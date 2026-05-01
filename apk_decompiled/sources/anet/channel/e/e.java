package anet.channel.e;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.session.TnetSpdySession;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f3959a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NetworkStatusHelper.NetworkStatus f3960b;

    public e(List list, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f3959a = list;
        this.f3960b = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        AtomicInteger atomicInteger;
        IConnStrategy b10;
        IConnStrategy iConnStrategy = (IConnStrategy) this.f3959a.get(0);
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        str = a.f3947b;
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Http3Detect");
        atomicInteger = a.f3953h;
        sb3.append(atomicInteger.getAndIncrement());
        String sb4 = sb3.toString();
        b10 = a.b(iConnStrategy);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(GlobalAppRuntimeInfo.getContext(), new anet.channel.entity.a(sb2, sb4, b10));
        tnetSpdySession.registerEventcb(257, new f(this, iConnStrategy));
        tnetSpdySession.f3828q.isCommitted = true;
        tnetSpdySession.connect();
    }
}
