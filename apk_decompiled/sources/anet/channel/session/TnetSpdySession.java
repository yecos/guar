package anet.channel.session;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.Config;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.SessionInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.heartbeat.HeartbeatManager;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.request.Request;
import anet.channel.security.ISecurity;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.statist.SessionMonitor;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import com.google.common.primitives.UnsignedBytes;
import com.taobao.accs.common.Constants;
import java.util.List;
import java.util.Map;
import org.android.spdy.SessionCb;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

/* loaded from: classes.dex */
public class TnetSpdySession extends Session implements SessionCb {
    protected long A;
    protected int B;
    protected DataFrameCb C;
    protected IHeartbeat D;
    protected IAuth E;
    protected String F;
    protected ISecurity G;
    private int H;
    private boolean I;

    /* renamed from: w, reason: collision with root package name */
    protected SpdyAgent f4092w;

    /* renamed from: x, reason: collision with root package name */
    protected SpdySession f4093x;

    /* renamed from: y, reason: collision with root package name */
    protected volatile boolean f4094y;

    /* renamed from: z, reason: collision with root package name */
    protected long f4095z;

    public class a extends anet.channel.session.a {

        /* renamed from: b, reason: collision with root package name */
        private Request f4097b;

        /* renamed from: c, reason: collision with root package name */
        private RequestCb f4098c;

        /* renamed from: d, reason: collision with root package name */
        private int f4099d = 0;

        /* renamed from: e, reason: collision with root package name */
        private long f4100e = 0;

        public a(Request request, RequestCb requestCb) {
            this.f4097b = request;
            this.f4098c = requestCb;
        }

