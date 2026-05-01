package a4;

import b3.k;
import b3.p;
import b3.r;
import b3.s;
import com.fasterxml.jackson.databind.ser.std.d0;
import com.fasterxml.jackson.databind.ser.std.e0;
import com.fasterxml.jackson.databind.ser.std.g0;
import com.fasterxml.jackson.databind.ser.std.j0;
import com.fasterxml.jackson.databind.ser.std.k0;
import com.fasterxml.jackson.databind.ser.std.l0;
import com.fasterxml.jackson.databind.ser.std.n0;
import com.fasterxml.jackson.databind.ser.std.t;
import com.fasterxml.jackson.databind.ser.std.v;
import com.fasterxml.jackson.databind.ser.std.w;
import com.fasterxml.jackson.databind.ser.std.x;
import d4.y;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import k3.a0;
import k3.b0;
import k3.c0;
import l3.f;

/* loaded from: classes.dex */
public abstract class b extends q implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f178b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f179c;

    /* renamed from: a, reason: collision with root package name */
    public final m3.p f180a;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f181a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f182b;

        static {
            int[] iArr = new int[r.a.values().length];
            f182b = iArr;
            try {
                iArr[r.a.NON_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f182b[r.a.NON_ABSENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f182b[r.a.NON_EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f182b[r.a.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f182b[r.a.NON_NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f182b[r.a.USE_DEFAULTS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[k.c.values().length];
            f181a = iArr2;
            try {
                iArr2[k.c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f181a[k.c.OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f181a[k.c.ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(String.class.getName(), new j0());
        l0 l0Var = l0.f6697a;
        hashMap2.put(StringBuffer.class.getName(), l0Var);
        hashMap2.put(StringBuilder.class.getName(), l0Var);
        hashMap2.put(Character.class.getName(), l0Var);
        hashMap2.put(Character.TYPE.getName(), l0Var);
        w.a(hashMap2);
        hashMap2.put(Boolean.TYPE.getName(), new com.fasterxml.jackson.databind.ser.std.e(true));
        hashMap2.put(Boolean.class.getName(), new com.fasterxml.jackson.databind.ser.std.e(false));
        hashMap2.put(BigInteger.class.getName(), new v(BigInteger.class));
        hashMap2.put(BigDecimal.class.getName(), new v(BigDecimal.class));
        hashMap2.put(Calendar.class.getName(), com.fasterxml.jackson.databind.ser.std.h.f6692d);
        hashMap2.put(Date.class.getName(), com.fasterxml.jackson.databind.ser.std.k.f6693d);
        for (Map.Entry entry : e0.a()) {
            Object value = entry.getValue();
            if (value instanceof k3.o) {
                hashMap2.put(((Class) entry.getKey()).getName(), (k3.o) value);
            } else {
                hashMap.put(((Class) entry.getKey()).getName(), (Class) value);
            }
        }
        hashMap.put(y.class.getName(), n0.class);
        f178b = hashMap2;
        f179c = hashMap;
    }

    public b(m3.p pVar) {
        this.f180a = pVar == null ? new m3.p() : pVar;
    }

    public k3.o A(c0 c0Var, c4.j jVar, k3.c cVar, boolean z10) {
        k3.j k10 = jVar.k();
        w3.h hVar = (w3.h) k10.t();
        a0 k11 = c0Var.k();
        if (hVar == null) {
            hVar = c(k11, k10);
        }
        w3.h hVar2 = hVar;
        k3.o oVar = (k3.o) k10.u();
        Iterator it = v().iterator();
        while (it.hasNext()) {
            k3.o d10 = ((r) it.next()).d(k11, jVar, cVar, hVar2, oVar);
            if (d10 != null) {
                return d10;
            }
        }
        if (jVar.N(AtomicReference.class)) {
            return k(c0Var, jVar, cVar, z10, hVar2, oVar);
        }
        return null;
    }

    public final k3.o B(a0 a0Var, k3.j jVar, k3.c cVar, boolean z10) {
        Class q10 = jVar.q();
        if (Iterator.class.isAssignableFrom(q10)) {
            k3.j[] K = a0Var.z().K(jVar, Iterator.class);
            return s(a0Var, jVar, cVar, z10, (K == null || K.length != 1) ? c4.o.O() : K[0]);
        }
        if (Iterable.class.isAssignableFrom(q10)) {
            k3.j[] K2 = a0Var.z().K(jVar, Iterable.class);
            return r(a0Var, jVar, cVar, z10, (K2 == null || K2.length != 1) ? c4.o.O() : K2[0]);
        }
        if (CharSequence.class.isAssignableFrom(q10)) {
            return l0.f6697a;
        }
        return null;
    }

    public final k3.o C(c0 c0Var, k3.j jVar, k3.c cVar) {
        if (k3.n.class.isAssignableFrom(jVar.q())) {
            return com.fasterxml.jackson.databind.ser.std.a0.f6655a;
        }
        r3.i k10 = cVar.k();
        if (k10 == null) {
            return null;
        }
        if (c0Var.z()) {
            d4.h.g(k10.m(), c0Var.l0(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        k3.j f10 = k10.f();
        k3.o F = F(c0Var, k10);
        if (F == null) {
            F = (k3.o) f10.u();
        }
        w3.h hVar = (w3.h) f10.t();
        if (hVar == null) {
            hVar = c(c0Var.k(), f10);
        }
        return new com.fasterxml.jackson.databind.ser.std.s(k10, hVar, F);
    }

    public final k3.o D(k3.j jVar, a0 a0Var, k3.c cVar, boolean z10) {
        Class cls;
        String name = jVar.q().getName();
        k3.o oVar = (k3.o) f178b.get(name);
        return (oVar != null || (cls = (Class) f179c.get(name)) == null) ? oVar : (k3.o) d4.h.l(cls, false);
    }

    public final k3.o E(c0 c0Var, k3.j jVar, k3.c cVar, boolean z10) {
        if (jVar.F()) {
            return o(c0Var.k(), jVar, cVar);
        }
        Class q10 = jVar.q();
        k3.o z11 = z(c0Var, jVar, cVar, z10);
        if (z11 != null) {
            return z11;
        }
        if (Calendar.class.isAssignableFrom(q10)) {
            return com.fasterxml.jackson.databind.ser.std.h.f6692d;
        }
        if (Date.class.isAssignableFrom(q10)) {
            return com.fasterxml.jackson.databind.ser.std.k.f6693d;
        }
        if (Map.Entry.class.isAssignableFrom(q10)) {
            k3.j i10 = jVar.i(Map.Entry.class);
            return t(c0Var, jVar, cVar, z10, i10.h(0), i10.h(1));
        }
        if (ByteBuffer.class.isAssignableFrom(q10)) {
            return new com.fasterxml.jackson.databind.ser.std.g();
        }
        if (InetAddress.class.isAssignableFrom(q10)) {
            return new com.fasterxml.jackson.databind.ser.std.p();
        }
        if (InetSocketAddress.class.isAssignableFrom(q10)) {
            return new com.fasterxml.jackson.databind.ser.std.q();
        }
        if (TimeZone.class.isAssignableFrom(q10)) {
            return new k0();
        }
        if (Charset.class.isAssignableFrom(q10)) {
            return l0.f6697a;
        }
        if (!Number.class.isAssignableFrom(q10)) {
            return null;
        }
        int i11 = a.f181a[cVar.g(null).i().ordinal()];
        if (i11 == 1) {
            return l0.f6697a;
        }
        if (i11 == 2 || i11 == 3) {
            return null;
        }
        return v.f6731b;
    }

    public k3.o F(c0 c0Var, r3.b bVar) {
        Object Y = c0Var.W().Y(bVar);
        if (Y == null) {
            return null;
        }
        return x(c0Var, bVar, c0Var.t0(bVar, Y));
    }

    public boolean G(Class cls) {
        return RandomAccess.class.isAssignableFrom(cls);
    }

    public boolean H(a0 a0Var, k3.c cVar, w3.h hVar) {
        if (hVar != null) {
            return false;
        }
        f.b X = a0Var.g().X(cVar.u());
        return (X == null || X == f.b.DEFAULT_TYPING) ? a0Var.D(k3.q.USE_STATIC_TYPING) : X == f.b.STATIC;
    }

    public abstract q I(m3.p pVar);

    @Override // a4.q
    public k3.o a(c0 c0Var, k3.j jVar, k3.o oVar) {
        k3.o oVar2;
        a0 k10 = c0Var.k();
        k3.c b02 = k10.b0(jVar);
        if (this.f180a.a()) {
            Iterator it = this.f180a.c().iterator();
            oVar2 = null;
            while (it.hasNext() && (oVar2 = ((r) it.next()).c(k10, jVar, b02)) == null) {
            }
        } else {
            oVar2 = null;
        }
        if (oVar2 == null) {
            k3.o i10 = i(c0Var, b02.u());
            if (i10 == null) {
                if (oVar == null) {
                    i10 = g0.b(k10, jVar.q(), false);
                    if (i10 == null) {
                        r3.i j10 = b02.j();
                        if (j10 == null) {
                            j10 = b02.k();
                        }
                        if (j10 != null) {
                            k3.o a10 = a(c0Var, j10.f(), oVar);
                            if (k10.b()) {
                                d4.h.g(j10.m(), k10.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                            }
                            oVar = new com.fasterxml.jackson.databind.ser.std.s(j10, null, a10);
                        } else {
                            oVar = g0.a(k10, jVar.q());
                        }
                    }
                }
            }
            oVar = i10;
        } else {
            oVar = oVar2;
        }
        if (this.f180a.b()) {
            Iterator it2 = this.f180a.d().iterator();
            if (it2.hasNext()) {
                androidx.appcompat.app.m.a(it2.next());
                throw null;
            }
        }
        return oVar;
    }

    @Override // a4.q
    public w3.h c(a0 a0Var, k3.j jVar) {
        Collection a10;
        r3.c u10 = a0Var.A(jVar.q()).u();
        w3.g c02 = a0Var.g().c0(a0Var, u10, jVar);
        if (c02 == null) {
            c02 = a0Var.s(jVar);
            a10 = null;
        } else {
            a10 = a0Var.T().a(a0Var, u10);
        }
        if (c02 == null) {
            return null;
        }
        return c02.b(a0Var, jVar, a10);
    }

    @Override // a4.q
    public final q d(r rVar) {
        return I(this.f180a.f(rVar));
    }

    @Override // a4.q
    public final q e(r rVar) {
        return I(this.f180a.g(rVar));
    }

    public t f(c0 c0Var, k3.c cVar, t tVar) {
        k3.j o10 = tVar.o();
        r.b h10 = h(c0Var, cVar, o10, Map.class);
        r.a f10 = h10 == null ? r.a.USE_DEFAULTS : h10.f();
        boolean z10 = true;
        Object obj = null;
        if (f10 == r.a.USE_DEFAULTS || f10 == r.a.ALWAYS) {
            return !c0Var.m0(b0.WRITE_NULL_MAP_VALUES) ? tVar.x(null, true) : tVar;
        }
        int i10 = a.f182b[f10.ordinal()];
        if (i10 == 1) {
            obj = d4.e.b(o10);
            if (obj != null && obj.getClass().isArray()) {
                obj = d4.c.a(obj);
            }
        } else if (i10 != 2) {
            if (i10 == 3) {
                obj = t.f6713q;
            } else if (i10 == 4 && (obj = c0Var.j0(null, h10.e())) != null) {
                z10 = c0Var.k0(obj);
            }
        } else if (o10.b()) {
            obj = t.f6713q;
        }
        return tVar.x(obj, z10);
    }

    public k3.o g(c0 c0Var, r3.b bVar) {
        Object g10 = c0Var.W().g(bVar);
        if (g10 != null) {
            return c0Var.t0(bVar, g10);
        }
        return null;
    }

    public r.b h(c0 c0Var, k3.c cVar, k3.j jVar, Class cls) {
        a0 k10 = c0Var.k();
        r.b q10 = k10.q(cls, cVar.p(k10.P()));
        r.b q11 = k10.q(jVar.q(), null);
        if (q11 == null) {
            return q10;
        }
        int i10 = a.f182b[q11.h().ordinal()];
        return i10 != 4 ? i10 != 6 ? q10.l(q11.h()) : q10 : q10.k(q11.e());
    }

    public k3.o i(c0 c0Var, r3.b bVar) {
        Object v10 = c0Var.W().v(bVar);
        if (v10 != null) {
            return c0Var.t0(bVar, v10);
        }
        return null;
    }

    public k3.o j(c0 c0Var, c4.a aVar, k3.c cVar, boolean z10, w3.h hVar, k3.o oVar) {
        a0 k10 = c0Var.k();
        Iterator it = v().iterator();
        k3.o oVar2 = null;
        while (it.hasNext() && (oVar2 = ((r) it.next()).b(k10, aVar, cVar, hVar, oVar)) == null) {
        }
        if (oVar2 == null) {
            Class q10 = aVar.q();
            if (oVar == null || d4.h.O(oVar)) {
                oVar2 = String[].class == q10 ? b4.m.f4634e : com.fasterxml.jackson.databind.ser.std.c0.a(q10);
            }
            if (oVar2 == null) {
                oVar2 = new x(aVar.k(), z10, hVar, oVar);
            }
        }
        if (this.f180a.b()) {
            Iterator it2 = this.f180a.d().iterator();
            if (it2.hasNext()) {
                androidx.appcompat.app.m.a(it2.next());
                throw null;
            }
        }
        return oVar2;
    }

    public k3.o k(c0 c0Var, c4.j jVar, k3.c cVar, boolean z10, w3.h hVar, k3.o oVar) {
        boolean z11;
        k3.j a10 = jVar.a();
        r.b h10 = h(c0Var, cVar, a10, AtomicReference.class);
        r.a f10 = h10 == null ? r.a.USE_DEFAULTS : h10.f();
        Object obj = null;
        if (f10 == r.a.USE_DEFAULTS || f10 == r.a.ALWAYS) {
            z11 = false;
        } else {
            int i10 = a.f182b[f10.ordinal()];
            z11 = true;
            if (i10 == 1) {
                obj = d4.e.b(a10);
                if (obj != null && obj.getClass().isArray()) {
                    obj = d4.c.a(obj);
                }
            } else if (i10 != 2) {
                if (i10 == 3) {
                    obj = t.f6713q;
                } else if (i10 == 4 && (obj = c0Var.j0(null, h10.e())) != null) {
                    z11 = c0Var.k0(obj);
                }
            } else if (a10.b()) {
                obj = t.f6713q;
            }
        }
        return new com.fasterxml.jackson.databind.ser.std.c(jVar, z10, hVar, oVar).i(obj, z11);
    }

    public h l(k3.j jVar, boolean z10, w3.h hVar, k3.o oVar) {
        return new com.fasterxml.jackson.databind.ser.std.j(jVar, z10, hVar, oVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k3.o m(c0 c0Var, c4.e eVar, k3.c cVar, boolean z10, w3.h hVar, k3.o oVar) {
        k3.o oVar2;
        a0 k10 = c0Var.k();
        Iterator it = v().iterator();
        k3.o oVar3 = null;
        while (it.hasNext() && (oVar3 = ((r) it.next()).a(k10, eVar, cVar, hVar, oVar)) == null) {
        }
        if (oVar3 == null && (oVar3 = C(c0Var, eVar, cVar)) == null) {
            if (cVar.g(null).i() == k.c.OBJECT) {
                return null;
            }
            Class q10 = eVar.q();
            if (EnumSet.class.isAssignableFrom(q10)) {
                k3.j k11 = eVar.k();
                if (!k11.E()) {
                    k11 = null;
                }
                oVar3 = p(k11);
            } else {
                Class q11 = eVar.k().q();
                if (G(q10)) {
                    if (q11 == String.class) {
                        if (d4.h.O(oVar)) {
                            oVar2 = b4.f.f4591b;
                        }
                        if (oVar3 == null) {
                            oVar3 = l(eVar.k(), z10, hVar, oVar);
                        }
                    } else {
                        oVar2 = q(eVar.k(), z10, hVar, oVar);
                    }
                    oVar3 = oVar2;
                    if (oVar3 == null) {
                    }
                } else {
                    if (q11 == String.class && d4.h.O(oVar)) {
                        oVar2 = b4.n.f4636b;
                        oVar3 = oVar2;
                    }
                    if (oVar3 == null) {
                    }
                }
            }
        }
        if (this.f180a.b()) {
            Iterator it2 = this.f180a.d().iterator();
            if (it2.hasNext()) {
                androidx.appcompat.app.m.a(it2.next());
                throw null;
            }
        }
        return oVar3;
    }

    public k3.o n(c0 c0Var, k3.j jVar, k3.c cVar, boolean z10) {
        a0 k10 = c0Var.k();
        boolean z11 = (z10 || !jVar.Q() || (jVar.D() && jVar.k().I())) ? z10 : true;
        w3.h c10 = c(k10, jVar.k());
        boolean z12 = c10 != null ? false : z11;
        k3.o g10 = g(c0Var, cVar.u());
        if (jVar.J()) {
            c4.g gVar = (c4.g) jVar;
            k3.o i10 = i(c0Var, cVar.u());
            if (gVar instanceof c4.h) {
                return u(c0Var, (c4.h) gVar, cVar, z12, i10, c10, g10);
            }
            Iterator it = v().iterator();
            k3.o oVar = null;
            while (it.hasNext() && (oVar = ((r) it.next()).g(k10, gVar, cVar, i10, c10, g10)) == null) {
            }
            if (oVar == null) {
                oVar = C(c0Var, jVar, cVar);
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
        if (!jVar.B()) {
            if (jVar.A()) {
                return j(c0Var, (c4.a) jVar, cVar, z12, c10, g10);
            }
            return null;
        }
        c4.d dVar = (c4.d) jVar;
        if (dVar instanceof c4.e) {
            return m(c0Var, (c4.e) dVar, cVar, z12, c10, g10);
        }
        Iterator it3 = v().iterator();
        k3.o oVar2 = null;
        while (it3.hasNext() && (oVar2 = ((r) it3.next()).f(k10, dVar, cVar, c10, g10)) == null) {
        }
        if (oVar2 == null) {
            oVar2 = C(c0Var, jVar, cVar);
        }
        if (oVar2 != null && this.f180a.b()) {
            Iterator it4 = this.f180a.d().iterator();
            if (it4.hasNext()) {
                androidx.appcompat.app.m.a(it4.next());
                throw null;
            }
        }
        return oVar2;
    }

    public k3.o o(a0 a0Var, k3.j jVar, k3.c cVar) {
        k.d g10 = cVar.g(null);
        if (g10.i() == k.c.OBJECT) {
            ((r3.q) cVar).M("declaringClass");
            return null;
        }
        com.fasterxml.jackson.databind.ser.std.m e10 = com.fasterxml.jackson.databind.ser.std.m.e(jVar.q(), a0Var, cVar, g10);
        if (this.f180a.b()) {
            Iterator it = this.f180a.d().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return e10;
    }

    public k3.o p(k3.j jVar) {
        return new com.fasterxml.jackson.databind.ser.std.n(jVar);
    }

    public h q(k3.j jVar, boolean z10, w3.h hVar, k3.o oVar) {
        return new b4.e(jVar, z10, hVar, oVar);
    }

    public k3.o r(a0 a0Var, k3.j jVar, k3.c cVar, boolean z10, k3.j jVar2) {
        return new com.fasterxml.jackson.databind.ser.std.r(jVar2, z10, c(a0Var, jVar2));
    }

    public k3.o s(a0 a0Var, k3.j jVar, k3.c cVar, boolean z10, k3.j jVar2) {
        return new b4.g(jVar2, z10, c(a0Var, jVar2));
    }

    public k3.o t(c0 c0Var, k3.j jVar, k3.c cVar, boolean z10, k3.j jVar2, k3.j jVar3) {
        Object obj = null;
        if (k.d.p(cVar.g(null), c0Var.a0(Map.Entry.class)).i() == k.c.OBJECT) {
            return null;
        }
        b4.h hVar = new b4.h(jVar3, jVar2, jVar3, z10, c(c0Var.k(), jVar3), null);
        k3.j g10 = hVar.g();
        r.b h10 = h(c0Var, cVar, g10, Map.Entry.class);
        r.a f10 = h10 == null ? r.a.USE_DEFAULTS : h10.f();
        if (f10 == r.a.USE_DEFAULTS || f10 == r.a.ALWAYS) {
            return hVar;
        }
        int i10 = a.f182b[f10.ordinal()];
        boolean z11 = true;
        if (i10 == 1) {
            obj = d4.e.b(g10);
            if (obj != null && obj.getClass().isArray()) {
                obj = d4.c.a(obj);
            }
        } else if (i10 != 2) {
            if (i10 == 3) {
                obj = t.f6713q;
            } else if (i10 == 4 && (obj = c0Var.j0(null, h10.e())) != null) {
                z11 = c0Var.k0(obj);
            }
        } else if (g10.b()) {
            obj = t.f6713q;
        }
        return hVar.l(obj, z11);
    }

    public k3.o u(c0 c0Var, c4.h hVar, k3.c cVar, boolean z10, k3.o oVar, w3.h hVar2, k3.o oVar2) {
        if (cVar.g(null).i() == k.c.OBJECT) {
            return null;
        }
        a0 k10 = c0Var.k();
        Iterator it = v().iterator();
        k3.o oVar3 = null;
        while (it.hasNext() && (oVar3 = ((r) it.next()).e(k10, hVar, cVar, oVar, hVar2, oVar2)) == null) {
        }
        if (oVar3 == null && (oVar3 = C(c0Var, hVar, cVar)) == null) {
            Object y10 = y(k10, cVar);
            p.a O = k10.O(Map.class, cVar.u());
            Set h10 = O == null ? null : O.h();
            s.a Q = k10.Q(Map.class, cVar.u());
            oVar3 = f(c0Var, cVar, t.m(h10, Q == null ? null : Q.e(), hVar, z10, hVar2, oVar, oVar2, y10));
        }
        if (this.f180a.b()) {
            Iterator it2 = this.f180a.d().iterator();
            if (it2.hasNext()) {
                androidx.appcompat.app.m.a(it2.next());
                throw null;
            }
        }
        return oVar3;
    }

    public abstract Iterable v();

    public d4.j w(c0 c0Var, r3.b bVar) {
        Object U = c0Var.W().U(bVar);
        if (U == null) {
            return null;
        }
        return c0Var.j(bVar, U);
    }

    public k3.o x(c0 c0Var, r3.b bVar, k3.o oVar) {
        d4.j w10 = w(c0Var, bVar);
        return w10 == null ? oVar : new d0(w10, w10.a(c0Var.l()), oVar);
    }

    public Object y(a0 a0Var, k3.c cVar) {
        return a0Var.g().p(cVar.u());
    }

    public k3.o z(c0 c0Var, k3.j jVar, k3.c cVar, boolean z10) {
        return q3.e.f18194e.c(c0Var.k(), jVar, cVar);
    }
}
