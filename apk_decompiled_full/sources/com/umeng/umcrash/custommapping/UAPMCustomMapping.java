package com.umeng.umcrash.custommapping;

import com.efs.sdk.base.custommapping.InnerCustomMappingManager;

/* loaded from: classes3.dex */
public class UAPMCustomMapping {
    public static final String STRING_PARAM_1 = "s1";
    public static final String STRING_PARAM_10 = "s10";
    public static final String STRING_PARAM_2 = "s2";
    public static final String STRING_PARAM_3 = "s3";
    public static final String STRING_PARAM_4 = "s4";
    public static final String STRING_PARAM_5 = "s5";
    public static final String STRING_PARAM_6 = "s6";
    public static final String STRING_PARAM_7 = "s7";
    public static final String STRING_PARAM_8 = "s8";
    public static final String STRING_PARAM_9 = "s9";

    public static String getStringParam(String str) {
        return InnerCustomMappingManager.getStringParam(str);
    }

    public static boolean putStringParam(String str, String str2) {
        return InnerCustomMappingManager.putStringParam(str, str2);
    }
}
