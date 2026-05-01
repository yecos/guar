package ca;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes3.dex */
public final class d1 extends h1 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5740f = AtomicIntegerFieldUpdater.newUpdater(d1.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: e, reason: collision with root package name */
    public final s9.l f5741e;

    public d1(s9.l lVar) {
        this.f5741e = lVar;
    }

    @Override // s9.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return h9.t.f14242a;
    }

    @Override // ca.u
    public void q(Throwable th) {
        if (f5740f.compareAndSet(this, 0, 1)) {
            this.f5741e.invoke(th);
        }
    }
}
