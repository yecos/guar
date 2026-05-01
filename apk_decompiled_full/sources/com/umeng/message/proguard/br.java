package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Button;
import com.mobile.brasiltv.view.RoundedDrawable;

/* loaded from: classes3.dex */
public final class br extends Button {

    /* renamed from: a, reason: collision with root package name */
    private Paint f11659a;

    /* renamed from: b, reason: collision with root package name */
    private float f11660b;

    /* renamed from: c, reason: collision with root package name */
    private float f11661c;

    /* renamed from: d, reason: collision with root package name */
    private float f11662d;

    /* renamed from: e, reason: collision with root package name */
    private float f11663e;

    /* renamed from: f, reason: collision with root package name */
    private float f11664f;

    /* renamed from: g, reason: collision with root package name */
    private int f11665g;

    public br(Context context) {
        super(context);
        setBackgroundColor(0);
        this.f11659a = new Paint();
        this.f11665g = bo.a(1.0f);
        this.f11664f = bo.a(2.0f);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f11660b = getWidth() / 2;
        this.f11661c = getHeight() / 2;
        float min = (Math.min(getHeight(), getWidth()) / 2) - this.f11665g;
        this.f11662d = min;
        this.f11663e = min / 1.4142f;
        this.f11659a.setAntiAlias(true);
        this.f11659a.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.f11659a.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.f11660b, this.f11661c, this.f11662d, this.f11659a);
        this.f11659a.setColor(-1);
        this.f11659a.setStrokeWidth(this.f11664f);
        this.f11659a.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(this.f11660b, this.f11661c, this.f11662d, this.f11659a);
        float f10 = this.f11660b;
        float f11 = this.f11663e;
        float f12 = this.f11661c;
        canvas.drawLine(f10 - f11, f12 - f11, f10 + f11, f12 + f11, this.f11659a);
        float f13 = this.f11660b;
        float f14 = this.f11663e;
        float f15 = this.f11661c;
        canvas.drawLine(f13 + f14, f15 - f14, f13 - f14, f15 + f14, this.f11659a);
    }
}
