#!/bin/bash

# prevent any mess
set -e

# Clear the screen :)
clear

dat=`date +%k%M`

# mkbootfs
if [ -e mkbootfs ]; then
echo "ok"
else
echo "mkbootfs missing"
exit 1
fi

# mkbootimg
if [ -e mkbootimg ]; then
echo "ok"
else
echo "mkbootimg missing"
exit 1
fi

# unpackbootimg
if [ -e mkbootimg ]; then
echo "ok"
else
echo "unpackbootimg missing"
exit 1
fi

# if there s a boot.img, unpack it!
if [ -e *boot*.img ]; then
echo "Boot.img found"
echo ""
mkdir out
mkdir ramdisk
./unpackbootimg -i *boot*.img -o out
mv out/*boot*.img-ramdisk.gz ramdisk/
cd ramdisk
gunzip -c *boot*.img-ramdisk.gz | cpio -i
cd ..
rm -f *boot*.img
rm -f ramdisk/*boot*.img-ramdisk.gz
exit 0

else
echo "No boot.img, looking for a kernel Image"
echo ""

# if there s a zImage, make a boot.img!
if [ -e zImage* ]; then
echo "kernel Image found!"
echo ""
echo "loading all values from out/..."

cmdline=`cat out/*.img-cmdline`
base=`cat out/*.img-base`
page=`cat out/*.img-pagesize`
ramdiskof=`cat out/*.img-ramdiskoff`
tagsof=`cat out/*.img-tagsoff`
kernelof=`cat out/*.img-kerneloff`
board=`cat out/*.img-board`

./mkbootfs ramdisk | gzip > out/boot.img-ramdisk.gz
./mkbootimg --kernel zImage* --ramdisk out/*boot*.img-ramdisk.gz --cmdline "$cmdline" --board "$board" --base "$base" --pagesize "$page" --kernel_offset "$kernelof" --ramdisk_offset "$ramdiskof" --tags_offset "$tagsof" --output "boot$dat.img"
rm -f zImage*
rm -rf out
rm -rf ramdisk
exit 0

else
echo "No zImage."
exit 1
fi

fi

# Credits:
# google
# osm0sis
# cyanogenmod
# Me :P
