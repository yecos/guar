package d4;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class k implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Class f12545a;

    /* renamed from: b, reason: collision with root package name */
    public final Enum[] f12546b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f12547c;

    /* renamed from: d, reason: collision with root package name */
    public final Enum f12548d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f12549e;

    public k(Class cls, Enum[] enumArr, HashMap hashMap, Enum r42, boolean z10) {
        this.f12545a = cls;
        this.f12546b = enumArr;
        this.f12547c = hashMap;
        this.f12548d = r42;
        this.f12549e = z10;
    }

    public static k a(Class cls, k3.b bVar, boolean z10) {
        Class d10 = d(cls);
        Enum[] e10 = e(cls);
        String[] o10 = bVar.o(d10, e10, new String[e10.length]);
        String[][] strArr = new String[o10.length][];
        bVar.n(d10, e10, strArr);
        HashMap hashMap = new HashMap();
        int length = e10.length;
        for (int i10 = 0; i10 < length; i10++) {
            Enum r72 = e10[i10];
            String str = o10[i10];
            if (str == null) {
                str = r72.name();
            }
            hashMap.put(str, r72);
            String[] strArr2 = strArr[i10];
            if (strArr2 != null) {
                for (String str2 : strArr2) {
                    if (!hashMap.containsKey(str2)) {
                        hashMap.put(str2, r72);
                    }
                }
            }
        }
        return new k(d10, e10, hashMap, f(bVar, d10), z10);
    }

    public static k b(Class cls, r3.i iVar, k3.b bVar, boolean z10) {
        Class d10 = d(cls);
        Enum[] e10 = e(cls);
        HashMap hashMap = new HashMap();
        int length = e10.length;
        while (true) {
            length--;
            if (length < 0) {
                return new k(d10, e10, hashMap, f(bVar, d10), z10);
            }
            Enum r02 = e10[length];
            try {
                Object n10 = iVar.n(r02);
                if (n10 != null) {
                    hashMap.put(n10.toString(), r02);
                }
            } catch (Exception e11) {
                throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + r02 + ": " + e11.getMessage());
            }
        }
    }

    public static k c(Class cls, k3.b bVar, boolean z10) {
        Class d10 = d(cls);
        Enum[] e10 = e(cls);
        HashMap hashMap = new HashMap();
        String[][] strArr = new String[e10.length][];
        bVar.n(d10, e10, strArr);
        int length = e10.length;
        while (true) {
            length--;
            if (length < 0) {
                return new k(d10, e10, hashMap, f(bVar, d10), z10);
            }
            Enum r42 = e10[length];
            hashMap.put(r42.toString(), r42);
            String[] strArr2 = strArr[length];
            if (strArr2 != null) {
                for (String str : strArr2) {
                    if (!hashMap.containsKey(str)) {
                        hashMap.put(str, r42);
                    }
                }
            }
        }
    }

    public static Class d(Class cls) {
        return cls;
    }

    public static Enum[] e(Class cls) {
        Enum[] enumArr = (Enum[]) d(cls).getEnumConstants();
        if (enumArr != null) {
            return enumArr;
        }
        throw new IllegalArgumentException("No enum constants for class " + cls.getName());
    }

    public static Enum f(k3.b bVar, Class cls) {
        if (bVar != null) {
            return bVar.j(d(cls));
        }
        return null;
    }

    public static k h(k3.f fVar, Class cls) {
        return a(cls, fVar.g(), fVar.D(k3.q.ACCEPT_CASE_INSENSITIVE_ENUMS));
    }

    public static k j(k3.f fVar, Class cls, r3.i iVar) {
        return b(cls, iVar, fVar.g(), fVar.D(k3.q.ACCEPT_CASE_INSENSITIVE_ENUMS));
    }

    public static k k(k3.f fVar, Class cls) {
        return c(cls, fVar.g(), fVar.D(k3.q.ACCEPT_CASE_INSENSITIVE_ENUMS));
    }

    public Enum g(String str) {
        for (Map.Entry entry : this.f12547c.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                return (Enum) entry.getValue();
            }
        }
        return null;
    }

    public i i() {
        return i.b(this.f12547c);
    }

    public Enum l(String str) {
        Enum r02 = (Enum) this.f12547c.get(str);
        return (r02 == null && this.f12549e) ? g(str) : r02;
    }

    public Enum m() {
        return this.f12548d;
    }

    public Class n() {
        return this.f12545a;
    }

    public Collection o() {
        return this.f12547c.keySet();
    }

    public Enum[] p() {
        return this.f12546b;
    }
}
