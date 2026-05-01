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
import com.hpplay.component.protocol.push.IPushHandler;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.j;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
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
    */
    public ArrayList<MsgDO> b() {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        ArrayList<MsgDO> arrayList;
        int i10;
        int i11;
        try {
            sQLiteDatabase = this.f17866b.getReadableDatabase();
        } catch (Throwable th) {
            th = th;
            cursor = null;
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Throwable th2) {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "getUnReportMsg close cursor or db, e: " + th2, new Object[0]);
                    }
                }
            }
            return null;
        }
        try {
            arrayList = new ArrayList<>();
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select * from accs_message where state = ? or state = ? or state = ?", new String[]{"0", "2", "3"});
                if (rawQuery != null) {
                    try {
                        int columnIndex = rawQuery.getColumnIndex("id");
                        int columnIndex2 = rawQuery.getColumnIndex(IPushHandler.STATE);
                        int columnIndex3 = rawQuery.getColumnIndex(Constants.SHARED_MESSAGE_ID_FILE);
                        int columnIndex4 = rawQuery.getColumnIndex("create_time");
                        while (rawQuery.moveToNext() && !TextUtils.isEmpty(rawQuery.getString(columnIndex3))) {
                            String string = rawQuery.getString(columnIndex2);
                            String string2 = rawQuery.getString(columnIndex3);
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                StringBuilder sb = new StringBuilder();
                                i11 = columnIndex2;
                                sb.append("state: ");
                                sb.append(string);
                                sb.append(" ,cursor.message:");
                                sb.append(string2);
                                sb.append(" ,cursor.id:");
                                sb.append(rawQuery.getString(columnIndex));
                                sb.append(" ,cursor.time:");
                                sb.append(rawQuery.getString(columnIndex4));
                                i10 = columnIndex;
                                ALog.i("MessageService", sb.toString(), new Object[0]);
                            } else {
                                i10 = columnIndex;
                                i11 = columnIndex2;
                            }
                            String str = TextUtils.equals("0", string) ? "4" : TextUtils.equals("2", string) ? MSG_ACCS_NOTIFY_CLICK : TextUtils.equals("3", string) ? MSG_ACCS_NOTIFY_DISMISS : null;
                            new MsgDO();
                            if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(str)) {
                                MsgDO b10 = b(string2, str);
                                b10.messageSource = "cache";
                                arrayList.add(b10);
                            }
                            columnIndex2 = i11;
                            columnIndex = i10;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = rawQuery;
                        try {
                            if (ALog.isPrintLog(ALog.Level.E)) {
                                ALog.e("MessageService", "getUnReportMsg, e: " + th, new Object[0]);
                            }
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable th4) {
                                    if (ALog.isPrintLog(ALog.Level.E)) {
                                        ALog.e("MessageService", "getUnReportMsg close cursor or db, e: " + th4, new Object[0]);
                                    }
                                }
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            return arrayList;
                        } finally {
                        }
                    }
                }
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Throwable th5) {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e("MessageService", "getUnReportMsg close cursor or db, e: " + th5, new Object[0]);
                        }
                    }
                }
                sQLiteDatabase.close();
            } catch (Throwable th6) {
                th = th6;
                cursor = null;
            }
        } catch (Throwable th7) {
            th = th7;
            cursor = null;
            arrayList = null;
            if (ALog.isPrintLog(ALog.Level.E)) {
            }
            if (cursor != null) {
            }
            if (sQLiteDatabase != null) {
            }
            return arrayList;
        }
        return arrayList;
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
    */
    public boolean a(String str) {
        SQLiteDatabase sQLiteDatabase;
        boolean z10;
        Cursor cursor = null;
        boolean z11 = false;
        try {
            boolean z12 = true;
            if (f17865c.get(str) != null) {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e("MessageService", "hasMessageDuplicate,msgid=" + str, new Object[0]);
                }
                z10 = true;
            } else {
                z10 = false;
            }
            try {
                sQLiteDatabase = this.f17866b.getReadableDatabase();
                if (sQLiteDatabase == null) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return z10;
                }
                try {
                    cursor = sQLiteDatabase.rawQuery("select count(1) from message where id = ?", new String[]{str});
                    if (cursor != null && cursor.moveToFirst()) {
                    }
                    z12 = z10;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable unused2) {
                            return z12;
                        }
                    }
                    sQLiteDatabase.close();
                    return z12;
                } catch (Throwable unused3) {
                    z11 = z10;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable unused4) {
                            return z11;
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return z11;
                }
            } catch (Throwable unused5) {
                sQLiteDatabase = null;
            }
        } catch (Throwable unused6) {
            sQLiteDatabase = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
    
        if (r0.getInt(0) > 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, int i10) {
        SQLiteDatabase sQLiteDatabase;
        boolean z10;
        Cursor cursor = null;
        boolean z11 = false;
        try {
            Integer num = f17865c.get(str);
            boolean z12 = true;
            if (num == null || i10 != num.intValue()) {
                z10 = false;
            } else {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e("MessageService", "hasMessageDuplicate,msgid=" + str, new Object[0]);
                }
                z10 = true;
            }
            try {
                sQLiteDatabase = this.f17866b.getReadableDatabase();
                if (sQLiteDatabase == null) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return z10;
                }
                try {
                    cursor = sQLiteDatabase.rawQuery("select count(1) from message where id = ? and body_code=? create_time< date('now','-1 day')", new String[]{str, "" + i10});
                    if (cursor != null && cursor.moveToFirst()) {
                    }
                    z12 = z10;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable unused2) {
                            return z12;
                        }
                    }
                    sQLiteDatabase.close();
                    return z12;
                } catch (Throwable unused3) {
                    z11 = z10;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable unused4) {
                            return z11;
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return z11;
                }
            } catch (Throwable unused5) {
                sQLiteDatabase = null;
            }
        } catch (Throwable unused6) {
            sQLiteDatabase = null;
        }
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
