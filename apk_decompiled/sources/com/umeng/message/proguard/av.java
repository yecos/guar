package com.umeng.message.proguard;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
final class av implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private final int f11573a;

    /* renamed from: b, reason: collision with root package name */
    private final int f11574b;

    /* renamed from: c, reason: collision with root package name */
    private final int f11575c;

    /* renamed from: d, reason: collision with root package name */
    private final long f11576d;

    /* renamed from: e, reason: collision with root package name */
    private final View f11577e;

    /* renamed from: f, reason: collision with root package name */
    private final a f11578f;

    /* renamed from: g, reason: collision with root package name */
    private int f11579g = 1;

    /* renamed from: h, reason: collision with root package name */
    private float f11580h;

    /* renamed from: i, reason: collision with root package name */
    private float f11581i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f11582j;

    /* renamed from: k, reason: collision with root package name */
    private int f11583k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f11584l;

    /* renamed from: m, reason: collision with root package name */
    private float f11585m;

    public static abstract class a {
        public abstract void a(View view);
    }

    public av(View view, a aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f11573a = viewConfiguration.getScaledTouchSlop();
        this.f11574b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f11575c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f11576d = view.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.f11577e = view;
        this.f11578f = aVar;
    }

    public final void a(float f10) {
        this.f11577e.setTranslationY(f10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x010c, code lost:
    
        if (r13.f11582j != false) goto L57;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r14, android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.av.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void a(float f10, float f11, AnimatorListenerAdapter animatorListenerAdapter) {
        final float translationY = this.f11577e.getTranslationY();
        final float f12 = f10 - translationY;
        final float alpha = this.f11577e.getAlpha();
        final float f13 = f11 - alpha;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(this.f11576d);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.umeng.message.proguard.av.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = translationY + (valueAnimator.getAnimatedFraction() * f12);
                float animatedFraction2 = alpha + (valueAnimator.getAnimatedFraction() * f13);
                av.this.a(animatedFraction);
                av.this.b(animatedFraction2);
            }
        });
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
    }

    public final void b(float f10) {
        this.f11577e.setAlpha(f10);
    }

    public static /* synthetic */ void a(av avVar) {
        final ViewGroup.LayoutParams layoutParams = avVar.f11577e.getLayoutParams();
        final int width = avVar.f11577e.getWidth();
        ValueAnimator duration = ValueAnimator.ofInt(width, 1).setDuration(avVar.f11576d);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.umeng.message.proguard.av.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                av.this.f11578f.a(av.this.f11577e);
                av.this.f11577e.setAlpha(1.0f);
                av.this.f11577e.setTranslationY(0.0f);
                layoutParams.width = width;
                av.this.f11577e.setLayoutParams(layoutParams);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.umeng.message.proguard.av.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                av.this.f11577e.setLayoutParams(layoutParams);
            }
        });
        duration.start();
    }
}
