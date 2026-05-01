package com.raizlabs.android.dbflow.structure.database;

import com.raizlabs.android.dbflow.runtime.NotifyDistributor;
import com.raizlabs.android.dbflow.sql.language.BaseQueriable;

/* loaded from: classes3.dex */
public class DatabaseStatementWrapper<TModel> extends BaseDatabaseStatement {
    private final DatabaseStatement databaseStatement;
    private final BaseQueriable<TModel> modelQueriable;

    public DatabaseStatementWrapper(DatabaseStatement databaseStatement, BaseQueriable<TModel> baseQueriable) {
        this.databaseStatement = databaseStatement;
        this.modelQueriable = baseQueriable;
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindBlob(int i10, byte[] bArr) {
        this.databaseStatement.bindBlob(i10, bArr);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindDouble(int i10, double d10) {
        this.databaseStatement.bindDouble(i10, d10);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindLong(int i10, long j10) {
        this.databaseStatement.bindLong(i10, j10);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindNull(int i10) {
        this.databaseStatement.bindNull(i10);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindString(int i10, String str) {
        this.databaseStatement.bindString(i10, str);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void close() {
        this.databaseStatement.close();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void execute() {
        this.databaseStatement.execute();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public long executeInsert() {
        long executeInsert = this.databaseStatement.executeInsert();
        if (executeInsert > 0) {
            NotifyDistributor.get().notifyTableChanged(this.modelQueriable.getTable(), this.modelQueriable.getPrimaryAction());
        }
        return executeInsert;
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public long executeUpdateDelete() {
        long executeUpdateDelete = this.databaseStatement.executeUpdateDelete();
        if (executeUpdateDelete > 0) {
            NotifyDistributor.get().notifyTableChanged(this.modelQueriable.getTable(), this.modelQueriable.getPrimaryAction());
        }
        return executeUpdateDelete;
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public long simpleQueryForLong() {
        return this.databaseStatement.simpleQueryForLong();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public String simpleQueryForString() {
        return this.databaseStatement.simpleQueryForString();
    }
}
