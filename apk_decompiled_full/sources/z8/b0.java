package z8;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.hpplay.component.protocol.push.IPushHandler;
import com.taobao.accs.common.Constants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z8.i2;
import z8.r;

/* loaded from: classes3.dex */
public class b0 implements q {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f20296a;

    /* renamed from: b, reason: collision with root package name */
    public r f20297b;

    /* renamed from: c, reason: collision with root package name */
    public q f20298c;

    /* renamed from: d, reason: collision with root package name */
    public y8.k1 f20299d;

    /* renamed from: f, reason: collision with root package name */
    public o f20301f;

    /* renamed from: g, reason: collision with root package name */
    public long f20302g;

    /* renamed from: h, reason: collision with root package name */
    public long f20303h;

    /* renamed from: e, reason: collision with root package name */
    public List f20300e = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public List f20304i = new ArrayList();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20305a;

        public a(int i10) {
            this.f20305a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.b(this.f20305a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.i();
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.n f20308a;

        public c(y8.n nVar) {
            this.f20308a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.a(this.f20308a);
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f20310a;

        public d(boolean z10) {
            this.f20310a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.j(this.f20310a);
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.v f20312a;

        public e(y8.v vVar) {
            this.f20312a = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.l(this.f20312a);
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20314a;

        public f(int i10) {
            this.f20314a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.c(this.f20314a);
        }
    }

    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20316a;

        public g(int i10) {
            this.f20316a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.d(this.f20316a);
        }
    }

    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.t f20318a;

        public h(y8.t tVar) {
            this.f20318a = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.k(this.f20318a);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.s();
        }
    }

    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20321a;

        public j(String str) {
            this.f20321a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.n(this.f20321a);
        }
    }

    public class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f20323a;

        public k(InputStream inputStream) {
            this.f20323a = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.h(this.f20323a);
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.flush();
        }
    }

    public class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.k1 f20326a;

