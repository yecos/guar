package n3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import o3.y;
import o3.z;

/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: v, reason: collision with root package name */
    public transient Exception f17182v;

    /* renamed from: w, reason: collision with root package name */
    public volatile transient d4.q f17183w;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17184a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17185b;

        static {
            int[] iArr = new int[m3.b.values().length];
            f17185b = iArr;
            try {
                iArr[m3.b.AsEmpty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17185b[m3.b.AsNull.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17185b[m3.b.TryConvert.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[c3.n.values().length];
            f17184a = iArr2;
            try {
                iArr2[c3.n.VALUE_STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17184a[c3.n.VALUE_NUMBER_INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17184a[c3.n.VALUE_NUMBER_FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17184a[c3.n.VALUE_EMBEDDED_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17184a[c3.n.VALUE_TRUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17184a[c3.n.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17184a[c3.n.VALUE_NULL.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17184a[c3.n.START_ARRAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17184a[c3.n.FIELD_NAME.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f17184a[c3.n.END_OBJECT.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public static class b extends z.a {

        /* renamed from: c, reason: collision with root package name */
        public final k3.g f17186c;

        /* renamed from: d, reason: collision with root package name */
        public final t f17187d;

        /* renamed from: e, reason: collision with root package name */
        public Object f17188e;

        public b(k3.g gVar, u uVar, k3.j jVar, y yVar, t tVar) {
            super(uVar, jVar);
            this.f17186c = gVar;
            this.f17187d = tVar;
        }

        public void c(Object obj) {
            this.f17188e = obj;
        }
    }

    public c(e eVar, k3.c cVar, o3.c cVar2, Map map, HashSet hashSet, boolean z10, Set set, boolean z11) {
        super(eVar, cVar, cVar2, map, hashSet, z10, set, z11);
    }

    @Override // n3.d
    public d G(o3.c cVar) {
        return new c(this, cVar);
    }

    @Override // n3.d
    public d I(boolean z10) {
        return new c(this, z10);
    }

    public Exception M() {
        if (this.f17182v == null) {
            this.f17182v = new NullPointerException("JSON Creator returned null");
        }
        return this.f17182v;
    }

    public final Object N(c3.k kVar, k3.g gVar, c3.n nVar) {
        if (nVar != null) {
            switch (a.f17184a[nVar.ordinal()]) {
                case 1:
                    return v(kVar, gVar);
                case 2:
                    return r(kVar, gVar);
                case 3:
                    return p(kVar, gVar);
                case 4:
                    return q(kVar, gVar);
                case 5:
                case 6:
                    return o(kVar, gVar);
                case 7:
                    return Q(kVar, gVar);
                case 8:
                    return _deserializeFromArray(kVar, gVar);
                case 9:
                case 10:
                    return this.f17197h ? Z(kVar, gVar, nVar) : this.f17209t != null ? w(kVar, gVar) : s(kVar, gVar);
            }
        }
        return gVar.c0(getValueType(gVar), kVar);
    }

    public final Object O(c3.k kVar, k3.g gVar, t tVar) {
        try {
            return tVar.k(kVar, gVar);
        } catch (Exception e10) {
            K(e10, this.f17190a.q(), tVar.getName(), gVar);
            return null;
        }
    }

    public Object P(c3.k kVar, k3.g gVar, Object obj, o3.g gVar2) {
        Class J = this.f17204o ? gVar.J() : null;
        c3.n n10 = kVar.n();
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            c3.n s02 = kVar.s0();
            t k10 = this.f17198i.k(m10);
            if (k10 != null) {
                if (s02.e()) {
                    gVar2.h(kVar, gVar, m10, obj);
                }
                if (J == null || k10.H(J)) {
                    try {
                        k10.l(kVar, gVar, obj);
                    } catch (Exception e10) {
                        K(e10, obj, m10, gVar);
                    }
                } else {
                    kVar.D0();
                }
            } else if (d4.m.c(m10, this.f17201l, this.f17202m)) {
                A(kVar, gVar, obj, m10);
            } else if (!gVar2.g(kVar, gVar, m10, obj)) {
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
        return gVar2.e(kVar, gVar, obj);
    }

    public Object Q(c3.k kVar, k3.g gVar) {
        if (!kVar.z0()) {
            return gVar.c0(getValueType(gVar), kVar);
        }
        d4.y yVar = new d4.y(kVar, gVar);
        yVar.W();
        c3.k S0 = yVar.S0(kVar);
        S0.s0();
        Object Z = this.f17197h ? Z(S0, gVar, c3.n.END_OBJECT) : s(S0, gVar);
        S0.close();
        return Z;
    }

    public Object R(c3.k kVar, k3.g gVar) {
        o3.g i10 = this.f17208s.i();
        o3.v vVar = this.f17195f;
        y e10 = vVar.e(kVar, gVar, this.f17209t);
        Class J = this.f17204o ? gVar.J() : null;
        c3.n n10 = kVar.n();
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            c3.n s02 = kVar.s0();
            t d10 = vVar.d(m10);
            if (!e10.i(m10) || d10 != null) {
                if (d10 == null) {
                    t k10 = this.f17198i.k(m10);
                    if (k10 != null) {
                        if (s02.e()) {
                            i10.h(kVar, gVar, m10, null);
                        }
                        if (J == null || k10.H(J)) {
                            e10.e(k10, k10.k(kVar, gVar));
                        } else {
                            kVar.D0();
                        }
                    } else if (!i10.g(kVar, gVar, m10, null)) {
                        if (d4.m.c(m10, this.f17201l, this.f17202m)) {
                            A(kVar, gVar, handledType(), m10);
                        } else {
                            s sVar = this.f17200k;
                            if (sVar != null) {
                                e10.c(sVar, m10, sVar.b(kVar, gVar));
                            } else {
                                handleUnknownProperty(kVar, gVar, this._valueClass, m10);
                            }
                        }
                    }
                } else if (!i10.g(kVar, gVar, m10, null) && e10.b(d10, O(kVar, gVar, d10))) {
                    kVar.s0();
                    try {
                        Object a10 = vVar.a(gVar, e10);
                        if (a10.getClass() == this.f17190a.q()) {
                            return P(kVar, gVar, a10, i10);
                        }
                        k3.j jVar = this.f17190a;
                        return gVar.q(jVar, String.format("Cannot create polymorphic instances with external type ids (%s -> %s)", jVar, a10.getClass()));
                    } catch (Exception e11) {
                        K(e11, this.f17190a.q(), m10, gVar);
                    }
                }
            }
            n10 = kVar.s0();
        }
        try {
            return i10.f(kVar, gVar, e10, vVar);
        } catch (Exception e12) {
            return L(e12, gVar);
        }
    }

    public Object S(c3.k kVar, k3.g gVar) {
        Object L;
        o3.v vVar = this.f17195f;
        y e10 = vVar.e(kVar, gVar, this.f17209t);
        d4.y yVar = new d4.y(kVar, gVar);
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
                        e10.e(k10, O(kVar, gVar, k10));
                    } else if (d4.m.c(m10, this.f17201l, this.f17202m)) {
                        A(kVar, gVar, handledType(), m10);
                    } else if (this.f17200k == null) {
                        yVar.Z(m10);
                        yVar.V0(kVar);
                    } else {
                        d4.y Q0 = d4.y.Q0(kVar);
                        yVar.Z(m10);
                        yVar.P0(Q0);
                        try {
                            s sVar = this.f17200k;
                            e10.c(sVar, m10, sVar.b(Q0.U0(), gVar));
                        } catch (Exception e11) {
                            K(e11, this.f17190a.q(), m10, gVar);
                        }
                    }
                } else if (e10.b(d10, O(kVar, gVar, d10))) {
                    c3.n s02 = kVar.s0();
                    try {
                        L = vVar.a(gVar, e10);
                    } catch (Exception e12) {
                        L = L(e12, gVar);
                    }
                    kVar.A0(L);
                    while (s02 == c3.n.FIELD_NAME) {
                        yVar.V0(kVar);
                        s02 = kVar.s0();
                    }
                    c3.n nVar = c3.n.END_OBJECT;
                    if (s02 != nVar) {
                        gVar.G0(this, nVar, "Attempted to unwrap '%s' value", handledType().getName());
                    }
                    yVar.W();
                    if (L.getClass() == this.f17190a.q()) {
                        return this.f17207r.b(kVar, gVar, L, yVar);
                    }
                    gVar.x0(d10, "Cannot create polymorphic instances with unwrapped values", new Object[0]);
                    return null;
                }
            }
            n10 = kVar.s0();
        }
        try {
            return this.f17207r.b(kVar, gVar, vVar.a(gVar, e10), yVar);
        } catch (Exception e13) {
            L(e13, gVar);
            return null;
        }
    }

    public Object T(c3.k kVar, k3.g gVar) {
        if (this.f17195f != null) {
            return R(kVar, gVar);
        }
        k3.k kVar2 = this.f17193d;
        return kVar2 != null ? this.f17192c.y(gVar, kVar2.deserialize(kVar, gVar)) : U(kVar, gVar, this.f17192c.x(gVar));
    }

    public Object U(c3.k kVar, k3.g gVar, Object obj) {
        return P(kVar, gVar, obj, this.f17208s.i());
    }

    public Object V(c3.k kVar, k3.g gVar) {
        k3.k kVar2 = this.f17193d;
        if (kVar2 != null) {
            return this.f17192c.y(gVar, kVar2.deserialize(kVar, gVar));
        }
        if (this.f17195f != null) {
            return S(kVar, gVar);
        }
        d4.y yVar = new d4.y(kVar, gVar);
        yVar.v0();
        Object x10 = this.f17192c.x(gVar);
        kVar.A0(x10);
        if (this.f17199j != null) {
            E(gVar, x10);
        }
        Class J = this.f17204o ? gVar.J() : null;
        String m10 = kVar.k0(5) ? kVar.m() : null;
        while (m10 != null) {
            kVar.s0();
            t k10 = this.f17198i.k(m10);
            if (k10 != null) {
                if (J == null || k10.H(J)) {
                    try {
                        k10.l(kVar, gVar, x10);
                    } catch (Exception e10) {
                        K(e10, x10, m10, gVar);
                    }
                } else {
                    kVar.D0();
                }
            } else if (d4.m.c(m10, this.f17201l, this.f17202m)) {
                A(kVar, gVar, x10, m10);
            } else if (this.f17200k == null) {
                yVar.Z(m10);
                yVar.V0(kVar);
            } else {
                d4.y Q0 = d4.y.Q0(kVar);
                yVar.Z(m10);
                yVar.P0(Q0);
                try {
                    this.f17200k.c(Q0.U0(), gVar, x10, m10);
                } catch (Exception e11) {
                    K(e11, x10, m10, gVar);
                }
            }
            m10 = kVar.q0();
        }
        yVar.W();
        this.f17207r.b(kVar, gVar, x10, yVar);
        return x10;
    }

    public Object W(c3.k kVar, k3.g gVar, Object obj) {
        c3.n n10 = kVar.n();
        if (n10 == c3.n.START_OBJECT) {
            n10 = kVar.s0();
        }
        d4.y yVar = new d4.y(kVar, gVar);
        yVar.v0();
        Class J = this.f17204o ? gVar.J() : null;
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            t k10 = this.f17198i.k(m10);
            kVar.s0();
            if (k10 != null) {
                if (J == null || k10.H(J)) {
                    try {
                        k10.l(kVar, gVar, obj);
                    } catch (Exception e10) {
                        K(e10, obj, m10, gVar);
                    }
                } else {
                    kVar.D0();
                }
            } else if (d4.m.c(m10, this.f17201l, this.f17202m)) {
                A(kVar, gVar, obj, m10);
            } else if (this.f17200k == null) {
                yVar.Z(m10);
                yVar.V0(kVar);
            } else {
                d4.y Q0 = d4.y.Q0(kVar);
                yVar.Z(m10);
                yVar.P0(Q0);
                try {
                    this.f17200k.c(Q0.U0(), gVar, obj, m10);
                } catch (Exception e11) {
                    K(e11, obj, m10, gVar);
                }
            }
            n10 = kVar.s0();
        }
        yVar.W();
        this.f17207r.b(kVar, gVar, obj, yVar);
        return obj;
    }

    public final Object X(c3.k kVar, k3.g gVar, Object obj, Class cls) {
        if (kVar.k0(5)) {
            String m10 = kVar.m();
            do {
                kVar.s0();
                t k10 = this.f17198i.k(m10);
                if (k10 == null) {
                    D(kVar, gVar, obj, m10);
                } else if (k10.H(cls)) {
                    try {
                        k10.l(kVar, gVar, obj);
                    } catch (Exception e10) {
                        K(e10, obj, m10, gVar);
                    }
                } else {
                    kVar.D0();
                }
                m10 = kVar.q0();
            } while (m10 != null);
        }
        return obj;
    }

    public final b Y(k3.g gVar, t tVar, y yVar, u uVar) {
        b bVar = new b(gVar, uVar, tVar.getType(), yVar, tVar);
        uVar.t().a(bVar);
        return bVar;
    }

    public final Object Z(c3.k kVar, k3.g gVar, c3.n nVar) {
        Object x10 = this.f17192c.x(gVar);
        kVar.A0(x10);
        if (kVar.k0(5)) {
            String m10 = kVar.m();
            do {
                kVar.s0();
                t k10 = this.f17198i.k(m10);
                if (k10 != null) {
                    try {
                        k10.l(kVar, gVar, x10);
                    } catch (Exception e10) {
                        K(e10, x10, m10, gVar);
                    }
                } else {
                    D(kVar, gVar, x10, m10);
                }
                m10 = kVar.q0();
            } while (m10 != null);
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
            return w10;
        }
        m3.b _findCoercionFromEmptyArray = _findCoercionFromEmptyArray(gVar);
        boolean n02 = gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (n02 || _findCoercionFromEmptyArray != m3.b.Fail) {
            c3.n s02 = kVar.s0();
            c3.n nVar = c3.n.END_ARRAY;
            if (s02 == nVar) {
                int i10 = a.f17185b[_findCoercionFromEmptyArray.ordinal()];
                return i10 != 1 ? (i10 == 2 || i10 == 3) ? getNullValue(gVar) : gVar.d0(getValueType(gVar), c3.n.START_ARRAY, kVar, null, new Object[0]) : getEmptyValue(gVar);
            }
            if (n02) {
                c3.n s03 = kVar.s0();
                c3.n nVar2 = c3.n.START_ARRAY;
                if (s03 == nVar2) {
                    k3.j valueType = getValueType(gVar);
                    return gVar.d0(valueType, nVar2, kVar, "Cannot deserialize value of type %s from deeply-nested JSON Array: only single wrapper allowed with `%s`", d4.h.G(valueType), "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS");
                }
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
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public c H(Set set, Set set2) {
        return new c(this, set, set2);
    }

    @Override // n3.d
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public c J(o3.s sVar) {
        return new c(this, sVar);
    }

    @Override // n3.d
    public Object c(c3.k kVar, k3.g gVar) {
        Object obj;
        Object L;
        o3.v vVar = this.f17195f;
        y e10 = vVar.e(kVar, gVar, this.f17209t);
        Class J = this.f17204o ? gVar.J() : null;
        c3.n n10 = kVar.n();
        ArrayList arrayList = null;
        d4.y yVar = null;
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t d10 = vVar.d(m10);
            if (!e10.i(m10) || d10 != null) {
                if (d10 == null) {
                    t k10 = this.f17198i.k(m10);
                    if (k10 != null) {
                        try {
                            e10.e(k10, O(kVar, gVar, k10));
                        } catch (u e11) {
                            b Y = Y(gVar, k10, e10, e11);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(Y);
                        }
                    } else if (d4.m.c(m10, this.f17201l, this.f17202m)) {
                        A(kVar, gVar, handledType(), m10);
                    } else {
                        s sVar = this.f17200k;
                        if (sVar != null) {
                            try {
                                e10.c(sVar, m10, sVar.b(kVar, gVar));
                            } catch (Exception e12) {
                                K(e12, this.f17190a.q(), m10, gVar);
                            }
                        } else {
                            if (yVar == null) {
                                yVar = new d4.y(kVar, gVar);
                            }
                            yVar.Z(m10);
                            yVar.V0(kVar);
                        }
                    }
                } else if (J != null && !d10.H(J)) {
                    kVar.D0();
                } else if (e10.b(d10, O(kVar, gVar, d10))) {
                    kVar.s0();
                    try {
                        L = vVar.a(gVar, e10);
                    } catch (Exception e13) {
                        L = L(e13, gVar);
                    }
                    if (L == null) {
                        return gVar.V(handledType(), null, M());
                    }
                    kVar.A0(L);
                    if (L.getClass() != this.f17190a.q()) {
                        return B(kVar, gVar, L, yVar);
                    }
                    if (yVar != null) {
                        L = C(gVar, L, yVar);
                    }
                    return deserialize(kVar, gVar, L);
                }
            }
            n10 = kVar.s0();
        }
        try {
            obj = vVar.a(gVar, e10);
        } catch (Exception e14) {
            L(e14, gVar);
            obj = null;
        }
        if (this.f17199j != null) {
            E(gVar, obj);
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).c(obj);
            }
        }
        return yVar != null ? obj.getClass() != this.f17190a.q() ? B(null, gVar, obj, yVar) : C(gVar, obj, yVar) : obj;
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar) {
        if (!kVar.o0()) {
            return N(kVar, gVar, kVar.n());
        }
        if (this.f17197h) {
            return Z(kVar, gVar, kVar.s0());
        }
        kVar.s0();
        return this.f17209t != null ? w(kVar, gVar) : s(kVar, gVar);
    }

    @Override // n3.d
    public d n() {
        return new o3.b(this, this.f17198i.m());
    }

    @Override // n3.d
    public Object s(c3.k kVar, k3.g gVar) {
        Class J;
        Object U;
        o3.s sVar = this.f17209t;
        if (sVar != null && sVar.e() && kVar.k0(5) && this.f17209t.d(kVar.m(), kVar)) {
            return t(kVar, gVar);
        }
        if (this.f17196g) {
            return this.f17207r != null ? V(kVar, gVar) : this.f17208s != null ? T(kVar, gVar) : u(kVar, gVar);
        }
        Object x10 = this.f17192c.x(gVar);
        kVar.A0(x10);
        if (kVar.c() && (U = kVar.U()) != null) {
            h(kVar, gVar, x10, U);
        }
        if (this.f17199j != null) {
            E(gVar, x10);
        }
        if (this.f17204o && (J = gVar.J()) != null) {
            return X(kVar, gVar, x10, J);
        }
        if (kVar.k0(5)) {
            String m10 = kVar.m();
            do {
                kVar.s0();
                t k10 = this.f17198i.k(m10);
                if (k10 != null) {
                    try {
                        k10.l(kVar, gVar, x10);
                    } catch (Exception e10) {
                        K(e10, x10, m10, gVar);
                    }
                } else {
                    D(kVar, gVar, x10, m10);
                }
                m10 = kVar.q0();
            } while (m10 != null);
        }
        return x10;
    }

    @Override // n3.d, k3.k
    public k3.k unwrappingDeserializer(d4.q qVar) {
        if (getClass() != c.class) {
            return this;
        }
        if (this.f17183w == qVar) {
            return this;
        }
        this.f17183w = qVar;
        try {
            return new c(this, qVar);
        } finally {
            this.f17183w = null;
        }
    }

    public c(d dVar) {
        super(dVar, dVar.f17203n);
    }

    public c(d dVar, boolean z10) {
        super(dVar, z10);
    }

    public c(d dVar, d4.q qVar) {
        super(dVar, qVar);
    }

    public c(d dVar, o3.s sVar) {
        super(dVar, sVar);
    }

    public c(d dVar, Set set, Set set2) {
        super(dVar, set, set2);
    }

    public c(d dVar, o3.c cVar) {
        super(dVar, cVar);
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar, Object obj) {
        String m10;
        Class J;
        kVar.A0(obj);
        if (this.f17199j != null) {
            E(gVar, obj);
        }
        if (this.f17207r != null) {
            return W(kVar, gVar, obj);
        }
        if (this.f17208s != null) {
            return U(kVar, gVar, obj);
        }
        if (kVar.o0()) {
            m10 = kVar.q0();
            if (m10 == null) {
                return obj;
            }
        } else {
            if (kVar.k0(5)) {
                m10 = kVar.m();
            }
            return obj;
        }
        if (this.f17204o && (J = gVar.J()) != null) {
            return X(kVar, gVar, obj, J);
        }
        do {
            kVar.s0();
            t k10 = this.f17198i.k(m10);
            if (k10 != null) {
                try {
                    k10.l(kVar, gVar, obj);
                } catch (Exception e10) {
                    K(e10, obj, m10, gVar);
                }
            } else {
                D(kVar, gVar, obj, m10);
            }
            m10 = kVar.q0();
        } while (m10 != null);
        return obj;
    }
}
