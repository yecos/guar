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
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T extends com.umeng.message.proguard.dc> T a(com.umeng.message.proguard.cz r2, com.umeng.message.proguard.bx.b r3) {
        /*
            int[] r0 = com.umeng.message.proguard.dd.AnonymousClass1.f11876a
            com.umeng.message.proguard.bx$c r1 = r2.f11851b
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L21
            r1 = 2
            if (r0 == r1) goto L1b
            r1 = 3
            if (r0 == r1) goto L15
            r2 = 0
            goto L27
        L15:
            com.umeng.message.proguard.dn r0 = new com.umeng.message.proguard.dn
            r0.<init>(r2)
            goto L26
        L1b:
            com.umeng.message.proguard.dq r0 = new com.umeng.message.proguard.dq
            r0.<init>(r2)
            goto L26
        L21:
            com.umeng.message.proguard.dm r0 = new com.umeng.message.proguard.dm
            r0.<init>(r2)
        L26:
            r2 = r0
        L27:
            if (r2 == 0) goto L2b
            r2.f11865c = r3
        L2b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.dd.a(com.umeng.message.proguard.cz, com.umeng.message.proguard.bx$b):com.umeng.message.proguard.dc");
    }
}
