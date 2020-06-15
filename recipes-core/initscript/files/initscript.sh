#!/bin/sh
logger "Starting Custome init script for play image"

logger "starting initscript"
mkdir -p /uboot
mount /dev/mmcblk0p1 /uboot
timedatectl set-ntp false
sleep 5
timedatectl set-time '2020-6-20 00:00:00'



# do some work here. Mount additional file system.

logger "initscript work done"

#job done, remove it from systemd services
systemctl stop initscript.service

logger "initscript stopped"