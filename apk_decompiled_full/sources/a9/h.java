package a9;

import a9.q;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.List;
import okio.Buffer;
import y8.k1;
import y8.v0;
import y8.w0;
import z8.a;
import z8.g2;
import z8.m2;
import z8.n2;
import z8.r;
import z8.t0;

/* loaded from: classes3.dex */
public class h extends z8.a {

    /* renamed from: p, reason: collision with root package name */
    public static final Buffer f383p = new Buffer();

    /* renamed from: h, reason: collision with root package name */
    public final w0 f384h;

    /* renamed from: i, reason: collision with root package name */
    public final String f385i;

    /* renamed from: j, reason: collision with root package name */
    public final g2 f386j;

    /* renamed from: k, reason: collision with root package name */
    public String f387k;

    /* renamed from: l, reason: collision with root package name */
    public final b f388l;

    /* renamed from: m, reason: collision with root package name */
    public final a f389m;

    /* renamed from: n, reason: collision with root package name */
    public final y8.a f390n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f391o;

    public class a implements a.b {
        public a() {
        }

        @Override // z8.a.b
        public void e(k1 k1Var) {
            g9.c.f("OkHttpClientStream$Sink.cancel");
            try {
                synchronized (h.this.f388l.f394z) {
                    h.this.f388l.a0(k1Var, true, null);
                }
            } finally {
                g9.c.h("OkHttpClientStream$Sink.cancel");
            }
        }

        @Override // z8.a.b
        public void f(v0 v0Var, byte[] bArr) {
            g9.c.f("OkHttpClientStream$Sink.writeHeaders");
            String str = Operator.Operation.DIVISION + h.this.f384h.c();
            if (bArr != null) {
                h.this.f391o = true;
                str = str + Operator.Operation.EMPTY_PARAM + BaseEncoding.base64().encode(bArr);
            }
            try {
                synchronized (h.this.f388l.f394z) {
                    h.this.f388l.g0(v0Var, str);
                }
            } finally {
                g9.c.h("OkHttpClientStream$Sink.writeHeaders");
            }
        }

        @Override // z8.a.b
        public void g(n2 n2Var, boolean z10, boolean z11, int i10) {
            Buffer c10;
            g9.c.f("OkHttpClientStream$Sink.writeFrame");
            if (n2Var == null) {
                c10 = h.f383p;
            } else {
                c10 = ((o) n2Var).c();
                int size = (int) c10.size();
                if (size > 0) {
                    h.this.s(size);
                }
            }
            try {
                synchronized (h.this.f388l.f394z) {
                    h.this.f388l.e0(c10, z10, z11);
                    h.this.w().e(i10);
                }
            } finally {
                g9.c.h("OkHttpClientStream$Sink.writeFrame");
            }
        }
    }

    public class b extends t0 implements q.b {
        public List A;
        public Buffer B;
        public boolean C;
        public boolean D;
        public boolean E;
        public int F;
        public int G;
        public final a9.b H;
        public final q I;
        public final i J;
        public boolean K;
        public final g9.d L;
        public q.c M;
        public int N;

        /* renamed from: y, reason: collision with root package name */
        public final int f393y;

        /* renamed from: z, reason: collision with root package name */
        public final Object f394z;

        public b(int i10, g2 g2Var, Object obj, a9.b bVar, q qVar, i iVar, int i11, String str) {
            super(i10, g2Var, h.this.w());
            this.B = new Buffer();
            this.C = false;
            this.D = false;
            this.E = false;
            this.K = true;
            this.N = -1;
            this.f394z = Preconditions.checkNotNull(obj, "lock");
            this.H = bVar;
            this.I = qVar;
            this.J = iVar;
            this.F = i11;
            this.G = i11;
            this.f393y = i11;
            this.L = g9.c.a(str);
        }

        @Override // z8.t0
        public void P(k1 k1Var, boolean z10, v0 v0Var) {
            a0(k1Var, z10, v0Var);
        }

        public final void a0(k1 k1Var, boolean z10, v0 v0Var) {
            if (this.E) {
                return;
            }
            this.E = true;
            if (!this.K) {
                this.J.U(c0(), k1Var, r.a.PROCESSED, z10, c9.a.CANCEL, v0Var);
                return;
            }
            this.J.h0(h.this);
            this.A = null;
            this.B.clear();
            this.K = false;
            if (v0Var == null) {
                v0Var = new v0();
            }
            N(k1Var, true, v0Var);
        }

