package anet.channel.detect;

import android.content.Context;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.session.b;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import com.hpplay.cybergarage.http.HTTP;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.netutil.PingResponse;
import org.android.netutil.PingTask;

/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    TreeMap<String, l.c> f3920a = new TreeMap<>();

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f3921b = new AtomicInteger(1);

    private void c(String str, l.e eVar) {
        String str2 = "HR" + this.f3921b.getAndIncrement();
        ALog.i("anet.HorseRaceDetector", "startTcpTask", str2, "ip", eVar.f4244a, "port", Integer.valueOf(eVar.f4245b.f4214a));
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Socket socket = new Socket(eVar.f4244a, eVar.f4245b.f4214a);
            int i10 = eVar.f4245b.f4216c;
            if (i10 == 0) {
                i10 = 10000;
            }
            socket.setSoTimeout(i10);
            ALog.i("anet.HorseRaceDetector", "socket connect success", str2, new Object[0]);
            horseRaceStat.connRet = 1;
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            socket.close();
        } catch (IOException unused) {
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            horseRaceStat.connErrorCode = -404;
        }
        AppMonitor.getInstance().commitStat(horseRaceStat);
    }

    public void a() {
        ALog.e("anet.HorseRaceDetector", "network detect thread start", null, new Object[0]);
        while (true) {
            synchronized (this.f3920a) {
                if (!AwcnConfig.isHorseRaceEnable()) {
                    this.f3920a.clear();
                    return;
                }
                Map.Entry<String, l.c> pollFirstEntry = this.f3920a.pollFirstEntry();
                if (pollFirstEntry == null) {
                    return;
                }
                try {
                    a(pollFirstEntry.getValue());
                } catch (Exception e10) {
                    ALog.e("anet.HorseRaceDetector", "start hr task failed", null, e10, new Object[0]);
                }
            }
        }
    }

    public void b() {
        StrategyCenter.getInstance().registerListener(new e(this));
        AppLifecycle.registerLifecycleListener(new f(this));
    }

    private void b(String str, l.e eVar) {
        ConnProtocol valueOf = ConnProtocol.valueOf(eVar.f4245b);
        ConnType valueOf2 = ConnType.valueOf(valueOf);
        if (valueOf2 == null) {
            return;
        }
        ALog.i("anet.HorseRaceDetector", "startLongLinkTask", null, Constants.KEY_HOST, str, "ip", eVar.f4244a, "port", Integer.valueOf(eVar.f4245b.f4214a), "protocol", valueOf);
        String str2 = "HR" + this.f3921b.getAndIncrement();
        Context context = GlobalAppRuntimeInfo.getContext();
        StringBuilder sb = new StringBuilder();
        sb.append(valueOf2.isSSL() ? "https://" : "http://");
        sb.append(str);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(context, new anet.channel.entity.a(sb.toString(), str2, a(valueOf, eVar)));
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        long currentTimeMillis = System.currentTimeMillis();
        tnetSpdySession.registerEventcb(257, new h(this, horseRaceStat, currentTimeMillis, str2, eVar, tnetSpdySession));
        tnetSpdySession.connect();
        synchronized (horseRaceStat) {
            try {
                int i10 = eVar.f4245b.f4216c;
                if (i10 == 0) {
                    i10 = 10000;
                }
                horseRaceStat.wait(i10);
                if (horseRaceStat.connTime == 0) {
                    horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
                }
                a(eVar.f4244a, horseRaceStat);
                AppMonitor.getInstance().commitStat(horseRaceStat);
            } catch (InterruptedException unused) {
            }
        }
        tnetSpdySession.close(false);
    }

    private void a(l.c cVar) {
        l.e[] eVarArr = cVar.f4235b;
        if (eVarArr == null || eVarArr.length == 0) {
            return;
        }
        String str = cVar.f4234a;
        int i10 = 0;
        while (true) {
            l.e[] eVarArr2 = cVar.f4235b;
            if (i10 >= eVarArr2.length) {
                return;
            }
            l.e eVar = eVarArr2[i10];
            String str2 = eVar.f4245b.f4215b;
            if (!str2.equalsIgnoreCase(HttpConstant.HTTP) && !str2.equalsIgnoreCase("https")) {
                if (!str2.equalsIgnoreCase(ConnType.HTTP2) && !str2.equalsIgnoreCase(ConnType.SPDY) && !str2.equalsIgnoreCase(ConnType.QUIC)) {
                    if (str2.equalsIgnoreCase("tcp")) {
                        c(str, eVar);
                    }
                } else {
                    b(str, eVar);
                }
            } else {
                a(str, eVar);
            }
            i10++;
        }
    }

    private void a(String str, l.e eVar) {
        HttpUrl parse = HttpUrl.parse(eVar.f4245b.f4215b + HttpConstant.SCHEME_SPLIT + str + eVar.f4246c);
        if (parse == null) {
            return;
        }
        ALog.i("anet.HorseRaceDetector", "startShortLinkTask", null, "url", parse);
        Request build = new Request.Builder().setUrl(parse).addHeader("Connection", HTTP.CLOSE).setConnectTimeout(eVar.f4245b.f4216c).setReadTimeout(eVar.f4245b.f4217d).setRedirectEnable(false).setSslSocketFactory(new anet.channel.util.j(str)).setSeq("HR" + this.f3921b.getAndIncrement()).build();
        build.setDnsOptimize(eVar.f4244a, eVar.f4245b.f4214a);
        long currentTimeMillis = System.currentTimeMillis();
        b.a a10 = anet.channel.session.b.a(build, (RequestCb) null);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        horseRaceStat.connTime = currentTimeMillis2;
        int i10 = a10.f4101a;
        if (i10 <= 0) {
            horseRaceStat.connErrorCode = i10;
        } else {
            horseRaceStat.connRet = 1;
            horseRaceStat.reqRet = a10.f4101a == 200 ? 1 : 0;
            horseRaceStat.reqErrorCode = a10.f4101a;
            horseRaceStat.reqTime = horseRaceStat.connTime;
        }
        a(eVar.f4244a, horseRaceStat);
        AppMonitor.getInstance().commitStat(horseRaceStat);
    }

    private static IConnStrategy a(ConnProtocol connProtocol, l.e eVar) {
        return new j(eVar, connProtocol);
    }

    private void a(String str, HorseRaceStat horseRaceStat) {
        if (AwcnConfig.isPing6Enable() && anet.channel.strategy.utils.d.b(str)) {
            try {
                PingResponse pingResponse = (PingResponse) new PingTask(str, 1000, 3, 0, 0).launch().get();
                if (pingResponse == null) {
                    return;
                }
                horseRaceStat.pingSuccessCount = pingResponse.getSuccessCnt();
                horseRaceStat.pingTimeoutCount = 3 - horseRaceStat.pingSuccessCount;
                horseRaceStat.localIP = pingResponse.getLocalIPStr();
            } catch (Throwable th) {
                ALog.e("anet.HorseRaceDetector", "ping6 task fail.", null, th, new Object[0]);
            }
        }
    }
}
