package io.reactivex.internal.operators.flowable;

import fb.b;
import fb.c;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/* loaded from: classes3.dex */
public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends b> mapper;
    final int maxConcurrency;
    final b source;

    public FlowableFlatMapPublisher(b bVar, Function<? super T, ? extends b> function, boolean z10, int i10, int i11) {
        this.source = bVar;
        this.mapper = function;
        this.delayErrors = z10;
        this.maxConcurrency = i10;
        this.bufferSize = i11;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(c cVar) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, cVar, this.mapper)) {
            return;
        }
        this.source.subscribe(FlowableFlatMap.subscribe(cVar, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }
}
