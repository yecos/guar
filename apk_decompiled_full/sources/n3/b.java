package n3;

import b3.b;
import b3.b0;
import b3.h;
import b3.j0;
import b3.p;
import b3.s;
import com.fasterxml.jackson.databind.deser.std.d0;
import com.fasterxml.jackson.databind.deser.std.g0;
import com.fasterxml.jackson.databind.deser.std.i0;
import com.fasterxml.jackson.databind.deser.std.k0;
import com.fasterxml.jackson.databind.deser.std.m0;
import d4.y;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;
import k3.d;
import m3.i;
import r3.h0;

/* loaded from: classes.dex */
public abstract class b extends n implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Class f17161c = Object.class;

    /* renamed from: d, reason: collision with root package name */
    public static final Class f17162d = String.class;

    /* renamed from: e, reason: collision with root package name */
    public static final Class f17163e = CharSequence.class;

    /* renamed from: f, reason: collision with root package name */
    public static final Class f17164f = Iterable.class;

    /* renamed from: g, reason: collision with root package name */
    public static final Class f17165g = Map.Entry.class;

    /* renamed from: h, reason: collision with root package name */
    public static final Class f17166h = Serializable.class;

    /* renamed from: i, reason: collision with root package name */
    public static final k3.x f17167i = new k3.x("@JsonUnwrapped");

    /* renamed from: b, reason: collision with root package name */
    public final m3.k f17168b;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17169a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17170b;

        static {
            int[] iArr = new int[i.a.values().length];
            f17170b = iArr;
            try {
                iArr[i.a.DELEGATING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17170b[i.a.PROPERTIES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17170b[i.a.REQUIRE_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17170b[i.a.HEURISTIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[h.a.values().length];
            f17169a = iArr2;
            try {
                iArr2[h.a.DELEGATING.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17169a[h.a.PROPERTIES.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17169a[h.a.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: n3.b$b, reason: collision with other inner class name */
    public static class C0296b {

        /* renamed from: a, reason: collision with root package name */
        public static final HashMap f17171a;

        /* renamed from: b, reason: collision with root package name */
        public static final HashMap f17172b;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put(Collection.class.getName(), ArrayList.class);
            hashMap.put(List.class.getName(), ArrayList.class);
            hashMap.put(Set.class.getName(), HashSet.class);
            hashMap.put(SortedSet.class.getName(), TreeSet.class);
            hashMap.put(Queue.class.getName(), LinkedList.class);
            hashMap.put(AbstractList.class.getName(), ArrayList.class);
            hashMap.put(AbstractSet.class.getName(), HashSet.class);
            hashMap.put(Deque.class.getName(), LinkedList.class);
            hashMap.put(NavigableSet.class.getName(), TreeSet.class);
            f17171a = hashMap;
            HashMap hashMap2 = new HashMap();
            hashMap2.put(Map.class.getName(), LinkedHashMap.class);
            hashMap2.put(AbstractMap.class.getName(), LinkedHashMap.class);
            hashMap2.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
            hashMap2.put(SortedMap.class.getName(), TreeMap.class);
            hashMap2.put(NavigableMap.class.getName(), TreeMap.class);
            hashMap2.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
            f17172b = hashMap2;
        }

        public static Class a(k3.j jVar) {
            return (Class) f17171a.get(jVar.q().getName());
        }

        public static Class b(k3.j jVar) {
            return (Class) f17172b.get(jVar.q().getName());
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final k3.g f17173a;

        /* renamed from: b, reason: collision with root package name */
        public final k3.c f17174b;

        /* renamed from: c, reason: collision with root package name */
        public final h0 f17175c;

        /* renamed from: d, reason: collision with root package name */
        public final o3.e f17176d;

        /* renamed from: e, reason: collision with root package name */
        public final Map f17177e;

        /* renamed from: f, reason: collision with root package name */
        public List f17178f;

        /* renamed from: g, reason: collision with root package name */
        public int f17179g;

        /* renamed from: h, reason: collision with root package name */
        public List f17180h;

        /* renamed from: i, reason: collision with root package name */
        public int f17181i;

        public c(k3.g gVar, k3.c cVar, h0 h0Var, o3.e eVar, Map map) {
            this.f17173a = gVar;
            this.f17174b = cVar;
            this.f17175c = h0Var;
            this.f17176d = eVar;
            this.f17177e = map;
        }

        public void a(o3.d dVar) {
            if (this.f17180h == null) {
                this.f17180h = new LinkedList();
            }
            this.f17180h.add(dVar);
        }

        public void b(o3.d dVar) {
            if (this.f17178f == null) {
                this.f17178f = new LinkedList();
            }
            this.f17178f.add(dVar);
        }

        public k3.b c() {
            return this.f17173a.K();
        }

        public boolean d() {
            return this.f17181i > 0;
        }

        public boolean e() {
            return this.f17179g > 0;
        }

        public boolean f() {
            return this.f17180h != null;
        }

        public boolean g() {
            return this.f17178f != null;
        }

        public List h() {
            return this.f17180h;
        }

        public List i() {
            return this.f17178f;
        }

        public void j() {
            this.f17181i++;
        }

        public void k() {
            this.f17179g++;
        }
    }

    public b(m3.k kVar) {
        this.f17168b = kVar;
    }

    public Map A(k3.g gVar, k3.c cVar) {
        Map emptyMap = Collections.emptyMap();
        for (r3.s sVar : cVar.o()) {
            Iterator n10 = sVar.n();
            while (n10.hasNext()) {
                r3.m mVar = (r3.m) n10.next();
                r3.n r10 = mVar.r();
                r3.s[] sVarArr = (r3.s[]) emptyMap.get(r10);
                int q10 = mVar.q();
                if (sVarArr == null) {
                    if (emptyMap.isEmpty()) {
                        emptyMap = new LinkedHashMap();
                    }
                    sVarArr = new r3.s[r10.v()];
                    emptyMap.put(r10, sVarArr);
                } else if (sVarArr[q10] != null) {
                    gVar.v0(cVar, "Conflict: parameter #%d of %s bound to more than one property; %s vs %s", Integer.valueOf(q10), r10, sVarArr[q10], sVar);
                }
                sVarArr[q10] = sVar;
            }
        }
        return emptyMap;
    }

    public k3.k B(c4.a aVar, k3.f fVar, k3.c cVar, w3.e eVar, k3.k kVar) {
        Iterator it = this.f17168b.c().iterator();
        while (it.hasNext()) {
            k3.k g10 = ((o) it.next()).g(aVar, fVar, cVar, eVar, kVar);
            if (g10 != null) {
                return g10;
            }
        }
        return null;
    }

    public k3.k C(k3.j jVar, k3.f fVar, k3.c cVar) {
        Iterator it = this.f17168b.c().iterator();
        while (it.hasNext()) {
            k3.k a10 = ((o) it.next()).a(jVar, fVar, cVar);
            if (a10 != null) {
                return a10;
            }
        }
        return null;
    }

    public k3.k D(c4.e eVar, k3.f fVar, k3.c cVar, w3.e eVar2, k3.k kVar) {
        Iterator it = this.f17168b.c().iterator();
        while (it.hasNext()) {
            k3.k h10 = ((o) it.next()).h(eVar, fVar, cVar, eVar2, kVar);
            if (h10 != null) {
                return h10;
            }
        }
        return null;
    }

    public k3.k E(c4.d dVar, k3.f fVar, k3.c cVar, w3.e eVar, k3.k kVar) {
        Iterator it = this.f17168b.c().iterator();
        while (it.hasNext()) {
            k3.k e10 = ((o) it.next()).e(dVar, fVar, cVar, eVar, kVar);
            if (e10 != null) {
                return e10;
            }
        }
        return null;
    }

    public k3.k F(Class cls, k3.f fVar, k3.c cVar) {
        Iterator it = this.f17168b.c().iterator();
        while (it.hasNext()) {
            k3.k d10 = ((o) it.next()).d(cls, fVar, cVar);
            if (d10 != null) {
                return d10;
            }
        }
        return null;
    }

    public k3.k G(c4.h hVar, k3.f fVar, k3.c cVar, k3.p pVar, w3.e eVar, k3.k kVar) {
        Iterator it = this.f17168b.c().iterator();
        while (it.hasNext()) {
            k3.k c10 = ((o) it.next()).c(hVar, fVar, cVar, pVar, eVar, kVar);
            if (c10 != null) {
                return c10;
            }
        }
        return null;
    }

    public k3.k H(c4.g gVar, k3.f fVar, k3.c cVar, k3.p pVar, w3.e eVar, k3.k kVar) {
        Iterator it = this.f17168b.c().iterator();
        while (it.hasNext()) {
            k3.k i10 = ((o) it.next()).i(gVar, fVar, cVar, pVar, eVar, kVar);
            if (i10 != null) {
                return i10;
            }
        }
        return null;
    }

    public k3.k I(c4.j jVar, k3.f fVar, k3.c cVar, w3.e eVar, k3.k kVar) {
        Iterator it = this.f17168b.c().iterator();
        while (it.hasNext()) {
            k3.k b10 = ((o) it.next()).b(jVar, fVar, cVar, eVar, kVar);
            if (b10 != null) {
                return b10;
            }
        }
        return null;
    }

    public k3.k J(Class cls, k3.f fVar, k3.c cVar) {
        Iterator it = this.f17168b.c().iterator();
        while (it.hasNext()) {
            k3.k f10 = ((o) it.next()).f(cls, fVar, cVar);
            if (f10 != null) {
                return f10;
            }
        }
        return null;
    }

    public final k3.x K(r3.m mVar, k3.b bVar) {
        if (bVar == null) {
            return null;
        }
        k3.x x10 = bVar.x(mVar);
        if (x10 != null && !x10.h()) {
            return x10;
        }
        String r10 = bVar.r(mVar);
        if (r10 == null || r10.isEmpty()) {
            return null;
        }
        return k3.x.a(r10);
    }

    public k3.j L(k3.f fVar, Class cls) {
        k3.j m10 = m(fVar, fVar.e(cls));
        if (m10 == null || m10.y(cls)) {
            return null;
        }
        return m10;
    }

    public k3.w M(k3.g gVar, k3.d dVar, k3.w wVar) {
        j0 j0Var;
        b0.a Z;
        k3.b K = gVar.K();
        k3.f k10 = gVar.k();
        r3.i d10 = dVar.d();
        j0 j0Var2 = null;
        if (d10 != null) {
            if (K == null || (Z = K.Z(d10)) == null) {
                j0Var = null;
            } else {
                j0Var2 = Z.f();
                j0Var = Z.e();
            }
            b0.a h10 = k10.j(dVar.getType().q()).h();
            if (h10 != null) {
                if (j0Var2 == null) {
                    j0Var2 = h10.f();
                }
                if (j0Var == null) {
                    j0Var = h10.e();
                }
            }
        } else {
            j0Var = null;
        }
        b0.a r10 = k10.r();
        if (j0Var2 == null) {
            j0Var2 = r10.f();
        }
        if (j0Var == null) {
            j0Var = r10.e();
        }
        return (j0Var2 == null && j0Var == null) ? wVar : wVar.j(j0Var2, j0Var);
    }

    public boolean N(o3.e eVar, r3.n nVar, boolean z10, boolean z11) {
        Class x10 = nVar.x(0);
        if (x10 == String.class || x10 == f17163e) {
            if (z10 || z11) {
                eVar.m(nVar, z10);
            }
            return true;
        }
        if (x10 == Integer.TYPE || x10 == Integer.class) {
            if (z10 || z11) {
                eVar.j(nVar, z10);
            }
            return true;
        }
        if (x10 == Long.TYPE || x10 == Long.class) {
            if (z10 || z11) {
                eVar.k(nVar, z10);
            }
            return true;
        }
        if (x10 == Double.TYPE || x10 == Double.class) {
            if (z10 || z11) {
                eVar.i(nVar, z10);
            }
            return true;
        }
        if (x10 == Boolean.TYPE || x10 == Boolean.class) {
            if (z10 || z11) {
                eVar.g(nVar, z10);
            }
            return true;
        }
        if (x10 == BigInteger.class && (z10 || z11)) {
            eVar.f(nVar, z10);
        }
        if (x10 == BigDecimal.class && (z10 || z11)) {
            eVar.e(nVar, z10);
        }
        if (!z10) {
            return false;
        }
        eVar.h(nVar, z10, null, 0);
        return true;
    }

    public boolean O(k3.g gVar, r3.b bVar) {
        h.a h10;
        k3.b K = gVar.K();
        return (K == null || (h10 = K.h(gVar.k(), bVar)) == null || h10 == h.a.DISABLED) ? false : true;
    }

    public c4.e P(k3.j jVar, k3.f fVar) {
        Class a10 = C0296b.a(jVar);
        if (a10 != null) {
            return (c4.e) fVar.z().G(jVar, a10, true);
        }
        return null;
    }

    public c4.h Q(k3.j jVar, k3.f fVar) {
        Class b10 = C0296b.b(jVar);
        if (b10 != null) {
            return (c4.h) fVar.z().G(jVar, b10, true);
        }
        return null;
    }

    public final k3.j R(k3.f fVar, k3.j jVar) {
        jVar.q();
        if (this.f17168b.d()) {
            Iterator it = this.f17168b.a().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return null;
    }

    public void S(k3.g gVar, k3.c cVar, r3.m mVar) {
        gVar.v0(cVar, "Cannot define Creator parameter %d as `@JsonUnwrapped`: combination not yet supported", Integer.valueOf(mVar.q()));
    }

    public void T(k3.g gVar, k3.c cVar, o3.d dVar, int i10, k3.x xVar, b.a aVar) {
        if (xVar == null && aVar == null) {
            gVar.v0(cVar, "Argument #%d of constructor %s has no property name (and is not Injectable): can not use as property-based Creator", Integer.valueOf(i10), dVar);
        }
    }

    public w U(k3.f fVar, r3.b bVar, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof w) {
            return (w) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
        }
        Class cls = (Class) obj;
        if (d4.h.J(cls)) {
            return null;
        }
        if (w.class.isAssignableFrom(cls)) {
            fVar.u();
            return (w) d4.h.l(cls, fVar.b());
        }
        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<ValueInstantiator>");
    }

    public t V(k3.g gVar, k3.c cVar, k3.x xVar, int i10, r3.m mVar, b.a aVar) {
        k3.f k10 = gVar.k();
        k3.b K = gVar.K();
        k3.w a10 = K == null ? k3.w.f14996j : k3.w.a(K.p0(mVar), K.J(mVar), K.O(mVar), K.I(mVar));
        k3.j f02 = f0(gVar, mVar, mVar.f());
        d.a aVar2 = new d.a(xVar, f02, K.g0(mVar), mVar, a10);
        w3.e eVar = (w3.e) f02.t();
        if (eVar == null) {
            eVar = l(k10, f02);
        }
        j O = j.O(xVar, f02, aVar2.e(), eVar, cVar.t(), mVar, i10, aVar, M(gVar, aVar2, a10));
        k3.k Z = Z(gVar, mVar);
        if (Z == null) {
            Z = (k3.k) f02.u();
        }
        return Z != null ? O.L(gVar.Y(Z, O, f02)) : O;
    }

    public d4.k W(Class cls, k3.f fVar, r3.i iVar) {
        if (iVar == null) {
            return d4.k.h(fVar, cls);
        }
        if (fVar.b()) {
            d4.h.g(iVar.m(), fVar.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return d4.k.j(fVar, cls, iVar);
    }

    public k3.k X(k3.g gVar, r3.b bVar) {
        Object f10;
        k3.b K = gVar.K();
        if (K == null || (f10 = K.f(bVar)) == null) {
            return null;
        }
        return gVar.y(bVar, f10);
    }

    public k3.k Y(k3.g gVar, k3.j jVar, k3.c cVar) {
        k3.j jVar2;
        k3.j jVar3;
        Class q10 = jVar.q();
        if (q10 == f17161c || q10 == f17166h) {
            k3.f k10 = gVar.k();
            if (this.f17168b.d()) {
                jVar2 = L(k10, List.class);
                jVar3 = L(k10, Map.class);
            } else {
                jVar2 = null;
                jVar3 = null;
            }
            return new m0(jVar2, jVar3);
        }
        if (q10 == f17162d || q10 == f17163e) {
            return i0.f6553a;
        }
        Class cls = f17164f;
        if (q10 == cls) {
            c4.o l10 = gVar.l();
            k3.j[] K = l10.K(jVar, cls);
            return d(gVar, l10.z(Collection.class, (K == null || K.length != 1) ? c4.o.O() : K[0]), cVar);
        }
        if (q10 == f17165g) {
            k3.j h10 = jVar.h(0);
            k3.j h11 = jVar.h(1);
            w3.e eVar = (w3.e) h11.t();
            if (eVar == null) {
                eVar = l(gVar.k(), h11);
            }
            return new com.fasterxml.jackson.databind.deser.std.t(jVar, (k3.p) h10.u(), (k3.k) h11.u(), eVar);
        }
        String name = q10.getName();
        if (q10.isPrimitive() || name.startsWith("java.")) {
            k3.k a10 = com.fasterxml.jackson.databind.deser.std.v.a(q10, name);
            if (a10 == null) {
                a10 = com.fasterxml.jackson.databind.deser.std.j.a(q10, name);
            }
            if (a10 != null) {
                return a10;
            }
        }
        if (q10 == y.class) {
            return new k0();
        }
        k3.k b02 = b0(gVar, jVar, cVar);
        return b02 != null ? b02 : com.fasterxml.jackson.databind.deser.std.p.a(q10, name);
    }

    public k3.k Z(k3.g gVar, r3.b bVar) {
        Object m10;
        k3.b K = gVar.K();
        if (K == null || (m10 = K.m(bVar)) == null) {
            return null;
        }
        return gVar.y(bVar, m10);
    }

    @Override // n3.n
    public k3.k a(k3.g gVar, c4.a aVar, k3.c cVar) {
        k3.f k10 = gVar.k();
        k3.j k11 = aVar.k();
        k3.k kVar = (k3.k) k11.u();
        w3.e eVar = (w3.e) k11.t();
        if (eVar == null) {
            eVar = l(k10, k11);
        }
        w3.e eVar2 = eVar;
        k3.k B = B(aVar, k10, cVar, eVar2, kVar);
        if (B == null) {
            if (kVar == null) {
                Class q10 = k11.q();
                if (k11.K()) {
                    return com.fasterxml.jackson.databind.deser.std.x.c(q10);
                }
                if (q10 == String.class) {
                    return g0.f6532f;
                }
            }
            B = new com.fasterxml.jackson.databind.deser.std.w(aVar, kVar, eVar2);
        }
        if (this.f17168b.e()) {
            Iterator it = this.f17168b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return B;
    }

    public k3.p a0(k3.g gVar, r3.b bVar) {
        Object u10;
        k3.b K = gVar.K();
        if (K == null || (u10 = K.u(bVar)) == null) {
            return null;
        }
        return gVar.p0(bVar, u10);
    }

    public k3.k b0(k3.g gVar, k3.j jVar, k3.c cVar) {
        return q3.e.f18194e.b(jVar, gVar.k(), cVar);
    }

    public w3.e c0(k3.f fVar, k3.j jVar, r3.i iVar) {
        w3.g H = fVar.g().H(fVar, iVar, jVar);
        k3.j k10 = jVar.k();
        return H == null ? l(fVar, k10) : H.e(fVar, k10, fVar.T().d(fVar, iVar, k10));
    }

    @Override // n3.n
    public k3.k d(k3.g gVar, c4.e eVar, k3.c cVar) {
        k3.j k10 = eVar.k();
        k3.k kVar = (k3.k) k10.u();
        k3.f k11 = gVar.k();
        w3.e eVar2 = (w3.e) k10.t();
        if (eVar2 == null) {
            eVar2 = l(k11, k10);
        }
        w3.e eVar3 = eVar2;
        k3.k D = D(eVar, k11, cVar, eVar3, kVar);
        if (D == null) {
            Class q10 = eVar.q();
            if (kVar == null && EnumSet.class.isAssignableFrom(q10)) {
                D = new com.fasterxml.jackson.databind.deser.std.m(k10, null);
            }
        }
        if (D == null) {
            if (eVar.H() || eVar.z()) {
                c4.e P = P(eVar, k11);
                if (P != null) {
                    cVar = k11.i0(P);
                    eVar = P;
                } else {
                    if (eVar.t() == null) {
                        throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Collection type " + eVar);
                    }
                    D = n3.a.c(cVar);
                }
            }
            if (D == null) {
                w e02 = e0(gVar, cVar);
                if (!e02.j()) {
                    if (eVar.y(ArrayBlockingQueue.class)) {
                        return new com.fasterxml.jackson.databind.deser.std.a(eVar, kVar, eVar3, e02);
                    }
                    k3.k d10 = o3.l.d(gVar, eVar);
                    if (d10 != null) {
                        return d10;
                    }
                }
                D = k10.y(String.class) ? new com.fasterxml.jackson.databind.deser.std.h0(eVar, kVar, e02) : new com.fasterxml.jackson.databind.deser.std.h(eVar, kVar, eVar3, e02);
            }
        }
        if (this.f17168b.e()) {
            Iterator it = this.f17168b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return D;
    }

    public w3.e d0(k3.f fVar, k3.j jVar, r3.i iVar) {
        w3.g P = fVar.g().P(fVar, iVar, jVar);
        if (P == null) {
            return l(fVar, jVar);
        }
        try {
            return P.e(fVar, jVar, fVar.T().d(fVar, iVar, jVar));
        } catch (IllegalArgumentException | IllegalStateException e10) {
            p3.b v10 = p3.b.v(null, d4.h.o(e10), jVar);
            v10.initCause(e10);
            throw v10;
        }
    }

    @Override // n3.n
    public k3.k e(k3.g gVar, c4.d dVar, k3.c cVar) {
        k3.j k10 = dVar.k();
        k3.k kVar = (k3.k) k10.u();
        k3.f k11 = gVar.k();
        w3.e eVar = (w3.e) k10.t();
        if (eVar == null) {
            eVar = l(k11, k10);
        }
        k3.k E = E(dVar, k11, cVar, eVar, kVar);
        if (E != null && this.f17168b.e()) {
            Iterator it = this.f17168b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return E;
    }

    public w e0(k3.g gVar, k3.c cVar) {
        k3.f k10 = gVar.k();
        r3.c u10 = cVar.u();
        Object e02 = gVar.K().e0(u10);
        w U = e02 != null ? U(k10, u10, e02) : null;
        if (U == null && (U = o3.k.a(k10, cVar.s())) == null) {
            U = y(gVar, cVar);
        }
        if (this.f17168b.g()) {
            Iterator it = this.f17168b.i().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return U != null ? U.m(gVar, cVar) : U;
    }

    @Override // n3.n
    public k3.k f(k3.g gVar, k3.j jVar, k3.c cVar) {
        k3.f k10 = gVar.k();
        Class q10 = jVar.q();
        k3.k F = F(q10, k10, cVar);
        if (F == null) {
            if (q10 == Enum.class) {
                return n3.a.c(cVar);
            }
            w y10 = y(gVar, cVar);
            t[] E = y10 == null ? null : y10.E(gVar.k());
            Iterator it = cVar.w().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                r3.j jVar2 = (r3.j) it.next();
                if (O(gVar, jVar2)) {
                    if (jVar2.v() == 0) {
                        F = com.fasterxml.jackson.databind.deser.std.k.h(k10, q10, jVar2);
                    } else {
                        if (!jVar2.D().isAssignableFrom(q10)) {
                            gVar.q(jVar, String.format("Invalid `@JsonCreator` annotated Enum factory method [%s]: needs to return compatible type", jVar2.toString()));
                        }
                        F = com.fasterxml.jackson.databind.deser.std.k.g(k10, q10, jVar2, y10, E);
                    }
                }
            }
            if (F == null) {
                F = new com.fasterxml.jackson.databind.deser.std.k(W(q10, k10, cVar.k()), Boolean.valueOf(k10.D(k3.q.ACCEPT_CASE_INSENSITIVE_ENUMS)));
            }
        }
        if (this.f17168b.e()) {
            Iterator it2 = this.f17168b.b().iterator();
            if (it2.hasNext()) {
                androidx.appcompat.app.m.a(it2.next());
                throw null;
            }
        }
        return F;
    }

    public k3.j f0(k3.g gVar, r3.i iVar, k3.j jVar) {
        k3.p p02;
        k3.b K = gVar.K();
        if (K == null) {
            return jVar;
        }
        if (jVar.J() && jVar.p() != null && (p02 = gVar.p0(iVar, K.u(iVar))) != null) {
            jVar = ((c4.g) jVar).c0(p02);
            jVar.p();
        }
        if (jVar.v()) {
            k3.k y10 = gVar.y(iVar, K.f(iVar));
            if (y10 != null) {
                jVar = jVar.c0(y10);
            }
            w3.e c02 = c0(gVar.k(), jVar, iVar);
            if (c02 != null) {
                jVar = jVar.S(c02);
            }
        }
        w3.e d02 = d0(gVar.k(), jVar, iVar);
        if (d02 != null) {
            jVar = jVar.e0(d02);
        }
        return K.u0(gVar.k(), iVar, jVar);
    }

    @Override // n3.n
    public k3.p g(k3.g gVar, k3.j jVar) {
        k3.c cVar;
        k3.p pVar;
        k3.f k10 = gVar.k();
        if (this.f17168b.f()) {
            cVar = k10.B(jVar);
            Iterator it = this.f17168b.h().iterator();
            pVar = null;
            while (it.hasNext() && (pVar = ((p) it.next()).a(jVar, k10, cVar)) == null) {
            }
        } else {
            cVar = null;
            pVar = null;
        }
        if (pVar == null) {
            if (cVar == null) {
                cVar = k10.A(jVar.q());
            }
            pVar = a0(gVar, cVar.u());
            if (pVar == null) {
                pVar = jVar.F() ? z(gVar, jVar) : d0.e(k10, jVar);
            }
        }
        if (pVar != null && this.f17168b.e()) {
            Iterator it2 = this.f17168b.b().iterator();
            if (it2.hasNext()) {
                androidx.appcompat.app.m.a(it2.next());
                throw null;
            }
        }
        return pVar;
    }

    public abstract n g0(m3.k kVar);

    @Override // n3.n
    public k3.k h(k3.g gVar, c4.h hVar, k3.c cVar) {
        k3.c cVar2;
        c4.h hVar2;
        k3.k kVar;
        w e02;
        k3.f k10 = gVar.k();
        k3.j p10 = hVar.p();
        k3.j k11 = hVar.k();
        k3.k kVar2 = (k3.k) k11.u();
        k3.p pVar = (k3.p) p10.u();
        w3.e eVar = (w3.e) k11.t();
        w3.e l10 = eVar == null ? l(k10, k11) : eVar;
        k3.k G = G(hVar, k10, cVar, pVar, l10, kVar2);
        if (G == null) {
            Class q10 = hVar.q();
            if (EnumMap.class.isAssignableFrom(q10)) {
                if (q10 == EnumMap.class) {
                    cVar2 = cVar;
                    e02 = null;
                } else {
                    cVar2 = cVar;
                    e02 = e0(gVar, cVar2);
                }
                if (!p10.E()) {
                    throw new IllegalArgumentException("Cannot construct EnumMap; generic (key) type not available");
                }
                G = new com.fasterxml.jackson.databind.deser.std.l(hVar, e02, null, kVar2, l10, null);
            } else {
                cVar2 = cVar;
            }
            if (G == null) {
                if (hVar.H() || hVar.z()) {
                    c4.h Q = Q(hVar, k10);
                    if (Q != null) {
                        Q.q();
                        cVar2 = k10.i0(Q);
                    } else {
                        if (hVar.t() == null) {
                            throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Map type " + hVar);
                        }
                        G = n3.a.c(cVar);
                        Q = hVar;
                    }
                    hVar2 = Q;
                    kVar = G;
                } else {
                    k3.k e10 = o3.l.e(gVar, hVar);
                    if (e10 != null) {
                        return e10;
                    }
                    kVar = e10;
                    hVar2 = hVar;
                }
                k3.c cVar3 = cVar2;
                k3.k kVar3 = kVar;
                if (kVar == null) {
                    com.fasterxml.jackson.databind.deser.std.s sVar = new com.fasterxml.jackson.databind.deser.std.s(hVar2, e0(gVar, cVar3), pVar, kVar2, l10);
                    p.a O = k10.O(Map.class, cVar3.u());
                    sVar.m(O == null ? null : O.g());
                    s.a Q2 = k10.Q(Map.class, cVar3.u());
                    sVar.n(Q2 == null ? null : Q2.e());
                    kVar3 = sVar;
                }
                G = kVar3;
            }
        }
        if (this.f17168b.e()) {
            Iterator it = this.f17168b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return G;
    }

    @Override // n3.n
    public k3.k i(k3.g gVar, c4.g gVar2, k3.c cVar) {
        k3.j p10 = gVar2.p();
        k3.j k10 = gVar2.k();
        k3.f k11 = gVar.k();
        k3.k kVar = (k3.k) k10.u();
        k3.p pVar = (k3.p) p10.u();
        w3.e eVar = (w3.e) k10.t();
        if (eVar == null) {
            eVar = l(k11, k10);
        }
        k3.k H = H(gVar2, k11, cVar, pVar, eVar, kVar);
        if (H != null && this.f17168b.e()) {
            Iterator it = this.f17168b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return H;
    }

    @Override // n3.n
    public k3.k j(k3.g gVar, c4.j jVar, k3.c cVar) {
        k3.j k10 = jVar.k();
        k3.k kVar = (k3.k) k10.u();
        k3.f k11 = gVar.k();
        w3.e eVar = (w3.e) k10.t();
        if (eVar == null) {
            eVar = l(k11, k10);
        }
        w3.e eVar2 = eVar;
        k3.k I = I(jVar, k11, cVar, eVar2, kVar);
        if (I == null && jVar.N(AtomicReference.class)) {
            return new com.fasterxml.jackson.databind.deser.std.e(jVar, jVar.q() != AtomicReference.class ? e0(gVar, cVar) : null, eVar2, kVar);
        }
        if (I != null && this.f17168b.e()) {
            Iterator it = this.f17168b.b().iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return I;
    }

    @Override // n3.n
    public k3.k k(k3.f fVar, k3.j jVar, k3.c cVar) {
        Class q10 = jVar.q();
        k3.k J = J(q10, fVar, cVar);
        return J != null ? J : com.fasterxml.jackson.databind.deser.std.r.l(q10);
    }

    @Override // n3.n
    public w3.e l(k3.f fVar, k3.j jVar) {
        Collection c10;
        k3.j m10;
        r3.c u10 = fVar.A(jVar.q()).u();
        w3.g c02 = fVar.g().c0(fVar, u10, jVar);
        if (c02 == null) {
            c02 = fVar.s(jVar);
            if (c02 == null) {
                return null;
            }
            c10 = null;
        } else {
            c10 = fVar.T().c(fVar, u10);
        }
        if (c02.g() == null && jVar.z() && (m10 = m(fVar, jVar)) != null && !m10.y(jVar.q())) {
            c02 = c02.d(m10.q());
        }
        try {
            return c02.e(fVar, jVar, c10);
        } catch (IllegalArgumentException | IllegalStateException e10) {
            p3.b v10 = p3.b.v(null, d4.h.o(e10), jVar);
            v10.initCause(e10);
            throw v10;
        }
    }

    @Override // n3.n
    public k3.j m(k3.f fVar, k3.j jVar) {
        k3.j R;
        while (true) {
            R = R(fVar, jVar);
            if (R == null) {
                return jVar;
            }
            Class q10 = jVar.q();
            Class<?> q11 = R.q();
            if (q10 == q11 || !q10.isAssignableFrom(q11)) {
                break;
            }
            jVar = R;
        }
        throw new IllegalArgumentException("Invalid abstract type resolution from " + jVar + " to " + R + ": latter is not a subtype of former");
    }

    @Override // n3.n
    public final n n(o oVar) {
        return g0(this.f17168b.j(oVar));
    }

    public void o(k3.g gVar, k3.c cVar, o3.e eVar, o3.d dVar, m3.i iVar) {
        k3.x xVar;
        boolean z10;
        int e10;
        if (1 != dVar.g()) {
            if (iVar.d() || (e10 = dVar.e()) < 0 || !(iVar.c() || dVar.h(e10) == null)) {
                s(gVar, cVar, eVar, dVar);
                return;
            } else {
                q(gVar, cVar, eVar, dVar);
                return;
            }
        }
        r3.m i10 = dVar.i(0);
        b.a f10 = dVar.f(0);
        int i11 = a.f17170b[iVar.e().ordinal()];
        if (i11 == 1) {
            xVar = null;
            z10 = false;
        } else if (i11 == 2) {
            k3.x h10 = dVar.h(0);
            if (h10 == null) {
                T(gVar, cVar, dVar, 0, h10, f10);
            }
            xVar = h10;
            z10 = true;
        } else {
            if (i11 == 3) {
                gVar.v0(cVar, "Single-argument constructor (%s) is annotated but no 'mode' defined; `CreatorDetector`configured with `SingleArgConstructor.REQUIRE_MODE`", dVar.b());
                return;
            }
            r3.s j10 = dVar.j(0);
            k3.x c10 = dVar.c(0);
            z10 = (c10 == null && f10 == null) ? false : true;
            if (!z10 && j10 != null) {
                c10 = dVar.h(0);
                z10 = c10 != null && j10.f();
            }
            xVar = c10;
        }
        if (z10) {
            eVar.l(dVar.b(), true, new t[]{V(gVar, cVar, xVar, 0, i10, f10)});
            return;
        }
        N(eVar, dVar.b(), true, true);
        r3.s j11 = dVar.j(0);
        if (j11 != null) {
            ((r3.d0) j11).l0();
        }
    }

    public void p(k3.g gVar, c cVar, boolean z10) {
        k3.c cVar2 = cVar.f17174b;
        o3.e eVar = cVar.f17176d;
        k3.b c10 = cVar.c();
        h0 h0Var = cVar.f17175c;
        Map map = cVar.f17177e;
        r3.e d10 = cVar2.d();
        if (d10 != null && (!eVar.o() || O(gVar, d10))) {
            eVar.r(d10);
        }
        for (r3.e eVar2 : cVar2.v()) {
            h.a h10 = c10.h(gVar.k(), eVar2);
            if (h.a.DISABLED != h10) {
                if (h10 != null) {
                    int i10 = a.f17169a[h10.ordinal()];
                    if (i10 == 1) {
                        q(gVar, cVar2, eVar, o3.d.a(c10, eVar2, null));
                    } else if (i10 != 2) {
                        o(gVar, cVar2, eVar, o3.d.a(c10, eVar2, (r3.s[]) map.get(eVar2)), gVar.k().a0());
                    } else {
                        s(gVar, cVar2, eVar, o3.d.a(c10, eVar2, (r3.s[]) map.get(eVar2)));
                    }
                    cVar.j();
                } else if (z10 && h0Var.j(eVar2)) {
                    cVar.a(o3.d.a(c10, eVar2, (r3.s[]) map.get(eVar2)));
                }
            }
        }
    }

    public void q(k3.g gVar, k3.c cVar, o3.e eVar, o3.d dVar) {
        int g10 = dVar.g();
        t[] tVarArr = new t[g10];
        int i10 = -1;
        for (int i11 = 0; i11 < g10; i11++) {
            r3.m i12 = dVar.i(i11);
            b.a f10 = dVar.f(i11);
            if (f10 != null) {
                tVarArr[i11] = V(gVar, cVar, null, i11, i12, f10);
            } else if (i10 < 0) {
                i10 = i11;
            } else {
                gVar.v0(cVar, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", Integer.valueOf(i10), Integer.valueOf(i11), dVar);
            }
        }
        if (i10 < 0) {
            gVar.v0(cVar, "No argument left as delegating for Creator %s: exactly one required", dVar);
        }
        if (g10 != 1) {
            eVar.h(dVar.b(), true, tVarArr, i10);
            return;
        }
        N(eVar, dVar.b(), true, true);
        r3.s j10 = dVar.j(0);
        if (j10 != null) {
            ((r3.d0) j10).l0();
        }
    }

    public void r(k3.g gVar, c cVar, boolean z10) {
        k3.c cVar2 = cVar.f17174b;
        o3.e eVar = cVar.f17176d;
        k3.b c10 = cVar.c();
        h0 h0Var = cVar.f17175c;
        Map map = cVar.f17177e;
        for (r3.j jVar : cVar2.w()) {
            h.a h10 = c10.h(gVar.k(), jVar);
            int v10 = jVar.v();
            if (h10 == null) {
                if (z10 && v10 == 1 && h0Var.j(jVar)) {
                    cVar.b(o3.d.a(c10, jVar, null));
                }
            } else if (h10 != h.a.DISABLED) {
                if (v10 == 0) {
                    eVar.r(jVar);
                } else {
                    int i10 = a.f17169a[h10.ordinal()];
                    if (i10 == 1) {
                        q(gVar, cVar2, eVar, o3.d.a(c10, jVar, null));
                    } else if (i10 != 2) {
                        o(gVar, cVar2, eVar, o3.d.a(c10, jVar, (r3.s[]) map.get(jVar)), m3.i.f16668d);
                    } else {
                        s(gVar, cVar2, eVar, o3.d.a(c10, jVar, (r3.s[]) map.get(jVar)));
                    }
                    cVar.k();
                }
            }
        }
    }

    public void s(k3.g gVar, k3.c cVar, o3.e eVar, o3.d dVar) {
        int g10 = dVar.g();
        t[] tVarArr = new t[g10];
        int i10 = 0;
        while (i10 < g10) {
            b.a f10 = dVar.f(i10);
            r3.m i11 = dVar.i(i10);
            k3.x h10 = dVar.h(i10);
            if (h10 == null) {
                if (gVar.K().d0(i11) != null) {
                    S(gVar, cVar, i11);
                }
                k3.x d10 = dVar.d(i10);
                T(gVar, cVar, dVar, i10, d10, f10);
                h10 = d10;
            }
            int i12 = i10;
            tVarArr[i12] = V(gVar, cVar, h10, i10, i11, f10);
            i10 = i12 + 1;
        }
        eVar.l(dVar.b(), true, tVarArr);
    }

    public void t(k3.g gVar, c cVar, List list) {
        h0 h0Var;
        boolean z10;
        Iterator it;
        o3.e eVar;
        int i10;
        o3.e eVar2;
        h0 h0Var2;
        boolean z11;
        Iterator it2;
        int i11;
        t[] tVarArr;
        r3.n nVar;
        int i12;
        o3.d dVar;
        o3.d dVar2;
        k3.f k10 = gVar.k();
        k3.c cVar2 = cVar.f17174b;
        o3.e eVar3 = cVar.f17176d;
        k3.b c10 = cVar.c();
        h0 h0Var3 = cVar.f17175c;
        boolean d10 = k10.a0().d();
        Iterator it3 = list.iterator();
        LinkedList linkedList = null;
        while (it3.hasNext()) {
            o3.d dVar3 = (o3.d) it3.next();
            int g10 = dVar3.g();
            r3.n b10 = dVar3.b();
            if (g10 == 1) {
                r3.s j10 = dVar3.j(0);
                if (d10 || w(c10, b10, j10)) {
                    t[] tVarArr2 = new t[1];
                    b.a f10 = dVar3.f(0);
                    k3.x h10 = dVar3.h(0);
                    if (h10 != null || (h10 = dVar3.d(0)) != null || f10 != null) {
                        tVarArr2[0] = V(gVar, cVar2, h10, 0, dVar3.i(0), f10);
                        eVar3.l(b10, false, tVarArr2);
                    }
                } else {
                    N(eVar3, b10, false, h0Var3.j(b10));
                    if (j10 != null) {
                        ((r3.d0) j10).l0();
                    }
                }
                eVar = eVar3;
                h0Var = h0Var3;
                z10 = d10;
                it = it3;
            } else {
                t[] tVarArr3 = new t[g10];
                int i13 = 0;
                int i14 = -1;
                int i15 = 0;
                int i16 = 0;
                while (i13 < g10) {
                    r3.m t10 = b10.t(i13);
                    r3.s j11 = dVar3.j(i13);
                    b.a s10 = c10.s(t10);
                    k3.x c11 = j11 == null ? null : j11.c();
                    if (j11 == null || !j11.C()) {
                        i10 = i13;
                        eVar2 = eVar3;
                        h0Var2 = h0Var3;
                        z11 = d10;
                        it2 = it3;
                        i11 = i14;
                        tVarArr = tVarArr3;
                        nVar = b10;
                        i12 = g10;
                        if (s10 != null) {
                            i16++;
                            dVar2 = dVar3;
                            tVarArr[i10] = V(gVar, cVar2, c11, i10, t10, s10);
                        } else {
                            dVar = dVar3;
                            if (c10.d0(t10) != null) {
                                S(gVar, cVar2, t10);
                            } else if (i11 < 0) {
                                i14 = i10;
                                dVar3 = dVar;
                                i13 = i10 + 1;
                                g10 = i12;
                                b10 = nVar;
                                tVarArr3 = tVarArr;
                                d10 = z11;
                                it3 = it2;
                                h0Var3 = h0Var2;
                                eVar3 = eVar2;
                            }
                            i14 = i11;
                            dVar3 = dVar;
                            i13 = i10 + 1;
                            g10 = i12;
                            b10 = nVar;
                            tVarArr3 = tVarArr;
                            d10 = z11;
                            it3 = it2;
                            h0Var3 = h0Var2;
                            eVar3 = eVar2;
                        }
                    } else {
                        i15++;
                        i10 = i13;
                        z11 = d10;
                        i11 = i14;
                        it2 = it3;
                        tVarArr = tVarArr3;
                        h0Var2 = h0Var3;
                        nVar = b10;
                        eVar2 = eVar3;
                        i12 = g10;
                        dVar2 = dVar3;
                        tVarArr[i10] = V(gVar, cVar2, c11, i10, t10, s10);
                    }
                    i14 = i11;
                    dVar = dVar2;
                    dVar3 = dVar;
                    i13 = i10 + 1;
                    g10 = i12;
                    b10 = nVar;
                    tVarArr3 = tVarArr;
                    d10 = z11;
                    it3 = it2;
                    h0Var3 = h0Var2;
                    eVar3 = eVar2;
                }
                o3.d dVar4 = dVar3;
                o3.e eVar4 = eVar3;
                h0Var = h0Var3;
                z10 = d10;
                it = it3;
                int i17 = i14;
                t[] tVarArr4 = tVarArr3;
                r3.n nVar2 = b10;
                int i18 = g10;
                int i19 = i15 + 0;
                if (i15 <= 0 && i16 <= 0) {
                    eVar = eVar4;
                } else if (i19 + i16 == i18) {
                    eVar = eVar4;
                    eVar.l(nVar2, false, tVarArr4);
                } else {
                    eVar = eVar4;
                    if (i15 == 0 && i16 + 1 == i18) {
                        eVar.h(nVar2, false, tVarArr4, 0);
                    } else {
                        k3.x d11 = dVar4.d(i17);
                        if (d11 == null || d11.h()) {
                            gVar.v0(cVar2, "Argument #%d of constructor %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", Integer.valueOf(i17), nVar2);
                        }
                    }
                }
                if (!eVar.o()) {
                    LinkedList linkedList2 = linkedList == null ? new LinkedList() : linkedList;
                    linkedList2.add(nVar2);
                    linkedList = linkedList2;
                }
            }
            eVar3 = eVar;
            d10 = z10;
            it3 = it;
            h0Var3 = h0Var;
        }
        o3.e eVar5 = eVar3;
        h0 h0Var4 = h0Var3;
        if (linkedList == null || eVar5.p() || eVar5.q()) {
            return;
        }
        x(gVar, cVar2, h0Var4, c10, eVar5, linkedList);
    }

    public void u(k3.g gVar, c cVar, List list) {
        int i10;
        h0 h0Var;
        Map map;
        Iterator it;
        t[] tVarArr;
        r3.n nVar;
        k3.c cVar2 = cVar.f17174b;
        o3.e eVar = cVar.f17176d;
        k3.b c10 = cVar.c();
        h0 h0Var2 = cVar.f17175c;
        Map map2 = cVar.f17177e;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            o3.d dVar = (o3.d) it2.next();
            int g10 = dVar.g();
            r3.n b10 = dVar.b();
            r3.s[] sVarArr = (r3.s[]) map2.get(b10);
            if (g10 == 1) {
                r3.s j10 = dVar.j(0);
                if (w(c10, b10, j10)) {
                    t[] tVarArr2 = new t[g10];
                    r3.m mVar = null;
                    int i11 = 0;
                    int i12 = 0;
                    int i13 = 0;
                    while (i11 < g10) {
                        r3.m t10 = b10.t(i11);
                        r3.s sVar = sVarArr == null ? null : sVarArr[i11];
                        b.a s10 = c10.s(t10);
                        k3.x c11 = sVar == null ? null : sVar.c();
                        if (sVar == null || !sVar.C()) {
                            i10 = i11;
                            h0Var = h0Var2;
                            map = map2;
                            it = it2;
                            tVarArr = tVarArr2;
                            nVar = b10;
                            if (s10 != null) {
                                i13++;
                                tVarArr[i10] = V(gVar, cVar2, c11, i10, t10, s10);
                            } else if (c10.d0(t10) != null) {
                                S(gVar, cVar2, t10);
                            } else if (mVar == null) {
                                mVar = t10;
                            }
                        } else {
                            i12++;
                            i10 = i11;
                            h0Var = h0Var2;
                            tVarArr = tVarArr2;
                            map = map2;
                            it = it2;
                            nVar = b10;
                            tVarArr[i10] = V(gVar, cVar2, c11, i10, t10, s10);
                        }
                        i11 = i10 + 1;
                        tVarArr2 = tVarArr;
                        b10 = nVar;
                        h0Var2 = h0Var;
                        map2 = map;
                        it2 = it;
                    }
                    h0 h0Var3 = h0Var2;
                    Map map3 = map2;
                    Iterator it3 = it2;
                    t[] tVarArr3 = tVarArr2;
                    r3.n nVar2 = b10;
                    int i14 = i12 + 0;
                    if (i12 > 0 || i13 > 0) {
                        if (i14 + i13 == g10) {
                            eVar.l(nVar2, false, tVarArr3);
                        } else if (i12 == 0 && i13 + 1 == g10) {
                            eVar.h(nVar2, false, tVarArr3, 0);
                        } else {
                            gVar.v0(cVar2, "Argument #%d of factory method %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", Integer.valueOf(mVar.q()), nVar2);
                        }
                    }
                    it2 = it3;
                    h0Var2 = h0Var3;
                    map2 = map3;
                } else {
                    N(eVar, b10, false, h0Var2.j(b10));
                    if (j10 != null) {
                        ((r3.d0) j10).l0();
                    }
                }
            }
        }
    }

    public void v(k3.g gVar, c cVar, r3.e eVar, List list) {
        int v10 = eVar.v();
        k3.b K = gVar.K();
        t[] tVarArr = new t[v10];
        for (int i10 = 0; i10 < v10; i10++) {
            r3.m t10 = eVar.t(i10);
            b.a s10 = K.s(t10);
            k3.x x10 = K.x(t10);
            if (x10 == null || x10.h()) {
                x10 = k3.x.a((String) list.get(i10));
            }
            tVarArr[i10] = V(gVar, cVar.f17174b, x10, i10, t10, s10);
        }
        cVar.f17176d.l(eVar, false, tVarArr);
    }

    public final boolean w(k3.b bVar, r3.n nVar, r3.s sVar) {
        String name;
        if ((sVar == null || !sVar.C()) && bVar.s(nVar.t(0)) == null) {
            return (sVar == null || (name = sVar.getName()) == null || name.isEmpty() || !sVar.f()) ? false : true;
        }
        return true;
    }

    public final void x(k3.g gVar, k3.c cVar, h0 h0Var, k3.b bVar, o3.e eVar, List list) {
        int i10;
        Iterator it = list.iterator();
        r3.n nVar = null;
        r3.n nVar2 = null;
        t[] tVarArr = null;
        while (true) {
            if (!it.hasNext()) {
                nVar = nVar2;
                break;
            }
            r3.n nVar3 = (r3.n) it.next();
            if (h0Var.j(nVar3)) {
                int v10 = nVar3.v();
                t[] tVarArr2 = new t[v10];
                int i11 = 0;
                while (true) {
                    if (i11 < v10) {
                        r3.m t10 = nVar3.t(i11);
                        k3.x K = K(t10, bVar);
                        if (K != null && !K.h()) {
                            tVarArr2[i11] = V(gVar, cVar, K, t10.q(), t10, null);
                            i11++;
                        }
                    } else {
                        if (nVar2 != null) {
                            break;
                        }
                        nVar2 = nVar3;
                        tVarArr = tVarArr2;
                    }
                }
            }
        }
        if (nVar != null) {
            eVar.l(nVar, false, tVarArr);
            r3.q qVar = (r3.q) cVar;
            for (t tVar : tVarArr) {
                k3.x c10 = tVar.c();
                if (!qVar.K(c10)) {
                    qVar.F(d4.w.E(gVar.k(), tVar.d(), c10));
                }
            }
        }
    }

    public w y(k3.g gVar, k3.c cVar) {
        ArrayList arrayList;
        r3.e a10;
        k3.f k10 = gVar.k();
        h0 t10 = k10.t(cVar.s(), cVar.u());
        m3.i a02 = k10.a0();
        c cVar2 = new c(gVar, cVar, t10, new o3.e(cVar, k10), A(gVar, cVar));
        r(gVar, cVar2, !a02.a());
        if (cVar.z().C()) {
            if (cVar.z().L() && (a10 = s3.a.a(gVar, cVar, (arrayList = new ArrayList()))) != null) {
                v(gVar, cVar2, a10, arrayList);
                return cVar2.f17176d.n(gVar);
            }
            if (!cVar.C()) {
                p(gVar, cVar2, a02.b(cVar.s()));
                if (cVar2.f() && !cVar2.d()) {
                    t(gVar, cVar2, cVar2.h());
                }
            }
        }
        if (cVar2.g() && !cVar2.e() && !cVar2.d()) {
            u(gVar, cVar2, cVar2.i());
        }
        return cVar2.f17176d.n(gVar);
    }

    public final k3.p z(k3.g gVar, k3.j jVar) {
        k3.f k10 = gVar.k();
        Class q10 = jVar.q();
        k3.c g02 = k10.g0(jVar);
        k3.p a02 = a0(gVar, g02.u());
        if (a02 != null) {
            return a02;
        }
        k3.k F = F(q10, k10, g02);
        if (F != null) {
            return d0.b(k10, jVar, F);
        }
        k3.k Z = Z(gVar, g02.u());
        if (Z != null) {
            return d0.b(k10, jVar, Z);
        }
        d4.k W = W(q10, k10, g02.k());
        for (r3.j jVar2 : g02.w()) {
            if (O(gVar, jVar2)) {
                if (jVar2.v() != 1 || !jVar2.D().isAssignableFrom(q10)) {
                    throw new IllegalArgumentException("Unsuitable method (" + jVar2 + ") decorated with @JsonCreator (for Enum type " + q10.getName() + ")");
                }
                if (jVar2.x(0) == String.class) {
                    if (k10.b()) {
                        d4.h.g(jVar2.m(), gVar.o0(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    return d0.d(W, jVar2);
                }
            }
        }
        return d0.c(W);
    }
}
