package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;
import com.umeng.message.common.UPLog;

/* loaded from: classes3.dex */
public final class as {

    /* renamed from: a, reason: collision with root package name */
    public aq f11549a;

    public final boolean a() {
        aq aqVar = this.f11549a;
        if (aqVar == null) {
            return false;
        }
        return aqVar.f11539b.isShown();
    }

    public final void a(Activity activity) {
        if (activity == null || activity.isFinishing() || !a()) {
            return;
        }
        final at atVar = this.f11549a.f11539b;
        final WindowManager a10 = a((Context) activity);
        activity.runOnUiThread(new Runnable() { // from class: com.umeng.message.proguard.as.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a10.removeViewImmediate(atVar);
                } catch (Throwable th) {
                    UPLog.e("Pop", "dismiss", th);
                }
            }
        });
        this.f11549a = null;
    }

    public static WindowManager a(Context context) {
        return (WindowManager) context.getSystemService("window");
    }
}
