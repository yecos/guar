package com.google.firebase.inappmessaging.display.internal;

import android.util.Log;

/* loaded from: classes2.dex */
public class Logging {
    private static final String TAG = "FIAM.Display";

    public static void logd(String str) {
        Log.isLoggable(TAG, 3);
    }

    public static void logdHeader(String str) {
        logd("============ " + str + " ============");
    }

    public static void logdNumber(String str, float f10) {
        logd(str + ": " + f10);
    }

    public static void logdPair(String str, float f10, float f11) {
        logd(str + ": (" + f10 + ", " + f11 + ")");
    }

    public static void loge(String str) {
        Log.e(TAG, str);
    }

    public static void logi(String str) {
        Log.isLoggable(TAG, 4);
    }
}
