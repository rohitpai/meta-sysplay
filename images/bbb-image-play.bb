SUMMARY = "A small image just capable of allowing a device to and play."

CORE_IMAGE_EXTRA_INSTALL += " hello-lib hello-application openssh" 
TOOLCHAIN_TARGET_TASK_append = " kernel-devsrc"
IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"


KERNEL_DEVICETREE_beaglebone += " \
    am335x-boneblack-play.dtb \
"