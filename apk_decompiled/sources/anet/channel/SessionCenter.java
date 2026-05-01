package anet.channel;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import anet.channel.Config;
import anet.channel.detect.n;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import java.net.ConnectException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* loaded from: classes.dex */
public class SessionCenter {
    public static final String TAG = "awcn.SessionCenter";

    /* renamed from: a, reason: collision with root package name */
    static Map<Config, SessionCenter> f3838a = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private static boolean f3839j = false;

    /* renamed from: b, reason: collision with root package name */
    Context f3840b;

    /* renamed from: c, reason: collision with root package name */
    String f3841c;

    /* renamed from: d, reason: collision with root package name */
    Config f3842d;

    /* renamed from: e, reason: collision with root package name */
    final e f3843e = new e();

    /* renamed from: f, reason: collision with root package name */
    final LruCache<String, SessionRequest> f3844f = new LruCache<>(32);

    /* renamed from: g, reason: collision with root package name */
    final c f3845g = new c();

    /* renamed from: h, reason: collision with root package name */
    final AccsSessionManager f3846h;

    /* renamed from: i, reason: collision with root package name */
    final a f3847i;

    private SessionCenter(Config config) {
        a aVar = new a(this, null);
        this.f3847i = aVar;
        this.f3840b = GlobalAppRuntimeInfo.getContext();
        this.f3842d = config;
        this.f3841c = config.getAppkey();
        aVar.a();
        this.f3846h = new AccsSessionManager(this);
        if (config.getAppkey().equals("[default]")) {
            return;
        }
        AmdcRuntimeInfo.setSign(new d(this, config.getAppkey(), config.getSecurity()));
    }

    public static void checkAndStartAccsSession() {
        Iterator<SessionCenter> it = f3838a.values().iterator();
        while (it.hasNext()) {
            it.next().f3846h.checkAndStartSession();
        }
    }

    public static synchronized SessionCenter getInstance(String str) {
        SessionCenter sessionCenter;
        synchronized (SessionCenter.class) {
            Config configByTag = Config.getConfigByTag(str);
            if (configByTag == null) {
                throw new RuntimeException("tag not exist!");
            }
            sessionCenter = getInstance(configByTag);
        }
        return sessionCenter;
    }

