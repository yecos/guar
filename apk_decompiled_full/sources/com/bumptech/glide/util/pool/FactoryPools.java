package com.bumptech.glide.util.pool;

import a0.e;
import a0.f;
import a0.g;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(Object obj) {
        }
    };
    private static final String TAG = "FactoryPools";

    public interface Factory<T> {
        T create();
    }

    public static final class FactoryPool<T> implements e {
        private final Factory<T> factory;
        private final e pool;
        private final Resetter<T> resetter;

        public FactoryPool(e eVar, Factory<T> factory, Resetter<T> resetter) {
            this.pool = eVar;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // a0.e
        public T acquire() {
            T t10 = (T) this.pool.acquire();
            if (t10 == null) {
                t10 = this.factory.create();
                if (Log.isLoggable(FactoryPools.TAG, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Created new ");
                    sb.append(t10.getClass());
                }
            }
            if (t10 instanceof Poolable) {
                t10.getVerifier().setRecycled(false);
            }
            return (T) t10;
        }

        @Override // a0.e
        public boolean release(T t10) {
            if (t10 instanceof Poolable) {
                ((Poolable) t10).getVerifier().setRecycled(true);
            }
            this.resetter.reset(t10);
            return this.pool.release(t10);
        }
    }

    public interface Poolable {
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(T t10);
    }

    private FactoryPools() {
    }

    private static <T extends Poolable> e build(e eVar, Factory<T> factory) {
        return build(eVar, factory, emptyResetter());
    }

    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }

    public static <T extends Poolable> e simple(int i10, Factory<T> factory) {
        return build(new f(i10), factory);
    }

    public static <T extends Poolable> e threadSafe(int i10, Factory<T> factory) {
        return build(new g(i10), factory);
    }

    public static <T> e threadSafeList() {
        return threadSafeList(20);
    }

    private static <T> e build(e eVar, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(eVar, factory, resetter);
    }

    public static <T extends Poolable> e threadSafe(int i10, Factory<T> factory, Resetter<T> resetter) {
        return build(new g(i10), factory, resetter);
    }

    public static <T> e threadSafeList(int i10) {
        return build(new g(i10), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public List<T> create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public void reset(List<T> list) {
                list.clear();
            }
        });
    }
}
