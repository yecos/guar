package com.umeng.message.proguard;

import com.umeng.message.proguard.bx;

/* loaded from: classes3.dex */
public final class dd {

    /* renamed from: com.umeng.message.proguard.dd$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11876a;

        static {
            int[] iArr = new int[bx.c.values().length];
            f11876a = iArr;
            try {
                iArr[bx.c.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11876a[bx.c.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11876a[bx.c.FLOATING_ICON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T extends dc> T a(cz czVar, bx.b bVar) {
        T dmVar;
        T t10;
        int i10 = AnonymousClass1.f11876a[czVar.f11851b.ordinal()];
        if (i10 == 1) {
            dmVar = new dm(czVar);
        } else if (i10 == 2) {
            dmVar = new dq(czVar);
        } else {
            if (i10 != 3) {
                t10 = null;
                if (t10 != null) {
                    t10.f11865c = bVar;
                }
                return t10;
            }
            dmVar = new dn(czVar);
        }
        t10 = dmVar;
        if (t10 != null) {
        }
        return t10;
    }
}
