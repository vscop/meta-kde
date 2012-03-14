LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/lib/info.h;md5=4547c0d20883d91da92544ee5fc15a0d;beginline=1;endline=16"

KDE_EXPORT_FILES = "${S}/build/lib/CMakeFiles/Export/_usr/share/apps/cmake/modules/KActivitiesLibraryTargets-relwithdebinfo.cmake"

inherit kde-exports
require kde4.inc

DEPENDS = "kdelibs4 soprano shared-desktop-ontologies"
RDEPENDS_${PN} = "soprano shared-desktop-ontologies"

OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

SRC_URI = "git://anongit.kde.org/kactivities;protocol=git;tag=v4.8.0 \
	   file://Fix-cmake-destination-directory.patch"

SRCREV = "f00250f697e517992fc54af324c2e3435bca9956"


PV = "4.8.0+git${SRCPV}"

S = "${WORKDIR}/git" 

FILES_${PN} += "\
		${datadir}/kde4/* \
		\
		${libdir}/kde4/*.so \
		\
		${sysconfdir}/* \
	       "

FILES_${PN}-dbg += "${libdir}/kde4/.debug/*"

FILES_${PN}-dev += "${datadir}/apps/cmake/* \
		   "


EXTRA_OECMAKE += "\
		  -DPERL_EXECUTABLE=${STAGING_BINDIR_NATIVE}/perl-native/perl \
		  -DOE_CROSSCOMPILING=TRUE \
		 "
