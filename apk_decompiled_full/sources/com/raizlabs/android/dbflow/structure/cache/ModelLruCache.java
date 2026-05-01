package com.raizlabs.android.dbflow.structure.cache;

/* loaded from: classes3.dex */
public class ModelLruCache<TModel> extends ModelCache<TModel, LruCache<Long, TModel>> {
    public ModelLruCache(int i10) {
        super(new LruCache(i10));
    }

    public static <TModel> ModelLruCache<TModel> newInstance(int i10) {
        if (i10 <= 0) {
            i10 = 25;
        }
        return new ModelLruCache<>(i10);
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public void addModel(Object obj, TModel tmodel) {
        if (!(obj instanceof Number)) {
            throw new IllegalArgumentException("A ModelLruCache must use an id that can cast toa Number to convert it into a long");
        }
        synchronized (getCache()) {
            getCache().put(Long.valueOf(((Number) obj).longValue()), tmodel);
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public void clear() {
        synchronized (getCache()) {
            getCache().evictAll();
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public TModel get(Object obj) {
        if (obj instanceof Number) {
            return getCache().get(Long.valueOf(((Number) obj).longValue()));
        }
        throw new IllegalArgumentException("A ModelLruCache must use an id that can cast toa Number to convert it into a long");
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public TModel removeModel(Object obj) {
        TModel remove;
        if (!(obj instanceof Number)) {
            throw new IllegalArgumentException("A ModelLruCache uses an id that can cast toa Number to convert it into a long");
        }
        synchronized (getCache()) {
            remove = getCache().remove(Long.valueOf(((Number) obj).longValue()));
        }
        return remove;
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public void setCacheSize(int i10) {
        getCache().resize(i10);
    }
}
