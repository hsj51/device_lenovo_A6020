# Camera
PRODUCT_PACKAGES += \
    camera.msm8916 \
    libboringssl-compat \
    libbson \
    libshim_atomic \
    libshim_gui \
    Snap

TARGET_PROCESS_SDK_VERSION_OVERRIDE := \
	/system/bin/mediaserver=23 \
        /system/bin/cameraserver=23 \
	/system/vendor/bin/mm-qcamera-daemon=23

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/external_camera_config.xml:$(TARGET_COPY_OUT_VENDOR)/etc/external_camera_config.xml

