package com.raizlabs.android.dbflow.structure.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

/* loaded from: classes3.dex */
public class AndroidDatabaseStatement extends BaseDatabaseStatement {
    private final SQLiteDatabase database;
    private final SQLiteStatement statement;

    public AndroidDatabaseStatement(SQLiteStatement sQLiteStatement, SQLiteDatabase sQLiteDatabase) {
        this.statement = sQLiteStatement;
        this.database = sQLiteDatabase;
    }

    public static AndroidDatabaseStatement from(SQLiteStatement sQLiteStatement, SQLiteDatabase sQLiteDatabase) {
        return new AndroidDatabaseStatement(sQLiteStatement, sQLiteDatabase);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindBlob(int i10, byte[] bArr) {
        this.statement.bindBlob(i10, bArr);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindDouble(int i10, double d10) {
        this.statement.bindDouble(i10, d10);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindLong(int i10, long j10) {
        this.statement.bindLong(i10, j10);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindNull(int i10) {
        this.statement.bindNull(i10);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindString(int i10, String str) {
        this.statement.bindString(i10, str);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void close() {
        this.statement.close();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void execute() {
        this.statement.execute();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public long executeInsert() {
        return this.statement.executeInsert();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public long executeUpdateDelete() {
        return this.statement.executeUpdateDelete();
    }

    public SQLiteStatement getStatement() {
        return this.statement;
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public long simpleQueryForLong() {
        return this.statement.simpleQueryForLong();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public String simpleQueryForString() {
        return this.statement.simpleQueryForString();
    }
}
