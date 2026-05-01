package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* loaded from: classes.dex */
class g implements EventCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Session f3988a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SessionRequest f3989b;

    public g(SessionRequest sessionRequest, Session session) {
        this.f3989b = sessionRequest;
        this.f3988a = session;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i10, anet.channel.entity.b bVar) {
        ALog.d("awcn.SessionRequest", "Receive session event", null, "eventType", Integer.valueOf(i10));
        ConnEvent connEvent = new ConnEvent();
        if (i10 == 512) {
            connEvent.isSuccess = true;
        }
        SessionInfo sessionInfo = this.f3989b.f3852c;
        if (sessionInfo != null) {
            connEvent.isAccs = sessionInfo.isAccs;
        }
        StrategyCenter.getInstance().notifyConnEvent(this.f3988a.getRealHost(), this.f3988a.getConnStrategy(), connEvent);
    }
}
