package com.zhy.autolayout.utils;

import android.util.Log;

/* loaded from: classes3.dex */
public class L {
    private static final String TAG = "AUTO_LAYOUT";
    public static boolean debug = false;

    public static void e(String str) {
        if (debug) {
            Log.e(TAG, str);
        }
    }
}
