package a4;

import b3.e0;
import b3.k0;
import b3.n0;
import b3.p;
import b3.s;
import com.fasterxml.jackson.databind.ser.std.d0;
import com.fasterxml.jackson.databind.ser.std.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k3.a0;
import k3.b;
import k3.c0;
import k3.d;
import k3.w;
import k3.x;
import r3.b0;

/* loaded from: classes.dex */
public class f extends b {

    /* renamed from: d, reason: collision with root package name */
    public static final f f210d = new f(null);

    public f(m3.p pVar) {
        super(pVar);
    }

    @Override // a4.b
    public q I(m3.p pVar) {
        if (this.f180a == pVar) {
            return this;
        }
        if (getClass() == f.class) {
            return new f(pVar);
        }
        throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': cannot instantiate subtype with additional serializer definitions");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c J(c0 c0Var, r3.s sVar, l lVar, boolean z10, r3.i iVar) {
        x c10 = sVar.c();
        k3.j f10 = iVar.f();
        k3.d aVar = new d.a(c10, f10, sVar.w(), iVar, sVar.getMetadata());
        k3.o F = F(c0Var, iVar);
        if (F instanceof o) {
            ((o) F).a(c0Var);
        }
        return lVar.c(c0Var, sVar, f10, c0Var.h0(F, aVar), W(f10, c0Var.k(), iVar), (f10.D() || f10.b()) ? V(f10, c0Var.k(), iVar) : null, iVar, z10);
    }

    public k3.o K(c0 c0Var, k3.j jVar, k3.c cVar, boolean z10) {
        k3.o oVar;
        a0 k10 = c0Var.k();
        if (jVar.D()) {
            if (!z10) {
                z10 = H(k10, cVar, null);
            }
            oVar = n(c0Var, jVar, cVar, z10);
            if (oVar != null) {
                return oVar;
            }
        } else {
            if (jVar.b()) {
                oVar = A(c0Var, (c4.j) jVar, cVar, z10);
            } else {
                Iterator it = v().iterator();
                k3.o oVar2 = null;
                while (it.hasNext() && (oVar2 = ((r) it.next()).c(k10, jVar, cVar)) == null) {
                }
                oVar = oVar2;
            }
            if (oVar == null) {
                oVar = C(c0Var, jVar, cVar);
            }
        }
        if (oVar == null && (oVar = D(jVar, k10, cVar, z10)) == null && (oVar = E(c0Var, jVar, cVar, z10)) == null && (oVar = T(c0Var, jVar, cVar, z10)) == null) {
            oVar = c0Var.g0(cVar.s());
        }
        if (oVar != null && this.f180a.b()) {
            Iterator it2 = this.f180a.d().iterator();
            if (it2.hasNext()) {
                androidx.appcompat.app.m.a(it2.next());
                throw null;
            }
        }
        return oVar;
    }

    public k3.o L(c0 c0Var, k3.j jVar, k3.c cVar) {
        String a10 = d4.e.a(jVar);
        if (a10 == null || c0Var.k().a(jVar.q()) != null) {
            return null;
        }
        return new b4.q(jVar, a10);
    }

