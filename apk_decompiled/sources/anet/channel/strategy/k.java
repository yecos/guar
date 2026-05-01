package anet.channel.strategy;

import java.util.Comparator;
import java.util.Map;

/* loaded from: classes.dex */
class k implements Comparator<IPConnStrategy> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StrategyList f4213a;

    public k(StrategyList strategyList) {
        this.f4213a = strategyList;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(IPConnStrategy iPConnStrategy, IPConnStrategy iPConnStrategy2) {
        Map map;
        Map map2;
        int i10;
        int i11;
        map = this.f4213a.f4165b;
        ConnHistoryItem connHistoryItem = (ConnHistoryItem) map.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
        map2 = this.f4213a.f4165b;
        ConnHistoryItem connHistoryItem2 = (ConnHistoryItem) map2.get(Integer.valueOf(iPConnStrategy2.getUniqueId()));
        int a10 = connHistoryItem.a();
        int a11 = connHistoryItem2.a();
        if (a10 != a11) {
            return a10 - a11;
        }
        if (iPConnStrategy.f4144a != iPConnStrategy2.f4144a) {
            i10 = iPConnStrategy.f4144a;
            i11 = iPConnStrategy2.f4144a;
        } else {
            i10 = iPConnStrategy.protocol.isHttp;
            i11 = iPConnStrategy2.protocol.isHttp;
        }
        return i10 - i11;
    }
}
