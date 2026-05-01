package com.umeng.message.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;

/* loaded from: classes3.dex */
public final class bb {

    /* renamed from: b, reason: collision with root package name */
    private static bb f11623b;

    /* renamed from: a, reason: collision with root package name */
    public final Context f11624a;

    private bb(Context context) {
        this.f11624a = context.getApplicationContext();
    }

    public static bb a(Context context) {
        if (f11623b == null) {
            f11623b = new bb(context);
        }
        return f11623b;
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f11625a;

        /* renamed from: b, reason: collision with root package name */
        public long f11626b;

        /* renamed from: c, reason: collision with root package name */
        public int f11627c;

        public a(String str, int i10, long j10) {
            this.f11625a = str;
            this.f11627c = i10;
            this.f11626b = j10;
        }

        public final ContentValues a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("MsgId", this.f11625a);
            contentValues.put("Time", Long.valueOf(this.f11626b));
            contentValues.put("ActionType", Integer.valueOf(this.f11627c));
            return contentValues;
        }

        public a(Cursor cursor) {
            this.f11625a = cursor.getString(cursor.getColumnIndex("MsgId"));
            this.f11626b = cursor.getLong(cursor.getColumnIndex("Time"));
            this.f11627c = cursor.getInt(cursor.getColumnIndex("ActionType"));
        }
    }

    public final void a(String str, int i10, long j10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f11624a.getContentResolver().insert(h.d(this.f11624a), new a(str, i10, j10).a());
        } catch (Exception e10) {
            UPLog.e("MsgLog", e10);
        }
    }
}
