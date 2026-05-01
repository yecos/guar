package com.hpplay.sdk.source.config;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import com.hpplay.sdk.source.api.BuildConfig;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.permission.ContextCompat;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class LelinkConfig {
    private static final String TAG = "LelinkConfig";

    public static boolean checkBrowserBlePermission(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_ADMIN") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static boolean checkPublishBlePermission(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_ADMIN") == 0;
    }

    public static String getSdkChannel() {
        return BuildConfig.SDK_CHANNEL;
    }

    public static boolean isBLEEnable() {
        return false;
    }

    public static int isBrowserBlueToothEnable(Context context) {
        if (Build.VERSION.SDK_INT >= 21 && checkBrowserBlePermission(context)) {
            return 1;
        }
        SourceLog.w(TAG, "browser ble:" + ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH") + Operator.Operation.DIVISION + ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_ADMIN"));
        return 0;
    }

    public static boolean isDeviceBrowserBlueToothEnable(Context context) {
        if (Build.VERSION.SDK_INT >= 21 && checkBrowserBlePermission(context)) {
            try {
                BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
                if (bluetoothManager == null) {
                    return false;
                }
                return bluetoothManager.getAdapter() != null;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean isDevicePublishBlueToothEnable(Context context) {
        BluetoothAdapter adapter;
        boolean isMultipleAdvertisementSupported;
        if (Build.VERSION.SDK_INT >= 21 && checkPublishBlePermission(context)) {
            try {
                BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
                if (bluetoothManager == null || (adapter = bluetoothManager.getAdapter()) == null) {
                    return false;
                }
                isMultipleAdvertisementSupported = adapter.isMultipleAdvertisementSupported();
                return isMultipleAdvertisementSupported;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean isLicenseMode() {
        return Preference.getInstance().get(Preference.KEY_PERMISSION_MODE, 1) == 1;
    }

    public static boolean isMultiProgress() {
        return true;
    }

    public static boolean isP2PEnable() {
        return false;
    }

    public static int isPublishBlueToothEnable(Context context) {
        if (isDevicePublishBlueToothEnable(context)) {
            return 1;
        }
        SourceLog.w(TAG, "publish ble:" + ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH") + Operator.Operation.DIVISION + ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_ADMIN") + Operator.Operation.DIVISION + ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION"));
        return 0;
    }

    public static boolean isReverseControlEnable() {
        return false;
    }

    public static boolean isSdkFree() {
        return false;
    }

    public static boolean isSupportDA() {
        return true;
    }

    public static boolean isSupportDeviceList() {
        return true;
    }

    public static boolean isSupportIM() {
        return true;
    }

    public static boolean isSupportMirror() {
        return false;
    }

    public static boolean isSupportSonic() {
        return false;
    }

    public static boolean isSupportYimMirror() {
        return false;
    }

    public static boolean isSystemSupportMirror() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
