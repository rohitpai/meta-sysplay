
FILESEXTRAPATHS_prepend := "${THISDIR}/cmd:"

SRC_URI += "file://u-boot-custom-cmd.patch \
            file://custom.c;subdir=git/cmd/ \
"

do_compile_prepend () {
    echo "CONFIG_CMD_SETEXPR=y" >> ${B}/.config
}