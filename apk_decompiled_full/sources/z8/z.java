package z8;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.g;

/* loaded from: classes3.dex */
public abstract class z extends y8.g {

    /* renamed from: j, reason: collision with root package name */
    public static final Logger f21147j = Logger.getLogger(z.class.getName());

    /* renamed from: k, reason: collision with root package name */
    public static final y8.g f21148k = new i();

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f21149a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f21150b;

    /* renamed from: c, reason: collision with root package name */
    public final y8.r f21151c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f21152d;

    /* renamed from: e, reason: collision with root package name */
    public g.a f21153e;

    /* renamed from: f, reason: collision with root package name */
    public y8.g f21154f;

    /* renamed from: g, reason: collision with root package name */
    public y8.k1 f21155g;

    /* renamed from: h, reason: collision with root package name */
    public List f21156h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public k f21157i;

    public class a extends x {
        public a(y8.r rVar) {
            super(rVar);
        }

        @Override // z8.x
        public void a() {
            z.this.m();
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f21159a;

        public b(StringBuilder sb) {
            this.f21159a = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            z.this.k(y8.k1.f19893j.r(this.f21159a.toString()), true);
        }
    }

    public class c extends x {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f21161b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k kVar) {
            super(z.this.f21151c);
            this.f21161b = kVar;
        }

        @Override // z8.x
        public void a() {
            this.f21161b.g();
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.a f21163a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y8.v0 f21164b;

        public d(g.a aVar, y8.v0 v0Var) {
            this.f21163a = aVar;
            this.f21164b = v0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            z.this.f21154f.e(this.f21163a, this.f21164b);
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.k1 f21166a;

        public e(y8.k1 k1Var) {
            this.f21166a = k1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            z.this.f21154f.a(this.f21166a.o(), this.f21166a.m());
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f21168a;

        public f(Object obj) {
            this.f21168a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            z.this.f21154f.d(this.f21168a);
        }
    }

    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21170a;

        public g(int i10) {
            this.f21170a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            z.this.f21154f.c(this.f21170a);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z.this.f21154f.b();
        }
    }

    public class i extends y8.g {
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

    public final class j extends x {

        /* renamed from: b, reason: collision with root package name */
        public final g.a f21173b;

        /* renamed from: c, reason: collision with root package name */
        public final y8.k1 f21174c;

        public j(g.a aVar, y8.k1 k1Var) {
            super(z.this.f21151c);
            this.f21173b = aVar;
            this.f21174c = k1Var;
        }

        @Override // z8.x
        public void a() {
            this.f21173b.a(this.f21174c, new y8.v0());
        }
    }

    public static final class k extends g.a {

        /* renamed from: a, reason: collision with root package name */
        public final g.a f21176a;

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f21177b;

        /* renamed from: c, reason: collision with root package name */
        public List f21178c = new ArrayList();

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y8.v0 f21179a;

            public a(y8.v0 v0Var) {
                this.f21179a = v0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f21176a.b(this.f21179a);
            }
        }

        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f21181a;

            public b(Object obj) {
                this.f21181a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f21176a.c(this.f21181a);
            }
        }

        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y8.k1 f21183a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y8.v0 f21184b;

            public c(y8.k1 k1Var, y8.v0 v0Var) {
                this.f21183a = k1Var;
                this.f21184b = v0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f21176a.a(this.f21183a, this.f21184b);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f21176a.d();
            }
        }

        public k(g.a aVar) {
            this.f21176a = aVar;
        }

        @Override // y8.g.a
        public void a(y8.k1 k1Var, y8.v0 v0Var) {
            f(new c(k1Var, v0Var));
        }

        @Override // y8.g.a
        public void b(y8.v0 v0Var) {
            if (this.f21177b) {
                this.f21176a.b(v0Var);
            } else {
                f(new a(v0Var));
            }
        }

        @Override // y8.g.a
        public void c(Object obj) {
            if (this.f21177b) {
                this.f21176a.c(obj);
            } else {
                f(new b(obj));
            }
        }

        @Override // y8.g.a
        public void d() {
            if (this.f21177b) {
                this.f21176a.d();
            } else {
                f(new d());
            }
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                if (this.f21177b) {
                    runnable.run();
                } else {
                    this.f21178c.add(runnable);
                }
            }
        }

        public void g() {
            List list;
            List arrayList = new ArrayList();
            while (true) {
                synchronized (this) {
                    if (this.f21178c.isEmpty()) {
                        this.f21178c = null;
                        this.f21177b = true;
                        return;
                    } else {
                        list = this.f21178c;
                        this.f21178c = arrayList;
                    }
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                list.clear();
                arrayList = list;
            }
        }
    }

    public z(Executor executor, ScheduledExecutorService scheduledExecutorService, y8.t tVar) {
        this.f21150b = (Executor) Preconditions.checkNotNull(executor, "callExecutor");
        Preconditions.checkNotNull(scheduledExecutorService, "scheduler");
        this.f21151c = y8.r.e();
        this.f21149a = o(scheduledExecutorService, tVar);
    }

