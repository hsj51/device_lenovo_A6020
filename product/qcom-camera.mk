# Camera
PRODUCT_PACKAGES += \
    camera.msm8916 \
    libbson \
    libshim_gui \
    libshim_atomic \
    Snap \

TARGET_PROCESS_SDK_VERSION_OVERRIDE := \
	/system/bin/mediaserver=23 \
        /system/bin/cameraserver=23 \
	/system/vendor/bin/mm-qcamera-daemon=23

