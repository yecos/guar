package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public EdgeEffect f2077a;

    public i(Context context) {
        this.f2077a = new EdgeEffect(context);
    }

    public static void d(EdgeEffect edgeEffect, float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f10, f11);
        } else {
            edgeEffect.onPull(f10);
        }
    }

    public boolean a(Canvas canvas) {
        return this.f2077a.draw(canvas);
    }

    public void b() {
        this.f2077a.finish();
    }

    public boolean c() {
        return this.f2077a.isFinished();
    }

    public boolean e(float f10) {
        this.f2077a.onPull(f10);
        return true;
    }

    public boolean f() {
        this.f2077a.onRelease();
        return this.f2077a.isFinished();
    }

    public void g(int i10, int i11) {
        this.f2077a.setSize(i10, i11);
    }
}
