package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.WeakReference;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class FinalizableWeakReference<T> extends WeakReference<T> implements FinalizableReference {
    public FinalizableWeakReference(@CheckForNull T t10, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t10, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
