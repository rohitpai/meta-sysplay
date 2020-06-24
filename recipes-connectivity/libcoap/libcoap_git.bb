DESCRIPTION = "CoAP Library"
SECTION = "Connectivity"
# License, for example MIT
LICENSE = "MIT"
# License checksum file is always required
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV = "${AUTOREV}"
PV  = "${SRCPV}"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/obgm/libcoap.git;branch=develop"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DENABLE_DTLS=OFF -DENABLE_TESTS=OFF"

do_install_append () {
    install -d ${D}${bindir}
    install -m 0755 ${B}/coap-client ${D}${bindir}
}
