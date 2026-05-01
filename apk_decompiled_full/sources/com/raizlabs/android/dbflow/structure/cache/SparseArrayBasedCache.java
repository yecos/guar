package com.raizlabs.android.dbflow.structure.cache;

import android.util.SparseArray;
import com.raizlabs.android.dbflow.config.FlowLog;

/* loaded from: classes3.dex */
public class SparseArrayBasedCache<TModel> extends ModelCache<TModel, SparseArray<TModel>> {
    public SparseArrayBasedCache() {
        super(new SparseArray());
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public void addModel(Object obj, TModel tmodel) {
        if (!(obj instanceof Number)) {
            throw new IllegalArgumentException("A SparseArrayBasedCache must use an id that can cast to a Number to convert it into a int");
        }
        synchronized (getCache()) {
            getCache().put(((Number) obj).intValue(), tmodel);
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public void clear() {
        synchronized (getCache()) {
            getCache().clear();
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public TModel get(Object obj) {
        if (obj instanceof Number) {
            return getCache().get(((Number) obj).intValue());
        }
        throw new IllegalArgumentException("A SparseArrayBasedCache uses an id that can cast to a Number to convert it into a int");
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public TModel removeModel(Object obj) {
        TModel tmodel = get(obj);
        synchronized (getCache()) {
            getCache().remove(((Number) obj).intValue());
        }
        return tmodel;
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public void setCacheSize(int i10) {
        FlowLog.log(FlowLog.Level.I, "The cache size for " + SparseArrayBasedCache.class.getSimpleName() + " is not re-configurable.");
    }

    public SparseArrayBasedCache(int i10) {
        super(new SparseArray(i10));
    }

    public SparseArrayBasedCache(SparseArray<TModel> sparseArray) {
        super(sparseArray);
    }
}
