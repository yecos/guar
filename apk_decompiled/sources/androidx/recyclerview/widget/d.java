package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import b0.c1;

/* loaded from: classes.dex */
public class d extends RecyclerView.n implements RecyclerView.s {
    public static final int[] D = {R.attr.state_pressed};
    public static final int[] E = new int[0];
    public int A;
    public final Runnable B;
    public final RecyclerView.t C;

    /* renamed from: a, reason: collision with root package name */
    public final int f3203a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3204b;

    /* renamed from: c, reason: collision with root package name */
    public final StateListDrawable f3205c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f3206d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3207e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3208f;

    /* renamed from: g, reason: collision with root package name */
    public final StateListDrawable f3209g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f3210h;

    /* renamed from: i, reason: collision with root package name */
    public final int f3211i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3212j;

    /* renamed from: k, reason: collision with root package name */
    public int f3213k;

    /* renamed from: l, reason: collision with root package name */
    public int f3214l;

    /* renamed from: m, reason: collision with root package name */
    public float f3215m;

    /* renamed from: n, reason: collision with root package name */
    public int f3216n;

    /* renamed from: o, reason: collision with root package name */
    public int f3217o;

    /* renamed from: p, reason: collision with root package name */
    public float f3218p;

    /* renamed from: s, reason: collision with root package name */
    public RecyclerView f3221s;

    /* renamed from: z, reason: collision with root package name */
    public final ValueAnimator f3228z;

    /* renamed from: q, reason: collision with root package name */
    public int f3219q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f3220r = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3222t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3223u = false;

    /* renamed from: v, reason: collision with root package name */
    public int f3224v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f3225w = 0;

