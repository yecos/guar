package anet.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.AlarmObject;
import anet.channel.statist.SessionConnStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
class SessionRequest {

    /* renamed from: a, reason: collision with root package name */
    SessionCenter f3850a;

    /* renamed from: b, reason: collision with root package name */
    e f3851b;

    /* renamed from: c, reason: collision with root package name */
    SessionInfo f3852c;

    /* renamed from: e, reason: collision with root package name */
    volatile Session f3854e;

    /* renamed from: i, reason: collision with root package name */
    private String f3858i;

    /* renamed from: j, reason: collision with root package name */
    private String f3859j;

    /* renamed from: k, reason: collision with root package name */
    private volatile Future f3860k;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f3853d = false;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f3855f = false;

    /* renamed from: g, reason: collision with root package name */
    HashMap<SessionGetCallback, c> f3856g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    SessionConnStat f3857h = null;

    /* renamed from: l, reason: collision with root package name */
    private Object f3861l = new Object();

    public interface IConnCb {
        void onDisConnect(Session session, long j10, int i10);

        void onFailed(Session session, long j10, int i10, int i11);

        void onSuccess(Session session, long j10);
    }

    public class a implements IConnCb {

        /* renamed from: a, reason: collision with root package name */
        boolean f3862a = false;

        /* renamed from: c, reason: collision with root package name */
        private Context f3864c;

        /* renamed from: d, reason: collision with root package name */
        private List<anet.channel.entity.a> f3865d;

        /* renamed from: e, reason: collision with root package name */
        private anet.channel.entity.a f3866e;

