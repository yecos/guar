package com.raizlabs.android.dbflow.sql.saveable;

import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.runtime.NotifyDistributor;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/* loaded from: classes3.dex */
public class AutoIncrementModelSaver<TModel> extends ModelSaver<TModel> {
    @Override // com.raizlabs.android.dbflow.sql.saveable.ModelSaver
    public synchronized long insert(TModel tmodel) {
        return insert(tmodel, getWritableDatabase());
    }

    @Override // com.raizlabs.android.dbflow.sql.saveable.ModelSaver
    public synchronized long insert(TModel tmodel, DatabaseWrapper databaseWrapper) {
        long executeInsert;
        boolean hasAutoIncrement = getModelAdapter().hasAutoIncrement(tmodel);
        DatabaseStatement compiledStatement = hasAutoIncrement ? getModelAdapter().getCompiledStatement(databaseWrapper) : getModelAdapter().getInsertStatement(databaseWrapper);
        try {
            getModelAdapter().saveForeignKeys(tmodel, databaseWrapper);
            if (hasAutoIncrement) {
                getModelAdapter().bindToStatement(compiledStatement, tmodel);
            } else {
                getModelAdapter().bindToInsertStatement(compiledStatement, tmodel);
            }
            executeInsert = compiledStatement.executeInsert();
            if (executeInsert > -1) {
                getModelAdapter().updateAutoIncrement(tmodel, Long.valueOf(executeInsert));
                NotifyDistributor.get().notifyModelChanged(tmodel, getModelAdapter(), BaseModel.Action.INSERT);
            }
        } finally {
            compiledStatement.close();
        }
        return executeInsert;
    }

    @Override // com.raizlabs.android.dbflow.sql.saveable.ModelSaver
    public synchronized long insert(TModel tmodel, DatabaseStatement databaseStatement, DatabaseWrapper databaseWrapper) {
        if (!getModelAdapter().hasAutoIncrement(tmodel)) {
            return super.insert(tmodel, databaseStatement, databaseWrapper);
        }
        FlowLog.log(FlowLog.Level.W, "Ignoring insert statement " + databaseStatement + " since an autoincrement column specified in the insert.");
        return insert(tmodel, databaseWrapper);
    }
}
