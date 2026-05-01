package com.umeng.message.proguard;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* renamed from: com.umeng.message.proguard.do, reason: invalid class name */
/* loaded from: classes3.dex */
final class Cdo {

    /* renamed from: a, reason: collision with root package name */
    eg f11959a;

    /* renamed from: b, reason: collision with root package name */
    a f11960b;

    /* renamed from: c, reason: collision with root package name */
    dp f11961c;

    /* renamed from: com.umeng.message.proguard.do$a */
    public interface a {
        void a();

        void a(View view);
    }

    public final boolean a() {
        return this.f11959a != null;
    }

    public final void b() {
        ViewGroup viewGroup;
        bz.a().b(this.f11961c);
        eg egVar = this.f11959a;
        if (egVar != null && (viewGroup = (ViewGroup) egVar.getParent()) != null) {
            viewGroup.removeView(this.f11959a);
        }
        this.f11961c = null;
        this.f11959a = null;
        this.f11960b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Activity activity) {
        ViewGroup b10;
        eg egVar = this.f11959a;
        if (egVar == null || (b10 = b(activity)) == null || egVar.getParent() == b10) {
            return;
        }
        if (egVar.getParent() != null) {
            ((ViewGroup) egVar.getParent()).removeView(egVar);
        }
        if (activity.isFinishing()) {
            ce.b("FloatingIcon", "activity has finished skip.");
            return;
        }
        if (ed.a(activity)) {
            ce.b("FloatingIcon", "activity window not match skipped.");
        } else {
            if (dt.a().a((Class<? extends Activity>) activity.getClass())) {
                return;
            }
            b10.addView(egVar);
            ce.b("FloatingIcon", "onShow");
        }
    }

    public static ViewGroup b(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return null;
            }
            return (ViewGroup) window.getDecorView().findViewById(R.id.content);
        } catch (Throwable unused) {
            return null;
        }
    }
}
