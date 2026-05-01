package com.hpplay.sdk.source.browser.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class LoadingView extends View {
    private int A;
    private int B;
    private boolean C;
    private ValueAnimator D;
    private ValueAnimator E;
    private ValueAnimator F;

    /* renamed from: a, reason: collision with root package name */
    private Paint f7496a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f7497b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f7498c;

    /* renamed from: d, reason: collision with root package name */
    private RectF f7499d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f7500e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f7501f;

    /* renamed from: g, reason: collision with root package name */
    private Path f7502g;

    /* renamed from: h, reason: collision with root package name */
    private Path f7503h;

    /* renamed from: i, reason: collision with root package name */
    private Path f7504i;

    /* renamed from: j, reason: collision with root package name */
    private Path f7505j;

    /* renamed from: k, reason: collision with root package name */
    private Path f7506k;

    /* renamed from: l, reason: collision with root package name */
    private Path f7507l;

    /* renamed from: m, reason: collision with root package name */
    private PathMeasure f7508m;

    /* renamed from: n, reason: collision with root package name */
    private int f7509n;

    /* renamed from: o, reason: collision with root package name */
    private int f7510o;

    /* renamed from: p, reason: collision with root package name */
    private float f7511p;

    /* renamed from: q, reason: collision with root package name */
    private float f7512q;

    /* renamed from: r, reason: collision with root package name */
    private float f7513r;

    /* renamed from: s, reason: collision with root package name */
    private float f7514s;

    /* renamed from: t, reason: collision with root package name */
    private int f7515t;

    /* renamed from: u, reason: collision with root package name */
    private float f7516u;

    /* renamed from: v, reason: collision with root package name */
    private float f7517v;

    /* renamed from: w, reason: collision with root package name */
    private float f7518w;

    /* renamed from: x, reason: collision with root package name */
    private float f7519x;

    /* renamed from: y, reason: collision with root package name */
    private float f7520y;

    /* renamed from: z, reason: collision with root package name */
    private float f7521z;

    public LoadingView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int c(LoadingView loadingView) {
        int i10 = loadingView.A;
        loadingView.A = i10 + 1;
        return i10;
    }

    private void d() {
        float f10 = this.f7514s + (this.f7517v * 2.0f);
        RectF rectF = this.f7499d;
        float f11 = this.f7519x;
        float f12 = this.f7516u;
        rectF.set(f10, f11, f10 + f12, f12 + f11);
        RectF rectF2 = this.f7500e;
        float f13 = this.f7499d.left;
        float f14 = this.f7516u;
        float f15 = this.f7517v;
        float f16 = this.f7519x;
        rectF2.set(f13 + f14 + f15, f16, f13 + f14 + f15 + f14, f14 + f16);
        RectF rectF3 = this.f7501f;
        float f17 = this.f7500e.left;
        float f18 = this.f7516u;
        float f19 = this.f7517v;
        float f20 = this.f7519x;
        rectF3.set(f17 + f18 + f19, f20, f17 + f18 + f19 + f18, f18 + f20);
        this.f7503h.reset();
        this.f7504i.reset();
        this.f7505j.reset();
        this.f7503h.addRect(this.f7499d, Path.Direction.CW);
        this.f7504i.addRect(this.f7500e, Path.Direction.CW);
        this.f7505j.addRect(this.f7501f, Path.Direction.CW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.E == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f7519x, this.f7520y);
            this.E = ofFloat;
            ofFloat.setDuration(this.B / 6);
            this.E.setRepeatCount(2);
            this.E.setInterpolator(new LinearInterpolator());
            this.E.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.hpplay.sdk.source.browser.view.LoadingView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LoadingView.this.f7521z = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            });
            this.E.addListener(new AnimatorListenerAdapter() { // from class: com.hpplay.sdk.source.browser.view.LoadingView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LoadingView.c(LoadingView.this);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    LoadingView.this.A = 1;
                }
            });
        }
        if (this.F == null) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(this.f7520y, this.f7519x);
            this.F = ofFloat2;
            ofFloat2.setDuration(this.B / 6);
            this.F.setRepeatCount(2);
            this.F.setInterpolator(new BounceInterpolator());
            this.F.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.hpplay.sdk.source.browser.view.LoadingView.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LoadingView.this.f7521z = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            });
            this.F.addListener(new AnimatorListenerAdapter() { // from class: com.hpplay.sdk.source.browser.view.LoadingView.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LoadingView.c(LoadingView.this);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    LoadingView.c(LoadingView.this);
                }
            });
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.E).before(this.F);
        animatorSet.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getPaddingLeft(), getPaddingTop() + (this.f7510o / 2));
        this.f7506k.reset();
        PathMeasure pathMeasure = this.f7508m;
        float f10 = this.f7511p;
        pathMeasure.getSegment(f10, this.f7512q + f10, this.f7506k, true);
        canvas.drawPath(this.f7506k, this.f7496a);
        float f11 = this.f7511p;
        float f12 = this.f7512q;
        float f13 = f11 + f12;
        float f14 = this.f7513r;
        if (f13 > f14) {
            this.f7507l.reset();
            this.f7508m.getSegment(0.0f, (f11 + f12) - f14, this.f7507l, true);
            canvas.drawPath(this.f7507l, this.f7496a);
        }
        a(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f7509n = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.f7510o = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        this.f7514s = a(this.f7509n, 18.0f);
        this.f7502g.reset();
        this.f7496a.setColor(-1);
        float f10 = this.f7514s;
        RectF rectF = new RectF(f10 / 2.0f, 0.0f, this.f7509n - (f10 / 2.0f), (this.f7510o / 2) - (f10 / 2.0f));
        this.f7498c = rectF;
        Path path = this.f7502g;
        int i14 = this.f7515t;
        path.addRoundRect(rectF, i14, i14, Path.Direction.CW);
        PathMeasure pathMeasure = new PathMeasure(this.f7502g, false);
        this.f7508m = pathMeasure;
        float length = pathMeasure.getLength();
        this.f7513r = length;
        this.f7512q = length / 6.0f;
        float a10 = a(this.f7509n - (this.f7514s * 2.0f), 15.0f);
        this.f7517v = a10;
        this.f7516u = a10 * 3.0f;
        float a11 = a((this.f7498c.height() - this.f7516u) - (this.f7514s * 1.5f), 2.0f);
        this.f7518w = a11;
        this.f7519x = this.f7514s + a11;
        this.f7520y = -(this.f7498c.height() - this.f7518w);
        a();
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        this.f7502g = new Path();
        Paint paint = new Paint();
        this.f7496a = paint;
        paint.setColor(-1);
        this.f7496a.setStyle(Paint.Style.STROKE);
        this.f7496a.setStrokeWidth(this.f7514s);
        this.f7496a.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f7497b = paint2;
        paint2.setColor(-1);
        this.f7497b.setAntiAlias(true);
        this.f7497b.setStyle(Paint.Style.FILL);
        this.f7499d = new RectF();
        this.f7500e = new RectF();
        this.f7501f = new RectF();
        this.f7503h = new Path();
        this.f7504i = new Path();
        this.f7505j = new Path();
        this.f7506k = new Path();
        this.f7507l = new Path();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7514s = 6.0f;
        this.f7515t = 10;
        this.A = 1;
        this.B = 1584;
        this.C = false;
        c();
    }

    public void b() {
        this.C = false;
        ValueAnimator valueAnimator = this.D;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.E;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator3 = this.F;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
    }

    private void a(Canvas canvas) {
        float f10 = this.f7514s;
        float f11 = this.f7517v;
        float f12 = f10 + (2.0f * f11);
        int i10 = this.A;
        if (i10 == 1 || i10 == 4) {
            RectF rectF = this.f7499d;
            float f13 = this.f7521z;
            float f14 = this.f7516u;
            rectF.set(f12, f13, f12 + f14, f14 + f13);
            this.f7503h.reset();
            this.f7503h.addRect(this.f7499d, Path.Direction.CW);
        } else if (i10 != 2 && i10 != 5) {
            RectF rectF2 = this.f7501f;
            float f15 = this.f7500e.left;
            float f16 = this.f7516u;
            float f17 = this.f7521z;
            rectF2.set(f15 + f16 + f11, f17, f15 + f16 + f11 + f16, f16 + f17);
            this.f7505j.reset();
            this.f7505j.addRect(this.f7501f, Path.Direction.CW);
        } else {
            RectF rectF3 = this.f7500e;
            float f18 = this.f7516u;
            float f19 = this.f7521z;
            rectF3.set(f12 + f18 + f11, f19, f12 + f18 + f11 + f18, f18 + f19);
            this.f7504i.reset();
            this.f7504i.addRect(this.f7500e, Path.Direction.CW);
        }
        canvas.drawPath(this.f7503h, this.f7497b);
        canvas.drawPath(this.f7504i, this.f7497b);
        canvas.drawPath(this.f7505j, this.f7497b);
    }

    public void a() {
        if (this.f7513r <= 0.0f || this.C) {
            return;
        }
        d();
        b();
        this.C = true;
        if (this.D == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.f7513r);
            this.D = ofFloat;
            ofFloat.setDuration(this.B);
            this.D.setRepeatCount(-1);
            this.D.setInterpolator(new LinearInterpolator());
            final float f10 = (this.f7513r - this.f7512q) - (this.f7515t * 2);
            this.D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.hpplay.sdk.source.browser.view.LoadingView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LoadingView.this.f7511p = (f10 + ((Float) valueAnimator.getAnimatedValue()).floatValue()) % LoadingView.this.f7513r;
                    LoadingView.this.invalidate();
                }
            });
            this.D.addListener(new AnimatorListenerAdapter() { // from class: com.hpplay.sdk.source.browser.view.LoadingView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LoadingView.this.e();
                }
            });
        }
        this.D.start();
        e();
    }

    private float a(float f10, float f11) {
        return new BigDecimal(Float.toString(f10)).divide(new BigDecimal(Float.toString(f11)), 2, 4).floatValue();
    }
}
