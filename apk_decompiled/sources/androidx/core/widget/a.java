package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import b0.c1;

/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: r, reason: collision with root package name */
    public static final int f2039r = ViewConfiguration.getTapTimeout();

    /* renamed from: c, reason: collision with root package name */
    public final View f2042c;

    /* renamed from: d, reason: collision with root package name */
    public Runnable f2043d;

    /* renamed from: g, reason: collision with root package name */
    public int f2046g;

    /* renamed from: h, reason: collision with root package name */
    public int f2047h;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2051l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2052m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2053n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2054o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2055p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2056q;

    /* renamed from: a, reason: collision with root package name */
    public final C0027a f2040a = new C0027a();

    /* renamed from: b, reason: collision with root package name */
    public final Interpolator f2041b = new AccelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    public float[] f2044e = {0.0f, 0.0f};

    /* renamed from: f, reason: collision with root package name */
    public float[] f2045f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: i, reason: collision with root package name */
    public float[] f2048i = {0.0f, 0.0f};

    /* renamed from: j, reason: collision with root package name */
    public float[] f2049j = {0.0f, 0.0f};

    /* renamed from: k, reason: collision with root package name */
    public float[] f2050k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    public static class C0027a {

        /* renamed from: a, reason: collision with root package name */
        public int f2057a;

        /* renamed from: b, reason: collision with root package name */
        public int f2058b;

        /* renamed from: c, reason: collision with root package name */
        public float f2059c;

        /* renamed from: d, reason: collision with root package name */
        public float f2060d;

        /* renamed from: j, reason: collision with root package name */
        public float f2066j;

        /* renamed from: k, reason: collision with root package name */
        public int f2067k;

        /* renamed from: e, reason: collision with root package name */
        public long f2061e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        public long f2065i = -1;

        /* renamed from: f, reason: collision with root package name */
        public long f2062f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f2063g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f2064h = 0;

        public void a() {
            if (this.f2062f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float g10 = g(e(currentAnimationTimeMillis));
            long j10 = currentAnimationTimeMillis - this.f2062f;
            this.f2062f = currentAnimationTimeMillis;
            float f10 = j10 * g10;
            this.f2063g = (int) (this.f2059c * f10);
            this.f2064h = (int) (f10 * this.f2060d);
        }

        public int b() {
            return this.f2063g;
        }

        public int c() {
            return this.f2064h;
        }

        public int d() {
            float f10 = this.f2059c;
            return (int) (f10 / Math.abs(f10));
        }

        public final float e(long j10) {
            if (j10 < this.f2061e) {
                return 0.0f;
            }
            long j11 = this.f2065i;
            if (j11 < 0 || j10 < j11) {
                return a.e((j10 - r0) / this.f2057a, 0.0f, 1.0f) * 0.5f;
            }
            float f10 = this.f2066j;
            return (1.0f - f10) + (f10 * a.e((j10 - j11) / this.f2067k, 0.0f, 1.0f));
        }

        public int f() {
            float f10 = this.f2060d;
            return (int) (f10 / Math.abs(f10));
        }

        public final float g(float f10) {
            return ((-4.0f) * f10 * f10) + (f10 * 4.0f);
        }

        public boolean h() {
            return this.f2065i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2065i + ((long) this.f2067k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2067k = a.f((int) (currentAnimationTimeMillis - this.f2061e), 0, this.f2058b);
            this.f2066j = e(currentAnimationTimeMillis);
            this.f2065i = currentAnimationTimeMillis;
        }

        public void j(int i10) {
            this.f2058b = i10;
        }

        public void k(int i10) {
            this.f2057a = i10;
        }

        public void l(float f10, float f11) {
            this.f2059c = f10;
            this.f2060d = f11;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2061e = currentAnimationTimeMillis;
            this.f2065i = -1L;
            this.f2062f = currentAnimationTimeMillis;
            this.f2066j = 0.5f;
            this.f2063g = 0;
            this.f2064h = 0;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f2054o) {
                if (aVar.f2052m) {
                    aVar.f2052m = false;
                    aVar.f2040a.m();
                }
                C0027a c0027a = a.this.f2040a;
                if (c0027a.h() || !a.this.u()) {
                    a.this.f2054o = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f2053n) {
                    aVar2.f2053n = false;
                    aVar2.c();
                }
                c0027a.a();
                a.this.j(c0027a.b(), c0027a.c());
                c1.c0(a.this.f2042c, this);
            }
        }
    }

    public a(View view) {
        this.f2042c = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (int) ((1575.0f * f10) + 0.5f);
        o(f11, f11);
        float f12 = (int) ((f10 * 315.0f) + 0.5f);
        p(f12, f12);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f2039r);
        r(500);
        q(500);
    }

    public static float e(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    public static int f(int i10, int i11, int i12) {
        return i10 > i12 ? i12 : i10 < i11 ? i11 : i10;
    }

    public abstract boolean a(int i10);

    public abstract boolean b(int i10);

    public void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f2042c.onTouchEvent(obtain);
        obtain.recycle();
    }

    public final float d(int i10, float f10, float f11, float f12) {
        float h10 = h(this.f2044e[i10], f11, this.f2045f[i10], f10);
        if (h10 == 0.0f) {
            return 0.0f;
        }
        float f13 = this.f2048i[i10];
        float f14 = this.f2049j[i10];
        float f15 = this.f2050k[i10];
        float f16 = f13 * f12;
        return h10 > 0.0f ? e(h10 * f16, f14, f15) : -e((-h10) * f16, f14, f15);
    }

    public final float g(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f2046g;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                if (f10 >= 0.0f) {
                    return 1.0f - (f10 / f11);
                }
                if (this.f2054o && i10 == 1) {
                    return 1.0f;
                }
            }
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        }
        return 0.0f;
    }

    public final float h(float f10, float f11, float f12, float f13) {
        float interpolation;
        float e10 = e(f10 * f11, 0.0f, f12);
        float g10 = g(f11 - f13, e10) - g(f13, e10);
        if (g10 < 0.0f) {
            interpolation = -this.f2041b.getInterpolation(-g10);
        } else {
            if (g10 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f2041b.getInterpolation(g10);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    public final void i() {
        if (this.f2052m) {
            this.f2054o = false;
        } else {
            this.f2040a.i();
        }
    }

    public abstract void j(int i10, int i11);

    public a k(int i10) {
        this.f2047h = i10;
        return this;
    }

    public a l(int i10) {
        this.f2046g = i10;
        return this;
    }

    public a m(boolean z10) {
        if (this.f2055p && !z10) {
            i();
        }
        this.f2055p = z10;
        return this;
    }

    public a n(float f10, float f11) {
        float[] fArr = this.f2045f;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a o(float f10, float f11) {
        float[] fArr = this.f2050k;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f2055p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f2053n = r2
            r5.f2051l = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f2042c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f2042c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f2040a
            r7.l(r0, r6)
            boolean r6 = r5.f2054o
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f2056q
            if (r6 == 0) goto L61
            boolean r6 = r5.f2054o
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f10, float f11) {
        float[] fArr = this.f2049j;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public a q(int i10) {
        this.f2040a.j(i10);
        return this;
    }

    public a r(int i10) {
        this.f2040a.k(i10);
        return this;
    }

    public a s(float f10, float f11) {
        float[] fArr = this.f2044e;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a t(float f10, float f11) {
        float[] fArr = this.f2048i;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public boolean u() {
        C0027a c0027a = this.f2040a;
        int f10 = c0027a.f();
        int d10 = c0027a.d();
        return (f10 != 0 && b(f10)) || (d10 != 0 && a(d10));
    }

    public final void v() {
        int i10;
        if (this.f2043d == null) {
            this.f2043d = new b();
        }
        this.f2054o = true;
        this.f2052m = true;
        if (this.f2051l || (i10 = this.f2047h) <= 0) {
            this.f2043d.run();
        } else {
            c1.d0(this.f2042c, this.f2043d, i10);
        }
        this.f2051l = true;
    }
}
