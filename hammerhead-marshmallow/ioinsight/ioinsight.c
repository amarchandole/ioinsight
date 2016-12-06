#include "ioinsight.h"
#include "ioinsight_define.h"
unsigned int at_fs_id = 0;

void __fill_header(unsigned char type, struct at_header *header)
{
	struct timespec ts_now;		//date 
	struct tm tm;			//time_to_tm(timeconv) 

	header->type = type;
	header->size = 0;

	//get current time
	getnstimeofday(&ts_now);
	ts_now.tv_sec -= 60 * 60 * 8;   //GMT - 8 hour (Los Angeles);
	time_to_tm(ts_now.tv_sec, 0, &tm);

	//collect log data
	header->year = tm.tm_year + 1900 - YEAR_BASE; //2000;
	header->month = tm.tm_mon + 1;
	header->day = tm.tm_mday;
	header->hour = tm.tm_hour;
	header->min = tm.tm_min;
	header->sec = tm.tm_sec;
	header->nsec = ts_now.tv_nsec;
}

bool ioinsight_add_io(struct request *rq, bool is_issue)
{
	struct at_header header;
	struct uio log;
	struct uio_ws log_ws; 	

	unsigned char log_size = 0;
	struct timespec ts_now;		//date 
	struct tm tm;			//time_to_tm(timeconv) 
	struct bio *bio = NULL;		//the first bio of request 
	char *bio_buf = NULL;		//check jouranl header 
	struct address_space *mapping = NULL;   //flags for sync/fdatasync 
	struct inode *inode = NULL;	//bio's address_space->inode 
	struct list_head *next = NULL;	//dentry.next 
	struct dentry *dentry = NULL;	//dentry, to get file name 
	struct task_struct *bio_task = NULL;    //process who submit bio 
	int pname_len = 0;
	char pname[PNAME_MAX];
	char *fname = NULL;
	int fname_len = 0;

	char *str_rwbs = NULL;
	char *str_bt = NULL;
	char *str_fsync = NULL;
	char *str_fdatasync = NULL;
	char *str_fsync_sqlite = NULL;
	char str_log[400];

	memset(str_log, 0, 400);

	
	log_size = sizeof(struct uio);
	memset(&log, 0, sizeof(struct uio));
	memset(&log_ws, 0, sizeof(struct uio_ws));
	memset(&pname, 0, PNAME_MAX);

	getnstimeofday(&ts_now);
	ts_now.tv_sec += 60 * 60 * 9;   //GMT +9hour(Korea); 
	time_to_tm(ts_now.tv_sec, 0, &tm);

	//header information (time) 
	__fill_header(TRACE_IO, &header);

	//io information 
	bio = rq->bio;	
	if (bio && bio->bi_io_vec && bio->bi_io_vec->bv_page && bio->bi_io_vec->bv_page->mapping) {
		if (bio_has_data(bio))
			bio_buf = bio_data(bio);
		if (PageAnon(bio->bi_io_vec->bv_page)) { //page->mapping points to anon_vma object, not address_space 
			log.block_type = BLOCK_ANON;
		} else { //page->mappings points to address_space object 

			mapping = bio->bi_io_vec->bv_page->mapping;
			inode = mapping->host;
			if (inode && inode->i_ino != 0 && &inode->i_dentry) {
				log.block_type = BLOCK_DATA;
				//to get file name, file type 
				next = inode->i_dentry.next;
				dentry = list_entry(next, struct dentry, d_alias);
				if (dentry->d_name.len > 0) {
					fname = (char*)dentry->d_name.name;
					fname_len = strlen(fname);
				}
				log.major_dev = MAJOR(inode->i_sb->s_dev);
				log.minor_dev = MINOR(inode->i_sb->s_dev);
			} else {
				//joruanl or meta block 
				if (!IS_ERR_OR_NULL(bio_buf)) {
					//journal signature(magic number) 
					if (*(bio_buf) == 0xc0 && *(bio_buf+1) == 0x3b &&
					    *(bio_buf+2) == 0x39 && *(bio_buf+3) == 0x98)
						log.block_type = BLOCK_JOURNAL;
					else
						log.block_type = BLOCK_META;
				} else {
					log.block_type = BLOCK_NONE;
				}
				log.major_dev = MAJOR(inode->i_rdev);
				log.minor_dev = MINOR(inode->i_rdev);
			}
		}

		//----collects I/O data 
		log.action = is_issue;
		//operation type 
		if (rq->cmd_flags & REQ_WRITE) { 
			if (rq->cmd_flags & REQ_SYNC)
				log.rwbs = WRITE_SYNC_MODE;
			else
				log.rwbs = WRITE_NONE_MODE;
		} else { 
			if (rq->cmd_flags & REQ_SYNC) 
				log.rwbs = READ_SYNC_MODE;
			else
				log.rwbs = READ_NONE_MODE;
		}
		
		//synchronous write  
		if (log.rwbs == WRITE_SYNC_MODE) {
			log_size += sizeof(struct uio_ws);
			log.ws_info = 1;
			if ( !IS_ERR_OR_NULL(mapping)){
				log_ws.fs_id = mapping->fs_id;
				if (mapping->fs_flags & AS_FS_FSYNC)
					log_ws.fsync = 1;
				if (mapping->fs_flags & AS_FS_FDSYNC)
					log_ws.fdatasync = 1;
				if (mapping->fs_flags & AS_FS_SQLITE)
					log_ws.fsync_sqlite = 1;
			}
		}

		log.sector_nb = (int)blk_rq_pos(rq);
		log.block_len = (int)blk_rq_bytes(rq) / 512;		//one block is 512 bytes, so block_len is the number of blocks accessed
		if (bio->bi_pid != 0) {
			bio_task = find_task_by_vpid(bio->bi_pid);
			log.pid = bio->bi_pid;
			log.tgid = bio->bi_tgid;
			log.ppid = -1;

			if (!IS_ERR_OR_NULL(bio_task) &&
				!IS_ERR_OR_NULL(bio_task->comm)) {
				while (bio_task->comm[pname_len] != '\0') {
					pname[pname_len] = bio_task->comm[pname_len];
					pname_len++;
				}
				log.pname_len = pname_len;
			}
		}
		
		//to get journal type, tranasction id 
		if (log.block_type == BLOCK_JOURNAL && !IS_ERR_OR_NULL(bio_buf))  {
			memcpy( &log_ws.journal_type, (char*)bio_buf+7, 1); 
			//memcpy & shift ( big-endian, litten-endian) 
			memcpy(&log_ws.t_id, (char*)bio_buf+8, 4);
			log_ws.t_id = ((log_ws.t_id << 24) & 0xFF000000) | ((log_ws.t_id << 8) & 0x00FF0000)
					| ((log_ws.t_id >> 8) & 0x0000FF00) | ((log_ws.t_id >> 24) & 0x000000FF);
		}

		//log_size = pname + file name + file name length 
		log_size += pname_len + 1 + fname_len;

		if (log_ws.fsync_sqlite)
			str_fsync_sqlite = "S";
		if (log_ws.fsync)
			str_fsync = "F";
		if (log_ws.fdatasync)
			str_fdatasync ="D"; 

		if (log.rwbs == READ_NONE_MODE)
			str_rwbs = "R";
		else if (log.rwbs == WRITE_NONE_MODE)
			str_rwbs = "W";
		else if (log.rwbs == WRITE_SYNC_MODE)
			str_rwbs = "WS";

		if (log.block_type == BLOCK_META)
			str_bt = "M";
		else if (log.block_type == BLOCK_JOURNAL)
			str_bt = "J";
		else if (log.block_type == BLOCK_DATA)
			str_bt = "D";
		else if (log.block_type == BLOCK_ANON)
			str_bt = "A";
		else if (log.block_type == BLOCK_NONE)
			str_bt = "N";

		/*snprintf(str_log, sizeof(str_log), "\n+%d,%d,%d,%d,%d,%s,%s,%d,%d,%s,%s,%s,%s,%s,%d,%d!",
		is_issue, header.hour, header.min, header.sec, header.nsec, 
		pname, fname, log_ws.t_id, log_ws.fs_id, 
		str_rwbs, str_bt, str_fsync_sqlite, str_fsync, str_fdatasync, log.sector_nb, log.block_len);*/

		snprintf(str_log, sizeof(str_log), "\n+%d,%d,%d,%d,%d,%s,%s,%d,%d,%s,%s,%s,%s,%s,%d,%d,%d,%d!",
		is_issue, header.hour, header.min, header.sec, header.nsec, 
		pname, fname, log_ws.t_id, log_ws.fs_id, 
		str_rwbs, str_bt, str_fsync_sqlite, str_fsync, str_fdatasync, log.sector_nb, log.block_len, log.pid, log.tgid);

		printk(KERN_EMERG "\t%s\n", str_log);
	}
	return true;
}