package g4;

import android.os.Build;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public abstract class c {
    public static Interpolator a(float f10, float f11, float f12, float f13) {
        return Build.VERSION.SDK_INT >= 21 ? d.a(f10, f11, f12, f13) : e.a(f10, f11, f12, f13);
    }
}
