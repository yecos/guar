package m3;

import java.io.Serializable;
import java.util.Map;
import k3.q;

/* loaded from: classes.dex */
public class d implements Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final int f16637e = c4.f.values().length;

    /* renamed from: a, reason: collision with root package name */
    public b f16638a;

    /* renamed from: b, reason: collision with root package name */
    public final o f16639b;

    /* renamed from: c, reason: collision with root package name */
    public o[] f16640c;

    /* renamed from: d, reason: collision with root package name */
    public Map f16641d;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16642a;

        static {
            int[] iArr = new int[e.values().length];
            f16642a = iArr;
            try {
                iArr[e.EmptyArray.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16642a[e.Float.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16642a[e.Integer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d() {
        this(b.TryConvert, new o(), null, null);
    }

    public b a(k3.f fVar, c4.f fVar2, Class cls, e eVar) {
        o oVar;
        b a10;
        o oVar2;
        b a11;
        Map map = this.f16641d;
        if (map != null && cls != null && (oVar2 = (o) map.get(cls)) != null && (a11 = oVar2.a(eVar)) != null) {
            return a11;
        }
        o[] oVarArr = this.f16640c;
        if (oVarArr != null && fVar2 != null && (oVar = oVarArr[fVar2.ordinal()]) != null && (a10 = oVar.a(eVar)) != null) {
            return a10;
        }
        b a12 = this.f16639b.a(eVar);
        if (a12 != null) {
            return a12;
        }
        int i10 = a.f16642a[eVar.ordinal()];
        boolean z10 = true;
        if (i10 == 1) {
            return fVar.j0(k3.h.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT) ? b.AsNull : b.Fail;
        }
        if (i10 != 2) {
            if (i10 == 3 && fVar2 == c4.f.Enum && fVar.j0(k3.h.FAIL_ON_NUMBERS_FOR_ENUMS)) {
                return b.Fail;
            }
        } else if (fVar2 == c4.f.Integer) {
            return fVar.j0(k3.h.ACCEPT_FLOAT_AS_INT) ? b.TryConvert : b.Fail;
        }
        if (fVar2 != c4.f.Float && fVar2 != c4.f.Integer && fVar2 != c4.f.Boolean && fVar2 != c4.f.DateTime) {
            z10 = false;
        }
        return (!z10 || fVar.D(q.ALLOW_COERCION_OF_SCALARS)) ? eVar == e.EmptyString ? (z10 || fVar.j0(k3.h.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) ? b.AsNull : fVar2 == c4.f.OtherScalar ? b.TryConvert : b.Fail : this.f16638a : b.Fail;
    }

    public b b(k3.f fVar, c4.f fVar2, Class cls, b bVar) {
        Boolean bool;
        b bVar2;
        o oVar;
        o oVar2;
        Map map = this.f16641d;
        if (map == null || cls == null || (oVar2 = (o) map.get(cls)) == null) {
            bool = null;
            bVar2 = null;
        } else {
            bool = oVar2.b();
            bVar2 = oVar2.a(e.EmptyString);
        }
        o[] oVarArr = this.f16640c;
        if (oVarArr != null && fVar2 != null && (oVar = oVarArr[fVar2.ordinal()]) != null) {
            if (bool == null) {
                bool = oVar.b();
            }
            if (bVar2 == null) {
                bVar2 = oVar.a(e.EmptyString);
            }
        }
        if (bool == null) {
            bool = this.f16639b.b();
        }
        if (bVar2 == null) {
            bVar2 = this.f16639b.a(e.EmptyString);
        }
        return !Boolean.TRUE.equals(bool) ? bVar : bVar2 != null ? bVar2 : fVar.j0(k3.h.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) ? b.AsNull : b.Fail;
    }

    public d(b bVar, o oVar, o[] oVarArr, Map map) {
        this.f16639b = oVar;
        this.f16638a = bVar;
        this.f16640c = oVarArr;
        this.f16641d = map;
    }
}
