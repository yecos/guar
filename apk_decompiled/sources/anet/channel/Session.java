package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.StringUtils;
import com.hpplay.sdk.source.common.global.Constant;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* loaded from: classes.dex */
public abstract class Session implements Comparable<Session> {

    /* renamed from: v, reason: collision with root package name */
    static ExecutorService f3811v = Executors.newSingleThreadExecutor();

    /* renamed from: a, reason: collision with root package name */
    protected Context f3812a;

    /* renamed from: c, reason: collision with root package name */
    protected String f3814c;

    /* renamed from: d, reason: collision with root package name */
    protected String f3815d;

    /* renamed from: e, reason: collision with root package name */
    protected String f3816e;

    /* renamed from: f, reason: collision with root package name */
    protected String f3817f;

    /* renamed from: g, reason: collision with root package name */
    protected int f3818g;

    /* renamed from: h, reason: collision with root package name */
    protected String f3819h;

    /* renamed from: i, reason: collision with root package name */
    protected int f3820i;

    /* renamed from: j, reason: collision with root package name */
    protected ConnType f3821j;

    /* renamed from: k, reason: collision with root package name */
    protected IConnStrategy f3822k;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f3824m;

    /* renamed from: o, reason: collision with root package name */
    protected Runnable f3826o;

    /* renamed from: p, reason: collision with root package name */
    public final String f3827p;

    /* renamed from: q, reason: collision with root package name */
    public final SessionStatistic f3828q;

    /* renamed from: r, reason: collision with root package name */
    protected int f3829r;

    /* renamed from: s, reason: collision with root package name */
    protected int f3830s;

    /* renamed from: x, reason: collision with root package name */
    private Future<?> f3834x;

    /* renamed from: b, reason: collision with root package name */
    Map<EventCb, Integer> f3813b = new LinkedHashMap();

    /* renamed from: w, reason: collision with root package name */
    private boolean f3833w = false;

    /* renamed from: l, reason: collision with root package name */
    protected String f3823l = null;

    /* renamed from: n, reason: collision with root package name */
    protected int f3825n = 6;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f3831t = false;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f3832u = true;

    /* renamed from: y, reason: collision with root package name */
    private List<Long> f3835y = null;

    /* renamed from: z, reason: collision with root package name */
    private long f3836z = 0;

    public static class a {
        public static final int AUTHING = 3;
        public static final int AUTH_FAIL = 5;
        public static final int AUTH_SUCC = 4;
        public static final int CONNECTED = 0;
        public static final int CONNECTING = 1;
        public static final int CONNETFAIL = 2;
        public static final int DISCONNECTED = 6;
        public static final int DISCONNECTING = 7;

        /* renamed from: a, reason: collision with root package name */
        static final String[] f3837a = {"CONNECTED", "CONNECTING", "CONNETFAIL", "AUTHING", "AUTH_SUCC", "AUTH_FAIL", "DISCONNECTED", "DISCONNECTING"};

        public static String a(int i10) {
            return f3837a[i10];
        }
    }

