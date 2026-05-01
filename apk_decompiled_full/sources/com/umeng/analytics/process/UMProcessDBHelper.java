package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.hpplay.cybergarage.soap.SOAP;
import com.umeng.analytics.pro.s;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.a;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    public class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i10) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = com.umeng.analytics.process.a.f10618c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.f10619d, ""), (JSONArray) obj);
            return true;
        }
    }

    public class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i10) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = com.umeng.analytics.process.a.f10618c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.f10619d, ""));
            return true;
        }
    }

    public class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        int f10607a;

        /* renamed from: b, reason: collision with root package name */
        String f10608b;

        /* renamed from: c, reason: collision with root package name */
        String f10609c;

        /* renamed from: d, reason: collision with root package name */
        String f10610d;

        /* renamed from: e, reason: collision with root package name */
        int f10611e;

        /* renamed from: f, reason: collision with root package name */
        String f10612f;

        /* renamed from: g, reason: collision with root package name */
        String f10613g;

        /* renamed from: h, reason: collision with root package name */
        String f10614h;

        private a() {
        }
    }

    private UMProcessDBHelper() {
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                a aVar = new a();
                aVar.f10609c = jSONObject.optString("id");
                aVar.f10613g = UMUtils.getAppVersionName(this.mContext);
                aVar.f10614h = UMUtils.getAppVersionCode(this.mContext);
                aVar.f10608b = jSONObject.optString("__i");
                aVar.f10611e = jSONObject.optInt("__t");
                aVar.f10612f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.f10610d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(String str, List<a> list) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a10 = c.a(this.mContext).a(str);
            try {
                try {
                    a10.beginTransaction();
                    for (a aVar : list) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("__i", aVar.f10608b);
                            contentValues.put("__e", aVar.f10609c);
                            contentValues.put("__t", Integer.valueOf(aVar.f10611e));
                            contentValues.put(a.InterfaceC0174a.f10629f, aVar.f10612f);
                            contentValues.put("__av", aVar.f10613g);
                            contentValues.put("__vc", aVar.f10614h);
                            contentValues.put("__s", aVar.f10610d);
                            a10.insert(a.InterfaceC0174a.f10624a, null, contentValues);
                        } catch (Exception unused) {
                        }
                    }
                    a10.setTransactionSuccessful();
                    try {
                        a10.endTransaction();
                    } catch (Throwable unused2) {
                    }
                    c.a(this.mContext).b(str);
                    return true;
                } catch (Exception unused3) {
                    sQLiteDatabase = a10;
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused4) {
                        }
                    }
                    c.a(this.mContext).b(str);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = a10;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.f10623h, readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00aa, code lost:
    
        if (r2 != null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c2 A[Catch: Exception -> 0x00c5, TRY_LEAVE, TryCatch #6 {Exception -> 0x00c5, blocks: (B:37:0x00bd, B:31:0x00c2), top: B:36:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.umeng.analytics.process.UMProcessDBHelper$1] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<a> readEventByProcess(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Exception e10;
        ArrayList arrayList = new ArrayList();
        ?? r12 = 0;
        r12 = 0;
        try {
            try {
                sQLiteDatabase = c.a(this.mContext).a(str);
            } catch (Exception unused) {
            }
        } catch (Exception e11) {
            cursor = null;
            e10 = e11;
            sQLiteDatabase = null;
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            sQLiteDatabase.beginTransaction();
            cursor = sQLiteDatabase.query(a.InterfaceC0174a.f10624a, null, null, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            a aVar = new a();
                            aVar.f10607a = cursor.getInt(0);
                            aVar.f10608b = cursor.getString(cursor.getColumnIndex("__i"));
                            aVar.f10609c = cursor.getString(cursor.getColumnIndex("__e"));
                            aVar.f10610d = cursor.getString(cursor.getColumnIndex("__s"));
                            aVar.f10611e = cursor.getInt(cursor.getColumnIndex("__t"));
                            aVar.f10612f = cursor.getString(cursor.getColumnIndex(a.InterfaceC0174a.f10629f));
                            aVar.f10613g = cursor.getString(cursor.getColumnIndex("__av"));
                            aVar.f10614h = cursor.getString(cursor.getColumnIndex("__vc"));
                            arrayList.add(aVar);
                        } catch (Exception e12) {
                            e10 = e12;
                            e10.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r12 = cursor;
                        if (r12 != 0) {
                            try {
                                r12.close();
                            } catch (Exception unused2) {
                                c.a(this.mContext).b(str);
                                throw th;
                            }
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        c.a(this.mContext).b(str);
                        throw th;
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e13) {
            cursor = null;
            e10 = e13;
        } catch (Throwable th3) {
            th = th3;
            if (r12 != 0) {
            }
            if (sQLiteDatabase != null) {
            }
            c.a(this.mContext).b(str);
            throw th;
        }
        sQLiteDatabase.endTransaction();
        c.a(this.mContext).b(str);
        return arrayList;
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void deleteEventDatas(String str, String str2, List<a> list) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            sQLiteDatabase = null;
            th = th2;
        }
        try {
            sQLiteDatabase.beginTransaction();
            int size = list.size();
            if (size > 0) {
                for (int i10 = 0; i10 < size; i10++) {
                    sQLiteDatabase.execSQL("delete from __et_p where rowid=" + list.get(i10).f10607a);
                }
            } else {
                sQLiteDatabase.delete(a.InterfaceC0174a.f10624a, null, null);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Exception unused2) {
            sQLiteDatabase2 = sQLiteDatabase;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
            c.a(this.mContext).b(str);
        } catch (Throwable th3) {
            th = th3;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b(str);
            throw th;
        }
        c.a(this.mContext).b(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
    
        if (r1 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void deleteMainProcessEventDatasByIds(List<Integer> list) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.f10623h);
            sQLiteDatabase.beginTransaction();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.delete(a.InterfaceC0174a.f10624a, "id=?", new String[]{String.valueOf(it.next())});
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b(com.umeng.analytics.process.a.f10623h);
            throw th;
        }
        sQLiteDatabase.endTransaction();
        c.a(this.mContext).b(com.umeng.analytics.process.a.f10623h);
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject readMainEvents(long j10, List<Integer> list) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        JSONObject jSONObject = new JSONObject();
        Cursor cursor2 = null;
        cursor2 = null;
        cursor2 = null;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            try {
                sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.f10623h);
            } catch (Throwable unused) {
            }
            try {
                sQLiteDatabase.beginTransaction();
                cursor2 = sQLiteDatabase.query(a.InterfaceC0174a.f10624a, null, null, null, null, null, null);
                if (cursor2 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    String str = "";
                    while (cursor2.moveToNext()) {
                        int i10 = cursor2.getInt(cursor2.getColumnIndex("id"));
                        int i11 = cursor2.getInt(cursor2.getColumnIndex("__t"));
                        String string = cursor2.getString(cursor2.getColumnIndex("__i"));
                        String string2 = cursor2.getString(cursor2.getColumnIndex("__s"));
                        String string3 = cursor2.getString(cursor2.getColumnIndex(a.InterfaceC0174a.f10629f));
                        String string4 = cursor2.getString(cursor2.getColumnIndex("__av"));
                        if (!TextUtils.isEmpty(string)) {
                            if (TextUtils.isEmpty(str)) {
                                str = string4;
                            }
                            if (!TextUtils.isEmpty(string2) && i11 == 2049) {
                                JSONObject jSONObject3 = new JSONObject(com.umeng.common.a.a().b(string2));
                                String optString = jSONObject3.optString("pn");
                                if (TextUtils.isEmpty(optString) || "unknown".equals(optString)) {
                                    jSONObject3.put("pn", this.mContext.getPackageName() + SOAP.DELIM + string3);
                                }
                                JSONArray optJSONArray = jSONObject2.has(string) ? jSONObject2.optJSONArray(string) : new JSONArray();
                                if (s.a(jSONObject3) + s.a(optJSONArray) <= j10 && str.equalsIgnoreCase(string4)) {
                                    list.add(Integer.valueOf(i10));
                                    optJSONArray.put(jSONObject3);
                                    jSONObject2.put(string, optJSONArray);
                                }
                            }
                        }
                    }
                    if (jSONObject2.length() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            JSONObject jSONObject4 = new JSONObject();
                            String next = keys.next();
                            jSONObject4.put(next, new JSONArray(jSONObject2.optString(next)));
                            if (jSONObject4.length() > 0) {
                                jSONArray.put(jSONObject4);
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put("ekv", jSONArray);
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (cursor2 != null) {
                    cursor2.close();
                }
                sQLiteDatabase.endTransaction();
            } catch (Exception unused2) {
                cursor = cursor2;
                sQLiteDatabase2 = sQLiteDatabase;
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建子进程事件数据异常，清除数据库数据。");
                    sQLiteDatabase2.execSQL("delete from __et_p");
                    sQLiteDatabase2.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                    sQLiteDatabase2.endTransaction();
                    c.a(this.mContext).b(com.umeng.analytics.process.a.f10623h);
                    return jSONObject;
                } catch (Throwable th) {
                    th = th;
                    Cursor cursor3 = cursor;
                    sQLiteDatabase = sQLiteDatabase2;
                    cursor2 = cursor3;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused3) {
                        }
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.f10623h);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                c.a(this.mContext).b(com.umeng.analytics.process.a.f10623h);
                throw th;
            }
        } catch (Exception unused4) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
        c.a(this.mContext).b(com.umeng.analytics.process.a.f10623h);
        return jSONObject;
    }

    public JSONObject readVersionInfoFromColumId(Integer num) {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.f10623h);
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor query = sQLiteDatabase.query(a.InterfaceC0174a.f10624a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (query != null) {
                        try {
                            try {
                                if (query.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = query.getString(query.getColumnIndex("__av"));
                                        String string2 = query.getString(query.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e10) {
                                        e = e10;
                                        cursor = query;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.f10623h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f10623h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Exception e11) {
                                e = e11;
                                jSONObject = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = query;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception unused2) {
                                    c.a(this.mContext).b(com.umeng.analytics.process.a.f10623h);
                                    throw th;
                                }
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            c.a(this.mContext).b(com.umeng.analytics.process.a.f10623h);
                            throw th;
                        }
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception unused3) {
                        }
                    }
                    sQLiteDatabase.endTransaction();
                    c.a(this.mContext).b(com.umeng.analytics.process.a.f10623h);
                    return jSONObject2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e12) {
                e = e12;
                jSONObject = null;
            }
        } catch (Exception e13) {
            e = e13;
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }
}
