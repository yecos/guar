package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.structure.database.FlowCursor;

/* loaded from: classes3.dex */
public class SingleModelLoader<TModel> extends ModelLoader<TModel, TModel> {
    public SingleModelLoader(Class<TModel> cls) {
        super(cls);
    }

    public TModel convertToData(FlowCursor flowCursor, TModel tmodel, boolean z10) {
        if (!z10 || flowCursor.moveToFirst()) {
            if (tmodel == null) {
                tmodel = getInstanceAdapter().newInstance();
            }
            getInstanceAdapter().loadFromCursor(flowCursor, tmodel);
        }
        return tmodel;
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelLoader
    public TModel convertToData(FlowCursor flowCursor, TModel tmodel) {
        return convertToData(flowCursor, tmodel, true);
    }
}
