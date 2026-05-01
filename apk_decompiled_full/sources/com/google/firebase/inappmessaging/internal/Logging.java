package com.google.firebase.inappmessaging.internal;

import android.util.Log;
import com.google.common.annotations.VisibleForTesting;

/* loaded from: classes2.dex */
public class Logging {

    @VisibleForTesting
    public static final String TAG = "FIAM.Headless";

    public static void logd(String str) {
        Log.isLoggable(TAG, 3);
    }

    public static void loge(String str) {
        Log.e(TAG, str);
    }

    public static void logi(String str) {
        Log.isLoggable(TAG, 4);
    }

    public static void logw(String str) {
    }
}
