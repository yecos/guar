package m9;

import h9.l;
import h9.m;
import h9.t;
import java.io.Serializable;
import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public abstract class a implements Continuation, d, Serializable {
    private final Continuation<Object> completion;

    public a(Continuation continuation) {
        this.completion = continuation;
    }

    public Continuation<t> create(Continuation<?> continuation) {
        t9.i.g(continuation, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // m9.d
    public d getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (continuation instanceof d) {
            return (d) continuation;
        }
        return null;
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return f.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        Continuation continuation = this;
        while (true) {
            g.b(continuation);
            a aVar = (a) continuation;
            Continuation continuation2 = aVar.completion;
            t9.i.d(continuation2);
            try {
                invokeSuspend = aVar.invokeSuspend(obj);
            } catch (Throwable th) {
                l.a aVar2 = l.f14231a;
                obj = l.a(m.a(th));
            }
            if (invokeSuspend == l9.c.c()) {
                return;
            }
            obj = l.a(invokeSuspend);
            aVar.releaseIntercepted();
            if (!(continuation2 instanceof a)) {
                continuation2.resumeWith(obj);
                return;
            }
            continuation = continuation2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public Continuation<t> create(Object obj, Continuation<?> continuation) {
        t9.i.g(continuation, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
