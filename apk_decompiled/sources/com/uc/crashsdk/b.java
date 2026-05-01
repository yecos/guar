package com.uc.crashsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.uc.crashsdk.a.h;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import org.android.agoo.common.AgooConstants;

/* loaded from: classes3.dex */
public class b {
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static boolean F = false;
    private static String H = null;
    private static int I = 0;
    private static boolean J = false;
    private static boolean K = false;
    private static boolean L = true;
    private static RandomAccessFile M = null;
    private static boolean N = false;
    private static String P = null;
    private static boolean Q = false;
    private static volatile Object[] R = null;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9658a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f9661b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9662c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f9663d = false;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f9665f = false;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f9666g = true;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f9667h = false;

    /* renamed from: i, reason: collision with root package name */
    static final /* synthetic */ boolean f9668i = true;

    /* renamed from: j, reason: collision with root package name */
    private static String f9669j = null;

    /* renamed from: k, reason: collision with root package name */
    private static String f9670k = null;

    /* renamed from: l, reason: collision with root package name */
    private static String f9671l = null;

    /* renamed from: m, reason: collision with root package name */
    private static String f9672m = null;

    /* renamed from: n, reason: collision with root package name */
    private static String f9673n = null;

    /* renamed from: o, reason: collision with root package name */
    private static String f9674o = null;

    /* renamed from: p, reason: collision with root package name */
    private static String f9675p = null;

    /* renamed from: q, reason: collision with root package name */
    private static String f9676q = null;

    /* renamed from: r, reason: collision with root package name */
    private static String f9677r = null;

    /* renamed from: s, reason: collision with root package name */
    private static String f9678s = null;

    /* renamed from: t, reason: collision with root package name */
    private static String f9679t = null;

    /* renamed from: u, reason: collision with root package name */
    private static String f9680u = null;

    /* renamed from: v, reason: collision with root package name */
    private static String f9681v = null;

    /* renamed from: w, reason: collision with root package name */
    private static String f9682w = null;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f9683x = false;

    /* renamed from: y, reason: collision with root package name */
    private static boolean f9684y = false;

    /* renamed from: z, reason: collision with root package name */
    private static volatile boolean f9685z = false;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f9664e = new Object();
    private static final Object G = new Object();
    private static final Object O = new Object();
    private static Runnable S = new com.uc.crashsdk.a.e(101);
    private static boolean T = false;
    private static long U = 0;
    private static final Object V = new Object();
    private static long W = 0;
    private static boolean X = false;
    private static boolean Y = false;
    private static boolean Z = false;

    /* renamed from: aa, reason: collision with root package name */
    private static long f9659aa = 0;

    /* renamed from: ab, reason: collision with root package name */
    private static final WeakHashMap<Activity, Integer> f9660ab = new WeakHashMap<>();
    private static boolean ac = false;
    private static String ad = null;
    private static boolean ae = false;
    private static boolean af = false;
    private static boolean ag = false;
    private static boolean ah = false;
    private static boolean ai = false;
    private static final Object aj = new Object();
    private static PendingIntent ak = null;

    public static boolean A() {
        return Y || !ad();
    }

    public static boolean B() {
        return Y && !f9683x;
    }

