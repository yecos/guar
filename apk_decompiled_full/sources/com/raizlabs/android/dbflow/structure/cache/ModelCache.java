package com.raizlabs.android.dbflow.structure.cache;

/* loaded from: classes3.dex */
public abstract class ModelCache<TModel, CacheClass> {
    private CacheClass cache;

    public ModelCache(CacheClass cacheclass) {
        this.cache = cacheclass;
    }

    public abstract void addModel(Object obj, TModel tmodel);

    public abstract void clear();

    public abstract TModel get(Object obj);

    public CacheClass getCache() {
        return this.cache;
    }

    public abstract TModel removeModel(Object obj);

    public abstract void setCacheSize(int i10);
}
