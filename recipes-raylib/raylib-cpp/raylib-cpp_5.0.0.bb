SUMMARY = "raylib-cpp"
DESCRIPTION = "raylib-cpp"
AUTHOR = "RobLoach"
SECTION = "graphics"
HOMEPAGE = "https://github.com/RobLoach/raylib-cpp"

LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Zlib;md5=87f239f408daca8a157858e192597633"
#PV = "5.0.0"
#PN = "raylib-cpp"
PR = "r0"

# Last commit for raylib-cpp 5.0.0
SRCREV = "34748ebbecdeaa1868eb2985e8679ba11df84b96"
SRCBRANCH = "master"

SRC_URI = "git://github.com/RobLoach/raylib-cpp.git;branch=${SRCBRANCH};protocol=https \
            "
S = "${WORKDIR}/git"

DEPENDS += " \
    raylib \
"

# Header only library
ALLOW_EMPTY:${PN} = "1"

RPROVIDES:${PN} += "raylib-cpp-${PV}"
PROVIDES += "raylib-cpp-${PV}"

inherit cmake

# -DCMAKE_INSTALL_PREFIX=/usr
EXTRA_OECMAKE += "-DBUILD_RAYLIB_CPP_EXAMPLES=OFF"
