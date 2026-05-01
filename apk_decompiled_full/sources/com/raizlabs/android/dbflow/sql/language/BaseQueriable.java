package com.raizlabs.android.dbflow.sql.language;

import android.database.sqlite.SQLiteDoneException;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.runtime.NotifyDistributor;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.sql.queriable.Queriable;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatementWrapper;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

/* loaded from: classes3.dex */
public abstract class BaseQueriable<TModel> implements Queriable, Actionable {
    private final Class<TModel> table;

    public BaseQueriable(Class<TModel> cls) {
        this.table = cls;
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public DatabaseStatement compileStatement() {
        return compileStatement(FlowManager.getWritableDatabaseForTable(this.table));
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public long count(DatabaseWrapper databaseWrapper) {
        return longValue(databaseWrapper);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public void execute() {
        FlowCursor query = query();
        if (query != null) {
            query.close();
        } else {
            NotifyDistributor.get().notifyTableChanged(getTable(), getPrimaryAction());
        }
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public long executeInsert() {
        return executeInsert(FlowManager.getWritableDatabaseForTable(this.table));
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable, com.raizlabs.android.dbflow.sql.language.Actionable
    public abstract BaseModel.Action getPrimaryAction();

    public Class<TModel> getTable() {
        return this.table;
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public boolean hasData() {
        return count() > 0;
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public long longValue() {
        return longValue(FlowManager.getWritableDatabaseForTable(this.table));
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public FlowCursor query() {
        query(FlowManager.getWritableDatabaseForTable(this.table));
        return null;
    }

    public String toString() {
        return getQuery();
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public DatabaseStatement compileStatement(DatabaseWrapper databaseWrapper) {
        String query = getQuery();
        FlowLog.log(FlowLog.Level.V, "Compiling Query Into Statement: " + query);
        return new DatabaseStatementWrapper(databaseWrapper.compileStatement(query), this);
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public long count() {
        return longValue();
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public long executeInsert(DatabaseWrapper databaseWrapper) {
        DatabaseStatement compileStatement = compileStatement(databaseWrapper);
        try {
            return compileStatement.executeInsert();
        } finally {
            compileStatement.close();
        }
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public boolean hasData(DatabaseWrapper databaseWrapper) {
        return count(databaseWrapper) > 0;
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public long longValue(DatabaseWrapper databaseWrapper) {
        try {
            String query = getQuery();
            FlowLog.log(FlowLog.Level.V, "Executing query: " + query);
            return SqlUtils.longForQuery(databaseWrapper, query);
        } catch (SQLiteDoneException e10) {
            FlowLog.log(FlowLog.Level.W, e10);
            return 0L;
        }
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public FlowCursor query(DatabaseWrapper databaseWrapper) {
        if (getPrimaryAction().equals(BaseModel.Action.INSERT)) {
            DatabaseStatement compileStatement = compileStatement(databaseWrapper);
            compileStatement.executeInsert();
            compileStatement.close();
            return null;
        }
        String query = getQuery();
        FlowLog.log(FlowLog.Level.V, "Executing query: " + query);
        databaseWrapper.execSQL(query);
        return null;
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public void execute(DatabaseWrapper databaseWrapper) {
        FlowCursor query = query(databaseWrapper);
        if (query != null) {
            query.close();
        } else {
            NotifyDistributor.get().notifyTableChanged(getTable(), getPrimaryAction());
        }
    }
}
