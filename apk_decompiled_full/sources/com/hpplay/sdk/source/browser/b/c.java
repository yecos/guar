package com.hpplay.sdk.source.browser.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.View;
import com.hpplay.common.log.LeLog;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7467a = "Util";

    /* renamed from: b, reason: collision with root package name */
    public static String f7468b = "14255,16963";

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f7469c = new AtomicInteger(1);

    public static Bitmap a(String str) {
        return null;
    }

    public static boolean b(String str) {
        LeLog.i(f7467a, "dongle appids=" + f7468b + " current appid=" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : f7468b.split(",")) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static int a() {
        try {
            return View.generateViewId();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Deprecated
    public static Bitmap a(Context context, String str) {
        Bitmap bitmap = null;
        try {
            InputStream open = context.getAssets().open(str);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (Exception e10) {
            LeLog.w(f7467a, e10);
            return bitmap;
        }
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            LeLog.i(f7467a, "isNetworkAvailable Unavailabel");
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }
}
