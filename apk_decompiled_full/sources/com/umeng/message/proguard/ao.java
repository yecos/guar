package com.umeng.message.proguard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.ao;
import com.umeng.message.proguard.av;
import java.lang.ref.WeakReference;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class ao {

    /* renamed from: a, reason: collision with root package name */
    private static final as f11532a = new as();

    /* renamed from: b, reason: collision with root package name */
    private static WeakReference<Activity> f11533b;

    /* renamed from: c, reason: collision with root package name */
    private static Future<?> f11534c;

    public static abstract class a {
        public abstract void a(ap apVar, boolean z10);
    }

    public static /* synthetic */ Future b() {
        f11534c = null;
        return null;
    }

    private static void c() {
        Future<?> future = f11534c;
        if (future != null && !future.isDone() && !future.isCancelled()) {
            future.cancel(false);
        }
        f11534c = null;
    }

    public static void a(final Activity activity, ap apVar, final a aVar) {
        c();
        f11533b = new WeakReference<>(activity);
        final aq aqVar = new aq(activity, apVar);
        final as asVar = f11532a;
        activity.runOnUiThread(new Runnable() { // from class: com.umeng.message.proguard.as.1

            /* renamed from: a */
            final /* synthetic */ Activity f11550a;

            /* renamed from: b */
            final /* synthetic */ aq f11551b;

            /* renamed from: c */
            final /* synthetic */ ao.a f11552c;

            public AnonymousClass1(final Activity activity2, final aq aqVar2, final ao.a aVar2) {
                r2 = activity2;
                r3 = aqVar2;
                r4 = aVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean z10;
                View.OnClickListener onClickListener;
                try {
                    if (r2.isFinishing()) {
                        UPLog.e("Pop", "Activity finish. cannot show");
                        try {
                            r4.a(r3.b(), false);
                            return;
                        } catch (Throwable th) {
                            UPLog.e("Pop", "callback fail", th.getMessage());
                            return;
                        }
                    }
                    if (as.this.a()) {
                        as.this.a(r2);
                    }
                    WindowManager a10 = as.a((Context) r2);
                    at atVar = r3.f11539b;
                    if (ak.a().c().f11529g) {
                        as asVar2 = as.this;
                        aq aqVar2 = r3;
                        av avVar = null;
                        if (aqVar2 != null && (onClickListener = aqVar2.f11540c) != null) {
                            avVar = new av(aqVar2.f11539b, new av.a() { // from class: com.umeng.message.proguard.as.4

                                /* renamed from: a */
                                final /* synthetic */ View.OnClickListener f11559a;

                                public AnonymousClass4(View.OnClickListener onClickListener2) {
                                    r2 = onClickListener2;
                                }

                                @Override // com.umeng.message.proguard.av.a
                                public final void a(View view) {
                                    r2.onClick(view);
                                }
                            });
                        }
                        r3.f11539b.setOnTouchListener(avVar);
                    }
                    Activity activity2 = r2;
                    int i10 = r3.f11541d;
                    Point point = new Point();
                    as.a((Context) activity2).getDefaultDisplay().getRealSize(point);
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(Math.min(point.x, point.y) - bo.a(32.0f), i10, Constant.STOP_FROM_SINK, 327968, -3);
                    Rect rect = new Rect();
                    activity2.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    layoutParams.y = Math.min(rect.top, bo.a(56.0f)) + bo.a(4.0f);
                    layoutParams.dimAmount = 0.3f;
                    layoutParams.gravity = 49;
                    layoutParams.windowAnimations = 0;
                    a10.addView(atVar, layoutParams);
                    as asVar3 = as.this;
                    asVar3.f11549a = r3;
                    try {
                        atVar.setAlpha(0.0f);
                        atVar.measure(-2, -2);
                        atVar.animate().translationX(0.0f).translationY(atVar.getMeasuredHeight() * (-1)).setDuration(1L).setListener(new AnimatorListenerAdapter() { // from class: com.umeng.message.proguard.as.2

                            /* renamed from: a */
                            final /* synthetic */ View f11554a;

                            public AnonymousClass2(View atVar2) {
                                r2 = atVar2;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                r2.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(500L).setListener(null);
                            }
                        });
                        try {
                            r4.a(r3.b(), true);
                        } catch (Throwable th2) {
                            UPLog.e("Pop", "callback fail", th2.getMessage());
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z10 = true;
                        try {
                            UPLog.e("Pop", "show fail", th.getMessage());
                            try {
                                r4.a(r3.b(), z10);
                            } catch (Throwable th4) {
                                UPLog.e("Pop", "callback fail", th4.getMessage());
                            }
                        } catch (Throwable th5) {
                            try {
                                r4.a(r3.b(), z10);
                            } catch (Throwable th6) {
                                UPLog.e("Pop", "callback fail", th6.getMessage());
                            }
                            throw th5;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    z10 = false;
                }
            }
        });
        f11534c = b.a(new Runnable() { // from class: com.umeng.message.proguard.ao.1
            @Override // java.lang.Runnable
            public final void run() {
                Activity activity2;
                WeakReference weakReference = ao.f11533b;
                if (weakReference == null || (activity2 = (Activity) weakReference.get()) == null) {
                    return;
                }
                ao.b();
                ao.a(activity2);
            }
        }, ak.a().c().f11523a, TimeUnit.MILLISECONDS);
    }

    public static void a(Activity activity) {
        try {
            c();
            f11532a.a(activity);
        } catch (Throwable unused) {
        }
        f11533b = null;
    }

    public static void a(String str) {
        Activity activity;
        WeakReference<Activity> weakReference = f11533b;
        if (weakReference == null || (activity = weakReference.get()) == null || activity.isFinishing()) {
            return;
        }
        aq aqVar = f11532a.f11549a;
        boolean z10 = false;
        if (aqVar != null && TextUtils.equals(str, aqVar.a())) {
            z10 = aqVar.f11539b.isShown();
        }
        if (z10) {
            a(activity);
        }
    }
}
