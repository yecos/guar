package com.umeng.message.proguard;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes3.dex */
public final class ca {

    /* renamed from: a, reason: collision with root package name */
    public static String f11696a;

    /* renamed from: b, reason: collision with root package name */
    public static String f11697b;

    /* renamed from: c, reason: collision with root package name */
    public static String f11698c;

    /* renamed from: d, reason: collision with root package name */
    private static String f11699d;

    private static String a(String str) {
        try {
            return (String) ec.a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{str});
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context) {
        return DeviceConfig.getAndroidId(context);
    }

    public static String c(Context context) {
        return DeviceConfig.getOaid(context);
    }

    public static String d(Context context) {
        String uMId = UMUtils.getUMId(context);
        return uMId == null ? "" : uMId;
    }

    public static String e(Context context) {
        return DeviceConfig.getImeiNew(context);
    }

    public static String f(Context context) {
        String imeiNew = DeviceConfig.getImeiNew(context);
        if (TextUtils.isEmpty(imeiNew)) {
            return null;
        }
        return UMUtils.MD5(imeiNew);
    }

    public static String a() {
        String str = f11699d;
        if (str != null) {
            return str;
        }
        if (!"vivo".equalsIgnoreCase(c())) {
            f11699d = "";
            return "";
        }
        String a10 = a("ro.vivo.os.build.display.id");
        f11699d = a10;
        if (!TextUtils.isEmpty(a10)) {
            return f11699d;
        }
        String a11 = a("ro.iqoo.os.build.display.id");
        f11699d = a11;
        if (!TextUtils.isEmpty(a11)) {
            return f11699d;
        }
        f11699d = "";
        return "";
    }

    public static String b() {
        if (TextUtils.isEmpty(f11696a)) {
            f11696a = Build.MODEL;
        }
        return f11696a;
    }

    public static String c() {
        if (TextUtils.isEmpty(f11697b)) {
            String str = Build.BRAND;
            f11697b = str;
            if (TextUtils.isEmpty(str)) {
                f11697b = Build.MANUFACTURER;
            }
        }
        return f11697b;
    }

    public static String a(Context context) {
        return DeviceConfig.getIdfa(context);
    }
}