        public m(y8.k1 k1Var) {
            this.f20326a = k1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.e(this.f20326a);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20298c.o();
        }
    }

    public static class o implements r {

        /* renamed from: a, reason: collision with root package name */
        public final r f20329a;

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f20330b;

        /* renamed from: c, reason: collision with root package name */
        public List f20331c = new ArrayList();

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i2.a f20332a;

            public a(i2.a aVar) {
                this.f20332a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f20329a.a(this.f20332a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f20329a.d();
            }
        }

        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y8.v0 f20335a;

            public c(y8.v0 v0Var) {
                this.f20335a = v0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f20329a.b(this.f20335a);
            }
        }

        public class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y8.k1 f20337a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r.a f20338b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ y8.v0 f20339c;

            public d(y8.k1 k1Var, r.a aVar, y8.v0 v0Var) {
                this.f20337a = k1Var;
                this.f20338b = aVar;
                this.f20339c = v0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f20329a.c(this.f20337a, this.f20338b, this.f20339c);
            }
        }

        public o(r rVar) {
            this.f20329a = rVar;
        }

        @Override // z8.i2
        public void a(i2.a aVar) {
            if (this.f20330b) {
                this.f20329a.a(aVar);
            } else {
                f(new a(aVar));
            }
        }

        @Override // z8.r
        public void b(y8.v0 v0Var) {
            f(new c(v0Var));
        }

        @Override // z8.r
        public void c(y8.k1 k1Var, r.a aVar, y8.v0 v0Var) {
            f(new d(k1Var, aVar, v0Var));
        }

        @Override // z8.i2
        public void d() {
            if (this.f20330b) {
                this.f20329a.d();
            } else {
                f(new b());
            }
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                if (this.f20330b) {
                    runnable.run();
                } else {
                    this.f20331c.add(runnable);
                }
            }
        }

        public void g() {
            List list;
            List arrayList = new ArrayList();
            while (true) {
                synchronized (this) {
                    if (this.f20331c.isEmpty()) {
                        this.f20331c = null;
                        this.f20330b = true;
                        return;
                    } else {
                        list = this.f20331c;
                        this.f20331c = arrayList;
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

    @Override // z8.h2
    public void a(y8.n nVar) {
        Preconditions.checkState(this.f20297b == null, "May only be called before start");
        Preconditions.checkNotNull(nVar, "compressor");
        this.f20304i.add(new c(nVar));
    }

    @Override // z8.h2
    public void b(int i10) {
        Preconditions.checkState(this.f20297b != null, "May only be called after start");
        if (this.f20296a) {
            this.f20298c.b(i10);
        } else {
            r(new a(i10));
        }
    }

    @Override // z8.q
    public void c(int i10) {
        Preconditions.checkState(this.f20297b == null, "May only be called before start");
        this.f20304i.add(new f(i10));
    }

    @Override // z8.q
    public void d(int i10) {
        Preconditions.checkState(this.f20297b == null, "May only be called before start");
        this.f20304i.add(new g(i10));
    }

    @Override // z8.q
    public void e(y8.k1 k1Var) {
        boolean z10 = true;
        Preconditions.checkState(this.f20297b != null, "May only be called after start");
        Preconditions.checkNotNull(k1Var, IPushHandler.REASON);
        synchronized (this) {
            if (this.f20298c == null) {
                v(n1.f20766a);
                this.f20299d = k1Var;
                z10 = false;
            }
        }
        if (z10) {
            r(new m(k1Var));
            return;
        }
        s();
        u(k1Var);
        this.f20297b.c(k1Var, r.a.PROCESSED, new y8.v0());
    }

    @Override // z8.h2
    public void flush() {
        Preconditions.checkState(this.f20297b != null, "May only be called after start");
        if (this.f20296a) {
            this.f20298c.flush();
        } else {
            r(new l());
        }
    }

    @Override // z8.q
    public void g(r rVar) {
        y8.k1 k1Var;
        boolean z10;
        Preconditions.checkNotNull(rVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkState(this.f20297b == null, "already started");
        synchronized (this) {
            k1Var = this.f20299d;
            z10 = this.f20296a;
            if (!z10) {
                o oVar = new o(rVar);
                this.f20301f = oVar;
                rVar = oVar;
            }
            this.f20297b = rVar;
            this.f20302g = System.nanoTime();
        }
        if (k1Var != null) {
            rVar.c(k1Var, r.a.PROCESSED, new y8.v0());
        } else if (z10) {
            t(rVar);
        }
    }

    @Override // z8.h2
    public void h(InputStream inputStream) {
        Preconditions.checkState(this.f20297b != null, "May only be called after start");
        Preconditions.checkNotNull(inputStream, Constants.SHARED_MESSAGE_ID_FILE);
        if (this.f20296a) {
            this.f20298c.h(inputStream);
        } else {
            r(new k(inputStream));
        }
    }

    @Override // z8.h2
    public void i() {
        Preconditions.checkState(this.f20297b == null, "May only be called before start");
        this.f20304i.add(new b());
    }

    @Override // z8.q
    public void j(boolean z10) {
        Preconditions.checkState(this.f20297b == null, "May only be called before start");
        this.f20304i.add(new d(z10));
    }

    @Override // z8.q
    public void k(y8.t tVar) {
        Preconditions.checkState(this.f20297b == null, "May only be called before start");
        this.f20304i.add(new h(tVar));
    }

    @Override // z8.q
    public void l(y8.v vVar) {
        Preconditions.checkState(this.f20297b == null, "May only be called before start");
        Preconditions.checkNotNull(vVar, "decompressorRegistry");
        this.f20304i.add(new e(vVar));
    }

    @Override // z8.h2
    public boolean m() {
        if (this.f20296a) {
            return this.f20298c.m();
        }
        return false;
    }

    @Override // z8.q
    public void n(String str) {
        Preconditions.checkState(this.f20297b == null, "May only be called before start");
        Preconditions.checkNotNull(str, "authority");
        this.f20304i.add(new j(str));
    }

    @Override // z8.q
    public void o() {
        Preconditions.checkState(this.f20297b != null, "May only be called after start");
        r(new n());
    }

    @Override // z8.q
    public void p(w0 w0Var) {
        synchronized (this) {
            if (this.f20297b == null) {
                return;
            }
            if (this.f20298c != null) {
                w0Var.b("buffered_nanos", Long.valueOf(this.f20303h - this.f20302g));
                this.f20298c.p(w0Var);
            } else {
                w0Var.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.f20302g));
                w0Var.a("waiting_for_connection");
            }
        }
    }

    public final void r(Runnable runnable) {
        Preconditions.checkState(this.f20297b != null, "May only be called after start");
        synchronized (this) {
            if (this.f20296a) {
                runnable.run();
            } else {
                this.f20300e.add(runnable);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        if (r0.hasNext() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s() {
        o oVar;
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                if (this.f20300e.isEmpty()) {
                    break;
                }
                list = this.f20300e;
                this.f20300e = arrayList;
            }
            if (oVar == null) {
                oVar.g();
                return;
            }
            return;
            list.clear();
            arrayList = list;
        }
        this.f20300e = null;
        this.f20296a = true;
        oVar = this.f20301f;
        if (oVar == null) {
        }
    }

    public final void t(r rVar) {
        Iterator it = this.f20304i.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f20304i = null;
        this.f20298c.g(rVar);
    }

    public void u(y8.k1 k1Var) {
    }

    public final void v(q qVar) {
        q qVar2 = this.f20298c;
        Preconditions.checkState(qVar2 == null, "realStream already set to %s", qVar2);
        this.f20298c = qVar;
        this.f20303h = System.nanoTime();
    }

    public final Runnable w(q qVar) {
        synchronized (this) {
            if (this.f20298c != null) {
                return null;
            }
            v((q) Preconditions.checkNotNull(qVar, "stream"));
            r rVar = this.f20297b;
            if (rVar == null) {
                this.f20300e = null;
                this.f20296a = true;
            }
            if (rVar == null) {
                return null;
            }
            t(rVar);
            return new i();
        }
    }
}
