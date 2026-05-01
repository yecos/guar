package anet.channel.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class StrategyTemplate {
    Map<String, ConnProtocol> templateMap = new ConcurrentHashMap();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static StrategyTemplate f4175a = new StrategyTemplate();
    }

    public static StrategyTemplate getInstance() {
        return a.f4175a;
    }

    public ConnProtocol getConnProtocol(String str) {
        return this.templateMap.get(str);
    }

    public void registerConnProtocol(String str, ConnProtocol connProtocol) {
        if (connProtocol != null) {
            this.templateMap.put(str, connProtocol);
            try {
                IStrategyInstance strategyCenter = StrategyCenter.getInstance();
                if (strategyCenter instanceof g) {
                    ((g) strategyCenter).f4203b.f4160c.a(str, connProtocol);
                }
            } catch (Exception unused) {
            }
        }
    }
}
