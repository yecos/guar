package com.umeng.message.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public final class bz {

    /* renamed from: b, reason: collision with root package name */
    private static final bz f11685b = new bz();

    /* renamed from: a, reason: collision with root package name */
    public boolean f11686a;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Activity> f11687c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11688d;

    /* renamed from: e, reason: collision with root package name */
    private volatile a f11689e;

    /* renamed from: f, reason: collision with root package name */
    private final ComponentCallbacks2 f11690f = new ComponentCallbacks2() { // from class: com.umeng.message.proguard.bz.1
        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int i10) {
            if (i10 == 20) {
                bz.a(bz.this);
            }
        }
    };

    /* renamed from: g, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f11691g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.message.proguard.bz.2
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            try {
                a aVar = bz.this.f11689e;
                if (aVar != null) {
                    aVar.d(activity);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            try {
                a aVar = bz.this.f11689e;
                if (aVar == null || aVar.f11694a.isEmpty()) {
                    return;
                }
                Iterator<b> it = aVar.f11694a.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            try {
                bz.this.f11687c = new WeakReference(activity);
                bz.c(bz.this);
                a aVar = bz.this.f11689e;
                if (aVar != null) {
                    aVar.c(activity);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            try {
                a aVar = bz.this.f11689e;
                if (aVar != null) {
                    aVar.a(activity);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            try {
                a aVar = bz.this.f11689e;
                if (aVar != null) {
                    aVar.b(activity);
                }
            } catch (Throwable unused) {
            }
        }
    };

    public static abstract class b {
        public abstract String a();

        public void a(Activity activity) {
        }

        public void b(Activity activity) {
        }

        public void c(Activity activity) {
        }

        public void d(Activity activity) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && a().equals(((b) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }
    }

    private bz() {
    }

    private a c() {
        if (this.f11689e == null) {
            synchronized (a.class) {
                if (this.f11689e == null) {
                    this.f11689e = new a((byte) 0);
                }
            }
        }
        return this.f11689e;
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final CopyOnWriteArraySet<b> f11694a;

        private a() {
            this.f11694a = new CopyOnWriteArraySet<>();
        }

        public final void a(Activity activity) {
            if (this.f11694a.isEmpty()) {
                return;
            }
            Iterator<b> it = this.f11694a.iterator();
            while (it.hasNext()) {
                it.next().a(activity);
            }
        }

        public final void b(Activity activity) {
            if (this.f11694a.isEmpty()) {
                return;
            }
            Iterator<b> it = this.f11694a.iterator();
            while (it.hasNext()) {
                it.next().b(activity);
            }
        }

        public final void c(Activity activity) {
            if (this.f11694a.isEmpty()) {
                return;
            }
            Iterator<b> it = this.f11694a.iterator();
            while (it.hasNext()) {
                it.next().c(activity);
            }
        }

        public final void d(Activity activity) {
            if (this.f11694a.isEmpty()) {
                return;
            }
            Iterator<b> it = this.f11694a.iterator();
            while (it.hasNext()) {
                it.next().d(activity);
            }
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public static void a(Context context) {
        if (context != null) {
            bz bzVar = f11685b;
            Application application = (Application) context.getApplicationContext();
            synchronized (bzVar) {
                if (application != null) {
                    if (!bzVar.f11688d) {
                        application.registerActivityLifecycleCallbacks(bzVar.f11691g);
                        application.registerComponentCallbacks(bzVar.f11690f);
                        bzVar.f11688d = true;
                    }
                }
            }
        }
    }

    public final Activity b() {
        WeakReference<Activity> weakReference = this.f11687c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void b(b bVar) {
        a c10 = c();
        if (bVar != null) {
            c10.f11694a.remove(bVar);
        }
    }

    public static /* synthetic */ void c(bz bzVar) {
        if (bzVar.f11686a) {
            return;
        }
        bzVar.f11686a = true;
    }

    public static bz a() {
        return f11685b;
    }

    public final void a(b bVar) {
        a c10 = c();
        if (bVar != null) {
            c10.f11694a.add(bVar);
        }
    }

    public static /* synthetic */ void a(bz bzVar) {
        if (bzVar.f11686a) {
            bzVar.f11686a = false;
        }
    }
}
