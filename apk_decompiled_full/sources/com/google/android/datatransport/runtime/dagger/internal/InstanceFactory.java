package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;

/* loaded from: classes.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory<>(null);
    private final T instance;

    private InstanceFactory(T t10) {
        this.instance = t10;
    }

    public static <T> Factory<T> create(T t10) {
        return new InstanceFactory(Preconditions.checkNotNull(t10, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t10) {
        return t10 == null ? nullInstanceFactory() : new InstanceFactory(t10);
    }

    private static <T> InstanceFactory<T> nullInstanceFactory() {
        return (InstanceFactory<T>) NULL_INSTANCE_FACTORY;
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.instance;
    }
}
