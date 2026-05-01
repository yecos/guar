package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.taobao.accs.common.Constants;

/* loaded from: classes.dex */
class b {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b f17893e = null;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f17894f = false;

    /* renamed from: h, reason: collision with root package name */
    private BroadcastReceiver f17900h;

    /* renamed from: a, reason: collision with root package name */
    OpenId f17895a = new OpenId("udid");

    /* renamed from: b, reason: collision with root package name */
    OpenId f17896b = new OpenId("oaid");

    /* renamed from: d, reason: collision with root package name */
    OpenId f17898d = new OpenId("vaid");

    /* renamed from: c, reason: collision with root package name */
    OpenId f17897c = new OpenId("aaid");

    /* renamed from: g, reason: collision with root package name */
    private SupportInfo f17899g = new SupportInfo();

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0095  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(Context context, OpenId openId) {
        String str;
        Cursor query;
        String concat;
        a("queryId : " + openId.f17884c);
        ?? r02 = 0;
        r0 = null;
        r02 = 0;
        String str2 = null;
        Cursor cursor = null;
        try {
            try {
                query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{openId.f17884c}, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e10) {
            e = e10;
            str = null;
        }
        try {
        } catch (Exception e11) {
            e = e11;
            str = str2;
            cursor = query;
            a("queryId, Exception : " + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            r02 = str;
            return r02;
        } catch (Throwable th2) {
            th = th2;
            r02 = query;
        }
        if (query == null) {
            if (a(context, false)) {
                concat = "forceQuery isSupported : ".concat(String.valueOf(a(context, true)));
                a(concat);
                r02 = str2;
            }
            if (query != null) {
            }
            return r02;
        }
        ValueData a10 = a(query);
        String str3 = a10.f17890a;
        openId.a(str3);
        openId.a(a10.f17892c);
        openId.a(a10.f17891b);
        a(openId.f17884c + " errorCode : " + openId.f17885d);
        r02 = str3;
        if (a10.f17891b != 1000) {
            b(context);
            r02 = str3;
            if (!a(context, false)) {
                concat = "not support, forceQuery isSupported: ".concat(String.valueOf(a(context, true)));
                str2 = str3;
                a(concat);
                r02 = str2;
            }
        }
        if (query != null) {
            query.close();
        }
        return r02;
        th = th;
        if (r02 != 0) {
            r02.close();
        }
        throw th;
    }

    public final String a(Context context, OpenId openId) {
        String str;
        if (openId == null) {
            str = "getId, openId = null.";
        } else {
            if (openId.a()) {
                return openId.f17883b;
            }
            if (a(context, true)) {
                return b(context, openId);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    private static String a(PackageManager packageManager, String str) {
        ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    private static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            a("getAppVersion, Exception : " + e10.getMessage());
            return null;
        }
    }

    private static ValueData a(Cursor cursor) {
        String str;
        ValueData valueData = new ValueData(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    valueData.f17890a = cursor.getString(columnIndex);
                } else {
                    a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex(Constants.KEY_HTTP_CODE);
                if (columnIndex2 >= 0) {
                    valueData.f17891b = cursor.getInt(columnIndex2);
                } else {
                    a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex(DialogManager.DIALOG_EXPIRED);
                if (columnIndex3 >= 0) {
                    valueData.f17892c = cursor.getLong(columnIndex3);
                } else {
                    a("parseExpired fail, index < 0.");
                }
                return valueData;
            }
            str = "parseValue fail, cursor is closed.";
        }
        a(str);
        return valueData;
    }

    private synchronized void b(Context context) {
        if (this.f17900h != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        a aVar = new a();
        this.f17900h = aVar;
        context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    public static final b a() {
        if (f17893e == null) {
            synchronized (b.class) {
                if (f17893e == null) {
                    f17893e = new b();
                }
            }
        }
        return f17893e;
    }

    public static void a(String str) {
    }

    public static void a(boolean z10) {
        f17894f = z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
    
        if (r7 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0033, code lost:
    
        if ("0".equals(r1.f17890a) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(Context context) {
        a("querySupport version : 1.0.8");
        boolean z10 = false;
        Cursor cursor = null;
        try {
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (cursor != null) {
                    ValueData a10 = a(cursor);
                    if (1000 == a10.f17891b) {
                    }
                    z10 = true;
                    cursor.close();
                    return z10;
                }
            } catch (Exception e10) {
                a("querySupport, Exception : " + e10.getMessage());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final boolean a(Context context, boolean z10) {
        if (this.f17899g.a() && !z10) {
            return this.f17899g.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String a10 = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(a10)) {
            return false;
        }
        String b10 = b(packageManager, a10);
        if (this.f17899g.a() && this.f17899g.a(b10)) {
            a("use same version cache, safeVersion : ".concat(String.valueOf(b10)));
            return this.f17899g.b();
        }
        this.f17899g.b(b10);
        boolean a11 = a(context);
        a("query support, result : ".concat(String.valueOf(a11)));
        this.f17899g.a(a11);
        return a11;
    }
}
