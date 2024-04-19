DESCRIPTION = "A Yocto image for BeaglePlay with GNOME desktop environment"
LICENSE = "MIT"
inherit core-image

export IMAGE_BASENAME = "seneca-image"
MACHINE_NAME ?= "${MACHINE}"
IMAGE_NAME = "${MACHINE_NAME}_${IMAGE_BASENAME}"

# Core GNOME packages for a minimal desktop environment
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
    gdm \
    gnome-session \
    gnome-shell \
    gnome-terminal \
    gnome-control-center \
    gnome-desktop \
    gnome-settings-daemon \
    gnome-keyring \
    adwaita-icon-theme \
    gnome-menus \
    gnome-system-monitor \
    nautilus \
    gnome-screenshot \
    yelp \
    metacity \
    mutter \
    network-manager-applet \
    gnome-online-accounts \
    packagegroup-gnome-desktop \
"

IMAGE_FEATURES += " \
    ssh-server-openssh \
    splash \
    tools-debug \
    tools-sdk \
    x11-base \
    x11-sato \
"

# Enabling graphical features in distro
DISTRO_FEATURES:append = " wayland x11 opengl gtk"

MACHINE_FEATURES += " usbgadget usbhost"
