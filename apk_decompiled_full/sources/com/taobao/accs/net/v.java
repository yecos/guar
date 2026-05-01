package com.taobao.accs.net;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.strategy.IConnStrategy;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.http.HTTPServer;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.upnp.Service;
import com.hpplay.sdk.source.common.global.Constant;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.SessionMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

/* loaded from: classes3.dex */
public class v extends com.taobao.accs.net.a implements SessionCb, Spdycb {
    private SpdySession A;
    private Object B;
    private long C;
    private long D;
    private long E;
    private long F;
    private int G;
    private String H;
    private SessionMonitor I;
    private com.taobao.accs.ut.a.c J;
    private boolean K;
    private String L;
    private boolean M;
    private h N;
    private String O;

    /* renamed from: o, reason: collision with root package name */
    protected ScheduledFuture<?> f9229o;

    /* renamed from: p, reason: collision with root package name */
    protected String f9230p;

    /* renamed from: q, reason: collision with root package name */
    protected int f9231q;

    /* renamed from: r, reason: collision with root package name */
    protected String f9232r;

    /* renamed from: s, reason: collision with root package name */
    protected int f9233s;

    /* renamed from: t, reason: collision with root package name */
    private int f9234t;

    /* renamed from: u, reason: collision with root package name */
    private LinkedList<Message> f9235u;

    /* renamed from: v, reason: collision with root package name */
    private a f9236v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f9237w;

    /* renamed from: x, reason: collision with root package name */
    private String f9238x;

    /* renamed from: y, reason: collision with root package name */
    private String f9239y;

    /* renamed from: z, reason: collision with root package name */
    private SpdyAgent f9240z;

    public class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public int f9241a;

        /* renamed from: b, reason: collision with root package name */
        long f9242b;

        /* renamed from: d, reason: collision with root package name */
        private final String f9244d;

        public a(String str) {
            super(str);
            this.f9244d = getName();
            this.f9241a = 0;
        }

