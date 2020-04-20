
FILESEXTRAPATHS_prepend := "${THISDIR}/cmd:"

SRC_URI += "file://u-boot-custom-cmd.patch \
            file://custom.c;subdir=git/cmd/ \
"