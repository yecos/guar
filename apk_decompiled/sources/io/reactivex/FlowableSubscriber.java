package io.reactivex;

import fb.c;
import fb.d;
import io.reactivex.annotations.NonNull;

/* loaded from: classes3.dex */
public interface FlowableSubscriber<T> extends c {
    @Override // fb.c
    /* synthetic */ void onComplete();

    @Override // fb.c
    /* synthetic */ void onError(Throwable th);

    @Override // fb.c
    /* synthetic */ void onNext(Object obj);

    @Override // fb.c
    void onSubscribe(@NonNull d dVar);
}
