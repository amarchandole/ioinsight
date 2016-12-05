#include <linux/string.h>

#include <linux/time.h>
#include <linux/file.h>
#include <linux/fcntl.h>
#include <linux/kernel.h>
#include <linux/debugfs.h>
#include <linux/syscalls.h>
#include <linux/namei.h>
#include <linux/fs.h>
#include <linux/blkdev.h>

bool ioinsight_add_io(struct request *rq, bool is_issue);