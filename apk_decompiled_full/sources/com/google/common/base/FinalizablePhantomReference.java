package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.PhantomReference;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class FinalizablePhantomReference<T> extends PhantomReference<T> implements FinalizableReference {
    public FinalizablePhantomReference(@CheckForNull T t10, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t10, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
