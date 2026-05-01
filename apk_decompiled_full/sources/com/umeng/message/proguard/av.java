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
    */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        motionEvent.offsetLocation(0.0f, this.f11585m);
        if (this.f11579g < 2) {
            this.f11579g = this.f11577e.getHeight();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f11580h = motionEvent.getRawX();
            this.f11581i = motionEvent.getRawY();
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f11584l = obtain;
            obtain.addMovement(motionEvent);
            return false;
        }
        boolean z10 = true;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker = this.f11584l;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX = motionEvent.getRawX() - this.f11580h;
                    float rawY = motionEvent.getRawY() - this.f11581i;
                    if (Math.abs(rawY) > this.f11573a && Math.abs(rawX) < Math.abs(rawY) / 2.0f) {
                        this.f11582j = true;
                        this.f11583k = rawX > 0.0f ? this.f11573a : -this.f11573a;
                        this.f11577e.getParent().requestDisallowInterceptTouchEvent(true);
                        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                        obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f11577e.onTouchEvent(obtain2);
                        obtain2.recycle();
                    }
                    if (this.f11582j) {
                        float f10 = rawY - this.f11583k;
                        if (f10 > 0.0f) {
                            f10 = 0.0f;
                            rawY = 0.0f;
                        }
                        this.f11585m = rawY;
                        a(f10);
                        b(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawY) * 0.5f) / this.f11579g))));
                        return true;
                    }
                }
            } else if (actionMasked == 3 && this.f11584l != null) {
                a(0.0f, 1.0f, null);
                this.f11584l.recycle();
                this.f11584l = null;
                this.f11585m = 0.0f;
                this.f11580h = 0.0f;
                this.f11581i = 0.0f;
                this.f11582j = false;
            }
        } else if (this.f11584l != null) {
            float rawY2 = motionEvent.getRawY() - this.f11581i;
            this.f11584l.addMovement(motionEvent);
            this.f11584l.computeCurrentVelocity(1000);
            float xVelocity = this.f11584l.getXVelocity();
            float yVelocity = this.f11584l.getYVelocity();
            float abs = Math.abs(xVelocity);
            float abs2 = Math.abs(yVelocity);
            if (rawY2 < 0.0f) {
                double abs3 = Math.abs(rawY2);
                double d10 = this.f11579g;
                Double.isNaN(d10);
                if (abs3 > d10 / 2.0d) {
                }
            }
            if (this.f11574b > abs2 || abs2 > this.f11575c || abs >= abs2 || !this.f11582j || yVelocity >= 0.0f || rawY2 >= 0.0f) {
                z10 = false;
            }
            if (z10) {
                a(-this.f11579g, 0.0f, new AnimatorListenerAdapter() { // from class: com.umeng.message.proguard.av.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        av.a(av.this);
                    }
                });
            } else if (this.f11582j) {
                a(0.0f, 1.0f, null);
            }
            VelocityTracker velocityTracker2 = this.f11584l;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
            }
            this.f11584l = null;
            this.f11585m = 0.0f;
            this.f11580h = 0.0f;
            this.f11581i = 0.0f;
            this.f11582j = false;
        }
        return false;
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
