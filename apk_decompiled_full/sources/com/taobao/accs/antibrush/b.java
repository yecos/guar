package com.taobao.accs.antibrush;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.utl.ALog;
import java.util.StringTokenizer;

/* loaded from: classes3.dex */
public class b {
    public static final String KEY_SEC = "sec";
    public static final String TAG = "CookieMgr";

    /* renamed from: a, reason: collision with root package name */
    public static CookieManager f9021a = null;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f9022b = false;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            try {
            } catch (Throwable th) {
                ALog.e(TAG, "setup", th, new Object[0]);
            }
            if (!GlobalConfig.enableCookie) {
                ALog.i(TAG, "disable cookie", new Object[0]);
                return;
            }
            if (f9022b) {
                return;
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 21) {
                CookieSyncManager.createInstance(context);
            }
            CookieManager cookieManager = CookieManager.getInstance();
            f9021a = cookieManager;
            cookieManager.setAcceptCookie(true);
            if (i10 < 21) {
                f9021a.removeExpiredCookie();
            }
            f9022b = true;
        }
    }

    public static String b(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        do {
            try {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("Invalid cookie name-value pair");
                }
                String trim = nextToken.substring(0, indexOf).trim();
                String trim2 = nextToken.substring(indexOf + 1).trim();
                if (KEY_SEC.equals(trim)) {
                    str2 = c(trim2);
                }
            } catch (Throwable th) {
                ALog.e(TAG, "parse", th, new Object[0]);
            }
        } while (stringTokenizer.hasMoreTokens());
        return str2;
    }

    private static String c(String str) {
        return (str == null || str.length() <= 2 || str.charAt(0) != '\"' || str.charAt(str.length() - 1) != '\"') ? (str == null || str.length() <= 2 || str.charAt(0) != '\'' || str.charAt(str.length() - 1) != '\'') ? str : str.substring(1, str.length() - 1) : str.substring(1, str.length() - 1);
    }

    private static boolean a() {
        Context context;
        if (!f9022b && (context = GlobalClientInfo.f9031a) != null) {
            a(context);
        }
        return f9022b;
    }

    public static synchronized String a(String str) {
        synchronized (b.class) {
            String str2 = null;
            if (!a()) {
                ALog.e(TAG, "cookieMgr not setup", new Object[0]);
                return null;
            }
            try {
                str2 = b(f9021a.getCookie(str));
            } catch (Throwable th) {
                ALog.e(TAG, "get cookie failed. url=" + str, th, new Object[0]);
            }
            return str2;
        }
    }
}
