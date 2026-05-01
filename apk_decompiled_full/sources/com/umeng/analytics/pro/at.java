package com.umeng.analytics.pro;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    private static String f9902a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f9903b = "";

    /* renamed from: c, reason: collision with root package name */
    private static final String f9904c = "hw_sc.build.platform.version";

    /* renamed from: d, reason: collision with root package name */
    private static final String f9905d = "ro.build.version.emui";

    /* renamed from: e, reason: collision with root package name */
    private static final String f9906e = "ro.build.version.magic";

    /* renamed from: f, reason: collision with root package name */
    private static final String f9907f = "ro.miui.ui.version.name";

    /* renamed from: g, reason: collision with root package name */
    private static final String f9908g = "ro.build.version.opporom";

    /* renamed from: h, reason: collision with root package name */
    private static final String f9909h = "ro.vivo.os.name";

    /* renamed from: i, reason: collision with root package name */
    private static final String f9910i = "ro.vivo.os.version";

    /* renamed from: j, reason: collision with root package name */
    private static final String f9911j = "ro.build.version.oplusrom";

    /* renamed from: k, reason: collision with root package name */
    private static final String f9912k = "ro.rom.version";

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(f9902a)) {
            e(str);
        }
        return f9903b;
    }

    public static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void e(String str) {
        char c10;
        try {
            String c11 = c(str);
            switch (c11.hashCode()) {
                case -1881642058:
                    if (c11.equals("REALME")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1706170181:
                    if (c11.equals("XIAOMI")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -602397472:
                    if (c11.equals("ONEPLUS")) {
                        c10 = 7;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2432928:
                    if (c11.equals("OPPO")) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2634924:
                    if (c11.equals("VIVO")) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 68924490:
                    if (c11.equals("HONOR")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 77852109:
                    if (c11.equals("REDMI")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2141820391:
                    if (c11.equals("HUAWEI")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    if (!a()) {
                        f9902a = "EMUI";
                        f9903b = d(f9905d);
                        break;
                    } else {
                        f9903b = d(f9904c);
                        f9902a = "HarmonyOS";
                        break;
                    }
                case 1:
                    if (!TextUtils.isEmpty(d(f9906e))) {
                        f9902a = "MagicUI";
                        f9903b = d(f9906e);
                        break;
                    } else {
                        f9902a = "EMUI";
                        f9903b = d(f9905d);
                        break;
                    }
                case 2:
                case 3:
                    f9902a = "MIUI";
                    f9903b = d(f9907f);
                    break;
                case 4:
                case 5:
                    f9902a = "ColorOS";
                    f9903b = d(f9908g);
                    break;
                case 6:
                    f9902a = "Funtouch";
                    f9903b = d(f9910i);
                    break;
                case 7:
                    f9902a = "HydrogenOS";
                    String d10 = d(f9912k);
                    if (TextUtils.isEmpty(d10)) {
                        f9902a = "ColorOS";
                        d10 = d(f9911j);
                    }
                    f9903b = d10;
                    break;
                default:
                    f9902a = "Android";
                    f9903b = Build.VERSION.RELEASE;
                    break;
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(f9902a)) {
            e(str);
        }
        return f9902a;
    }
}
