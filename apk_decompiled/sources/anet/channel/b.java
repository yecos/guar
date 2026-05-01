package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.util.ALog;
import java.util.Map;

/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3883a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ anet.channel.entity.b f3884b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Session f3885c;

    public b(Session session, int i10, anet.channel.entity.b bVar) {
        this.f3885c = session;
        this.f3883a = i10;
        this.f3884b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Map<EventCb, Integer> map = this.f3885c.f3813b;
            if (map != null) {
                for (EventCb eventCb : map.keySet()) {
                    if (eventCb != null) {
                        int intValue = this.f3885c.f3813b.get(eventCb).intValue();
                        int i10 = this.f3883a;
                        if ((intValue & i10) != 0) {
                            try {
                                eventCb.onEvent(this.f3885c, i10, this.f3884b);
                            } catch (Exception e10) {
                                ALog.e("awcn.Session", e10.toString(), this.f3885c.f3827p, new Object[0]);
                            }
                        }
                    }
                }
            }
        } catch (Exception e11) {
            ALog.e("awcn.Session", "handleCallbacks", this.f3885c.f3827p, e11, new Object[0]);
        }
    }
}
