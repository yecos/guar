package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static int f4010a = 0;

    /* renamed from: b, reason: collision with root package name */
    static long f4011b = 0;

    /* renamed from: c, reason: collision with root package name */
    static long f4012c = 0;

    /* renamed from: d, reason: collision with root package name */
    static long f4013d = 0;

    /* renamed from: e, reason: collision with root package name */
    static long f4014e = 0;

    /* renamed from: f, reason: collision with root package name */
    static long f4015f = 0;

    /* renamed from: g, reason: collision with root package name */
    static double f4016g = 0.0d;

    /* renamed from: h, reason: collision with root package name */
    static double f4017h = 0.0d;

    /* renamed from: i, reason: collision with root package name */
    static double f4018i = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    static double f4019j = 40.0d;

    /* renamed from: k, reason: collision with root package name */
    private static volatile boolean f4020k = false;

    /* renamed from: l, reason: collision with root package name */
    private int f4021l;

    /* renamed from: m, reason: collision with root package name */
    private int f4022m;

    /* renamed from: n, reason: collision with root package name */
    private e f4023n;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static b f4024a = new b(null);
    }

    public /* synthetic */ b(c cVar) {
        this();
    }

    public static /* synthetic */ int b(b bVar) {
        int i10 = bVar.f4022m;
        bVar.f4022m = i10 + 1;
        return i10;
    }

    public synchronized void d() {
        try {
            ALog.i("awcn.BandWidthSampler", "[startNetworkMeter]", null, "NetworkStatus", NetworkStatusHelper.getStatus());
        } catch (Exception e10) {
            ALog.w("awcn.BandWidthSampler", "startNetworkMeter fail.", null, e10, new Object[0]);
        }
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            f4020k = false;
        } else {
            f4020k = true;
        }
    }

    public void e() {
        f4020k = false;
    }

    private b() {
        this.f4021l = 5;
        this.f4022m = 0;
        this.f4023n = new e();
        NetworkStatusHelper.addStatusChangeListener(new c(this));
    }

    public double c() {
        return f4018i;
    }

    public static b a() {
        return a.f4024a;
    }

    public int b() {
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            return 1;
        }
        return this.f4021l;
    }

    public void a(long j10, long j11, long j12) {
        if (f4020k) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "onDataReceived", null, "mRequestStartTime", Long.valueOf(j10), "mRequestFinishedTime", Long.valueOf(j11), "mRequestDataSize", Long.valueOf(j12));
            }
            if (j12 <= 3000 || j10 >= j11) {
                return;
            }
            ThreadPoolExecutorFactory.submitScheduledTask(new d(this, j12, j11, j10));
        }
    }
}
