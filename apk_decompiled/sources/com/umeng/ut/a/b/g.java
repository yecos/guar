package com.umeng.ut.a.b;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f12359a = false;

    /* renamed from: a, reason: collision with other field name */
    private Context f59a;

    public g(Context context) {
        this.f59a = context;
    }

    private void a() {
        com.umeng.ut.a.c.e.c();
        if (com.umeng.ut.a.c.c.b(this.f59a) && !f12359a) {
            f12359a = true;
            if (com.umeng.ut.b.b.d.a(this.f59a).b()) {
                try {
                    m71b();
                } catch (Throwable unused) {
                }
                f12359a = false;
            }
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    private void m71b() {
        com.umeng.ut.a.c.e.c();
        String b10 = b();
        if (TextUtils.isEmpty(b10)) {
            com.umeng.ut.a.c.e.m72a("postData is empty", new Object[0]);
        } else if (a(b10)) {
            com.umeng.ut.a.c.e.m72a("", "upload success");
        } else {
            com.umeng.ut.a.c.e.m72a("", "upload fail");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                Thread.sleep(com.umeng.ut.b.b.a.b());
            } catch (Exception unused) {
            }
            a();
        } catch (Throwable th) {
            com.umeng.ut.a.c.e.a("", th, new Object[0]);
        }
    }

    private boolean a(String str) {
        a a10 = b.a("https://audid.umeng.com/v3/a/audid/req", str, true);
        if (a10 == null) {
            return false;
        }
        return com.umeng.ut.b.b.e.a(a10);
    }

    private String b() {
        String i10 = com.umeng.ut.b.b.a.a().i();
        if (TextUtils.isEmpty(i10)) {
            return null;
        }
        String a10 = com.umeng.ut.a.a.a.a(i10);
        if (com.umeng.ut.a.c.e.m73a()) {
            com.umeng.ut.a.c.e.b("", a10);
        }
        return com.umeng.ut.a.a.b.b(a10);
    }
}
