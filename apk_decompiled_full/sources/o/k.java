package o;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f17368a;

    /* renamed from: b, reason: collision with root package name */
    public static final Field f17369b;

    /* renamed from: c, reason: collision with root package name */
    public static final Field f17370c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f17371d;

    /* renamed from: e, reason: collision with root package name */
    public static final Method f17372e;

    /* renamed from: f, reason: collision with root package name */
    public static final Method f17373f;

    /* renamed from: g, reason: collision with root package name */
    public static final Handler f17374g = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f17375a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f17376b;

        public a(d dVar, Object obj) {
            this.f17375a = dVar;
            this.f17376b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17375a.f17381a = this.f17376b;
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f17377a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f17378b;

        public b(Application application, d dVar) {
            this.f17377a = application;
            this.f17378b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17377a.unregisterActivityLifecycleCallbacks(this.f17378b);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f17379a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f17380b;

        public c(Object obj, Object obj2) {
            this.f17379a = obj;
            this.f17380b = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = k.f17371d;
                if (method != null) {
                    method.invoke(this.f17379a, this.f17380b, Boolean.FALSE, "AppCompat recreation");
                } else {
                    k.f17372e.invoke(this.f17379a, this.f17380b, Boolean.FALSE);
                }
            } catch (RuntimeException e10) {
                if (e10.getClass() == RuntimeException.class && e10.getMessage() != null && e10.getMessage().startsWith("Unable to stop")) {
                    throw e10;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    public static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public Object f17381a;

        /* renamed from: b, reason: collision with root package name */
        public Activity f17382b;

        /* renamed from: c, reason: collision with root package name */
        public final int f17383c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f17384d = false;

        /* renamed from: e, reason: collision with root package name */
        public boolean f17385e = false;

        /* renamed from: f, reason: collision with root package name */
        public boolean f17386f = false;

        public d(Activity activity) {
            this.f17382b = activity;
            this.f17383c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f17382b == activity) {
                this.f17382b = null;
                this.f17385e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f17385e || this.f17386f || this.f17384d || !k.h(this.f17381a, this.f17383c, activity)) {
                return;
            }
            this.f17386f = true;
            this.f17381a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f17382b == activity) {
                this.f17384d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class a10 = a();
        f17368a = a10;
        f17369b = b();
        f17370c = f();
        f17371d = d(a10);
        f17372e = c(a10);
        f17373f = e(a10);
    }

    public static Class a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method e(Class cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 == 26 || i10 == 27;
    }

    public static boolean h(Object obj, int i10, Activity activity) {
        try {
            Object obj2 = f17370c.get(activity);
            if (obj2 == obj && activity.hashCode() == i10) {
                f17374g.postAtFrontOfQueue(new c(f17369b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f17373f == null) {
            return false;
        }
        if (f17372e == null && f17371d == null) {
            return false;
        }
        try {
            Object obj2 = f17370c.get(activity);
            if (obj2 == null || (obj = f17369b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d dVar = new d(activity);
            application.registerActivityLifecycleCallbacks(dVar);
            Handler handler = f17374g;
            handler.post(new a(dVar, obj2));
            try {
                if (g()) {
                    Method method = f17373f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, dVar));
                return true;
            } catch (Throwable th) {
                f17374g.post(new b(application, dVar));
                throw th;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
