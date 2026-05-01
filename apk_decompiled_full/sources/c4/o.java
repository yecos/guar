package c4;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class o implements Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final k3.j[] f5580e = new k3.j[0];

    /* renamed from: f, reason: collision with root package name */
    public static final o f5581f = new o();

    /* renamed from: g, reason: collision with root package name */
    public static final n f5582g = n.i();

    /* renamed from: h, reason: collision with root package name */
    public static final Class f5583h = String.class;

    /* renamed from: i, reason: collision with root package name */
    public static final Class f5584i = Object.class;

    /* renamed from: j, reason: collision with root package name */
    public static final Class f5585j = Comparable.class;

    /* renamed from: k, reason: collision with root package name */
    public static final Class f5586k = Class.class;

    /* renamed from: l, reason: collision with root package name */
    public static final Class f5587l = Enum.class;

    /* renamed from: m, reason: collision with root package name */
    public static final Class f5588m = k3.m.class;

    /* renamed from: n, reason: collision with root package name */
    public static final Class f5589n;

    /* renamed from: o, reason: collision with root package name */
    public static final Class f5590o;

    /* renamed from: p, reason: collision with root package name */
    public static final Class f5591p;

    /* renamed from: q, reason: collision with root package name */
    public static final l f5592q;

    /* renamed from: r, reason: collision with root package name */
    public static final l f5593r;

    /* renamed from: s, reason: collision with root package name */
    public static final l f5594s;

    /* renamed from: t, reason: collision with root package name */
    public static final l f5595t;

    /* renamed from: u, reason: collision with root package name */
    public static final l f5596u;

    /* renamed from: v, reason: collision with root package name */
    public static final l f5597v;

    /* renamed from: w, reason: collision with root package name */
    public static final l f5598w;

    /* renamed from: x, reason: collision with root package name */
    public static final l f5599x;

    /* renamed from: y, reason: collision with root package name */
    public static final l f5600y;

    /* renamed from: a, reason: collision with root package name */
    public final d4.p f5601a;

    /* renamed from: b, reason: collision with root package name */
    public final p[] f5602b;

    /* renamed from: c, reason: collision with root package name */
    public final q f5603c;

    /* renamed from: d, reason: collision with root package name */
    public final ClassLoader f5604d;

    static {
        Class cls = Boolean.TYPE;
        f5589n = cls;
        Class cls2 = Integer.TYPE;
        f5590o = cls2;
        Class cls3 = Long.TYPE;
        f5591p = cls3;
        f5592q = new l(cls);
        f5593r = new l(cls2);
        f5594s = new l(cls3);
        f5595t = new l(String.class);
        f5596u = new l(Object.class);
        f5597v = new l(Comparable.class);
        f5598w = new l(Enum.class);
        f5599x = new l(Class.class);
        f5600y = new l(k3.m.class);
    }

    public o() {
        this(null);
    }

    public static o I() {
        return f5581f;
    }

    public static k3.j O() {
        return I().u();
    }

    public k3.j A(String str) {
        return this.f5603c.c(str);
    }

    public k3.j B(k3.j jVar, Class cls) {
        Class q10 = jVar.q();
        if (q10 == cls) {
            return jVar;
        }
        k3.j i10 = jVar.i(cls);
        if (i10 != null) {
            return i10;
        }
        if (cls.isAssignableFrom(q10)) {
            throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", cls.getName(), jVar));
        }
        throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", cls.getName(), jVar));
    }

    public h C(Class cls, Class cls2, Class cls3) {
        k3.j i10;
        k3.j i11;
        if (cls == Properties.class) {
            i10 = f5595t;
            i11 = i10;
        } else {
            n nVar = f5582g;
            i10 = i(null, cls2, nVar);
            i11 = i(null, cls3, nVar);
        }
        return D(cls, i10, i11);
    }

    public h D(Class cls, k3.j jVar, k3.j jVar2) {
        n h10 = n.h(cls, new k3.j[]{jVar, jVar2});
        h hVar = (h) i(null, cls, h10);
        if (h10.n()) {
            k3.j i10 = hVar.i(Map.class);
            k3.j p10 = i10.p();
            if (!p10.equals(jVar)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", d4.h.X(cls), jVar, p10));
            }
            k3.j k10 = i10.k();
            if (!k10.equals(jVar2)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", d4.h.X(cls), jVar2, k10));
            }
        }
        return hVar;
    }

    public k3.j E(Class cls, n nVar) {
        return a(cls, i(null, cls, nVar));
    }

    public k3.j F(k3.j jVar, Class cls) {
        return G(jVar, cls, false);
    }

    public k3.j G(k3.j jVar, Class cls, boolean z10) {
        k3.j i10;
        Class q10 = jVar.q();
        if (q10 == cls) {
            return jVar;
        }
        if (q10 == Object.class) {
            i10 = i(null, cls, f5582g);
        } else {
            if (!q10.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(String.format("Class %s not subtype of %s", d4.h.X(cls), d4.h.G(jVar)));
            }
            if (jVar.D()) {
                if (jVar.J()) {
                    if (cls == HashMap.class || cls == LinkedHashMap.class || cls == EnumMap.class || cls == TreeMap.class) {
                        i10 = i(null, cls, n.d(cls, jVar.p(), jVar.k()));
                    }
                } else if (jVar.B()) {
                    if (cls == ArrayList.class || cls == LinkedList.class || cls == HashSet.class || cls == TreeSet.class) {
                        i10 = i(null, cls, n.c(cls, jVar.k()));
                    } else if (q10 == EnumSet.class) {
                        return jVar;
                    }
                }
            }
            if (jVar.j().n()) {
                i10 = i(null, cls, f5582g);
            } else {
                int length = cls.getTypeParameters().length;
                i10 = length == 0 ? i(null, cls, f5582g) : i(null, cls, b(jVar, length, cls, z10));
            }
        }
        return i10.U(jVar);
    }

    public k3.j H(Type type) {
        return g(null, type, f5582g);
    }

    public Class J(String str) {
        Throwable th;
        Class e10;
        if (str.indexOf(46) < 0 && (e10 = e(str)) != null) {
            return e10;
        }
        ClassLoader L = L();
        if (L == null) {
            L = Thread.currentThread().getContextClassLoader();
        }
        if (L != null) {
            try {
                return x(str, true, L);
            } catch (Exception e11) {
                th = d4.h.F(e11);
            }
        } else {
            th = null;
        }
        try {
            return w(str);
        } catch (Exception e12) {
            if (th == null) {
                th = d4.h.F(e12);
            }
            d4.h.j0(th);
            throw new ClassNotFoundException(th.getMessage(), th);
        }
    }

    public k3.j[] K(k3.j jVar, Class cls) {
        k3.j i10 = jVar.i(cls);
        return i10 == null ? f5580e : i10.j().p();
    }

    public ClassLoader L() {
        return this.f5604d;
    }

    public k3.j M(Type type, n nVar) {
        return g(null, type, nVar);
    }

    public k3.j N(Class cls) {
        return d(cls, f5582g, null, null);
    }

    public k3.j a(Type type, k3.j jVar) {
        if (this.f5602b == null) {
            return jVar;
        }
        jVar.j();
        p[] pVarArr = this.f5602b;
        if (pVarArr.length <= 0) {
            return jVar;
        }
        p pVar = pVarArr[0];
        throw null;
    }

    public final n b(k3.j jVar, int i10, Class cls, boolean z10) {
        i[] iVarArr = new i[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iVarArr[i11] = new i(i11);
        }
        k3.j i12 = i(null, cls, n.e(cls, iVarArr)).i(jVar.q());
        if (i12 == null) {
            throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", jVar.q().getName(), cls.getName()));
        }
        String t10 = t(jVar, i12);
        if (t10 == null || z10) {
            k3.j[] jVarArr = new k3.j[i10];
            for (int i13 = 0; i13 < i10; i13++) {
                k3.j c02 = iVarArr[i13].c0();
                if (c02 == null) {
                    c02 = O();
                }
                jVarArr[i13] = c02;
            }
            return n.e(cls, jVarArr);
        }
        throw new IllegalArgumentException("Failed to specialize base type " + jVar.c() + " as " + cls.getName() + ", problem: " + t10);
    }

    public final k3.j c(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        k3.j jVar2;
        List l10 = nVar.l();
        if (l10.isEmpty()) {
            jVar2 = u();
        } else {
            if (l10.size() != 1) {
                throw new IllegalArgumentException("Strange Collection type " + cls.getName() + ": cannot determine type parameters");
            }
            jVar2 = (k3.j) l10.get(0);
        }
        return e.b0(cls, nVar, jVar, jVarArr, jVar2);
    }

    public k3.j d(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        k3.j f10;
        return (!nVar.n() || (f10 = f(cls)) == null) ? p(cls, nVar, jVar, jVarArr) : f10;
    }

    public Class e(String str) {
        if ("int".equals(str)) {
            return Integer.TYPE;
        }
        if ("long".equals(str)) {
            return Long.TYPE;
        }
        if ("float".equals(str)) {
            return Float.TYPE;
        }
        if ("double".equals(str)) {
            return Double.TYPE;
        }
        if ("boolean".equals(str)) {
            return Boolean.TYPE;
        }
        if ("byte".equals(str)) {
            return Byte.TYPE;
        }
        if ("char".equals(str)) {
            return Character.TYPE;
        }
        if ("short".equals(str)) {
            return Short.TYPE;
        }
        if ("void".equals(str)) {
            return Void.TYPE;
        }
        return null;
    }

    public k3.j f(Class cls) {
        if (cls.isPrimitive()) {
            if (cls == f5589n) {
                return f5592q;
            }
            if (cls == f5590o) {
                return f5593r;
            }
            if (cls == f5591p) {
                return f5594s;
            }
            return null;
        }
        if (cls == f5583h) {
            return f5595t;
        }
        if (cls == f5584i) {
            return f5596u;
        }
        if (cls == f5588m) {
            return f5600y;
        }
        return null;
    }

    public k3.j g(c cVar, Type type, n nVar) {
        k3.j n10;
        if (type instanceof Class) {
            n10 = i(cVar, (Class) type, f5582g);
        } else if (type instanceof ParameterizedType) {
            n10 = j(cVar, (ParameterizedType) type, nVar);
        } else {
            if (type instanceof k3.j) {
                return (k3.j) type;
            }
            if (type instanceof GenericArrayType) {
                n10 = h(cVar, (GenericArrayType) type, nVar);
            } else if (type instanceof TypeVariable) {
                n10 = k(cVar, (TypeVariable) type, nVar);
            } else {
                if (!(type instanceof WildcardType)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unrecognized Type: ");
                    sb.append(type == null ? "[null]" : type.toString());
                    throw new IllegalArgumentException(sb.toString());
                }
                n10 = n(cVar, (WildcardType) type, nVar);
            }
        }
        return a(type, n10);
    }

    public k3.j h(c cVar, GenericArrayType genericArrayType, n nVar) {
        return a.b0(g(cVar, genericArrayType.getGenericComponentType(), nVar), nVar);
    }

    public k3.j i(c cVar, Class cls, n nVar) {
        c b10;
        k3.j r10;
        k3.j[] s10;
        k3.j p10;
        k3.j f10 = f(cls);
        if (f10 != null) {
            return f10;
        }
        Object a10 = (nVar == null || nVar.n()) ? cls : nVar.a(cls);
        k3.j jVar = (k3.j) this.f5601a.get(a10);
        if (jVar != null) {
            return jVar;
        }
        if (cVar == null) {
            b10 = new c(cls);
        } else {
            c c10 = cVar.c(cls);
            if (c10 != null) {
                k kVar = new k(cls, f5582g);
                c10.a(kVar);
                return kVar;
            }
            b10 = cVar.b(cls);
        }
        if (cls.isArray()) {
            p10 = a.b0(g(b10, cls.getComponentType(), nVar), nVar);
        } else {
            if (cls.isInterface()) {
                s10 = s(b10, cls, nVar);
                r10 = null;
            } else {
                r10 = r(b10, cls, nVar);
                s10 = s(b10, cls, nVar);
            }
            k3.j[] jVarArr = s10;
            k3.j jVar2 = r10;
            if (cls == Properties.class) {
                l lVar = f5595t;
                jVar = h.d0(cls, nVar, jVar2, jVarArr, lVar, lVar);
            } else if (jVar2 != null) {
                jVar = jVar2.P(cls, nVar, jVar2, jVarArr);
            }
            p10 = (jVar == null && (jVar = l(b10, cls, nVar, jVar2, jVarArr)) == null && (jVar = m(b10, cls, nVar, jVar2, jVarArr)) == null) ? p(cls, nVar, jVar2, jVarArr) : jVar;
        }
        b10.d(p10);
        if (!p10.x()) {
            this.f5601a.putIfAbsent(a10, p10);
        }
        return p10;
    }

    public k3.j j(c cVar, ParameterizedType parameterizedType, n nVar) {
        n e10;
        Class cls = (Class) parameterizedType.getRawType();
        if (cls == f5587l) {
            return f5598w;
        }
        if (cls == f5585j) {
            return f5597v;
        }
        if (cls == f5586k) {
            return f5599x;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int length = actualTypeArguments == null ? 0 : actualTypeArguments.length;
        if (length == 0) {
            e10 = f5582g;
        } else {
            k3.j[] jVarArr = new k3.j[length];
            for (int i10 = 0; i10 < length; i10++) {
                jVarArr[i10] = g(cVar, actualTypeArguments[i10], nVar);
            }
            e10 = n.e(cls, jVarArr);
        }
        return i(cVar, cls, e10);
    }

    public k3.j k(c cVar, TypeVariable typeVariable, n nVar) {
        Type[] bounds;
        String name = typeVariable.getName();
        if (nVar == null) {
            throw new IllegalArgumentException("Null `bindings` passed (type variable \"" + name + "\")");
        }
        k3.j j10 = nVar.j(name);
        if (j10 != null) {
            return j10;
        }
        if (nVar.m(name)) {
            return f5596u;
        }
        n q10 = nVar.q(name);
        synchronized (typeVariable) {
            bounds = typeVariable.getBounds();
        }
        return g(cVar, bounds[0], q10);
    }

    public k3.j l(c cVar, Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        if (nVar == null) {
            nVar = f5582g;
        }
        if (cls == Map.class) {
            return o(cls, nVar, jVar, jVarArr);
        }
        if (cls == Collection.class) {
            return c(cls, nVar, jVar, jVarArr);
        }
        if (cls == AtomicReference.class) {
            return q(cls, nVar, jVar, jVarArr);
        }
        return null;
    }

    public k3.j m(c cVar, Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        for (k3.j jVar2 : jVarArr) {
            k3.j P = jVar2.P(cls, nVar, jVar, jVarArr);
            if (P != null) {
                return P;
            }
        }
        return null;
    }

    public k3.j n(c cVar, WildcardType wildcardType, n nVar) {
        return g(cVar, wildcardType.getUpperBounds()[0], nVar);
    }

    public final k3.j o(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        k3.j u10;
        k3.j jVar2;
        k3.j jVar3;
        if (cls == Properties.class) {
            u10 = f5595t;
        } else {
            List l10 = nVar.l();
            int size = l10.size();
            if (size != 0) {
                if (size == 2) {
                    k3.j jVar4 = (k3.j) l10.get(0);
                    jVar2 = (k3.j) l10.get(1);
                    jVar3 = jVar4;
                    return h.d0(cls, nVar, jVar, jVarArr, jVar3, jVar2);
                }
                Object[] objArr = new Object[4];
                objArr[0] = d4.h.X(cls);
                objArr[1] = Integer.valueOf(size);
                objArr[2] = size == 1 ? "" : "s";
                objArr[3] = nVar;
                throw new IllegalArgumentException(String.format("Strange Map type %s with %d type parameter%s (%s), can not resolve", objArr));
            }
            u10 = u();
        }
        jVar3 = u10;
        jVar2 = jVar3;
        return h.d0(cls, nVar, jVar, jVarArr, jVar3, jVar2);
    }

    public k3.j p(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        return new l(cls, nVar, jVar, jVarArr);
    }

    public final k3.j q(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        k3.j jVar2;
        List l10 = nVar.l();
        if (l10.isEmpty()) {
            jVar2 = u();
        } else {
            if (l10.size() != 1) {
                throw new IllegalArgumentException("Strange Reference type " + cls.getName() + ": cannot determine type parameters");
            }
            jVar2 = (k3.j) l10.get(0);
        }
        return j.g0(cls, nVar, jVar, jVarArr, jVar2);
    }

    public k3.j r(c cVar, Class cls, n nVar) {
        Type D = d4.h.D(cls);
        if (D == null) {
            return null;
        }
        return g(cVar, D, nVar);
    }

    public k3.j[] s(c cVar, Class cls, n nVar) {
        Type[] C = d4.h.C(cls);
        if (C == null || C.length == 0) {
            return f5580e;
        }
        int length = C.length;
        k3.j[] jVarArr = new k3.j[length];
        for (int i10 = 0; i10 < length; i10++) {
            jVarArr[i10] = g(cVar, C[i10], nVar);
        }
        return jVarArr;
    }

    public final String t(k3.j jVar, k3.j jVar2) {
        List l10 = jVar.j().l();
        List l11 = jVar2.j().l();
        int size = l11.size();
        int size2 = l10.size();
        int i10 = 0;
        while (i10 < size2) {
            k3.j jVar3 = (k3.j) l10.get(i10);
            k3.j O = i10 < size ? (k3.j) l11.get(i10) : O();
            if (!v(jVar3, O) && !jVar3.y(Object.class) && ((i10 != 0 || !jVar.J() || !O.y(Object.class)) && (!jVar3.H() || !jVar3.O(O.q())))) {
                return String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i10 + 1), Integer.valueOf(size2), jVar3.c(), O.c());
            }
            i10++;
        }
        return null;
    }

    public k3.j u() {
        return f5596u;
    }

    public final boolean v(k3.j jVar, k3.j jVar2) {
        if (jVar2 instanceof i) {
            ((i) jVar2).d0(jVar);
            return true;
        }
        if (jVar.q() != jVar2.q()) {
            return false;
        }
        List l10 = jVar.j().l();
        List l11 = jVar2.j().l();
        int size = l10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!v((k3.j) l10.get(i10), (k3.j) l11.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public Class w(String str) {
        return Class.forName(str);
    }

    public Class x(String str, boolean z10, ClassLoader classLoader) {
        return Class.forName(str, true, classLoader);
    }

    public e y(Class cls, Class cls2) {
        return z(cls, i(null, cls2, f5582g));
    }

    public e z(Class cls, k3.j jVar) {
        n g10 = n.g(cls, jVar);
        e eVar = (e) i(null, cls, g10);
        if (g10.n() && jVar != null) {
            k3.j k10 = eVar.i(Collection.class).k();
            if (!k10.equals(jVar)) {
                throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", d4.h.X(cls), jVar, k10));
            }
        }
        return eVar;
    }

    public o(d4.p pVar) {
        this.f5601a = pVar == null ? new d4.n(16, 200) : pVar;
        this.f5603c = new q(this);
        this.f5602b = null;
        this.f5604d = null;
    }
}
