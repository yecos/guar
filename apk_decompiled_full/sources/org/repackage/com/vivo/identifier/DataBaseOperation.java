package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    */
    public String a(int i10, String str) {
        Uri uri;
        Uri uri2;
        ?? r82;
        Cursor cursor;
        Cursor cursor2 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        String str2 = null;
        try {
            if (i10 == 0) {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
            } else if (i10 == 1) {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
            } else if (i10 == 2) {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
            } else if (i10 == 3) {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/UDID");
            } else if (i10 == 4) {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_" + str);
            } else if (i10 != 5) {
                uri2 = null;
                r82 = i10;
                if (uri2 != null) {
                    return null;
                }
                try {
                    cursor = this.f17939t.getContentResolver().query(uri2, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                str2 = cursor.getString(cursor.getColumnIndex("value"));
                            }
                        } catch (Exception unused) {
                            Log.e(f17920a, "return cursor is error");
                        }
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } else {
                uri = Uri.parse(f17922c);
            }
            if (uri2 != null) {
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = r82;
        }
        uri2 = uri;
        r82 = uri;
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
