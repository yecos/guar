package com.umeng.logsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.taobao.accs.common.Constants;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class ULogManager {
    public static final String TAG = "CodeLogManager";

    /* renamed from: a, reason: collision with root package name */
    private static Context f11300a = null;

    /* renamed from: b, reason: collision with root package name */
    private static ULogConfigManager f11301b = null;

    /* renamed from: c, reason: collision with root package name */
    private static EfsReporter f11302c = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f11303d = false;

    /* renamed from: e, reason: collision with root package name */
    private static String f11304e = "";

    /* renamed from: f, reason: collision with root package name */
    private static String f11305f = "";

    /* renamed from: h, reason: collision with root package name */
    private static long f11307h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static long f11308i = 0;
    public static boolean isDebug = true;

    /* renamed from: g, reason: collision with root package name */
    private static JSONArray f11306g = new JSONArray();

    /* renamed from: j, reason: collision with root package name */
    private static Handler f11309j = new Handler(Looper.getMainLooper()) { // from class: com.umeng.logsdk.ULogManager.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 == 0) {
                ULogManager.a(message);
            } else {
                if (i10 != 1) {
                    return;
                }
                ULogManager.e();
            }
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private static int f11310k = 0;

    public static /* synthetic */ int b() {
        int i10 = f11310k;
        f11310k = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int d() {
        int i10 = f11310k;
        f11310k = i10 - 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e() {
        /*
            org.json.JSONArray r0 = com.umeng.logsdk.ULogManager.f11306g
            int r0 = r0.length()
            if (r0 <= 0) goto L82
            long r0 = java.lang.System.currentTimeMillis()
            com.umeng.logsdk.ULogManager.f11308i = r0
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L53
            r1.<init>()     // Catch: java.lang.Throwable -> L53
            java.lang.String r0 = "taskid"
            java.lang.String r2 = ""
            r1.put(r0, r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = "status"
            r2 = 0
            r1.put(r0, r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = "time_start"
            long r2 = com.umeng.logsdk.ULogManager.f11307h     // Catch: java.lang.Throwable -> L51
            r1.put(r0, r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = "time_end"
            long r2 = com.umeng.logsdk.ULogManager.f11308i     // Catch: java.lang.Throwable -> L51
            r1.put(r0, r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = "uid"
            java.lang.String r2 = getUserID()     // Catch: java.lang.Throwable -> L51
            byte[] r2 = r2.getBytes()     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = com.umeng.logsdk.c.b(r2)     // Catch: java.lang.Throwable -> L51
            r1.put(r0, r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = "did"
            java.lang.String r2 = getDeviceID()     // Catch: java.lang.Throwable -> L51
            r1.put(r0, r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = "body"
            org.json.JSONArray r2 = com.umeng.logsdk.ULogManager.f11306g     // Catch: java.lang.Throwable -> L51
            r1.put(r0, r2)     // Catch: java.lang.Throwable -> L51
            goto L5a
        L51:
            r0 = move-exception
            goto L57
        L53:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L57:
            r0.printStackTrace()
        L5a:
            if (r1 == 0) goto L82
            com.efs.sdk.base.protocol.record.EfsJSONLog r0 = new com.efs.sdk.base.protocol.record.EfsJSONLog
            java.lang.String r2 = "codelogperf"
            r0.<init>(r2)
            long r2 = com.umeng.logsdk.ULogManager.f11307h
            r0.setLogBeginTime(r2)
            long r2 = com.umeng.logsdk.ULogManager.f11308i
            r0.setLogEndTime(r2)
            java.lang.String r2 = "codelog"
            r0.put(r2, r1)
            com.efs.sdk.base.EfsReporter r1 = getReporter()
            if (r1 == 0) goto L82
            r1.send(r0)
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            com.umeng.logsdk.ULogManager.f11306g = r0
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.logsdk.ULogManager.e():void");
    }

    public static String getDeviceID() {
        return f11304e;
    }

    public static EfsReporter getReporter() {
        return f11302c;
    }

    public static ULogConfigManager getULogConfigManager() {
        return f11301b;
    }

    public static String getUserID() {
        return f11305f;
    }

    public static void i(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 2;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f11309j.sendMessage(message);
    }

    public static void init(Context context, EfsReporter efsReporter) {
        try {
            if (context == null || efsReporter == null) {
                if (isDebug) {
                    Log.e(TAG, "init code log manager error! parameter is null!");
                }
            } else if (isInit()) {
                if (isDebug) {
                    Log.e(TAG, "invalid init ！");
                }
            } else {
                Context applicationContext = context.getApplicationContext();
                f11300a = applicationContext;
                f11302c = efsReporter;
                f11301b = new ULogConfigManager(applicationContext, efsReporter);
                registerActivityCallback(context);
                f11303d = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean isInit() {
        return f11303d;
    }

    public static void registerActivityCallback(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.logsdk.ULogManager.2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityResumed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStarted(Activity activity) {
                    ULogManager.b();
                    int unused = ULogManager.f11310k;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStopped(Activity activity) {
                    ULogManager.d();
                    if (ULogManager.f11310k == 0) {
                        ULogManager.e();
                    }
                }
            });
        }
    }

    public static void setDeviceID(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 128) {
            f11304e = str;
        } else if (isDebug) {
            Log.e(TAG, "device id over length!");
        }
    }

    public static void setUserID(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 128) {
            f11305f = c.a(str.getBytes());
        } else if (isDebug) {
            Log.e(TAG, "user id over length!");
        }
    }

    public static void v(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 0;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f11309j.sendMessage(message);
    }

    public static void w(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 3;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f11309j.sendMessage(message);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(android.os.Message r7) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.logsdk.ULogManager.a(android.os.Message):void");
    }

    public static void d(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 1;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f11309j.sendMessage(message);
    }

    public static void e(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 4;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f11309j.sendMessage(message);
    }
}
