package com.raizlabs.android.dbflow.structure.provider;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

/* loaded from: classes3.dex */
public abstract class BaseSyncableProviderModel extends BaseModel implements ModelProvider {
    @Override // com.raizlabs.android.dbflow.structure.BaseModel, com.raizlabs.android.dbflow.structure.Model
    public boolean delete() {
        return super.delete() && ContentUtils.delete(getDeleteUri(), this) > 0;
    }

    @Override // com.raizlabs.android.dbflow.structure.BaseModel, com.raizlabs.android.dbflow.structure.Model
    public long insert() {
        long insert = super.insert();
        ContentUtils.insert(getInsertUri(), this);
        return insert;
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
        return exists() ? super.save() && ContentUtils.update(getUpdateUri(), this) > 0 : super.save() && ContentUtils.insert(getInsertUri(), this) != null;
    }

    @Override // com.raizlabs.android.dbflow.structure.BaseModel, com.raizlabs.android.dbflow.structure.Model
    public boolean update() {
        return super.update() && ContentUtils.update(getUpdateUri(), this) > 0;
    }

    @Override // com.raizlabs.android.dbflow.structure.BaseModel, com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public void load() {
        load(getModelAdapter().getPrimaryConditionClause(this), "", new String[0]);
    }
}
