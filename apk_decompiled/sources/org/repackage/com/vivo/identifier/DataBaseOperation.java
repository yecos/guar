package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

/* loaded from: classes.dex */
public class DataBaseOperation {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17920a = "VMS_SDK_DB";

    /* renamed from: b, reason: collision with root package name */
    private static final String f17921b = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: c, reason: collision with root package name */
    private static final String f17922c = "content://com.vivo.abe.exidentifier/guid";

    /* renamed from: d, reason: collision with root package name */
    private static final String f17923d = "value";

    /* renamed from: e, reason: collision with root package name */
    private static final String f17924e = "OAID";

    /* renamed from: f, reason: collision with root package name */
    private static final String f17925f = "AAID";

    /* renamed from: g, reason: collision with root package name */
    private static final String f17926g = "VAID";

    /* renamed from: h, reason: collision with root package name */
    private static final String f17927h = "OAIDBLACK";

    /* renamed from: i, reason: collision with root package name */
    private static final String f17928i = "OAIDSTATUS";

    /* renamed from: j, reason: collision with root package name */
    private static final String f17929j = "STATISTICS";

    /* renamed from: k, reason: collision with root package name */
    private static final int f17930k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static final int f17931l = 1;

    /* renamed from: m, reason: collision with root package name */
    private static final int f17932m = 2;

    /* renamed from: n, reason: collision with root package name */
    private static final int f17933n = 3;

    /* renamed from: o, reason: collision with root package name */
    private static final int f17934o = 4;

    /* renamed from: p, reason: collision with root package name */
    private static final int f17935p = 5;

    /* renamed from: q, reason: collision with root package name */
    private static final int f17936q = 6;

    /* renamed from: r, reason: collision with root package name */
    private static final int f17937r = 7;

    /* renamed from: s, reason: collision with root package name */
    private static final String f17938s = "UDID";

    /* renamed from: t, reason: collision with root package name */
    private Context f17939t;

    public DataBaseOperation(Context context) {
        this.f17939t = context;
    }

    public boolean a(int i10, String str, ContentValues[] contentValuesArr) {
        Uri parse;
        int bulkInsert;
        if (i10 == 6) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i10 != 7) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            bulkInsert = this.f17939t.getContentResolver().bulkInsert(parse, contentValuesArr);
            StringBuilder sb = new StringBuilder();
            sb.append("insert:");
            sb.append(bulkInsert);
        } catch (Exception unused) {
            Log.e(f17920a, "return insert is error");
        }
        return bulkInsert != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
    
        if (r8 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0091, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a2, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009f, code lost:
    
        if (r8 == null) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(int r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L64
            r1 = 1
            if (r8 == r1) goto L4e
            r1 = 2
            if (r8 == r1) goto L38
            r1 = 3
            if (r8 == r1) goto L31
            r1 = 4
            if (r8 == r1) goto L1b
            r9 = 5
            if (r8 == r9) goto L14
            r2 = r0
            goto L6b
        L14:
            java.lang.String r8 = "content://com.vivo.abe.exidentifier/guid"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L1b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L31:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/UDID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L38:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L4e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L64:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
        L6a:
            r2 = r8
        L6b:
            if (r2 != 0) goto L6e
            return r0
        L6e:
            android.content.Context r8 = r7.f17939t     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L97
            if (r8 == 0) goto L8f
            boolean r9 = r8.moveToNext()     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> La3
            if (r9 == 0) goto L8f
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> La3
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> La3
            r0 = r9
        L8f:
            if (r8 == 0) goto La2
        L91:
            r8.close()
            goto La2
        L95:
            r9 = move-exception
            goto La5
        L97:
            r8 = r0
        L98:
            java.lang.String r9 = "VMS_SDK_DB"
            java.lang.String r1 = "return cursor is error"
            android.util.Log.e(r9, r1)     // Catch: java.lang.Throwable -> La3
            if (r8 == 0) goto La2
            goto L91
        La2:
            return r0
        La3:
            r9 = move-exception
            r0 = r8
        La5:
            if (r0 == 0) goto Laa
            r0.close()
        Laa:
            goto Lac
        Lab:
            throw r9
        Lac:
            goto Lab
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.vivo.identifier.DataBaseOperation.a(int, java.lang.String):java.lang.String");
    }

    public boolean a(int i10, String str, String str2, String str3) {
        Uri parse;
        int delete;
        if (i10 != 6) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            delete = this.f17939t.getContentResolver().delete(parse, "packageName=? and uid=?", new String[]{str2, str3});
            StringBuilder sb = new StringBuilder();
            sb.append("delete:");
            sb.append(delete);
        } catch (Exception unused) {
            Log.e(f17920a, "return delete is error");
        }
        return delete != 0;
    }
}
