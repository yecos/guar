package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import y8.f;
import y8.o1;
import z8.j1;
import z8.k;
import z8.r;
import z8.t;

/* loaded from: classes3.dex */
public final class x0 implements y8.h0, l2 {

    /* renamed from: a, reason: collision with root package name */
    public final y8.i0 f20979a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20980b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20981c;

    /* renamed from: d, reason: collision with root package name */
    public final k.a f20982d;

    /* renamed from: e, reason: collision with root package name */
    public final j f20983e;

    /* renamed from: f, reason: collision with root package name */
    public final t f20984f;

    /* renamed from: g, reason: collision with root package name */
    public final ScheduledExecutorService f20985g;

    /* renamed from: h, reason: collision with root package name */
    public final y8.c0 f20986h;

    /* renamed from: i, reason: collision with root package name */
    public final z8.m f20987i;

    /* renamed from: j, reason: collision with root package name */
    public final o f20988j;

    /* renamed from: k, reason: collision with root package name */
    public final y8.f f20989k;

    /* renamed from: l, reason: collision with root package name */
    public final y8.o1 f20990l;

    /* renamed from: m, reason: collision with root package name */
    public final k f20991m;

    /* renamed from: n, reason: collision with root package name */
    public volatile List f20992n;

    /* renamed from: o, reason: collision with root package name */
    public z8.k f20993o;

    /* renamed from: p, reason: collision with root package name */
    public final Stopwatch f20994p;

    /* renamed from: q, reason: collision with root package name */
    public o1.d f20995q;

    /* renamed from: r, reason: collision with root package name */
    public o1.d f20996r;

    /* renamed from: s, reason: collision with root package name */
    public j1 f20997s;

    /* renamed from: v, reason: collision with root package name */
    public v f21000v;

    /* renamed from: w, reason: collision with root package name */
    public volatile j1 f21001w;

    /* renamed from: y, reason: collision with root package name */
    public y8.k1 f21003y;

    /* renamed from: t, reason: collision with root package name */
    public final Collection f20998t = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    public final v0 f20999u = new a();

    /* renamed from: x, reason: collision with root package name */
    public volatile y8.q f21002x = y8.q.a(y8.p.IDLE);

    public class a extends v0 {
        public a() {
        }

        @Override // z8.v0
        public void b() {
            x0.this.f20983e.a(x0.this);
        }

        @Override // z8.v0
        public void c() {
            x0.this.f20983e.b(x0.this);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x0.this.f20995q = null;
            x0.this.f20989k.a(f.a.INFO, "CONNECTING after backoff");
            x0.this.M(y8.p.CONNECTING);
            x0.this.S();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x0.this.f21002x.c() == y8.p.IDLE) {
                x0.this.f20989k.a(f.a.INFO, "CONNECTING as requested");
                x0.this.M(y8.p.CONNECTING);
                x0.this.S();
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f21007a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j1 j1Var = x0.this.f20997s;
                x0.this.f20996r = null;
                x0.this.f20997s = null;
                j1Var.c(y8.k1.f19904u.r("InternalSubchannel closed transport due to address change"));
            }
        }

        public d(List list) {
            this.f21007a = list;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0094  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            j1 j1Var;
            SocketAddress a10 = x0.this.f20991m.a();
            x0.this.f20991m.h(this.f21007a);
            x0.this.f20992n = this.f21007a;
            y8.p c10 = x0.this.f21002x.c();
            y8.p pVar = y8.p.READY;
            if ((c10 == pVar || x0.this.f21002x.c() == y8.p.CONNECTING) && !x0.this.f20991m.g(a10)) {
                if (x0.this.f21002x.c() == pVar) {
                    j1Var = x0.this.f21001w;
                    x0.this.f21001w = null;
                    x0.this.f20991m.f();
                    x0.this.M(y8.p.IDLE);
                    if (j1Var == null) {
                        if (x0.this.f20996r != null) {
                            x0.this.f20997s.c(y8.k1.f19904u.r("InternalSubchannel closed transport early due to address change"));
                            x0.this.f20996r.a();
                            x0.this.f20996r = null;
                            x0.this.f20997s = null;
                        }
                        x0.this.f20997s = j1Var;
                        x0 x0Var = x0.this;
                        x0Var.f20996r = x0Var.f20990l.c(new a(), 5L, TimeUnit.SECONDS, x0.this.f20985g);
                        return;
                    }
                    return;
                }
                x0.this.f21000v.c(y8.k1.f19904u.r("InternalSubchannel closed pending transport due to address change"));
                x0.this.f21000v = null;
                x0.this.f20991m.f();
                x0.this.S();
            }
            j1Var = null;
            if (j1Var == null) {
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.k1 f21010a;

        public e(y8.k1 k1Var) {
            this.f21010a = k1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            y8.p c10 = x0.this.f21002x.c();
            y8.p pVar = y8.p.SHUTDOWN;
            if (c10 == pVar) {
                return;
            }
            x0.this.f21003y = this.f21010a;
            j1 j1Var = x0.this.f21001w;
            v vVar = x0.this.f21000v;
            x0.this.f21001w = null;
            x0.this.f21000v = null;
            x0.this.M(pVar);
            x0.this.f20991m.f();
            if (x0.this.f20998t.isEmpty()) {
                x0.this.O();
            }
            x0.this.K();
            if (x0.this.f20996r != null) {
                x0.this.f20996r.a();
                x0.this.f20997s.c(this.f21010a);
                x0.this.f20996r = null;
                x0.this.f20997s = null;
            }
            if (j1Var != null) {
                j1Var.c(this.f21010a);
            }
            if (vVar != null) {
                vVar.c(this.f21010a);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x0.this.f20989k.a(f.a.INFO, "Terminated");
            x0.this.f20983e.d(x0.this);
        }
    }

    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f21013a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f21014b;

        public g(v vVar, boolean z10) {
            this.f21013a = vVar;
            this.f21014b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            x0.this.f20999u.e(this.f21013a, this.f21014b);
        }
    }

    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.k1 f21016a;

        public h(y8.k1 k1Var) {
            this.f21016a = k1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(x0.this.f20998t).iterator();
            while (it.hasNext()) {
                ((j1) it.next()).g(this.f21016a);
            }
        }
    }

