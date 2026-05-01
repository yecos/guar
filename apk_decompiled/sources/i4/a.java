package i4;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;
import com.taobao.accs.flowcontrol.FlowControl;

/* loaded from: classes.dex */
public class a extends h4.f {

    /* renamed from: i4.a$a, reason: collision with other inner class name */
    public class C0229a extends h4.a {
        public C0229a() {
        }

        @Override // h4.e
        public ValueAnimator c() {
            float[] fArr = {0.0f, 0.5f, 1.0f};
            return new f4.d(this).l(fArr, 0.0f, 1.0f, 0.0f).c(2000L).d(fArr).b();
        }
    }

    @Override // h4.f
    public void M(h4.e... eVarArr) {
        super.M(eVarArr);
        eVarArr[1].s(FlowControl.DELAY_MAX_BRUSH);
    }

    @Override // h4.f
    public h4.e[] N() {
        return new h4.e[]{new C0229a(), new C0229a()};
    }

    @Override // h4.f, h4.e
    public ValueAnimator c() {
        return new f4.d(this).i(new float[]{0.0f, 1.0f}, 0, 360).c(2000L).h(new LinearInterpolator()).b();
    }

    @Override // h4.f, h4.e, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a10 = a(rect);
        int width = (int) (a10.width() * 0.6f);
        h4.e J = J(0);
        int i10 = a10.left;
        int i11 = a10.top;
        J.u(i10, i11, a10.right, i11 + width);
        h4.e J2 = J(1);
        int i12 = a10.left;
        int i13 = a10.bottom;
        J2.u(i12, i13 - width, a10.right, i13);
    }
}
