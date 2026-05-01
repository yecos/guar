package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10941a = "BatteryUtils";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f10942b = false;

    /* renamed from: c, reason: collision with root package name */
    private static Context f10943c;

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f10944d;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f10946a = new c();

        private a() {
        }
    }

    public static c a(Context context) {
        if (f10943c == null && context != null) {
            f10943c = context.getApplicationContext();
        }
        return a.f10946a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f10943c.registerReceiver(this.f10944d, intentFilter);
            f10942b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f10943c, th);
        }
    }

    public synchronized void c() {
        try {
            f10943c.unregisterReceiver(this.f10944d);
            f10942b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f10943c, th);
        }
    }

    private c() {
        this.f10944d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                        int i10 = 0;
                        int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0);
                        int intExtra2 = intent.getIntExtra("voltage", 0);
                        int intExtra3 = intent.getIntExtra("temperature", 0);
                        int intExtra4 = intent.getIntExtra(Constant.KEY_STATUS, 0);
                        int i11 = -1;
                        if (intExtra4 != 1) {
                            if (intExtra4 == 2) {
                                i11 = 1;
                            } else if (intExtra4 == 4) {
                                i11 = 0;
                            } else if (intExtra4 == 5) {
                                i11 = 2;
                            }
                        }
                        int intExtra5 = intent.getIntExtra("plugged", 0);
                        if (intExtra5 == 1) {
                            i10 = 1;
                        } else if (intExtra5 == 2) {
                            i10 = 2;
                        }
                        b bVar = new b();
                        bVar.f10935a = intExtra;
                        bVar.f10936b = intExtra2;
                        bVar.f10938d = i11;
                        bVar.f10937c = intExtra3;
                        bVar.f10939e = i10;
                        bVar.f10940f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f10890h, com.umeng.commonsdk.internal.b.a(c.f10943c).a(), bVar);
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.f10943c, th);
                }
            }
        };
    }

    public synchronized boolean a() {
        return f10942b;
    }
}
