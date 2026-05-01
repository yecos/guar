package com.raizlabs.android.dbflow.structure.database;

/* loaded from: classes3.dex */
public abstract class BaseDatabaseStatement implements DatabaseStatement {
    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindBlobOrNull(int i10, byte[] bArr) {
        if (bArr != null) {
            bindBlob(i10, bArr);
        } else {
            bindNull(i10);
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindDoubleOrNull(int i10, Double d10) {
        if (d10 != null) {
            bindDouble(i10, d10.doubleValue());
        } else {
            bindNull(i10);
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindFloatOrNull(int i10, Float f10) {
        if (f10 != null) {
            bindDouble(i10, f10.floatValue());
        } else {
            bindNull(i10);
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindNumber(int i10, Number number) {
        bindNumberOrNull(i10, number);
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindNumberOrNull(int i10, Number number) {
        if (number != null) {
            bindLong(i10, number.longValue());
        } else {
            bindNull(i10);
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.database.DatabaseStatement
    public void bindStringOrNull(int i10, String str) {
        if (str != null) {
            bindString(i10, str);
        } else {
            bindNull(i10);
        }
    }
}
