package z8;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.hpplay.sdk.source.common.global.Constant;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.v0;
import z8.d;
import z8.l1;
import z8.r;

/* loaded from: classes3.dex */
public abstract class a extends d implements q, l1.d {

    /* renamed from: g, reason: collision with root package name */
    public static final Logger f20241g = Logger.getLogger(a.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final m2 f20242a;

    /* renamed from: b, reason: collision with root package name */
    public final o0 f20243b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20244c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20245d;

    /* renamed from: e, reason: collision with root package name */
    public y8.v0 f20246e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f20247f;

    /* renamed from: z8.a$a, reason: collision with other inner class name */
    public class C0354a implements o0 {

        /* renamed from: a, reason: collision with root package name */
        public y8.v0 f20248a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f20249b;

        /* renamed from: c, reason: collision with root package name */
        public final g2 f20250c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f20251d;

        public C0354a(y8.v0 v0Var, g2 g2Var) {
            this.f20248a = (y8.v0) Preconditions.checkNotNull(v0Var, "headers");
            this.f20250c = (g2) Preconditions.checkNotNull(g2Var, "statsTraceCtx");
        }

        @Override // z8.o0
        public o0 a(y8.n nVar) {
            return this;
        }

        @Override // z8.o0
        public void b(InputStream inputStream) {
            Preconditions.checkState(this.f20251d == null, "writePayload should not be called multiple times");
            try {
                this.f20251d = ByteStreams.toByteArray(inputStream);
                this.f20250c.i(0);
                g2 g2Var = this.f20250c;
                byte[] bArr = this.f20251d;
                g2Var.j(0, bArr.length, bArr.length);
                this.f20250c.k(this.f20251d.length);
                this.f20250c.l(this.f20251d.length);
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // z8.o0
        public void close() {
            this.f20249b = true;
            Preconditions.checkState(this.f20251d != null, "Lack of request message. GET request is only supported for unary requests");
            a.this.u().f(this.f20248a, this.f20251d);
            this.f20251d = null;
            this.f20248a = null;
        }

        @Override // z8.o0
        public void d(int i10) {
        }

        @Override // z8.o0
        public void flush() {
        }

        @Override // z8.o0
        public boolean isClosed() {
            return this.f20249b;
        }
    }

    public interface b {
        void e(y8.k1 k1Var);

        void f(y8.v0 v0Var, byte[] bArr);

        void g(n2 n2Var, boolean z10, boolean z11, int i10);
    }

    public static abstract class c extends d.a {

        /* renamed from: i, reason: collision with root package name */
        public final g2 f20253i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f20254j;

        /* renamed from: k, reason: collision with root package name */
        public r f20255k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f20256l;

        /* renamed from: m, reason: collision with root package name */
        public y8.v f20257m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f20258n;

        /* renamed from: o, reason: collision with root package name */
        public Runnable f20259o;

        /* renamed from: p, reason: collision with root package name */
        public volatile boolean f20260p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f20261q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f20262r;

        /* renamed from: z8.a$c$a, reason: collision with other inner class name */
        public class RunnableC0355a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y8.k1 f20263a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r.a f20264b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ y8.v0 f20265c;

            public RunnableC0355a(y8.k1 k1Var, r.a aVar, y8.v0 v0Var) {
                this.f20263a = k1Var;
                this.f20264b = aVar;
                this.f20265c = v0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.C(this.f20263a, this.f20264b, this.f20265c);
            }
        }

        public c(int i10, g2 g2Var, m2 m2Var) {
            super(i10, g2Var, m2Var);
            this.f20257m = y8.v.c();
            this.f20258n = false;
            this.f20253i = (g2) Preconditions.checkNotNull(g2Var, "statsTraceCtx");
        }

        public final void C(y8.k1 k1Var, r.a aVar, y8.v0 v0Var) {
            if (this.f20254j) {
                return;
            }
            this.f20254j = true;
            this.f20253i.m(k1Var);
            o().c(k1Var, aVar, v0Var);
            if (m() != null) {
                m().f(k1Var.p());
            }
        }

        public void D(t1 t1Var) {
            Preconditions.checkNotNull(t1Var, "frame");
            boolean z10 = true;
            try {
                if (this.f20261q) {
                    a.f20241g.log(Level.INFO, "Received data on closed stream");
                    t1Var.close();
                    return;
                }
                try {
                    l(t1Var);
                } catch (Throwable th) {
                    th = th;
                    z10 = false;
                    if (z10) {
                        t1Var.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void E(y8.v0 r6) {
            /*
                r5 = this;
                boolean r0 = r5.f20261q
                r1 = 1
                r0 = r0 ^ r1
                java.lang.String r2 = "Received headers on closed stream"
                com.google.common.base.Preconditions.checkState(r0, r2)
                z8.g2 r0 = r5.f20253i
                r0.a()
                y8.v0$g r0 = z8.q0.f20839g
                java.lang.Object r0 = r6.g(r0)
                java.lang.String r0 = (java.lang.String) r0
                boolean r2 = r5.f20256l
                r3 = 0
                if (r2 == 0) goto L4f
                if (r0 == 0) goto L4f
                java.lang.String r2 = "gzip"
                boolean r2 = r0.equalsIgnoreCase(r2)
                if (r2 == 0) goto L2f
                z8.r0 r0 = new z8.r0
                r0.<init>()
                r5.w(r0)
                r0 = 1
                goto L50
            L2f:
                java.lang.String r2 = "identity"
                boolean r2 = r0.equalsIgnoreCase(r2)
                if (r2 != 0) goto L4f
                y8.k1 r6 = y8.k1.f19903t
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r3] = r0
                java.lang.String r0 = "Can't find full stream decompressor for %s"
                java.lang.String r0 = java.lang.String.format(r0, r1)
                y8.k1 r6 = r6.r(r0)
                y8.m1 r6 = r6.d()
                r5.d(r6)
                return
            L4f:
                r0 = 0
            L50:
                y8.v0$g r2 = z8.q0.f20837e
                java.lang.Object r2 = r6.g(r2)
                java.lang.String r2 = (java.lang.String) r2
                if (r2 == 0) goto L93
                y8.v r4 = r5.f20257m
                y8.u r4 = r4.e(r2)
                if (r4 != 0) goto L7a
                y8.k1 r6 = y8.k1.f19903t
                java.lang.Object[] r0 = new java.lang.Object[r1]
                r0[r3] = r2
                java.lang.String r1 = "Can't find decompressor for %s"
                java.lang.String r0 = java.lang.String.format(r1, r0)
                y8.k1 r6 = r6.r(r0)
                y8.m1 r6 = r6.d()
                r5.d(r6)
                return
            L7a:
                y8.l r1 = y8.l.b.f19933a
                if (r4 == r1) goto L93
                if (r0 == 0) goto L90
                y8.k1 r6 = y8.k1.f19903t
                java.lang.String r0 = "Full stream and gRPC message encoding cannot both be set"
                y8.k1 r6 = r6.r(r0)
                y8.m1 r6 = r6.d()
                r5.d(r6)
                return
            L90:
                r5.v(r4)
            L93:
                z8.r r0 = r5.o()
                r0.b(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.a.c.E(y8.v0):void");
        }

        public void F(y8.v0 v0Var, y8.k1 k1Var) {
            Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            Preconditions.checkNotNull(v0Var, "trailers");
            if (this.f20261q) {
                a.f20241g.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{k1Var, v0Var});
            } else {
                this.f20253i.b(v0Var);
                N(k1Var, false, v0Var);
            }
        }

        public final boolean G() {
            return this.f20260p;
        }

        @Override // z8.d.a
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public final r o() {
            return this.f20255k;
        }

        public final void I(y8.v vVar) {
            Preconditions.checkState(this.f20255k == null, "Already called start");
            this.f20257m = (y8.v) Preconditions.checkNotNull(vVar, "decompressorRegistry");
        }

        public final void J(boolean z10) {
            this.f20256l = z10;
        }

        public final void K(r rVar) {
            Preconditions.checkState(this.f20255k == null, "Already called setListener");
            this.f20255k = (r) Preconditions.checkNotNull(rVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }

        public final void L() {
            this.f20260p = true;
        }

        public final void M(y8.k1 k1Var, r.a aVar, boolean z10, y8.v0 v0Var) {
            Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            Preconditions.checkNotNull(v0Var, "trailers");
            if (!this.f20261q || z10) {
                this.f20261q = true;
                this.f20262r = k1Var.p();
                s();
                if (this.f20258n) {
                    this.f20259o = null;
                    C(k1Var, aVar, v0Var);
                } else {
                    this.f20259o = new RunnableC0355a(k1Var, aVar, v0Var);
                    k(z10);
                }
            }
        }

        public final void N(y8.k1 k1Var, boolean z10, y8.v0 v0Var) {
            M(k1Var, r.a.PROCESSED, z10, v0Var);
        }

        public void e(boolean z10) {
            Preconditions.checkState(this.f20261q, "status should have been reported on deframer closed");
            this.f20258n = true;
            if (this.f20262r && z10) {
                N(y8.k1.f19903t.r("Encountered end-of-stream mid-frame"), true, new y8.v0());
            }
            Runnable runnable = this.f20259o;
            if (runnable != null) {
                runnable.run();
                this.f20259o = null;
            }
        }
    }

    public a(o2 o2Var, g2 g2Var, m2 m2Var, y8.v0 v0Var, y8.c cVar, boolean z10) {
        Preconditions.checkNotNull(v0Var, "headers");
        this.f20242a = (m2) Preconditions.checkNotNull(m2Var, "transportTracer");
        this.f20244c = q0.o(cVar);
        this.f20245d = z10;
        if (z10) {
            this.f20243b = new C0354a(v0Var, g2Var);
        } else {
            this.f20243b = new l1(this, o2Var, g2Var);
            this.f20246e = v0Var;
        }
    }

    @Override // z8.q
    public void c(int i10) {
        y().x(i10);
    }

    @Override // z8.q
    public void d(int i10) {
        this.f20243b.d(i10);
    }

    @Override // z8.q
    public final void e(y8.k1 k1Var) {
        Preconditions.checkArgument(!k1Var.p(), "Should not cancel with OK status");
        this.f20247f = true;
        u().e(k1Var);
    }

    @Override // z8.l1.d
    public final void f(n2 n2Var, boolean z10, boolean z11, int i10) {
        Preconditions.checkArgument(n2Var != null || z10, "null frame before EOS");
        u().g(n2Var, z10, z11, i10);
    }

    @Override // z8.q
    public final void g(r rVar) {
        y().K(rVar);
        if (this.f20245d) {
            return;
        }
        u().f(this.f20246e, null);
        this.f20246e = null;
    }

    @Override // z8.q
    public final void j(boolean z10) {
        y().J(z10);
    }

    @Override // z8.q
    public void k(y8.t tVar) {
        y8.v0 v0Var = this.f20246e;
        v0.g gVar = q0.f20836d;
        v0Var.e(gVar);
        this.f20246e.o(gVar, Long.valueOf(Math.max(0L, tVar.i(TimeUnit.NANOSECONDS))));
    }

    @Override // z8.q
    public final void l(y8.v vVar) {
        y().I(vVar);
    }

    @Override // z8.d, z8.h2
    public final boolean m() {
        return super.m() && !this.f20247f;
    }

    @Override // z8.q
    public final void o() {
        if (y().G()) {
            return;
        }
        y().L();
        q();
    }

    @Override // z8.q
    public final void p(w0 w0Var) {
        w0Var.b("remote_addr", getAttributes().b(y8.a0.f19776a));
    }

    @Override // z8.d
    public final o0 r() {
        return this.f20243b;
    }

    public abstract b u();

    public m2 w() {
        return this.f20242a;
    }

    public final boolean x() {
        return this.f20244c;
    }

    public abstract c y();
}
