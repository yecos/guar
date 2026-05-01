package com.umeng.message.proguard;

import com.umeng.message.proguard.bx;

/* loaded from: classes3.dex */
public final class bt {

    /* renamed from: com.umeng.message.proguard.bt$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11674a;

        static {
            int[] iArr = new int[bx.c.values().length];
            f11674a = iArr;
            try {
                iArr[bx.c.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11674a[bx.c.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11674a[bx.c.FLOATING_ICON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static int a(bx.c cVar) {
        if (cVar == null) {
            return -1;
        }
        int i10 = AnonymousClass1.f11674a[cVar.ordinal()];
        if (i10 == 1) {
            return 2;
        }
        if (i10 != 2) {
            return i10 != 3 ? -1 : 5;
        }
        return 4;
    }

    public static bx.c a(ck ckVar) {
        int optInt = ckVar.f11740b.optInt("type", -1);
        if (optInt == 2) {
            return bx.c.BANNER;
        }
        if (optInt == 4) {
            return bx.c.INTERSTITIAL;
        }
        if (optInt != 5) {
            return null;
        }
        return bx.c.FLOATING_ICON;
    }
}
