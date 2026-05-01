package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class StrategyConfig implements Serializable {
    public static final String NO_RESULT = "No_Result";

    /* renamed from: a, reason: collision with root package name */
    private SerialLruCache<String, String> f4155a = null;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f4156b = null;

    /* renamed from: c, reason: collision with root package name */
    private transient StrategyInfoHolder f4157c = null;

    public StrategyConfig a() {
        StrategyConfig strategyConfig = new StrategyConfig();
        synchronized (this) {
            strategyConfig.f4155a = new SerialLruCache<>(this.f4155a, 256);
            strategyConfig.f4156b = new ConcurrentHashMap(this.f4156b);
            strategyConfig.f4157c = this.f4157c;
        }
        return strategyConfig;
    }

    public void b() {
        if (this.f4155a == null) {
            this.f4155a = new SerialLruCache<>(256);
        }
        if (this.f4156b == null) {
            this.f4156b = new ConcurrentHashMap();
        }
    }

    public String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.f4156b.get(str);
        }
        return str2;
    }

    public void a(StrategyInfoHolder strategyInfoHolder) {
        this.f4157c = strategyInfoHolder;
    }

    public void a(l.d dVar) {
        if (dVar.f4237b == null) {
            return;
        }
        synchronized (this) {
            TreeMap treeMap = null;
            int i10 = 0;
            while (true) {
                l.b[] bVarArr = dVar.f4237b;
                if (i10 >= bVarArr.length) {
                    break;
                }
                l.b bVar = bVarArr[i10];
                if (bVar.f4231j) {
                    this.f4155a.remove(bVar.f4222a);
                } else if (bVar.f4225d != null) {
                    if (treeMap == null) {
                        treeMap = new TreeMap();
                    }
                    treeMap.put(bVar.f4222a, bVar.f4225d);
                } else {
                    if (!HttpConstant.HTTP.equalsIgnoreCase(bVar.f4224c) && !"https".equalsIgnoreCase(bVar.f4224c)) {
                        this.f4155a.put(bVar.f4222a, NO_RESULT);
                    } else {
                        this.f4155a.put(bVar.f4222a, bVar.f4224c);
                    }
                    if (!TextUtils.isEmpty(bVar.f4226e)) {
                        this.f4156b.put(bVar.f4222a, bVar.f4226e);
                    } else {
                        this.f4156b.remove(bVar.f4222a);
                    }
                }
                i10++;
            }
            if (treeMap != null) {
                for (Map.Entry entry : treeMap.entrySet()) {
                    String str = (String) entry.getValue();
                    if (this.f4155a.containsKey(str)) {
                        this.f4155a.put(entry.getKey(), this.f4155a.get(str));
                    } else {
                        this.f4155a.put(entry.getKey(), NO_RESULT);
                    }
                }
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.StrategyConfig", "", null, "SchemeMap", this.f4155a.toString());
            ALog.d("awcn.StrategyConfig", "", null, "UnitMap", this.f4156b.toString());
        }
    }

    public String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !anet.channel.strategy.utils.d.c(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.f4155a.get(str);
            if (str2 == null) {
                this.f4155a.put(str, NO_RESULT);
            }
        }
        if (str2 == null) {
            this.f4157c.d().a(str, false);
        } else if (NO_RESULT.equals(str2)) {
            return null;
        }
        return str2;
    }
}
