package com.raizlabs.android.dbflow.structure.database;

import android.database.Cursor;
import android.database.CursorWrapper;

/* loaded from: classes3.dex */
public class FlowCursor extends CursorWrapper {
    private Cursor cursor;

    private FlowCursor(Cursor cursor) {
        super(cursor);
        this.cursor = cursor;
    }

    public static FlowCursor from(Cursor cursor) {
        return cursor instanceof FlowCursor ? (FlowCursor) cursor : new FlowCursor(cursor);
    }

    public byte[] getBlobOrDefault(String str) {
        return getBlobOrDefault(this.cursor.getColumnIndex(str));
    }

    public boolean getBoolean(int i10) {
        return this.cursor.getInt(i10) == 1;
    }

    public boolean getBooleanOrDefault(int i10, boolean z10) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? z10 : getBoolean(i10);
    }

    public double getDoubleOrDefault(int i10, double d10) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? d10 : this.cursor.getDouble(i10);
    }

    public float getFloatOrDefault(int i10, float f10) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? f10 : this.cursor.getFloat(i10);
    }

    public int getIntOrDefault(String str) {
        return getIntOrDefault(this.cursor.getColumnIndex(str));
    }

    public long getLongOrDefault(int i10, long j10) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? j10 : this.cursor.getLong(i10);
    }

    public short getShortOrDefault(int i10, short s10) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? s10 : this.cursor.getShort(i10);
    }

    public String getStringOrDefault(int i10, String str) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? str : this.cursor.getString(i10);
    }

    @Override // android.database.CursorWrapper
    public Cursor getWrappedCursor() {
        return this.cursor;
    }

    public byte[] getBlobOrDefault(int i10) {
        if (i10 == -1 || this.cursor.isNull(i10)) {
            return null;
        }
        return this.cursor.getBlob(i10);
    }

    public int getIntOrDefault(int i10) {
        if (i10 == -1 || this.cursor.isNull(i10)) {
            return 0;
        }
        return this.cursor.getInt(i10);
    }

    public boolean getBooleanOrDefault(String str) {
        return getBooleanOrDefault(this.cursor.getColumnIndex(str));
    }

    public double getDoubleOrDefault(String str) {
        return getDoubleOrDefault(this.cursor.getColumnIndex(str));
    }

    public float getFloatOrDefault(String str) {
        return getFloatOrDefault(this.cursor.getColumnIndex(str));
    }

    public long getLongOrDefault(String str) {
        return getLongOrDefault(this.cursor.getColumnIndex(str));
    }

    public short getShortOrDefault(String str) {
        return getShortOrDefault(this.cursor.getColumnIndex(str));
    }

    public String getStringOrDefault(String str) {
        return getStringOrDefault(this.cursor.getColumnIndex(str));
    }

    public byte[] getBlobOrDefault(int i10, byte[] bArr) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? bArr : this.cursor.getBlob(i10);
    }

    public boolean getBooleanOrDefault(int i10) {
        if (i10 == -1 || this.cursor.isNull(i10)) {
            return false;
        }
        return getBoolean(i10);
    }

    public double getDoubleOrDefault(int i10) {
        if (i10 == -1 || this.cursor.isNull(i10)) {
            return 0.0d;
        }
        return this.cursor.getDouble(i10);
    }

    public float getFloatOrDefault(int i10) {
        if (i10 == -1 || this.cursor.isNull(i10)) {
            return 0.0f;
        }
        return this.cursor.getFloat(i10);
    }

    public int getIntOrDefault(int i10, int i11) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? i11 : this.cursor.getInt(i10);
    }

    public long getLongOrDefault(int i10) {
        if (i10 == -1 || this.cursor.isNull(i10)) {
            return 0L;
        }
        return this.cursor.getLong(i10);
    }

    public short getShortOrDefault(int i10) {
        if (i10 == -1 || this.cursor.isNull(i10)) {
            return (short) 0;
        }
        return this.cursor.getShort(i10);
    }

    public String getStringOrDefault(int i10) {
        if (i10 == -1 || this.cursor.isNull(i10)) {
            return null;
        }
        return this.cursor.getString(i10);
    }

    public byte[] getBlobOrDefault(String str, byte[] bArr) {
        return getBlobOrDefault(this.cursor.getColumnIndex(str), bArr);
    }

    public boolean getBooleanOrDefault(String str, boolean z10) {
        return getBooleanOrDefault(this.cursor.getColumnIndex(str), z10);
    }

    public double getDoubleOrDefault(String str, double d10) {
        return getDoubleOrDefault(this.cursor.getColumnIndex(str), d10);
    }

    public float getFloatOrDefault(String str, float f10) {
        return getFloatOrDefault(this.cursor.getColumnIndex(str), f10);
    }

    public int getIntOrDefault(String str, int i10) {
        return getIntOrDefault(this.cursor.getColumnIndex(str), i10);
    }

    public long getLongOrDefault(String str, long j10) {
        return getLongOrDefault(this.cursor.getColumnIndex(str), j10);
    }

    public short getShortOrDefault(String str, short s10) {
        return getShortOrDefault(this.cursor.getColumnIndex(str), s10);
    }

    public String getStringOrDefault(String str, String str2) {
        return getStringOrDefault(this.cursor.getColumnIndex(str), str2);
    }

    public Double getDoubleOrDefault(int i10, Double d10) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? d10 : Double.valueOf(this.cursor.getDouble(i10));
    }

    public Float getFloatOrDefault(int i10, Float f10) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? f10 : Float.valueOf(this.cursor.getFloat(i10));
    }

    public Integer getIntOrDefault(int i10, Integer num) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? num : Integer.valueOf(this.cursor.getInt(i10));
    }

    public Long getLongOrDefault(int i10, Long l10) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? l10 : Long.valueOf(this.cursor.getLong(i10));
    }

    public Short getShortOrDefault(int i10, Short sh) {
        return (i10 == -1 || this.cursor.isNull(i10)) ? sh : Short.valueOf(this.cursor.getShort(i10));
    }

    public Double getDoubleOrDefault(String str, Double d10) {
        return getDoubleOrDefault(this.cursor.getColumnIndex(str), d10);
    }

    public Float getFloatOrDefault(String str, Float f10) {
        return getFloatOrDefault(this.cursor.getColumnIndex(str), f10);
    }

    public Integer getIntOrDefault(String str, Integer num) {
        return getIntOrDefault(this.cursor.getColumnIndex(str), num);
    }

    public Long getLongOrDefault(String str, Long l10) {
        return getLongOrDefault(this.cursor.getColumnIndex(str), l10);
    }

    public Short getShortOrDefault(String str, Short sh) {
        return getShortOrDefault(this.cursor.getColumnIndex(str), sh);
    }
}
