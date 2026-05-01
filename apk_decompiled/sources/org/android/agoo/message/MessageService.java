package org.android.agoo.message;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import c8.b;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.j;
import com.umeng.analytics.pro.bt;
import m7.f;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MessageService {
    public static final String MSG_ACCS_NOTIFY_CLICK = "8";
    public static final String MSG_ACCS_NOTIFY_DISMISS = "9";
    public static final String MSG_ACCS_READY_REPORT = "4";
    public static final String MSG_DB_COMPLETE = "100";
    public static final String MSG_DB_NOTIFY_CLICK = "2";
    public static final String MSG_DB_NOTIFY_DISMISS = "3";
    public static final String MSG_DB_NOTIFY_REACHED = "1";
    public static final String MSG_DB_READY_REPORT = "0";

    /* renamed from: a, reason: collision with root package name */
    private static Context f17864a;

    /* renamed from: c, reason: collision with root package name */
    private static LruCache<String, Integer> f17865c;

    /* renamed from: b, reason: collision with root package name */
    private volatile SQLiteOpenHelper f17866b = null;

    public static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "message_accs_db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        private String a() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("create table accs_message");
            stringBuffer.append("(");
            stringBuffer.append("id text UNIQUE not null,");
            stringBuffer.append("state text,");
            stringBuffer.append("message text,");
            stringBuffer.append("create_time date");
            stringBuffer.append(");");
            return stringBuffer.toString();
        }

        private String b() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("create table message");
            stringBuffer.append("(");
            stringBuffer.append("id text UNIQUE not null,");
            stringBuffer.append("state integer,");
            stringBuffer.append("body_code integer,");
            stringBuffer.append("report long,");
            stringBuffer.append("target_time long,");
            stringBuffer.append("interval integer,");
            stringBuffer.append("type text,");
            stringBuffer.append("message text,");
            stringBuffer.append("notify integer,");
            stringBuffer.append("create_time date");
            stringBuffer.append(");");
            return stringBuffer.toString();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (j.a(super.getWritableDatabase().getPath(), 102400)) {
                return super.getWritableDatabase();
            }
            return null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL(b());
                    sQLiteDatabase.execSQL("CREATE INDEX id_index ON message(id)");
                    sQLiteDatabase.execSQL("CREATE INDEX body_code_index ON message(body_code)");
                    sQLiteDatabase.execSQL(a());
                } catch (Throwable th) {
                    ALog.e("MessageService", "messagedbhelper create", th, new Object[0]);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
                } catch (Throwable th) {
                    try {
                        ALog.e("MessageService", "messagedbhelper create", th, new Object[0]);
                        try {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                            sQLiteDatabase.execSQL(a());
                            return;
                        } catch (Throwable th2) {
                            ALog.e("MessageService", "MessageService onUpgrade is error", th2, new Object[0]);
                            return;
                        }
                    } catch (Throwable th3) {
                        try {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                            sQLiteDatabase.execSQL(a());
                        } catch (Throwable th4) {
                            ALog.e("MessageService", "MessageService onUpgrade is error", th4, new Object[0]);
                        }
                        throw th3;
                    }
                }
            }
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                sQLiteDatabase.execSQL(a());
            } catch (Throwable th5) {
                ALog.e("MessageService", "MessageService onUpgrade is error", th5, new Object[0]);
            }
        }
    }

    public void a(Context context) {
        f17865c = new LruCache<>(100);
        f17864a = context;
        this.f17866b = new a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x014b A[Catch: all -> 0x018e, TRY_LEAVE, TryCatch #7 {all -> 0x018e, blocks: (B:66:0x0143, B:68:0x014b), top: B:65:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016c A[Catch: all -> 0x0168, TRY_LEAVE, TryCatch #2 {all -> 0x0168, blocks: (B:80:0x0164, B:72:0x016c), top: B:79:0x0164 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<org.android.agoo.common.MsgDO> b() {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.b():java.util.ArrayList");
    }

    public void a(String str, String str2) {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("MessageService", "updateAccsMessage sqlite3--->[" + str + ",state=" + str2 + "]", new Object[0]);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
        } catch (Throwable th) {
            try {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e("MessageService", "updateAccsMessage error,e--->[" + th + "],ex=" + th.getStackTrace().toString(), new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", j.b(f17864a), "updateAccsMessageFailed", th.toString());
                if (0 == 0) {
                    return;
                }
            } finally {
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            sQLiteDatabase = this.f17866b.getWritableDatabase();
            if (sQLiteDatabase == null) {
                if (sQLiteDatabase != null) {
                    return;
                } else {
                    return;
                }
            }
            if (TextUtils.equals(str2, "1")) {
                sQLiteDatabase.execSQL("UPDATE accs_message set state = ? where id = ? and state = ?", new Object[]{str2, str, "0"});
            } else {
                sQLiteDatabase.execSQL("UPDATE accs_message set state = ? where id = ?", new Object[]{str2, str});
            }
            sQLiteDatabase.close();
        }
    }

    public void a(String str, String str2, String str3) {
        Cursor cursor;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("MessageService", "addAccsMessage sqlite3--->[" + str + ",message=" + str2 + ",state=" + str3 + "]", new Object[0]);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                SQLiteDatabase writableDatabase = this.f17866b.getWritableDatabase();
                if (writableDatabase == null) {
                    if (writableDatabase != null) {
                        writableDatabase.close();
                        return;
                    }
                    return;
                }
                try {
                    Cursor rawQuery = writableDatabase.rawQuery("select count(1) from accs_message where id = ?", new String[]{str});
                    if (rawQuery != null && rawQuery.moveToFirst() && rawQuery.getInt(0) > 0) {
                        rawQuery.close();
                        rawQuery.close();
                        writableDatabase.close();
                    } else {
                        writableDatabase.execSQL("INSERT INTO accs_message VALUES(?,?,?,date('now'))", new Object[]{str, str3, str2});
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        writableDatabase.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    sQLiteDatabase = writableDatabase;
                    try {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e("MessageService", "addAccsMessage error,e--->[" + th + "],ex=" + a(th), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", j.b(f17864a), "addAccsMessageFailed", th.toString());
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private String a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement.toString());
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    private MsgDO b(String str, String str2) {
        boolean z10;
        ALog.Level level = ALog.Level.I;
        if (ALog.isPrintLog(level)) {
            ALog.i("MessageService", "msgRecevie,message--->[" + str + "],utdid=" + j.b(f17864a), new Object[0]);
        }
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", j.b(f17864a), "message==null");
            if (ALog.isPrintLog(level)) {
                ALog.i("MessageService", "handleMessage message==null,utdid=" + j.b(f17864a), new Object[0]);
            }
            return null;
        }
        MsgDO msgDO = new MsgDO();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            new Bundle();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (jSONObject != null) {
                    String string = jSONObject.getString(bt.aD);
                    String string2 = jSONObject.getString(bt.aI);
                    String string3 = jSONObject.getString(b.f5629b);
                    long j10 = jSONObject.getLong(f.f16828a);
                    if (!jSONObject.isNull("ext")) {
                        str3 = jSONObject.getString("ext");
                    }
                    int i11 = length - 1;
                    msgDO.msgIds = string2;
                    msgDO.extData = str3;
                    msgDO.messageSource = "accs";
                    msgDO.type = "cache";
                    if (TextUtils.isEmpty(string3)) {
                        msgDO.errorCode = AgooConstants.ACK_BODY_NULL;
                    } else if (TextUtils.isEmpty(string)) {
                        msgDO.errorCode = AgooConstants.ACK_PACK_NULL;
                    } else if (j10 == -1) {
                        msgDO.errorCode = AgooConstants.ACK_FLAG_NULL;
                    } else if (!a(f17864a, string)) {
                        ALog.d("MessageService", "ondata checkpackage is del,pack=" + string, new Object[0]);
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", j.b(f17864a), "deletePack", string);
                        msgDO.removePacks = string;
                    } else {
                        String string4 = a(j10, msgDO).getString(AgooConstants.MESSAGE_ENCRYPTED);
                        if (!f17864a.getPackageName().equals(string)) {
                            z10 = true;
                        } else if (TextUtils.equals(Integer.toString(0), string4) || TextUtils.equals(Integer.toString(4), string4)) {
                            z10 = false;
                        } else {
                            msgDO.errorCode = AgooConstants.ACK_PACK_ERROR;
                            ALog.e("MessageService", "error encrypted: " + string4, new Object[0]);
                        }
                        msgDO.agooFlag = z10;
                        if (!TextUtils.isEmpty(str2)) {
                            msgDO.msgStatus = str2;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("MessageService", "createMsg is error,e: " + th, new Object[0]);
            }
        }
        return msgDO;
    }

    public void a(String str, String str2, String str3, int i10) {
        a(str, str2, str3, 1, -1L, -1, i10);
    }

    private void a(String str, String str2, String str3, int i10, long j10, int i11, int i12) {
        Throwable th;
        int hashCode;
        String str4;
        StringBuilder sb = new StringBuilder();
        sb.append("add sqlite3--->[");
        sb.append(str);
        sb.append("]");
        ALog.d("MessageService", sb.toString(), new Object[0]);
        SQLiteClosable sQLiteClosable = null;
        try {
            String str5 = "";
            if (TextUtils.isEmpty(str2)) {
                str4 = "";
                hashCode = -1;
            } else {
                hashCode = str2.hashCode();
                str4 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                str5 = str3;
            }
            if (f17865c.get(str) == null) {
                f17865c.put(str, Integer.valueOf(hashCode));
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i("MessageService", "addMessage,messageId=" + str + ", mCache size:" + f17865c.size(), new Object[0]);
                }
            }
            try {
                SQLiteDatabase writableDatabase = this.f17866b.getWritableDatabase();
                if (writableDatabase == null) {
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.close();
                            return;
                        } catch (Throwable th2) {
                            if (ALog.isPrintLog(ALog.Level.E)) {
                                ALog.e("MessageService", "addMessage,db.close(),error,e--->[" + th2 + "]", new Object[0]);
                            }
                            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", j.b(f17864a), "addMessageDBcloseFailed", th2.toString());
                            return;
                        }
                    }
                    return;
                }
                writableDatabase.execSQL("INSERT INTO message VALUES(?,?,?,?,?,?,?,?,?,date('now'))", new Object[]{str, Integer.valueOf(i10), Integer.valueOf(hashCode), 0, Long.valueOf(j10), Integer.valueOf(i11), str5, str4, Integer.valueOf(i12)});
                try {
                    writableDatabase.close();
                } catch (Throwable th3) {
                    th = th3;
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "addMessage,db.close(),error,e--->[" + th + "]", new Object[0]);
                    }
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", j.b(f17864a), "addMessageDBcloseFailed", th.toString());
                }
            } catch (Throwable th4) {
                th = th4;
                try {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "addMessage error,e--->[" + th + "]", new Object[0]);
                    }
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", j.b(f17864a), "addMessageFailed", th.toString());
                    if (0 != 0) {
                        try {
                            sQLiteClosable.close();
                        } catch (Throwable th5) {
                            th = th5;
                            if (ALog.isPrintLog(ALog.Level.E)) {
                                ALog.e("MessageService", "addMessage,db.close(),error,e--->[" + th + "]", new Object[0]);
                            }
                            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", j.b(f17864a), "addMessageDBcloseFailed", th.toString());
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void a() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.f17866b.getWritableDatabase();
        } catch (Throwable th) {
            try {
                ALog.e("MessageService", "deleteCacheMessage sql Throwable", th, new Object[0]);
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
        if (sQLiteDatabase == null) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            return;
        }
        sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
        sQLiteDatabase.execSQL("delete from accs_message where create_time< date('now','-1 day') ");
        try {
            sQLiteDatabase.close();
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r0.getInt(0) > 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            android.util.LruCache<java.lang.String, java.lang.Integer> r2 = org.android.agoo.message.MessageService.f17865c     // Catch: java.lang.Throwable -> L64
            java.lang.Object r2 = r2.get(r7)     // Catch: java.lang.Throwable -> L64
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L64
            r3 = 1
            if (r2 == 0) goto L2f
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.E     // Catch: java.lang.Throwable -> L64
            boolean r2 = com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L2d
            java.lang.String r2 = "MessageService"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r4.<init>()     // Catch: java.lang.Throwable -> L64
            java.lang.String r5 = "hasMessageDuplicate,msgid="
            r4.append(r5)     // Catch: java.lang.Throwable -> L64
            r4.append(r7)     // Catch: java.lang.Throwable -> L64
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L64
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L64
            com.taobao.accs.utl.ALog.e(r2, r4, r5)     // Catch: java.lang.Throwable -> L64
        L2d:
            r2 = 1
            goto L30
        L2f:
            r2 = 0
        L30:
            android.database.sqlite.SQLiteOpenHelper r4 = r6.f17866b     // Catch: java.lang.Throwable -> L61
            android.database.sqlite.SQLiteDatabase r4 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L61
            if (r4 != 0) goto L3e
            if (r4 == 0) goto L3d
            r4.close()     // Catch: java.lang.Throwable -> L3d
        L3d:
            return r2
        L3e:
            java.lang.String r5 = "select count(1) from message where id = ?"
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch: java.lang.Throwable -> L62
            android.database.Cursor r0 = r4.rawQuery(r5, r7)     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L57
            boolean r7 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L62
            if (r7 == 0) goto L57
            int r7 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L62
            if (r7 <= 0) goto L57
            goto L58
        L57:
            r3 = r2
        L58:
            if (r0 == 0) goto L5d
            r0.close()     // Catch: java.lang.Throwable -> L70
        L5d:
            r4.close()     // Catch: java.lang.Throwable -> L70
            goto L70
        L61:
            r4 = r0
        L62:
            r1 = r2
            goto L65
        L64:
            r4 = r0
        L65:
            if (r0 == 0) goto L6a
            r0.close()     // Catch: java.lang.Throwable -> L6f
        L6a:
            if (r4 == 0) goto L6f
            r4.close()     // Catch: java.lang.Throwable -> L6f
        L6f:
            r3 = r1
        L70:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
    
        if (r0.getInt(0) > 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r9, int r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            android.util.LruCache<java.lang.String, java.lang.Integer> r2 = org.android.agoo.message.MessageService.f17865c     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r2 = r2.get(r9)     // Catch: java.lang.Throwable -> L7e
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L7e
            r3 = 1
            if (r2 == 0) goto L35
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            if (r10 != r2) goto L35
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.E     // Catch: java.lang.Throwable -> L7e
            boolean r2 = com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch: java.lang.Throwable -> L7e
            if (r2 == 0) goto L33
            java.lang.String r2 = "MessageService"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e
            r4.<init>()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r5 = "hasMessageDuplicate,msgid="
            r4.append(r5)     // Catch: java.lang.Throwable -> L7e
            r4.append(r9)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L7e
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L7e
            com.taobao.accs.utl.ALog.e(r2, r4, r5)     // Catch: java.lang.Throwable -> L7e
        L33:
            r2 = 1
            goto L36
        L35:
            r2 = 0
        L36:
            android.database.sqlite.SQLiteOpenHelper r4 = r8.f17866b     // Catch: java.lang.Throwable -> L7b
            android.database.sqlite.SQLiteDatabase r4 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L7b
            if (r4 != 0) goto L44
            if (r4 == 0) goto L43
            r4.close()     // Catch: java.lang.Throwable -> L43
        L43:
            return r2
        L44:
            java.lang.String r5 = "select count(1) from message where id = ? and body_code=? create_time< date('now','-1 day')"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L7c
            r6[r1] = r9     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r9.<init>()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = ""
            r9.append(r7)     // Catch: java.lang.Throwable -> L7c
            r9.append(r10)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L7c
            r6[r3] = r9     // Catch: java.lang.Throwable -> L7c
            android.database.Cursor r0 = r4.rawQuery(r5, r6)     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L71
            boolean r9 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L7c
            if (r9 == 0) goto L71
            int r9 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L7c
            if (r9 <= 0) goto L71
            goto L72
        L71:
            r3 = r2
        L72:
            if (r0 == 0) goto L77
            r0.close()     // Catch: java.lang.Throwable -> L8a
        L77:
            r4.close()     // Catch: java.lang.Throwable -> L8a
            goto L8a
        L7b:
            r4 = r0
        L7c:
            r1 = r2
            goto L7f
        L7e:
            r4 = r0
        L7f:
            if (r0 == 0) goto L84
            r0.close()     // Catch: java.lang.Throwable -> L89
        L84:
            if (r4 == 0) goto L89
            r4.close()     // Catch: java.lang.Throwable -> L89
        L89:
            r3 = r1
        L8a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a(java.lang.String, int):boolean");
    }

    public static final boolean a(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    private static Bundle a(long j10, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j10).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb.toString());
                    if (charArray[6] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_REPORT, "1");
                        msgDO.reportStr = "1";
                    }
                    if (charArray[7] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_NOTIFICATION, "1");
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, "1");
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, "1");
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }
}
