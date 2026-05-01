package com.umeng.message.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    */
    private static String d(String str, String str2) {
        Context a10;
        Cursor cursor = null;
        try {
            try {
                a10 = de.a();
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (dy.a(a10)) {
            return ds.a().b(str, str2);
        }
        cursor = a10.getContentResolver().query(cy.a(a10), null, null, new String[]{str}, null);
        if (cursor == null) {
            String b10 = ds.a().b(str, str2);
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable unused2) {
                }
            }
            return b10;
        }
        if (cursor.moveToFirst()) {
            str2 = cursor.getString(cursor.getColumnIndex("v"));
        }
        try {
            cursor.close();
        } catch (Throwable unused3) {
        }
        return str2;
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
