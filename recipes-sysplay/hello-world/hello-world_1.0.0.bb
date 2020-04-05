# Package summary
SUMMARY = "Hello World"
# License, for example MIT
LICENSE = "MIT"
# License checksum file is always required
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
TARGET_CC_ARCH += "${LDFLAGS}" 
# hello-world.c from local file
SRC_URI = "file://hello-world.cpp"
 
# Change source directory to workdirectory where hello-world.cpp is
S = "${WORKDIR}"
 
do_configure() {
    
}

# Compile hello-world from sources, no Makefile
do_compile() {
    ${CXX} -Wall hello-world.cpp -o hello-world
}
 
# Install binary to final directory /usr/bin
do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/hello-world ${D}${bindir}
}
