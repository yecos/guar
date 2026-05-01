package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.lang.Thread;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import y8.a;
import y8.d0;
import y8.e0;
import y8.f;
import y8.g;
import y8.k;
import y8.o0;
import y8.o1;
import y8.y0;
import z8.i1;
import z8.j;
import z8.j1;
import z8.k;
import z8.m;
import z8.p;
import z8.x0;
import z8.x1;

/* loaded from: classes3.dex */
public final class f1 extends y8.r0 implements y8.h0 {

    /* renamed from: n0, reason: collision with root package name */
    public static final Logger f20462n0 = Logger.getLogger(f1.class.getName());

    /* renamed from: o0, reason: collision with root package name */
    public static final Pattern f20463o0 = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* renamed from: p0, reason: collision with root package name */
    public static final y8.k1 f20464p0;

    /* renamed from: q0, reason: collision with root package name */
    public static final y8.k1 f20465q0;

    /* renamed from: r0, reason: collision with root package name */
    public static final y8.k1 f20466r0;

    /* renamed from: s0, reason: collision with root package name */
    public static final i1 f20467s0;

    /* renamed from: t0, reason: collision with root package name */
    public static final y8.e0 f20468t0;

    /* renamed from: u0, reason: collision with root package name */
    public static final y8.g f20469u0;
    public final y8.d A;
    public final String B;
    public y8.y0 C;
    public boolean D;
    public n E;
    public volatile o0.i F;
    public boolean G;
    public final Set H;
    public Collection I;
    public final Object J;
    public final Set K;
    public final a0 L;
    public final t M;
    public final AtomicBoolean N;
    public boolean O;
    public boolean P;
    public volatile boolean Q;
    public final CountDownLatch R;
    public final m.b S;
    public final z8.m T;
    public final z8.o U;
    public final y8.f V;
    public final y8.c0 W;
    public final p X;
    public q Y;
    public i1 Z;

    /* renamed from: a, reason: collision with root package name */
    public final y8.i0 f20470a;

    /* renamed from: a0, reason: collision with root package name */
    public final i1 f20471a0;

    /* renamed from: b, reason: collision with root package name */
    public final String f20472b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f20473b0;

    /* renamed from: c, reason: collision with root package name */
    public final String f20474c;

    /* renamed from: c0, reason: collision with root package name */
    public final boolean f20475c0;

    /* renamed from: d, reason: collision with root package name */
    public final y8.a1 f20476d;

    /* renamed from: d0, reason: collision with root package name */
    public final x1.t f20477d0;

    /* renamed from: e, reason: collision with root package name */
    public final y0.c f20478e;

    /* renamed from: e0, reason: collision with root package name */
    public final long f20479e0;

    /* renamed from: f, reason: collision with root package name */
    public final y0.a f20480f;

    /* renamed from: f0, reason: collision with root package name */
    public final long f20481f0;

    /* renamed from: g, reason: collision with root package name */
    public final z8.j f20482g;

    /* renamed from: g0, reason: collision with root package name */
    public final boolean f20483g0;

    /* renamed from: h, reason: collision with root package name */
    public final z8.t f20484h;

    /* renamed from: h0, reason: collision with root package name */
    public final j1.a f20485h0;

    /* renamed from: i, reason: collision with root package name */
    public final z8.t f20486i;

    /* renamed from: i0, reason: collision with root package name */
    public final v0 f20487i0;

    /* renamed from: j, reason: collision with root package name */
    public final z8.t f20488j;

    /* renamed from: j0, reason: collision with root package name */
    public o1.d f20489j0;

    /* renamed from: k, reason: collision with root package name */
    public final r f20490k;

    /* renamed from: k0, reason: collision with root package name */
    public z8.k f20491k0;

    /* renamed from: l, reason: collision with root package name */
    public final Executor f20492l;

    /* renamed from: l0, reason: collision with root package name */
    public final p.e f20493l0;

    /* renamed from: m, reason: collision with root package name */
    public final o1 f20494m;

    /* renamed from: m0, reason: collision with root package name */
    public final w1 f20495m0;

    /* renamed from: n, reason: collision with root package name */
    public final o1 f20496n;

    /* renamed from: o, reason: collision with root package name */
    public final k f20497o;

    /* renamed from: p, reason: collision with root package name */
    public final k f20498p;

    /* renamed from: q, reason: collision with root package name */
    public final j2 f20499q;

    /* renamed from: r, reason: collision with root package name */
    public final int f20500r;

    /* renamed from: s, reason: collision with root package name */
    public final y8.o1 f20501s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f20502t;

    /* renamed from: u, reason: collision with root package name */
    public final y8.v f20503u;

    /* renamed from: v, reason: collision with root package name */
    public final y8.o f20504v;

    /* renamed from: w, reason: collision with root package name */
    public final Supplier f20505w;

    /* renamed from: x, reason: collision with root package name */
    public final long f20506x;

    /* renamed from: y, reason: collision with root package name */
    public final w f20507y;

    /* renamed from: z, reason: collision with root package name */
    public final k.a f20508z;

    public class a extends y8.e0 {
        @Override // y8.e0
        public e0.b a(o0.f fVar) {
            throw new IllegalStateException("Resolution is pending");
        }
    }

    public final class b implements m.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j2 f20509a;

        public b(j2 j2Var) {
            this.f20509a = j2Var;
        }

