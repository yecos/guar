package w3;

import b3.e0;
import c3.k;
import c3.n;
import k3.j;

/* loaded from: classes.dex */
public abstract class e {

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19157a;

        static {
            int[] iArr = new int[n.values().length];
            f19157a = iArr;
            try {
                iArr[n.VALUE_STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19157a[n.VALUE_NUMBER_INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19157a[n.VALUE_NUMBER_FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19157a[n.VALUE_TRUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19157a[n.VALUE_FALSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static Object a(k kVar, k3.g gVar, Class cls) {
        n n10 = kVar.n();
        if (n10 == null) {
            return null;
        }
        int i10 = a.f19157a[n10.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 == 5 && cls.isAssignableFrom(Boolean.class)) {
                            return Boolean.FALSE;
                        }
                    } else if (cls.isAssignableFrom(Boolean.class)) {
                        return Boolean.TRUE;
                    }
                } else if (cls.isAssignableFrom(Double.class)) {
                    return Double.valueOf(kVar.M());
                }
            } else if (cls.isAssignableFrom(Integer.class)) {
                return Integer.valueOf(kVar.P());
            }
        } else if (cls.isAssignableFrom(String.class)) {
            return kVar.Y();
        }
        return null;
    }

    public static Object b(k kVar, k3.g gVar, j jVar) {
        return a(kVar, gVar, jVar.q());
    }

    public abstract Object c(k kVar, k3.g gVar);

    public abstract Object d(k kVar, k3.g gVar);

    public abstract Object e(k kVar, k3.g gVar);

    public abstract Object f(k kVar, k3.g gVar);

    public abstract e g(k3.d dVar);

    public abstract Class h();

    public abstract String i();

    public abstract f j();

    public abstract e0.a k();

    public abstract boolean l();
}
