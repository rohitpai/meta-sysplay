DESCRIPTION = "ZeroMQ looks like an embeddable networking library but acts like a concurrency framework"
HOMEPAGE = "http://www.zeromq.org"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=d5311495d952062e0e4fbba39cbf3de1"

PACKAGECONFIG ??= "libsodium"
PACKAGECONFIG[libsodium] = "-DWITH_LIBSODIUM=ON,-DWITH_LIBSODIUM=OFF, libsodium"

SRC_URI = "http://github.com/zeromq/libzmq/releases/download/v${PV}/zeromq-${PV}.tar.gz"
SRC_URI[md5sum] = "64cbf3577afdbfda30358bc757a6ac83"
SRC_URI[sha256sum] = "bcbabe1e2c7d0eec4ed612e10b94b112dd5f06fcefa994a0c79a45d835cd21eb"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DBUILD_TESTS=OFF \
                 -DCMAKE_SKIP_RPATH=ON \
"
FILES_${PN}-doc += "${datadir}/zmq/*.txt"
