package h4;

import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* loaded from: classes.dex */
public abstract class e extends Drawable implements ValueAnimator.AnimatorUpdateListener, Animatable, Drawable.Callback {

    /* renamed from: d, reason: collision with root package name */
    public float f14174d;

    /* renamed from: e, reason: collision with root package name */
    public float f14175e;

    /* renamed from: f, reason: collision with root package name */
    public int f14176f;

    /* renamed from: g, reason: collision with root package name */
    public int f14177g;

    /* renamed from: h, reason: collision with root package name */
    public int f14178h;

    /* renamed from: i, reason: collision with root package name */
    public int f14179i;

    /* renamed from: j, reason: collision with root package name */
    public int f14180j;

    /* renamed from: k, reason: collision with root package name */
    public int f14181k;

    /* renamed from: l, reason: collision with root package name */
    public float f14182l;

    /* renamed from: m, reason: collision with root package name */
    public float f14183m;

    /* renamed from: n, reason: collision with root package name */
    public ValueAnimator f14184n;

    /* renamed from: s, reason: collision with root package name */
    public static final Rect f14163s = new Rect();

    /* renamed from: t, reason: collision with root package name */
    public static final Property f14164t = new c("rotateX");

    /* renamed from: u, reason: collision with root package name */
    public static final Property f14165u = new d("rotate");

    /* renamed from: v, reason: collision with root package name */
    public static final Property f14166v = new C0225e("rotateY");

    /* renamed from: w, reason: collision with root package name */
    public static final Property f14167w = new f("translateX");

    /* renamed from: x, reason: collision with root package name */
    public static final Property f14168x = new g("translateY");

    /* renamed from: y, reason: collision with root package name */
    public static final Property f14169y = new h("translateXPercentage");

    /* renamed from: z, reason: collision with root package name */
    public static final Property f14170z = new i("translateYPercentage");
    public static final Property A = new j("scaleX");
    public static final Property B = new k("scaleY");
    public static final Property C = new a("scale");
    public static final Property D = new b("alpha");

    /* renamed from: a, reason: collision with root package name */
    public float f14171a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f14172b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    public float f14173c = 1.0f;

    /* renamed from: o, reason: collision with root package name */
    public int f14185o = 255;

    /* renamed from: p, reason: collision with root package name */
    public Rect f14186p = f14163s;

    /* renamed from: q, reason: collision with root package name */
    public Camera f14187q = new Camera();

    /* renamed from: r, reason: collision with root package name */
    public Matrix f14188r = new Matrix();

    public static class a extends f4.b {
        public a(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(e eVar) {
            return Float.valueOf(eVar.j());
        }

        @Override // f4.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(e eVar, float f10) {
            eVar.B(f10);
        }
    }

    public static class b extends f4.c {
        public b(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.getAlpha());
        }