    public static synchronized void init(Context context) {
        synchronized (SessionCenter.class) {
            if (context == null) {
                ALog.e(TAG, "context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            }
            GlobalAppRuntimeInfo.setContext(context.getApplicationContext());
            if (!f3839j) {
                Map<Config, SessionCenter> map = f3838a;
                Config config = Config.DEFAULT_CONFIG;
                map.put(config, new SessionCenter(config));
                AppLifecycle.initialize();
                NetworkStatusHelper.startListener(context);
                if (!AwcnConfig.isTbNextLaunch()) {
                    StrategyCenter.getInstance().initialize(GlobalAppRuntimeInfo.getContext());
                }
                if (GlobalAppRuntimeInfo.isTargetProcess()) {
                    n.a();
                    anet.channel.e.a.a();
                }
                f3839j = true;
            }
        }
    }

    public static synchronized void switchEnvironment(ENV env) {
        synchronized (SessionCenter.class) {
            try {
                if (GlobalAppRuntimeInfo.getEnv() != env) {
                    ALog.i(TAG, "switch env", null, "old", GlobalAppRuntimeInfo.getEnv(), "new", env);
                    GlobalAppRuntimeInfo.setEnv(env);
                    StrategyCenter.getInstance().switchEnv();
                    SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).switchAccsServer(env == ENV.TEST ? 0 : 1);
                }
                Iterator<Map.Entry<Config, SessionCenter>> it = f3838a.entrySet().iterator();
                while (it.hasNext()) {
                    SessionCenter value = it.next().getValue();
                    if (value.f3842d.getEnv() != env) {
                        ALog.i(TAG, "remove instance", value.f3841c, "ENVIRONMENT", value.f3842d.getEnv());
                        value.f3846h.forceCloseSession(false);
                        value.f3847i.b();
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                ALog.e(TAG, "switch env error.", null, th, new Object[0]);
            }
        }
    }

    public void asyncGet(HttpUrl httpUrl, int i10, long j10, SessionGetCallback sessionGetCallback) {
        if (sessionGetCallback == null) {
            throw new NullPointerException("cb is null");
        }
        if (j10 <= 0) {
            throw new InvalidParameterException("timeout must > 0");
        }
        try {
            b(httpUrl, i10, j10, sessionGetCallback);
        } catch (Exception unused) {
            sessionGetCallback.onSessionGetFail();
        }
    }

    public void b(HttpUrl httpUrl, int i10, long j10, SessionGetCallback sessionGetCallback) {
        SessionInfo b10;
        if (!f3839j) {
            ALog.e(TAG, "getInternal not inited!", this.f3841c, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        }
        if (httpUrl == null) {
            throw new InvalidParameterException("httpUrl is null");
        }
        if (sessionGetCallback == null) {
            throw new InvalidParameterException("sessionGetCallback is null");
        }
        String str = this.f3841c;
        Object[] objArr = new Object[6];
        objArr[0] = "u";
        objArr[1] = httpUrl.urlString();
        objArr[2] = "sessionType";
        objArr[3] = i10 == anet.channel.entity.c.f3972a ? "LongLink" : "ShortLink";
        objArr[4] = "timeout";
        objArr[5] = Long.valueOf(j10);
        ALog.d(TAG, "getInternal", str, objArr);
        SessionRequest a10 = a(httpUrl);
        Session a11 = this.f3843e.a(a10, i10);
        if (a11 != null) {
            ALog.d(TAG, "get internal hit cache session", this.f3841c, "session", a11);
            sessionGetCallback.onSessionGetSuccess(a11);
            return;
        }
        if (this.f3842d == Config.DEFAULT_CONFIG && i10 != anet.channel.entity.c.f3973b) {
            sessionGetCallback.onSessionGetFail();
            return;
        }
        if (GlobalAppRuntimeInfo.isAppBackground() && i10 == anet.channel.entity.c.f3972a && AwcnConfig.isAccsSessionCreateForbiddenInBg() && (b10 = this.f3845g.b(httpUrl.host())) != null && b10.isAccs) {
            ALog.w(TAG, "app background, forbid to create accs session", this.f3841c, new Object[0]);
            throw new ConnectException("accs session connecting forbidden in background");
        }
        a10.b(this.f3840b, i10, anet.channel.util.i.a(this.f3841c), sessionGetCallback, j10);
    }

    @Deprecated
    public void enterBackground() {
        AppLifecycle.onBackground();
    }

    @Deprecated
    public void enterForeground() {
        AppLifecycle.onForeground();
    }

    public void forceRecreateAccsSession() {
        this.f3846h.forceCloseSession(true);
    }

    public Session get(String str, long j10) {
        return get(HttpUrl.parse(str), anet.channel.entity.c.f3974c, j10);
    }

    public Session getThrowsException(String str, long j10) {
        return a(HttpUrl.parse(str), anet.channel.entity.c.f3974c, j10, null);
    }

    public void registerAccsSessionListener(ISessionListener iSessionListener) {
        this.f3846h.registerListener(iSessionListener);
    }

    public void registerPublicKey(String str, int i10) {
        this.f3845g.a(str, i10);
    }

    public void registerSessionInfo(SessionInfo sessionInfo) {
        this.f3845g.a(sessionInfo);
        if (sessionInfo.isKeepAlive) {
            this.f3846h.checkAndStartSession();
        }
    }

    @Deprecated
    public synchronized void switchEnv(ENV env) {
        switchEnvironment(env);
    }

    public void unregisterAccsSessionListener(ISessionListener iSessionListener) {
        this.f3846h.unregisterListener(iSessionListener);
    }

    public void unregisterSessionInfo(String str) {
        SessionInfo a10 = this.f3845g.a(str);
        if (a10 == null || !a10.isKeepAlive) {
            return;
        }
        this.f3846h.checkAndStartSession();
    }

    public class a implements NetworkStatusHelper.INetworkStatusChangeListener, IStrategyListener, AppLifecycle.AppLifecycleListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f3848a;

        private a() {
            this.f3848a = false;
        }

        public void a() {
            AppLifecycle.registerLifecycleListener(this);
            NetworkStatusHelper.addStatusChangeListener(this);
            StrategyCenter.getInstance().registerListener(this);
        }

        public void b() {
            StrategyCenter.getInstance().unregisterListener(this);
            AppLifecycle.unregisterLifecycleListener(this);
            NetworkStatusHelper.removeStatusChangeListener(this);
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void background() {
            ALog.i(SessionCenter.TAG, "[background]", SessionCenter.this.f3841c, new Object[0]);
            if (!SessionCenter.f3839j) {
                ALog.e(SessionCenter.TAG, "background not inited!", SessionCenter.this.f3841c, new Object[0]);
                return;
            }
            try {
                StrategyCenter.getInstance().saveData();
                if (AwcnConfig.isAccsSessionCreateForbiddenInBg() && "OPPO".equalsIgnoreCase(Build.BRAND)) {
                    ALog.i(SessionCenter.TAG, "close session for OPPO", SessionCenter.this.f3841c, new Object[0]);
                    SessionCenter.this.f3846h.forceCloseSession(false);
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void forground() {
            ALog.i(SessionCenter.TAG, "[forground]", SessionCenter.this.f3841c, new Object[0]);
            if (SessionCenter.this.f3840b == null || this.f3848a) {
                return;
            }
            this.f3848a = true;
            try {
                if (!SessionCenter.f3839j) {
                    ALog.e(SessionCenter.TAG, "forground not inited!", SessionCenter.this.f3841c, new Object[0]);
                    return;
                }
                try {
                    if (AppLifecycle.lastEnterBackgroundTime == 0 || System.currentTimeMillis() - AppLifecycle.lastEnterBackgroundTime <= 60000) {
                        SessionCenter.this.f3846h.checkAndStartSession();
                    } else {
                        SessionCenter.this.f3846h.forceCloseSession(true);
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.f3848a = false;
                    throw th;
                }
                this.f3848a = false;
            } catch (Exception unused2) {
            }
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
            ALog.e(SessionCenter.TAG, "onNetworkStatusChanged.", SessionCenter.this.f3841c, "networkStatus", networkStatus);
            List<SessionRequest> a10 = SessionCenter.this.f3843e.a();
            if (!a10.isEmpty()) {
                for (SessionRequest sessionRequest : a10) {
                    ALog.d(SessionCenter.TAG, "network change, try recreate session", SessionCenter.this.f3841c, new Object[0]);
                    sessionRequest.a((String) null);
                }
            }
            SessionCenter.this.f3846h.checkAndStartSession();
        }

        @Override // anet.channel.strategy.IStrategyListener
        public void onStrategyUpdated(l.d dVar) {
            SessionCenter.this.a(dVar);
            SessionCenter.this.f3846h.checkAndStartSession();
        }

        public /* synthetic */ a(SessionCenter sessionCenter, d dVar) {
            this();
        }
    }

    @Deprecated
    public Session get(String str, ConnType.TypeLevel typeLevel, long j10) {
        return get(HttpUrl.parse(str), typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f3972a : anet.channel.entity.c.f3973b, j10);
    }

    @Deprecated
    public Session getThrowsException(String str, ConnType.TypeLevel typeLevel, long j10) {
        return a(HttpUrl.parse(str), typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f3972a : anet.channel.entity.c.f3973b, j10, null);
    }

    private SessionRequest a(HttpUrl httpUrl) {
        String cNameByHost = StrategyCenter.getInstance().getCNameByHost(httpUrl.host());
        if (cNameByHost == null) {
            cNameByHost = httpUrl.host();
        }
        String scheme = httpUrl.scheme();
        if (!httpUrl.isSchemeLocked()) {
            scheme = StrategyCenter.getInstance().getSchemeByHost(cNameByHost, scheme);
        }
        return a(StringUtils.concatString(scheme, HttpConstant.SCHEME_SPLIT, cNameByHost));
    }

    @Deprecated
    public Session get(HttpUrl httpUrl, ConnType.TypeLevel typeLevel, long j10) {
        return get(httpUrl, typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f3972a : anet.channel.entity.c.f3973b, j10);
    }

    public Session getThrowsException(HttpUrl httpUrl, int i10, long j10) {
        return a(httpUrl, i10, j10, null);
    }

    public static synchronized SessionCenter getInstance(Config config) {
        SessionCenter sessionCenter;
        Context appContext;
        synchronized (SessionCenter.class) {
            if (config != null) {
                if (!f3839j && (appContext = Utils.getAppContext()) != null) {
                    init(appContext);
                }
                sessionCenter = f3838a.get(config);
                if (sessionCenter == null) {
                    sessionCenter = new SessionCenter(config);
                    f3838a.put(config, sessionCenter);
                }
            } else {
                throw new NullPointerException("config is null!");
            }
        }
        return sessionCenter;
    }

    public Session get(HttpUrl httpUrl, int i10, long j10) {
        try {
            return a(httpUrl, i10, j10, null);
        } catch (NoAvailStrategyException e10) {
            ALog.i(TAG, "[Get]" + e10.getMessage(), this.f3841c, null, "url", httpUrl.urlString());
            return null;
        } catch (ConnectException e11) {
            ALog.e(TAG, "[Get]connect exception", this.f3841c, "errMsg", e11.getMessage(), "url", httpUrl.urlString());
            return null;
        } catch (InvalidParameterException e12) {
            ALog.e(TAG, "[Get]param url is invalid", this.f3841c, e12, "url", httpUrl);
            return null;
        } catch (TimeoutException e13) {
            ALog.e(TAG, "[Get]timeout exception", this.f3841c, e13, "url", httpUrl.urlString());
            return null;
        } catch (Exception e14) {
            ALog.e(TAG, "[Get]" + e14.getMessage(), this.f3841c, null, "url", httpUrl.urlString());
            return null;
        }
    }

    @Deprecated
    public Session getThrowsException(HttpUrl httpUrl, ConnType.TypeLevel typeLevel, long j10) {
        return a(httpUrl, typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f3972a : anet.channel.entity.c.f3973b, j10, null);
    }

    public Session a(HttpUrl httpUrl, int i10, long j10, SessionGetCallback sessionGetCallback) {
        SessionInfo b10;
        if (!f3839j) {
            ALog.e(TAG, "getInternal not inited!", this.f3841c, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        }
        if (httpUrl != null) {
            String str = this.f3841c;
            Object[] objArr = new Object[6];
            objArr[0] = "u";
            objArr[1] = httpUrl.urlString();
            objArr[2] = "sessionType";
            objArr[3] = i10 == anet.channel.entity.c.f3972a ? "LongLink" : "ShortLink";
            objArr[4] = "timeout";
            objArr[5] = Long.valueOf(j10);
            ALog.d(TAG, "getInternal", str, objArr);
            SessionRequest a10 = a(httpUrl);
            Session a11 = this.f3843e.a(a10, i10);
            if (a11 != null) {
                ALog.d(TAG, "get internal hit cache session", this.f3841c, "session", a11);
            } else {
                if (this.f3842d == Config.DEFAULT_CONFIG && i10 != anet.channel.entity.c.f3973b) {
                    if (sessionGetCallback == null) {
                        return null;
                    }
                    sessionGetCallback.onSessionGetFail();
                    return null;
                }
                if (GlobalAppRuntimeInfo.isAppBackground() && i10 == anet.channel.entity.c.f3972a && AwcnConfig.isAccsSessionCreateForbiddenInBg() && (b10 = this.f3845g.b(httpUrl.host())) != null && b10.isAccs) {
                    ALog.w(TAG, "app background, forbid to create accs session", this.f3841c, new Object[0]);
                    throw new ConnectException("accs session connecting forbidden in background");
                }
                a10.a(this.f3840b, i10, anet.channel.util.i.a(this.f3841c), sessionGetCallback, j10);
                if (sessionGetCallback == null && j10 > 0 && (i10 == anet.channel.entity.c.f3974c || a10.b() == i10)) {
                    a10.a(j10);
                    a11 = this.f3843e.a(a10, i10);
                    if (a11 == null) {
                        throw new ConnectException("session connecting failed or timeout");
                    }
                }
            }
            return a11;
        }
        throw new InvalidParameterException("httpUrl is null");
    }

    @Deprecated
    public static synchronized SessionCenter getInstance() {
        Context appContext;
        synchronized (SessionCenter.class) {
            if (!f3839j && (appContext = Utils.getAppContext()) != null) {
                init(appContext);
            }
            SessionCenter sessionCenter = null;
            for (Map.Entry<Config, SessionCenter> entry : f3838a.entrySet()) {
                SessionCenter value = entry.getValue();
                if (entry.getKey() != Config.DEFAULT_CONFIG) {
                    return value;
                }
                sessionCenter = value;
            }
            return sessionCenter;
        }
    }

    @Deprecated
    public static synchronized void init(Context context, String str) {
        synchronized (SessionCenter.class) {
            init(context, str, GlobalAppRuntimeInfo.getEnv());
        }
    }

    public static synchronized void init(Context context, String str, ENV env) {
        synchronized (SessionCenter.class) {
            if (context != null) {
                Config config = Config.getConfig(str, env);
                if (config == null) {
                    config = new Config.Builder().setAppkey(str).setEnv(env).build();
                }
                init(context, config);
            } else {
                ALog.e(TAG, "context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            }
        }
    }

    private void b(l.b bVar) {
        boolean z10;
        boolean z11;
        ALog.i(TAG, "find effectNow", this.f3841c, Constants.KEY_HOST, bVar.f4222a);
        l.a[] aVarArr = bVar.f4229h;
        String[] strArr = bVar.f4227f;
        for (Session session : this.f3843e.a(a(StringUtils.buildKey(bVar.f4224c, bVar.f4222a)))) {
            if (!session.getConnType().isHttpType()) {
                int i10 = 0;
                while (true) {
                    if (i10 >= strArr.length) {
                        z10 = false;
                        break;
                    } else {
                        if (session.getIp().equals(strArr[i10])) {
                            z10 = true;
                            break;
                        }
                        i10++;
                    }
                }
                if (z10) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= aVarArr.length) {
                            z11 = false;
                            break;
                        } else {
                            if (session.getPort() == aVarArr[i11].f4214a && session.getConnType().equals(ConnType.valueOf(ConnProtocol.valueOf(aVarArr[i11])))) {
                                z11 = true;
                                break;
                            }
                            i11++;
                        }
                    }
                    if (!z11) {
                        if (ALog.isPrintLog(2)) {
                            ALog.i(TAG, "aisle not match", session.f3827p, "port", Integer.valueOf(session.getPort()), "connType", session.getConnType(), "aisle", Arrays.toString(aVarArr));
                        }
                        session.close(true);
                    }
                } else {
                    if (ALog.isPrintLog(2)) {
                        ALog.i(TAG, "ip not match", session.f3827p, "session ip", session.getIp(), "ips", Arrays.toString(strArr));
                    }
                    session.close(true);
                }
            }
        }
    }

    public static synchronized void init(Context context, Config config) {
        synchronized (SessionCenter.class) {
            if (context == null) {
                ALog.e(TAG, "context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            }
            if (config != null) {
                init(context);
                if (!f3838a.containsKey(config)) {
                    f3838a.put(config, new SessionCenter(config));
                }
            } else {
                ALog.e(TAG, "paramter config is null!", null, new Object[0]);
                throw new NullPointerException("init failed. config is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l.d dVar) {
        try {
            for (l.b bVar : dVar.f4237b) {
                if (bVar.f4232k) {
                    b(bVar);
                }
                if (bVar.f4226e != null) {
                    a(bVar);
                }
            }
        } catch (Exception e10) {
            ALog.e(TAG, "checkStrategy failed", this.f3841c, e10, new Object[0]);
        }
    }

    private void a(l.b bVar) {
        for (Session session : this.f3843e.a(a(StringUtils.buildKey(bVar.f4224c, bVar.f4222a)))) {
            if (!StringUtils.isStringEqual(session.f3823l, bVar.f4226e)) {
                ALog.i(TAG, "unit change", session.f3827p, "session unit", session.f3823l, "unit", bVar.f4226e);
                session.close(true);
            }
        }
    }

    public SessionRequest a(String str) {
        SessionRequest sessionRequest;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f3844f) {
            sessionRequest = this.f3844f.get(str);
            if (sessionRequest == null) {
                sessionRequest = new SessionRequest(str, this);
                this.f3844f.put(str, sessionRequest);
            }
        }
        return sessionRequest;
    }
}
