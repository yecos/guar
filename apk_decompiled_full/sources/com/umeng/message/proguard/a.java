package com.umeng.message.proguard;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.common.UPLog;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f11445a = new a();

    /* renamed from: b, reason: collision with root package name */
    private String f11446b;

    /* renamed from: c, reason: collision with root package name */
    private Class<?> f11447c;

    /* renamed from: d, reason: collision with root package name */
    private Class<?> f11448d;

    /* renamed from: e, reason: collision with root package name */
    private Class<?> f11449e;

    /* renamed from: f, reason: collision with root package name */
    private Class<?> f11450f;

    private a() {
    }

    public static int a(String str) {
        return f11445a.g(str);
    }

    public static int b(String str) {
        return f11445a.e(str);
    }

    public static int c(String str) {
        return f11445a.f(str);
    }

    public static int d(String str) {
        return f11445a.h(str);
    }

    private int e(String str) {
        if (this.f11447c == null) {
            try {
                this.f11447c = Class.forName(a() + ".R$id");
            } catch (ClassNotFoundException e10) {
                UPLog.w("R2", UPLog.getStackTrace(e10));
            }
        }
        return a(this.f11447c, str);
    }

    private int f(String str) {
        if (this.f11448d == null) {
            try {
                this.f11448d = Class.forName(a() + ".R$drawable");
            } catch (ClassNotFoundException e10) {
                UPLog.w("R2", UPLog.getStackTrace(e10));
                UMLog.aq(ac.f11452b, 0, "\\|");
            }
        }
        return a(this.f11448d, str);
    }

    private int g(String str) {
        if (this.f11449e == null) {
            try {
                this.f11449e = Class.forName(a() + ".R$layout");
            } catch (ClassNotFoundException e10) {
                UPLog.w("R2", UPLog.getStackTrace(e10));
            }
        }
        return a(this.f11449e, str);
    }

    private int h(String str) {
        if (this.f11450f == null) {
            try {
                this.f11450f = Class.forName(a() + ".R$raw");
            } catch (ClassNotFoundException e10) {
                UPLog.w("R2", UPLog.getStackTrace(e10));
            }
        }
        return a(this.f11450f, str);
    }

    private String a() {
        if (!TextUtils.isEmpty(this.f11446b)) {
            return this.f11446b;
        }
        Application a10 = y.a();
        String h10 = MessageSharedPrefs.getInstance(a10).h();
        if (TextUtils.isEmpty(h10)) {
            h10 = a10.getPackageName();
        }
        this.f11446b = h10;
        UPLog.i("R2", "resPackage:", h10);
        return this.f11446b;
    }

    private int a(Class<?> cls, String str) {
        if (cls != null) {
            return cls.getField(str).getInt(str);
        }
        UPLog.e("R2", "getRes(null,", str, ")");
        throw new Resources.NotFoundException(a() + ".R$* field=" + str + " not exist.");
    }
}
