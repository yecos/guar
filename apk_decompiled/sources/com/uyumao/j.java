package com.uyumao;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.sdk.source.common.global.Constant;

/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static Context f12420a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final j f12421a = new j();
    }

    public synchronized i a() {
        i iVar;
        iVar = null;
        try {
            Intent registerReceiver = f12420a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
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
            i iVar2 = new i();
            try {
                iVar2.f12414a = intExtra;
                iVar2.f12415b = intExtra2;
                iVar2.f12417d = i11;
                iVar2.f12416c = intExtra3;
                iVar2.f12418e = i10;
                iVar2.f12419f = System.currentTimeMillis();
            } catch (Throwable unused) {
            }
            iVar = iVar2;
        } catch (Throwable unused2) {
        }
        return iVar;
    }
}
