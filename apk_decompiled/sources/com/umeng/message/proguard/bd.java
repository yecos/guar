package com.umeng.message.proguard;

import android.app.Application;
import android.content.ContentValues;
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
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String c(java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 0
            android.app.Application r1 = com.umeng.message.proguard.y.a()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            boolean r2 = com.umeng.message.proguard.f.b(r1)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r2 == 0) goto L16
            com.umeng.message.proguard.bc r1 = com.umeng.message.proguard.bc.a()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            android.content.SharedPreferences r1 = r1.f11629a     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r7 = r1.getString(r7, r8)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            return r7
        L16:
            java.lang.String[] r5 = new java.lang.String[]{r7}     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            android.content.ContentResolver r7 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            android.net.Uri r2 = com.umeng.message.proguard.h.c(r1)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r3 = 0
            r4 = 0
            r6 = 0
            r1 = r7
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r0 != 0) goto L32
            if (r0 == 0) goto L31
            r0.close()     // Catch: java.lang.Throwable -> L31
        L31:
            return r8
        L32:
            boolean r7 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r7 == 0) goto L43
            java.lang.String r7 = "v"
            int r7 = r0.getColumnIndex(r7)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r7 = r0.getString(r7)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r8 = r7
        L43:
            r0.close()     // Catch: java.lang.Throwable -> L52
            goto L52
        L47:
            r7 = move-exception
            goto L53
        L49:
            r7 = move-exception
            java.lang.String r1 = "KV"
            com.umeng.message.common.UPLog.e(r1, r7)     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L52
            goto L43
        L52:
            return r8
        L53:
            if (r0 == 0) goto L58
            r0.close()     // Catch: java.lang.Throwable -> L58
        L58:
            goto L5a
        L59:
            throw r7
        L5a:
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.bd.c(java.lang.String, java.lang.String):java.lang.String");
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