    public static void C() {
        com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(100));
    }

    public static void D() {
        String str;
        if (!f9663d || (str = ad) == null) {
            return;
        }
        JNIBridge.set(129, str);
    }

    public static String E() {
        String str = ad;
        return str == null ? "" : str;
    }

    public static boolean F() {
        if (!ae) {
            if (!com.uc.crashsdk.a.g.a(a.f9578a) && a.f9578a.equals(e.h())) {
                af = true;
                if (f9663d) {
                    JNIBridge.set(2, true);
                }
            }
            ae = true;
        }
        return af;
    }

    public static void G() {
        ag = true;
        if (f9663d) {
            JNIBridge.set(34, true);
        }
    }

    public static boolean H() {
        return ag;
    }

    public static int I() {
        boolean U2 = U();
        return t() ? U2 ? 3 : 6 : s() ? U2 ? 2 : 5 : U2 ? 4 : 1;
    }

    public static int J() {
        boolean V2 = V();
        boolean W2 = W();
        boolean X2 = X();
        if (t()) {
            if (V2) {
                return 12;
            }
            if (W2) {
                return 14;
            }
            return X2 ? 16 : 98;
        }
        if (!s()) {
            return 1;
        }
        if (V2) {
            return 11;
        }
        if (W2) {
            return 13;
        }
        return X2 ? 15 : 97;
    }

    public static void K() {
        if (f9663d) {
            JNIBridge.nativeSet(27, I, AgooConstants.ACK_PACK_NULL, null);
            JNIBridge.set(30, L);
        }
    }

    public static boolean L() {
        if (!ai) {
            synchronized (aj) {
                if (!ai) {
                    ah = ae();
                    ai = true;
                }
            }
        }
        return ah;
    }

    public static void M() {
        if (e.F() || L() || ak != null || g.h() < 0) {
            return;
        }
        try {
            Context a10 = com.uc.crashsdk.a.g.a();
            Intent launchIntentForPackage = a10.getPackageManager().getLaunchIntentForPackage(a10.getPackageName());
            launchIntentForPackage.addFlags(335544320);
            ak = PendingIntent.getActivity(a10, 0, launchIntentForPackage, 0);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static boolean N() {
        if (ak == null) {
            com.uc.crashsdk.a.a.b("Restart intent is null!");
            return false;
        }
        try {
            com.uc.crashsdk.a.a.a("crashsdk", "restarting ...");
            ((AlarmManager) com.uc.crashsdk.a.g.a().getSystemService("alarm")).set(1, System.currentTimeMillis() + 200, ak);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static /* synthetic */ boolean O() {
        ac = true;
        return true;
    }

    private static String Q() {
        if (f9669j == null) {
            f9669j = d("ss");
        }
        return f9669j;
    }

    private static String R() {
        if (f9671l == null) {
            f9671l = d("ctn");
        }
        return f9671l;
    }

    private static String S() {
        if (f9672m == null) {
            f9672m = d("cta");
        }
        return f9672m;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:13|(9:17|18|(1:24)|25|26|(1:28)|30|31|32)|35|18|(2:20|24)|25|26|(0)|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        com.uc.crashsdk.a.g.a(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[Catch: all -> 0x0075, TRY_LEAVE, TryCatch #0 {all -> 0x0075, blocks: (B:26:0x006b, B:28:0x0071), top: B:25:0x006b, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void T() {
        /*
            boolean r0 = com.uc.crashsdk.b.f9685z
            if (r0 != 0) goto L80
            boolean r0 = com.uc.crashsdk.b.f9684y
            if (r0 == 0) goto La
            goto L80
        La:
            java.lang.Object r0 = com.uc.crashsdk.b.G
            monitor-enter(r0)
            boolean r1 = com.uc.crashsdk.b.f9685z     // Catch: java.lang.Throwable -> L7d
            if (r1 == 0) goto L13
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7d
            return
        L13:
            java.lang.String r1 = com.uc.crashsdk.g.X()     // Catch: java.lang.Throwable -> L7d
            f(r1)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r1 = p()     // Catch: java.lang.Throwable -> L7d
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L7d
            java.lang.String r3 = b()     // Catch: java.lang.Throwable -> L7d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L7d
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L7d
            java.lang.String r4 = R()     // Catch: java.lang.Throwable -> L7d
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r4 = "f"
            boolean r4 = r4.equals(r1)     // Catch: java.lang.Throwable -> L7d
            com.uc.crashsdk.b.A = r4     // Catch: java.lang.Throwable -> L7d
            java.lang.String r4 = "b"
            boolean r1 = r4.equals(r1)     // Catch: java.lang.Throwable -> L7d
            com.uc.crashsdk.b.B = r1     // Catch: java.lang.Throwable -> L7d
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L7d
            com.uc.crashsdk.b.D = r1     // Catch: java.lang.Throwable -> L7d
            boolean r1 = r3.exists()     // Catch: java.lang.Throwable -> L7d
            com.uc.crashsdk.b.E = r1     // Catch: java.lang.Throwable -> L7d
            boolean r2 = com.uc.crashsdk.b.D     // Catch: java.lang.Throwable -> L7d
            r3 = 1
            if (r2 != 0) goto L56
            if (r1 == 0) goto L54
            goto L56
        L54:
            r1 = 0
            goto L57
        L56:
            r1 = 1
        L57:
            com.uc.crashsdk.b.C = r1     // Catch: java.lang.Throwable -> L7d
            if (r1 != 0) goto L6b
            boolean r1 = com.uc.crashsdk.b.A     // Catch: java.lang.Throwable -> L7d
            if (r1 != 0) goto L63
            boolean r1 = com.uc.crashsdk.b.B     // Catch: java.lang.Throwable -> L7d
            if (r1 == 0) goto L6b
        L63:
            boolean r1 = r()     // Catch: java.lang.Throwable -> L7d
            com.uc.crashsdk.b.F = r1     // Catch: java.lang.Throwable -> L7d
            com.uc.crashsdk.b.C = r1     // Catch: java.lang.Throwable -> L7d
        L6b:
            boolean r1 = z()     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L79
            Z()     // Catch: java.lang.Throwable -> L75
            goto L79
        L75:
            r1 = move-exception
            com.uc.crashsdk.a.g.a(r1)     // Catch: java.lang.Throwable -> L7d
        L79:
            com.uc.crashsdk.b.f9685z = r3     // Catch: java.lang.Throwable -> L7d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7d
            return
        L7d:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7d
            throw r1
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.b.T():void");
    }

    private static boolean U() {
        T();
        return C;
    }

    private static boolean V() {
        T();
        return D;
    }

    private static boolean W() {
        T();
        return E;
    }

    private static boolean X() {
        T();
        return F;
    }

    private static void Y() {
        if (f9663d) {
            JNIBridge.set(26, f9683x);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0041 -> B:13:0x0044). Please report as a decompilation issue!!! */
    private static void Z() {
        if (!T) {
            T = true;
            try {
                new File(b()).delete();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            try {
                new File(R()).delete();
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            try {
                if (f9663d) {
                    JNIBridge.cmd(16);
                } else {
                    new File(S()).delete();
                }
            } catch (Throwable th3) {
                com.uc.crashsdk.a.g.a(th3);
            }
        }
        Object[] ab2 = ab();
        if (!ab2[0].equals(P) && R == null) {
            a(ab2);
        } else {
            Q = true;
            aa();
        }
    }

    public static String a() {
        String str = H;
        if (str != null) {
            return str;
        }
        String h10 = e.h();
        if (com.uc.crashsdk.a.g.a(h10)) {
            H = "LLUN";
        } else {
            int i10 = 0;
            if (h10.length() > 48) {
                int length = h10.length() - 48;
                h10 = h10.substring(0, 48);
                i10 = length;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bytes = h10.getBytes();
            for (int length2 = bytes.length - 1; length2 >= 0; length2--) {
                byte b10 = bytes[length2];
                if (b10 == 46) {
                    sb.append('0');
                } else if (b10 == 58) {
                    sb.append('1');
                } else if (b10 >= 97 && b10 <= 122) {
                    sb.append((char) ((b10 + 65) - 97));
                } else if (b10 >= 65 && b10 <= 90) {
                    sb.append((char) b10);
                } else if (b10 < 48 || b10 > 57) {
                    sb.append('2');
                } else {
                    sb.append((char) b10);
                }
            }
            if (i10 > 0) {
                sb.append(String.valueOf(i10));
            }
            H = sb.toString();
        }
        return H;
    }

    private static void aa() {
        if (!com.uc.crashsdk.a.f.b(S)) {
            com.uc.crashsdk.a.f.a(1, S);
            return;
        }
        Object[] objArr = R;
        if (objArr == null || !ab()[0].equals(objArr[0])) {
            com.uc.crashsdk.a.f.a(S);
            com.uc.crashsdk.a.f.a(1, S);
        }
    }

    private static Object[] ab() {
        synchronized (V) {
            long j10 = W + 1;
            W = j10;
            if (f9683x) {
                return new Object[]{"e", Long.valueOf(j10)};
            }
            if (B()) {
                return new Object[]{m7.f.f16828a, Long.valueOf(W)};
            }
            return new Object[]{c8.b.f5629b, Long.valueOf(W)};
        }
    }

    private static Object ac() {
        Object a10;
        Object a11 = a((Application) com.uc.crashsdk.a.g.a(), (Class<?>) Application.class, "mLoadedApk");
        if (a11 != null && (a10 = a(a11, (Class<?>) null, "mActivityThread")) != null) {
            return a10;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, new Object[0]);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return null;
    }

    private static boolean ad() {
        String a10 = com.uc.crashsdk.a.g.a(new File("/proc/self/cgroup"), 512, false);
        if (com.uc.crashsdk.a.g.a(a10)) {
            return false;
        }
        return a10.contains("/bg_non_interactive") || a10.contains("/background");
    }

    private static boolean ae() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke != null && (invoke instanceof Boolean)) {
                    return ((Boolean) invoke).booleanValue();
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        int myUid = Process.myUid() % 100000;
        return myUid >= 99000 && myUid <= 99999;
    }

    public static String b() {
        if (f9670k == null) {
            f9670k = d("ctj");
        }
        return f9670k;
    }

    private static String d(String str) {
        return g.X() + a() + "." + str;
    }

    private static File[] e(String str) {
        if (!f9668i && str.length() <= 0) {
            throw new AssertionError();
        }
        File[] listFiles = new File(g.X()).listFiles();
        if (listFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            if (file.getPath().endsWith(str)) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public static File[] f() {
        return e(".stcb");
    }

    public static String g() {
        if (f9681v == null) {
            f9681v = d("bati");
        }
        return f9681v;
    }

    public static String h() {
        if (f9682w == null) {
            f9682w = d("hdr");
        }
        return f9682w;
    }

    public static String i() {
        if (f9676q == null) {
            f9676q = g.X() + com.umeng.analytics.pro.f.R;
        }
        return f9676q;
    }

    public static String j() {
        if (f9677r == null) {
            f9677r = g.X() + "authu";
        }
        return f9677r;
    }

    public static String k() {
        if (f9678s == null) {
            f9678s = g.X() + "statu";
        }
        return f9678s;
    }

    public static String l() {
        if (f9679t == null) {
            f9679t = g.X() + "poli";
        }
        return f9679t;
    }

    public static String m() {
        if (f9680u == null) {
            f9680u = g.X() + BrowserInfo.KEY_VER;
        }
        return f9680u;
    }

    public static String n() {
        return g.X() + "bvu";
    }

    public static String o() {
        return g.X() + "fds";
    }

    public static String p() {
        return com.uc.crashsdk.a.g.a(new File(Q()), 8, false);
    }

    public static boolean q() {
        return f9684y;
    }

    public static boolean r() {
        if (!J) {
            if (f9663d) {
                K = JNIBridge.cmd(15) == 1;
            } else {
                K = new File(S()).exists();
            }
            J = true;
        }
        return K;
    }

    public static boolean s() {
        T();
        return A;
    }

    public static boolean t() {
        T();
        return B;
    }

    public static boolean u() {
        return f9683x;
    }

    public static void v() {
        boolean z10;
        f(g.X());
        f9684y = true;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        F = false;
        String[] strArr = {".st", ".wa", ".callback", ".ctn", ".ctj", ".cta", ".signal"};
        String[] strArr2 = {com.umeng.analytics.pro.f.R, "authu", "statu", "poli"};
        File[] listFiles = new File(g.X()).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                int i10 = 0;
                while (true) {
                    if (i10 >= 7) {
                        z10 = false;
                        break;
                    } else {
                        if (name.endsWith(strArr[i10])) {
                            z10 = true;
                            break;
                        }
                        i10++;
                    }
                }
                if (!z10) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= 4) {
                            break;
                        }
                        if (name.equals(strArr2[i11])) {
                            z10 = true;
                            break;
                        }
                        i11++;
                    }
                }
                if (z10) {
                    com.uc.crashsdk.a.a.a("crashsdk", "delete file: " + file.getPath());
                    com.uc.crashsdk.a.g.a(file);
                }
            }
        }
        Z();
    }

    public static void w() {
        if (f9683x) {
            return;
        }
        f9683x = true;
        if (L() || e.u()) {
            return;
        }
        f(g.X());
        Y();
        Z();
    }

    public static boolean x() {
        return f(g.X());
    }

    public static boolean y() {
        return f(g.Y());
    }

    public static boolean z() {
        return X || !ad();
    }

    public static String c() {
        if (f9673n == null) {
            f9673n = d("st");
        }
        return f9673n;
    }

    public static File[] d() {
        return e(".st");
    }

    private static boolean f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "Crash log directory was placed by a file!", null);
        if (!file.delete()) {
            return false;
        }
        file.mkdirs();
        return true;
    }

    public static String b(String str) {
        return "debug.crs." + str;
    }

    public static void b(boolean z10) {
        if (e.u()) {
            return;
        }
        if (z10 && f9683x) {
            g.P();
            f9683x = false;
            Y();
        }
        boolean z11 = e.F() || L();
        long currentTimeMillis = System.currentTimeMillis();
        if (X && !Y && z10) {
            long j10 = f9659aa;
            if (j10 != 0 && !z11 && currentTimeMillis - j10 > 1800000) {
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(104), 1000L);
            }
        }
        f9659aa = currentTimeMillis;
        Y = z10;
        if (z10) {
            X = true;
        }
        if (f9663d) {
            JNIBridge.nativeSetForeground(z10);
        }
        if (f9683x || z11) {
            return;
        }
        T();
        Z();
        if (z10) {
            a.a(false);
            if (!Z) {
                e.B();
                Z = true;
            }
        }
        if (!N) {
            aa();
        }
        e.c(z10);
    }

    public static boolean c(int i10) {
        return (i10 & I) != 0;
    }

    public static String e() {
        if (f9674o == null) {
            f9674o = d("stcb");
        }
        return f9674o;
    }

    public static String a(String str) {
        if (str == null || str.length() <= 0 || !str.endsWith(".st")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".st");
        if (!f9668i && lastIndexOf < 0) {
            throw new AssertionError();
        }
        String substring = str.substring(0, lastIndexOf);
        if (substring.length() <= 0) {
            return null;
        }
        return substring + ".stcb";
    }

    public static void a(boolean z10) {
        L = z10;
        if (f9663d) {
            JNIBridge.set(30, z10);
        }
    }

    public static void b(int i10) {
        I = i10;
        K();
    }

    private static void a(Object[] objArr) {
        R = objArr;
        synchronized (O) {
            String str = (String) objArr[0];
            long longValue = ((Long) objArr[1]).longValue();
            if (longValue < U) {
                com.uc.crashsdk.a.a.c("crashsdk", String.format(Locale.US, "Update state generation %d, last is: %d", Long.valueOf(longValue), Long.valueOf(U)));
                return;
            }
            U = longValue;
            String Q2 = Q();
            if (f9663d) {
                RandomAccessFile randomAccessFile = M;
                if (randomAccessFile != null) {
                    com.uc.crashsdk.a.g.a(randomAccessFile);
                    M = null;
                }
                boolean nativeChangeState = JNIBridge.nativeChangeState(Q2, str, N);
                N = false;
                if (!nativeChangeState) {
                    com.uc.crashsdk.a.a.b("write state failed: " + str);
                }
            } else {
                RandomAccessFile randomAccessFile2 = M;
                if (randomAccessFile2 == null || N) {
                    if (randomAccessFile2 != null) {
                        com.uc.crashsdk.a.g.a(randomAccessFile2);
                        M = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile3 = new RandomAccessFile(Q2, "rw");
                        M = randomAccessFile3;
                        randomAccessFile3.seek(0L);
                        N = false;
                    } catch (Exception e10) {
                        com.uc.crashsdk.a.g.a(e10);
                    }
                }
                try {
                    M.write(str.getBytes());
                    M.seek(0L);
                } catch (Exception e11) {
                    com.uc.crashsdk.a.g.a(e11);
                }
            }
            P = str;
            R = null;
        }
    }

    public static void b(Context context) {
        long j10;
        boolean z10;
        com.uc.crashsdk.a.a.a("Restart APP");
        if (context == null) {
            return;
        }
        if (f9675p == null) {
            f9675p = d("rt");
        }
        File file = new File(f9675p);
        try {
            j10 = Long.parseLong(com.uc.crashsdk.a.g.d(file));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            j10 = -1;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (g.h() < 0 || (j10 > 0 && currentTimeMillis - j10 <= g.h())) {
            z10 = false;
        } else {
            f(g.X());
            com.uc.crashsdk.a.g.a(file, String.valueOf(currentTimeMillis));
            z10 = true;
        }
        com.uc.crashsdk.a.a.a("lastTime: " + j10 + ", currentTime: " + currentTimeMillis + ", needRestart: " + z10);
        if (z10) {
            try {
                d.a(true);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            N();
        }
    }

    public static boolean a(Context context) {
        try {
            ((Application) context).registerActivityLifecycleCallbacks(new c());
            if (!g.M()) {
                return true;
            }
            C();
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static void a(int i10) {
        Object a10;
        Activity activity;
        int i11;
        boolean z10 = false;
        boolean z11 = true;
        switch (i10) {
            case 100:
                Object ac2 = ac();
                if (ac2 == null || (a10 = a(ac2, (Class<?>) null, "mActivities")) == null) {
                    return;
                }
                try {
                    Iterator it = ((Map) a10).entrySet().iterator();
                    boolean z12 = false;
                    while (it.hasNext()) {
                        Object value = ((Map.Entry) it.next()).getValue();
                        if (value != null && (activity = (Activity) a(value, (Class<?>) null, "activity")) != null) {
                            boolean booleanValue = ((Boolean) a(value, (Class<?>) null, "paused")).booleanValue();
                            boolean booleanValue2 = ((Boolean) a(value, (Class<?>) null, "stopped")).booleanValue();
                            WeakHashMap<Activity, Integer> weakHashMap = f9660ab;
                            synchronized (weakHashMap) {
                                if (booleanValue || booleanValue2) {
                                    i11 = 2;
                                } else {
                                    i11 = 1;
                                    z12 = true;
                                }
                                weakHashMap.put(activity, Integer.valueOf(i11));
                            }
                        }
                        z10 = true;
                    }
                    if (z10) {
                        b(z12);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 101:
                try {
                    if (new File(Q()).exists()) {
                        z11 = false;
                    }
                    N = z11;
                    if (z11 || Q) {
                        a(ab());
                        Q = false;
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    com.uc.crashsdk.a.g.a(th2);
                    return;
                }
            case 102:
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(103));
                return;
            case 103:
                try {
                    com.uc.crashsdk.a.g.a(new File(S()));
                    return;
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 104:
                h.d();
                f.a(102);
                if (F()) {
                    e.C();
                    return;
                }
                return;
            default:
                if (!f9668i) {
                    throw new AssertionError();
                }
                return;
        }
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    public static boolean a(Object obj, String str, com.uc.crashsdk.a.e eVar) {
        FileChannel fileChannel;
        boolean z10;
        synchronized (obj) {
            FileChannel fileChannel2 = null;
            r1 = null;
            FileLock lock = null;
            FileChannel fileChannel3 = null;
            boolean z11 = false;
            if (f9663d) {
                int nativeOpenFile = JNIBridge.nativeOpenFile(str);
                if (nativeOpenFile < 0) {
                    com.uc.crashsdk.a.a.a("crashsdk", "Can not open file: " + str, null);
                    return false;
                }
                try {
                    boolean nativeLockFile = JNIBridge.nativeLockFile(nativeOpenFile, true);
                    try {
                        z10 = eVar.a();
                        return z10;
                    } finally {
                        if (nativeLockFile) {
                            JNIBridge.nativeLockFile(nativeOpenFile, false);
                        }
                    }
                } finally {
                    JNIBridge.nativeCloseFile(nativeOpenFile);
                }
            }
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e10) {
                    com.uc.crashsdk.a.g.a(e10);
                }
            }
            try {
                try {
                    fileChannel = new RandomAccessFile(file, "rw").getChannel();
                } catch (Throwable th) {
                    th = th;
                    com.uc.crashsdk.a.g.a(fileChannel3);
                    throw th;
                }
            } catch (Exception e11) {
                try {
                    com.uc.crashsdk.a.g.a(e11);
                    fileChannel = null;
                } catch (Exception e12) {
                    e = e12;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileChannel2);
                    z10 = z11;
                    return z10;
                }
            }
            if (fileChannel != null) {
                try {
                    try {
                        lock = fileChannel.lock();
                    } catch (Exception e13) {
                        try {
                            com.uc.crashsdk.a.g.a(e13);
                        } catch (Exception e14) {
                            e = e14;
                            fileChannel2 = fileChannel;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel2);
                            z10 = z11;
                            return z10;
                        }
                    }
                } catch (Throwable th2) {
                    fileChannel3 = fileChannel;
                    th = th2;
                    com.uc.crashsdk.a.g.a(fileChannel3);
                    throw th;
                }
            }
            try {
                z11 = eVar.a();
                com.uc.crashsdk.a.g.a(fileChannel);
                z10 = z11;
                return z10;
            } finally {
                if (lock != null) {
                    try {
                        lock.release();
                    } catch (Exception e15) {
                        com.uc.crashsdk.a.g.a(e15);
                    }
                }
            }
        }
    }
}
