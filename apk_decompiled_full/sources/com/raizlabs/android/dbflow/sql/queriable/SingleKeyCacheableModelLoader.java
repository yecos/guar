package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.structure.database.FlowCursor;

/* loaded from: classes3.dex */
public class SingleKeyCacheableModelLoader<TModel> extends CacheableModelLoader<TModel> {
    public SingleKeyCacheableModelLoader(Class<TModel> cls) {
        super(cls);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.CacheableModelLoader, com.raizlabs.android.dbflow.sql.queriable.SingleModelLoader
    public TModel convertToData(FlowCursor flowCursor, TModel tmodel, boolean z10) {
        if (z10 && !flowCursor.moveToFirst()) {
            return null;
        }
        Object cachingColumnValueFromCursor = getModelAdapter().getCachingColumnValueFromCursor(flowCursor);
        TModel tmodel2 = getModelCache().get(cachingColumnValueFromCursor);
        if (tmodel2 != null) {
            getModelAdapter().reloadRelationships(tmodel2, flowCursor);
            return tmodel2;
        }
        if (tmodel == null) {
            tmodel = getModelAdapter().newInstance();
        }
        getModelAdapter().loadFromCursor(flowCursor, tmodel);
        getModelCache().addModel(cachingColumnValueFromCursor, tmodel);
        return tmodel;
    }
}