    @Override // y8.g
    public final void a(String str, Throwable th) {
        y8.k1 k1Var = y8.k1.f19890g;
        y8.k1 r10 = str != null ? k1Var.r(str) : k1Var.r("Call cancelled without message");
        if (th != null) {
            r10 = r10.q(th);
        }
        k(r10, false);
    }

    @Override // y8.g
    public final void b() {
        l(new h());
    }

    @Override // y8.g
    public final void c(int i10) {
        if (this.f21152d) {
            this.f21154f.c(i10);
        } else {
            l(new g(i10));
        }
    }

    @Override // y8.g
    public final void d(Object obj) {
        if (this.f21152d) {
            this.f21154f.d(obj);
        } else {
            l(new f(obj));
        }
    }

    @Override // y8.g
    public final void e(g.a aVar, y8.v0 v0Var) {
        y8.k1 k1Var;
        boolean z10;
        Preconditions.checkState(this.f21153e == null, "already started");
        synchronized (this) {
            this.f21153e = (g.a) Preconditions.checkNotNull(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            k1Var = this.f21155g;
            z10 = this.f21152d;
            if (!z10) {
                k kVar = new k(aVar);
                this.f21157i = kVar;
                aVar = kVar;
            }
        }
        if (k1Var != null) {
            this.f21150b.execute(new j(aVar, k1Var));
        } else if (z10) {
            this.f21154f.e(aVar, v0Var);
        } else {
            l(new d(aVar, v0Var));
        }
    }

    public void j() {
    }

    public final void k(y8.k1 k1Var, boolean z10) {
        boolean z11;
        g.a aVar;
        synchronized (this) {
            if (this.f21154f == null) {
                q(f21148k);
                aVar = this.f21153e;
                this.f21155g = k1Var;
                z11 = false;
            } else {
                if (z10) {
                    return;
                }
                z11 = true;
                aVar = null;
            }
            if (z11) {
                l(new e(k1Var));
            } else {
                if (aVar != null) {
                    this.f21150b.execute(new j(aVar, k1Var));
                }
                m();
            }
            j();
        }
    }

    public final void l(Runnable runnable) {
        synchronized (this) {
            if (this.f21152d) {
                runnable.run();
            } else {
                this.f21156h.add(runnable);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        if (r0.hasNext() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m() {
        k kVar;
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                if (this.f21156h.isEmpty()) {
                    break;
                }
                list = this.f21156h;
                this.f21156h = arrayList;
            }
            if (kVar == null) {
                this.f21150b.execute(new c(kVar));
                return;
            }
            return;
            list.clear();
            arrayList = list;
        }
        this.f21156h = null;
        this.f21152d = true;
        kVar = this.f21157i;
        if (kVar == null) {
        }
    }

    public final boolean n(y8.t tVar, y8.t tVar2) {
        if (tVar2 == null) {
            return true;
        }
        if (tVar == null) {
            return false;
        }
        return tVar.f(tVar2);
    }

    public final ScheduledFuture o(ScheduledExecutorService scheduledExecutorService, y8.t tVar) {
        y8.t g10 = this.f21151c.g();
        if (tVar == null && g10 == null) {
            return null;
        }
        long i10 = tVar != null ? tVar.i(TimeUnit.NANOSECONDS) : Long.MAX_VALUE;
        if (g10 != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (g10.i(timeUnit) < i10) {
                i10 = g10.i(timeUnit);
                Logger logger = f21147j;
                if (logger.isLoggable(Level.FINE)) {
                    Locale locale = Locale.US;
                    StringBuilder sb = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(i10)));
                    if (tVar == null) {
                        sb.append(" Explicit call timeout was not set.");
                    } else {
                        sb.append(String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(tVar.i(timeUnit))));
                    }
                    logger.fine(sb.toString());
                }
            }
        }
        long abs = Math.abs(i10);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        long nanos = abs / timeUnit2.toNanos(1L);
        long abs2 = Math.abs(i10) % timeUnit2.toNanos(1L);
        StringBuilder sb2 = new StringBuilder();
        String str = n(g10, tVar) ? "Context" : "CallOptions";
        if (i10 < 0) {
            sb2.append("ClientCall started after ");
            sb2.append(str);
            sb2.append(" deadline was exceeded. Deadline has been exceeded for ");
        } else {
            sb2.append("Deadline ");
            sb2.append(str);
            sb2.append(" will be exceeded in ");
        }
        sb2.append(nanos);
        sb2.append(String.format(Locale.US, ".%09d", Long.valueOf(abs2)));
        sb2.append("s. ");
        return scheduledExecutorService.schedule(new b(sb2), i10, TimeUnit.NANOSECONDS);
    }

    public final Runnable p(y8.g gVar) {
        synchronized (this) {
            if (this.f21154f != null) {
                return null;
            }
            q((y8.g) Preconditions.checkNotNull(gVar, "call"));
            return new a(this.f21151c);
        }
    }

    public final void q(y8.g gVar) {
        y8.g gVar2 = this.f21154f;
        Preconditions.checkState(gVar2 == null, "realCall already set to %s", gVar2);
        ScheduledFuture scheduledFuture = this.f21149a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f21154f = gVar;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("realCall", this.f21154f).toString();
    }
}
