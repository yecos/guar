package i4;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class f extends h4.f {
    public boolean G = false;

    public class a extends h4.c {
        public a() {
        }

        @Override // h4.e
        public ValueAnimator c() {
            float[] fArr = {0.0f, 0.1f, 0.25f, 0.75f, 0.9f, 1.0f};
            return new f4.d(this).a(fArr, 0, 0, 255, 255, 0, 0).j(fArr, -180, -180, 0, 0, 0, 0).k(fArr, 0, 0, 0, 0, 180, 180).c(2400L).h(new LinearInterpolator()).b();
        }
    }

    @Override // h4.f
    public void I(Canvas canvas) {
        Rect a10 = a(getBounds());
        for (int i10 = 0; i10 < K(); i10++) {
            int save = canvas.save();
            canvas.rotate((i10 * 90) + 45, a10.centerX(), a10.centerY());
            J(i10).draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // h4.f
    public h4.e[] N() {
        a[] aVarArr = new a[4];
        for (int i10 = 0; i10 < 4; i10++) {
            a aVar = new a();
            aVarArr[i10] = aVar;
            aVar.s((i10 * 300) - 1200);
        }
        return aVarArr;
    }

    @Override // h4.f, h4.e, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a10 = a(rect);
        int min = Math.min(a10.width(), a10.height());
        if (this.G) {
            min = (int) Math.sqrt((min * min) / 2);
            int width = (a10.width() - min) / 2;
            int height = (a10.height() - min) / 2;
            a10 = new Rect(a10.left + width, a10.top + height, a10.right - width, a10.bottom - height);
        }
        int i10 = min / 2;
        int i11 = a10.left + i10 + 1;
        int i12 = a10.top + i10 + 1;
        for (int i13 = 0; i13 < K(); i13++) {
            h4.e J = J(i13);
            J.u(a10.left, a10.top, i11, i12);
            J.w(J.d().right);
            J.x(J.d().bottom);
        }
    }
}
