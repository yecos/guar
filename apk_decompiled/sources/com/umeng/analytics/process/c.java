package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private static c f10632a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f10633b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private Context f10634c;

    private c() {
    }

    public static c a(Context context) {
        if (f10632a == null) {
            synchronized (c.class) {
                if (f10632a == null) {
                    f10632a = new c();
                }
            }
        }
        c cVar = f10632a;
        cVar.f10634c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.f10633b.get(str) != null) {
            return this.f10633b.get(str);
        }
        a a10 = a.a(this.f10634c, str);
        this.f10633b.put(str, a10);
        return a10;
    }

    public synchronized void b(String str) {
        c(str).b();
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private AtomicInteger f10635a = new AtomicInteger();

        /* renamed from: b, reason: collision with root package name */
        private SQLiteOpenHelper f10636b;

        /* renamed from: c, reason: collision with root package name */
        private SQLiteDatabase f10637c;

        private a() {
        }

        public static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f10636b = b.a(appContext, str);
            return aVar;
        }

        public synchronized void b() {
            try {
                if (this.f10635a.decrementAndGet() == 0) {
                    this.f10637c.close();
                }
            } catch (Throwable unused) {
            }
        }

        public synchronized SQLiteDatabase a() {
            if (this.f10635a.incrementAndGet() == 1) {
                this.f10637c = this.f10636b.getWritableDatabase();
            }
            return this.f10637c;
        }
    }

    public synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
