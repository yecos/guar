package com.raizlabs.android.dbflow.sql.saveable;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.runtime.NotifyDistributor;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public class ModelSaver<TModel> {
    public static final int INSERT_FAILED = -1;
    private ModelAdapter<TModel> modelAdapter;

    public synchronized boolean delete(TModel tmodel) {
        return delete(tmodel, this.modelAdapter.getDeleteStatement(), getWritableDatabase());
    }

    public ModelAdapter<TModel> getModelAdapter() {
        return this.modelAdapter;
    }

    public DatabaseWrapper getWritableDatabase() {
        return FlowManager.getDatabaseForTable(this.modelAdapter.getModelClass()).getWritableDatabase();
    }

    public synchronized long insert(TModel tmodel) {
        return insert(tmodel, this.modelAdapter.getInsertStatement(), getWritableDatabase());
    }

    public synchronized boolean save(TModel tmodel) {
        return save((ModelSaver<TModel>) tmodel, getWritableDatabase(), this.modelAdapter.getInsertStatement(), this.modelAdapter.getUpdateStatement());
    }

    public void setModelAdapter(ModelAdapter<TModel> modelAdapter) {
        this.modelAdapter = modelAdapter;
    }

    public synchronized boolean update(TModel tmodel) {
        return update((ModelSaver<TModel>) tmodel, getWritableDatabase(), this.modelAdapter.getUpdateStatement());
    }

    public synchronized boolean delete(TModel tmodel, DatabaseWrapper databaseWrapper) {
        DatabaseStatement deleteStatement;
        deleteStatement = this.modelAdapter.getDeleteStatement(databaseWrapper);
        try {
        } finally {
            deleteStatement.close();
        }
        return delete(tmodel, deleteStatement, databaseWrapper);
    }

    public synchronized long insert(TModel tmodel, DatabaseWrapper databaseWrapper) {
        DatabaseStatement insertStatement;
        insertStatement = this.modelAdapter.getInsertStatement(databaseWrapper);
        try {
        } finally {
            insertStatement.close();
        }
        return insert(tmodel, insertStatement, databaseWrapper);
    }

    public synchronized boolean update(TModel tmodel, DatabaseWrapper databaseWrapper) {
        DatabaseStatement updateStatement;
        updateStatement = this.modelAdapter.getUpdateStatement(databaseWrapper);
        try {
        } finally {
            updateStatement.close();
        }
        return update((ModelSaver<TModel>) tmodel, databaseWrapper, updateStatement);
    }

    public synchronized boolean save(TModel tmodel, DatabaseWrapper databaseWrapper) {
        boolean exists;
        exists = getModelAdapter().exists(tmodel, databaseWrapper);
        if (exists) {
            exists = update(tmodel, databaseWrapper);
        }
        if (!exists) {
            exists = insert(tmodel, databaseWrapper) > -1;
        }
        if (exists) {
            NotifyDistributor.get().notifyModelChanged(tmodel, getModelAdapter(), BaseModel.Action.SAVE);
        }
        return exists;
    }

    public synchronized boolean delete(TModel tmodel, DatabaseStatement databaseStatement, DatabaseWrapper databaseWrapper) {
        boolean z10;
        this.modelAdapter.deleteForeignKeys(tmodel, databaseWrapper);
        this.modelAdapter.bindToDeleteStatement(databaseStatement, tmodel);
        z10 = databaseStatement.executeUpdateDelete() != 0;
        if (z10) {
            NotifyDistributor.get().notifyModelChanged(tmodel, this.modelAdapter, BaseModel.Action.DELETE);
        }
        this.modelAdapter.updateAutoIncrement(tmodel, 0);
        return z10;
    }

    public synchronized long insert(TModel tmodel, DatabaseStatement databaseStatement, DatabaseWrapper databaseWrapper) {
        long executeInsert;
        this.modelAdapter.saveForeignKeys(tmodel, databaseWrapper);
        this.modelAdapter.bindToInsertStatement(databaseStatement, tmodel);
        executeInsert = databaseStatement.executeInsert();
        if (executeInsert > -1) {
            this.modelAdapter.updateAutoIncrement(tmodel, Long.valueOf(executeInsert));
            NotifyDistributor.get().notifyModelChanged(tmodel, this.modelAdapter, BaseModel.Action.INSERT);
        }
        return executeInsert;
    }

    public synchronized boolean update(TModel tmodel, DatabaseWrapper databaseWrapper, DatabaseStatement databaseStatement) {
        boolean z10;
        this.modelAdapter.saveForeignKeys(tmodel, databaseWrapper);
        this.modelAdapter.bindToUpdateStatement(databaseStatement, tmodel);
        z10 = databaseStatement.executeUpdateDelete() != 0;
        if (z10) {
            NotifyDistributor.get().notifyModelChanged(tmodel, this.modelAdapter, BaseModel.Action.UPDATE);
        }
        return z10;
    }

    public synchronized boolean save(TModel tmodel, DatabaseWrapper databaseWrapper, DatabaseStatement databaseStatement, DatabaseStatement databaseStatement2) {
        boolean exists;
        exists = this.modelAdapter.exists(tmodel, databaseWrapper);
        if (exists) {
            exists = update((ModelSaver<TModel>) tmodel, databaseWrapper, databaseStatement2);
        }
        if (!exists) {
            exists = insert(tmodel, databaseStatement, databaseWrapper) > -1;
        }
        if (exists) {
            NotifyDistributor.get().notifyModelChanged(tmodel, this.modelAdapter, BaseModel.Action.SAVE);
        }
        return exists;
    }

    @Deprecated
    public synchronized boolean update(TModel tmodel, DatabaseWrapper databaseWrapper, ContentValues contentValues) {
        boolean z10;
        this.modelAdapter.saveForeignKeys(tmodel, databaseWrapper);
        this.modelAdapter.bindToContentValues(contentValues, tmodel);
        z10 = databaseWrapper.updateWithOnConflict(this.modelAdapter.getTableName(), contentValues, this.modelAdapter.getPrimaryConditionClause(tmodel).getQuery(), null, ConflictAction.getSQLiteDatabaseAlgorithmInt(this.modelAdapter.getUpdateOnConflictAction())) != 0;
        if (z10) {
            NotifyDistributor.get().notifyModelChanged(tmodel, this.modelAdapter, BaseModel.Action.UPDATE);
        }
        return z10;
    }

    @Deprecated
    public synchronized boolean save(TModel tmodel, DatabaseWrapper databaseWrapper, DatabaseStatement databaseStatement, ContentValues contentValues) {
        boolean exists;
        exists = this.modelAdapter.exists(tmodel, databaseWrapper);
        if (exists) {
            exists = update((ModelSaver<TModel>) tmodel, databaseWrapper, contentValues);
        }
        if (!exists) {
            exists = insert(tmodel, databaseStatement, databaseWrapper) > -1;
        }
        if (exists) {
            NotifyDistributor.get().notifyModelChanged(tmodel, this.modelAdapter, BaseModel.Action.SAVE);
        }
        return exists;
    }
}
