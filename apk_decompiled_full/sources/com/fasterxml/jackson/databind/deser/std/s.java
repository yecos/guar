package com.fasterxml.jackson.databind.deser.std;

import b3.p;
import b3.s;
import d4.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o3.z;

/* loaded from: classes.dex */
public class s extends i implements n3.i, n3.r {

    /* renamed from: e, reason: collision with root package name */
    public final k3.p f6593e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6594f;

    /* renamed from: g, reason: collision with root package name */
    public final k3.k f6595g;

    /* renamed from: h, reason: collision with root package name */
    public final w3.e f6596h;

    /* renamed from: i, reason: collision with root package name */
    public final n3.w f6597i;

    /* renamed from: j, reason: collision with root package name */
    public k3.k f6598j;

    /* renamed from: k, reason: collision with root package name */
    public o3.v f6599k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f6600l;

    /* renamed from: m, reason: collision with root package name */
    public Set f6601m;

    /* renamed from: n, reason: collision with root package name */
    public Set f6602n;

    /* renamed from: o, reason: collision with root package name */
    public m.a f6603o;

    public static class a extends z.a {

        /* renamed from: c, reason: collision with root package name */
        public final b f6604c;

        /* renamed from: d, reason: collision with root package name */
        public final Map f6605d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f6606e;

        public a(b bVar, n3.u uVar, Class cls, Object obj) {
            super(uVar, cls);
            this.f6605d = new LinkedHashMap();
            this.f6604c = bVar;
            this.f6606e = obj;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Class f6607a;

        /* renamed from: b, reason: collision with root package name */
        public Map f6608b;

        /* renamed from: c, reason: collision with root package name */
        public List f6609c = new ArrayList();

        public b(Class cls, Map map) {
            this.f6607a = cls;
            this.f6608b = map;
        }

        public z.a a(n3.u uVar, Object obj) {
            a aVar = new a(this, uVar, this.f6607a, obj);
            this.f6609c.add(aVar);
            return aVar;
        }

        public void b(Object obj, Object obj2) {
            if (this.f6609c.isEmpty()) {
                this.f6608b.put(obj, obj2);
            } else {
                ((a) this.f6609c.get(r0.size() - 1)).f6605d.put(obj, obj2);
            }
        }
    }

