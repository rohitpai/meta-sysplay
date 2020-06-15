inherit bundle

RAUC_BUNDLE_COMPATIBLE ?= "Demo Board"

RAUC_BUNDLE_SLOTS ?= "rootfs"

RAUC_SLOT_rootfs ?= "bbb-image-play"

RAUC_KEY_FILE = "${COREBASE}/../../openssl/key.pem"
RAUC_CERT_FILE = "${COREBASE}/../../openssl/ca.cert.pem"