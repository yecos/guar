package o3;

import b3.k0;

/* loaded from: classes.dex */
public final class u extends n3.t {

    /* renamed from: o, reason: collision with root package name */
    public final s f17570o;

    public u(s sVar, k3.w wVar) {
        super(sVar.f17563b, sVar.c(), wVar, sVar.b());
        this.f17570o = sVar;
    }

    @Override // n3.t
    public void C(Object obj, Object obj2) {
        D(obj, obj2);
    }

    @Override // n3.t
    public Object D(Object obj, Object obj2) {
        n3.t tVar = this.f17570o.f17566e;
        if (tVar != null) {
            return tVar.D(obj, obj2);
        }
        throw new UnsupportedOperationException("Should not call set() on ObjectIdProperty that has no SettableBeanProperty");
    }

    @Override // n3.t
    public n3.t I(k3.x xVar) {
        return new u(this, xVar);
    }

    @Override // n3.t
    public n3.t J(n3.q qVar) {
        return new u(this, this.f17254g, qVar);
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
        return new u(this, kVar, qVar);
    }

    @Override // n3.t, k3.d
    public r3.i d() {
        return null;
    }

    @Override // n3.t
    public void l(c3.k kVar, k3.g gVar, Object obj) {
        m(kVar, gVar, obj);
    }

    @Override // n3.t
    public Object m(c3.k kVar, k3.g gVar, Object obj) {
        if (kVar.j0(c3.n.VALUE_NULL)) {
            return null;
        }
        Object deserialize = this.f17254g.deserialize(kVar, gVar);
        s sVar = this.f17570o;
        k0 k0Var = sVar.f17564c;
        sVar.getClass();
        gVar.H(deserialize, k0Var, null).b(obj);
        n3.t tVar = this.f17570o.f17566e;
        return tVar != null ? tVar.D(obj, deserialize) : obj;
    }

    public u(u uVar, k3.k kVar, n3.q qVar) {
        super(uVar, kVar, qVar);
        this.f17570o = uVar.f17570o;
    }

    public u(u uVar, k3.x xVar) {
        super(uVar, xVar);
        this.f17570o = uVar.f17570o;
    }
}
