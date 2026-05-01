package kotlinx.coroutines.internal;

import ca.g0;
import ca.l0;
import ca.q0;
import ca.w1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public final class f extends l0 implements m9.d, Continuation {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f15737h = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* renamed from: d, reason: collision with root package name */
    public final ca.y f15738d;

    /* renamed from: e, reason: collision with root package name */
    public final Continuation f15739e;

    /* renamed from: f, reason: collision with root package name */
    public Object f15740f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f15741g;

    public f(ca.y yVar, Continuation continuation) {
        super(-1);
        y yVar2;
        this.f15738d = yVar;
        this.f15739e = continuation;
        yVar2 = g.f15746a;
        this.f15740f = yVar2;
        this.f15741g = c0.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    @Override // ca.l0
    public void a(Object obj, Throwable th) {
        if (obj instanceof ca.t) {
            ((ca.t) obj).f5804b.invoke(th);
        }
    }

    @Override // ca.l0
    public Continuation b() {
        return this;
    }

    @Override // ca.l0
    public Object f() {
        y yVar;
        Object obj = this.f15740f;
        yVar = g.f15746a;
        this.f15740f = yVar;
        return obj;
    }

    @Override // m9.d
    public m9.d getCallerFrame() {
        Continuation continuation = this.f15739e;
        if (continuation instanceof m9.d) {
            return (m9.d) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public k9.f getContext() {
        return this.f15739e.getContext();
    }

    public final void h() {
        while (this._reusableCancellableContinuation == g.f15747b) {
        }
    }

    public final ca.k i() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof ca.k) {
            return (ca.k) obj;
        }
        return null;
    }

    public final boolean j() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean k(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            y yVar = g.f15747b;
            if (t9.i.b(obj, yVar)) {
                if (androidx.concurrent.futures.b.a(f15737h, this, yVar, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (androidx.concurrent.futures.b.a(f15737h, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void l() {
        h();
        ca.k i10 = i();
        if (i10 != null) {
            i10.n();
        }
    }

    public final Throwable m(ca.j jVar) {
        y yVar;
        do {
            Object obj = this._reusableCancellableContinuation;
            yVar = g.f15747b;
            if (obj != yVar) {
                if (obj instanceof Throwable) {
                    if (androidx.concurrent.futures.b.a(f15737h, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!androidx.concurrent.futures.b.a(f15737h, this, yVar, jVar));
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        k9.f context = this.f15739e.getContext();
        Object c10 = ca.w.c(obj, null, 1, null);
        if (this.f15738d.M(context)) {
            this.f15740f = c10;
            this.f5765c = 0;
            this.f15738d.L(context, this);
            return;
        }
        q0 a10 = w1.f5809a.a();
        if (a10.U()) {
            this.f15740f = c10;
            this.f5765c = 0;
            a10.Q(this);
            return;
        }
        a10.S(true);
        try {
            k9.f context2 = getContext();
            Object c11 = c0.c(context2, this.f15741g);
            try {
                this.f15739e.resumeWith(obj);
                h9.t tVar = h9.t.f14242a;
                while (a10.W()) {
                }
            } finally {
                c0.a(context2, c11);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f15738d + ", " + g0.c(this.f15739e) + ']';
    }
}
