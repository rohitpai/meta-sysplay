FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append := " file://fw_env.config;subdir=git/tools/env"