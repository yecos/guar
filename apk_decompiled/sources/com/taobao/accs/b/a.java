package com.taobao.accs.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized boolean a(java.lang.String r15, java.lang.String r16, boolean r17, java.lang.String r18) {
        /*
            r14 = this;
            monitor-enter(r14)
            r1 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r14.getWritableDatabase()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            if (r3 != 0) goto Lb
            monitor-exit(r14)
            return r1
        Lb:
            java.lang.String r4 = "traffic"
            r0 = 7
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r0 = "_id"
            r5[r1] = r0     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r0 = "date"
            r12 = 1
            r5[r12] = r0     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r0 = "host"
            r6 = 2
            r5[r6] = r0     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r0 = "serviceid"
            r7 = 3
            r5[r7] = r0     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r0 = "bid"
            r8 = 4
            r5[r8] = r0     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r0 = "isbackground"
            r9 = 5
            r5[r9] = r0     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r0 = "size"
            r9 = 6
            r5[r9] = r0     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r0 = "date=? AND host=? AND bid=? AND isbackground=?"
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r8[r1] = r18     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r8[r12] = r15     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r8[r6] = r16     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r6 = java.lang.String.valueOf(r17)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r8[r7] = r6     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r9 = 0
            r10 = 0
            r11 = 0
            r6 = 100
            java.lang.String r13 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r6 = r0
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r13
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            if (r2 == 0) goto L62
            int r0 = r2.getCount()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            if (r0 <= 0) goto L62
            r2.close()     // Catch: java.lang.Throwable -> L81
            monitor-exit(r14)
            return r12
        L62:
            if (r2 == 0) goto L79
        L64:
            r2.close()     // Catch: java.lang.Throwable -> L81
            goto L79
        L68:
            r0 = move-exception
            goto L7b
        L6a:
            r0 = move-exception
            java.lang.String r3 = "DBHelper"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L68
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L68
            com.taobao.accs.utl.ALog.w(r3, r0, r4)     // Catch: java.lang.Throwable -> L68
            if (r2 == 0) goto L79
            goto L64
        L79:
            monitor-exit(r14)
            return r1
        L7b:
            if (r2 == 0) goto L80
            r2.close()     // Catch: java.lang.Throwable -> L81
        L80:
            throw r0     // Catch: java.lang.Throwable -> L81
        L81:
            r0 = move-exception
            monitor-exit(r14)
            goto L85
        L84:
            throw r0
        L85:
            goto L84
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.b.a.a(java.lang.String, java.lang.String, boolean, java.lang.String):boolean");
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
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void a(java.lang.String r5, java.lang.Object[] r6, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            java.util.LinkedList<com.taobao.accs.b.a$a> r1 = r4.f9026b     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            com.taobao.accs.b.a$a r2 = new com.taobao.accs.b.a$a     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r3 = 0
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r1.add(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            java.util.LinkedList<com.taobao.accs.b.a$a> r5 = r4.f9026b     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            r6 = 5
            if (r5 > r6) goto L18
            if (r7 == 0) goto L78
        L18:
            android.database.sqlite.SQLiteDatabase r5 = r4.getWritableDatabase()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            if (r5 != 0) goto L20
            monitor-exit(r4)
            return
        L20:
            java.util.LinkedList<com.taobao.accs.b.a$a> r6 = r4.f9026b     // Catch: java.lang.Throwable -> L65
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L65
            if (r6 <= 0) goto L61
            java.util.LinkedList<com.taobao.accs.b.a$a> r6 = r4.f9026b     // Catch: java.lang.Throwable -> L65
            java.lang.Object r6 = r6.removeFirst()     // Catch: java.lang.Throwable -> L65
            com.taobao.accs.b.a$a r6 = (com.taobao.accs.b.a.C0168a) r6     // Catch: java.lang.Throwable -> L65
            java.lang.Object[] r7 = r6.f9029b     // Catch: java.lang.Throwable -> L65
            if (r7 == 0) goto L3a
            java.lang.String r1 = r6.f9028a     // Catch: java.lang.Throwable -> L65
            r5.execSQL(r1, r7)     // Catch: java.lang.Throwable -> L65
            goto L3f
        L3a:
            java.lang.String r7 = r6.f9028a     // Catch: java.lang.Throwable -> L65
            r5.execSQL(r7)     // Catch: java.lang.Throwable -> L65
        L3f:
            java.lang.String r6 = r6.f9028a     // Catch: java.lang.Throwable -> L65
            java.lang.String r7 = "INSERT"
            boolean r6 = r6.contains(r7)     // Catch: java.lang.Throwable -> L65
            if (r6 == 0) goto L20
            int r6 = r4.f9025a     // Catch: java.lang.Throwable -> L65
            r7 = 1
            int r6 = r6 + r7
            r4.f9025a = r6     // Catch: java.lang.Throwable -> L65
            r1 = 4000(0xfa0, float:5.605E-42)
            if (r6 <= r1) goto L20
            java.lang.String r6 = "DBHelper"
            java.lang.String r1 = "db is full!"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L65
            com.taobao.accs.utl.ALog.d(r6, r1, r2)     // Catch: java.lang.Throwable -> L65
            r4.onUpgrade(r5, r0, r7)     // Catch: java.lang.Throwable -> L65
            r4.f9025a = r0     // Catch: java.lang.Throwable -> L65
        L61:
            r5.close()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            goto L78
        L65:
            r6 = move-exception
            r5.close()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
            throw r6     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
        L6a:
            r5 = move-exception
            goto L7a
        L6c:
            r5 = move-exception
            java.lang.String r6 = "DBHelper"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6a
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L6a
            com.taobao.accs.utl.ALog.d(r6, r5, r7)     // Catch: java.lang.Throwable -> L6a
        L78:
            monitor-exit(r4)
            return
        L7a:
            monitor-exit(r4)
            goto L7d
        L7c:
            throw r5
        L7d:
            goto L7c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.b.a.a(java.lang.String, java.lang.Object[], boolean):void");
    }
}
