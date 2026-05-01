package io.reactivex.internal.operators.parallel;

import fb.b;
import fb.c;
import io.reactivex.parallel.ParallelFlowable;

/* loaded from: classes3.dex */
public final class ParallelFromArray<T> extends ParallelFlowable<T> {
    final b[] sources;

    public ParallelFromArray(b[] bVarArr) {
        this.sources = bVarArr;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.sources.length;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(c[] cVarArr) {
        if (validate(cVarArr)) {
            int length = cVarArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                this.sources[i10].subscribe(cVarArr[i10]);
            }
        }
    }
}