    public static final class i extends j0 {

        /* renamed from: a, reason: collision with root package name */
        public final v f21018a;

        /* renamed from: b, reason: collision with root package name */
        public final z8.m f21019b;

        public class a extends h0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q f21020a;

            /* renamed from: z8.x0$i$a$a, reason: collision with other inner class name */
            public class C0360a extends i0 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ r f21022a;

                public C0360a(r rVar) {
                    this.f21022a = rVar;
                }

                @Override // z8.i0, z8.r
                public void c(y8.k1 k1Var, r.a aVar, y8.v0 v0Var) {
                    i.this.f21019b.a(k1Var.p());
                    super.c(k1Var, aVar, v0Var);
                }

                @Override // z8.i0
                public r e() {
                    return this.f21022a;
                }
            }

            public a(q qVar) {
                this.f21020a = qVar;
            }

            @Override // z8.h0
            public q f() {
                return this.f21020a;
            }

            @Override // z8.h0, z8.q
            public void g(r rVar) {
                i.this.f21019b.b();
                super.g(new C0360a(rVar));
            }
        }

        public /* synthetic */ i(v vVar, z8.m mVar, a aVar) {
            this(vVar, mVar);
        }

        @Override // z8.j0
        public v a() {
            return this.f21018a;
        }

        @Override // z8.j0, z8.s
        public q b(y8.w0 w0Var, y8.v0 v0Var, y8.c cVar, y8.k[] kVarArr) {
            return new a(super.b(w0Var, v0Var, cVar, kVarArr));
        }

        public i(v vVar, z8.m mVar) {
            this.f21018a = vVar;
            this.f21019b = mVar;
        }
    }

    public static abstract class j {
        public abstract void a(x0 x0Var);

        public abstract void b(x0 x0Var);

        public abstract void c(x0 x0Var, y8.q qVar);

        public abstract void d(x0 x0Var);
    }

    public static final class k {

        /* renamed from: a, reason: collision with root package name */
        public List f21024a;

        /* renamed from: b, reason: collision with root package name */
        public int f21025b;

        /* renamed from: c, reason: collision with root package name */
        public int f21026c;

        public k(List list) {
            this.f21024a = list;
        }

        public SocketAddress a() {
            return (SocketAddress) ((y8.x) this.f21024a.get(this.f21025b)).a().get(this.f21026c);
        }

        public y8.a b() {
            return ((y8.x) this.f21024a.get(this.f21025b)).b();
        }

        public void c() {
            y8.x xVar = (y8.x) this.f21024a.get(this.f21025b);
            int i10 = this.f21026c + 1;
            this.f21026c = i10;
            if (i10 >= xVar.a().size()) {
                this.f21025b++;
                this.f21026c = 0;
            }
        }

        public boolean d() {
            return this.f21025b == 0 && this.f21026c == 0;
        }

        public boolean e() {
            return this.f21025b < this.f21024a.size();
        }

        public void f() {
            this.f21025b = 0;
            this.f21026c = 0;
        }

        public boolean g(SocketAddress socketAddress) {
            for (int i10 = 0; i10 < this.f21024a.size(); i10++) {
                int indexOf = ((y8.x) this.f21024a.get(i10)).a().indexOf(socketAddress);
                if (indexOf != -1) {
                    this.f21025b = i10;
                    this.f21026c = indexOf;
                    return true;
                }
            }
            return false;
        }

        public void h(List list) {
            this.f21024a = list;
            f();
        }
    }

    public class l implements j1.a {

        /* renamed from: a, reason: collision with root package name */
        public final v f21027a;

        /* renamed from: b, reason: collision with root package name */
        public final SocketAddress f21028b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f21029c = false;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                x0.this.f20993o = null;
                if (x0.this.f21003y != null) {
                    Preconditions.checkState(x0.this.f21001w == null, "Unexpected non-null activeTransport");
                    l lVar = l.this;
                    lVar.f21027a.c(x0.this.f21003y);
                    return;
                }
                v vVar = x0.this.f21000v;
                l lVar2 = l.this;
                v vVar2 = lVar2.f21027a;
                if (vVar == vVar2) {
                    x0.this.f21001w = vVar2;
                    x0.this.f21000v = null;
                    x0.this.M(y8.p.READY);
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y8.k1 f21032a;

            public b(y8.k1 k1Var) {
                this.f21032a = k1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (x0.this.f21002x.c() == y8.p.SHUTDOWN) {
                    return;
                }
                j1 j1Var = x0.this.f21001w;
                l lVar = l.this;
                if (j1Var == lVar.f21027a) {
                    x0.this.f21001w = null;
                    x0.this.f20991m.f();
                    x0.this.M(y8.p.IDLE);
                    return;
                }
                v vVar = x0.this.f21000v;
                l lVar2 = l.this;
                if (vVar == lVar2.f21027a) {
                    Preconditions.checkState(x0.this.f21002x.c() == y8.p.CONNECTING, "Expected state is CONNECTING, actual state is %s", x0.this.f21002x.c());
                    x0.this.f20991m.c();
                    if (x0.this.f20991m.e()) {
                        x0.this.S();
                        return;
                    }
                    x0.this.f21000v = null;
                    x0.this.f20991m.f();
                    x0.this.R(this.f21032a);
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                x0.this.f20998t.remove(l.this.f21027a);
                if (x0.this.f21002x.c() == y8.p.SHUTDOWN && x0.this.f20998t.isEmpty()) {
                    x0.this.O();
                }
            }
        }

        public l(v vVar, SocketAddress socketAddress) {
            this.f21027a = vVar;
            this.f21028b = socketAddress;
        }

        @Override // z8.j1.a
        public void a() {
            x0.this.f20989k.a(f.a.INFO, "READY");
            x0.this.f20990l.execute(new a());
        }

        @Override // z8.j1.a
        public void b(boolean z10) {
            x0.this.P(this.f21027a, z10);
        }

        @Override // z8.j1.a
        public void c(y8.k1 k1Var) {
            x0.this.f20989k.b(f.a.INFO, "{0} SHUTDOWN with {1}", this.f21027a.d(), x0.this.Q(k1Var));
            this.f21029c = true;
            x0.this.f20990l.execute(new b(k1Var));
        }

        @Override // z8.j1.a
        public void d() {
            Preconditions.checkState(this.f21029c, "transportShutdown() must be called before transportTerminated().");
            x0.this.f20989k.b(f.a.INFO, "{0} Terminated", this.f21027a.d());
            x0.this.f20986h.i(this.f21027a);
            x0.this.P(this.f21027a, false);
            x0.this.f20990l.execute(new c());
        }
    }

    public static final class m extends y8.f {

        /* renamed from: a, reason: collision with root package name */
        public y8.i0 f21035a;

        @Override // y8.f
        public void a(f.a aVar, String str) {
            n.d(this.f21035a, aVar, str);
        }

        @Override // y8.f
        public void b(f.a aVar, String str, Object... objArr) {
            n.e(this.f21035a, aVar, str, objArr);
        }
    }

    public x0(List list, String str, String str2, k.a aVar, t tVar, ScheduledExecutorService scheduledExecutorService, Supplier supplier, y8.o1 o1Var, j jVar, y8.c0 c0Var, z8.m mVar, o oVar, y8.i0 i0Var, y8.f fVar) {
        Preconditions.checkNotNull(list, "addressGroups");
        Preconditions.checkArgument(!list.isEmpty(), "addressGroups is empty");
        L(list, "addressGroups contains null entry");
        List unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f20992n = unmodifiableList;
        this.f20991m = new k(unmodifiableList);
        this.f20980b = str;
        this.f20981c = str2;
        this.f20982d = aVar;
        this.f20984f = tVar;
        this.f20985g = scheduledExecutorService;
        this.f20994p = (Stopwatch) supplier.get();
        this.f20990l = o1Var;
        this.f20983e = jVar;
        this.f20986h = c0Var;
        this.f20987i = mVar;
        this.f20988j = (o) Preconditions.checkNotNull(oVar, "channelTracer");
        this.f20979a = (y8.i0) Preconditions.checkNotNull(i0Var, "logId");
        this.f20989k = (y8.f) Preconditions.checkNotNull(fVar, "channelLogger");
    }

    public static void L(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Preconditions.checkNotNull(it.next(), str);
        }
    }

    public final void K() {
        this.f20990l.e();
        o1.d dVar = this.f20995q;
        if (dVar != null) {
            dVar.a();
            this.f20995q = null;
            this.f20993o = null;
        }
    }

    public final void M(y8.p pVar) {
        this.f20990l.e();
        N(y8.q.a(pVar));
    }

    public final void N(y8.q qVar) {
        this.f20990l.e();
        if (this.f21002x.c() != qVar.c()) {
            Preconditions.checkState(this.f21002x.c() != y8.p.SHUTDOWN, "Cannot transition out of SHUTDOWN to " + qVar);
            this.f21002x = qVar;
            this.f20983e.c(this, qVar);
        }
    }

    public final void O() {
        this.f20990l.execute(new f());
    }

    public final void P(v vVar, boolean z10) {
        this.f20990l.execute(new g(vVar, z10));
    }

    public final String Q(y8.k1 k1Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(k1Var.n());
        if (k1Var.o() != null) {
            sb.append("(");
            sb.append(k1Var.o());
            sb.append(")");
        }
        if (k1Var.m() != null) {
            sb.append("[");
            sb.append(k1Var.m());
            sb.append("]");
        }
        return sb.toString();
    }

    public final void R(y8.k1 k1Var) {
        this.f20990l.e();
        N(y8.q.b(k1Var));
        if (this.f20993o == null) {
            this.f20993o = this.f20982d.get();
        }
        long a10 = this.f20993o.a();
        Stopwatch stopwatch = this.f20994p;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long elapsed = a10 - stopwatch.elapsed(timeUnit);
        this.f20989k.b(f.a.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", Q(k1Var), Long.valueOf(elapsed));
        Preconditions.checkState(this.f20995q == null, "previous reconnectTask is not done");
        this.f20995q = this.f20990l.c(new b(), elapsed, timeUnit, this.f20985g);
    }

    public final void S() {
        SocketAddress socketAddress;
        y8.b0 b0Var;
        this.f20990l.e();
        Preconditions.checkState(this.f20995q == null, "Should have no reconnectTask scheduled");
        if (this.f20991m.d()) {
            this.f20994p.reset().start();
        }
        SocketAddress a10 = this.f20991m.a();
        a aVar = null;
        if (a10 instanceof y8.b0) {
            b0Var = (y8.b0) a10;
            socketAddress = b0Var.c();
        } else {
            socketAddress = a10;
            b0Var = null;
        }
        y8.a b10 = this.f20991m.b();
        String str = (String) b10.b(y8.x.f20066d);
        t.a aVar2 = new t.a();
        if (str == null) {
            str = this.f20980b;
        }
        t.a g10 = aVar2.e(str).f(b10).h(this.f20981c).g(b0Var);
        m mVar = new m();
        mVar.f21035a = d();
        i iVar = new i(this.f20984f.J(socketAddress, g10, mVar), this.f20987i, aVar);
        mVar.f21035a = iVar.d();
        this.f20986h.c(iVar);
        this.f21000v = iVar;
        this.f20998t.add(iVar);
        Runnable e10 = iVar.e(new l(iVar, socketAddress));
        if (e10 != null) {
            this.f20990l.b(e10);
        }
        this.f20989k.b(f.a.INFO, "Started transport {0}", mVar.f21035a);
    }

    public void T(List list) {
        Preconditions.checkNotNull(list, "newAddressGroups");
        L(list, "newAddressGroups contains null entry");
        Preconditions.checkArgument(!list.isEmpty(), "newAddressGroups is empty");
        this.f20990l.execute(new d(Collections.unmodifiableList(new ArrayList(list))));
    }

    @Override // z8.l2
    public s a() {
        j1 j1Var = this.f21001w;
        if (j1Var != null) {
            return j1Var;
        }
        this.f20990l.execute(new c());
        return null;
    }

    public void c(y8.k1 k1Var) {
        this.f20990l.execute(new e(k1Var));
    }

    @Override // y8.m0
    public y8.i0 d() {
        return this.f20979a;
    }

    public void g(y8.k1 k1Var) {
        c(k1Var);
        this.f20990l.execute(new h(k1Var));
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.f20979a.d()).add("addressGroups", this.f20992n).toString();
    }
}
