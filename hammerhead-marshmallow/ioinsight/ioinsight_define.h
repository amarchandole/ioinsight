
#define YEAR_BASE 2000
#define YEAR_RELEASE 16

/* rwbs(read,write, synchronous)*/
#define READ_NONE_MODE 0
#define WRITE_NONE_MODE 1
#define READ_SYNC_MODE 2
#define WRITE_SYNC_MODE 3

/* block type */ 
#define BLOCK_META 0
#define BLOCK_JOURNAL 1  
#define BLOCK_DATA 2
#define BLOCK_ANON 3 
#define BLOCK_NONE 4 

/* process name*/
#define PNAME_MAX 30

/* trace type */
#define TRACE_IO 1
#define TRACE_FILELS 2
#define TRACE_SQLITE 3
#define TRACE_SUSPEND 4

#pragma pack(push,1)
struct at_header{
	unsigned char type;
	unsigned char size;
	
	unsigned int year:4;
	unsigned int month:4;
	unsigned int day:5;
 	unsigned int hour:5;
	unsigned int min:6;
	unsigned int sec:6;
	unsigned int reserved:2; 
	unsigned int nsec;	
};

struct uio_ws{
	unsigned char fs_id;
	unsigned char fsync :1;
	unsigned char fdatasync :1;
	unsigned char fsync_sqlite :1;
	unsigned char reserved :5;
	unsigned int t_id;
	unsigned char journal_type;
};

struct uio
{
	unsigned char file_type; 
	unsigned char action :1; 
	unsigned char rwbs :2;
	unsigned char ws_info :1;
	unsigned char discard :1;
	unsigned char flush :1;
	unsigned char reserved2 :2;

	unsigned char major_dev;
	unsigned char minor_dev;
	unsigned char block_type; 
	unsigned int sector_nb; 
	unsigned int block_len; 
	unsigned char pname_len;

	unsigned int pid;
	unsigned int tgid;
	unsigned int ppid;
};

#pragma pack(pop)

