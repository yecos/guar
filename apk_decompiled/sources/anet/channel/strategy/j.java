package anet.channel.strategy;

import anet.channel.strategy.StrategyList;
import anet.channel.strategy.l;

/* loaded from: classes.dex */
class j implements StrategyList.Predicate<IPConnStrategy> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l.a f4209a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4210b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ConnProtocol f4211c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ StrategyList f4212d;

    public j(StrategyList strategyList, l.a aVar, String str, ConnProtocol connProtocol) {
        this.f4212d = strategyList;
        this.f4209a = aVar;
        this.f4210b = str;
        this.f4211c = connProtocol;
    }

    @Override // anet.channel.strategy.StrategyList.Predicate
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean apply(IPConnStrategy iPConnStrategy) {
        return iPConnStrategy.getPort() == this.f4209a.f4214a && iPConnStrategy.getIp().equals(this.f4210b) && iPConnStrategy.protocol.equals(this.f4211c);
    }
}
