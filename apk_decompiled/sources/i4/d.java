package i4;

import android.animation.ValueAnimator;
import com.taobao.accs.flowcontrol.FlowControl;

/* loaded from: classes.dex */
public class d extends h4.f {

    public class a extends h4.a {
        public a() {
            setAlpha(153);
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
        return new h4.e[]{new a(), new a()};
    }
}
