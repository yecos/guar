package androidx.work.impl.background.systemalarm;

import a1.k;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.d;
import j1.p;
import java.util.Collections;
import java.util.List;
import k1.n;
import k1.r;

/* loaded from: classes.dex */
public class c implements f1.c, b1.b, r.b {

    /* renamed from: j, reason: collision with root package name */
    public static final String f3686j = k.f("DelayMetCommandHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f3687a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3688b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3689c;

    /* renamed from: d, reason: collision with root package name */
    public final d f3690d;

    /* renamed from: e, reason: collision with root package name */
    public final f1.d f3691e;

    /* renamed from: h, reason: collision with root package name */
    public PowerManager.WakeLock f3694h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3695i = false;

    /* renamed from: g, reason: collision with root package name */
    public int f3693g = 0;

    /* renamed from: f, reason: collision with root package name */
    public final Object f3692f = new Object();

    public c(Context context, int i10, String str, d dVar) {
        this.f3687a = context;
        this.f3688b = i10;
        this.f3690d = dVar;
        this.f3689c = str;
        this.f3691e = new f1.d(context, dVar.f(), this);
    }

    @Override // k1.r.b
    public void a(String str) {
        k.c().a(f3686j, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // f1.c
    public void b(List list) {
        g();
    }

    @Override // b1.b
    public void c(String str, boolean z10) {
        k.c().a(f3686j, String.format("onExecuted %s, %s", str, Boolean.valueOf(z10)), new Throwable[0]);
        e();
        if (z10) {
            Intent f10 = a.f(this.f3687a, this.f3689c);
            d dVar = this.f3690d;
            dVar.k(new d.b(dVar, f10, this.f3688b));
        }
        if (this.f3695i) {
            Intent a10 = a.a(this.f3687a);
            d dVar2 = this.f3690d;
            dVar2.k(new d.b(dVar2, a10, this.f3688b));
        }
    }

    @Override // f1.c
    public void d(List list) {
        if (list.contains(this.f3689c)) {
            synchronized (this.f3692f) {
                if (this.f3693g == 0) {
                    this.f3693g = 1;
                    k.c().a(f3686j, String.format("onAllConstraintsMet for %s", this.f3689c), new Throwable[0]);
                    if (this.f3690d.e().j(this.f3689c)) {
                        this.f3690d.h().b(this.f3689c, 600000L, this);
                    } else {
                        e();
                    }
                } else {
                    k.c().a(f3686j, String.format("Already started work for %s", this.f3689c), new Throwable[0]);
                }
            }
        }
    }

    public final void e() {
        synchronized (this.f3692f) {
            this.f3691e.e();
            this.f3690d.h().c(this.f3689c);
            PowerManager.WakeLock wakeLock = this.f3694h;
            if (wakeLock != null && wakeLock.isHeld()) {
                k.c().a(f3686j, String.format("Releasing wakelock %s for WorkSpec %s", this.f3694h, this.f3689c), new Throwable[0]);
                this.f3694h.release();
            }
        }
    }

    public void f() {
        this.f3694h = n.b(this.f3687a, String.format("%s (%s)", this.f3689c, Integer.valueOf(this.f3688b)));
        k c10 = k.c();
        String str = f3686j;
        c10.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.f3694h, this.f3689c), new Throwable[0]);
        this.f3694h.acquire();
        p h10 = this.f3690d.g().n().B().h(this.f3689c);
        if (h10 == null) {
            g();
            return;
        }
        boolean b10 = h10.b();
        this.f3695i = b10;
        if (b10) {
            this.f3691e.d(Collections.singletonList(h10));
        } else {
            k.c().a(str, String.format("No constraints for %s", this.f3689c), new Throwable[0]);
            d(Collections.singletonList(this.f3689c));
        }
    }

    public final void g() {
        synchronized (this.f3692f) {
            if (this.f3693g < 2) {
                this.f3693g = 2;
                k c10 = k.c();
                String str = f3686j;
                c10.a(str, String.format("Stopping work for WorkSpec %s", this.f3689c), new Throwable[0]);
                Intent g10 = a.g(this.f3687a, this.f3689c);
                d dVar = this.f3690d;
                dVar.k(new d.b(dVar, g10, this.f3688b));
                if (this.f3690d.e().g(this.f3689c)) {
                    k.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.f3689c), new Throwable[0]);
                    Intent f10 = a.f(this.f3687a, this.f3689c);
                    d dVar2 = this.f3690d;
                    dVar2.k(new d.b(dVar2, f10, this.f3688b));
                } else {
                    k.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f3689c), new Throwable[0]);
                }
            } else {
                k.c().a(f3686j, String.format("Already stopped work for %s", this.f3689c), new Throwable[0]);
            }
        }
    }
}
