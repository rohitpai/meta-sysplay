SRC_URI += "file://bbb-image-play.cfg \
            file://am335x-boneblack-play.dts;subdir=git/arch/${ARCH}/boot/dts \
            "

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH = "beaglebone"

KERNEL_DEVICETREE_beaglebone += " \
    am335x-boneblack-play.dtb \
"
KERNEL_CONFIG_FRAGMENTS += "${WORKDIR}/bbb-image-play.cfg"