package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class g implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f4114a;

    public g(f fVar) {
        this.f4114a = fVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z10) {
        this.f4114a.f4111b.onDataReceive(byteArray, z10);
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i10, String str, RequestStatistic requestStatistic) {
        if (i10 <= 0 && i10 != -204) {
            this.f4114a.f4113d.handleCallbacks(2, new anet.channel.entity.b(2, 0, "Http connect fail"));
        }
        this.f4114a.f4111b.onFinish(i10, str, requestStatistic);
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i10, Map<String, List<String>> map) {
        ALog.i("awcn.HttpSession", "", this.f4114a.f4110a.getSeq(), "httpStatusCode", Integer.valueOf(i10));
        ALog.i("awcn.HttpSession", "", this.f4114a.f4110a.getSeq(), "response headers", map);
        this.f4114a.f4111b.onResponseCode(i10, map);
        this.f4114a.f4112c.serverRT = HttpHelper.parseServerRT(map);
        f fVar = this.f4114a;
        fVar.f4113d.handleResponseCode(fVar.f4110a, i10);
        f fVar2 = this.f4114a;
        fVar2.f4113d.handleResponseHeaders(fVar2.f4110a, map);
    }
}
