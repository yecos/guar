package com.hpplay.sdk.source.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f7421b = "AppLifecycleListen";

    /* renamed from: e, reason: collision with root package name */
    private static InterfaceC0124a f7423e;

    /* renamed from: f, reason: collision with root package name */
    private static int f7424f;

    /* renamed from: d, reason: collision with root package name */
    private Application f7425d;

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f7422c = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    static Application.ActivityLifecycleCallbacks f7420a = new Application.ActivityLifecycleCallbacks() { // from class: com.hpplay.sdk.source.a.a.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            SourceLog.i(a.f7421b, "onActivityDestroyed");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            SourceLog.i(a.f7421b, "onActivityPaused");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            int unused = a.f7424f = activity.hashCode();
            SourceLog.i(a.f7421b, "onActivityResumed   " + a.f7422c.get());
            if (a.f7422c.get() && a.f7423e != null) {
                a.f7423e.onAppResume();
            }
            a.f7422c.set(false);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            SourceLog.i(a.f7421b, "onActivitySaveInstanceState  " + a.f7422c.get());
            if (a.f7422c.get() || a.f7423e == null || a.f7424f != activity.hashCode()) {
                return;
            }
            SourceLog.i(a.f7421b, "app exited Background ");
            a.f7423e.onAppPause();
            a.f7422c.set(true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            SourceLog.i(a.f7421b, "onActivityStarted");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            SourceLog.i(a.f7421b, "onActivityStopped");
        }
    };

    /* renamed from: com.hpplay.sdk.source.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0124a {
        void onAppPause();

        void onAppResume();
    }

    public a() {
        try {
            Application application = HapplayUtils.getApplication();
            this.f7425d = application;
            application.registerActivityLifecycleCallbacks(f7420a);
        } catch (Exception e10) {
            SourceLog.w(f7421b, e10);
        }
    }

    public void a(InterfaceC0124a interfaceC0124a) {
        f7423e = interfaceC0124a;
    }

    public void a() {
        Application application = this.f7425d;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(f7420a);
        }
    }
}
