package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final String f11241b = "lastReqTime";

    /* renamed from: c, reason: collision with root package name */
    private static final int f11242c = 48;

    /* renamed from: d, reason: collision with root package name */
    private static final int f11243d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final int f11244e = 720;

    /* renamed from: f, reason: collision with root package name */
    private static final String f11245f = "iss";

    /* renamed from: g, reason: collision with root package name */
    private static final String f11246g = "sinr";

    /* renamed from: h, reason: collision with root package name */
    private static final String f11247h = "clean";

    /* renamed from: i, reason: collision with root package name */
    private static boolean f11248i;

    /* renamed from: j, reason: collision with root package name */
    private static int f11249j;

    /* renamed from: a, reason: collision with root package name */
    private static final String f11240a = bd.b().b(bd.f9999z);

    /* renamed from: k, reason: collision with root package name */
    private static Object f11250k = new Object();

    static {
        f11248i = false;
        f11249j = f11244e;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(appContext, "iss", "");
            if (TextUtils.isEmpty(imprintProperty) || !"1".equals(imprintProperty)) {
                return;
            }
            synchronized (f11250k) {
                f11248i = true;
            }
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, f11246g, "");
            if (TextUtils.isEmpty(imprintProperty)) {
                f11249j = 48;
                return;
            }
            try {
                f11249j = a(Integer.parseInt(imprintProperty2));
            } catch (Throwable unused) {
                f11249j = 48;
            }
        }
    }

    private static int a(int i10) {
        if (i10 > f11244e) {
            return f11244e;
        }
        if (i10 < 1) {
            return 1;
        }
        return i10;
    }

    public static long b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f11240a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(f11241b, 0L);
        }
        return 0L;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f11240a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f11247h, true).commit();
        }
    }

    public static void d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f11240a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f11247h, false).commit();
        }
    }

    public static boolean e(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f11240a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(f11247h, false);
        }
        return false;
    }

    public static boolean a() {
        boolean z10;
        synchronized (f11250k) {
            z10 = f11248i;
        }
        return z10;
    }

    public static int a(Context context) {
        int i10;
        synchronized (f11250k) {
            i10 = f11249j;
        }
        return i10;
    }

    public static boolean a(long j10, long j11, int i10) {
        Date date = new Date(j11);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j10));
        calendar.add(10, i10);
        return date.after(calendar.getTime());
    }

    public static void a(Context context, long j10) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f11240a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(f11241b, j10).commit();
        }
    }
}
