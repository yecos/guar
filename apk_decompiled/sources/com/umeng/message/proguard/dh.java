package com.umeng.message.proguard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import com.google.android.gms.cast.CastStatusCodes;
import com.hpplay.sdk.source.api.IConferenceMirrorListener;
import com.umeng.message.proguard.cq;
import com.umeng.message.proguard.eh;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class dh {

    /* renamed from: a, reason: collision with root package name */
    private static long f11892a;

    /* renamed from: b, reason: collision with root package name */
    private static WeakReference<Activity> f11893b;

    /* renamed from: c, reason: collision with root package name */
    private static WeakReference<da> f11894c;

    /* renamed from: d, reason: collision with root package name */
    private static final Callable<Void> f11895d = new Callable<Void>() { // from class: com.umeng.message.proguard.dh.1
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            try {
                dh.b(2051);
                cb.c(new Runnable() { // from class: com.umeng.message.proguard.dh.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        da daVar;
                        cf cfVar;
                        da daVar2;
                        cf cfVar2;
                        da daVar3;
                        cf cfVar3;
                        da daVar4;
                        cf cfVar4;
                        try {
                            WeakReference weakReference = dh.f11893b;
                            if (weakReference == null) {
                                ce.a("Banner", "floating banner timeout!");
                                WeakReference weakReference2 = dh.f11894c;
                                if (weakReference2 == null || (daVar4 = (da) weakReference2.get()) == null || (cfVar4 = daVar4.f11861a) == null) {
                                    return;
                                }
                                cfVar4.b();
                                return;
                            }
                            Activity activity = (Activity) weakReference.get();
                            if (activity != null && !activity.isFinishing()) {
                                dh.f11896e.a(activity);
                                ce.a("Banner", "floating banner timeout!");
                                WeakReference weakReference3 = dh.f11894c;
                                if (weakReference3 == null || (daVar3 = (da) weakReference3.get()) == null || (cfVar3 = daVar3.f11861a) == null) {
                                    return;
                                }
                                cfVar3.b();
                                return;
                            }
                            ce.a("Banner", "floating banner timeout!");
                            WeakReference weakReference4 = dh.f11894c;
                            if (weakReference4 == null || (daVar2 = (da) weakReference4.get()) == null || (cfVar2 = daVar2.f11861a) == null) {
                                return;
                            }
                            cfVar2.b();
                        } catch (Throwable th) {
                            ce.a("Banner", "floating banner timeout!");
                            WeakReference weakReference5 = dh.f11894c;
                            if (weakReference5 != null && (daVar = (da) weakReference5.get()) != null && (cfVar = daVar.f11861a) != null) {
                                cfVar.b();
                            }
                            throw th;
                        }
                    }
                });
                return null;
            } catch (Throwable th) {
                ce.d("Banner", "floating banner timeout error:", th.getMessage());
                return null;
            }
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private static final di f11896e = new di();

    /* renamed from: f, reason: collision with root package name */
    private static volatile Future<Void> f11897f;

    /* renamed from: com.umeng.message.proguard.dh$2, reason: invalid class name */
    public class AnonymousClass2 extends eh.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f11899a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ dl f11900b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ck f11901c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ da f11902d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ dj f11903e;

        public AnonymousClass2(long j10, dl dlVar, ck ckVar, da daVar, dj djVar) {
            this.f11899a = j10;
            this.f11900b = dlVar;
            this.f11901c = ckVar;
            this.f11902d = daVar;
            this.f11903e = djVar;
        }

        @Override // com.umeng.message.proguard.eh.a
        public final void a() {
            dh.f();
            long e10 = this.f11899a - e();
            if (e10 < 0) {
                e10 = 0;
            }
            Future unused = dh.f11897f = cb.a(dh.f11895d, e10, TimeUnit.MILLISECONDS);
        }

        @Override // com.umeng.message.proguard.eh.a
        public final void b() {
            dh.f();
        }

        @Override // com.umeng.message.proguard.eh.a
        public final void c() {
            this.f11900b.f11925c.post(new Runnable() { // from class: com.umeng.message.proguard.dh.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        cr.a().a(AnonymousClass2.this.f11901c, new cq.a() { // from class: com.umeng.message.proguard.dh.2.1.1
                            @Override // com.umeng.message.proguard.cq.a
                            public final void a() {
                                cf cfVar = AnonymousClass2.this.f11902d.f11861a;
                                if (cfVar != null) {
                                    cfVar.a();
                                }
                            }

                            @Override // com.umeng.message.proguard.cq.a
                            public final void a(String str) {
                                cf cfVar = AnonymousClass2.this.f11902d.f11861a;
                                if (cfVar != null) {
                                    cfVar.a(2010, str);
                                }
                            }
                        });
                        if (AnonymousClass2.this.f11901c.f11740b.optBoolean("expose_verify", false)) {
                            return;
                        }
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        ef efVar = anonymousClass2.f11900b.f11925c;
                        anonymousClass2.f11901c.f11745g = efVar.getWidth();
                        AnonymousClass2.this.f11901c.f11746h = efVar.getHeight();
                        List<Integer> a10 = dw.a(efVar);
                        if (!a10.isEmpty()) {
                            Iterator<Integer> it = a10.iterator();
                            while (it.hasNext()) {
                                cr.a().c(AnonymousClass2.this.f11901c, it.next().intValue());
                            }
                        }
                        AnonymousClass2.this.f11901c.f11740b.put("expose_verify", true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }

        @Override // com.umeng.message.proguard.eh.a
        public final void d() {
            bz.a().b(this.f11903e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        Future<Void> future = f11897f;
        if (future != null && !future.isDone() && !future.isCancelled()) {
            future.cancel(false);
        }
        f11897f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i10) {
        WeakReference<dl> weakReference = f11896e.f11917a;
        dl dlVar = weakReference == null ? null : weakReference.get();
        if (dlVar != null) {
            eh.a onStatusListener = dlVar.f11925c.getOnStatusListener();
            ck ckVar = dlVar.f11923a.f11920a;
            if (onStatusListener == null || ckVar == null) {
                return;
            }
            try {
                ckVar.f11740b.put("exposed_duration", onStatusListener.e());
                cr.a().a(ckVar, i10);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Activity activity) {
        Activity activity2;
        WeakReference<Activity> weakReference = f11893b;
        if (weakReference == null || (activity2 = weakReference.get()) == null || activity2 != activity) {
            return false;
        }
        return f11896e.a();
    }

    public static void a(dk dkVar, long j10, da daVar) {
        if (!bz.a().f11686a) {
            cr.a().b(dkVar.f11920a, CastStatusCodes.NOT_ALLOWED);
            return;
        }
        Activity b10 = bz.a().b();
        if (b10 != null && !b10.isFinishing()) {
            a(b10, dkVar, j10, daVar);
        } else {
            cr.a().b(dkVar.f11920a, CastStatusCodes.APPLICATION_NOT_RUNNING);
        }
    }

    public static void b(Activity activity) {
        try {
            di diVar = f11896e;
            if (diVar.a()) {
                b(2053);
                diVar.a(activity);
            }
            f();
        } catch (Throwable th) {
            ce.a("Banner", "floating banner dismiss err:" + th.getMessage());
        }
        f11893b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Activity activity, final dk dkVar, final long j10, final da daVar) {
        if (dt.a().a((Class<? extends Activity>) activity.getClass())) {
            cr.a().b(dkVar.f11920a, CastStatusCodes.MESSAGE_TOO_LARGE);
            ce.a("Banner", "current activity not allow show ad:", activity.getClass().getName());
        } else {
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.umeng.message.proguard.dh.6
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Activity b10 = bz.a().b();
                        if (b10 == null || activity == b10) {
                            dh.b(activity, dkVar, j10, daVar);
                        } else {
                            ce.b("Banner", "activity not top skip.");
                            cr.a().b(dkVar.f11920a, CastStatusCodes.APPLICATION_NOT_FOUND);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public static /* synthetic */ void b(Activity activity, dk dkVar, long j10, final da daVar) {
        if (activity == null || dkVar == null || daVar == null) {
            return;
        }
        final ck ckVar = dkVar.f11920a;
        if (ed.a(activity)) {
            ce.a("Banner", "floating banner: activity window not match skipped.");
            cr.a().b(ckVar, 2010);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - f11892a;
        if (elapsedRealtime < 1000) {
            ce.b("Banner", "skipped floating banner show interval:", Long.valueOf(elapsedRealtime));
            cr.a().b(ckVar, CastStatusCodes.MESSAGE_SEND_BUFFER_TOO_FULL);
            return;
        }
        f11892a = SystemClock.elapsedRealtime();
        f();
        di diVar = f11896e;
        if (diVar.a()) {
            b(2052);
            diVar.a(activity);
        }
        dl dlVar = new dl(activity, dkVar);
        f11894c = new WeakReference<>(daVar);
        f11893b = new WeakReference<>(activity);
        dj djVar = new dj();
        final AnonymousClass2 anonymousClass2 = new AnonymousClass2(j10, dlVar, ckVar, daVar, djVar);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.umeng.message.proguard.dh.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    ce.a("Banner", "floating banner closed!");
                    Activity activity2 = (Activity) view.getContext();
                    if (activity2 == null) {
                        return;
                    }
                    dh.f();
                    dh.b(com.umeng.analytics.pro.k.f10421b);
                    dh.f11896e.a(activity2);
                    cf cfVar = da.this.f11861a;
                    if (cfVar != null) {
                        cfVar.b();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        dlVar.f11925c.setDismissListener(onClickListener);
        dlVar.f11924b.setOnClickListener(onClickListener);
        dlVar.f11925c.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.proguard.dh.4
            @Override // android.view.View.OnClickListener
            public final void onClick(final View view) {
                try {
                    ce.a("Banner", "floating banner clicked.");
                    Activity activity2 = (Activity) view.getContext();
                    if (activity2 == null) {
                        return;
                    }
                    dh.f();
                    dh.f11896e.a(activity2);
                    ck.this.f11740b.put("clicked", true);
                    ck.this.f11740b.put("exposed_duration", anonymousClass2.e());
                    ck ckVar2 = ck.this;
                    eh.a aVar = anonymousClass2;
                    ckVar2.f11751m = aVar.f12039g;
                    ckVar2.f11752n = aVar.f12041i;
                    ckVar2.f11753o = aVar.f12040h;
                    ckVar2.f11754p = aVar.f12042j;
                    ckVar2.f11755q = aVar.f12043k;
                    ckVar2.f11756r = aVar.f12044l;
                    ckVar2.f11757s = aVar.f12045m;
                    ckVar2.f11758t = aVar.f12046n;
                    dy.a(de.a(), ck.this, new cq.a() { // from class: com.umeng.message.proguard.dh.4.1
                        @Override // com.umeng.message.proguard.cq.a
                        public final void a() {
                            cf cfVar = daVar.f11861a;
                            if (cfVar != null) {
                                cfVar.a(view);
                            }
                        }

                        @Override // com.umeng.message.proguard.cq.a
                        public final void a(String str) {
                            cf cfVar = daVar.f11861a;
                            if (cfVar != null) {
                                cfVar.a(IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_OK, str);
                            }
                        }
                    });
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        dlVar.f11925c.setOnStatusListener(anonymousClass2);
        dlVar.f11926d = new View.OnClickListener() { // from class: com.umeng.message.proguard.dh.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    ce.a("Banner", "floating banner closed.");
                    Activity activity2 = (Activity) view.getContext();
                    if (activity2 == null) {
                        return;
                    }
                    dh.f();
                    dh.b(2054);
                    dh.f11896e.a(activity2);
                    cf cfVar = da.this.f11861a;
                    if (cfVar != null) {
                        cfVar.b();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        if (diVar.a(dlVar, activity)) {
            bz.a().a(djVar);
            ef efVar = dlVar.f11925c;
            efVar.setAlpha(0.0f);
            efVar.measure(-2, -2);
            efVar.animate().translationX(0.0f).translationY(efVar.getMeasuredHeight() * (-1)).setDuration(1L).setListener(new AnimatorListenerAdapter() { // from class: com.umeng.message.proguard.dv.1

                /* renamed from: a */
                final /* synthetic */ View f12019a;

                public AnonymousClass1(View efVar2) {
                    r1 = efVar2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    try {
                        r1.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(500L).setListener(null);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
