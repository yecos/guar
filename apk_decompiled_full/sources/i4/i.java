package i4;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* loaded from: classes.dex */
public class i extends h4.f {

    public class a extends h4.a {
        public a() {
        }

        @Override // h4.e
        public ValueAnimator c() {
            float[] fArr = {0.0f, 0.4f, 0.8f, 1.0f};
            return new f4.d(this).l(fArr, 0.0f, 1.0f, 0.0f, 0.0f).c(1400L).d(fArr).b();
        }
    }

    @Override // h4.f
    public void M(h4.e... eVarArr) {
        super.M(eVarArr);
        eVarArr[1].s(160);
        eVarArr[2].s(320);
    }

    @Override // h4.f
    public h4.e[] N() {
        return new h4.e[]{new a(), new a(), new a()};
    }

    @Override // h4.f, h4.e, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a10 = a(rect);
        int width = a10.width() / 8;
        int centerY = a10.centerY() - width;
        int centerY2 = a10.centerY() + width;
        for (int i10 = 0; i10 < K(); i10++) {
            int width2 = ((a10.width() * i10) / 3) + a10.left;
            J(i10).u(width2, centerY, (width * 2) + width2, centerY2);
        }
    }
}
