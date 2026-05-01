package anet.channel.detect;

import anet.channel.AwcnConfig;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.l;
import anet.channel.util.ALog;

/* loaded from: classes.dex */
class e implements IStrategyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f3922a;

    public e(d dVar) {
        this.f3922a = dVar;
    }

    @Override // anet.channel.strategy.IStrategyListener
    public void onStrategyUpdated(l.d dVar) {
        l.c[] cVarArr;
        int i10 = 0;
        ALog.i("anet.HorseRaceDetector", "onStrategyUpdated", null, new Object[0]);
        if (!AwcnConfig.isHorseRaceEnable() || (cVarArr = dVar.f4238c) == null || cVarArr.length == 0) {
            return;
        }
        synchronized (this.f3922a.f3920a) {
            while (true) {
                l.c[] cVarArr2 = dVar.f4238c;
                if (i10 < cVarArr2.length) {
                    l.c cVar = cVarArr2[i10];
                    this.f3922a.f3920a.put(cVar.f4234a, cVar);
                    i10++;
                }
            }
        }
    }
}
