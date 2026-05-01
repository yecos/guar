package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.g;

/* loaded from: classes3.dex */
class h extends SQLiteOpenHelper {

    /* renamed from: b, reason: collision with root package name */
    private static Context f10412b;

    /* renamed from: a, reason: collision with root package name */
    private String f10413a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final h f10414a = new h(h.f10412b, j.b(h.f10412b), g.f10346b, null, 2);

        private a() {
        }
    }

    public static h a(Context context) {
        if (f10412b == null) {
            f10412b = context.getApplicationContext();
        }
        return a.f10414a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f10413a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f10413a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!j.a(sQLiteDatabase, g.d.f10387a, "__av")) {
            j.a(sQLiteDatabase, g.d.f10387a, "__sp", "TEXT");
            j.a(sQLiteDatabase, g.d.f10387a, "__pp", "TEXT");
            j.a(sQLiteDatabase, g.d.f10387a, "__av", "TEXT");
            j.a(sQLiteDatabase, g.d.f10387a, "__vc", "TEXT");
        }
        if (!j.a(sQLiteDatabase, g.b.f10361a, "__av")) {
            j.a(sQLiteDatabase, g.b.f10361a, "__av", "TEXT");
            j.a(sQLiteDatabase, g.b.f10361a, "__vc", "TEXT");
        }
        if (j.a(sQLiteDatabase, g.a.f10350a, "__av")) {
            return;
        }
        j.a(sQLiteDatabase, g.a.f10350a, "__av", "TEXT");
        j.a(sQLiteDatabase, g.a.f10350a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, g.d.f10387a);
        a(sQLiteDatabase, g.b.f10361a);
        a(sQLiteDatabase, g.a.f10350a);
        a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(f10412b);
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable unused3) {
            if (sQLiteDatabase == null) {
                return;
            }
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable unused4) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i11 <= i10 || i10 != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                f(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            e(sQLiteDatabase);
        }
    }

    private h(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        this(new e(context, str), str2, cursorFactory, i10);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f10413a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private h(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, TextUtils.isEmpty(str) ? g.f10346b : str, cursorFactory, i10);
        this.f10413a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!j.a(g.d.f10387a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!j.a(g.c.f10374a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!j.a(g.b.f10361a, writableDatabase)) {
                b(writableDatabase);
            }
            if (j.a(g.a.f10350a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f10413a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
