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

DESCRIPTION = "Management of /var/log filesystem"

require utilities-common.inc

S = "${S_DIR}/utilities/logmgmt/logmgmt/"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

RDEPENDS_${PN}_append = " \
	systemd \
	python-daemon \
	"

inherit setuptools systemd
SYSTEMD_PACKAGES += "logmgmt"
SYSTEMD_SERVICE_${PN} = "logmgmt.service"


do_install_append() {

	cd ${S}/../scripts
	install -d -m0755 ${D}/${bindir}
	install -m0700 bin/logmgmt ${D}/${bindir}
	install -m0700 bin/logmgmt_postrotate ${D}/${bindir}
	install -m0700 bin/logmgmt_prerotate ${D}/${bindir}

	install -d -m0755 ${D}/${sysconfdir}/init.d
	install -m0700 init.d/logmgmt ${D}/${sysconfdir}/init.d

	install -d -m0755 ${D}/${sysconfdir}/pmon.d
	install -m0700 pmon.d/logmgmt ${D}/${sysconfdir}/pmon.d

	install -d -m0755 ${D}/${systemd_system_unitdir}
	install -m0664 etc/systemd/system/logmgmt.service ${D}/${systemd_system_unitdir}
}