        @Override // z8.m.b
        public z8.m create() {
            return new z8.m(this.f20509a);
        }
    }

    public final class c extends o0.i {

        /* renamed from: a, reason: collision with root package name */
        public final o0.e f20511a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f20512b;

        public c(Throwable th) {
            this.f20512b = th;
            this.f20511a = o0.e.e(y8.k1.f19903t.r("Panic! This is a bug!").q(th));
        }

        @Override // y8.o0.i
        public o0.e a(o0.f fVar) {
            return this.f20511a;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) c.class).add("panicPickResult", this.f20511a).toString();
        }
    }

    public class d implements Thread.UncaughtExceptionHandler {
        public d() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            f1.f20462n0.log(Level.SEVERE, "[" + f1.this.d() + "] Uncaught exception in the SynchronizationContext. Panic!", th);
            f1.this.A0(th);
        }
    }

    public class e extends m0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f20515b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(y8.y0 y0Var, String str) {
            super(y0Var);
            this.f20515b = str;
        }

        @Override // y8.y0
        public String a() {
            return this.f20515b;
        }
    }

    public class f extends y8.g {
        @Override // y8.g
        public void a(String str, Throwable th) {
        }

        @Override // y8.g
        public void b() {
        }

        @Override // y8.g
        public void c(int i10) {
        }

        @Override // y8.g
        public void d(Object obj) {
        }

        @Override // y8.g
        public void e(g.a aVar, y8.v0 v0Var) {
        }
    }

    public final class g implements p.e {

        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f1.this.u0();
            }
        }

        public final class b extends x1 {
            public final /* synthetic */ y8.w0 E;
            public final /* synthetic */ y8.v0 F;
            public final /* synthetic */ y8.c G;
            public final /* synthetic */ y1 H;
            public final /* synthetic */ s0 I;
            public final /* synthetic */ x1.c0 J;
            public final /* synthetic */ y8.r K;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(y8.w0 w0Var, y8.v0 v0Var, y8.c cVar, y1 y1Var, s0 s0Var, x1.c0 c0Var, y8.r rVar) {
                super(w0Var, v0Var, f1.this.f20477d0, f1.this.f20479e0, f1.this.f20481f0, f1.this.v0(cVar), f1.this.f20486i.p(), y1Var, s0Var, c0Var);
                this.E = w0Var;
                this.F = v0Var;
                this.G = cVar;
                this.H = y1Var;
                this.I = s0Var;
                this.J = c0Var;
                this.K = rVar;
            }

            @Override // z8.x1
            public z8.q i0(y8.v0 v0Var, k.a aVar, int i10, boolean z10) {
                y8.c t10 = this.G.t(aVar);
                y8.k[] f10 = q0.f(t10, v0Var, i10, z10);
                z8.s c10 = g.this.c(new r1(this.E, v0Var, t10));
                y8.r b10 = this.K.b();
                try {
                    return c10.b(this.E, v0Var, t10, f10);
                } finally {
                    this.K.f(b10);
                }
            }

            @Override // z8.x1
            public void j0() {
                f1.this.M.c(this);
            }

            @Override // z8.x1
            public y8.k1 k0() {
                return f1.this.M.a(this);
            }
        }

        public g() {
        }

        @Override // z8.p.e
        public z8.q a(y8.w0 w0Var, y8.c cVar, y8.v0 v0Var, y8.r rVar) {
            if (f1.this.f20483g0) {
                x1.c0 g10 = f1.this.Z.g();
                i1.b bVar = (i1.b) cVar.h(i1.b.f20651g);
                return new b(w0Var, v0Var, cVar, bVar == null ? null : bVar.f20656e, bVar == null ? null : bVar.f20657f, g10, rVar);
            }
            z8.s c10 = c(new r1(w0Var, v0Var, cVar));
            y8.r b10 = rVar.b();
            try {
                return c10.b(w0Var, v0Var, cVar, q0.f(cVar, v0Var, 0, false));
            } finally {
                rVar.f(b10);
            }
        }

        public final z8.s c(o0.f fVar) {
            o0.i iVar = f1.this.F;
            if (f1.this.N.get()) {
                return f1.this.L;
            }
            if (iVar == null) {
                f1.this.f20501s.execute(new a());
                return f1.this.L;
            }
            z8.s j10 = q0.j(iVar.a(fVar), fVar.a().j());
            return j10 != null ? j10 : f1.this.L;
        }

        public /* synthetic */ g(f1 f1Var, a aVar) {
            this();
        }
    }

    public static final class h extends y8.y {

        /* renamed from: a, reason: collision with root package name */
        public final y8.e0 f20518a;

        /* renamed from: b, reason: collision with root package name */
        public final y8.d f20519b;

        /* renamed from: c, reason: collision with root package name */
        public final Executor f20520c;

        /* renamed from: d, reason: collision with root package name */
        public final y8.w0 f20521d;

        /* renamed from: e, reason: collision with root package name */
        public final y8.r f20522e;

        /* renamed from: f, reason: collision with root package name */
        public y8.c f20523f;

        /* renamed from: g, reason: collision with root package name */
        public y8.g f20524g;

        public class a extends x {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g.a f20525b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ y8.k1 f20526c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g.a aVar, y8.k1 k1Var) {
                super(h.this.f20522e);
                this.f20525b = aVar;
                this.f20526c = k1Var;
            }

            @Override // z8.x
            public void a() {
                this.f20525b.a(this.f20526c, new y8.v0());
            }
        }

        public h(y8.e0 e0Var, y8.d dVar, Executor executor, y8.w0 w0Var, y8.c cVar) {
            this.f20518a = e0Var;
            this.f20519b = dVar;
            this.f20521d = w0Var;
            executor = cVar.e() != null ? cVar.e() : executor;
            this.f20520c = executor;
            this.f20523f = cVar.p(executor);
            this.f20522e = y8.r.e();
        }

        @Override // y8.y, y8.b1, y8.g
        public void a(String str, Throwable th) {
            y8.g gVar = this.f20524g;
            if (gVar != null) {
                gVar.a(str, th);
            }
        }

        @Override // y8.y, y8.g
        public void e(g.a aVar, y8.v0 v0Var) {
            e0.b a10 = this.f20518a.a(new r1(this.f20521d, v0Var, this.f20523f));
            y8.k1 c10 = a10.c();
            if (!c10.p()) {
                h(aVar, q0.n(c10));
                this.f20524g = f1.f20469u0;
                return;
            }
            y8.h b10 = a10.b();
            i1.b f10 = ((i1) a10.a()).f(this.f20521d);
            if (f10 != null) {
                this.f20523f = this.f20523f.s(i1.b.f20651g, f10);
            }
            if (b10 != null) {
                this.f20524g = b10.a(this.f20521d, this.f20523f, this.f20519b);
            } else {
                this.f20524g = this.f20519b.h(this.f20521d, this.f20523f);
            }
            this.f20524g.e(aVar, v0Var);
        }

        @Override // y8.y, y8.b1
        public y8.g f() {
            return this.f20524g;
        }

        public final void h(g.a aVar, y8.k1 k1Var) {
            this.f20520c.execute(new a(aVar, k1Var));
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f1.this.f20489j0 = null;
            f1.this.C0();
        }
    }

    public final class j implements j1.a {
        public j() {
        }

        @Override // z8.j1.a
        public void a() {
        }

        @Override // z8.j1.a
        public void b(boolean z10) {
            f1 f1Var = f1.this;
            f1Var.f20487i0.e(f1Var.L, z10);
        }

        @Override // z8.j1.a
        public void c(y8.k1 k1Var) {
            Preconditions.checkState(f1.this.N.get(), "Channel must have been shut down");
        }

        @Override // z8.j1.a
        public void d() {
            Preconditions.checkState(f1.this.N.get(), "Channel must have been shut down");
            f1.this.P = true;
            f1.this.E0(false);
            f1.this.y0();
            f1.this.z0();
        }

        public /* synthetic */ j(f1 f1Var, a aVar) {
            this();
        }
    }

    public static final class k implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final o1 f20530a;

        /* renamed from: b, reason: collision with root package name */
        public Executor f20531b;

        public k(o1 o1Var) {
            this.f20530a = (o1) Preconditions.checkNotNull(o1Var, "executorPool");
        }

        public synchronized Executor a() {
            if (this.f20531b == null) {
                this.f20531b = (Executor) Preconditions.checkNotNull((Executor) this.f20530a.a(), "%s.getObject()", this.f20531b);
            }
            return this.f20531b;
        }

        public synchronized void b() {
            Executor executor = this.f20531b;
            if (executor != null) {
                this.f20531b = (Executor) this.f20530a.b(executor);
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a().execute(runnable);
        }
    }

    public final class l extends v0 {
        public l() {
        }

        @Override // z8.v0
        public void b() {
            f1.this.u0();
        }

        @Override // z8.v0
        public void c() {
            if (f1.this.N.get()) {
                return;
            }
            f1.this.D0();
        }

        public /* synthetic */ l(f1 f1Var, a aVar) {
            this();
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f1.this.E == null) {
                return;
            }
            f1.this.t0();
        }

        public /* synthetic */ m(f1 f1Var, a aVar) {
            this();
        }
    }

    public final class n extends o0.d {

        /* renamed from: a, reason: collision with root package name */
        public j.b f20534a;

        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f1.this.B0();
            }
        }

        public final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o0.i f20537a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y8.p f20538b;

            public b(o0.i iVar, y8.p pVar) {
                this.f20537a = iVar;
                this.f20538b = pVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                n nVar = n.this;
                if (nVar != f1.this.E) {
                    return;
                }
                f1.this.F0(this.f20537a);
                if (this.f20538b != y8.p.SHUTDOWN) {
                    f1.this.V.b(f.a.INFO, "Entering {0} state with picker: {1}", this.f20538b, this.f20537a);
                    f1.this.f20507y.a(this.f20538b);
                }
            }
        }

        public n() {
        }

        @Override // y8.o0.d
        public y8.f b() {
            return f1.this.V;
        }

        @Override // y8.o0.d
        public ScheduledExecutorService c() {
            return f1.this.f20490k;
        }

        @Override // y8.o0.d
        public y8.o1 d() {
            return f1.this.f20501s;
        }

        @Override // y8.o0.d
        public void e() {
            f1.this.f20501s.e();
            f1.this.f20501s.execute(new a());
        }

        @Override // y8.o0.d
        public void f(y8.p pVar, o0.i iVar) {
            f1.this.f20501s.e();
            Preconditions.checkNotNull(pVar, "newState");
            Preconditions.checkNotNull(iVar, "newPicker");
            f1.this.f20501s.execute(new b(iVar, pVar));
        }

        @Override // y8.o0.d
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public z8.e a(o0.b bVar) {
            f1.this.f20501s.e();
            Preconditions.checkState(!f1.this.P, "Channel is being terminated");
            return f1.this.new s(bVar, this);
        }

        public /* synthetic */ n(f1 f1Var, a aVar) {
            this();
        }
    }

    public final class o extends y0.d {

        /* renamed from: a, reason: collision with root package name */
        public final n f20540a;

        /* renamed from: b, reason: collision with root package name */
        public final y8.y0 f20541b;

        public final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y8.k1 f20543a;

            public a(y8.k1 k1Var) {
                this.f20543a = k1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.e(this.f20543a);
            }
        }

        public final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y0.e f20545a;

            public b(y0.e eVar) {
                this.f20545a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                i1 i1Var;
                if (f1.this.C != o.this.f20541b) {
                    return;
                }
                List a10 = this.f20545a.a();
                y8.f fVar = f1.this.V;
                f.a aVar = f.a.DEBUG;
                fVar.b(aVar, "Resolved address: {0}, config={1}", a10, this.f20545a.b());
                q qVar = f1.this.Y;
                q qVar2 = q.SUCCESS;
                if (qVar != qVar2) {
                    f1.this.V.b(f.a.INFO, "Address resolved: {0}", a10);
                    f1.this.Y = qVar2;
                }
                f1.this.f20491k0 = null;
                y0.b c10 = this.f20545a.c();
                y8.e0 e0Var = (y8.e0) this.f20545a.b().b(y8.e0.f19843a);
                i1 i1Var2 = (c10 == null || c10.c() == null) ? null : (i1) c10.c();
                y8.k1 d10 = c10 != null ? c10.d() : null;
                if (f1.this.f20475c0) {
                    if (i1Var2 != null) {
                        if (e0Var != null) {
                            f1.this.X.n(e0Var);
                            if (i1Var2.c() != null) {
                                f1.this.V.a(aVar, "Method configs in service config will be discarded due to presence ofconfig-selector");
                            }
                        } else {
                            f1.this.X.n(i1Var2.c());
                        }
                    } else if (f1.this.f20471a0 != null) {
                        i1Var2 = f1.this.f20471a0;
                        f1.this.X.n(i1Var2.c());
                        f1.this.V.a(f.a.INFO, "Received no service config, using default service config");
                    } else if (d10 == null) {
                        i1Var2 = f1.f20467s0;
                        f1.this.X.n(null);
                    } else {
                        if (!f1.this.f20473b0) {
                            f1.this.V.a(f.a.INFO, "Fallback to error due to invalid first service config without default config");
                            o.this.a(c10.d());
                            return;
                        }
                        i1Var2 = f1.this.Z;
                    }
                    if (!i1Var2.equals(f1.this.Z)) {
                        y8.f fVar2 = f1.this.V;
                        f.a aVar2 = f.a.INFO;
                        Object[] objArr = new Object[1];
                        objArr[0] = i1Var2 == f1.f20467s0 ? " to empty" : "";
                        fVar2.b(aVar2, "Service config changed{0}", objArr);
                        f1.this.Z = i1Var2;
                    }
                    try {
                        f1.this.f20473b0 = true;
                    } catch (RuntimeException e10) {
                        f1.f20462n0.log(Level.WARNING, "[" + f1.this.d() + "] Unexpected exception from parsing service config", (Throwable) e10);
                    }
                    i1Var = i1Var2;
                } else {
                    if (i1Var2 != null) {
                        f1.this.V.a(f.a.INFO, "Service config from name resolver discarded by channel settings");
                    }
                    i1Var = f1.this.f20471a0 == null ? f1.f20467s0 : f1.this.f20471a0;
                    if (e0Var != null) {
                        f1.this.V.a(f.a.INFO, "Config selector from name resolver discarded by channel settings");
                    }
                    f1.this.X.n(i1Var.c());
                }
                y8.a b10 = this.f20545a.b();
                o oVar = o.this;
                if (oVar.f20540a == f1.this.E) {
                    a.b c11 = b10.d().c(y8.e0.f19843a);
                    Map d11 = i1Var.d();
                    if (d11 != null) {
                        c11.d(y8.o0.f19951b, d11).a();
                    }
                    if (o.this.f20540a.f20534a.d(o0.g.d().b(a10).c(c11.a()).d(i1Var.e()).a())) {
                        return;
                    }
                    o.this.f();
                }
            }
        }

        public o(n nVar, y8.y0 y0Var) {
            this.f20540a = (n) Preconditions.checkNotNull(nVar, "helperImpl");
            this.f20541b = (y8.y0) Preconditions.checkNotNull(y0Var, "resolver");
        }

        @Override // y8.y0.d
        public void a(y8.k1 k1Var) {
            Preconditions.checkArgument(!k1Var.p(), "the error status must not be OK");
            f1.this.f20501s.execute(new a(k1Var));
        }

        @Override // y8.y0.d
        public void b(y0.e eVar) {
            f1.this.f20501s.execute(new b(eVar));
        }

        public final void e(y8.k1 k1Var) {
            f1.f20462n0.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{f1.this.d(), k1Var});
            f1.this.X.m();
            q qVar = f1.this.Y;
            q qVar2 = q.ERROR;
            if (qVar != qVar2) {
                f1.this.V.b(f.a.WARNING, "Failed to resolve name: {0}", k1Var);
                f1.this.Y = qVar2;
            }
            if (this.f20540a != f1.this.E) {
                return;
            }
            this.f20540a.f20534a.b(k1Var);
            f();
        }

        public final void f() {
            if (f1.this.f20489j0 == null || !f1.this.f20489j0.b()) {
                if (f1.this.f20491k0 == null) {
                    f1 f1Var = f1.this;
                    f1Var.f20491k0 = f1Var.f20508z.get();
                }
                long a10 = f1.this.f20491k0.a();
                f1.this.V.b(f.a.DEBUG, "Scheduling DNS resolution backoff for {0} ns", Long.valueOf(a10));
                f1 f1Var2 = f1.this;
                f1Var2.f20489j0 = f1Var2.f20501s.c(f1Var2.new i(), a10, TimeUnit.NANOSECONDS, f1.this.f20486i.p());
            }
        }
    }

    public class p extends y8.d {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReference f20547a;

        /* renamed from: b, reason: collision with root package name */
        public final String f20548b;

        /* renamed from: c, reason: collision with root package name */
        public final y8.d f20549c;

        public class a extends y8.d {
            public a() {
            }

            @Override // y8.d
            public String a() {
                return p.this.f20548b;
            }

            @Override // y8.d
            public y8.g h(y8.w0 w0Var, y8.c cVar) {
                return new z8.p(w0Var, f1.this.v0(cVar), cVar, f1.this.f20493l0, f1.this.Q ? null : f1.this.f20486i.p(), f1.this.T, null).C(f1.this.f20502t).B(f1.this.f20503u).A(f1.this.f20504v);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f1.this.u0();
            }
        }

        public class c extends y8.g {
            public c() {
            }

            @Override // y8.g
            public void a(String str, Throwable th) {
            }

            @Override // y8.g
            public void b() {
            }

            @Override // y8.g
            public void c(int i10) {
            }

            @Override // y8.g
            public void d(Object obj) {
            }

            @Override // y8.g
            public void e(g.a aVar, y8.v0 v0Var) {
                aVar.a(f1.f20465q0, new y8.v0());
            }
        }

        public class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f20554a;

            public d(e eVar) {
                this.f20554a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (p.this.f20547a.get() != f1.f20468t0) {
                    this.f20554a.r();
                    return;
                }
                if (f1.this.I == null) {
                    f1.this.I = new LinkedHashSet();
                    f1 f1Var = f1.this;
                    f1Var.f20487i0.e(f1Var.J, true);
                }
                f1.this.I.add(this.f20554a);
            }
        }

        public final class e extends z {

            /* renamed from: l, reason: collision with root package name */
            public final y8.r f20556l;

            /* renamed from: m, reason: collision with root package name */
            public final y8.w0 f20557m;

            /* renamed from: n, reason: collision with root package name */
            public final y8.c f20558n;

            public class a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Runnable f20560a;

                public a(Runnable runnable) {
                    this.f20560a = runnable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f20560a.run();
                    e eVar = e.this;
                    f1.this.f20501s.execute(eVar.new b());
                }
            }

            public final class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (f1.this.I != null) {
                        f1.this.I.remove(e.this);
                        if (f1.this.I.isEmpty()) {
                            f1 f1Var = f1.this;
                            f1Var.f20487i0.e(f1Var.J, false);
                            f1.this.I = null;
                            if (f1.this.N.get()) {
                                f1.this.M.b(f1.f20465q0);
                            }
                        }
                    }
                }
            }

            public e(y8.r rVar, y8.w0 w0Var, y8.c cVar) {
                super(f1.this.v0(cVar), f1.this.f20490k, cVar.d());
                this.f20556l = rVar;
                this.f20557m = w0Var;
                this.f20558n = cVar;
            }

            @Override // z8.z
            public void j() {
                super.j();
                f1.this.f20501s.execute(new b());
            }

            public void r() {
                y8.r b10 = this.f20556l.b();
                try {
                    y8.g l10 = p.this.l(this.f20557m, this.f20558n);
                    this.f20556l.f(b10);
                    Runnable p10 = p(l10);
                    if (p10 == null) {
                        f1.this.f20501s.execute(new b());
                    } else {
                        f1.this.v0(this.f20558n).execute(new a(p10));
                    }
                } catch (Throwable th) {
                    this.f20556l.f(b10);
                    throw th;
                }
            }
        }

        public /* synthetic */ p(f1 f1Var, String str, a aVar) {
            this(str);
        }

        @Override // y8.d
        public String a() {
            return this.f20548b;
        }

        @Override // y8.d
        public y8.g h(y8.w0 w0Var, y8.c cVar) {
            if (this.f20547a.get() != f1.f20468t0) {
                return l(w0Var, cVar);
            }
            f1.this.f20501s.execute(new b());
            if (this.f20547a.get() != f1.f20468t0) {
                return l(w0Var, cVar);
            }
            if (f1.this.N.get()) {
                return new c();
            }
            e eVar = new e(y8.r.e(), w0Var, cVar);
            f1.this.f20501s.execute(new d(eVar));
            return eVar;
        }

        public final y8.g l(y8.w0 w0Var, y8.c cVar) {
            y8.e0 e0Var = (y8.e0) this.f20547a.get();
            if (e0Var == null) {
                return this.f20549c.h(w0Var, cVar);
            }
            if (!(e0Var instanceof i1.c)) {
                return new h(e0Var, this.f20549c, f1.this.f20492l, w0Var, cVar);
            }
            i1.b f10 = ((i1.c) e0Var).f20658b.f(w0Var);
            if (f10 != null) {
                cVar = cVar.s(i1.b.f20651g, f10);
            }
            return this.f20549c.h(w0Var, cVar);
        }

        public void m() {
            if (this.f20547a.get() == f1.f20468t0) {
                n(null);
            }
        }

        public void n(y8.e0 e0Var) {
            y8.e0 e0Var2 = (y8.e0) this.f20547a.get();
            this.f20547a.set(e0Var);
            if (e0Var2 != f1.f20468t0 || f1.this.I == null) {
                return;
            }
            Iterator it = f1.this.I.iterator();
            while (it.hasNext()) {
                ((e) it.next()).r();
            }
        }

        public p(String str) {
            this.f20547a = new AtomicReference(f1.f20468t0);
            this.f20549c = new a();
            this.f20548b = (String) Preconditions.checkNotNull(str, "authority");
        }
    }

    public enum q {
        NO_RESOLUTION,
        SUCCESS,
        ERROR
    }

    public static final class r implements ScheduledExecutorService {

        /* renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f20567a;

        public /* synthetic */ r(ScheduledExecutorService scheduledExecutorService, a aVar) {
            this(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j10, TimeUnit timeUnit) {
            return this.f20567a.awaitTermination(j10, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f20567a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public List invokeAll(Collection collection) {
            return this.f20567a.invokeAll(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public Object invokeAny(Collection collection) {
            return this.f20567a.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.f20567a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.f20567a.isTerminated();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture schedule(Callable callable, long j10, TimeUnit timeUnit) {
            return this.f20567a.schedule(callable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.f20567a.scheduleAtFixedRate(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.f20567a.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public List shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Callable callable) {
            return this.f20567a.submit(callable);
        }

        public r(ScheduledExecutorService scheduledExecutorService) {
            this.f20567a = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "delegate");
        }

        @Override // java.util.concurrent.ExecutorService
        public List invokeAll(Collection collection, long j10, TimeUnit timeUnit) {
            return this.f20567a.invokeAll(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public Object invokeAny(Collection collection, long j10, TimeUnit timeUnit) {
            return this.f20567a.invokeAny(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f20567a.schedule(runnable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Runnable runnable) {
            return this.f20567a.submit(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Runnable runnable, Object obj) {
            return this.f20567a.submit(runnable, obj);
        }
    }

    public final class s extends z8.e {

        /* renamed from: a, reason: collision with root package name */
        public final o0.b f20568a;

        /* renamed from: b, reason: collision with root package name */
        public final n f20569b;

        /* renamed from: c, reason: collision with root package name */
        public final y8.i0 f20570c;

        /* renamed from: d, reason: collision with root package name */
        public final z8.n f20571d;

        /* renamed from: e, reason: collision with root package name */
        public final z8.o f20572e;

        /* renamed from: f, reason: collision with root package name */
        public List f20573f;

        /* renamed from: g, reason: collision with root package name */
        public x0 f20574g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f20575h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f20576i;

        /* renamed from: j, reason: collision with root package name */
        public o1.d f20577j;

        public final class a extends x0.j {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o0.j f20579a;

            public a(o0.j jVar) {
                this.f20579a = jVar;
            }

            @Override // z8.x0.j
            public void a(x0 x0Var) {
                f1.this.f20487i0.e(x0Var, true);
            }

            @Override // z8.x0.j
            public void b(x0 x0Var) {
                f1.this.f20487i0.e(x0Var, false);
            }

            @Override // z8.x0.j
            public void c(x0 x0Var, y8.q qVar) {
                Preconditions.checkState(this.f20579a != null, "listener is null");
                this.f20579a.a(qVar);
            }

            @Override // z8.x0.j
            public void d(x0 x0Var) {
                f1.this.H.remove(x0Var);
                f1.this.W.k(x0Var);
                f1.this.z0();
            }
        }

        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                s.this.f20574g.c(f1.f20466r0);
            }
        }

        public s(o0.b bVar, n nVar) {
            Preconditions.checkNotNull(bVar, "args");
            this.f20573f = bVar.a();
            if (f1.this.f20474c != null) {
                bVar = bVar.d().d(i(bVar.a())).b();
            }
            this.f20568a = bVar;
            this.f20569b = (n) Preconditions.checkNotNull(nVar, "helper");
            y8.i0 b10 = y8.i0.b("Subchannel", f1.this.a());
            this.f20570c = b10;
            z8.o oVar = new z8.o(b10, f1.this.f20500r, f1.this.f20499q.a(), "Subchannel for " + bVar.a());
            this.f20572e = oVar;
            this.f20571d = new z8.n(oVar, f1.this.f20499q);
        }

        @Override // y8.o0.h
        public List b() {
            f1.this.f20501s.e();
            Preconditions.checkState(this.f20575h, "not started");
            return this.f20573f;
        }

        @Override // y8.o0.h
        public y8.a c() {
            return this.f20568a.b();
        }

        @Override // y8.o0.h
        public Object d() {
            Preconditions.checkState(this.f20575h, "Subchannel is not started");
            return this.f20574g;
        }

        @Override // y8.o0.h
        public void e() {
            f1.this.f20501s.e();
            Preconditions.checkState(this.f20575h, "not started");
            this.f20574g.a();
        }

        @Override // y8.o0.h
        public void f() {
            o1.d dVar;
            f1.this.f20501s.e();
            if (this.f20574g == null) {
                this.f20576i = true;
                return;
            }
            if (!this.f20576i) {
                this.f20576i = true;
            } else {
                if (!f1.this.P || (dVar = this.f20577j) == null) {
                    return;
                }
                dVar.a();
                this.f20577j = null;
            }
            if (f1.this.P) {
                this.f20574g.c(f1.f20465q0);
            } else {
                this.f20577j = f1.this.f20501s.c(new c1(new b()), 5L, TimeUnit.SECONDS, f1.this.f20486i.p());
            }
        }

        @Override // y8.o0.h
        public void g(o0.j jVar) {
            f1.this.f20501s.e();
            Preconditions.checkState(!this.f20575h, "already started");
            Preconditions.checkState(!this.f20576i, "already shutdown");
            Preconditions.checkState(!f1.this.P, "Channel is being terminated");
            this.f20575h = true;
            x0 x0Var = new x0(this.f20568a.a(), f1.this.a(), f1.this.B, f1.this.f20508z, f1.this.f20486i, f1.this.f20486i.p(), f1.this.f20505w, f1.this.f20501s, new a(jVar), f1.this.W, f1.this.S.create(), this.f20572e, this.f20570c, this.f20571d);
            f1.this.U.e(new d0.a().b("Child Subchannel started").c(d0.b.CT_INFO).e(f1.this.f20499q.a()).d(x0Var).a());
            this.f20574g = x0Var;
            f1.this.W.e(x0Var);
            f1.this.H.add(x0Var);
        }

        @Override // y8.o0.h
        public void h(List list) {
            f1.this.f20501s.e();
            this.f20573f = list;
            if (f1.this.f20474c != null) {
                list = i(list);
            }
            this.f20574g.T(list);
        }

        public final List i(List list) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                y8.x xVar = (y8.x) it.next();
                arrayList.add(new y8.x(xVar.a(), xVar.b().d().c(y8.x.f20066d).a()));
            }
            return Collections.unmodifiableList(arrayList);
        }

        public String toString() {
            return this.f20570c.toString();
        }
    }

    static {
        y8.k1 k1Var = y8.k1.f19904u;
        f20464p0 = k1Var.r("Channel shutdownNow invoked");
        f20465q0 = k1Var.r("Channel shutdown invoked");
        f20466r0 = k1Var.r("Subchannel shutdown invoked");
        f20467s0 = i1.a();
        f20468t0 = new a();
        f20469u0 = new f();
    }

    public f1(g1 g1Var, z8.t tVar, k.a aVar, o1 o1Var, Supplier supplier, List list, j2 j2Var) {
        a aVar2;
        y8.o1 o1Var2 = new y8.o1(new d());
        this.f20501s = o1Var2;
        this.f20507y = new w();
        this.H = new HashSet(16, 0.75f);
        this.J = new Object();
        this.K = new HashSet(1, 0.75f);
        a aVar3 = null;
        this.M = new t(this, aVar3);
        this.N = new AtomicBoolean(false);
        this.R = new CountDownLatch(1);
        this.Y = q.NO_RESOLUTION;
        this.Z = f20467s0;
        this.f20473b0 = false;
        this.f20477d0 = new x1.t();
        j jVar = new j(this, aVar3);
        this.f20485h0 = jVar;
        this.f20487i0 = new l(this, aVar3);
        this.f20493l0 = new g(this, aVar3);
        String str = (String) Preconditions.checkNotNull(g1Var.f20604f, "target");
        this.f20472b = str;
        y8.i0 b10 = y8.i0.b("Channel", str);
        this.f20470a = b10;
        this.f20499q = (j2) Preconditions.checkNotNull(j2Var, "timeProvider");
        o1 o1Var3 = (o1) Preconditions.checkNotNull(g1Var.f20599a, "executorPool");
        this.f20494m = o1Var3;
        Executor executor = (Executor) Preconditions.checkNotNull((Executor) o1Var3.a(), "executor");
        this.f20492l = executor;
        this.f20484h = tVar;
        k kVar = new k((o1) Preconditions.checkNotNull(g1Var.f20600b, "offloadExecutorPool"));
        this.f20498p = kVar;
        z8.l lVar = new z8.l(tVar, g1Var.f20605g, kVar);
        this.f20486i = lVar;
        this.f20488j = new z8.l(tVar, null, kVar);
        r rVar = new r(lVar.p(), aVar3);
        this.f20490k = rVar;
        this.f20500r = g1Var.f20620v;
        z8.o oVar = new z8.o(b10, g1Var.f20620v, j2Var.a(), "Channel for '" + str + "'");
        this.U = oVar;
        z8.n nVar = new z8.n(oVar, j2Var);
        this.V = nVar;
        y8.d1 d1Var = g1Var.f20623y;
        d1Var = d1Var == null ? q0.f20849q : d1Var;
        boolean z10 = g1Var.f20618t;
        this.f20483g0 = z10;
        z8.j jVar2 = new z8.j(g1Var.f20609k);
        this.f20482g = jVar2;
        this.f20476d = g1Var.f20602d;
        z1 z1Var = new z1(z10, g1Var.f20614p, g1Var.f20615q, jVar2);
        String str2 = g1Var.f20608j;
        this.f20474c = str2;
        y0.a a10 = y0.a.f().c(g1Var.c()).f(d1Var).i(o1Var2).g(rVar).h(z1Var).b(nVar).d(kVar).e(str2).a();
        this.f20480f = a10;
        y0.c cVar = g1Var.f20603e;
        this.f20478e = cVar;
        this.C = w0(str, str2, cVar, a10);
        this.f20496n = (o1) Preconditions.checkNotNull(o1Var, "balancerRpcExecutorPool");
        this.f20497o = new k(o1Var);
        a0 a0Var = new a0(executor, o1Var2);
        this.L = a0Var;
        a0Var.e(jVar);
        this.f20508z = aVar;
        Map map = g1Var.f20621w;
        if (map != null) {
            y0.b a11 = z1Var.a(map);
            Preconditions.checkState(a11.d() == null, "Default config is invalid: %s", a11.d());
            i1 i1Var = (i1) a11.c();
            this.f20471a0 = i1Var;
            this.Z = i1Var;
            aVar2 = null;
        } else {
            aVar2 = null;
            this.f20471a0 = null;
        }
        boolean z11 = g1Var.f20622x;
        this.f20475c0 = z11;
        p pVar = new p(this, this.C.a(), aVar2);
        this.X = pVar;
        this.A = y8.j.a(pVar, list);
        this.f20505w = (Supplier) Preconditions.checkNotNull(supplier, "stopwatchSupplier");
        long j10 = g1Var.f20613o;
        if (j10 == -1) {
            this.f20506x = j10;
        } else {
            Preconditions.checkArgument(j10 >= g1.J, "invalid idleTimeoutMillis %s", j10);
            this.f20506x = g1Var.f20613o;
        }
        this.f20495m0 = new w1(new m(this, null), o1Var2, lVar.p(), (Stopwatch) supplier.get());
        this.f20502t = g1Var.f20610l;
        this.f20503u = (y8.v) Preconditions.checkNotNull(g1Var.f20611m, "decompressorRegistry");
        this.f20504v = (y8.o) Preconditions.checkNotNull(g1Var.f20612n, "compressorRegistry");
        this.B = g1Var.f20607i;
        this.f20481f0 = g1Var.f20616r;
        this.f20479e0 = g1Var.f20617s;
        b bVar = new b(j2Var);
        this.S = bVar;
        this.T = bVar.create();
        y8.c0 c0Var = (y8.c0) Preconditions.checkNotNull(g1Var.f20619u);
        this.W = c0Var;
        c0Var.d(this);
        if (z11) {
            return;
        }
        if (this.f20471a0 != null) {
            nVar.a(f.a.INFO, "Service config look-up disabled, using default service config");
        }
        this.f20473b0 = true;
    }

    public static y8.y0 w0(String str, String str2, y0.c cVar, y0.a aVar) {
        y8.y0 x02 = x0(str, cVar, aVar);
        return str2 == null ? x02 : new e(x02, str2);
    }

    public static y8.y0 x0(String str, y0.c cVar, y0.a aVar) {
        URI uri;
        y8.y0 b10;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e10) {
            sb.append(e10.getMessage());
            uri = null;
        }
        if (uri != null && (b10 = cVar.b(uri, aVar)) != null) {
            return b10;
        }
        String str2 = "";
        if (!f20463o0.matcher(str).matches()) {
            try {
                y8.y0 b11 = cVar.b(new URI(cVar.a(), "", Operator.Operation.DIVISION + str, null), aVar);
                if (b11 != null) {
                    return b11;
                }
            } catch (URISyntaxException e11) {
                throw new IllegalArgumentException(e11);
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (sb.length() > 0) {
            str2 = " (" + ((Object) sb) + ")";
        }
        objArr[1] = str2;
        throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", objArr));
    }

    public void A0(Throwable th) {
        if (this.G) {
            return;
        }
        this.G = true;
        r0(true);
        E0(false);
        F0(new c(th));
        this.X.n(null);
        this.V.a(f.a.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        this.f20507y.a(y8.p.TRANSIENT_FAILURE);
    }

    public final void B0() {
        this.f20501s.e();
        s0();
        C0();
    }

    public final void C0() {
        this.f20501s.e();
        if (this.D) {
            this.C.b();
        }
    }

    public final void D0() {
        long j10 = this.f20506x;
        if (j10 == -1) {
            return;
        }
        this.f20495m0.k(j10, TimeUnit.MILLISECONDS);
    }

    public final void E0(boolean z10) {
        this.f20501s.e();
        if (z10) {
            Preconditions.checkState(this.D, "nameResolver is not started");
            Preconditions.checkState(this.E != null, "lbHelper is null");
        }
        if (this.C != null) {
            s0();
            this.C.c();
            this.D = false;
            if (z10) {
                this.C = w0(this.f20472b, this.f20474c, this.f20478e, this.f20480f);
            } else {
                this.C = null;
            }
        }
        n nVar = this.E;
        if (nVar != null) {
            nVar.f20534a.c();
            this.E = null;
        }
        this.F = null;
    }

    public final void F0(o0.i iVar) {
        this.F = iVar;
        this.L.r(iVar);
    }

    @Override // y8.d
    public String a() {
        return this.A.a();
    }

    @Override // y8.m0
    public y8.i0 d() {
        return this.f20470a;
    }

    @Override // y8.d
    public y8.g h(y8.w0 w0Var, y8.c cVar) {
        return this.A.h(w0Var, cVar);
    }

    public final void r0(boolean z10) {
        this.f20495m0.i(z10);
    }

    public final void s0() {
        this.f20501s.e();
        o1.d dVar = this.f20489j0;
        if (dVar != null) {
            dVar.a();
            this.f20489j0 = null;
            this.f20491k0 = null;
        }
    }

    public final void t0() {
        E0(true);
        this.L.r(null);
        this.V.a(f.a.INFO, "Entering IDLE state");
        this.f20507y.a(y8.p.IDLE);
        if (this.f20487i0.a(this.J, this.L)) {
            u0();
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.f20470a.d()).add("target", this.f20472b).toString();
    }

    public void u0() {
        this.f20501s.e();
        if (this.N.get() || this.G) {
            return;
        }
        if (this.f20487i0.d()) {
            r0(false);
        } else {
            D0();
        }
        if (this.E != null) {
            return;
        }
        this.V.a(f.a.INFO, "Exiting idle mode");
        n nVar = new n(this, null);
        nVar.f20534a = this.f20482g.e(nVar);
        this.E = nVar;
        this.C.d(new o(nVar, this.C));
        this.D = true;
    }

    public final Executor v0(y8.c cVar) {
        Executor e10 = cVar.e();
        return e10 == null ? this.f20492l : e10;
    }

    public final void y0() {
        if (this.O) {
            Iterator it = this.H.iterator();
            while (it.hasNext()) {
                ((x0) it.next()).g(f20464p0);
            }
            Iterator it2 = this.K.iterator();
            if (it2.hasNext()) {
                androidx.appcompat.app.m.a(it2.next());
                throw null;
            }
        }
    }

    public final void z0() {
        if (!this.Q && this.N.get() && this.H.isEmpty() && this.K.isEmpty()) {
            this.V.a(f.a.INFO, "Terminated");
            this.W.j(this);
            this.f20494m.b(this.f20492l);
            this.f20497o.b();
            this.f20498p.b();
            this.f20486i.close();
            this.Q = true;
            this.R.countDown();
        }
    }

    public final class t {

        /* renamed from: a, reason: collision with root package name */
        public final Object f20582a;

        /* renamed from: b, reason: collision with root package name */
        public Collection f20583b;

        /* renamed from: c, reason: collision with root package name */
        public y8.k1 f20584c;

        public t() {
            this.f20582a = new Object();
            this.f20583b = new HashSet();
        }

        public y8.k1 a(x1 x1Var) {
            synchronized (this.f20582a) {
                y8.k1 k1Var = this.f20584c;
                if (k1Var != null) {
                    return k1Var;
                }
                this.f20583b.add(x1Var);
                return null;
            }
        }

        public void b(y8.k1 k1Var) {
            synchronized (this.f20582a) {
                if (this.f20584c != null) {
                    return;
                }
                this.f20584c = k1Var;
                boolean isEmpty = this.f20583b.isEmpty();
                if (isEmpty) {
                    f1.this.L.c(k1Var);
                }
            }
        }

        public void c(x1 x1Var) {
            y8.k1 k1Var;
            synchronized (this.f20582a) {
                this.f20583b.remove(x1Var);
                if (this.f20583b.isEmpty()) {
                    k1Var = this.f20584c;
                    this.f20583b = new HashSet();
                } else {
                    k1Var = null;
                }
            }
            if (k1Var != null) {
                f1.this.L.c(k1Var);
            }
        }

        public /* synthetic */ t(f1 f1Var, a aVar) {
            this();
        }
    }
}
