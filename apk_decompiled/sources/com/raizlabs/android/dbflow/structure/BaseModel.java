package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.annotation.ColumnIgnore;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public class BaseModel implements Model {

    @ColumnIgnore
    private transient ModelAdapter modelAdapter;

    public enum Action {
        SAVE,
        INSERT,
        UPDATE,
        DELETE,
        CHANGE
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public AsyncModel<? extends Model> async() {
        return new AsyncModel<>(this);
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public boolean delete() {
        return getModelAdapter().delete(this);
    }

    @Override // com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public boolean exists() {
        return getModelAdapter().exists(this);
    }

    public ModelAdapter getModelAdapter() {
        if (this.modelAdapter == null) {
            this.modelAdapter = FlowManager.getModelAdapter(getClass());
        }
        return this.modelAdapter;
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public long insert() {
        return getModelAdapter().insert(this);
    }

    @Override // com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public void load() {
        getModelAdapter().load(this);
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public boolean save() {
        return getModelAdapter().save(this);
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public boolean update() {
        return getModelAdapter().update(this);
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public boolean delete(DatabaseWrapper databaseWrapper) {
        return getModelAdapter().delete(this, databaseWrapper);
    }

    @Override // com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public boolean exists(DatabaseWrapper databaseWrapper) {
        return getModelAdapter().exists(this, databaseWrapper);
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public long insert(DatabaseWrapper databaseWrapper) {
        return getModelAdapter().insert(this, databaseWrapper);
    }

    @Override // com.raizlabs.android.dbflow.structure.ReadOnlyModel
    public void load(DatabaseWrapper databaseWrapper) {
        getModelAdapter().load(this, databaseWrapper);
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public boolean save(DatabaseWrapper databaseWrapper) {
        return getModelAdapter().save(this, databaseWrapper);
    }

    @Override // com.raizlabs.android.dbflow.structure.Model
    public boolean update(DatabaseWrapper databaseWrapper) {
        return getModelAdapter().update(this, databaseWrapper);
    }
}
