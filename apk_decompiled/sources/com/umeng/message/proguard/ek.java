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
public final class ek implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private final int f12059a;

    /* renamed from: b, reason: collision with root package name */
    private final int f12060b;

    /* renamed from: c, reason: collision with root package name */
    private final int f12061c;

    /* renamed from: d, reason: collision with root package name */
    private final long f12062d;

    /* renamed from: e, reason: collision with root package name */
    private final View f12063e;

    /* renamed from: f, reason: collision with root package name */
    private final View.OnClickListener f12064f;

    /* renamed from: g, reason: collision with root package name */
    private int f12065g = 1;

    /* renamed from: h, reason: collision with root package name */
    private float f12066h;

    /* renamed from: i, reason: collision with root package name */
    private float f12067i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12068j;

    /* renamed from: k, reason: collision with root package name */
    private int f12069k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f12070l;

    /* renamed from: m, reason: collision with root package name */
    private float f12071m;

    public ek(View view, View.OnClickListener onClickListener) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f12059a = viewConfiguration.getScaledTouchSlop();
        this.f12060b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f12061c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f12062d = view.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.f12063e = view;
        this.f12064f = onClickListener;
    }

    public final void a(float f10) {
        this.f12063e.setTranslationY(f10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x010a, code lost:
    
        if (r13.f12068j != false) goto L57;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r14, android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.ek.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void a(float f10, float f11, AnimatorListenerAdapter animatorListenerAdapter) {
        final float translationY = this.f12063e.getTranslationY();
        final float f12 = f10 - translationY;
        final float alpha = this.f12063e.getAlpha();
        final float f13 = f11 - alpha;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(this.f12062d);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.umeng.message.proguard.ek.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = translationY + (valueAnimator.getAnimatedFraction() * f12);
                float animatedFraction2 = alpha + (valueAnimator.getAnimatedFraction() * f13);
                ek.this.a(animatedFraction);
                ek.this.b(animatedFraction2);
            }
        });
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
    }

    public final void b(float f10) {
        this.f12063e.setAlpha(f10);
    }

    public static /* synthetic */ void a(ek ekVar) {
        final ViewGroup.LayoutParams layoutParams = ekVar.f12063e.getLayoutParams();
        final int width = ekVar.f12063e.getWidth();
        ValueAnimator duration = ValueAnimator.ofInt(width, 1).setDuration(ekVar.f12062d);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.umeng.message.proguard.ek.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ek.this.f12064f.onClick(ek.this.f12063e);
                ek.this.f12063e.setAlpha(1.0f);
                ek.this.f12063e.setTranslationY(0.0f);
                layoutParams.width = width;
                ek.this.f12063e.setLayoutParams(layoutParams);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.umeng.message.proguard.ek.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ek.this.f12063e.setLayoutParams(layoutParams);
            }
        });
        duration.start();
    }
}
