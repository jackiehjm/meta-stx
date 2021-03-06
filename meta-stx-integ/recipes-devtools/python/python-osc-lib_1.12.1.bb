
DESCRIPTION = "OpenStackClient Library"
HOMEPAGE = "http://opensource.perlig.de/rcssmin/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "73c8bd90b8325b2595b814f41d06fdb8"
SRC_URI[sha256sum] = "26d3e32c8c4eff47240c458cddb6b75db52034d643f01de2841ad9e84904d7aa"

inherit setuptools pypi

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-six \
        python-babel \
        python-cliff \
        python-keystoneauth1 \
        python-os-client-config \
        python-oslo.i18n \
        python-oslo.utils \
        python-simplejson \
        python-stevedore \
        "

CLEANBROKEN = "1"
