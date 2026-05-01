package com.umeng.ut.a;

import android.content.Context;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f12350a = new a();

    /* renamed from: a, reason: collision with other field name */
    private Context f57a = null;

    /* renamed from: a, reason: collision with other field name */
    private long f56a = 0;

    private a() {
    }

    public static a a() {
        return f12350a;
    }

    public synchronized void a(Context context) {
        if (this.f57a == null) {
            if (context == null) {
                return;
            }
            if (context.getApplicationContext() != null) {
                this.f57a = context.getApplicationContext();
            } else {
                this.f57a = context;
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public Context m69a() {
        return this.f57a;
    }

    public void a(long j10) {
        this.f56a = j10 - System.currentTimeMillis();
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m68a() {
        return System.currentTimeMillis() + this.f56a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m70a() {
        return "" + m68a();
    }
}
