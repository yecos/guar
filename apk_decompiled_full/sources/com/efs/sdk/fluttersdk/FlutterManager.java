package com.efs.sdk.fluttersdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import java.util.Map;

/* loaded from: classes.dex */
public class FlutterManager {
    public static final String TAG = "FlutterManager";

    /* renamed from: a, reason: collision with root package name */
    private static EfsReporter f6254a = null;

    /* renamed from: b, reason: collision with root package name */
    private static FlutterConfigManager f6255b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Context f6256c = null;
    public static boolean isDebug = true;

    public static Map<String, Object> getCloudConfig() {
        FlutterConfigManager flutterConfigManager = f6255b;
        if (flutterConfigManager != null) {
            return flutterConfigManager.getCloudConfig();
        }
        return null;
    }

    public static FlutterConfigManager getFlutterConfigManager() {
        return f6255b;
    }

    public static long getLongValue(String str) {
        Context context = f6256c;
        if (context == null) {
            Log.e(TAG, "Flutter Manager not init!");
            return 0L;
        }
        try {
            return context.getSharedPreferences("efs_flutter_bridge", 0).getLong(str, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static Map<String, Object> getNativeParams() {
        FlutterConfigManager flutterConfigManager = f6255b;
        if (flutterConfigManager != null) {
            return flutterConfigManager.getNativeParams();
        }
        return null;
    }

    public static EfsReporter getReporter() {
        return f6254a;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            Log.e(TAG, "init Flutter manager error! parameter is null!");
            return;
        }
        f6256c = context;
        f6254a = efsReporter;
        f6255b = new FlutterConfigManager(context, efsReporter);
    }

    public static boolean putLongValue(String str, long j10) {
        Context context = f6256c;
        if (context == null) {
            Log.e(TAG, "Flutter Manager not init!");
            return false;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("efs_flutter_bridge", 0).edit();
            edit.putLong(str, j10);
            edit.apply();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
