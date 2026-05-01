package q0;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f18179a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final e f18180b;

    /* renamed from: c, reason: collision with root package name */
    public volatile t0.f f18181c;

    public k(e eVar) {
        this.f18180b = eVar;
    }

    public t0.f a() {
        b();
        return e(this.f18179a.compareAndSet(false, true));
    }

    public void b() {
        this.f18180b.a();
    }

    public final t0.f c() {
        return this.f18180b.d(d());
    }

    public abstract String d();

    public final t0.f e(boolean z10) {
        if (!z10) {
            return c();
        }
        if (this.f18181c == null) {
            this.f18181c = c();
        }
        return this.f18181c;
    }

    public void f(t0.f fVar) {
        if (fVar == this.f18181c) {
            this.f18179a.set(false);
        }
    }
}
