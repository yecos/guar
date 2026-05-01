package io.reactivex.internal.fuseable;

import io.reactivex.FlowableSubscriber;

/* loaded from: classes3.dex */
public interface ConditionalSubscriber<T> extends FlowableSubscriber<T> {
    @Override // io.reactivex.FlowableSubscriber, fb.c
    /* synthetic */ void onComplete();

    @Override // io.reactivex.FlowableSubscriber, fb.c
    /* synthetic */ void onError(Throwable th);

    @Override // io.reactivex.FlowableSubscriber, fb.c
    /* synthetic */ void onNext(Object obj);

    boolean tryOnNext(T t10);
}
