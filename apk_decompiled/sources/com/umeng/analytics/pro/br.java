package com.umeng.analytics.pro;

import android.os.Build;
import android.text.TextUtils;
import com.umeng.message.api.UPushThirdTokenCallback;

@Deprecated
/* loaded from: classes3.dex */
public class br {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10032a = "ro.build.version.emui";

    /* renamed from: b, reason: collision with root package name */
    private static final String f10033b = "hw_sc.build.platform.version";

    public static boolean a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.flyme.version", ""));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b() {
        return d() && !g();
    }

    @Deprecated
    public static boolean c() {
        return d() && g();
    }

    public static boolean d() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    public static boolean e() {
        String str = Build.BRAND;
        if (!str.equalsIgnoreCase("huawei") && !str.equalsIgnoreCase(UPushThirdTokenCallback.TYPE_HONOR) && !str.equalsIgnoreCase("华为")) {
            String a10 = a(f10032a);
            String a11 = a(f10033b);
            if (TextUtils.isEmpty(a10) && TextUtils.isEmpty(a11)) {
                return false;
            }
        }
        return true;
    }

    public static boolean f() {
        return !TextUtils.isEmpty(a("ro.coolos.version"));
    }

    private static boolean g() {
        return !TextUtils.isEmpty(a(f10032a));
    }

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
