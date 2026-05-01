package com.mobile.brasiltv.utils.zxing.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.ResultPoint;
import com.hpplay.cybergarage.upnp.UPnP;
import com.mobile.brasiltv.R$styleable;
import d7.c;
import java.util.Collection;
import java.util.HashSet;

/* loaded from: classes3.dex */
public final class ViewfinderView extends View {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f8796m = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: n, reason: collision with root package name */
    public static int f8797n = 0;

    /* renamed from: o, reason: collision with root package name */
    public static int f8798o = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f8799a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f8800b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8801c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8802d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8803e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8804f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8805g;

    /* renamed from: h, reason: collision with root package name */
    public final int f8806h;

    /* renamed from: i, reason: collision with root package name */
    public int f8807i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8808j;

    /* renamed from: k, reason: collision with root package name */
    public final float f8809k;

    /* renamed from: l, reason: collision with root package name */
    public Collection f8810l;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.F);
        this.f8804f = obtainStyledAttributes.getColor(5, 65280);
        this.f8805g = obtainStyledAttributes.getColor(0, 65280);
        this.f8803e = obtainStyledAttributes.getColor(1, UPnP.CONFIGID_UPNP_ORG_MAX);
        this.f8806h = obtainStyledAttributes.getColor(8, -1056964864);
        this.f8801c = obtainStyledAttributes.getColor(6, 0);
        this.f8802d = obtainStyledAttributes.getColor(7, -1342177280);
        this.f8808j = obtainStyledAttributes.getColor(3, -1862270977);
        this.f8809k = obtainStyledAttributes.getFloat(4, 36.0f);
        Paint paint = new Paint();
        this.f8799a = paint;
        paint.setAntiAlias(true);
        this.f8807i = 0;
        this.f8810l = new HashSet(5);
    }

    public void a(ResultPoint resultPoint) {
        this.f8810l.add(resultPoint);
    }

    public final void b(Canvas canvas, Rect rect) {
        this.f8799a.setColor(this.f8805g);
        canvas.drawRect(rect.left, rect.top, r0 + 8, r1 + 40, this.f8799a);
        canvas.drawRect(rect.left, rect.top, r0 + 40, r1 + 8, this.f8799a);
        int i10 = rect.right;
        canvas.drawRect(i10 - 8, rect.top, i10, r1 + 40, this.f8799a);
        int i11 = rect.right;
        canvas.drawRect(i11 - 40, rect.top, i11, r1 + 8, this.f8799a);
        canvas.drawRect(rect.left, r1 - 8, r0 + 40, rect.bottom, this.f8799a);
        canvas.drawRect(rect.left, r1 - 40, r0 + 8, rect.bottom, this.f8799a);
        canvas.drawRect(r0 - 8, r1 - 40, rect.right, rect.bottom, this.f8799a);
        canvas.drawRect(r0 - 40, r10 - 8, rect.right, rect.bottom, this.f8799a);
    }

    public final void c(Canvas canvas, Rect rect, int i10, int i11) {
        this.f8799a.setColor(this.f8800b != null ? this.f8802d : this.f8801c);
        float f10 = i10;
        canvas.drawRect(0.0f, 0.0f, f10, rect.top, this.f8799a);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f8799a);
        canvas.drawRect(rect.right + 1, rect.top, f10, rect.bottom + 1, this.f8799a);
        canvas.drawRect(0.0f, rect.bottom + 1, f10, i11, this.f8799a);
    }

    public final void d(Canvas canvas, Rect rect) {
        this.f8799a.setColor(this.f8803e);
        canvas.drawRect(rect.left, rect.top, rect.right + 1, r0 + 2, this.f8799a);
        canvas.drawRect(rect.left, rect.top + 2, r0 + 2, rect.bottom - 1, this.f8799a);
        int i10 = rect.right;
        canvas.drawRect(i10 - 1, rect.top, i10 + 1, rect.bottom - 1, this.f8799a);
        float f10 = rect.left;
        int i11 = rect.bottom;
        canvas.drawRect(f10, i11 - 1, rect.right + 1, i11 + 1, this.f8799a);
    }

    public final void e(Canvas canvas, Rect rect) {
        this.f8799a.setColor(this.f8804f);
        int i10 = rect.left;
        LinearGradient linearGradient = new LinearGradient(i10, f8797n, i10, r4 + 10, h(this.f8804f), this.f8804f, Shader.TileMode.MIRROR);
        float width = rect.left + (rect.width() / 2);
        float f10 = f8797n + 5;
        int i11 = this.f8804f;
        RadialGradient radialGradient = new RadialGradient(width, f10, 360.0f, i11, h(i11), Shader.TileMode.MIRROR);
        new SweepGradient(rect.left + (rect.width() / 2), f8797n + 10, h(this.f8804f), this.f8804f);
        new ComposeShader(radialGradient, linearGradient, PorterDuff.Mode.ADD);
        this.f8799a.setShader(radialGradient);
        if (f8797n <= f8798o) {
            canvas.drawOval(new RectF(rect.left + 20, f8797n, rect.right - 20, r4 + 10), this.f8799a);
            f8797n += 5;
        } else {
            f8797n = rect.top;
        }
        this.f8799a.setShader(null);
    }

    public final void f(Canvas canvas, Rect rect) {
        this.f8799a.setColor(this.f8808j);
        this.f8799a.setTextSize(this.f8809k);
        this.f8799a.setTextAlign(Paint.Align.CENTER);
    }

    public void g() {
        this.f8800b = null;
        invalidate();
    }

    public int h(int i10) {
        return Integer.valueOf("20" + Integer.toHexString(i10).substring(2), 16).intValue();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect d10 = c.c().d();
        if (d10 == null) {
            return;
        }
        if (f8797n == 0 || f8798o == 0) {
            f8797n = d10.top;
            f8798o = d10.bottom;
        }
        c(canvas, d10, canvas.getWidth(), canvas.getHeight());
        if (this.f8800b != null) {
            this.f8799a.setAlpha(255);
            canvas.drawBitmap(this.f8800b, d10.left, d10.top, this.f8799a);
            return;
        }
        d(canvas, d10);
        b(canvas, d10);
        f(canvas, d10);
        e(canvas, d10);
        postInvalidateDelayed(10L, d10.left, d10.top, d10.right, d10.bottom);
    }
}
