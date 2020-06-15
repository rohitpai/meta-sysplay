# License, for example MIT
LICENSE = "MIT"
# License checksum file is always required
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


S = "${WORKDIR}/git"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://u-boot.sh"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "u-boot-mkimage-native"

inherit deploy

BOOTSCRIPT ??= "${S}/../u-boot.sh"

do_mkimage () {
    uboot-mkimage -A arm -O linux -T script -C none -a 0 -e 0 \
                  -n "boot script" -d ${BOOTSCRIPT} ${S}/boot.scr
}

addtask mkimage after do_compile before do_install

do_compile[noexec] = "1"

do_install () {
    install -D -m 644 ${S}/boot.scr ${D}/boot.scr
}

do_deploy () {
    install -D -m 644 ${D}/boot.scr \
                      ${DEPLOYDIR}/boot.scr-${MACHINE}-${PV}-${PR}

    cd ${DEPLOYDIR}
    rm -f boot.scr
    ln -sf boot.scr-${MACHINE}-${PV}-${PR} boot.scr
}

addtask deploy after do_install before do_build

FILES_${PN} += "/"

COMPATIBLE_MACHINE = "beaglebone"