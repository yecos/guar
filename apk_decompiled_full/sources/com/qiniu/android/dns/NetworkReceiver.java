package com.qiniu.android.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.qiniu.android.dns.a;
import com.umeng.analytics.pro.bd;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class NetworkReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f9003a = Uri.parse("content://telephony/carriers/preferapn");

    /* renamed from: b, reason: collision with root package name */
    public static o7.a f9004b;

    public static a a(NetworkInfo networkInfo, Context context) {
        a.EnumC0167a enumC0167a;
        String extraInfo;
        if (networkInfo == null) {
            return a.f9005c;
        }
        int i10 = 0;
        if (networkInfo.getType() == 1) {
            enumC0167a = a.EnumC0167a.WIFI;
        } else {
            a.EnumC0167a enumC0167a2 = a.EnumC0167a.MOBILE;
            Cursor query = context.getContentResolver().query(f9003a, null, null, null, null);
            if (query != null) {
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex(bd.f9986m));
                if (!TextUtils.isEmpty(string) && (string.startsWith("ctwap") || string.startsWith("ctnet"))) {
                    i10 = 1;
                }
            }
            query.close();
            if (i10 != 1 && (extraInfo = networkInfo.getExtraInfo()) != null) {
                String lowerCase = extraInfo.toLowerCase(Locale.getDefault());
                if (lowerCase.equals("cmwap") || lowerCase.equals("cmnet")) {
                    i10 = 3;
                } else if (lowerCase.equals("3gnet") || lowerCase.equals("uninet") || lowerCase.equals("3gwap") || lowerCase.equals("uniwap")) {
                    i10 = 2;
                }
            }
            enumC0167a = enumC0167a2;
        }
        return new a(enumC0167a, i10);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (f9004b == null) {
            return;
        }
        f9004b.d(a(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo(), context));
    }
}
