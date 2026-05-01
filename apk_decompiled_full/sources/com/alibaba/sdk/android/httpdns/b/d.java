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
    */
    private List<g> b(long j10) {
        SQLiteDatabase sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            try {
                cursor = sQLiteDatabase.query("ipv6", null, "host_id=?", new String[]{String.valueOf(j10)}, null, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    do {
                        g gVar = new g();
                        gVar.id = cursor.getInt(cursor.getColumnIndex("id"));
                        gVar.f5854i = cursor.getInt(cursor.getColumnIndex("host_id"));
                        gVar.f5855o = cursor.getString(cursor.getColumnIndex("ip"));
                        gVar.f5856p = cursor.getString(cursor.getColumnIndex("ttl"));
                        arrayList.add(gVar);
                    } while (cursor.moveToNext());
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception unused) {
                if (cursor != null) {
                    cursor.close();
                }
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
        return arrayList;
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
    */
    private List<g> a(long j10) {
        SQLiteDatabase sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            try {
                cursor = sQLiteDatabase.query("ip", null, "host_id=?", new String[]{String.valueOf(j10)}, null, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    do {
                        g gVar = new g();
                        gVar.id = cursor.getInt(cursor.getColumnIndex("id"));
                        gVar.f5854i = cursor.getInt(cursor.getColumnIndex("host_id"));
                        gVar.f5855o = cursor.getString(cursor.getColumnIndex("ip"));
                        gVar.f5856p = cursor.getString(cursor.getColumnIndex("ttl"));
                        arrayList.add(gVar);
                    } while (cursor.moveToNext());
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception unused) {
                if (cursor != null) {
                    cursor.close();
                }
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
        return arrayList;
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
