# Package summary
SUMMARY = "Hello Application"
# License, for example MIT
LICENSE = "MIT"
# License checksum file is always required
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
 
inherit meson

# As Meson enforces out-of-tree builds we can just use cleandirs
B = "${WORKDIR}/build"
do_configure[cleandirs] = "${B}"

# Where the meson.build build configuration is
MESON_SOURCEPATH = "${WORKDIR}/git/meson-tutorials"

BB_STRICT_CHECKSUM = "0"
SRC_URI="git://github.com/rohitpai/sysplayApps.git"
SRCREV = "${AUTOREV}"

DEPENDS += "\
    hello-lib \
    systemd \
"

RDEPENDS_${PN} += "\
    hello-lib \
    systemd \
"