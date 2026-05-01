package com.fasterxml.jackson.databind.deser.std;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class m0 extends b0 implements n3.r, n3.i {
    protected static final Object[] NO_OBJECTS = new Object[0];
    private static final long serialVersionUID = 1;
    protected k3.k _listDeserializer;
    protected k3.j _listType;
    protected k3.k _mapDeserializer;
    protected k3.j _mapType;
    protected final boolean _nonMerging;
    protected k3.k _numberDeserializer;
    protected k3.k _stringDeserializer;

    public static class a extends b0 {

        /* renamed from: b, reason: collision with root package name */
        public static final a f6579b = new a();

        /* renamed from: a, reason: collision with root package name */
        public final boolean f6580a;

        public a() {
            this(false);
        }

        public static a c(boolean z10) {
            return z10 ? new a(true) : f6579b;
        }

        public Object _mapObjectWithDups(c3.k kVar, k3.g gVar, Map map, String str, Object obj, Object obj2, String str2) {
            boolean m02 = gVar.m0(c3.r.DUPLICATE_PROPERTIES);
            if (m02) {
                a(map, str, obj, obj2);
            }
            while (str2 != null) {
                kVar.s0();
                Object deserialize = deserialize(kVar, gVar);
                Object put = map.put(str2, deserialize);
                if (put != null && m02) {
                    a(map, str2, put, deserialize);
                }
                str2 = kVar.q0();
            }
            return map;
        }

        public final void a(Map map, String str, Object obj, Object obj2) {
            if (obj instanceof List) {
                ((List) obj).add(obj2);
                map.put(str, obj);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(obj);
                arrayList.add(obj2);
                map.put(str, arrayList);
            }
        }

        public final Object b(c3.k kVar, k3.g gVar, int i10) {
            switch (kVar.q()) {
                case 1:
                    if (kVar.s0() == c3.n.END_OBJECT) {
                        return new LinkedHashMap(2);
                    }
                    break;
                case 2:
                    return new LinkedHashMap(2);
                case 3:
                    if (kVar.s0() == c3.n.END_ARRAY) {
                        return gVar.n0(k3.h.USE_JAVA_ARRAY_FOR_JSON_ARRAY) ? m0.NO_OBJECTS : new ArrayList(2);
                    }
                    if (i10 <= 1000) {
                        return gVar.n0(k3.h.USE_JAVA_ARRAY_FOR_JSON_ARRAY) ? e(kVar, gVar, i10) : d(kVar, gVar, i10);
                    }
                    throw new c3.j(kVar, "JSON is too deeply nested.");
                case 4:
                default:
                    return gVar.a0(Object.class, kVar);
                case 5:
                    break;
                case 6:
                    return kVar.Y();
                case 7:
                    return gVar.k0(b0.F_MASK_INT_COERCIONS) ? _coerceIntegral(kVar, gVar) : kVar.S();
                case 8:
                    return gVar.n0(k3.h.USE_BIG_DECIMAL_FOR_FLOATS) ? kVar.L() : kVar.S();
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return kVar.N();
            }
            if (i10 <= 1000) {
                return f(kVar, gVar, i10);
            }
            throw new c3.j(kVar, "JSON is too deeply nested.");
        }

        public Object d(c3.k kVar, k3.g gVar, int i10) {
            int i11 = i10 + 1;
            Object b10 = b(kVar, gVar, i11);
            c3.n s02 = kVar.s0();
            c3.n nVar = c3.n.END_ARRAY;
            int i12 = 2;
            if (s02 == nVar) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(b10);
                return arrayList;
            }
            Object b11 = b(kVar, gVar, i11);
            if (kVar.s0() == nVar) {
                ArrayList arrayList2 = new ArrayList(2);
                arrayList2.add(b10);
                arrayList2.add(b11);
                return arrayList2;
            }
            d4.s q02 = gVar.q0();
            Object[] i13 = q02.i();
            i13[0] = b10;
            i13[1] = b11;
            int i14 = 2;
            while (true) {
                Object b12 = b(kVar, gVar, i11);
                i12++;
                if (i14 >= i13.length) {
                    i13 = q02.c(i13);
                    i14 = 0;
                }
                int i15 = i14 + 1;
                i13[i14] = b12;
                if (kVar.s0() == c3.n.END_ARRAY) {
                    ArrayList arrayList3 = new ArrayList(i12);
                    q02.e(i13, i15, arrayList3);
                    return arrayList3;
                }
                i14 = i15;
            }
        }

        @Override // k3.k
        public Object deserialize(c3.k kVar, k3.g gVar) {
            return b(kVar, gVar, 0);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
        public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
            int q10 = kVar.q();
            if (q10 != 1 && q10 != 3) {
                switch (q10) {
                    case 5:
                        break;
                    case 6:
                        return kVar.Y();
                    case 7:
                        return gVar.n0(k3.h.USE_BIG_INTEGER_FOR_INTS) ? kVar.s() : kVar.S();
                    case 8:
                        return gVar.n0(k3.h.USE_BIG_DECIMAL_FOR_FLOATS) ? kVar.L() : kVar.S();
                    case 9:
                        return Boolean.TRUE;
                    case 10:
                        return Boolean.FALSE;
                    case 11:
                        return null;
                    case 12:
                        return kVar.N();
                    default:
                        return gVar.a0(Object.class, kVar);
                }
            }
            return eVar.c(kVar, gVar);
        }

        public Object[] e(c3.k kVar, k3.g gVar, int i10) {
            int i11 = i10 + 1;
            d4.s q02 = gVar.q0();
            Object[] i12 = q02.i();
            int i13 = 0;
            while (true) {
                Object b10 = b(kVar, gVar, i11);
                if (i13 >= i12.length) {
                    i12 = q02.c(i12);
                    i13 = 0;
                }
                int i14 = i13 + 1;
                i12[i13] = b10;
                if (kVar.s0() == c3.n.END_ARRAY) {
                    return q02.f(i12, i14);
                }
                i13 = i14;
            }
        }

        public Object f(c3.k kVar, k3.g gVar, int i10) {
            int i11 = i10 + 1;
            String Y = kVar.Y();
            kVar.s0();
            Object b10 = b(kVar, gVar, i11);
            String q02 = kVar.q0();
            if (q02 == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(2);
                linkedHashMap.put(Y, b10);
                return linkedHashMap;
            }
            kVar.s0();
            Object b11 = b(kVar, gVar, i11);
            String q03 = kVar.q0();
            if (q03 == null) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(4);
                linkedHashMap2.put(Y, b10);
                return linkedHashMap2.put(q02, b11) != null ? _mapObjectWithDups(kVar, gVar, linkedHashMap2, Y, b10, b11, q03) : linkedHashMap2;
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put(Y, b10);
            if (linkedHashMap3.put(q02, b11) != null) {
                return _mapObjectWithDups(kVar, gVar, linkedHashMap3, Y, b10, b11, q03);
            }
            String str = q03;
            do {
                kVar.s0();
                Object b12 = b(kVar, gVar, i11);
                Object put = linkedHashMap3.put(str, b12);
                if (put != null) {
                    return _mapObjectWithDups(kVar, gVar, linkedHashMap3, str, put, b12, kVar.q0());
                }
                str = kVar.q0();
            } while (str != null);
            return linkedHashMap3;
        }

        @Override // k3.k
        public c4.f logicalType() {
            return c4.f.Untyped;
        }

        @Override // k3.k
        public Boolean supportsUpdate(k3.f fVar) {
            if (this.f6580a) {
                return Boolean.FALSE;
            }
            return null;
        }

        public a(boolean z10) {
            super(Object.class);
            this.f6580a = z10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:
        
            if (r0 != 5) goto L41;
         */
        @Override // k3.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object deserialize(c3.k kVar, k3.g gVar, Object obj) {
            if (this.f6580a) {
                return deserialize(kVar, gVar);
            }
            int q10 = kVar.q();
            if (q10 != 1) {
                if (q10 != 2) {
                    if (q10 == 3) {
                        if (kVar.s0() == c3.n.END_ARRAY) {
                            return obj;
                        }
                        if (obj instanceof Collection) {
                            Collection collection = (Collection) obj;
                            do {
                                collection.add(deserialize(kVar, gVar));
                            } while (kVar.s0() != c3.n.END_ARRAY);
                        }
                        return deserialize(kVar, gVar);
                    }
                    if (q10 != 4) {
                    }
                }
                return obj;
            }
            if (kVar.s0() == c3.n.END_OBJECT) {
                return obj;
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                String m10 = kVar.m();
                do {
                    kVar.s0();
                    Object obj2 = map.get(m10);
                    Object deserialize = obj2 != null ? deserialize(kVar, gVar, obj2) : deserialize(kVar, gVar);
                    if (deserialize != obj2) {
                        map.put(m10, deserialize);
                    }
                    m10 = kVar.q0();
                } while (m10 != null);
                return obj;
            }
            return deserialize(kVar, gVar);
        }
    }

    public m0(k3.j jVar, k3.j jVar2) {
        super(Object.class);
        this._listType = jVar;
        this._mapType = jVar2;
        this._nonMerging = false;
    }

    public k3.k _clearIfStdImpl(k3.k kVar) {
        if (d4.h.O(kVar)) {
            return null;
        }
        return kVar;
    }

    public k3.k _findCustomDeser(k3.g gVar, k3.j jVar) {
        return gVar.G(jVar);
    }

    public Object _mapObjectWithDups(c3.k kVar, k3.g gVar, Map<String, Object> map, String str, Object obj, Object obj2, String str2) {
        boolean m02 = gVar.m0(c3.r.DUPLICATE_PROPERTIES);
        if (m02) {
            a(map, str, obj, obj2);
        }
        while (str2 != null) {
            kVar.s0();
            Object deserialize = deserialize(kVar, gVar);
            Object put = map.put(str2, deserialize);
            if (put != null && m02) {
                a(map, str, put, deserialize);
            }
            str2 = kVar.q0();
        }
        return map;
    }

    public final void a(Map map, String str, Object obj, Object obj2) {
        if (obj instanceof List) {
            ((List) obj).add(obj2);
            map.put(str, obj);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(obj);
            arrayList.add(obj2);
            map.put(str, arrayList);
        }
    }

    @Override // n3.i
    public k3.k createContextual(k3.g gVar, k3.d dVar) {
        boolean z10 = dVar == null && Boolean.FALSE.equals(gVar.k().M(Object.class));
        return (this._stringDeserializer == null && this._numberDeserializer == null && this._mapDeserializer == null && this._listDeserializer == null && getClass() == m0.class) ? a.c(z10) : z10 != this._nonMerging ? new m0(this, z10) : this;
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar) {
        switch (kVar.q()) {
            case 1:
            case 2:
            case 5:
                k3.k kVar2 = this._mapDeserializer;
                return kVar2 != null ? kVar2.deserialize(kVar, gVar) : mapObject(kVar, gVar);
            case 3:
                if (gVar.n0(k3.h.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                    return mapArrayToArray(kVar, gVar);
                }
                k3.k kVar3 = this._listDeserializer;
                return kVar3 != null ? kVar3.deserialize(kVar, gVar) : mapArray(kVar, gVar);
            case 4:
            default:
                return gVar.a0(Object.class, kVar);
            case 6:
                k3.k kVar4 = this._stringDeserializer;
                return kVar4 != null ? kVar4.deserialize(kVar, gVar) : kVar.Y();
            case 7:
                k3.k kVar5 = this._numberDeserializer;
                return kVar5 != null ? kVar5.deserialize(kVar, gVar) : gVar.k0(b0.F_MASK_INT_COERCIONS) ? _coerceIntegral(kVar, gVar) : kVar.S();
            case 8:
                k3.k kVar6 = this._numberDeserializer;
                return kVar6 != null ? kVar6.deserialize(kVar, gVar) : gVar.n0(k3.h.USE_BIG_DECIMAL_FOR_FLOATS) ? kVar.L() : kVar.S();
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return kVar.N();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        int q10 = kVar.q();
        if (q10 != 1 && q10 != 3) {
            switch (q10) {
                case 5:
                    break;
                case 6:
                    k3.k kVar2 = this._stringDeserializer;
                    return kVar2 != null ? kVar2.deserialize(kVar, gVar) : kVar.Y();
                case 7:
                    k3.k kVar3 = this._numberDeserializer;
                    return kVar3 != null ? kVar3.deserialize(kVar, gVar) : gVar.k0(b0.F_MASK_INT_COERCIONS) ? _coerceIntegral(kVar, gVar) : kVar.S();
                case 8:
                    k3.k kVar4 = this._numberDeserializer;
                    return kVar4 != null ? kVar4.deserialize(kVar, gVar) : gVar.n0(k3.h.USE_BIG_DECIMAL_FOR_FLOATS) ? kVar.L() : kVar.S();
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return kVar.N();
                default:
                    return gVar.a0(Object.class, kVar);
            }
        }
        return eVar.c(kVar, gVar);
    }

    @Override // k3.k
    public boolean isCachable() {
        return true;
    }

    @Override // k3.k
    public c4.f logicalType() {
        return c4.f.Untyped;
    }

    public Object mapArray(c3.k kVar, k3.g gVar) {
        c3.n s02 = kVar.s0();
        c3.n nVar = c3.n.END_ARRAY;
        int i10 = 2;
        if (s02 == nVar) {
            return new ArrayList(2);
        }
        Object deserialize = deserialize(kVar, gVar);
        if (kVar.s0() == nVar) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(deserialize);
            return arrayList;
        }
        Object deserialize2 = deserialize(kVar, gVar);
        if (kVar.s0() == nVar) {
            ArrayList arrayList2 = new ArrayList(2);
            arrayList2.add(deserialize);
            arrayList2.add(deserialize2);
            return arrayList2;
        }
        d4.s q02 = gVar.q0();
        Object[] i11 = q02.i();
        i11[0] = deserialize;
        i11[1] = deserialize2;
        int i12 = 2;
        while (true) {
            Object deserialize3 = deserialize(kVar, gVar);
            i10++;
            if (i12 >= i11.length) {
                i11 = q02.c(i11);
                i12 = 0;
            }
            int i13 = i12 + 1;
            i11[i12] = deserialize3;
            if (kVar.s0() == c3.n.END_ARRAY) {
                ArrayList arrayList3 = new ArrayList(i10);
                q02.e(i11, i13, arrayList3);
                return arrayList3;
            }
            i12 = i13;
        }
    }

    public Object[] mapArrayToArray(c3.k kVar, k3.g gVar) {
        if (kVar.s0() == c3.n.END_ARRAY) {
            return NO_OBJECTS;
        }
        d4.s q02 = gVar.q0();
        Object[] i10 = q02.i();
        int i11 = 0;
        while (true) {
            Object deserialize = deserialize(kVar, gVar);
            if (i11 >= i10.length) {
                i10 = q02.c(i10);
                i11 = 0;
            }
            int i12 = i11 + 1;
            i10[i11] = deserialize;
            if (kVar.s0() == c3.n.END_ARRAY) {
                return q02.f(i10, i12);
            }
            i11 = i12;
        }
    }

    public Object mapObject(c3.k kVar, k3.g gVar) {
        String str;
        c3.n n10 = kVar.n();
        if (n10 == c3.n.START_OBJECT) {
            str = kVar.q0();
        } else if (n10 == c3.n.FIELD_NAME) {
            str = kVar.m();
        } else {
            if (n10 != c3.n.END_OBJECT) {
                return gVar.a0(handledType(), kVar);
            }
            str = null;
        }
        String str2 = str;
        if (str2 == null) {
            return new LinkedHashMap(2);
        }
        kVar.s0();
        Object deserialize = deserialize(kVar, gVar);
        String q02 = kVar.q0();
        if (q02 == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put(str2, deserialize);
            return linkedHashMap;
        }
        kVar.s0();
        Object deserialize2 = deserialize(kVar, gVar);
        String q03 = kVar.q0();
        if (q03 == null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(4);
            linkedHashMap2.put(str2, deserialize);
            return linkedHashMap2.put(q02, deserialize2) != null ? _mapObjectWithDups(kVar, gVar, linkedHashMap2, str2, deserialize, deserialize2, q03) : linkedHashMap2;
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put(str2, deserialize);
        if (linkedHashMap3.put(q02, deserialize2) != null) {
            return _mapObjectWithDups(kVar, gVar, linkedHashMap3, str2, deserialize, deserialize2, q03);
        }
        do {
            kVar.s0();
            Object deserialize3 = deserialize(kVar, gVar);
            Object put = linkedHashMap3.put(q03, deserialize3);
            if (put != null) {
                return _mapObjectWithDups(kVar, gVar, linkedHashMap3, q03, put, deserialize3, kVar.q0());
            }
            q03 = kVar.q0();
        } while (q03 != null);
        return linkedHashMap3;
    }

    @Override // n3.r
    public void resolve(k3.g gVar) {
        k3.j x10 = gVar.x(Object.class);
        k3.j x11 = gVar.x(String.class);
        c4.o l10 = gVar.l();
        k3.j jVar = this._listType;
        if (jVar == null) {
            this._listDeserializer = _clearIfStdImpl(_findCustomDeser(gVar, l10.z(List.class, x10)));
        } else {
            this._listDeserializer = _findCustomDeser(gVar, jVar);
        }
        k3.j jVar2 = this._mapType;
        if (jVar2 == null) {
            this._mapDeserializer = _clearIfStdImpl(_findCustomDeser(gVar, l10.D(Map.class, x11, x10)));
        } else {
            this._mapDeserializer = _findCustomDeser(gVar, jVar2);
        }
        this._stringDeserializer = _clearIfStdImpl(_findCustomDeser(gVar, x11));
        this._numberDeserializer = _clearIfStdImpl(_findCustomDeser(gVar, l10.H(Number.class)));
        k3.j O = c4.o.O();
        this._mapDeserializer = gVar.Z(this._mapDeserializer, null, O);
        this._listDeserializer = gVar.Z(this._listDeserializer, null, O);
        this._stringDeserializer = gVar.Z(this._stringDeserializer, null, O);
        this._numberDeserializer = gVar.Z(this._numberDeserializer, null, O);
    }

    @Override // k3.k
    public Boolean supportsUpdate(k3.f fVar) {
        return null;
    }

    public m0(m0 m0Var, boolean z10) {
        super(Object.class);
        this._mapDeserializer = m0Var._mapDeserializer;
        this._listDeserializer = m0Var._listDeserializer;
        this._stringDeserializer = m0Var._stringDeserializer;
        this._numberDeserializer = m0Var._numberDeserializer;
        this._listType = m0Var._listType;
        this._mapType = m0Var._mapType;
        this._nonMerging = z10;
    }

    public Object mapArray(c3.k kVar, k3.g gVar, Collection<Object> collection) {
        while (kVar.s0() != c3.n.END_ARRAY) {
            collection.add(deserialize(kVar, gVar));
        }
        return collection;
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar, Object obj) {
        if (this._nonMerging) {
            return deserialize(kVar, gVar);
        }
        switch (kVar.q()) {
            case 1:
            case 2:
            case 5:
                k3.k kVar2 = this._mapDeserializer;
                if (kVar2 == null) {
                    if (!(obj instanceof Map)) {
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            case 3:
                k3.k kVar3 = this._listDeserializer;
                if (kVar3 == null) {
                    if (!(obj instanceof Collection)) {
                        if (!gVar.n0(k3.h.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            case 6:
                k3.k kVar4 = this._stringDeserializer;
                if (kVar4 == null) {
                    break;
                } else {
                    break;
                }
            case 7:
                k3.k kVar5 = this._numberDeserializer;
                if (kVar5 == null) {
                    if (!gVar.k0(b0.F_MASK_INT_COERCIONS)) {
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            case 8:
                k3.k kVar6 = this._numberDeserializer;
                if (kVar6 == null) {
                    if (!gVar.n0(k3.h.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
        }
        return deserialize(kVar, gVar);
    }

    public Object mapObject(c3.k kVar, k3.g gVar, Map<Object, Object> map) {
        Object deserialize;
        c3.n n10 = kVar.n();
        if (n10 == c3.n.START_OBJECT) {
            n10 = kVar.s0();
        }
        if (n10 == c3.n.END_OBJECT) {
            return map;
        }
        String m10 = kVar.m();
        do {
            kVar.s0();
            Object obj = map.get(m10);
            if (obj != null) {
                deserialize = deserialize(kVar, gVar, obj);
            } else {
                deserialize = deserialize(kVar, gVar);
            }
            if (deserialize != obj) {
                map.put(m10, deserialize);
            }
            m10 = kVar.q0();
        } while (m10 != null);
        return map;
    }
}
