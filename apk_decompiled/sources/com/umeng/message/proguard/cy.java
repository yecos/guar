package com.umeng.message.proguard;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.structure.provider.ContentUtils;
import java.util.Map;

/* loaded from: classes3.dex */
public final class cy extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    private final UriMatcher f11849a;

    public static Uri a(Context context) {
        return Uri.parse(ContentUtils.BASE_CONTENT_URI + c(context) + "/sp");
    }

    public static Uri b(Context context) {
        return Uri.parse(ContentUtils.BASE_CONTENT_URI + c(context) + "/ua");
    }

    private static String c(Context context) {
        return context.getPackageName() + ".umeng.union";
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        try {
            if (this.f11849a.match(uri) == 2 && strArr != null && strArr.length != 0) {
                ds a10 = ds.a();
                if (strArr.length == 0) {
                    return 0;
                }
                SharedPreferences.Editor edit = a10.f12014a.edit();
                int i10 = 0;
                for (String str2 : strArr) {
                    if (a10.f12014a.contains(str2)) {
                        edit.remove(str2);
                        i10++;
                    }
                }
                if (i10 > 0) {
                    edit.apply();
                }
                return i10;
            }
            return 0;
        } catch (Throwable th) {
            ce.d("Provider", "delete() ", th.getMessage());
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        int match = this.f11849a.match(uri);
        if (match == 2 || match == 11) {
            return "union";
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        try {
            if (this.f11849a.match(uri) != 2 || contentValues == null) {
                return null;
            }
            ds.a().a(contentValues.getAsString("k"), contentValues.getAsString("v"));
            return null;
        } catch (Throwable th) {
            ce.d("Provider", "insert() ", th.getMessage());
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        try {
            Context context = getContext();
            de.a(context);
            String c10 = c(context);
            this.f11849a.addURI(c10, a(context).getPath(), 2);
            this.f11849a.addURI(c10, b(context).getPath(), 11);
        } catch (Throwable th) {
            ce.d("Provider", "onCreate() ", th.getMessage());
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            int match = this.f11849a.match(uri);
            if (match != 2) {
                if (match != 11) {
                    return null;
                }
                MatrixCursor matrixCursor = new MatrixCursor(new String[]{com.umeng.analytics.pro.bd.f9977d});
                matrixCursor.addRow(new Object[]{dy.a()});
                return matrixCursor;
            }
            MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"k", "v"});
            Map<String, ?> all = ds.a().f12014a.getAll();
            if (strArr2 != null && strArr2.length != 0) {
                for (String str3 : strArr2) {
                    Object obj = all.get(str3);
                    if (obj instanceof String) {
                        matrixCursor2.addRow(new Object[]{str3, obj});
                    }
                }
                return matrixCursor2;
            }
            for (String str4 : all.keySet()) {
                Object obj2 = all.get(str4);
                if (obj2 instanceof String) {
                    matrixCursor2.addRow(new Object[]{str4, obj2});
                }
            }
            return matrixCursor2;
        } catch (Throwable th) {
            ce.d("Provider", "query() ", th.getMessage());
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            if (this.f11849a.match(uri) == 2 && contentValues != null && strArr != null && strArr.length != 0) {
                String str2 = strArr[0];
                String asString = contentValues.getAsString("v");
                if (!TextUtils.isEmpty(str2)) {
                    ds.a().a(str2, asString);
                    return 1;
                }
            }
            return 0;
        } catch (Throwable th) {
            ce.d("Provider", "update() ", th.getMessage());
        }
        return 0;
    }
}
