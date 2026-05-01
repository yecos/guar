package com.uc.crashsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private boolean f9686a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f9687b = false;

    private void a(Activity activity, int i10) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (1 == i10) {
            String unused = b.ad = activity.getComponentName().flattenToShortString();
        } else {
            String unused2 = b.ad = "";
        }
        b.D();
        if (g.M()) {
            b.O();
            weakHashMap = b.f9660ab;
            synchronized (weakHashMap) {
                weakHashMap2 = b.f9660ab;
                weakHashMap2.put(activity, Integer.valueOf(i10));
                a(i10);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (g.M()) {
            b.O();
            weakHashMap = b.f9660ab;
            synchronized (weakHashMap) {
                weakHashMap2 = b.f9660ab;
                weakHashMap2.remove(activity);
                a(2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(activity, 2);
    }

    private void a(int i10) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (e.u()) {
            com.uc.crashsdk.a.a.a("crashsdk", "[LifeCycle] ignore state change while crashing");
            return;
        }
        boolean z10 = true;
        boolean z11 = 1 == i10;
        if (!z11) {
            weakHashMap2 = b.f9660ab;
            Iterator it = weakHashMap2.entrySet().iterator();
            while (it.hasNext()) {
                Object value = ((Map.Entry) it.next()).getValue();
                if (value != null && ((Integer) value).intValue() == 1) {
                    break;
                }
            }
        }
        z10 = z11;
        if (this.f9686a != z10) {
            b.b(z10);
            this.f9686a = z10;
        }
        weakHashMap = b.f9660ab;
        boolean isEmpty = weakHashMap.isEmpty();
        if (this.f9687b != isEmpty) {
            if (isEmpty) {
                b.w();
            }
            this.f9687b = isEmpty;
        }
    }
}
