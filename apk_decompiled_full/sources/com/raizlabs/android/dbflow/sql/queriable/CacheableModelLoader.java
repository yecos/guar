package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.cache.ModelCache;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

/* loaded from: classes3.dex */
public class CacheableModelLoader<TModel> extends SingleModelLoader<TModel> {
    private ModelAdapter<TModel> modelAdapter;
    private ModelCache<TModel, ?> modelCache;

    public CacheableModelLoader(Class<TModel> cls) {
        super(cls);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.SingleModelLoader
    public TModel convertToData(FlowCursor flowCursor, TModel tmodel, boolean z10) {
        if (z10 && !flowCursor.moveToFirst()) {
            return null;
        }
        Object[] cachingColumnValuesFromCursor = getModelAdapter().getCachingColumnValuesFromCursor(new Object[getModelAdapter().getCachingColumns().length], flowCursor);
        TModel tmodel2 = getModelCache().get(getModelAdapter().getCachingId(cachingColumnValuesFromCursor));
        if (tmodel2 != null) {
            getModelAdapter().reloadRelationships(tmodel2, flowCursor);
            return tmodel2;
        }
        if (tmodel == null) {
            tmodel = getModelAdapter().newInstance();
        }
        getModelAdapter().loadFromCursor(flowCursor, tmodel);
        getModelCache().addModel(getModelAdapter().getCachingId(cachingColumnValuesFromCursor), tmodel);
        return tmodel;
    }

    public ModelAdapter<TModel> getModelAdapter() {
        if (this.modelAdapter == null) {
            if (!(getInstanceAdapter() instanceof ModelAdapter)) {
                throw new IllegalArgumentException("A non-Table type was used.");
            }
            ModelAdapter<TModel> modelAdapter = (ModelAdapter) getInstanceAdapter();
            this.modelAdapter = modelAdapter;
            if (!modelAdapter.cachingEnabled()) {
                throw new IllegalArgumentException("You cannot call this method for a table that has no caching id. Eitheruse one Primary Key or use the MultiCacheKeyConverter");
            }
        }
        return this.modelAdapter;
    }

    public ModelCache<TModel, ?> getModelCache() {
        if (this.modelCache == null) {
            this.modelCache = getModelAdapter().getModelCache();
        }
        return this.modelCache;
    }
}
