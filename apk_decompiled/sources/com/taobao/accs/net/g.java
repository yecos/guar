package com.taobao.accs.net;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.internal.AccsJobService;
import com.taobao.accs.utl.ALog;

/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: b, reason: collision with root package name */
    protected static volatile g f9183b;

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f9184c = {270, 360, 480};

    /* renamed from: a, reason: collision with root package name */
    protected Context f9185a;

    /* renamed from: d, reason: collision with root package name */
    private int f9186d;

    /* renamed from: e, reason: collision with root package name */
    private long f9187e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9188f = false;

    /* renamed from: g, reason: collision with root package name */
    private int[] f9189g = {0, 0, 0};

    /* renamed from: h, reason: collision with root package name */
    private boolean f9190h;

    public g(Context context) {
        this.f9190h = true;
        try {
            this.f9185a = context;
            this.f9186d = 0;
            this.f9187e = System.currentTimeMillis();
            this.f9190h = com.taobao.accs.utl.t.a();
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "HeartbeatManager", th, new Object[0]);
        }
    }

    public static g a(Context context) {
        if (f9183b == null) {
            synchronized (g.class) {
                if (f9183b == null) {
                    if (GlobalConfig.isJobHeartbeatEnable() && Build.VERSION.SDK_INT >= 21 && b(context)) {
                        ALog.i("HeartbeatManager", "hb use job", new Object[0]);
                        f9183b = new f(context);
                    } else {
                        ALog.i("HeartbeatManager", "hb use alarm", new Object[0]);
                        f9183b = new e(context);
                    }
                }
            }
        }
        return f9183b;
    }

    private static boolean b(Context context) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), AccsJobService.class.getName()), 0);
            if (serviceInfo != null) {
                return serviceInfo.isEnabled();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public abstract void a(int i10);

    public void c() {
        this.f9187e = -1L;
        if (this.f9188f) {
            int[] iArr = this.f9189g;
            int i10 = this.f9186d;
            iArr[i10] = iArr[i10] + 1;
        }
        int i11 = this.f9186d;
        this.f9186d = i11 > 0 ? i11 - 1 : 0;
        ALog.d("HeartbeatManager", "onNetworkTimeout", new Object[0]);
    }

    public void d() {
        this.f9187e = -1L;
        ALog.d("HeartbeatManager", "onNetworkFail", new Object[0]);
    }

    public void e() {
        ALog.d("HeartbeatManager", "onHeartbeatSucc", new Object[0]);
        if (System.currentTimeMillis() - this.f9187e <= 7199000) {
            this.f9188f = false;
            this.f9189g[this.f9186d] = 0;
            return;
        }
        int i10 = this.f9186d;
        if (i10 >= f9184c.length - 1 || this.f9189g[i10] > 2) {
            return;
        }
        ALog.d("HeartbeatManager", "upgrade", new Object[0]);
        this.f9186d++;
        this.f9188f = true;
        this.f9187e = System.currentTimeMillis();
    }

    public void f() {
        this.f9186d = 0;
        this.f9187e = System.currentTimeMillis();
        ALog.d("HeartbeatManager", "resetLevel", new Object[0]);
    }

    public int b() {
        int i10 = this.f9190h ? f9184c[this.f9186d] : 270;
        this.f9190h = com.taobao.accs.utl.t.a();
        return i10;
    }

    public synchronized void a() {
        try {
            if (this.f9187e < 0) {
                this.f9187e = System.currentTimeMillis();
            }
            int b10 = b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("HeartbeatManager", "set " + b10, new Object[0]);
            }
            a(b10);
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "set", th, new Object[0]);
        }
    }
}
