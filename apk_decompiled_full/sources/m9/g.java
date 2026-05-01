package m9;

import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public abstract class g {
    public static final Continuation a(Continuation continuation) {
        t9.i.g(continuation, "completion");
        return continuation;
    }

    public static final void b(Continuation continuation) {
        t9.i.g(continuation, "frame");
    }

    public static final void c(Continuation continuation) {
        t9.i.g(continuation, "frame");
    }
}
