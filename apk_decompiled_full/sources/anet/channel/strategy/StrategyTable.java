package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class StrategyTable implements Serializable {

    /* renamed from: e, reason: collision with root package name */
    protected static Comparator<StrategyCollection> f4168e = new o();

    /* renamed from: a, reason: collision with root package name */
    protected String f4169a;

    /* renamed from: b, reason: collision with root package name */
    protected volatile String f4170b;

    /* renamed from: c, reason: collision with root package name */
    Map<String, Long> f4171c;

    /* renamed from: d, reason: collision with root package name */
    protected transient boolean f4172d = false;

    /* renamed from: f, reason: collision with root package name */
    private HostLruCache f4173f;

    /* renamed from: g, reason: collision with root package name */
    private volatile transient int f4174g;

    public static class HostLruCache extends SerialLruCache<String, StrategyCollection> {
        public HostLruCache(int i10) {
            super(i10);
        }

        @Override // anet.channel.strategy.utils.SerialLruCache
        public boolean entryRemoved(Map.Entry<String, StrategyCollection> entry) {
            if (!entry.getValue().f4150d) {
                return true;
            }
            Iterator<Map.Entry<String, StrategyCollection>> it = entrySet().iterator();
            while (it.hasNext()) {
                if (!it.next().getValue().f4150d) {
                    it.remove();
                    return false;
                }
            }
            return false;
        }
    }

    public StrategyTable(String str) {
        this.f4169a = str;
        a();
    }

    private void b() {
        if (HttpDispatcher.getInstance().isInitHostsChanged(this.f4169a)) {
            for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                this.f4173f.put(str, new StrategyCollection(str));
            }
        }
    }

    private void c() {
        TreeSet treeSet;
        try {
            if (HttpDispatcher.getInstance().isInitHostsChanged(this.f4169a)) {
                synchronized (this.f4173f) {
                    treeSet = null;
                    for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                        if (!this.f4173f.containsKey(str)) {
                            this.f4173f.put(str, new StrategyCollection(str));
                            if (treeSet == null) {
                                treeSet = new TreeSet();
                            }
                            treeSet.add(str);
                        }
                    }
                }
                if (treeSet != null) {
                    a(treeSet);
                }
            }
        } catch (Exception e10) {
            ALog.e("awcn.StrategyTable", "checkInitHost failed", this.f4169a, e10, new Object[0]);
        }
    }

    public void a() {
        if (this.f4173f == null) {
            this.f4173f = new HostLruCache(256);
            b();
        }
        Iterator<StrategyCollection> it = this.f4173f.values().iterator();
        while (it.hasNext()) {
            it.next().checkInit();
        }
        ALog.i("awcn.StrategyTable", "strategy map", null, "size", Integer.valueOf(this.f4173f.size()));
        this.f4174g = GlobalAppRuntimeInfo.isTargetProcess() ? 0 : -1;
        if (this.f4171c == null) {
            this.f4171c = new ConcurrentHashMap();
        }
    }

    public String getCnameByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f4173f) {
            strategyCollection = this.f4173f.get(str);
        }
        if (strategyCollection != null && strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0) {
            a(str);
        }
        if (strategyCollection != null) {
            return strategyCollection.f4149c;
        }
        return null;
    }

    public List<IConnStrategy> queryByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str) || !anet.channel.strategy.utils.d.c(str)) {
            return Collections.EMPTY_LIST;
        }
        c();
        synchronized (this.f4173f) {
            strategyCollection = this.f4173f.get(str);
            if (strategyCollection == null) {
                strategyCollection = new StrategyCollection(str);
                this.f4173f.put(str, strategyCollection);
            }
        }
        if (strategyCollection.f4148b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
            a(str);
        }
        return strategyCollection.queryStrategyList();
    }

    public void update(l.d dVar) {
        l.b[] bVarArr;
        String str;
        ALog.i("awcn.StrategyTable", "update strategyTable with httpDns response", this.f4169a, new Object[0]);
        try {
            this.f4170b = dVar.f4236a;
            this.f4174g = dVar.f4241f;
            bVarArr = dVar.f4237b;
        } catch (Throwable th) {
            ALog.e("awcn.StrategyTable", "fail to update strategyTable", this.f4169a, th, new Object[0]);
        }
        if (bVarArr == null) {
            return;
        }
        synchronized (this.f4173f) {
            for (l.b bVar : bVarArr) {
                if (bVar != null && (str = bVar.f4222a) != null) {
                    if (bVar.f4231j) {
                        this.f4173f.remove(str);
                    } else {
                        StrategyCollection strategyCollection = this.f4173f.get(str);
                        if (strategyCollection == null) {
                            strategyCollection = new StrategyCollection(bVar.f4222a);
                            this.f4173f.put(bVar.f4222a, strategyCollection);
                        }
                        strategyCollection.update(bVar);
                    }
                }
            }
        }
        this.f4172d = true;
        if (ALog.isPrintLog(1)) {
            StringBuilder sb = new StringBuilder("uniqueId : ");
            sb.append(this.f4169a);
            sb.append("\n-------------------------domains:------------------------------------");
            ALog.d("awcn.StrategyTable", sb.toString(), null, new Object[0]);
            synchronized (this.f4173f) {
                for (Map.Entry<String, StrategyCollection> entry : this.f4173f.entrySet()) {
                    sb.setLength(0);
                    sb.append(entry.getKey());
                    sb.append(" = ");
                    sb.append(entry.getValue().toString());
                    ALog.d("awcn.StrategyTable", sb.toString(), null, new Object[0]);
                }
            }
        }
    }

    private void b(Set<String> set) {
        TreeSet treeSet = new TreeSet(f4168e);
        synchronized (this.f4173f) {
            treeSet.addAll(this.f4173f.values());
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            StrategyCollection strategyCollection = (StrategyCollection) it.next();
            if (!strategyCollection.isExpired() || set.size() >= 40) {
                return;
            }
            strategyCollection.f4148b = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS + currentTimeMillis;
            set.add(strategyCollection.f4147a);
        }
    }

    private void a(String str) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(str);
        a(treeSet);
    }

    public void a(String str, boolean z10) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f4173f) {
            strategyCollection = this.f4173f.get(str);
            if (strategyCollection == null) {
                strategyCollection = new StrategyCollection(str);
                this.f4173f.put(str, strategyCollection);
            }
        }
        if (z10 || strategyCollection.f4148b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
            a(str);
        }
    }

    private void a(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        if ((GlobalAppRuntimeInfo.isAppBackground() && AppLifecycle.lastEnterBackgroundTime > 0) || !NetworkStatusHelper.isConnected()) {
            ALog.i("awcn.StrategyTable", "app in background or no network", this.f4169a, new Object[0]);
            return;
        }
        int amdcLimitLevel = AmdcRuntimeInfo.getAmdcLimitLevel();
        if (amdcLimitLevel == 3) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f4173f) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                StrategyCollection strategyCollection = this.f4173f.get(it.next());
                if (strategyCollection != null) {
                    strategyCollection.f4148b = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS + currentTimeMillis;
                }
            }
        }
        if (amdcLimitLevel == 0) {
            b(set);
        }
        HttpDispatcher.getInstance().sendAmdcRequest(set, this.f4174g);
    }

    public void a(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        StrategyCollection strategyCollection;
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.StrategyTable", "[notifyConnEvent]", null, "Host", str, "IConnStrategy", iConnStrategy, "ConnEvent", connEvent);
        }
        String str2 = iConnStrategy.getProtocol().protocol;
        if (ConnType.HTTP3.equals(str2) || ConnType.HTTP3_PLAIN.equals(str2)) {
            anet.channel.e.a.a(connEvent.isSuccess);
            ALog.e("awcn.StrategyTable", "enable http3", null, "uniqueId", this.f4169a, "enable", Boolean.valueOf(connEvent.isSuccess));
        }
        if (!connEvent.isSuccess && anet.channel.strategy.utils.d.b(iConnStrategy.getIp())) {
            this.f4171c.put(str, Long.valueOf(System.currentTimeMillis()));
            ALog.e("awcn.StrategyTable", "disable ipv6", null, "uniqueId", this.f4169a, Constants.KEY_HOST, str);
        }
        synchronized (this.f4173f) {
            strategyCollection = this.f4173f.get(str);
        }
        if (strategyCollection != null) {
            strategyCollection.notifyConnEvent(iConnStrategy, connEvent);
        }
    }

    public boolean a(String str, long j10) {
        Long l10 = this.f4171c.get(str);
        if (l10 == null) {
            return false;
        }
        if (l10.longValue() + j10 >= System.currentTimeMillis()) {
            return true;
        }
        this.f4171c.remove(str);
        return false;
    }
}