    /* renamed from: x, reason: collision with root package name */
    public final int[] f3226x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    public final int[] f3227y = new int[2];

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.h(500);
        }
    }

    public class b extends RecyclerView.t {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            d.this.s(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f3231a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3231a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3231a) {
                this.f3231a = false;
                return;
            }
            if (((Float) d.this.f3228z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.A = 0;
                dVar.p(0);
            } else {
                d dVar2 = d.this;
                dVar2.A = 2;
                dVar2.m();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$d, reason: collision with other inner class name */
    public class C0046d implements ValueAnimator.AnimatorUpdateListener {
        public C0046d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f3205c.setAlpha(floatValue);
            d.this.f3206d.setAlpha(floatValue);
            d.this.m();
        }
    }

    public d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f3228z = ofFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f3205c = stateListDrawable;
        this.f3206d = drawable;
        this.f3209g = stateListDrawable2;
        this.f3210h = drawable2;
        this.f3207e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f3208f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f3211i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f3212j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f3203a = i11;
        this.f3204b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new C0046d());
        a(recyclerView);
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3221s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            c();
        }
        this.f3221s = recyclerView;
        if (recyclerView != null) {
            q();
        }
    }

    public final void b() {
        this.f3221s.removeCallbacks(this.B);
    }

    public final void c() {
        this.f3221s.removeItemDecoration(this);
        this.f3221s.removeOnItemTouchListener(this);
        this.f3221s.removeOnScrollListener(this.C);
        b();
    }

    public final void d(Canvas canvas) {
        int i10 = this.f3220r;
        int i11 = this.f3211i;
        int i12 = this.f3217o;
        int i13 = this.f3216n;
        this.f3209g.setBounds(0, 0, i13, i11);
        this.f3210h.setBounds(0, 0, this.f3219q, this.f3212j);
        canvas.translate(0.0f, i10 - i11);
        this.f3210h.draw(canvas);
        canvas.translate(i12 - (i13 / 2), 0.0f);
        this.f3209g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    public final void e(Canvas canvas) {
        int i10 = this.f3219q;
        int i11 = this.f3207e;
        int i12 = i10 - i11;
        int i13 = this.f3214l;
        int i14 = this.f3213k;
        int i15 = i13 - (i14 / 2);
        this.f3205c.setBounds(0, 0, i11, i14);
        this.f3206d.setBounds(0, 0, this.f3208f, this.f3220r);
        if (!j()) {
            canvas.translate(i12, 0.0f);
            this.f3206d.draw(canvas);
            canvas.translate(0.0f, i15);
            this.f3205c.draw(canvas);
            canvas.translate(-i12, -i15);
            return;
        }
        this.f3206d.draw(canvas);
        canvas.translate(this.f3207e, i15);
        canvas.scale(-1.0f, 1.0f);
        this.f3205c.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.f3207e, -i15);
    }

    public final int[] f() {
        int[] iArr = this.f3227y;
        int i10 = this.f3204b;
        iArr[0] = i10;
        iArr[1] = this.f3219q - i10;
        return iArr;
    }

    public final int[] g() {
        int[] iArr = this.f3226x;
        int i10 = this.f3204b;
        iArr[0] = i10;
        iArr[1] = this.f3220r - i10;
        return iArr;
    }

    public void h(int i10) {
        int i11 = this.A;
        if (i11 == 1) {
            this.f3228z.cancel();
        } else if (i11 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f3228z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f3228z.setDuration(i10);
        this.f3228z.start();
    }

    public final void i(float f10) {
        int[] f11 = f();
        float max = Math.max(f11[0], Math.min(f11[1], f10));
        if (Math.abs(this.f3217o - max) < 2.0f) {
            return;
        }
        int o10 = o(this.f3218p, max, f11, this.f3221s.computeHorizontalScrollRange(), this.f3221s.computeHorizontalScrollOffset(), this.f3219q);
        if (o10 != 0) {
            this.f3221s.scrollBy(o10, 0);
        }
        this.f3218p = max;
    }

    public final boolean j() {
        return c1.z(this.f3221s) == 1;
    }

    public boolean k(float f10, float f11) {
        if (f11 >= this.f3220r - this.f3211i) {
            int i10 = this.f3217o;
            int i11 = this.f3216n;
            if (f10 >= i10 - (i11 / 2) && f10 <= i10 + (i11 / 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean l(float f10, float f11) {
        if (!j() ? f10 >= this.f3219q - this.f3207e : f10 <= this.f3207e / 2) {
            int i10 = this.f3214l;
            int i11 = this.f3213k;
            if (f11 >= i10 - (i11 / 2) && f11 <= i10 + (i11 / 2)) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        this.f3221s.invalidate();
    }

    public final void n(int i10) {
        b();
        this.f3221s.postDelayed(this.B, i10);
    }

    public final int o(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 == 0) {
            return 0;
        }
        int i14 = i10 - i12;
        int i15 = (int) (((f11 - f10) / i13) * i14);
        int i16 = i11 + i15;
        if (i16 >= i14 || i16 < 0) {
            return 0;
        }
        return i15;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.f3219q != this.f3221s.getWidth() || this.f3220r != this.f3221s.getHeight()) {
            this.f3219q = this.f3221s.getWidth();
            this.f3220r = this.f3221s.getHeight();
            p(0);
        } else if (this.A != 0) {
            if (this.f3222t) {
                e(canvas);
            }
            if (this.f3223u) {
                d(canvas);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f3224v;
        if (i10 == 1) {
            boolean l10 = l(motionEvent.getX(), motionEvent.getY());
            boolean k10 = k(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!l10 && !k10) {
                return false;
            }
            if (k10) {
                this.f3225w = 1;
                this.f3218p = (int) motionEvent.getX();
            } else if (l10) {
                this.f3225w = 2;
                this.f3215m = (int) motionEvent.getY();
            }
            p(2);
        } else if (i10 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onRequestDisallowInterceptTouchEvent(boolean z10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f3224v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean l10 = l(motionEvent.getX(), motionEvent.getY());
            boolean k10 = k(motionEvent.getX(), motionEvent.getY());
            if (l10 || k10) {
                if (k10) {
                    this.f3225w = 1;
                    this.f3218p = (int) motionEvent.getX();
                } else if (l10) {
                    this.f3225w = 2;
                    this.f3215m = (int) motionEvent.getY();
                }
                p(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f3224v == 2) {
            this.f3215m = 0.0f;
            this.f3218p = 0.0f;
            p(1);
            this.f3225w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f3224v == 2) {
            r();
            if (this.f3225w == 1) {
                i(motionEvent.getX());
            }
            if (this.f3225w == 2) {
                t(motionEvent.getY());
            }
        }
    }

    public void p(int i10) {
        if (i10 == 2 && this.f3224v != 2) {
            this.f3205c.setState(D);
            b();
        }
        if (i10 == 0) {
            m();
        } else {
            r();
        }
        if (this.f3224v == 2 && i10 != 2) {
            this.f3205c.setState(E);
            n(1200);
        } else if (i10 == 1) {
            n(1500);
        }
        this.f3224v = i10;
    }

    public final void q() {
        this.f3221s.addItemDecoration(this);
        this.f3221s.addOnItemTouchListener(this);
        this.f3221s.addOnScrollListener(this.C);
    }

    public void r() {
        int i10 = this.A;
        if (i10 != 0) {
            if (i10 != 3) {
                return;
            } else {
                this.f3228z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f3228z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f3228z.setDuration(500L);
        this.f3228z.setStartDelay(0L);
        this.f3228z.start();
    }

    public void s(int i10, int i11) {
        int computeVerticalScrollRange = this.f3221s.computeVerticalScrollRange();
        int i12 = this.f3220r;
        this.f3222t = computeVerticalScrollRange - i12 > 0 && i12 >= this.f3203a;
        int computeHorizontalScrollRange = this.f3221s.computeHorizontalScrollRange();
        int i13 = this.f3219q;
        boolean z10 = computeHorizontalScrollRange - i13 > 0 && i13 >= this.f3203a;
        this.f3223u = z10;
        boolean z11 = this.f3222t;
        if (!z11 && !z10) {
            if (this.f3224v != 0) {
                p(0);
                return;
            }
            return;
        }
        if (z11) {
            float f10 = i12;
            this.f3214l = (int) ((f10 * (i11 + (f10 / 2.0f))) / computeVerticalScrollRange);
            this.f3213k = Math.min(i12, (i12 * i12) / computeVerticalScrollRange);
        }
        if (this.f3223u) {
            float f11 = i13;
            this.f3217o = (int) ((f11 * (i10 + (f11 / 2.0f))) / computeHorizontalScrollRange);
            this.f3216n = Math.min(i13, (i13 * i13) / computeHorizontalScrollRange);
        }
        int i14 = this.f3224v;
        if (i14 == 0 || i14 == 1) {
            p(1);
        }
    }

    public final void t(float f10) {
        int[] g10 = g();
        float max = Math.max(g10[0], Math.min(g10[1], f10));
        if (Math.abs(this.f3214l - max) < 2.0f) {
            return;
        }
        int o10 = o(this.f3215m, max, g10, this.f3221s.computeVerticalScrollRange(), this.f3221s.computeVerticalScrollOffset(), this.f3220r);
        if (o10 != 0) {
            this.f3221s.scrollBy(0, o10);
        }
        this.f3215m = max;
    }
}
