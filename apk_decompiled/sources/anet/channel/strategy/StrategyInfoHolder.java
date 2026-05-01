package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.StrategyStatObject;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
class StrategyInfoHolder implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    Map<String, StrategyTable> f4158a = new LruStrategyMap();

    /* renamed from: b, reason: collision with root package name */
    volatile StrategyConfig f4159b = null;

    /* renamed from: c, reason: collision with root package name */
    final a f4160c = new a();

    /* renamed from: d, reason: collision with root package name */
    private final StrategyTable f4161d = new StrategyTable("Unknown");

    /* renamed from: e, reason: collision with root package name */
    private final Set<String> f4162e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private volatile String f4163f = "";

    public static class LruStrategyMap extends SerialLruCache<String, StrategyTable> {
        public LruStrategyMap() {
            super(3);
        }

        @Override // anet.channel.strategy.utils.SerialLruCache
        public boolean entryRemoved(Map.Entry<String, StrategyTable> entry) {
            anet.channel.strategy.utils.a.a(new f(this, entry));
            return true;
        }
    }

    private StrategyInfoHolder() {
        try {
            e();
            g();
        } catch (Throwable unused) {
        }
        f();
    }

    public static StrategyInfoHolder a() {
        return new StrategyInfoHolder();
    }

    private void e() {
        NetworkStatusHelper.addStatusChangeListener(this);
        this.f4163f = a(NetworkStatusHelper.getStatus());
    }

    private void f() {
        Iterator<Map.Entry<String, StrategyTable>> it = this.f4158a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
        synchronized (this) {
            if (this.f4159b == null) {
                StrategyConfig strategyConfig = new StrategyConfig();
                strategyConfig.b();
                strategyConfig.a(this);
                this.f4159b = strategyConfig;
            }
        }
    }

    private void g() {
        ALog.i("awcn.StrategyInfoHolder", "restore", null, new Object[0]);
        String str = this.f4163f;
        if (!AwcnConfig.isAsyncLoadStrategyEnable()) {
            if (!TextUtils.isEmpty(str)) {
                a(str, true);
            }
            this.f4159b = (StrategyConfig) m.a("StrategyConfig", null);
            if (this.f4159b != null) {
                this.f4159b.b();
                this.f4159b.a(this);
            }
        }
        anet.channel.strategy.utils.a.a(new d(this, str));
    }

    public void b() {
        NetworkStatusHelper.removeStatusChangeListener(this);
    }

    public void c() {
        synchronized (this) {
            for (StrategyTable strategyTable : this.f4158a.values()) {
                if (strategyTable.f4172d) {
                    StrategyStatObject strategyStatObject = new StrategyStatObject(1);
                    String str = strategyTable.f4169a;
                    strategyStatObject.writeStrategyFileId = str;
                    m.a(strategyTable, str, strategyStatObject);
                    strategyTable.f4172d = false;
                }
            }
            m.a(this.f4159b.a(), "StrategyConfig", null);
        }
    }

    public StrategyTable d() {
        StrategyTable strategyTable = this.f4161d;
        String str = this.f4163f;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f4158a) {
                strategyTable = this.f4158a.get(str);
                if (strategyTable == null) {
                    strategyTable = new StrategyTable(str);
                    this.f4158a.put(str, strategyTable);
                }
            }
        }
        return strategyTable;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f4160c.a();
        this.f4163f = a(networkStatus);
        String str = this.f4163f;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f4158a) {
            if (!this.f4158a.containsKey(str)) {
                anet.channel.strategy.utils.a.a(new e(this, str));
            }
        }
    }

    public void a(String str, boolean z10) {
        StrategyStatObject strategyStatObject;
        synchronized (this.f4162e) {
            if (this.f4162e.contains(str)) {
                return;
            }
            this.f4162e.add(str);
            if (z10) {
                strategyStatObject = new StrategyStatObject(0);
                strategyStatObject.readStrategyFileId = str;
            } else {
                strategyStatObject = null;
            }
            StrategyTable strategyTable = (StrategyTable) m.a(str, strategyStatObject);
            if (strategyTable != null) {
                strategyTable.a();
                synchronized (this.f4158a) {
                    this.f4158a.put(strategyTable.f4169a, strategyTable);
                }
            }
            synchronized (this.f4162e) {
                this.f4162e.remove(str);
            }
            if (z10) {
                strategyStatObject.isSucceed = strategyTable != null ? 1 : 0;
                AppMonitor.getInstance().commitStat(strategyStatObject);
            }
        }
    }

    private String a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (networkStatus.isWifi()) {
            String md5ToHex = StringUtils.md5ToHex(NetworkStatusHelper.getWifiBSSID());
            return "WIFI$" + (TextUtils.isEmpty(md5ToHex) ? "" : md5ToHex);
        }
        if (!networkStatus.isMobile()) {
            return "";
        }
        return networkStatus.getType() + "$" + NetworkStatusHelper.getApn();
    }

    public void a(l.d dVar) {
        int i10 = dVar.f4242g;
        if (i10 != 0) {
            AmdcRuntimeInfo.updateAmdcLimit(i10, dVar.f4243h);
        }
        d().update(dVar);
        this.f4159b.a(dVar);
    }
}
