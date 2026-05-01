package k2;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bigkoo.pickerview.lib.WheelView;

/* loaded from: classes.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final WheelView f14803a;

    public b(WheelView wheelView) {
        this.f14803a = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        this.f14803a.g(f11);
        return true;
    }
}
