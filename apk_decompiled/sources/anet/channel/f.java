package anet.channel;

import anet.channel.SessionRequest;
import anet.channel.entity.EventCb;
import anet.channel.util.ALog;

/* loaded from: classes.dex */
class f implements EventCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SessionRequest.IConnCb f3975a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f3976b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionRequest f3977c;

    public f(SessionRequest sessionRequest, SessionRequest.IConnCb iConnCb, long j10) {
        this.f3977c = sessionRequest;
        this.f3975a = iConnCb;
        this.f3976b = j10;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i10, anet.channel.entity.b bVar) {
        if (session == null) {
            return;
        }
        int i11 = bVar == null ? 0 : bVar.f3970b;
        String str = bVar == null ? "" : bVar.f3971c;
        if (i10 == 2) {
            ALog.d("awcn.SessionRequest", null, session.f3827p, "Session", session, "EventType", Integer.valueOf(i10), "Event", bVar);
            this.f3977c.a(session, i11, str);
            SessionRequest sessionRequest = this.f3977c;
            if (sessionRequest.f3851b.c(sessionRequest, session)) {
                this.f3975a.onDisConnect(session, this.f3976b, i10);
                return;
            } else {
                this.f3975a.onFailed(session, this.f3976b, i10, i11);
                return;
            }
        }
        if (i10 == 256) {
            ALog.d("awcn.SessionRequest", null, session.f3827p, "Session", session, "EventType", Integer.valueOf(i10), "Event", bVar);
            this.f3975a.onFailed(session, this.f3976b, i10, i11);
        } else {
            if (i10 != 512) {
                return;
            }
            ALog.d("awcn.SessionRequest", null, session.f3827p, "Session", session, "EventType", Integer.valueOf(i10), "Event", bVar);
            this.f3977c.a(session, 0, (String) null);
            this.f3975a.onSuccess(session, this.f3976b);
        }
    }
}
