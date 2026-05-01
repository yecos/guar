package com.umeng.powersdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.sdk.source.common.global.Constant;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static Context f12315a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f12316a = new b(0);
    }

    private b() {
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public final synchronized com.umeng.powersdk.a a() {
        com.umeng.powersdk.a aVar;
        com.umeng.powersdk.a aVar2 = null;
        try {
            Intent registerReceiver = f12315a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i10 = 0;
            int intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0);
            int intExtra2 = registerReceiver.getIntExtra("voltage", 0);
            int intExtra3 = registerReceiver.getIntExtra("temperature", 0);
            int intExtra4 = registerReceiver.getIntExtra(Constant.KEY_STATUS, 0);
            int i11 = -1;
            if (intExtra4 != 1) {
                if (intExtra4 == 2) {
                    i11 = 1;
                } else if (intExtra4 == 3 || intExtra4 == 4) {
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
            aVar = new com.umeng.powersdk.a();
            try {
                aVar.f12309a = intExtra;
                aVar.f12310b = intExtra2;
                aVar.f12312d = i11;
                aVar.f12311c = intExtra3;
                aVar.f12313e = i10;
                aVar.f12314f = System.currentTimeMillis();
            } catch (Throwable unused) {
                aVar2 = aVar;
                aVar = aVar2;
                return aVar;
            }
        } catch (Throwable unused2) {
        }
        return aVar;
    }

    public static b a(Context context) {
        if (f12315a == null && context != null) {
            f12315a = context.getApplicationContext();
        }
        return a.f12316a;
    }
}
