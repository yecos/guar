package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.common.Constants;

/* loaded from: classes3.dex */
public class v {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";

    /* renamed from: a, reason: collision with root package name */
    static int f9381a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f9382b = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    private static int f9383c = -1;

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (f9383c == -1) {
            f9383c = context.getApplicationInfo().targetSdkVersion;
        }
        return f9383c >= 26 && Build.VERSION.SDK_INT >= 26;
    }

    public static int b(Context context) {
        int i10;
        int i11 = f9381a;
        if (i11 != -1) {
            return i11;
        }
        try {
        } catch (Throwable th) {
            th = th;
            context = null;
        }
        try {
            synchronized (f9382b) {
                try {
                    i10 = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt(Constants.SP_KEY_DEBUG_MODE, 0);
                    return i10;
                } catch (Throwable th2) {
                    th = th2;
                    context = null;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        th = th3;
                        ALog.e("Utils", "getMode", th, new Object[0]);
                        i10 = context;
                        return i10;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void c(Context context) {
        try {
            synchronized (f9382b) {
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.clear();
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.e("Utils", "clearAllSharePreferences", th, new Object[0]);
        }
    }

    public static void d(Context context) {
        try {
            UtilityImpl.killService(context);
        } catch (Throwable th) {
            ALog.e("Utils", "killService", th, new Object[0]);
        }
    }

    public static boolean e(Context context) {
        boolean z10;
        try {
            z10 = UtilityImpl.isMainProcess(context);
        } catch (Throwable th) {
            ALog.e("Utils", "killservice", th, new Object[0]);
            th.printStackTrace();
            z10 = true;
        }
        ALog.i("Utils", "isMainProcess", "result", Boolean.valueOf(z10));
        return z10;
    }

    public static void f(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("AGOO_BIND", 0).edit();
            edit.clear();
            edit.apply();
        } catch (Exception e10) {
            ALog.e("Utils", "clearAgooBindCache", e10, new Object[0]);
        }
    }

    public static void a(Context context, int i10) {
        try {
            synchronized (f9382b) {
                f9381a = i10;
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.putInt(Constants.SP_KEY_DEBUG_MODE, i10);
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.e("Utils", "setMode", th, new Object[0]);
        }
    }

    @Deprecated
    public static void a() {
        try {
            AccsConfig.build();
        } catch (Throwable th) {
            ALog.e("Utils", "initConfig", th, new Object[0]);
            th.printStackTrace();
        }
    }

    public static String a(Context context, String str, String str2) {
        String str3 = null;
        try {
            synchronized (f9382b) {
                str3 = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(str, null);
            }
            ALog.i("Utils", "getSpValue", "value", str3);
            if (TextUtils.isEmpty(str3)) {
                ALog.e("Utils", "getSpValue use default!", new Object[0]);
                return str2;
            }
        } catch (Throwable th) {
            ALog.e("Utils", "getSpValue fail", th, new Object[0]);
        }
        return str3;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
