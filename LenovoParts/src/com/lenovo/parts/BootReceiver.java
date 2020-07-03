package com.lenovo.parts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

import com.lenovo.parts.kcal.Utils;

public class BootReceiver extends BroadcastReceiver implements Utils {

    public void onReceive(Context context, Intent intent) {

        if (Settings.Secure.getInt(context.getContentResolver(), PREF_ENABLED, 0) == 1) {
            FileUtils.setValue(KCAL_ENABLE, Settings.Secure.getInt(context.getContentResolver(),
                    PREF_ENABLED, 0));

            String rgbValue = Settings.Secure.getInt(context.getContentResolver(),
                    PREF_RED, RED_DEFAULT) + " " +
                    Settings.Secure.getInt(context.getContentResolver(), PREF_GREEN,
                            GREEN_DEFAULT) + " " +
                    Settings.Secure.getInt(context.getContentResolver(), PREF_BLUE,
                            BLUE_DEFAULT);

            FileUtils.setValue(KCAL_RGB, rgbValue);
            FileUtils.setValue(KCAL_MIN, Settings.Secure.getInt(context.getContentResolver(),
                    PREF_MINIMUM, MINIMUM_DEFAULT));
            FileUtils.setValue(KCAL_SAT, Settings.Secure.getInt(context.getContentResolver(),
                    PREF_GRAYSCALE, 0) == 1 ? 128 :
                    Settings.Secure.getInt(context.getContentResolver(),
                            PREF_SATURATION, SATURATION_DEFAULT) + SATURATION_OFFSET);
            FileUtils.setValue(KCAL_VAL, Settings.Secure.getInt(context.getContentResolver(),
                    PREF_VALUE, VALUE_DEFAULT) + VALUE_OFFSET);
            FileUtils.setValue(KCAL_CONT, Settings.Secure.getInt(context.getContentResolver(),
                    PREF_CONTRAST, CONTRAST_DEFAULT) + CONTRAST_OFFSET);
            FileUtils.setValue(KCAL_HUE, Settings.Secure.getInt(context.getContentResolver(),
                    PREF_HUE, HUE_DEFAULT));
        }

        int gain = Settings.Secure.getInt(context.getContentResolver(),
                DeviceSettings.PREF_HEADPHONE_GAIN, 0);
        FileUtils.setValue(DeviceSettings.HEADPHONE_GAIN_PATH, gain + " " + gain);
        FileUtils.setValue(DeviceSettings.MICROPHONE_GAIN_PATH, Settings.Secure.getInt(context.getContentResolver(),
                DeviceSettings.PREF_MICROPHONE_GAIN, 3));

        FileUtils.setValue(DeviceSettings.VIBRATION_STRENGTH_PATH, Settings.Secure.getInt(
                context.getContentResolver(), DeviceSettings.PREF_VIBRATION_STRENGTH, 80) / 100.0 * (DeviceSettings.MAX_VIBRATION - DeviceSettings.MIN_VIBRATION) + DeviceSettings.MIN_VIBRATION);
        FileUtils.setValue(DeviceSettings.DT2W_PATH, Settings.Secure.getInt(
                context.getContentResolver(), DeviceSettings.PREF_DT2W, 0));
        FileUtils.setValue(DeviceSettings.USB_FASTCHARGE_PATH, Settings.Secure.getInt(
                context.getContentResolver(), DeviceSettings.PREF_USB_FASTCHARGE, 0));
    }
}
