package com.taobao.accs.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.ISessionListener;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionInfo;
import anet.channel.entity.ConnType;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class k extends com.taobao.accs.net.a implements DataFrameCb {

    /* renamed from: o, reason: collision with root package name */
    private boolean f9195o;

    /* renamed from: p, reason: collision with root package name */
    private long f9196p;

    /* renamed from: q, reason: collision with root package name */
    private ScheduledFuture f9197q;

    /* renamed from: r, reason: collision with root package name */
    private Handler f9198r;

    /* renamed from: s, reason: collision with root package name */
    private Runnable f9199s;

    /* renamed from: t, reason: collision with root package name */
    private ISessionListener f9200t;

    /* renamed from: u, reason: collision with root package name */
    private Runnable f9201u;

    /* renamed from: v, reason: collision with root package name */
    private Set<String> f9202v;

    public static class a implements IAuth {

        /* renamed from: a, reason: collision with root package name */
        private String f9203a;

        /* renamed from: b, reason: collision with root package name */
        private int f9204b;

        /* renamed from: c, reason: collision with root package name */
        private String f9205c;

        /* renamed from: d, reason: collision with root package name */
        private com.taobao.accs.net.a f9206d;

        public a(com.taobao.accs.net.a aVar, String str) {
            this.f9205c = aVar.d();
            this.f9203a = aVar.c("https://" + str + "/accs/");
            this.f9204b = aVar.f9159c;
            this.f9206d = aVar;
        }

        @Override // anet.channel.IAuth
        public void auth(Session session, IAuth.AuthCallback authCallback) {
            ALog.e(this.f9205c, BaseMonitor.ALARM_POINT_AUTH, "URL", this.f9203a);
            session.request(new Request.Builder().setUrl(this.f9203a).build(), new u(this, authCallback));
        }
    }

    public k(Context context, int i10, String str) {
        super(context, i10, str);
        this.f9195o = true;
        this.f9196p = 3600000L;
        this.f9198r = new Handler(Looper.getMainLooper());
        this.f9199s = new l(this);
        this.f9200t = new m(this);
        this.f9201u = new t(this);
        this.f9202v = Collections.synchronizedSet(new HashSet());
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.f9201u, 120000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f9165i.isAccsHeartbeatEnable()) {
            ALog.e(d(), "startAccsHeartBeat", new Object[0]);
            ScheduledFuture scheduledFuture = this.f9197q;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
            Runnable runnable = this.f9199s;
            long j10 = this.f9196p;
            this.f9197q = scheduledExecutor.scheduleAtFixedRate(runnable, j10, j10, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.taobao.accs.net.a
    public com.taobao.accs.ut.a.c c() {
        return null;
    }

    @Override // com.taobao.accs.net.a
    public String d() {
        return "InAppConn_" + this.f9169m;
    }

    @Override // com.taobao.accs.net.a
    public void e() {
        ALog.e(d(), "shut down", new Object[0]);
        this.f9195o = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f A[Catch: all -> 0x0046, TRY_LEAVE, TryCatch #0 {all -> 0x0046, blocks: (B:4:0x0005, B:6:0x002a, B:10:0x0034, B:12:0x003f), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // com.taobao.accs.net.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m() {
        /*
            r7 = this;
            boolean r0 = r7.f9163g
            r1 = 0
            if (r0 == 0) goto L46
            com.taobao.accs.AccsClientConfig r0 = r7.f9165i     // Catch: java.lang.Throwable -> L46
            java.lang.String r0 = r0.getAppKey()     // Catch: java.lang.Throwable -> L46
            anet.channel.SessionCenter r0 = anet.channel.SessionCenter.getInstance(r0)     // Catch: java.lang.Throwable -> L46
            r2 = 0
            java.lang.String r2 = r7.b(r2)     // Catch: java.lang.Throwable -> L46
            anet.channel.entity.ConnType$TypeLevel r3 = anet.channel.entity.ConnType.TypeLevel.SPDY     // Catch: java.lang.Throwable -> L46
            r4 = 0
            anet.channel.Session r0 = r0.get(r2, r3, r4)     // Catch: java.lang.Throwable -> L46
            java.lang.String r2 = "InAppConn_"
            java.lang.String r3 = "isConnected"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L46
            java.lang.String r5 = "state"
            r4[r1] = r5     // Catch: java.lang.Throwable -> L46
            r5 = 1
            if (r0 == 0) goto L33
            boolean r6 = r0.isAvailable()     // Catch: java.lang.Throwable -> L46
            if (r6 == 0) goto L31
            goto L33
        L31:
            r6 = 0
            goto L34
        L33:
            r6 = 1
        L34:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.Throwable -> L46
            r4[r5] = r6     // Catch: java.lang.Throwable -> L46
            com.taobao.accs.utl.ALog.e(r2, r3, r4)     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L46
            boolean r0 = r0.isAvailable()     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L46
            r1 = 1
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.k.m():boolean");
    }

    @Override // anet.channel.DataFrameCb
    public void onDataReceive(TnetSpdySession tnetSpdySession, byte[] bArr, int i10, int i11) {
        if (ALog.isPrintLog(ALog.Level.E)) {
            ALog.e(d(), "onDataReceive", "type", Integer.valueOf(i11), "dataid", Integer.valueOf(i10));
        }
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new r(this, i11, bArr, tnetSpdySession));
    }

    @Override // anet.channel.DataFrameCb
    public void onException(int i10, int i11, boolean z10, String str) {
        ALog.e(d(), "errorId:" + i11 + "detail:" + str + " dataId:" + i10 + " needRetry:" + z10, new Object[0]);
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new s(this, i10, z10, i11));
    }

    @Override // com.taobao.accs.net.a
    public synchronized void a() {
        ALog.d(d(), "start", new Object[0]);
        this.f9195o = true;
        a(this.f9160d);
    }

    @Override // com.taobao.accs.net.a
    public void b() {
        this.f9162f = 0;
    }

    @Override // com.taobao.accs.net.a
    public void c(int i10) {
        super.c(i10);
    }

    @Override // com.taobao.accs.net.a
    public void a(Message message, boolean z10) {
        if (this.f9195o && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size() <= 1000) {
                    ScheduledFuture<?> schedule = ThreadPoolExecutorFactory.getSendScheduledExecutor().schedule(new o(this, message), message.delyTime, TimeUnit.MILLISECONDS);
                    if (message.getType() == 1 && message.cunstomDataId != null) {
                        if (message.isControlFrame() && a(message.cunstomDataId)) {
                            this.f9161e.b(message);
                        }
                        this.f9161e.f9103a.put(message.cunstomDataId, schedule);
                    }
                    NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
                    if (netPermanceMonitor != null) {
                        netPermanceMonitor.setDeviceId(UtilityImpl.j(this.f9160d));
                        netPermanceMonitor.setConnType(this.f9159c);
                        netPermanceMonitor.onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                this.f9161e.a(message, ErrorCode.MESSAGE_QUEUE_FULL);
                ALog.e(d(), "send queue full count:" + ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size(), new Object[0]);
                return;
            } catch (Throwable th) {
                this.f9161e.a(message, -8);
                ALog.e(d(), "send error", th, new Object[0]);
                return;
            }
        }
        ALog.e(d(), "not running or msg null! " + this.f9195o, new Object[0]);
    }

    public k(Context context, int i10, String str, int i11) {
        super(context, i10, str);
        this.f9195o = true;
        this.f9196p = 3600000L;
        this.f9198r = new Handler(Looper.getMainLooper());
        this.f9199s = new l(this);
        this.f9200t = new m(this);
        this.f9201u = new t(this);
        this.f9202v = Collections.synchronizedSet(new HashSet());
        c(i11);
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.f9201u, 120000L, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.net.a
    public void a(String str, boolean z10, long j10) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new p(this, str, z10), j10, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.net.a
    public void a(boolean z10, boolean z11) {
        ThreadPoolExecutorFactory.getSendScheduledExecutor().execute(new q(this));
    }

    @Override // com.taobao.accs.net.a
    public void a(String str, boolean z10, String str2) {
        Session session;
        try {
            Message b10 = this.f9161e.b(str);
            if (b10 != null && b10.host != null && (session = SessionCenter.getInstance(this.f9165i.getAppKey()).get(b10.host.toString(), 0L)) != null) {
                if (z10) {
                    ALog.e(d(), "close session by time out", new Object[0]);
                    session.close(true);
                } else {
                    session.ping(true);
                }
            }
        } catch (Exception e10) {
            ALog.e(d(), "onTimeOut", e10, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.a
    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        ScheduledFuture<?> scheduledFuture = this.f9161e.f9103a.get(str);
        boolean cancel = scheduledFuture != null ? scheduledFuture.cancel(false) : false;
        if (cancel) {
            ALog.e(d(), "cancel", "customDataId", str);
        }
        return cancel;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            ALog.e(d(), "onReceiveAccsHeartbeatResp response data is null", new Object[0]);
            return;
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(d(), "onReceiveAccsHeartbeatResp", "data", jSONObject);
        }
        try {
            int i10 = jSONObject.getInt("timeInterval");
            if (i10 == -1) {
                ScheduledFuture scheduledFuture = this.f9197q;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    return;
                }
                return;
            }
            long j10 = i10 * 1000;
            if (this.f9196p != j10) {
                if (i10 == 0) {
                    j10 = 3600000;
                }
                this.f9196p = j10;
                ScheduledFuture scheduledFuture2 = this.f9197q;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(true);
                }
                ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
                Runnable runnable = this.f9199s;
                long j11 = this.f9196p;
                this.f9197q = scheduledExecutor.scheduleAtFixedRate(runnable, j11, j11, TimeUnit.MILLISECONDS);
            }
        } catch (JSONException e10) {
            ALog.e(d(), "onReceiveAccsHeartbeatResp", "e", e10.getMessage());
        }
    }

    @Override // com.taobao.accs.net.a
    public void a(Context context) {
        boolean z10;
        try {
            if (this.f9163g) {
                return;
            }
            super.a(context);
            if (com.taobao.accs.utl.t.c()) {
                SessionCenter.getInstance(this.f9165i.getAppKey()).registerAccsSessionListener(this.f9200t);
            }
            String inappHost = this.f9165i.getInappHost();
            if (h() && this.f9165i.isKeepalive()) {
                z10 = true;
            } else {
                ALog.d(d(), "initAwcn close keepalive", new Object[0]);
                z10 = false;
            }
            a(SessionCenter.getInstance(this.f9165i.getAppKey()), inappHost, z10);
            this.f9163g = true;
            ALog.i(d(), "initAwcn success!", new Object[0]);
        } catch (Throwable th) {
            ALog.e(d(), "initAwcn", th, new Object[0]);
        }
    }

    public void a(SessionCenter sessionCenter, String str, boolean z10) {
        if (this.f9202v.contains(str)) {
            return;
        }
        sessionCenter.registerSessionInfo(SessionInfo.create(str, z10, true, new a(this, str), null, this));
        sessionCenter.registerPublicKey(str, this.f9165i.getInappPubKey());
        this.f9202v.add(str);
        ALog.i(d(), "registerSessionInfo", Constants.KEY_HOST, str);
    }

    public void a(AccsClientConfig accsClientConfig) {
        if (accsClientConfig == null) {
            ALog.i(d(), "updateConfig null", new Object[0]);
            return;
        }
        if (accsClientConfig.equals(this.f9165i)) {
            ALog.w(d(), "updateConfig not any changed", new Object[0]);
            return;
        }
        if (!this.f9163g) {
            if (UtilityImpl.isMainProcess(this.f9160d)) {
                this.f9165i = accsClientConfig;
                a(this.f9160d);
                return;
            }
            return;
        }
        try {
            boolean z10 = true;
            ALog.w(d(), "updateConfig", "old", this.f9165i, "new", accsClientConfig);
            String inappHost = this.f9165i.getInappHost();
            String inappHost2 = accsClientConfig.getInappHost();
            SessionCenter sessionCenter = SessionCenter.getInstance(this.f9165i.getAppKey());
            if (sessionCenter == null) {
                ALog.w(d(), "updateConfig not need update", new Object[0]);
                return;
            }
            sessionCenter.unregisterSessionInfo(inappHost);
            ALog.w(d(), "updateConfig unregisterSessionInfo", Constants.KEY_HOST, inappHost);
            if (this.f9202v.contains(inappHost)) {
                this.f9202v.remove(inappHost);
                ALog.w(d(), "updateConfig removeSessionRegistered", "oldHost", inappHost);
            }
            this.f9165i = accsClientConfig;
            this.f9158b = accsClientConfig.getAppKey();
            this.f9169m = this.f9165i.getTag();
            String str = ConnType.PK_ACS;
            if (this.f9165i.getInappPubKey() == 10 || this.f9165i.getInappPubKey() == 11) {
                str = ConnType.PK_OPEN;
            }
            ALog.i(d(), "update config register new conn protocol host:", this.f9165i.getInappHost());
            StrategyTemplate.getInstance().registerConnProtocol(this.f9165i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
            if (!h() || !this.f9165i.isKeepalive()) {
                ALog.i(d(), "updateConfig close keepalive", new Object[0]);
                z10 = false;
            }
            a(sessionCenter, inappHost2, z10);
        } catch (Throwable th) {
            ALog.e(d(), "updateConfig", th, new Object[0]);
        }
    }
}
