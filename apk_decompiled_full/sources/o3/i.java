package o3;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class i extends n3.t {

    /* renamed from: o, reason: collision with root package name */
    public final r3.g f17530o;

    /* renamed from: p, reason: collision with root package name */
    public final transient Field f17531p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f17532q;

    public i(r3.s sVar, k3.j jVar, w3.e eVar, d4.b bVar, r3.g gVar) {
        super(sVar, jVar, eVar, bVar);
        this.f17530o = gVar;
        this.f17531p = gVar.b();
        this.f17532q = q.b(this.f17256i);
    }

    @Override // n3.t
    public void C(Object obj, Object obj2) {
        try {
            this.f17531p.set(obj, obj2);
        } catch (Exception e10) {
            i(e10, obj2);
        }
    }

    @Override // n3.t
    public Object D(Object obj, Object obj2) {
        try {
            this.f17531p.set(obj, obj2);
        } catch (Exception e10) {
            i(e10, obj2);
        }
        return obj;
    }

    @Override // n3.t
    public n3.t I(k3.x xVar) {
        return new i(this, xVar);
    }

    @Override // n3.t
    public n3.t J(n3.q qVar) {
        return new i(this, this.f17254g, qVar);
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
        return new i(this, kVar, qVar);
    }

    @Override // n3.t, k3.d
    public r3.i d() {
        return this.f17530o;
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
                } else if (this.f17532q) {
                    return;
                } else {
                    deserializeWithType = this.f17256i.getNullValue(gVar);
                }
            } else {
                deserializeWithType = this.f17254g.deserializeWithType(kVar, gVar, eVar);
            }
        } else if (this.f17532q) {
            return;
        } else {
            deserializeWithType = this.f17256i.getNullValue(gVar);
        }
        try {
            this.f17531p.set(obj, deserializeWithType);
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
                    if (this.f17532q) {
                        return obj;
                    }
                    deserializeWithType = this.f17256i.getNullValue(gVar);
                }
            } else {
                deserializeWithType = this.f17254g.deserializeWithType(kVar, gVar, eVar);
            }
        } else {
            if (this.f17532q) {
                return obj;
            }
            deserializeWithType = this.f17256i.getNullValue(gVar);
        }
        try {
            this.f17531p.set(obj, deserializeWithType);
        } catch (Exception e10) {
            h(kVar, e10, deserializeWithType);
        }
        return obj;
    }

    @Override // n3.t
    public void o(k3.f fVar) {
        d4.h.g(this.f17531p, fVar.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public i(i iVar, k3.k kVar, n3.q qVar) {
        super(iVar, kVar, qVar);
        this.f17530o = iVar.f17530o;
        this.f17531p = iVar.f17531p;
        this.f17532q = q.b(qVar);
    }

    public i(i iVar, k3.x xVar) {
        super(iVar, xVar);
        this.f17530o = iVar.f17530o;
        this.f17531p = iVar.f17531p;
        this.f17532q = iVar.f17532q;
    }
}
