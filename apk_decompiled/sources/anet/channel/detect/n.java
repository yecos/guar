package anet.channel.detect;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static d f3938a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static ExceptionDetector f3939b = new ExceptionDetector();

    /* renamed from: c, reason: collision with root package name */
    private static k f3940c = new k();

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f3941d = new AtomicBoolean(false);

    public static void a() {
        try {
            if (f3941d.compareAndSet(false, true)) {
                ALog.i("awcn.NetworkDetector", "registerListener", null, new Object[0]);
                f3938a.b();
                f3939b.a();
                f3940c.a();
            }
        } catch (Exception e10) {
            ALog.e("awcn.NetworkDetector", "[registerListener]error", null, e10, new Object[0]);
        }
    }

    public static void a(RequestStatistic requestStatistic) {
        if (f3941d.get()) {
            f3939b.a(requestStatistic);
        }
    }
}
