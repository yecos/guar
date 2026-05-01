package n3;

import d4.y;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: v, reason: collision with root package name */
    public final r3.j f17226v;

    /* renamed from: w, reason: collision with root package name */
    public final k3.j f17227w;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17228a;

        static {
            int[] iArr = new int[m3.b.values().length];
            f17228a = iArr;
            try {
                iArr[m3.b.AsEmpty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17228a[m3.b.AsNull.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17228a[m3.b.TryConvert.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public h(e eVar, k3.c cVar, k3.j jVar, o3.c cVar2, Map map, Set set, boolean z10, Set set2, boolean z11) {
        super(eVar, cVar, cVar2, map, set, z10, set2, z11);
        this.f17227w = jVar;
        this.f17226v = eVar.q();
        if (this.f17209t == null) {
            return;
        }
        throw new IllegalArgumentException("Cannot use Object Id with Builder-based deserialization (type " + cVar.z() + ")");
    }

    @Override // n3.d
    public d G(o3.c cVar) {
        return new h(this, cVar);
    }

    @Override // n3.d
    public d H(Set set, Set set2) {
        return new h(this, set, set2);
    }

    @Override // n3.d
    public d I(boolean z10) {
        return new h(this, z10);
    }

    @Override // n3.d
    public d J(o3.s sVar) {
        return new h(this, sVar);
    }

    public final Object M(c3.k kVar, k3.g gVar, Object obj) {
        Class J;
        if (this.f17199j != null) {
            E(gVar, obj);
        }
        if (this.f17207r != null) {
            if (kVar.j0(c3.n.START_OBJECT)) {
                kVar.s0();
            }
            y yVar = new y(kVar, gVar);
            yVar.v0();
            return S(kVar, gVar, obj, yVar);
        }
        if (this.f17208s != null) {
            return Q(kVar, gVar, obj);
        }
        if (this.f17204o && (J = gVar.J()) != null) {
            return T(kVar, gVar, obj, J);
        }
        c3.n n10 = kVar.n();
        if (n10 == c3.n.START_OBJECT) {
            n10 = kVar.s0();
        }
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t k10 = this.f17198i.k(m10);
            if (k10 != null) {
                try {
                    obj = k10.m(kVar, gVar, obj);
                } catch (Exception e10) {
                    K(e10, obj, m10, gVar);
                }
            } else {
                D(kVar, gVar, obj, m10);
            }
            n10 = kVar.s0();
        }
        return obj;
    }

    public Object N(c3.k kVar, k3.g gVar) {
        k3.j jVar = this.f17227w;
        return gVar.q(jVar, String.format("Deserialization (of %s) with Builder, External type id, @JsonCreator not yet implemented", jVar));
    }

    public Object O(c3.k kVar, k3.g gVar) {
        o3.v vVar = this.f17195f;
        o3.y e10 = vVar.e(kVar, gVar, this.f17209t);
        y yVar = new y(kVar, gVar);
        yVar.v0();
        c3.n n10 = kVar.n();
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t d10 = vVar.d(m10);
            if (!e10.i(m10) || d10 != null) {
                if (d10 == null) {
                    t k10 = this.f17198i.k(m10);
                    if (k10 != null) {
                        e10.e(k10, k10.k(kVar, gVar));
                    } else if (d4.m.c(m10, this.f17201l, this.f17202m)) {
                        A(kVar, gVar, handledType(), m10);
                    } else {
                        yVar.Z(m10);
                        yVar.V0(kVar);
                        s sVar = this.f17200k;
                        if (sVar != null) {
                            e10.c(sVar, m10, sVar.b(kVar, gVar));
                        }
                    }
                } else if (e10.b(d10, d10.k(kVar, gVar))) {
                    kVar.s0();
                    try {
                        Object a10 = vVar.a(gVar, e10);
                        return a10.getClass() != this.f17190a.q() ? B(kVar, gVar, a10, yVar) : S(kVar, gVar, a10, yVar);
                    } catch (Exception e11) {
                        K(e11, this.f17190a.q(), m10, gVar);
                    }
                } else {
                    continue;
                }
            }
            n10 = kVar.s0();
        }
        yVar.W();
        try {
            return this.f17207r.b(kVar, gVar, vVar.a(gVar, e10), yVar);
        } catch (Exception e12) {
            return L(e12, gVar);
        }
    }

    public Object P(c3.k kVar, k3.g gVar) {
        return this.f17195f != null ? N(kVar, gVar) : Q(kVar, gVar, this.f17192c.x(gVar));
    }

    public Object Q(c3.k kVar, k3.g gVar, Object obj) {
        Class J = this.f17204o ? gVar.J() : null;
        o3.g i10 = this.f17208s.i();
        c3.n n10 = kVar.n();
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            c3.n s02 = kVar.s0();
            t k10 = this.f17198i.k(m10);
            if (k10 != null) {
                if (s02.e()) {
                    i10.h(kVar, gVar, m10, obj);
                }
                if (J == null || k10.H(J)) {
                    try {
                        obj = k10.m(kVar, gVar, obj);
                    } catch (Exception e10) {
                        K(e10, obj, m10, gVar);
                    }
                } else {
                    kVar.D0();
                }
            } else if (d4.m.c(m10, this.f17201l, this.f17202m)) {
                A(kVar, gVar, obj, m10);
            } else if (!i10.g(kVar, gVar, m10, obj)) {
                s sVar = this.f17200k;
                if (sVar != null) {
                    try {
                        sVar.c(kVar, gVar, obj, m10);
                    } catch (Exception e11) {
                        K(e11, obj, m10, gVar);
                    }
                } else {
                    handleUnknownProperty(kVar, gVar, obj, m10);
                }
            }
            n10 = kVar.s0();
        }
        return i10.e(kVar, gVar, obj);
    }

    public Object R(c3.k kVar, k3.g gVar) {
        k3.k kVar2 = this.f17193d;
        if (kVar2 != null) {
            return this.f17192c.y(gVar, kVar2.deserialize(kVar, gVar));
        }
        if (this.f17195f != null) {
            return O(kVar, gVar);
        }
        y yVar = new y(kVar, gVar);
        yVar.v0();
        Object x10 = this.f17192c.x(gVar);
        if (this.f17199j != null) {
            E(gVar, x10);
        }
        Class J = this.f17204o ? gVar.J() : null;
        while (kVar.n() == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t k10 = this.f17198i.k(m10);
            if (k10 != null) {
                if (J == null || k10.H(J)) {
                    try {
                        x10 = k10.m(kVar, gVar, x10);
                    } catch (Exception e10) {
                        K(e10, x10, m10, gVar);
                    }
                } else {
                    kVar.D0();
                }
            } else if (d4.m.c(m10, this.f17201l, this.f17202m)) {
                A(kVar, gVar, x10, m10);
            } else {
                yVar.Z(m10);
                yVar.V0(kVar);
                s sVar = this.f17200k;
                if (sVar != null) {
                    try {
                        sVar.c(kVar, gVar, x10, m10);
                    } catch (Exception e11) {
                        K(e11, x10, m10, gVar);
                    }
                }
            }
            kVar.s0();
        }
        yVar.W();
        return this.f17207r.b(kVar, gVar, x10, yVar);
    }

    public Object S(c3.k kVar, k3.g gVar, Object obj, y yVar) {
        Class J = this.f17204o ? gVar.J() : null;
        c3.n n10 = kVar.n();
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            t k10 = this.f17198i.k(m10);
            kVar.s0();
            if (k10 != null) {
                if (J == null || k10.H(J)) {
                    try {
                        obj = k10.m(kVar, gVar, obj);
                    } catch (Exception e10) {
                        K(e10, obj, m10, gVar);
                    }
                } else {
                    kVar.D0();
                }
            } else if (d4.m.c(m10, this.f17201l, this.f17202m)) {
                A(kVar, gVar, obj, m10);
            } else {
                yVar.Z(m10);
                yVar.V0(kVar);
                s sVar = this.f17200k;
                if (sVar != null) {
                    sVar.c(kVar, gVar, obj, m10);
                }
            }
            n10 = kVar.s0();
        }
        yVar.W();
        return this.f17207r.b(kVar, gVar, obj, yVar);
    }

    public final Object T(c3.k kVar, k3.g gVar, Object obj, Class cls) {
        c3.n n10 = kVar.n();
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t k10 = this.f17198i.k(m10);
            if (k10 == null) {
                D(kVar, gVar, obj, m10);
            } else if (k10.H(cls)) {
                try {
                    obj = k10.m(kVar, gVar, obj);
                } catch (Exception e10) {
                    K(e10, obj, m10, gVar);
                }
            } else {
                kVar.D0();
            }
            n10 = kVar.s0();
        }
        return obj;
    }

    public Object U(k3.g gVar, Object obj) {
        r3.j jVar = this.f17226v;
        if (jVar == null) {
            return obj;
        }
        try {
            return jVar.m().invoke(obj, null);
        } catch (Exception e10) {
            return L(e10, gVar);
        }
    }

    public final Object V(c3.k kVar, k3.g gVar, c3.n nVar) {
        Object x10 = this.f17192c.x(gVar);
        while (kVar.n() == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t k10 = this.f17198i.k(m10);
            if (k10 != null) {
                try {
                    x10 = k10.m(kVar, gVar, x10);
                } catch (Exception e10) {
                    K(e10, x10, m10, gVar);
                }
            } else {
                D(kVar, gVar, x10, m10);
            }
            kVar.s0();
        }
        return x10;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0
    public Object _deserializeFromArray(c3.k kVar, k3.g gVar) {
        k3.k kVar2 = this.f17194e;
        if (kVar2 != null || (kVar2 = this.f17193d) != null) {
            Object w10 = this.f17192c.w(gVar, kVar2.deserialize(kVar, gVar));
            if (this.f17199j != null) {
                E(gVar, w10);
            }
            return U(gVar, w10);
        }
        m3.b _findCoercionFromEmptyArray = _findCoercionFromEmptyArray(gVar);
        boolean n02 = gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (n02 || _findCoercionFromEmptyArray != m3.b.Fail) {
            c3.n s02 = kVar.s0();
            c3.n nVar = c3.n.END_ARRAY;
            if (s02 == nVar) {
                int i10 = a.f17228a[_findCoercionFromEmptyArray.ordinal()];
                return i10 != 1 ? (i10 == 2 || i10 == 3) ? getNullValue(gVar) : gVar.d0(getValueType(gVar), c3.n.START_ARRAY, kVar, null, new Object[0]) : getEmptyValue(gVar);
            }
            if (n02) {
                Object deserialize = deserialize(kVar, gVar);
                if (kVar.s0() != nVar) {
                    handleMissingEndArrayForSingle(kVar, gVar);
                }
                return deserialize;
            }
        }
        return gVar.c0(getValueType(gVar), kVar);
    }

    @Override // n3.d
    public Object c(c3.k kVar, k3.g gVar) {
        Object L;
        o3.v vVar = this.f17195f;
        o3.y e10 = vVar.e(kVar, gVar, this.f17209t);
        Class J = this.f17204o ? gVar.J() : null;
        c3.n n10 = kVar.n();
        y yVar = null;
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t d10 = vVar.d(m10);
            if (!e10.i(m10) || d10 != null) {
                if (d10 == null) {
                    t k10 = this.f17198i.k(m10);
                    if (k10 != null) {
                        e10.e(k10, k10.k(kVar, gVar));
                    } else if (d4.m.c(m10, this.f17201l, this.f17202m)) {
                        A(kVar, gVar, handledType(), m10);
                    } else {
                        s sVar = this.f17200k;
                        if (sVar != null) {
                            e10.c(sVar, m10, sVar.b(kVar, gVar));
                        } else {
                            if (yVar == null) {
                                yVar = new y(kVar, gVar);
                            }
                            yVar.Z(m10);
                            yVar.V0(kVar);
                        }
                    }
                } else if (J != null && !d10.H(J)) {
                    kVar.D0();
                } else if (e10.b(d10, d10.k(kVar, gVar))) {
                    kVar.s0();
                    try {
                        Object a10 = vVar.a(gVar, e10);
                        if (a10.getClass() != this.f17190a.q()) {
                            return B(kVar, gVar, a10, yVar);
                        }
                        if (yVar != null) {
                            a10 = C(gVar, a10, yVar);
                        }
                        return M(kVar, gVar, a10);
                    } catch (Exception e11) {
                        K(e11, this.f17190a.q(), m10, gVar);
                    }
                } else {
                    continue;
                }
            }
            n10 = kVar.s0();
        }
        try {
            L = vVar.a(gVar, e10);
        } catch (Exception e12) {
            L = L(e12, gVar);
        }
        return yVar != null ? L.getClass() != this.f17190a.q() ? B(null, gVar, L, yVar) : C(gVar, L, yVar) : L;
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar) {
        if (kVar.o0()) {
            return this.f17197h ? U(gVar, V(kVar, gVar, kVar.s0())) : U(gVar, s(kVar, gVar));
        }
        switch (kVar.q()) {
            case 2:
            case 5:
                return U(gVar, s(kVar, gVar));
            case 3:
                return _deserializeFromArray(kVar, gVar);
            case 4:
            case 11:
            default:
                return gVar.c0(getValueType(gVar), kVar);
            case 6:
                return U(gVar, v(kVar, gVar));
            case 7:
                return U(gVar, r(kVar, gVar));
            case 8:
                return U(gVar, p(kVar, gVar));
            case 9:
            case 10:
                return U(gVar, o(kVar, gVar));
            case 12:
                return kVar.N();
        }
    }

    @Override // n3.d
    public d n() {
        return new o3.a(this, this.f17227w, this.f17198i.m(), this.f17226v);
    }

    @Override // n3.d
    public Object s(c3.k kVar, k3.g gVar) {
        Class J;
        if (this.f17196g) {
            return this.f17207r != null ? R(kVar, gVar) : this.f17208s != null ? P(kVar, gVar) : u(kVar, gVar);
        }
        Object x10 = this.f17192c.x(gVar);
        if (this.f17199j != null) {
            E(gVar, x10);
        }
        if (this.f17204o && (J = gVar.J()) != null) {
            return T(kVar, gVar, x10, J);
        }
        while (kVar.n() == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t k10 = this.f17198i.k(m10);
            if (k10 != null) {
                try {
                    x10 = k10.m(kVar, gVar, x10);
                } catch (Exception e10) {
                    K(e10, x10, m10, gVar);
                }
            } else {
                D(kVar, gVar, x10, m10);
            }
            kVar.s0();
        }
        return x10;
    }

    @Override // n3.d, k3.k
    public Boolean supportsUpdate(k3.f fVar) {
        return Boolean.FALSE;
    }

    @Override // n3.d, k3.k
    public k3.k unwrappingDeserializer(d4.q qVar) {
        return new h(this, qVar);
    }

    public h(h hVar, boolean z10) {
        super(hVar, z10);
        this.f17226v = hVar.f17226v;
        this.f17227w = hVar.f17227w;
    }

    public h(h hVar, d4.q qVar) {
        super(hVar, qVar);
        this.f17226v = hVar.f17226v;
        this.f17227w = hVar.f17227w;
    }

    public h(h hVar, o3.s sVar) {
        super(hVar, sVar);
        this.f17226v = hVar.f17226v;
        this.f17227w = hVar.f17227w;
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar, Object obj) {
        k3.j jVar = this.f17227w;
        Class handledType = handledType();
        Class<?> cls = obj.getClass();
        if (handledType.isAssignableFrom(cls)) {
            return gVar.q(jVar, String.format("Deserialization of %s by passing existing Builder (%s) instance not supported", jVar, handledType.getName()));
        }
        return gVar.q(jVar, String.format("Deserialization of %s by passing existing instance (of %s) not supported", jVar, cls.getName()));
    }

    public h(h hVar, Set set, Set set2) {
        super(hVar, set, set2);
        this.f17226v = hVar.f17226v;
        this.f17227w = hVar.f17227w;
    }

    public h(h hVar, o3.c cVar) {
        super(hVar, cVar);
        this.f17226v = hVar.f17226v;
        this.f17227w = hVar.f17227w;
    }
}
