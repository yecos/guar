package io.reactivex.internal.operators.flowable;

import fb.b;
import fb.c;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class FlowableDefer<T> extends Flowable<T> {
    final Callable<? extends b> supplier;

    public FlowableDefer(Callable<? extends b> callable) {
        this.supplier = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(c cVar) {
        try {
            ((b) ObjectHelper.requireNonNull(this.supplier.call(), "The publisher supplied is null")).subscribe(cVar);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, cVar);
        }
    }
}
