package com.bigkoo.pickerview.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bigkoo.pickerview.R$dimen;
import com.bigkoo.pickerview.R$styleable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import k2.c;

/* loaded from: classes.dex */
public class WheelView extends View {
    public int A;
    public int B;
    public float C;
    public long D;
    public int E;
    public int F;
    public int G;
    public int H;
    public float I;

    /* renamed from: a, reason: collision with root package name */
    public b f6001a;

    /* renamed from: b, reason: collision with root package name */
    public Context f6002b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f6003c;

    /* renamed from: d, reason: collision with root package name */
    public GestureDetector f6004d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6005e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6006f;

    /* renamed from: g, reason: collision with root package name */
    public ScheduledExecutorService f6007g;

    /* renamed from: h, reason: collision with root package name */
    public ScheduledFuture f6008h;

    /* renamed from: i, reason: collision with root package name */
    public Paint f6009i;

    /* renamed from: j, reason: collision with root package name */
    public Paint f6010j;

    /* renamed from: k, reason: collision with root package name */
    public Paint f6011k;

    /* renamed from: l, reason: collision with root package name */
    public String f6012l;

    /* renamed from: m, reason: collision with root package name */
    public int f6013m;

    /* renamed from: n, reason: collision with root package name */
    public float f6014n;

    /* renamed from: o, reason: collision with root package name */
    public Typeface f6015o;

    /* renamed from: p, reason: collision with root package name */
    public int f6016p;

    /* renamed from: q, reason: collision with root package name */
    public int f6017q;

    /* renamed from: r, reason: collision with root package name */
    public int f6018r;

    /* renamed from: s, reason: collision with root package name */
    public float f6019s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6020t;

    /* renamed from: u, reason: collision with root package name */
    public float f6021u;

    /* renamed from: v, reason: collision with root package name */
    public int f6022v;

    /* renamed from: w, reason: collision with root package name */
    public int f6023w;

    /* renamed from: x, reason: collision with root package name */
    public int f6024x;

    /* renamed from: y, reason: collision with root package name */
    public int f6025y;

    /* renamed from: z, reason: collision with root package name */
    public int f6026z;

    public enum a {
        CLICK,
        FLING,
        DAGGLE
    }

