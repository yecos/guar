package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class t1 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final float f1644a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1645b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1646c;

    /* renamed from: d, reason: collision with root package name */
    public final View f1647d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f1648e;

    /* renamed from: f, reason: collision with root package name */
    public Runnable f1649f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1650g;

    /* renamed from: h, reason: collision with root package name */
    public int f1651h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f1652i = new int[2];

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = t1.this.f1647d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t1.this.e();
        }
    }

    public t1(View view) {
        this.f1647d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1644a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1645b = tapTimeout;
        this.f1646c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View view, float f10, float f11, float f12) {
        float f13 = -f12;
        return f10 >= f13 && f11 >= f13 && f10 < ((float) (view.getRight() - view.getLeft())) + f12 && f11 < ((float) (view.getBottom() - view.getTop())) + f12;
    }

    public final void a() {
        Runnable runnable = this.f1649f;
        if (runnable != null) {
            this.f1647d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1648e;
        if (runnable2 != null) {
            this.f1647d.removeCallbacks(runnable2);
        }
    }

    public abstract androidx.appcompat.view.menu.p b();

    public abstract boolean c();

    public boolean d() {
        androidx.appcompat.view.menu.p b10 = b();
        if (b10 == null || !b10.isShowing()) {
            return true;
        }
        b10.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f1647d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1650g = true;
        }
    }

    public final boolean f(MotionEvent motionEvent) {
        r1 r1Var;
        View view = this.f1647d;
        androidx.appcompat.view.menu.p b10 = b();
        if (b10 == null || !b10.isShowing() || (r1Var = (r1) b10.m()) == null || !r1Var.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(r1Var, obtainNoHistory);
        boolean e10 = r1Var.e(obtainNoHistory, this.f1651h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return e10 && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
    
        if (r1 != 3) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1647d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f1651h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1644a
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f1651h = r6
            java.lang.Runnable r6 = r5.f1648e
            if (r6 != 0) goto L52
            androidx.appcompat.widget.t1$a r6 = new androidx.appcompat.widget.t1$a
            r6.<init>()
            r5.f1648e = r6
        L52:
            java.lang.Runnable r6 = r5.f1648e
            int r1 = r5.f1645b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1649f
            if (r6 != 0) goto L65
            androidx.appcompat.widget.t1$b r6 = new androidx.appcompat.widget.t1$b
            r6.<init>()
            r5.f1649f = r6
        L65:
            java.lang.Runnable r6 = r5.f1649f
            int r1 = r5.f1646c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.t1.g(android.view.MotionEvent):boolean");
    }

    public final boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1652i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    public final boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1652i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = this.f1650g;
        if (z11) {
            z10 = f(motionEvent) || !d();
        } else {
            z10 = g(motionEvent) && c();
            if (z10) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1647d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f1650g = z10;
        return z10 || z11;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1650g = false;
        this.f1651h = -1;
        Runnable runnable = this.f1648e;
        if (runnable != null) {
            this.f1647d.removeCallbacks(runnable);
        }
    }
}
