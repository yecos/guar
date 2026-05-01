package g4;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public class b implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public TimeInterpolator f13630a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f13631b;

    public b(TimeInterpolator timeInterpolator) {
        this.f13630a = timeInterpolator;
    }

    public static b a(float... fArr) {
        b bVar = new b(a.a());
        bVar.b(fArr);
        return bVar;
    }

    public void b(float... fArr) {
        this.f13631b = fArr;
    }

    @Override // android.animation.TimeInterpolator
    public synchronized float getInterpolation(float f10) {
        if (this.f13631b.length > 1) {
            int i10 = 0;
            while (true) {
                float[] fArr = this.f13631b;
                if (i10 >= fArr.length - 1) {
                    break;
                }
                float f11 = fArr[i10];
                i10++;
                float f12 = fArr[i10];
                float f13 = f12 - f11;
                if (f10 >= f11 && f10 <= f12) {
                    return f11 + (this.f13630a.getInterpolation((f10 - f11) / f13) * f13);
                }
            }
        }
        return this.f13630a.getInterpolation(f10);
    }
}
