package com.taobao.accs.net;

import anet.channel.entity.ConnType;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private int f9191a = 0;

    /* renamed from: b, reason: collision with root package name */
    private List<IConnStrategy> f9192b = new ArrayList();

    public h(String str) {
        HttpDispatcher.getInstance().addListener(new i(this));
        a(str);
    }

    public List<IConnStrategy> a(String str) {
        List<IConnStrategy> connStrategyListByHost;
        if ((this.f9191a == 0 || this.f9192b.isEmpty()) && (connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str)) != null && !connStrategyListByHost.isEmpty()) {
            this.f9192b.clear();
            for (IConnStrategy iConnStrategy : connStrategyListByHost) {
                ConnType valueOf = ConnType.valueOf(iConnStrategy.getProtocol());
                if (valueOf.getTypeLevel() == ConnType.TypeLevel.SPDY && valueOf.isSSL()) {
                    this.f9192b.add(iConnStrategy);
                }
            }
        }
        return this.f9192b;
    }

    public void b() {
        this.f9191a++;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("HttpDnsProvider", "updateStrategyPos StrategyPos:" + this.f9191a, new Object[0]);
        }
    }

    public int c() {
        return this.f9191a;
    }

    public void b(String str) {
        StrategyCenter.getInstance().forceRefreshStrategy(str);
    }

    public IConnStrategy a() {
        return a(this.f9192b);
    }

    public IConnStrategy a(List<IConnStrategy> list) {
        if (list != null && !list.isEmpty()) {
            int i10 = this.f9191a;
            if (i10 < 0 || i10 >= list.size()) {
                this.f9191a = 0;
            }
            return list.get(this.f9191a);
        }
        ALog.d("HttpDnsProvider", "strategys null or 0", new Object[0]);
        return null;
    }
}
