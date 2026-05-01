package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;

/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Request f4108a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f4109b;

    public e(d dVar, Request request) {
        this.f4109b = dVar;
        this.f4108a = request;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10 = b.a(this.f4108a, (RequestCb) null).f4101a;
        if (i10 > 0) {
            this.f4109b.notifyStatus(4, new anet.channel.entity.b(1));
        } else {
            this.f4109b.handleCallbacks(256, new anet.channel.entity.b(256, i10, "Http connect fail"));
        }
    }
}
