package com.umeng.powersdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.powersdk.c;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class PowerManager {
    public static final String TAG = "PowerManager";

    /* renamed from: a, reason: collision with root package name */
    private static Context f12305a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f12306b = false;

    /* renamed from: c, reason: collision with root package name */
    private static EfsReporter f12307c = null;

    /* renamed from: d, reason: collision with root package name */
    private static PowerConfigManager f12308d = null;
    public static boolean isDebug = true;

    public static Context getApplicationContext() {
        return f12305a;
    }

    public static PowerConfigManager getPowerConfigManager() {
        return f12308d;
    }

    public static EfsReporter getReporter() {
        return f12307c;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        final c cVar;
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    Log.e(TAG, "init power manager error! parameter is null!");
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
                return;
            }
            return;
        }
        f12305a = context.getApplicationContext();
        f12307c = efsReporter;
        f12308d = new PowerConfigManager(context, efsReporter);
        f12306b = true;
        cVar = c.a.f12333a;
        try {
            if (getPowerConfigManager() == null || !getPowerConfigManager().enableTracer()) {
                return;
            }
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("efs_power", 0);
            if (sharedPreferences != null) {
                cVar.f12318b = sharedPreferences.getInt("apm_powerperf_collect_interval", 5);
                cVar.f12319c = sharedPreferences.getInt("apm_powerperf_collect_max_period_sec", 100);
            }
            final HandlerThread handlerThread = new HandlerThread("power-info");
            handlerThread.start();
            final Handler handler = new Handler(handlerThread.getLooper()) { // from class: com.umeng.powersdk.c.1
                @Override // android.os.Handler
                public final void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message.what == c.this.f12317a) {
                        try {
                            handlerThread.quit();
                        } catch (Throwable unused) {
                        }
                    }
                }
            };
            handler.post(new Runnable() { // from class: com.umeng.powersdk.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        final c cVar2 = c.this;
                        final Handler handler2 = handler;
                        final int i10 = cVar2.f12318b;
                        final int i11 = cVar2.f12319c;
                        final long elapsedRealtime = SystemClock.elapsedRealtime();
                        handler2.post(new Runnable() { // from class: com.umeng.powersdk.c.3
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (c.this.f12321e) {
                                    if (SystemClock.elapsedRealtime() - elapsedRealtime > i11 * 1000) {
                                        handler2.sendEmptyMessage(c.this.f12317a);
                                        return;
                                    }
                                    try {
                                        EfsJSONLog efsJSONLog = new EfsJSONLog("powerperf");
                                        efsJSONLog.put("power", c.this.a());
                                        EfsReporter reporter = PowerManager.getReporter();
                                        if (reporter != null) {
                                            reporter.send(efsJSONLog);
                                        }
                                    } catch (Throwable unused) {
                                    }
                                }
                                handler2.postDelayed(this, i10 * 1000);
                            }
                        });
                    } catch (Throwable unused) {
                        handler.sendEmptyMessage(c.this.f12317a);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static boolean isInit() {
        return f12306b;
    }

    public static void onActivityResumed(Activity activity) {
        c cVar;
        cVar = c.a.f12333a;
        try {
            if (getPowerConfigManager() != null && getPowerConfigManager().enableTracer()) {
                cVar.f12320d = new WeakReference<>(activity);
            }
        } catch (Throwable unused) {
        }
    }

    public static void onActivityStarted(Activity activity) {
        c cVar;
        cVar = c.a.f12333a;
        try {
            if (getPowerConfigManager() == null || !getPowerConfigManager().enableTracer() || activity == null) {
                return;
            }
            if (cVar.f12323g) {
                cVar.f12323g = false;
                return;
            }
            int i10 = cVar.f12322f + 1;
            cVar.f12322f = i10;
            if (i10 == 1) {
                cVar.f12321e = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static void onActivityStopped(Activity activity) {
        c cVar;
        cVar = c.a.f12333a;
        try {
            if (getPowerConfigManager() == null || !getPowerConfigManager().enableTracer() || activity == null) {
                return;
            }
            if (activity.isChangingConfigurations()) {
                cVar.f12323g = true;
                return;
            }
            int i10 = cVar.f12322f - 1;
            cVar.f12322f = i10;
            if (i10 == 0) {
                cVar.f12321e = false;
            }
        } catch (Throwable unused) {
        }
    }
}