    public enum b {
        FILL,
        WRAP
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6005e = false;
        this.f6006f = true;
        this.f6007g = Executors.newSingleThreadScheduledExecutor();
        this.f6015o = Typeface.MONOSPACE;
        this.f6016p = -5723992;
        this.f6017q = -14013910;
        this.f6018r = -2763307;
        this.f6019s = 1.6f;
        this.f6024x = 11;
        this.B = 0;
        this.C = 0.0f;
        this.D = 0L;
        this.F = 17;
        this.G = 0;
        this.H = 0;
        this.f6013m = getResources().getDimensionPixelSize(R$dimen.pickerview_textsize);
        float f10 = getResources().getDisplayMetrics().density;
        if (f10 < 1.0f) {
            this.I = 2.4f;
        } else if (1.0f <= f10 && f10 < 2.0f) {
            this.I = 3.6f;
        } else if (1.0f <= f10 && f10 < 2.0f) {
            this.I = 4.5f;
        } else if (2.0f <= f10 && f10 < 3.0f) {
            this.I = 6.0f;
        } else if (f10 >= 3.0f) {
            this.I = f10 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f6000a, 0, 0);
            this.F = obtainStyledAttributes.getInt(R$styleable.pickerview_pickerview_gravity, 17);
            this.f6016p = obtainStyledAttributes.getColor(R$styleable.pickerview_pickerview_textColorOut, this.f6016p);
            this.f6017q = obtainStyledAttributes.getColor(R$styleable.pickerview_pickerview_textColorCenter, this.f6017q);
            this.f6018r = obtainStyledAttributes.getColor(R$styleable.pickerview_pickerview_dividerColor, this.f6018r);
            this.f6013m = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.pickerview_pickerview_textSize, this.f6013m);
            this.f6019s = obtainStyledAttributes.getFloat(R$styleable.pickerview_pickerview_lineSpacingMultiplier, this.f6019s);
            obtainStyledAttributes.recycle();
        }
        d();
        b(context);
    }

    public void a() {
        ScheduledFuture scheduledFuture = this.f6008h;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f6008h.cancel(true);
        this.f6008h = null;
    }

    public final void b(Context context) {
        this.f6002b = context;
        this.f6003c = new com.bigkoo.pickerview.lib.a(this);
        GestureDetector gestureDetector = new GestureDetector(context, new k2.b(this));
        this.f6004d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f6020t = true;
        this.f6021u = 0.0f;
        this.f6022v = -1;
        c();
    }

    public final void c() {
        Paint paint = new Paint();
        this.f6009i = paint;
        paint.setColor(this.f6016p);
        this.f6009i.setAntiAlias(true);
        this.f6009i.setTypeface(this.f6015o);
        this.f6009i.setTextSize(this.f6013m);
        Paint paint2 = new Paint();
        this.f6010j = paint2;
        paint2.setColor(this.f6017q);
        this.f6010j.setAntiAlias(true);
        this.f6010j.setTextScaleX(1.1f);
        this.f6010j.setTypeface(this.f6015o);
        this.f6010j.setTextSize(this.f6013m);
        Paint paint3 = new Paint();
        this.f6011k = paint3;
        paint3.setColor(this.f6018r);
        this.f6011k.setAntiAlias(true);
        setLayerType(1, null);
    }

    public final void d() {
        float f10 = this.f6019s;
        if (f10 < 1.2f) {
            this.f6019s = 1.2f;
        } else if (f10 > 2.0f) {
            this.f6019s = 2.0f;
        }
    }

    public final void e() {
    }

    public final void f() {
    }

    public final void g(float f10) {
        a();
        this.f6008h = this.f6007g.scheduleWithFixedDelay(new k2.a(this, f10), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final j2.a getAdapter() {
        return null;
    }

    public final int getCurrentItem() {
        return this.f6023w;
    }

    public int getItemsCount() {
        return 0;
    }

    public void h(a aVar) {
        a();
        if (aVar == a.FLING || aVar == a.DAGGLE) {
            float f10 = this.f6021u;
            float f11 = this.f6014n;
            int i10 = (int) (((f10 % f11) + f11) % f11);
            this.B = i10;
            if (i10 > f11 / 2.0f) {
                this.B = (int) (f11 - i10);
            } else {
                this.B = -i10;
            }
        }
        this.f6008h = this.f6007g.scheduleWithFixedDelay(new c(this, this.B), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        this.E = i10;
        f();
        setMeasuredDimension(this.f6026z, this.f6025y);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f6004d.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.D = System.currentTimeMillis();
            a();
            this.C = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.C - motionEvent.getRawY();
            this.C = motionEvent.getRawY();
            this.f6021u += rawY;
            if (!this.f6020t) {
                throw null;
            }
        } else if (!onTouchEvent) {
            float y10 = motionEvent.getY();
            int i10 = this.A;
            double acos = Math.acos((i10 - y10) / i10);
            double d10 = this.A;
            Double.isNaN(d10);
            double d11 = acos * d10;
            float f10 = this.f6014n;
            double d12 = f10 / 2.0f;
            Double.isNaN(d12);
            double d13 = d11 + d12;
            Double.isNaN(f10);
            this.B = (int) (((((int) (d13 / r3)) - (this.f6024x / 2)) * f10) - (((this.f6021u % f10) + f10) % f10));
            if (System.currentTimeMillis() - this.D > 120) {
                h(a.DAGGLE);
            } else {
                h(a.CLICK);
            }
        }
        invalidate();
        return true;
    }

    public final void setAdapter(j2.a aVar) {
        f();
        invalidate();
    }

    public final void setCurrentItem(int i10) {
        this.f6023w = i10;
        this.f6022v = i10;
        this.f6021u = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z10) {
        this.f6020t = z10;
    }

    public void setDividerColor(int i10) {
        if (i10 != 0) {
            this.f6018r = i10;
            this.f6011k.setColor(i10);
        }
    }

    public void setDividerType(b bVar) {
        this.f6001a = bVar;
    }

    public void setGravity(int i10) {
        this.F = i10;
    }

    public void setIsOptions(boolean z10) {
        this.f6005e = z10;
    }

    public void setLabel(String str) {
        this.f6012l = str;
    }

    public void setLineSpacingMultiplier(float f10) {
        if (f10 != 0.0f) {
            this.f6019s = f10;
            d();
        }
    }

    public final void setOnItemSelectedListener(l2.a aVar) {
    }

    public void setTextColorCenter(int i10) {
        if (i10 != 0) {
            this.f6017q = i10;
            this.f6010j.setColor(i10);
        }
    }

    public void setTextColorOut(int i10) {
        if (i10 != 0) {
            this.f6016p = i10;
            this.f6009i.setColor(i10);
        }
    }

    public final void setTextSize(float f10) {
        if (f10 > 0.0f) {
            int i10 = (int) (this.f6002b.getResources().getDisplayMetrics().density * f10);
            this.f6013m = i10;
            this.f6009i.setTextSize(i10);
            this.f6010j.setTextSize(this.f6013m);
        }
    }

    public final void setTypeface(Typeface typeface) {
        this.f6015o = typeface;
        this.f6009i.setTypeface(typeface);
        this.f6010j.setTypeface(this.f6015o);
    }
}
