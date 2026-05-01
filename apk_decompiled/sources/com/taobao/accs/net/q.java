package com.taobao.accs.net;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import com.taobao.accs.utl.ALog;

/* loaded from: classes3.dex */
class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f9217a;

    public q(k kVar) {
        this.f9217a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9217a.f9163g) {
            try {
                Session session = SessionCenter.getInstance(this.f9217a.f9165i.getAppKey()).get(this.f9217a.b((String) null), ConnType.TypeLevel.SPDY, 0L);
                if (session != null) {
                    ALog.e(this.f9217a.d(), "try session ping", new Object[0]);
                    int pingTimeout = this.f9217a.f9165i.getPingTimeout();
                    if (pingTimeout > 0) {
                        session.ping(true, pingTimeout);
                    } else {
                        session.ping(true);
                    }
                }
            } catch (Exception e10) {
                ALog.e(this.f9217a.d(), "ping error", e10, new Object[0]);
            }
        }
    }
}
