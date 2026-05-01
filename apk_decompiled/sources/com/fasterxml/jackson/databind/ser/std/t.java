package com.fasterxml.jackson.databind.ser.std;

import b3.r;
import b4.k;
import d4.m;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class t extends a4.h implements a4.i {

    /* renamed from: p, reason: collision with root package name */
    public static final k3.j f6712p = c4.o.O();

    /* renamed from: q, reason: collision with root package name */
    public static final Object f6713q = r.a.NON_EMPTY;

    /* renamed from: a, reason: collision with root package name */
    public final k3.d f6714a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6715b;

    /* renamed from: c, reason: collision with root package name */
    public final k3.j f6716c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.j f6717d;

    /* renamed from: e, reason: collision with root package name */
    public k3.o f6718e;

    /* renamed from: f, reason: collision with root package name */
    public k3.o f6719f;

    /* renamed from: g, reason: collision with root package name */
    public final w3.h f6720g;

    /* renamed from: h, reason: collision with root package name */
    public b4.k f6721h;

    /* renamed from: i, reason: collision with root package name */
    public final Set f6722i;

    /* renamed from: j, reason: collision with root package name */
    public final Set f6723j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f6724k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f6725l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f6726m;

    /* renamed from: n, reason: collision with root package name */
    public final m.a f6727n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f6728o;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6729a;

        static {
            int[] iArr = new int[r.a.values().length];
            f6729a = iArr;
            try {
                iArr[r.a.NON_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6729a[r.a.NON_ABSENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6729a[r.a.NON_EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6729a[r.a.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6729a[r.a.NON_NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6729a[r.a.ALWAYS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public t(Set set, Set set2, k3.j jVar, k3.j jVar2, boolean z10, w3.h hVar, k3.o oVar, k3.o oVar2) {
        super(Map.class, false);
        set = (set == null || set.isEmpty()) ? null : set;
        this.f6722i = set;
        this.f6723j = set2;
        this.f6716c = jVar;
        this.f6717d = jVar2;
        this.f6715b = z10;
        this.f6720g = hVar;
        this.f6718e = oVar;
        this.f6719f = oVar2;
        this.f6721h = b4.k.c();
        this.f6714a = null;
        this.f6724k = null;
        this.f6728o = false;
        this.f6725l = null;
        this.f6726m = false;
        this.f6727n = d4.m.a(set, set2);
    }

    public static t m(Set set, Set set2, k3.j jVar, boolean z10, w3.h hVar, k3.o oVar, k3.o oVar2, Object obj) {
        k3.j O;
        k3.j jVar2;
        boolean z11;
        if (jVar == null) {
            jVar2 = f6712p;
            O = jVar2;
        } else {
            k3.j p10 = jVar.p();
            O = jVar.y(Properties.class) ? c4.o.O() : jVar.k();
            jVar2 = p10;
        }
        boolean z12 = false;
        if (z10) {
            z11 = O.q() == Object.class ? false : z10;
        } else {
            if (O != null && O.G()) {
                z12 = true;
            }
            z11 = z12;
        }
        t tVar = new t(set, set2, jVar2, O, z11, hVar, oVar, oVar2);
        return obj != null ? tVar.withFilterId(obj) : tVar;
    }

    public static t n(Set set, k3.j jVar, boolean z10, w3.h hVar, k3.o oVar, k3.o oVar2, Object obj) {
        return m(set, null, jVar, z10, hVar, oVar, oVar2, obj);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        fVar.i(jVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0124, code lost:
    
        if (r0 != 5) goto L94;
     */
    @Override // a4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k3.o b(k3.c0 r14, k3.d r15) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.t.b(k3.c0, k3.d):k3.o");
    }

    public void e(String str) {
        d4.h.n0(t.class, this, str);
    }

    public final k3.o f(b4.k kVar, Class cls, k3.c0 c0Var) {
        k.d g10 = kVar.g(cls, c0Var, this.f6714a);
        b4.k kVar2 = g10.f4620b;
        if (kVar != kVar2) {
            this.f6721h = kVar2;
        }
        return g10.f4619a;
    }

    public final k3.o g(b4.k kVar, k3.j jVar, k3.c0 c0Var) {
        k.d h10 = kVar.h(jVar, c0Var, this.f6714a);
        b4.k kVar2 = h10.f4620b;
        if (kVar != kVar2) {
            this.f6721h = kVar2;
        }
        return h10.f4619a;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        return createSchemaNode("object", true);
    }

    public final k3.o h(k3.c0 c0Var, Object obj) {
        Class<?> cls = obj.getClass();
        k3.o j10 = this.f6721h.j(cls);
        return j10 != null ? j10 : this.f6717d.w() ? g(this.f6721h, c0Var.A(this.f6717d, cls), c0Var) : f(this.f6721h, cls, c0Var);
    }

    public boolean i(Map map) {
        return (map instanceof HashMap) && map.containsKey(null);
    }

    public Map j(Map map, c3.h hVar, k3.c0 c0Var) {
        if (map instanceof SortedMap) {
            return map;
        }
        if (!i(map)) {
            return new TreeMap(map);
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                l(hVar, c0Var, entry.getValue());
            } else {
                treeMap.put(key, entry.getValue());
            }
        }
        return treeMap;
    }

    @Override // a4.h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public t c(w3.h hVar) {
        if (this.f6720g == hVar) {
            return this;
        }
        e("_withValueTypeSerializer");
        return new t(this, hVar, this.f6725l, this.f6726m);
    }

    public void l(c3.h hVar, k3.c0 c0Var, Object obj) {
        k3.o oVar;
        k3.o K = c0Var.K(this.f6716c, this.f6714a);
        if (obj != null) {
            oVar = this.f6719f;
            if (oVar == null) {
                oVar = h(c0Var, obj);
            }
            Object obj2 = this.f6725l;
            if (obj2 == f6713q) {
                if (oVar.isEmpty(c0Var, obj)) {
                    return;
                }
            } else if (obj2 != null && obj2.equals(obj)) {
                return;
            }
        } else if (this.f6726m) {
            return;
        } else {
            oVar = c0Var.Z();
        }
        try {
            K.serialize(null, hVar, c0Var);
            oVar.serialize(obj, hVar, c0Var);
        } catch (Exception e10) {
            wrapAndThrow(c0Var, e10, obj, "");
        }
    }

    public k3.j o() {
        return this.f6717d;
    }

    @Override // k3.o
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean isEmpty(k3.c0 c0Var, Map map) {
        k3.o h10;
        if (map.isEmpty()) {
            return true;
        }
        Object obj = this.f6725l;
        if (obj == null && !this.f6726m) {
            return false;
        }
        k3.o oVar = this.f6719f;
        boolean z10 = f6713q == obj;
        if (oVar != null) {
            for (Object obj2 : map.values()) {
                if (obj2 == null) {
                    if (!this.f6726m) {
                        return false;
                    }
                } else if (z10) {
                    if (!oVar.isEmpty(c0Var, obj2)) {
                        return false;
                    }
                } else if (obj == null || !obj.equals(map)) {
                    return false;
                }
            }
            return true;
        }
        for (Object obj3 : map.values()) {
            if (obj3 != null) {
                try {
                    h10 = h(c0Var, obj3);
                } catch (k3.l unused) {
                }
                if (!z10) {
                    if (obj != null && obj.equals(map)) {
                    }
                    return false;
                }
                if (!h10.isEmpty(c0Var, obj3)) {
                    return false;
                }
            } else if (!this.f6726m) {
                return false;
            }
        }
        return true;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void serialize(Map map, c3.h hVar, k3.c0 c0Var) {
        hVar.w0(map);
        w(map, hVar, c0Var);
        hVar.W();
    }

    public void r(Map map, c3.h hVar, k3.c0 c0Var) {
        Object obj = null;
        if (this.f6720g != null) {
            u(map, hVar, c0Var, null);
            return;
        }
        k3.o oVar = this.f6718e;
        try {
            Object obj2 = null;
            for (Map.Entry entry : map.entrySet()) {
                try {
                    Object value = entry.getValue();
                    obj2 = entry.getKey();
                    if (obj2 == null) {
                        c0Var.K(this.f6716c, this.f6714a).serialize(null, hVar, c0Var);
                    } else {
                        m.a aVar = this.f6727n;
                        if (aVar == null || !aVar.b(obj2)) {
                            oVar.serialize(obj2, hVar, c0Var);
                        }
                    }
                    if (value == null) {
                        c0Var.E(hVar);
                    } else {
                        k3.o oVar2 = this.f6719f;
                        if (oVar2 == null) {
                            oVar2 = h(c0Var, value);
                        }
                        oVar2.serialize(value, hVar, c0Var);
                    }
                } catch (Exception e10) {
                    e = e10;
                    obj = obj2;
                    wrapAndThrow(c0Var, e, map, String.valueOf(obj));
                    return;
                }
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public void s(Map map, c3.h hVar, k3.c0 c0Var, k3.o oVar) {
        k3.o oVar2 = this.f6718e;
        w3.h hVar2 = this.f6720g;
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            m.a aVar = this.f6727n;
            if (aVar == null || !aVar.b(key)) {
                if (key == null) {
                    c0Var.K(this.f6716c, this.f6714a).serialize(null, hVar, c0Var);
                } else {
                    oVar2.serialize(key, hVar, c0Var);
                }
                Object value = entry.getValue();
                if (value == null) {
                    c0Var.E(hVar);
                } else if (hVar2 == null) {
                    try {
                        oVar.serialize(value, hVar, c0Var);
                    } catch (Exception e10) {
                        wrapAndThrow(c0Var, e10, map, String.valueOf(key));
                    }
                } else {
                    oVar.serializeWithType(value, hVar, c0Var, hVar2);
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:12|(2:52|53)(2:14|(1:19)(2:50|32))|20|(3:44|45|(2:49|32)(2:47|48))(4:22|23|(1:25)|(3:40|41|(2:43|32))(2:27|(2:31|32)))|33|34|36|32|10) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0070, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0071, code lost:
    
        wrapAndThrow(r10, r2, r8, java.lang.String.valueOf(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t(java.util.Map r8, c3.h r9, k3.c0 r10, java.lang.Object r11) {
        /*
            r7 = this;
            w3.h r0 = r7.f6720g
            if (r0 == 0) goto L8
            r7.u(r8, r9, r10, r11)
            return
        L8:
            java.lang.Object r0 = com.fasterxml.jackson.databind.ser.std.t.f6713q
            if (r0 != r11) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            java.util.Set r1 = r8.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L17:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L79
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            if (r3 != 0) goto L32
            k3.j r4 = r7.f6716c
            k3.d r5 = r7.f6714a
            k3.o r4 = r10.K(r4, r5)
            goto L3f
        L32:
            d4.m$a r4 = r7.f6727n
            if (r4 == 0) goto L3d
            boolean r4 = r4.b(r3)
            if (r4 == 0) goto L3d
            goto L17
        L3d:
            k3.o r4 = r7.f6718e
        L3f:
            java.lang.Object r2 = r2.getValue()
            if (r2 != 0) goto L4f
            boolean r5 = r7.f6726m
            if (r5 == 0) goto L4a
            goto L17
        L4a:
            k3.o r5 = r10.Z()
            goto L69
        L4f:
            k3.o r5 = r7.f6719f
            if (r5 != 0) goto L57
            k3.o r5 = r7.h(r10, r2)
        L57:
            if (r0 == 0) goto L60
            boolean r6 = r5.isEmpty(r10, r2)
            if (r6 == 0) goto L69
            goto L17
        L60:
            if (r11 == 0) goto L69
            boolean r6 = r11.equals(r2)
            if (r6 == 0) goto L69
            goto L17
        L69:
            r4.serialize(r3, r9, r10)     // Catch: java.lang.Exception -> L70
            r5.serialize(r2, r9, r10)     // Catch: java.lang.Exception -> L70
            goto L17
        L70:
            r2 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r7.wrapAndThrow(r10, r2, r8, r3)
            goto L17
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.t.t(java.util.Map, c3.h, k3.c0, java.lang.Object):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:7|(2:51|52)(2:9|(1:14)(2:49|32))|15|(3:43|44|(2:48|32)(2:46|47))(4:17|18|(1:20)|(3:38|39|(2:42|32)(1:41))(2:22|(2:36|32)))|27|28|29|31|32|5) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006a, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        wrapAndThrow(r10, r2, r8, java.lang.String.valueOf(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(java.util.Map r8, c3.h r9, k3.c0 r10, java.lang.Object r11) {
        /*
            r7 = this;
            java.lang.Object r0 = com.fasterxml.jackson.databind.ser.std.t.f6713q
            if (r0 != r11) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            java.util.Set r1 = r8.entrySet()
            java.util.Iterator r1 = r1.iterator()
        Lf:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L73
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            if (r3 != 0) goto L2a
            k3.j r4 = r7.f6716c
            k3.d r5 = r7.f6714a
            k3.o r4 = r10.K(r4, r5)
            goto L37
        L2a:
            d4.m$a r4 = r7.f6727n
            if (r4 == 0) goto L35
            boolean r4 = r4.b(r3)
            if (r4 == 0) goto L35
            goto Lf
        L35:
            k3.o r4 = r7.f6718e
        L37:
            java.lang.Object r2 = r2.getValue()
            if (r2 != 0) goto L47
            boolean r5 = r7.f6726m
            if (r5 == 0) goto L42
            goto Lf
        L42:
            k3.o r5 = r10.Z()
            goto L61
        L47:
            k3.o r5 = r7.f6719f
            if (r5 != 0) goto L4f
            k3.o r5 = r7.h(r10, r2)
        L4f:
            if (r0 == 0) goto L58
            boolean r6 = r5.isEmpty(r10, r2)
            if (r6 == 0) goto L61
            goto Lf
        L58:
            if (r11 == 0) goto L61
            boolean r6 = r11.equals(r2)
            if (r6 == 0) goto L61
            goto Lf
        L61:
            r4.serialize(r3, r9, r10)
            w3.h r4 = r7.f6720g     // Catch: java.lang.Exception -> L6a
            r5.serializeWithType(r2, r9, r10, r4)     // Catch: java.lang.Exception -> L6a
            goto Lf
        L6a:
            r2 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r7.wrapAndThrow(r10, r2, r8, r3)
            goto Lf
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.t.u(java.util.Map, c3.h, k3.c0, java.lang.Object):void");
    }

    @Override // k3.o
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void serializeWithType(Map map, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        hVar.z(map);
        i3.b g10 = hVar2.g(hVar, hVar2.d(map, c3.n.START_OBJECT));
        w(map, hVar, c0Var);
        hVar2.h(hVar, g10);
    }

    public void w(Map map, c3.h hVar, k3.c0 c0Var) {
        if (map.isEmpty()) {
            return;
        }
        if (this.f6728o || c0Var.m0(k3.b0.ORDER_MAP_ENTRIES_BY_KEYS)) {
            map = j(map, hVar, c0Var);
        }
        Object obj = this.f6724k;
        if (obj != null) {
            findPropertyFilter(c0Var, obj, map);
        }
        Object obj2 = this.f6725l;
        if (obj2 != null || this.f6726m) {
            t(map, hVar, c0Var, obj2);
            return;
        }
        k3.o oVar = this.f6719f;
        if (oVar != null) {
            s(map, hVar, c0Var, oVar);
        } else {
            r(map, hVar, c0Var);
        }
    }

    public t x(Object obj, boolean z10) {
        if (obj == this.f6725l && z10 == this.f6726m) {
            return this;
        }
        e("withContentInclusion");
        return new t(this, this.f6720g, obj, z10);
    }

    @Override // k3.o
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public t withFilterId(Object obj) {
        if (this.f6724k == obj) {
            return this;
        }
        e("withFilterId");
        return new t(this, obj, this.f6728o);
    }

    public t z(k3.d dVar, k3.o oVar, k3.o oVar2, Set set, Set set2, boolean z10) {
        e("withResolved");
        t tVar = new t(this, dVar, oVar, oVar2, set, set2);
        return z10 != tVar.f6728o ? new t(tVar, this.f6724k, z10) : tVar;
    }

    public t(t tVar, k3.d dVar, k3.o oVar, k3.o oVar2, Set set, Set set2) {
        super(Map.class, false);
        set = (set == null || set.isEmpty()) ? null : set;
        this.f6722i = set;
        this.f6723j = set2;
        this.f6716c = tVar.f6716c;
        this.f6717d = tVar.f6717d;
        this.f6715b = tVar.f6715b;
        this.f6720g = tVar.f6720g;
        this.f6718e = oVar;
        this.f6719f = oVar2;
        this.f6721h = b4.k.c();
        this.f6714a = dVar;
        this.f6724k = tVar.f6724k;
        this.f6728o = tVar.f6728o;
        this.f6725l = tVar.f6725l;
        this.f6726m = tVar.f6726m;
        this.f6727n = d4.m.a(set, set2);
    }

    public t(t tVar, w3.h hVar, Object obj, boolean z10) {
        super(Map.class, false);
        this.f6722i = tVar.f6722i;
        this.f6723j = tVar.f6723j;
        this.f6716c = tVar.f6716c;
        this.f6717d = tVar.f6717d;
        this.f6715b = tVar.f6715b;
        this.f6720g = hVar;
        this.f6718e = tVar.f6718e;
        this.f6719f = tVar.f6719f;
        this.f6721h = tVar.f6721h;
        this.f6714a = tVar.f6714a;
        this.f6724k = tVar.f6724k;
        this.f6728o = tVar.f6728o;
        this.f6725l = obj;
        this.f6726m = z10;
        this.f6727n = tVar.f6727n;
    }

    public t(t tVar, Object obj, boolean z10) {
        super(Map.class, false);
        this.f6722i = tVar.f6722i;
        this.f6723j = tVar.f6723j;
        this.f6716c = tVar.f6716c;
        this.f6717d = tVar.f6717d;
        this.f6715b = tVar.f6715b;
        this.f6720g = tVar.f6720g;
        this.f6718e = tVar.f6718e;
        this.f6719f = tVar.f6719f;
        this.f6721h = b4.k.c();
        this.f6714a = tVar.f6714a;
        this.f6724k = obj;
        this.f6728o = z10;
        this.f6725l = tVar.f6725l;
        this.f6726m = tVar.f6726m;
        this.f6727n = tVar.f6727n;
    }
}
