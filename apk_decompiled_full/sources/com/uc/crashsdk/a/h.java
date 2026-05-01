package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import com.uc.crashsdk.JNIBridge;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import io.jsonwebtoken.Header;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f9640a = true;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f9641b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f9642c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static int f9643d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, a> f9644e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private static final Object f9645f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static final Object f9646g = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static final SparseArray<String> f9647h = new SparseArray<>();

    /* renamed from: i, reason: collision with root package name */
    private static boolean f9648i = false;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f9649j = false;

    /* renamed from: k, reason: collision with root package name */
    private static final Object f9650k = new Object();

    /* renamed from: l, reason: collision with root package name */
    private static String f9651l = null;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f9652a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f9653b = 0;

        /* renamed from: c, reason: collision with root package name */
        Map<String, String> f9654c = new HashMap();

        /* renamed from: d, reason: collision with root package name */
        private String f9655d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f9656e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f9657f;

        public a(String str, boolean z10, boolean z11) {
            this.f9656e = false;
            this.f9657f = false;
            this.f9655d = str;
            this.f9656e = z10;
            this.f9657f = z11;
        }

        private long d(String str) {
            return g.c(a(str));
        }

        public final void a(String str, String str2) {
            this.f9654c.put(str, str2);
        }

        public final String b(String str) {
            String a10 = a(str);
            return a10 == null ? "" : a10;
        }

        public final boolean c(String str) {
            if (g.a(str)) {
                return false;
            }
            HashMap hashMap = new HashMap();
            Map c10 = h.c(str);
            String str2 = null;
            long j10 = 0;
            int i10 = 0;
            for (String str3 : c10.keySet()) {
                String str4 = (String) c10.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.f9656e && str3.equals(com.umeng.analytics.pro.f.R)) {
                    j10 = g.c(str4);
                } else if (this.f9656e && str3.equals("pid")) {
                    i10 = (int) g.c(str4);
                } else {
                    hashMap.put(str3, str4);
                }
            }
            String str5 = this.f9655d;
            if (str5 != null && !str5.equals(str2)) {
                return false;
            }
            this.f9652a = j10;
            this.f9653b = i10;
            this.f9655d = str2;
            this.f9654c = hashMap;
            return true;
        }

        public final void a(String str, long j10) {
            long d10 = d(str) + j10;
            if (d10 <= 100) {
                j10 = 0;
                if (d10 >= 0) {
                    j10 = d10;
                }
            }
            a(str, String.valueOf(j10));
        }

        public final boolean a(a aVar) {
            if (!this.f9657f) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "WaItem '%s' is not mergable!", this.f9655d), null);
                return false;
            }
            for (String str : aVar.f9654c.keySet()) {
                if (str.startsWith("c_")) {
                    a(str, aVar.a(str));
                } else {
                    long d10 = aVar.d(str);
                    if (d10 == 0) {
                        a(str, aVar.a(str));
                    } else if (d10 < 100) {
                        a(str, d10);
                    }
                }
            }
            return true;
        }

        public final String a(String str) {
            return this.f9654c.get(str);
        }

        public final String a(boolean z10, boolean z11, boolean z12) {
            if (this.f9655d == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (z10) {
                h.b(sb, "lt", "uc");
                h.b(sb, "pre", com.uc.crashsdk.g.e());
                h.b(sb, "pkg", com.uc.crashsdk.a.f9578a);
                h.b(sb, "rom", Build.VERSION.RELEASE);
                h.b(sb, "brd", Build.BRAND);
                h.b(sb, Constants.KEY_MODEL, Build.MODEL);
                h.a(sb, com.umeng.ccg.a.f10661u, Build.VERSION.SDK_INT);
                h.b(sb, bt.f10062w, com.uc.crashsdk.e.e());
                h.b(sb, "hdw", com.uc.crashsdk.e.f());
                long o10 = h.o();
                h.a(sb, "ram", o10);
                h.b(sb, "aram", h.a(o10));
                h.b(sb, "cver", "3.3.2.2");
                h.b(sb, "cseq", "240515102041");
                h.b(sb, "ctag", "umeng");
                h.b(sb, "aver", com.uc.crashsdk.a.a());
                h.b(sb, BrowserInfo.KEY_VER, com.uc.crashsdk.g.U());
                h.b(sb, "sver", com.uc.crashsdk.g.V());
                h.b(sb, "seq", com.uc.crashsdk.g.W());
                h.b(sb, "grd", com.uc.crashsdk.b.A() ? "fg" : "bg");
                h.b(sb, "os", "android");
                h.b(sb, "dn", com.uc.crashsdk.e.q());
                String ac = com.uc.crashsdk.g.ac();
                if (TextUtils.isEmpty(ac)) {
                    ac = com.uc.crashsdk.e.q();
                }
                h.b(sb, "k_uid", ac);
                String ad = com.uc.crashsdk.g.ad();
                if (!TextUtils.isEmpty(ad)) {
                    h.b(sb, "k_channel", ad);
                }
                sb.append("\n");
            }
            h.b(sb, "lt", this.f9655d);
            h.a(sb, this.f9654c);
            if (this.f9656e && !z11) {
                long j10 = this.f9652a;
                if (j10 != 0) {
                    h.b(sb, com.umeng.analytics.pro.f.R, String.valueOf(j10));
                }
                if (z12) {
                    h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(Process.myPid())));
                } else {
                    int i10 = this.f9653b;
                    if (i10 != 0) {
                        h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(i10)));
                    }
                }
            }
            sb.append("\n");
            return sb.toString();
        }
    }

    public static /* synthetic */ String a(long j10) {
        return j10 < 524288 ? "512M" : String.format(Locale.US, "%dG", Long.valueOf(((j10 / 1024) + 512) / 1024));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(Operator.Operation.EQUALS);
        sb.append(str2);
        sb.append("`");
    }

    public static /* synthetic */ Map c(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("`")) {
            if (str2.length() > 1) {
                String[] split = str2.split(Operator.Operation.EQUALS, 3);
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    public static void d() {
        b(2, 2000L);
        a(1, 70000L);
    }

    public static boolean e() {
        return f9649j;
    }

    public static void f() {
        b(1, 2000L);
    }

    public static void g() {
        b(3, 0L);
    }

    public static void h() {
        b(4, 0L);
    }

    public static void i() {
        if (com.uc.crashsdk.g.R()) {
            f.a(1, new e(303));
        }
    }

    public static byte[] j() {
        return new byte[]{Ascii.DEL, 100, 110, Ascii.US};
    }

    public static void k() {
        synchronized (f9650k) {
            f9651l = null;
        }
    }

    private static String m() {
        return com.uc.crashsdk.g.X() + "pv.wa";
    }

    private static String n() {
        return com.uc.crashsdk.g.X() + "cdt.wa";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long o() {
        Iterator<String> it = g.a(new File("/proc/meminfo"), 2).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next.contains("MemTotal:")) {
                try {
                    return Long.parseLong(next.replaceAll("\\D+", ""));
                } catch (NumberFormatException e10) {
                    g.a(e10);
                }
            }
        }
        return 0L;
    }

    public static /* synthetic */ void a(StringBuilder sb, String str, long j10) {
        b(sb, str, String.valueOf(j10));
    }

    public static void b() {
        a(2, 0L);
    }

    public static void c() {
        a(3, 0L);
    }

    private static void b(int i10, long j10) {
        if (com.uc.crashsdk.g.R()) {
            f.a(1, new e(301, new Object[]{Integer.valueOf(i10)}), j10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean c(String str, String str2) {
        boolean z10;
        String d10;
        String sb;
        byte[] a10;
        byte[] a11;
        if (g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        try {
            byte[] bArr = new byte[16];
            c.a(bArr, 0, c.a());
            c.a(bArr, 4, j());
            c.a(bArr, 8, com.uc.crashsdk.a.f());
            c.a(bArr, 12, d.d());
            a11 = c.a(bytes, bArr);
        } catch (Throwable th) {
            g.a(th);
        }
        if (a11 != null) {
            bytes = a11;
            z10 = true;
            if (str == null) {
                str = "unknown";
            }
            String str3 = !com.uc.crashsdk.g.S() ? "4ea4e41a3993" : "28ef1713347d";
            String valueOf = String.valueOf(System.currentTimeMillis());
            d10 = g.d(str3 + str + valueOf + "AppChk#2014");
            if (d10 != null) {
                sb = null;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(com.uc.crashsdk.g.A());
                sb2.append("?chk=");
                sb2.append(d10.substring(d10.length() - 8, d10.length()));
                sb2.append("&vno=");
                sb2.append(valueOf);
                sb2.append("&uuid=");
                sb2.append(str);
                sb2.append("&app=");
                sb2.append(str3);
                if (z10) {
                    sb2.append("&enc=aes");
                }
                sb = sb2.toString();
            }
            return sb == null && (a10 = c.a(sb, bytes)) != null && new String(a10).contains("retcode=0");
        }
        z10 = false;
        if (str == null) {
        }
        if (!com.uc.crashsdk.g.S()) {
        }
        String valueOf2 = String.valueOf(System.currentTimeMillis());
        d10 = g.d(str3 + str + valueOf2 + "AppChk#2014");
        if (d10 != null) {
        }
        if (sb == null) {
            return false;
        }
    }

    private static boolean d(String str) {
        boolean c10;
        File file = new File(str);
        Iterator<a> it = a(file, "cst", 30).iterator();
        while (it.hasNext()) {
            a next = it.next();
            String a10 = next.a("prc");
            if (!g.a(a10)) {
                Map<String, a> map = f9644e;
                a aVar = map.get(a10);
                if (aVar != null) {
                    aVar.a(next);
                } else {
                    map.put(a10, next);
                }
            }
        }
        Map<String, a> map2 = f9644e;
        StringBuilder a11 = a((Iterable<a>) map2.values(), true, false);
        if (com.uc.crashsdk.g.ab()) {
            c10 = b(com.uc.crashsdk.e.q(), a11.toString());
        } else {
            c10 = c(com.uc.crashsdk.e.q(), a11.toString());
        }
        g.b(file);
        if (c10 || g.a(file, a((Iterable<a>) map2.values(), false, true).toString())) {
            map2.clear();
        }
        return true;
    }

    public static /* synthetic */ void a(StringBuilder sb, Map map) {
        for (String str : map.keySet()) {
            b(sb, str, (String) map.get(str));
        }
    }

    public static void a(String str) {
        synchronized (f9641b) {
            File file = new File(m());
            a aVar = new a(com.umeng.analytics.pro.f.T, true, true);
            String c10 = g.c(file);
            if (!g.a(c10)) {
                aVar.c(c10);
            }
            aVar.a(str, 1L);
            aVar.a("aujv", 1L);
            g.a(file, aVar.a(false, false, false));
        }
    }

    public static boolean b(int i10, Object[] objArr) {
        switch (i10) {
            case 351:
                if (!f9640a && objArr == null) {
                    throw new AssertionError();
                }
                String str = (String) objArr[0];
                int intValue = ((Integer) objArr[1]).intValue();
                if (intValue == 1) {
                    if (f9649j) {
                        return false;
                    }
                    f9649j = true;
                }
                if (!com.uc.crashsdk.g.aa()) {
                    return false;
                }
                File file = new File(str);
                ArrayList<a> a10 = a(file, "crp", 100);
                if (intValue != 4) {
                    a aVar = new a("crp", false, false);
                    if (intValue == 1) {
                        aVar.a("et", String.valueOf(com.uc.crashsdk.b.I()));
                        aVar.a("ete", String.valueOf(com.uc.crashsdk.b.J()));
                    } else if (intValue == 3) {
                        aVar.a("et", "1");
                        aVar.a("ete", "1");
                    } else if (intValue == 2) {
                        aVar.a("hpv", "1");
                    }
                    aVar.a("prc", com.uc.crashsdk.e.h());
                    aVar.a(bd.f9976c, com.uc.crashsdk.b.F() ? "1" : "0");
                    a(aVar);
                    a10.add(0, aVar);
                }
                if (!a10.isEmpty()) {
                    boolean c10 = c(com.uc.crashsdk.e.q(), a((Iterable<a>) a10, true, false).toString());
                    g.b(file);
                    if (!c10) {
                        g.a(file, a((Iterable<a>) a10, false, true).toString());
                    }
                }
                return true;
            case 352:
                if (f9640a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case 353:
                if (f9640a || objArr != null) {
                    return b((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                }
                throw new AssertionError();
            case 354:
                if (!f9640a && objArr == null) {
                    throw new AssertionError();
                }
                File file2 = new File((String) objArr[0]);
                boolean c11 = c(com.uc.crashsdk.e.q(), a((Iterable<a>) a(file2, "cst", 30), true, false).toString());
                if (c11) {
                    g.b(file2);
                }
                return c11;
            default:
                return false;
        }
    }

    public static void a() {
        a(0, com.uc.crashsdk.b.H() ? 700000L : 70000L);
    }

    private static void a(int i10, long j10) {
        if (com.uc.crashsdk.b.F()) {
            f.a(0, new e(302, new Object[]{Integer.valueOf(i10)}), j10);
        }
    }

    public static boolean a(String str, String str2) {
        try {
            String str3 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", Operator.Operation.MINUS);
            String replaceAll = g.a(str2) ? "" : str2.replaceAll("[`=]", Operator.Operation.MINUS);
            Map<String, String> map = f9642c;
            synchronized (map) {
                if (map.get(str3) == null) {
                    int i10 = f9643d;
                    if (i10 >= 20) {
                        return false;
                    }
                    f9643d = i10 + 1;
                }
                map.put(str3, replaceAll);
                return true;
            }
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    public static void b(boolean z10) {
        if (a(z10, "crash detail upload")) {
            return;
        }
        String str = com.uc.crashsdk.g.X() + "dt.wa";
        com.uc.crashsdk.b.a(f9645f, str, new e(352, new Object[]{str}));
        String n10 = n();
        com.uc.crashsdk.b.a(f9646g, n10, new e(354, new Object[]{n10}));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(String str, String str2) {
        boolean z10;
        byte[] a10;
        byte[] a11;
        if (g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        long currentTimeMillis = System.currentTimeMillis();
        String d10 = g.d(com.uc.crashsdk.g.e() + str + currentTimeMillis + "AppChk#2014");
        try {
            a11 = c.a(bytes, d10.substring(d10.length() - 16, d10.length()).getBytes());
        } catch (Throwable th) {
            g.a(th);
        }
        if (a11 != null) {
            bytes = a11;
            z10 = true;
            String substring = d10.substring(d10.length() - 8, d10.length());
            StringBuilder sb = new StringBuilder();
            sb.append(com.uc.crashsdk.g.A());
            sb.append("/api/v1/crashtrack/upload?chk=");
            sb.append(substring);
            sb.append("&vno=");
            sb.append(currentTimeMillis);
            sb.append("&uuid=");
            sb.append(str);
            sb.append("&app=");
            sb.append(com.uc.crashsdk.g.e());
            if (z10) {
                sb.append("&enc=aes");
            }
            String sb2 = sb.toString();
            return sb2 == null && (a10 = c.a(sb2, bytes)) != null && new String(a10).contains("retcode=0");
        }
        z10 = false;
        String substring2 = d10.substring(d10.length() - 8, d10.length());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(com.uc.crashsdk.g.A());
        sb3.append("/api/v1/crashtrack/upload?chk=");
        sb3.append(substring2);
        sb3.append("&vno=");
        sb3.append(currentTimeMillis);
        sb3.append("&uuid=");
        sb3.append(str);
        sb3.append("&app=");
        sb3.append(com.uc.crashsdk.g.e());
        if (z10) {
        }
        String sb22 = sb3.toString();
        if (sb22 == null) {
            return false;
        }
    }

    private static void a(a aVar) {
        Map<String, String> map = f9642c;
        synchronized (map) {
            for (String str : map.keySet()) {
                aVar.a(str, f9642c.get(str));
            }
        }
    }

    public static void a(boolean z10) {
        a(1, z10);
    }

    public static boolean a(boolean z10, String str) {
        if (!com.uc.crashsdk.b.f9663d || z10 || !JNIBridge.nativeIsCrashing()) {
            return false;
        }
        com.uc.crashsdk.a.a.b("crashsdk", "Native is crashing, skip stat for " + str);
        return true;
    }

    private static boolean b(String str, String str2, boolean z10, boolean z11) {
        a aVar;
        File file = new File(n());
        ArrayList<a> a10 = a(file, "cst", 30);
        String str3 = str + str2;
        Iterator<a> it = a10.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (str3.equals(aVar.b("prc") + aVar.b(Header.TYPE))) {
                break;
            }
        }
        if (aVar == null) {
            aVar = new a("cst", false, true);
            aVar.a("prc", str);
            aVar.a(Header.TYPE, str2);
            a(aVar);
            a10.add(aVar);
        }
        aVar.a("cnt", 1L);
        if (z10) {
            aVar.a("lim", 1L);
        }
        if (z11) {
            aVar.a("syu", 1L);
        }
        return g.a(file, a((Iterable<a>) a10, false, false).toString());
    }

    private static void a(int i10, boolean z10) {
        if (a(z10, "crash rate")) {
            return;
        }
        String str = com.uc.crashsdk.g.X() + "cr.wa";
        com.uc.crashsdk.b.a(f9641b, str, new e(351, new Object[]{str, Integer.valueOf(i10)}));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:
    
        if (r3 == false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00af A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:19:0x001d, B:21:0x0028, B:23:0x002c, B:24:0x00c9, B:27:0x002e, B:29:0x0038, B:31:0x0040, B:33:0x005a, B:35:0x005f, B:42:0x0070, B:43:0x0077, B:44:0x008b, B:46:0x0097, B:50:0x00af, B:51:0x00c2, B:52:0x00a5, B:57:0x0083), top: B:18:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i10, Object[] objArr) {
        String str;
        String q10;
        long j10;
        boolean z10;
        switch (i10) {
            case 301:
                if (!f9640a && objArr == null) {
                    throw new AssertionError();
                }
                a(((Integer) objArr[0]).intValue(), false);
                return;
            case 302:
                if (!f9640a && objArr == null) {
                    throw new AssertionError();
                }
                synchronized (f9641b) {
                    int intValue = ((Integer) objArr[0]).intValue();
                    if (intValue == 0) {
                        if (!f9648i) {
                            f9648i = true;
                        }
                    }
                    if (!com.uc.crashsdk.a.f9579b.equals("2.0") || !com.uc.crashsdk.b.c(268435456)) {
                        File file = new File(m());
                        String c10 = g.c(file);
                        a aVar = new a(com.umeng.analytics.pro.f.T, true, true);
                        if (!g.a(c10)) {
                            aVar.c(c10);
                        }
                        if (intValue == 0) {
                            if (aVar.f9653b != Process.myPid()) {
                                z10 = false;
                                break;
                            } else {
                                z10 = true;
                                break;
                            }
                        }
                        if (intValue == 0) {
                            aVar.a(com.umeng.analytics.pro.f.T, 1L);
                            str = "fjv";
                        } else if (intValue == 1) {
                            str = "hpv";
                        } else {
                            if (intValue == 2) {
                                aVar.a(com.umeng.analytics.pro.f.T, 1L);
                                str = "npv";
                            }
                            q10 = com.uc.crashsdk.e.q();
                            j10 = aVar.f9652a;
                            if ((j10 != 0 || System.currentTimeMillis() - j10 >= 28800000) ? c(q10, aVar.a(true, true, false)) : false) {
                                aVar.f9654c = new HashMap();
                                aVar.f9652a = System.currentTimeMillis();
                                aVar.f9653b = Process.myPid();
                            }
                            g.a(file, aVar.a(false, false, true));
                        }
                        aVar.a(str, 1L);
                        q10 = com.uc.crashsdk.e.q();
                        j10 = aVar.f9652a;
                        if ((j10 != 0 || System.currentTimeMillis() - j10 >= 28800000) ? c(q10, aVar.a(true, true, false)) : false) {
                        }
                        g.a(file, aVar.a(false, false, true));
                    }
                }
                return;
            case 303:
                b(false);
                return;
            default:
                if (!f9640a) {
                    throw new AssertionError();
                }
                return;
        }
    }

    public static void b(String str) {
        synchronized (f9650k) {
            f9651l = str;
            b.a(com.uc.crashsdk.b.k(), str + "\n");
        }
    }

    private static StringBuilder a(Iterable<a> iterable, boolean z10, boolean z11) {
        StringBuilder sb = new StringBuilder();
        boolean z12 = true;
        for (a aVar : iterable) {
            if (z12) {
                sb.append(aVar.a(z10, z10, z11));
                z12 = false;
            } else {
                sb.append(aVar.a(false, z10, z11));
            }
        }
        return sb;
    }

    public static void a(String str, int i10, int i11) {
        if (com.uc.crashsdk.g.R()) {
            synchronized (f9645f) {
                Map<String, a> map = f9644e;
                a aVar = map.get(str);
                if (aVar == null) {
                    aVar = new a("cst", false, true);
                    map.put(str, aVar);
                    a(aVar);
                }
                SparseArray<String> sparseArray = f9647h;
                synchronized (sparseArray) {
                    if (sparseArray.size() == 0) {
                        a(100, com.umeng.analytics.pro.f.T);
                        a(102, "hpv");
                        a(1, "all");
                        a(2, "afg");
                        a(101, "abg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(32, "urs");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(40, "anf");
                        a(41, "anb");
                        a(42, "ancf");
                        a(43, "ancb");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(200, "ltf");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(201, "lec");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                String str2 = sparseArray.get(i10);
                if (str2 == null) {
                    com.uc.crashsdk.a.a.a("crashsdk", "map key is not set with: " + i10, null);
                }
                aVar.a("prc", str);
                if (str2 != null) {
                    aVar.a(str2, String.valueOf(i11));
                }
            }
        }
    }

    public static boolean a(String str, String str2, boolean z10, boolean z11) {
        if (!com.uc.crashsdk.g.R()) {
            return false;
        }
        return com.uc.crashsdk.b.a(f9646g, n(), new e(353, new Object[]{str, str2, Boolean.valueOf(z10), Boolean.valueOf(z11)}));
    }

    private static void a(int i10, String str) {
        f9647h.put(i10, str);
    }

    private static ArrayList<a> a(File file, String str, int i10) {
        ArrayList<String> a10 = g.a(file, i10);
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<String> it = a10.iterator();
        while (it.hasNext()) {
            String next = it.next();
            a aVar = new a(str, false, false);
            if (aVar.c(next)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
