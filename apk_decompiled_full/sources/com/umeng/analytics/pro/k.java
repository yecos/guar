package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final int f10420a = 2049;

    /* renamed from: b, reason: collision with root package name */
    public static final int f10421b = 2050;

    /* renamed from: c, reason: collision with root package name */
    private static final int f10422c = 1000;

    /* renamed from: d, reason: collision with root package name */
    private static Context f10423d = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f10424e = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f10425f = "umeng+";

    /* renamed from: g, reason: collision with root package name */
    private static final String f10426g = "ek__id";

    /* renamed from: h, reason: collision with root package name */
    private static final String f10427h = "ek_key";

    /* renamed from: i, reason: collision with root package name */
    private List<String> f10428i;

    /* renamed from: j, reason: collision with root package name */
    private List<Integer> f10429j;

    /* renamed from: k, reason: collision with root package name */
    private String f10430k;

    /* renamed from: l, reason: collision with root package name */
    private List<String> f10431l;

    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final k f10439a = new k();

        private b() {
        }
    }

    public static k a(Context context) {
        k kVar = b.f10439a;
        if (f10423d == null && context != null) {
            f10423d = context.getApplicationContext();
            kVar.k();
        }
        return kVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.f10428i.clear();
            this.f10431l.clear();
            this.f10429j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(f10424e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(f10423d, f10426g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(f10423d).getString(f10426g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(f10423d, f10426g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String substring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i10 = 0; i10 < substring.length(); i10++) {
                        char charAt = substring.charAt(i10);
                        if (!Character.isDigit(charAt)) {
                            sb.append(charAt);
                        } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                        }
                    }
                    f10424e = sb.toString();
                }
                if (TextUtils.isEmpty(f10424e)) {
                    return;
                }
                f10424e += new StringBuilder(f10424e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(f10423d, f10427h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(f10423d, f10427h, c(f10425f));
                } else {
                    if (f10425f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.f10431l.clear();
    }

    public boolean c() {
        return this.f10431l.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
    
        if (r0 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        String c10;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = i.a(f10423d).a();
                sQLiteDatabase.beginTransaction();
                c10 = w.a().c();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(f10423d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(f10423d);
        } catch (Throwable unused3) {
        }
        if (TextUtils.isEmpty(c10)) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused4) {
            }
            i.a(f10423d).b();
            return;
        }
        String[] strArr = {"", "-1"};
        for (int i10 = 0; i10 < 2; i10++) {
            sQLiteDatabase.execSQL("update __et set __i=\"" + c10 + "\" where __i=\"" + strArr[i10] + "\"");
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    public boolean e() {
        return this.f10428i.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a3, code lost:
    
        if (r2 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0087, code lost:
    
        if (r2 != null) goto L56;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject f() {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        r3 = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        r3 = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.f10431l.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabase = i.a(f10423d).a();
            try {
                sQLiteDatabase.beginTransaction();
                Cursor a10 = a(g.c.f10374a, sQLiteDatabase, null, "__ii=? ", new String[]{this.f10431l.get(0)}, null, null, null, null);
                if (a10 != null) {
                    try {
                        if (a10.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = a10.getString(a10.getColumnIndex("__av"));
                                String string2 = a10.getString(a10.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = a10;
                                try {
                                    j.a(f10423d);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                } catch (Throwable th) {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        try {
                                            sQLiteDatabase.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    i.a(f10423d).b();
                                    throw th;
                                }
                            } catch (Throwable unused3) {
                                cursor = a10;
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (a10 != null) {
                    a10.close();
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused6) {
                }
                i.a(f10423d).b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (Throwable unused8) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable unused10) {
            sQLiteDatabase = null;
            jSONObject = null;
        }
        i.a(f10423d).b();
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a3, code lost:
    
        if (r2 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0087, code lost:
    
        if (r2 != null) goto L56;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject g() {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        r3 = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        r3 = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.f10428i.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabase = i.a(f10423d).a();
            try {
                sQLiteDatabase.beginTransaction();
                Cursor a10 = a(g.d.f10387a, sQLiteDatabase, null, "__ii=? ", new String[]{this.f10428i.get(0)}, null, null, null, null);
                if (a10 != null) {
                    try {
                        if (a10.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = a10.getString(a10.getColumnIndex("__av"));
                                String string2 = a10.getString(a10.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = a10;
                                try {
                                    j.a(f10423d);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                } catch (Throwable th) {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        try {
                                            sQLiteDatabase.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    i.a(f10423d).b();
                                    throw th;
                                }
                            } catch (Throwable unused3) {
                                cursor = a10;
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (a10 != null) {
                    a10.close();
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused6) {
                }
                i.a(f10423d).b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (Throwable unused8) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable unused10) {
            sQLiteDatabase = null;
            jSONObject = null;
        }
        i.a(f10423d).b();
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = i.a(f10423d).a();
                sQLiteDatabase.beginTransaction();
                if (this.f10429j.size() > 0) {
                    for (int i10 = 0; i10 < this.f10429j.size(); i10++) {
                        sQLiteDatabase.execSQL("delete from __et where rowid=" + this.f10429j.get(i10));
                    }
                }
                this.f10429j.clear();
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(f10423d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(f10423d);
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r0 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = i.a(f10423d).a();
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("delete from __er");
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(f10423d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(f10423d);
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (r1 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j() {
        SQLiteDatabase sQLiteDatabase;
        if (!TextUtils.isEmpty(this.f10430k)) {
            try {
                sQLiteDatabase = i.a(f10423d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("delete from __er where __i=\"" + this.f10430k + "\"");
                    sQLiteDatabase.execSQL("delete from __et where __i=\"" + this.f10430k + "\"");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    try {
                        j.a(f10423d);
                    } finally {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        i.a(f10423d).b();
                    }
                } catch (Throwable unused3) {
                }
            } catch (SQLiteDatabaseCorruptException unused4) {
                sQLiteDatabase = null;
            } catch (Throwable unused5) {
                sQLiteDatabase = null;
            }
        }
        this.f10430k = null;
    }

    private k() {
        this.f10428i = new ArrayList();
        this.f10429j = new ArrayList();
        this.f10430k = null;
        this.f10431l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c10 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(longValue));
            contentValues.put("__sp", c10);
            contentValues.put("__pp", str2);
            contentValues.put("__av", UMGlobalContext.getInstance(f10423d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(f10423d));
            sQLiteDatabase.insert(g.c.f10374a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        JSONObject jSONObject2;
        String str2;
        Cursor cursor2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(g.d.a.f10392e);
            if (optJSONObject != null) {
                jSONObject2 = optJSONObject;
                Cursor a10 = a(g.d.f10387a, sQLiteDatabase, new String[]{g.d.a.f10392e}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (a10 != null) {
                    String str3 = null;
                    while (a10.moveToNext()) {
                        try {
                            str3 = d(a10.getString(a10.getColumnIndex(g.d.a.f10392e)));
                        } catch (Throwable unused) {
                            cursor = a10;
                            if (cursor == null) {
                            }
                        }
                    }
                    String str4 = str3;
                    cursor2 = a10;
                    str2 = str4;
                } else {
                    cursor2 = a10;
                    str2 = null;
                }
            } else {
                jSONObject2 = optJSONObject;
                str2 = null;
                cursor2 = null;
            }
            if (jSONObject2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONArray = new JSONArray(str2);
                    }
                    jSONArray.put(jSONObject2);
                    String c10 = c(jSONArray.toString());
                    if (!TextUtils.isEmpty(c10)) {
                        sQLiteDatabase.execSQL("update  __sd set __d=\"" + c10 + "\" where __ii=\"" + str + "\"");
                    }
                } catch (Throwable unused2) {
                    cursor = cursor2;
                    if (cursor == null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(g.d.a.f10391d);
            if (optJSONObject2 != null) {
                String c11 = c(optJSONObject2.toString());
                if (!TextUtils.isEmpty(c11)) {
                    sQLiteDatabase.execSQL("update  __sd set __c=\"" + c11 + "\" where __ii=\"" + str + "\"");
                }
            }
            sQLiteDatabase.execSQL("update  __sd set __f=\"" + String.valueOf(jSONObject.optLong(g.d.a.f10394g)) + "\" where __ii=\"" + str + "\"");
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        this.f10428i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
    
        if (r2 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0098, code lost:
    
        if (r2 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(JSONArray jSONArray) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase a10 = i.a(f10423d).a();
                try {
                    try {
                        a10.beginTransaction();
                        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                                ContentValues contentValues = new ContentValues();
                                String optString = jSONObject.optString("__i");
                                if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                                    optString = w.a().b();
                                    if (TextUtils.isEmpty(optString)) {
                                        optString = "-1";
                                    }
                                }
                                contentValues.put("__i", optString);
                                contentValues.put("__e", jSONObject.optString("id"));
                                contentValues.put("__t", Integer.valueOf(jSONObject.optInt("__t")));
                                contentValues.put("__av", UMUtils.getAppVersionName(f10423d));
                                contentValues.put("__vc", UMUtils.getAppVersionCode(f10423d));
                                jSONObject.remove("__i");
                                jSONObject.remove("__t");
                                contentValues.put("__s", c(jSONObject.toString()));
                                a10.insert(g.b.f10361a, null, contentValues);
                            } catch (Exception unused) {
                            }
                        }
                        a10.setTransactionSuccessful();
                        a10.endTransaction();
                    } catch (SQLiteDatabaseCorruptException unused2) {
                        sQLiteDatabase = a10;
                        try {
                            j.a(f10423d);
                        } catch (Throwable th) {
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Throwable unused3) {
                                }
                            }
                            i.a(f10423d).b();
                            throw th;
                        }
                    }
                } catch (Throwable unused4) {
                    sQLiteDatabase = a10;
                }
            } catch (Throwable unused5) {
            }
        } catch (SQLiteDatabaseCorruptException unused6) {
        } catch (Throwable unused7) {
        }
        i.a(f10423d).b();
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(f10424e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f10424e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    public JSONObject b(boolean z10) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z10);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x008f, code lost:
    
        if (r1 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0081, code lost:
    
        if (r1 != null) goto L48;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00a4: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:51:0x00a9, block:B:50:0x00a4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        Cursor a10;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabase = i.a(f10423d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    if (!TextUtils.isEmpty(str)) {
                        a10 = a(g.a.f10350a, sQLiteDatabase, null, "__i=? ", new String[]{str}, null, null, null, null);
                    } else {
                        a10 = a(g.a.f10350a, sQLiteDatabase, null, null, null, null, null, null, null);
                    }
                    cursor = a10;
                    if (cursor != null) {
                        JSONArray jSONArray = new JSONArray();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("__a"));
                            if (!TextUtils.isEmpty(string)) {
                                jSONArray.put(new JSONObject(d(string)));
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put("error", jSONArray);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused) {
                    j.a(f10423d);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable unused2) {
                    j.a(f10423d);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Throwable unused3) {
                    }
                }
                i.a(f10423d).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            sQLiteDatabase = null;
        } catch (Throwable unused5) {
            sQLiteDatabase = null;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable unused6) {
        }
        i.a(f10423d).b();
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(f10424e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f10424e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
    
        if (r0 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, String str2, int i10) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase a10 = i.a(f10423d).a();
                try {
                    a10.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("__i", str);
                    String c10 = c(str2);
                    if (!TextUtils.isEmpty(c10)) {
                        contentValues.put("__a", c10);
                        contentValues.put("__t", Integer.valueOf(i10));
                        contentValues.put("__av", UMUtils.getAppVersionName(f10423d));
                        contentValues.put("__vc", UMUtils.getAppVersionCode(f10423d));
                        a10.insert(g.a.f10350a, null, contentValues);
                    }
                    a10.setTransactionSuccessful();
                    a10.endTransaction();
                } catch (SQLiteDatabaseCorruptException unused) {
                    sQLiteDatabase = a10;
                    try {
                        j.a(f10423d);
                    } catch (Throwable th) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        i.a(f10423d).b();
                        throw th;
                    }
                } catch (Throwable unused3) {
                    sQLiteDatabase = a10;
                }
            } catch (Throwable unused4) {
            }
        } catch (SQLiteDatabaseCorruptException unused5) {
        } catch (Throwable unused6) {
        }
        i.a(f10423d).b();
        return false;
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null && optJSONObject.optLong("duration") > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e4, code lost:
    
        if (r1 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e6, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d5, code lost:
    
        if (r1 != null) goto L63;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(JSONObject jSONObject, boolean z10) {
        Object obj;
        SQLiteDatabase sQLiteDatabase;
        ?? r02 = 0;
        String str = null;
        r02 = 0;
        r02 = 0;
        r02 = 0;
        r0 = null;
        r0 = null;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                sQLiteDatabase = i.a(f10423d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor a10 = a(g.c.f10374a, sQLiteDatabase, null, null, null, null, null, null, null);
                    if (a10 != null) {
                        try {
                            JSONArray jSONArray = new JSONArray();
                            while (a10.moveToNext()) {
                                JSONObject jSONObject2 = new JSONObject();
                                String string = a10.getString(a10.getColumnIndex("__e"));
                                str = a10.getString(a10.getColumnIndex("__ii"));
                                this.f10431l.add(str);
                                String string2 = a10.getString(a10.getColumnIndex("__sp"));
                                String string3 = a10.getString(a10.getColumnIndex("__pp"));
                                if (!TextUtils.isEmpty(string2)) {
                                    jSONObject2.put(f.aA, new JSONObject(d(string2)));
                                }
                                if (!TextUtils.isEmpty(string3)) {
                                    jSONObject2.put(f.aB, new JSONObject(d(string3)));
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    jSONObject2.put("id", str);
                                    jSONObject2.put(f.f10334p, string);
                                    if (jSONObject2.length() > 0) {
                                        jSONArray.put(jSONObject2);
                                    }
                                    if (z10) {
                                        break;
                                    }
                                }
                            }
                            r02 = str;
                            if (jSONArray.length() > 0) {
                                jSONObject.put(f.f10332n, jSONArray);
                                r02 = str;
                            }
                        } catch (SQLiteDatabaseCorruptException unused) {
                            obj = r02;
                            cursor = a10;
                            j.a(f10423d);
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Throwable unused2) {
                            obj = r02;
                            cursor2 = a10;
                            j.a(f10423d);
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (a10 != null) {
                        a10.close();
                    }
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused3) {
                    }
                    i.a(f10423d).b();
                } catch (SQLiteDatabaseCorruptException unused4) {
                    obj = null;
                } catch (Throwable unused5) {
                    obj = null;
                }
            } catch (Throwable th) {
                if (r02 != 0) {
                    r02.close();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused6) {
                    }
                }
                i.a(f10423d).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused7) {
            obj = null;
            sQLiteDatabase = null;
        } catch (Throwable unused8) {
            obj = null;
            sQLiteDatabase = null;
        }
        return r02;
        i.a(f10423d).b();
        r02 = obj;
        return r02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0099, code lost:
    
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0085, code lost:
    
        if (r2 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, JSONObject jSONObject, a aVar) {
        if (jSONObject == null) {
            return false;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase a10 = i.a(f10423d).a();
                try {
                    a10.beginTransaction();
                    if (aVar == a.BEGIN) {
                        long longValue = ((Long) jSONObject.opt("__e")).longValue();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__ii", str);
                        contentValues.put("__e", String.valueOf(longValue));
                        contentValues.put("__av", UMUtils.getAppVersionName(f10423d));
                        contentValues.put("__vc", UMUtils.getAppVersionCode(f10423d));
                        a10.insert(g.d.f10387a, null, contentValues);
                    } else if (aVar == a.INSTANTSESSIONBEGIN) {
                        b(str, jSONObject, a10);
                    } else if (aVar == a.END) {
                        a(str, jSONObject, a10);
                    } else if (aVar == a.PAGE) {
                        a(str, jSONObject, a10, "__a");
                    } else if (aVar == a.AUTOPAGE) {
                        a(str, jSONObject, a10, g.d.a.f10390c);
                    } else if (aVar == a.NEWSESSION) {
                        c(str, jSONObject, a10);
                    }
                    a10.setTransactionSuccessful();
                    a10.endTransaction();
                } catch (SQLiteDatabaseCorruptException unused) {
                    sQLiteDatabase = a10;
                    try {
                        j.a(f10423d);
                    } catch (Throwable th) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        i.a(f10423d).b();
                        throw th;
                    }
                } catch (Throwable unused3) {
                    sQLiteDatabase = a10;
                }
            } catch (Throwable unused4) {
            }
        } catch (SQLiteDatabaseCorruptException unused5) {
        } catch (Throwable unused6) {
        }
        i.a(f10423d).b();
        return false;
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.opt(g.d.a.f10394g)).longValue();
            Object opt = jSONObject.opt(g.d.a.f10395h);
            long longValue2 = (opt == null || !(opt instanceof Long)) ? 0L : ((Long) opt).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c10 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", " + g.d.a.f10395h + "=\"" + longValue2 + "\", __sp=\"" + c10 + "\", __pp=\"" + str2 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
    
        if (r0 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(boolean z10, boolean z11) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = i.a(f10423d).a();
                sQLiteDatabase.beginTransaction();
                if (z11) {
                    if (z10) {
                        sQLiteDatabase.execSQL("delete from __sd");
                    }
                } else if (this.f10428i.size() > 0) {
                    for (int i10 = 0; i10 < this.f10428i.size(); i10++) {
                        sQLiteDatabase.execSQL("delete from __sd where __ii=\"" + this.f10428i.get(i10) + "\"");
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(f10423d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(f10423d);
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        if (r4 != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        long j10 = 0;
        try {
            try {
                sQLiteDatabase = i.a(f10423d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    cursor = a(g.d.f10387a, sQLiteDatabase, new String[]{g.d.a.f10394g}, "__ii=? ", new String[]{str}, null, null, null, null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        j10 = cursor.getLong(cursor.getColumnIndex(g.d.a.f10394g));
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
                        try {
                            cursor.close();
                        } catch (Exception unused2) {
                            i.a(f10423d).b();
                            throw th;
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    i.a(f10423d).b();
                    throw th;
                }
            } catch (Exception unused3) {
            }
        } catch (Exception unused4) {
            sQLiteDatabase = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
        }
        sQLiteDatabase.endTransaction();
        i.a(f10423d).b();
        return j10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if (r0 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = i.a(f10423d).a();
                sQLiteDatabase.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabase.execSQL("delete from __is where __ii=\"" + str + "\"");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(f10423d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(f10423d);
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:52:0x004f, B:54:0x0055, B:15:0x0066, B:17:0x0071, B:18:0x0076, B:26:0x0085, B:29:0x008b, B:31:0x0091, B:38:0x0097, B:40:0x00a5, B:33:0x0094), top: B:51:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004f A[EXC_TOP_SPLITTER, LOOP:1: B:51:0x004f->B:54:0x0055, LOOP_START, PHI: r13
      0x004f: PHI (r13v2 java.lang.String) = (r13v7 java.lang.String), (r13v3 java.lang.String) binds: [B:14:0x004d, B:54:0x0055] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) {
        JSONArray jSONArray;
        JSONArray optJSONArray;
        Cursor a10;
        JSONArray jSONArray2;
        Cursor cursor = null;
        r13 = null;
        String str3 = null;
        try {
            if ("__a".equals(str2)) {
                optJSONArray = jSONObject.optJSONArray("__a");
                if (optJSONArray == null) {
                    return;
                }
                if (optJSONArray.length() <= 0) {
                    return;
                }
            } else if (g.d.a.f10390c.equals(str2)) {
                optJSONArray = jSONObject.optJSONArray(g.d.a.f10390c);
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    return;
                }
            } else {
                jSONArray = null;
                a10 = a(g.d.f10387a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (a10 != null) {
                    while (a10.moveToNext()) {
                        try {
                            str3 = d(a10.getString(a10.getColumnIndex(str2)));
                        } catch (Throwable unused) {
                            cursor = a10;
                            if (cursor != null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                    }
                }
                jSONArray2 = new JSONArray();
                if (!TextUtils.isEmpty(str3)) {
                    jSONArray2 = new JSONArray(str3);
                }
                if (jSONArray2.length() <= 1000) {
                    if (a10 != null) {
                        a10.close();
                        return;
                    }
                    return;
                }
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                        if (jSONObject2 != null) {
                            jSONArray2.put(jSONObject2);
                        }
                    } catch (JSONException unused2) {
                    }
                }
                String c10 = c(jSONArray2.toString());
                if (!TextUtils.isEmpty(c10)) {
                    sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + c10 + "\" where __ii=\"" + str + "\"");
                }
                if (a10 != null) {
                    a10.close();
                    return;
                }
                return;
            }
            jSONArray = optJSONArray;
            a10 = a(g.d.f10387a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
            if (a10 != null) {
            }
            jSONArray2 = new JSONArray();
            if (!TextUtils.isEmpty(str3)) {
            }
            if (jSONArray2.length() <= 1000) {
            }
        } catch (Throwable unused3) {
        }
    }

    public JSONObject a(boolean z10) {
        a();
        this.f10429j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z10) {
            a(jSONObject, z10);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String a10 = a(jSONObject, z10);
            if (!TextUtils.isEmpty(a10)) {
                b(jSONObject, a10);
                a(jSONObject, a10);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x018d, code lost:
    
        if (r1 != null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x017f, code lost:
    
        if (r1 != null) goto L90;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x01a2: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:114:0x01a7, block:B:113:0x01a2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        Cursor a10;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabase = i.a(f10423d).a();
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(f10423d).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            sQLiteDatabase = null;
        } catch (Throwable unused3) {
            sQLiteDatabase = null;
        }
        try {
            sQLiteDatabase.beginTransaction();
            if (!TextUtils.isEmpty(str)) {
                a10 = a(g.b.f10361a, sQLiteDatabase, null, "__i=? ", new String[]{str}, null, null, null, null);
            } else {
                a10 = a(g.b.f10361a, sQLiteDatabase, null, null, null, null, null, null, null);
            }
            cursor = a10;
            if (cursor != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                String b10 = w.a().b();
                while (cursor.moveToNext()) {
                    int i10 = cursor.getInt(cursor.getColumnIndex("__t"));
                    String string = cursor.getString(cursor.getColumnIndex("__i"));
                    String string2 = cursor.getString(cursor.getColumnIndex("__s"));
                    if (TextUtils.isEmpty(string) || "-1".equals(string)) {
                        if (!TextUtils.isEmpty(b10)) {
                            string = b10;
                        }
                    }
                    this.f10429j.add(Integer.valueOf(cursor.getInt(0)));
                    if (i10 != 2049) {
                        if (i10 == 2050 && !TextUtils.isEmpty(string2)) {
                            JSONObject jSONObject4 = new JSONObject(d(string2));
                            if (jSONObject3.has(string)) {
                                jSONArray = jSONObject3.optJSONArray(string);
                            } else {
                                jSONArray = new JSONArray();
                            }
                            jSONArray.put(jSONObject4);
                            jSONObject3.put(string, jSONArray);
                        }
                    } else if (!TextUtils.isEmpty(string2)) {
                        JSONObject jSONObject5 = new JSONObject(d(string2));
                        if (jSONObject2.has(string)) {
                            jSONArray2 = jSONObject2.optJSONArray(string);
                        } else {
                            jSONArray2 = new JSONArray();
                        }
                        jSONArray2.put(jSONObject5);
                        jSONObject2.put(string, jSONArray2);
                    }
                }
                if (jSONObject2.length() > 0) {
                    JSONArray jSONArray3 = new JSONArray();
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        JSONObject jSONObject6 = new JSONObject();
                        String next = keys.next();
                        jSONObject6.put(next, new JSONArray(jSONObject2.optString(next)));
                        if (jSONObject6.length() > 0) {
                            jSONArray3.put(jSONObject6);
                        }
                    }
                    if (jSONArray3.length() > 0) {
                        jSONObject.put("ekv", jSONArray3);
                    }
                }
                if (jSONObject3.length() > 0) {
                    JSONArray jSONArray4 = new JSONArray();
                    Iterator<String> keys2 = jSONObject3.keys();
                    while (keys2.hasNext()) {
                        JSONObject jSONObject7 = new JSONObject();
                        String next2 = keys2.next();
                        jSONObject7.put(next2, new JSONArray(jSONObject3.optString(next2)));
                        if (jSONObject7.length() > 0) {
                            jSONArray4.put(jSONObject7);
                        }
                    }
                    if (jSONArray4.length() > 0) {
                        jSONObject.put(f.Z, jSONArray4);
                    }
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (cursor != null) {
                cursor.close();
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            j.a(f10423d);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable unused5) {
            j.a(f10423d);
            if (cursor != null) {
                cursor.close();
            }
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable unused6) {
        }
        i.a(f10423d).b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x022e, code lost:
    
        if (r12 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x021f, code lost:
    
        if (r12 == null) goto L99;
     */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0243: IF  (r12 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:131:0x0248, block:B:130:0x0243 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x023e: IF  (r14 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:130:0x0243, block:B:128:0x023e */
    /* JADX WARN: Removed duplicated region for block: B:23:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(JSONObject jSONObject, boolean z10) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Cursor cursor2;
        SQLiteDatabase sQLiteDatabase2;
        JSONArray jSONArray;
        String str;
        JSONArray jSONArray2;
        String str2 = null;
        try {
            try {
                sQLiteDatabase = i.a(f10423d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor a10 = a(g.d.f10387a, sQLiteDatabase, null, null, null, null, null, null, null);
                    if (a10 != null) {
                        try {
                            JSONArray jSONArray3 = new JSONArray();
                            while (true) {
                                if (!a10.moveToNext()) {
                                    cursor = a10;
                                    jSONArray = jSONArray3;
                                    break;
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                String string = a10.getString(a10.getColumnIndex(g.d.a.f10394g));
                                String string2 = a10.getString(a10.getColumnIndex("__e"));
                                String string3 = a10.getString(a10.getColumnIndex(g.d.a.f10395h));
                                str2 = a10.getString(a10.getColumnIndex("__ii"));
                                try {
                                    if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                                        str = str2;
                                        cursor = a10;
                                        jSONArray = jSONArray3;
                                    } else {
                                        if (Long.parseLong(string) - Long.parseLong(string2) > 0) {
                                            String string4 = a10.getString(a10.getColumnIndex("__a"));
                                            String string5 = a10.getString(a10.getColumnIndex(g.d.a.f10390c));
                                            String string6 = a10.getString(a10.getColumnIndex(g.d.a.f10391d));
                                            String string7 = a10.getString(a10.getColumnIndex(g.d.a.f10392e));
                                            this.f10428i.add(str2);
                                            String string8 = a10.getString(a10.getColumnIndex("__sp"));
                                            String string9 = a10.getString(a10.getColumnIndex("__pp"));
                                            jSONObject2.put("id", str2);
                                            jSONObject2.put(f.f10334p, string2);
                                            jSONObject2.put(f.f10335q, string);
                                            str = str2;
                                            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                cursor = a10;
                                                jSONArray2 = jSONArray3;
                                                jSONObject2.put("duration", Long.parseLong(string) - Long.parseLong(string2));
                                            } else {
                                                try {
                                                    if (Long.parseLong(string3) <= 0) {
                                                        jSONObject2.put("duration", Long.parseLong(string) - Long.parseLong(string2));
                                                        cursor = a10;
                                                        jSONArray2 = jSONArray3;
                                                    } else {
                                                        cursor = a10;
                                                        jSONArray2 = jSONArray3;
                                                        jSONObject2.put("duration", Long.parseLong(string3));
                                                        jSONObject2.put(f.f10337s, Long.parseLong(string) - Long.parseLong(string2));
                                                    }
                                                } catch (SQLiteDatabaseCorruptException unused) {
                                                    cursor = a10;
                                                    str2 = str;
                                                    j.a(f10423d);
                                                    if (cursor != null) {
                                                    }
                                                } catch (Throwable unused2) {
                                                    cursor = a10;
                                                    str2 = str;
                                                    j.a(f10423d);
                                                    if (cursor != null) {
                                                    }
                                                }
                                            }
                                            if (!TextUtils.isEmpty(string4)) {
                                                try {
                                                    jSONObject2.put(f.f10338t, new JSONArray(d(string4)));
                                                } catch (SQLiteDatabaseCorruptException unused3) {
                                                    str2 = str;
                                                    j.a(f10423d);
                                                    if (cursor != null) {
                                                    }
                                                } catch (Throwable unused4) {
                                                    str2 = str;
                                                    j.a(f10423d);
                                                    if (cursor != null) {
                                                    }
                                                }
                                            }
                                            boolean z11 = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO;
                                            if (!TextUtils.isEmpty(string5) && z11) {
                                                JSONArray jSONArray4 = new JSONArray(d(string5));
                                                JSONArray jSONArray5 = new JSONArray();
                                                if (jSONArray4.length() > 0) {
                                                    jSONArray5 = b(jSONArray4);
                                                }
                                                jSONObject2.put(f.f10339u, jSONArray5);
                                            }
                                            if (!TextUtils.isEmpty(string6)) {
                                                jSONObject2.put(f.F, new JSONObject(d(string6)));
                                            }
                                            if (!TextUtils.isEmpty(string7)) {
                                                jSONObject2.put(f.B, new JSONArray(d(string7)));
                                            }
                                            if (!TextUtils.isEmpty(string8)) {
                                                jSONObject2.put(f.aA, new JSONObject(d(string8)));
                                            }
                                            if (!TextUtils.isEmpty(string9)) {
                                                jSONObject2.put(f.aB, new JSONObject(d(string9)));
                                            }
                                            if (jSONObject2.length() > 0) {
                                                jSONArray = jSONArray2;
                                                jSONArray.put(jSONObject2);
                                            } else {
                                                jSONArray = jSONArray2;
                                            }
                                        } else {
                                            str = str2;
                                            cursor = a10;
                                            jSONArray = jSONArray3;
                                        }
                                        if (z10) {
                                            str2 = str;
                                            break;
                                        }
                                    }
                                    jSONArray3 = jSONArray;
                                    a10 = cursor;
                                    str2 = str;
                                } catch (SQLiteDatabaseCorruptException unused5) {
                                    cursor = a10;
                                    j.a(f10423d);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                } catch (Throwable unused6) {
                                    cursor = a10;
                                    j.a(f10423d);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                }
                            }
                        } catch (SQLiteDatabaseCorruptException unused7) {
                        } catch (Throwable unused8) {
                        }
                        try {
                            if (this.f10428i.size() < 1) {
                                cursor.close();
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Throwable unused9) {
                                }
                                i.a(f10423d).b();
                                return str2;
                            }
                            if (jSONArray.length() > 0) {
                                jSONObject.put(f.f10332n, jSONArray);
                            }
                        } catch (SQLiteDatabaseCorruptException unused10) {
                            j.a(f10423d);
                            if (cursor != null) {
                            }
                        } catch (Throwable unused11) {
                            j.a(f10423d);
                            if (cursor != null) {
                            }
                        }
                    } else {
                        cursor = a10;
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused12) {
                    cursor = null;
                } catch (Throwable unused13) {
                    cursor = null;
                }
            } catch (Throwable th) {
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Throwable unused14) {
                    }
                }
                i.a(f10423d).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused15) {
            sQLiteDatabase = null;
            cursor = null;
        } catch (Throwable unused16) {
            sQLiteDatabase = null;
            cursor = null;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable unused17) {
        }
        i.a(f10423d).b();
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0064, code lost:
    
        if (r0 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z10, boolean z11) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                try {
                    sQLiteDatabase = i.a(f10423d).a();
                    sQLiteDatabase.beginTransaction();
                    if (!z11) {
                        int size = this.f10431l.size();
                        int i10 = 0;
                        if (size > 0) {
                            int i11 = 0;
                            while (i10 < size) {
                                String str = this.f10431l.get(i10);
                                if (str == null) {
                                    i11 = 1;
                                }
                                sQLiteDatabase.execSQL("delete from __is where __ii=\"" + str + "\"");
                                i10++;
                            }
                            i10 = i11;
                        }
                        if (i10 != 0) {
                            sQLiteDatabase.execSQL("delete from __is where __ii is null");
                        }
                    } else if (z10) {
                        sQLiteDatabase.execSQL("delete from __is");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Throwable unused) {
                    j.a(f10423d);
                    if (sQLiteDatabase != null) {
                    }
                }
            } catch (SQLiteDatabaseCorruptException unused2) {
                j.a(f10423d);
            }
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
            i.a(f10423d).b();
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            i.a(f10423d).b();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0078, code lost:
    
        if (r0 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z10, String str) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = i.a(f10423d).a();
                sQLiteDatabase.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabase.execSQL("delete from __er where __i=\"" + str + "\"");
                    sQLiteDatabase.execSQL("delete from __et where __i=\"" + str + "\"");
                    this.f10429j.clear();
                    sQLiteDatabase.execSQL("delete from __sd where __ii=\"" + str + "\"");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(f10423d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(f10423d);
        } catch (Throwable unused3) {
        }
    }
}
