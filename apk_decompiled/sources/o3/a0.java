package o3;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a0 extends n3.t {

    /* renamed from: o, reason: collision with root package name */
    public final r3.j f17480o;

    /* renamed from: p, reason: collision with root package name */
    public final Method f17481p;

    public a0(r3.s sVar, k3.j jVar, w3.e eVar, d4.b bVar, r3.j jVar2) {
        super(sVar, jVar, eVar, bVar);
        this.f17480o = jVar2;
        this.f17481p = jVar2.b();
    }

    @Override // n3.t
    public final void C(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should never call `set()` on setterless property ('" + getName() + "')");
    }

    @Override // n3.t
    public Object D(Object obj, Object obj2) {
        C(obj, obj2);
        return obj;
    }

    @Override // n3.t
    public n3.t I(k3.x xVar) {
        return new a0(this, xVar);
    }

    @Override // n3.t
    public n3.t J(n3.q qVar) {
        return new a0(this, this.f17254g, qVar);
    }

    @Override // n3.t
    public n3.t L(k3.k kVar) {
        k3.k kVar2 = this.f17254g;
        if (kVar2 == kVar) {
            return this;
        }
        n3.q qVar = this.f17256i;
        if (kVar2 == qVar) {
            qVar = kVar;
        }
        return new a0(this, kVar, qVar);
    }

    @Override // n3.t, k3.d
    public r3.i d() {
        return this.f17480o;
    }

    @Override // n3.t
    public final void l(c3.k kVar, k3.g gVar, Object obj) {
        if (kVar.j0(c3.n.VALUE_NULL)) {
            return;
        }
        if (this.f17255h != null) {
            gVar.q(getType(), String.format("Problem deserializing 'setterless' property (\"%s\"): no way to handle typed deser with setterless yet", getName()));
        }
        try {
            Object invoke = this.f17481p.invoke(obj, null);
            if (invoke == null) {
                gVar.q(getType(), String.format("Problem deserializing 'setterless' property '%s': get method returned null", getName()));
            }
            this.f17254g.deserialize(kVar, gVar, invoke);
        } catch (Exception e10) {
            g(kVar, e10);
        }
    }

    @Override // n3.t
    public Object m(c3.k kVar, k3.g gVar, Object obj) {
        l(kVar, gVar, obj);
        return obj;
    }

    @Override // n3.t
    public void o(k3.f fVar) {
        this.f17480o.i(fVar.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public a0(a0 a0Var, k3.k kVar, n3.q qVar) {
        super(a0Var, kVar, qVar);
        this.f17480o = a0Var.f17480o;
        this.f17481p = a0Var.f17481p;
    }

    public a0(a0 a0Var, k3.x xVar) {
        super(a0Var, xVar);
        this.f17480o = a0Var.f17480o;
        this.f17481p = a0Var.f17481p;
    }
}
