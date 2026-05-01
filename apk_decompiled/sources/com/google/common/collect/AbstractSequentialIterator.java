package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    @CheckForNull
    private T nextOrNull;

    public AbstractSequentialIterator(@CheckForNull T t10) {
        this.nextOrNull = t10;
    }

    @CheckForNull
    public abstract T computeNext(T t10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.nextOrNull != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        T t10 = this.nextOrNull;
        if (t10 == null) {
            throw new NoSuchElementException();
        }
        this.nextOrNull = computeNext(t10);
        return t10;
    }
}
