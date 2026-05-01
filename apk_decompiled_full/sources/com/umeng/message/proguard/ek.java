package com.umeng.message.proguard;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
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
    */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        motionEvent.offsetLocation(0.0f, this.f12071m);
        if (this.f12065g < 2) {
            this.f12065g = this.f12063e.getHeight();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f12066h = motionEvent.getRawX();
            this.f12067i = motionEvent.getRawY();
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f12070l = obtain;
            obtain.addMovement(motionEvent);
            return false;
        }
        boolean z10 = true;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker = this.f12070l;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX = motionEvent.getRawX() - this.f12066h;
                    float rawY = motionEvent.getRawY() - this.f12067i;
                    if (Math.abs(rawY) > this.f12059a && Math.abs(rawX) < Math.abs(rawY) / 2.0f) {
                        this.f12068j = true;
                        this.f12069k = rawX > 0.0f ? this.f12059a : -this.f12059a;
                        this.f12063e.getParent().requestDisallowInterceptTouchEvent(true);
                        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                        obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f12063e.onTouchEvent(obtain2);
                        obtain2.recycle();
                    }
                    if (this.f12068j) {
                        float f10 = rawY - this.f12069k;
                        if (f10 > 0.0f) {
                            f10 = 0.0f;
                            rawY = 0.0f;
                        }
                        this.f12071m = rawY;
                        a(f10);
                        b(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawX) * 2.0f) / this.f12065g))));
                        return true;
                    }
                }
            } else if (actionMasked == 3 && this.f12070l != null) {
                a(0.0f, 1.0f, null);
                this.f12070l.recycle();
                this.f12070l = null;
                this.f12071m = 0.0f;
                this.f12066h = 0.0f;
                this.f12067i = 0.0f;
                this.f12068j = false;
            }
        } else if (this.f12070l != null) {
            float rawY2 = motionEvent.getRawY() - this.f12067i;
            this.f12070l.addMovement(motionEvent);
            this.f12070l.computeCurrentVelocity(1000);
            float xVelocity = this.f12070l.getXVelocity();
            float yVelocity = this.f12070l.getYVelocity();
            float abs = Math.abs(xVelocity);
            float abs2 = Math.abs(yVelocity);
            if (rawY2 < 0.0f) {
                double abs3 = Math.abs(rawY2);
                double d10 = this.f12065g;
                Double.isNaN(d10);
                if (abs3 > d10 / 2.0d) {
                }
            }
            if (this.f12060b > abs2 || abs2 > this.f12061c || abs >= abs2 || !this.f12068j || yVelocity >= 0.0f || rawY2 >= 0.0f) {
                z10 = false;
            }
            if (z10) {
                a(-this.f12065g, 0.0f, new AnimatorListenerAdapter() { // from class: com.umeng.message.proguard.ek.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        ek.a(ek.this);
                    }
                });
            } else if (this.f12068j) {
                a(0.0f, 1.0f, null);
            }
            VelocityTracker velocityTracker2 = this.f12070l;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
            }
            this.f12070l = null;
            this.f12071m = 0.0f;
            this.f12066h = 0.0f;
            this.f12067i = 0.0f;
            this.f12068j = false;
        }
        return false;
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
