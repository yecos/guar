package ca;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes3.dex */
public abstract class r0 extends s0 implements j0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5798f = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_queue");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5799g = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    public static final class a extends kotlinx.coroutines.internal.d0 {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    private final boolean d0() {
        return this._isCompleted;
    }

    @Override // ca.y
    public final void L(k9.f fVar, Runnable runnable) {
        b0(runnable);
    }

    @Override // ca.q0
    public long R() {
        kotlinx.coroutines.internal.y yVar;
        if (super.R() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.p)) {
                yVar = u0.f5806b;
                return obj == yVar ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.p) obj).g()) {
                return 0L;
            }
        }
        a aVar = (a) this._delayed;
        if (aVar != null) {
            aVar.c();
        }
        return Long.MAX_VALUE;
    }

    public final void Z() {
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVar2;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5798f;
                yVar = u0.f5806b;
                if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, null, yVar)) {
                    return;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.internal.p) {
                    ((kotlinx.coroutines.internal.p) obj).d();
                    return;
                }
                yVar2 = u0.f5806b;
                if (obj == yVar2) {
                    return;
                }
                kotlinx.coroutines.internal.p pVar = new kotlinx.coroutines.internal.p(8, true);
                pVar.a((Runnable) obj);
                if (androidx.concurrent.futures.b.a(f5798f, this, obj, pVar)) {
                    return;
                }
            }
        }
    }

    public final Runnable a0() {
        kotlinx.coroutines.internal.y yVar;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.p) {
                kotlinx.coroutines.internal.p pVar = (kotlinx.coroutines.internal.p) obj;
                Object j10 = pVar.j();
                if (j10 != kotlinx.coroutines.internal.p.f15766h) {
                    return (Runnable) j10;
                }
                androidx.concurrent.futures.b.a(f5798f, this, obj, pVar.i());
            } else {
                yVar = u0.f5806b;
                if (obj == yVar) {
                    return null;
                }
                if (androidx.concurrent.futures.b.a(f5798f, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    public void b0(Runnable runnable) {
        if (c0(runnable)) {
            Y();
        } else {
            h0.f5753h.b0(runnable);
        }
    }

    public final boolean c0(Runnable runnable) {
        kotlinx.coroutines.internal.y yVar;
        while (true) {
            Object obj = this._queue;
            if (d0()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.b.a(f5798f, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.p) {
                kotlinx.coroutines.internal.p pVar = (kotlinx.coroutines.internal.p) obj;
                int a10 = pVar.a(runnable);
                if (a10 == 0) {
                    return true;
                }
                if (a10 == 1) {
                    androidx.concurrent.futures.b.a(f5798f, this, obj, pVar.i());
                } else if (a10 == 2) {
                    return false;
                }
            } else {
                yVar = u0.f5806b;
                if (obj == yVar) {
                    return false;
                }
                kotlinx.coroutines.internal.p pVar2 = new kotlinx.coroutines.internal.p(8, true);
                pVar2.a((Runnable) obj);
                pVar2.a(runnable);
                if (androidx.concurrent.futures.b.a(f5798f, this, obj, pVar2)) {
                    return true;
                }
            }
        }
    }

    public boolean e0() {
        kotlinx.coroutines.internal.y yVar;
        if (!V()) {
            return false;
        }
        a aVar = (a) this._delayed;
        if (aVar != null && !aVar.b()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.p) {
                return ((kotlinx.coroutines.internal.p) obj).g();
            }
            yVar = u0.f5806b;
            if (obj != yVar) {
                return false;
            }
        }
        return true;
    }

    public long f0() {
        if (W()) {
            return 0L;
        }
        a aVar = (a) this._delayed;
        if (aVar != null && !aVar.b()) {
            c.a();
            System.nanoTime();
            synchronized (aVar) {
                aVar.a();
            }
            androidx.appcompat.app.m.a(null);
        }
        Runnable a02 = a0();
        if (a02 == null) {
            return R();
        }
        a02.run();
        return 0L;
    }

    public final void g0() {
        c.a();
        System.nanoTime();
        a aVar = (a) this._delayed;
        if (aVar != null) {
            aVar.d();
        }
    }

    public final void h0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void i0(boolean z10) {
        this._isCompleted = z10 ? 1 : 0;
    }

    @Override // ca.q0
    public void shutdown() {
        w1.f5809a.b();
        i0(true);
        Z();
        while (f0() <= 0) {
        }
        g0();
    }
}
