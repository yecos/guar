package com.taobao.accs.utl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.agoo.TaobaoRegister;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class l implements Application.ActivityLifecycleCallbacks {
    public static final int STATE_BACK = 0;
    public static final int STATE_FORE = 1;

    /* renamed from: a, reason: collision with root package name */
    private static final String f9362a = "l";

    /* renamed from: b, reason: collision with root package name */
    private static volatile l f9363b = null;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<a> f9364c = null;

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList<b> f9365d = null;

    /* renamed from: e, reason: collision with root package name */
    private static Application f9366e = null;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f9367j = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f9369g;

    /* renamed from: f, reason: collision with root package name */
    private int f9368f = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f9370h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f9371i = 1;

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private String f9372a;

        /* renamed from: b, reason: collision with root package name */
        private int f9373b;

        /* renamed from: c, reason: collision with root package name */
        private long f9374c = t.a(l.f9366e);

        public a(String str, int i10) {
            this.f9372a = str;
            this.f9373b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            ALog.e(l.f9362a, "click report", "lastActiveTime", Long.valueOf(this.f9374c), "currentActiveTime", Long.valueOf(currentTimeMillis));
            long j10 = this.f9374c;
            if (j10 == 0 || UtilityImpl.a(j10, currentTimeMillis)) {
                this.f9373b |= 8;
            }
            TaobaoRegister.clickMessage(l.f9366e, this.f9372a, null, this.f9373b, this.f9374c);
        }
    }

    public interface b {
        void a();

        void b();
    }

    private l() {
        f9364c = new ArrayList<>();
        f9365d = new ArrayList<>();
    }

    public static l a() {
        if (f9363b == null) {
            synchronized (l.class) {
                if (f9363b == null) {
                    f9363b = new l();
                }
            }
        }
        return f9363b;
    }

    public void b() {
        ArrayList<a> arrayList = f9364c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                ThreadPoolExecutorFactory.getScheduledExecutor().execute(it.next());
            }
            f9364c.clear();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        int i10 = this.f9368f;
        if ((i10 & 1) != 1) {
            this.f9368f = i10 | 1 | 2;
        } else if ((i10 & 2) == 2) {
            this.f9368f = i10 & (-3);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.f9369g) {
            t.a(f9366e, System.currentTimeMillis());
            if (!f9367j) {
                f9367j = true;
            }
        }
        this.f9369g = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i10 = this.f9370h;
        this.f9370h = i10 + 1;
        if (i10 == 0) {
            ALog.i(f9362a, "onActivityStarted back to force", new Object[0]);
            this.f9369g = true;
            this.f9371i = 1;
            ThreadPoolExecutorFactory.execute(new m(this));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i10 = this.f9370h - 1;
        this.f9370h = i10;
        if (i10 == 0) {
            this.f9371i = 0;
            ThreadPoolExecutorFactory.execute(new n(this));
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            f9365d.add(bVar);
        }
    }
}
