package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.hpplay.component.common.ParamsMap;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f12349a = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.excelliance.multiaccounts", "com.lody.virtual", "com.qihoo.magic"};

    public static String a(Context context) {
        try {
            String str = DeviceConfig.UNKNOW;
            Method declaredMethod = DeviceConfig.class.getDeclaredMethod("getAndroidId", Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(DeviceConfig.class, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String b(Context context) {
        SharedPreferences a10;
        if (context == null || (a10 = a.a(context)) == null) {
            return "";
        }
        String string = a10.getString("inputDomain", "");
        return c(string) ? a(string) : string;
    }

    public static String c(Context context) {
        SharedPreferences a10;
        return (context == null || (a10 = a.a(context)) == null) ? "" : a10.getString("uabc", "");
    }

    public static String d(Context context) {
        SharedPreferences a10;
        if (context == null || (a10 = a.a(context)) == null) {
            return null;
        }
        return a10.getString("aaid", null);
    }

    public static String e(Context context) {
        try {
            String str = DeviceConfig.UNKNOW;
            Method declaredMethod = DeviceConfig.class.getDeclaredMethod("getMac", Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(DeviceConfig.class, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String f(Context context) {
        try {
            String str = DeviceConfig.UNKNOW;
            Method declaredMethod = DeviceConfig.class.getDeclaredMethod("getOaid", Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(DeviceConfig.class, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static boolean g(Context context) {
        boolean z10;
        try {
            String path = context.getFilesDir().getPath();
            for (String str : f12349a) {
                if (path.contains(str)) {
                    z10 = true;
                    break;
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return false;
            }
        }
        z10 = false;
        return z10;
    }

    public static boolean h(Context context) {
        try {
            String str = UMUtils.UNKNOW;
            Method declaredMethod = UMUtils.class.getDeclaredMethod("isMainProgress", Context.class);
            if (declaredMethod == null) {
                return true;
            }
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(UMUtils.class, context)).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean i(Context context) {
        NetworkInfo networkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (networkInfo = connectivityManager.getNetworkInfo(17)) != null) {
                    return networkInfo.isConnected();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean j(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void c(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (a10 = a.a(context)) == null || (edit = a10.edit()) == null) {
            return;
        }
        edit.putString("resetToken", str).commit();
    }

    public static void d(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (a10 = a.a(context)) == null || (edit = a10.edit()) == null) {
            return;
        }
        edit.putString("uabc", str).commit();
    }

    public static void e(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (a10 = a.a(context)) == null || (edit = a10.edit()) == null) {
            return;
        }
        edit.putString("aaid", str).commit();
    }

    public static void f(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (a10 = a.a(context)) == null || (edit = a10.edit()) == null) {
            return;
        }
        edit.putString("zdata", str).commit();
    }

    public static void a(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        String b10 = b(str);
        if (context == null || b10 == null || TextUtils.isEmpty(b10) || (a10 = a.a(context)) == null || (edit = a10.edit()) == null) {
            return;
        }
        edit.putString(ParamsMap.DeviceParams.KEY_MAC, b10).commit();
    }

    public static void b(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        String b10 = b(str);
        if (context == null || b10 == null || TextUtils.isEmpty(b10) || (a10 = a.a(context)) == null || (edit = a10.edit()) == null) {
            return;
        }
        edit.putString("oaid", b10).commit();
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.equals(b(a(str)));
    }
}
