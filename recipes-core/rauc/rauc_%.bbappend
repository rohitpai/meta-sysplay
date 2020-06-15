FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
FILESEXTRAPATHS_prepend := "${COREBASE}/../../openssl:"   
SRC_URI_append := " file://system.conf"
SRC_URI_append := " file://ca.cert.pem"