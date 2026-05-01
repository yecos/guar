package xa;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class f extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final i f19625a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19626b;

    /* renamed from: c, reason: collision with root package name */
    public final c f19627c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19628d;

    public f(c cVar, Looper looper, int i10) {
        super(looper);
        this.f19627c = cVar;
        this.f19626b = i10;
        this.f19625a = new i();
    }

    public void a(n nVar, Object obj) {
        h a10 = h.a(nVar, obj);
        synchronized (this) {
            this.f19625a.a(a10);
            if (!this.f19628d) {
                this.f19628d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                h b10 = this.f19625a.b();
                if (b10 == null) {
                    synchronized (this) {
                        b10 = this.f19625a.b();
                        if (b10 == null) {
                            return;
                        }
                    }
                }
                this.f19627c.f(b10);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f19626b);
            if (!sendMessage(obtainMessage())) {
                throw new e("Could not send handler message");
            }
            this.f19628d = true;
        } finally {
            this.f19628d = false;
        }
    }
}
