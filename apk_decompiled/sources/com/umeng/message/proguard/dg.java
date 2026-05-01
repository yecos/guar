package com.umeng.message.proguard;

import android.app.Activity;
import android.view.View;
import anet.channel.entity.ConnType;
import com.umeng.message.proguard.bx;
import com.umeng.message.proguard.bz;
import com.umeng.message.proguard.db;
import com.umeng.message.proguard.df;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class dg extends bz.b {

    /* renamed from: a, reason: collision with root package name */
    private static final dg f11884a = new dg();

    /* renamed from: b, reason: collision with root package name */
    private volatile Future<Void> f11885b;

    private dg() {
    }

    public static dg b() {
        return f11884a;
    }

    @Override // com.umeng.message.proguard.bz.b
    public final String a() {
        return ConnType.PK_AUTO;
    }

    @Override // com.umeng.message.proguard.bz.b
    public final void c(Activity activity) {
        if (activity instanceof cx) {
            return;
        }
        try {
            final dt a10 = dt.a();
            if (a10.f12016a.c(ConnType.PK_AUTO)) {
                Future<Void> future = this.f11885b;
                if (future != null && !future.isDone() && !future.isCancelled()) {
                    future.cancel(false);
                }
                final Class<?> cls = activity.getClass();
                this.f11885b = cb.a(new Callable<Void>() { // from class: com.umeng.message.proguard.dg.1
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Void call() {
                        Activity b10;
                        df dfVar;
                        df dfVar2;
                        df dfVar3;
                        cz czVar;
                        dc a11;
                        cz czVar2;
                        dc a12;
                        cz czVar3;
                        dc a13;
                        db unused;
                        dg.a(dg.this);
                        if (a10.a(cls)) {
                            return null;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (Math.abs(currentTimeMillis - a10.f12016a.b("req", 0L)) < Math.max(a10.f12016a.b(com.umeng.analytics.pro.bt.f10040ba, 300L) * 1000, 60000L) || (b10 = bz.a().b()) == null || ed.a(b10) || !cls.getName().equals(b10.getClass().getName())) {
                            return null;
                        }
                        a10.f12016a.a("req", currentTimeMillis);
                        unused = db.a.f11862a;
                        bx.b bVar = new bx.b() { // from class: com.umeng.message.proguard.dg.1.1
                            @Override // com.umeng.message.proguard.bx.b
                            public final void a(final bx.c cVar, bx.a aVar) {
                                aVar.a(new bx.d() { // from class: com.umeng.message.proguard.dg.1.1.1
                                    @Override // com.umeng.message.proguard.bx.d
                                    public final void a() {
                                        ce.b("Auto", "onShow ", cVar.name());
                                    }

                                    @Override // com.umeng.message.proguard.bx.d
                                    public final void b() {
                                        ce.b("Auto", "onDismiss ", cVar.name());
                                    }

                                    @Override // com.umeng.message.proguard.bx.d
                                    public final void a(View view) {
                                        ce.b("Auto", "onClick ", cVar.name());
                                    }

                                    @Override // com.umeng.message.proguard.bx.d
                                    public final void a(int i10, String str) {
                                        ce.b("Auto", "onError ", cVar.name(), " code: ", Integer.valueOf(i10), " message: ", str);
                                    }
                                });
                                aVar.a();
                            }

                            @Override // com.umeng.message.proguard.bx.b
                            public final void a(bx.c cVar, String str) {
                                ce.d("Auto", "onFailure ", cVar.name(), " message: ", str);
                            }
                        };
                        dfVar = df.a.f11883a;
                        bw bwVar = dfVar.f11879b;
                        if (bwVar != null && (a13 = dd.a((czVar3 = new cz(bx.c.BANNER, bwVar)), bVar)) != null) {
                            czVar3.f11852c = true;
                            a13.a();
                        }
                        dfVar2 = df.a.f11883a;
                        bw bwVar2 = dfVar2.f11878a;
                        if (bwVar2 != null && (a12 = dd.a((czVar2 = new cz(bx.c.INTERSTITIAL, bwVar2)), bVar)) != null) {
                            czVar2.f11852c = true;
                            a12.a();
                        }
                        dfVar3 = df.a.f11883a;
                        bw bwVar3 = dfVar3.f11880c;
                        if (bwVar3 == null || (a11 = dd.a((czVar = new cz(bx.c.FLOATING_ICON, bwVar3)), bVar)) == null) {
                            return null;
                        }
                        czVar.f11852c = true;
                        a11.a();
                        return null;
                    }
                }, Math.max(a10.f12016a.b("delay", 7L), 5L), TimeUnit.SECONDS);
            }
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ Future a(dg dgVar) {
        dgVar.f11885b = null;
        return null;
    }
}
