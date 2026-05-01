package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f11046a;

    /* renamed from: b, reason: collision with root package name */
    private static Context f11047b;

    /* renamed from: c, reason: collision with root package name */
    private static String f11048c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f11049d = bd.b().b(bd.f9986m);

    public d(Context context) {
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            f11047b = context.getApplicationContext();
            f11048c = context.getPackageName();
            if (f11046a == null) {
                f11046a = new d(context);
            }
            dVar = f11046a;
        }
        return dVar;
    }

    private SharedPreferences f() {
        return f11047b.getSharedPreferences(f11049d + f11048c, 0);
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f11047b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(f11047b) > 0;
    }

    public String[] d() {
        try {
            SharedPreferences f10 = f();
            String string = f10.getString("au_p", null);
            String string2 = f10.getString("au_u", null);
            if (string == null || string2 == null) {
                return null;
            }
            return new String[]{string, string2};
        } catch (Exception unused) {
            return null;
        }
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }

    public void a(int i10) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f11047b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i10).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f11047b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f11047b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }
}
