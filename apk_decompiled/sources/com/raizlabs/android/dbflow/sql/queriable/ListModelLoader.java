package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ListModelLoader<TModel> extends ModelLoader<TModel, List<TModel>> {
    public ListModelLoader(Class<TModel> cls) {
        super(cls);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelLoader
    public List<TModel> convertToData(FlowCursor flowCursor, List<TModel> list) {
        if (list == null) {
            list = new ArrayList<>();
        } else {
            list.clear();
        }
        if (flowCursor.moveToFirst()) {
            do {
                TModel newInstance = getInstanceAdapter().newInstance();
                getInstanceAdapter().loadFromCursor(flowCursor, newInstance);
                list.add(newInstance);
            } while (flowCursor.moveToNext());
        }
        return list;
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelLoader
    public List<TModel> load(String str) {
        return (List) super.load(str);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelLoader
    public List<TModel> load(String str, List<TModel> list) {
        return (List) super.load(str, (String) list);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelLoader
    public List<TModel> load(DatabaseWrapper databaseWrapper, String str) {
        return (List) super.load(databaseWrapper, str);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelLoader
    public List<TModel> load(DatabaseWrapper databaseWrapper, String str, List<TModel> list) {
        return (List) super.load(databaseWrapper, str, (String) list);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelLoader
    public List<TModel> load(FlowCursor flowCursor) {
        return (List) super.load(flowCursor);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.ModelLoader
    public List<TModel> load(FlowCursor flowCursor, List<TModel> list) {
        if (list == null) {
            list = new ArrayList<>();
        } else {
            list.clear();
        }
        return (List) super.load(flowCursor, (FlowCursor) list);
    }
}
