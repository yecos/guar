package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;

/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Request f4110a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RequestCb f4111b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f4112c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f4113d;

    public f(d dVar, Request request, RequestCb requestCb, RequestStatistic requestStatistic) {
        this.f4113d = dVar;
        this.f4110a = request;
        this.f4111b = requestCb;
        this.f4112c = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4110a.f4045a.sendBeforeTime = System.currentTimeMillis() - this.f4110a.f4045a.reqStart;
        b.a(this.f4110a, new g(this));
    }
}
