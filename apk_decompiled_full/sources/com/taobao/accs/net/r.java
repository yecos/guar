package com.taobao.accs.net;

import anet.channel.session.TnetSpdySession;
import com.hpplay.cybergarage.upnp.Service;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;

/* loaded from: classes3.dex */
class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9218a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte[] f9219b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f9220c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ k f9221d;

    public r(k kVar, int i10, byte[] bArr, TnetSpdySession tnetSpdySession) {
        this.f9221d = kVar;
        this.f9218a = i10;
        this.f9219b = bArr;
        this.f9220c = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9218a != 200) {
            ALog.e(this.f9221d.d(), "drop frame len:" + this.f9219b.length + " frameType" + this.f9218a, new Object[0]);
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9221d.f9161e.a(this.f9219b, this.f9220c.getHost());
            com.taobao.accs.ut.a.d g10 = this.f9221d.f9161e.g();
            if (g10 != null) {
                g10.f9277c = String.valueOf(currentTimeMillis);
                g10.f9281g = this.f9221d.f9159c == 0 ? Service.ELEM_NAME : "inapp";
                g10.a();
            }
        } catch (Throwable th) {
            ALog.e(this.f9221d.d(), "onDataReceive ", th, new Object[0]);
            UTMini.getInstance().commitEvent(66001, "DATA_RECEIVE", UtilityImpl.a(th));
        }
    }
}