        public a(Context context, List<anet.channel.entity.a> list, anet.channel.entity.a aVar) {
            this.f3864c = context;
            this.f3865d = list;
            this.f3866e = aVar;
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onDisConnect(Session session, long j10, int i10) {
            SessionInfo sessionInfo;
            boolean isAppBackground = GlobalAppRuntimeInfo.isAppBackground();
            ALog.d("awcn.SessionRequest", "Connect Disconnect", this.f3866e.h(), "session", session, Constants.KEY_HOST, SessionRequest.this.a(), "appIsBg", Boolean.valueOf(isAppBackground), "isHandleFinish", Boolean.valueOf(this.f3862a));
            SessionRequest sessionRequest = SessionRequest.this;
            sessionRequest.f3851b.b(sessionRequest, session);
            if (this.f3862a) {
                return;
            }
            this.f3862a = true;
            if (session.f3831t) {
                if (isAppBackground && ((sessionInfo = SessionRequest.this.f3852c) == null || !sessionInfo.isAccs || AwcnConfig.isAccsSessionCreateForbiddenInBg())) {
                    ALog.e("awcn.SessionRequest", "[onDisConnect]app background, don't Recreate", this.f3866e.h(), "session", session);
                    return;
                }
                if (!NetworkStatusHelper.isConnected()) {
                    ALog.e("awcn.SessionRequest", "[onDisConnect]no network, don't Recreate", this.f3866e.h(), "session", session);
                    return;
                }
                try {
                    ALog.d("awcn.SessionRequest", "session disconnected, try to recreate session", this.f3866e.h(), new Object[0]);
                    SessionInfo sessionInfo2 = SessionRequest.this.f3852c;
                    int accsReconnectionDelayPeriod = (sessionInfo2 == null || !sessionInfo2.isAccs) ? 10000 : AwcnConfig.getAccsReconnectionDelayPeriod();
                    i iVar = new i(this, session);
                    double random = Math.random();
                    double d10 = accsReconnectionDelayPeriod;
                    Double.isNaN(d10);
                    ThreadPoolExecutorFactory.submitScheduledTask(iVar, (long) (random * d10), TimeUnit.MILLISECONDS);
                } catch (Exception unused) {
                }
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onFailed(Session session, long j10, int i10, int i11) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "Connect failed", this.f3866e.h(), "session", session, Constants.KEY_HOST, SessionRequest.this.a(), "isHandleFinish", Boolean.valueOf(this.f3862a));
            }
            if (SessionRequest.this.f3855f) {
                SessionRequest.this.f3855f = false;
                return;
            }
            if (this.f3862a) {
                return;
            }
            this.f3862a = true;
            SessionRequest sessionRequest = SessionRequest.this;
            sessionRequest.f3851b.b(sessionRequest, session);
            if (!session.f3832u || !NetworkStatusHelper.isConnected() || this.f3865d.isEmpty()) {
                SessionRequest.this.c();
                SessionRequest.this.a(session, i10, i11);
                synchronized (SessionRequest.this.f3856g) {
                    for (Map.Entry<SessionGetCallback, c> entry : SessionRequest.this.f3856g.entrySet()) {
                        c value = entry.getValue();
                        if (value.f3870b.compareAndSet(false, true)) {
                            ThreadPoolExecutorFactory.removeScheduleTask(value);
                            entry.getKey().onSessionGetFail();
                        }
                    }
                    SessionRequest.this.f3856g.clear();
                }
                return;
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "use next connInfo to create session", this.f3866e.h(), Constants.KEY_HOST, SessionRequest.this.a());
            }
            anet.channel.entity.a aVar = this.f3866e;
            if (aVar.f3965b == aVar.f3966c && (i11 == -2003 || i11 == -2410)) {
                ListIterator<anet.channel.entity.a> listIterator = this.f3865d.listIterator();
                while (listIterator.hasNext()) {
                    if (session.getIp().equals(listIterator.next().f3964a.getIp())) {
                        listIterator.remove();
                    }
                }
            }
            if (anet.channel.strategy.utils.d.b(session.getIp())) {
                ListIterator<anet.channel.entity.a> listIterator2 = this.f3865d.listIterator();
                while (listIterator2.hasNext()) {
                    if (anet.channel.strategy.utils.d.b(listIterator2.next().f3964a.getIp())) {
                        listIterator2.remove();
                    }
                }
            }
            if (!this.f3865d.isEmpty()) {
                anet.channel.entity.a remove = this.f3865d.remove(0);
                SessionRequest sessionRequest2 = SessionRequest.this;
                Context context = this.f3864c;
                sessionRequest2.a(context, remove, sessionRequest2.new a(context, this.f3865d, remove), remove.h());
                return;
            }
            SessionRequest.this.c();
            SessionRequest.this.a(session, i10, i11);
            synchronized (SessionRequest.this.f3856g) {
                for (Map.Entry<SessionGetCallback, c> entry2 : SessionRequest.this.f3856g.entrySet()) {
                    c value2 = entry2.getValue();
                    if (value2.f3870b.compareAndSet(false, true)) {
                        ThreadPoolExecutorFactory.removeScheduleTask(value2);
                        entry2.getKey().onSessionGetFail();
                    }
                }
                SessionRequest.this.f3856g.clear();
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onSuccess(Session session, long j10) {
            ALog.d("awcn.SessionRequest", "Connect Success", this.f3866e.h(), "session", session, Constants.KEY_HOST, SessionRequest.this.a());
            try {
                if (SessionRequest.this.f3855f) {
                    SessionRequest.this.f3855f = false;
                    session.close(false);
                    return;
                }
                SessionRequest sessionRequest = SessionRequest.this;
                sessionRequest.f3851b.a(sessionRequest, session);
                SessionRequest.this.a(session);
                synchronized (SessionRequest.this.f3856g) {
                    for (Map.Entry<SessionGetCallback, c> entry : SessionRequest.this.f3856g.entrySet()) {
                        c value = entry.getValue();
                        if (value.f3870b.compareAndSet(false, true)) {
                            ThreadPoolExecutorFactory.removeScheduleTask(value);
                            entry.getKey().onSessionGetSuccess(session);
                        }
                    }
                    SessionRequest.this.f3856g.clear();
                }
            } catch (Exception e10) {
                ALog.e("awcn.SessionRequest", "[onSuccess]:", this.f3866e.h(), e10, new Object[0]);
            } finally {
                SessionRequest.this.c();
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        String f3867a;

        public b(String str) {
            this.f3867a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SessionRequest.this.f3853d) {
                ALog.e("awcn.SessionRequest", "Connecting timeout!!! reset status!", this.f3867a, new Object[0]);
                SessionConnStat sessionConnStat = SessionRequest.this.f3857h;
                sessionConnStat.ret = 2;
                sessionConnStat.totalTime = System.currentTimeMillis() - SessionRequest.this.f3857h.start;
                if (SessionRequest.this.f3854e != null) {
                    SessionRequest.this.f3854e.f3832u = false;
                    SessionRequest.this.f3854e.close();
                    SessionRequest sessionRequest = SessionRequest.this;
                    sessionRequest.f3857h.syncValueFromSession(sessionRequest.f3854e);
                }
                AppMonitor.getInstance().commitStat(SessionRequest.this.f3857h);
                SessionRequest.this.a(false);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        SessionGetCallback f3869a;

        /* renamed from: b, reason: collision with root package name */
        AtomicBoolean f3870b = new AtomicBoolean(false);

        public c(SessionGetCallback sessionGetCallback) {
            this.f3869a = null;
            this.f3869a = sessionGetCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3870b.compareAndSet(false, true)) {
                ALog.e("awcn.SessionRequest", "get session timeout", null, new Object[0]);
                synchronized (SessionRequest.this.f3856g) {
                    SessionRequest.this.f3856g.remove(this.f3869a);
                }
                this.f3869a.onSessionGetFail();
            }
        }
    }

    public SessionRequest(String str, SessionCenter sessionCenter) {
        this.f3858i = str;
        String substring = str.substring(str.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.f3859j = substring;
        this.f3850a = sessionCenter;
        this.f3852c = sessionCenter.f3845g.b(substring);
        this.f3851b = sessionCenter.f3843e;
    }

    public synchronized void b(Context context, int i10, String str, SessionGetCallback sessionGetCallback, long j10) {
        Session a10 = this.f3851b.a(this, i10);
        if (a10 != null) {
            ALog.d("awcn.SessionRequest", "Available Session exist!!!", str, new Object[0]);
            sessionGetCallback.onSessionGetSuccess(a10);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = anet.channel.util.i.a(null);
        }
        ALog.d("awcn.SessionRequest", "SessionRequest start", str, Constants.KEY_HOST, this.f3858i, "type", Integer.valueOf(i10));
        if (this.f3853d) {
            ALog.d("awcn.SessionRequest", "session connecting", str, Constants.KEY_HOST, a());
            if (b() == i10) {
                c cVar = new c(sessionGetCallback);
                synchronized (this.f3856g) {
                    this.f3856g.put(sessionGetCallback, cVar);
                }
                ThreadPoolExecutorFactory.submitScheduledTask(cVar, j10, TimeUnit.MILLISECONDS);
            } else {
                sessionGetCallback.onSessionGetFail();
            }
            return;
        }
        a(true);
        this.f3860k = ThreadPoolExecutorFactory.submitScheduledTask(new b(str), 45L, TimeUnit.SECONDS);
        SessionConnStat sessionConnStat = new SessionConnStat();
        this.f3857h = sessionConnStat;
        sessionConnStat.start = System.currentTimeMillis();
        if (!NetworkStatusHelper.isConnected()) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "network is not available, can't create session", str, "isConnected", Boolean.valueOf(NetworkStatusHelper.isConnected()));
            }
            c();
            throw new RuntimeException("no network");
        }
        List<IConnStrategy> a11 = a(i10, str);
        if (a11.isEmpty()) {
            ALog.i("awcn.SessionRequest", "no avalible strategy, can't create session", str, Constants.KEY_HOST, this.f3858i, "type", Integer.valueOf(i10));
            c();
            throw new NoAvailStrategyException("no avalible strategy");
        }
        List<anet.channel.entity.a> a12 = a(a11, str);
        try {
            anet.channel.entity.a remove = a12.remove(0);
            a(context, remove, new a(context, a12, remove), remove.h());
            c cVar2 = new c(sessionGetCallback);
            synchronized (this.f3856g) {
                this.f3856g.put(sessionGetCallback, cVar2);
            }
            ThreadPoolExecutorFactory.submitScheduledTask(cVar2, j10, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
            c();
        }
        return;
    }

    public void c() {
        a(false);
        synchronized (this.f3861l) {
            this.f3861l.notifyAll();
        }
    }

    public String a() {
        return this.f3858i;
    }

    public void a(boolean z10) {
        this.f3853d = z10;
        if (z10) {
            return;
        }
        if (this.f3860k != null) {
            this.f3860k.cancel(true);
            this.f3860k = null;
        }
        this.f3854e = null;
    }

    private void c(Session session, int i10, String str) {
        SessionInfo sessionInfo = this.f3852c;
        if (sessionInfo == null || !sessionInfo.isAccs) {
            return;
        }
        ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByCallBack", null, new Object[0]);
        Intent intent = new Intent(Constants.ACTION_ACCS_CONNECT_INFO);
        intent.putExtra("command", 103);
        intent.putExtra(Constants.KEY_HOST, session.getHost());
        intent.putExtra(Constants.KEY_CENTER_HOST, true);
        boolean isAvailable = session.isAvailable();
        if (!isAvailable) {
            intent.putExtra("errorCode", i10);
            intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
        }
        intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, isAvailable);
        intent.putExtra(Constants.KEY_TYPE_INAPP, true);
        this.f3850a.f3846h.notifyListener(intent);
    }

