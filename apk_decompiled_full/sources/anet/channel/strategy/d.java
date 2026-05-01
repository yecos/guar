package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.util.ALog;
import java.io.File;

/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4182a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrategyInfoHolder f4183b;

    public d(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f4183b = strategyInfoHolder;
        this.f4182a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ALog.i("awcn.StrategyInfoHolder", "start loading strategy files", null, new Object[0]);
            long currentTimeMillis = System.currentTimeMillis();
            if (AwcnConfig.isAsyncLoadStrategyEnable()) {
                ALog.i("awcn.StrategyInfoHolder", "load strategy async", null, new Object[0]);
                if (!TextUtils.isEmpty(this.f4182a)) {
                    this.f4183b.a(this.f4182a, true);
                }
                StrategyConfig strategyConfig = (StrategyConfig) m.a("StrategyConfig", null);
                if (strategyConfig != null) {
                    strategyConfig.b();
                    strategyConfig.a(this.f4183b);
                    synchronized (this.f4183b) {
                        this.f4183b.f4159b = strategyConfig;
                    }
                }
            }
            File[] b10 = m.b();
            if (b10 == null) {
                return;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < b10.length && i10 < 2; i11++) {
                File file = b10[i11];
                if (!file.isDirectory()) {
                    String name = file.getName();
                    if (!name.equals(this.f4182a) && !name.startsWith("StrategyConfig")) {
                        this.f4183b.a(name, false);
                        i10++;
                    }
                }
            }
            ALog.i("awcn.StrategyInfoHolder", "end loading strategy files", null, "total cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception unused) {
        }
    }
}
