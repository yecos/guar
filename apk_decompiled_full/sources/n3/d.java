package n3;

import b3.e0;
import b3.k;
import b3.k0;
import b3.n0;
import b3.p;
import c3.k;
import com.fasterxml.jackson.databind.deser.std.b0;
import d4.y;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.d;
import k3.w;
import o3.a0;
import o3.d0;
import o3.e0;
import o3.g;
import o3.z;

/* loaded from: classes.dex */
public abstract class d extends b0 implements i, r {

    /* renamed from: u, reason: collision with root package name */
    public static final k3.x f17189u = new k3.x("#temporary-name");

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f17190a;

    /* renamed from: b, reason: collision with root package name */
    public final k.c f17191b;

    /* renamed from: c, reason: collision with root package name */
    public final w f17192c;

    /* renamed from: d, reason: collision with root package name */
    public k3.k f17193d;

    /* renamed from: e, reason: collision with root package name */
    public k3.k f17194e;

    /* renamed from: f, reason: collision with root package name */
    public o3.v f17195f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f17196g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f17197h;

    /* renamed from: i, reason: collision with root package name */
    public final o3.c f17198i;

    /* renamed from: j, reason: collision with root package name */
    public final e0[] f17199j;

    /* renamed from: k, reason: collision with root package name */
    public s f17200k;

    /* renamed from: l, reason: collision with root package name */
    public final Set f17201l;

    /* renamed from: m, reason: collision with root package name */
    public final Set f17202m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f17203n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f17204o;

    /* renamed from: p, reason: collision with root package name */
    public final Map f17205p;

    /* renamed from: q, reason: collision with root package name */
    public transient HashMap f17206q;

    /* renamed from: r, reason: collision with root package name */
    public d0 f17207r;

    /* renamed from: s, reason: collision with root package name */
    public o3.g f17208s;

    /* renamed from: t, reason: collision with root package name */
    public final o3.s f17209t;

    public d(e eVar, k3.c cVar, o3.c cVar2, Map map, Set set, boolean z10, Set set2, boolean z11) {
        super(cVar.z());
        this.f17190a = cVar.z();
        w t10 = eVar.t();
        this.f17192c = t10;
        this.f17193d = null;
        this.f17194e = null;
        this.f17195f = null;
        this.f17198i = cVar2;
        this.f17205p = map;
        this.f17201l = set;
        this.f17203n = z10;
        this.f17202m = set2;
        this.f17200k = eVar.p();
        List r10 = eVar.r();
        e0[] e0VarArr = (r10 == null || r10.isEmpty()) ? null : (e0[]) r10.toArray(new e0[r10.size()]);
        this.f17199j = e0VarArr;
        o3.s s10 = eVar.s();
        this.f17209t = s10;
        boolean z12 = false;
        this.f17196g = this.f17207r != null || t10.k() || t10.g() || !t10.j();
        this.f17191b = cVar.g(null).i();
        this.f17204o = z11;
        if (!this.f17196g && e0VarArr == null && !z11 && s10 == null) {
            z12 = true;
        }
        this.f17197h = z12;
    }

    public void A(c3.k kVar, k3.g gVar, Object obj, String str) {
        if (gVar.n0(k3.h.FAIL_ON_IGNORED_PROPERTIES)) {
            throw p3.a.v(kVar, obj, str, getKnownPropertyNames());
        }
        kVar.D0();
    }

    public Object B(c3.k kVar, k3.g gVar, Object obj, y yVar) {
        k3.k f10 = f(gVar, obj, yVar);
        if (f10 == null) {
            if (yVar != null) {
                obj = C(gVar, obj, yVar);
            }
            return kVar != null ? deserialize(kVar, gVar, obj) : obj;
        }
        if (yVar != null) {
            yVar.W();
            c3.k R0 = yVar.R0();
            R0.s0();
            obj = f10.deserialize(R0, gVar, obj);
        }
        return kVar != null ? f10.deserialize(kVar, gVar, obj) : obj;
    }

