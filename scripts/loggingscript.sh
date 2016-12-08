#!/system/bin/sh
dat=`date +%k%M`

> /storage/emulated/0/dev_tools/log.txt
sleep 8

echo "
---------------START----------------
" >> /storage/emulated/0/dev_tools/log.txt

dmesg -ct >> /storage/emulated/0/dev_tools/log.txt
echo "
-----------------1--------------

" >> /storage/emulated/0/dev_tools/log.txt
sleep 2

dmesg -ct >> /storage/emulated/0/dev_tools/log.txt
echo "
-----------------2--------------
" >> /storage/emulated/0/dev_tools/log.txt
sleep 2

dmesg -ct >> /storage/emulated/0/dev_tools/log.txt
echo "
-----------------3--------------
" >> /storage/emulated/0/dev_tools/log.txt
sleep 2

dmesg -ct >> /storage/emulated/0/dev_tools/log.txt
echo "
-----------------4--------------
" >> /storage/emulated/0/dev_tools/log.txt
sleep 2

dmesg -ct >> /storage/emulated/0/dev_tools/log.txt
echo "
-----------------5--------------
" >> /storage/emulated/0/dev_tools/log.txt
sleep 2

dmesg -ct >> /storage/emulated/0/dev_tools/log.txt
echo "
-----------------6--------------
" >> /storage/emulated/0/dev_tools/log.txt
sleep 2

dmesg -ct >> /storage/emulated/0/dev_tools/log.txt
echo "
-----------------7--------------
" >> /storage/emulated/0/dev_tools/log.txt
sleep 2

dmesg -ct >> /storage/emulated/0/dev_tools/log.txt
echo "
-----------------8--------------
" >> /storage/emulated/0/dev_tools/log.txt
sleep 2

dmesg -ct >> /storage/emulated/0/dev_tools/log.txt
echo "
-----------------9--------------
" >> /storage/emulated/0/dev_tools/log.txt
sleep 2

dmesg -ct >> /storage/emulated/0/dev_tools/log.txt
echo "
-----------------10-------------
" >> /storage/emulated/0/dev_tools/log.txt
sleep 2

echo "
-----------------DONE--------------

" >> /storage/emulated/0/dev_tools/log.txt


#cat /storage/emulated/0/dev_tools/log.txt >> /storage/emulated/0/dev_tools/log$dat.txt