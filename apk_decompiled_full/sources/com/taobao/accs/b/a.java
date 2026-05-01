package com.taobao.accs.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.raizlabs.android.dbflow.sql.language.TriggerMethod;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f9023c;

    /* renamed from: e, reason: collision with root package name */
    private static final Lock f9024e = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    public int f9025a;

    /* renamed from: b, reason: collision with root package name */
    LinkedList<C0168a> f9026b;

    /* renamed from: d, reason: collision with root package name */
    private Context f9027d;

    /* renamed from: com.taobao.accs.b.a$a, reason: collision with other inner class name */
    public class C0168a {

        /* renamed from: a, reason: collision with root package name */
        String f9028a;

        /* renamed from: b, reason: collision with root package name */
        Object[] f9029b;

        private C0168a(String str, Object[] objArr) {
            this.f9028a = str;
            this.f9029b = objArr;
        }
    }

    private a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, str, cursorFactory, i10);
        this.f9025a = 0;
        this.f9026b = new LinkedList<>();
        this.f9027d = context;
    }

    public static a a(Context context) {
        if (f9023c == null) {
            synchronized (a.class) {
                if (f9023c == null) {
                    f9023c = new a(context, Constants.DB_NAME, null, 3);
                }
            }
        }
        return f9023c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (j.a(super.getWritableDatabase().getPath(), 102400)) {
            return super.getWritableDatabase();
        }
        return null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            Lock lock = f9024e;
            if (lock.tryLock()) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traffic(_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, host TEXT,serviceid TEXT, bid TEXT, isbackground TEXT, size TEXT)");
            }
            lock.unlock();
        } catch (Throwable th) {
            f9024e.unlock();
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 < i11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS service");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS network");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ping");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS election");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindApp");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindUser");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS traffic");
            onCreate(sQLiteDatabase);
        }
    }

    public void a(String str, String str2, String str3, boolean z10, long j10, String str4) {
        if (a(str, str3, z10, str4)) {
            a("UPDATE traffic SET size=? WHERE date=? AND host=? AND bid=? AND isbackground=?", new Object[]{Long.valueOf(j10), str4, str, str3, String.valueOf(z10)}, true);
        } else {
            a("INSERT INTO traffic VALUES(null,?,?,?,?,?,?)", new Object[]{str4, str, str2, str3, String.valueOf(z10), Long.valueOf(j10)}, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
    
        if (r2 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean a(String str, String str2, boolean z10, String str3) {
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return false;
                }
                cursor = writableDatabase.query(f.F, new String[]{bx.f10121d, "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", "size"}, "date=? AND host=? AND bid=? AND isbackground=?", new String[]{str3, str, str2, String.valueOf(z10)}, null, null, null, String.valueOf(100));
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        cursor.close();
                        return true;
                    }
                }
            } catch (Exception e10) {
                ALog.w("DBHelper", e10.toString(), new Object[0]);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void a() {
        a("DELETE FROM traffic", null, true);
    }

    public List<TrafficsMonitor.a> a(boolean z10) {
        SQLiteDatabase writableDatabase;
        int i10;
        int i11;
        int i12;
        Cursor query;
        Cursor cursor;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor2 = null;
            Cursor cursor3 = null;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e10) {
                e = e10;
            }
            if (writableDatabase == null) {
                return null;
            }
            try {
                if (z10) {
                    i10 = 1;
                    i11 = 2;
                    i12 = 3;
                    query = writableDatabase.query(f.F, new String[]{bx.f10121d, "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", "size"}, "date=?", new String[]{UtilityImpl.a(System.currentTimeMillis())}, null, null, null, String.valueOf(100));
                } else {
                    i10 = 1;
                    i11 = 2;
                    i12 = 3;
                    query = writableDatabase.query(f.F, new String[]{bx.f10121d, "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", "size"}, null, null, null, null, null, String.valueOf(100));
                }
                cursor = query;
            } catch (Exception e11) {
                e = e11;
                cursor3 = null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = null;
            }
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(i10);
                        String string2 = cursor.getString(i11);
                        String string3 = cursor.getString(i12);
                        String string4 = cursor.getString(4);
                        boolean booleanValue = Boolean.valueOf(cursor.getString(5)).booleanValue();
                        long j10 = cursor.getLong(6);
                        if (string4 != null && j10 > 0) {
                            arrayList.add(new TrafficsMonitor.a(string, string4, string3, booleanValue, string2, j10));
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
                cursor2 = i10;
            } catch (Exception e12) {
                e = e12;
                cursor3 = cursor;
                ALog.w("DBHelper", e.toString(), new Object[0]);
                cursor2 = cursor3;
                if (cursor3 != null) {
                    cursor3.close();
                    cursor2 = cursor3;
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
            return arrayList;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        com.taobao.accs.utl.ALog.d("DBHelper", "db is full!", new java.lang.Object[0]);
        onUpgrade(r5, 0, 1);
        r4.f9025a = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void a(String str, Object[] objArr, boolean z10) {
        try {
            this.f9026b.add(new C0168a(str, objArr));
            if (this.f9026b.size() > 5 || z10) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                while (true) {
                    try {
                        if (this.f9026b.size() <= 0) {
                            break;
                        }
                        C0168a removeFirst = this.f9026b.removeFirst();
                        Object[] objArr2 = removeFirst.f9029b;
                        if (objArr2 != null) {
                            writableDatabase.execSQL(removeFirst.f9028a, objArr2);
                        } else {
                            writableDatabase.execSQL(removeFirst.f9028a);
                        }
                        if (removeFirst.f9028a.contains(TriggerMethod.INSERT)) {
                            int i10 = this.f9025a + 1;
                            this.f9025a = i10;
                            if (i10 > 4000) {
                                break;
                            }
                        }
                    } catch (Throwable th) {
                        writableDatabase.close();
                        throw th;
                    }
                }
                writableDatabase.close();
            }
        } catch (Exception e10) {
            ALog.d("DBHelper", e10.toString(), new Object[0]);
        }
    }
}
