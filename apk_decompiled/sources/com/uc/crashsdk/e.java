package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.common.utils.ContextPath;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.upnp.UPnPStatus;
import com.hpplay.cybergarage.upnp.ssdp.SSDP;
import com.hpplay.sdk.source.common.global.Constant;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.LogType;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class e implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f9695a = true;

    /* renamed from: b, reason: collision with root package name */
    private static long f9698b;

    /* renamed from: i, reason: collision with root package name */
    private static String f9704i;

    /* renamed from: e, reason: collision with root package name */
    private final List<FileInputStream> f9722e = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f9699c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static boolean f9700d = false;

    /* renamed from: f, reason: collision with root package name */
    private static long f9701f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static long f9702g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f9703h = true;

    /* renamed from: j, reason: collision with root package name */
    private static String f9705j = "";

    /* renamed from: k, reason: collision with root package name */
    private static String f9706k = null;

    /* renamed from: l, reason: collision with root package name */
    private static String f9707l = null;

    /* renamed from: m, reason: collision with root package name */
    private static String f9708m = null;

    /* renamed from: n, reason: collision with root package name */
    private static final Object f9709n = new Object();

    /* renamed from: o, reason: collision with root package name */
    private static final ConditionVariable f9710o = new ConditionVariable();

    /* renamed from: p, reason: collision with root package name */
    private static final Object f9711p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private static final Object f9712q = new Object();

    /* renamed from: r, reason: collision with root package name */
    private static final Object f9713r = new Object();

    /* renamed from: s, reason: collision with root package name */
    private static final ArrayList<String> f9714s = new ArrayList<>();

    /* renamed from: t, reason: collision with root package name */
    private static int f9715t = 0;

    /* renamed from: u, reason: collision with root package name */
    private static String f9716u = null;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f9717v = false;

    /* renamed from: w, reason: collision with root package name */
    private static String f9718w = null;

    /* renamed from: x, reason: collision with root package name */
    private static String f9719x = null;

    /* renamed from: y, reason: collision with root package name */
    private static final Object f9720y = new Object();

    /* renamed from: z, reason: collision with root package name */
    private static final Object f9721z = new Object();
    private static Map<String, Integer> A = null;
    private static String B = null;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static int I = -1;
    private static String J = Operator.Operation.EMPTY_PARAM;
    private static boolean K = false;
    private static boolean L = false;
    private static int M = 0;
    private static int N = 0;
    private static boolean O = false;
    private static com.uc.crashsdk.a.e P = new com.uc.crashsdk.a.e(405);
    private static c Q = new c(0);
    private static boolean R = false;
    private static final com.uc.crashsdk.a.e S = new com.uc.crashsdk.a.e(412);
    private static Thread.UncaughtExceptionHandler T = null;
    private static Throwable U = null;
    private static boolean V = false;
    private static boolean W = false;
    private static Runnable X = null;
    private static final Object Y = new Object();
    private static int Z = 101;

    /* renamed from: aa, reason: collision with root package name */
    private static Runnable f9696aa = new com.uc.crashsdk.a.e(407);

    /* renamed from: ab, reason: collision with root package name */
    private static final Object f9697ab = new Object();
    private static volatile boolean ac = false;
    private static Object ad = new Object();
    private static ParcelFileDescriptor ae = null;
    private static boolean af = false;
    private static boolean ag = false;

    public static class b implements Comparator<File> {
        private b() {
        }

        public /* synthetic */ b(byte b10) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }
    }

    public static class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.intent.action.BATTERY_CHANGED".equals(action)) {
                if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                    boolean unused = e.K = "android.intent.action.BATTERY_LOW".equals(action);
                    e.K();
                    return;
                } else {
                    if ("android.intent.action.ANR".equals(action)) {
                        try {
                            e.d(context);
                            return;
                        } catch (Throwable th) {
                            com.uc.crashsdk.a.g.a(th);
                            return;
                        }
                    }
                    return;
                }
            }
            int unused2 = e.C = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int unused3 = e.D = intent.getIntExtra("scale", -1);
            int unused4 = e.E = intent.getIntExtra("voltage", -1);
            int unused5 = e.F = intent.getIntExtra("health", -1);
            int unused6 = e.G = intent.getIntExtra("plugged", -1);
            int unused7 = e.H = intent.getIntExtra(Constant.KEY_STATUS, -1);
            int unused8 = e.I = intent.getIntExtra("temperature", -1);
            String unused9 = e.J = intent.getStringExtra("technology");
            if (e.J() >= 2) {
                e.K();
                e.L();
            }
        }

        public /* synthetic */ c(byte b10) {
            this();
        }
    }

    public e() {
        try {
            M();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void A() {
        if (g.r()) {
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(UPnPStatus.OUT_OF_SYNC), NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
        }
    }

    public static void B() {
        if (ac || com.uc.crashsdk.b.L()) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(408), 1000L);
    }

    public static void C() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(409), 7000L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x003f, code lost:
    
        if ((java.lang.System.currentTimeMillis() % 3) == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        if (r0 == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        r4 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void D() {
        /*
            int r0 = com.uc.crashsdk.g.O()
            r1 = 4
            r2 = 3
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L13
            if (r0 == r2) goto L13
            if (r0 != r1) goto Lf
            goto L13
        Lf:
            if (r0 != r4) goto L43
        L11:
            r4 = 0
            goto L43
        L13:
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 21
            if (r5 < r6) goto L43
            r6 = 25
            if (r5 > r6) goto L43
            if (r0 != 0) goto L21
            r5 = 0
            goto L22
        L21:
            r5 = 1
        L22:
            r6 = 0
            if (r0 != r2) goto L34
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 10
            long r8 = r8 % r10
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 != 0) goto L33
            r5 = 1
            goto L34
        L33:
            r5 = 0
        L34:
            if (r0 != r1) goto L42
            long r0 = java.lang.System.currentTimeMillis()
            r8 = 3
            long r0 = r0 % r8
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 != 0) goto L11
            goto L43
        L42:
            r4 = r5
        L43:
            if (r4 != 0) goto L4c
            java.lang.String r0 = "crashsdk"
            java.lang.String r1 = "SIG 3 is disabled by settings"
            com.uc.crashsdk.a.a.a(r0, r1)
        L4c:
            boolean r0 = com.uc.crashsdk.b.L()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            android.os.Looper r2 = android.os.Looper.myLooper()
            if (r1 == r2) goto L68
            if (r4 == 0) goto L68
            com.uc.crashsdk.a.e r1 = new com.uc.crashsdk.a.e
            r2 = 413(0x19d, float:5.79E-43)
            r1.<init>(r2)
            r2 = 2
            com.uc.crashsdk.a.f.a(r2, r1)
            goto L69
        L68:
            r3 = r4
        L69:
            r1 = 7
            long r4 = (long) r0
            r0 = 0
            com.uc.crashsdk.JNIBridge.nativeCmd(r1, r4, r0, r0)
            if (r3 == 0) goto L76
            r0 = 8
            com.uc.crashsdk.JNIBridge.cmd(r0)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.D():void");
    }

    public static ParcelFileDescriptor E() {
        if (!com.uc.crashsdk.b.f9663d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        synchronized (ad) {
            ParcelFileDescriptor parcelFileDescriptor = ae;
            if (parcelFileDescriptor != null) {
                return parcelFileDescriptor;
            }
            int cmd = (int) JNIBridge.cmd(14);
            if (cmd == -1) {
                return null;
            }
            ParcelFileDescriptor adoptFd = ParcelFileDescriptor.adoptFd(cmd);
            ae = adoptFd;
            af = true;
            return adoptFd;
        }
    }

    public static boolean F() {
        return ag;
    }

    public static void G() {
        String Y2 = g.Y();
        File file = new File(Y2);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + Y2);
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    a(false, false);
                    return;
                }
            }
        }
    }

    public static /* synthetic */ int J() {
        int i10 = M + 1;
        M = i10;
        return i10;
    }

    public static /* synthetic */ void K() {
        StringBuilder Y2;
        if (com.uc.crashsdk.b.f9663d && (Y2 = Y()) != null) {
            JNIBridge.set(125, Y2.toString());
        }
        L = true;
        Z();
    }

    public static /* synthetic */ int L() {
        M = 0;
        return 0;
    }

    private void M() {
        int J2 = g.J();
        for (int i10 = 0; i10 < J2; i10++) {
            try {
                this.f9722e.add(new FileInputStream("/dev/null"));
            } catch (Exception e10) {
                com.uc.crashsdk.a.g.a(e10);
                return;
            }
        }
    }

    private void N() {
        Iterator<FileInputStream> it = this.f9722e.iterator();
        while (it.hasNext()) {
            com.uc.crashsdk.a.g.a(it.next());
        }
        this.f9722e.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean O() {
        if (g.Q()) {
            return true;
        }
        return a();
    }

    private static String P() {
        return g.e() + "_";
    }

    private static String Q() {
        return com.uc.crashsdk.b.B() ? "fg" : "bg";
    }

    private static byte[] R() {
        byte[] bArr = null;
        int i10 = 1024;
        while (bArr == null && i10 > 0) {
            try {
                bArr = new byte[i10];
            } catch (Throwable unused) {
                i10 /= 2;
                if (i10 < 16) {
                    break;
                }
            }
        }
        return bArr;
    }

    private static String S() {
        return (!com.uc.crashsdk.b.F() || f9700d) ? LogType.JAVA_TYPE : "ucebujava";
    }

    private static void T() {
        String str;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String str2 = Operator.Operation.MINUS;
        try {
            str = Build.HARDWARE;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            str = Operator.Operation.MINUS;
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i10 = 0;
                do {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("Hardware")) {
                            str = readLine.substring(readLine.indexOf(SOAP.DELIM) + 1).trim();
                        } else if (readLine.startsWith("Processor")) {
                            str2 = readLine.substring(readLine.indexOf(SOAP.DELIM) + 1).trim();
                        }
                        i10++;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            com.uc.crashsdk.a.g.a(th);
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            f9706k = str;
                            f9707l = str2;
                        } catch (Throwable th4) {
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            throw th4;
                        }
                    }
                } while (i10 < 2);
                com.uc.crashsdk.a.g.a(fileReader);
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            th = th6;
            fileReader = null;
        }
        com.uc.crashsdk.a.g.a(bufferedReader);
        f9706k = str;
        f9707l = str2;
    }

    private static String U() {
        return g.X() + HTTP.CONTENT_RANGE_BYTES;
    }

    private static boolean V() {
        return Build.VERSION.SDK_INT < 29;
    }

    private static void W() {
        if (O || com.uc.crashsdk.b.F() || com.uc.crashsdk.b.L()) {
            return;
        }
        JNIBridge.cmd(18);
    }

    private static void X() {
        com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(414), 1000L);
    }

    private static StringBuilder Y() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(C);
            sb.append("\n");
            sb.append("scale: ");
            sb.append(D);
            sb.append("\n");
            switch (F) {
                case 1:
                    str = " (Unknown)";
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(F);
            sb.append(str);
            sb.append("\n");
            int i10 = G;
            String str2 = i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)";
            sb.append("pluged: ");
            sb.append(G);
            sb.append(str2);
            sb.append("\n");
            int i11 = H;
            String str3 = i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)" : " (Unknown)";
            sb.append("status: ");
            sb.append(H);
            sb.append(str3);
            sb.append("\n");
            sb.append("voltage: ");
            sb.append(E);
            sb.append("\n");
            sb.append("temperature: ");
            sb.append(I);
            sb.append("\n");
            sb.append("technology: ");
            sb.append(J);
            sb.append("\n");
            sb.append("battery low: ");
            sb.append(K);
            sb.append("\n");
            return sb;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    private static void Z() {
        if (com.uc.crashsdk.b.f9662c && L && com.uc.crashsdk.a.f9580c) {
            L = false;
            if (com.uc.crashsdk.a.f.b(P)) {
                return;
            }
            com.uc.crashsdk.a.f.a(0, P, 2000L);
        }
    }

    public static boolean a() {
        if (f9701f == 0) {
            f9701f = 2L;
            if (h(com.uc.crashsdk.b.b("logs")) == 1) {
                f9701f = 1L;
            }
        }
        return f9701f == 1;
    }

    private static boolean aa() {
        return com.uc.crashsdk.b.f9663d && JNIBridge.nativeIsCrashing();
    }

    private static void ab() {
        String Z2 = g.Z();
        File file = new File(Z2);
        if (file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 150) {
                    Arrays.sort(listFiles, new b((byte) 0));
                    int length = listFiles.length - 150;
                    int i10 = length < 0 ? 0 : length;
                    long currentTimeMillis = System.currentTimeMillis();
                    int i11 = 0;
                    int i12 = 0;
                    int i13 = 0;
                    while (i11 < listFiles.length) {
                        File file2 = listFiles[i11];
                        boolean z10 = i11 < i10;
                        if (!z10 && currentTimeMillis - file2.lastModified() >= 432000000) {
                            z10 = true;
                        }
                        if (!z10) {
                            break;
                        }
                        try {
                            file2.delete();
                            i12++;
                            i13 = 0;
                        } catch (Throwable th) {
                            i13++;
                            com.uc.crashsdk.a.g.a(th);
                        }
                        if (i13 >= 3) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i12 + " logs in " + Z2);
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    public static long b() {
        if (f9702g == -1) {
            f9702g = h(com.uc.crashsdk.b.b("local"));
        }
        return f9702g;
    }

    private static String j(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(65536);
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", P(), g.U(), g.W(), i(Build.MODEL), i(Build.VERSION.RELEASE), str);
    }

    private static String k(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", d(), n(), Q(), str);
    }

    private static String l(String str) {
        if (!com.uc.crashsdk.a.g.b(str)) {
            return "";
        }
        int indexOf = str.indexOf(0);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return str.trim();
    }

    private static String m(String str) {
        String a10 = com.uc.crashsdk.a.b.a(str, g.x(), g.w());
        if (!str.equals(a10)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return a10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        if (r7.endsWith(r3) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
    
        if (r7.indexOf(".log", r7.lastIndexOf(95)) != r7.lastIndexOf(".log")) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean[] n(java.lang.String r7) {
        /*
            boolean r0 = com.uc.crashsdk.g.w()
            boolean r1 = com.uc.crashsdk.g.y()
            r2 = 0
            if (r0 != 0) goto Ld
            if (r1 == 0) goto L6d
        Ld:
            java.lang.String r3 = ".tmp"
            boolean r3 = r7.endsWith(r3)
            if (r3 != 0) goto L6b
            java.lang.String r3 = ".ec"
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L1e
            goto L6b
        L1e:
            char r3 = java.io.File.separatorChar
            int r3 = r7.lastIndexOf(r3)
            if (r3 >= 0) goto L27
            r3 = 0
        L27:
            r4 = 0
        L28:
            r5 = 95
            int r3 = r7.indexOf(r5, r3)
            if (r3 < 0) goto L34
            int r4 = r4 + 1
            int r3 = r3 + 1
        L34:
            if (r3 >= 0) goto L28
            r3 = 8
            if (r4 == r3) goto L3b
            goto L6b
        L3b:
            java.lang.String r3 = com.uc.crashsdk.g.x()
            java.lang.String r4 = ".log"
            boolean r6 = r7.endsWith(r4)
            if (r6 != 0) goto L54
            boolean r0 = com.uc.crashsdk.a.g.a(r3)
            if (r0 != 0) goto L6b
            boolean r7 = r7.endsWith(r3)
            if (r7 != 0) goto L5a
            goto L6b
        L54:
            boolean r3 = com.uc.crashsdk.a.g.a(r3)
            if (r3 == 0) goto L5c
        L5a:
            r0 = 0
            goto L6d
        L5c:
            int r3 = r7.lastIndexOf(r5)
            int r3 = r7.indexOf(r4, r3)
            int r7 = r7.lastIndexOf(r4)
            if (r3 == r7) goto L6d
            goto L5a
        L6b:
            r0 = 0
            r1 = 0
        L6d:
            r7 = 2
            boolean[] r7 = new boolean[r7]
            r7[r2] = r0
            r0 = 1
            r7[r0] = r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.n(java.lang.String):boolean[]");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:3|4|(3:6|(3:9|(1:11)(17:12|13|14|(13:48|49|18|(1:47)(1:21)|22|(1:24)|25|26|27|29|30|31|32)(1:16)|17|18|(0)|47|22|(0)|25|26|27|29|30|31|32)|7)|53)|54|(0)|25|26|27|29|30|31|32) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(3:6|(3:9|(1:11)(17:12|13|14|(13:48|49|18|(1:47)(1:21)|22|(1:24)|25|26|27|29|30|31|32)(1:16)|17|18|(0)|47|22|(0)|25|26|27|29|30|31|32)|7)|53)|26|27|29|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00dd, code lost:
    
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e2, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e5, code lost:
    
        com.uc.crashsdk.a.g.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00da, code lost:
    
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ea, code lost:
    
        com.uc.crashsdk.a.g.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ed, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ae A[Catch: all -> 0x00ee, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x0033, B:7:0x0041, B:9:0x0047, B:11:0x0051, B:13:0x0056, B:49:0x0068, B:18:0x0078, B:22:0x0083, B:24:0x00ae, B:31:0x00d5, B:32:0x00e8, B:43:0x00ea, B:44:0x00ed, B:39:0x00e5, B:52:0x0072), top: B:3:0x0005, inners: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean o(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.o(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ae A[Catch: all -> 0x0108, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:12:0x00ae, B:17:0x00d4, B:23:0x00ef, B:24:0x00df, B:38:0x00fc, B:41:0x0106, B:45:0x0033, B:47:0x003b, B:48:0x0044, B:50:0x004c, B:52:0x0054, B:54:0x005c, B:59:0x006a, B:61:0x0074, B:63:0x0081, B:65:0x008b, B:66:0x0096, B:68:0x00a0), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a0 A[Catch: all -> 0x0108, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:12:0x00ae, B:17:0x00d4, B:23:0x00ef, B:24:0x00df, B:38:0x00fc, B:41:0x0106, B:45:0x0033, B:47:0x003b, B:48:0x0044, B:50:0x004c, B:52:0x0054, B:54:0x005c, B:59:0x006a, B:61:0x0074, B:63:0x0081, B:65:0x008b, B:66:0x0096, B:68:0x00a0), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean p(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.p(java.lang.String):boolean");
    }

    private static Map<String, Integer> q(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\\|", 30)) {
            String[] split = str2.split(SOAP.DELIM, 3);
            if (split.length == 2) {
                String trim = split[0].trim();
                if (!com.uc.crashsdk.a.g.a(trim)) {
                    int i10 = 1;
                    try {
                        i10 = Integer.parseInt(split[1].trim(), 10);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                    hashMap.put(trim, Integer.valueOf(i10));
                }
            }
        }
        return hashMap;
    }

    private static void r(String str) {
        if (g.r()) {
            try {
                ab();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            if (str == null || "".equals(str)) {
                return;
            }
            try {
                File file = new File(g.Z());
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
                com.uc.crashsdk.a.g.a(new File(str), file);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    private static String s(String str) {
        return String.format("$^%s^$", str);
    }

    public static void t() {
        Thread.setDefaultUncaughtExceptionHandler(T);
    }

    public static boolean u() {
        return f9699c.get() || aa();
    }

    public static Throwable v() {
        return U;
    }

    public static int w() {
        if (com.uc.crashsdk.b.I() == 5) {
            return Z;
        }
        return 100;
    }

    public static void x() {
        long p10 = g.p();
        if (p10 < 0) {
            return;
        }
        boolean z10 = com.uc.crashsdk.b.I() == 5;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(401));
        if (z10) {
            com.uc.crashsdk.a.e eVar = new com.uc.crashsdk.a.e(402);
            X = eVar;
            com.uc.crashsdk.a.f.a(0, eVar, p10);
        }
    }

    public static void y() {
        if (com.uc.crashsdk.b.f9662c && com.uc.crashsdk.a.f9580c && !com.uc.crashsdk.a.f.b(f9696aa)) {
            com.uc.crashsdk.a.f.a(0, f9696aa, 1000L);
        }
    }

    public static boolean z() {
        synchronized (Y) {
            Runnable runnable = X;
            if (runnable == null || W) {
                return false;
            }
            com.uc.crashsdk.a.f.a(runnable);
            X = null;
            return true;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    public static String d() {
        String str = f9704i;
        if (str != null) {
            return str;
        }
        String j10 = j(null);
        f9704i = j10;
        return j10;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:30|(2:32|33)|34|35|36|(1:40)|41|(1:45)|47|48) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0141, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0142, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad A[Catch: all -> 0x00d1, TRY_LEAVE, TryCatch #1 {all -> 0x00d1, blocks: (B:28:0x0098, B:30:0x00ad), top: B:27:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:36:0x00d8, B:38:0x00de, B:40:0x00e6, B:41:0x010c, B:43:0x0112, B:45:0x011a), top: B:35:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0112 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:36:0x00d8, B:38:0x00de, B:40:0x00e6, B:41:0x010c, B:43:0x0112, B:45:0x011a), top: B:35:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e() {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e():java.lang.String");
    }

    public static String f() {
        if (com.uc.crashsdk.a.g.a(f9706k)) {
            T();
        }
        return f9706k;
    }

    private static long h(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return 0L;
    }

    private static String i(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", Operator.Operation.MINUS);
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static void s() {
        T = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new e());
    }

    public static void c() {
        f9704i = null;
    }

    public static boolean i() {
        return f9700d;
    }

    public static boolean b(int i10, Object[] objArr) {
        if (i10 == 451) {
            if (f9695a || objArr != null) {
                return a((String) objArr[0], (d) objArr[1]);
            }
            throw new AssertionError();
        }
        if (i10 != 452) {
            if (f9695a) {
                return false;
            }
            throw new AssertionError();
        }
        if (!f9695a && objArr == null) {
            throw new AssertionError();
        }
        String str = (String) objArr[0];
        d dVar = (d) objArr[1];
        return com.uc.crashsdk.a.g.a(new File(str), String.format(Locale.US, "%d %d %d %d", Long.valueOf(dVar.f9728a), Long.valueOf(dVar.f9729b), Integer.valueOf(dVar.f9730c), Integer.valueOf(dVar.f9731d)).getBytes());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void c(java.io.OutputStream r9) {
        /*
            java.lang.String r0 = "UTF-8"
            boolean r1 = com.uc.crashsdk.b.f9663d
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L3d
            java.lang.String r0 = com.uc.crashsdk.b.o()
            com.uc.crashsdk.e.f9703h = r2
            r1 = 17
            long r1 = com.uc.crashsdk.JNIBridge.cmd(r1, r0)
            r4 = 1
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 != 0) goto L3a
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            byte[] r0 = com.uc.crashsdk.a.g.e(r1)     // Catch: java.lang.Throwable -> L29
            if (r0 == 0) goto L2d
            r9.write(r0)     // Catch: java.lang.Throwable -> L29
            goto L2d
        L29:
            r0 = move-exception
            a(r0, r9)
        L2d:
            r1.delete()     // Catch: java.lang.Throwable -> L31
            goto L35
        L31:
            r0 = move-exception
            a(r0, r9)
        L35:
            com.uc.crashsdk.e.f9703h = r3
            a(r9)
        L3a:
            com.uc.crashsdk.e.f9703h = r3
            return
        L3d:
            r1 = 0
            int r4 = com.uc.crashsdk.g.K()     // Catch: java.lang.Throwable -> L7b
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L79
            java.lang.String r6 = "/proc/self/fd"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L79
            java.io.File[] r1 = r5.listFiles()     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto L6f
            java.util.Locale r5 = java.util.Locale.US     // Catch: java.lang.Throwable -> L79
            java.lang.String r6 = "opened file count: %d, write limit: %d.\n"
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L79
            int r8 = r1.length     // Catch: java.lang.Throwable -> L79
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L79
            r7[r2] = r8     // Catch: java.lang.Throwable -> L79
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L79
            r7[r3] = r8     // Catch: java.lang.Throwable -> L79
            java.lang.String r3 = java.lang.String.format(r5, r6, r7)     // Catch: java.lang.Throwable -> L79
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L79
            r9.write(r3)     // Catch: java.lang.Throwable -> L79
            goto L81
        L6f:
            java.lang.String r3 = "[DEBUG] listFiles failed!\n"
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L79
            r9.write(r3)     // Catch: java.lang.Throwable -> L79
            goto L81
        L79:
            r3 = move-exception
            goto L7e
        L7b:
            r3 = move-exception
            r4 = 900(0x384, float:1.261E-42)
        L7e:
            a(r3, r9)
        L81:
            if (r1 == 0) goto Lc8
            int r3 = r1.length     // Catch: java.lang.Throwable -> Lc4
            if (r3 < r4) goto Lc8
            java.lang.String r3 = "opened files:\n"
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> Lc4
            r9.write(r3)     // Catch: java.lang.Throwable -> Lc4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc4
            r3.<init>()     // Catch: java.lang.Throwable -> Lc4
            int r4 = r1.length     // Catch: java.lang.Throwable -> Lb4
        L95:
            if (r2 >= r4) goto Lb8
            r5 = r1[r2]     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = r5.getName()     // Catch: java.lang.Throwable -> Lb4
            r3.append(r6)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = " -> "
            r3.append(r6)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r5 = r5.getCanonicalPath()     // Catch: java.lang.Throwable -> Lb4
            r3.append(r5)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r5 = "\n"
            r3.append(r5)     // Catch: java.lang.Throwable -> Lb4
            int r2 = r2 + 1
            goto L95
        Lb4:
            r1 = move-exception
            a(r1, r9)     // Catch: java.lang.Throwable -> Lc4
        Lb8:
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> Lc4
            byte[] r0 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> Lc4
            r9.write(r0)     // Catch: java.lang.Throwable -> Lc4
            goto Lc8
        Lc4:
            r0 = move-exception
            a(r0, r9)
        Lc8:
            a(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.c(java.io.OutputStream):void");
    }

    public static String g() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) com.uc.crashsdk.a.g.a().getSystemService("activity");
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ");
                    sb.append(memoryInfo.availMem / 1024);
                    sb.append(" kB\n");
                    sb.append("threshold:  ");
                    sb.append(memoryInfo.threshold / 1024);
                    sb.append(" kB\n");
                    sb.append("lowMemory:  ");
                    sb.append(memoryInfo.lowMemory);
                    sb.append("\n");
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            return sb.toString();
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void d(java.io.OutputStream r12) {
        /*
            java.lang.String r0 = "UTF-8"
            r1 = 0
            r2 = 0
            int r3 = com.uc.crashsdk.g.L()     // Catch: java.lang.Throwable -> L1c
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L1a
            java.lang.String r5 = "/proc/self/task"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L1a
            java.io.File[] r1 = r4.listFiles()     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L16
            return
        L16:
            int r4 = r1.length     // Catch: java.lang.Throwable -> L1a
            if (r4 >= r3) goto L23
            return
        L1a:
            r4 = move-exception
            goto L1f
        L1c:
            r4 = move-exception
            r3 = 300(0x12c, float:4.2E-43)
        L1f:
            com.uc.crashsdk.a.g.a(r4)
            r4 = 0
        L23:
            if (r1 != 0) goto L26
            return
        L26:
            java.lang.String r5 = "threads info:\n"
            byte[] r5 = r5.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r5)     // Catch: java.lang.Throwable -> L8e
            java.util.Locale r5 = java.util.Locale.US     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = "threads count: %d, dump limit: %d.\n"
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L8e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L8e
            r8[r2] = r4     // Catch: java.lang.Throwable -> L8e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L8e
            r4 = 1
            r8[r4] = r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = java.lang.String.format(r5, r6, r8)     // Catch: java.lang.Throwable -> L8e
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r3)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = " tid     name\n"
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r3)     // Catch: java.lang.Throwable -> L8e
            int r3 = r1.length     // Catch: java.lang.Throwable -> L8e
            r5 = 0
        L59:
            if (r5 >= r3) goto L92
            r6 = r1[r5]     // Catch: java.lang.Throwable -> L8e
            java.io.File r8 = new java.io.File     // Catch: java.lang.Throwable -> L8e
            java.lang.String r9 = r6.getPath()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r10 = "comm"
            r8.<init>(r9, r10)     // Catch: java.lang.Throwable -> L8e
            r9 = 128(0x80, float:1.8E-43)
            java.lang.String r8 = com.uc.crashsdk.a.g.a(r8, r9, r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = l(r8)     // Catch: java.lang.Throwable -> L8e
            java.util.Locale r9 = java.util.Locale.US     // Catch: java.lang.Throwable -> L8e
            java.lang.String r10 = "%5s %s\n"
            java.lang.Object[] r11 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> L8e
            r11[r2] = r6     // Catch: java.lang.Throwable -> L8e
            r11[r4] = r8     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = java.lang.String.format(r9, r10, r11)     // Catch: java.lang.Throwable -> L8e
            byte[] r6 = r6.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r6)     // Catch: java.lang.Throwable -> L8e
            int r5 = r5 + 1
            goto L59
        L8e:
            r0 = move-exception
            a(r0, r12)
        L92:
            a(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.d(java.io.OutputStream):void");
    }

    private static void f(OutputStream outputStream) {
        String m10;
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            if (ag) {
                m10 = s("LASTVER");
            } else {
                m10 = com.uc.crashsdk.a.m();
            }
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", m10).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            ArrayList<String> arrayList = f9714s;
            synchronized (arrayList) {
                if (f9716u != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", f9716u).getBytes("UTF-8"));
                }
                if (f9715t > 0 || arrayList.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(f9715t)).getBytes("UTF-8"));
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                    }
                }
            }
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "dumping all threads: %s\n", Boolean.valueOf(f9717v)).getBytes("UTF-8"));
            String str = f9718w;
            if (str != null) {
                outputStream.write(String.format(locale, "dumping threads: %s\n", str).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    public static String k() {
        String str = f9719x;
        if (com.uc.crashsdk.a.g.a(str)) {
            synchronized (f9720y) {
                str = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.i(), g.z(), true);
                f9719x = str;
            }
        }
        return str;
    }

    public static void l() {
        synchronized (f9720y) {
            f9719x = null;
        }
    }

    public static void a(int i10, Object[] objArr) {
        int i11;
        switch (i10) {
            case 401:
                JNIBridge.nativeCmd(10, com.uc.crashsdk.b.I() == 5 ? 1L : 0L, null, null);
                com.uc.crashsdk.a.f9580c = true;
                com.uc.crashsdk.a.a(false);
                L = true;
                Z();
                y();
                return;
            case 402:
                Object obj = Y;
                synchronized (obj) {
                    if (X == null) {
                        return;
                    }
                    W = true;
                    if (com.uc.crashsdk.b.q()) {
                        return;
                    }
                    if (!com.uc.crashsdk.a.d.e()) {
                        com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                        return;
                    }
                    if (!d(LogType.UNEXP_TYPE)) {
                        com.uc.crashsdk.a.a.d("DEBUG", "unexp sample miss");
                        return;
                    }
                    int nativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(g.p(), g.q());
                    if (nativeGenerateUnexpLog != 0) {
                        f.a(11);
                        if ((nativeGenerateUnexpLog & 4352) != 0) {
                            Z = 105;
                            i11 = 30;
                        } else if ((nativeGenerateUnexpLog & LogType.UNEXP_EXIT) != 0) {
                            Z = 104;
                            i11 = 31;
                        } else if ((nativeGenerateUnexpLog & LogType.UNEXP_RESTART) != 0) {
                            Z = 106;
                            i11 = 32;
                        } else {
                            if ((nativeGenerateUnexpLog & 1280) != 0) {
                                Z = 103;
                                f.a(10);
                            } else if ((nativeGenerateUnexpLog & LogType.UNEXP_LOW_MEMORY) != 0) {
                                Z = 107;
                                f.a(29);
                            } else {
                                Z = 102;
                            }
                            a(true);
                        }
                        f.a(i11);
                        a(true);
                    }
                    synchronized (obj) {
                        X = null;
                    }
                    return;
                }
            case UPnPStatus.OUT_OF_SYNC /* 403 */:
                ab();
                return;
            case 404:
            default:
                if (!f9695a) {
                    throw new AssertionError();
                }
                return;
            case 405:
                L = false;
                StringBuilder Y2 = Y();
                String g10 = com.uc.crashsdk.b.g();
                if (Y2 != null) {
                    com.uc.crashsdk.a.g.a(new File(g10), Y2.toString());
                    return;
                }
                return;
            case 406:
                if (!f9695a && objArr == null) {
                    throw new AssertionError();
                }
                a((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                return;
            case 407:
                try {
                    com.uc.crashsdk.a.d();
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 408:
                synchronized (f9697ab) {
                    if (!ac && g.R() && com.uc.crashsdk.b.z()) {
                        com.uc.crashsdk.b.s();
                        h.f();
                        f.c();
                        if (com.uc.crashsdk.b.F()) {
                            C();
                        }
                        if (g.R()) {
                            a(Calendar.getInstance());
                        }
                        ac = true;
                        return;
                    }
                    return;
                }
            case 409:
                d(false);
                return;
            case Constant.TOKEN_EXPIRED /* 410 */:
                a(false, true);
                return;
            case MediaError.DetailedErrorCode.HLS_MANIFEST_MASTER /* 411 */:
                if (com.uc.crashsdk.b.f9663d) {
                    JNIBridge.set(28, d(LogType.NATIVE_TYPE));
                    JNIBridge.set(29, d(LogType.ANR_TYPE));
                    return;
                }
                return;
            case 412:
                if (!R && com.uc.crashsdk.b.B() && g.N()) {
                    b(com.uc.crashsdk.a.g.a());
                    return;
                }
                if (R) {
                    if (com.uc.crashsdk.b.B() && g.N()) {
                        return;
                    }
                    try {
                        com.uc.crashsdk.a.g.a().unregisterReceiver(Q);
                        R = false;
                        return;
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                        return;
                    }
                }
                return;
            case 413:
                JNIBridge.cmd(8);
                return;
            case 414:
                try {
                    if (d(com.uc.crashsdk.a.g.a())) {
                        return;
                    }
                    int i12 = N + 1;
                    N = i12;
                    if (i12 < 10) {
                        X();
                        return;
                    } else {
                        if (com.uc.crashsdk.b.f9663d) {
                            JNIBridge.set(130, "(get failed)");
                            return;
                        }
                        return;
                    }
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 415:
                if (!f9695a && objArr == null) {
                    throw new AssertionError();
                }
                long longValue = ((Long) objArr[0]).longValue();
                Calendar calendar = Calendar.getInstance();
                if (calendar.getTimeInMillis() >= longValue) {
                    h.g();
                    f.a(100);
                    d(true);
                    f.a(true);
                    h.b();
                } else {
                    h.h();
                    h.i();
                    h.c();
                }
                a(calendar);
                break;
            case 416:
                break;
        }
        W();
    }

    public static class a extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        private final long f9723a;

        /* renamed from: b, reason: collision with root package name */
        private final OutputStream f9724b;

        /* renamed from: c, reason: collision with root package name */
        private int f9725c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f9726d = 0;

        /* renamed from: e, reason: collision with root package name */
        private boolean f9727e = false;

        public a(long j10, OutputStream outputStream) {
            this.f9723a = j10;
            this.f9724b = outputStream;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int a(byte[] r7, int r8, int r9) {
            /*
                r6 = this;
                int r0 = r6.f9726d
                int r0 = r0 + r9
                r6.f9726d = r0
                boolean r0 = r6.f9727e
                if (r0 == 0) goto Lb
                r7 = 0
                return r7
            Lb:
                int r0 = com.uc.crashsdk.g.B()
                if (r0 <= 0) goto L19
                int r1 = r6.f9725c
                int r2 = r1 + r9
                if (r2 <= r0) goto L19
                int r0 = r0 - r1
                goto L1a
            L19:
                r0 = r9
            L1a:
                int r1 = r6.f9725c
                int r1 = r1 + r0
                r6.f9725c = r1
                long r1 = r6.f9723a
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L30
                java.lang.String r1 = new java.lang.String
                r1.<init>(r7, r8, r0)
                r6.b(r1)
                goto L35
            L30:
                java.io.OutputStream r1 = r6.f9724b
                r1.write(r7, r8, r0)
            L35:
                if (r0 >= r9) goto L3a
                r7 = 1
                r6.f9727e = r7
            L3a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a.a(byte[], int, int):int");
        }

        private void b(String str) {
            if (com.uc.crashsdk.b.f9663d) {
                JNIBridge.nativeClientWriteData(this.f9723a, str);
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i10) {
            if (e.f9703h && e.O()) {
                com.uc.crashsdk.a.a.d("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i10)));
            }
            if (this.f9723a != 0) {
                b(String.format(Locale.US, "%c", Integer.valueOf(i10)));
            } else {
                this.f9724b.write(i10);
            }
            this.f9725c++;
            this.f9726d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i10, int i11) {
            if (e.f9703h && e.O()) {
                byte[] bArr2 = new byte[i11];
                System.arraycopy(bArr, i10, bArr2, 0, i11);
                if (i11 != 1 || bArr2[0] != 10) {
                    try {
                        com.uc.crashsdk.a.a.d("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            a(bArr, i10, i11);
        }

        public final void a() {
            try {
                if (this.f9726d - this.f9725c > 0) {
                    a("\n");
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.f9726d), Integer.valueOf(this.f9725c), Integer.valueOf(g.B()), Integer.valueOf(this.f9726d - this.f9725c)));
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            if (e.f9703h && e.O() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    com.uc.crashsdk.a.a.d("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        public final void a(String str) {
            if (e.f9703h && e.O()) {
                com.uc.crashsdk.a.a.d("DEBUG", str);
            }
            if (this.f9723a != 0) {
                b(str);
            } else {
                this.f9724b.write(str.getBytes("UTF-8"));
            }
        }
    }

    public static String h() {
        String str = f9708m;
        if (str != null) {
            return str;
        }
        String a10 = a(Process.myPid());
        f9708m = a10;
        return a10;
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        long f9728a;

        /* renamed from: b, reason: collision with root package name */
        long f9729b;

        /* renamed from: c, reason: collision with root package name */
        int f9730c;

        /* renamed from: d, reason: collision with root package name */
        int f9731d;

        /* renamed from: e, reason: collision with root package name */
        boolean f9732e;

        /* renamed from: f, reason: collision with root package name */
        boolean f9733f;

        /* renamed from: g, reason: collision with root package name */
        boolean f9734g;

        private d() {
            this.f9728a = 0L;
            this.f9729b = 0L;
            this.f9730c = 0;
            this.f9731d = 0;
            this.f9732e = false;
            this.f9733f = false;
            this.f9734g = false;
        }

        public /* synthetic */ d(byte b10) {
            this();
        }
    }

    public static void j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void m() {
        if (ag) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(MediaError.DetailedErrorCode.HLS_MANIFEST_MASTER), 1000L);
    }

    public static void p() {
        String str;
        Throwable th;
        if (com.uc.crashsdk.a.g.a(B)) {
            String str2 = null;
            try {
                File file = new File(g.X() + "unique");
                if (file.exists()) {
                    str = com.uc.crashsdk.a.g.a(file, 48, false);
                    try {
                        if (str != null) {
                            try {
                                if (str.length() == 36) {
                                    str2 = str.replaceAll("[^0-9a-zA-Z-]", Operator.Operation.MINUS);
                                }
                            } catch (Exception e10) {
                                com.uc.crashsdk.a.g.a(e10);
                            }
                        }
                        str2 = str;
                    } catch (Throwable th2) {
                        th = th2;
                        com.uc.crashsdk.a.g.a(th);
                        str2 = str;
                        B = str2;
                    }
                }
                if (com.uc.crashsdk.a.g.a(str2)) {
                    com.uc.crashsdk.b.G();
                    str2 = UUID.randomUUID().toString();
                    if (!com.uc.crashsdk.a.g.a(str2)) {
                        com.uc.crashsdk.a.g.a(file, str2.getBytes());
                    }
                }
            } catch (Throwable th3) {
                str = str2;
                th = th3;
            }
            B = str2;
        }
    }

    public static String q() {
        return B;
    }

    public static void r() {
        O = false;
        if (!com.uc.crashsdk.b.B()) {
            com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(416), 11000L);
        }
        if (V()) {
            return;
        }
        N = 0;
        X();
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String str3;
        String str4;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), n()).getBytes("UTF-8"));
            Object[] objArr = new Object[3];
            objArr[0] = e();
            if (com.uc.crashsdk.a.g.a(f9707l)) {
                T();
            }
            objArr[1] = f9707l;
            objArr[2] = f();
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            Locale locale2 = Locale.US;
            outputStream.write(String.format(locale2, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            Object[] objArr2 = new Object[4];
            objArr2[0] = a(new Date(f9698b));
            objArr2[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
            objArr2[2] = com.uc.crashsdk.a.g.d();
            objArr2[3] = com.uc.crashsdk.b.B() ? "fg" : "bg";
            outputStream.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            Locale locale3 = Locale.US;
            outputStream.write(String.format(locale3, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", g.U(), g.V(), g.W(), Integer.valueOf(com.uc.crashsdk.a.c())).getBytes("UTF-8"));
            String str5 = "0";
            String str6 = "";
            if (com.uc.crashsdk.b.f9663d) {
                String nativeGet = JNIBridge.nativeGet(1, 0L, null);
                str4 = JNIBridge.nativeGet(2, 0L, null);
                str5 = nativeGet;
            } else {
                str4 = "";
            }
            outputStream.write(String.format(locale3, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", "3.3.2.2", str5, "240515102041", str4, "umeng").getBytes("UTF-8"));
            if (str != null) {
                str6 = str;
            }
            outputStream.write(("Report Name: " + str6.substring(str6.lastIndexOf(47) + 1) + "\n").getBytes("UTF-8"));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            if (ag) {
                str3 = s("UUID");
            } else {
                str3 = B;
            }
            outputStream.write(String.format("UUID: %s\n", str3).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + "\n").getBytes("UTF-8"));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            String E2 = com.uc.crashsdk.b.E();
            if (com.uc.crashsdk.a.g.a(E2)) {
                E2 = "(none)";
            }
            outputStream.write(("Activity: " + E2 + "\n").getBytes("UTF-8"));
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, "UTF-8");
            if (ag) {
                f9703h = false;
                outputStream.write(s("HEADER").getBytes("UTF-8"));
                f9703h = true;
            }
        } catch (Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    public static String n() {
        return a(new Date());
    }

    public static boolean d(String str) {
        if (ag) {
            return true;
        }
        try {
            return p(str);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(boolean z10) {
        File[] listFiles;
        try {
            if (com.uc.crashsdk.b.y() && (listFiles = new File(g.Y()).listFiles()) != null) {
                int m10 = g.m();
                int n10 = g.n();
                if (listFiles.length < Math.min(m10, n10)) {
                    return;
                }
                Object[] objArr = 0;
                int i10 = 0;
                int i11 = 0;
                for (File file : listFiles) {
                    if (b(file)) {
                        i10++;
                    } else {
                        i11++;
                    }
                }
                int i12 = (!z10 || i10 < m10) ? 0 : (i10 - m10) + 1;
                int i13 = (z10 || i11 < n10) ? 0 : (i11 - n10) + 1;
                if (i12 == 0 && i13 == 0) {
                    return;
                }
                Arrays.sort(listFiles, new b(objArr == true ? 1 : 0));
                int i14 = i12;
                int i15 = i13;
                for (File file2 : listFiles) {
                    boolean b10 = b(file2);
                    if (b10 && i14 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                        file2.delete();
                        i14 += -1;
                    } else if (!b10 && i15 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                        file2.delete();
                        i15 += -1;
                    }
                    if (i14 == 0 && i15 == 0) {
                        break;
                    }
                }
                f.a(16, i12 + i13);
                if (i12 > 0) {
                    f.a(22, i12);
                }
                if (i13 > 0) {
                    f.a(23, i13);
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        boolean z10 = false;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.ProcessErrorStateInfo next = it.next();
            if (next.pid == myPid) {
                O = true;
                if (O()) {
                    com.uc.crashsdk.a.a.d("crashsdk", "ANR occurred in process: " + next.processName);
                }
                if (com.uc.crashsdk.b.f9663d) {
                    JNIBridge.set(130, next.longMsg);
                }
                z10 = true;
            }
        }
        if (!z10 && com.uc.crashsdk.b.f9663d) {
            W();
        }
        return true;
    }

    public static void o() {
        f9698b = System.currentTimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(java.io.OutputStream r11) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e(java.io.OutputStream):void");
    }

    public static void c(String str) {
        synchronized (f9721z) {
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.l(), str + "\n");
        }
    }

    public static void d(boolean z10) {
        f.d(false);
        if (z10) {
            f.a(com.uc.crashsdk.b.c(), false);
            h.i();
        } else {
            f.a();
            h.i();
        }
    }

    public static int f(boolean z10) {
        int b10;
        if (z10) {
            b10 = f.a(com.uc.crashsdk.b.c()) ? 1 : 0;
        } else {
            b10 = f.b();
        }
        int b11 = f.b(z10);
        return b11 > b10 ? b11 : b10;
    }

    public static void c(boolean z10) {
        boolean z11 = true;
        if (!R ? !z10 || !g.N() : z10 && g.N()) {
            z11 = false;
        }
        if (z11) {
            com.uc.crashsdk.a.e eVar = S;
            if (com.uc.crashsdk.a.f.b(eVar)) {
                com.uc.crashsdk.a.f.a(eVar);
            }
            com.uc.crashsdk.a.f.a(0, eVar, 3000L);
        }
    }

    public static StringBuilder f(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    public static String a(String str, String str2) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(Build.VERSION.SDK_INT >= 26 ? new String[]{"ps", "-ef"} : new String[]{"ps"}).getInputStream()));
            boolean b10 = com.uc.crashsdk.a.g.b(str);
            boolean b11 = com.uc.crashsdk.a.g.b(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if ((b10 && readLine.contains(str)) || (b11 && readLine.contains(str2)) || (readLine.indexOf(47) < 0 && readLine.indexOf(46) > 0)) {
                        byteArrayOutputStream.write(readLine.getBytes("UTF-8"));
                        byteArrayOutputStream.write("\n".getBytes("UTF-8"));
                    }
                } else {
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "exception exists.";
        }
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i10 = 8192;
        while (bufferedReader == null && i10 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i10);
            } catch (Throwable unused) {
                i10 /= 2;
                if (i10 < 512) {
                    break;
                }
            }
        }
        return bufferedReader;
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    public static boolean e(String str) {
        try {
            if (!com.uc.crashsdk.a.g.b(str) || !str.startsWith(ContextPath.LIB) || !str.endsWith(".so")) {
                return false;
            }
            System.loadLibrary(str.substring(3, str.length() - 3));
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    private static String a(File file) {
        String str;
        try {
            str = file.getCanonicalPath();
        } catch (Throwable unused) {
            str = null;
        }
        return com.uc.crashsdk.a.g.a(str) ? file.getPath() : str;
    }

    private static long a(StatFs statFs, String str, String str2) {
        try {
            Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(statFs, new Object[0]);
            if (invoke != null && (invoke instanceof Long)) {
                return ((Long) invoke).longValue();
            }
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object invoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (invoke2 == null || !(invoke2 instanceof Integer)) {
                return 0L;
            }
            return ((Integer) invoke2).intValue();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return 0L;
        }
    }

    public static int e(boolean z10) {
        return f.a(z10);
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReader = null;
        try {
            outputStream.write("logcat:\n".getBytes("UTF-8"));
        } finally {
        }
        try {
            if (g.o() <= 0) {
                try {
                    outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                a(outputStream);
                return;
            }
            int o10 = g.o();
            bufferedReader = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", com.umeng.analytics.pro.f.ax, "-b", MediaTrack.ROLE_MAIN, "-v", "threadtime", "-t", String.valueOf(o10)}).getInputStream()));
            if (bufferedReader == null) {
                try {
                    outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                a(outputStream);
                return;
            }
            f9703h = false;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    i10++;
                    if (i11 < o10 && !readLine.contains(" I auditd ") && !readLine.contains(" I liblog ")) {
                        outputStream.write(readLine.getBytes("UTF-8"));
                        outputStream.write("\n".getBytes("UTF-8"));
                        i11++;
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable th3) {
                        a(th3, outputStream);
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i10), Integer.valueOf(i11)).getBytes("UTF-8"));
            f9703h = true;
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
            return;
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
            return;
        } finally {
        }
    }

    private static void a(a aVar) {
        try {
            aVar.a(String.format(Locale.US, "log end: %s\n", n()));
        } catch (Throwable th) {
            a(th, aVar);
        }
    }

    public static int a(OutputStream outputStream, String str, int i10) {
        int i11 = 0;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String a10 = com.uc.crashsdk.a.b.a(str);
            if (a10 == null) {
                a10 = "file: '" + str + "' not found or decode failed!";
            }
            int length = a10.length();
            if (length <= i10 + 32) {
                i10 = length;
            }
            if (i10 > 0) {
                try {
                    outputStream.write(a10.getBytes("UTF-8"), 0, i10);
                    outputStream.write("\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    th = th;
                    i11 = i10;
                    a(th, outputStream);
                    i10 = i11;
                    a(outputStream);
                    return i10;
                }
            }
            if (i10 < a10.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(a10.length() - i10)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i10;
    }

    public static String a(int i10) {
        try {
            String a10 = com.uc.crashsdk.a.g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i10))), 128, false);
            return com.uc.crashsdk.a.g.b(a10) ? l(a10) : "unknown";
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "unknown";
        }
    }

    private static void b(a aVar) {
        f9703h = false;
        try {
            aVar.write((s("LOG_END") + "\n").getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        f9703h = true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(39:0|1|(38:2|3|4|(2:332|333)|6|(2:8|9)(1:331)|10|11|(3:12|13|(1:15))|17|(2:19|20)|(2:25|26)|(5:27|28|(3:29|30|(1:32))|34|(1:38))|(2:40|41)|(2:43|44)|45|(2:46|47)|49|50|(2:295|296)|52|(2:53|54)|55|56|57|(2:58|59)|60|(2:61|62)|63|(4:65|66|67|68)|(2:72|73)|74|(2:75|76)|(2:78|79)|(3:80|81|(1:83)(2:267|(1:269)))|84|(2:85|86)|87)|(4:89|90|91|92)(3:211|212|(8:219|220|221|222|223|224|225|(45:227|228|229|230|231|232|233|234|235|236|237|238|239|95|96|97|98|(3:100|101|102)(7:172|173|(1:175)|176|(1:178)|179|(4:181|(1:183)(1:187)|184|185))|103|104|105|106|107|(4:109|110|111|112)|116|117|118|119|120|121|(4:123|124|125|126)|130|131|132|133|134|(1:136)|137|138|(1:140)|141|142|(1:144)(1:149)|145|146)(34:254|94|95|96|97|98|(0)(0)|103|104|105|106|107|(0)|116|117|118|119|120|121|(0)|130|131|132|133|134|(0)|137|138|(0)|141|142|(0)(0)|145|146)))|93|94|95|96|97|98|(0)(0)|103|104|105|106|107|(0)|116|117|118|119|120|121|(0)|130|131|132|133|134|(0)|137|138|(0)|141|142|(0)(0)|145|146|(2:(0)|(1:156))) */
    /* JADX WARN: Can't wrap try/catch for region: R(76:0|1|2|3|4|(2:332|333)|6|(2:8|9)(1:331)|10|11|(3:12|13|(1:15))|17|(2:19|20)|(2:25|26)|(5:27|28|(3:29|30|(1:32))|34|(1:38))|(2:40|41)|(2:43|44)|45|(2:46|47)|49|50|(2:295|296)|52|(2:53|54)|55|56|57|(2:58|59)|60|(2:61|62)|63|(4:65|66|67|68)|(2:72|73)|74|(2:75|76)|(2:78|79)|(3:80|81|(1:83)(2:267|(1:269)))|84|(2:85|86)|87|(4:89|90|91|92)(3:211|212|(8:219|220|221|222|223|224|225|(45:227|228|229|230|231|232|233|234|235|236|237|238|239|95|96|97|98|(3:100|101|102)(7:172|173|(1:175)|176|(1:178)|179|(4:181|(1:183)(1:187)|184|185))|103|104|105|106|107|(4:109|110|111|112)|116|117|118|119|120|121|(4:123|124|125|126)|130|131|132|133|134|(1:136)|137|138|(1:140)|141|142|(1:144)(1:149)|145|146)(34:254|94|95|96|97|98|(0)(0)|103|104|105|106|107|(0)|116|117|118|119|120|121|(0)|130|131|132|133|134|(0)|137|138|(0)|141|142|(0)(0)|145|146)))|93|94|95|96|97|98|(0)(0)|103|104|105|106|107|(0)|116|117|118|119|120|121|(0)|130|131|132|133|134|(0)|137|138|(0)|141|142|(0)(0)|145|146|(2:(0)|(1:156))) */
    /* JADX WARN: Can't wrap try/catch for region: R(91:0|1|2|3|4|(2:332|333)|6|(2:8|9)(1:331)|10|11|12|13|(1:15)|17|(2:19|20)|(2:25|26)|27|28|29|30|(1:32)|34|(1:38)|40|41|(2:43|44)|45|(2:46|47)|49|50|(2:295|296)|52|53|54|55|56|57|58|59|60|(2:61|62)|63|(4:65|66|67|68)|72|73|74|75|76|(2:78|79)|80|81|(1:83)(2:267|(1:269))|84|(2:85|86)|87|(4:89|90|91|92)(3:211|212|(8:219|220|221|222|223|224|225|(45:227|228|229|230|231|232|233|234|235|236|237|238|239|95|96|97|98|(3:100|101|102)(7:172|173|(1:175)|176|(1:178)|179|(4:181|(1:183)(1:187)|184|185))|103|104|105|106|107|(4:109|110|111|112)|116|117|118|119|120|121|(4:123|124|125|126)|130|131|132|133|134|(1:136)|137|138|(1:140)|141|142|(1:144)(1:149)|145|146)(34:254|94|95|96|97|98|(0)(0)|103|104|105|106|107|(0)|116|117|118|119|120|121|(0)|130|131|132|133|134|(0)|137|138|(0)|141|142|(0)(0)|145|146)))|93|94|95|96|97|98|(0)(0)|103|104|105|106|107|(0)|116|117|118|119|120|121|(0)|130|131|132|133|134|(0)|137|138|(0)|141|142|(0)(0)|145|146|(2:(0)|(1:156))) */
    /* JADX WARN: Can't wrap try/catch for region: R(93:0|1|2|3|4|(2:332|333)|6|(2:8|9)(1:331)|10|11|12|13|(1:15)|17|(2:19|20)|(2:25|26)|27|28|29|30|(1:32)|34|(1:38)|40|41|43|44|45|(2:46|47)|49|50|(2:295|296)|52|53|54|55|56|57|58|59|60|(2:61|62)|63|(4:65|66|67|68)|72|73|74|75|76|(2:78|79)|80|81|(1:83)(2:267|(1:269))|84|85|86|87|(4:89|90|91|92)(3:211|212|(8:219|220|221|222|223|224|225|(45:227|228|229|230|231|232|233|234|235|236|237|238|239|95|96|97|98|(3:100|101|102)(7:172|173|(1:175)|176|(1:178)|179|(4:181|(1:183)(1:187)|184|185))|103|104|105|106|107|(4:109|110|111|112)|116|117|118|119|120|121|(4:123|124|125|126)|130|131|132|133|134|(1:136)|137|138|(1:140)|141|142|(1:144)(1:149)|145|146)(34:254|94|95|96|97|98|(0)(0)|103|104|105|106|107|(0)|116|117|118|119|120|121|(0)|130|131|132|133|134|(0)|137|138|(0)|141|142|(0)(0)|145|146)))|93|94|95|96|97|98|(0)(0)|103|104|105|106|107|(0)|116|117|118|119|120|121|(0)|130|131|132|133|134|(0)|137|138|(0)|141|142|(0)(0)|145|146|(2:(0)|(1:156))) */
    /* JADX WARN: Can't wrap try/catch for region: R(97:0|1|2|3|4|(2:332|333)|6|(2:8|9)(1:331)|10|11|12|13|(1:15)|17|(2:19|20)|25|26|27|28|29|30|(1:32)|34|(1:38)|40|41|43|44|45|46|47|49|50|(2:295|296)|52|53|54|55|56|57|58|59|60|61|62|63|(4:65|66|67|68)|72|73|74|75|76|78|79|80|81|(1:83)(2:267|(1:269))|84|85|86|87|(4:89|90|91|92)(3:211|212|(8:219|220|221|222|223|224|225|(45:227|228|229|230|231|232|233|234|235|236|237|238|239|95|96|97|98|(3:100|101|102)(7:172|173|(1:175)|176|(1:178)|179|(4:181|(1:183)(1:187)|184|185))|103|104|105|106|107|(4:109|110|111|112)|116|117|118|119|120|121|(4:123|124|125|126)|130|131|132|133|134|(1:136)|137|138|(1:140)|141|142|(1:144)(1:149)|145|146)(34:254|94|95|96|97|98|(0)(0)|103|104|105|106|107|(0)|116|117|118|119|120|121|(0)|130|131|132|133|134|(0)|137|138|(0)|141|142|(0)(0)|145|146)))|93|94|95|96|97|98|(0)(0)|103|104|105|106|107|(0)|116|117|118|119|120|121|(0)|130|131|132|133|134|(0)|137|138|(0)|141|142|(0)(0)|145|146|(2:(0)|(1:156))) */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x04d2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x04d3, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0483, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0485, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0456, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0458, code lost:
    
        a(r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x044c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x044e, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0427, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0429, code lost:
    
        a(r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0358, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0359, code lost:
    
        a(r0, r14);
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0430 A[Catch: all -> 0x0494, TRY_LEAVE, TryCatch #35 {all -> 0x0494, blocks: (B:95:0x034b, B:98:0x035c, B:103:0x0417, B:107:0x042c, B:109:0x0430, B:112:0x0445, B:115:0x0442, B:121:0x045b, B:123:0x045f, B:126:0x0474, B:129:0x0471, B:130:0x0477, B:155:0x0485, B:160:0x0458, B:164:0x044e, B:168:0x0429, B:171:0x0376, B:191:0x0359, B:247:0x0348, B:106:0x0423, B:125:0x0462, B:111:0x0433, B:132:0x047d, B:117:0x0448, B:120:0x0452, B:97:0x034e), top: B:246:0x0348, inners: #4, #8, #22, #24, #27, #36, #39 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x045f A[Catch: all -> 0x0494, TRY_LEAVE, TryCatch #35 {all -> 0x0494, blocks: (B:95:0x034b, B:98:0x035c, B:103:0x0417, B:107:0x042c, B:109:0x0430, B:112:0x0445, B:115:0x0442, B:121:0x045b, B:123:0x045f, B:126:0x0474, B:129:0x0471, B:130:0x0477, B:155:0x0485, B:160:0x0458, B:164:0x044e, B:168:0x0429, B:171:0x0376, B:191:0x0359, B:247:0x0348, B:106:0x0423, B:125:0x0462, B:111:0x0433, B:132:0x047d, B:117:0x0448, B:120:0x0452, B:97:0x034e), top: B:246:0x0348, inners: #4, #8, #22, #24, #27, #36, #39 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04c1 A[Catch: all -> 0x04d2, TryCatch #33 {all -> 0x04d2, blocks: (B:142:0x04bd, B:144:0x04c1, B:145:0x04cc), top: B:141:0x04bd }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x037b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(java.lang.Throwable r23, java.lang.String r24, long r25, boolean r27) {
        /*
            Method dump skipped, instructions count: 1259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Throwable, java.lang.String, long, boolean):java.lang.String");
    }

    public static int b(OutputStream outputStream, String str, int i10) {
        int i11;
        DataInputStream dataInputStream;
        int i12;
        DataInputStream dataInputStream2 = null;
        int i13 = 0;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] R2 = R();
                if (R2 == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    return 0;
                }
                dataInputStream = new DataInputStream(new FileInputStream(file));
                i12 = 0;
                i11 = 0;
                loop0: while (true) {
                    boolean z10 = false;
                    while (true) {
                        try {
                            int read = dataInputStream.read(R2);
                            if (read == -1) {
                                break loop0;
                            }
                            i12 += read;
                            int i14 = i10 - i11;
                            if (read <= i14 + 32) {
                                i14 = read;
                            }
                            if (i14 > 0 && !z10) {
                                outputStream.write(R2, 0, i14);
                                i11 += i14;
                            }
                            if (!z10) {
                                if (i14 < read || i11 >= i10) {
                                    z10 = true;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            i13 = i11;
                            dataInputStream2 = dataInputStream;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(dataInputStream2);
                                i11 = i13;
                                a(outputStream);
                                return i11;
                            } finally {
                                com.uc.crashsdk.a.g.a(dataInputStream2);
                            }
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                dataInputStream = null;
                i12 = 0;
                i11 = 0;
            }
            if (i11 > 0) {
                outputStream.write("\n".getBytes("UTF-8"));
            }
            if (i11 < i12) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i12 - i11)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i11;
    }

    public static void b(boolean z10) {
        try {
            boolean z11 = g.s() && com.uc.crashsdk.b.F() && !f9700d;
            if (!z11) {
                z11 = g.t();
            }
            if (z11) {
                if (z10) {
                    String k10 = k();
                    if (com.uc.crashsdk.a.g.a(k10)) {
                        return;
                    }
                    j();
                    a(k10, false, false);
                    return;
                }
                a(true, false);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    private static boolean b(File file) {
        int indexOf;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(95);
        if (lastIndexOf <= 0 || (indexOf = name.indexOf(46, lastIndexOf)) <= 0) {
            return false;
        }
        String substring = name.substring(lastIndexOf + 1, indexOf);
        return LogType.JAVA_TYPE.equals(substring) || "ucebujava".equals(substring) || LogType.NATIVE_TYPE.equals(substring) || "ucebujni".equals(substring) || LogType.UNEXP_TYPE.equals(substring) || LogType.ANR_TYPE.equals(substring);
    }

    private static String b(String str, boolean z10, boolean z11) {
        if (z10) {
            try {
                str = m(str);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (!z11) {
            return str;
        }
        try {
            return a(str);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return str;
        }
    }

    public static void b(String str, String str2, boolean z10) {
        h.a(str, str2, false, z10);
    }

    public static void b(String str) {
        synchronized (f9720y) {
            f9719x = str;
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.i(), str + "\n");
        }
    }

    private static void b(String str, String str2) {
        try {
            com.uc.crashsdk.d.a(str, h(), str2);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void b(Context context) {
        if (g.N()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(Q, intentFilter, null, com.uc.crashsdk.a.f.a(1));
                R = true;
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    public static void b(int i10) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(Constant.TOKEN_EXPIRED), i10 * 1000);
    }

    public static String a(String str) {
        int lastIndexOf;
        int indexOf;
        int i10;
        int indexOf2;
        File file;
        byte[] e10;
        byte[] bArr;
        if (!g.y() || (lastIndexOf = str.lastIndexOf(47)) <= 0 || (indexOf = str.indexOf(95, lastIndexOf)) <= lastIndexOf || (indexOf2 = str.indexOf(95, (i10 = indexOf + 1))) <= indexOf) {
            return str;
        }
        String d10 = com.uc.crashsdk.a.g.d("CrashSDK" + str.substring(lastIndexOf + 1, indexOf) + str.substring(i10, indexOf2));
        if (d10 == null || (e10 = com.uc.crashsdk.a.g.e((file = new File(str)))) == null || e10.length <= 0) {
            return str;
        }
        try {
            bArr = com.uc.crashsdk.a.c.b(e10, d10.substring(0, 16).getBytes());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            bArr = null;
        }
        if (bArr == null) {
            return str;
        }
        String str2 = str + ".ec";
        File file2 = new File(str2 + ".tmp");
        if (!com.uc.crashsdk.a.g.a(file2, bArr)) {
            return str;
        }
        if (!file2.renameTo(new File(str2))) {
            file2.delete();
            return str;
        }
        file.delete();
        return str2;
    }

    public static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        com.uc.crashsdk.a.g.a(th);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0356 A[Catch: all -> 0x0441, TryCatch #1 {all -> 0x0441, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0065, B:28:0x03cc, B:29:0x006d, B:31:0x007d, B:33:0x008f, B:34:0x00b0, B:36:0x00c0, B:40:0x00cd, B:45:0x00f9, B:50:0x00eb, B:66:0x01c6, B:68:0x01da, B:70:0x01de, B:71:0x01e0, B:73:0x01e5, B:74:0x01e7, B:75:0x01ec, B:79:0x0210, B:81:0x0226, B:83:0x022c, B:85:0x0235, B:86:0x0242, B:88:0x0261, B:89:0x0274, B:91:0x0286, B:93:0x0296, B:94:0x02a7, B:95:0x02eb, B:99:0x02fc, B:103:0x030a, B:107:0x031b, B:109:0x0329, B:111:0x0336, B:113:0x033d, B:116:0x034a, B:118:0x0356, B:120:0x036f, B:121:0x0374, B:123:0x0383, B:124:0x0390, B:129:0x03ba, B:131:0x03e0, B:133:0x03e7, B:135:0x03ee, B:137:0x03f5, B:139:0x03fc, B:141:0x0403, B:146:0x0415, B:148:0x041c, B:150:0x0423, B:152:0x042a, B:153:0x040e, B:154:0x038a, B:155:0x03ad, B:157:0x03b2, B:161:0x02af, B:163:0x02b5, B:166:0x02bd, B:168:0x02c1, B:170:0x02d5, B:172:0x02d9, B:175:0x01f7, B:177:0x0205, B:179:0x020b, B:182:0x01c3, B:189:0x0432), top: B:4:0x000a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03ad A[Catch: all -> 0x0441, TryCatch #1 {all -> 0x0441, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0065, B:28:0x03cc, B:29:0x006d, B:31:0x007d, B:33:0x008f, B:34:0x00b0, B:36:0x00c0, B:40:0x00cd, B:45:0x00f9, B:50:0x00eb, B:66:0x01c6, B:68:0x01da, B:70:0x01de, B:71:0x01e0, B:73:0x01e5, B:74:0x01e7, B:75:0x01ec, B:79:0x0210, B:81:0x0226, B:83:0x022c, B:85:0x0235, B:86:0x0242, B:88:0x0261, B:89:0x0274, B:91:0x0286, B:93:0x0296, B:94:0x02a7, B:95:0x02eb, B:99:0x02fc, B:103:0x030a, B:107:0x031b, B:109:0x0329, B:111:0x0336, B:113:0x033d, B:116:0x034a, B:118:0x0356, B:120:0x036f, B:121:0x0374, B:123:0x0383, B:124:0x0390, B:129:0x03ba, B:131:0x03e0, B:133:0x03e7, B:135:0x03ee, B:137:0x03f5, B:139:0x03fc, B:141:0x0403, B:146:0x0415, B:148:0x041c, B:150:0x0423, B:152:0x042a, B:153:0x040e, B:154:0x038a, B:155:0x03ad, B:157:0x03b2, B:161:0x02af, B:163:0x02b5, B:166:0x02bd, B:168:0x02c1, B:170:0x02d5, B:172:0x02d9, B:175:0x01f7, B:177:0x0205, B:179:0x020b, B:182:0x01c3, B:189:0x0432), top: B:4:0x000a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01da A[Catch: all -> 0x0441, TryCatch #1 {all -> 0x0441, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0065, B:28:0x03cc, B:29:0x006d, B:31:0x007d, B:33:0x008f, B:34:0x00b0, B:36:0x00c0, B:40:0x00cd, B:45:0x00f9, B:50:0x00eb, B:66:0x01c6, B:68:0x01da, B:70:0x01de, B:71:0x01e0, B:73:0x01e5, B:74:0x01e7, B:75:0x01ec, B:79:0x0210, B:81:0x0226, B:83:0x022c, B:85:0x0235, B:86:0x0242, B:88:0x0261, B:89:0x0274, B:91:0x0286, B:93:0x0296, B:94:0x02a7, B:95:0x02eb, B:99:0x02fc, B:103:0x030a, B:107:0x031b, B:109:0x0329, B:111:0x0336, B:113:0x033d, B:116:0x034a, B:118:0x0356, B:120:0x036f, B:121:0x0374, B:123:0x0383, B:124:0x0390, B:129:0x03ba, B:131:0x03e0, B:133:0x03e7, B:135:0x03ee, B:137:0x03f5, B:139:0x03fc, B:141:0x0403, B:146:0x0415, B:148:0x041c, B:150:0x0423, B:152:0x042a, B:153:0x040e, B:154:0x038a, B:155:0x03ad, B:157:0x03b2, B:161:0x02af, B:163:0x02b5, B:166:0x02bd, B:168:0x02c1, B:170:0x02d5, B:172:0x02d9, B:175:0x01f7, B:177:0x0205, B:179:0x020b, B:182:0x01c3, B:189:0x0432), top: B:4:0x000a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0210 A[Catch: all -> 0x0441, TryCatch #1 {all -> 0x0441, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0065, B:28:0x03cc, B:29:0x006d, B:31:0x007d, B:33:0x008f, B:34:0x00b0, B:36:0x00c0, B:40:0x00cd, B:45:0x00f9, B:50:0x00eb, B:66:0x01c6, B:68:0x01da, B:70:0x01de, B:71:0x01e0, B:73:0x01e5, B:74:0x01e7, B:75:0x01ec, B:79:0x0210, B:81:0x0226, B:83:0x022c, B:85:0x0235, B:86:0x0242, B:88:0x0261, B:89:0x0274, B:91:0x0286, B:93:0x0296, B:94:0x02a7, B:95:0x02eb, B:99:0x02fc, B:103:0x030a, B:107:0x031b, B:109:0x0329, B:111:0x0336, B:113:0x033d, B:116:0x034a, B:118:0x0356, B:120:0x036f, B:121:0x0374, B:123:0x0383, B:124:0x0390, B:129:0x03ba, B:131:0x03e0, B:133:0x03e7, B:135:0x03ee, B:137:0x03f5, B:139:0x03fc, B:141:0x0403, B:146:0x0415, B:148:0x041c, B:150:0x0423, B:152:0x042a, B:153:0x040e, B:154:0x038a, B:155:0x03ad, B:157:0x03b2, B:161:0x02af, B:163:0x02b5, B:166:0x02bd, B:168:0x02c1, B:170:0x02d5, B:172:0x02d9, B:175:0x01f7, B:177:0x0205, B:179:0x020b, B:182:0x01c3, B:189:0x0432), top: B:4:0x000a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0226 A[Catch: all -> 0x0441, TryCatch #1 {all -> 0x0441, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0065, B:28:0x03cc, B:29:0x006d, B:31:0x007d, B:33:0x008f, B:34:0x00b0, B:36:0x00c0, B:40:0x00cd, B:45:0x00f9, B:50:0x00eb, B:66:0x01c6, B:68:0x01da, B:70:0x01de, B:71:0x01e0, B:73:0x01e5, B:74:0x01e7, B:75:0x01ec, B:79:0x0210, B:81:0x0226, B:83:0x022c, B:85:0x0235, B:86:0x0242, B:88:0x0261, B:89:0x0274, B:91:0x0286, B:93:0x0296, B:94:0x02a7, B:95:0x02eb, B:99:0x02fc, B:103:0x030a, B:107:0x031b, B:109:0x0329, B:111:0x0336, B:113:0x033d, B:116:0x034a, B:118:0x0356, B:120:0x036f, B:121:0x0374, B:123:0x0383, B:124:0x0390, B:129:0x03ba, B:131:0x03e0, B:133:0x03e7, B:135:0x03ee, B:137:0x03f5, B:139:0x03fc, B:141:0x0403, B:146:0x0415, B:148:0x041c, B:150:0x0423, B:152:0x042a, B:153:0x040e, B:154:0x038a, B:155:0x03ad, B:157:0x03b2, B:161:0x02af, B:163:0x02b5, B:166:0x02bd, B:168:0x02c1, B:170:0x02d5, B:172:0x02d9, B:175:0x01f7, B:177:0x0205, B:179:0x020b, B:182:0x01c3, B:189:0x0432), top: B:4:0x000a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02fc A[Catch: all -> 0x0441, TryCatch #1 {all -> 0x0441, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0065, B:28:0x03cc, B:29:0x006d, B:31:0x007d, B:33:0x008f, B:34:0x00b0, B:36:0x00c0, B:40:0x00cd, B:45:0x00f9, B:50:0x00eb, B:66:0x01c6, B:68:0x01da, B:70:0x01de, B:71:0x01e0, B:73:0x01e5, B:74:0x01e7, B:75:0x01ec, B:79:0x0210, B:81:0x0226, B:83:0x022c, B:85:0x0235, B:86:0x0242, B:88:0x0261, B:89:0x0274, B:91:0x0286, B:93:0x0296, B:94:0x02a7, B:95:0x02eb, B:99:0x02fc, B:103:0x030a, B:107:0x031b, B:109:0x0329, B:111:0x0336, B:113:0x033d, B:116:0x034a, B:118:0x0356, B:120:0x036f, B:121:0x0374, B:123:0x0383, B:124:0x0390, B:129:0x03ba, B:131:0x03e0, B:133:0x03e7, B:135:0x03ee, B:137:0x03f5, B:139:0x03fc, B:141:0x0403, B:146:0x0415, B:148:0x041c, B:150:0x0423, B:152:0x042a, B:153:0x040e, B:154:0x038a, B:155:0x03ad, B:157:0x03b2, B:161:0x02af, B:163:0x02b5, B:166:0x02bd, B:168:0x02c1, B:170:0x02d5, B:172:0x02d9, B:175:0x01f7, B:177:0x0205, B:179:0x020b, B:182:0x01c3, B:189:0x0432), top: B:4:0x000a, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.String r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 1116
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, boolean, boolean):void");
    }

    public static boolean a(boolean z10, boolean z11) {
        if (!f9700d) {
            if (com.uc.crashsdk.b.f9663d) {
                JNIBridge.set(1, true);
            }
            f9700d = true;
        }
        try {
            String k10 = k();
            if (com.uc.crashsdk.a.g.a(k10)) {
                com.uc.crashsdk.a.a.a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            if (com.uc.crashsdk.a.f.a(z10 ? 1 : 0, new com.uc.crashsdk.a.e(406, new Object[]{k10, Boolean.valueOf(z11), Boolean.valueOf(z10)})) && z10) {
                f9710o.close();
                if (!r6.block(3000L)) {
                    com.uc.crashsdk.a.a.a("crashsdk", "timeout to wait for uploading");
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        boolean z10;
        FileChannel fileChannel;
        Exception e10;
        synchronized (f9711p) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e11) {
                    com.uc.crashsdk.a.g.a(e11);
                }
            }
            ?? r52 = 0;
            r5 = null;
            FileLock lock = null;
            z10 = false;
            try {
                try {
                    try {
                        fileChannel = new RandomAccessFile(file, "rw").getChannel();
                    } catch (Throwable th) {
                        th = th;
                        r52 = file;
                        com.uc.crashsdk.a.g.a((Closeable) r52);
                        throw th;
                    }
                } catch (Exception e12) {
                    try {
                        com.uc.crashsdk.a.g.a(e12);
                        fileChannel = null;
                    } catch (Exception e13) {
                        fileChannel = null;
                        e10 = e13;
                        com.uc.crashsdk.a.g.a(e10);
                        com.uc.crashsdk.a.g.a(fileChannel);
                        return z10;
                    }
                }
                if (fileChannel != null) {
                    try {
                        lock = fileChannel.lock();
                    } catch (Exception e14) {
                        try {
                            com.uc.crashsdk.a.g.a(e14);
                        } catch (Exception e15) {
                            e10 = e15;
                            com.uc.crashsdk.a.g.a(e10);
                            com.uc.crashsdk.a.g.a(fileChannel);
                            return z10;
                        }
                    }
                }
                try {
                    z10 = eVar.a();
                    com.uc.crashsdk.a.g.a(fileChannel);
                } finally {
                    if (lock != null) {
                        try {
                            lock.release();
                        } catch (Exception e16) {
                            com.uc.crashsdk.a.g.a(e16);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z10;
    }

    private static boolean a(String str, d dVar) {
        String a10 = com.uc.crashsdk.a.g.a(new File(str), 64, false);
        if (a10 == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(a10);
            if (matcher.find()) {
                long parseLong = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - parseLong < 86400000) {
                    dVar.f9729b = Long.parseLong(matcher.group(2));
                    dVar.f9730c = Integer.parseInt(matcher.group(3));
                    dVar.f9731d = Integer.parseInt(matcher.group(4));
                    dVar.f9728a = parseLong;
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public static boolean a(StringBuffer stringBuffer, String str, long j10, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j11;
        boolean z10;
        boolean a10;
        if (f9699c.get()) {
            com.uc.crashsdk.a.a.b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z11 = ag || com.uc.crashsdk.b.L();
        if (!z11 && !com.uc.crashsdk.a.d.e()) {
            com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
            return false;
        }
        if (!d(str)) {
            com.uc.crashsdk.a.a.d("DEBUG", "custom log sample miss: " + str);
            return false;
        }
        if (aa()) {
            com.uc.crashsdk.a.a.b("Processing native crash, skip generate custom log: " + str);
            return false;
        }
        if (stringBuffer == null || str == null) {
            return false;
        }
        String str3 = g.Y() + k(str);
        ?? r11 = (j10 & 32) != 0 ? 1 : 0;
        if (z11) {
            long nativeClientCreateConnection = com.uc.crashsdk.b.f9663d ? JNIBridge.nativeClientCreateConnection(str3, "custom", str, r11) : 0L;
            if (nativeClientCreateConnection == 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "skip custom log: " + str);
                return false;
            }
            j11 = nativeClientCreateConnection;
        } else {
            if (a(h(), str, (boolean) r11)) {
                return false;
            }
            g.a();
            a(false);
            j11 = 0;
        }
        synchronized (f9712q) {
            z10 = r11;
            a10 = a(str3, j11, stringBuffer, str, j10, arrayList, arrayList2, arrayList3, str2);
        }
        if (a10 && !z11) {
            b(h(), str, z10);
        }
        if (j11 != 0) {
            JNIBridge.nativeClientCloseConnection(j11);
        }
        if (!a10) {
            return false;
        }
        if (!z11) {
            r(str3);
        }
        if (!z11) {
            str3 = a(m(str3));
        }
        b(str3, str);
        if (!z10 || z11) {
            return true;
        }
        try {
            a(true, false);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    public static boolean a(String str, String str2, boolean z10) {
        if (!o(str2)) {
            return false;
        }
        h.a(str, str2, true, z10);
        com.uc.crashsdk.a.a.b(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
        return true;
    }

    private static void a(a aVar, String str, long j10) {
        String nativeDumpThreads;
        String str2 = null;
        if (com.uc.crashsdk.b.f9663d) {
            try {
                aVar.flush();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            nativeDumpThreads = JNIBridge.nativeDumpThreads(str, j10);
            if (ag || nativeDumpThreads == null || nativeDumpThreads.length() >= 512 || !nativeDumpThreads.startsWith(Operator.Operation.DIVISION) || nativeDumpThreads.indexOf(10) >= 0) {
                str2 = nativeDumpThreads;
            } else {
                if (!new File(nativeDumpThreads).exists()) {
                    str2 = "Can not found " + nativeDumpThreads;
                }
                String str3 = str2;
                str2 = nativeDumpThreads;
                nativeDumpThreads = str3;
            }
        } else {
            nativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (nativeDumpThreads != null) {
            try {
                aVar.write(nativeDumpThreads.getBytes("UTF-8"));
                aVar.write("\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            a((OutputStream) aVar);
        } else if (str2 != null && !ag) {
            b(aVar, str2, LogType.ANR);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            aVar.flush();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(java.lang.String r17, long r18, java.lang.StringBuffer r20, java.lang.String r21, long r22, java.util.ArrayList<java.lang.String> r24, java.util.ArrayList<java.lang.String> r25, java.util.ArrayList<java.lang.String> r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, long, java.lang.StringBuffer, java.lang.String, long, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + SSDP.PORT), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    public static void a(OutputStream outputStream, String str, String str2, int i10, boolean z10, boolean z11) {
        f9703h = false;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(i10);
            objArr[3] = Integer.valueOf(z10 ? 1 : 0);
            objArr[4] = Integer.valueOf(z11 ? 1 : 0);
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d,%d^$", objArr).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        f9703h = true;
        a(outputStream);
    }

    public static void a(OutputStream outputStream, String str, String str2) {
        f9703h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        f9703h = true;
    }

    public static void a(Context context) {
        try {
            if (V()) {
                context.registerReceiver(new c((byte) 0), new IntentFilter("android.intent.action.ANR"), null, com.uc.crashsdk.a.f.a(3));
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:347|(3:382|383|(15:386|387|388|(1:352)|353|354|355|356|(1:358)|359|(1:363)|364|(1:367)|369|(1:375)(2:373|374)))|349|(1:352)|353|354|355|356|(0)|359|(2:361|363)|364|(1:367)|369|(2:371|375)(1:376)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:398|(3:433|434|(15:437|438|439|(1:403)|404|405|406|407|(1:409)|410|(1:414)|415|(1:418)|420|(1:426)(2:424|425)))|400|(1:403)|404|405|406|407|(0)|410|(2:412|414)|415|(1:418)|420|(2:422|426)(1:427)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:82|(3:117|118|(15:121|122|123|(1:87)|88|89|90|91|(1:93)|94|(1:98)|99|(1:102)|104|(1:110)(2:108|109)))|84|(1:87)|88|89|90|91|(0)|94|(2:96|98)|99|(1:102)|104|(2:106|110)(1:111)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:11|(4:13|(6:16|17|18|19|(1:21)(1:23)|14)|28|22)|(3:64|65|(15:68|69|70|(1:33)|34|35|36|37|(1:39)|40|(1:44)|45|(1:48)|50|(1:57)(2:54|55)))|30|(1:33)|34|35|36|37|(0)|40|(2:42|44)|45|(1:48)|50|(2:52|57)(1:58)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:214|(1:218)|(3:253|254|(15:257|258|259|(1:223)|224|225|226|227|(1:229)|230|(1:234)|235|(1:238)|240|(1:246)(2:244|245)))|220|(1:223)|224|225|226|227|(0)|230|(2:232|234)|235|(1:238)|240|(2:242|246)(1:247)) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:159|160|(1:164)|(3:199|200|(15:203|204|205|(1:169)|170|171|172|173|(1:175)|176|(1:180)|181|(1:184)|186|(1:192)(2:190|191)))|166|(1:169)|170|171|172|173|(0)|176|(2:178|180)|181|(1:184)|186|(2:188|192)(1:193)) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:517|518|(2:520|(1:522))|(3:557|558|(16:561|562|563|564|(1:527)|528|529|530|531|(0)|534|(2:536|538)|539|(1:542)|544|(0)(0)))|524|(0)|528|529|530|531|(0)|534|(0)|539|(0)|544|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(19:458|459|(1:461)|463|(1:467)|(3:502|503|(16:506|507|508|509|(1:472)|473|474|475|476|(1:478)|479|(1:483)|484|(1:487)|489|(1:495)(2:493|494)))|469|(1:472)|473|474|475|476|(0)|479|(2:481|483)|484|(1:487)|489|(2:491|495)(1:496)) */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x013e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x013f, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0106, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0107, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x03b9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x03ba, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0381, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0382, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x043e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x043f, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0406, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0407, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0292, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0293, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x025a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x025b, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x0313, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x0314, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x02db, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x02dc, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x05f8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x05f9, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:500:0x05c0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:501:0x05c1, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b8, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x007f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0080, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0134 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0378 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03a2 A[Catch: all -> 0x03b9, TryCatch #19 {all -> 0x03b9, blocks: (B:173:0x0386, B:176:0x0391, B:178:0x03a2, B:180:0x03a6, B:181:0x03a9, B:184:0x03b1), top: B:172:0x0386 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03af A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03fd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0427 A[Catch: all -> 0x043e, TryCatch #20 {all -> 0x043e, blocks: (B:227:0x040b, B:230:0x0416, B:232:0x0427, B:234:0x042b, B:235:0x042e, B:238:0x0436), top: B:226:0x040b }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0434 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:247:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0488 A[Catch: all -> 0x055c, TryCatch #44 {all -> 0x055c, blocks: (B:267:0x0458, B:270:0x046a, B:272:0x0470, B:274:0x0488, B:275:0x048b, B:278:0x04b9, B:282:0x04b6, B:159:0x034a, B:277:0x04b0), top: B:150:0x0203, inners: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0500 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x052a A[Catch: all -> 0x0541, TryCatch #26 {all -> 0x0541, blocks: (B:296:0x050e, B:299:0x0519, B:301:0x052a, B:303:0x052e, B:304:0x0531, B:307:0x0539), top: B:295:0x050e }] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0537 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:316:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x04e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0251 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x027b A[Catch: all -> 0x0292, TryCatch #36 {all -> 0x0292, blocks: (B:356:0x025f, B:359:0x026a, B:361:0x027b, B:363:0x027f, B:364:0x0282, B:367:0x028a), top: B:355:0x025f }] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0288 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:376:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x02d2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:409:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x02fc A[Catch: all -> 0x0313, TryCatch #38 {all -> 0x0313, blocks: (B:407:0x02e0, B:410:0x02eb, B:412:0x02fc, B:414:0x0300, B:415:0x0303, B:418:0x030b), top: B:406:0x02e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0309 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:422:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:427:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0 A[Catch: all -> 0x00b7, TryCatch #17 {all -> 0x00b7, blocks: (B:37:0x0084, B:40:0x008f, B:42:0x00a0, B:44:0x00a4, B:45:0x00a7, B:48:0x00af), top: B:36:0x0084 }] */
    /* JADX WARN: Removed duplicated region for block: B:471:0x05b7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:478:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:481:0x05e1 A[Catch: all -> 0x05f8, TryCatch #18 {all -> 0x05f8, blocks: (B:476:0x05c5, B:479:0x05d0, B:481:0x05e1, B:483:0x05e5, B:484:0x05e8, B:487:0x05f0), top: B:475:0x05c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:486:0x05ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:496:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:526:0x063e A[ADDED_TO_REGION, DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:533:0x0656 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:536:0x0668 A[Catch: all -> 0x067f, DONT_GENERATE, FINALLY_INSNS, TryCatch #22 {all -> 0x067f, blocks: (B:531:0x064c, B:534:0x0657, B:536:0x0668, B:538:0x066c, B:539:0x066f, B:542:0x0677), top: B:530:0x064c }] */
    /* JADX WARN: Removed duplicated region for block: B:541:0x0675 A[ADDED_TO_REGION, DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:546:0x068c A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:551:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0127 A[Catch: all -> 0x013e, TryCatch #21 {all -> 0x013e, blocks: (B:91:0x010b, B:94:0x0116, B:96:0x0127, B:98:0x012b, B:99:0x012e, B:102:0x0136), top: B:90:0x010b }] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [long] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:436:0x0218 -> B:331:0x0220). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:439:0x021d -> B:331:0x0220). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Thread r20, java.lang.Throwable r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 1692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Thread, java.lang.Throwable, boolean):void");
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.d("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    private static void a(Calendar calendar) {
        if (g.T()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j10 = timeInMillis2 - timeInMillis;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(415, new Object[]{Long.valueOf(timeInMillis2)}), j10 <= 3600000 ? 1000 + j10 : 3600000L);
        }
    }

    public static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i10 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z10 = str == null;
            int i11 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i11++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append("\n");
                if (!z10 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    z10 = true;
                    i11 = 0;
                }
            }
            i10 = i11;
        }
        if (i10 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (af) {
            com.uc.crashsdk.a.a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        }
        if (!com.uc.crashsdk.b.f9663d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return false;
        }
        if (ae != null) {
            com.uc.crashsdk.a.a.c("crashsdk", "Has already set host fd!");
        }
        ae = parcelFileDescriptor;
        int fd = parcelFileDescriptor.getFd();
        int nativeCmd = (int) JNIBridge.nativeCmd(13, fd, null, null);
        ag = nativeCmd != -1;
        return fd == -1 || nativeCmd != -1;
    }
}