    public k3.o M(c0 c0Var, k3.j jVar, k3.c cVar, boolean z10) {
        if (cVar.s() == Object.class) {
            return c0Var.g0(Object.class);
        }
        k3.o L = L(c0Var, jVar, cVar);
        if (L != null) {
            return L;
        }
        a0 k10 = c0Var.k();
        e N = N(cVar);
        N.j(k10);
        List U = U(c0Var, cVar, N);
        List arrayList = U == null ? new ArrayList() : a0(c0Var, cVar, N, U);
        c0Var.W().d(k10, cVar.u(), arrayList);
        if (this.f180a.b()) {
            Iterator it = this.f180a.d().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        List R = R(k10, cVar, S(k10, cVar, arrayList));
        if (this.f180a.b()) {
            Iterator it2 = this.f180a.d().iterator();
            if (it2.hasNext()) {
                androidx.appcompat.app.m.a(it2.next());
                throw null;
            }
        }
        N.m(P(c0Var, cVar, R));
        N.n(R);
        N.k(y(k10, cVar));
        r3.i a10 = cVar.a();
        if (a10 != null) {
            k3.j f10 = a10.f();
            k3.j k11 = f10.k();
            w3.h c10 = c(k10, k11);
            k3.o F = F(c0Var, a10);
            if (F == null) {
                F = t.n(null, f10, k10.D(k3.q.USE_STATIC_TYPING), c10, null, null, null);
            }
            N.i(new a(new d.a(x.a(a10.d()), k11, null, a10, w.f14995i), a10, F));
        }
        Y(k10, N);
        if (this.f180a.b()) {
            Iterator it3 = this.f180a.d().iterator();
            if (it3.hasNext()) {
                androidx.appcompat.app.m.a(it3.next());
                throw null;
            }
        }
        try {
            k3.o a11 = N.a();
            if (a11 == null) {
                if (jVar.L()) {
                    return N.b();
                }
                a11 = B(k10, jVar, cVar, z10);
                if (a11 == null && cVar.A()) {
                    return N.b();
                }
            }
            return a11;
        } catch (RuntimeException e10) {
            return (k3.o) c0Var.q0(cVar, "Failed to construct BeanSerializer for %s: (%s) %s", cVar.z(), e10.getClass().getName(), e10.getMessage());
        }
    }

    public e N(k3.c cVar) {
        return new e(cVar);
    }

    public c O(c cVar, Class[] clsArr) {
        return b4.d.a(cVar, clsArr);
    }

    public b4.i P(c0 c0Var, k3.c cVar, List list) {
        b0 y10 = cVar.y();
        if (y10 == null) {
            return null;
        }
        Class c10 = y10.c();
        if (c10 != n0.class) {
            return b4.i.a(c0Var.l().K(c0Var.i(c10), k0.class)[0], y10.d(), c0Var.n(cVar.u(), y10), y10.b());
        }
        String c11 = y10.d().c();
        int size = list.size();
        for (int i10 = 0; i10 != size; i10++) {
            c cVar2 = (c) list.get(i10);
            if (c11.equals(cVar2.getName())) {
                if (i10 > 0) {
                    list.remove(i10);
                    list.add(0, cVar2);
                }
                return b4.i.a(cVar2.getType(), null, new b4.j(y10, cVar2), y10.b());
            }
        }
        throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", d4.h.G(cVar.z()), d4.h.U(c11)));
    }

    public l Q(a0 a0Var, k3.c cVar) {
        return new l(a0Var, cVar);
    }

    public List R(a0 a0Var, k3.c cVar, List list) {
        p.a O = a0Var.O(cVar.s(), cVar.u());
        Set h10 = O != null ? O.h() : null;
        s.a Q = a0Var.Q(cVar.s(), cVar.u());
        Set e10 = Q != null ? Q.e() : null;
        if (e10 != null || (h10 != null && !h10.isEmpty())) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (d4.m.c(((c) it.next()).getName(), h10, e10)) {
                    it.remove();
                }
            }
        }
        return list;
    }

    public List S(a0 a0Var, k3.c cVar, List list) {
        if (cVar.z().N(CharSequence.class)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                r3.i d10 = ((c) it.next()).d();
                if ((d10 instanceof r3.j) && "isEmpty".equals(d10.d()) && d10.k() == CharSequence.class) {
                    it.remove();
                }
            }
        }
        return list;
    }

    public k3.o T(c0 c0Var, k3.j jVar, k3.c cVar, boolean z10) {
        if (X(jVar.q()) || d4.h.L(jVar.q())) {
            return M(c0Var, jVar, cVar, z10);
        }
        return null;
    }

    public List U(c0 c0Var, k3.c cVar, e eVar) {
        List<r3.s> o10 = cVar.o();
        a0 k10 = c0Var.k();
        Z(k10, cVar, o10);
        if (k10.D(k3.q.REQUIRE_SETTERS_FOR_GETTERS)) {
            b0(k10, cVar, o10);
        }
        if (o10.isEmpty()) {
            return null;
        }
        boolean H = H(k10, cVar, null);
        l Q = Q(k10, cVar);
        ArrayList arrayList = new ArrayList(o10.size());
        for (r3.s sVar : o10) {
            r3.i l10 = sVar.l();
            if (!sVar.D()) {
                b.a j10 = sVar.j();
                if (j10 == null || !j10.c()) {
                    if (l10 instanceof r3.j) {
                        arrayList.add(J(c0Var, sVar, Q, H, (r3.j) l10));
                    } else {
                        arrayList.add(J(c0Var, sVar, Q, H, (r3.g) l10));
                    }
                }
            } else if (l10 != null) {
                eVar.o(l10);
            }
        }
        return arrayList;
    }

    public w3.h V(k3.j jVar, a0 a0Var, r3.i iVar) {
        k3.j k10 = jVar.k();
        w3.g H = a0Var.g().H(a0Var, iVar, jVar);
        return H == null ? c(a0Var, k10) : H.b(a0Var, k10, a0Var.T().b(a0Var, iVar, k10));
    }

    public w3.h W(k3.j jVar, a0 a0Var, r3.i iVar) {
        w3.g P = a0Var.g().P(a0Var, iVar, jVar);
        return P == null ? c(a0Var, jVar) : P.b(a0Var, jVar, a0Var.T().b(a0Var, iVar, jVar));
    }

    public boolean X(Class cls) {
        return d4.h.f(cls) == null && !d4.h.S(cls);
    }

    public void Y(a0 a0Var, e eVar) {
        List g10 = eVar.g();
        boolean D = a0Var.D(k3.q.DEFAULT_VIEW_INCLUSION);
        int size = g10.size();
        c[] cVarArr = new c[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = (c) g10.get(i11);
            Class[] t10 = cVar.t();
            if (t10 != null && t10.length != 0) {
                i10++;
                cVarArr[i11] = O(cVar, t10);
            } else if (D) {
                cVarArr[i11] = cVar;
            }
        }
        if (D && i10 == 0) {
            return;
        }
        eVar.l(cVarArr);
    }

    public void Z(a0 a0Var, k3.c cVar, List list) {
        k3.b g10 = a0Var.g();
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r3.s sVar = (r3.s) it.next();
            if (sVar.l() == null) {
                it.remove();
            } else {
                Class u10 = sVar.u();
                Boolean bool = (Boolean) hashMap.get(u10);
                if (bool == null) {
                    bool = a0Var.j(u10).f();
                    if (bool == null && (bool = g10.r0(a0Var.A(u10).u())) == null) {
                        bool = Boolean.FALSE;
                    }
                    hashMap.put(u10, bool);
                }
                if (bool.booleanValue()) {
                    it.remove();
                }
            }
        }
    }

    public List a0(c0 c0Var, k3.c cVar, e eVar, List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            c cVar2 = (c) list.get(i10);
            w3.h s10 = cVar2.s();
            if (s10 != null && s10.c() == e0.a.EXTERNAL_PROPERTY) {
                x a10 = x.a(s10.b());
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c cVar3 = (c) it.next();
                    if (cVar3 != cVar2 && cVar3.E(a10)) {
                        cVar2.m(null);
                        break;
                    }
                }
            }
        }
        return list;
    }

    @Override // a4.q
    public k3.o b(c0 c0Var, k3.j jVar) {
        k3.j v02;
        a0 k10 = c0Var.k();
        k3.c b02 = k10.b0(jVar);
        k3.o F = F(c0Var, b02.u());
        if (F != null) {
            return F;
        }
        k3.b g10 = k10.g();
        boolean z10 = false;
        if (g10 == null) {
            v02 = jVar;
        } else {
            try {
                v02 = g10.v0(k10, b02.u(), jVar);
            } catch (k3.l e10) {
                return (k3.o) c0Var.q0(b02, e10.getMessage(), new Object[0]);
            }
        }
        if (v02 != jVar) {
            if (!v02.y(jVar.q())) {
                b02 = k10.b0(v02);
            }
            z10 = true;
        }
        d4.j q10 = b02.q();
        if (q10 == null) {
            return K(c0Var, v02, b02, z10);
        }
        k3.j a10 = q10.a(c0Var.l());
        if (!a10.y(v02.q())) {
            b02 = k10.b0(a10);
            F = F(c0Var, b02.u());
        }
        if (F == null && !a10.I()) {
            F = K(c0Var, a10, b02, true);
        }
        return new d0(q10, a10, F);
    }

    public void b0(a0 a0Var, k3.c cVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r3.s sVar = (r3.s) it.next();
            if (!sVar.e() && !sVar.B()) {
                it.remove();
            }
        }
    }

    @Override // a4.b
    public Iterable v() {
        return this.f180a.e();
    }
}
