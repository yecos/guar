package com.taobao.accs.net;

import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.p;
import java.util.UUID;

/* loaded from: classes3.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f9207a;

    public l(k kVar) {
        this.f9207a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j10;
        ALog.d(this.f9207a.d(), "sendAccsHeartbeatMessage", new Object[0]);
        try {
            p.a a10 = new p.a().a("dataType", "pingreq");
            j10 = this.f9207a.f9196p;
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, null, a10.a("timeInterval", Long.valueOf(j10)).a().toString().getBytes(XML.CHARSET_UTF8), UUID.randomUUID().toString());
            accsRequest.setTarget("accs-iot");
            accsRequest.setTargetServiceName("sal");
            k kVar = this.f9207a;
            this.f9207a.a(Message.buildRequest(kVar.f9160d, kVar.b((String) null), this.f9207a.d(), this.f9207a.f9165i.getStoreId(), this.f9207a.f9160d.getPackageName(), Constants.TARGET_SERVICE, accsRequest, true), true);
        } catch (Exception e10) {
            ALog.e(this.f9207a.d(), "send accs heartbeat message", e10, new Object[0]);
        }
    }
}
