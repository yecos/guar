package com.hpplay.component.common.utils;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class DeviceProperties {
    private static String sBoard = "";
    private static String sBrand = "";
    private static String sManufacturer = "";
    private static String sModel = "";

    public static String getBoard() {
        if (TextUtils.isEmpty(sBoard)) {
            sBoard = Build.BOARD;
        }
        return sBoard;
    }

    public static String getBrand() {
        if (TextUtils.isEmpty(sBrand)) {
            sBrand = Build.BRAND;
        }
        return sBrand;
    }

    public static String getManufacturer() {
        if (TextUtils.isEmpty(sManufacturer)) {
            sManufacturer = Build.MANUFACTURER;
        }
        return sManufacturer;
    }

    public static String getModel() {
        if (TextUtils.isEmpty(sModel)) {
            sModel = Build.MODEL;
        }
        return sModel;
    }
}
