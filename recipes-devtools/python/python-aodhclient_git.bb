#
## Copyright (C) 2019 Wind River Systems, Inc.
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.

DESCRIPTION = "client library for Aodh built on the Aodh API"
HOMEPAGE = "https://launchpad.net/python-aodhclient"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCREV = "6d03e61986418a3a95635405ae65ae9f28a5c61e"
SRCNAME = "python-aodhclient"
BRANCH = "stable/train"
PROTOCOL = "https"
PV = "1.2.0+git${SRCPV}"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;protocol=${PROTOCOL};rev=${SRCREV};branch=${BRANCH}"
	
inherit setuptools monitor rmargparse

DEPENDS += " \
        python-pip \
        python-pbr-native\
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "

RDEPENDS_${PN} += " \
        python-pbr \
        python-cliff \
        python-oslo.i18n \
        python-oslo.serialization \
        python-oslo.utils \
        python-keystoneauth1 \
        python-six \
        python-osc-lib \
	python-pyparsing \
	"


do_install_append() {
	:
}

FILES_${PN} += " \
	"
