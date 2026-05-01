package com.raizlabs.android.dbflow.structure.provider;

import android.database.Cursor;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

/* loaded from: classes3.dex */
public abstract class BaseProviderModel extends BaseModel implements ModelProvider {
    @Override // com.raizlabs.android.dbflow.structure.BaseModel, com.raizlabs.android.dbflow.structure.Model
    public boolean delete() {
        return ContentUtils.delete(getDeleteUri(), this) > 0;
    }

    @Override // com.raizlabs.android.dbflow.structure.BaseModel, com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public boolean exists() {
        boolean z10 = false;
        Cursor query = ContentUtils.query(FlowManager.getContext().getContentResolver(), getQueryUri(), getModelAdapter().getPrimaryConditionClause(this), "", new String[0]);
        if (query != null && query.getCount() > 0) {
            z10 = true;
        }
        if (query != null) {
            query.close();
        }
        return z10;
    }

    @Override // com.raizlabs.android.dbflow.structure.BaseModel, com.raizlabs.android.dbflow.structure.Model
    public long insert() {
        ContentUtils.insert(getInsertUri(), this);
        return 0L;
    }

    @Override // com.raizlabs.android.dbflow.structure.provider.ModelProvider
    public void load(OperatorGroup operatorGroup, String str, String... strArr) {
        FlowCursor from = FlowCursor.from(ContentUtils.query(FlowManager.getContext().getContentResolver(), getQueryUri(), operatorGroup, str, strArr));
        if (from == null || !from.moveToFirst()) {
            return;
        }
        getModelAdapter().loadFromCursor(from, this);
        from.close();
    }

    @Override // com.raizlabs.android.dbflow.structure.BaseModel, com.raizlabs.android.dbflow.structure.Model
    public boolean save() {
        int update = ContentUtils.update(getUpdateUri(), this);
        return update == 0 ? ContentUtils.insert(getInsertUri(), this) != null : update > 0;
    }

    @Override // com.raizlabs.android.dbflow.structure.BaseModel, com.raizlabs.android.dbflow.structure.Model
    public boolean update() {
        return ContentUtils.update(getUpdateUri(), this) > 0;
    }

    @Override // com.raizlabs.android.dbflow.structure.BaseModel, com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public void load() {
        load(getModelAdapter().getPrimaryConditionClause(this), "", new String[0]);
    }
}
