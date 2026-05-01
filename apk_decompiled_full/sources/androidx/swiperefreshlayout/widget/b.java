package androidx.swiperefreshlayout.widget;

import a0.h;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.mobile.brasiltv.view.RoundedDrawable;

/* loaded from: classes.dex */
public class b extends Drawable implements Animatable {

    /* renamed from: g, reason: collision with root package name */
    public static final Interpolator f3375g = new LinearInterpolator();

    /* renamed from: h, reason: collision with root package name */
    public static final Interpolator f3376h = new h0.b();

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f3377i = {RoundedDrawable.DEFAULT_BORDER_COLOR};

    /* renamed from: a, reason: collision with root package name */
    public final c f3378a;

    /* renamed from: b, reason: collision with root package name */
    public float f3379b;

    /* renamed from: c, reason: collision with root package name */
    public Resources f3380c;

    /* renamed from: d, reason: collision with root package name */
    public Animator f3381d;

    /* renamed from: e, reason: collision with root package name */
    public float f3382e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3383f;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f3384a;

        public a(c cVar) {
            this.f3384a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.n(floatValue, this.f3384a);
            b.this.b(floatValue, this.f3384a, false);
            b.this.invalidateSelf();
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.b$b, reason: collision with other inner class name */
    public class C0055b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f3386a;

        public C0055b(c cVar) {
            this.f3386a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.b(1.0f, this.f3386a, true);
            this.f3386a.A();
            this.f3386a.l();
            b bVar = b.this;
            if (!bVar.f3383f) {
                bVar.f3382e += 1.0f;
                return;
            }
            bVar.f3383f = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f3386a.x(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f3382e = 0.0f;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final RectF f3388a = new RectF();

        /* renamed from: b, reason: collision with root package name */
        public final Paint f3389b;

        /* renamed from: c, reason: collision with root package name */
        public final Paint f3390c;

        /* renamed from: d, reason: collision with root package name */
        public final Paint f3391d;

        /* renamed from: e, reason: collision with root package name */
        public float f3392e;

        /* renamed from: f, reason: collision with root package name */
        public float f3393f;

        /* renamed from: g, reason: collision with root package name */
        public float f3394g;

        /* renamed from: h, reason: collision with root package name */
        public float f3395h;

        /* renamed from: i, reason: collision with root package name */
        public int[] f3396i;

        /* renamed from: j, reason: collision with root package name */
        public int f3397j;

        /* renamed from: k, reason: collision with root package name */
        public float f3398k;

        /* renamed from: l, reason: collision with root package name */
        public float f3399l;

        /* renamed from: m, reason: collision with root package name */
        public float f3400m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f3401n;

        /* renamed from: o, reason: collision with root package name */
        public Path f3402o;

        /* renamed from: p, reason: collision with root package name */
        public float f3403p;

        /* renamed from: q, reason: collision with root package name */
        public float f3404q;

        /* renamed from: r, reason: collision with root package name */
        public int f3405r;

        /* renamed from: s, reason: collision with root package name */
        public int f3406s;

        /* renamed from: t, reason: collision with root package name */
        public int f3407t;

        /* renamed from: u, reason: collision with root package name */
        public int f3408u;

        public c() {
            Paint paint = new Paint();
            this.f3389b = paint;
            Paint paint2 = new Paint();
            this.f3390c = paint2;
            Paint paint3 = new Paint();
            this.f3391d = paint3;
            this.f3392e = 0.0f;
            this.f3393f = 0.0f;
            this.f3394g = 0.0f;
            this.f3395h = 5.0f;
            this.f3403p = 1.0f;
            this.f3407t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public void A() {
            this.f3398k = this.f3392e;
            this.f3399l = this.f3393f;
            this.f3400m = this.f3394g;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f3388a;
            float f10 = this.f3404q;
            float f11 = (this.f3395h / 2.0f) + f10;
            if (f10 <= 0.0f) {
                f11 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f3405r * this.f3403p) / 2.0f, this.f3395h / 2.0f);
            }
            rectF.set(rect.centerX() - f11, rect.centerY() - f11, rect.centerX() + f11, rect.centerY() + f11);
            float f12 = this.f3392e;
            float f13 = this.f3394g;
            float f14 = (f12 + f13) * 360.0f;
            float f15 = ((this.f3393f + f13) * 360.0f) - f14;
            this.f3389b.setColor(this.f3408u);
            this.f3389b.setAlpha(this.f3407t);
            float f16 = this.f3395h / 2.0f;
            rectF.inset(f16, f16);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f3391d);
            float f17 = -f16;
            rectF.inset(f17, f17);
            canvas.drawArc(rectF, f14, f15, false, this.f3389b);
            b(canvas, f14, f15, rectF);
        }

        public void b(Canvas canvas, float f10, float f11, RectF rectF) {
            if (this.f3401n) {
                Path path = this.f3402o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f3402o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f12 = (this.f3405r * this.f3403p) / 2.0f;
                this.f3402o.moveTo(0.0f, 0.0f);
                this.f3402o.lineTo(this.f3405r * this.f3403p, 0.0f);
                Path path3 = this.f3402o;
                float f13 = this.f3405r;
                float f14 = this.f3403p;
                path3.lineTo((f13 * f14) / 2.0f, this.f3406s * f14);
                this.f3402o.offset((min + rectF.centerX()) - f12, rectF.centerY() + (this.f3395h / 2.0f));
                this.f3402o.close();
                this.f3390c.setColor(this.f3408u);
                this.f3390c.setAlpha(this.f3407t);
                canvas.save();
                canvas.rotate(f10 + f11, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f3402o, this.f3390c);
                canvas.restore();
            }
        }

        public int c() {
            return this.f3407t;
        }

        public float d() {
            return this.f3393f;
        }

        public int e() {
            return this.f3396i[f()];
        }

        public int f() {
            return (this.f3397j + 1) % this.f3396i.length;
        }

        public float g() {
            return this.f3392e;
        }

        public int h() {
            return this.f3396i[this.f3397j];
        }

        public float i() {
            return this.f3399l;
        }

        public float j() {
            return this.f3400m;
        }

        public float k() {
            return this.f3398k;
        }

        public void l() {
            t(f());
        }

        public void m() {
            this.f3398k = 0.0f;
            this.f3399l = 0.0f;
            this.f3400m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        public void n(int i10) {
            this.f3407t = i10;
        }

        public void o(float f10, float f11) {
            this.f3405r = (int) f10;
            this.f3406s = (int) f11;
        }

        public void p(float f10) {
            if (f10 != this.f3403p) {
                this.f3403p = f10;
            }
        }

        public void q(float f10) {
            this.f3404q = f10;
        }

        public void r(int i10) {
            this.f3408u = i10;
        }

        public void s(ColorFilter colorFilter) {
            this.f3389b.setColorFilter(colorFilter);
        }

        public void t(int i10) {
            this.f3397j = i10;
            this.f3408u = this.f3396i[i10];
        }

        public void u(int[] iArr) {
            this.f3396i = iArr;
            t(0);
        }

        public void v(float f10) {
            this.f3393f = f10;
        }

        public void w(float f10) {
            this.f3394g = f10;
        }

        public void x(boolean z10) {
            if (this.f3401n != z10) {
                this.f3401n = z10;
            }
        }

        public void y(float f10) {
            this.f3392e = f10;
        }

        public void z(float f10) {
            this.f3395h = f10;
            this.f3389b.setStrokeWidth(f10);
        }
    }

    public b(Context context) {
        this.f3380c = ((Context) h.d(context)).getResources();
        c cVar = new c();
        this.f3378a = cVar;
        cVar.u(f3377i);
        k(2.5f);
        m();
    }

    public final void a(float f10, c cVar) {
        n(f10, cVar);
        float floor = (float) (Math.floor(cVar.j() / 0.8f) + 1.0d);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f10));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((floor - cVar.j()) * f10));
    }

    public void b(float f10, c cVar, boolean z10) {
        float interpolation;
        float f11;
        if (this.f3383f) {
            a(f10, cVar);
            return;
        }
        if (f10 != 1.0f || z10) {
            float j10 = cVar.j();
            if (f10 < 0.5f) {
                interpolation = cVar.k();
                f11 = (f3376h.getInterpolation(f10 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float k10 = cVar.k() + 0.79f;
                interpolation = k10 - (((1.0f - f3376h.getInterpolation((f10 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f11 = k10;
            }
            float f12 = j10 + (0.20999998f * f10);
            float f13 = (f10 + this.f3382e) * 216.0f;
            cVar.y(interpolation);
            cVar.v(f11);
            cVar.w(f12);
            h(f13);
        }
    }

    public final int c(float f10, int i10, int i11) {
        return ((((i10 >> 24) & 255) + ((int) ((((i11 >> 24) & 255) - r0) * f10))) << 24) | ((((i10 >> 16) & 255) + ((int) ((((i11 >> 16) & 255) - r1) * f10))) << 16) | ((((i10 >> 8) & 255) + ((int) ((((i11 >> 8) & 255) - r2) * f10))) << 8) | ((i10 & 255) + ((int) (f10 * ((i11 & 255) - r8))));
    }

    public void d(boolean z10) {
        this.f3378a.x(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f3379b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f3378a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f10) {
        this.f3378a.p(f10);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f3378a.u(iArr);
        this.f3378a.t(0);
        invalidateSelf();
    }

    public void g(float f10) {
        this.f3378a.w(f10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3378a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(float f10) {
        this.f3379b = f10;
    }

    public final void i(float f10, float f11, float f12, float f13) {
        c cVar = this.f3378a;
        float f14 = this.f3380c.getDisplayMetrics().density;
        cVar.z(f11 * f14);
        cVar.q(f10 * f14);
        cVar.t(0);
        cVar.o(f12 * f14, f13 * f14);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f3381d.isRunning();
    }

    public void j(float f10, float f11) {
        this.f3378a.y(f10);
        this.f3378a.v(f11);
        invalidateSelf();
    }

    public void k(float f10) {
        this.f3378a.z(f10);
        invalidateSelf();
    }

    public void l(int i10) {
        if (i10 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void m() {
        c cVar = this.f3378a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f3375g);
        ofFloat.addListener(new C0055b(cVar));
        this.f3381d = ofFloat;
    }

    public void n(float f10, c cVar) {
        if (f10 > 0.75f) {
            cVar.r(c((f10 - 0.75f) / 0.25f, cVar.h(), cVar.e()));
        } else {
            cVar.r(cVar.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f3378a.n(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3378a.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f3381d.cancel();
        this.f3378a.A();
        if (this.f3378a.d() != this.f3378a.g()) {
            this.f3383f = true;
            this.f3381d.setDuration(666L);
            this.f3381d.start();
        } else {
            this.f3378a.t(0);
            this.f3378a.m();
            this.f3381d.setDuration(1332L);
            this.f3381d.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f3381d.cancel();
        h(0.0f);
        this.f3378a.x(false);
        this.f3378a.t(0);
        this.f3378a.m();
        invalidateSelf();
    }
}
