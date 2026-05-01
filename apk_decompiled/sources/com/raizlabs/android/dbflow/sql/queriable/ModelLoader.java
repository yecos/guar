package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.InstanceAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

/* loaded from: classes3.dex */
public abstract class ModelLoader<TModel, TReturn> {
    private DatabaseDefinition databaseDefinition;
    private InstanceAdapter<TModel> instanceAdapter;
    private final Class<TModel> modelClass;

    public ModelLoader(Class<TModel> cls) {
        this.modelClass = cls;
    }

    public abstract TReturn convertToData(FlowCursor flowCursor, TReturn treturn);

    public DatabaseDefinition getDatabaseDefinition() {
        if (this.databaseDefinition == null) {
            this.databaseDefinition = FlowManager.getDatabaseForTable(this.modelClass);
        }
        return this.databaseDefinition;
    }

    public InstanceAdapter<TModel> getInstanceAdapter() {
        if (this.instanceAdapter == null) {
            this.instanceAdapter = FlowManager.getInstanceAdapter(this.modelClass);
        }
        return this.instanceAdapter;
    }

    public Class<TModel> getModelClass() {
        return this.modelClass;
    }

    public TReturn load(String str) {
        return load(getDatabaseDefinition().getWritableDatabase(), str);
    }

    public TReturn load(String str, TReturn treturn) {
        return load(getDatabaseDefinition().getWritableDatabase(), str, treturn);
    }

    public TReturn load(DatabaseWrapper databaseWrapper, String str) {
        return load(databaseWrapper, str, null);
    }

    public TReturn load(DatabaseWrapper databaseWrapper, String str, TReturn treturn) {
        return load(databaseWrapper.rawQuery(str, null), (FlowCursor) treturn);
    }

    public TReturn load(FlowCursor flowCursor) {
        return load(flowCursor, (FlowCursor) null);
    }

    public TReturn load(FlowCursor flowCursor, TReturn treturn) {
        if (flowCursor != null) {
            try {
                treturn = convertToData(flowCursor, treturn);
            } finally {
                flowCursor.close();
            }
        }
        return treturn;
    }
}
