package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.w;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class t extends w.c {

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f2589f = {Application.class, s.class};

    /* renamed from: g, reason: collision with root package name */
    public static final Class[] f2590g = {s.class};

    /* renamed from: a, reason: collision with root package name */
    public final Application f2591a;

    /* renamed from: b, reason: collision with root package name */
    public final w.b f2592b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f2593c;

    /* renamed from: d, reason: collision with root package name */
    public final d f2594d;

    /* renamed from: e, reason: collision with root package name */
    public final SavedStateRegistry f2595e;

    public t(Application application, androidx.savedstate.b bVar, Bundle bundle) {
        this.f2595e = bVar.getSavedStateRegistry();
        this.f2594d = bVar.getLifecycle();
        this.f2593c = bundle;
        this.f2591a = application;
        this.f2592b = application != null ? w.a.c(application) : w.d.b();
    }

    public static Constructor d(Class cls, Class[] clsArr) {
        for (Constructor<?> constructor : cls.getConstructors()) {
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    @Override // androidx.lifecycle.w.b
    public v a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.w.e
    public void b(v vVar) {
        SavedStateHandleController.b(vVar, this.f2595e, this.f2594d);
    }

    @Override // androidx.lifecycle.w.c
    public v c(String str, Class cls) {
        v vVar;
        boolean isAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor d10 = (!isAssignableFrom || this.f2591a == null) ? d(cls, f2590g) : d(cls, f2589f);
        if (d10 == null) {
            return this.f2592b.a(cls);
        }
        SavedStateHandleController d11 = SavedStateHandleController.d(this.f2595e, this.f2594d, str, this.f2593c);
        if (isAssignableFrom) {
            try {
                Application application = this.f2591a;
                if (application != null) {
                    vVar = (v) d10.newInstance(application, d11.e());
                    vVar.e("androidx.lifecycle.savedstate.vm.tag", d11);
                    return vVar;
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Failed to access " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e12.getCause());
            }
        }
        vVar = (v) d10.newInstance(d11.e());
        vVar.e("androidx.lifecycle.savedstate.vm.tag", d11);
        return vVar;
    }
}
