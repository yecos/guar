package com.umeng.message.proguard;

import android.app.Activity;
import android.os.SystemClock;
import com.umeng.message.proguard.bx;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public abstract class dc {

    /* renamed from: a, reason: collision with root package name */
    public final cz f11863a;

    /* renamed from: b, reason: collision with root package name */
    protected final bx.c f11864b;

    /* renamed from: c, reason: collision with root package name */
    public bx.b f11865c;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<Activity> f11866d;

    /* renamed from: e, reason: collision with root package name */
    protected int f11867e = 1500;

    /* renamed from: f, reason: collision with root package name */
    protected long f11868f;

    /* renamed from: g, reason: collision with root package name */
    long f11869g;

    public dc(cz czVar) {
        this.f11863a = czVar;
        this.f11864b = czVar.f11851b;
    }

    public final void a() {
        this.f11868f = SystemClock.elapsedRealtime();
        new Runnable() { // from class: com.umeng.message.proguard.dc.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    try {
                        ck b10 = dc.this.b();
                        if (b10 == null) {
                            ce.a("Load", "type:", dc.this.f11864b, " consume:", Long.valueOf(SystemClock.elapsedRealtime() - dc.this.f11868f));
                            return;
                        }
                        final bx.a b11 = dc.this.b(b10);
                        if (b11 == null) {
                            ce.a("Load", "type:", dc.this.f11864b, " consume:", Long.valueOf(SystemClock.elapsedRealtime() - dc.this.f11868f));
                            return;
                        }
                        dc.this.f11869g = SystemClock.elapsedRealtime();
                        b10.f11748j = System.currentTimeMillis();
                        final dc dcVar = dc.this;
                        final bx.c cVar = b10.f11739a;
                        cb.c(new Runnable() { // from class: com.umeng.message.proguard.dc.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                bx.b bVar = dc.this.f11865c;
                                if (bVar != null) {
                                    bVar.a(cVar, b11);
                                }
                            }
                        });
                        ce.a("Load", "type:", dc.this.f11864b, " consume:", Long.valueOf(SystemClock.elapsedRealtime() - dc.this.f11868f));
                    } catch (cd e10) {
                        final dc dcVar2 = dc.this;
                        final String message = e10.getMessage();
                        cb.c(new Runnable() { // from class: com.umeng.message.proguard.dc.3
                            @Override // java.lang.Runnable
                            public final void run() {
                                dc dcVar3 = dc.this;
                                bx.b bVar = dcVar3.f11865c;
                                if (bVar != null) {
                                    bVar.a(dcVar3.f11864b, message);
                                }
                            }
                        });
                        ce.a("Load", "type:", dc.this.f11864b, " consume:", Long.valueOf(SystemClock.elapsedRealtime() - dc.this.f11868f));
                    }
                } catch (Throwable th) {
                    ce.a("Load", "type:", dc.this.f11864b, " consume:", Long.valueOf(SystemClock.elapsedRealtime() - dc.this.f11868f));
                    throw th;
                }
            }
        }.run();
    }

    public abstract bx.a b(ck ckVar);

    public abstract ck b();

    public final boolean a(ck ckVar) {
        return SystemClock.elapsedRealtime() - this.f11869g > ((long) ckVar.h());
    }
}