    public synchronized void a(Context context, int i10, String str, SessionGetCallback sessionGetCallback, long j10) {
        Session a10 = this.f3851b.a(this, i10);
        if (a10 != null) {
            ALog.d("awcn.SessionRequest", "Available Session exist!!!", str, new Object[0]);
            if (sessionGetCallback != null) {
                sessionGetCallback.onSessionGetSuccess(a10);
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = anet.channel.util.i.a(null);
        }
        ALog.d("awcn.SessionRequest", "SessionRequest start", str, Constants.KEY_HOST, this.f3858i, "type", Integer.valueOf(i10));
        if (this.f3853d) {
            ALog.d("awcn.SessionRequest", "session connecting", str, Constants.KEY_HOST, a());
            if (sessionGetCallback != null) {
                if (b() == i10) {
                    c cVar = new c(sessionGetCallback);
                    synchronized (this.f3856g) {
                        this.f3856g.put(sessionGetCallback, cVar);
                    }
                    ThreadPoolExecutorFactory.submitScheduledTask(cVar, j10, TimeUnit.MILLISECONDS);
                } else {
                    sessionGetCallback.onSessionGetFail();
                }
            }
            return;
        }
        a(true);
        this.f3860k = ThreadPoolExecutorFactory.submitScheduledTask(new b(str), 45L, TimeUnit.SECONDS);
        SessionConnStat sessionConnStat = new SessionConnStat();
        this.f3857h = sessionConnStat;
        sessionConnStat.start = System.currentTimeMillis();
        if (!NetworkStatusHelper.isConnected()) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "network is not available, can't create session", str, "isConnected", Boolean.valueOf(NetworkStatusHelper.isConnected()));
            }
            c();
            throw new RuntimeException("no network");
        }
        List<IConnStrategy> a11 = a(i10, str);
        if (!a11.isEmpty()) {
            List<anet.channel.entity.a> a12 = a(a11, str);
            try {
                anet.channel.entity.a remove = a12.remove(0);
                a(context, remove, new a(context, a12, remove), remove.h());
                if (sessionGetCallback != null) {
                    c cVar2 = new c(sessionGetCallback);
                    synchronized (this.f3856g) {
                        this.f3856g.put(sessionGetCallback, cVar2);
                    }
                    ThreadPoolExecutorFactory.submitScheduledTask(cVar2, j10, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable unused) {
                c();
            }
            return;
        }
        ALog.i("awcn.SessionRequest", "no avalible strategy, can't create session", str, Constants.KEY_HOST, this.f3858i, "type", Integer.valueOf(i10));
        c();
        throw new NoAvailStrategyException("no avalible strategy");
    }

    public void b(boolean z10) {
        ALog.d("awcn.SessionRequest", "closeSessions", this.f3850a.f3841c, Constants.KEY_HOST, this.f3858i, "autoCreate", Boolean.valueOf(z10));
        if (!z10 && this.f3854e != null) {
            this.f3854e.f3832u = false;
            this.f3854e.close(false);
        }
        List<Session> a10 = this.f3851b.a(this);
        if (a10 != null) {
            for (Session session : a10) {
                if (session != null) {
                    session.close(z10);
                }
            }
        }
    }

    public void a(Session session) {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = bt.by;
        alarmObject.arg = this.f3858i;
        alarmObject.isSuccess = true;
        AppMonitor.getInstance().commitAlarm(alarmObject);
        this.f3857h.syncValueFromSession(session);
        SessionConnStat sessionConnStat = this.f3857h;
        sessionConnStat.ret = 1;
        sessionConnStat.totalTime = System.currentTimeMillis() - this.f3857h.start;
        AppMonitor.getInstance().commitStat(this.f3857h);
    }

    public int b() {
        Session session = this.f3854e;
        if (session != null) {
            return session.f3821j.getType();
        }
        return -1;
    }

    private void b(Session session, int i10, String str) {
        SessionInfo sessionInfo;
        Context context = GlobalAppRuntimeInfo.getContext();
        if (context == null || (sessionInfo = this.f3852c) == null || !sessionInfo.isAccs) {
            return;
        }
        ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, new Object[0]);
        try {
            Intent intent = new Intent(Constants.ACTION_RECEIVE);
            intent.setPackage(context.getPackageName());
            intent.setClassName(context, com.taobao.accs.utl.j.msgService);
            intent.putExtra("command", 103);
            intent.putExtra(Constants.KEY_HOST, session.getHost());
            intent.putExtra(Constants.KEY_CENTER_HOST, true);
            boolean isAvailable = session.isAvailable();
            if (!isAvailable) {
                intent.putExtra("errorCode", i10);
                intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
            }
            intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, isAvailable);
            intent.putExtra(Constants.KEY_TYPE_INAPP, true);
            if (Build.VERSION.SDK_INT >= 26) {
                context.bindService(intent, new h(this, intent, context), 1);
            } else {
                context.startService(intent);
            }
        } catch (Throwable th) {
            ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, th, new Object[0]);
        }
    }

    public void a(Session session, int i10, int i11) {
        if (256 != i10 || i11 == -2613 || i11 == -2601) {
            return;
        }
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = bt.by;
        alarmObject.arg = this.f3858i;
        alarmObject.errorCode = String.valueOf(i11);
        alarmObject.isSuccess = false;
        AppMonitor.getInstance().commitAlarm(alarmObject);
        SessionConnStat sessionConnStat = this.f3857h;
        sessionConnStat.ret = 0;
        sessionConnStat.appendErrorTrace(i11);
        this.f3857h.errorCode = String.valueOf(i11);
        this.f3857h.totalTime = System.currentTimeMillis() - this.f3857h.start;
        this.f3857h.syncValueFromSession(session);
        AppMonitor.getInstance().commitStat(this.f3857h);
    }

    private List<IConnStrategy> a(int i10, String str) {
        HttpUrl parse;
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        try {
            parse = HttpUrl.parse(a());
        } catch (Throwable th) {
            ALog.e("awcn.SessionRequest", "", str, th, new Object[0]);
        }
        if (parse == null) {
            return list;
        }
        list = StrategyCenter.getInstance().getConnStrategyListByHost(parse.host());
        if (!list.isEmpty()) {
            boolean equalsIgnoreCase = "https".equalsIgnoreCase(parse.scheme());
            boolean b10 = anet.channel.util.c.b();
            ListIterator<IConnStrategy> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                IConnStrategy next = listIterator.next();
                ConnType valueOf = ConnType.valueOf(next.getProtocol());
                if (valueOf != null) {
                    if (valueOf.isSSL() == equalsIgnoreCase && (i10 == anet.channel.entity.c.f3974c || valueOf.getType() == i10)) {
                        if (b10 && anet.channel.strategy.utils.d.b(next.getIp())) {
                            listIterator.remove();
                        }
                    }
                    listIterator.remove();
                }
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.SessionRequest", "[getAvailStrategy]", str, "strategies", list);
        }
        return list;
    }

    private List<anet.channel.entity.a> a(List<IConnStrategy> list, String str) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            IConnStrategy iConnStrategy = list.get(i11);
            int retryTimes = iConnStrategy.getRetryTimes();
            for (int i12 = 0; i12 <= retryTimes; i12++) {
                i10++;
                anet.channel.entity.a aVar = new anet.channel.entity.a(a(), str + "_" + i10, iConnStrategy);
                aVar.f3965b = i12;
                aVar.f3966c = retryTimes;
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, anet.channel.entity.a aVar, IConnCb iConnCb, String str) {
        ConnType c10 = aVar.c();
        if (context != null && !c10.isHttpType()) {
            TnetSpdySession tnetSpdySession = new TnetSpdySession(context, aVar);
            tnetSpdySession.initConfig(this.f3850a.f3842d);
            tnetSpdySession.initSessionInfo(this.f3852c);
            tnetSpdySession.setTnetPublicKey(this.f3850a.f3845g.c(this.f3859j));
            this.f3854e = tnetSpdySession;
        } else {
            this.f3854e = new anet.channel.session.d(context, aVar);
        }
        ALog.i("awcn.SessionRequest", "create connection...", str, "Host", a(), "Type", aVar.c(), "IP", aVar.a(), "Port", Integer.valueOf(aVar.b()), "heartbeat", Integer.valueOf(aVar.g()), "session", this.f3854e);
        a(this.f3854e, iConnCb, System.currentTimeMillis());
        this.f3854e.connect();
        SessionConnStat sessionConnStat = this.f3857h;
        sessionConnStat.retryTimes++;
        sessionConnStat.startConnect = System.currentTimeMillis();
        SessionConnStat sessionConnStat2 = this.f3857h;
        if (sessionConnStat2.retryTimes == 0) {
            sessionConnStat2.putExtra("firstIp", aVar.a());
        }
    }

    private void a(Session session, IConnCb iConnCb, long j10) {
        if (iConnCb == null) {
            return;
        }
        session.registerEventcb(EventType.ALL, new f(this, iConnCb, j10));
        session.registerEventcb(1792, new g(this, session));
    }

    public void a(String str) {
        ALog.d("awcn.SessionRequest", "reCreateSession", str, Constants.KEY_HOST, this.f3858i);
        b(true);
    }

    public void a(long j10) {
        ALog.d("awcn.SessionRequest", "[await]", null, "timeoutMs", Long.valueOf(j10));
        if (j10 <= 0) {
            return;
        }
        synchronized (this.f3861l) {
            long currentTimeMillis = System.currentTimeMillis() + j10;
            while (this.f3853d) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 >= currentTimeMillis) {
                    break;
                } else {
                    this.f3861l.wait(currentTimeMillis - currentTimeMillis2);
                }
            }
            if (this.f3853d) {
                throw new TimeoutException();
            }
        }
    }

    public void a(Session session, int i10, String str) {
        if (AwcnConfig.isSendConnectInfoByService()) {
            b(session, i10, str);
        }
        c(session, i10, str);
    }
}
