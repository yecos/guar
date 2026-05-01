package com.raizlabs.android.dbflow.structure.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes3.dex */
public class AndroidDatabase implements DatabaseWrapper {
    private final SQLiteDatabase database;

    public AndroidDatabase(SQLiteDatabase sQLiteDatabase) {
        this.database = sQLiteDatabase;
    }

    public static AndroidDatabase from(SQLiteDatabase sQLiteDatabase) {
        return new AndroidDatabase(sQLiteDatabase);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
    public void beginTransaction() {
        this.database.beginTransaction();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
    public DatabaseStatement compileStatement(String str) {
        return AndroidDatabaseStatement.from(this.database.compileStatement(str), this.database);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
    public int delete(String str, String str2, String[] strArr) {
        return this.database.delete(str, str2, strArr);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
    public void endTransaction() {
        this.database.endTransaction();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
    public void execSQL(String str) {
        this.database.execSQL(str);
    }

    public SQLiteDatabase getDatabase() {
        return this.database;
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
    public int getVersion() {
        return this.database.getVersion();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
    public long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i10) {
        return this.database.insertWithOnConflict(str, str2, contentValues, i10);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
    public FlowCursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return FlowCursor.from(this.database.query(str, strArr, str2, strArr2, str3, str4, str5));
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
    public FlowCursor rawQuery(String str, String[] strArr) {
        return FlowCursor.from(this.database.rawQuery(str, strArr));
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
    public void setTransactionSuccessful() {
        this.database.setTransactionSuccessful();
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
    public long updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i10) {
        return this.database.updateWithOnConflict(str, contentValues, str2, strArr, i10);
    }
}
