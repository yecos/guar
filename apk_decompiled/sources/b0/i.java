package b0;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final a f4369a;

    public interface a {
        void a(boolean z10);

        boolean onTouchEvent(MotionEvent motionEvent);
    }

    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final GestureDetector f4370a;

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f4370a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // b0.i.a
        public void a(boolean z10) {
            this.f4370a.setIsLongpressEnabled(z10);
        }

        @Override // b0.i.a
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.f4370a.onTouchEvent(motionEvent);
        }
    }

    public i(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f4369a.onTouchEvent(motionEvent);
    }

    public void b(boolean z10) {
        this.f4369a.a(z10);
    }

    public i(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f4369a = new b(context, onGestureListener, handler);
    }
}
