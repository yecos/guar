package com.umeng.pagesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.sdk.source.common.global.Constant;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f12275a = false;

    /* renamed from: b, reason: collision with root package name */
    private static Context f12276b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0200b f12277c;

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f12278d;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f12280a = new b(0);
    }

    /* renamed from: com.umeng.pagesdk.b$b, reason: collision with other inner class name */
    public interface InterfaceC0200b {
        void a(com.umeng.pagesdk.a aVar);
    }

    private b() {
        this.f12278d = new BroadcastReceiver() { // from class: com.umeng.pagesdk.b.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
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
                        com.umeng.pagesdk.a aVar = new com.umeng.pagesdk.a();
                        aVar.f12269a = intExtra;
                        aVar.f12270b = intExtra2;
                        aVar.f12272d = i11;
                        aVar.f12271c = intExtra3;
                        aVar.f12273e = i10;
                        aVar.f12274f = System.currentTimeMillis();
                        if (b.this.f12277c != null) {
                            b.this.f12277c.a(aVar);
                        }
                        b.this.b();
                    }
                } catch (Throwable unused) {
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        try {
            f12276b.unregisterReceiver(this.f12278d);
            f12275a = false;
        } catch (Throwable unused) {
        }
    }

    public final synchronized com.umeng.pagesdk.a a() {
        com.umeng.pagesdk.a aVar;
        int i10;
        int intExtra;
        int intExtra2;
        int intExtra3;
        int i11;
        com.umeng.pagesdk.a aVar2 = null;
        try {
            Intent registerReceiver = f12276b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            i10 = 0;
            intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0);
            intExtra2 = registerReceiver.getIntExtra("voltage", 0);
            intExtra3 = registerReceiver.getIntExtra("temperature", 0);
            int intExtra4 = registerReceiver.getIntExtra(Constant.KEY_STATUS, 0);
            i11 = -1;
            if (intExtra4 != 1) {
                if (intExtra4 == 2) {
                    i11 = 1;
                } else if (intExtra4 == 4) {
                    i11 = 0;
                } else if (intExtra4 == 5) {
                    i11 = 2;
                }
            }
            int intExtra5 = registerReceiver.getIntExtra("plugged", 0);
            if (intExtra5 == 1) {
                i10 = 1;
            } else if (intExtra5 == 2) {
                i10 = 2;
            }
            aVar = new com.umeng.pagesdk.a();
        } catch (Throwable unused) {
        }
        try {
            aVar.f12269a = intExtra;
            aVar.f12270b = intExtra2;
            aVar.f12272d = i11;
            aVar.f12271c = intExtra3;
            aVar.f12273e = i10;
            aVar.f12274f = System.currentTimeMillis();
        } catch (Throwable unused2) {
            aVar2 = aVar;
            aVar = aVar2;
            return aVar;
        }
        return aVar;
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public static b a(Context context) {
        if (f12276b == null && context != null) {
            f12276b = context.getApplicationContext();
        }
        return a.f12280a;
    }

    public final synchronized void a(InterfaceC0200b interfaceC0200b) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f12276b.registerReceiver(this.f12278d, intentFilter);
            f12275a = true;
            this.f12277c = interfaceC0200b;
        } catch (Throwable unused) {
        }
    }
}
