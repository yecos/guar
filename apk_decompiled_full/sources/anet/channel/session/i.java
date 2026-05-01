package anet.channel.session;

import anet.channel.IAuth;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.statist.SessionStatistic;
import anet.channel.util.ALog;

/* loaded from: classes.dex */
class i implements IAuth.AuthCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f4116a;

    public i(TnetSpdySession tnetSpdySession) {
        this.f4116a = tnetSpdySession;
    }

    @Override // anet.channel.IAuth.AuthCallback
    public void onAuthFail(int i10, String str) {
        this.f4116a.notifyStatus(5, null);
        SessionStatistic sessionStatistic = this.f4116a.f3828q;
        if (sessionStatistic != null) {
            sessionStatistic.closeReason = "Accs_Auth_Fail:" + i10;
            this.f4116a.f3828q.errorCode = (long) i10;
        }
        this.f4116a.close();
    }

    @Override // anet.channel.IAuth.AuthCallback
    public void onAuthSuccess() {
        this.f4116a.notifyStatus(4, null);
        this.f4116a.f4095z = System.currentTimeMillis();
        TnetSpdySession tnetSpdySession = this.f4116a;
        IHeartbeat iHeartbeat = tnetSpdySession.D;
        if (iHeartbeat != null) {
            iHeartbeat.start(tnetSpdySession);
        }
        TnetSpdySession tnetSpdySession2 = this.f4116a;
        SessionStatistic sessionStatistic = tnetSpdySession2.f3828q;
        sessionStatistic.ret = 1;
        ALog.d("awcn.TnetSpdySession", "spdyOnStreamResponse", tnetSpdySession2.f3827p, "authTime", Long.valueOf(sessionStatistic.authTime));
        TnetSpdySession tnetSpdySession3 = this.f4116a;
        if (tnetSpdySession3.A > 0) {
            tnetSpdySession3.f3828q.authTime = System.currentTimeMillis() - this.f4116a.A;
        }
    }
}
