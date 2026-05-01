package com.umeng.pagesdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import com.efs.sdk.base.EfsReporter;

/* loaded from: classes3.dex */
public class PageManger {
    public static final String TAG = "PageManger";

    /* renamed from: a, reason: collision with root package name */
    private static Context f12263a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f12264b = false;

    /* renamed from: c, reason: collision with root package name */
    private static EfsReporter f12265c = null;

    /* renamed from: d, reason: collision with root package name */
    private static PageConfigManger f12266d = null;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f12267e = true;

    /* renamed from: f, reason: collision with root package name */
    private static float f12268f = 0.0f;
    public static boolean isDebug = true;

    public static Context getApplicationContext() {
        return f12263a;
    }

    public static PageConfigManger getPageConfigManger() {
        return f12266d;
    }

    public static float getRefreshRate() {
        return f12268f;
    }

    public static EfsReporter getReporter() {
        return f12265c;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    Log.e(TAG, "init page manager error! parameter is null!");
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isInit()) {
            if (isDebug) {
                Log.e(TAG, "invalid init ！");
            }
        } else {
            f12263a = context.getApplicationContext();
            f12265c = efsReporter;
            f12266d = new PageConfigManger(context, efsReporter);
            f12264b = true;
        }
    }

    public static boolean isControlMainThread() {
        return f12267e;
    }

    public static boolean isInit() {
        return f12264b;
    }

    public static void onTracePageBegin(Activity activity, String str) {
        try {
            onTracePageBegin(activity, str, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onTracePageEnd(Activity activity, String str) {
        try {
            onTracePageEnd(activity, str, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setControlMainThread(boolean z10) {
        f12267e = z10;
    }

    public static void onTracePageBegin(Activity activity, String str, boolean z10) {
        float refreshRate;
        Display display;
        if (activity != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!z10 && (str.equals("onCreate") || str.equals("onStart") || str.equals("onResume") || str.equals("onPause"))) {
                        if (isDebug) {
                            Log.e(TAG, "tracePageBegin. parameter illegality!");
                            return;
                        }
                        return;
                    }
                    if (str.length() > 10) {
                        if (isDebug) {
                            Log.e(TAG, "tracePageBegin. method name is " + str + "method name over length !");
                            return;
                        }
                        return;
                    }
                    if (f12267e && !e.a(activity.getApplicationContext()) && isDebug) {
                        Log.e(TAG, "tracePageBegin. Non main process !");
                    }
                    String name = activity.getClass().getName();
                    if (f12268f <= 0.0f) {
                        if (Build.VERSION.SDK_INT >= 30) {
                            display = activity.getDisplay();
                            refreshRate = display.getRefreshRate();
                        } else {
                            refreshRate = activity.getWindowManager().getDefaultDisplay().getRefreshRate();
                        }
                        f12268f = refreshRate;
                    }
                    d.a(name, str, z10);
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isDebug) {
            Log.e(TAG, "tracePageBegin. parameter null!");
        }
    }

    public static void onTracePageEnd(Activity activity, String str, boolean z10) {
        if (activity != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!z10 && (str.equals("onCreate") || str.equals("onStart") || str.equals("onResume") || str.equals("onPause"))) {
                        if (isDebug) {
                            Log.e(TAG, "tracePageEnd. parameter illegality!");
                            return;
                        }
                        return;
                    } else {
                        if (str.length() <= 10) {
                            if (f12267e && !e.a(activity.getApplicationContext()) && isDebug) {
                                Log.e(TAG, "tracePageBegin. Non main process !");
                            }
                            d.b(activity.getClass().getName(), str, z10);
                            return;
                        }
                        if (isDebug) {
                            Log.e(TAG, "tracePageEnd. method name is " + str + "method name over length !");
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isDebug) {
            Log.e(TAG, "tracePageEnd. parameter null!");
        }
    }
}
