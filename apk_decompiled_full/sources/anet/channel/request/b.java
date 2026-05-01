package anet.channel.request;

import anet.channel.util.ALog;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class b implements Cancelable {
    public static final b NULL = new b(null, null);

    /* renamed from: a, reason: collision with root package name */
    private final Future<?> f4081a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4082b;

    public b(Future<?> future, String str) {
        this.f4081a = future;
        this.f4082b = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        if (this.f4081a != null) {
            ALog.i("awcn.FutureCancelable", "cancel request", this.f4082b, new Object[0]);
            this.f4081a.cancel(true);
        }
    }
}
