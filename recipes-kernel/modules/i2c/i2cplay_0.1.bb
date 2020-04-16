# Package summary
SUMMARY = "i2c play kernel module"
# License, for example MIT
LICENSE = "MIT"
# License checksum file is always required
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


inherit module kernel-module-split

S = "${WORKDIR}/git/drivers/i2c"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

RPROVIDES_${PN} += "kernel-module-i2cplay"

BB_STRICT_CHECKSUM = "0"
SRC_URI="git://github.com/rohitpai/sysplayApps.git"
SRCREV = "${AUTOREV}"
