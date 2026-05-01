package anet.channel.e;

import anet.channel.Session;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.e.a;
import anet.channel.entity.EventCb;
import anet.channel.statist.Http3DetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;

/* loaded from: classes.dex */
class f implements EventCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IConnStrategy f3961a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f3962b;

    public f(e eVar, IConnStrategy iConnStrategy) {
        this.f3962b = eVar;
        this.f3961a = iConnStrategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i10, anet.channel.entity.b bVar) {
        a.b bVar2;
        String str;
        ?? r02 = i10 != 1 ? 0 : 1;
        bVar2 = a.f3946a;
        bVar2.a(NetworkStatusHelper.getUniqueId(this.f3962b.f3960b), r02);
        session.close(false);
        str = a.f3947b;
        Http3DetectStat http3DetectStat = new Http3DetectStat(str, this.f3961a);
        http3DetectStat.ret = r02;
        AppMonitor.getInstance().commitStat(http3DetectStat);
    }
}
