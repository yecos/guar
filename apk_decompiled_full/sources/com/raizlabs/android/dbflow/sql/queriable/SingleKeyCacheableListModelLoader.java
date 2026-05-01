package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SingleKeyCacheableListModelLoader<TModel> extends CacheableListModelLoader<TModel> {
    public SingleKeyCacheableListModelLoader(Class<TModel> cls) {
        super(cls);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.CacheableListModelLoader, com.raizlabs.android.dbflow.sql.queriable.ListModelLoader, com.raizlabs.android.dbflow.sql.queriable.ModelLoader
    public List<TModel> convertToData(FlowCursor flowCursor, List<TModel> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (flowCursor.moveToFirst()) {
            do {
                Object cachingColumnValueFromCursor = getModelAdapter().getCachingColumnValueFromCursor(flowCursor);
                TModel tmodel = getModelCache().get(cachingColumnValueFromCursor);
                if (tmodel != null) {
                    getModelAdapter().reloadRelationships(tmodel, flowCursor);
                    list.add(tmodel);
                } else {
                    TModel newInstance = getModelAdapter().newInstance();
                    getModelAdapter().loadFromCursor(flowCursor, newInstance);
                    getModelCache().addModel(cachingColumnValueFromCursor, newInstance);
                    list.add(newInstance);
                }
            } while (flowCursor.moveToNext());
        }
        return list;
    }
}
