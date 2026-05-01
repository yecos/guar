package com.umeng.ut.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.ut.a.b.g;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f12376a = new a();

    /* renamed from: c, reason: collision with root package name */
    private static long f12377c = 3000;

    /* renamed from: c, reason: collision with other field name */
    private String f63c = "";

    private a() {
    }

    public static a a() {
        return f12376a;
    }

    public static long b() {
        return f12377c;
    }

    private void d() {
        com.umeng.ut.a.c.e.c();
        if (TextUtils.isEmpty(this.f63c)) {
            return;
        }
        try {
            Context m69a = com.umeng.ut.a.a.a().m69a();
            if (com.umeng.ut.a.c.a.a(m69a)) {
                new Thread(new g(m69a)).start();
            }
        } catch (Throwable th) {
            com.umeng.ut.a.c.e.m72a("", th);
        }
    }

    public synchronized String getUtdid(Context context) {
        if (!TextUtils.isEmpty(this.f63c)) {
            return this.f63c;
        }
        try {
            String value = d.a(context).getValue();
            if (TextUtils.isEmpty(value)) {
                return "ffffffffffffffffffffffff";
            }
            this.f63c = value;
            d();
            return this.f63c;
        } catch (Throwable th) {
            com.umeng.ut.a.c.e.a("AppUtdid", th, new Object[0]);
            return "ffffffffffffffffffffffff";
        }
    }

    public synchronized String i() {
        return this.f63c;
    }
}
