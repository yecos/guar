package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
class i {

    /* renamed from: b, reason: collision with root package name */
    private static SQLiteOpenHelper f10415b;

    /* renamed from: d, reason: collision with root package name */
    private static Context f10416d;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f10417a;

    /* renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f10418c;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final i f10419a = new i();

        private a() {
        }
    }

    public static i a(Context context) {
        if (f10416d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            f10416d = applicationContext;
            f10415b = h.a(applicationContext);
        }
        return a.f10419a;
    }

    public synchronized void b() {
        try {
            if (this.f10417a.decrementAndGet() == 0) {
                this.f10418c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private i() {
        this.f10417a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.f10417a.incrementAndGet() == 1) {
            this.f10418c = f10415b.getWritableDatabase();
        }
        return this.f10418c;
    }
}
