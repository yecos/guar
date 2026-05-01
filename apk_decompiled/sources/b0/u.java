package b0;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public abstract class u {
    public static int a(MotionEvent motionEvent, int i10) {
        return motionEvent.findPointerIndex(i10);
    }

    public static int b(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    public static int c(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static int d(MotionEvent motionEvent, int i10) {
        return motionEvent.getPointerId(i10);
    }

    public static float e(MotionEvent motionEvent, int i10) {
        return motionEvent.getX(i10);
    }

    public static float f(MotionEvent motionEvent, int i10) {
        return motionEvent.getY(i10);
    }

    public static boolean g(MotionEvent motionEvent, int i10) {
        return (motionEvent.getSource() & i10) == i10;
    }
}
