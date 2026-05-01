package d4;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes.dex */
public final class l implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Class f12550a;

    /* renamed from: b, reason: collision with root package name */
    public final Enum[] f12551b;

    /* renamed from: c, reason: collision with root package name */
    public final c3.q[] f12552c;

    public l(Class cls, c3.q[] qVarArr) {
        this.f12550a = cls;
        this.f12551b = (Enum[]) cls.getEnumConstants();
        this.f12552c = qVarArr;
    }

    public static l a(Class cls, c3.q[] qVarArr) {
        return new l(cls, qVarArr);
    }

    public static l b(m3.m mVar, Class cls) {
        Class r10 = h.r(cls);
        Enum[] enumArr = (Enum[]) r10.getEnumConstants();
        if (enumArr == null) {
            throw new IllegalArgumentException("Cannot determine enum constants for Class " + cls.getName());
        }
        String[] o10 = mVar.g().o(r10, enumArr, new String[enumArr.length]);
        c3.q[] qVarArr = new c3.q[enumArr.length];
        int length = enumArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Enum r52 = enumArr[i10];
            String str = o10[i10];
            if (str == null) {
                str = r52.name();
            }
            qVarArr[r52.ordinal()] = mVar.d(str);
        }
        return a(cls, qVarArr);
    }

    public Class c() {
        return this.f12550a;
    }

    public c3.q d(Enum r22) {
        return this.f12552c[r22.ordinal()];
    }

    public Collection e() {
        return Arrays.asList(this.f12552c);
    }
}
