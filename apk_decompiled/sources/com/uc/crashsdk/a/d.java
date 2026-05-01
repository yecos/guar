package com.uc.crashsdk.a;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.common.base.Ascii;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.commonsdk.framework.UMModuleRegister;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f9609a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f9610b = true;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f9612d = false;

    /* renamed from: e, reason: collision with root package name */
    private static String f9613e = "hsdk";

    /* renamed from: f, reason: collision with root package name */
    private static String f9614f = "alid ";

    /* renamed from: g, reason: collision with root package name */
    private static String f9615g;

    /* renamed from: i, reason: collision with root package name */
    private static String f9617i;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f9611c = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f9616h = new Object();

    public static void a() {
        f.a(0, new e(500), com.uc.crashsdk.b.H() ? 900000L : 90000L);
    }

    public static String b() {
        try {
            return "inv" + f9614f + "cras" + f9613e;
        } catch (Throwable th) {
            g.b(th);
            return "";
        }
    }

    public static void c() {
        synchronized (f9616h) {
            f9617i = null;
        }
    }

    public static byte[] d() {
        return new byte[]{6, 0, Ascii.ETB, 8};
    }

    public static boolean e() {
        if (!com.uc.crashsdk.e.F() && !com.uc.crashsdk.b.L()) {
            a(true);
            return f9610b;
        }
        return true;
    }

    private static String f() {
        String str = f9617i;
        if (g.a(str)) {
            synchronized (f9616h) {
                str = g.a(com.uc.crashsdk.b.j(), (com.uc.crashsdk.g.S() ? "https://errlogos.umeng.com" : "https://errlog.umeng.com") + "/api/crashsdk/validate", true);
                f9617i = str;
            }
        }
        return str;
    }

    private static String g() {
        byte[] bArr;
        String f10;
        byte[] a10;
        byte[] bArr2;
        StringBuilder sb = new StringBuilder();
        a(sb, DispatchConstants.PLATFORM, com.uc.crashsdk.g.e());
        a(sb, "pkgname", com.uc.crashsdk.a.f9578a);
        a(sb, UMModuleRegister.PROCESS, com.uc.crashsdk.e.h());
        a(sb, "version", com.uc.crashsdk.a.a());
        a(sb, "cver", "3.3.2.2");
        a(sb, "ctag", "umeng");
        a(sb, "inter", com.uc.crashsdk.g.S() ? "true" : "false");
        a(sb, "os", "android");
        String sb2 = sb.toString();
        byte[] bArr3 = new byte[16];
        c.a(bArr3, 0, h.j());
        c.a(bArr3, 4, c.a());
        c.a(bArr3, 8, d());
        c.a(bArr3, 12, com.uc.crashsdk.a.f());
        try {
            bArr = c.a(sb2.getBytes(), bArr3, true);
        } catch (Throwable th) {
            g.a(th);
            bArr = null;
        }
        if (bArr == null || (f10 = f()) == null || (a10 = c.a(f10, bArr)) == null) {
            return null;
        }
        try {
            bArr2 = c.a(a10, bArr3, false);
        } catch (Throwable th2) {
            g.a(th2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            return new String(bArr2);
        }
        return null;
    }

    public static void a(int i10) {
        if (i10 != 500) {
            if (!f9609a) {
                throw new AssertionError();
            }
            return;
        }
        synchronized (f9611c) {
            f9615g = null;
            a(!com.uc.crashsdk.b.F());
            if (g.b(f9615g)) {
                h.a(f9615g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(boolean r12) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.d.a(boolean):boolean");
    }

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append(Operator.Operation.EQUALS);
        sb.append(str2);
        return sb;
    }
}
