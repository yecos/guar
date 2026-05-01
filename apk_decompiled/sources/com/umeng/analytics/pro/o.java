package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class o implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private static o f10487a = new o();

    /* renamed from: b, reason: collision with root package name */
    private final int f10488b = 3000;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10489c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10490d = true;

    /* renamed from: e, reason: collision with root package name */
    private Handler f10491e = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<p> f10492f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private a f10493g = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!o.this.f10489c || !o.this.f10490d) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            o.this.f10489c = false;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i10 = 0; i10 < o.this.f10492f.size(); i10++) {
                ((p) o.this.f10492f.get(i10)).n();
            }
        }
    }

    private o() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f10490d = true;
        a aVar = this.f10493g;
        if (aVar != null) {
            this.f10491e.removeCallbacks(aVar);
            this.f10491e.postDelayed(this.f10493g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f10490d = false;
        this.f10489c = true;
        a aVar = this.f10493g;
        if (aVar != null) {
            this.f10491e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public synchronized void b(p pVar) {
        if (pVar != null) {
            for (int i10 = 0; i10 < this.f10492f.size(); i10++) {
                if (this.f10492f.get(i10) == pVar) {
                    this.f10492f.remove(i10);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f10487a);
        }
    }

    public static o a() {
        return f10487a;
    }

    public synchronized void a(p pVar) {
        if (pVar != null) {
            this.f10492f.add(pVar);
        }
    }
}
