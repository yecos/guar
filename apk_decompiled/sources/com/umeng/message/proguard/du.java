package com.umeng.message.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public final class du {

    /* renamed from: a, reason: collision with root package name */
    private final String f12018a;

    public du(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str + "_";
        }
        this.f12018a = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0057, code lost:
    
        if (0 == 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String d(java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            android.content.Context r1 = com.umeng.message.proguard.de.a()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            boolean r2 = com.umeng.message.proguard.dy.a(r1)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r2 == 0) goto L14
            com.umeng.message.proguard.ds r1 = com.umeng.message.proguard.ds.a()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r8 = r1.b(r8, r9)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            return r8
        L14:
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            android.net.Uri r3 = com.umeng.message.proguard.cy.a(r1)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r4 = 0
            r6 = 0
            r7 = 0
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r6
            r6 = r7
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r0 != 0) goto L3c
            com.umeng.message.proguard.ds r1 = com.umeng.message.proguard.ds.a()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r8 = r1.b(r8, r9)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r0 == 0) goto L3b
            r0.close()     // Catch: java.lang.Throwable -> L3b
        L3b:
            return r8
        L3c:
            boolean r8 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r8 == 0) goto L4d
            java.lang.String r8 = "v"
            int r8 = r0.getColumnIndex(r8)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r8 = r0.getString(r8)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r9 = r8
        L4d:
            r0.close()     // Catch: java.lang.Throwable -> L5a
            goto L5a
        L51:
            r8 = move-exception
            goto L5b
        L53:
            r8 = move-exception
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L5a
            goto L4d
        L5a:
            return r9
        L5b:
            if (r0 == 0) goto L60
            r0.close()     // Catch: java.lang.Throwable -> L60
        L60:
            goto L62
        L61:
            throw r8
        L62:
            goto L61
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.du.d(java.lang.String, java.lang.String):java.lang.String");
    }

    public final String a(String str) {
        return this.f12018a + str;
    }

    public final int b(String str) {
        try {
            return Integer.parseInt(d(a(str), "0"));
        } catch (Exception unused) {
            return 0;
        }
    }

    public final boolean c(String str) {
        try {
            return Boolean.parseBoolean(d(a(str), "false"));
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a(String str, int i10) {
        c(a(str), String.valueOf(i10));
    }

    public static void c(String str, String str2) {
        try {
            Context a10 = de.a();
            if (dy.a(a10)) {
                ds.a().a(str, str2);
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("k", str);
            contentValues.put("v", str2);
            try {
                a10.getContentResolver().insert(cy.a(a10), contentValues);
            } catch (Throwable unused) {
                ds.a().a(str, str2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(String str, long j10) {
        c(a(str), String.valueOf(j10));
    }

    public final long b(String str, long j10) {
        try {
            return Long.parseLong(d(a(str), String.valueOf(j10)));
        } catch (Exception unused) {
            return j10;
        }
    }

    public final void a(String str, String str2) {
        c(a(str), String.valueOf(str2));
    }

    public final void a(String str, boolean z10) {
        c(a(str), String.valueOf(z10));
    }

    public final String b(String str, String str2) {
        return d(a(str), String.valueOf(str2));
    }

    public final Set<String> a(String str, Set<String> set) {
        try {
            String d10 = d(a(str), "");
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = new JSONArray(d10);
            int length = jSONArray.length();
            if (length > 0) {
                for (int i10 = 0; i10 < length; i10++) {
                    hashSet.add(jSONArray.optString(i10));
                }
            }
            return hashSet;
        } catch (Throwable unused) {
            return set;
        }
    }
}
