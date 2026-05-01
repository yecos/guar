package com.raizlabs.android.dbflow.structure.database;

/* loaded from: classes3.dex */
public interface DatabaseStatement {
    void bindBlob(int i10, byte[] bArr);

    void bindBlobOrNull(int i10, byte[] bArr);

    void bindDouble(int i10, double d10);

    void bindDoubleOrNull(int i10, Double d10);

    void bindFloatOrNull(int i10, Float f10);

    void bindLong(int i10, long j10);

    void bindNull(int i10);

    void bindNumber(int i10, Number number);

    void bindNumberOrNull(int i10, Number number);

    void bindString(int i10, String str);

    void bindStringOrNull(int i10, String str);

    void close();

    void execute();

    long executeInsert();

    long executeUpdateDelete();

    long simpleQueryForLong();

    String simpleQueryForString();
}
