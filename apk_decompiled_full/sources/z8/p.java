package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.g;
import y8.k1;
import y8.l;
import y8.r;
import y8.v0;
import y8.w0;
import z8.i1;
import z8.i2;
import z8.r;

/* loaded from: classes3.dex */
public final class p extends y8.g {

    /* renamed from: t, reason: collision with root package name */
    public static final Logger f20776t = Logger.getLogger(p.class.getName());

    /* renamed from: u, reason: collision with root package name */
    public static final byte[] f20777u = "gzip".getBytes(Charset.forName("US-ASCII"));

    /* renamed from: v, reason: collision with root package name */
    public static final double f20778v;

    /* renamed from: a, reason: collision with root package name */
    public final y8.w0 f20779a;

    /* renamed from: b, reason: collision with root package name */
    public final g9.d f20780b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f20781c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f20782d;

    /* renamed from: e, reason: collision with root package name */
    public final m f20783e;

    /* renamed from: f, reason: collision with root package name */
    public final y8.r f20784f;

    /* renamed from: g, reason: collision with root package name */
    public volatile ScheduledFuture f20785g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f20786h;

    /* renamed from: i, reason: collision with root package name */
    public y8.c f20787i;

    /* renamed from: j, reason: collision with root package name */
    public q f20788j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f20789k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20790l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20791m;

    /* renamed from: n, reason: collision with root package name */
    public final e f20792n;

    /* renamed from: p, reason: collision with root package name */
    public final ScheduledExecutorService f20794p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f20795q;

    /* renamed from: o, reason: collision with root package name */
    public final f f20793o = new f();

    /* renamed from: r, reason: collision with root package name */
    public y8.v f20796r = y8.v.c();

    /* renamed from: s, reason: collision with root package name */
    public y8.o f20797s = y8.o.a();

    public class b extends x {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g.a f20798b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g.a aVar) {
            super(p.this.f20784f);
            this.f20798b = aVar;
        }

