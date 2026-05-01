package z8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import y8.o0;
import z8.j1;
import z8.r;

/* loaded from: classes3.dex */
public final class a0 implements j1 {

    /* renamed from: c, reason: collision with root package name */
    public final Executor f20269c;

    /* renamed from: d, reason: collision with root package name */
    public final y8.o1 f20270d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f20271e;

    /* renamed from: f, reason: collision with root package name */
    public Runnable f20272f;

    /* renamed from: g, reason: collision with root package name */
    public Runnable f20273g;

    /* renamed from: h, reason: collision with root package name */
    public j1.a f20274h;

    /* renamed from: j, reason: collision with root package name */
    public y8.k1 f20276j;

    /* renamed from: k, reason: collision with root package name */
    public o0.i f20277k;

    /* renamed from: l, reason: collision with root package name */
    public long f20278l;

    /* renamed from: a, reason: collision with root package name */
    public final y8.i0 f20267a = y8.i0.a(a0.class, null);

    /* renamed from: b, reason: collision with root package name */
    public final Object f20268b = new Object();

    /* renamed from: i, reason: collision with root package name */
    public Collection f20275i = new LinkedHashSet();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j1.a f20279a;

        public a(j1.a aVar) {
            this.f20279a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20279a.b(true);
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j1.a f20281a;

        public b(j1.a aVar) {
            this.f20281a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20281a.b(false);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j1.a f20283a;

        public c(j1.a aVar) {
            this.f20283a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20283a.d();
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.k1 f20285a;

        public d(y8.k1 k1Var) {
            this.f20285a = k1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.f20274h.c(this.f20285a);
        }
    }

    public class e extends b0 {

        /* renamed from: j, reason: collision with root package name */
        public final o0.f f20287j;

        /* renamed from: k, reason: collision with root package name */
        public final y8.r f20288k;

        /* renamed from: l, reason: collision with root package name */
        public final y8.k[] f20289l;

        public /* synthetic */ e(a0 a0Var, o0.f fVar, y8.k[] kVarArr, a aVar) {
            this(fVar, kVarArr);
        }

        public final Runnable A(s sVar) {
            y8.r b10 = this.f20288k.b();
            try {
                q b11 = sVar.b(this.f20287j.c(), this.f20287j.b(), this.f20287j.a(), this.f20289l);
                this.f20288k.f(b10);
                return w(b11);
            } catch (Throwable th) {
                this.f20288k.f(b10);
                throw th;
            }
        }

        @Override // z8.b0, z8.q
        public void e(y8.k1 k1Var) {
            super.e(k1Var);
            synchronized (a0.this.f20268b) {
                if (a0.this.f20273g != null) {
                    boolean remove = a0.this.f20275i.remove(this);
                    if (!a0.this.q() && remove) {
                        a0.this.f20270d.b(a0.this.f20272f);
                        if (a0.this.f20276j != null) {
                            a0.this.f20270d.b(a0.this.f20273g);
                            a0.this.f20273g = null;
                        }
                    }
                }
            }
            a0.this.f20270d.a();
        }

        @Override // z8.b0, z8.q
        public void p(w0 w0Var) {
            if (this.f20287j.a().j()) {
                w0Var.a("wait_for_ready");
            }
            super.p(w0Var);
        }

        @Override // z8.b0
        public void u(y8.k1 k1Var) {
            for (y8.k kVar : this.f20289l) {
                kVar.i(k1Var);
            }
        }

        public e(o0.f fVar, y8.k[] kVarArr) {
            this.f20288k = y8.r.e();
            this.f20287j = fVar;
            this.f20289l = kVarArr;
        }
    }

    public a0(Executor executor, y8.o1 o1Var) {
        this.f20269c = executor;
        this.f20270d = o1Var;
    }

    @Override // z8.s
    public final q b(y8.w0 w0Var, y8.v0 v0Var, y8.c cVar, y8.k[] kVarArr) {
        q f0Var;
        try {
            r1 r1Var = new r1(w0Var, v0Var, cVar);
            o0.i iVar = null;
            long j10 = -1;
            while (true) {
                synchronized (this.f20268b) {
                    if (this.f20276j == null) {
                        o0.i iVar2 = this.f20277k;
                        if (iVar2 != null) {
                            if (iVar != null && j10 == this.f20278l) {
                                f0Var = o(r1Var, kVarArr);
                                break;
                            }
                            j10 = this.f20278l;
                            s j11 = q0.j(iVar2.a(r1Var), cVar.j());
                            if (j11 != null) {
                                f0Var = j11.b(r1Var.c(), r1Var.b(), r1Var.a(), kVarArr);
                                break;
                            }
                            iVar = iVar2;
                        } else {
                            f0Var = o(r1Var, kVarArr);
                            break;
                        }
                    } else {
                        f0Var = new f0(this.f20276j, kVarArr);
                        break;
                    }
                }
            }
            return f0Var;
        } finally {
            this.f20270d.a();
        }
    }

    @Override // z8.j1
    public final void c(y8.k1 k1Var) {
        Runnable runnable;
        synchronized (this.f20268b) {
            if (this.f20276j != null) {
                return;
            }
            this.f20276j = k1Var;
            this.f20270d.b(new d(k1Var));
            if (!q() && (runnable = this.f20273g) != null) {
                this.f20270d.b(runnable);
                this.f20273g = null;
            }
            this.f20270d.a();
        }
    }

    @Override // y8.m0
    public y8.i0 d() {
        return this.f20267a;
    }

    @Override // z8.j1
    public final Runnable e(j1.a aVar) {
        this.f20274h = aVar;
        this.f20271e = new a(aVar);
        this.f20272f = new b(aVar);
        this.f20273g = new c(aVar);
        return null;
    }

    @Override // z8.j1
    public final void g(y8.k1 k1Var) {
        Collection<e> collection;
        Runnable runnable;
        c(k1Var);
        synchronized (this.f20268b) {
            collection = this.f20275i;
            runnable = this.f20273g;
            this.f20273g = null;
            if (!collection.isEmpty()) {
                this.f20275i = Collections.emptyList();
            }
        }
        if (runnable != null) {
            for (e eVar : collection) {
                Runnable w10 = eVar.w(new f0(k1Var, r.a.REFUSED, eVar.f20289l));
                if (w10 != null) {
                    w10.run();
                }
            }
            this.f20270d.execute(runnable);
        }
    }

    public final e o(o0.f fVar, y8.k[] kVarArr) {
        e eVar = new e(this, fVar, kVarArr, null);
        this.f20275i.add(eVar);
        if (p() == 1) {
            this.f20270d.b(this.f20271e);
        }
        return eVar;
    }

    public final int p() {
        int size;
        synchronized (this.f20268b) {
            size = this.f20275i.size();
        }
        return size;
    }

    public final boolean q() {
        boolean z10;
        synchronized (this.f20268b) {
            z10 = !this.f20275i.isEmpty();
        }
        return z10;
    }

    public final void r(o0.i iVar) {
        Runnable runnable;
        synchronized (this.f20268b) {
            this.f20277k = iVar;
            this.f20278l++;
            if (iVar != null && q()) {
                ArrayList arrayList = new ArrayList(this.f20275i);
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    e eVar = (e) it.next();
                    o0.e a10 = iVar.a(eVar.f20287j);
                    y8.c a11 = eVar.f20287j.a();
                    s j10 = q0.j(a10, a11.j());
                    if (j10 != null) {
                        Executor executor = this.f20269c;
                        if (a11.e() != null) {
                            executor = a11.e();
                        }
                        Runnable A = eVar.A(j10);
                        if (A != null) {
                            executor.execute(A);
                        }
                        arrayList2.add(eVar);
                    }
                }
                synchronized (this.f20268b) {
                    if (q()) {
                        this.f20275i.removeAll(arrayList2);
                        if (this.f20275i.isEmpty()) {
                            this.f20275i = new LinkedHashSet();
                        }
                        if (!q()) {
                            this.f20270d.b(this.f20272f);
                            if (this.f20276j != null && (runnable = this.f20273g) != null) {
                                this.f20270d.b(runnable);
                                this.f20273g = null;
                            }
                        }
                        this.f20270d.a();
                    }
                }
            }
        }
    }
}
