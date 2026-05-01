package a4;

import d4.a0;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import k3.c0;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f222a = new HashMap(64);

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f223b = new AtomicReference();

    public final synchronized b4.l a() {
        b4.l lVar;
        lVar = (b4.l) this.f223b.get();
        if (lVar == null) {
            lVar = b4.l.b(this.f222a);
            this.f223b.set(lVar);
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(Class cls, k3.j jVar, k3.o oVar, c0 c0Var) {
        synchronized (this) {
            Object put = this.f222a.put(new a0(cls, false), oVar);
            Object put2 = this.f222a.put(new a0(jVar, false), oVar);
            if (put == null || put2 == null) {
                this.f223b.set(null);
            }
            if (oVar instanceof o) {
                ((o) oVar).a(c0Var);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(k3.j jVar, k3.o oVar, c0 c0Var) {
        synchronized (this) {
            if (this.f222a.put(new a0(jVar, false), oVar) == null) {
                this.f223b.set(null);
            }
            if (oVar instanceof o) {
                ((o) oVar).a(c0Var);
            }
        }
    }

    public void d(Class cls, k3.o oVar) {
        synchronized (this) {
            if (this.f222a.put(new a0(cls, true), oVar) == null) {
                this.f223b.set(null);
            }
        }
    }

    public void e(k3.j jVar, k3.o oVar) {
        synchronized (this) {
            if (this.f222a.put(new a0(jVar, true), oVar) == null) {
                this.f223b.set(null);
            }
        }
    }

    public b4.l f() {
        b4.l lVar = (b4.l) this.f223b.get();
        return lVar != null ? lVar : a();
    }

    public k3.o g(Class cls) {
        k3.o oVar;
        synchronized (this) {
            oVar = (k3.o) this.f222a.get(new a0(cls, true));
        }
        return oVar;
    }

    public k3.o h(k3.j jVar) {
        k3.o oVar;
        synchronized (this) {
            oVar = (k3.o) this.f222a.get(new a0(jVar, true));
        }
        return oVar;
    }

    public k3.o i(Class cls) {
        k3.o oVar;
        synchronized (this) {
            oVar = (k3.o) this.f222a.get(new a0(cls, false));
        }
        return oVar;
    }

    public k3.o j(k3.j jVar) {
        k3.o oVar;
        synchronized (this) {
            oVar = (k3.o) this.f222a.get(new a0(jVar, false));
        }
        return oVar;
    }
}
