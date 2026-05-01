package com.mobile.brasiltv.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final n0 f8733a = new n0();

    /* renamed from: b, reason: collision with root package name */
    public static final String f8734b = "user_data";

    public static /* synthetic */ boolean c(n0 n0Var, Context context, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return n0Var.b(context, str, z10);
    }

    public static /* synthetic */ String f(n0 n0Var, Context context, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        return n0Var.e(context, str, str2);
    }

    public static /* synthetic */ void h(n0 n0Var, Context context, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        n0Var.g(context, str, z10);
    }

    public final void a(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        context.getApplicationContext().getSharedPreferences(f8734b, 0).edit().clear().apply();
    }

    public final boolean b(Context context, String str, boolean z10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "defaultKey");
        return context.getApplicationContext().getSharedPreferences(f8734b, 0).getBoolean(str, z10);
    }

    public final int d(Context context, String str, int i10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "defaultKey");
        return context.getApplicationContext().getSharedPreferences(f8734b, 0).getInt(str, i10);
    }

    public final String e(Context context, String str, String str2) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "defaultKey");
        return context.getApplicationContext().getSharedPreferences(f8734b, 0).getString(str, str2);
    }

    public final void g(Context context, String str, boolean z10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "defaultKey");
        context.getApplicationContext().getSharedPreferences(f8734b, 0).edit().putBoolean(str, z10).apply();
    }

    public final void i(Context context, String str, int i10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "defaultKey");
        context.getApplicationContext().getSharedPreferences(f8734b, 0).edit().putInt(str, i10).apply();
    }

    public final void j(Context context, String str, String str2) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "defaultKey");
        context.getApplicationContext().getSharedPreferences(f8734b, 0).edit().putString(str, str2).apply();
    }

    public final void k(Context context, String[] strArr, String[] strArr2) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(strArr, "keyArray");
        t9.i.g(strArr2, "valueArray");
        if (strArr.length == strArr2.length) {
            int i10 = 0;
            if (!(strArr.length == 0)) {
                SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(f8734b, 0).edit();
                int length = strArr.length;
                int i11 = 0;
                while (i10 < length) {
                    edit.putString(strArr[i10], strArr2[i11]);
                    i10++;
                    i11++;
                }
                edit.apply();
                return;
            }
        }
        System.out.print(new Exception("数量不匹配"));
    }

    public final void l(Context context, String[] strArr, Object[] objArr) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(strArr, "keyArray");
        t9.i.g(objArr, "valueArray");
        if (strArr.length == objArr.length) {
            int i10 = 0;
            if (!(strArr.length == 0)) {
                SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(f8734b, 0).edit();
                int length = strArr.length;
                int i11 = 0;
                while (i10 < length) {
                    String str = strArr[i10];
                    int i12 = i11 + 1;
                    Object obj = objArr[i11];
                    if (obj instanceof String) {
                        edit.putString(str, (String) obj);
                    } else if (obj instanceof Integer) {
                        edit.putInt(str, ((Number) obj).intValue());
                    } else if (obj instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Float) {
                        edit.putFloat(str, ((Number) obj).floatValue());
                    } else if (obj instanceof Long) {
                        edit.putLong(str, ((Number) obj).longValue());
                    }
                    i10++;
                    i11 = i12;
                }
                edit.apply();
                return;
            }
        }
        System.out.print(new Exception("数量不匹配"));
    }
}
