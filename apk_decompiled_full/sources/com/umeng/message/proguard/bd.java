package com.umeng.message.proguard;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public final class bd {

    /* renamed from: a, reason: collision with root package name */
    private final String f11630a;

    public bd(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str + "_";
        }
        this.f11630a = str;
    }

    private String b(String str) {
        return this.f11630a + str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
    
        if (0 == 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String c(String str, String str2) {
        Application a10;
        Cursor cursor = null;
        try {
            try {
                a10 = y.a();
            } catch (Exception e10) {
                UPLog.e("KV", e10);
            }
            if (f.b(a10)) {
                return bc.a().f11629a.getString(str, str2);
            }
            cursor = a10.getContentResolver().query(h.c(a10), null, null, new String[]{str}, null);
            if (cursor == null) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable unused) {
                    }
                }
                return str2;
            }
            if (cursor.moveToFirst()) {
                str2 = cursor.getString(cursor.getColumnIndex("v"));
            }
            try {
                cursor.close();
            } catch (Throwable unused2) {
            }
            return str2;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Throwable unused3) {
                }
            }
            throw th;
        }
    }

    private static void d(String str, String str2) {
        try {
            Application a10 = y.a();
            if (f.b(a10)) {
                bc.a().a(str, str2);
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("k", str);
            contentValues.put("v", str2);
            a10.getContentResolver().insert(h.c(a10), contentValues);
        } catch (Exception e10) {
            UPLog.e("KV", e10);
        }
    }

    public final void a(String str, int i10) {
        d(b(str), String.valueOf(i10));
    }

    public final void a(String str, long j10) {
        d(b(str), String.valueOf(j10));
    }

    public final Set<String> b(String str, Set<String> set) {
        try {
            String c10 = c(b(str), "");
            if (!TextUtils.isEmpty(c10)) {
                HashSet hashSet = new HashSet();
                JSONArray jSONArray = new JSONArray(c10);
                int length = jSONArray.length();
                if (length > 0) {
                    for (int i10 = 0; i10 < length; i10++) {
                        hashSet.add(jSONArray.optString(i10));
                    }
                }
                return hashSet;
            }
        } catch (Throwable th) {
            UPLog.e("KV", th);
        }
        return set;
    }

    public final void a(String str, String str2) {
        d(b(str), String.valueOf(str2));
    }

    public final void a(String str, boolean z10) {
        d(b(str), String.valueOf(z10));
    }

    public final void a(String str, Set<String> set) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (set != null) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            d(b(str), jSONArray.toString());
        } catch (Throwable th) {
            UPLog.e("KV", th);
        }
    }

    public final int b(String str, int i10) {
        String c10 = c(b(str), String.valueOf(i10));
        if (!TextUtils.isEmpty(c10)) {
            try {
                return Integer.parseInt(c10);
            } catch (Exception e10) {
                UPLog.e("KV", e10);
            }
        }
        return i10;
    }

    public final void a(String str) {
        c(b(str));
    }

    public final long b(String str, long j10) {
        String c10 = c(b(str), String.valueOf(j10));
        if (!TextUtils.isEmpty(c10)) {
            try {
                return Long.parseLong(c10);
            } catch (Exception e10) {
                UPLog.e("KV", e10);
            }
        }
        return j10;
    }

    private static void c(String str) {
        try {
            Application a10 = y.a();
            if (f.b(a10)) {
                bc.a().a(str);
                return;
            }
            a10.getContentResolver().delete(h.c(a10), null, new String[]{str});
        } catch (Throwable th) {
            UPLog.e("KV", th);
        }
    }

    public final boolean b(String str, boolean z10) {
        String c10 = c(b(str), String.valueOf(z10));
        if (!TextUtils.isEmpty(c10)) {
            try {
                return Boolean.parseBoolean(c10);
            } catch (Exception e10) {
                UPLog.e("KV", e10);
            }
        }
        return z10;
    }

    public final String b(String str, String str2) {
        return c(b(str), str2);
    }
}