    public Object C(k3.g gVar, Object obj, y yVar) {
        yVar.W();
        c3.k R0 = yVar.R0();
        while (R0.s0() != c3.n.END_OBJECT) {
            String m10 = R0.m();
            R0.s0();
            handleUnknownProperty(R0, gVar, obj, m10);
        }
        return obj;
    }

    public void D(c3.k kVar, k3.g gVar, Object obj, String str) {
        if (d4.m.c(str, this.f17201l, this.f17202m)) {
            A(kVar, gVar, obj, str);
            return;
        }
        s sVar = this.f17200k;
        if (sVar == null) {
            handleUnknownProperty(kVar, gVar, obj, str);
            return;
        }
        try {
            sVar.c(kVar, gVar, obj, str);
        } catch (Exception e10) {
            K(e10, obj, str, gVar);
        }
    }

    public void E(k3.g gVar, Object obj) {
        for (e0 e0Var : this.f17199j) {
            e0Var.g(gVar, obj);
        }
    }

    public final Throwable F(Throwable th, k3.g gVar) {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        d4.h.h0(th);
        boolean z10 = gVar == null || gVar.n0(k3.h.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z10 || !(th instanceof c3.l)) {
                throw ((IOException) th);
            }
        } else if (!z10) {
            d4.h.j0(th);
        }
        return th;
    }

    public abstract d G(o3.c cVar);

    public abstract d H(Set set, Set set2);

    public abstract d I(boolean z10);

    public abstract d J(o3.s sVar);

    public void K(Throwable th, Object obj, String str, k3.g gVar) {
        throw k3.l.q(F(th, gVar), obj, str);
    }

    public Object L(Throwable th, k3.g gVar) {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        d4.h.h0(th);
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        if (!(gVar == null || gVar.n0(k3.h.WRAP_EXCEPTIONS))) {
            d4.h.j0(th);
        }
        return gVar.V(this.f17190a.q(), null, th);
    }

    public Object a(c3.k kVar, k3.g gVar, Object obj, k3.k kVar2) {
        y yVar = new y(kVar, gVar);
        if (obj instanceof String) {
            yVar.z0((String) obj);
        } else if (obj instanceof Long) {
            yVar.e0(((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            yVar.d0(((Integer) obj).intValue());
        } else {
            yVar.a1(obj);
        }
        c3.k R0 = yVar.R0();
        R0.s0();
        return kVar2.deserialize(R0, gVar);
    }

    public final k3.k b() {
        k3.k kVar = this.f17193d;
        return kVar == null ? this.f17194e : kVar;
    }

    public abstract Object c(c3.k kVar, k3.g gVar);

    @Override // n3.i
    public k3.k createContextual(k3.g gVar, k3.d dVar) {
        o3.c cVar;
        o3.c t10;
        r3.b0 B;
        k3.j jVar;
        t tVar;
        k0 n10;
        o3.s sVar = this.f17209t;
        k3.b K = gVar.K();
        r3.i d10 = b0._neitherNull(dVar, K) ? dVar.d() : null;
        if (d10 != null && (B = K.B(d10)) != null) {
            r3.b0 C = K.C(d10, B);
            Class c10 = C.c();
            gVar.o(d10, C);
            if (c10 == n0.class) {
                k3.x d11 = C.d();
                t z10 = z(d11);
                if (z10 == null) {
                    gVar.q(this.f17190a, String.format("Invalid Object Id definition for %s: cannot find property with name %s", d4.h.X(handledType()), d4.h.V(d11)));
                }
                jVar = z10.getType();
                tVar = z10;
                n10 = new o3.w(C.f());
            } else {
                jVar = gVar.l().K(gVar.x(c10), k0.class)[0];
                tVar = null;
                n10 = gVar.n(d10, C);
            }
            k3.j jVar2 = jVar;
            sVar = o3.s.a(jVar2, C.d(), n10, gVar.I(jVar2), tVar, null);
        }
        d J = (sVar == null || sVar == this.f17209t) ? this : J(sVar);
        if (d10 != null) {
            J = g(gVar, K, J, d10);
        }
        k.d findFormatOverrides = findFormatOverrides(gVar, dVar, handledType());
        if (findFormatOverrides != null) {
            r3 = findFormatOverrides.n() ? findFormatOverrides.i() : null;
            Boolean e10 = findFormatOverrides.e(k.a.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
            if (e10 != null && (t10 = (cVar = this.f17198i).t(e10.booleanValue())) != cVar) {
                J = J.G(t10);
            }
        }
        if (r3 == null) {
            r3 = this.f17191b;
        }
        return r3 == k.c.ARRAY ? J.n() : J;
    }

    public final k3.k d(k3.g gVar, k3.j jVar, r3.n nVar) {
        d.a aVar = new d.a(f17189u, jVar, null, nVar, k3.w.f14995i);
        w3.e eVar = (w3.e) jVar.t();
        if (eVar == null) {
            eVar = gVar.k().Z(jVar);
        }
        k3.k kVar = (k3.k) jVar.u();
        k3.k findDeserializer = kVar == null ? findDeserializer(gVar, jVar, aVar) : gVar.Z(kVar, aVar, jVar);
        return eVar != null ? new o3.b0(eVar.g(aVar), findDeserializer) : findDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        Object U;
        if (this.f17209t != null) {
            if (kVar.c() && (U = kVar.U()) != null) {
                return h(kVar, gVar, eVar.e(kVar, gVar), U);
            }
            c3.n n10 = kVar.n();
            if (n10 != null) {
                if (n10.e()) {
                    return t(kVar, gVar);
                }
                if (n10 == c3.n.START_OBJECT) {
                    n10 = kVar.s0();
                }
                if (n10 == c3.n.FIELD_NAME && this.f17209t.e() && this.f17209t.d(kVar.m(), kVar)) {
                    return t(kVar, gVar);
                }
            }
        }
        return eVar.e(kVar, gVar);
    }

    public d4.q e(k3.g gVar, t tVar) {
        d4.q d02;
        r3.i d10 = tVar.d();
        if (d10 == null || (d02 = gVar.K().d0(d10)) == null) {
            return null;
        }
        if (tVar instanceof j) {
            gVar.q(getValueType(), String.format("Cannot define Creator property \"%s\" as `@JsonUnwrapped`: combination not yet supported", tVar.getName()));
        }
        return d02;
    }

    public k3.k f(k3.g gVar, Object obj, y yVar) {
        k3.k kVar;
        synchronized (this) {
            HashMap hashMap = this.f17206q;
            kVar = hashMap == null ? null : (k3.k) hashMap.get(new c4.b(obj.getClass()));
        }
        if (kVar != null) {
            return kVar;
        }
        k3.k I = gVar.I(gVar.x(obj.getClass()));
        if (I != null) {
            synchronized (this) {
                if (this.f17206q == null) {
                    this.f17206q = new HashMap();
                }
                this.f17206q.put(new c4.b(obj.getClass()), I);
            }
        }
        return I;
    }

    @Override // k3.k
    public t findBackReference(String str) {
        Map map = this.f17205p;
        if (map == null) {
            return null;
        }
        return (t) map.get(str);
    }

    public d g(k3.g gVar, k3.b bVar, d dVar, r3.i iVar) {
        k3.f k10 = gVar.k();
        p.a K = bVar.K(k10, iVar);
        if (K.j() && !this.f17203n) {
            dVar = dVar.I(true);
        }
        Set g10 = K.g();
        Set set = dVar.f17201l;
        if (g10.isEmpty()) {
            g10 = set;
        } else if (set != null && !set.isEmpty()) {
            HashSet hashSet = new HashSet(set);
            hashSet.addAll(g10);
            g10 = hashSet;
        }
        Set set2 = dVar.f17202m;
        Set b10 = d4.m.b(set2, bVar.N(k10, iVar).e());
        return (g10 == set && b10 == set2) ? dVar : dVar.H(g10, b10);
    }

    @Override // k3.k
    public d4.a getEmptyAccessPattern() {
        return d4.a.DYNAMIC;
    }

    @Override // k3.k
    public Object getEmptyValue(k3.g gVar) {
        try {
            return this.f17192c.x(gVar);
        } catch (IOException e10) {
            return d4.h.g0(gVar, e10);
        }
    }

    @Override // k3.k
    public Collection getKnownPropertyNames() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f17198i.iterator();
        while (it.hasNext()) {
            arrayList.add(((t) it.next()).getName());
        }
        return arrayList;
    }

    @Override // k3.k
    public d4.a getNullAccessPattern() {
        return d4.a.ALWAYS_NULL;
    }

    @Override // k3.k
    public o3.s getObjectIdReader() {
        return this.f17209t;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0
    public w getValueInstantiator() {
        return this.f17192c;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0
    public k3.j getValueType() {
        return this.f17190a;
    }

    public Object h(c3.k kVar, k3.g gVar, Object obj, Object obj2) {
        k3.k b10 = this.f17209t.b();
        if (b10.handledType() != obj2.getClass()) {
            obj2 = a(kVar, gVar, obj2, b10);
        }
        o3.s sVar = this.f17209t;
        k0 k0Var = sVar.f17564c;
        sVar.getClass();
        gVar.H(obj2, k0Var, null).b(obj);
        t tVar = this.f17209t.f17566e;
        return tVar != null ? tVar.D(obj, obj2) : obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0
    public void handleUnknownProperty(c3.k kVar, k3.g gVar, Object obj, String str) {
        if (this.f17203n) {
            kVar.D0();
            return;
        }
        if (d4.m.c(str, this.f17201l, this.f17202m)) {
            A(kVar, gVar, obj, str);
        }
        super.handleUnknownProperty(kVar, gVar, obj, str);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Class handledType() {
        return this.f17190a.q();
    }

    public void i(o3.c cVar, t[] tVarArr, t tVar, t tVar2) {
        cVar.s(tVar, tVar2);
        if (tVarArr != null) {
            int length = tVarArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (tVarArr[i10] == tVar) {
                    tVarArr[i10] = tVar2;
                    return;
                }
            }
        }
    }

    @Override // k3.k
    public boolean isCachable() {
        return true;
    }

    public t j(k3.g gVar, t tVar) {
        Class q10;
        Class E;
        k3.k u10 = tVar.u();
        if ((u10 instanceof d) && !((d) u10).getValueInstantiator().j() && (E = d4.h.E((q10 = tVar.getType().q()))) != null && E == this.f17190a.q()) {
            for (Constructor<?> constructor : q10.getConstructors()) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == 1 && E.equals(parameterTypes[0])) {
                    if (gVar.u()) {
                        d4.h.g(constructor, gVar.o0(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    return new o3.j(tVar, constructor);
                }
            }
        }
        return tVar;
    }

    public t k(k3.g gVar, t tVar) {
        String r10 = tVar.r();
        if (r10 == null) {
            return tVar;
        }
        t findBackReference = tVar.u().findBackReference(r10);
        if (findBackReference == null) {
            gVar.q(this.f17190a, String.format("Cannot handle managed/back reference %s: no back reference property found from type %s", d4.h.U(r10), d4.h.G(tVar.getType())));
        }
        k3.j jVar = this.f17190a;
        k3.j type = findBackReference.getType();
        boolean D = tVar.getType().D();
        if (!type.q().isAssignableFrom(jVar.q())) {
            gVar.q(this.f17190a, String.format("Cannot handle managed/back reference %s: back reference type (%s) not compatible with managed type (%s)", d4.h.U(r10), d4.h.G(type), jVar.q().getName()));
        }
        return new o3.m(tVar, r10, findBackReference, D);
    }

    public t l(k3.g gVar, t tVar, k3.w wVar) {
        w.a d10 = wVar.d();
        if (d10 != null) {
            k3.k u10 = tVar.u();
            Boolean supportsUpdate = u10.supportsUpdate(gVar.k());
            if (supportsUpdate == null) {
                if (d10.f15005b) {
                    return tVar;
                }
            } else if (!supportsUpdate.booleanValue()) {
                if (!d10.f15005b) {
                    gVar.U(u10);
                }
                return tVar;
            }
            r3.i iVar = d10.f15004a;
            iVar.i(gVar.o0(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            if (!(tVar instanceof a0)) {
                tVar = o3.n.O(tVar, iVar);
            }
        }
        q findValueNullProvider = findValueNullProvider(gVar, tVar, wVar);
        return findValueNullProvider != null ? tVar.J(findValueNullProvider) : tVar;
    }

    @Override // k3.k
    public c4.f logicalType() {
        return c4.f.POJO;
    }

    public t m(k3.g gVar, t tVar) {
        r3.b0 t10 = tVar.t();
        k3.k u10 = tVar.u();
        return (t10 == null && (u10 == null ? null : u10.getObjectIdReader()) == null) ? tVar : new o3.t(tVar, t10);
    }

    public abstract d n();

    public Object o(c3.k kVar, k3.g gVar) {
        k3.k b10 = b();
        if (b10 == null || this.f17192c.c()) {
            return this.f17192c.p(gVar, kVar.n() == c3.n.VALUE_TRUE);
        }
        Object y10 = this.f17192c.y(gVar, b10.deserialize(kVar, gVar));
        if (this.f17199j != null) {
            E(gVar, y10);
        }
        return y10;
    }

    public Object p(c3.k kVar, k3.g gVar) {
        k.b R = kVar.R();
        if (R == k.b.DOUBLE || R == k.b.FLOAT) {
            k3.k b10 = b();
            if (b10 == null || this.f17192c.d()) {
                return this.f17192c.q(gVar, kVar.M());
            }
            Object y10 = this.f17192c.y(gVar, b10.deserialize(kVar, gVar));
            if (this.f17199j != null) {
                E(gVar, y10);
            }
            return y10;
        }
        if (R != k.b.BIG_DECIMAL) {
            return gVar.W(handledType(), getValueInstantiator(), kVar, "no suitable creator method found to deserialize from Number value (%s)", kVar.S());
        }
        k3.k b11 = b();
        if (b11 == null || this.f17192c.a()) {
            return this.f17192c.n(gVar, kVar.L());
        }
        Object y11 = this.f17192c.y(gVar, b11.deserialize(kVar, gVar));
        if (this.f17199j != null) {
            E(gVar, y11);
        }
        return y11;
    }

    public Object q(c3.k kVar, k3.g gVar) {
        if (this.f17209t != null) {
            return t(kVar, gVar);
        }
        k3.k b10 = b();
        if (b10 == null || this.f17192c.h()) {
            Object N = kVar.N();
            return (N == null || this.f17190a.O(N.getClass())) ? N : gVar.h0(this.f17190a, N, kVar);
        }
        Object y10 = this.f17192c.y(gVar, b10.deserialize(kVar, gVar));
        if (this.f17199j != null) {
            E(gVar, y10);
        }
        return y10;
    }

    public Object r(c3.k kVar, k3.g gVar) {
        if (this.f17209t != null) {
            return t(kVar, gVar);
        }
        k3.k b10 = b();
        k.b R = kVar.R();
        if (R == k.b.INT) {
            if (b10 == null || this.f17192c.e()) {
                return this.f17192c.r(gVar, kVar.P());
            }
            Object y10 = this.f17192c.y(gVar, b10.deserialize(kVar, gVar));
            if (this.f17199j != null) {
                E(gVar, y10);
            }
            return y10;
        }
        if (R == k.b.LONG) {
            if (b10 == null || this.f17192c.e()) {
                return this.f17192c.s(gVar, kVar.Q());
            }
            Object y11 = this.f17192c.y(gVar, b10.deserialize(kVar, gVar));
            if (this.f17199j != null) {
                E(gVar, y11);
            }
            return y11;
        }
        if (R != k.b.BIG_INTEGER) {
            return gVar.W(handledType(), getValueInstantiator(), kVar, "no suitable creator method found to deserialize from Number value (%s)", kVar.S());
        }
        if (b10 == null || this.f17192c.b()) {
            return this.f17192c.o(gVar, kVar.s());
        }
        Object y12 = this.f17192c.y(gVar, b10.deserialize(kVar, gVar));
        if (this.f17199j != null) {
            E(gVar, y12);
        }
        return y12;
    }

    @Override // n3.r
    public void resolve(k3.g gVar) {
        t[] tVarArr;
        k3.k u10;
        k3.k unwrappingDeserializer;
        boolean z10 = false;
        g.a aVar = null;
        if (this.f17192c.g()) {
            tVarArr = this.f17192c.E(gVar.k());
            if (this.f17201l != null || this.f17202m != null) {
                int length = tVarArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    if (d4.m.c(tVarArr[i10].getName(), this.f17201l, this.f17202m)) {
                        tVarArr[i10].B();
                    }
                }
            }
        } else {
            tVarArr = null;
        }
        Iterator it = this.f17198i.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            if (!tVar.w()) {
                k3.k x10 = x(gVar, tVar);
                if (x10 == null) {
                    x10 = gVar.G(tVar.getType());
                }
                i(this.f17198i, tVarArr, tVar, tVar.L(x10));
            }
        }
        Iterator it2 = this.f17198i.iterator();
        d0 d0Var = null;
        while (it2.hasNext()) {
            t tVar2 = (t) it2.next();
            t k10 = k(gVar, tVar2.L(gVar.Y(tVar2.u(), tVar2, tVar2.getType())));
            if (!(k10 instanceof o3.m)) {
                k10 = m(gVar, k10);
            }
            d4.q e10 = e(gVar, k10);
            if (e10 == null || (unwrappingDeserializer = (u10 = k10.u()).unwrappingDeserializer(e10)) == u10 || unwrappingDeserializer == null) {
                t j10 = j(gVar, l(gVar, k10, k10.getMetadata()));
                if (j10 != tVar2) {
                    i(this.f17198i, tVarArr, tVar2, j10);
                }
                if (j10.x()) {
                    w3.e v10 = j10.v();
                    if (v10.k() == e0.a.EXTERNAL_PROPERTY) {
                        if (aVar == null) {
                            aVar = o3.g.d(this.f17190a);
                        }
                        aVar.b(j10, v10);
                        this.f17198i.q(j10);
                    }
                }
            } else {
                t L = k10.L(unwrappingDeserializer);
                if (d0Var == null) {
                    d0Var = new d0();
                }
                d0Var.a(L);
                this.f17198i.q(L);
            }
        }
        s sVar = this.f17200k;
        if (sVar != null && !sVar.h()) {
            s sVar2 = this.f17200k;
            this.f17200k = sVar2.j(findDeserializer(gVar, sVar2.g(), this.f17200k.f()));
        }
        if (this.f17192c.k()) {
            k3.j D = this.f17192c.D(gVar.k());
            if (D == null) {
                k3.j jVar = this.f17190a;
                gVar.q(jVar, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", d4.h.G(jVar), d4.h.h(this.f17192c)));
            }
            this.f17193d = d(gVar, D, this.f17192c.C());
        }
        if (this.f17192c.i()) {
            k3.j A = this.f17192c.A(gVar.k());
            if (A == null) {
                k3.j jVar2 = this.f17190a;
                gVar.q(jVar2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", d4.h.G(jVar2), d4.h.h(this.f17192c)));
            }
            this.f17194e = d(gVar, A, this.f17192c.z());
        }
        if (tVarArr != null) {
            this.f17195f = o3.v.b(gVar, this.f17192c, tVarArr, this.f17198i);
        }
        if (aVar != null) {
            this.f17208s = aVar.c(this.f17198i);
            this.f17196g = true;
        }
        this.f17207r = d0Var;
        if (d0Var != null) {
            this.f17196g = true;
        }
        if (this.f17197h && !this.f17196g) {
            z10 = true;
        }
        this.f17197h = z10;
    }

    public abstract Object s(c3.k kVar, k3.g gVar);

    @Override // k3.k
    public Boolean supportsUpdate(k3.f fVar) {
        return Boolean.TRUE;
    }

    public Object t(c3.k kVar, k3.g gVar) {
        Object f10 = this.f17209t.f(kVar, gVar);
        o3.s sVar = this.f17209t;
        k0 k0Var = sVar.f17564c;
        sVar.getClass();
        z H = gVar.H(f10, k0Var, null);
        Object f11 = H.f();
        if (f11 != null) {
            return f11;
        }
        throw new u(kVar, "Could not resolve Object Id [" + f10 + "] (for " + this.f17190a + ").", kVar.z(), H);
    }

    public Object u(c3.k kVar, k3.g gVar) {
        k3.k b10 = b();
        if (b10 != null) {
            Object y10 = this.f17192c.y(gVar, b10.deserialize(kVar, gVar));
            if (this.f17199j != null) {
                E(gVar, y10);
            }
            return y10;
        }
        if (this.f17195f != null) {
            return c(kVar, gVar);
        }
        Class q10 = this.f17190a.q();
        return d4.h.Q(q10) ? gVar.W(q10, null, kVar, "non-static inner classes like this can only by instantiated using default, no-argument constructor", new Object[0]) : gVar.W(q10, getValueInstantiator(), kVar, "cannot deserialize from Object value (no delegate- or property-based Creator)", new Object[0]);
    }

    @Override // k3.k
    public abstract k3.k unwrappingDeserializer(d4.q qVar);

    public Object v(c3.k kVar, k3.g gVar) {
        if (this.f17209t != null) {
            return t(kVar, gVar);
        }
        k3.k b10 = b();
        if (b10 == null || this.f17192c.h()) {
            return _deserializeFromString(kVar, gVar);
        }
        Object y10 = this.f17192c.y(gVar, b10.deserialize(kVar, gVar));
        if (this.f17199j != null) {
            E(gVar, y10);
        }
        return y10;
    }

    public Object w(c3.k kVar, k3.g gVar) {
        return s(kVar, gVar);
    }

    public k3.k x(k3.g gVar, t tVar) {
        Object l10;
        k3.b K = gVar.K();
        if (K == null || (l10 = K.l(tVar.d())) == null) {
            return null;
        }
        d4.j j10 = gVar.j(tVar.d(), l10);
        k3.j b10 = j10.b(gVar.l());
        return new com.fasterxml.jackson.databind.deser.std.a0(j10, b10, gVar.G(b10));
    }

    public t y(String str) {
        o3.v vVar;
        o3.c cVar = this.f17198i;
        t k10 = cVar == null ? null : cVar.k(str);
        return (k10 != null || (vVar = this.f17195f) == null) ? k10 : vVar.d(str);
    }

    public t z(k3.x xVar) {
        return y(xVar.c());
    }

    public d(d dVar) {
        this(dVar, dVar.f17203n);
    }

    public d(d dVar, boolean z10) {
        super(dVar.f17190a);
        this.f17190a = dVar.f17190a;
        this.f17192c = dVar.f17192c;
        this.f17193d = dVar.f17193d;
        this.f17194e = dVar.f17194e;
        this.f17195f = dVar.f17195f;
        this.f17198i = dVar.f17198i;
        this.f17205p = dVar.f17205p;
        this.f17201l = dVar.f17201l;
        this.f17203n = z10;
        this.f17202m = dVar.f17202m;
        this.f17200k = dVar.f17200k;
        this.f17199j = dVar.f17199j;
        this.f17209t = dVar.f17209t;
        this.f17196g = dVar.f17196g;
        this.f17207r = dVar.f17207r;
        this.f17204o = dVar.f17204o;
        this.f17191b = dVar.f17191b;
        this.f17197h = dVar.f17197h;
    }

    public d(d dVar, d4.q qVar) {
        super(dVar.f17190a);
        this.f17190a = dVar.f17190a;
        this.f17192c = dVar.f17192c;
        this.f17193d = dVar.f17193d;
        this.f17194e = dVar.f17194e;
        this.f17195f = dVar.f17195f;
        this.f17205p = dVar.f17205p;
        this.f17201l = dVar.f17201l;
        this.f17203n = qVar != null || dVar.f17203n;
        this.f17202m = dVar.f17202m;
        this.f17200k = dVar.f17200k;
        this.f17199j = dVar.f17199j;
        this.f17209t = dVar.f17209t;
        this.f17196g = dVar.f17196g;
        d0 d0Var = dVar.f17207r;
        if (qVar != null) {
            d0Var = d0Var != null ? d0Var.c(qVar) : d0Var;
            this.f17198i = dVar.f17198i.r(qVar);
        } else {
            this.f17198i = dVar.f17198i;
        }
        this.f17207r = d0Var;
        this.f17204o = dVar.f17204o;
        this.f17191b = dVar.f17191b;
        this.f17197h = false;
    }

    public d(d dVar, o3.s sVar) {
        super(dVar.f17190a);
        this.f17190a = dVar.f17190a;
        this.f17192c = dVar.f17192c;
        this.f17193d = dVar.f17193d;
        this.f17194e = dVar.f17194e;
        this.f17195f = dVar.f17195f;
        this.f17205p = dVar.f17205p;
        this.f17201l = dVar.f17201l;
        this.f17203n = dVar.f17203n;
        this.f17202m = dVar.f17202m;
        this.f17200k = dVar.f17200k;
        this.f17199j = dVar.f17199j;
        this.f17196g = dVar.f17196g;
        this.f17207r = dVar.f17207r;
        this.f17204o = dVar.f17204o;
        this.f17191b = dVar.f17191b;
        this.f17209t = sVar;
        if (sVar == null) {
            this.f17198i = dVar.f17198i;
            this.f17197h = dVar.f17197h;
        } else {
            this.f17198i = dVar.f17198i.u(new o3.u(sVar, k3.w.f14994h));
            this.f17197h = false;
        }
    }

    public d(d dVar, Set set, Set set2) {
        super(dVar.f17190a);
        this.f17190a = dVar.f17190a;
        this.f17192c = dVar.f17192c;
        this.f17193d = dVar.f17193d;
        this.f17194e = dVar.f17194e;
        this.f17195f = dVar.f17195f;
        this.f17205p = dVar.f17205p;
        this.f17201l = set;
        this.f17203n = dVar.f17203n;
        this.f17202m = set2;
        this.f17200k = dVar.f17200k;
        this.f17199j = dVar.f17199j;
        this.f17196g = dVar.f17196g;
        this.f17207r = dVar.f17207r;
        this.f17204o = dVar.f17204o;
        this.f17191b = dVar.f17191b;
        this.f17197h = dVar.f17197h;
        this.f17209t = dVar.f17209t;
        this.f17198i = dVar.f17198i.v(set, set2);
    }

    public d(d dVar, o3.c cVar) {
        super(dVar.f17190a);
        this.f17190a = dVar.f17190a;
        this.f17192c = dVar.f17192c;
        this.f17193d = dVar.f17193d;
        this.f17194e = dVar.f17194e;
        this.f17195f = dVar.f17195f;
        this.f17198i = cVar;
        this.f17205p = dVar.f17205p;
        this.f17201l = dVar.f17201l;
        this.f17203n = dVar.f17203n;
        this.f17202m = dVar.f17202m;
        this.f17200k = dVar.f17200k;
        this.f17199j = dVar.f17199j;
        this.f17209t = dVar.f17209t;
        this.f17196g = dVar.f17196g;
        this.f17207r = dVar.f17207r;
        this.f17204o = dVar.f17204o;
        this.f17191b = dVar.f17191b;
        this.f17197h = dVar.f17197h;
    }
}
