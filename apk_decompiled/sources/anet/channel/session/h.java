package anet.channel.session;

import anet.channel.Session;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyInstance;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f4115a;

    public h(TnetSpdySession tnetSpdySession) {
        this.f4115a = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        IConnStrategy iConnStrategy;
        if (this.f4115a.f4094y) {
            TnetSpdySession tnetSpdySession = this.f4115a;
            ALog.e("awcn.TnetSpdySession", "send msg time out!", tnetSpdySession.f3827p, "pingUnRcv:", Boolean.valueOf(tnetSpdySession.f4094y));
            try {
                this.f4115a.handleCallbacks(2048, null);
                SessionStatistic sessionStatistic = this.f4115a.f3828q;
                if (sessionStatistic != null) {
                    sessionStatistic.closeReason = "ping time out";
                }
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = false;
                connEvent.isAccs = this.f4115a.I;
                IStrategyInstance strategyCenter = StrategyCenter.getInstance();
                str = ((Session) this.f4115a).f3815d;
                iConnStrategy = ((Session) this.f4115a).f3822k;
                strategyCenter.notifyConnEvent(str, iConnStrategy, connEvent);
                this.f4115a.close(true);
            } catch (Exception unused) {
            }
        }
    }
}
