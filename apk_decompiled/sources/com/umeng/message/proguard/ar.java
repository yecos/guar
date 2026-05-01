package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* loaded from: classes3.dex */
public final class ar extends View {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f11548a;

    public ar(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f11548a = paint;
        paint.setAntiAlias(true);
        paint.setColor(-9733746);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(bo.a(1.3f));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        float min = Math.min(width, r1) * 0.618f;
        float f10 = width;
        float f11 = f10 - min;
        float height = getHeight() / 2;
        float f12 = height - min;
        float f13 = f10 + min;
        float f14 = height + min;
        canvas.drawLine(f11, f12, f13, f14, this.f11548a);
        canvas.drawLine(f13, f12, f11, f14, this.f11548a);
    }
}
