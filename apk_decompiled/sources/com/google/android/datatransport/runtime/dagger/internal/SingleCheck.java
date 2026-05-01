package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SingleCheck<T> implements Provider<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private SingleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p10) {
        return ((p10 instanceof SingleCheck) || (p10 instanceof DoubleCheck)) ? p10 : new SingleCheck((Provider) Preconditions.checkNotNull(p10));
    }

    @Override // javax.inject.Provider
    public T get() {
        T t10 = (T) this.instance;
        if (t10 != UNINITIALIZED) {
            return t10;
        }
        Provider<T> provider = this.provider;
        if (provider == null) {
            return (T) this.instance;
        }
        T t11 = provider.get();
        this.instance = t11;
        this.provider = null;
        return t11;
    }
}
