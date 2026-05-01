package com.raizlabs.android.dbflow.structure.database;

import android.content.ContentValues;

/* loaded from: classes3.dex */
public interface DatabaseWrapper {
    void beginTransaction();

    DatabaseStatement compileStatement(String str);

    int delete(String str, String str2, String[] strArr);

    void endTransaction();

    void execSQL(String str);

    int getVersion();

    long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i10);

    FlowCursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5);

    FlowCursor rawQuery(String str, String[] strArr);

    void setTransactionSuccessful();

    long updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i10);
}
