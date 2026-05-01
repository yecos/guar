package m9;

import k9.f;
import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public abstract class c extends a {
    private final k9.f _context;
    private transient Continuation<Object> intercepted;

    public c(Continuation continuation, k9.f fVar) {
        super(continuation);
        this._context = fVar;
    }

    @Override // kotlin.coroutines.Continuation
    public k9.f getContext() {
        k9.f fVar = this._context;
        t9.i.d(fVar);
        return fVar;
    }

    public final Continuation<Object> intercepted() {
        Continuation continuation = this.intercepted;
        if (continuation == null) {
            k9.d dVar = (k9.d) getContext().a(k9.d.f15705e0);
            if (dVar == null || (continuation = dVar.c(this)) == null) {
                continuation = this;
            }
            this.intercepted = continuation;
        }
        return continuation;
    }

    @Override // m9.a
    public void releaseIntercepted() {
        Continuation<Object> continuation = this.intercepted;
        if (continuation != null && continuation != this) {
            f.b a10 = getContext().a(k9.d.f15705e0);
            t9.i.d(a10);
            ((k9.d) a10).b(continuation);
        }
        this.intercepted = b.f16840a;
    }

    public c(Continuation continuation) {
        this(continuation, continuation != null ? continuation.getContext() : null);
    }
}
