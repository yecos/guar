package x;

import android.os.CancellationSignal;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f19270a;

    /* renamed from: b, reason: collision with root package name */
    public a f19271b;

    /* renamed from: c, reason: collision with root package name */
    public Object f19272c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19273d;

    public interface a {
        void a();
    }

    public void a() {
        synchronized (this) {
            if (this.f19270a) {
                return;
            }
            this.f19270a = true;
            this.f19273d = true;
            a aVar = this.f19271b;
            Object obj = this.f19272c;
            if (aVar != null) {
                try {
                    aVar.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f19273d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.f19273d = false;
                notifyAll();
            }
        }
    }

    public boolean b() {
        boolean z10;
        synchronized (this) {
            z10 = this.f19270a;
        }
        return z10;
    }

    public void c(a aVar) {
        synchronized (this) {
            d();
            if (this.f19271b == aVar) {
                return;
            }
            this.f19271b = aVar;
            if (this.f19270a && aVar != null) {
                aVar.a();
            }
        }
    }

    public final void d() {
        while (this.f19273d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
