package o3;

import java.util.Set;

/* loaded from: classes.dex */
public class b extends n3.d {

    /* renamed from: v, reason: collision with root package name */
    public final n3.d f17482v;

    /* renamed from: w, reason: collision with root package name */
    public final n3.t[] f17483w;

    public b(n3.d dVar, n3.t[] tVarArr) {
        super(dVar);
        this.f17482v = dVar;
        this.f17483w = tVarArr;
    }

    @Override // n3.d
    public n3.d G(c cVar) {
        return new b(this.f17482v.G(cVar), this.f17483w);
    }

    @Override // n3.d
    public n3.d H(Set set, Set set2) {
        return new b(this.f17482v.H(set, set2), this.f17483w);
    }

    @Override // n3.d
    public n3.d I(boolean z10) {
        return new b(this.f17482v.I(z10), this.f17483w);
    }

    @Override // n3.d
    public n3.d J(s sVar) {
        return new b(this.f17482v.J(sVar), this.f17483w);
    }

    public Object M(c3.k kVar, k3.g gVar) {
        return gVar.d0(getValueType(gVar), kVar.n(), kVar, "Cannot deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array", d4.h.G(this.f17190a), kVar.n());
    }

    public Object N(c3.k kVar, k3.g gVar) {
        if (this.f17196g) {
            return u(kVar, gVar);
        }
        Object x10 = this.f17192c.x(gVar);
        kVar.A0(x10);
        if (this.f17199j != null) {
            E(gVar, x10);
        }
        Class J = this.f17204o ? gVar.J() : null;
        n3.t[] tVarArr = this.f17483w;
        int length = tVarArr.length;
        int i10 = 0;
        while (true) {
            c3.n s02 = kVar.s0();
            c3.n nVar = c3.n.END_ARRAY;
            if (s02 == nVar) {
                return x10;
            }
            if (i10 == length) {
                if (!this.f17203n) {
                    gVar.G0(this, nVar, "Unexpected JSON values; expected at most %d properties (in JSON Array)", Integer.valueOf(length));
                }
                do {
                    kVar.D0();
                } while (kVar.s0() != c3.n.END_ARRAY);
                return x10;
            }
            n3.t tVar = tVarArr[i10];
            i10++;
            if (tVar == null || !(J == null || tVar.H(J))) {
                kVar.D0();
            } else {
                try {
                    tVar.l(kVar, gVar, x10);
                } catch (Exception e10) {
                    K(e10, x10, tVar.getName(), gVar);
                }
            }
        }
    }

    @Override // n3.d
    public final Object c(c3.k kVar, k3.g gVar) {
        v vVar = this.f17195f;
        y e10 = vVar.e(kVar, gVar, this.f17209t);
        n3.t[] tVarArr = this.f17483w;
        int length = tVarArr.length;
        Class J = this.f17204o ? gVar.J() : null;
        Object obj = null;
        int i10 = 0;
        while (kVar.s0() != c3.n.END_ARRAY) {
            n3.t tVar = i10 < length ? tVarArr[i10] : null;
            if (tVar == null) {
                kVar.D0();
            } else if (J != null && !tVar.H(J)) {
                kVar.D0();
            } else if (obj != null) {
                try {
                    tVar.l(kVar, gVar, obj);
                } catch (Exception e11) {
                    K(e11, obj, tVar.getName(), gVar);
                }
            } else {
                String name = tVar.getName();
                n3.t d10 = vVar.d(name);
                if (!e10.i(name) || d10 != null) {
                    if (d10 == null) {
                        e10.e(tVar, tVar.k(kVar, gVar));
                    } else if (e10.b(d10, d10.k(kVar, gVar))) {
                        try {
                            obj = vVar.a(gVar, e10);
                            kVar.A0(obj);
                            if (obj.getClass() != this.f17190a.q()) {
                                k3.j jVar = this.f17190a;
                                gVar.q(jVar, String.format("Cannot support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type %s, actual type %s", d4.h.G(jVar), d4.h.y(obj)));
                            }
                        } catch (Exception e12) {
                            K(e12, this.f17190a.q(), name, gVar);
                        }
                    }
                }
            }
            i10++;
        }
        if (obj != null) {
            return obj;
        }
        try {
            return vVar.a(gVar, e10);
        } catch (Exception e13) {
            return L(e13, gVar);
        }
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar) {
        if (!kVar.n0()) {
            return M(kVar, gVar);
        }
        if (!this.f17197h) {
            return N(kVar, gVar);
        }
        Object x10 = this.f17192c.x(gVar);
        kVar.A0(x10);
        n3.t[] tVarArr = this.f17483w;
        int length = tVarArr.length;
        int i10 = 0;
        while (true) {
            c3.n s02 = kVar.s0();
            c3.n nVar = c3.n.END_ARRAY;
            if (s02 == nVar) {
                return x10;
            }
            if (i10 == length) {
                if (!this.f17203n && gVar.n0(k3.h.FAIL_ON_UNKNOWN_PROPERTIES)) {
                    gVar.G0(this, nVar, "Unexpected JSON values; expected at most %d properties (in JSON Array)", Integer.valueOf(length));
                }
                do {
                    kVar.D0();
                } while (kVar.s0() != c3.n.END_ARRAY);
                return x10;
            }
            n3.t tVar = tVarArr[i10];
            if (tVar != null) {
                try {
                    tVar.l(kVar, gVar, x10);
                } catch (Exception e10) {
                    K(e10, x10, tVar.getName(), gVar);
                }
            } else {
                kVar.D0();
            }
            i10++;
        }
    }

    @Override // n3.d
    public n3.d n() {
        return this;
    }

    @Override // n3.d
    public Object s(c3.k kVar, k3.g gVar) {
        return M(kVar, gVar);
    }

    @Override // n3.d, k3.k
    public k3.k unwrappingDeserializer(d4.q qVar) {
        return this.f17482v.unwrappingDeserializer(qVar);
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar, Object obj) {
        kVar.A0(obj);
        if (!kVar.n0()) {
            return M(kVar, gVar);
        }
        if (this.f17199j != null) {
            E(gVar, obj);
        }
        n3.t[] tVarArr = this.f17483w;
        int length = tVarArr.length;
        int i10 = 0;
        while (true) {
            c3.n s02 = kVar.s0();
            c3.n nVar = c3.n.END_ARRAY;
            if (s02 == nVar) {
                return obj;
            }
            if (i10 == length) {
                if (!this.f17203n && gVar.n0(k3.h.FAIL_ON_UNKNOWN_PROPERTIES)) {
                    gVar.G0(this, nVar, "Unexpected JSON values; expected at most %d properties (in JSON Array)", Integer.valueOf(length));
                }
                do {
                    kVar.D0();
                } while (kVar.s0() != c3.n.END_ARRAY);
                return obj;
            }
            n3.t tVar = tVarArr[i10];
            if (tVar != null) {
                try {
                    tVar.l(kVar, gVar, obj);
                } catch (Exception e10) {
                    K(e10, obj, tVar.getName(), gVar);
                }
            } else {
                kVar.D0();
            }
            i10++;
        }
    }
}
