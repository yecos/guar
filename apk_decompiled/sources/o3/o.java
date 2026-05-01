package o3;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class o extends n3.t {

    /* renamed from: o, reason: collision with root package name */
    public final r3.j f17552o;

    /* renamed from: p, reason: collision with root package name */
    public final transient Method f17553p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f17554q;

    public o(r3.s sVar, k3.j jVar, w3.e eVar, d4.b bVar, r3.j jVar2) {
        super(sVar, jVar, eVar, bVar);
        this.f17552o = jVar2;
        this.f17553p = jVar2.b();
        this.f17554q = q.b(this.f17256i);
    }

    @Override // n3.t
    public final void C(Object obj, Object obj2) {
        try {
            this.f17553p.invoke(obj, obj2);
        } catch (Exception e10) {
            i(e10, obj2);
        }
    }

    @Override // n3.t
    public Object D(Object obj, Object obj2) {
        try {
            Object invoke = this.f17553p.invoke(obj, obj2);
            return invoke == null ? obj : invoke;
        } catch (Exception e10) {
            i(e10, obj2);
            return null;
        }
    }

    @Override // n3.t
    public n3.t I(k3.x xVar) {
        return new o(this, xVar);
    }

    @Override // n3.t
    public n3.t J(n3.q qVar) {
        return new o(this, this.f17254g, qVar);
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
        return new o(this, kVar, qVar);
    }

    @Override // n3.t, k3.d
    public r3.i d() {
        return this.f17552o;
    }

    @Override // n3.t
    public void l(c3.k kVar, k3.g gVar, Object obj) {
        Object deserializeWithType;
        if (!kVar.j0(c3.n.VALUE_NULL)) {
            w3.e eVar = this.f17255h;
            if (eVar == null) {
                Object deserialize = this.f17254g.deserialize(kVar, gVar);
                if (deserialize != null) {
                    deserializeWithType = deserialize;
                } else if (this.f17554q) {
                    return;
                } else {
                    deserializeWithType = this.f17256i.getNullValue(gVar);
                }
            } else {
                deserializeWithType = this.f17254g.deserializeWithType(kVar, gVar, eVar);
            }
        } else if (this.f17554q) {
            return;
        } else {
            deserializeWithType = this.f17256i.getNullValue(gVar);
        }
        try {
            this.f17553p.invoke(obj, deserializeWithType);
        } catch (Exception e10) {
            h(kVar, e10, deserializeWithType);
        }
    }

    @Override // n3.t
    public Object m(c3.k kVar, k3.g gVar, Object obj) {
        Object deserializeWithType;
        if (!kVar.j0(c3.n.VALUE_NULL)) {
            w3.e eVar = this.f17255h;
            if (eVar == null) {
                Object deserialize = this.f17254g.deserialize(kVar, gVar);
                if (deserialize != null) {
                    deserializeWithType = deserialize;
                } else {
                    if (this.f17554q) {
                        return obj;
                    }
                    deserializeWithType = this.f17256i.getNullValue(gVar);
                }
            } else {
                deserializeWithType = this.f17254g.deserializeWithType(kVar, gVar, eVar);
            }
        } else {
            if (this.f17554q) {
                return obj;
            }
            deserializeWithType = this.f17256i.getNullValue(gVar);
        }
        try {
            Object invoke = this.f17553p.invoke(obj, deserializeWithType);
            return invoke == null ? obj : invoke;
        } catch (Exception e10) {
            h(kVar, e10, deserializeWithType);
            return null;
        }
    }

    @Override // n3.t
    public void o(k3.f fVar) {
        this.f17552o.i(fVar.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public o(o oVar, k3.k kVar, n3.q qVar) {
        super(oVar, kVar, qVar);
        this.f17552o = oVar.f17552o;
        this.f17553p = oVar.f17553p;
        this.f17554q = q.b(qVar);
    }

    public o(o oVar, k3.x xVar) {
        super(oVar, xVar);
        this.f17552o = oVar.f17552o;
        this.f17553p = oVar.f17553p;
        this.f17554q = oVar.f17554q;
    }
}
