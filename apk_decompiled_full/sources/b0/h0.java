package b0;

import android.view.VelocityTracker;

/* loaded from: classes.dex */
public abstract class h0 {
    public static float a(VelocityTracker velocityTracker, int i10) {
        return velocityTracker.getXVelocity(i10);
    }

    public static float b(VelocityTracker velocityTracker, int i10) {
        return velocityTracker.getYVelocity(i10);
    }
}
