package com.umeng.message.proguard;

import android.app.Activity;
import com.umeng.message.proguard.bz;

/* loaded from: classes3.dex */
final class dj extends bz.b {
    @Override // com.umeng.message.proguard.bz.b
    public final String a() {
        return "fb";
    }

    @Override // com.umeng.message.proguard.bz.b
    public final void d(Activity activity) {
        try {
            if (dh.a(activity)) {
                dh.b(activity);
            }
        } catch (Throwable unused) {
        }
        bz.a().b(this);
    }
}
