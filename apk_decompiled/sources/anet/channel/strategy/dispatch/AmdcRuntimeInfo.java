package anet.channel.strategy.dispatch;

import android.content.Context;
import anet.channel.util.ALog;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* loaded from: classes.dex */
public class AmdcRuntimeInfo {
    private static final String TAG = "awcn.AmdcRuntimeInfo";
    private static volatile int amdcLimitLevel = 0;
    private static volatile long amdcLimitTime = 0;
    public static volatile String appChannel = null;
    public static volatile String appName = null;
    public static volatile String appVersion = null;
    private static volatile Context context = null;
    private static volatile boolean forceHttps = false;
    private static IAmdcSign iSign = null;
    public static volatile double latitude = 0.0d;
    public static volatile double longitude = 0.0d;
    private static Map<String, String> params = null;
    private static volatile boolean timeoutRetryEnable = true;

    public static int getAmdcLimitLevel() {
        if (amdcLimitLevel > 0 && System.currentTimeMillis() - amdcLimitTime > 0) {
            amdcLimitTime = 0L;
            amdcLimitLevel = 0;
        }
        return amdcLimitLevel;
    }

    public static Context getContext() {
        return context;
    }

    public static synchronized Map<String, String> getParams() {
        synchronized (AmdcRuntimeInfo.class) {
            if (params == null) {
                return Collections.EMPTY_MAP;
            }
            return new HashMap(params);
        }
    }

    public static IAmdcSign getSign() {
        return iSign;
    }

    public static boolean isForceHttps() {
        return forceHttps;
    }

    public static boolean isTimeoutRetryEnable() {
        return timeoutRetryEnable;
    }

    public static void setAppInfo(String str, String str2, String str3) {
        appName = str;
        appVersion = str2;
        appChannel = str3;
    }

    public static void setContext(Context context2) {
        context = context2;
    }

    public static void setForceHttps(boolean z10) {
        forceHttps = z10;
    }

    public static synchronized void setParam(String str, String str2) {
        synchronized (AmdcRuntimeInfo.class) {
            if (params == null) {
                params = new HashMap();
            }
            params.put(str, str2);
        }
    }

    public static void setSign(IAmdcSign iAmdcSign) {
        iSign = iAmdcSign;
    }

    public static void setTimeoutRetryEnable(boolean z10) {
        timeoutRetryEnable = z10;
    }

    public static void updateAmdcLimit(int i10, int i11) {
        ALog.i(TAG, "set amdc limit", null, FirebaseAnalytics.Param.LEVEL, Integer.valueOf(i10), AgooConstants.MESSAGE_TIME, Integer.valueOf(i11));
        if (i10 < 0 || i10 > 3) {
            return;
        }
        amdcLimitLevel = i10;
        amdcLimitTime = System.currentTimeMillis() + (i11 * 1000);
    }

    public static void updateLocation(double d10, double d11) {
        latitude = d10;
        longitude = d11;
    }
}
