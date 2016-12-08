# IOinsight

App to monitor and summarize block-level R/W requests made by applications to Android Storage Subsystem. Achieved by making changes to the Android Linux Kernel (v3.4).

___________________________________________________________________________________________________
##Key Info :

Tested Environment Setup :
* Rooted Google Nexus 5 (hammerhead) running Marshmallow 6.0.1
* AOSP 3.4 android linux kernel
* Busybox, Terminal Emulator installed on phone for local tests

This repo contains :
* A customized kernel for Nexus 5 (hammerhead) with all the changes needed and ready to compile
* Android Application files (Java + XML + resources)
* bootimgkitchen (to pack, unpack the boot.img)
* Rooting tools (compatible SuperSU, TWRP)
* Tested boot images for recovery purposes
* Scripts to be run on phone for logging, and on laptop for easy automation
* Ready to use IOinsight.apk

___________________________________________________________________________________________________
##Installation steps :

###Compilation steps for kernel 
(ready boot.img is available to flash and use. Compilation needed only if changes made to the code)


* Clone this repo
* Clone arm-eabi-4.9 to this repo's folder
* Make necessary changes to the kernel source in hammerhead-marshmallow folder
* Install adb and fastboot to your computer
* Connect Nexus 5 and run the script _pack_kernel.sh_. This script takes care of all things from compilation to packing the kernel into a boot.img to flashing it to your phone
* Root your phone (root access will be lost even if it was root already). Use TWRP-2.8.7.1 and SuperSU-v2.76 from **resources** folder of the repo for rooting
* Copy the script _loggingscript.sh_ from the **scripts** folder to the phone to the path `/storage/emulated/0/dev_tools`
* Install the IOinsight.apk, grant storage and superuser access when prompted, select the Apps and get comprehensive results!
