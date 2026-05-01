package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.measurement.AppMeasurement;
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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
    */
    public static void D() {
        int O2 = g.O();
        boolean z10 = false;
        boolean z11 = true;
        if (O2 == 0 || O2 == 3 || O2 == 4) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 21 && i10 <= 25) {
                boolean z12 = O2 != 0;
                if (O2 == 3) {
                    z12 = System.currentTimeMillis() % 10 == 0;
                }
                if (O2 != 4) {
                    z11 = z12;
                }
            }
        }
        if (!z11) {
            com.uc.crashsdk.a.a.a("crashsdk", "SIG 3 is disabled by settings");
        }
        boolean L2 = com.uc.crashsdk.b.L();
        if (Looper.getMainLooper() == Looper.myLooper() || !z11) {
            z10 = z11;
        } else {
            com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(413));
        }
        JNIBridge.nativeCmd(7, L2 ? 1L : 0L, null, null);
        if (z10) {
            JNIBridge.cmd(8);
        }
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
    */
    private static boolean[] n(String str) {
        boolean w10 = g.w();
        boolean y10 = g.y();
        if (w10 || y10) {
            if (!str.endsWith(".tmp") && !str.contains(".ec")) {
                int lastIndexOf = str.lastIndexOf(File.separatorChar);
                if (lastIndexOf < 0) {
                    lastIndexOf = 0;
                }
                int i10 = 0;
                do {
                    lastIndexOf = str.indexOf(95, lastIndexOf);
                    if (lastIndexOf >= 0) {
                        i10++;
                        lastIndexOf++;
                    }
                } while (lastIndexOf >= 0);
                if (i10 == 8) {
                    String x10 = g.x();
                    if (str.endsWith(".log")) {
                        if (!com.uc.crashsdk.a.g.a(x10)) {
                        }
                    } else if (!com.uc.crashsdk.a.g.a(x10)) {
                    }
                    w10 = false;
                }
            }
            w10 = false;
            y10 = false;
        }
        return new boolean[]{w10, y10};
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
    */
    private static boolean o(String str) {
        boolean z10;
        boolean z11;
        int parseInt;
        synchronized (f9713r) {
            File file = new File(g.X() + "customlog");
            String a10 = com.uc.crashsdk.a.g.a(file, 1024, false);
            long currentTimeMillis = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            try {
                if (a10 != null) {
                    stringBuffer.append(a10);
                    Matcher matcher = Pattern.compile("([^\\n\\r\\t\\s]+) (\\d+) (\\d+)").matcher(stringBuffer);
                    for (int i10 = 0; matcher.find(i10); i10 = matcher.end()) {
                        if (str.equals(matcher.group(1))) {
                            long parseLong = Long.parseLong(matcher.group(2));
                            if (currentTimeMillis - parseLong < 86400000) {
                                try {
                                    parseInt = Integer.parseInt(matcher.group(3));
                                } catch (Exception e10) {
                                    com.uc.crashsdk.a.g.a(e10);
                                }
                                int G2 = g.G();
                                z11 = G2 < 0 && parseInt >= G2;
                                stringBuffer.replace(matcher.start(), matcher.end(), String.format(Locale.US, "%s %d %d", str, Long.valueOf(parseLong), Integer.valueOf(parseInt + 1)));
                                z10 = true;
                                if (!z10) {
                                    stringBuffer.append(String.format(Locale.US, "%s %d 1\n", str, Long.valueOf(currentTimeMillis)));
                                }
                                FileWriter fileWriter = null;
                                FileWriter fileWriter2 = new FileWriter(file);
                                String stringBuffer2 = stringBuffer.toString();
                                fileWriter2.write(stringBuffer2, 0, stringBuffer2.length());
                                com.uc.crashsdk.a.g.a(fileWriter2);
                            } else {
                                parseLong = currentTimeMillis;
                            }
                            parseInt = 0;
                            int G22 = g.G();
                            if (G22 < 0) {
                            }
                            stringBuffer.replace(matcher.start(), matcher.end(), String.format(Locale.US, "%s %d %d", str, Long.valueOf(parseLong), Integer.valueOf(parseInt + 1)));
                            z10 = true;
                            if (!z10) {
                            }
                            FileWriter fileWriter3 = null;
                            FileWriter fileWriter22 = new FileWriter(file);
                            String stringBuffer22 = stringBuffer.toString();
                            fileWriter22.write(stringBuffer22, 0, stringBuffer22.length());
                            com.uc.crashsdk.a.g.a(fileWriter22);
                        }
                    }
                }
                FileWriter fileWriter222 = new FileWriter(file);
                String stringBuffer222 = stringBuffer.toString();
                fileWriter222.write(stringBuffer222, 0, stringBuffer222.length());
                com.uc.crashsdk.a.g.a(fileWriter222);
            } catch (Throwable th) {
                th = th;
            }
            z10 = false;
            z11 = false;
            if (!z10) {
            }
            FileWriter fileWriter32 = null;
        }
        return z11;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ae A[Catch: all -> 0x0108, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:12:0x00ae, B:17:0x00d4, B:23:0x00ef, B:24:0x00df, B:38:0x00fc, B:41:0x0106, B:45:0x0033, B:47:0x003b, B:48:0x0044, B:50:0x004c, B:52:0x0054, B:54:0x005c, B:59:0x006a, B:61:0x0074, B:63:0x0081, B:65:0x008b, B:66:0x0096, B:68:0x00a0), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a0 A[Catch: all -> 0x0108, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:12:0x00ae, B:17:0x00d4, B:23:0x00ef, B:24:0x00df, B:38:0x00fc, B:41:0x0106, B:45:0x0033, B:47:0x003b, B:48:0x0044, B:50:0x004c, B:52:0x0054, B:54:0x005c, B:59:0x006a, B:61:0x0074, B:63:0x0081, B:65:0x008b, B:66:0x0096, B:68:0x00a0), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean p(String str) {
        boolean z10;
        boolean z11;
        int i10;
        Integer num;
        synchronized (f9721z) {
            z10 = false;
            if (A == null) {
                A = q(com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.l(), "all:1", false));
            }
            if (A.containsKey("all")) {
                num = A.get("all");
            } else if (A.containsKey(str)) {
                num = A.get(str);
            } else {
                if (!LogType.JAVA_TYPE.equals(str) && !LogType.NATIVE_TYPE.equals(str) && !LogType.ANR_TYPE.equals(str) && !LogType.UNEXP_TYPE.equals(str)) {
                    z11 = false;
                    if (!z11 && A.containsKey(AppMeasurement.CRASH_ORIGIN)) {
                        num = A.get(AppMeasurement.CRASH_ORIGIN);
                    } else if (z11 && A.containsKey("nocrash")) {
                        num = A.get("nocrash");
                    } else if (A.containsKey(DispatchConstants.OTHER)) {
                        i10 = 1;
                        if (i10 != 0) {
                            long j10 = i10;
                            if (j10 < 0) {
                                long j11 = j10 == -2 ? 7L : j10 == -3 ? 15L : j10 == -4 ? 60L : 30L;
                                long b10 = com.uc.crashsdk.a.b();
                                long currentTimeMillis = b10 == 0 ? -1L : (System.currentTimeMillis() - b10) / 86400000;
                                j10 = currentTimeMillis <= j11 ? 1L : currentTimeMillis - j11;
                            }
                            if (j10 != 1) {
                                if (j10 > 0) {
                                    if (System.currentTimeMillis() % j10 == 0) {
                                    }
                                }
                            }
                            z10 = true;
                        }
                    } else {
                        num = A.get(DispatchConstants.OTHER);
                    }
                }
                z11 = true;
                if (!z11) {
                }
                if (z11) {
                }
                if (A.containsKey(DispatchConstants.OTHER)) {
                }
            }
            i10 = num.intValue();
            if (i10 != 0) {
            }
        }
        return z10;
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
    */
    public static String e() {
        String str;
        String str2;
        boolean z10;
        String str3;
        String str4;
        Method declaredMethod;
        if (!com.uc.crashsdk.a.g.a(f9705j)) {
            return f9705j;
        }
        String str5 = null;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Field declaredField = Build.class.getDeclaredField("SUPPORTED_ABIS");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(null);
                if (obj != null && (obj instanceof String[])) {
                    String[] strArr = (String[]) obj;
                    StringBuilder sb = new StringBuilder();
                    int length = strArr.length;
                    int i10 = 0;
                    boolean z11 = true;
                    while (i10 < length) {
                        String str6 = strArr[i10];
                        if (!z11) {
                            sb.append(",");
                        }
                        sb.append(str6);
                        i10++;
                        z11 = false;
                    }
                    f9705j = sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        if (com.uc.crashsdk.a.g.a(f9705j)) {
            try {
                str = Build.CPU_ABI;
            } catch (Throwable unused2) {
                str = null;
            }
            try {
                str2 = Build.CPU_ABI2;
            } catch (Throwable unused3) {
                str2 = null;
                z10 = !com.uc.crashsdk.a.g.a(str);
                if (z10) {
                }
                if (!com.uc.crashsdk.a.g.a(str2)) {
                }
                declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                if (declaredMethod != null) {
                }
            }
            z10 = !com.uc.crashsdk.a.g.a(str);
            if (z10) {
                f9705j = str;
            }
            if (!com.uc.crashsdk.a.g.a(str2)) {
                if (z10) {
                    f9705j += ",";
                    f9705j += str2;
                } else {
                    f9705j = str2;
                }
            }
        }
        try {
            declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
        } catch (Throwable th) {
            th = th;
            str3 = null;
        }
        if (declaredMethod != null) {
            str4 = null;
            if (!com.uc.crashsdk.a.g.a(str5)) {
                f9705j += ",";
                f9705j += str5;
            }
            if (!com.uc.crashsdk.a.g.a(str4)) {
                f9705j += ",";
                f9705j += str4;
            }
            return f9705j;
        }
        declaredMethod.setAccessible(true);
        str3 = (String) declaredMethod.invoke(null, "ro.product.cpu.abi", null);
        try {
            str4 = (String) declaredMethod.invoke(null, "ro.product.cpu.abi2", null);
        } catch (Throwable th2) {
            th = th2;
            com.uc.crashsdk.a.g.a(th);
            str4 = null;
            str5 = str3;
            if (!com.uc.crashsdk.a.g.a(str5)) {
            }
            if (!com.uc.crashsdk.a.g.a(str4)) {
            }
            return f9705j;
        }
        str5 = str3;
        if (!com.uc.crashsdk.a.g.a(str5) && !f9705j.contains(str5)) {
            f9705j += ",";
            f9705j += str5;
        }
        if (!com.uc.crashsdk.a.g.a(str4) && !f9705j.contains(str4)) {
            f9705j += ",";
            f9705j += str4;
        }
        return f9705j;
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
    */
    private static void c(OutputStream outputStream) {
        int i10;
        if (com.uc.crashsdk.b.f9663d) {
            String o10 = com.uc.crashsdk.b.o();
            f9703h = false;
            if (1 == JNIBridge.cmd(17, o10)) {
                File file = new File(o10);
                try {
                    byte[] e10 = com.uc.crashsdk.a.g.e(file);
                    if (e10 != null) {
                        outputStream.write(e10);
                    }
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                try {
                    file.delete();
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                f9703h = true;
                a(outputStream);
            }
            f9703h = true;
            return;
        }
        File[] fileArr = null;
        try {
            i10 = g.K();
            try {
                fileArr = new File("/proc/self/fd").listFiles();
                if (fileArr != null) {
                    outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArr.length), Integer.valueOf(i10)).getBytes("UTF-8"));
                } else {
                    outputStream.write("[DEBUG] listFiles failed!\n".getBytes("UTF-8"));
                }
            } catch (Throwable th3) {
                th = th3;
                a(th, outputStream);
                if (fileArr != null) {
                }
                a(outputStream);
            }
        } catch (Throwable th4) {
            th = th4;
            i10 = 900;
        }
        if (fileArr != null) {
            try {
                if (fileArr.length >= i10) {
                    outputStream.write("opened files:\n".getBytes("UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (File file2 : fileArr) {
                            sb.append(file2.getName());
                            sb.append(" -> ");
                            sb.append(file2.getCanonicalPath());
                            sb.append("\n");
                        }
                    } catch (Throwable th5) {
                        a(th5, outputStream);
                    }
                    outputStream.write(sb.toString().getBytes("UTF-8"));
                }
            } catch (Throwable th6) {
                a(th6, outputStream);
            }
        }
        a(outputStream);
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
    */
    private static void d(OutputStream outputStream) {
        int i10;
        int i11;
        File[] fileArr = null;
        try {
            i10 = g.L();
            try {
                fileArr = new File("/proc/self/task").listFiles();
            } catch (Throwable th) {
                th = th;
                com.uc.crashsdk.a.g.a(th);
                i11 = 0;
                if (fileArr != null) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            i10 = 300;
        }
        if (fileArr == null) {
            return;
        }
        i11 = fileArr.length;
        if (i11 < i10) {
            return;
        }
        if (fileArr != null) {
            return;
        }
        try {
            outputStream.write("threads info:\n".getBytes("UTF-8"));
            outputStream.write(String.format(Locale.US, "threads count: %d, dump limit: %d.\n", Integer.valueOf(i11), Integer.valueOf(i10)).getBytes("UTF-8"));
            outputStream.write(" tid     name\n".getBytes("UTF-8"));
            for (File file : fileArr) {
                outputStream.write(String.format(Locale.US, "%5s %s\n", file.getName(), l(com.uc.crashsdk.a.g.a(new File(file.getPath(), "comm"), 128, false))).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
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
        */
        private int a(byte[] bArr, int i10, int i11) {
            int i12;
            this.f9726d += i11;
            if (this.f9727e) {
                return 0;
            }
            int B = g.B();
            if (B > 0) {
                int i13 = this.f9725c;
                if (i13 + i11 > B) {
                    i12 = B - i13;
                    this.f9725c += i12;
                    if (this.f9723a == 0) {
                        b(new String(bArr, i10, i12));
                    } else {
                        this.f9724b.write(bArr, i10, i12);
                    }
                    if (i12 < i11) {
                        this.f9727e = true;
                    }
                    return i12;
                }
            }
            i12 = i11;
            this.f9725c += i12;
            if (this.f9723a == 0) {
            }
            if (i12 < i11) {
            }
            return i12;
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
    */
    private static void e(OutputStream outputStream) {
        BufferedReader bufferedReader;
        int indexOf;
        boolean z10;
        if (com.uc.crashsdk.b.f9663d) {
            try {
                outputStream.write("solib build id:\n".getBytes("UTF-8"));
            } catch (Throwable th) {
                a(th, outputStream);
            }
            FileReader fileReader = null;
            try {
                ArrayList arrayList = new ArrayList();
                FileReader fileReader2 = new FileReader(new File("/proc/self/maps"));
                try {
                    bufferedReader = new BufferedReader(fileReader2, 512);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.endsWith(".so") && (indexOf = readLine.indexOf(47)) != -1) {
                                String substring = readLine.substring(indexOf);
                                if (!substring.contains("/data/") && !substring.contains(com.uc.crashsdk.a.f9578a)) {
                                    z10 = false;
                                    if (z10 && !arrayList.contains(substring)) {
                                        arrayList.add(substring);
                                        if (!ag) {
                                            try {
                                                outputStream.write((String.format("$^%s`%s^$", "SOBUILDID", substring) + "\n").getBytes("UTF-8"));
                                            } catch (Throwable th2) {
                                                a(th2, outputStream);
                                            }
                                        } else {
                                            outputStream.write(String.format(Locale.US, "%s: %s\n", substring, JNIBridge.nativeGet(3, 0L, substring)).getBytes("UTF-8"));
                                        }
                                    }
                                }
                                z10 = true;
                                if (z10) {
                                    arrayList.add(substring);
                                    if (!ag) {
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileReader = fileReader2;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                a(outputStream);
                            } catch (Throwable th4) {
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                throw th4;
                            }
                        }
                    }
                    com.uc.crashsdk.a.g.a(fileReader2);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
        }
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
    */
    private static String a(Throwable th, String str, long j10, boolean z10) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        a aVar;
        String str2;
        String str3;
        HashSet hashSet;
        String a10;
        StatFs statFs;
        long a11;
        long a12;
        a aVar2 = null;
        try {
            if (!com.uc.crashsdk.b.L()) {
                try {
                    g.a();
                    a(true);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    try {
                        a(th, aVar2);
                        if (j10 != 0) {
                        }
                        com.uc.crashsdk.a.g.a(aVar2);
                        com.uc.crashsdk.a.g.a(fileOutputStream);
                        if (!ag) {
                        }
                        b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                        return str;
                    } catch (Throwable th3) {
                        if (j10 != 0) {
                            b(aVar2);
                        }
                        com.uc.crashsdk.a.g.a(aVar2);
                        com.uc.crashsdk.a.g.a(fileOutputStream);
                        throw th3;
                    }
                }
            }
            fileOutputStream2 = j10 == 0 ? new FileOutputStream(str) : null;
            try {
                aVar = new a(j10, fileOutputStream2);
                try {
                    try {
                        if (com.uc.crashsdk.b.f9663d) {
                            JNIBridge.set(126, str);
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = fileOutputStream2;
                        aVar2 = aVar;
                        a(th, aVar2);
                        if (j10 != 0) {
                        }
                        com.uc.crashsdk.a.g.a(aVar2);
                        com.uc.crashsdk.a.g.a(fileOutputStream);
                        if (!ag) {
                        }
                        b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                        return str;
                    }
                } catch (Throwable th5) {
                    com.uc.crashsdk.a.g.a(th5);
                }
                b(aVar, str, S());
                if (z10) {
                    try {
                        aVar.flush();
                    } catch (Throwable th6) {
                        com.uc.crashsdk.a.g.a(th6);
                    }
                }
                try {
                    aVar.write(("Process Name: '" + h() + "'\n").getBytes("UTF-8"));
                    aVar.write(("Thread Name: '" + Thread.currentThread().getName() + "'\n").getBytes("UTF-8"));
                } catch (Throwable th7) {
                    com.uc.crashsdk.a.g.a(th7);
                }
                try {
                    aVar.write("Back traces starts.\n".getBytes("UTF-8"));
                    try {
                        Field declaredField = Throwable.class.getDeclaredField("detailMessage");
                        declaredField.setAccessible(true);
                        Object obj = declaredField.get(th);
                        if (obj != null) {
                            declaredField.set(th, ((String) obj).replaceAll("\n\t", "\n->  "));
                        }
                    } catch (Throwable th8) {
                        com.uc.crashsdk.a.g.a(th8);
                    }
                    String message = th.getMessage();
                    if (message != null && !message.equals(th.getLocalizedMessage())) {
                        aVar.write(("Message: " + message + "\n").getBytes("UTF-8"));
                    }
                } catch (Throwable th9) {
                    com.uc.crashsdk.a.g.a(th9);
                }
                try {
                    th.printStackTrace(new PrintStream(aVar));
                } catch (Throwable th10) {
                    com.uc.crashsdk.a.g.a(th10);
                }
                try {
                    aVar.write("Back traces ends.\n".getBytes("UTF-8"));
                } catch (Throwable th11) {
                    com.uc.crashsdk.a.g.a(th11);
                }
                a((OutputStream) aVar);
                try {
                    aVar.flush();
                } catch (Throwable th12) {
                    com.uc.crashsdk.a.g.a(th12);
                }
                try {
                    com.uc.crashsdk.a.a(aVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                } catch (Throwable th13) {
                    com.uc.crashsdk.a.g.a(th13);
                }
                if (z10) {
                    try {
                        aVar.flush();
                    } catch (Throwable th14) {
                        com.uc.crashsdk.a.g.a(th14);
                    }
                }
                try {
                    aVar.write("meminfo:\n".getBytes("UTF-8"));
                    b(aVar, "/proc/meminfo", 10240);
                } catch (Throwable th15) {
                    a(th15, aVar);
                }
                try {
                    String format = String.format(Locale.US, "/proc/%d/status", Integer.valueOf(Process.myPid()));
                    aVar.write("status:\n".getBytes("UTF-8"));
                    b(aVar, format, 10240);
                } catch (Throwable th16) {
                    a(th16, aVar);
                }
                try {
                    aVar.write(("memory info:\n" + g()).getBytes("UTF-8"));
                } catch (Throwable th17) {
                    a(th17, aVar);
                }
                a((OutputStream) aVar);
                f(aVar);
                try {
                    com.uc.crashsdk.a.a(aVar, "UTF-8", (ArrayList<String>) null);
                } catch (Throwable th18) {
                    a(th18, aVar);
                }
                if (ag) {
                    f9703h = false;
                    try {
                        aVar.write(s("JAVADUMPFILES").getBytes("UTF-8"));
                    } catch (Throwable th19) {
                        a(th19, aVar);
                    }
                    f9703h = true;
                }
                try {
                    aVar.flush();
                } catch (Throwable th20) {
                    com.uc.crashsdk.a.g.a(th20);
                }
                b((OutputStream) aVar);
                try {
                    aVar.flush();
                } catch (Throwable th21) {
                    com.uc.crashsdk.a.g.a(th21);
                }
                try {
                    aVar.write("battery info:\n".getBytes("UTF-8"));
                } catch (Throwable th22) {
                    a(th22, aVar);
                }
                try {
                    if (ag) {
                        f9703h = false;
                        aVar.write(s("BATTERYINFO").getBytes("UTF-8"));
                        f9703h = true;
                    } else {
                        StringBuilder Y2 = Y();
                        if (Y2 != null) {
                            aVar.write(Y2.toString().getBytes("UTF-8"));
                        }
                    }
                } catch (Throwable th23) {
                    a(th23, aVar);
                }
                a((OutputStream) aVar);
                try {
                    aVar.write("disk info:\n".getBytes("UTF-8"));
                } catch (Throwable th24) {
                    a(th24, aVar);
                }
            } catch (Throwable th25) {
                th = th25;
                fileOutputStream = fileOutputStream2;
            }
        } catch (Throwable th26) {
            th = th26;
        }
        if (ag) {
            f9703h = false;
            try {
                aVar.write(s("FSSTAT").getBytes("UTF-8"));
            } catch (Throwable th27) {
                a(th27, aVar);
            }
            f9703h = true;
        } else {
            try {
                hashSet = new HashSet();
                a10 = a(new File(com.uc.crashsdk.a.g.b()));
            } catch (Throwable th28) {
                th = th28;
                str2 = "\n";
                str3 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
            }
            if (!com.uc.crashsdk.a.g.a(a10) && !hashSet.contains(a10) && !a10.equals("/storage/emulated")) {
                hashSet.add(a10);
                try {
                    statFs = new StatFs(a10);
                    a11 = a(statFs, "getBlockCountLong", "getBlockCount");
                    str3 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                } catch (Throwable unused) {
                }
                try {
                    a12 = a(statFs, "getBlockSizeLong", "getBlockSize");
                } catch (Throwable th29) {
                    th = th29;
                    str2 = "\n";
                    fileOutputStream = fileOutputStream2;
                    try {
                        a(th, aVar);
                        a((OutputStream) aVar);
                        aVar.write("device status:\n".getBytes("UTF-8"));
                        if (!ag) {
                        }
                        a((OutputStream) aVar);
                        c(aVar);
                        d(aVar);
                        String str4 = str3;
                        com.uc.crashsdk.a.b(aVar, "UTF-8", str4, null);
                        if (ag) {
                        }
                        aVar.flush();
                        com.uc.crashsdk.a.a(aVar, "UTF-8", str4, null);
                        if (ag) {
                        }
                        aVar.a();
                        a(aVar);
                        aVar.flush();
                        if (j10 != 0) {
                        }
                        com.uc.crashsdk.a.g.a(aVar);
                    } catch (Throwable th30) {
                        th = th30;
                        aVar2 = aVar;
                        a(th, aVar2);
                        if (j10 != 0) {
                            b(aVar2);
                        }
                        com.uc.crashsdk.a.g.a(aVar2);
                        com.uc.crashsdk.a.g.a(fileOutputStream);
                        if (!ag) {
                        }
                        b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                        return str;
                    }
                    com.uc.crashsdk.a.g.a(fileOutputStream);
                    if (!ag) {
                    }
                    b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                    return str;
                }
                if ((a11 / 1024) * a12 >= 10240) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        long a13 = a(statFs, "getAvailableBlocksLong", "getAvailableBlocks");
                        long a14 = a(statFs, "getFreeBlocksLong", "getFreeBlocks");
                        try {
                            Locale locale = Locale.US;
                            aVar.write(String.format(locale, "%s:\n", a10).getBytes("UTF-8"));
                            Object[] objArr = new Object[1];
                            double d10 = a11;
                            Double.isNaN(d10);
                            str2 = "\n";
                            double d11 = a12;
                            Double.isNaN(d11);
                            try {
                                objArr[0] = Long.valueOf((long) (((d10 * 1.0d) * d11) / 1024.0d));
                                aVar.write(String.format(locale, "  total:      %d kB\n", objArr).getBytes("UTF-8"));
                                Object[] objArr2 = new Object[1];
                                double d12 = a13;
                                Double.isNaN(d12);
                                Double.isNaN(d11);
                                objArr2[0] = Long.valueOf((long) (((d12 * 1.0d) * d11) / 1024.0d));
                                aVar.write(String.format(locale, "  available:  %d kB\n", objArr2).getBytes("UTF-8"));
                                Object[] objArr3 = new Object[1];
                                double d13 = a14;
                                Double.isNaN(d13);
                                Double.isNaN(d11);
                                objArr3[0] = Long.valueOf((long) (((d13 * 1.0d) * d11) / 1024.0d));
                                aVar.write(String.format(locale, "  free:       %d kB\n", objArr3).getBytes("UTF-8"));
                                aVar.write(String.format(locale, "  block size: %d B\n\n", Long.valueOf(a12)).getBytes("UTF-8"));
                            } catch (Throwable th31) {
                                th = th31;
                                try {
                                    a(th, aVar);
                                } catch (Throwable th32) {
                                    th = th32;
                                    a(th, aVar);
                                    a((OutputStream) aVar);
                                    aVar.write("device status:\n".getBytes("UTF-8"));
                                    if (!ag) {
                                    }
                                    a((OutputStream) aVar);
                                    c(aVar);
                                    d(aVar);
                                    String str42 = str3;
                                    com.uc.crashsdk.a.b(aVar, "UTF-8", str42, null);
                                    if (ag) {
                                    }
                                    aVar.flush();
                                    com.uc.crashsdk.a.a(aVar, "UTF-8", str42, null);
                                    if (ag) {
                                    }
                                    aVar.a();
                                    a(aVar);
                                    aVar.flush();
                                    if (j10 != 0) {
                                    }
                                    com.uc.crashsdk.a.g.a(aVar);
                                    com.uc.crashsdk.a.g.a(fileOutputStream);
                                    if (!ag) {
                                    }
                                    b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                                    return str;
                                }
                                a((OutputStream) aVar);
                                aVar.write("device status:\n".getBytes("UTF-8"));
                                if (!ag) {
                                }
                                a((OutputStream) aVar);
                                c(aVar);
                                d(aVar);
                                String str422 = str3;
                                com.uc.crashsdk.a.b(aVar, "UTF-8", str422, null);
                                if (ag) {
                                }
                                aVar.flush();
                                com.uc.crashsdk.a.a(aVar, "UTF-8", str422, null);
                                if (ag) {
                                }
                                aVar.a();
                                a(aVar);
                                aVar.flush();
                                if (j10 != 0) {
                                }
                                com.uc.crashsdk.a.g.a(aVar);
                                com.uc.crashsdk.a.g.a(fileOutputStream);
                                if (!ag) {
                                }
                                b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                                return str;
                            }
                        } catch (Throwable th33) {
                            th = th33;
                            str2 = "\n";
                        }
                    } catch (Throwable th34) {
                        th = th34;
                        str2 = "\n";
                    }
                    a((OutputStream) aVar);
                    aVar.write("device status:\n".getBytes("UTF-8"));
                    if (!ag) {
                        try {
                            f9703h = false;
                            aVar.write(s("DEVICESTATUS").getBytes("UTF-8"));
                            f9703h = true;
                        } catch (Throwable th35) {
                            th = th35;
                            a(th, aVar);
                            a((OutputStream) aVar);
                            c(aVar);
                            d(aVar);
                            String str4222 = str3;
                            com.uc.crashsdk.a.b(aVar, "UTF-8", str4222, null);
                            if (ag) {
                            }
                            aVar.flush();
                            com.uc.crashsdk.a.a(aVar, "UTF-8", str4222, null);
                            if (ag) {
                            }
                            aVar.a();
                            a(aVar);
                            aVar.flush();
                            if (j10 != 0) {
                            }
                            com.uc.crashsdk.a.g.a(aVar);
                            com.uc.crashsdk.a.g.a(fileOutputStream);
                            if (!ag) {
                            }
                            b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                            return str;
                        }
                    } else {
                        try {
                            Locale locale2 = Locale.US;
                            aVar.write(String.format(locale2, "has root: %s\n", Boolean.valueOf(com.uc.crashsdk.a.g.e())).getBytes("UTF-8"));
                            String str5 = Build.TAGS;
                            String str6 = str5 != null ? str5 : "";
                            StringBuilder sb = new StringBuilder();
                            sb.append("build tags: ");
                            sb.append(str6);
                            if (com.uc.crashsdk.a.g.f()) {
                                sb.append(" (default root)");
                            }
                            sb.append(str2);
                            aVar.write(sb.toString().getBytes("UTF-8"));
                            String h10 = com.uc.crashsdk.a.g.h();
                            if (com.uc.crashsdk.a.g.b(h10)) {
                                aVar.write(String.format(locale2, "su binary: %s\n", h10).getBytes("UTF-8"));
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("su permission: ");
                                sb2.append(com.uc.crashsdk.a.g.g() ? "valid (" : "invalid (");
                                sb2.append(com.uc.crashsdk.a.g.i());
                                sb2.append(")\n");
                                aVar.write(sb2.toString().getBytes("UTF-8"));
                            }
                        } catch (Throwable th36) {
                            th = th36;
                            a(th, aVar);
                            a((OutputStream) aVar);
                            c(aVar);
                            d(aVar);
                            String str42222 = str3;
                            com.uc.crashsdk.a.b(aVar, "UTF-8", str42222, null);
                            if (ag) {
                            }
                            aVar.flush();
                            com.uc.crashsdk.a.a(aVar, "UTF-8", str42222, null);
                            if (ag) {
                            }
                            aVar.a();
                            a(aVar);
                            aVar.flush();
                            if (j10 != 0) {
                            }
                            com.uc.crashsdk.a.g.a(aVar);
                            com.uc.crashsdk.a.g.a(fileOutputStream);
                            if (!ag) {
                            }
                            b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                            return str;
                        }
                    }
                    a((OutputStream) aVar);
                    c(aVar);
                    d(aVar);
                    String str422222 = str3;
                    com.uc.crashsdk.a.b(aVar, "UTF-8", str422222, null);
                    if (ag) {
                        f9703h = false;
                        try {
                            aVar.write(s("JAVACACHEDINFOS").getBytes("UTF-8"));
                        } catch (Throwable th37) {
                            a(th37, aVar);
                        }
                        f9703h = true;
                    }
                    aVar.flush();
                    com.uc.crashsdk.a.a(aVar, "UTF-8", str422222, null);
                    if (ag) {
                        f9703h = false;
                        try {
                            aVar.write(s("JAVACALLBACKINFOS").getBytes("UTF-8"));
                        } catch (Throwable th38) {
                            a(th38, aVar);
                        }
                        f9703h = true;
                    }
                    aVar.a();
                    a(aVar);
                    aVar.flush();
                    if (j10 != 0) {
                        b(aVar);
                    }
                    com.uc.crashsdk.a.g.a(aVar);
                    com.uc.crashsdk.a.g.a(fileOutputStream);
                    if (!ag) {
                        r(str);
                    }
                    b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                    return str;
                }
                str2 = "\n";
                fileOutputStream = fileOutputStream2;
                a((OutputStream) aVar);
                aVar.write("device status:\n".getBytes("UTF-8"));
                if (!ag) {
                }
                a((OutputStream) aVar);
                c(aVar);
                d(aVar);
                String str4222222 = str3;
                com.uc.crashsdk.a.b(aVar, "UTF-8", str4222222, null);
                if (ag) {
                }
                aVar.flush();
                com.uc.crashsdk.a.a(aVar, "UTF-8", str4222222, null);
                if (ag) {
                }
                aVar.a();
                a(aVar);
                aVar.flush();
                if (j10 != 0) {
                }
                com.uc.crashsdk.a.g.a(aVar);
                com.uc.crashsdk.a.g.a(fileOutputStream);
                if (!ag) {
                }
                b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                return str;
            }
        }
        str2 = "\n";
        str3 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
        fileOutputStream = fileOutputStream2;
        a((OutputStream) aVar);
        aVar.write("device status:\n".getBytes("UTF-8"));
        if (!ag) {
        }
        a((OutputStream) aVar);
        c(aVar);
        d(aVar);
        String str42222222 = str3;
        com.uc.crashsdk.a.b(aVar, "UTF-8", str42222222, null);
        if (ag) {
        }
        aVar.flush();
        com.uc.crashsdk.a.a(aVar, "UTF-8", str42222222, null);
        if (ag) {
        }
        aVar.a();
        a(aVar);
        aVar.flush();
        if (j10 != 0) {
        }
        com.uc.crashsdk.a.g.a(aVar);
        com.uc.crashsdk.a.g.a(fileOutputStream);
        if (!ag) {
        }
        b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
        return str;
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
    */
    private static void a(String str, boolean z10, boolean z11) {
        ConditionVariable conditionVariable;
        int i10;
        boolean z12;
        boolean z13;
        File[] fileArr;
        int i11;
        String path;
        String b10;
        File a10;
        int i12;
        int i13;
        String str2;
        String str3;
        int i14;
        File file;
        boolean z14;
        com.uc.crashsdk.a.a.a("crashsdk", "crashsdk uploading logs");
        synchronized (f9709n) {
            try {
                try {
                    if (com.uc.crashsdk.a.g.b(str)) {
                        String Y2 = g.Y();
                        File file2 = new File(Y2);
                        if (file2.exists()) {
                            File[] listFiles = file2.listFiles();
                            if (listFiles == null) {
                                com.uc.crashsdk.a.a.b("List folder failed: " + Y2);
                            } else {
                                int length = listFiles.length;
                                int i15 = 0;
                                int i16 = 0;
                                int i17 = 0;
                                int i18 = 0;
                                int i19 = 0;
                                int i20 = 0;
                                int i21 = 0;
                                int i22 = 0;
                                int i23 = 0;
                                boolean z15 = false;
                                boolean z16 = false;
                                boolean z17 = false;
                                while (true) {
                                    if (i15 >= length) {
                                        i10 = i18;
                                        z12 = z15;
                                        z13 = z16;
                                        break;
                                    }
                                    File file3 = listFiles[i15];
                                    if (file3.isFile()) {
                                        String name = file3.getName();
                                        fileArr = listFiles;
                                        if (!name.endsWith(".tmp")) {
                                            i11 = length;
                                            z12 = z15;
                                            z13 = z16;
                                            if (file3.length() == 0) {
                                                i16++;
                                                com.uc.crashsdk.a.g.a(file3);
                                            } else {
                                                if (z10) {
                                                    long currentTimeMillis = (System.currentTimeMillis() - file3.lastModified()) / 1000;
                                                    if (currentTimeMillis < 0 || (currentTimeMillis >= 2 && (currentTimeMillis >= 5 || !file3.getName().endsWith(".log")))) {
                                                        z14 = true;
                                                        com.uc.crashsdk.a.a.a(String.format(Locale.US, "file: %s, modify interval: %d s, safe upload: %s", file3.getName(), Long.valueOf(currentTimeMillis), Boolean.valueOf(z14)));
                                                        if (!z14) {
                                                            i18++;
                                                        }
                                                    }
                                                    z14 = false;
                                                    com.uc.crashsdk.a.a.a(String.format(Locale.US, "file: %s, modify interval: %d s, safe upload: %s", file3.getName(), Long.valueOf(currentTimeMillis), Boolean.valueOf(z14)));
                                                    if (!z14) {
                                                    }
                                                }
                                                try {
                                                } catch (Throwable th) {
                                                    th = th;
                                                    i10 = i18;
                                                }
                                                if (g.l()) {
                                                    Matcher matcher = Pattern.compile("([^_]+)_([^_]+)_([^_]+)\\.crashsdk").matcher(file3.getName());
                                                    if (matcher.matches()) {
                                                        i10 = i18;
                                                        try {
                                                            file = new File(g.Y() + String.format(Locale.US, "%s%s_%s_%s.%s", j(matcher.group(2)), n(), Q(), matcher.group(1), matcher.group(3)));
                                                            com.uc.crashsdk.a.a.a("crashsdk", "File " + file3.getPath() + " matches, rename to " + file.getPath());
                                                            file3.renameTo(file);
                                                            if (file != file3) {
                                                                i22++;
                                                            }
                                                            file3 = file;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            com.uc.crashsdk.a.g.a(th);
                                                            path = file3.getPath();
                                                            boolean[] n10 = n(path);
                                                            b10 = b(path, n10[0], n10[1]);
                                                            if (path != b10) {
                                                            }
                                                            a10 = com.uc.crashsdk.d.a(file3);
                                                            if (a10 == null) {
                                                            }
                                                            if (a10 == null) {
                                                            }
                                                            i12 = i21;
                                                            z16 = z13;
                                                            i18 = i10;
                                                            i15++;
                                                            listFiles = fileArr;
                                                            i21 = i12;
                                                            length = i11;
                                                            z15 = z12;
                                                        }
                                                        path = file3.getPath();
                                                        boolean[] n102 = n(path);
                                                        b10 = b(path, n102[0], n102[1]);
                                                        if (path != b10) {
                                                            if (n102[0]) {
                                                                i21++;
                                                            }
                                                            if (n102[1]) {
                                                                i19++;
                                                            }
                                                            file3 = new File(b10);
                                                        }
                                                        a10 = com.uc.crashsdk.d.a(file3);
                                                        if (a10 == null) {
                                                            a10 = null;
                                                        } else if (file3 != a10 && !file3.getName().equals(a10.getName()) && file3.exists()) {
                                                            file3.delete();
                                                        }
                                                        if (a10 == null) {
                                                            com.uc.crashsdk.a.a.b("onBeforeUploadLog return null, skip upload: " + file3.getAbsolutePath());
                                                        } else {
                                                            int C2 = g.C();
                                                            if (C2 <= 0 || a10.length() < C2) {
                                                                d dVar = new d((byte) 0);
                                                                dVar.f9729b = 0L;
                                                                dVar.f9728a = System.currentTimeMillis();
                                                                String U2 = U();
                                                                if (new File(U2).exists()) {
                                                                    a(U2, new com.uc.crashsdk.a.e(451, new Object[]{U2, dVar}));
                                                                }
                                                                long D2 = g.D();
                                                                int E2 = g.E();
                                                                int F2 = g.F();
                                                                if (D2 >= 0) {
                                                                    i12 = i21;
                                                                    i13 = i22;
                                                                    if (dVar.f9729b + a10.length() > D2) {
                                                                        dVar.f9732e = true;
                                                                        str2 = "Reach max upload bytes: " + D2;
                                                                        com.uc.crashsdk.a.a.b(str2);
                                                                        if (!dVar.f9732e) {
                                                                            i22 = i13;
                                                                            z16 = z13;
                                                                            i18 = i10;
                                                                            z12 = true;
                                                                        } else if (dVar.f9734g) {
                                                                            i22 = i13;
                                                                            i18 = i10;
                                                                            z16 = true;
                                                                        } else if (dVar.f9733f) {
                                                                            i22 = i13;
                                                                            z16 = z13;
                                                                            i18 = i10;
                                                                            z17 = true;
                                                                        } else {
                                                                            String name2 = a10.getName();
                                                                            if (name2.startsWith(P())) {
                                                                                String[] split = name2.split("_", 10);
                                                                                if (split.length == 9) {
                                                                                    str3 = split[1];
                                                                                    boolean z18 = str3 == null && str3.equals(g.U());
                                                                                    if (com.uc.crashsdk.a.c.a(a10, a10.getName(), str)) {
                                                                                        i23++;
                                                                                        if (z18) {
                                                                                            f.a(14);
                                                                                        }
                                                                                        i14 = 3;
                                                                                    } else {
                                                                                        com.uc.crashsdk.a.a.a("crashsdk", "Uploaded log: " + a10.getName(), null);
                                                                                        if (z18) {
                                                                                            f.a(13);
                                                                                        }
                                                                                        dVar.f9729b += a10.length();
                                                                                        if (b(a10)) {
                                                                                            dVar.f9730c++;
                                                                                        } else {
                                                                                            dVar.f9731d++;
                                                                                        }
                                                                                        String U3 = U();
                                                                                        a(U3, new com.uc.crashsdk.a.e(452, new Object[]{U3, dVar}));
                                                                                        a10.delete();
                                                                                        i14 = 3;
                                                                                        i23 = 0;
                                                                                    }
                                                                                    if (i23 < i14) {
                                                                                        com.uc.crashsdk.a.a.a("crashsdk", "Upload failed 3 times continuously, abort upload!", null);
                                                                                        i22 = i13;
                                                                                        i21 = i12;
                                                                                        break;
                                                                                    } else {
                                                                                        i22 = i13;
                                                                                        z16 = z13;
                                                                                        i18 = i10;
                                                                                    }
                                                                                }
                                                                            }
                                                                            str3 = null;
                                                                            if (str3 == null) {
                                                                            }
                                                                            if (com.uc.crashsdk.a.c.a(a10, a10.getName(), str)) {
                                                                            }
                                                                            if (i23 < i14) {
                                                                            }
                                                                        }
                                                                        i15++;
                                                                        listFiles = fileArr;
                                                                        i21 = i12;
                                                                        length = i11;
                                                                        z15 = z12;
                                                                    }
                                                                } else {
                                                                    i12 = i21;
                                                                    i13 = i22;
                                                                }
                                                                if (!g.f()) {
                                                                    if (b(a10)) {
                                                                        if (E2 >= 0 && dVar.f9730c >= E2) {
                                                                            dVar.f9734g = true;
                                                                            str2 = "Reach max upload builtin log count: " + E2;
                                                                            com.uc.crashsdk.a.a.b(str2);
                                                                        }
                                                                    } else if (F2 >= 0 && dVar.f9731d >= F2) {
                                                                        dVar.f9733f = true;
                                                                        str2 = "Reach max upload custom log count: " + F2;
                                                                        com.uc.crashsdk.a.a.b(str2);
                                                                    }
                                                                }
                                                                if (!dVar.f9732e) {
                                                                }
                                                                i15++;
                                                                listFiles = fileArr;
                                                                i21 = i12;
                                                                length = i11;
                                                                z15 = z12;
                                                            } else {
                                                                i20++;
                                                                com.uc.crashsdk.a.g.a(a10);
                                                            }
                                                        }
                                                        i12 = i21;
                                                        z16 = z13;
                                                        i18 = i10;
                                                        i15++;
                                                        listFiles = fileArr;
                                                        i21 = i12;
                                                        length = i11;
                                                        z15 = z12;
                                                    }
                                                }
                                                i10 = i18;
                                                file = file3;
                                                if (file != file3) {
                                                }
                                                file3 = file;
                                                path = file3.getPath();
                                                boolean[] n1022 = n(path);
                                                b10 = b(path, n1022[0], n1022[1]);
                                                if (path != b10) {
                                                }
                                                a10 = com.uc.crashsdk.d.a(file3);
                                                if (a10 == null) {
                                                }
                                                if (a10 == null) {
                                                }
                                                i12 = i21;
                                                z16 = z13;
                                                i18 = i10;
                                                i15++;
                                                listFiles = fileArr;
                                                i21 = i12;
                                                length = i11;
                                                z15 = z12;
                                            }
                                            i12 = i21;
                                            z16 = z13;
                                            i15++;
                                            listFiles = fileArr;
                                            i21 = i12;
                                            length = i11;
                                            z15 = z12;
                                        } else if ((System.currentTimeMillis() - file3.lastModified()) / 1000 > 30) {
                                            i11 = length;
                                            com.uc.crashsdk.a.a.b("delete legacy tmp file: " + name);
                                            i17++;
                                            com.uc.crashsdk.a.g.a(file3);
                                            i12 = i21;
                                            z12 = z15;
                                            i15++;
                                            listFiles = fileArr;
                                            i21 = i12;
                                            length = i11;
                                            z15 = z12;
                                        }
                                    } else {
                                        com.uc.crashsdk.a.g.a(file3);
                                        fileArr = listFiles;
                                    }
                                    i11 = length;
                                    i12 = i21;
                                    z12 = z15;
                                    i15++;
                                    listFiles = fileArr;
                                    i21 = i12;
                                    length = i11;
                                    z15 = z12;
                                }
                                if (i17 > 0) {
                                    f.a(200, i17);
                                }
                                if (i16 > 0) {
                                    f.a(15, i16);
                                }
                                if (i20 > 0) {
                                    f.a(17, i20);
                                }
                                if (z12) {
                                    f.a(19);
                                }
                                if (z13) {
                                    f.a(20);
                                }
                                if (z17) {
                                    f.a(21);
                                }
                                if (z12 || z13 || z17) {
                                    f.a(18);
                                }
                                if (i21 > 0) {
                                    f.a(24, i21);
                                }
                                if (i19 > 0) {
                                    f.a(201, i19);
                                }
                                if (i22 > 0) {
                                    f.a(25, i22);
                                }
                                if (i10 > 0) {
                                    f.a(26, i10);
                                }
                            }
                        } else {
                            com.uc.crashsdk.a.a.a("crashsdk", "Folder not exist: " + Y2);
                        }
                    } else {
                        com.uc.crashsdk.a.a.a("crashsdk", "upload url is empty!");
                    }
                } catch (Throwable th3) {
                    try {
                        com.uc.crashsdk.a.g.a(th3);
                        if (z11) {
                            conditionVariable = f9710o;
                        }
                    } finally {
                    }
                }
                if (z11) {
                    conditionVariable = f9710o;
                    conditionVariable.open();
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
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
    */
    private static boolean a(String str, long j10, StringBuffer stringBuffer, String str2, long j11, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str3) {
        FileOutputStream fileOutputStream;
        a aVar;
        ArrayList<String> arrayList4;
        if (j10 == 0) {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                aVar = null;
                com.uc.crashsdk.a.g.a(th);
                if (aVar == null) {
                }
            }
        } else {
            fileOutputStream = null;
        }
        try {
            aVar = new a(j10, fileOutputStream);
            try {
                synchronized (f9714s) {
                    f9716u = str;
                    if (com.uc.crashsdk.b.f9663d) {
                        JNIBridge.set(126, f9716u);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.uc.crashsdk.a.g.a(th);
                if (aVar == null) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            aVar = null;
        }
        if (aVar == null) {
            return false;
        }
        if ((j11 & 1) != 0) {
            try {
                b(aVar, str, str2);
            } finally {
                try {
                    arrayList4 = f9714s;
                    synchronized (arrayList4) {
                    }
                } finally {
                }
            }
        }
        try {
            aVar.write(stringBuffer.toString().getBytes());
            aVar.write("\n".getBytes("UTF-8"));
            aVar.flush();
        } catch (Throwable th4) {
            a(th4, aVar);
        }
        a((OutputStream) aVar);
        if ((j11 & 4) != 0) {
            b((OutputStream) aVar);
            try {
                aVar.flush();
            } catch (Throwable th5) {
                com.uc.crashsdk.a.g.a(th5);
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            com.uc.crashsdk.a.a(aVar, "UTF-8", arrayList);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            com.uc.crashsdk.a.a(aVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList2);
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            com.uc.crashsdk.a.b(aVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList3);
        }
        if (str3 != null) {
            try {
                aVar.flush();
            } catch (Throwable th6) {
                a(th6, aVar);
            }
            try {
                aVar.write("threads dump:\n".getBytes("UTF-8"));
            } catch (Throwable th7) {
                a(th7, aVar);
            }
            f9703h = false;
            f9718w = str3;
            try {
                a(aVar, str3, j10);
            } catch (Throwable th8) {
                a(th8, aVar);
            }
            f9718w = null;
            f9703h = true;
        }
        if ((j11 & 8) != 0 && j10 == 0) {
            try {
                aVar.flush();
            } catch (Throwable th9) {
                a(th9, aVar);
            }
            try {
                aVar.write("all threads dump:\n".getBytes("UTF-8"));
            } catch (Throwable th10) {
                a(th10, aVar);
            }
            f9717v = true;
            try {
                a(aVar, "all", 0L);
            } catch (Throwable th11) {
                a(th11, aVar);
            }
            f9717v = false;
        }
        if ((j11 & 16) != 0) {
            e(aVar);
        }
        if ((j11 & 2) != 0) {
            aVar.a();
            a(aVar);
        }
        if (j10 != 0) {
            b(aVar);
        }
        try {
            arrayList4 = f9714s;
            synchronized (arrayList4) {
                f9715t++;
                String str4 = f9716u;
                if (str4 != null) {
                    arrayList4.add(str4);
                    if (arrayList4.size() > 3) {
                        arrayList4.remove(0);
                    }
                    if (com.uc.crashsdk.b.f9663d) {
                        JNIBridge.set(127, f9716u);
                    }
                    f9716u = null;
                }
                if (com.uc.crashsdk.b.f9663d) {
                    JNIBridge.set(25, f9715t);
                }
            }
        } catch (Throwable th12) {
            com.uc.crashsdk.a.g.a(th12);
        }
        return true;
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
    */
    public final void a(Thread thread, Throwable th, boolean z10) {
        boolean z11;
        ?? r12;
        Throwable th2;
        boolean z12;
        boolean i10;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        boolean z13;
        String str;
        boolean z14;
        boolean i11;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        boolean z15;
        boolean i12;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler3;
        Throwable th3;
        boolean z16;
        boolean i13;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler4;
        File file;
        boolean z17;
        boolean i14;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler5;
        boolean z18;
        boolean i15;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler6;
        boolean z19;
        boolean i16;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler7;
        boolean z20;
        boolean i17;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler8;
        boolean z21 = (ag && com.uc.crashsdk.b.f9663d) || com.uc.crashsdk.b.L();
        try {
            r12 = 4;
            if (f9699c.getAndSet(true) && Process.myPid() > 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "another thread is generating java report!");
                com.uc.crashsdk.a.a.d("DEBUG", "current thread exception is:");
                a(th);
                if (g.j()) {
                    int i18 = 0;
                    while (!V) {
                        try {
                            Thread.sleep(1000L);
                        } catch (Throwable th4) {
                            com.uc.crashsdk.a.g.a(th4);
                        }
                        i18++;
                        if (i18 >= 4) {
                            break;
                        }
                    }
                    Process.killProcess(Process.myPid());
                }
                if (z10) {
                    try {
                    } catch (Throwable th5) {
                        th = th5;
                        z20 = false;
                    }
                    if (g.s() && !z21) {
                        try {
                            a(true, false);
                            z20 = true;
                        } catch (Throwable th6) {
                            th = th6;
                            z20 = true;
                            com.uc.crashsdk.a.g.a(th);
                            if (!z20) {
                            }
                            f.c(false);
                            i17 = g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i17);
                            if (i17) {
                            }
                            if (com.uc.crashsdk.b.B()) {
                            }
                            V = true;
                            if (Process.myPid() <= 0) {
                            }
                        }
                        if (!z20 && !z21) {
                            b(false);
                        }
                        f.c(false);
                        i17 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                            i17 = true;
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i17);
                        if (i17 && (uncaughtExceptionHandler8 = T) != null) {
                            uncaughtExceptionHandler8.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B() && !z21) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (Process.myPid() <= 0 || !g.j()) {
                            return;
                        }
                        Process.killProcess(Process.myPid());
                        return;
                    }
                }
                z20 = false;
                if (!z20) {
                    b(false);
                }
                f.c(false);
                i17 = g.i();
                if (!com.uc.crashsdk.a.d.e()) {
                }
                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i17);
                if (i17) {
                    uncaughtExceptionHandler8.uncaughtException(thread, th);
                }
                if (com.uc.crashsdk.b.B()) {
                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                }
                V = true;
                if (Process.myPid() <= 0) {
                    return;
                } else {
                    return;
                }
            }
            U = th;
            if (!z21 && !com.uc.crashsdk.a.d.e()) {
                com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                if (z10) {
                    try {
                    } catch (Throwable th7) {
                        th = th7;
                        z19 = false;
                    }
                    if (g.s() && !z21) {
                        try {
                            a(true, false);
                            z19 = true;
                        } catch (Throwable th8) {
                            th = th8;
                            z19 = true;
                            com.uc.crashsdk.a.g.a(th);
                            if (!z19) {
                            }
                            f.c(false);
                            i16 = g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i16);
                            if (i16) {
                            }
                            if (com.uc.crashsdk.b.B()) {
                            }
                            V = true;
                            if (Process.myPid() <= 0) {
                            }
                        }
                        if (!z19 && !z21) {
                            b(false);
                        }
                        f.c(false);
                        i16 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                            i16 = true;
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i16);
                        if (i16 && (uncaughtExceptionHandler7 = T) != null) {
                            uncaughtExceptionHandler7.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B() && !z21) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (Process.myPid() <= 0 || !g.j()) {
                            return;
                        }
                        Process.killProcess(Process.myPid());
                        return;
                    }
                }
                z19 = false;
                if (!z19) {
                    b(false);
                }
                f.c(false);
                i16 = g.i();
                if (!com.uc.crashsdk.a.d.e()) {
                }
                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i16);
                if (i16) {
                    uncaughtExceptionHandler7.uncaughtException(thread, th);
                }
                if (com.uc.crashsdk.b.B()) {
                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                }
                V = true;
                if (Process.myPid() <= 0) {
                    return;
                } else {
                    return;
                }
            }
            com.uc.crashsdk.a.a.d("DEBUG", "encryptLog: " + g.y() + ", zipCrashLog: " + g.y());
            if (g.f9744a != null) {
                com.uc.crashsdk.a.a.d("DEBUG", "the set zip log to false stack is:");
                g.f9744a.printStackTrace();
            }
            if (g.f9745b != null) {
                com.uc.crashsdk.a.a.d("DEBUG", "the set encrypt to true stack is:");
                g.f9745b.printStackTrace();
            }
            com.uc.crashsdk.a.a.d("DEBUG", "begin to generate java report");
            try {
                N();
            } catch (Throwable th9) {
                com.uc.crashsdk.a.g.a(th9);
            }
            try {
                z13 = g.u();
                try {
                    String g10 = g.g();
                    if (g10 == null || g10.equals("")) {
                        g10 = k(S());
                    }
                    str = g.Y() + g10;
                    z11 = false;
                } catch (Throwable th10) {
                    th = th10;
                    com.uc.crashsdk.a.a.d("DEBUG", "get java log name failed: " + th);
                    a(th);
                    com.uc.crashsdk.a.a.d("DEBUG", "original exception is: " + th);
                    a(th);
                    str = null;
                    z11 = true;
                    try {
                        if (z21) {
                        }
                        boolean z22 = th instanceof OutOfMemoryError;
                        a(th, str, r12, z22);
                        com.uc.crashsdk.a.a.d("DEBUG", "generate java report finished");
                        if (!com.uc.crashsdk.b.L()) {
                            String name = new File(str).getName();
                            String Z2 = g.Z();
                            file = new File(Z2);
                            if (!file.exists()) {
                            }
                            String format = String.format(Locale.US, "%s%s.hprof", Z2, name);
                            com.uc.crashsdk.a.a.d("DEBUG", "begin dump hprof: " + format);
                            long currentTimeMillis = System.currentTimeMillis();
                            try {
                                Debug.dumpHprofData(format);
                            } catch (Throwable th11) {
                                com.uc.crashsdk.a.g.a(th11);
                            }
                            com.uc.crashsdk.a.a.d("DEBUG", "end dump hprof, use " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                        }
                        if (r12 != 0) {
                            JNIBridge.nativeClientCloseConnection(r12);
                        }
                        if (z10) {
                        }
                        z16 = false;
                        if (!z16) {
                        }
                        try {
                            f.c(false);
                        } catch (Throwable th12) {
                            com.uc.crashsdk.a.g.a(th12);
                        }
                        try {
                            i13 = g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i13);
                            if (i13) {
                            }
                            if (com.uc.crashsdk.b.B()) {
                            }
                        } catch (Throwable th13) {
                            com.uc.crashsdk.a.g.a(th13);
                        }
                        V = true;
                        if (Process.myPid() > 0) {
                        }
                    } catch (Throwable th14) {
                        th = th14;
                    }
                }
            } catch (Throwable th15) {
                th = th15;
                z13 = false;
            }
            try {
                if (z21) {
                    try {
                        g.a();
                        try {
                            if (com.uc.crashsdk.b.B()) {
                                f.a(3);
                            } else {
                                f.a(4);
                            }
                        } catch (Throwable th16) {
                            com.uc.crashsdk.a.g.a(th16);
                        }
                    } catch (Throwable th17) {
                        com.uc.crashsdk.a.g.a(th17);
                    }
                    try {
                        new File(com.uc.crashsdk.b.b()).createNewFile();
                    } catch (Throwable th18) {
                        com.uc.crashsdk.a.g.a(th18);
                    }
                    if (z13) {
                        com.uc.crashsdk.a.a.d("DEBUG", "omit java crash");
                        if (z10) {
                            try {
                            } catch (Throwable th19) {
                                th = th19;
                                z15 = false;
                            }
                            if (g.s() && !z21) {
                                try {
                                    a(true, false);
                                    z15 = true;
                                } catch (Throwable th20) {
                                    th = th20;
                                    z15 = true;
                                    com.uc.crashsdk.a.g.a(th);
                                    if (!z15) {
                                    }
                                    f.c(false);
                                    i12 = g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i12);
                                    if (i12) {
                                    }
                                    if (com.uc.crashsdk.b.B()) {
                                    }
                                    V = true;
                                    if (Process.myPid() <= 0) {
                                    }
                                }
                                if (!z15 && !z21) {
                                    b(false);
                                }
                                f.c(false);
                                i12 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    i12 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i12);
                                if (i12 && (uncaughtExceptionHandler3 = T) != null) {
                                    uncaughtExceptionHandler3.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z21) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                                V = true;
                                if (Process.myPid() <= 0 || !g.j()) {
                                    return;
                                }
                                Process.killProcess(Process.myPid());
                                return;
                            }
                        }
                        z15 = false;
                        if (!z15) {
                            b(false);
                        }
                        f.c(false);
                        i12 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i12);
                        if (i12) {
                            uncaughtExceptionHandler3.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B()) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (Process.myPid() <= 0) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (!d(LogType.JAVA_TYPE)) {
                        com.uc.crashsdk.a.a.d("DEBUG", "java log sample miss");
                        if (z10) {
                            try {
                            } catch (Throwable th21) {
                                th = th21;
                                z14 = false;
                            }
                            if (g.s() && !z21) {
                                try {
                                    a(true, false);
                                    z14 = true;
                                } catch (Throwable th22) {
                                    th = th22;
                                    z14 = true;
                                    com.uc.crashsdk.a.g.a(th);
                                    if (!z14) {
                                    }
                                    f.c(false);
                                    i11 = g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i11);
                                    if (i11) {
                                    }
                                    if (com.uc.crashsdk.b.B()) {
                                    }
                                    V = true;
                                    if (Process.myPid() <= 0) {
                                    }
                                }
                                if (!z14 && !z21) {
                                    b(false);
                                }
                                f.c(false);
                                i11 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    i11 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i11);
                                if (i11 && (uncaughtExceptionHandler2 = T) != null) {
                                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z21) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                                V = true;
                                if (Process.myPid() <= 0 || !g.j()) {
                                    return;
                                }
                                Process.killProcess(Process.myPid());
                                return;
                            }
                        }
                        z14 = false;
                        if (!z14) {
                            b(false);
                        }
                        f.c(false);
                        i11 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i11);
                        if (i11) {
                            uncaughtExceptionHandler2.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B()) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (Process.myPid() <= 0) {
                            return;
                        } else {
                            return;
                        }
                    }
                    r12 = 0;
                } else {
                    if (z13) {
                        str = "omit";
                        com.uc.crashsdk.a.a.d("DEBUG", "omit java crash");
                    }
                    long nativeClientCreateConnection = com.uc.crashsdk.b.f9663d ? JNIBridge.nativeClientCreateConnection(str, LogType.JAVA_TYPE, null, 0) : 0L;
                    r12 = nativeClientCreateConnection;
                    if (nativeClientCreateConnection == 0) {
                        com.uc.crashsdk.a.a.d("DEBUG", "skip java crash:");
                        a(th);
                        if (nativeClientCreateConnection != 0 && com.uc.crashsdk.b.f9663d) {
                            JNIBridge.nativeClientCloseConnection(nativeClientCreateConnection);
                        }
                        if (z10) {
                            try {
                            } catch (Throwable th23) {
                                th = th23;
                                z18 = false;
                            }
                            if (g.s() && !z21) {
                                try {
                                    a(true, false);
                                    z18 = true;
                                } catch (Throwable th24) {
                                    th = th24;
                                    z18 = true;
                                    com.uc.crashsdk.a.g.a(th);
                                    if (!z18) {
                                    }
                                    f.c(false);
                                    i15 = g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i15);
                                    if (i15) {
                                    }
                                    if (com.uc.crashsdk.b.B()) {
                                    }
                                    V = true;
                                    if (Process.myPid() <= 0) {
                                    }
                                }
                                if (!z18 && !z21) {
                                    b(false);
                                }
                                f.c(false);
                                i15 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    i15 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i15);
                                if (i15 && (uncaughtExceptionHandler6 = T) != null) {
                                    uncaughtExceptionHandler6.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z21) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                                V = true;
                                if (Process.myPid() <= 0 || !g.j()) {
                                    return;
                                }
                                Process.killProcess(Process.myPid());
                                return;
                            }
                        }
                        z18 = false;
                        if (!z18) {
                            b(false);
                        }
                        f.c(false);
                        i15 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i15);
                        if (i15) {
                            uncaughtExceptionHandler6.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B()) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (Process.myPid() <= 0) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (z13) {
                        if (nativeClientCreateConnection != 0 && com.uc.crashsdk.b.f9663d) {
                            JNIBridge.nativeClientCloseConnection(nativeClientCreateConnection);
                        }
                        if (z10) {
                            try {
                            } catch (Throwable th25) {
                                th = th25;
                                z17 = false;
                            }
                            if (g.s() && !z21) {
                                try {
                                    a(true, false);
                                    z17 = true;
                                } catch (Throwable th26) {
                                    th = th26;
                                    z17 = true;
                                    com.uc.crashsdk.a.g.a(th);
                                    if (!z17) {
                                    }
                                    f.c(false);
                                    i14 = g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i14);
                                    if (i14) {
                                    }
                                    if (com.uc.crashsdk.b.B()) {
                                    }
                                    V = true;
                                    if (Process.myPid() <= 0) {
                                    }
                                }
                                if (!z17 && !z21) {
                                    b(false);
                                }
                                f.c(false);
                                i14 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    i14 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i14);
                                if (i14 && (uncaughtExceptionHandler5 = T) != null) {
                                    uncaughtExceptionHandler5.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z21) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                                V = true;
                                if (Process.myPid() <= 0 || !g.j()) {
                                    return;
                                }
                                Process.killProcess(Process.myPid());
                                return;
                            }
                        }
                        z17 = false;
                        if (!z17) {
                            b(false);
                        }
                        f.c(false);
                        i14 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i14);
                        if (i14) {
                            uncaughtExceptionHandler5.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B()) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (Process.myPid() <= 0) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
                boolean z222 = th instanceof OutOfMemoryError;
                a(th, str, r12, z222);
                com.uc.crashsdk.a.a.d("DEBUG", "generate java report finished");
                if (!com.uc.crashsdk.b.L() && z222 && g.k()) {
                    String name2 = new File(str).getName();
                    String Z22 = g.Z();
                    file = new File(Z22);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String format2 = String.format(Locale.US, "%s%s.hprof", Z22, name2);
                    com.uc.crashsdk.a.a.d("DEBUG", "begin dump hprof: " + format2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Debug.dumpHprofData(format2);
                    com.uc.crashsdk.a.a.d("DEBUG", "end dump hprof, use " + (System.currentTimeMillis() - currentTimeMillis2) + " ms");
                }
                if (r12 != 0 && com.uc.crashsdk.b.f9663d) {
                    JNIBridge.nativeClientCloseConnection(r12);
                }
                if (z10) {
                    try {
                    } catch (Throwable th27) {
                        th3 = th27;
                        z16 = false;
                    }
                    if (g.s() && !z21) {
                        try {
                            a(true, false);
                            z16 = true;
                        } catch (Throwable th28) {
                            th3 = th28;
                            z16 = true;
                            com.uc.crashsdk.a.g.a(th3);
                            if (!z16) {
                            }
                            f.c(false);
                            i13 = g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i13);
                            if (i13) {
                            }
                            if (com.uc.crashsdk.b.B()) {
                            }
                            V = true;
                            if (Process.myPid() > 0) {
                            }
                        }
                        if (!z16 && !z21) {
                            b(false);
                        }
                        f.c(false);
                        i13 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                            i13 = true;
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i13);
                        if (i13 && (uncaughtExceptionHandler4 = T) != null) {
                            uncaughtExceptionHandler4.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B() && !z21) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                        V = true;
                        if (Process.myPid() > 0 || !g.j()) {
                            return;
                        }
                        Process.killProcess(Process.myPid());
                        return;
                    }
                }
                z16 = false;
                if (!z16) {
                    b(false);
                }
                f.c(false);
                i13 = g.i();
                if (!com.uc.crashsdk.a.d.e()) {
                }
                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i13);
                if (i13) {
                    uncaughtExceptionHandler4.uncaughtException(thread, th);
                }
                if (com.uc.crashsdk.b.B()) {
                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                }
                V = true;
                if (Process.myPid() > 0) {
                    return;
                } else {
                    return;
                }
            } catch (Throwable th29) {
                th = th29;
            }
        } catch (Throwable th30) {
            th = th30;
            z11 = false;
        }
        th = th30;
        z11 = false;
        r12 = 0;
        try {
            com.uc.crashsdk.a.a.d("DEBUG", "exception occurs while java log: " + th);
            a(th);
            if (!z11) {
                com.uc.crashsdk.a.a.d("DEBUG", "original exception is: " + th);
                a(th);
            }
            if (r12 != 0 && com.uc.crashsdk.b.f9663d) {
                JNIBridge.nativeClientCloseConnection(r12);
            }
            if (z10) {
                try {
                } catch (Throwable th31) {
                    th2 = th31;
                    z12 = false;
                }
                if (g.s() && !z21) {
                    try {
                        a(true, false);
                        z12 = true;
                    } catch (Throwable th32) {
                        th2 = th32;
                        z12 = true;
                        com.uc.crashsdk.a.g.a(th2);
                        if (!z12) {
                        }
                        f.c(false);
                        i10 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i10);
                        if (i10) {
                        }
                        if (com.uc.crashsdk.b.B()) {
                        }
                        V = true;
                        if (Process.myPid() <= 0) {
                        }
                    }
                    if (!z12 && !z21) {
                        b(false);
                    }
                    f.c(false);
                    i10 = g.i();
                    if (!com.uc.crashsdk.a.d.e()) {
                        i10 = true;
                    }
                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i10);
                    if (i10 && (uncaughtExceptionHandler = T) != null) {
                        uncaughtExceptionHandler.uncaughtException(thread, th);
                    }
                    if (com.uc.crashsdk.b.B() && !z21) {
                        com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                    }
                    V = true;
                    if (Process.myPid() <= 0 || !g.j()) {
                    }
                    Process.killProcess(Process.myPid());
                    return;
                }
            }
            z12 = false;
            if (!z12) {
                b(false);
            }
            f.c(false);
            i10 = g.i();
            if (!com.uc.crashsdk.a.d.e()) {
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i10);
            if (i10) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
            if (com.uc.crashsdk.b.B()) {
                com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
            }
            V = true;
            if (Process.myPid() <= 0) {
            }
        } finally {
        }
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
