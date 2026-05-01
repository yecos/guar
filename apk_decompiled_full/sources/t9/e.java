package t9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class e implements z9.b, d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f18948b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final Map f18949c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f18950d;

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f18951e;

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f18952f;

    /* renamed from: g, reason: collision with root package name */
    public static final Map f18953g;

    /* renamed from: a, reason: collision with root package name */
    public final Class f18954a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    static {
        int i10 = 0;
        List g10 = i9.j.g(s9.a.class, s9.l.class, s9.p.class, s9.q.class, s9.r.class, s9.s.class, s9.t.class, s9.u.class, s9.v.class, s9.w.class, s9.b.class, s9.c.class, s9.d.class, s9.e.class, s9.f.class, s9.g.class, s9.h.class, s9.i.class, s9.j.class, s9.k.class, s9.m.class, s9.n.class, s9.o.class);
        ArrayList arrayList = new ArrayList(i9.k.k(g10, 10));
        for (Object obj : g10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                i9.j.j();
            }
            arrayList.add(h9.p.a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f18949c = i9.z.g(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f18950d = hashMap;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f18951e = hashMap2;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        i.f(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            i.f(str, "kotlinName");
            sb.append(ba.t.R(str, '.', null, 2, null));
            sb.append("CompanionObject");
            h9.k a10 = h9.p.a(sb.toString(), str + ".Companion");
            hashMap3.put(a10.c(), a10.d());
        }
        for (Map.Entry entry : f18949c.entrySet()) {
            hashMap3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        f18952f = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(i9.y.a(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), ba.t.R((String) entry2.getValue(), '.', null, 2, null));
        }
        f18953g = linkedHashMap;
    }

    public e(Class cls) {
        i.g(cls, "jClass");
        this.f18954a = cls;
    }

    @Override // t9.d
    public Class a() {
        return this.f18954a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && i.b(r9.a.a(this), r9.a.a((z9.b) obj));
    }

    public int hashCode() {
        return r9.a.a(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
