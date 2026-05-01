package anet.channel.request;

import anet.channel.util.ALog;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;

/* loaded from: classes.dex */
public class c implements Cancelable {
    public static final c NULL = new c(null, 0, null);

    /* renamed from: a, reason: collision with root package name */
    private final int f4083a;

    /* renamed from: b, reason: collision with root package name */
    private final SpdySession f4084b;

    /* renamed from: c, reason: collision with root package name */
    private final String f4085c;

    public c(SpdySession spdySession, int i10, String str) {
        this.f4084b = spdySession;
        this.f4083a = i10;
        this.f4085c = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        int i10;
        try {
            if (this.f4084b == null || (i10 = this.f4083a) == 0) {
                return;
            }
            ALog.i("awcn.TnetCancelable", "cancel tnet request", this.f4085c, "streamId", Integer.valueOf(i10));
            this.f4084b.streamReset(this.f4083a, 5);
        } catch (SpdyErrorException e10) {
            ALog.e("awcn.TnetCancelable", "request cancel failed.", this.f4085c, e10, "errorCode", Integer.valueOf(e10.SpdyErrorGetCode()));
        }
    }
}
