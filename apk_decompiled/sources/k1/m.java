package k1;

import a1.s;
import androidx.work.impl.WorkDatabase;

/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public static final String f14761d = a1.k.f("StopWorkRunnable");

    /* renamed from: a, reason: collision with root package name */
    public final b1.j f14762a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14763b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14764c;

    public m(b1.j jVar, String str, boolean z10) {
        this.f14762a = jVar;
        this.f14763b = str;
        this.f14764c = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean o10;
        WorkDatabase n10 = this.f14762a.n();
        b1.d l10 = this.f14762a.l();
        j1.q B = n10.B();
        n10.c();
        try {
            boolean h10 = l10.h(this.f14763b);
            if (this.f14764c) {
                o10 = this.f14762a.l().n(this.f14763b);
            } else {
                if (!h10 && B.g(this.f14763b) == s.RUNNING) {
                    B.d(s.ENQUEUED, this.f14763b);
                }
                o10 = this.f14762a.l().o(this.f14763b);
            }
            a1.k.c().a(f14761d, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.f14763b, Boolean.valueOf(o10)), new Throwable[0]);
            n10.r();
        } finally {
            n10.g();
        }
    }
}