    public Session(Context context, anet.channel.entity.a aVar) {
        boolean z10 = false;
        this.f3824m = false;
        this.f3812a = context;
        String a10 = aVar.a();
        this.f3816e = a10;
        this.f3817f = a10;
        this.f3818g = aVar.b();
        this.f3821j = aVar.c();
        String f10 = aVar.f();
        this.f3814c = f10;
        this.f3815d = f10.substring(f10.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.f3830s = aVar.e();
        this.f3829r = aVar.d();
        IConnStrategy iConnStrategy = aVar.f3964a;
        this.f3822k = iConnStrategy;
        if (iConnStrategy != null && iConnStrategy.getIpType() == -1) {
            z10 = true;
        }
        this.f3824m = z10;
        this.f3827p = aVar.h();
        SessionStatistic sessionStatistic = new SessionStatistic(aVar);
        this.f3828q = sessionStatistic;
        sessionStatistic.host = this.f3815d;
    }

    public static void configTnetALog(Context context, String str, int i10, int i11) {
        SpdyAgent spdyAgent = SpdyAgent.getInstance(context, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (spdyAgent == null || !SpdyAgent.checkLoadSucc()) {
            ALog.e("agent null or configTnetALog load so fail!!!", null, "loadso", Boolean.valueOf(SpdyAgent.checkLoadSucc()));
        } else {
            spdyAgent.configLogFile(str, i10, i11);
        }
    }

    public void cancelTimeout() {
        Future<?> future;
        if (this.f3826o == null || (future = this.f3834x) == null) {
            return;
        }
        future.cancel(true);
    }

    public void checkAvailable() {
        ping(true);
    }

    public abstract void close();

    public void close(boolean z10) {
        this.f3831t = z10;
        close();
    }

    public void connect() {
    }

    public IConnStrategy getConnStrategy() {
        return this.f3822k;
    }

    public ConnType getConnType() {
        return this.f3821j;
    }

    public String getHost() {
        return this.f3814c;
    }

    public String getIp() {
        return this.f3816e;
    }

    public int getPort() {
        return this.f3818g;
    }

    public String getRealHost() {
        return this.f3815d;
    }

    public abstract Runnable getRecvTimeOutRunnable();

    public String getUnit() {
        return this.f3823l;
    }

    public void handleCallbacks(int i10, anet.channel.entity.b bVar) {
        f3811v.submit(new b(this, i10, bVar));
    }

    public void handleResponseCode(Request request, int i10) {
        if (request.getHeaders().containsKey(HttpConstant.X_PV) && i10 >= 500 && i10 < 600) {
            synchronized (this) {
                if (this.f3835y == null) {
                    this.f3835y = new LinkedList();
                }
                if (this.f3835y.size() < 5) {
                    this.f3835y.add(Long.valueOf(System.currentTimeMillis()));
                } else {
                    long longValue = this.f3835y.remove(0).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - longValue <= 60000) {
                        StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                        this.f3835y.clear();
                    } else {
                        this.f3835y.add(Long.valueOf(currentTimeMillis));
                    }
                }
            }
        }
    }

    public void handleResponseHeaders(Request request, Map<String, List<String>> map) {
        try {
            if (map.containsKey(HttpConstant.X_SWITCH_UNIT)) {
                String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.X_SWITCH_UNIT);
                if (TextUtils.isEmpty(singleHeaderFieldByKey)) {
                    singleHeaderFieldByKey = null;
                }
                if (StringUtils.isStringEqual(this.f3823l, singleHeaderFieldByKey)) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f3836z > 60000) {
                    StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                    this.f3836z = currentTimeMillis;
                }
            }
        } catch (Exception unused) {
        }
    }

    public abstract boolean isAvailable();

    public synchronized void notifyStatus(int i10, anet.channel.entity.b bVar) {
        ALog.e("awcn.Session", "notifyStatus", this.f3827p, Constant.KEY_STATUS, a.a(i10));
        if (i10 == this.f3825n) {
            ALog.i("awcn.Session", "ignore notifyStatus", this.f3827p, new Object[0]);
            return;
        }
        this.f3825n = i10;
        if (i10 == 0) {
            handleCallbacks(1, bVar);
        } else if (i10 == 2) {
            handleCallbacks(256, bVar);
        } else if (i10 == 4) {
            this.f3823l = StrategyCenter.getInstance().getUnitByHost(this.f3815d);
            handleCallbacks(512, bVar);
        } else if (i10 == 5) {
            handleCallbacks(1024, bVar);
        } else if (i10 == 6) {
            onDisconnect();
            if (!this.f3833w) {
                handleCallbacks(2, bVar);
            }
        }
    }

    public void onDisconnect() {
    }

    public void ping(boolean z10) {
    }

    public void registerEventcb(int i10, EventCb eventCb) {
        Map<EventCb, Integer> map = this.f3813b;
        if (map != null) {
            map.put(eventCb, Integer.valueOf(i10));
        }
    }

    public abstract Cancelable request(Request request, RequestCb requestCb);

    public void sendCustomFrame(int i10, byte[] bArr, int i11) {
    }

    public void setPingTimeout(int i10) {
        if (this.f3826o == null) {
            this.f3826o = getRecvTimeOutRunnable();
        }
        cancelTimeout();
        Runnable runnable = this.f3826o;
        if (runnable != null) {
            this.f3834x = ThreadPoolExecutorFactory.submitScheduledTask(runnable, i10, TimeUnit.MILLISECONDS);
        }
    }

    public String toString() {
        return "Session@[" + this.f3827p + '|' + this.f3821j + ']';
    }

    public void unReceiveEventCb(EventCb eventCb) {
        Map<EventCb, Integer> map = this.f3813b;
        if (map != null) {
            map.remove(eventCb);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Session session) {
        return ConnType.compare(this.f3821j, session.f3821j);
    }

    public void ping(boolean z10, int i10) {
    }
}
