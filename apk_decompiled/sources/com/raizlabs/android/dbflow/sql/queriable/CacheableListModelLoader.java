package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.cache.ModelCache;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class CacheableListModelLoader<TModel> extends ListModelLoader<TModel> {
    private ModelAdapter<TModel> modelAdapter;
    private ModelCache<TModel, ?> modelCache;

    public CacheableListModelLoader(Class<TModel> cls) {
        super(cls);
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
            ModelCache<TModel, ?> modelCache = this.modelAdapter.getModelCache();
            this.modelCache = modelCache;
            if (modelCache == null) {
                throw new IllegalArgumentException("ModelCache specified in convertToCacheableList() must not be null.");
            }
        }
        return this.modelCache;
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ListModelLoader, com.raizlabs.android.dbflow.sql.queriable.ModelLoader
    public List<TModel> convertToData(FlowCursor flowCursor, List<TModel> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        Object[] objArr = new Object[getModelAdapter().getCachingColumns().length];
        if (flowCursor.moveToFirst()) {
            do {
                Object[] cachingColumnValuesFromCursor = getModelAdapter().getCachingColumnValuesFromCursor(objArr, flowCursor);
                TModel tmodel = getModelCache().get(getModelAdapter().getCachingId(cachingColumnValuesFromCursor));
                if (tmodel != null) {
                    getModelAdapter().reloadRelationships(tmodel, flowCursor);
                    list.add(tmodel);
                } else {
                    TModel newInstance = getModelAdapter().newInstance();
                    getModelAdapter().loadFromCursor(flowCursor, newInstance);
                    getModelCache().addModel(getModelAdapter().getCachingId(cachingColumnValuesFromCursor), newInstance);
                    list.add(newInstance);
                }
            } while (flowCursor.moveToNext());
        }
        return list;
    }
}
