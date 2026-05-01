package anet.channel.detect;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.HorseRaceStat;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import com.hpplay.sdk.source.common.global.Constant;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class i implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f3931a;

    public i(h hVar) {
        this.f3931a = hVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z10) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i10, String str, RequestStatistic requestStatistic) {
        ALog.i("anet.HorseRaceDetector", "LongLinkTask request finish", this.f3931a.f3927c, "statusCode", Integer.valueOf(i10), Constant.KEY_MSG, str);
        if (this.f3931a.f3925a.reqErrorCode == 0) {
            this.f3931a.f3925a.reqErrorCode = i10;
        } else {
            HorseRaceStat horseRaceStat = this.f3931a.f3925a;
            horseRaceStat.reqRet = horseRaceStat.reqErrorCode == 200 ? 1 : 0;
        }
        HorseRaceStat horseRaceStat2 = this.f3931a.f3925a;
        long currentTimeMillis = System.currentTimeMillis();
        h hVar = this.f3931a;
        horseRaceStat2.reqTime = (currentTimeMillis - hVar.f3926b) + hVar.f3925a.connTime;
        synchronized (this.f3931a.f3925a) {
            this.f3931a.f3925a.notify();
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i10, Map<String, List<String>> map) {
        this.f3931a.f3925a.reqErrorCode = i10;
    }
}
