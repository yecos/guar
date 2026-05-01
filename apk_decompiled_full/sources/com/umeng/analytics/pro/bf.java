package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;

/* loaded from: classes3.dex */
public class bf {

    /* renamed from: a, reason: collision with root package name */
    private static be f10001a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f10002b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f10003c = false;

    public static synchronized String a(Context context) {
        synchronized (bf.class) {
            if (!UMConfigure.shouldCollectOaid()) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAID(): oaid开关已关闭。");
                return null;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** real call OpenDeviceId.getOaid()");
            if (context == null) {
                return null;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return null;
            }
            if (f10001a == null) {
                f10001a = bh.a();
            }
            be beVar = f10001a;
            if (beVar != null) {
                try {
                    String a10 = beVar.a(context);
                    if (!TextUtils.isEmpty(a10)) {
                        f10002b = a10;
                    }
                    f10003c = true;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "OpenDeviceId:getOAID() result: " + f10002b);
                    return f10002b;
                } catch (Throwable unused) {
                }
            }
            return null;
        }
    }

    public static String b(Context context) {
        if (UMConfigure.shouldCollectOaid()) {
            return f10003c ? f10002b : a(context);
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAIDFromCache(): oaid开关已关闭。");
        return null;
    }

    @Deprecated
    public static synchronized String c(Context context) {
        synchronized (bf.class) {
            if (UMConfigure.shouldCollectOaid()) {
                return null;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaid(): oaid开关已关闭。");
            return null;
        }
    }

    @Deprecated
    public static synchronized String d(Context context) {
        synchronized (bf.class) {
            if (UMConfigure.shouldCollectOaid()) {
                return null;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaidFromCache(): oaid开关已关闭。");
            return null;
        }
    }
}
