package com.umeng.message.proguard;

import android.app.Activity;
import android.view.ViewGroup;
import com.umeng.message.proguard.bz;

/* loaded from: classes3.dex */
final class dp extends bz.b {

    /* renamed from: a, reason: collision with root package name */
    final Cdo f11964a;

    public dp(Cdo cdo) {
        this.f11964a = cdo;
    }

    @Override // com.umeng.message.proguard.bz.b
    public final String a() {
        return "fi";
    }

    @Override // com.umeng.message.proguard.bz.b
    public final void b(Activity activity) {
        eg egVar;
        ViewGroup b10;
        try {
            if (!this.f11964a.a() || (egVar = this.f11964a.f11959a) == null || (b10 = Cdo.b(activity)) == null || egVar.getParent() != b10) {
                return;
            }
            ((ViewGroup) egVar.getParent()).removeView(egVar);
            ce.b("FloatingIcon", "onHidden");
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.message.proguard.bz.b
    public final void a(final Activity activity) {
        try {
            if (!this.f11964a.a() || (activity instanceof cx)) {
                return;
            }
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.umeng.message.proguard.dp.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        dp.this.f11964a.a(activity);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
