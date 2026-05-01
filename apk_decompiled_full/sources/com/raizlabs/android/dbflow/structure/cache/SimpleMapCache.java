package com.raizlabs.android.dbflow.structure.cache;

import com.raizlabs.android.dbflow.config.FlowLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class SimpleMapCache<TModel> extends ModelCache<TModel, Map<Object, TModel>> {
    public SimpleMapCache(int i10) {
        super(new HashMap(i10));
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public void addModel(Object obj, TModel tmodel) {
        getCache().put(obj, tmodel);
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public void clear() {
        getCache().clear();
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public TModel get(Object obj) {
        return getCache().get(obj);
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public TModel removeModel(Object obj) {
        return getCache().remove(obj);
    }

    @Override // com.raizlabs.android.dbflow.structure.cache.ModelCache
    public void setCacheSize(int i10) {
        FlowLog.log(FlowLog.Level.I, "The cache size for " + SimpleMapCache.class.getSimpleName() + " is not re-configurable.");
    }

    public SimpleMapCache(Map<Object, TModel> map) {
        super(map);
    }
}
