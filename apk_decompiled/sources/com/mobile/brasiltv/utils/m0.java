package com.mobile.brasiltv.utils;

/* loaded from: classes3.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static final m0 f8732a = new m0();

    public static /* synthetic */ v9.a c(m0 m0Var, String str, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return m0Var.b(str, j10);
    }

    public static /* synthetic */ v9.a e(m0 m0Var, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return m0Var.d(str, str2);
    }

    public final v9.a a(String str, boolean z10) {
        return new j0(str, Boolean.valueOf(z10));
    }

    public final v9.a b(String str, long j10) {
        return new k0(str, j10);
    }

    public final v9.a d(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return new l0(str, str2);
    }
}
