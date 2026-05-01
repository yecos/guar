package z8;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class g2 {

    /* renamed from: c, reason: collision with root package name */
    public static final g2 f20625c = new g2(new y8.n1[0]);

    /* renamed from: a, reason: collision with root package name */
    public final y8.n1[] f20626a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f20627b = new AtomicBoolean(false);

    public g2(y8.n1[] n1VarArr) {
        this.f20626a = n1VarArr;
    }

    public static g2 h(y8.k[] kVarArr, y8.a aVar, y8.v0 v0Var) {
        g2 g2Var = new g2(kVarArr);
        for (y8.k kVar : kVarArr) {
            kVar.m(aVar, v0Var);
        }
        return g2Var;
    }

    public void a() {
        for (y8.n1 n1Var : this.f20626a) {
            ((y8.k) n1Var).j();
        }
    }

    public void b(y8.v0 v0Var) {
        for (y8.n1 n1Var : this.f20626a) {
            ((y8.k) n1Var).k(v0Var);
        }
    }

    public void c() {
        for (y8.n1 n1Var : this.f20626a) {
            ((y8.k) n1Var).l();
        }
    }

    public void d(int i10) {
        for (y8.n1 n1Var : this.f20626a) {
            n1Var.a(i10);
        }
    }

    public void e(int i10, long j10, long j11) {
        for (y8.n1 n1Var : this.f20626a) {
            n1Var.b(i10, j10, j11);
        }
    }

    public void f(long j10) {
        for (y8.n1 n1Var : this.f20626a) {
            n1Var.c(j10);
        }
    }

    public void g(long j10) {
        for (y8.n1 n1Var : this.f20626a) {
            n1Var.d(j10);
        }
    }

    public void i(int i10) {
        for (y8.n1 n1Var : this.f20626a) {
            n1Var.e(i10);
        }
    }

    public void j(int i10, long j10, long j11) {
        for (y8.n1 n1Var : this.f20626a) {
            n1Var.f(i10, j10, j11);
        }
    }

    public void k(long j10) {
        for (y8.n1 n1Var : this.f20626a) {
            n1Var.g(j10);
        }
    }

    public void l(long j10) {
        for (y8.n1 n1Var : this.f20626a) {
            n1Var.h(j10);
        }
    }

    public void m(y8.k1 k1Var) {
        if (this.f20627b.compareAndSet(false, true)) {
            for (y8.n1 n1Var : this.f20626a) {
                n1Var.i(k1Var);
            }
        }
    }
}
