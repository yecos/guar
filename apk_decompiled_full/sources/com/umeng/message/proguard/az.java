package com.umeng.message.proguard;

import android.os.Build;

/* loaded from: classes3.dex */
public final class az {
    public static void a(ad adVar) {
        if (Build.VERSION.SDK_INT < 23 || adVar == null || adVar.f11454b == null) {
            return;
        }
        Object obj = adVar.f11455c;
        if (obj instanceof c) {
            ((c) obj).c();
        }
        adVar.f11455c = null;
    }
}