    public s(k3.j jVar, n3.w wVar, k3.p pVar, k3.k kVar, w3.e eVar) {
        super(jVar, (n3.q) null, (Boolean) null);
        this.f6593e = pVar;
        this.f6595g = kVar;
        this.f6596h = eVar;
        this.f6597i = wVar;
        this.f6600l = wVar.j();
        this.f6598j = null;
        this.f6599k = null;
        this.f6594f = d(jVar, pVar);
        this.f6603o = null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.i
    public k3.k a() {
        return this.f6595g;
    }

    public Map c(c3.k kVar, k3.g gVar) {
        Object deserialize;
        o3.v vVar = this.f6599k;
        o3.y e10 = vVar.e(kVar, gVar, null);
        k3.k kVar2 = this.f6595g;
        w3.e eVar = this.f6596h;
        String q02 = kVar.o0() ? kVar.q0() : kVar.j0(c3.n.FIELD_NAME) ? kVar.m() : null;
        while (q02 != null) {
            c3.n s02 = kVar.s0();
            m.a aVar = this.f6603o;
            if (aVar == null || !aVar.b(q02)) {
                n3.t d10 = vVar.d(q02);
                if (d10 == null) {
                    Object a10 = this.f6593e.a(q02, gVar);
                    try {
                        if (s02 != c3.n.VALUE_NULL) {
                            deserialize = eVar == null ? kVar2.deserialize(kVar, gVar) : kVar2.deserializeWithType(kVar, gVar, eVar);
                        } else if (!this.f6551c) {
                            deserialize = this.f6550b.getNullValue(gVar);
                        }
                        e10.d(a10, deserialize);
                    } catch (Exception e11) {
                        b(gVar, e11, this.f6549a.q(), q02);
                        return null;
                    }
                } else if (e10.b(d10, d10.k(kVar, gVar))) {
                    kVar.s0();
                    try {
                        Map map = (Map) vVar.a(gVar, e10);
                        e(kVar, gVar, map);
                        return map;
                    } catch (Exception e12) {
                        return (Map) b(gVar, e12, this.f6549a.q(), q02);
                    }
                }
            } else {
                kVar.D0();
            }
            q02 = kVar.q0();
        }
        try {
            return (Map) vVar.a(gVar, e10);
        } catch (Exception e13) {
            b(gVar, e13, this.f6549a.q(), q02);
            return null;
        }
    }

    @Override // n3.i
    public k3.k createContextual(k3.g gVar, k3.d dVar) {
        Set set;
        Set set2;
        r3.i d10;
        Set<String> e10;
        k3.p pVar = this.f6593e;
        if (pVar == null) {
            pVar = gVar.F(this.f6549a.p(), dVar);
        }
        k3.p pVar2 = pVar;
        k3.k kVar = this.f6595g;
        if (dVar != null) {
            kVar = findConvertingContentDeserializer(gVar, dVar, kVar);
        }
        k3.j k10 = this.f6549a.k();
        k3.k D = kVar == null ? gVar.D(k10, dVar) : gVar.Z(kVar, dVar, k10);
        w3.e eVar = this.f6596h;
        if (eVar != null) {
            eVar = eVar.g(dVar);
        }
        w3.e eVar2 = eVar;
        Set set3 = this.f6601m;
        Set set4 = this.f6602n;
        k3.b K = gVar.K();
        if (b0._neitherNull(K, dVar) && (d10 = dVar.d()) != null) {
            k3.f k11 = gVar.k();
            p.a K2 = K.K(k11, d10);
            if (K2 != null) {
                Set g10 = K2.g();
                if (!g10.isEmpty()) {
                    set3 = set3 == null ? new HashSet() : new HashSet(set3);
                    Iterator it = g10.iterator();
                    while (it.hasNext()) {
                        set3.add((String) it.next());
                    }
                }
            }
            s.a N = K.N(k11, d10);
            if (N != null && (e10 = N.e()) != null) {
                HashSet hashSet = new HashSet();
                if (set4 == null) {
                    hashSet = new HashSet(e10);
                } else {
                    for (String str : e10) {
                        if (set4.contains(str)) {
                            hashSet.add(str);
                        }
                    }
                }
                set2 = hashSet;
                set = set3;
                return o(pVar2, eVar2, D, findContentNullProvider(gVar, dVar, D), set, set2);
            }
        }
        set = set3;
        set2 = set4;
        return o(pVar2, eVar2, D, findContentNullProvider(gVar, dVar, D), set, set2);
    }

    public final boolean d(k3.j jVar, k3.p pVar) {
        k3.j p10;
        if (pVar == null || (p10 = jVar.p()) == null) {
            return true;
        }
        Class q10 = p10.q();
        return (q10 == String.class || q10 == Object.class) && isDefaultKeyDeserializer(pVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return eVar.e(kVar, gVar);
    }

    public final void e(c3.k kVar, k3.g gVar, Map map) {
        String m10;
        Object deserialize;
        k3.p pVar = this.f6593e;
        k3.k kVar2 = this.f6595g;
        w3.e eVar = this.f6596h;
        boolean z10 = kVar2.getObjectIdReader() != null;
        b bVar = z10 ? new b(this.f6549a.k().q(), map) : null;
        if (kVar.o0()) {
            m10 = kVar.q0();
        } else {
            c3.n n10 = kVar.n();
            c3.n nVar = c3.n.FIELD_NAME;
            if (n10 != nVar) {
                if (n10 == c3.n.END_OBJECT) {
                    return;
                } else {
                    gVar.G0(this, nVar, null, new Object[0]);
                }
            }
            m10 = kVar.m();
        }
        while (m10 != null) {
            Object a10 = pVar.a(m10, gVar);
            c3.n s02 = kVar.s0();
            m.a aVar = this.f6603o;
            if (aVar == null || !aVar.b(m10)) {
                try {
                    if (s02 != c3.n.VALUE_NULL) {
                        deserialize = eVar == null ? kVar2.deserialize(kVar, gVar) : kVar2.deserializeWithType(kVar, gVar, eVar);
                    } else if (!this.f6551c) {
                        deserialize = this.f6550b.getNullValue(gVar);
                    }
                    if (z10) {
                        bVar.b(a10, deserialize);
                    } else {
                        map.put(a10, deserialize);
                    }
                } catch (n3.u e10) {
                    l(gVar, bVar, a10, e10);
                } catch (Exception e11) {
                    b(gVar, e11, map, m10);
                }
            } else {
                kVar.D0();
            }
            m10 = kVar.q0();
        }
    }

    public final void f(c3.k kVar, k3.g gVar, Map map) {
        String m10;
        Object deserialize;
        k3.k kVar2 = this.f6595g;
        w3.e eVar = this.f6596h;
        boolean z10 = kVar2.getObjectIdReader() != null;
        b bVar = z10 ? new b(this.f6549a.k().q(), map) : null;
        if (kVar.o0()) {
            m10 = kVar.q0();
        } else {
            c3.n n10 = kVar.n();
            if (n10 == c3.n.END_OBJECT) {
                return;
            }
            c3.n nVar = c3.n.FIELD_NAME;
            if (n10 != nVar) {
                gVar.G0(this, nVar, null, new Object[0]);
            }
            m10 = kVar.m();
        }
        while (m10 != null) {
            c3.n s02 = kVar.s0();
            m.a aVar = this.f6603o;
            if (aVar == null || !aVar.b(m10)) {
                try {
                    if (s02 != c3.n.VALUE_NULL) {
                        deserialize = eVar == null ? kVar2.deserialize(kVar, gVar) : kVar2.deserializeWithType(kVar, gVar, eVar);
                    } else if (!this.f6551c) {
                        deserialize = this.f6550b.getNullValue(gVar);
                    }
                    if (z10) {
                        bVar.b(m10, deserialize);
                    } else {
                        map.put(m10, deserialize);
                    }
                } catch (n3.u e10) {
                    l(gVar, bVar, m10, e10);
                } catch (Exception e11) {
                    b(gVar, e11, map, m10);
                }
            } else {
                kVar.D0();
            }
            m10 = kVar.q0();
        }
    }

    public final void g(c3.k kVar, k3.g gVar, Map map) {
        String m10;
        k3.p pVar = this.f6593e;
        k3.k kVar2 = this.f6595g;
        w3.e eVar = this.f6596h;
        if (kVar.o0()) {
            m10 = kVar.q0();
        } else {
            c3.n n10 = kVar.n();
            if (n10 == c3.n.END_OBJECT) {
                return;
            }
            c3.n nVar = c3.n.FIELD_NAME;
            if (n10 != nVar) {
                gVar.G0(this, nVar, null, new Object[0]);
            }
            m10 = kVar.m();
        }
        while (m10 != null) {
            Object a10 = pVar.a(m10, gVar);
            c3.n s02 = kVar.s0();
            m.a aVar = this.f6603o;
            if (aVar == null || !aVar.b(m10)) {
                try {
                    if (s02 != c3.n.VALUE_NULL) {
                        Object obj = map.get(a10);
                        Object deserialize = obj != null ? eVar == null ? kVar2.deserialize(kVar, gVar, obj) : kVar2.deserializeWithType(kVar, gVar, eVar, obj) : eVar == null ? kVar2.deserialize(kVar, gVar) : kVar2.deserializeWithType(kVar, gVar, eVar);
                        if (deserialize != obj) {
                            map.put(a10, deserialize);
                        }
                    } else if (!this.f6551c) {
                        map.put(a10, this.f6550b.getNullValue(gVar));
                    }
                } catch (Exception e10) {
                    b(gVar, e10, map, m10);
                }
            } else {
                kVar.D0();
            }
            m10 = kVar.q0();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0
    public n3.w getValueInstantiator() {
        return this.f6597i;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.i, com.fasterxml.jackson.databind.deser.std.b0
    public k3.j getValueType() {
        return this.f6549a;
    }

    public final void h(c3.k kVar, k3.g gVar, Map map) {
        String m10;
        k3.k kVar2 = this.f6595g;
        w3.e eVar = this.f6596h;
        if (kVar.o0()) {
            m10 = kVar.q0();
        } else {
            c3.n n10 = kVar.n();
            if (n10 == c3.n.END_OBJECT) {
                return;
            }
            c3.n nVar = c3.n.FIELD_NAME;
            if (n10 != nVar) {
                gVar.G0(this, nVar, null, new Object[0]);
            }
            m10 = kVar.m();
        }
        while (m10 != null) {
            c3.n s02 = kVar.s0();
            m.a aVar = this.f6603o;
            if (aVar == null || !aVar.b(m10)) {
                try {
                    if (s02 != c3.n.VALUE_NULL) {
                        Object obj = map.get(m10);
                        Object deserialize = obj != null ? eVar == null ? kVar2.deserialize(kVar, gVar, obj) : kVar2.deserializeWithType(kVar, gVar, eVar, obj) : eVar == null ? kVar2.deserialize(kVar, gVar) : kVar2.deserializeWithType(kVar, gVar, eVar);
                        if (deserialize != obj) {
                            map.put(m10, deserialize);
                        }
                    } else if (!this.f6551c) {
                        map.put(m10, this.f6550b.getNullValue(gVar));
                    }
                } catch (Exception e10) {
                    b(gVar, e10, map, m10);
                }
            } else {
                kVar.D0();
            }
            m10 = kVar.q0();
        }
    }

    @Override // k3.k
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Map deserialize(c3.k kVar, k3.g gVar) {
        if (this.f6599k != null) {
            return c(kVar, gVar);
        }
        k3.k kVar2 = this.f6598j;
        if (kVar2 != null) {
            return (Map) this.f6597i.y(gVar, kVar2.deserialize(kVar, gVar));
        }
        if (!this.f6600l) {
            return (Map) gVar.W(k(), getValueInstantiator(), kVar, "no default constructor found", new Object[0]);
        }
        int q10 = kVar.q();
        if (q10 != 1 && q10 != 2) {
            if (q10 == 3) {
                return (Map) _deserializeFromArray(kVar, gVar);
            }
            if (q10 != 5) {
                return q10 != 6 ? (Map) gVar.c0(getValueType(gVar), kVar) : (Map) _deserializeFromString(kVar, gVar);
            }
        }
        Map map = (Map) this.f6597i.x(gVar);
        if (this.f6594f) {
            f(kVar, gVar, map);
            return map;
        }
        e(kVar, gVar, map);
        return map;
    }

    @Override // k3.k
    public boolean isCachable() {
        return this.f6595g == null && this.f6593e == null && this.f6596h == null && this.f6601m == null && this.f6602n == null;
    }

    @Override // k3.k
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Map deserialize(c3.k kVar, k3.g gVar, Map map) {
        kVar.A0(map);
        c3.n n10 = kVar.n();
        if (n10 != c3.n.START_OBJECT && n10 != c3.n.FIELD_NAME) {
            return (Map) gVar.a0(k(), kVar);
        }
        if (this.f6594f) {
            h(kVar, gVar, map);
            return map;
        }
        g(kVar, gVar, map);
        return map;
    }

    public final Class k() {
        return this.f6549a.q();
    }

    public final void l(k3.g gVar, b bVar, Object obj, n3.u uVar) {
        if (bVar == null) {
            gVar.z0(this, "Unresolved forward reference but no identity info: " + uVar, new Object[0]);
        }
        uVar.t().a(bVar.a(uVar, obj));
    }

    @Override // k3.k
    public c4.f logicalType() {
        return c4.f.Map;
    }

    public void m(Set set) {
        if (set == null || set.size() == 0) {
            set = null;
        }
        this.f6601m = set;
        this.f6603o = d4.m.a(set, this.f6602n);
    }

    public void n(Set set) {
        this.f6602n = set;
        this.f6603o = d4.m.a(this.f6601m, set);
    }

    public s o(k3.p pVar, w3.e eVar, k3.k kVar, n3.q qVar, Set set, Set set2) {
        return (this.f6593e == pVar && this.f6595g == kVar && this.f6596h == eVar && this.f6550b == qVar && this.f6601m == set && this.f6602n == set2) ? this : new s(this, pVar, kVar, eVar, qVar, set, set2);
    }

    @Override // n3.r
    public void resolve(k3.g gVar) {
        if (this.f6597i.k()) {
            k3.j D = this.f6597i.D(gVar.k());
            if (D == null) {
                k3.j jVar = this.f6549a;
                gVar.q(jVar, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", jVar, this.f6597i.getClass().getName()));
            }
            this.f6598j = findDeserializer(gVar, D, null);
        } else if (this.f6597i.i()) {
            k3.j A = this.f6597i.A(gVar.k());
            if (A == null) {
                k3.j jVar2 = this.f6549a;
                gVar.q(jVar2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", jVar2, this.f6597i.getClass().getName()));
            }
            this.f6598j = findDeserializer(gVar, A, null);
        }
        if (this.f6597i.g()) {
            this.f6599k = o3.v.c(gVar, this.f6597i, this.f6597i.E(gVar.k()), gVar.o0(k3.q.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        }
        this.f6594f = d(this.f6549a, this.f6593e);
    }

    public s(s sVar, k3.p pVar, k3.k kVar, w3.e eVar, n3.q qVar, Set set, Set set2) {
        super(sVar, qVar, sVar.f6552d);
        this.f6593e = pVar;
        this.f6595g = kVar;
        this.f6596h = eVar;
        this.f6597i = sVar.f6597i;
        this.f6599k = sVar.f6599k;
        this.f6598j = sVar.f6598j;
        this.f6600l = sVar.f6600l;
        this.f6601m = set;
        this.f6602n = set2;
        this.f6603o = d4.m.a(set, set2);
        this.f6594f = d(this.f6549a, pVar);
    }
}
