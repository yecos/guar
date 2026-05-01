package com.umeng.message.proguard;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes3.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name */
    long f11457a;

    /* renamed from: b, reason: collision with root package name */
    String f11458b;

    /* renamed from: c, reason: collision with root package name */
    int f11459c;

    /* renamed from: d, reason: collision with root package name */
    public int f11460d;

    /* renamed from: e, reason: collision with root package name */
    public int f11461e;

    /* renamed from: f, reason: collision with root package name */
    public int f11462f;

    /* renamed from: g, reason: collision with root package name */
    public int f11463g;

    /* renamed from: h, reason: collision with root package name */
    public int f11464h;

    /* renamed from: i, reason: collision with root package name */
    public int f11465i;

    /* renamed from: j, reason: collision with root package name */
    public int f11466j;

    public af(String str, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.f11457a = System.currentTimeMillis();
        this.f11458b = str;
        this.f11459c = i10;
        this.f11460d = i11;
        this.f11461e = i12;
        this.f11462f = i13;
        this.f11463g = i14;
        this.f11464h = i15;
        this.f11465i = i16;
        this.f11466j = i17;
    }

    public final ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Time", Long.valueOf(this.f11457a));
        contentValues.put("MsgId", this.f11458b);
        contentValues.put("MsgType", Integer.valueOf(this.f11459c));
        contentValues.put("NumDisplay", Integer.valueOf(this.f11460d));
        contentValues.put("NumOpenFull", Integer.valueOf(this.f11461e));
        contentValues.put("NumOpenTop", Integer.valueOf(this.f11462f));
        contentValues.put("NumOpenBottom", Integer.valueOf(this.f11463g));
        contentValues.put("NumClose", Integer.valueOf(this.f11464h));
        contentValues.put("NumDuration", Integer.valueOf(this.f11465i));
        contentValues.put("NumCustom", Integer.valueOf(this.f11466j));
        return contentValues;
    }

    public af(Cursor cursor) {
        this.f11458b = cursor.getString(cursor.getColumnIndexOrThrow("MsgId"));
        this.f11459c = cursor.getInt(cursor.getColumnIndexOrThrow("MsgType"));
        this.f11460d = cursor.getInt(cursor.getColumnIndexOrThrow("NumDisplay"));
        this.f11461e = cursor.getInt(cursor.getColumnIndexOrThrow("NumOpenFull"));
        this.f11462f = cursor.getInt(cursor.getColumnIndexOrThrow("NumOpenTop"));
        this.f11463g = cursor.getInt(cursor.getColumnIndexOrThrow("NumOpenBottom"));
        this.f11464h = cursor.getInt(cursor.getColumnIndexOrThrow("NumClose"));
        this.f11465i = cursor.getInt(cursor.getColumnIndexOrThrow("NumDuration"));
        this.f11466j = cursor.getInt(cursor.getColumnIndexOrThrow("NumCustom"));
    }
}
