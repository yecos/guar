package m9;

import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public final class b implements Continuation {

    /* renamed from: a, reason: collision with root package name */
    public static final b f16840a = new b();

    @Override // kotlin.coroutines.Continuation
    public k9.f getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
