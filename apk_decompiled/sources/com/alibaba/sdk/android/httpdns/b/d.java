package com.alibaba.sdk.android.httpdns.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.common.AgooConstants;

/* loaded from: classes.dex */
class d extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f5849a = new Object();

    public d(Context context) {
        super(context, "aliclound_httpdns.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private long a(SQLiteDatabase sQLiteDatabase, g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_id", Long.valueOf(gVar.f5854i));
        contentValues.put("ip", gVar.f5855o);
        contentValues.put("ttl", gVar.f5856p);
        try {
            return sQLiteDatabase.insert("ip", null, contentValues);
        } catch (Exception unused) {
            return 0L;
        }
    }

    private long b(SQLiteDatabase sQLiteDatabase, g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_id", Long.valueOf(gVar.f5854i));
        contentValues.put("ip", gVar.f5855o);
        contentValues.put("ttl", gVar.f5856p);
        try {
            return sQLiteDatabase.insert("ipv6", null, contentValues);
        } catch (Exception unused) {
            return 0L;
        }
    }

    private void c(long j10) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.delete("ipv6", "id = ?", new String[]{String.valueOf(j10)});
        } catch (Exception unused) {
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        sQLiteDatabase.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE host (id INTEGER PRIMARY KEY,host TEXT,sp TEXT,time TEXT,extra TEXT,cache_key TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE ip (id INTEGER PRIMARY KEY,host_id INTEGER,ip TEXT,ttl TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE ipv6 (id INTEGER PRIMARY KEY,host_id INTEGER,ip TEXT,ttl TEXT);");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 != i11) {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS host;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ip;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ipv6;");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                onCreate(sQLiteDatabase);
            } catch (Exception unused) {
            }
        }
    }

    private void c(e eVar) {
        m2a(eVar.id);
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m4a(e eVar) {
        SQLiteDatabase writableDatabase;
        synchronized (f5849a) {
            b(eVar.f5852m, eVar.host);
            ContentValues contentValues = new ContentValues();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                writableDatabase = getWritableDatabase();
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                writableDatabase.beginTransaction();
                contentValues.put(Constants.KEY_HOST, eVar.host);
                contentValues.put("sp", eVar.f5852m);
                contentValues.put(AgooConstants.MESSAGE_TIME, c.c(eVar.f5853n));
                contentValues.put("extra", eVar.f5850a);
                contentValues.put("cache_key", eVar.f5851b);
                long insert = writableDatabase.insert(Constants.KEY_HOST, null, contentValues);
                eVar.id = insert;
                ArrayList<g> arrayList = eVar.f7a;
                if (arrayList != null) {
                    Iterator<g> it = arrayList.iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        next.f5854i = insert;
                        next.id = a(writableDatabase, next);
                    }
                }
                ArrayList<g> arrayList2 = eVar.f8b;
                if (arrayList2 != null) {
                    Iterator<g> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        g next2 = it2.next();
                        next2.f5854i = insert;
                        next2.id = b(writableDatabase, next2);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                writableDatabase.close();
                return insert;
            } catch (Exception unused2) {
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                    sQLiteDatabase.close();
                }
                return 0L;
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
    }

    public List<e> b() {
        ArrayList arrayList;
        SQLiteDatabase sQLiteDatabase;
        synchronized (f5849a) {
            arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                sQLiteDatabase = getReadableDatabase();
                try {
                    cursor = sQLiteDatabase.query(Constants.KEY_HOST, null, null, null, null, null, null);
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        do {
                            e eVar = new e();
                            eVar.id = cursor.getInt(cursor.getColumnIndex("id"));
                            eVar.host = cursor.getString(cursor.getColumnIndex(Constants.KEY_HOST));
                            eVar.f5852m = cursor.getString(cursor.getColumnIndex("sp"));
                            eVar.f5853n = c.d(cursor.getString(cursor.getColumnIndex(AgooConstants.MESSAGE_TIME)));
                            eVar.f7a = (ArrayList) a(eVar);
                            eVar.f8b = (ArrayList) b(eVar);
                            eVar.f5850a = cursor.getString(cursor.getColumnIndex("extra"));
                            eVar.f5851b = cursor.getString(cursor.getColumnIndex("cache_key"));
                            arrayList.add(eVar);
                        } while (cursor.moveToNext());
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                sQLiteDatabase = null;
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = null;
            }
            sQLiteDatabase.close();
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008a, code lost:
    
        if (r10 != null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.alibaba.sdk.android.httpdns.b.g> b(long r12) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getWritableDatabase()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L83
            java.lang.String r3 = "ipv6"
            r4 = 0
            java.lang.String r5 = "host_id=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r13 = 0
            r6[r13] = r12     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r1 == 0) goto L6c
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r12 <= 0) goto L6c
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
        L2c:
            com.alibaba.sdk.android.httpdns.b.g r12 = new com.alibaba.sdk.android.httpdns.b.g     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r12.<init>()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r13 = "id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r12.id = r2     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r13 = "host_id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r12.f5854i = r2     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r13 = "ip"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r12.f5855o = r13     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r13 = "ttl"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r12.f5856p = r13     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r0.add(r12)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r12 != 0) goto L2c
        L6c:
            if (r1 == 0) goto L8c
            r1.close()
            goto L8c
        L72:
            r12 = move-exception
            goto L78
        L74:
            goto L85
        L76:
            r12 = move-exception
            r10 = r1
        L78:
            if (r1 == 0) goto L7d
            r1.close()
        L7d:
            if (r10 == 0) goto L82
            r10.close()
        L82:
            throw r12
        L83:
            r10 = r1
        L85:
            if (r1 == 0) goto L8a
            r1.close()
        L8a:
            if (r10 == 0) goto L8f
        L8c:
            r10.close()
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.b(long):java.util.List");
    }

    public e a(String str, String str2) {
        SQLiteDatabase sQLiteDatabase;
        e eVar;
        e eVar2;
        synchronized (f5849a) {
            Cursor cursor = null;
            eVar2 = null;
            eVar2 = null;
            r1 = null;
            cursor = null;
            Cursor cursor2 = null;
            try {
                try {
                    sQLiteDatabase = getReadableDatabase();
                    try {
                        Cursor query = sQLiteDatabase.query(Constants.KEY_HOST, null, "sp=? AND host=?", new String[]{str, str2}, null, null, null);
                        if (query != null) {
                            try {
                                try {
                                    if (query.getCount() > 0) {
                                        query.moveToFirst();
                                        eVar = new e();
                                        try {
                                            eVar.id = query.getInt(query.getColumnIndex("id"));
                                            eVar.host = query.getString(query.getColumnIndex(Constants.KEY_HOST));
                                            eVar.f5852m = query.getString(query.getColumnIndex("sp"));
                                            eVar.f5853n = c.d(query.getString(query.getColumnIndex(AgooConstants.MESSAGE_TIME)));
                                            eVar.f7a = (ArrayList) a(eVar);
                                            eVar.f8b = (ArrayList) b(eVar);
                                            eVar.f5850a = query.getString(query.getColumnIndex("extra"));
                                            eVar.f5851b = query.getString(query.getColumnIndex("cache_key"));
                                            eVar2 = eVar;
                                        } catch (Exception unused) {
                                            cursor2 = query;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.close();
                                            }
                                            eVar2 = eVar;
                                            return eVar2;
                                        }
                                    }
                                } catch (Exception unused2) {
                                    eVar = null;
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor = query;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        }
                        if (query != null) {
                            query.close();
                        }
                        sQLiteDatabase.close();
                    } catch (Exception unused3) {
                        eVar = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } finally {
                }
            } catch (Exception unused4) {
                eVar = null;
                sQLiteDatabase = null;
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
            }
        }
        return eVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008a, code lost:
    
        if (r10 != null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.alibaba.sdk.android.httpdns.b.g> a(long r12) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getWritableDatabase()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L83
            java.lang.String r3 = "ip"
            r4 = 0
            java.lang.String r5 = "host_id=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r13 = 0
            r6[r13] = r12     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r1 == 0) goto L6c
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r12 <= 0) goto L6c
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
        L2c:
            com.alibaba.sdk.android.httpdns.b.g r12 = new com.alibaba.sdk.android.httpdns.b.g     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r12.<init>()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r13 = "id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r12.id = r2     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r13 = "host_id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r12.f5854i = r2     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r13 = "ip"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r12.f5855o = r13     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r13 = "ttl"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r12.f5856p = r13     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r0.add(r12)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r12 != 0) goto L2c
        L6c:
            if (r1 == 0) goto L8c
            r1.close()
            goto L8c
        L72:
            r12 = move-exception
            goto L78
        L74:
            goto L85
        L76:
            r12 = move-exception
            r10 = r1
        L78:
            if (r1 == 0) goto L7d
            r1.close()
        L7d:
            if (r10 == 0) goto L82
            r10.close()
        L82:
            throw r12
        L83:
            r10 = r1
        L85:
            if (r1 == 0) goto L8a
            r1.close()
        L8a:
            if (r10 == 0) goto L8f
        L8c:
            r10.close()
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.a(long):java.util.List");
    }

    private List<g> b(e eVar) {
        return b(eVar.id);
    }

    private List<g> a(e eVar) {
        return a(eVar.id);
    }

    /* renamed from: b, reason: collision with other method in class */
    private void m3b(long j10) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.delete("ip", "id = ?", new String[]{String.valueOf(j10)});
        } catch (Exception unused) {
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        sQLiteDatabase.close();
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m2a(long j10) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.delete(Constants.KEY_HOST, "id = ?", new String[]{String.valueOf(j10)});
        } catch (Exception unused) {
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        sQLiteDatabase.close();
    }

    private void b(g gVar) {
        c(gVar.id);
    }

    private void a(g gVar) {
        m3b(gVar.id);
    }

    public void b(String str, String str2) {
        synchronized (f5849a) {
            e a10 = a(str, str2);
            if (a10 != null) {
                c(a10);
                ArrayList<g> arrayList = a10.f7a;
                if (arrayList != null) {
                    Iterator<g> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a(it.next());
                    }
                }
                ArrayList<g> arrayList2 = a10.f8b;
                if (arrayList2 != null) {
                    Iterator<g> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        b(it2.next());
                    }
                }
            }
        }
    }
}