        private void a(boolean z10) {
            if (v.this.f9234t == 1) {
                if (v.this.f9234t != 1 || System.currentTimeMillis() - this.f9242b <= 5000) {
                    return;
                }
                this.f9241a = 0;
                return;
            }
            ALog.d(v.this.d(), "tryConnect", "force", Boolean.valueOf(z10));
            if (!UtilityImpl.i(v.this.f9160d)) {
                ALog.e(this.f9244d, "Network not available", new Object[0]);
                return;
            }
            if (z10) {
                this.f9241a = 0;
            }
            ALog.i(this.f9244d, "tryConnect", "force", Boolean.valueOf(z10), "failTimes", Integer.valueOf(this.f9241a));
            if (v.this.f9234t != 1 && this.f9241a >= 4) {
                v.this.K = true;
                ALog.e(this.f9244d, "tryConnect fail", "maxTimes", 4);
                return;
            }
            if (v.this.f9234t != 1) {
                if (v.this.f9159c == 1 && this.f9241a == 0) {
                    ALog.i(this.f9244d, "tryConnect in app, no sleep", new Object[0]);
                } else {
                    ALog.i(this.f9244d, "tryConnect, need sleep", new Object[0]);
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e10) {
                        e10.printStackTrace();
                    }
                }
                v.this.L = "";
                if (this.f9241a == 3) {
                    v.this.N.b(v.this.p());
                }
                v.this.d((String) null);
                v.this.I.setRetryTimes(this.f9241a);
                if (v.this.f9234t == 1) {
                    this.f9242b = System.currentTimeMillis();
                    return;
                }
                this.f9241a++;
                ALog.e(this.f9244d, "try connect fail, ready for reconnect", new Object[0]);
                a(false);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Message message;
            boolean z10;
            Integer num;
            Integer num2;
            Integer num3;
            ALog.i(this.f9244d, "NetworkThread run", new Object[0]);
            this.f9241a = 0;
            Message message2 = null;
            while (v.this.f9237w) {
                ALog.d(this.f9244d, "ready to get message", new Object[0]);
                synchronized (v.this.f9235u) {
                    if (v.this.f9235u.size() == 0) {
                        try {
                            ALog.d(this.f9244d, "no message, wait", new Object[0]);
                            v.this.f9235u.wait();
                        } catch (InterruptedException e10) {
                            e10.printStackTrace();
                        }
                    }
                    ALog.d(this.f9244d, "try get message", new Object[0]);
                    if (v.this.f9235u.size() != 0) {
                        message2 = (Message) v.this.f9235u.getFirst();
                        if (message2.getNetPermanceMonitor() != null) {
                            message2.getNetPermanceMonitor().onTakeFromQueue();
                        }
                    }
                    message = message2;
                }
                if (!v.this.f9237w) {
                    break;
                }
                if (message != null) {
                    ALog.d(this.f9244d, "sendMessage not null", new Object[0]);
                    try {
                        int type = message.getType();
                        ALog.i(this.f9244d, "sendMessage", "type", Message.MsgType.name(type), Constant.KEY_STATUS, Integer.valueOf(v.this.f9234t));
                        if (type != 2) {
                            if (type == 1) {
                                a(true);
                                if (v.this.f9234t == 1 && v.this.A != null) {
                                    v vVar = v.this;
                                    byte[] build = message.build(vVar.f9160d, vVar.f9159c);
                                    message.setSendTime(System.currentTimeMillis());
                                    if (build.length <= 49152 || message.command.intValue() == 102) {
                                        int id = message.isAck ? -message.getMsgId().getId() : message.getMsgId().getId();
                                        v.this.A.sendCustomControlFrame(id, 200, 0, build.length, build);
                                        ALog.e(this.f9244d, "send data", "length", Integer.valueOf(build.length), Constants.KEY_DATA_ID, message.getDataId(), "utdid", v.this.f9166j);
                                        v.this.f9161e.a(message);
                                        if (message.isAck) {
                                            ALog.e(this.f9244d, "sendCFrame end ack", Constants.KEY_DATA_ID, Integer.valueOf(id));
                                            v.this.f9168l.put(Integer.valueOf(id), message);
                                        }
                                        if (message.getNetPermanceMonitor() != null) {
                                            message.getNetPermanceMonitor().onSendData();
                                        }
                                        v.this.a(message.getDataId(), v.this.f9165i.isQuickReconnect(), message.timeout);
                                        v.this.f9161e.a(new TrafficsMonitor.a(message.serviceId, GlobalAppRuntimeInfo.isAppBackground(), v.this.p(), build.length));
                                    } else {
                                        v.this.f9161e.a(message, -4);
                                    }
                                }
                                z10 = false;
                            } else {
                                a(false);
                                ALog.e(this.f9244d, "skip msg", "type", Integer.valueOf(type));
                            }
                            z10 = true;
                        } else if (v.this.f9159c == 1) {
                            ALog.d(this.f9244d, "sendMessage INAPP ping, skip", new Object[0]);
                            try {
                                ALog.d(this.f9244d, "send succ, remove it", new Object[0]);
                                synchronized (v.this.f9235u) {
                                    v.this.f9235u.remove(message);
                                }
                            } catch (Throwable th) {
                                ALog.e(this.f9244d, " run finally error", th, new Object[0]);
                            }
                        } else {
                            if (System.currentTimeMillis() - v.this.C < (g.a(v.this.f9160d).b() - 1) * 1000 && !message.force) {
                                a(false);
                                z10 = true;
                            }
                            ALog.d(this.f9244d, "sendMessage", "force", Boolean.valueOf(message.force), "last ping", Long.valueOf(System.currentTimeMillis() - v.this.C));
                            a(true);
                            if (v.this.A != null && v.this.f9234t == 1) {
                                if (System.currentTimeMillis() - v.this.C >= (g.a(v.this.f9160d).b() - 1) * 1000) {
                                    ALog.i(this.f9244d, "sendMessage onSendPing", new Object[0]);
                                    v.this.f9161e.a();
                                    v.this.A.submitPing();
                                    v.this.I.onSendPing();
                                    v.this.C = System.currentTimeMillis();
                                    v.this.D = System.nanoTime();
                                    v.this.f();
                                }
                                z10 = true;
                            }
                            z10 = false;
                        }
                        try {
                            v.this.t();
                            if (z10) {
                                ALog.d(this.f9244d, "send succ, remove it", new Object[0]);
                                synchronized (v.this.f9235u) {
                                    v.this.f9235u.remove(message);
                                }
                            } else {
                                try {
                                    v.this.o();
                                    if (v.this.I != null) {
                                        v.this.I.setCloseReason("send fail");
                                    }
                                    synchronized (v.this.f9235u) {
                                        for (int size = v.this.f9235u.size() - 1; size >= 0; size--) {
                                            Message message3 = (Message) v.this.f9235u.get(size);
                                            if (message3 != null && (num3 = message3.command) != null && (num3.intValue() == 100 || message3.command.intValue() == 201)) {
                                                v.this.f9161e.a(message3, -1);
                                                v.this.f9235u.remove(size);
                                            }
                                        }
                                        ALog.e(this.f9244d, "network disconnected, wait", new Object[0]);
                                        v.this.f9235u.wait();
                                    }
                                } catch (Throwable th2) {
                                    ALog.e(this.f9244d, " run finally error", th2, new Object[0]);
                                }
                            }
                            ALog.e(this.f9244d, " run finally error", th2, new Object[0]);
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, message.serviceId, "1", v.this.f9159c + th.toString());
                                th.printStackTrace();
                                ALog.e(this.f9244d, "service connection run", th, new Object[0]);
                                if (z10) {
                                    ALog.d(this.f9244d, "send succ, remove it", new Object[0]);
                                    synchronized (v.this.f9235u) {
                                        v.this.f9235u.remove(message);
                                    }
                                    message2 = message;
                                } else {
                                    try {
                                        v.this.o();
                                        if (v.this.I != null) {
                                            v.this.I.setCloseReason("send fail");
                                        }
                                        synchronized (v.this.f9235u) {
                                            for (int size2 = v.this.f9235u.size() - 1; size2 >= 0; size2--) {
                                                Message message4 = (Message) v.this.f9235u.get(size2);
                                                if (message4 != null && (num2 = message4.command) != null && (num2.intValue() == 100 || message4.command.intValue() == 201)) {
                                                    v.this.f9161e.a(message4, -1);
                                                    v.this.f9235u.remove(size2);
                                                }
                                            }
                                            ALog.e(this.f9244d, "network disconnected, wait", new Object[0]);
                                            v.this.f9235u.wait();
                                        }
                                    } catch (Throwable th4) {
                                        ALog.e(this.f9244d, " run finally error", th4, new Object[0]);
                                    }
                                    message2 = message;
                                }
                                ALog.e(this.f9244d, " run finally error", th4, new Object[0]);
                                message2 = message;
                            } catch (Throwable th5) {
                                try {
                                    if (z10) {
                                        ALog.d(this.f9244d, "send succ, remove it", new Object[0]);
                                        synchronized (v.this.f9235u) {
                                            v.this.f9235u.remove(message);
                                            throw th5;
                                        }
                                    }
                                    v.this.o();
                                    if (v.this.I != null) {
                                        v.this.I.setCloseReason("send fail");
                                    }
                                    synchronized (v.this.f9235u) {
                                        for (int size3 = v.this.f9235u.size() - 1; size3 >= 0; size3--) {
                                            Message message5 = (Message) v.this.f9235u.get(size3);
                                            if (message5 != null && (num = message5.command) != null && (num.intValue() == 100 || message5.command.intValue() == 201)) {
                                                v.this.f9161e.a(message5, -1);
                                                v.this.f9235u.remove(size3);
                                            }
                                        }
                                        ALog.e(this.f9244d, "network disconnected, wait", new Object[0]);
                                        v.this.f9235u.wait();
                                        throw th5;
                                    }
                                } catch (Throwable th6) {
                                    ALog.e(this.f9244d, " run finally error", th6, new Object[0]);
                                    throw th5;
                                }
                                ALog.e(this.f9244d, " run finally error", th6, new Object[0]);
                                throw th5;
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        z10 = true;
                    }
                }
                message2 = message;
            }
            v.this.o();
        }
    }

    public v(Context context, int i10, String str) {
        super(context, i10, str);
        this.f9234t = 3;
        this.f9235u = new LinkedList<>();
        this.f9237w = true;
        this.f9240z = null;
        this.A = null;
        this.B = new Object();
        this.G = -1;
        this.H = null;
        this.K = false;
        this.L = "";
        this.M = false;
        this.N = new h(p());
        u();
    }

    private int r() {
        boolean l10 = l();
        if (AccsClientConfig.mEnv == 2) {
            return 0;
        }
        int channelPubKey = this.f9165i.getChannelPubKey();
        if (channelPubKey <= 0) {
            return l10 ? 4 : 3;
        }
        ALog.i(d(), "getPublicKeyType use custom pub key", "pubKey", Integer.valueOf(channelPubKey));
        return channelPubKey;
    }

    private void s() {
        if (this.A == null) {
            d(3);
            return;
        }
        try {
            String encode = URLEncoder.encode(UtilityImpl.j(this.f9160d));
            String a10 = UtilityImpl.a(i(), this.f9165i.getAppSecret(), UtilityImpl.j(this.f9160d));
            String c10 = c(this.f9238x);
            ALog.e(d(), BaseMonitor.ALARM_POINT_AUTH, "url", c10);
            this.f9239y = c10;
            if (!a(encode, i(), a10)) {
                ALog.e(d(), "auth param error!", new Object[0]);
                e(-6);
            } else {
                SpdyRequest spdyRequest = new SpdyRequest(new URL(c10), "GET", RequestPriority.DEFAULT_PRIORITY, HTTPServer.DEFAULT_TIMEOUT, com.taobao.accs.net.a.ACCS_RECEIVE_TIMEOUT);
                spdyRequest.setDomain(p());
                this.A.submitRequest(spdyRequest, new SpdyDataProvider((byte[]) null), p(), this);
            }
        } catch (Throwable th) {
            ALog.e(d(), "auth exception ", th, new Object[0]);
            e(-7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t() {
        if (this.f9159c == 1) {
            return;
        }
        this.C = System.currentTimeMillis();
        this.D = System.nanoTime();
        g.a(this.f9160d).a();
    }

    private void u() {
        try {
            SpdyAgent.enableDebug = ALog.isPrintLog();
            this.f9240z = SpdyAgent.getInstance(this.f9160d, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            if (SpdyAgent.checkLoadSucc()) {
                com.taobao.accs.utl.q.a();
            } else {
                ALog.e(d(), "initClient", new Object[0]);
                this.f9240z = null;
                com.taobao.accs.utl.q.b();
            }
        } catch (Throwable th) {
            ALog.e(d(), "initClient", th, new Object[0]);
        }
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i10) {
        ALog.w(d(), "bioPingRecvCallback uniId:" + i10, new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        spdySession.getDomain();
        return UtilityImpl.c();
    }

    @Override // com.taobao.accs.net.a
    public boolean h() {
        return false;
    }

    public void o() {
        ALog.e(d(), " force close!", new Object[0]);
        try {
            this.A.closeSession();
            this.I.setCloseType(1);
        } catch (Exception unused) {
        }
        d(3);
    }

    public String p() {
        String channelHost = this.f9165i.getChannelHost();
        ALog.i(d(), "getChannelHost", Constants.KEY_HOST, channelHost);
        return channelHost == null ? "" : channelHost;
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        spdySession.getDomain();
        return UtilityImpl.b();
    }

    public boolean q() {
        return this.f9237w;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i10, int i11) {
        b(i10);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i10, int i11, int i12, int i13, byte[] bArr) {
        t();
        ALog.e(d(), "onFrame", "type", Integer.valueOf(i11), "len", Integer.valueOf(bArr.length));
        StringBuilder sb = new StringBuilder();
        if (ALog.isPrintLog(ALog.Level.D) && bArr.length < 512) {
            long currentTimeMillis = System.currentTimeMillis();
            for (byte b10 : bArr) {
                sb.append(Integer.toHexString(b10 & UnsignedBytes.MAX_VALUE));
                sb.append(" ");
            }
            ALog.d(d(), ((Object) sb) + " log time:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        }
        if (i11 == 200) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.f9161e.a(bArr);
                com.taobao.accs.ut.a.d g10 = this.f9161e.g();
                if (g10 != null) {
                    g10.f9277c = String.valueOf(currentTimeMillis2);
                    g10.f9281g = this.f9159c == 0 ? Service.ELEM_NAME : "inapp";
                    g10.a();
                }
            } catch (Throwable th) {
                ALog.e(d(), "onDataReceive ", th, new Object[0]);
                UTMini.getInstance().commitEvent(66001, "SERVICE_DATA_RECEIVE", UtilityImpl.a(th));
            }
            ALog.d(d(), "try handle msg", new Object[0]);
            g();
        } else {
            ALog.e(d(), "drop frame", "len", Integer.valueOf(bArr.length));
        }
        ALog.d(d(), "spdyCustomControlFrameRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z10, long j10, SpdyByteArray spdyByteArray, Object obj) {
        ALog.d(d(), "spdyDataChunkRecvCB", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataRecvCallback(SpdySession spdySession, boolean z10, long j10, int i10, Object obj) {
        ALog.d(d(), "spdyDataRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataSendCallback(SpdySession spdySession, boolean z10, long j10, int i10, Object obj) {
        ALog.d(d(), "spdyDataSendCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyOnStreamResponse(SpdySession spdySession, long j10, Map<String, List<String>> map, Object obj) {
        this.C = System.currentTimeMillis();
        this.D = System.nanoTime();
        try {
            Map<String, String> a10 = UtilityImpl.a(map);
            ALog.d("SilenceConn_", "spdyOnStreamResponse", "header", map);
            int parseInt = Integer.parseInt(a10.get(":status"));
            ALog.e(d(), "spdyOnStreamResponse", "httpStatusCode", Integer.valueOf(parseInt));
            if (parseInt == 200) {
                d(1);
                String str = a10.get("x-at");
                if (!TextUtils.isEmpty(str)) {
                    this.f9167k = str;
                }
                SessionMonitor sessionMonitor = this.I;
                sessionMonitor.auth_time = sessionMonitor.connection_stop_date > 0 ? System.currentTimeMillis() - this.I.connection_stop_date : 0L;
                String str2 = this.f9159c == 0 ? Service.ELEM_NAME : "inapp";
                UTMini.getInstance().commitEvent(66001, "CONNECTED 200 " + str2, this.f9239y, this.L, Integer.valueOf(Constants.SDK_VERSION_CODE), "0");
                com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_AUTH, "");
            } else {
                e(parseInt);
            }
        } catch (Exception e10) {
            ALog.e(d(), e10.toString(), new Object[0]);
            o();
            this.I.setCloseReason("exception");
        }
        ALog.d(d(), "spdyOnStreamResponse", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j10, Object obj) {
        ALog.d(d(), "spdyPingRecvCallback uniId:" + j10, new Object[0]);
        if (j10 < 0) {
            return;
        }
        this.f9161e.b();
        g.a(this.f9160d).e();
        g.a(this.f9160d).a();
        this.I.onPingCBReceive();
        if (this.I.ping_rec_times % 2 == 0) {
            UtilityImpl.a(this.f9160d, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        }
    }

    @Override // org.android.spdy.Spdycb
    public void spdyRequestRecvCallback(SpdySession spdySession, long j10, Object obj) {
        ALog.d(d(), "spdyRequestRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i10) {
        ALog.e(d(), "spdySessionCloseCallback", "errorCode", Integer.valueOf(i10));
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e10) {
                ALog.e(d(), "session cleanUp has exception: " + e10, new Object[0]);
            }
        }
        d(3);
        this.I.onCloseConnect();
        if (this.I.getConCloseDate() > 0 && this.I.getConStopDate() > 0) {
            this.I.getConCloseDate();
            this.I.getConStopDate();
        }
        this.I.setCloseReason(this.I.getCloseReason() + "tnet error:" + i10);
        if (superviseConnectInfo != null) {
            this.I.live_time = superviseConnectInfo.keepalive_period_second;
        }
        AppMonitor.getInstance().commitStat(this.I);
        for (Message message : this.f9161e.e()) {
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().setRet(false);
                message.getNetPermanceMonitor().setFailReason("session close");
                AppMonitor.getInstance().commitStat(message.getNetPermanceMonitor());
            }
        }
        String str = this.f9159c == 0 ? Service.ELEM_NAME : "inapp";
        ALog.d(d(), "spdySessionCloseCallback, conKeepTime:" + this.I.live_time + " connectType:" + str, new Object[0]);
        UTMini uTMini = UTMini.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("DISCONNECT CLOSE ");
        sb.append(str);
        uTMini.commitEvent(66001, sb.toString(), Integer.valueOf(i10), Long.valueOf(this.I.live_time), Integer.valueOf(Constants.SDK_VERSION_CODE), this.f9239y, this.L);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        this.G = superviseConnectInfo.connectTime;
        int i10 = superviseConnectInfo.handshakeTime;
        ALog.e(d(), "spdySessionConnectCB", "sessionConnectInterval", Integer.valueOf(this.G), "sslTime", Integer.valueOf(i10), "reuse", Integer.valueOf(superviseConnectInfo.sessionTicketReused));
        s();
        this.I.setRet(true);
        this.I.onConnectStop();
        SessionMonitor sessionMonitor = this.I;
        sessionMonitor.tcp_time = this.G;
        sessionMonitor.ssl_time = i10;
        String str = this.f9159c == 0 ? Service.ELEM_NAME : "inapp";
        UTMini.getInstance().commitEvent(66001, "CONNECTED " + str + " " + superviseConnectInfo.sessionTicketReused, String.valueOf(this.G), String.valueOf(i10), Integer.valueOf(Constants.SDK_VERSION_CODE), String.valueOf(superviseConnectInfo.sessionTicketReused), this.f9239y, this.L);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_CONNECT, "");
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i10, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e10) {
                ALog.e(d(), "session cleanUp has exception: " + e10, new Object[0]);
            }
        }
        a aVar = this.f9236v;
        int i11 = aVar != null ? aVar.f9241a : 0;
        ALog.e(d(), "spdySessionFailedError", "retryTimes", Integer.valueOf(i11), "errorId", Integer.valueOf(i10));
        this.K = false;
        this.M = true;
        d(3);
        this.I.setFailReason(i10);
        this.I.onConnectStop();
        String str = this.f9159c == 0 ? Service.ELEM_NAME : "inapp";
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(Constants.SDK_VERSION_CODE), this.f9239y, this.L);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i11, i10 + "", "");
    }

    @Override // org.android.spdy.Spdycb
    public void spdyStreamCloseCallback(SpdySession spdySession, long j10, int i10, Object obj, SuperviseData superviseData) {
        ALog.d(d(), "spdyStreamCloseCallback", new Object[0]);
        if (i10 != 0) {
            ALog.e(d(), "spdyStreamCloseCallback", "statusCode", Integer.valueOf(i10));
            e(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        SessionInfo sessionInfo;
        int i10 = this.f9234t;
        if (i10 == 2 || i10 == 1) {
            return;
        }
        if (this.N == null) {
            this.N = new h(p());
        }
        List<IConnStrategy> a10 = this.N.a(p());
        int i11 = Constants.PORT;
        if (a10 == null || a10.size() <= 0) {
            if (str != null) {
                this.f9230p = str;
            } else {
                this.f9230p = p();
            }
            if (System.currentTimeMillis() % 2 == 0) {
                i11 = 80;
            }
            this.f9231q = i11;
            com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_DNS, "localdns", 0.0d);
            ALog.i(d(), "connect get ip from amdc fail!!", new Object[0]);
        } else {
            for (IConnStrategy iConnStrategy : a10) {
                if (iConnStrategy != null) {
                    ALog.e(d(), BaseMonitor.ALARM_POINT_CONNECT, "ip", iConnStrategy.getIp(), "port", Integer.valueOf(iConnStrategy.getPort()));
                }
            }
            if (this.M) {
                this.N.b();
                this.M = false;
            }
            IConnStrategy a11 = this.N.a();
            this.f9230p = a11 == null ? p() : a11.getIp();
            if (a11 != null) {
                i11 = a11.getPort();
            }
            this.f9231q = i11;
            com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_DNS, "httpdns", 0.0d);
            ALog.e(d(), "connect from amdc succ", "ip", this.f9230p, "port", Integer.valueOf(this.f9231q), "originPos", Integer.valueOf(this.N.c()));
        }
        this.f9238x = "https://" + this.f9230p + SOAP.DELIM + this.f9231q + "/accs/";
        ALog.e(d(), BaseMonitor.ALARM_POINT_CONNECT, "URL", this.f9238x);
        this.O = String.valueOf(System.currentTimeMillis());
        if (this.I != null) {
            AppMonitor.getInstance().commitStat(this.I);
        }
        SessionMonitor sessionMonitor = new SessionMonitor();
        this.I = sessionMonitor;
        sessionMonitor.setConnectType(this.f9159c == 0 ? Service.ELEM_NAME : "inapp");
        if (this.f9240z != null) {
            try {
                this.E = System.currentTimeMillis();
                this.F = System.nanoTime();
                this.f9232r = UtilityImpl.a(this.f9160d);
                this.f9233s = UtilityImpl.b(this.f9160d);
                this.C = System.currentTimeMillis();
                this.I.onStartConnect();
                d(2);
                synchronized (this.B) {
                    try {
                        try {
                            if (TextUtils.isEmpty(this.f9232r) || this.f9233s < 0 || !this.K) {
                                ALog.e(d(), "connect normal", new Object[0]);
                                sessionInfo = new SessionInfo(this.f9230p, this.f9231q, p() + "_" + this.f9158b, null, 0, this.O, this, 4226);
                                this.L = "";
                            } else {
                                ALog.e(d(), BaseMonitor.ALARM_POINT_CONNECT, "proxy", this.f9232r, "port", Integer.valueOf(this.f9233s));
                                sessionInfo = new SessionInfo(this.f9230p, this.f9231q, p() + "_" + this.f9158b, this.f9232r, this.f9233s, this.O, this, 4226);
                                this.L = this.f9232r + SOAP.DELIM + this.f9233s;
                            }
                            sessionInfo.setPubKeySeqNum(r());
                            sessionInfo.setConnectionTimeoutMs(com.taobao.accs.net.a.ACCS_RECEIVE_TIMEOUT);
                            this.A = this.f9240z.createSession(sessionInfo);
                            this.I.connection_stop_date = 0L;
                            this.B.wait();
                        } catch (InterruptedException e10) {
                            e10.printStackTrace();
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        this.K = false;
                    }
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    @Override // com.taobao.accs.net.a
    public com.taobao.accs.ut.a.c c() {
        if (this.J == null) {
            this.J = new com.taobao.accs.ut.a.c();
        }
        com.taobao.accs.ut.a.c cVar = this.J;
        cVar.f9265b = this.f9159c;
        cVar.f9267d = this.f9235u.size();
        this.J.f9272i = UtilityImpl.i(this.f9160d);
        com.taobao.accs.ut.a.c cVar2 = this.J;
        cVar2.f9269f = this.L;
        cVar2.f9264a = this.f9234t;
        SessionMonitor sessionMonitor = this.I;
        cVar2.f9266c = sessionMonitor != null && sessionMonitor.getRet();
        this.J.f9273j = q();
        com.taobao.accs.ut.a.c cVar3 = this.J;
        com.taobao.accs.data.d dVar = this.f9161e;
        cVar3.f9268e = dVar != null ? dVar.d() : 0;
        com.taobao.accs.ut.a.c cVar4 = this.J;
        cVar4.f9270g = this.f9239y;
        return cVar4;
    }

    @Override // com.taobao.accs.net.a
    public void e() {
        super.e();
        this.f9237w = false;
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new x(this));
        ALog.e(d(), "shut down", new Object[0]);
    }

    @Override // com.taobao.accs.net.a
    public void b() {
        this.K = false;
        this.f9162f = 0;
    }

    private void e(int i10) {
        this.f9167k = null;
        o();
        a aVar = this.f9236v;
        int i11 = aVar != null ? aVar.f9241a : 0;
        this.I.setCloseReason("code not 200 is" + i10);
        this.M = true;
        String str = this.f9159c == 0 ? Service.ELEM_NAME : "inapp";
        UTMini.getInstance().commitEvent(66001, "CONNECTED NO 200 " + str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(Constants.SDK_VERSION_CODE), this.f9239y, this.L);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_AUTH, "", i10 + "", "");
    }

    @Override // com.taobao.accs.net.a
    public void a() {
        this.f9237w = true;
        ALog.d(d(), "start", new Object[0]);
        a(this.f9160d);
        if (this.f9236v == null) {
            ALog.i(d(), "start thread", new Object[0]);
            a aVar = new a("NetworkThread_" + this.f9169m);
            this.f9236v = aVar;
            aVar.setPriority(2);
            this.f9236v.start();
        }
        a(false, false);
    }

    @Override // com.taobao.accs.net.a
    public String b(String str) {
        return "https://" + this.f9165i.getChannelHost();
    }

    @Override // com.taobao.accs.net.a
    public void a(Message message, boolean z10) {
        if (this.f9237w && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size() <= 1000) {
                    ScheduledFuture<?> schedule = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new w(this, message, z10), message.delyTime, TimeUnit.MILLISECONDS);
                    if (message.getType() == 1 && message.cunstomDataId != null) {
                        if (message.isControlFrame()) {
                            a(message.cunstomDataId);
                        }
                        this.f9161e.f9103a.put(message.cunstomDataId, schedule);
                    }
                    if (message.getNetPermanceMonitor() != null) {
                        message.getNetPermanceMonitor().setDeviceId(UtilityImpl.j(this.f9160d));
                        message.getNetPermanceMonitor().setConnType(this.f9159c);
                        message.getNetPermanceMonitor().onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                this.f9161e.a(message, ErrorCode.MESSAGE_QUEUE_FULL);
                ALog.e(d(), "send queue full count:" + ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size(), new Object[0]);
                return;
            } catch (Throwable th) {
                this.f9161e.a(message, -8);
                ALog.e(d(), "send error", th, new Object[0]);
                return;
            }
        }
        ALog.e(d(), "not running or msg null! " + this.f9237w, new Object[0]);
    }

    @Override // com.taobao.accs.net.a
    public void a(boolean z10, boolean z11) {
        ALog.d(d(), "try ping, force:" + z10, new Object[0]);
        if (this.f9159c == 1) {
            ALog.d(d(), "INAPP, skip", new Object[0]);
            return;
        }
        Message BuildPing = Message.BuildPing(z10, (int) (z11 ? Math.random() * 10.0d * 1000.0d : 0.0d));
        int pingTimeout = this.f9165i.getPingTimeout();
        if (pingTimeout > 0) {
            BuildPing.timeout = pingTimeout;
        }
        b(BuildPing, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        if (message.command == null || this.f9235u.size() == 0) {
            return;
        }
        for (int size = this.f9235u.size() - 1; size >= 0; size--) {
            Message message2 = this.f9235u.get(size);
            if (message2 != null && message2.command != null && message2.getPackageName().equals(message.getPackageName())) {
                switch (message.command.intValue()) {
                    case 1:
                    case 2:
                        if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                            this.f9235u.remove(size);
                            break;
                        }
                        break;
                    case 3:
                    case 4:
                        if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                            this.f9235u.remove(size);
                            break;
                        }
                        break;
                    case 5:
                    case 6:
                        if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                            this.f9235u.remove(size);
                            break;
                        }
                        break;
                }
                ALog.d(d(), "clearRepeatControlCommand message:" + message2.command + Operator.Operation.DIVISION + message2.getPackageName(), new Object[0]);
            }
        }
        com.taobao.accs.data.d dVar = this.f9161e;
        if (dVar != null) {
            dVar.b(message);
        }
    }

    private synchronized void d(int i10) {
        ALog.e(d(), "notifyStatus start", Constant.KEY_STATUS, a(i10));
        if (i10 == this.f9234t) {
            ALog.i(d(), "ignore notifyStatus", new Object[0]);
            return;
        }
        this.f9234t = i10;
        if (i10 == 1) {
            g.a(this.f9160d).f();
            t();
            ScheduledFuture<?> scheduledFuture = this.f9229o;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            synchronized (this.B) {
                try {
                    this.B.notifyAll();
                } catch (Exception unused) {
                }
            }
            synchronized (this.f9235u) {
                try {
                    this.f9235u.notifyAll();
                } catch (Exception unused2) {
                }
            }
            ALog.i(d(), "notifyStatus end", Constant.KEY_STATUS, a(i10));
        }
        if (i10 == 2) {
            ScheduledFuture<?> scheduledFuture2 = this.f9229o;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(true);
            }
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new y(this, this.O), 120000L, TimeUnit.MILLISECONDS);
        } else if (i10 == 3) {
            t();
            g.a(this.f9160d).d();
            synchronized (this.B) {
                try {
                    this.B.notifyAll();
                } catch (Exception unused3) {
                }
            }
            this.f9161e.a(-10);
            a(false, true);
        }
        ALog.i(d(), "notifyStatus end", Constant.KEY_STATUS, a(i10));
    }

    private boolean a(String str, String str2, String str3) {
        int i10 = 1;
        if (com.taobao.accs.utl.v.b(this.f9160d) == 2) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        d(3);
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                i10 = 2;
            } else if (TextUtils.isEmpty(str3)) {
                i10 = 3;
            }
        }
        this.I.setFailReason(i10);
        this.I.onConnectStop();
        String str4 = this.f9159c == 0 ? Service.ELEM_NAME : "inapp";
        a aVar = this.f9236v;
        int i11 = aVar != null ? aVar.f9241a : 0;
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str4, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(Constants.SDK_VERSION_CODE), this.f9239y, this.L);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i11, i10 + "", "");
        return false;
    }

    @Override // com.taobao.accs.net.a
    public void a(String str, boolean z10, String str2) {
        try {
            d(4);
            o();
            this.I.setCloseReason(str2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.taobao.accs.net.a
    public boolean a(String str) {
        boolean z10;
        String str2;
        synchronized (this.f9235u) {
            z10 = true;
            int size = this.f9235u.size() - 1;
            while (true) {
                if (size >= 0) {
                    Message message = this.f9235u.get(size);
                    if (message != null && message.getType() == 1 && (str2 = message.cunstomDataId) != null && str2.equals(str)) {
                        this.f9235u.remove(size);
                        break;
                    }
                    size--;
                } else {
                    z10 = false;
                    break;
                }
            }
        }
        return z10;
    }

    @Override // com.taobao.accs.net.a
    public String d() {
        return "SilenceConn_" + this.f9169m;
    }

    @Override // com.taobao.accs.net.a
    public void a(Context context) {
        if (this.f9163g) {
            return;
        }
        super.a(context);
        GlobalAppRuntimeInfo.setBackground(false);
        this.f9163g = true;
        ALog.i(d(), "init awcn success!", new Object[0]);
    }
}
