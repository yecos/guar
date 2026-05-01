package anet.channel.strategy;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.PolicyVersionStat;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
class StrategyCollection implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    String f4147a;

    /* renamed from: b, reason: collision with root package name */
    volatile long f4148b;

    /* renamed from: c, reason: collision with root package name */
    volatile String f4149c;

    /* renamed from: d, reason: collision with root package name */
    boolean f4150d;

    /* renamed from: e, reason: collision with root package name */
    int f4151e;

    /* renamed from: f, reason: collision with root package name */
    private StrategyList f4152f;

    /* renamed from: g, reason: collision with root package name */
    private transient long f4153g;

    /* renamed from: h, reason: collision with root package name */
    private transient boolean f4154h;

    public StrategyCollection() {
        this.f4152f = null;
        this.f4148b = 0L;
        this.f4149c = null;
        this.f4150d = false;
        this.f4151e = 0;
        this.f4153g = 0L;
        this.f4154h = true;
    }

    public synchronized void checkInit() {
        if (System.currentTimeMillis() - this.f4148b > 172800000) {
            this.f4152f = null;
            return;
        }
        StrategyList strategyList = this.f4152f;
        if (strategyList != null) {
            strategyList.checkInit();
        }
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.f4148b;
    }

    public synchronized void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        StrategyList strategyList = this.f4152f;
        if (strategyList != null) {
            strategyList.notifyConnEvent(iConnStrategy, connEvent);
            if (!connEvent.isSuccess && this.f4152f.shouldRefresh()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f4153g > 60000) {
                    StrategyCenter.getInstance().forceRefreshStrategy(this.f4147a);
                    this.f4153g = currentTimeMillis;
                }
            }
        }
    }

    public synchronized List<IConnStrategy> queryStrategyList() {
        if (this.f4152f == null) {
            return Collections.EMPTY_LIST;
        }
        if (this.f4154h) {
            this.f4154h = false;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.f4147a, this.f4151e);
            policyVersionStat.reportType = 0;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        return this.f4152f.getStrategyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("\nStrategyList = ");
        sb.append(this.f4148b);
        StrategyList strategyList = this.f4152f;
        if (strategyList != null) {
            sb.append(strategyList.toString());
        } else if (this.f4149c != null) {
            sb.append('[');
            sb.append(this.f4147a);
            sb.append("=>");
            sb.append(this.f4149c);
            sb.append(']');
        } else {
            sb.append("[]");
        }
        return sb.toString();
    }

    public synchronized void update(l.b bVar) {
        l.e[] eVarArr;
        l.a[] aVarArr;
        this.f4148b = System.currentTimeMillis() + (bVar.f4223b * 1000);
        if (!bVar.f4222a.equalsIgnoreCase(this.f4147a)) {
            ALog.e("StrategyCollection", "update error!", null, Constants.KEY_HOST, this.f4147a, "dnsInfo.host", bVar.f4222a);
            return;
        }
        int i10 = this.f4151e;
        int i11 = bVar.f4233l;
        if (i10 != i11) {
            this.f4151e = i11;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.f4147a, i11);
            policyVersionStat.reportType = 1;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        this.f4149c = bVar.f4225d;
        String[] strArr = bVar.f4227f;
        if ((strArr != null && strArr.length != 0 && (aVarArr = bVar.f4229h) != null && aVarArr.length != 0) || ((eVarArr = bVar.f4230i) != null && eVarArr.length != 0)) {
            if (this.f4152f == null) {
                this.f4152f = new StrategyList();
            }
            this.f4152f.update(bVar);
            return;
        }
        this.f4152f = null;
    }

    public StrategyCollection(String str) {
        this.f4152f = null;
        this.f4148b = 0L;
        this.f4149c = null;
        this.f4150d = false;
        this.f4151e = 0;
        this.f4153g = 0L;
        this.f4154h = true;
        this.f4147a = str;
        this.f4150d = DispatchConstants.isAmdcServerDomain(str);
    }
}
