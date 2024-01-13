SUMMARY = "raylib"
DESCRIPTION = "raylib"
AUTHOR = "raysan5"
SECTION = "graphics"
HOMEPAGE = "https://www.raylib.com/"

LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Zlib;md5=87f239f408daca8a157858e192597633"
#PV = "4.5.0"
#PN = "raylib"
PR = "r0"

# Last commit for raylib 5.0.0
SRCREV = "ae50bfa2cc569c0f8d5bc4315d39db64005b1b08"
#SRCREV = "${AUTOREV}"
SRCBRANCH = "master"

SRC_URI = "git://github.com/raysan5/raylib.git;branch=${SRCBRANCH};protocol=https \
            "
S = "${WORKDIR}/git"

DEPENDS += " \
    libxinerama \
    libxrandr \
    libxcursor \
    xinput \
    freeglut \
    libglu \
    alsa-lib \
"

RDEPENDS:${PN} += " \
    libxinerama \
    libxrandr \
    libxcursor \
    xinput \
    freeglut \
    libglu \
    alsa-lib \
"
# RRECOMMENDS:${PN} =

RPROVIDES:${PN} += "raylib-${PV}"
PROVIDES += "raylib-${PV}"

#COMPATIBLE_HOST = "(i.86|x86_64).*-linux"

inherit features_check
REQUIRED_DISTRO_FEATURES = "opengl"

inherit cmake

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DBUILD_SHARED_LIBS=ON -DBUILD_EXAMPLES=OFF -DWITH_PIC=ON"
#EXTRA_OECMAKE:append:riscv64 = ""
