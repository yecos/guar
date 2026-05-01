package kotlin.coroutines;

import k9.f;

/* loaded from: classes3.dex */
public interface Continuation<T> {
    f getContext();

    void resumeWith(Object obj);
}
