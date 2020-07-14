SUMMARY = "A small image just capable of allowing us to play."

CORE_IMAGE_EXTRA_INSTALL += " hello-lib hello-application openssh" 
TOOLCHAIN_TARGET_TASK_append = " kernel-devsrc"
IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

IMAGE_INSTALL_append = " libstdc++ libgpiod"
TOOLCHAIN_TARGET_TASK_append = " libstdc++-staticdev libcoap-staticdev cppzmq-dev"

# Utils 
IMAGE_INSTALL += " e2fsprogs dosfstools e2fsprogs-mke2fs util-linux-mkfs u-boot-fw-utils"
IMAGE_INSTALL += " rauc redis hiredis pacman4console libcoap zeromq-dev"

IMAGE_INSTALL_append = " bluez5 i2c-tools python-smbus bridge-utils hostapd dhcp-server iptables python3 python3-modules"



RPI_PACKAGES = " \
  gstreamer1.0 \
  gstreamer1.0-plugins-base \
  gstreamer1.0-plugins-good-meta \
  gstreamer1.0-plugins-good \
  gstreamer1.0-plugins-bad \
  gstreamer1.0-plugins-ugly \
"

KERNEL_EXTRA = " \
    kernel-modules \
"

WIFI = " \
    iw \
    linux-firmware-rpidistro-bcm43455 \
    wpa-supplicant \
"

IMAGE_INSTALL += " \
    ${RPI_PACKAGES} \
    ${KERNEL_EXTRA} \
    ${WIFI} \
"

