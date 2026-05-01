package n3;

import b3.k0;
import b3.n0;
import b3.p;
import b3.s;
import com.fasterxml.jackson.databind.deser.std.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.b;
import k3.d;
import l3.e;
import o3.a0;
import o3.c0;
import r3.b0;

/* loaded from: classes.dex */
public class f extends b {

    /* renamed from: j, reason: collision with root package name */
    public static final Class[] f17224j = {Throwable.class};

    /* renamed from: k, reason: collision with root package name */
    public static final f f17225k = new f(new m3.k());

    public f(m3.k kVar) {
        super(kVar);
    }

    @Override // n3.n
    public k3.k b(k3.g gVar, k3.j jVar, k3.c cVar) {
        k3.j z02;
        k3.f k10 = gVar.k();
        k3.k C = C(jVar, k10, cVar);
        if (C != null) {
            if (this.f17168b.e()) {
                Iterator it = this.f17168b.b().iterator();
                if (it.hasNext()) {
                    androidx.appcompat.app.m.a(it.next());
                    gVar.k();
                    throw null;
                }
            }
            return C;
        }
        if (jVar.M()) {
            return q0(gVar, jVar, cVar);
        }
        if (jVar.z() && !jVar.K() && !jVar.F() && (z02 = z0(gVar, jVar, cVar)) != null) {
            return o0(gVar, z02, k10.g0(z02));
        }
        k3.k w02 = w0(gVar, jVar, cVar);
        if (w02 != null) {
            return w02;
        }
        if (!y0(jVar.q())) {
            return null;
        }
        j0(gVar, jVar, cVar);
        k3.k h02 = h0(gVar, jVar, cVar);
        return h02 != null ? h02 : o0(gVar, jVar, cVar);
    }

    @Override // n3.n
    public k3.k c(k3.g gVar, k3.j jVar, k3.c cVar, Class cls) {
        return p0(gVar, jVar, gVar.k().h0(gVar.o0(k3.q.INFER_BUILDER_TYPE_BINDINGS) ? gVar.l().E(cls, jVar.j()) : gVar.x(cls), cVar));
    }

    @Override // n3.b
    public n g0(m3.k kVar) {
        if (this.f17168b == kVar) {
            return this;
        }
        d4.h.n0(f.class, this, "withConfig");
        return new f(kVar);
    }

    public k3.k h0(k3.g gVar, k3.j jVar, k3.c cVar) {
        String a10 = d4.e.a(jVar);
        if (a10 == null || gVar.k().a(jVar.q()) != null) {
            return null;
        }
        return new c0(jVar, a10);
    }

