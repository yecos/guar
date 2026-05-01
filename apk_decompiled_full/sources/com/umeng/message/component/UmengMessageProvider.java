package com.umeng.message.component;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.bc;
import com.umeng.message.proguard.h;
import com.umeng.message.proguard.y;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes3.dex */
public class UmengMessageProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    private final UriMatcher f11360a = new UriMatcher(-1);

    /* renamed from: b, reason: collision with root package name */
    private volatile a f11361b;

    /* renamed from: c, reason: collision with root package name */
    private volatile b f11362c;

    public static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "MessageStore.db", (SQLiteDatabase.CursorFactory) null, 5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(String.format("create table if not exists %s (time long, type varchar default NULL, alias varchar default NULL, exclusive int, ttl long, PRIMARY KEY(time))", "MsgAlias"));
            } catch (Throwable th) {
                UPLog.e("MessageProvider", th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            try {
                if (UmengMessageProvider.b(sQLiteDatabase, "MsgAlias")) {
                    sQLiteDatabase.execSQL("drop table MsgAlias");
                }
                onCreate(sQLiteDatabase);
            } catch (Throwable th) {
                UPLog.e("MessageProvider", th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            if (i10 <= 3) {
                try {
                    if (UmengMessageProvider.b(sQLiteDatabase, "MsgTemp")) {
                        sQLiteDatabase.execSQL("drop table MsgTemp");
                    }
                    if (UmengMessageProvider.b(sQLiteDatabase, "MessageStore")) {
                        sQLiteDatabase.execSQL("drop table MessageStore");
                    }
                } catch (Throwable th) {
                    UPLog.e("MessageProvider", th);
                    return;
                }
            }
            if (i10 <= 4 && UmengMessageProvider.b(sQLiteDatabase, "MsgAlias")) {
                sQLiteDatabase.execSQL("drop table MsgAlias");
            }
            onCreate(sQLiteDatabase);
        }
    }

    public static class b extends SQLiteOpenHelper {
        public b(Context context) {
            super(context, "MsgLogStore.db", (SQLiteDatabase.CursorFactory) null, 8);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(String.format("create table if not exists MsgLogStore (MsgId varchar, ActionType Integer, Time long, %s varchar, PRIMARY KEY(MsgId, ActionType))", "pa"));
                sQLiteDatabase.execSQL("create table if not exists InAppLogStore (Time long, MsgId varchar, MsgType Integer, NumDisplay Integer, NumOpenFull Integer, NumOpenTop Integer, NumOpenBottom Integer, NumClose Integer, NumDuration Integer, NumCustom Integer, PRIMARY KEY(Time))");
            } catch (Throwable th) {
                UPLog.e("MessageProvider", th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            try {
                if (UmengMessageProvider.b(sQLiteDatabase, "MsgLogStore")) {
                    sQLiteDatabase.execSQL("drop table MsgLogStore");
                }
                if (UmengMessageProvider.b(sQLiteDatabase, "InAppLogStore")) {
                    sQLiteDatabase.execSQL("drop table InAppLogStore");
                }
                onCreate(sQLiteDatabase);
            } catch (Throwable th) {
                UPLog.e("MessageProvider", th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            if (i10 <= 5) {
                try {
                    if (UmengMessageProvider.b(sQLiteDatabase, "MsgLogStore")) {
                        sQLiteDatabase.execSQL(String.format("ALTER TABLE MsgLogStore ADD COLUMN %s varchar", "pa"));
                    }
                } catch (Throwable th) {
                    UPLog.e("MessageProvider", th);
                    return;
                }
            }
            if (i10 <= 6 && UmengMessageProvider.b(sQLiteDatabase, "InAppLogStore")) {
                sQLiteDatabase.execSQL(String.format("ALTER TABLE InAppLogStore ADD COLUMN %s Integer", "NumCustom"));
            }
            if (i10 <= 7) {
                if (UmengMessageProvider.b(sQLiteDatabase, "MsgLogStoreForAgoo")) {
                    sQLiteDatabase.execSQL("drop table MsgLogStoreForAgoo");
                }
                if (UmengMessageProvider.b(sQLiteDatabase, "MsgLogIdTypeStore")) {
                    sQLiteDatabase.execSQL("drop table MsgLogIdTypeStore");
                }
                if (UmengMessageProvider.b(sQLiteDatabase, "MsgLogIdTypeStoreForAgoo")) {
                    sQLiteDatabase.execSQL("drop table MsgLogIdTypeStoreForAgoo");
                }
                if (UmengMessageProvider.b(sQLiteDatabase, "MsgConfigInfo")) {
                    sQLiteDatabase.execSQL("drop table MsgConfigInfo");
                }
            }
            onCreate(sQLiteDatabase);
        }
    }

    private b b() {
        if (this.f11362c == null) {
            synchronized (b.class) {
                if (this.f11362c == null) {
                    this.f11362c = new b(getContext());
                }
            }
        }
        return this.f11362c;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        SQLiteDatabase writableDatabase = b().getWritableDatabase();
        try {
            if (writableDatabase == null) {
                return super.applyBatch(arrayList);
            }
            try {
                writableDatabase.beginTransaction();
                ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
                writableDatabase.setTransactionSuccessful();
                return applyBatch;
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (Throwable unused) {
            return super.applyBatch(arrayList);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        SQLiteDatabase writableDatabase;
        try {
            int match = this.f11360a.match(uri);
            if (match != 2) {
                if (match == 3) {
                    SQLiteDatabase writableDatabase2 = a().getWritableDatabase();
                    if (writableDatabase2 != null) {
                        return writableDatabase2.delete("MsgAlias", str, strArr);
                    }
                } else if (match == 4) {
                    SQLiteDatabase writableDatabase3 = a().getWritableDatabase();
                    if (writableDatabase3 != null) {
                        return writableDatabase3.delete("MsgAlias", null, null);
                    }
                } else if (match == 5) {
                    SQLiteDatabase writableDatabase4 = b().getWritableDatabase();
                    if (writableDatabase4 != null) {
                        return writableDatabase4.delete("MsgLogStore", str, strArr);
                    }
                } else if (match == 10 && (writableDatabase = b().getWritableDatabase()) != null) {
                    return writableDatabase.delete("InAppLogStore", str, strArr);
                }
            } else if (strArr != null && strArr.length != 0) {
                bc a10 = bc.a();
                if (strArr.length == 0) {
                    return 0;
                }
                SharedPreferences.Editor edit = a10.f11629a.edit();
                int i10 = 0;
                for (String str2 : strArr) {
                    if (a10.f11629a.contains(str2)) {
                        edit.remove(str2);
                        i10++;
                    }
                }
                if (i10 > 0) {
                    edit.apply();
                }
                return i10;
            }
        } catch (Throwable th) {
            UPLog.e("MessageProvider", th);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int match = this.f11360a.match(uri);
        if (match == 2 || match == 3 || match == 5) {
            return "vnd.android.cursor.dir/vnd.umeng.message";
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            int match = this.f11360a.match(uri);
            if (match != 2) {
                if (match == 3) {
                    SQLiteDatabase writableDatabase = a().getWritableDatabase();
                    if (writableDatabase == null) {
                        return null;
                    }
                    writableDatabase.insertWithOnConflict("MsgAlias", null, contentValues, 5);
                } else if (match == 5) {
                    SQLiteDatabase writableDatabase2 = b().getWritableDatabase();
                    if (writableDatabase2 == null) {
                        return null;
                    }
                    writableDatabase2.insertWithOnConflict("MsgLogStore", null, contentValues, 5);
                } else if (match == 10) {
                    SQLiteDatabase writableDatabase3 = b().getWritableDatabase();
                    if (writableDatabase3 == null) {
                        return null;
                    }
                    writableDatabase3.insertWithOnConflict("InAppLogStore", null, contentValues, 5);
                }
            } else {
                if (contentValues == null) {
                    return null;
                }
                String asString = contentValues.getAsString("k");
                String asString2 = contentValues.getAsString("v");
                if (!TextUtils.isEmpty(asString)) {
                    bc.a().a(asString, asString2);
                }
            }
        } catch (Throwable th) {
            UPLog.e("MessageProvider", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            Context context = getContext();
            y.a(context);
            Uri a10 = h.a(context);
            this.f11360a.addURI(a10.getAuthority(), a10.getPath(), 3);
            Uri b10 = h.b(context);
            this.f11360a.addURI(b10.getAuthority(), b10.getPath(), 4);
            Uri d10 = h.d(context);
            this.f11360a.addURI(d10.getAuthority(), d10.getPath(), 5);
            Uri e10 = h.e(context);
            this.f11360a.addURI(e10.getAuthority(), e10.getPath(), 10);
            Uri c10 = h.c(context);
            this.f11360a.addURI(c10.getAuthority(), c10.getPath(), 2);
            return true;
        } catch (Throwable th) {
            UPLog.e("MessageProvider", th);
            return true;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase readableDatabase;
        try {
            int match = this.f11360a.match(uri);
            if (match != 2) {
                if (match == 3) {
                    SQLiteDatabase readableDatabase2 = a().getReadableDatabase();
                    if (readableDatabase2 == null) {
                        return null;
                    }
                    return readableDatabase2.query("MsgAlias", strArr, str, strArr2, null, null, str2);
                }
                if (match != 5) {
                    if (match == 10 && (readableDatabase = b().getReadableDatabase()) != null) {
                        return readableDatabase.query("InAppLogStore", strArr, str, strArr2, null, null, str2);
                    }
                    return null;
                }
                SQLiteDatabase readableDatabase3 = b().getReadableDatabase();
                if (readableDatabase3 == null) {
                    return null;
                }
                return readableDatabase3.query("MsgLogStore", strArr, str, strArr2, null, null, str2);
            }
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"k", "v"});
            Map<String, ?> all = bc.a().f11629a.getAll();
            if (strArr2 != null && strArr2.length != 0) {
                for (String str3 : strArr2) {
                    Object obj = all.get(str3);
                    if (obj instanceof String) {
                        matrixCursor.addRow(new Object[]{str3, obj});
                    }
                }
                return matrixCursor;
            }
            for (String str4 : all.keySet()) {
                Object obj2 = all.get(str4);
                if (obj2 instanceof String) {
                    matrixCursor.addRow(new Object[]{str4, obj2});
                }
            }
            return matrixCursor;
        } catch (Throwable th) {
            UPLog.e("MessageProvider", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase;
        try {
            int match = this.f11360a.match(uri);
            if (match != 2) {
                if (match == 3) {
                    SQLiteDatabase writableDatabase2 = a().getWritableDatabase();
                    if (writableDatabase2 != null) {
                        return writableDatabase2.updateWithOnConflict("MsgAlias", contentValues, str, strArr, 5);
                    }
                } else if (match == 10 && (writableDatabase = b().getWritableDatabase()) != null) {
                    return writableDatabase.updateWithOnConflict("InAppLogStore", contentValues, str, strArr, 5);
                }
            } else if (contentValues != null && strArr != null && strArr.length != 0) {
                String str2 = strArr[0];
                String asString = contentValues.getAsString("v");
                if (!TextUtils.isEmpty(str2)) {
                    bc.a().a(str2, asString);
                    return 1;
                }
            }
        } catch (Throwable th) {
            UPLog.e("MessageProvider", th);
        }
        return 0;
    }

    private a a() {
        if (this.f11361b == null) {
            synchronized (a.class) {
                if (this.f11361b == null) {
                    this.f11361b = new a(getContext());
                }
            }
        }
        return this.f11361b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery(String.format("select count(*) as c from sqlite_master where type = 'table' and name = '%s'", str.trim()), null);
            if (rawQuery != null) {
                if (rawQuery.moveToNext() && rawQuery.getInt(0) > 0) {
                    z10 = true;
                }
                rawQuery.close();
            }
        } catch (Throwable th) {
            UPLog.e("MessageProvider", th);
        }
        return z10;
    }
}
