#!/bin/bash
source /home/amar/cs211/run_this_android.sh
cd /home/amar/cs211/ioinsight/hammerhead-marshmallow/
make hammerhead_defconfig && make -j4

echo -n "

Should I flash the new boot.img (y/n)? I hope you've connected your phone! "
read answer
if echo "$answer" | grep -iq "^y" ;then
    echo "Sure you genius :)
    "
    cd /home/amar/cs211/bootimgkitchen/
	./BootTools-Nex5.sh
	cp /home/amar/cs211/ioinsight/hammerhead-marshmallow/arch/arm/boot/zImage-dtb ./zImage-dtb
	./BootTools-Nex5.sh
	adb reboot bootloader
	sleep 1
	fastboot flash boot ./*.img
	fastboot reboot
else
    echo "Ok idiot :| Go solve the error :/
    "
fi