package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            r7 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            com.umeng.analytics.pro.w r1 = com.umeng.analytics.pro.w.a()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            if (r2 == 0) goto L29
            r0.endTransaction()     // Catch: java.lang.Throwable -> L1f
        L1f:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            return
        L29:
            r2 = 2
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r4 = ""
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r4 = "-1"
            r6 = 1
            r3[r6] = r4     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
        L36:
            if (r5 >= r2) goto L68
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            r4.<init>()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r6 = "update __et set __i=\""
            r4.append(r6)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            r4.append(r1)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r6 = "\" where "
            r4.append(r6)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r6 = "__i"
            r4.append(r6)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r6 = "=\""
            r4.append(r6)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            r6 = r3[r5]     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            r4.append(r6)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r6 = "\""
            r4.append(r6)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            int r5 = r5 + 1
            goto L36
        L68:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteDatabaseCorruptException -> L7b
            goto L6e
        L6c:
            if (r0 == 0) goto L71
        L6e:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L71
        L71:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L83
        L7b:
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L84
            com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L84
            if (r0 == 0) goto L71
            goto L6e
        L83:
            return
        L84:
            r1 = move-exception
            if (r0 == 0) goto L8a
            r0.endTransaction()     // Catch: java.lang.Throwable -> L8a
        L8a:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L95
        L94:
            throw r1
        L95:
            goto L94
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.d():void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject f() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f10431l
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L97
            com.umeng.analytics.pro.i r2 = com.umeng.analytics.pro.i.a(r2)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L97
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L97
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.util.List<java.lang.String> r4 = r14.f10431l     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.lang.String r5 = "__is"
            r7 = 0
            java.lang.String r8 = "__ii=? "
            java.lang.String[] r9 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = r14
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            if (r4 == 0) goto L5e
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            if (r5 == 0) goto L5e
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r5.<init>()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r3 = r5
            goto L5e
        L5c:
            goto L75
        L5e:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            if (r4 == 0) goto L66
            r4.close()
        L66:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L69
        L69:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto La6
        L73:
            r5 = r3
        L75:
            r3 = r4
            goto L82
        L77:
            r5 = r3
        L78:
            r3 = r4
            goto L99
        L7a:
            r5 = r3
            goto L82
        L7d:
            r5 = r3
            goto L99
        L7f:
            r2 = r3
            r5 = r2
        L82:
            if (r3 == 0) goto L87
            r3.close()
        L87:
            if (r2 == 0) goto L8c
        L89:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8c
        L8c:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            r3 = r5
            goto La6
        L97:
            r2 = r3
            r5 = r2
        L99:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> La7
            com.umeng.analytics.pro.j.a(r0)     // Catch: java.lang.Throwable -> La7
            if (r3 == 0) goto La3
            r3.close()
        La3:
            if (r2 == 0) goto L8c
            goto L89
        La6:
            return r3
        La7:
            r0 = move-exception
            if (r3 == 0) goto Lad
            r3.close()
        Lad:
            if (r2 == 0) goto Lb2
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb2
        Lb2:
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            goto Lbd
        Lbc:
            throw r0
        Lbd:
            goto Lbc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.f():org.json.JSONObject");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject g() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f10428i
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L97
            com.umeng.analytics.pro.i r2 = com.umeng.analytics.pro.i.a(r2)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L97
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L97
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.util.List<java.lang.String> r4 = r14.f10428i     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.lang.String r5 = "__sd"
            r7 = 0
            java.lang.String r8 = "__ii=? "
            java.lang.String[] r9 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = r14
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            if (r4 == 0) goto L5e
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            if (r5 == 0) goto L5e
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            r5.<init>()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L5c android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r3 = r5
            goto L5e
        L5c:
            goto L75
        L5e:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L77
            if (r4 == 0) goto L66
            r4.close()
        L66:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L69
        L69:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto La6
        L73:
            r5 = r3
        L75:
            r3 = r4
            goto L82
        L77:
            r5 = r3
        L78:
            r3 = r4
            goto L99
        L7a:
            r5 = r3
            goto L82
        L7d:
            r5 = r3
            goto L99
        L7f:
            r2 = r3
            r5 = r2
        L82:
            if (r3 == 0) goto L87
            r3.close()
        L87:
            if (r2 == 0) goto L8c
        L89:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8c
        L8c:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            r3 = r5
            goto La6
        L97:
            r2 = r3
            r5 = r2
        L99:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> La7
            com.umeng.analytics.pro.j.a(r0)     // Catch: java.lang.Throwable -> La7
            if (r3 == 0) goto La3
            r3.close()
        La3:
            if (r2 == 0) goto L8c
            goto L89
        La6:
            return r3
        La7:
            r0 = move-exception
            if (r3 == 0) goto Lad
            r3.close()
        Lad:
            if (r2 == 0) goto Lb2
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb2
        Lb2:
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            goto Lbd
        Lbc:
            throw r0
        Lbd:
            goto Lbc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.g():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.util.List<java.lang.Integer> r1 = r4.f10429j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            if (r1 <= 0) goto L3c
            r1 = 0
        L17:
            java.util.List<java.lang.Integer> r2 = r4.f10429j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            if (r1 >= r2) goto L3c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.<init>()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r3 = "delete from __et where rowid="
            r2.append(r3)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.util.List<java.lang.Integer> r3 = r4.f10429j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.append(r3)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            int r1 = r1 + 1
            goto L17
        L3c:
            java.util.List<java.lang.Integer> r1 = r4.f10429j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r1.clear()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            goto L47
        L45:
            if (r0 == 0) goto L4a
        L47:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L4a
        L4a:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L5c
        L54:
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L5d
            com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L4a
            goto L47
        L5c:
            return
        L5d:
            r1 = move-exception
            if (r0 == 0) goto L63
            r0.endTransaction()     // Catch: java.lang.Throwable -> L63
        L63:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L6e
        L6d:
            throw r1
        L6e:
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.h():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r0 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i() {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            java.lang.String r1 = "delete from __er"
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            goto L19
        L17:
            if (r0 == 0) goto L1c
        L19:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L1c
        L1c:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L2e
        L26:
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L2f
            com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L1c
            goto L19
        L2e:
            return
        L2f:
            r1 = move-exception
            if (r0 == 0) goto L35
            r0.endTransaction()     // Catch: java.lang.Throwable -> L35
        L35:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L40
        L3f:
            throw r1
        L40:
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.i():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (r1 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j() {
        /*
            r5 = this;
            java.lang.String r0 = "\""
            java.lang.String r1 = r5.f10430k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L77
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L4e android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L4e android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L4e android.database.sqlite.SQLiteDatabaseCorruptException -> L5e
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.<init>()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r4 = "delete from __er where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r4 = r5.f10430k     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.append(r4)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.append(r0)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r1.execSQL(r3)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.<init>()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r4 = "delete from __et where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r4 = r5.f10430k     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.append(r4)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.append(r0)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r1.execSQL(r0)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            goto L51
        L4e:
            r1 = r2
        L4f:
            if (r1 == 0) goto L54
        L51:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L54
        L54:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L77
        L5e:
            r1 = r2
        L5f:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L67
            com.umeng.analytics.pro.j.a(r0)     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L54
            goto L51
        L67:
            r0 = move-exception
            if (r1 == 0) goto L6d
            r1.endTransaction()     // Catch: java.lang.Throwable -> L6d
        L6d:
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            throw r0
        L77:
            r5.f10430k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.j():void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(java.lang.String r20, org.json.JSONObject r21, android.database.sqlite.SQLiteDatabase r22) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.c(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(org.json.JSONArray r11) {
        /*
            r10 = this;
            java.lang.String r0 = "__t"
            java.lang.String r1 = "__i"
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteDatabaseCorruptException -> La7
            com.umeng.analytics.pro.i r3 = com.umeng.analytics.pro.i.a(r3)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteDatabaseCorruptException -> La7
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteDatabaseCorruptException -> La7
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r4 = 0
        L13:
            int r5 = r11.length()     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            if (r4 >= r5) goto L8d
            org.json.JSONObject r5 = r11.getJSONObject(r4)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.<init>()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = r5.optString(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r9 = "-1"
            if (r8 != 0) goto L34
            boolean r8 = r9.equals(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            if (r8 == 0) goto L43
        L34:
            com.umeng.analytics.pro.w r7 = com.umeng.analytics.pro.w.a()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = r7.b()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            if (r8 == 0) goto L43
            r7 = r9
        L43:
            r6.put(r1, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__e"
            java.lang.String r8 = "id"
            java.lang.String r8 = r5.optString(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            int r7 = r5.optInt(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r0, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r5.remove(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r5.remove(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__s"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r5 = r10.c(r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r5 = "__et"
            r3.insert(r5, r2, r6)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
        L8a:
            int r4 = r4 + 1
            goto L13
        L8d:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r3.endTransaction()     // Catch: java.lang.Throwable -> L9d
            goto L9d
        L94:
            r2 = r3
            goto L98
        L96:
            r2 = r3
            goto La7
        L98:
            if (r2 == 0) goto L9d
        L9a:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L9d
        L9d:
            android.content.Context r11 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r11 = com.umeng.analytics.pro.i.a(r11)
            r11.b()
            goto Laf
        La7:
            android.content.Context r11 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> Lb0
            com.umeng.analytics.pro.j.a(r11)     // Catch: java.lang.Throwable -> Lb0
            if (r2 == 0) goto L9d
            goto L9a
        Laf:
            return
        Lb0:
            r11 = move-exception
            if (r2 == 0) goto Lb6
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto Lc1
        Lc0:
            throw r11
        Lc1:
            goto Lc0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(org.json.JSONArray):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(org.json.JSONObject r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L84
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L84
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L84
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            if (r2 != 0) goto L28
            java.lang.String r3 = "__er"
            r5 = 0
            java.lang.String r6 = "__i=? "
            java.lang.String[] r7 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            goto L37
        L28:
            java.lang.String r3 = "__er"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
        L37:
            r0 = r14
            if (r0 == 0) goto L6d
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            r14.<init>()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
        L3f:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            if (r2 == 0) goto L62
            java.lang.String r2 = "__a"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            if (r3 != 0) goto L3f
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            java.lang.String r2 = r12.d(r2)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            r14.put(r3)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            goto L3f
        L62:
            int r2 = r14.length()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            if (r2 <= 0) goto L6d
            java.lang.String r2 = "error"
            r13.put(r2, r14)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
        L6d:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteDatabaseCorruptException -> L85
            if (r0 == 0) goto L91
            r0.close()
            goto L91
        L76:
            r1 = r0
        L77:
            android.content.Context r13 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L9e
            com.umeng.analytics.pro.j.a(r13)     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L81
            r0.close()
        L81:
            if (r1 == 0) goto L94
            goto L91
        L84:
            r1 = r0
        L85:
            android.content.Context r13 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L9e
            com.umeng.analytics.pro.j.a(r13)     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L8f
            r0.close()
        L8f:
            if (r1 == 0) goto L94
        L91:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L94
        L94:
            android.content.Context r13 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r13 = com.umeng.analytics.pro.i.a(r13)
            r13.b()
            return
        L9e:
            r13 = move-exception
            if (r0 == 0) goto La4
            r0.close()
        La4:
            if (r1 == 0) goto La9
            r1.endTransaction()     // Catch: java.lang.Throwable -> La9
        La9:
            android.content.Context r14 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r14 = com.umeng.analytics.pro.i.a(r14)
            r14.b()
            goto Lb4
        Lb3:
            throw r13
        Lb4:
            goto Lb3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.b(org.json.JSONObject, java.lang.String):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteDatabaseCorruptException -> L65
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteDatabaseCorruptException -> L65
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteDatabaseCorruptException -> L65
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.<init>()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = r4.c(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            if (r6 != 0) goto L4b
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__av"
            android.content.Context r6 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__vc"
            android.content.Context r6 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
        L4b:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r1.endTransaction()     // Catch: java.lang.Throwable -> L5b
            goto L5b
        L52:
            r0 = r1
            goto L56
        L54:
            r0 = r1
            goto L65
        L56:
            if (r0 == 0) goto L5b
        L58:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L5b
        L5b:
            android.content.Context r5 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r5 = com.umeng.analytics.pro.i.a(r5)
            r5.b()
            goto L6d
        L65:
            android.content.Context r5 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L6f
            com.umeng.analytics.pro.j.a(r5)     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L5b
            goto L58
        L6d:
            r5 = 0
            return r5
        L6f:
            r5 = move-exception
            if (r0 == 0) goto L75
            r0.endTransaction()     // Catch: java.lang.Throwable -> L75
        L75:
            android.content.Context r6 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r6 = com.umeng.analytics.pro.i.a(r6)
            r6.b()
            goto L80
        L7f:
            throw r5
        L80:
            goto L7f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String, java.lang.String, int):boolean");
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
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b(org.json.JSONObject r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.b(org.json.JSONObject, boolean):java.lang.String");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.k.a r9) {
        /*
            r6 = this;
            java.lang.String r0 = "__e"
            r1 = 0
            if (r8 != 0) goto L6
            return r1
        L6:
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            com.umeng.analytics.pro.i r3 = com.umeng.analytics.pro.i.a(r3)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            com.umeng.analytics.pro.k$a r4 = com.umeng.analytics.pro.k.a.BEGIN     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r4) goto L4f
            java.lang.Object r8 = r8.opt(r0)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            long r8 = r8.longValue()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.<init>()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r5 = "__ii"
            r4.put(r5, r7)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.put(r0, r7)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = "__sd"
            r3.insert(r7, r2, r4)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L4f:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.INSTANTSESSIONBEGIN     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L57
            r6.b(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L57:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.END     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L5f
            r6.a(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L5f:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.PAGE     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L69
            java.lang.String r9 = "__a"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L69:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.AUTOPAGE     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L73
            java.lang.String r9 = "__b"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L73:
            com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.NEWSESSION     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L7a
            r6.c(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
        L7a:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r3.endTransaction()     // Catch: java.lang.Throwable -> L8a
            goto L8a
        L81:
            r2 = r3
            goto L85
        L83:
            r2 = r3
            goto L94
        L85:
            if (r2 == 0) goto L8a
        L87:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8a
        L8a:
            android.content.Context r7 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r7 = com.umeng.analytics.pro.i.a(r7)
            r7.b()
            goto L9c
        L94:
            android.content.Context r7 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L9d
            com.umeng.analytics.pro.j.a(r7)     // Catch: java.lang.Throwable -> L9d
            if (r2 == 0) goto L8a
            goto L87
        L9c:
            return r1
        L9d:
            r7 = move-exception
            if (r2 == 0) goto La3
            r2.endTransaction()     // Catch: java.lang.Throwable -> La3
        La3:
            android.content.Context r8 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r8 = com.umeng.analytics.pro.i.a(r8)
            r8.b()
            goto Lae
        Lad:
            throw r7
        Lae:
            goto Lad
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.k$a):boolean");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(boolean r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            if (r4 == 0) goto L18
            if (r3 == 0) goto L4d
            java.lang.String r3 = "delete from __sd"
            r0.execSQL(r3)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            goto L4d
        L18:
            java.util.List<java.lang.String> r3 = r2.f10428i     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            if (r3 <= 0) goto L4d
            r3 = 0
        L21:
            java.util.List<java.lang.String> r4 = r2.f10428i     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            if (r3 >= r4) goto L4d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r4.<init>()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r1 = "delete from __sd where __ii=\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.util.List<java.lang.String> r1 = r2.f10428i     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r4.append(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r1 = "\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            int r3 = r3 + 1
            goto L21
        L4d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            goto L53
        L51:
            if (r0 == 0) goto L56
        L53:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L56
        L56:
            android.content.Context r3 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r3 = com.umeng.analytics.pro.i.a(r3)
            r3.b()
            goto L68
        L60:
            android.content.Context r3 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L69
            com.umeng.analytics.pro.j.a(r3)     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L56
            goto L53
        L68:
            return
        L69:
            r3 = move-exception
            if (r0 == 0) goto L6f
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6f
        L6f:
            android.content.Context r4 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.i.a(r4)
            r4.b()
            goto L7a
        L79:
            throw r3
        L7a:
            goto L79
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.b(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        if (r4 != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long a(java.lang.String r16) {
        /*
            r15 = this;
            java.lang.String r0 = "__f"
            r1 = 0
            r2 = 0
            android.content.Context r4 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L55
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.i.a(r4)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L55
            android.database.sqlite.SQLiteDatabase r4 = r4.a()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L55
            r4.beginTransaction()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L56
            r5 = 1
            java.lang.String[] r8 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L56
            r5 = 0
            r8[r5] = r0     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L56
            java.lang.String r6 = "__sd"
            java.lang.String r9 = "__ii=? "
            java.lang.String[] r10 = new java.lang.String[]{r16}     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L56
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r5 = r15
            r7 = r4
            android.database.Cursor r1 = r5.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L56
            if (r1 == 0) goto L37
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L56
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L56
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L56
        L37:
            if (r1 == 0) goto L5d
            r1.close()     // Catch: java.lang.Exception -> L60
            goto L5d
        L3d:
            r0 = move-exception
            goto L41
        L3f:
            r0 = move-exception
            r4 = r1
        L41:
            if (r1 == 0) goto L46
            r1.close()     // Catch: java.lang.Exception -> L4b
        L46:
            if (r4 == 0) goto L4b
            r4.endTransaction()     // Catch: java.lang.Exception -> L4b
        L4b:
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)
            r1.b()
            throw r0
        L55:
            r4 = r1
        L56:
            if (r1 == 0) goto L5b
            r1.close()     // Catch: java.lang.Exception -> L60
        L5b:
            if (r4 == 0) goto L60
        L5d:
            r4.endTransaction()     // Catch: java.lang.Exception -> L60
        L60:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if (r0 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            if (r1 != 0) goto L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r1.<init>()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            java.lang.String r2 = "delete from __is where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r1.append(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            java.lang.String r4 = "\""
            r1.append(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
        L2d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            goto L33
        L31:
            if (r0 == 0) goto L36
        L33:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L36
        L36:
            android.content.Context r4 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.i.a(r4)
            r4.b()
            goto L48
        L40:
            android.content.Context r4 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L49
            com.umeng.analytics.pro.j.a(r4)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L36
            goto L33
        L48:
            return
        L49:
            r4 = move-exception
            if (r0 == 0) goto L4f
            r0.endTransaction()     // Catch: java.lang.Throwable -> L4f
        L4f:
            android.content.Context r0 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
            r0.b()
            goto L5a
        L59:
            throw r4
        L5a:
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.b(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:52:0x004f, B:54:0x0055, B:15:0x0066, B:17:0x0071, B:18:0x0076, B:26:0x0085, B:29:0x008b, B:31:0x0091, B:38:0x0097, B:40:0x00a5, B:33:0x0094), top: B:51:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004f A[EXC_TOP_SPLITTER, LOOP:1: B:51:0x004f->B:54:0x0055, LOOP_START, PHI: r13
      0x004f: PHI (r13v2 java.lang.String) = (r13v7 java.lang.String), (r13v3 java.lang.String) binds: [B:14:0x004d, B:54:0x0055] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r16, org.json.JSONObject r17, android.database.sqlite.SQLiteDatabase r18, java.lang.String r19) {
        /*
            r15 = this;
            r10 = r15
            r0 = r17
            r11 = r19
            java.lang.String r12 = "=\""
            java.lang.String r1 = "__b"
            java.lang.String r2 = "__a"
            r13 = 0
            boolean r3 = r2.equals(r11)     // Catch: java.lang.Throwable -> Lde
            if (r3 == 0) goto L22
            org.json.JSONArray r0 = r0.optJSONArray(r2)     // Catch: java.lang.Throwable -> Lde
            if (r0 == 0) goto L21
            int r1 = r0.length()     // Catch: java.lang.Throwable -> Lde
            if (r1 > 0) goto L1f
            goto L21
        L1f:
            r14 = r0
            goto L36
        L21:
            return
        L22:
            boolean r2 = r1.equals(r11)     // Catch: java.lang.Throwable -> Lde
            if (r2 == 0) goto L35
            org.json.JSONArray r0 = r0.optJSONArray(r1)     // Catch: java.lang.Throwable -> Lde
            if (r0 == 0) goto L34
            int r1 = r0.length()     // Catch: java.lang.Throwable -> Lde
            if (r1 > 0) goto L1f
        L34:
            return
        L35:
            r14 = r13
        L36:
            java.lang.String[] r3 = new java.lang.String[]{r19}     // Catch: java.lang.Throwable -> Lde
            java.lang.String r1 = "__sd"
            java.lang.String r4 = "__ii=? "
            java.lang.String[] r5 = new java.lang.String[]{r16}     // Catch: java.lang.Throwable -> Lde
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r0 = r15
            r2 = r18
            android.database.Cursor r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> Lde
            if (r0 == 0) goto L66
        L4f:
            boolean r1 = r0.moveToNext()     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L66
            int r1 = r0.getColumnIndex(r11)     // Catch: java.lang.Throwable -> L62
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L62
            java.lang.String r13 = r15.d(r1)     // Catch: java.lang.Throwable -> L62
            goto L4f
        L62:
            r13 = r0
            goto Ldf
        L66:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L62
            r1.<init>()     // Catch: java.lang.Throwable -> L62
            boolean r2 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L76
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L62
            r1.<init>(r13)     // Catch: java.lang.Throwable -> L62
        L76:
            int r2 = r1.length()     // Catch: java.lang.Throwable -> L62
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 <= r3) goto L84
            if (r0 == 0) goto L83
            r0.close()
        L83:
            return
        L84:
            r2 = 0
        L85:
            int r3 = r14.length()     // Catch: java.lang.Throwable -> L62
            if (r2 >= r3) goto L97
            org.json.JSONObject r3 = r14.getJSONObject(r2)     // Catch: java.lang.Throwable -> L62 org.json.JSONException -> L94
            if (r3 == 0) goto L94
            r1.put(r3)     // Catch: java.lang.Throwable -> L62
        L94:
            int r2 = r2 + 1
            goto L85
        L97:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L62
            java.lang.String r1 = r15.c(r1)     // Catch: java.lang.Throwable -> L62
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto Ld8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r2.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r3 = "update __sd set "
            r2.append(r3)     // Catch: java.lang.Throwable -> L62
            r2.append(r11)     // Catch: java.lang.Throwable -> L62
            r2.append(r12)     // Catch: java.lang.Throwable -> L62
            r2.append(r1)     // Catch: java.lang.Throwable -> L62
            java.lang.String r1 = "\" where "
            r2.append(r1)     // Catch: java.lang.Throwable -> L62
            java.lang.String r1 = "__ii"
            r2.append(r1)     // Catch: java.lang.Throwable -> L62
            r2.append(r12)     // Catch: java.lang.Throwable -> L62
            r1 = r16
            r2.append(r1)     // Catch: java.lang.Throwable -> L62
            java.lang.String r1 = "\""
            r2.append(r1)     // Catch: java.lang.Throwable -> L62
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L62
            r2 = r18
            r2.execSQL(r1)     // Catch: java.lang.Throwable -> L62
        Ld8:
            if (r0 == 0) goto Le4
            r0.close()
            goto Le4
        Lde:
        Ldf:
            if (r13 == 0) goto Le4
            r13.close()
        Le4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(org.json.JSONObject r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(org.json.JSONObject, java.lang.String):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(org.json.JSONObject r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0064, code lost:
    
        if (r0 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r6, boolean r7) {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            if (r7 == 0) goto L18
            if (r6 == 0) goto L53
            java.lang.String r6 = "delete from __is"
            r0.execSQL(r6)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            goto L53
        L18:
            java.util.List<java.lang.String> r6 = r5.f10431l     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r7 = 0
            if (r6 <= 0) goto L4c
            r1 = 0
        L22:
            if (r7 >= r6) goto L4b
            java.util.List<java.lang.String> r2 = r5.f10431l     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.Object r2 = r2.get(r7)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            if (r2 != 0) goto L2f
            r1 = 1
        L2f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.<init>()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r4 = "delete from __is where __ii=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r3.append(r2)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r2 = "\""
            r3.append(r2)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            int r7 = r7 + 1
            goto L22
        L4b:
            r7 = r1
        L4c:
            if (r7 == 0) goto L53
            java.lang.String r6 = "delete from __is where __ii is null"
            r0.execSQL(r6)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
        L53:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            goto L66
        L57:
            android.content.Context r6 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L73
            com.umeng.analytics.pro.j.a(r6)     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L69
            goto L66
        L5f:
            android.content.Context r6 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L73
            com.umeng.analytics.pro.j.a(r6)     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L69
        L66:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L69
        L69:
            android.content.Context r6 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r6 = com.umeng.analytics.pro.i.a(r6)
            r6.b()
            return
        L73:
            r6 = move-exception
            if (r0 == 0) goto L79
            r0.endTransaction()     // Catch: java.lang.Throwable -> L79
        L79:
            android.content.Context r7 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r7 = com.umeng.analytics.pro.i.a(r7)
            r7.b()
            goto L84
        L83:
            throw r6
        L84:
            goto L83
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0078, code lost:
    
        if (r0 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = "\""
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            if (r1 != 0) goto L60
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r2 = "delete from __er where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r2 = "delete from __et where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.util.List<java.lang.Integer> r1 = r3.f10429j     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.clear()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r2 = "delete from __sd where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
        L60:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            goto L66
        L64:
            if (r0 == 0) goto L69
        L66:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L69
        L69:
            android.content.Context r4 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r4 = com.umeng.analytics.pro.i.a(r4)
            r4.b()
            goto L7b
        L73:
            android.content.Context r4 = com.umeng.analytics.pro.k.f10423d     // Catch: java.lang.Throwable -> L7c
            com.umeng.analytics.pro.j.a(r4)     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L69
            goto L66
        L7b:
            return
        L7c:
            r4 = move-exception
            if (r0 == 0) goto L82
            r0.endTransaction()     // Catch: java.lang.Throwable -> L82
        L82:
            android.content.Context r5 = com.umeng.analytics.pro.k.f10423d
            com.umeng.analytics.pro.i r5 = com.umeng.analytics.pro.i.a(r5)
            r5.b()
            goto L8d
        L8c:
            throw r4
        L8d:
            goto L8c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.k.a(boolean, java.lang.String):void");
    }
}
