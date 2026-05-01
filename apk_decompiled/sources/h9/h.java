package h9;

import com.taobao.accs.common.Constants;

/* loaded from: classes.dex */
public abstract class h {

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14224a;

        static {
            int[] iArr = new int[i.values().length];
            try {
                iArr[i.SYNCHRONIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[i.PUBLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[i.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f14224a = iArr;
        }
    }

    public static final g a(i iVar, s9.a aVar) {
        t9.i.g(iVar, Constants.KEY_MODE);
        t9.i.g(aVar, "initializer");
        int i10 = a.f14224a[iVar.ordinal()];
        if (i10 == 1) {
            return new o(aVar, null, 2, null);
        }
        if (i10 == 2) {
            return new n(aVar);
        }
        if (i10 == 3) {
            return new u(aVar);
        }
        throw new j();
    }

    public static final g b(s9.a aVar) {
        t9.i.g(aVar, "initializer");
        return new o(aVar, null, 2, null);
    }
}
