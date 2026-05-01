package com.raizlabs.android.dbflow;

/* loaded from: classes3.dex */
public class StringUtils {
    public static boolean isNotNullOrEmpty(String str) {
        return (str == null || str.equals("") || str.length() <= 0) ? false : true;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.equals("") || str.length() <= 0;
    }
}
