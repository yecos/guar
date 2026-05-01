package i4;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* loaded from: classes.dex */
public class j extends h4.f {

    public class a extends h4.c {
        public a() {
        }

        @Override // h4.e
        public ValueAnimator c() {
            float[] fArr = {0.0f, 0.25f, 0.5f, 0.51f, 0.75f, 1.0f};
            return new f4.d(this).i(fArr, 0, -90, -179, -180, -270, -360).m(fArr, 0.0f, 0.75f, 0.75f, 0.75f, 0.0f, 0.0f).n(fArr, 0.0f, 0.0f, 0.75f, 0.75f, 0.75f, 0.0f).l(fArr, 1.0f, 0.5f, 1.0f, 1.0f, 0.5f, 1.0f).c(1800L).d(fArr).b();
        }
    }

    @Override // h4.f
    public void M(h4.e... eVarArr) {
        super.M(eVarArr);
        eVarArr[1].s(-900);
    }

    @Override // h4.f
    public h4.e[] N() {
        return new h4.e[]{new a(), new a()};
    }

    @Override // h4.f, h4.e, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Rect a10 = a(rect);
        super.onBoundsChange(a10);
        for (int i10 = 0; i10 < K(); i10++) {
            h4.e J = J(i10);
            int i11 = a10.left;
            J.u(i11, a10.top, (a10.width() / 4) + i11, a10.top + (a10.height() / 4));
        }
    }
}
