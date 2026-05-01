package com.uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.Log;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.uc.crashsdk.export.LogType;
import java.io.File;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f9578a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f9579b = "";

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f9581d = true;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, String> f9582e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private static final List<String> f9583f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private static String f9584g = "";

    /* renamed from: h, reason: collision with root package name */
    private static String f9585h = null;

    /* renamed from: i, reason: collision with root package name */
    private static int f9586i = -1;

    /* renamed from: j, reason: collision with root package name */
    private static long f9587j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static final HashMap<String, Object[]> f9588k = new HashMap<>();

    /* renamed from: l, reason: collision with root package name */
    private static final List<String> f9589l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private static int f9590m = 0;

    /* renamed from: n, reason: collision with root package name */
    private static int f9591n = 0;

    /* renamed from: o, reason: collision with root package name */
    private static int f9592o = 0;

    /* renamed from: p, reason: collision with root package name */
    private static int f9593p = 0;

    /* renamed from: q, reason: collision with root package name */
    private static final HashMap<String, Object[]> f9594q = new HashMap<>();

    /* renamed from: r, reason: collision with root package name */
    private static final List<String> f9595r = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    private static int f9596s = 0;

    /* renamed from: t, reason: collision with root package name */
    private static int f9597t = 0;

    /* renamed from: u, reason: collision with root package name */
    private static int f9598u = 0;

    /* renamed from: v, reason: collision with root package name */
    private static int f9599v = 0;

    /* renamed from: w, reason: collision with root package name */
    private static int f9600w = 0;

    /* renamed from: x, reason: collision with root package name */
    private static int f9601x = 0;

    /* renamed from: y, reason: collision with root package name */
    private static final SparseArray<Object[]> f9602y = new SparseArray<>();

    /* renamed from: z, reason: collision with root package name */
    private static final List<Integer> f9603z = new ArrayList();
    private static final HashMap<String, Object[]> A = new HashMap<>();
    private static final List<String> B = new ArrayList();
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;

    /* renamed from: c, reason: collision with root package name */
    static boolean f9580c = false;
    private static Runnable F = new com.uc.crashsdk.a.e(201);
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = false;

    public static String a() {
        String str = f9585h;
        return str != null ? str : o() ? f9585h : "";
    }

    public static long b() {
        return f9587j;
    }

    public static int c() {
        if (f9586i == -1) {
            o();
        }
        return f9586i;
    }

    public static void d() {
        StringBuilder sb = new StringBuilder();
        synchronized (f9582e) {
            for (String str : f9583f) {
                String str2 = f9582e.get(str);
                sb.append(str);
                sb.append(": ");
                if (str2 != null) {
                    sb.append(str2);
                }
                sb.append("\n");
            }
        }
        sb.append(String.format(Locale.US, "(saved at %s)\n", e.n()));
        com.uc.crashsdk.a.b.a(b.h(), sb.toString());
    }

    public static void e() {
        if (!f9581d && !b.f9663d) {
            throw new AssertionError();
        }
        synchronized (f9582e) {
            for (String str : f9583f) {
                JNIBridge.nativeAddHeaderInfo(str, f9582e.get(str));
            }
        }
    }

    public static byte[] f() {
        return new byte[]{Ascii.CAN, 99, 121, 60};
    }

    public static void g() {
        if (!f9581d && !b.f9663d) {
            throw new AssertionError();
        }
        synchronized (f9588k) {
            for (String str : f9589l) {
                Object[] objArr = f9588k.get(str);
                int intValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & intValue) != 0) {
                    JNIBridge.nativeAddDumpFile(str, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), intValue, ((Boolean) objArr[4]).booleanValue());
                }
            }
        }
    }

    public static String h() {
        StringBuilder sb = new StringBuilder();
        synchronized (f9588k) {
            boolean z10 = true;
            for (String str : f9589l) {
                if (LogType.isForJava(((Integer) f9588k.get(str)[0]).intValue())) {
                    if (!z10) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z10 = false;
                }
            }
        }
        return sb.toString();
    }

    public static void i() {
        if (!f9581d && !b.f9663d) {
            throw new AssertionError();
        }
        synchronized (f9594q) {
            for (String str : f9595r) {
                Object[] objArr = f9594q.get(str);
                int intValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & intValue) != 0) {
                    JNIBridge.nativeAddCallbackInfo(str, intValue, ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                }
            }
        }
    }

    public static String j() {
        String sb;
        synchronized (f9594q) {
            StringBuilder sb2 = new StringBuilder();
            List<String> list = f9595r;
            synchronized (list) {
                boolean z10 = true;
                for (String str : list) {
                    if (LogType.isForJava(((Integer) f9594q.get(str)[0]).intValue())) {
                        if (!z10) {
                            sb2.append("`");
                        }
                        sb2.append(str);
                        z10 = false;
                    }
                }
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static void k() {
        if (!f9581d && !b.f9663d) {
            throw new AssertionError();
        }
        synchronized (A) {
            for (String str : B) {
                Object[] objArr = A.get(str);
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if ((1048577 & intValue2) != 0 && JNIBridge.nativeCreateCachedInfo(str, intValue, intValue2) != 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext() && JNIBridge.nativeAddCachedInfo(str, (String) it.next())) {
                    }
                }
            }
        }
    }

    public static String l() {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            boolean z10 = true;
            for (String str : B) {
                if (LogType.isForJava(((Integer) A.get(str)[1]).intValue())) {
                    if (!z10) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z10 = false;
                }
            }
        }
        return sb.toString();
    }

    public static String m() {
        if (!G) {
            String a10 = com.uc.crashsdk.a.b.a(b.m());
            f9584g = a10;
            G = true;
            if (a10 == null) {
                f9584g = "";
            }
        }
        return f9584g;
    }

    public static void n() {
        p();
        if (!H) {
            H = true;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(202));
        } else if (b.f9663d) {
            JNIBridge.set(128, f9584g);
        }
    }

    private static boolean o() {
        try {
            PackageInfo packageInfo = com.uc.crashsdk.a.g.a().getPackageManager().getPackageInfo(f9578a, 0);
            f9585h = packageInfo.versionName;
            f9587j = packageInfo.lastUpdateTime;
            f9586i = packageInfo.versionCode;
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.b(th);
            return false;
        }
    }

    private static void p() {
        if (!I && e.a()) {
            if (b.f9663d || !b.f9666g) {
                String format = String.format(Locale.US, "%s/%s/%s", g.U(), g.V(), g.W());
                com.uc.crashsdk.a.a.b("crashsdk", "UUID: " + e.q());
                com.uc.crashsdk.a.a.b("crashsdk", "Version: " + format);
                com.uc.crashsdk.a.a.b("crashsdk", "Process Name: " + e.h());
                I = true;
            }
        }
    }

    private static StringBuilder b(String str, boolean z10) {
        String a10;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr = f9594q.get(str);
            try {
                if (objArr == null) {
                    a10 = "Unknown callback: " + str;
                } else {
                    Callable callable = (Callable) objArr[1];
                    a10 = callable != null ? (String) callable.call() : d.a(str, z10);
                }
                if (a10 != null) {
                    sb.append(a10);
                }
            } catch (Throwable th) {
                sb.append("[DEBUG] Callback occurred new exception:\n");
                sb.append(Log.getStackTraceString(th));
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        return sb;
    }

    public static void a(String str, String str2) {
        Map<String, String> map = f9582e;
        synchronized (map) {
            if (!map.containsKey(str)) {
                f9583f.add(str);
            }
            map.put(str, str2);
            if (b.f9663d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            e.y();
        }
    }

    public static ArrayList<String> c(String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return null;
        }
        String[] split = str.split(";", 20);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : split) {
            if (!com.uc.crashsdk.a.g.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static void a(OutputStream outputStream, String str) {
        synchronized (f9582e) {
            for (String str2 : f9583f) {
                try {
                    StringBuilder sb = new StringBuilder(11);
                    sb.append(str2);
                    sb.append(": ");
                    String str3 = f9582e.get(str2);
                    if (str3 != null) {
                        sb.append(str3);
                    }
                    sb.append("\n");
                    outputStream.write(sb.toString().getBytes(str));
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
            }
        }
    }

    public static int b(String str, String str2) {
        int i10;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, 2048);
        }
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            if (objArr != null) {
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (list.size() >= intValue) {
                    list.remove(0);
                }
                list.add(str2);
                r0 = LogType.isForJava(intValue2) ? LogType.addType(0, 16) : 0;
                if (!b.f9663d) {
                    if (LogType.isForNative(intValue2)) {
                        r0 = LogType.addType(r0, 1);
                    }
                    if (LogType.isForANR(intValue2)) {
                        r0 = LogType.addType(r0, LogType.ANR);
                    }
                }
                i10 = r0;
                r0 = intValue2;
            } else {
                i10 = 0;
            }
            if (b.f9663d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                if (LogType.isForNative(r0)) {
                    i10 = LogType.addType(i10, 1);
                }
                if (LogType.isForANR(r0)) {
                    i10 = LogType.addType(i10, LogType.ANR);
                }
            }
        }
        return i10;
    }

    public static int a(String str, String str2, boolean z10, boolean z11, int i10, boolean z12) {
        int i11;
        int i12;
        boolean z13;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        HashMap<String, Object[]> hashMap = f9588k;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i12 = ((Integer) hashMap.get(str)[0]).intValue();
                i11 = LogType.addType(i12, i10);
            } else {
                i11 = i10;
                i12 = 0;
            }
            if (LogType.isForJava(i11) && !LogType.isForJava(i12)) {
                int i13 = f9590m;
                if (i13 >= 10) {
                    i11 = LogType.removeType(i11, 16);
                } else {
                    f9590m = i13 + 1;
                }
            }
            if (LogType.isForNative(i11) && !LogType.isForNative(i12)) {
                int i14 = f9591n;
                if (i14 >= 10) {
                    i11 = LogType.removeType(i11, 1);
                } else {
                    f9591n = i14 + 1;
                }
            }
            if (LogType.isForUnexp(i11) && !LogType.isForUnexp(i12)) {
                int i15 = f9592o;
                if (i15 >= 10) {
                    i11 = LogType.removeType(i11, 256);
                } else {
                    f9592o = i15 + 1;
                }
            }
            if (LogType.isForANR(i11) && !LogType.isForANR(i12)) {
                int i16 = f9593p;
                if (i16 >= 10) {
                    i11 = LogType.removeType(i11, LogType.ANR);
                } else {
                    f9593p = i16 + 1;
                }
            }
            if ((1048849 & i11) == 0) {
                z13 = false;
            } else {
                if (i12 == 0) {
                    f9589l.add(str);
                }
                z13 = true;
            }
            if (!z13) {
                return i11;
            }
            if (b.f9663d && (1048833 & i10) != 0) {
                int nativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z10, z11, i10, z12);
                if (!LogType.isForNative(nativeAddDumpFile)) {
                    i11 = LogType.removeType(i11, 1);
                }
                if (!LogType.isForUnexp(nativeAddDumpFile)) {
                    i11 = LogType.removeType(i11, 256);
                }
                if (!LogType.isForANR(nativeAddDumpFile)) {
                    i11 = LogType.removeType(i11, LogType.ANR);
                }
            }
            hashMap.put(str, new Object[]{Integer.valueOf(i11), str2, Boolean.valueOf(z10), Boolean.valueOf(z11), Boolean.valueOf(z12)});
            return i11;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:7|(3:34|35|(4:37|38|39|24))(3:9|10|(2:33|24))|12|13|15|16|(2:19|17)|20|21|23|24|5) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a3, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:
    
        com.uc.crashsdk.e.a(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008d, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        com.uc.crashsdk.e.a(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
    
        com.uc.crashsdk.e.a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        synchronized (A) {
            for (String str3 : B) {
                Object[] objArr = A.get(str3);
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (arrayList == null) {
                    if (!LogType.isForJava(intValue2)) {
                    }
                } else if (!a(arrayList, str3)) {
                }
                outputStream.write(String.format(Locale.US, "%s (%d/%d)\n", str3, Integer.valueOf(list.size()), Integer.valueOf(intValue)).getBytes(str));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    outputStream.write(((String) it.next()).getBytes(str));
                    outputStream.write("\n".getBytes(str));
                }
                outputStream.write("\n".getBytes(str));
                outputStream.write(str2.getBytes(str));
            }
            if (arrayList != null && e.F()) {
                Iterator<String> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (!a(B, next)) {
                        e.a(outputStream, "CUSTOMCACHEDINFO", next);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #2 {all -> 0x00d7, blocks: (B:12:0x0025, B:69:0x002f, B:22:0x0045, B:24:0x0050, B:15:0x003e), top: B:11:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0 A[Catch: all -> 0x00d3, TryCatch #0 {all -> 0x00d3, blocks: (B:33:0x007f, B:37:0x009b, B:39:0x00a3, B:57:0x00b0, B:59:0x00b5), top: B:32:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b5 A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #0 {all -> 0x00d3, blocks: (B:33:0x007f, B:37:0x009b, B:39:0x00a3, B:57:0x00b0, B:59:0x00b5), top: B:32:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(OutputStream outputStream, String str, ArrayList<String> arrayList) {
        int i10;
        boolean booleanValue;
        String str2;
        boolean booleanValue2;
        int b10;
        File file;
        boolean z10 = arrayList == null;
        boolean F2 = e.F();
        synchronized (f9588k) {
            int i11 = 0;
            for (String str3 : f9589l) {
                try {
                    Object[] objArr = f9588k.get(str3);
                    if (arrayList == null) {
                        if (LogType.isForJava(((Integer) objArr[0]).intValue())) {
                            if (!((Boolean) objArr[3]).booleanValue()) {
                                try {
                                    outputStream.write((str3 + "\n").getBytes(str));
                                } catch (Throwable th) {
                                    th = th;
                                    e.a(th, outputStream);
                                }
                            }
                            i10 = i11 <= 153600 ? 153600 : i11;
                            try {
                                int min = Math.min(20480, 153600 - i10);
                                booleanValue = ((Boolean) objArr[2]).booleanValue();
                                str2 = (String) objArr[1];
                                booleanValue2 = ((Boolean) objArr[4]).booleanValue();
                                if (F2 || str2.startsWith("/proc/")) {
                                    if (!booleanValue) {
                                        b10 = e.a(outputStream, str2, min);
                                    } else {
                                        b10 = e.b(outputStream, str2, min);
                                    }
                                    i10 += b10;
                                } else {
                                    e.a(outputStream, "FILE", str2, min, booleanValue, booleanValue2);
                                }
                                i11 = i10;
                                if (booleanValue2 && z10 && !F2) {
                                    file = new File(str2);
                                    if (!file.exists()) {
                                        file.delete();
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                i11 = i10;
                                e.a(th, outputStream);
                            }
                        }
                    } else if (a(arrayList, str3)) {
                        if (!((Boolean) objArr[3]).booleanValue()) {
                        }
                        if (i11 <= 153600) {
                        }
                        int min2 = Math.min(20480, 153600 - i10);
                        booleanValue = ((Boolean) objArr[2]).booleanValue();
                        str2 = (String) objArr[1];
                        booleanValue2 = ((Boolean) objArr[4]).booleanValue();
                        if (F2) {
                        }
                        if (!booleanValue) {
                        }
                        i10 += b10;
                        i11 = i10;
                        if (booleanValue2) {
                            file = new File(str2);
                            if (!file.exists()) {
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (arrayList != null && F2) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!a(f9589l, next)) {
                        e.a(outputStream, "CUSTOMDUMPFILE", next);
                    }
                }
            }
        }
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            int intValue = ((Integer) objArr[0]).intValue();
            List list = (List) objArr[2];
            sb.append(String.format(Locale.US, "%s (%d/%d)\n", str, Integer.valueOf(list.size()), Integer.valueOf(intValue)));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static String a(String str) {
        HashMap<String, Object[]> hashMap = f9588k;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            if (objArr == null) {
                return null;
            }
            int i10 = 1;
            String str2 = (String) objArr[1];
            boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[3]).booleanValue();
            Locale locale = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = str2;
            objArr2[1] = "`";
            objArr2[2] = Integer.valueOf(booleanValue ? 1 : 0);
            if (!booleanValue2) {
                i10 = 0;
            }
            objArr2[3] = Integer.valueOf(i10);
            return String.format(locale, "%s%s%d%d", objArr2);
        }
    }

    private static boolean a(List<String> list, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d0 A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d5 A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ed A[Catch: all -> 0x015a, DONT_GENERATE, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ef A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(String str, int i10, Callable<String> callable, long j10, int i11) {
        int i12;
        int i13;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i14;
        boolean z15;
        boolean z16;
        if (str == null) {
            return 0;
        }
        HashMap<String, Object[]> hashMap = f9594q;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i13 = ((Integer) hashMap.get(str)[0]).intValue();
                i12 = LogType.addType(i13, i10);
                if (i13 == i12) {
                    return i13;
                }
            } else {
                i12 = i10;
                i13 = 0;
            }
            if (LogType.isForJava(i12) && !LogType.isForJava(i13)) {
                int i15 = f9596s;
                if (i15 < 8) {
                    if (j10 != 0) {
                        int i16 = f9600w;
                        if (i16 < 6) {
                            f9600w = i16 + 1;
                            f9596s = i15 + 1;
                            z16 = false;
                        }
                    } else {
                        if (i15 - f9600w >= 6) {
                        }
                        f9596s = i15 + 1;
                        z16 = false;
                    }
                    if (z16) {
                        i12 = LogType.removeType(i12, 16);
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
            if (!LogType.isForNative(i12) || LogType.isForNative(i13)) {
                z10 = false;
                z11 = false;
            } else {
                int i17 = f9597t;
                if (i17 < 6) {
                    if (j10 != 0) {
                        int i18 = f9601x;
                        if (i18 < 4) {
                            f9601x = i18 + 1;
                            f9597t = i17 + 1;
                            z15 = false;
                            z10 = true;
                            z11 = true;
                            if (z15) {
                                i12 = LogType.removeType(i12, 1);
                            }
                        }
                    } else if (i17 - f9601x < 4) {
                        f9597t = i17 + 1;
                        z15 = false;
                        z10 = true;
                        z11 = false;
                        if (z15) {
                        }
                    }
                }
                z15 = true;
                z10 = false;
                z11 = false;
                if (z15) {
                }
            }
            if (LogType.isForANR(i12) && !LogType.isForANR(i13)) {
                int i19 = f9599v;
                if (i19 >= 6) {
                    i12 = LogType.removeType(i12, LogType.ANR);
                } else {
                    f9599v = i19 + 1;
                    z12 = true;
                    if (LogType.isForUnexp(i12) && !LogType.isForUnexp(i13)) {
                        i14 = f9598u;
                        if (i14 < 6) {
                            i12 = LogType.removeType(i12, 256);
                        } else {
                            f9598u = i14 + 1;
                            z13 = true;
                            if ((1048849 & i12) == 0) {
                                z14 = false;
                            } else {
                                if (i13 == 0) {
                                    f9595r.add(str);
                                }
                                z14 = true;
                            }
                            if (!z14) {
                                return i12;
                            }
                            if (b.f9663d && (1048833 & i10) != 0) {
                                int nativeAddCallbackInfo = JNIBridge.nativeAddCallbackInfo(str, i10, j10, i11);
                                if (!LogType.isForNative(nativeAddCallbackInfo)) {
                                    i12 = LogType.removeType(i12, 1);
                                    if (z10) {
                                        f9597t--;
                                    }
                                    if (z11) {
                                        f9601x--;
                                    }
                                }
                                if (!LogType.isForANR(nativeAddCallbackInfo)) {
                                    i12 = LogType.removeType(i12, LogType.ANR);
                                    if (z12) {
                                        f9599v--;
                                    }
                                }
                                if (!LogType.isForUnexp(nativeAddCallbackInfo)) {
                                    i12 = LogType.removeType(i12, 256);
                                    if (z13) {
                                        f9598u--;
                                    }
                                }
                            }
                            hashMap.put(str, new Object[]{Integer.valueOf(i12), callable, Long.valueOf(j10), Integer.valueOf(i11)});
                            return i12;
                        }
                    }
                    z13 = false;
                    if ((1048849 & i12) == 0) {
                    }
                    if (!z14) {
                    }
                }
            }
            z12 = false;
            if (LogType.isForUnexp(i12)) {
                i14 = f9598u;
                if (i14 < 6) {
                }
            }
            z13 = false;
            if ((1048849 & i12) == 0) {
            }
            if (!z14) {
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:7|(2:8|9)|(3:35|36|(4:39|40|41|17)(1:38))(3:11|12|(4:14|15|16|17)(1:18))|19|(1:21)(1:34)|(1:33)(1:25)|26|27|29|17|5) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
    
        com.uc.crashsdk.e.a(r2, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        Object[] objArr;
        int intValue;
        String sb;
        synchronized (f9594q) {
            for (String str3 : f9595r) {
                try {
                    objArr = f9594q.get(str3);
                    intValue = ((Integer) objArr[0]).intValue();
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
                if (arrayList == null) {
                    if (!LogType.isForJava(intValue)) {
                    }
                } else if (!a(arrayList, str3)) {
                }
                outputStream.write((str3 + "\n").getBytes(str));
                long longValue = ((Long) objArr[2]).longValue();
                if (longValue != 0) {
                    sb = JNIBridge.nativeGetCallbackInfo(str3, longValue, ((Integer) objArr[3]).intValue(), false);
                } else {
                    sb = b(str3, false).toString();
                }
                if (sb != null && sb.length() > 0) {
                    outputStream.write(sb.getBytes(str));
                } else {
                    outputStream.write("(data is null)\n".getBytes(str));
                }
                outputStream.write("\n".getBytes(str));
                outputStream.write(str2.getBytes(str));
            }
            if (arrayList != null && e.F()) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!a(f9595r, next)) {
                        e.a(outputStream, "CUSTOMCALLBACKINFO", next);
                    }
                }
            }
        }
    }

    public static String a(String str, boolean z10) {
        String sb;
        HashMap<String, Object[]> hashMap = f9594q;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            long longValue = ((Long) objArr[2]).longValue();
            if (longValue != 0) {
                sb = JNIBridge.nativeGetCallbackInfo(str, longValue, ((Integer) objArr[3]).intValue(), z10);
            } else {
                sb = b(str, z10).toString();
            }
        }
        return sb;
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        SparseArray<Object[]> sparseArray = f9602y;
        synchronized (sparseArray) {
            int id = (int) thread.getId();
            if (sparseArray.get(id) == null) {
                f9603z.add(Integer.valueOf(id));
            }
            sparseArray.put(id, new Object[]{new WeakReference(thread), str});
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ca A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:30:0x00c3, B:32:0x00ca, B:33:0x00d3, B:35:0x00d8, B:37:0x00dc, B:38:0x00e5), top: B:29:0x00c3, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d8 A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:30:0x00c3, B:32:0x00ca, B:33:0x00d3, B:35:0x00d8, B:37:0x00dc, B:38:0x00e5), top: B:29:0x00c3, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(OutputStream outputStream, String str, String str2) {
        Thread thread;
        Throwable th;
        String str3;
        StackTraceElement[] stackTrace;
        int length;
        int i10;
        Object[] objArr;
        synchronized (f9602y) {
            Thread currentThread = Thread.currentThread();
            Iterator<Integer> it = f9603z.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                try {
                    objArr = f9602y.get(intValue);
                } catch (Throwable th2) {
                    thread = null;
                    th = th2;
                    str3 = null;
                }
                if (objArr != null) {
                    thread = (Thread) ((WeakReference) objArr[0]).get();
                    try {
                        str3 = (String) objArr[1];
                    } catch (Throwable th3) {
                        str3 = null;
                        th = th3;
                    }
                    if (thread == null) {
                        try {
                            com.uc.crashsdk.a.a.b("Thread (" + str3 + ", " + intValue + ") has exited!");
                        } catch (Throwable th4) {
                            th = th4;
                            e.a(th, outputStream);
                            try {
                                Locale locale = Locale.US;
                                outputStream.write(String.format(locale, "Thread Name: '%s'\n", str3).getBytes(str));
                                outputStream.write(String.format(locale, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), !thread.isDaemon() ? " daemon" : "", Integer.valueOf(thread.getPriority()), Integer.valueOf(intValue), thread.getState().toString()).getBytes(str));
                            } catch (Throwable th5) {
                                e.a(th5, outputStream);
                            }
                            try {
                                stackTrace = thread.getStackTrace();
                                if (stackTrace.length == 0) {
                                }
                                length = stackTrace.length;
                                i10 = 0;
                                boolean z10 = true;
                                while (i10 < length) {
                                }
                            } catch (Throwable th6) {
                                e.a(th6, outputStream);
                            }
                            try {
                                outputStream.write("\n".getBytes(str));
                                outputStream.write(str2.getBytes(str));
                            } catch (Throwable th7) {
                                e.a(th7, outputStream);
                            }
                        }
                    } else {
                        if (currentThread == thread) {
                        }
                        Locale locale2 = Locale.US;
                        outputStream.write(String.format(locale2, "Thread Name: '%s'\n", str3).getBytes(str));
                        outputStream.write(String.format(locale2, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), !thread.isDaemon() ? " daemon" : "", Integer.valueOf(thread.getPriority()), Integer.valueOf(intValue), thread.getState().toString()).getBytes(str));
                        stackTrace = thread.getStackTrace();
                        if (stackTrace.length == 0) {
                            outputStream.write("  (no stack frames)".getBytes(str));
                        }
                        length = stackTrace.length;
                        i10 = 0;
                        boolean z102 = true;
                        while (i10 < length) {
                            StackTraceElement stackTraceElement = stackTrace[i10];
                            if (!z102) {
                                outputStream.write("\n".getBytes(str));
                            }
                            outputStream.write(String.format(Locale.US, "  at %s", stackTraceElement.toString()).getBytes(str));
                            i10++;
                            z102 = false;
                        }
                        outputStream.write("\n".getBytes(str));
                        outputStream.write(str2.getBytes(str));
                    }
                }
            }
        }
    }

    public static int a(String str, int i10, int i11) {
        int i12;
        int i13;
        boolean z10;
        if (str == null || i10 <= 0) {
            return 0;
        }
        if (i10 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i13 = ((Integer) hashMap.get(str)[1]).intValue();
                i12 = LogType.addType(i13, i11);
            } else {
                i12 = i11;
                i13 = 0;
            }
            if (LogType.isForJava(i12) && !LogType.isForJava(i13)) {
                int i14 = C;
                if (i14 >= 8) {
                    i12 = LogType.removeType(i12, 16);
                } else {
                    C = i14 + 1;
                }
            }
            if (LogType.isForNative(i12) && !LogType.isForNative(i13)) {
                int i15 = D;
                if (i15 >= 8) {
                    i12 = LogType.removeType(i12, 1);
                } else {
                    D = i15 + 1;
                }
            }
            if (LogType.isForANR(i12) && !LogType.isForANR(i13)) {
                int i16 = E;
                if (i16 >= 8) {
                    i12 = LogType.removeType(i12, LogType.ANR);
                } else {
                    E = i16 + 1;
                }
            }
            if ((1048849 & i12) == 0) {
                z10 = false;
            } else {
                if (i13 == 0) {
                    B.add(str);
                }
                z10 = true;
            }
            if (!z10) {
                return i12;
            }
            if (b.f9663d && (i11 & 1048577) != 0) {
                int nativeCreateCachedInfo = JNIBridge.nativeCreateCachedInfo(str, i10, i12);
                if (!LogType.isForNative(nativeCreateCachedInfo)) {
                    i12 = LogType.removeType(i12, 1);
                }
                if (!LogType.isForANR(nativeCreateCachedInfo)) {
                    i12 = LogType.removeType(i12, LogType.ANR);
                }
            }
            hashMap.put(str, new Object[]{Integer.valueOf(i10), Integer.valueOf(i12), new ArrayList()});
            return i12;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(int i10, String str) {
        ?? r02;
        if (com.uc.crashsdk.a.g.a(str)) {
            str = Thread.currentThread().getName();
        }
        if (LogType.isForNative(i10) || LogType.isForANR(i10)) {
            if (b.f9663d) {
                synchronized (f9602y) {
                    JNIBridge.nativeCmd(4, i10, str, null);
                }
                boolean isForNative = LogType.isForNative(i10);
                r02 = isForNative;
                if (LogType.isForANR(i10)) {
                    r02 = (isForNative ? 1 : 0) | LogType.ANR;
                }
                if (LogType.isForJava(i10)) {
                    return r02;
                }
                a(str, Thread.currentThread());
                return r02 | 16;
            }
            com.uc.crashsdk.a.a.a("crashsdk", "crashsdk so has not loaded!", null);
        }
        r02 = 0;
        if (LogType.isForJava(i10)) {
        }
    }

    public static boolean a(boolean z10) {
        int H2;
        if (!b.f9662c) {
            com.uc.crashsdk.a.a.a("crashsdk", "Unexp log not enabled, skip update unexp info!");
            return false;
        }
        if (e.F() || b.L()) {
            return false;
        }
        if (z10) {
            com.uc.crashsdk.a.f.a(F);
            H2 = 0;
        } else {
            if (!b.B()) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stop update unexp info in background!");
                return false;
            }
            if (g.H() <= 0) {
                return false;
            }
            if (com.uc.crashsdk.a.f.b(F)) {
                return true;
            }
            H2 = g.H() * 1000;
        }
        com.uc.crashsdk.a.f.a(0, F, H2);
        return true;
    }

    public static void a(int i10) {
        if (i10 == 201) {
            com.uc.crashsdk.a.a.a("crashsdk", "Begin update info ...");
            long currentTimeMillis = System.currentTimeMillis();
            if (b.f9663d && f9580c) {
                JNIBridge.nativeCmd(11, g.H(), String.valueOf(g.I()), null);
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Update info took " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            a(false);
            return;
        }
        if (i10 != 202) {
            if (!f9581d) {
                throw new AssertionError();
            }
            return;
        }
        p();
        Locale locale = Locale.US;
        String format = String.format(locale, "%s/%s/%s", g.U(), g.V(), g.W());
        f9584g = m();
        if (b.f9663d) {
            JNIBridge.set(128, f9584g);
        }
        boolean z10 = !format.equals(f9584g);
        if (z10) {
            com.uc.crashsdk.a.b.a(b.m(), format);
        }
        if (z10 && g.v()) {
            com.uc.crashsdk.a.a.a("crashsdk", String.format(locale, "Is new version ('%s' -> '%s'), deleting old stats data!", f9584g, format));
            b.v();
        }
    }
}
