package b4;

import b3.k0;
import b3.n0;
import r3.b0;

/* loaded from: classes.dex */
public class j extends n0 {

    /* renamed from: b, reason: collision with root package name */
    public final a4.c f4610b;

    public j(b0 b0Var, a4.c cVar) {
        this(b0Var.f(), cVar);
    }

    @Override // b3.n0, b3.l0, b3.k0
    public boolean a(k0 k0Var) {
        if (k0Var.getClass() != getClass()) {
            return false;
        }
        j jVar = (j) k0Var;
        return jVar.d() == this.f4545a && jVar.f4610b == this.f4610b;
    }

    @Override // b3.k0
    public k0 b(Class cls) {
        return cls == this.f4545a ? this : new j(cls, this.f4610b);
    }

    @Override // b3.k0
    public Object c(Object obj) {
        try {
            return this.f4610b.p(obj);
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new IllegalStateException("Problem accessing property '" + this.f4610b.getName() + "': " + e11.getMessage(), e11);
        }
    }

    @Override // b3.k0
    public k0.a f(Object obj) {
        if (obj == null) {
            return null;
        }
        return new k0.a(getClass(), this.f4545a, obj);
    }

    @Override // b3.k0
    public k0 h(Object obj) {
        return this;
    }

    public j(Class cls, a4.c cVar) {
        super(cls);
        this.f4610b = cVar;
    }
}
