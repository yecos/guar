package r3;

import b3.b;
import b3.h;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final m3.m f18355a;

    /* renamed from: b, reason: collision with root package name */
    public final a f18356b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f18357c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.j f18358d;

    /* renamed from: e, reason: collision with root package name */
    public final c f18359e;

    /* renamed from: f, reason: collision with root package name */
    public final h0 f18360f;

    /* renamed from: g, reason: collision with root package name */
    public final k3.b f18361g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f18362h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18363i;

    /* renamed from: j, reason: collision with root package name */
    public LinkedHashMap f18364j;

    /* renamed from: k, reason: collision with root package name */
    public LinkedList f18365k;

    /* renamed from: l, reason: collision with root package name */
    public Map f18366l;

    /* renamed from: m, reason: collision with root package name */
    public LinkedList f18367m;

    /* renamed from: n, reason: collision with root package name */
    public LinkedList f18368n;

    /* renamed from: o, reason: collision with root package name */
    public LinkedList f18369o;

    /* renamed from: p, reason: collision with root package name */
    public LinkedList f18370p;

    /* renamed from: q, reason: collision with root package name */
    public LinkedList f18371q;

    /* renamed from: r, reason: collision with root package name */
    public LinkedList f18372r;

    /* renamed from: s, reason: collision with root package name */
    public HashSet f18373s;

    /* renamed from: t, reason: collision with root package name */
    public LinkedHashMap f18374t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f18375u;

    /* renamed from: v, reason: collision with root package name */
    public String f18376v = "set";

    public c0(m3.m mVar, boolean z10, k3.j jVar, c cVar, a aVar) {
        this.f18355a = mVar;
        this.f18357c = z10;
        this.f18358d = jVar;
        this.f18359e = cVar;
        if (mVar.C()) {
            this.f18362h = true;
            this.f18361g = mVar.g();
        } else {
            this.f18362h = false;
            this.f18361g = k3.b.t0();
        }
        this.f18360f = mVar.t(jVar.q(), cVar);
        this.f18356b = aVar;
        this.f18375u = mVar.D(k3.q.USE_STD_BEAN_NAMING);
    }

    public c A() {
        return this.f18359e;
    }

    public m3.m B() {
        return this.f18355a;
    }

    public Set C() {
        return this.f18373s;
    }

    public Map D() {
        if (!this.f18363i) {
            v();
        }
        return this.f18374t;
    }

    public i E() {
        if (!this.f18363i) {
            v();
        }
        LinkedList linkedList = this.f18371q;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            K("Multiple 'as-key' properties defined (%s vs %s)", this.f18371q.get(0), this.f18371q.get(1));
        }
        return (i) this.f18371q.get(0);
    }

    public i F() {
        if (!this.f18363i) {
            v();
        }
        LinkedList linkedList = this.f18372r;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            K("Multiple 'as-value' properties defined (%s vs %s)", this.f18372r.get(0), this.f18372r.get(1));
        }
        return (i) this.f18372r.get(0);
    }

    public b0 G() {
        b0 B = this.f18361g.B(this.f18359e);
        return B != null ? this.f18361g.C(this.f18359e, B) : B;
    }

    public List H() {
        return new ArrayList(I().values());
    }

    public Map I() {
        if (!this.f18363i) {
            v();
        }
        return this.f18364j;
    }

    public k3.j J() {
        return this.f18358d;
    }

    public void K(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new IllegalArgumentException("Problem with definition of " + this.f18359e + ": " + str);
    }

    public void a(Map map, m mVar) {
        h.a h10;
        String r10 = this.f18361g.r(mVar);
        if (r10 == null) {
            r10 = "";
        }
        k3.x x10 = this.f18361g.x(mVar);
        boolean z10 = (x10 == null || x10.h()) ? false : true;
        if (!z10) {
            if (r10.isEmpty() || (h10 = this.f18361g.h(this.f18355a, mVar.r())) == null || h10 == h.a.DISABLED) {
                return;
            } else {
                x10 = k3.x.a(r10);
            }
        }
        k3.x xVar = x10;
        String i10 = i(r10);
        d0 o10 = (z10 && i10.isEmpty()) ? o(map, xVar) : n(map, i10);
        o10.V(mVar, xVar, z10, true, false);
        this.f18365k.add(o10);
    }

    public void b(Map map) {
        if (this.f18362h) {
            Iterator it = this.f18359e.p().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e eVar = (e) it.next();
                if (this.f18365k == null) {
                    this.f18365k = new LinkedList();
                }
                int v10 = eVar.v();
                for (int i10 = 0; i10 < v10; i10++) {
                    a(map, eVar.t(i10));
                }
            }
            for (j jVar : this.f18359e.r()) {
                if (this.f18365k == null) {
                    this.f18365k = new LinkedList();
                }
                int v11 = jVar.v();
                for (int i11 = 0; i11 < v11; i11++) {
                    a(map, jVar.t(i11));
                }
            }
        }
    }

    public void c(Map map) {
        k3.x xVar;
        boolean z10;
        boolean z11;
        boolean z12;
        k3.b bVar = this.f18361g;
        boolean z13 = (this.f18357c || this.f18355a.D(k3.q.ALLOW_FINAL_FIELDS_AS_MUTATORS)) ? false : true;
        boolean D = this.f18355a.D(k3.q.PROPAGATE_TRANSIENT_MARKER);
        for (g gVar : this.f18359e.l()) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(bVar.k0(this.f18355a, gVar))) {
                if (this.f18371q == null) {
                    this.f18371q = new LinkedList();
                }
                this.f18371q.add(gVar);
            }
            if (bool.equals(bVar.l0(gVar))) {
                if (this.f18372r == null) {
                    this.f18372r = new LinkedList();
                }
                this.f18372r.add(gVar);
            } else {
                boolean equals = bool.equals(bVar.h0(gVar));
                boolean equals2 = bool.equals(bVar.j0(gVar));
                if (equals || equals2) {
                    if (equals) {
                        if (this.f18368n == null) {
                            this.f18368n = new LinkedList();
                        }
                        this.f18368n.add(gVar);
                    }
                    if (equals2) {
                        if (this.f18370p == null) {
                            this.f18370p = new LinkedList();
                        }
                        this.f18370p.add(gVar);
                    }
                } else {
                    String r10 = bVar.r(gVar);
                    if (r10 == null) {
                        r10 = gVar.d();
                    }
                    String d10 = this.f18356b.d(gVar, r10);
                    if (d10 != null) {
                        k3.x m10 = m(d10);
                        k3.x R = bVar.R(this.f18355a, gVar, m10);
                        if (R != null && !R.equals(m10)) {
                            if (this.f18366l == null) {
                                this.f18366l = new HashMap();
                            }
                            this.f18366l.put(R, m10);
                        }
                        k3.x y10 = this.f18357c ? bVar.y(gVar) : bVar.x(gVar);
                        boolean z14 = y10 != null;
                        if (z14 && y10.h()) {
                            xVar = m(d10);
                            z10 = false;
                        } else {
                            xVar = y10;
                            z10 = z14;
                        }
                        boolean z15 = xVar != null;
                        if (!z15) {
                            z15 = this.f18360f.e(gVar);
                        }
                        boolean o02 = bVar.o0(gVar);
                        if (!gVar.s() || z14) {
                            z11 = o02;
                            z12 = z15;
                        } else if (D) {
                            z12 = false;
                            z11 = true;
                        } else {
                            z11 = o02;
                            z12 = false;
                        }
                        if (!z13 || xVar != null || z11 || !Modifier.isFinal(gVar.r())) {
                            n(map, d10).W(gVar, xVar, z10, z12, z11);
                        }
                    }
                }
            }
        }
    }

    public void d(Map map, j jVar, k3.b bVar) {
        k3.x xVar;
        boolean z10;
        String str;
        boolean z11;
        boolean g10;
        Class D = jVar.D();
        if (D != Void.TYPE) {
            if (D != Void.class || this.f18355a.D(k3.q.ALLOW_VOID_VALUED_PROPERTIES)) {
                Boolean bool = Boolean.TRUE;
                if (bool.equals(bVar.h0(jVar))) {
                    if (this.f18367m == null) {
                        this.f18367m = new LinkedList();
                    }
                    this.f18367m.add(jVar);
                    return;
                }
                if (bool.equals(bVar.k0(this.f18355a, jVar))) {
                    if (this.f18371q == null) {
                        this.f18371q = new LinkedList();
                    }
                    this.f18371q.add(jVar);
                    return;
                }
                if (bool.equals(bVar.l0(jVar))) {
                    if (this.f18372r == null) {
                        this.f18372r = new LinkedList();
                    }
                    this.f18372r.add(jVar);
                    return;
                }
                k3.x y10 = bVar.y(jVar);
                boolean z12 = false;
                boolean z13 = y10 != null;
                if (z13) {
                    String r10 = bVar.r(jVar);
                    if (r10 == null && (r10 = this.f18356b.c(jVar, jVar.d())) == null) {
                        r10 = this.f18356b.a(jVar, jVar.d());
                    }
                    if (r10 == null) {
                        r10 = jVar.d();
                    }
                    if (y10.h()) {
                        y10 = m(r10);
                    } else {
                        z12 = z13;
                    }
                    xVar = y10;
                    z10 = z12;
                    str = r10;
                    z11 = true;
                } else {
                    str = bVar.r(jVar);
                    if (str == null) {
                        str = this.f18356b.c(jVar, jVar.d());
                    }
                    if (str == null) {
                        str = this.f18356b.a(jVar, jVar.d());
                        if (str == null) {
                            return;
                        } else {
                            g10 = this.f18360f.d(jVar);
                        }
                    } else {
                        g10 = this.f18360f.g(jVar);
                    }
                    xVar = y10;
                    z11 = g10;
                    z10 = z13;
                }
                n(map, i(str)).X(jVar, xVar, z10, z11, bVar.o0(jVar));
            }
        }
    }

    public void e(Map map) {
        for (i iVar : this.f18359e.l()) {
            k(this.f18361g.s(iVar), iVar);
        }
        for (j jVar : this.f18359e.u()) {
            if (jVar.v() == 1) {
                k(this.f18361g.s(jVar), jVar);
            }
        }
    }

    public void f(Map map) {
        for (j jVar : this.f18359e.u()) {
            int v10 = jVar.v();
            if (v10 == 0) {
                d(map, jVar, this.f18361g);
            } else if (v10 == 1) {
                g(map, jVar, this.f18361g);
            } else if (v10 == 2 && Boolean.TRUE.equals(this.f18361g.j0(jVar))) {
                if (this.f18369o == null) {
                    this.f18369o = new LinkedList();
                }
                this.f18369o.add(jVar);
            }
        }
    }

    public void g(Map map, j jVar, k3.b bVar) {
        k3.x xVar;
        boolean z10;
        String str;
        boolean z11;
        k3.x x10 = bVar.x(jVar);
        boolean z12 = false;
        boolean z13 = x10 != null;
        if (z13) {
            String r10 = bVar.r(jVar);
            if (r10 == null) {
                r10 = this.f18356b.b(jVar, jVar.d());
            }
            if (r10 == null) {
                r10 = jVar.d();
            }
            if (x10.h()) {
                x10 = m(r10);
            } else {
                z12 = z13;
            }
            xVar = x10;
            z10 = z12;
            str = r10;
            z11 = true;
        } else {
            str = bVar.r(jVar);
            if (str == null) {
                str = this.f18356b.b(jVar, jVar.d());
            }
            if (str == null) {
                return;
            }
            xVar = x10;
            z11 = this.f18360f.f(jVar);
            z10 = z13;
        }
        n(map, i(str)).Y(jVar, xVar, z10, z11, bVar.o0(jVar));
    }

    public final boolean h(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((d0) it.next()).getMetadata().f()) {
                return true;
            }
        }
        return false;
    }

    public final String i(String str) {
        k3.x xVar;
        Map map = this.f18366l;
        return (map == null || (xVar = (k3.x) map.get(m(str))) == null) ? str : xVar.c();
    }

    public void j(String str) {
        if (this.f18357c || str == null) {
            return;
        }
        if (this.f18373s == null) {
            this.f18373s = new HashSet();
        }
        this.f18373s.add(str);
    }

    public void k(b.a aVar, i iVar) {
        if (aVar == null) {
            return;
        }
        Object e10 = aVar.e();
        if (this.f18374t == null) {
            this.f18374t = new LinkedHashMap();
        }
        i iVar2 = (i) this.f18374t.put(e10, iVar);
        if (iVar2 == null || iVar2.getClass() != iVar.getClass()) {
            return;
        }
        throw new IllegalArgumentException("Duplicate injectable value with id '" + e10 + "' (of type " + e10.getClass().getName() + ")");
    }

    public final k3.y l() {
        Object z10 = this.f18361g.z(this.f18359e);
        if (z10 == null) {
            this.f18355a.x();
            return null;
        }
        if (!(z10 instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + z10.getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
        }
        Class cls = (Class) z10;
        if (cls == k3.y.class) {
            return null;
        }
        if (k3.y.class.isAssignableFrom(cls)) {
            this.f18355a.u();
            androidx.appcompat.app.m.a(d4.h.l(cls, this.f18355a.b()));
            return null;
        }
        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<PropertyNamingStrategy>");
    }

    public final k3.x m(String str) {
        return k3.x.b(str, null);
    }

    public d0 n(Map map, String str) {
        d0 d0Var = (d0) map.get(str);
        if (d0Var != null) {
            return d0Var;
        }
        d0 d0Var2 = new d0(this.f18355a, this.f18361g, this.f18357c, k3.x.a(str));
        map.put(str, d0Var2);
        return d0Var2;
    }

    public d0 o(Map map, k3.x xVar) {
        String c10 = xVar.c();
        d0 d0Var = (d0) map.get(c10);
        if (d0Var != null) {
            return d0Var;
        }
        d0 d0Var2 = new d0(this.f18355a, this.f18361g, this.f18357c, xVar);
        map.put(c10, d0Var2);
        return d0Var2;
    }

    public void p(Map map) {
        boolean D = this.f18355a.D(k3.q.INFER_PROPERTY_MUTATORS);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((d0) it.next()).n0(D, this.f18357c ? null : this);
        }
    }

    public void q(Map map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            d0 d0Var = (d0) it.next();
            if (!d0Var.a0()) {
                it.remove();
            } else if (d0Var.Z()) {
                if (d0Var.B()) {
                    d0Var.m0();
                    if (!d0Var.e()) {
                        j(d0Var.getName());
                    }
                } else {
                    it.remove();
                    j(d0Var.getName());
                }
            }
        }
    }

    public void r(Map map) {
        HashSet hashSet;
        Iterator it = map.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            d0 d0Var = (d0) ((Map.Entry) it.next()).getValue();
            Set e02 = d0Var.e0();
            if (!e02.isEmpty()) {
                it.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (e02.size() == 1) {
                    linkedList.add(d0Var.p0((k3.x) e02.iterator().next()));
                } else {
                    linkedList.addAll(d0Var.c0(e02));
                }
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                d0 d0Var2 = (d0) it2.next();
                String name = d0Var2.getName();
                d0 d0Var3 = (d0) map.get(name);
                if (d0Var3 == null) {
                    map.put(name, d0Var2);
                } else {
                    d0Var3.U(d0Var2);
                }
                if (t(d0Var2, this.f18365k) && (hashSet = this.f18373s) != null) {
                    hashSet.remove(name);
                }
            }
        }
    }

    public void s(Map map) {
        k3.x g02;
        Iterator it = map.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            d0 d0Var = (d0) ((Map.Entry) it.next()).getValue();
            i s10 = d0Var.s();
            if (s10 != null && (g02 = this.f18361g.g0(s10)) != null && g02.e() && !g02.equals(d0Var.c())) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(d0Var.p0(g02));
                it.remove();
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                d0 d0Var2 = (d0) it2.next();
                String name = d0Var2.getName();
                d0 d0Var3 = (d0) map.get(name);
                if (d0Var3 == null) {
                    map.put(name, d0Var2);
                } else {
                    d0Var3.U(d0Var2);
                }
            }
        }
    }

    public boolean t(d0 d0Var, List list) {
        if (list != null) {
            String h02 = d0Var.h0();
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((d0) list.get(i10)).h0().equals(h02)) {
                    list.set(i10, d0Var);
                    return true;
                }
            }
        }
        return false;
    }

    public void u(Map map) {
        Collection<d0> collection;
        k3.b bVar = this.f18361g;
        Boolean W = bVar.W(this.f18359e);
        boolean E = W == null ? this.f18355a.E() : W.booleanValue();
        boolean h10 = h(map.values());
        String[] V = bVar.V(this.f18359e);
        if (E || h10 || this.f18365k != null || V != null) {
            int size = map.size();
            Map treeMap = E ? new TreeMap() : new LinkedHashMap(size + size);
            for (d0 d0Var : map.values()) {
                treeMap.put(d0Var.getName(), d0Var);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(size + size);
            if (V != null) {
                for (String str : V) {
                    d0 d0Var2 = (d0) treeMap.remove(str);
                    if (d0Var2 == null) {
                        Iterator it = map.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            d0 d0Var3 = (d0) it.next();
                            if (str.equals(d0Var3.h0())) {
                                str = d0Var3.getName();
                                d0Var2 = d0Var3;
                                break;
                            }
                        }
                    }
                    if (d0Var2 != null) {
                        linkedHashMap.put(str, d0Var2);
                    }
                }
            }
            if (h10) {
                TreeMap treeMap2 = new TreeMap();
                Iterator it2 = treeMap.entrySet().iterator();
                while (it2.hasNext()) {
                    d0 d0Var4 = (d0) ((Map.Entry) it2.next()).getValue();
                    Integer c10 = d0Var4.getMetadata().c();
                    if (c10 != null) {
                        treeMap2.put(c10, d0Var4);
                        it2.remove();
                    }
                }
                for (d0 d0Var5 : treeMap2.values()) {
                    linkedHashMap.put(d0Var5.getName(), d0Var5);
                }
            }
            if (this.f18365k != null && (!E || this.f18355a.D(k3.q.SORT_CREATOR_PROPERTIES_FIRST))) {
                if (E) {
                    TreeMap treeMap3 = new TreeMap();
                    Iterator it3 = this.f18365k.iterator();
                    while (it3.hasNext()) {
                        d0 d0Var6 = (d0) it3.next();
                        treeMap3.put(d0Var6.getName(), d0Var6);
                    }
                    collection = treeMap3.values();
                } else {
                    collection = this.f18365k;
                }
                for (d0 d0Var7 : collection) {
                    String name = d0Var7.getName();
                    if (treeMap.containsKey(name)) {
                        linkedHashMap.put(name, d0Var7);
                    }
                }
            }
            linkedHashMap.putAll(treeMap);
            map.clear();
            map.putAll(linkedHashMap);
        }
    }

    public void v() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c(linkedHashMap);
        f(linkedHashMap);
        if (!this.f18359e.t()) {
            b(linkedHashMap);
        }
        q(linkedHashMap);
        p(linkedHashMap);
        r(linkedHashMap);
        e(linkedHashMap);
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((d0) it.next()).k0(this.f18357c);
        }
        Iterator it2 = linkedHashMap.values().iterator();
        while (it2.hasNext()) {
            ((d0) it2.next()).o0();
        }
        l();
        if (this.f18355a.D(k3.q.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            s(linkedHashMap);
        }
        u(linkedHashMap);
        this.f18364j = linkedHashMap;
        this.f18363i = true;
    }

    public i w() {
        if (!this.f18363i) {
            v();
        }
        LinkedList linkedList = this.f18368n;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            K("Multiple 'any-getter' fields defined (%s vs %s)", this.f18368n.get(0), this.f18368n.get(1));
        }
        return (i) this.f18368n.getFirst();
    }

    public i x() {
        if (!this.f18363i) {
            v();
        }
        LinkedList linkedList = this.f18367m;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            K("Multiple 'any-getter' methods defined (%s vs %s)", this.f18367m.get(0), this.f18367m.get(1));
        }
        return (i) this.f18367m.getFirst();
    }

    public i y() {
        if (!this.f18363i) {
            v();
        }
        LinkedList linkedList = this.f18370p;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            K("Multiple 'any-setter' fields defined (%s vs %s)", this.f18370p.get(0), this.f18370p.get(1));
        }
        return (i) this.f18370p.getFirst();
    }

    public j z() {
        if (!this.f18363i) {
            v();
        }
        LinkedList linkedList = this.f18369o;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            K("Multiple 'any-setter' methods defined (%s vs %s)", this.f18369o.get(0), this.f18369o.get(1));
        }
        return (j) this.f18369o.getFirst();
    }
}
