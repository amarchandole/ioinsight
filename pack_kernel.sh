#!/bin/bash

source ./scripts/run_this_android.sh
cd ./hammerhead-marshmallow/
make hammerhead_defconfig && make -j4

echo -n "

Should I flash the new boot.img (y/n)? I hope you've connected your phone! "
read answer
if echo "$answer" | grep -iq "^y" ;then
    echo "Sure you genius :)
    "
    cd ../bootimgkitchen/
	./BootTools-Nex5.sh
	cp ../hammerhead-marshmallow/arch/arm/boot/zImage-dtb ./zImage-dtb
	./BootTools-Nex5.sh
	adb reboot bootloader
	sleep 1
	fastboot flash boot ./*.img
	fastboot reboot
else
    echo "Ok :| Go solve the error :/
    "
fi