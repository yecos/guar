package com.raizlabs.android.dbflow.sql.queriable;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.BaseModelQueriable;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

/* loaded from: classes3.dex */
public class StringQuery<TModel> extends BaseModelQueriable<TModel> {
    private String[] args;
    private final String query;

    public StringQuery(Class<TModel> cls, String str) {
        super(cls);
        this.query = str;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseQueriable, com.raizlabs.android.dbflow.sql.queriable.Queriable, com.raizlabs.android.dbflow.sql.language.Actionable
    public BaseModel.Action getPrimaryAction() {
        return BaseModel.Action.CHANGE;
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        return this.query;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseQueriable, com.raizlabs.android.dbflow.sql.queriable.Queriable
    public FlowCursor query() {
        return query(FlowManager.getDatabaseForTable(getTable()).getWritableDatabase());
    }

    public StringQuery<TModel> setSelectionArgs(String[] strArr) {
        this.args = strArr;
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseQueriable, com.raizlabs.android.dbflow.sql.queriable.Queriable
    public FlowCursor query(DatabaseWrapper databaseWrapper) {
        return databaseWrapper.rawQuery(this.query, this.args);
    }
}
