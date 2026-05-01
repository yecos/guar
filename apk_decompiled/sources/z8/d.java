package z8;

import com.google.common.base.Preconditions;
import com.taobao.accs.common.Constants;
import java.io.InputStream;
import y8.l;
import z8.f;
import z8.i2;
import z8.k1;

/* loaded from: classes3.dex */
public abstract class d implements h2 {

    public static abstract class a implements f.h, k1.b {

        /* renamed from: a, reason: collision with root package name */
        public y f20413a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f20414b = new Object();

        /* renamed from: c, reason: collision with root package name */
        public final g2 f20415c;

        /* renamed from: d, reason: collision with root package name */
        public final m2 f20416d;

        /* renamed from: e, reason: collision with root package name */
        public final k1 f20417e;

        /* renamed from: f, reason: collision with root package name */
        public int f20418f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f20419g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f20420h;

        /* renamed from: z8.d$a$a, reason: collision with other inner class name */
        public class RunnableC0356a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g9.b f20421a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f20422b;

            public RunnableC0356a(g9.b bVar, int i10) {
                this.f20421a = bVar;
                this.f20422b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                g9.c.f("AbstractStream.request");
                g9.c.d(this.f20421a);
                try {
                    a.this.f20413a.b(this.f20422b);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }

        public a(int i10, g2 g2Var, m2 m2Var) {
            this.f20415c = (g2) Preconditions.checkNotNull(g2Var, "statsTraceCtx");
            this.f20416d = (m2) Preconditions.checkNotNull(m2Var, "transportTracer");
            k1 k1Var = new k1(this, l.b.f19933a, i10, g2Var, m2Var);
            this.f20417e = k1Var;
            this.f20413a = k1Var;
        }

        @Override // z8.k1.b
        public void a(i2.a aVar) {
            o().a(aVar);
        }

        public final void b(int i10) {
            boolean z10;
            synchronized (this.f20414b) {
                Preconditions.checkState(this.f20419g, "onStreamAllocated was not called, but it seems the stream is active");
                int i11 = this.f20418f;
                z10 = true;
                boolean z11 = i11 < 32768;
                int i12 = i11 - i10;
                this.f20418f = i12;
                boolean z12 = i12 < 32768;
                if (z11 || !z12) {
                    z10 = false;
                }
            }
            if (z10) {
                p();
            }
        }

        public final void k(boolean z10) {
            if (z10) {
                this.f20413a.close();
            } else {
                this.f20413a.m();
            }
        }

        public final void l(t1 t1Var) {
            try {
                this.f20413a.f(t1Var);
            } catch (Throwable th) {
                d(th);
            }
        }

        public m2 m() {
            return this.f20416d;
        }

        public final boolean n() {
            boolean z10;
            synchronized (this.f20414b) {
                z10 = this.f20419g && this.f20418f < 32768 && !this.f20420h;
            }
            return z10;
        }

        public abstract i2 o();

        public final void p() {
            boolean n10;
            synchronized (this.f20414b) {
                n10 = n();
            }
            if (n10) {
                o().d();
            }
        }

        public final void q(int i10) {
            synchronized (this.f20414b) {
                this.f20418f += i10;
            }
        }

        public void r() {
            Preconditions.checkState(o() != null);
            synchronized (this.f20414b) {
                Preconditions.checkState(this.f20419g ? false : true, "Already allocated");
                this.f20419g = true;
            }
            p();
        }

        public final void s() {
            synchronized (this.f20414b) {
                this.f20420h = true;
            }
        }

        public final void t() {
            this.f20417e.E(this);
            this.f20413a = this.f20417e;
        }

        public final void u(int i10) {
            f(new RunnableC0356a(g9.c.e(), i10));
        }

        public final void v(y8.u uVar) {
            this.f20413a.e(uVar);
        }

        public void w(r0 r0Var) {
            this.f20417e.z(r0Var);
            this.f20413a = new f(this, this, this.f20417e);
        }

        public final void x(int i10) {
            this.f20413a.c(i10);
        }
    }

    @Override // z8.h2
    public final void a(y8.n nVar) {
        r().a((y8.n) Preconditions.checkNotNull(nVar, "compressor"));
    }

    @Override // z8.h2
    public final void b(int i10) {
        t().u(i10);
    }

    @Override // z8.h2
    public final void flush() {
        if (r().isClosed()) {
            return;
        }
        r().flush();
    }

    @Override // z8.h2
    public final void h(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream, Constants.SHARED_MESSAGE_ID_FILE);
        try {
            if (!r().isClosed()) {
                r().b(inputStream);
            }
        } finally {
            q0.d(inputStream);
        }
    }

    @Override // z8.h2
    public void i() {
        t().t();
    }

    @Override // z8.h2
    public boolean m() {
        return t().n();
    }

    public final void q() {
        r().close();
    }

    public abstract o0 r();

    public final void s(int i10) {
        t().q(i10);
    }

    public abstract a t();
}