        @Override // f4.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(e eVar, int i10) {
            eVar.setAlpha(i10);
        }
    }

    public static class c extends f4.c {
        public c(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.h());
        }

        @Override // f4.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(e eVar, int i10) {
            eVar.z(i10);
        }
    }

    public static class d extends f4.c {
        public d(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.g());
        }

        @Override // f4.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(e eVar, int i10) {
            eVar.y(i10);
        }
    }

    /* renamed from: h4.e$e, reason: collision with other inner class name */
    public static class C0225e extends f4.c {
        public C0225e(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.i());
        }

        @Override // f4.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(e eVar, int i10) {
            eVar.A(i10);
        }
    }

    public static class f extends f4.c {
        public f(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.m());
        }

        @Override // f4.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(e eVar, int i10) {
            eVar.E(i10);
        }
    }

    public static class g extends f4.c {
        public g(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.o());
        }

        @Override // f4.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(e eVar, int i10) {
            eVar.G(i10);
        }
    }

    public static class h extends f4.b {
        public h(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(e eVar) {
            return Float.valueOf(eVar.n());
        }

        @Override // f4.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(e eVar, float f10) {
            eVar.F(f10);
        }
    }

    public static class i extends f4.b {
        public i(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(e eVar) {
            return Float.valueOf(eVar.p());
        }

        @Override // f4.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(e eVar, float f10) {
            eVar.H(f10);
        }
    }

    public static class j extends f4.b {
        public j(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(e eVar) {
            return Float.valueOf(eVar.k());
        }

        @Override // f4.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(e eVar, float f10) {
            eVar.C(f10);
        }
    }

    public static class k extends f4.b {
        public k(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(e eVar) {
            return Float.valueOf(eVar.l());
        }

        @Override // f4.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(e eVar, float f10) {
            eVar.D(f10);
        }
    }

    public void A(int i10) {
        this.f14178h = i10;
    }

    public void B(float f10) {
        this.f14171a = f10;
        C(f10);
        D(f10);
    }

    public void C(float f10) {
        this.f14172b = f10;
    }

    public void D(float f10) {
        this.f14173c = f10;
    }

    public void E(int i10) {
        this.f14179i = i10;
    }

    public void F(float f10) {
        this.f14182l = f10;
    }

    public void G(int i10) {
        this.f14180j = i10;
    }

    public void H(float f10) {
        this.f14183m = f10;
    }

    public Rect a(Rect rect) {
        int min = Math.min(rect.width(), rect.height());
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int i10 = min / 2;
        return new Rect(centerX - i10, centerY - i10, centerX + i10, centerY + i10);
    }

    public abstract void b(Canvas canvas);

    public abstract ValueAnimator c();

    public Rect d() {
        return this.f14186p;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int m10 = m();
        if (m10 == 0) {
            m10 = (int) (getBounds().width() * n());
        }
        int o10 = o();
        if (o10 == 0) {
            o10 = (int) (getBounds().height() * p());
        }
        canvas.translate(m10, o10);
        canvas.scale(k(), l(), e(), f());
        canvas.rotate(g(), e(), f());
        if (h() != 0 || i() != 0) {
            this.f14187q.save();
            this.f14187q.rotateX(h());
            this.f14187q.rotateY(i());
            this.f14187q.getMatrix(this.f14188r);
            this.f14188r.preTranslate(-e(), -f());
            this.f14188r.postTranslate(e(), f());
            this.f14187q.restore();
            canvas.concat(this.f14188r);
        }
        b(canvas);
    }

    public float e() {
        return this.f14174d;
    }

    public float f() {
        return this.f14175e;
    }

    public int g() {
        return this.f14181k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f14185o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 1;
    }

    public int h() {
        return this.f14177g;
    }

    public int i() {
        return this.f14178h;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return f4.a.a(this.f14184n);
    }

    public float j() {
        return this.f14171a;
    }

    public float k() {
        return this.f14172b;
    }

    public float l() {
        return this.f14173c;
    }

    public int m() {
        return this.f14179i;
    }

    public float n() {
        return this.f14182l;
    }

    public int o() {
        return this.f14180j;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        v(rect);
    }

    public float p() {
        return this.f14183m;
    }

    public ValueAnimator q() {
        if (this.f14184n == null) {
            ValueAnimator c10 = c();
            this.f14184n = c10;
            if (c10 != null) {
                c10.addUpdateListener(this);
            }
        }
        ValueAnimator valueAnimator = this.f14184n;
        if (valueAnimator != null) {
            valueAnimator.setStartDelay(this.f14176f);
        }
        return this.f14184n;
    }

    public void r() {
        this.f14171a = 1.0f;
        this.f14177g = 0;
        this.f14178h = 0;
        this.f14179i = 0;
        this.f14180j = 0;
        this.f14181k = 0;
        this.f14182l = 0.0f;
        this.f14183m = 0.0f;
    }

    public e s(int i10) {
        this.f14176f = i10;
        return this;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f14185o = i10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        ValueAnimator q10 = q();
        this.f14184n = q10;
        if (q10 == null || q10.isStarted()) {
            return;
        }
        f4.a.c(this.f14184n);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ValueAnimator valueAnimator = this.f14184n;
        if (valueAnimator != null) {
            valueAnimator.end();
            r();
            onAnimationUpdate(this.f14184n);
        }
    }

    public abstract void t(int i10);

    public void u(int i10, int i11, int i12, int i13) {
        this.f14186p = new Rect(i10, i11, i12, i13);
        w(d().centerX());
        x(d().centerY());
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    public void v(Rect rect) {
        u(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void w(float f10) {
        this.f14174d = f10;
    }

    public void x(float f10) {
        this.f14175e = f10;
    }

    public void y(int i10) {
        this.f14181k = i10;
    }

    public void z(int i10) {
        this.f14177g = i10;
    }
}
