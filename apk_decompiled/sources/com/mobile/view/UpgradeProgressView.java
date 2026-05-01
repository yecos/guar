package com.mobile.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public class UpgradeProgressView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f8996a;

    /* renamed from: b, reason: collision with root package name */
    public float f8997b;

    /* renamed from: c, reason: collision with root package name */
    public float f8998c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f8999d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f9000e;

    /* renamed from: f, reason: collision with root package name */
    public Paint f9001f;

    /* renamed from: g, reason: collision with root package name */
    public final RectF f9002g;

    public UpgradeProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8996a = 0;
        this.f8998c = 0.0f;
        this.f9002g = new RectF();
        a();
    }

    public final void a() {
        Paint paint = new Paint(5);
        this.f8999d = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.f8999d.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f8999d.setColor(Color.parseColor("#45454d"));
        this.f9000e = new Paint(5);
        Paint paint2 = new Paint(5);
        this.f9001f = paint2;
        paint2.setColor(-1);
        this.f9001f.setTextSize(AutoUtils.getPercentWidthSize(24));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f10 = this.f8997b;
        float measuredWidth = getMeasuredWidth();
        float f11 = this.f8997b;
        canvas.drawLine(f10, f10, measuredWidth - f11, f11, this.f8999d);
        float measuredWidth2 = ((this.f8996a * 1.0f) * getMeasuredWidth()) / 100.0f;
        RectF rectF = this.f9002g;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = measuredWidth2;
        rectF.bottom = getMeasuredHeight();
        RectF rectF2 = this.f9002g;
        float f12 = this.f8997b;
        canvas.drawRoundRect(rectF2, f12, f12, this.f9000e);
        String str = this.f8996a + Operator.Operation.MOD;
        canvas.drawText(str, this.f8996a <= 10 ? measuredWidth2 + this.f8997b : (measuredWidth2 - this.f9001f.measureText(str)) - this.f8997b, this.f8998c, this.f9001f);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f8997b = (getMeasuredHeight() * 1.0f) / 2.0f;
        this.f8999d.setStrokeWidth(getMeasuredHeight());
        this.f9000e.setShader(new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{Color.parseColor("#56e3ff"), Color.parseColor("#33a7fe")}, (float[]) null, Shader.TileMode.CLAMP));
        this.f9000e.setStrokeWidth(getMeasuredHeight());
        Paint.FontMetrics fontMetrics = this.f9001f.getFontMetrics();
        float f10 = this.f8997b;
        float f11 = fontMetrics.bottom;
        this.f8998c = (f10 + ((f11 - fontMetrics.top) / 2.0f)) - f11;
    }

    public void setInvalid(boolean z10) {
        this.f9000e.setShader(z10 ? new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{Color.parseColor("#5c5c66"), Color.parseColor("#5c5c66")}, (float[]) null, Shader.TileMode.CLAMP) : new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{Color.parseColor("#56e3ff"), Color.parseColor("#33a7fe")}, (float[]) null, Shader.TileMode.CLAMP));
        invalidate();
    }

    public void setProgress(int i10) {
        if (i10 < 0 || i10 > 100) {
            return;
        }
        this.f8996a = i10;
        invalidate();
    }
}
