SUMMARY = "A small image just capable of allowing us to play."

CORE_IMAGE_EXTRA_INSTALL += " hello-lib hello-application openssh" 
TOOLCHAIN_TARGET_TASK_append = " kernel-devsrc"
IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

# Set Kernel options 
KERNEL_DEVICETREE += " \
    am335x-boneblack-play.dtb \
"
# Remove unwanted packages 
MACHINE_GUI_CLASS_remove = "bigscreen"


IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

# Custom Image features
#IMAGE_FSTYPES_append = " squashfs"
#IMAGE_FEATURES_append = " read-only-rootfs"
IMAGE_INSTALL += " kernel-module-i2cplay kernel-module-mcp320x"
IMAGE_INSTALL_append = " libstdc++ libgpiod initscript"
TOOLCHAIN_TARGET_TASK_append = " libstdc++-staticdev"


# Utils 
IMAGE_INSTALL += " e2fsprogs dosfstools e2fsprogs-mke2fs util-linux-mkfs u-boot-fw-utils"
IMAGE_INSTALL += " rauc"




