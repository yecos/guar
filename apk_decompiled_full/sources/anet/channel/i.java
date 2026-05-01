package anet.channel;

import android.content.Context;
import anet.channel.SessionRequest;

/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Session f4002a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SessionRequest.a f4003b;

    public i(SessionRequest.a aVar, Session session) {
        this.f4003b = aVar;
        this.f4002a = session;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        try {
            SessionRequest.a aVar = this.f4003b;
            SessionRequest sessionRequest = SessionRequest.this;
            context = aVar.f3864c;
            sessionRequest.a(context, this.f4002a.getConnType().getType(), anet.channel.util.i.a(SessionRequest.this.f3850a.f3841c), (SessionGetCallback) null, 0L);
        } catch (Exception unused) {
        }
    }
}
