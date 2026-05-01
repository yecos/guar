package b1;

import a1.s;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import com.google.common.util.concurrent.ListenableFuture;
import j1.p;
import j1.q;
import j1.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import k1.o;

/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: t, reason: collision with root package name */
    public static final String f4427t = a1.k.f("WorkerWrapper");

    /* renamed from: a, reason: collision with root package name */
    public Context f4428a;

    /* renamed from: b, reason: collision with root package name */
    public String f4429b;

    /* renamed from: c, reason: collision with root package name */
    public List f4430c;

    /* renamed from: d, reason: collision with root package name */
    public WorkerParameters.a f4431d;

    /* renamed from: e, reason: collision with root package name */
    public p f4432e;

    /* renamed from: f, reason: collision with root package name */
    public ListenableWorker f4433f;

    /* renamed from: g, reason: collision with root package name */
    public m1.a f4434g;

    /* renamed from: i, reason: collision with root package name */
    public androidx.work.a f4436i;

    /* renamed from: j, reason: collision with root package name */
    public i1.a f4437j;

    /* renamed from: k, reason: collision with root package name */
    public WorkDatabase f4438k;

    /* renamed from: l, reason: collision with root package name */
    public q f4439l;

    /* renamed from: m, reason: collision with root package name */
    public j1.b f4440m;

    /* renamed from: n, reason: collision with root package name */
    public t f4441n;

    /* renamed from: o, reason: collision with root package name */
    public List f4442o;

    /* renamed from: p, reason: collision with root package name */
    public String f4443p;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f4446s;

    /* renamed from: h, reason: collision with root package name */
    public ListenableWorker.a f4435h = ListenableWorker.a.a();

    /* renamed from: q, reason: collision with root package name */
    public l1.c f4444q = l1.c.s();

    /* renamed from: r, reason: collision with root package name */
    public ListenableFuture f4445r = null;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f4447a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l1.c f4448b;

        public a(ListenableFuture listenableFuture, l1.c cVar) {
            this.f4447a = listenableFuture;
            this.f4448b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f4447a.get();
                a1.k.c().a(k.f4427t, String.format("Starting work for %s", k.this.f4432e.f14585c), new Throwable[0]);
                k kVar = k.this;
                kVar.f4445r = kVar.f4433f.p();
                this.f4448b.q(k.this.f4445r);
            } catch (Throwable th) {
                this.f4448b.p(th);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l1.c f4450a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4451b;

        public b(l1.c cVar, String str) {
            this.f4450a = cVar;
            this.f4451b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    ListenableWorker.a aVar = (ListenableWorker.a) this.f4450a.get();
                    if (aVar == null) {
                        a1.k.c().b(k.f4427t, String.format("%s returned a null result. Treating it as a failure.", k.this.f4432e.f14585c), new Throwable[0]);
                    } else {
                        a1.k.c().a(k.f4427t, String.format("%s returned a %s result.", k.this.f4432e.f14585c, aVar), new Throwable[0]);
                        k.this.f4435h = aVar;
                    }
                } catch (InterruptedException e10) {
                    e = e10;
                    a1.k.c().b(k.f4427t, String.format("%s failed because it threw an exception/error", this.f4451b), e);
                } catch (CancellationException e11) {
                    a1.k.c().d(k.f4427t, String.format("%s was cancelled", this.f4451b), e11);
                } catch (ExecutionException e12) {
                    e = e12;
                    a1.k.c().b(k.f4427t, String.format("%s failed because it threw an exception/error", this.f4451b), e);
                }
            } finally {
                k.this.f();
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Context f4453a;

        /* renamed from: b, reason: collision with root package name */
        public ListenableWorker f4454b;

        /* renamed from: c, reason: collision with root package name */
        public i1.a f4455c;

        /* renamed from: d, reason: collision with root package name */
        public m1.a f4456d;

        /* renamed from: e, reason: collision with root package name */
        public androidx.work.a f4457e;

        /* renamed from: f, reason: collision with root package name */
        public WorkDatabase f4458f;

        /* renamed from: g, reason: collision with root package name */
        public String f4459g;

        /* renamed from: h, reason: collision with root package name */
        public List f4460h;

        /* renamed from: i, reason: collision with root package name */
        public WorkerParameters.a f4461i = new WorkerParameters.a();

        public c(Context context, androidx.work.a aVar, m1.a aVar2, i1.a aVar3, WorkDatabase workDatabase, String str) {
            this.f4453a = context.getApplicationContext();
            this.f4456d = aVar2;
            this.f4455c = aVar3;
            this.f4457e = aVar;
            this.f4458f = workDatabase;
            this.f4459g = str;
        }

        public k a() {
            return new k(this);
        }

        public c b(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.f4461i = aVar;
            }
            return this;
        }

        public c c(List list) {
            this.f4460h = list;
            return this;
        }
    }

    public k(c cVar) {
        this.f4428a = cVar.f4453a;
        this.f4434g = cVar.f4456d;
        this.f4437j = cVar.f4455c;
        this.f4429b = cVar.f4459g;
        this.f4430c = cVar.f4460h;
        this.f4431d = cVar.f4461i;
        this.f4433f = cVar.f4454b;
        this.f4436i = cVar.f4457e;
        WorkDatabase workDatabase = cVar.f4458f;
        this.f4438k = workDatabase;
        this.f4439l = workDatabase.B();
        this.f4440m = this.f4438k.t();
        this.f4441n = this.f4438k.C();
    }

    public final String a(List list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f4429b);
        sb.append(", tags={ ");
        Iterator it = list.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z10) {
                z10 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    public ListenableFuture b() {
        return this.f4444q;
    }

    public final void c(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            a1.k.c().d(f4427t, String.format("Worker result SUCCESS for %s", this.f4443p), new Throwable[0]);
            if (this.f4432e.d()) {
                h();
                return;
            } else {
                m();
                return;
            }
        }
        if (aVar instanceof ListenableWorker.a.b) {
            a1.k.c().d(f4427t, String.format("Worker result RETRY for %s", this.f4443p), new Throwable[0]);
            g();
            return;
        }
        a1.k.c().d(f4427t, String.format("Worker result FAILURE for %s", this.f4443p), new Throwable[0]);
        if (this.f4432e.d()) {
            h();
        } else {
            l();
        }
    }

    public void d() {
        boolean z10;
        this.f4446s = true;
        n();
        ListenableFuture listenableFuture = this.f4445r;
        if (listenableFuture != null) {
            z10 = listenableFuture.isDone();
            this.f4445r.cancel(true);
        } else {
            z10 = false;
        }
        ListenableWorker listenableWorker = this.f4433f;
        if (listenableWorker == null || z10) {
            a1.k.c().a(f4427t, String.format("WorkSpec %s is already done. Not interrupting.", this.f4432e), new Throwable[0]);
        } else {
            listenableWorker.q();
        }
    }

    public final void e(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.f4439l.g(str2) != s.CANCELLED) {
                this.f4439l.d(s.FAILED, str2);
            }
            linkedList.addAll(this.f4440m.a(str2));
        }
    }

    public void f() {
        if (!n()) {
            this.f4438k.c();
            try {
                s g10 = this.f4439l.g(this.f4429b);
                this.f4438k.A().a(this.f4429b);
                if (g10 == null) {
                    i(false);
                } else if (g10 == s.RUNNING) {
                    c(this.f4435h);
                } else if (!g10.a()) {
                    g();
                }
                this.f4438k.r();
            } finally {
                this.f4438k.g();
            }
        }
        List list = this.f4430c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((e) it.next()).cancel(this.f4429b);
            }
            f.b(this.f4436i, this.f4438k, this.f4430c);
        }
    }

    public final void g() {
        this.f4438k.c();
        try {
            this.f4439l.d(s.ENQUEUED, this.f4429b);
            this.f4439l.t(this.f4429b, System.currentTimeMillis());
            this.f4439l.l(this.f4429b, -1L);
            this.f4438k.r();
        } finally {
            this.f4438k.g();
            i(true);
        }
    }

    public final void h() {
        this.f4438k.c();
        try {
            this.f4439l.t(this.f4429b, System.currentTimeMillis());
            this.f4439l.d(s.ENQUEUED, this.f4429b);
            this.f4439l.r(this.f4429b);
            this.f4439l.l(this.f4429b, -1L);
            this.f4438k.r();
        } finally {
            this.f4438k.g();
            i(false);
        }
    }

    public final void i(boolean z10) {
        ListenableWorker listenableWorker;
        this.f4438k.c();
        try {
            if (!this.f4438k.B().q()) {
                k1.g.a(this.f4428a, RescheduleReceiver.class, false);
            }
            if (z10) {
                this.f4439l.d(s.ENQUEUED, this.f4429b);
                this.f4439l.l(this.f4429b, -1L);
            }
            if (this.f4432e != null && (listenableWorker = this.f4433f) != null && listenableWorker.j()) {
                this.f4437j.a(this.f4429b);
            }
            this.f4438k.r();
            this.f4438k.g();
            this.f4444q.o(Boolean.valueOf(z10));
        } catch (Throwable th) {
            this.f4438k.g();
            throw th;
        }
    }

    public final void j() {
        s g10 = this.f4439l.g(this.f4429b);
        if (g10 == s.RUNNING) {
            a1.k.c().a(f4427t, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.f4429b), new Throwable[0]);
            i(true);
        } else {
            a1.k.c().a(f4427t, String.format("Status for %s is %s; not doing any work", this.f4429b, g10), new Throwable[0]);
            i(false);
        }
    }

    public final void k() {
        androidx.work.b b10;
        if (n()) {
            return;
        }
        this.f4438k.c();
        try {
            p h10 = this.f4439l.h(this.f4429b);
            this.f4432e = h10;
            if (h10 == null) {
                a1.k.c().b(f4427t, String.format("Didn't find WorkSpec for id %s", this.f4429b), new Throwable[0]);
                i(false);
                this.f4438k.r();
                return;
            }
            if (h10.f14584b != s.ENQUEUED) {
                j();
                this.f4438k.r();
                a1.k.c().a(f4427t, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f4432e.f14585c), new Throwable[0]);
                return;
            }
            if (h10.d() || this.f4432e.c()) {
                long currentTimeMillis = System.currentTimeMillis();
                p pVar = this.f4432e;
                if (!(pVar.f14596n == 0) && currentTimeMillis < pVar.a()) {
                    a1.k.c().a(f4427t, String.format("Delaying execution for %s because it is being executed before schedule.", this.f4432e.f14585c), new Throwable[0]);
                    i(true);
                    this.f4438k.r();
                    return;
                }
            }
            this.f4438k.r();
            this.f4438k.g();
            if (this.f4432e.d()) {
                b10 = this.f4432e.f14587e;
            } else {
                a1.h b11 = this.f4436i.f().b(this.f4432e.f14586d);
                if (b11 == null) {
                    a1.k.c().b(f4427t, String.format("Could not create Input Merger %s", this.f4432e.f14586d), new Throwable[0]);
                    l();
                    return;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f4432e.f14587e);
                    arrayList.addAll(this.f4439l.i(this.f4429b));
                    b10 = b11.b(arrayList);
                }
            }
            WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f4429b), b10, this.f4442o, this.f4431d, this.f4432e.f14593k, this.f4436i.e(), this.f4434g, this.f4436i.m(), new k1.q(this.f4438k, this.f4434g), new k1.p(this.f4438k, this.f4437j, this.f4434g));
            if (this.f4433f == null) {
                this.f4433f = this.f4436i.m().b(this.f4428a, this.f4432e.f14585c, workerParameters);
            }
            ListenableWorker listenableWorker = this.f4433f;
            if (listenableWorker == null) {
                a1.k.c().b(f4427t, String.format("Could not create Worker %s", this.f4432e.f14585c), new Throwable[0]);
                l();
                return;
            }
            if (listenableWorker.l()) {
                a1.k.c().b(f4427t, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f4432e.f14585c), new Throwable[0]);
                l();
                return;
            }
            this.f4433f.o();
            if (!o()) {
                j();
                return;
            }
            if (n()) {
                return;
            }
            l1.c s10 = l1.c.s();
            o oVar = new o(this.f4428a, this.f4432e, this.f4433f, workerParameters.b(), this.f4434g);
            this.f4434g.a().execute(oVar);
            ListenableFuture a10 = oVar.a();
            a10.addListener(new a(a10, s10), this.f4434g.a());
            s10.addListener(new b(s10, this.f4443p), this.f4434g.c());
        } finally {
            this.f4438k.g();
        }
    }

    public void l() {
        this.f4438k.c();
        try {
            e(this.f4429b);
            this.f4439l.o(this.f4429b, ((ListenableWorker.a.C0058a) this.f4435h).e());
            this.f4438k.r();
        } finally {
            this.f4438k.g();
            i(false);
        }
    }

    public final void m() {
        this.f4438k.c();
        try {
            this.f4439l.d(s.SUCCEEDED, this.f4429b);
            this.f4439l.o(this.f4429b, ((ListenableWorker.a.c) this.f4435h).e());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.f4440m.a(this.f4429b)) {
                if (this.f4439l.g(str) == s.BLOCKED && this.f4440m.b(str)) {
                    a1.k.c().d(f4427t, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                    this.f4439l.d(s.ENQUEUED, str);
                    this.f4439l.t(str, currentTimeMillis);
                }
            }
            this.f4438k.r();
        } finally {
            this.f4438k.g();
            i(false);
        }
    }

    public final boolean n() {
        if (!this.f4446s) {
            return false;
        }
        a1.k.c().a(f4427t, String.format("Work interrupted for %s", this.f4443p), new Throwable[0]);
        if (this.f4439l.g(this.f4429b) == null) {
            i(false);
        } else {
            i(!r0.a());
        }
        return true;
    }

    public final boolean o() {
        this.f4438k.c();
        try {
            boolean z10 = false;
            if (this.f4439l.g(this.f4429b) == s.ENQUEUED) {
                this.f4439l.d(s.RUNNING, this.f4429b);
                this.f4439l.s(this.f4429b);
                z10 = true;
            }
            this.f4438k.r();
            return z10;
        } finally {
            this.f4438k.g();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        List a10 = this.f4441n.a(this.f4429b);
        this.f4442o = a10;
        this.f4443p = a(a10);
        k();
    }
}
