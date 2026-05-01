package com.taobao.accs.net;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushRegisterCallback;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class a {
    public static final int ACCS_RECEIVE_TIMEOUT = 40000;
    public static final int INAPP = 1;
    public static final int SERVICE = 0;

    /* renamed from: n, reason: collision with root package name */
    protected static int f9156n;

    /* renamed from: b, reason: collision with root package name */
    public String f9158b;

    /* renamed from: c, reason: collision with root package name */
    protected int f9159c;

    /* renamed from: d, reason: collision with root package name */
    protected Context f9160d;

    /* renamed from: e, reason: collision with root package name */
    protected com.taobao.accs.data.d f9161e;

    /* renamed from: h, reason: collision with root package name */
    public com.taobao.accs.client.b f9164h;

    /* renamed from: i, reason: collision with root package name */
    public AccsClientConfig f9165i;

    /* renamed from: j, reason: collision with root package name */
    protected String f9166j;

    /* renamed from: m, reason: collision with root package name */
    public String f9169m;

    /* renamed from: r, reason: collision with root package name */
    private Runnable f9173r;

    /* renamed from: s, reason: collision with root package name */
    private ScheduledFuture<?> f9174s;

    /* renamed from: a, reason: collision with root package name */
    public String f9157a = "android@umeng";

    /* renamed from: f, reason: collision with root package name */
    protected int f9162f = 0;

    /* renamed from: o, reason: collision with root package name */
    private long f9170o = 0;

    /* renamed from: g, reason: collision with root package name */
    protected volatile boolean f9163g = false;

    /* renamed from: k, reason: collision with root package name */
    protected String f9167k = null;

    /* renamed from: p, reason: collision with root package name */
    private boolean f9171p = false;

    /* renamed from: l, reason: collision with root package name */
    protected LinkedHashMap<Integer, Message> f9168l = new LinkedHashMap<Integer, Message>() { // from class: com.taobao.accs.net.BaseConnection$1
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<Integer, Message> entry) {
            return size() > 10;
        }
    };

    /* renamed from: q, reason: collision with root package name */
    private final ArrayList<AccsConnectStateListener> f9172q = new ArrayList<>();

    public a(Context context, int i10, String str) {
        this.f9158b = "";
        this.f9159c = i10;
        this.f9160d = context.getApplicationContext();
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        this.f9165i = configByTag;
        if (configByTag == null) {
            ALog.e(d(), "BaseConnection config null!!", new Object[0]);
            try {
                int i11 = PushAgent.f11346a;
                Object invoke = PushAgent.class.getMethod("getInstance", Context.class).invoke(null, context);
                PushAgent.class.getMethod(com.taobao.agoo.a.a.c.JSON_CMD_REGISTER, UPushRegisterCallback.class).invoke(invoke, PushAgent.class.getMethod("getRegisterCallback", new Class[0]).invoke(invoke, new Object[0]));
                this.f9165i = AccsClientConfig.getConfigByTag(str);
            } catch (Throwable th) {
                ALog.e(d(), "BaseConnection build config", th, new Object[0]);
            }
        }
        AccsClientConfig accsClientConfig = this.f9165i;
        if (accsClientConfig != null) {
            this.f9169m = accsClientConfig.getTag();
            this.f9158b = this.f9165i.getAppKey();
        }
        com.taobao.accs.data.d dVar = new com.taobao.accs.data.d(context, this);
        this.f9161e = dVar;
        dVar.f9104b = this.f9159c;
        ALog.d(d(), "new connection", new Object[0]);
    }

    public String a(int i10) {
        return i10 != 1 ? i10 != 2 ? (i10 == 3 || i10 != 4) ? "DISCONNECTED" : "DISCONNECTING" : "CONNECTING" : "CONNECTED";
    }

    public abstract void a();

    public abstract void a(Message message, boolean z10);

    public abstract void a(String str, boolean z10, String str2);

    public abstract void a(boolean z10, boolean z11);

    public abstract boolean a(String str);

    public abstract void b();

    public void b(Message message, boolean z10) {
        if (!message.isAck && !UtilityImpl.i(this.f9160d)) {
            ALog.e(d(), "sendMessage ready no network", Constants.KEY_DATA_ID, message.dataId);
            this.f9161e.a(message, -13);
            return;
        }
        long a10 = message.getType() != 2 ? this.f9161e.f9106d.a(message.serviceId, message.bizId) : 0L;
        if (a10 == -1) {
            ALog.e(d(), "sendMessage ready server limit high", Constants.KEY_DATA_ID, message.dataId);
            this.f9161e.a(message, ErrorCode.SERVIER_HIGH_LIMIT);
            return;
        }
        if (a10 == -1000) {
            ALog.e(d(), "sendMessage ready server limit high for brush", Constants.KEY_DATA_ID, message.dataId);
            this.f9161e.a(message, ErrorCode.SERVIER_HIGH_LIMIT_BRUSH);
            return;
        }
        if (a10 > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j10 = this.f9170o;
            if (currentTimeMillis > j10) {
                message.delyTime = a10;
            } else {
                message.delyTime = (j10 + a10) - System.currentTimeMillis();
            }
            this.f9170o = System.currentTimeMillis() + message.delyTime;
            ALog.e(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        } else if ("accs".equals(message.serviceId)) {
            ALog.e(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        } else if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        }
        try {
            if (TextUtils.isEmpty(this.f9166j)) {
                this.f9166j = UtilityImpl.j(this.f9160d);
            }
            if (message.isTimeOut()) {
                this.f9161e.a(message, -9);
            } else {
                a(message, z10);
            }
        } catch (RejectedExecutionException unused) {
            this.f9161e.a(message, ErrorCode.MESSAGE_QUEUE_FULL);
            ALog.e(d(), "sendMessage ready queue full", "size", Integer.valueOf(ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size()));
        }
    }

    public abstract com.taobao.accs.ut.a.c c();

    public String c(String str) {
        String str2;
        String j10 = UtilityImpl.j(this.f9160d);
        try {
            str2 = URLEncoder.encode(j10);
        } catch (Throwable th) {
            ALog.e(d(), "buildAuthUrl", th, new Object[0]);
            str2 = j10;
        }
        String a10 = UtilityImpl.a(i(), this.f9165i.getAppSecret(), j10);
        StringBuilder sb = new StringBuilder(256);
        sb.append(str);
        sb.append("auth?1=");
        sb.append(str2);
        sb.append("&2=");
        sb.append(a10);
        sb.append("&3=");
        sb.append(i());
        if (this.f9167k != null) {
            sb.append("&4=");
            sb.append(this.f9167k);
        }
        sb.append("&5=");
        sb.append(this.f9159c);
        sb.append("&6=");
        sb.append(UtilityImpl.g(this.f9160d));
        sb.append("&7=");
        sb.append(UtilityImpl.d());
        sb.append("&8=");
        sb.append(this.f9159c == 1 ? "1.1.2" : Integer.valueOf(Constants.SDK_VERSION_CODE));
        sb.append("&9=");
        sb.append(System.currentTimeMillis());
        sb.append("&10=");
        sb.append(1);
        sb.append("&11=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("&12=");
        sb.append(this.f9160d.getPackageName());
        sb.append("&13=");
        sb.append(UtilityImpl.l(this.f9160d));
        sb.append("&14=");
        sb.append(this.f9157a);
        sb.append("&15=");
        sb.append(UtilityImpl.b(Build.MODEL));
        sb.append("&16=");
        sb.append(UtilityImpl.b(Build.BRAND));
        sb.append("&17=");
        sb.append("221");
        sb.append("&19=");
        sb.append(!l() ? 1 : 0);
        sb.append("&20=");
        sb.append(this.f9165i.getStoreId());
        return sb.toString();
    }

    public abstract String d();

    public void e() {
    }

    public void f() {
        if (this.f9173r == null) {
            this.f9173r = new c(this);
        }
        g();
        this.f9174s = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.f9173r, 40000L, TimeUnit.MILLISECONDS);
    }

    public void g() {
        ScheduledFuture<?> scheduledFuture = this.f9174s;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public boolean h() {
        return true;
    }

    public String i() {
        return this.f9158b;
    }

    public com.taobao.accs.client.b j() {
        if (this.f9164h == null) {
            ALog.d(d(), "new ClientManager", Constants.KEY_CONFIG_TAG, this.f9169m);
            this.f9164h = new com.taobao.accs.client.b(this.f9160d, this.f9169m);
        }
        return this.f9164h;
    }

    public void k() {
        try {
            ThreadPoolExecutorFactory.schedule(new d(this), NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            ALog.w(d(), "startChannelService", th, new Object[0]);
        }
    }

    public boolean l() {
        return 2 == this.f9165i.getSecurity();
    }

    public boolean m() {
        return false;
    }

    public ArrayList<AccsConnectStateListener> n() {
        return this.f9172q;
    }

    public void a(String str, boolean z10, long j10) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new b(this, str, z10), j10, TimeUnit.MILLISECONDS);
    }

    public boolean a(Message message, int i10) {
        boolean z10;
        int i11;
        try {
            i11 = message.retryTimes;
        } catch (Throwable th) {
            th = th;
            z10 = false;
        }
        if (i11 > 3) {
            return false;
        }
        z10 = true;
        message.retryTimes = i11 + 1;
        message.delyTime = i10;
        ALog.e(d(), "reSend dataid:" + message.dataId + " retryTimes:" + message.retryTimes, new Object[0]);
        b(message, true);
        try {
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().take_date = 0L;
                message.getNetPermanceMonitor().to_tnet_date = 0L;
                NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
                int i12 = message.retryTimes;
                netPermanceMonitor.retry_times = i12;
                if (i12 == 1) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total", 0.0d);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            this.f9161e.a(message, -8);
            ALog.e(d(), "reSend error", th, new Object[0]);
            return z10;
        }
        return z10;
    }

    public void a(Context context) {
        try {
            ENV env = ENV.ONLINE;
            int i10 = AccsClientConfig.mEnv;
            if (i10 == 2) {
                env = ENV.TEST;
                SessionCenter.switchEnvironment(env);
            } else if (i10 == 1) {
                env = ENV.PREPARE;
                SessionCenter.switchEnvironment(env);
            }
            SessionCenter.init(context, new Config.Builder().setAppkey(this.f9158b).setAppSecret(this.f9165i.getAppSecret()).setAuthCode(this.f9165i.getAuthCode()).setEnv(env).setTag(this.f9165i.getAppKey()).build());
            String str = ConnType.PK_ACS;
            if (this.f9165i.getInappPubKey() == 10 || this.f9165i.getInappPubKey() == 11) {
                str = ConnType.PK_OPEN;
            }
            ALog.i(d(), "init awcn register new conn protocol host:", this.f9165i.getInappHost());
            StrategyTemplate.getInstance().registerConnProtocol(this.f9165i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
        } catch (Throwable th) {
            ALog.e(d(), "initAwcn", th, new Object[0]);
        }
    }

    public void b(int i10) {
        if (i10 < 0) {
            ALog.e(d(), "reSendAck", Constants.KEY_DATA_ID, Integer.valueOf(i10));
            Message message = this.f9168l.get(Integer.valueOf(i10));
            if (message != null) {
                a(message, com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT);
                com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, BaseMonitor.COUNT_ACK, 0.0d);
            }
        }
    }

    public void c(int i10) {
        f9156n = i10 != 1 ? 0 : 1;
    }

    public String b(String str) {
        String inappHost = this.f9165i.getInappHost();
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(TextUtils.isEmpty(str) ? "" : str);
        sb.append(inappHost);
        String sb2 = sb.toString();
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("https://");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb3.append(str);
            sb3.append(inappHost);
            return sb3.toString();
        } catch (Throwable th) {
            ALog.e("InAppConnection", "getHost", th, new Object[0]);
            return sb2;
        }
    }

    public void a(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.f9172q) {
            this.f9172q.add(accsConnectStateListener);
        }
    }

    public void b(Message message, int i10) {
        this.f9161e.a(message, i10);
    }

    public void b(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.f9172q) {
            this.f9172q.remove(accsConnectStateListener);
        }
    }
}
