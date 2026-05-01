package io.reactivex.internal.operators.flowable;

import fb.b;
import fb.c;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;

/* loaded from: classes3.dex */
public final class FlowableConcatMapPublisher<T, R> extends Flowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends b> mapper;
    final int prefetch;
    final b source;

    public FlowableConcatMapPublisher(b bVar, Function<? super T, ? extends b> function, int i10, ErrorMode errorMode) {
        this.source = bVar;
        this.mapper = function;
        this.prefetch = i10;
        this.errorMode = errorMode;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(c cVar) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, cVar, this.mapper)) {
            return;
        }
        this.source.subscribe(FlowableConcatMap.subscribe(cVar, this.mapper, this.prefetch, this.errorMode));
    }
}
