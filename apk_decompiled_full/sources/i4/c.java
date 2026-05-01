package i4;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* loaded from: classes.dex */
public class c extends h4.f {

    public class a extends h4.c {
        public a() {
        }

        @Override // h4.e
        public ValueAnimator c() {
            float[] fArr = {0.0f, 0.35f, 0.7f, 1.0f};
            return new f4.d(this).l(fArr, 1.0f, 0.0f, 1.0f, 1.0f).c(1300L).d(fArr).b();
        }
    }

    @Override // h4.f
    public h4.e[] N() {
        int[] iArr = {200, 300, 400, 100, 200, 300, 0, 100, 200};
        a[] aVarArr = new a[9];
        for (int i10 = 0; i10 < 9; i10++) {
            a aVar = new a();
            aVarArr[i10] = aVar;
            aVar.s(iArr[i10]);
        }
        return aVarArr;
    }

    @Override // h4.f, h4.e, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a10 = a(rect);
        int width = (int) (a10.width() * 0.33f);
        int height = (int) (a10.height() * 0.33f);
        for (int i10 = 0; i10 < K(); i10++) {
            int i11 = a10.left + ((i10 % 3) * width);
            int i12 = a10.top + ((i10 / 3) * height);
            J(i10).u(i11, i12, i11 + width, i12 + height);
        }
    }
}