        private void a(SuperviseData superviseData, int i10, String str) {
            try {
                this.f4097b.f4045a.rspEnd = System.currentTimeMillis();
                if (this.f4097b.f4045a.isDone.get()) {
                    return;
                }
                if (i10 > 0) {
                    this.f4097b.f4045a.ret = 1;
                }
                this.f4097b.f4045a.statusCode = i10;
                this.f4097b.f4045a.msg = str;
                if (superviseData != null) {
                    this.f4097b.f4045a.rspEnd = superviseData.responseEnd;
                    this.f4097b.f4045a.sendBeforeTime = superviseData.sendStart - superviseData.requestStart;
                    RequestStatistic requestStatistic = this.f4097b.f4045a;
                    requestStatistic.sendDataTime = superviseData.sendEnd - requestStatistic.sendStart;
                    this.f4097b.f4045a.firstDataTime = superviseData.responseStart - superviseData.sendEnd;
                    this.f4097b.f4045a.recDataTime = superviseData.responseEnd - superviseData.responseStart;
                    this.f4097b.f4045a.sendDataSize = superviseData.bodySize + superviseData.compressSize;
                    this.f4097b.f4045a.recDataSize = this.f4100e + superviseData.recvUncompressSize;
                    this.f4097b.f4045a.reqHeadInflateSize = superviseData.uncompressSize;
                    this.f4097b.f4045a.reqHeadDeflateSize = superviseData.compressSize;
                    this.f4097b.f4045a.reqBodyInflateSize = superviseData.bodySize;
                    this.f4097b.f4045a.reqBodyDeflateSize = superviseData.bodySize;
                    this.f4097b.f4045a.rspHeadDeflateSize = superviseData.recvCompressSize;
                    this.f4097b.f4045a.rspHeadInflateSize = superviseData.recvUncompressSize;
                    this.f4097b.f4045a.rspBodyDeflateSize = superviseData.recvBodySize;
                    this.f4097b.f4045a.rspBodyInflateSize = this.f4100e;
                    if (this.f4097b.f4045a.contentLength == 0) {
                        this.f4097b.f4045a.contentLength = superviseData.originContentLength;
                    }
                    SessionStatistic sessionStatistic = TnetSpdySession.this.f3828q;
                    sessionStatistic.recvSizeCount += superviseData.recvBodySize + superviseData.recvCompressSize;
                    sessionStatistic.sendSizeCount += superviseData.bodySize + superviseData.compressSize;
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z10, long j10, SpdyByteArray spdyByteArray, Object obj) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyDataChunkRecvCB", this.f4097b.getSeq(), "len", Integer.valueOf(spdyByteArray.getDataLength()), "fin", Boolean.valueOf(z10));
            }
            this.f4100e += spdyByteArray.getDataLength();
            this.f4097b.f4045a.recDataSize += spdyByteArray.getDataLength();
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
            if (this.f4098c != null) {
                ByteArray a10 = a.C0063a.f3894a.a(spdyByteArray.getByteArray(), spdyByteArray.getDataLength());
                spdyByteArray.recycle();
                this.f4098c.onDataReceive(a10, z10);
            }
            TnetSpdySession.this.handleCallbacks(32, null);
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyOnStreamResponse(SpdySession spdySession, long j10, Map<String, List<String>> map, Object obj) {
            this.f4097b.f4045a.firstDataTime = System.currentTimeMillis() - this.f4097b.f4045a.sendStart;
            this.f4099d = HttpHelper.parseStatusCode(map);
            TnetSpdySession.this.H = 0;
            ALog.i("awcn.TnetSpdySession", "", this.f4097b.getSeq(), "statusCode", Integer.valueOf(this.f4099d));
            ALog.i("awcn.TnetSpdySession", "", this.f4097b.getSeq(), "response headers", map);
            RequestCb requestCb = this.f4098c;
            if (requestCb != null) {
                requestCb.onResponseCode(this.f4099d, HttpHelper.cloneMap(map));
            }
            TnetSpdySession.this.handleCallbacks(16, null);
            this.f4097b.f4045a.contentEncoding = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Encoding");
            this.f4097b.f4045a.contentType = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Type");
            this.f4097b.f4045a.contentLength = HttpHelper.parseContentLength(map);
            this.f4097b.f4045a.serverRT = HttpHelper.parseServerRT(map);
            TnetSpdySession.this.handleResponseCode(this.f4097b, this.f4099d);
            TnetSpdySession.this.handleResponseHeaders(this.f4097b, map);
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyStreamCloseCallback(SpdySession spdySession, long j10, int i10, Object obj, SuperviseData superviseData) {
            String str;
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyStreamCloseCallback", this.f4097b.getSeq(), "streamId", Long.valueOf(j10), "errorCode", Integer.valueOf(i10));
            }
            if (i10 != 0) {
                this.f4099d = ErrorConstant.ERROR_TNET_REQUEST_FAIL;
                str = ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_REQUEST_FAIL, String.valueOf(i10));
                if (i10 != -2005) {
                    AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_TNET_EXCEPTION, str, this.f4097b.f4045a, null));
                }
                ALog.e("awcn.TnetSpdySession", "spdyStreamCloseCallback error", this.f4097b.getSeq(), "session", TnetSpdySession.this.f3827p, "status code", Integer.valueOf(i10), "URL", this.f4097b.getHttpUrl().simpleUrlString());
            } else {
                str = HttpConstant.SUCCESS;
            }
            this.f4097b.f4045a.tnetErrorCode = i10;
            a(superviseData, this.f4099d, str);
            RequestCb requestCb = this.f4098c;
            if (requestCb != null) {
                requestCb.onFinish(this.f4099d, str, this.f4097b.f4045a);
            }
            if (i10 == -2004) {
                if (!TnetSpdySession.this.f4094y) {
                    TnetSpdySession.this.ping(true);
                }
                if (TnetSpdySession.e(TnetSpdySession.this) >= 2) {
                    ConnEvent connEvent = new ConnEvent();
                    connEvent.isSuccess = false;
                    connEvent.isAccs = TnetSpdySession.this.I;
                    StrategyCenter.getInstance().notifyConnEvent(((Session) TnetSpdySession.this).f3815d, ((Session) TnetSpdySession.this).f3822k, connEvent);
                    TnetSpdySession.this.close(true);
                }
            }
        }
    }

    public TnetSpdySession(Context context, anet.channel.entity.a aVar) {
        super(context, aVar);
        this.f4094y = false;
        this.A = 0L;
        this.H = 0;
        this.B = -1;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.I = false;
    }

    public static /* synthetic */ int e(TnetSpdySession tnetSpdySession) {
        int i10 = tnetSpdySession.H + 1;
        tnetSpdySession.H = i10;
        return i10;
    }

    public void auth() {
        IAuth iAuth = this.E;
        if (iAuth != null) {
            iAuth.auth(this, new i(this));
            return;
        }
        notifyStatus(4, null);
        this.f3828q.ret = 1;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.start(this);
        }
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i10) {
    }

    @Override // anet.channel.Session
    public void close() {
        ALog.e("awcn.TnetSpdySession", "force close!", this.f3827p, "session", this);
        notifyStatus(7, null);
        try {
            IHeartbeat iHeartbeat = this.D;
            if (iHeartbeat != null) {
                iHeartbeat.stop();
                this.D = null;
            }
            SpdySession spdySession = this.f4093x;
            if (spdySession != null) {
                spdySession.closeSession();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x012e A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:8:0x0013, B:10:0x0017, B:11:0x001a, B:13:0x0020, B:16:0x0028, B:19:0x0030, B:21:0x00d4, B:23:0x00dc, B:26:0x00e5, B:28:0x00e9, B:29:0x010f, B:31:0x0117, B:33:0x011d, B:34:0x0120, B:36:0x012e, B:39:0x0143, B:42:0x0158, B:45:0x00ed, B:47:0x00f3, B:48:0x00f9, B:50:0x0103, B:52:0x0107, B:53:0x010c, B:54:0x010a), top: B:7:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0143 A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:8:0x0013, B:10:0x0017, B:11:0x001a, B:13:0x0020, B:16:0x0028, B:19:0x0030, B:21:0x00d4, B:23:0x00dc, B:26:0x00e5, B:28:0x00e9, B:29:0x010f, B:31:0x0117, B:33:0x011d, B:34:0x0120, B:36:0x012e, B:39:0x0143, B:42:0x0158, B:45:0x00ed, B:47:0x00f3, B:48:0x00f9, B:50:0x0103, B:52:0x0107, B:53:0x010c, B:54:0x010a), top: B:7:0x0013 }] */
    @Override // anet.channel.Session
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void connect() {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.TnetSpdySession.connect():void");
    }

    @Override // anet.channel.Session
    public Runnable getRecvTimeOutRunnable() {
        return new h(this);
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            ALog.i("awcn.TnetSpdySession", "get sslticket host is null", null, new Object[0]);
            return null;
        }
        try {
            ISecurity iSecurity = this.G;
            if (iSecurity == null) {
                return null;
            }
            return iSecurity.getBytes(this.f3812a, "accs_ssl_key2_" + domain);
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "getSSLMeta", null, th, new Object[0]);
            return null;
        }
    }

    public void initConfig(Config config) {
        if (config != null) {
            this.F = config.getAppkey();
            this.G = config.getSecurity();
        }
    }

    public void initSessionInfo(SessionInfo sessionInfo) {
        if (sessionInfo != null) {
            this.C = sessionInfo.dataFrameCb;
            this.E = sessionInfo.auth;
            if (sessionInfo.isKeepAlive) {
                this.f3828q.isKL = 1L;
                this.f3831t = true;
                IHeartbeat iHeartbeat = sessionInfo.heartbeat;
                this.D = iHeartbeat;
                boolean z10 = sessionInfo.isAccs;
                this.I = z10;
                if (iHeartbeat == null) {
                    if (!z10 || AwcnConfig.isAccsSessionCreateForbiddenInBg()) {
                        this.D = HeartbeatManager.getDefaultHeartbeat();
                    } else {
                        this.D = HeartbeatManager.getDefaultBackgroundAccsHeartbeat();
                    }
                }
            }
        }
        if (AwcnConfig.isIdleSessionCloseEnable() && this.D == null) {
            this.D = new anet.channel.heartbeat.c();
        }
    }

    @Override // anet.channel.Session
    public boolean isAvailable() {
        return this.f3825n == 4;
    }

    @Override // anet.channel.Session
    public void onDisconnect() {
        this.f4094y = false;
    }

    @Override // anet.channel.Session
    public void ping(boolean z10) {
        ping(z10, this.f3830s);
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            return -1;
        }
        try {
            ISecurity iSecurity = this.G;
            if (iSecurity == null) {
                return -1;
            }
            Context context = this.f3812a;
            StringBuilder sb = new StringBuilder();
            sb.append("accs_ssl_key2_");
            sb.append(domain);
            return iSecurity.saveBytes(context, sb.toString(), bArr) ? 0 : -1;
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "putSSLMeta", null, th, new Object[0]);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0111 A[Catch: Exception -> 0x01b9, SpdyErrorException -> 0x01c3, TRY_ENTER, TryCatch #4 {SpdyErrorException -> 0x01c3, Exception -> 0x01b9, blocks: (B:12:0x0051, B:14:0x0055, B:18:0x005c, B:20:0x0060, B:21:0x0067, B:24:0x007e, B:25:0x00b7, B:27:0x00bf, B:30:0x00c4, B:31:0x00fe, B:34:0x0111, B:36:0x0118, B:37:0x011f, B:38:0x013e, B:40:0x016b, B:41:0x0180, B:62:0x011b, B:63:0x0123, B:65:0x0136, B:66:0x0138, B:67:0x00eb, B:69:0x01af), top: B:11:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x016b A[Catch: Exception -> 0x01b9, SpdyErrorException -> 0x01c3, TryCatch #4 {SpdyErrorException -> 0x01c3, Exception -> 0x01b9, blocks: (B:12:0x0051, B:14:0x0055, B:18:0x005c, B:20:0x0060, B:21:0x0067, B:24:0x007e, B:25:0x00b7, B:27:0x00bf, B:30:0x00c4, B:31:0x00fe, B:34:0x0111, B:36:0x0118, B:37:0x011f, B:38:0x013e, B:40:0x016b, B:41:0x0180, B:62:0x011b, B:63:0x0123, B:65:0x0136, B:66:0x0138, B:67:0x00eb, B:69:0x01af), top: B:11:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a3 A[Catch: Exception -> 0x01a8, SpdyErrorException -> 0x01aa, TRY_LEAVE, TryCatch #3 {SpdyErrorException -> 0x01aa, Exception -> 0x01a8, blocks: (B:43:0x018b, B:45:0x01a3), top: B:42:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0123 A[Catch: Exception -> 0x01b9, SpdyErrorException -> 0x01c3, TryCatch #4 {SpdyErrorException -> 0x01c3, Exception -> 0x01b9, blocks: (B:12:0x0051, B:14:0x0055, B:18:0x005c, B:20:0x0060, B:21:0x0067, B:24:0x007e, B:25:0x00b7, B:27:0x00bf, B:30:0x00c4, B:31:0x00fe, B:34:0x0111, B:36:0x0118, B:37:0x011f, B:38:0x013e, B:40:0x016b, B:41:0x0180, B:62:0x011b, B:63:0x0123, B:65:0x0136, B:66:0x0138, B:67:0x00eb, B:69:0x01af), top: B:11:0x0051 }] */
    @Override // anet.channel.Session
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public anet.channel.request.Cancelable request(anet.channel.request.Request r25, anet.channel.RequestCb r26) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.TnetSpdySession.request(anet.channel.request.Request, anet.channel.RequestCb):anet.channel.request.Cancelable");
    }

    @Override // anet.channel.Session
    public void sendCustomFrame(int i10, byte[] bArr, int i11) {
        SpdySession spdySession;
        try {
            if (this.C == null) {
                return;
            }
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.f3827p, Constants.KEY_DATA_ID, Integer.valueOf(i10), "type", Integer.valueOf(i11));
            if (this.f3825n != 4 || (spdySession = this.f4093x) == null) {
                ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.f3827p, "sendCustomFrame con invalid mStatus:" + this.f3825n);
                a(i10, ErrorConstant.ERROR_SESSION_INVALID, true, "session invalid");
                return;
            }
            if (bArr != null && bArr.length > 16384) {
                a(i10, ErrorConstant.ERROR_DATA_TOO_LARGE, false, null);
                return;
            }
            spdySession.sendCustomControlFrame(i10, i11, 0, bArr == null ? 0 : bArr.length, bArr);
            SessionStatistic sessionStatistic = this.f3828q;
            sessionStatistic.requestCount++;
            sessionStatistic.cfRCount++;
            this.f4095z = System.currentTimeMillis();
            IHeartbeat iHeartbeat = this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
        } catch (SpdyErrorException e10) {
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame error", this.f3827p, e10, new Object[0]);
            a(i10, ErrorConstant.ERROR_TNET_EXCEPTION, true, "SpdyErrorException: " + e10.toString());
        } catch (Exception e11) {
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame error", this.f3827p, e11, new Object[0]);
            a(i10, -101, true, e11.toString());
        }
    }

    public void setTnetPublicKey(int i10) {
        this.B = i10;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i10, int i11) {
        ALog.e("awcn.TnetSpdySession", "spdyCustomControlFrameFailCallback", this.f3827p, Constants.KEY_DATA_ID, Integer.valueOf(i10));
        a(i10, i11, true, "tnet error");
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i10, int i11, int i12, int i13, byte[] bArr) {
        ALog.e("awcn.TnetSpdySession", "[spdyCustomControlFrameRecvCallback]", this.f3827p, "len", Integer.valueOf(i13), "frameCb", this.C);
        if (ALog.isPrintLog(1) && i13 < 512) {
            String str = "";
            for (byte b10 : bArr) {
                str = str + Integer.toHexString(b10 & UnsignedBytes.MAX_VALUE) + " ";
            }
            ALog.e("awcn.TnetSpdySession", null, this.f3827p, "str", str);
        }
        DataFrameCb dataFrameCb = this.C;
        if (dataFrameCb != null) {
            dataFrameCb.onDataReceive(this, bArr, i10, i11);
        } else {
            ALog.e("awcn.TnetSpdySession", "AccsFrameCb is null", this.f3827p, new Object[0]);
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(-105, null, "rt"));
        }
        this.f3828q.inceptCount++;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j10, Object obj) {
        if (ALog.isPrintLog(2)) {
            ALog.i("awcn.TnetSpdySession", "ping receive", this.f3827p, "Host", this.f3814c, "id", Long.valueOf(j10));
        }
        if (j10 < 0) {
            return;
        }
        this.f4094y = false;
        this.H = 0;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
        handleCallbacks(128, null);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i10) {
        ALog.e("awcn.TnetSpdySession", "spdySessionCloseCallback", this.f3827p, " errorCode:", Integer.valueOf(i10));
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.stop();
            this.D = null;
        }
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e10) {
                ALog.e("awcn.TnetSpdySession", "session clean up failed!", null, e10, new Object[0]);
            }
        }
        if (i10 == -3516) {
            ConnEvent connEvent = new ConnEvent();
            connEvent.isSuccess = false;
            StrategyCenter.getInstance().notifyConnEvent(this.f3815d, this.f3822k, connEvent);
        }
        notifyStatus(6, new anet.channel.entity.b(2));
        if (superviseConnectInfo != null) {
            SessionStatistic sessionStatistic = this.f3828q;
            sessionStatistic.requestCount = superviseConnectInfo.reused_counter;
            sessionStatistic.liveTime = superviseConnectInfo.keepalive_period_second;
            try {
                if (this.f3821j.isHTTP3()) {
                    if (spdySession != null) {
                        ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionCloseCallback]", this.f3827p, "connectInfo", spdySession.getConnectInfoOnDisConnected());
                    }
                    this.f3828q.xqc0RttStatus = superviseConnectInfo.xqc0RttStatus;
                    this.f3828q.retransmissionRate = superviseConnectInfo.retransmissionRate;
                    this.f3828q.lossRate = superviseConnectInfo.lossRate;
                    this.f3828q.tlpCount = superviseConnectInfo.tlpCount;
                    this.f3828q.rtoCount = superviseConnectInfo.rtoCount;
                    this.f3828q.srtt = superviseConnectInfo.srtt;
                }
            } catch (Exception unused) {
            }
        }
        SessionStatistic sessionStatistic2 = this.f3828q;
        if (sessionStatistic2.errorCode == 0) {
            sessionStatistic2.errorCode = i10;
        }
        sessionStatistic2.lastPingInterval = (int) (System.currentTimeMillis() - this.f4095z);
        AppMonitor.getInstance().commitStat(this.f3828q);
        if (anet.channel.strategy.utils.d.b(this.f3828q.ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.f3828q));
        }
        AppMonitor.getInstance().commitAlarm(this.f3828q.getAlarmObject());
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        SessionStatistic sessionStatistic = this.f3828q;
        sessionStatistic.connectionTime = superviseConnectInfo.connectTime;
        sessionStatistic.sslTime = superviseConnectInfo.handshakeTime;
        sessionStatistic.sslCalTime = superviseConnectInfo.doHandshakeTime;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        this.A = System.currentTimeMillis();
        notifyStatus(0, new anet.channel.entity.b(1));
        auth();
        ALog.e("awcn.TnetSpdySession", "spdySessionConnectCB connect", this.f3827p, "connectTime", Integer.valueOf(superviseConnectInfo.connectTime), "sslTime", Integer.valueOf(superviseConnectInfo.handshakeTime));
        if (this.f3821j.isHTTP3()) {
            this.f3828q.scid = superviseConnectInfo.scid;
            this.f3828q.dcid = superviseConnectInfo.dcid;
            this.f3828q.congControlKind = superviseConnectInfo.congControlKind;
            ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionConnectCB]", this.f3827p, "connectInfo", spdySession.getConnectInfoOnConnected());
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i10, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e10) {
                ALog.e("awcn.TnetSpdySession", "[spdySessionFailedError]session clean up failed!", null, e10, new Object[0]);
            }
        }
        notifyStatus(2, new anet.channel.entity.b(256, i10, "tnet connect fail"));
        ALog.e("awcn.TnetSpdySession", null, this.f3827p, " errorId:", Integer.valueOf(i10));
        SessionStatistic sessionStatistic = this.f3828q;
        sessionStatistic.errorCode = i10;
        sessionStatistic.ret = 0;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        AppMonitor.getInstance().commitStat(this.f3828q);
        if (anet.channel.strategy.utils.d.b(this.f3828q.ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.f3828q));
        }
        AppMonitor.getInstance().commitAlarm(this.f3828q.getAlarmObject());
    }

    @Override // anet.channel.Session
    public void ping(boolean z10, int i10) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.TnetSpdySession", "ping", this.f3827p, Constants.KEY_HOST, this.f3814c, "thread", Thread.currentThread().getName());
        }
        if (z10) {
            try {
                if (this.f4093x == null) {
                    SessionStatistic sessionStatistic = this.f3828q;
                    if (sessionStatistic != null) {
                        sessionStatistic.closeReason = "session null";
                    }
                    ALog.e("awcn.TnetSpdySession", this.f3814c + " session null", this.f3827p, new Object[0]);
                    close();
                    return;
                }
                int i11 = this.f3825n;
                if (i11 == 0 || i11 == 4) {
                    handleCallbacks(64, null);
                    if (this.f4094y) {
                        return;
                    }
                    this.f4094y = true;
                    this.f3828q.ppkgCount++;
                    this.f4093x.submitPing();
                    if (ALog.isPrintLog(1)) {
                        ALog.d("awcn.TnetSpdySession", this.f3814c + " submit ping ms:" + (System.currentTimeMillis() - this.f4095z) + " force:" + z10, this.f3827p, new Object[0]);
                    }
                    setPingTimeout(i10);
                    this.f4095z = System.currentTimeMillis();
                    IHeartbeat iHeartbeat = this.D;
                    if (iHeartbeat != null) {
                        iHeartbeat.reSchedule();
                    }
                }
            } catch (SpdyErrorException e10) {
                if (e10.SpdyErrorGetCode() == -1104 || e10.SpdyErrorGetCode() == -1103) {
                    ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.f3827p, new Object[0]);
                    notifyStatus(6, new anet.channel.entity.b(2));
                }
                ALog.e("awcn.TnetSpdySession", "ping", this.f3827p, e10, new Object[0]);
            } catch (Exception e11) {
                ALog.e("awcn.TnetSpdySession", "ping", this.f3827p, e11, new Object[0]);
            }
        }
    }

    private void a(int i10, int i11, boolean z10, String str) {
        DataFrameCb dataFrameCb = this.C;
        if (dataFrameCb != null) {
            dataFrameCb.onException(i10, i11, z10, str);
        }
    }

    private void a() {
        SpdyAgent.enableDebug = false;
        this.f4092w = SpdyAgent.getInstance(this.f3812a, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        ISecurity iSecurity = this.G;
        if (iSecurity != null && !iSecurity.isSecOff()) {
            this.f4092w.setAccsSslCallback(new j(this));
        }
        if (AwcnConfig.isTnetHeaderCacheEnable()) {
            return;
        }
        try {
            this.f4092w.getClass().getDeclaredMethod("disableHeaderCache", new Class[0]).invoke(this.f4092w, new Object[0]);
            ALog.i("awcn.TnetSpdySession", "tnet disableHeaderCache", null, new Object[0]);
        } catch (Exception e10) {
            ALog.e("awcn.TnetSpdySession", "tnet disableHeaderCache", null, e10, new Object[0]);
        }
    }
}
