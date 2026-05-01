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
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.commonsdk.framework.UMModuleRegister;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

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
    */
    public static void e() {
        JSONObject jSONObject;
        Throwable th;
        if (f11306g.length() > 0) {
            f11308i = System.currentTimeMillis();
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("taskid", "");
                    jSONObject.put(Constant.KEY_STATUS, 0);
                    jSONObject.put("time_start", f11307h);
                    jSONObject.put("time_end", f11308i);
                    jSONObject.put(ParamsMap.DeviceParams.KEY_UID, c.b(getUserID().getBytes()));
                    jSONObject.put("did", getDeviceID());
                    jSONObject.put("body", f11306g);
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    if (jSONObject == null) {
                    }
                }
            } catch (Throwable th3) {
                jSONObject = null;
                th = th3;
            }
            if (jSONObject == null) {
                EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_CODELOGPERF);
                efsJSONLog.setLogBeginTime(f11307h);
                efsJSONLog.setLogEndTime(f11308i);
                efsJSONLog.put("codelog", jSONObject);
                EfsReporter reporter = getReporter();
                if (reporter != null) {
                    reporter.send(efsJSONLog);
                    f11306g = new JSONArray();
                }
            }
        }
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
        bundle.putString(com.taobao.accs.common.Constants.SHARED_MESSAGE_ID_FILE, str2);
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
        bundle.putString(com.taobao.accs.common.Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f11309j.sendMessage(message);
    }

    public static void w(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 3;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(com.taobao.accs.common.Constants.SHARED_MESSAGE_ID_FILE, str2);
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
    */
    public static /* synthetic */ void a(Message message) {
        String str;
        String str2;
        JSONObject jSONObject;
        if (message == null || message.getData() == null) {
            str = "writeMemory msg or msg data is null!";
        } else {
            Bundle data = message.getData();
            if (data == null) {
                str = "writeMemory bundle is null!";
            } else {
                String string = data.getString("tag");
                String string2 = data.getString(com.taobao.accs.common.Constants.SHARED_MESSAGE_ID_FILE);
                boolean z10 = false;
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                    if (isDebug) {
                        str2 = "ULog parameter null!";
                        Log.e(TAG, str2);
                    }
                    if (z10) {
                        return;
                    }
                    JSONObject jSONObject2 = null;
                    try {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tag", string);
                            jSONObject.put(Constant.KEY_MSG, string2);
                            jSONObject.put(FirebaseAnalytics.Param.LEVEL, message.arg1);
                            jSONObject.put(AgooConstants.MESSAGE_TIME, System.currentTimeMillis());
                            jSONObject.put(UMModuleRegister.PROCESS, ProcessUtil.getCurrentProcessName());
                            jSONObject.put("thread", Thread.currentThread().getName());
                        } catch (Throwable th) {
                            th = th;
                            jSONObject2 = jSONObject;
                            th.printStackTrace();
                            jSONObject = jSONObject2;
                            if (jSONObject != null) {
                            }
                            if (f11306g.toString().getBytes().length < 18432) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (jSONObject != null) {
                        if (f11306g.length() == 0) {
                            f11307h = System.currentTimeMillis();
                        }
                        f11306g.put(jSONObject);
                        new StringBuilder("add mem is ").append(jSONObject.toString());
                    }
                    if (f11306g.toString().getBytes().length < 18432) {
                        new StringBuilder("over max size upload. size is ").append(f11306g.toString().getBytes().length);
                        e();
                        return;
                    }
                    return;
                }
                if (string.length() > a.f11319a || string2.length() > a.f11320b) {
                    if (isDebug) {
                        str2 = "ULog tag or message over length!";
                        Log.e(TAG, str2);
                    }
                    if (z10) {
                    }
                } else if (isInit()) {
                    if (!TextUtils.isEmpty(getDeviceID()) || !TextUtils.isEmpty(getUserID())) {
                        z10 = true;
                    } else if (isDebug) {
                        str2 = "ULog not set device id or user id!";
                        Log.e(TAG, str2);
                    }
                    if (z10) {
                    }
                } else {
                    if (isDebug) {
                        str2 = "ULog not init!";
                        Log.e(TAG, str2);
                    }
                    if (z10) {
                    }
                }
            }
        }
        Log.e(TAG, str);
    }

    public static void d(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 1;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(com.taobao.accs.common.Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f11309j.sendMessage(message);
    }

    public static void e(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 4;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString(com.taobao.accs.common.Constants.SHARED_MESSAGE_ID_FILE, str2);
        message.setData(bundle);
        f11309j.sendMessage(message);
    }
}
