package ca;

import ca.f1;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public class k extends l0 implements j, m9.d {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5758g = AtomicIntegerFieldUpdater.newUpdater(k.class, "_decision");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5759h = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* renamed from: d, reason: collision with root package name */
    public final Continuation f5760d;

    /* renamed from: e, reason: collision with root package name */
    public final k9.f f5761e;

    /* renamed from: f, reason: collision with root package name */
    public o0 f5762f;

    public k(Continuation continuation, int i10) {
        super(i10);
        this.f5760d = continuation;
        this.f5761e = continuation.getContext();
        this._decision = 0;
        this._state = d.f5739a;
    }

    public static /* synthetic */ void C(k kVar, Object obj, int i10, s9.l lVar, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        kVar.B(obj, i10, lVar);
    }

    public final void A() {
        Throwable m10;
        Continuation continuation = this.f5760d;
        kotlinx.coroutines.internal.f fVar = continuation instanceof kotlinx.coroutines.internal.f ? (kotlinx.coroutines.internal.f) continuation : null;
        if (fVar == null || (m10 = fVar.m(this)) == null) {
            return;
        }
        n();
        l(m10);
    }

    public final void B(Object obj, int i10, s9.l lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof s1)) {
                if (obj2 instanceof l) {
                    l lVar2 = (l) obj2;
                    if (lVar2.c()) {
                        if (lVar != null) {
                            k(lVar, lVar2.f5802a);
                            return;
                        }
                        return;
                    }
                }
                h(obj);
                throw new h9.c();
            }
        } while (!androidx.concurrent.futures.b.a(f5759h, this, obj2, D((s1) obj2, obj, i10, lVar, null)));
        o();
        p(i10);
    }

    public final Object D(s1 s1Var, Object obj, int i10, s9.l lVar, Object obj2) {
        if (obj instanceof s) {
            return obj;
        }
        if (!m0.b(i10) && obj2 == null) {
            return obj;
        }
        if (lVar == null && !(s1Var instanceof h) && obj2 == null) {
            return obj;
        }
        return new r(obj, s1Var instanceof h ? (h) s1Var : null, lVar, obj2, null, 16, null);
    }

    public final boolean E() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f5758g.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean F() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f5758g.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // ca.l0
    public void a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof s1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof s) {
                return;
            }
            if (obj2 instanceof r) {
                r rVar = (r) obj2;
                if (!(!rVar.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (androidx.concurrent.futures.b.a(f5759h, this, obj2, r.b(rVar, null, null, null, null, th, 15, null))) {
                    rVar.d(this, th);
                    return;
                }
            } else if (androidx.concurrent.futures.b.a(f5759h, this, obj2, new r(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // ca.l0
    public final Continuation b() {
        return this.f5760d;
    }

    @Override // ca.l0
    public Throwable c(Object obj) {
        Throwable c10 = super.c(obj);
        if (c10 != null) {
            return c10;
        }
        return null;
    }

    @Override // ca.l0
    public Object d(Object obj) {
        return obj instanceof r ? ((r) obj).f5793a : obj;
    }

    @Override // ca.l0
    public Object f() {
        return s();
    }

    @Override // ca.j
    public void g(s9.l lVar) {
        h w10 = w(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof d) {
                if (androidx.concurrent.futures.b.a(f5759h, this, obj, w10)) {
                    return;
                }
            } else if (obj instanceof h) {
                x(lVar, obj);
            } else {
                boolean z10 = obj instanceof s;
                if (z10) {
                    s sVar = (s) obj;
                    if (!sVar.b()) {
                        x(lVar, obj);
                    }
                    if (obj instanceof l) {
                        if (!z10) {
                            sVar = null;
                        }
                        j(lVar, sVar != null ? sVar.f5802a : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (rVar.f5794b != null) {
                        x(lVar, obj);
                    }
                    if (rVar.c()) {
                        j(lVar, rVar.f5797e);
                        return;
                    } else {
                        if (androidx.concurrent.futures.b.a(f5759h, this, obj, r.b(rVar, null, w10, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (androidx.concurrent.futures.b.a(f5759h, this, obj, new r(obj, w10, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @Override // m9.d
    public m9.d getCallerFrame() {
        Continuation continuation = this.f5760d;
        if (continuation instanceof m9.d) {
            return (m9.d) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public k9.f getContext() {
        return this.f5761e;
    }

    public final Void h(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public final void i(h hVar, Throwable th) {
        try {
            hVar.b(th);
        } catch (Throwable th2) {
            b0.a(getContext(), new v("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void j(s9.l lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            b0.a(getContext(), new v("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void k(s9.l lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            b0.a(getContext(), new v("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public boolean l(Throwable th) {
        Object obj;
        boolean z10;
        do {
            obj = this._state;
            if (!(obj instanceof s1)) {
                return false;
            }
            z10 = obj instanceof h;
        } while (!androidx.concurrent.futures.b.a(f5759h, this, obj, new l(this, th, z10)));
        h hVar = z10 ? (h) obj : null;
        if (hVar != null) {
            i(hVar, th);
        }
        o();
        p(this.f5765c);
        return true;
    }

    public final boolean m(Throwable th) {
        if (v()) {
            return ((kotlinx.coroutines.internal.f) this.f5760d).k(th);
        }
        return false;
    }

    public final void n() {
        o0 o0Var = this.f5762f;
        if (o0Var == null) {
            return;
        }
        o0Var.dispose();
        this.f5762f = r1.f5800a;
    }

    public final void o() {
        if (v()) {
            return;
        }
        n();
    }

    public final void p(int i10) {
        if (E()) {
            return;
        }
        m0.a(this, i10);
    }

    public Throwable q(f1 f1Var) {
        return f1Var.f();
    }

    public final Object r() {
        f1 f1Var;
        boolean v10 = v();
        if (F()) {
            if (this.f5762f == null) {
                u();
            }
            if (v10) {
                A();
            }
            return l9.c.c();
        }
        if (v10) {
            A();
        }
        Object s10 = s();
        if (s10 instanceof s) {
            throw ((s) s10).f5802a;
        }
        if (!m0.b(this.f5765c) || (f1Var = (f1) getContext().a(f1.f5750a0)) == null || f1Var.isActive()) {
            return d(s10);
        }
        CancellationException f10 = f1Var.f();
        a(s10, f10);
        throw f10;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        C(this, w.a(obj, this), this.f5765c, null, 4, null);
    }

    public final Object s() {
        return this._state;
    }

    public final String t() {
        Object s10 = s();
        return s10 instanceof s1 ? "Active" : s10 instanceof l ? "Cancelled" : "Completed";
    }

    public String toString() {
        return y() + ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + g0.c(this.f5760d) + "){" + t() + "}@" + g0.b(this);
    }

    public final o0 u() {
        f1 f1Var = (f1) getContext().a(f1.f5750a0);
        if (f1Var == null) {
            return null;
        }
        o0 d10 = f1.a.d(f1Var, true, false, new m(this), 2, null);
        this.f5762f = d10;
        return d10;
    }

    public final boolean v() {
        return m0.c(this.f5765c) && ((kotlinx.coroutines.internal.f) this.f5760d).j();
    }

    public final h w(s9.l lVar) {
        return lVar instanceof h ? (h) lVar : new c1(lVar);
    }

    public final void x(s9.l lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    public String y() {
        return "CancellableContinuation";
    }

    public final void z(Throwable th) {
        if (m(th)) {
            return;
        }
        l(th);
        o();
    }
}