        public q.c b0() {
            q.c cVar;
            synchronized (this.f394z) {
                cVar = this.M;
            }
            return cVar;
        }

        @Override // z8.k1.b
        public void c(int i10) {
            int i11 = this.G - i10;
            this.G = i11;
            float f10 = i11;
            int i12 = this.f393y;
            if (f10 <= i12 * 0.5f) {
                int i13 = i12 - i11;
                this.F += i13;
                this.G = i11 + i13;
                this.H.windowUpdate(c0(), i13);
            }
        }

        public int c0() {
            return this.N;
        }

        @Override // z8.k1.b
        public void d(Throwable th) {
            P(k1.l(th), true, new v0());
        }

        public final void d0() {
            if (G()) {
                this.J.U(c0(), null, r.a.PROCESSED, false, null, null);
            } else {
                this.J.U(c0(), null, r.a.PROCESSED, false, c9.a.CANCEL, null);
            }
        }

        @Override // z8.t0, z8.a.c, z8.k1.b
        public void e(boolean z10) {
            d0();
            super.e(z10);
        }

        public final void e0(Buffer buffer, boolean z10, boolean z11) {
            if (this.E) {
                return;
            }
            if (!this.K) {
                Preconditions.checkState(c0() != -1, "streamId should be set");
                this.I.d(z10, this.M, buffer, z11);
            } else {
                this.B.write(buffer, (int) buffer.size());
                this.C |= z10;
                this.D |= z11;
            }
        }

        @Override // z8.g.d
        public void f(Runnable runnable) {
            synchronized (this.f394z) {
                runnable.run();
            }
        }

        public void f0(int i10) {
            Preconditions.checkState(this.N == -1, "the stream has been started with id %s", i10);
            this.N = i10;
            this.M = this.I.c(this, i10);
            h.this.f388l.r();
            if (this.K) {
                this.H.K(h.this.f391o, false, this.N, 0, this.A);
                h.this.f386j.c();
                this.A = null;
                if (this.B.size() > 0) {
                    this.I.d(this.C, this.M, this.B, this.D);
                }
                this.K = false;
            }
        }

        public final void g0(v0 v0Var, String str) {
            this.A = d.b(v0Var, str, h.this.f387k, h.this.f385i, h.this.f391o, this.J.b0());
            this.J.o0(h.this);
        }

        public g9.d h0() {
            return this.L;
        }

        public void i0(Buffer buffer, boolean z10) {
            int size = this.F - ((int) buffer.size());
            this.F = size;
            if (size >= 0) {
                super.S(new l(buffer), z10);
            } else {
                this.H.d(c0(), c9.a.FLOW_CONTROL_ERROR);
                this.J.U(c0(), k1.f19903t.r("Received data size exceeded our receiving window size"), r.a.PROCESSED, false, null, null);
            }
        }

        public void j0(List list, boolean z10) {
            if (z10) {
                U(r.c(list));
            } else {
                T(r.a(list));
            }
        }

        @Override // z8.d.a
        public void r() {
            super.r();
            m().c();
        }
    }

    public h(w0 w0Var, v0 v0Var, a9.b bVar, i iVar, q qVar, Object obj, int i10, int i11, String str, String str2, g2 g2Var, m2 m2Var, y8.c cVar, boolean z10) {
        super(new p(), g2Var, m2Var, v0Var, cVar, z10 && w0Var.f());
        this.f389m = new a();
        this.f391o = false;
        this.f386j = (g2) Preconditions.checkNotNull(g2Var, "statsTraceCtx");
        this.f384h = w0Var;
        this.f387k = str;
        this.f385i = str2;
        this.f390n = iVar.V();
        this.f388l = new b(i10, g2Var, obj, bVar, qVar, iVar, i11, w0Var.c());
    }

    public w0.d L() {
        return this.f384h.e();
    }

    @Override // z8.a
    /* renamed from: M, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public b y() {
        return this.f388l;
    }

    public boolean N() {
        return this.f391o;
    }

    @Override // z8.q
    public y8.a getAttributes() {
        return this.f390n;
    }

    @Override // z8.q
    public void n(String str) {
        this.f387k = (String) Preconditions.checkNotNull(str, "authority");
    }

    @Override // z8.a
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public a u() {
        return this.f389m;
    }
}