        @Override // z8.x
        public void a() {
            p pVar = p.this;
            pVar.r(this.f20798b, y8.s.a(pVar.f20784f), new y8.v0());
        }
    }

    public class c extends x {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g.a f20800b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f20801c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g.a aVar, String str) {
            super(p.this.f20784f);
            this.f20800b = aVar;
            this.f20801c = str;
        }

        @Override // z8.x
        public void a() {
            p.this.r(this.f20800b, y8.k1.f19903t.r(String.format("Unable to find compressor by name %s", this.f20801c)), new y8.v0());
        }
    }

    public class d implements r {

        /* renamed from: a, reason: collision with root package name */
        public final g.a f20803a;

        /* renamed from: b, reason: collision with root package name */
        public y8.k1 f20804b;

        public final class a extends x {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g9.b f20806b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ y8.v0 f20807c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g9.b bVar, y8.v0 v0Var) {
                super(p.this.f20784f);
                this.f20806b = bVar;
                this.f20807c = v0Var;
            }

            @Override // z8.x
            public void a() {
                g9.c.g("ClientCall$Listener.headersRead", p.this.f20780b);
                g9.c.d(this.f20806b);
                try {
                    b();
                } finally {
                    g9.c.i("ClientCall$Listener.headersRead", p.this.f20780b);
                }
            }

            public final void b() {
                if (d.this.f20804b != null) {
                    return;
                }
                try {
                    d.this.f20803a.b(this.f20807c);
                } catch (Throwable th) {
                    d.this.i(y8.k1.f19890g.q(th).r("Failed to read headers"));
                }
            }
        }

        public final class b extends x {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g9.b f20809b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ i2.a f20810c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(g9.b bVar, i2.a aVar) {
                super(p.this.f20784f);
                this.f20809b = bVar;
                this.f20810c = aVar;
            }

            @Override // z8.x
            public void a() {
                g9.c.g("ClientCall$Listener.messagesAvailable", p.this.f20780b);
                g9.c.d(this.f20809b);
                try {
                    b();
                } finally {
                    g9.c.i("ClientCall$Listener.messagesAvailable", p.this.f20780b);
                }
            }

            public final void b() {
                if (d.this.f20804b != null) {
                    q0.e(this.f20810c);
                    return;
                }
                while (true) {
                    try {
                        InputStream next = this.f20810c.next();
                        if (next == null) {
                            return;
                        }
                        try {
                            d.this.f20803a.c(p.this.f20779a.i(next));
                            next.close();
                        } catch (Throwable th) {
                            q0.d(next);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        q0.e(this.f20810c);
                        d.this.i(y8.k1.f19890g.q(th2).r("Failed to read message."));
                        return;
                    }
                }
            }
        }

        public final class c extends x {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g9.b f20812b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ y8.k1 f20813c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ y8.v0 f20814d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(g9.b bVar, y8.k1 k1Var, y8.v0 v0Var) {
                super(p.this.f20784f);
                this.f20812b = bVar;
                this.f20813c = k1Var;
                this.f20814d = v0Var;
            }

            @Override // z8.x
            public void a() {
                g9.c.g("ClientCall$Listener.onClose", p.this.f20780b);
                g9.c.d(this.f20812b);
                try {
                    b();
                } finally {
                    g9.c.i("ClientCall$Listener.onClose", p.this.f20780b);
                }
            }

            public final void b() {
                y8.k1 k1Var = this.f20813c;
                y8.v0 v0Var = this.f20814d;
                if (d.this.f20804b != null) {
                    k1Var = d.this.f20804b;
                    v0Var = new y8.v0();
                }
                p.this.f20789k = true;
                try {
                    d dVar = d.this;
                    p.this.r(dVar.f20803a, k1Var, v0Var);
                } finally {
                    p.this.y();
                    p.this.f20783e.a(k1Var.p());
                }
            }
        }

        /* renamed from: z8.p$d$d, reason: collision with other inner class name */
        public final class C0359d extends x {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g9.b f20816b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0359d(g9.b bVar) {
                super(p.this.f20784f);
                this.f20816b = bVar;
            }

            @Override // z8.x
            public void a() {
                g9.c.g("ClientCall$Listener.onReady", p.this.f20780b);
                g9.c.d(this.f20816b);
                try {
                    b();
                } finally {
                    g9.c.i("ClientCall$Listener.onReady", p.this.f20780b);
                }
            }

            public final void b() {
                if (d.this.f20804b != null) {
                    return;
                }
                try {
                    d.this.f20803a.d();
                } catch (Throwable th) {
                    d.this.i(y8.k1.f19890g.q(th).r("Failed to call onReady."));
                }
            }
        }

        public d(g.a aVar) {
            this.f20803a = (g.a) Preconditions.checkNotNull(aVar, "observer");
        }

        @Override // z8.i2
        public void a(i2.a aVar) {
            g9.c.g("ClientStreamListener.messagesAvailable", p.this.f20780b);
            try {
                p.this.f20781c.execute(new b(g9.c.e(), aVar));
            } finally {
                g9.c.i("ClientStreamListener.messagesAvailable", p.this.f20780b);
            }
        }

        @Override // z8.r
        public void b(y8.v0 v0Var) {
            g9.c.g("ClientStreamListener.headersRead", p.this.f20780b);
            try {
                p.this.f20781c.execute(new a(g9.c.e(), v0Var));
            } finally {
                g9.c.i("ClientStreamListener.headersRead", p.this.f20780b);
            }
        }

        @Override // z8.r
        public void c(y8.k1 k1Var, r.a aVar, y8.v0 v0Var) {
            g9.c.g("ClientStreamListener.closed", p.this.f20780b);
            try {
                h(k1Var, aVar, v0Var);
            } finally {
                g9.c.i("ClientStreamListener.closed", p.this.f20780b);
            }
        }

        @Override // z8.i2
        public void d() {
            if (p.this.f20779a.e().a()) {
                return;
            }
            g9.c.g("ClientStreamListener.onReady", p.this.f20780b);
            try {
                p.this.f20781c.execute(new C0359d(g9.c.e()));
            } finally {
                g9.c.i("ClientStreamListener.onReady", p.this.f20780b);
            }
        }

        public final void h(y8.k1 k1Var, r.a aVar, y8.v0 v0Var) {
            y8.t s10 = p.this.s();
            if (k1Var.n() == k1.b.CANCELLED && s10 != null && s10.g()) {
                w0 w0Var = new w0();
                p.this.f20788j.p(w0Var);
                k1Var = y8.k1.f19893j.f("ClientCall was cancelled at or after deadline. " + w0Var);
                v0Var = new y8.v0();
            }
            p.this.f20781c.execute(new c(g9.c.e(), k1Var, v0Var));
        }

        public final void i(y8.k1 k1Var) {
            this.f20804b = k1Var;
            p.this.f20788j.e(k1Var);
        }
    }

    public interface e {
        q a(y8.w0 w0Var, y8.c cVar, y8.v0 v0Var, y8.r rVar);
    }

    public final class f implements r.a {
        public f() {
        }
    }

    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final long f20819a;

        public g(long j10) {
            this.f20819a = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            w0 w0Var = new w0();
            p.this.f20788j.p(w0Var);
            long abs = Math.abs(this.f20819a);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long nanos = abs / timeUnit.toNanos(1L);
            long abs2 = Math.abs(this.f20819a) % timeUnit.toNanos(1L);
            StringBuilder sb = new StringBuilder();
            sb.append("deadline exceeded after ");
            if (this.f20819a < 0) {
                sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            }
            sb.append(nanos);
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(abs2)));
            sb.append("s. ");
            sb.append(w0Var);
            p.this.f20788j.e(y8.k1.f19893j.f(sb.toString()));
        }
    }

    static {
        double nanos = TimeUnit.SECONDS.toNanos(1L);
        Double.isNaN(nanos);
        f20778v = nanos * 1.0d;
    }

    public p(y8.w0 w0Var, Executor executor, y8.c cVar, e eVar, ScheduledExecutorService scheduledExecutorService, m mVar, y8.e0 e0Var) {
        this.f20779a = w0Var;
        g9.d b10 = g9.c.b(w0Var.c(), System.identityHashCode(this));
        this.f20780b = b10;
        boolean z10 = true;
        if (executor == MoreExecutors.directExecutor()) {
            this.f20781c = new a2();
            this.f20782d = true;
        } else {
            this.f20781c = new b2(executor);
            this.f20782d = false;
        }
        this.f20783e = mVar;
        this.f20784f = y8.r.e();
        if (w0Var.e() != w0.d.UNARY && w0Var.e() != w0.d.SERVER_STREAMING) {
            z10 = false;
        }
        this.f20786h = z10;
        this.f20787i = cVar;
        this.f20792n = eVar;
        this.f20794p = scheduledExecutorService;
        g9.c.c("ClientCall.<init>", b10);
    }

    public static boolean u(y8.t tVar, y8.t tVar2) {
        if (tVar == null) {
            return false;
        }
        if (tVar2 == null) {
            return true;
        }
        return tVar.f(tVar2);
    }

    public static void v(y8.t tVar, y8.t tVar2, y8.t tVar3) {
        Logger logger = f20776t;
        if (logger.isLoggable(Level.FINE) && tVar != null && tVar.equals(tVar2)) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long max = Math.max(0L, tVar.i(timeUnit));
            Locale locale = Locale.US;
            StringBuilder sb = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(max)));
            if (tVar3 == null) {
                sb.append(" Explicit call timeout was not set.");
            } else {
                sb.append(String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(tVar3.i(timeUnit))));
            }
            logger.fine(sb.toString());
        }
    }

    public static y8.t w(y8.t tVar, y8.t tVar2) {
        return tVar == null ? tVar2 : tVar2 == null ? tVar : tVar.h(tVar2);
    }

    public static void x(y8.v0 v0Var, y8.v vVar, y8.n nVar, boolean z10) {
        v0Var.e(q0.f20841i);
        v0.g gVar = q0.f20837e;
        v0Var.e(gVar);
        if (nVar != l.b.f19933a) {
            v0Var.o(gVar, nVar.a());
        }
        v0.g gVar2 = q0.f20838f;
        v0Var.e(gVar2);
        byte[] a10 = y8.f0.a(vVar);
        if (a10.length != 0) {
            v0Var.o(gVar2, a10);
        }
        v0Var.e(q0.f20839g);
        v0.g gVar3 = q0.f20840h;
        v0Var.e(gVar3);
        if (z10) {
            v0Var.o(gVar3, f20777u);
        }
    }

    public p A(y8.o oVar) {
        this.f20797s = oVar;
        return this;
    }

    public p B(y8.v vVar) {
        this.f20796r = vVar;
        return this;
    }

    public p C(boolean z10) {
        this.f20795q = z10;
        return this;
    }

    public final ScheduledFuture D(y8.t tVar) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long i10 = tVar.i(timeUnit);
        return this.f20794p.schedule(new c1(new g(i10)), i10, timeUnit);
    }

    public final void E(g.a aVar, y8.v0 v0Var) {
        y8.n nVar;
        Preconditions.checkState(this.f20788j == null, "Already started");
        Preconditions.checkState(!this.f20790l, "call was cancelled");
        Preconditions.checkNotNull(aVar, "observer");
        Preconditions.checkNotNull(v0Var, "headers");
        if (this.f20784f.h()) {
            this.f20788j = n1.f20766a;
            this.f20781c.execute(new b(aVar));
            return;
        }
        p();
        String b10 = this.f20787i.b();
        if (b10 != null) {
            nVar = this.f20797s.b(b10);
            if (nVar == null) {
                this.f20788j = n1.f20766a;
                this.f20781c.execute(new c(aVar, b10));
                return;
            }
        } else {
            nVar = l.b.f19933a;
        }
        x(v0Var, this.f20796r, nVar, this.f20795q);
        y8.t s10 = s();
        if (s10 != null && s10.g()) {
            y8.k[] f10 = q0.f(this.f20787i, v0Var, 0, false);
            String str = u(this.f20787i.d(), this.f20784f.g()) ? "CallOptions" : "Context";
            double i10 = s10.i(TimeUnit.NANOSECONDS);
            double d10 = f20778v;
            Double.isNaN(i10);
            this.f20788j = new f0(y8.k1.f19893j.r(String.format("ClientCall started after %s deadline was exceeded .9%f seconds ago", str, Double.valueOf(i10 / d10))), f10);
        } else {
            v(s10, this.f20784f.g(), this.f20787i.d());
            this.f20788j = this.f20792n.a(this.f20779a, this.f20787i, v0Var, this.f20784f);
        }
        if (this.f20782d) {
            this.f20788j.i();
        }
        if (this.f20787i.a() != null) {
            this.f20788j.n(this.f20787i.a());
        }
        if (this.f20787i.f() != null) {
            this.f20788j.c(this.f20787i.f().intValue());
        }
        if (this.f20787i.g() != null) {
            this.f20788j.d(this.f20787i.g().intValue());
        }
        if (s10 != null) {
            this.f20788j.k(s10);
        }
        this.f20788j.a(nVar);
        boolean z10 = this.f20795q;
        if (z10) {
            this.f20788j.j(z10);
        }
        this.f20788j.l(this.f20796r);
        this.f20783e.b();
        this.f20788j.g(new d(aVar));
        this.f20784f.a(this.f20793o, MoreExecutors.directExecutor());
        if (s10 != null && !s10.equals(this.f20784f.g()) && this.f20794p != null) {
            this.f20785g = D(s10);
        }
        if (this.f20789k) {
            y();
        }
    }

    @Override // y8.g
    public void a(String str, Throwable th) {
        g9.c.g("ClientCall.cancel", this.f20780b);
        try {
            q(str, th);
        } finally {
            g9.c.i("ClientCall.cancel", this.f20780b);
        }
    }

    @Override // y8.g
    public void b() {
        g9.c.g("ClientCall.halfClose", this.f20780b);
        try {
            t();
        } finally {
            g9.c.i("ClientCall.halfClose", this.f20780b);
        }
    }

    @Override // y8.g
    public void c(int i10) {
        g9.c.g("ClientCall.request", this.f20780b);
        try {
            boolean z10 = true;
            Preconditions.checkState(this.f20788j != null, "Not started");
            if (i10 < 0) {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "Number requested must be non-negative");
            this.f20788j.b(i10);
        } finally {
            g9.c.i("ClientCall.request", this.f20780b);
        }
    }

    @Override // y8.g
    public void d(Object obj) {
        g9.c.g("ClientCall.sendMessage", this.f20780b);
        try {
            z(obj);
        } finally {
            g9.c.i("ClientCall.sendMessage", this.f20780b);
        }
    }

    @Override // y8.g
    public void e(g.a aVar, y8.v0 v0Var) {
        g9.c.g("ClientCall.start", this.f20780b);
        try {
            E(aVar, v0Var);
        } finally {
            g9.c.i("ClientCall.start", this.f20780b);
        }
    }

    public final void p() {
        i1.b bVar = (i1.b) this.f20787i.h(i1.b.f20651g);
        if (bVar == null) {
            return;
        }
        Long l10 = bVar.f20652a;
        if (l10 != null) {
            y8.t a10 = y8.t.a(l10.longValue(), TimeUnit.NANOSECONDS);
            y8.t d10 = this.f20787i.d();
            if (d10 == null || a10.compareTo(d10) < 0) {
                this.f20787i = this.f20787i.n(a10);
            }
        }
        Boolean bool = bVar.f20653b;
        if (bool != null) {
            this.f20787i = bool.booleanValue() ? this.f20787i.u() : this.f20787i.v();
        }
        if (bVar.f20654c != null) {
            Integer f10 = this.f20787i.f();
            if (f10 != null) {
                this.f20787i = this.f20787i.q(Math.min(f10.intValue(), bVar.f20654c.intValue()));
            } else {
                this.f20787i = this.f20787i.q(bVar.f20654c.intValue());
            }
        }
        if (bVar.f20655d != null) {
            Integer g10 = this.f20787i.g();
            if (g10 != null) {
                this.f20787i = this.f20787i.r(Math.min(g10.intValue(), bVar.f20655d.intValue()));
            } else {
                this.f20787i = this.f20787i.r(bVar.f20655d.intValue());
            }
        }
    }

    public final void q(String str, Throwable th) {
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            f20776t.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th);
        }
        if (this.f20790l) {
            return;
        }
        this.f20790l = true;
        try {
            if (this.f20788j != null) {
                y8.k1 k1Var = y8.k1.f19890g;
                y8.k1 r10 = str != null ? k1Var.r(str) : k1Var.r("Call cancelled without message");
                if (th != null) {
                    r10 = r10.q(th);
                }
                this.f20788j.e(r10);
            }
        } finally {
            y();
        }
    }

    public final void r(g.a aVar, y8.k1 k1Var, y8.v0 v0Var) {
        aVar.a(k1Var, v0Var);
    }

    public final y8.t s() {
        return w(this.f20787i.d(), this.f20784f.g());
    }

    public final void t() {
        Preconditions.checkState(this.f20788j != null, "Not started");
        Preconditions.checkState(!this.f20790l, "call was cancelled");
        Preconditions.checkState(!this.f20791m, "call already half-closed");
        this.f20791m = true;
        this.f20788j.o();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add(FirebaseAnalytics.Param.METHOD, this.f20779a).toString();
    }

    public final void y() {
        this.f20784f.i(this.f20793o);
        ScheduledFuture scheduledFuture = this.f20785g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public final void z(Object obj) {
        Preconditions.checkState(this.f20788j != null, "Not started");
        Preconditions.checkState(!this.f20790l, "call was cancelled");
        Preconditions.checkState(!this.f20791m, "call was half-closed");
        try {
            q qVar = this.f20788j;
            if (qVar instanceof x1) {
                ((x1) qVar).n0(obj);
            } else {
                qVar.h(this.f20779a.j(obj));
            }
            if (this.f20786h) {
                return;
            }
            this.f20788j.flush();
        } catch (Error e10) {
            this.f20788j.e(y8.k1.f19890g.r("Client sendMessage() failed with Error"));
            throw e10;
        } catch (RuntimeException e11) {
            this.f20788j.e(y8.k1.f19890g.q(e11).r("Failed to stream message"));
        }
    }
}
