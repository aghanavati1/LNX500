DESCRIPTION = "Bastet (Bastard Tetris) - a Tetris clone with a challenging algorithm"
HOMEPAGE = "https://github.com/fph/bastet"
SECTION = "games"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/fph/bastet.git;protocol=https"
SRC_URI[sha256sum] = "44a6ce9495c747a5a153ea26d3b0b020752beaf64a8431e945822060b1d9a1cc"
SRCREV = "1b3e6922c1f7d72e87640ea4a58a52e1d36f01e1"
S = "${WORKDIR}/git"

DEPENDS = "boost"

do_compile() {
    oe_runmake 'CXXFLAGS=${CXXFLAGS} -Wno-error=format-security'
}


do_install() {
    if [ -f ${S}/bastet ]; then
        install -d ${D}${bindir}
        install -m 0755 ${S}/bastet ${D}${bindir}
    else
        bberror "Bastet binary does not exist."
    fi
}


FILES_${PN} += "${bindir}/bastet"