    public final boolean i0(Class cls) {
        return Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls);
    }

    public void j0(k3.g gVar, k3.j jVar, k3.c cVar) {
        x3.p.a().b(gVar, jVar, cVar);
    }

    public void k0(k3.g gVar, k3.c cVar, e eVar) {
        List<r3.s> c10 = cVar.c();
        if (c10 != null) {
            for (r3.s sVar : c10) {
                eVar.d(sVar.i(), t0(gVar, cVar, sVar, sVar.t()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [n3.t[]] */
    /* JADX WARN: Type inference failed for: r18v0, types: [k3.g] */
    /* JADX WARN: Type inference failed for: r20v0, types: [n3.e] */
    public void l0(k3.g gVar, k3.c cVar, e eVar) {
        Set emptySet;
        Set set;
        t tVar;
        j jVar;
        t tVar2 = null;
        j[] E = cVar.z().z() ^ true ? eVar.t().E(gVar.k()) : null;
        boolean z10 = E != null;
        p.a O = gVar.k().O(cVar.s(), cVar.u());
        if (O != null) {
            eVar.w(O.j());
            emptySet = O.g();
            Iterator it = emptySet.iterator();
            while (it.hasNext()) {
                eVar.f((String) it.next());
            }
        } else {
            emptySet = Collections.emptySet();
        }
        Set set2 = emptySet;
        s.a Q = gVar.k().Q(cVar.s(), cVar.u());
        if (Q != null) {
            Set e10 = Q.e();
            if (e10 != null) {
                Iterator it2 = e10.iterator();
                while (it2.hasNext()) {
                    eVar.g((String) it2.next());
                }
            }
            set = e10;
        } else {
            set = null;
        }
        r3.i b10 = cVar.b();
        if (b10 != null) {
            eVar.v(r0(gVar, cVar, b10));
        } else {
            Set x10 = cVar.x();
            if (x10 != null) {
                Iterator it3 = x10.iterator();
                while (it3.hasNext()) {
                    eVar.f((String) it3.next());
                }
            }
        }
        boolean z11 = gVar.o0(k3.q.USE_GETTERS_AS_SETTERS) && gVar.o0(k3.q.AUTO_DETECT_GETTERS);
        List<r3.s> v02 = v0(gVar, cVar, eVar, cVar.o(), set2, set);
        if (this.f17168b.e()) {
            Iterator it4 = this.f17168b.b().iterator();
            if (it4.hasNext()) {
                androidx.appcompat.app.m.a(it4.next());
                gVar.k();
                throw null;
            }
        }
        for (r3.s sVar : v02) {
            if (sVar.A()) {
                tVar = t0(gVar, cVar, sVar, sVar.v().w(0));
            } else if (sVar.y()) {
                tVar = t0(gVar, cVar, sVar, sVar.o().f());
            } else {
                r3.j p10 = sVar.p();
                if (p10 != null) {
                    if (z11 && i0(p10.e())) {
                        if (!eVar.u(sVar.getName())) {
                            tVar = u0(gVar, cVar, sVar);
                        }
                    } else if (!sVar.x() && sVar.getMetadata().d() != null) {
                        tVar = u0(gVar, cVar, sVar);
                    }
                }
                tVar = tVar2;
            }
            if (z10 && sVar.x()) {
                String name = sVar.getName();
                int length = E.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        jVar = null;
                        break;
                    }
                    j jVar2 = E[i10];
                    if (name.equals(jVar2.getName()) && (jVar2 instanceof j)) {
                        jVar = jVar2;
                        break;
                    }
                    i10++;
                }
                if (jVar == null) {
                    ArrayList arrayList = new ArrayList();
                    for (j jVar3 : E) {
                        arrayList.add(jVar3.getName());
                    }
                    gVar.u0(cVar, sVar, "Could not find creator property with name %s (known Creator properties: %s)", d4.h.U(name), arrayList);
                } else {
                    if (tVar != null) {
                        jVar.P(tVar);
                    }
                    Class[] k10 = sVar.k();
                    if (k10 == null) {
                        k10 = cVar.e();
                    }
                    jVar.G(k10);
                    eVar.e(jVar);
                }
            } else if (tVar != null) {
                Class[] k11 = sVar.k();
                if (k11 == null) {
                    k11 = cVar.e();
                }
                tVar.G(k11);
                eVar.j(tVar);
            }
            tVar2 = null;
        }
    }

    public void m0(k3.g gVar, k3.c cVar, e eVar) {
        Map i10 = cVar.i();
        if (i10 != null) {
            for (Map.Entry entry : i10.entrySet()) {
                r3.i iVar = (r3.i) entry.getValue();
                eVar.h(k3.x.a(iVar.d()), iVar.f(), cVar.t(), iVar, entry.getKey());
            }
        }
    }

    public void n0(k3.g gVar, k3.c cVar, e eVar) {
        t tVar;
        k0 n10;
        k3.j jVar;
        b0 y10 = cVar.y();
        if (y10 == null) {
            return;
        }
        Class c10 = y10.c();
        gVar.o(cVar.u(), y10);
        if (c10 == n0.class) {
            k3.x d10 = y10.d();
            tVar = eVar.o(d10);
            if (tVar == null) {
                throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", d4.h.G(cVar.z()), d4.h.V(d10)));
            }
            jVar = tVar.getType();
            n10 = new o3.w(y10.f());
        } else {
            k3.j jVar2 = gVar.l().K(gVar.x(c10), k0.class)[0];
            tVar = null;
            n10 = gVar.n(cVar.u(), y10);
            jVar = jVar2;
        }
        eVar.x(o3.s.a(jVar, y10.d(), n10, gVar.I(jVar), tVar, null));
    }

    public k3.k o0(k3.g gVar, k3.j jVar, k3.c cVar) {
        try {
            w e02 = e0(gVar, cVar);
            e s02 = s0(gVar, cVar);
            s02.z(e02);
            l0(gVar, cVar, s02);
            n0(gVar, cVar, s02);
            k0(gVar, cVar, s02);
            m0(gVar, cVar, s02);
            gVar.k();
            if (this.f17168b.e()) {
                Iterator it = this.f17168b.b().iterator();
                if (it.hasNext()) {
                    androidx.appcompat.app.m.a(it.next());
                    throw null;
                }
            }
            k3.k k10 = (!jVar.z() || e02.l()) ? s02.k() : s02.l();
            if (this.f17168b.e()) {
                Iterator it2 = this.f17168b.b().iterator();
                if (it2.hasNext()) {
                    androidx.appcompat.app.m.a(it2.next());
                    throw null;
                }
            }
            return k10;
        } catch (IllegalArgumentException e10) {
            p3.b u10 = p3.b.u(gVar.S(), d4.h.o(e10), cVar, null);
            u10.initCause(e10);
            throw u10;
        } catch (NoClassDefFoundError e11) {
            return new o3.f(e11);
        }
    }

    public k3.k p0(k3.g gVar, k3.j jVar, k3.c cVar) {
        try {
            w e02 = e0(gVar, cVar);
            k3.f k10 = gVar.k();
            e s02 = s0(gVar, cVar);
            s02.z(e02);
            l0(gVar, cVar, s02);
            n0(gVar, cVar, s02);
            k0(gVar, cVar, s02);
            m0(gVar, cVar, s02);
            e.a n10 = cVar.n();
            String str = n10 == null ? "build" : n10.f15921a;
            r3.j l10 = cVar.l(str, null);
            if (l10 != null && k10.b()) {
                d4.h.g(l10.m(), k10.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            s02.y(l10, n10);
            if (this.f17168b.e()) {
                Iterator it = this.f17168b.b().iterator();
                if (it.hasNext()) {
                    androidx.appcompat.app.m.a(it.next());
                    throw null;
                }
            }
            k3.k m10 = s02.m(jVar, str);
            if (this.f17168b.e()) {
                Iterator it2 = this.f17168b.b().iterator();
                if (it2.hasNext()) {
                    androidx.appcompat.app.m.a(it2.next());
                    throw null;
                }
            }
            return m10;
        } catch (IllegalArgumentException e10) {
            throw p3.b.u(gVar.S(), d4.h.o(e10), cVar, null);
        } catch (NoClassDefFoundError e11) {
            return new o3.f(e11);
        }
    }

    public k3.k q0(k3.g gVar, k3.j jVar, k3.c cVar) {
        t t02;
        gVar.k();
        e s02 = s0(gVar, cVar);
        s02.z(e0(gVar, cVar));
        l0(gVar, cVar, s02);
        r3.j l10 = cVar.l("initCause", f17224j);
        if (l10 != null && (t02 = t0(gVar, cVar, d4.w.E(gVar.k(), l10, new k3.x("cause")), l10.w(0))) != null) {
            s02.i(t02, true);
        }
        s02.f("localizedMessage");
        s02.f("suppressed");
        if (this.f17168b.e()) {
            Iterator it = this.f17168b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        k3.k k10 = s02.k();
        if (k10 instanceof c) {
            k10 = new j0((c) k10);
        }
        if (this.f17168b.e()) {
            Iterator it2 = this.f17168b.b().iterator();
            if (it2.hasNext()) {
                androidx.appcompat.app.m.a(it2.next());
                throw null;
            }
        }
        return k10;
    }

    public s r0(k3.g gVar, k3.c cVar, r3.i iVar) {
        k3.j p10;
        d.a aVar;
        k3.j jVar;
        if (iVar instanceof r3.j) {
            r3.j jVar2 = (r3.j) iVar;
            p10 = jVar2.w(0);
            jVar = f0(gVar, iVar, jVar2.w(1));
            aVar = new d.a(k3.x.a(iVar.d()), jVar, null, iVar, k3.w.f14995i);
        } else {
            if (!(iVar instanceof r3.g)) {
                return (s) gVar.q(cVar.z(), String.format("Unrecognized mutator type for any setter: %s", iVar.getClass()));
            }
            k3.j f02 = f0(gVar, iVar, ((r3.g) iVar).f());
            p10 = f02.p();
            k3.j k10 = f02.k();
            aVar = new d.a(k3.x.a(iVar.d()), f02, null, iVar, k3.w.f14995i);
            jVar = k10;
        }
        k3.p a02 = a0(gVar, iVar);
        if (a02 == null) {
            a02 = (k3.p) p10.u();
        }
        if (a02 == null) {
            a02 = gVar.F(p10, aVar);
        }
        k3.p pVar = a02;
        k3.k X = X(gVar, iVar);
        if (X == null) {
            X = (k3.k) jVar.u();
        }
        return new s(aVar, iVar, jVar, pVar, X != null ? gVar.Y(X, aVar, jVar) : X, (w3.e) jVar.t());
    }

    public e s0(k3.g gVar, k3.c cVar) {
        return new e(cVar, gVar);
    }

    public t t0(k3.g gVar, k3.c cVar, r3.s sVar, k3.j jVar) {
        r3.i r10 = sVar.r();
        if (r10 == null) {
            gVar.u0(cVar, sVar, "No non-constructor mutator available", new Object[0]);
        }
        k3.j f02 = f0(gVar, r10, jVar);
        w3.e eVar = (w3.e) f02.t();
        t oVar = r10 instanceof r3.j ? new o3.o(sVar, f02, eVar, cVar.t(), (r3.j) r10) : new o3.i(sVar, f02, eVar, cVar.t(), (r3.g) r10);
        k3.k Z = Z(gVar, r10);
        if (Z == null) {
            Z = (k3.k) f02.u();
        }
        if (Z != null) {
            oVar = oVar.L(gVar.Y(Z, oVar, f02));
        }
        b.a j10 = sVar.j();
        if (j10 != null && j10.d()) {
            oVar.E(j10.b());
        }
        b0 h10 = sVar.h();
        if (h10 != null) {
            oVar.F(h10);
        }
        return oVar;
    }

    public t u0(k3.g gVar, k3.c cVar, r3.s sVar) {
        r3.j p10 = sVar.p();
        k3.j f02 = f0(gVar, p10, p10.f());
        a0 a0Var = new a0(sVar, f02, (w3.e) f02.t(), cVar.t(), p10);
        k3.k Z = Z(gVar, p10);
        if (Z == null) {
            Z = (k3.k) f02.u();
        }
        return Z != null ? a0Var.L(gVar.Y(Z, a0Var, f02)) : a0Var;
    }

    public List v0(k3.g gVar, k3.c cVar, e eVar, List list, Set set, Set set2) {
        Class u10;
        ArrayList arrayList = new ArrayList(Math.max(4, list.size()));
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r3.s sVar = (r3.s) it.next();
            String name = sVar.getName();
            if (!d4.m.c(name, set, set2)) {
                if (sVar.x() || (u10 = sVar.u()) == null || !x0(gVar.k(), sVar, u10, hashMap)) {
                    arrayList.add(sVar);
                } else {
                    eVar.f(name);
                }
            }
        }
        return arrayList;
    }

    public k3.k w0(k3.g gVar, k3.j jVar, k3.c cVar) {
        k3.k Y = Y(gVar, jVar, cVar);
        if (Y != null && this.f17168b.e()) {
            Iterator it = this.f17168b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                gVar.k();
                throw null;
            }
        }
        return Y;
    }

    public boolean x0(k3.f fVar, r3.s sVar, Class cls, Map map) {
        Boolean bool;
        Boolean bool2 = (Boolean) map.get(cls);
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        if (cls == String.class || cls.isPrimitive()) {
            bool = Boolean.FALSE;
        } else {
            bool = fVar.j(cls).f();
            if (bool == null) {
                bool = fVar.g().r0(fVar.A(cls).u());
                if (bool == null) {
                    bool = Boolean.FALSE;
                }
            }
        }
        map.put(cls, bool);
        return bool.booleanValue();
    }

    public boolean y0(Class cls) {
        String f10 = d4.h.f(cls);
        if (f10 != null) {
            throw new IllegalArgumentException("Cannot deserialize Class " + cls.getName() + " (of type " + f10 + ") as a Bean");
        }
        if (d4.h.S(cls)) {
            throw new IllegalArgumentException("Cannot deserialize Proxy class " + cls.getName() + " as a Bean");
        }
        String P = d4.h.P(cls, true);
        if (P == null) {
            return true;
        }
        throw new IllegalArgumentException("Cannot deserialize Class " + cls.getName() + " (of type " + P + ") as a Bean");
    }

    public k3.j z0(k3.g gVar, k3.j jVar, k3.c cVar) {
        Iterator it = this.f17168b.a().iterator();
        if (!it.hasNext()) {
            return null;
        }
        androidx.appcompat.app.m.a(it.next());
        gVar.k();
        throw null;
    }
}
