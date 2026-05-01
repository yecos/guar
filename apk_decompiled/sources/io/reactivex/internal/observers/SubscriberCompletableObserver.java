package io.reactivex.internal.observers;

import fb.c;
import fb.d;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes3.dex */
public final class SubscriberCompletableObserver<T> implements CompletableObserver, d {
    final c subscriber;
    Disposable upstream;

    public SubscriberCompletableObserver(c cVar) {
        this.subscriber = cVar;
    }

    @Override // fb.d
    public void cancel() {
        this.upstream.dispose();
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        this.subscriber.onComplete();
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        this.subscriber.onError(th);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.subscriber.onSubscribe(this);
        }
    }

    @Override // fb.d
    public void request(long j10) {
    }
}
