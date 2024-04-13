SUMMARY = "This is a base image created as an example for courses"
LICENSE = "MIT"
inherit core-image

export IMAGE_BASENAME = "seneca-image"
MACHINE_NAME ?= "${MACHINE}"
IMAGE_NAME = "${MACHINE_NAME}_${IMAGE_BASENAME}"

IMAGE_INSTALL += " \
    kernel-devsrc \
    usbutils \
    usbinit \
    i2c-tools \
    libgpiod \
    evtest \
    pmu-mod \
    nano \
    bastet \
    connman \
    connman-client \
    connman-gnome \
    wpa-supplicant \
    ethtool \
    openssh-sftp-server \
    python3-adafruit-circuitpython-register \
"


IMAGE_FEATURES += " \
    ssh-server-openssh \
    splash \
    tools-debug \
    tools-sdk \
"

DISTRO_FEATURES += " usbgadget"
MACHINE_FEATURES += " usbgadget usbhost"


