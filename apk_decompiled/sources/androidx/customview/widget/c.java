package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import b0.c1;
import java.util.Arrays;

/* loaded from: classes.dex */
public class c {

    /* renamed from: w, reason: collision with root package name */
    public static final Interpolator f2093w = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f2094a;

    /* renamed from: b, reason: collision with root package name */
    public int f2095b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f2097d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f2098e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f2099f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f2100g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f2101h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f2102i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f2103j;

    /* renamed from: k, reason: collision with root package name */
    public int f2104k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f2105l;

    /* renamed from: m, reason: collision with root package name */
    public float f2106m;

    /* renamed from: n, reason: collision with root package name */
    public float f2107n;

    /* renamed from: o, reason: collision with root package name */
    public int f2108o;

    /* renamed from: p, reason: collision with root package name */
    public int f2109p;

    /* renamed from: q, reason: collision with root package name */
    public OverScroller f2110q;

    /* renamed from: r, reason: collision with root package name */
    public final AbstractC0030c f2111r;

    /* renamed from: s, reason: collision with root package name */
    public View f2112s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2113t;

    /* renamed from: u, reason: collision with root package name */
    public final ViewGroup f2114u;

    /* renamed from: c, reason: collision with root package name */
    public int f2096c = -1;

    /* renamed from: v, reason: collision with root package name */
    public final Runnable f2115v = new b();

    public static class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.F(0);
        }
    }

    /* renamed from: androidx.customview.widget.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0030c {
        public abstract int clampViewPositionHorizontal(View view, int i10, int i11);

        public abstract int clampViewPositionVertical(View view, int i10, int i11);

        public int getOrderedChildIndex(int i10) {
            return i10;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i10, int i11) {
        }

        public boolean onEdgeLock(int i10) {
            return false;
        }

        public void onEdgeTouched(int i10, int i11) {
        }

        public void onViewCaptured(View view, int i10) {
        }

        public abstract void onViewDragStateChanged(int i10);

        public abstract void onViewPositionChanged(View view, int i10, int i11, int i12, int i13);

        public abstract void onViewReleased(View view, float f10, float f11);

        public abstract boolean tryCaptureView(View view, int i10);
    }

    public c(Context context, ViewGroup viewGroup, AbstractC0030c abstractC0030c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0030c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f2114u = viewGroup;
        this.f2111r = abstractC0030c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2108o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f2095b = viewConfiguration.getScaledTouchSlop();
        this.f2106m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f2107n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2110q = new OverScroller(context, f2093w);
    }

    public static c l(ViewGroup viewGroup, float f10, AbstractC0030c abstractC0030c) {
        c m10 = m(viewGroup, abstractC0030c);
        m10.f2095b = (int) (m10.f2095b * (1.0f / f10));
        return m10;
    }

    public static c m(ViewGroup viewGroup, AbstractC0030c abstractC0030c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0030c);
    }

    public void A(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f2105l == null) {
            this.f2105l = VelocityTracker.obtain();
        }
        this.f2105l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View r10 = r((int) x10, (int) y10);
            D(x10, y10, pointerId);
            J(r10, pointerId);
            int i12 = this.f2101h[pointerId];
            int i13 = this.f2109p;
            if ((i12 & i13) != 0) {
                this.f2111r.onEdgeTouched(i12 & i13, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f2094a == 1) {
                B();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f2094a == 1) {
                if (y(this.f2096c)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f2096c);
                    float x11 = motionEvent.getX(findPointerIndex);
                    float y11 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f2099f;
                    int i14 = this.f2096c;
                    int i15 = (int) (x11 - fArr[i14]);
                    int i16 = (int) (y11 - this.f2100g[i14]);
                    p(this.f2112s.getLeft() + i15, this.f2112s.getTop() + i16, i15, i16);
                    E(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i11 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i11);
                if (y(pointerId2)) {
                    float x12 = motionEvent.getX(i11);
                    float y12 = motionEvent.getY(i11);
                    float f10 = x12 - this.f2097d[pointerId2];
                    float f11 = y12 - this.f2098e[pointerId2];
                    C(f10, f11, pointerId2);
                    if (this.f2094a != 1) {
                        View r11 = r((int) x12, (int) y12);
                        if (d(r11, f10, f11) && J(r11, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i11++;
            }
            E(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f2094a == 1) {
                n(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x13 = motionEvent.getX(actionIndex);
            float y13 = motionEvent.getY(actionIndex);
            D(x13, y13, pointerId3);
            if (this.f2094a != 0) {
                if (w((int) x13, (int) y13)) {
                    J(this.f2112s, pointerId3);
                    return;
                }
                return;
            } else {
                J(r((int) x13, (int) y13), pointerId3);
                int i17 = this.f2101h[pointerId3];
                int i18 = this.f2109p;
                if ((i17 & i18) != 0) {
                    this.f2111r.onEdgeTouched(i17 & i18, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f2094a == 1 && pointerId4 == this.f2096c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i11 >= pointerCount2) {
                    i10 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i11);
                if (pointerId5 != this.f2096c) {
                    View r12 = r((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                    View view = this.f2112s;
                    if (r12 == view && J(view, pointerId5)) {
                        i10 = this.f2096c;
                        break;
                    }
                }
                i11++;
            }
            if (i10 == -1) {
                B();
            }
        }
        h(pointerId4);
    }

    public final void B() {
        this.f2105l.computeCurrentVelocity(1000, this.f2106m);
        n(e(this.f2105l.getXVelocity(this.f2096c), this.f2107n, this.f2106m), e(this.f2105l.getYVelocity(this.f2096c), this.f2107n, this.f2106m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.c$c] */
    public final void C(float f10, float f11, int i10) {
        boolean c10 = c(f10, f11, i10, 1);
        boolean z10 = c10;
        if (c(f11, f10, i10, 4)) {
            z10 = (c10 ? 1 : 0) | 4;
        }
        boolean z11 = z10;
        if (c(f10, f11, i10, 2)) {
            z11 = (z10 ? 1 : 0) | 2;
        }
        ?? r02 = z11;
        if (c(f11, f10, i10, 8)) {
            r02 = (z11 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f2102i;
            iArr[i10] = iArr[i10] | r02;
            this.f2111r.onEdgeDragStarted(r02, i10);
        }
    }

    public final void D(float f10, float f11, int i10) {
        q(i10);
        float[] fArr = this.f2097d;
        this.f2099f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f2098e;
        this.f2100g[i10] = f11;
        fArr2[i10] = f11;
        this.f2101h[i10] = t((int) f10, (int) f11);
        this.f2104k |= 1 << i10;
    }

    public final void E(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (y(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f2099f[pointerId] = x10;
                this.f2100g[pointerId] = y10;
            }
        }
    }

    public void F(int i10) {
        this.f2114u.removeCallbacks(this.f2115v);
        if (this.f2094a != i10) {
            this.f2094a = i10;
            this.f2111r.onViewDragStateChanged(i10);
            if (this.f2094a == 0) {
                this.f2112s = null;
            }
        }
    }

    public boolean G(int i10, int i11) {
        if (this.f2113t) {
            return s(i10, i11, (int) this.f2105l.getXVelocity(this.f2096c), (int) this.f2105l.getYVelocity(this.f2096c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00dd, code lost:
    
        if (r12 != r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean H(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.c.H(android.view.MotionEvent):boolean");
    }

    public boolean I(View view, int i10, int i11) {
        this.f2112s = view;
        this.f2096c = -1;
        boolean s10 = s(i10, i11, 0, 0);
        if (!s10 && this.f2094a == 0 && this.f2112s != null) {
            this.f2112s = null;
        }
        return s10;
    }

    public boolean J(View view, int i10) {
        if (view == this.f2112s && this.f2096c == i10) {
            return true;
        }
        if (view == null || !this.f2111r.tryCaptureView(view, i10)) {
            return false;
        }
        this.f2096c = i10;
        b(view, i10);
        return true;
    }

    public void a() {
        this.f2096c = -1;
        g();
        VelocityTracker velocityTracker = this.f2105l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2105l = null;
        }
    }

    public void b(View view, int i10) {
        if (view.getParent() == this.f2114u) {
            this.f2112s = view;
            this.f2096c = i10;
            this.f2111r.onViewCaptured(view, i10);
            F(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f2114u + ")");
    }

    public final boolean c(float f10, float f11, int i10, int i11) {
        float abs = Math.abs(f10);
        float abs2 = Math.abs(f11);
        if ((this.f2101h[i10] & i11) != i11 || (this.f2109p & i11) == 0 || (this.f2103j[i10] & i11) == i11 || (this.f2102i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f2095b;
        if (abs <= i12 && abs2 <= i12) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f2111r.onEdgeLock(i11)) {
            return (this.f2102i[i10] & i11) == 0 && abs > ((float) this.f2095b);
        }
        int[] iArr = this.f2103j;
        iArr[i10] = iArr[i10] | i11;
        return false;
    }

    public final boolean d(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        boolean z10 = this.f2111r.getViewHorizontalDragRange(view) > 0;
        boolean z11 = this.f2111r.getViewVerticalDragRange(view) > 0;
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f2095b) : z11 && Math.abs(f11) > ((float) this.f2095b);
        }
        float f12 = (f10 * f10) + (f11 * f11);
        int i10 = this.f2095b;
        return f12 > ((float) (i10 * i10));
    }

    public final float e(float f10, float f11, float f12) {
        float abs = Math.abs(f10);
        if (abs < f11) {
            return 0.0f;
        }
        return abs > f12 ? f10 > 0.0f ? f12 : -f12 : f10;
    }

    public final int f(int i10, int i11, int i12) {
        int abs = Math.abs(i10);
        if (abs < i11) {
            return 0;
        }
        return abs > i12 ? i10 > 0 ? i12 : -i12 : i10;
    }

    public final void g() {
        float[] fArr = this.f2097d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f2098e, 0.0f);
        Arrays.fill(this.f2099f, 0.0f);
        Arrays.fill(this.f2100g, 0.0f);
        Arrays.fill(this.f2101h, 0);
        Arrays.fill(this.f2102i, 0);
        Arrays.fill(this.f2103j, 0);
        this.f2104k = 0;
    }

    public final void h(int i10) {
        if (this.f2097d == null || !x(i10)) {
            return;
        }
        this.f2097d[i10] = 0.0f;
        this.f2098e[i10] = 0.0f;
        this.f2099f[i10] = 0.0f;
        this.f2100g[i10] = 0.0f;
        this.f2101h[i10] = 0;
        this.f2102i[i10] = 0;
        this.f2103j[i10] = 0;
        this.f2104k = ((1 << i10) ^ (-1)) & this.f2104k;
    }

    public final int i(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        int width = this.f2114u.getWidth();
        float f10 = width / 2;
        float o10 = f10 + (o(Math.min(1.0f, Math.abs(i10) / width)) * f10);
        int abs = Math.abs(i11);
        return Math.min(abs > 0 ? Math.round(Math.abs(o10 / abs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f), 600);
    }

    public final int j(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int f14 = f(i12, (int) this.f2107n, (int) this.f2106m);
        int f15 = f(i13, (int) this.f2107n, (int) this.f2106m);
        int abs = Math.abs(i10);
        int abs2 = Math.abs(i11);
        int abs3 = Math.abs(f14);
        int abs4 = Math.abs(f15);
        int i14 = abs3 + abs4;
        int i15 = abs + abs2;
        if (f14 != 0) {
            f10 = abs3;
            f11 = i14;
        } else {
            f10 = abs;
            f11 = i15;
        }
        float f16 = f10 / f11;
        if (f15 != 0) {
            f12 = abs4;
            f13 = i14;
        } else {
            f12 = abs2;
            f13 = i15;
        }
        return (int) ((i(i10, f14, this.f2111r.getViewHorizontalDragRange(view)) * f16) + (i(i11, f15, this.f2111r.getViewVerticalDragRange(view)) * (f12 / f13)));
    }

    public boolean k(boolean z10) {
        if (this.f2094a == 2) {
            boolean computeScrollOffset = this.f2110q.computeScrollOffset();
            int currX = this.f2110q.getCurrX();
            int currY = this.f2110q.getCurrY();
            int left = currX - this.f2112s.getLeft();
            int top = currY - this.f2112s.getTop();
            if (left != 0) {
                c1.V(this.f2112s, left);
            }
            if (top != 0) {
                c1.W(this.f2112s, top);
            }
            if (left != 0 || top != 0) {
                this.f2111r.onViewPositionChanged(this.f2112s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f2110q.getFinalX() && currY == this.f2110q.getFinalY()) {
                this.f2110q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z10) {
                    this.f2114u.post(this.f2115v);
                } else {
                    F(0);
                }
            }
        }
        return this.f2094a == 2;
    }

    public final void n(float f10, float f11) {
        this.f2113t = true;
        this.f2111r.onViewReleased(this.f2112s, f10, f11);
        this.f2113t = false;
        if (this.f2094a == 1) {
            F(0);
        }
    }

    public final float o(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    public final void p(int i10, int i11, int i12, int i13) {
        int left = this.f2112s.getLeft();
        int top = this.f2112s.getTop();
        if (i12 != 0) {
            i10 = this.f2111r.clampViewPositionHorizontal(this.f2112s, i10, i12);
            c1.V(this.f2112s, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f2111r.clampViewPositionVertical(this.f2112s, i11, i13);
            c1.W(this.f2112s, i11 - top);
        }
        int i15 = i11;
        if (i12 == 0 && i13 == 0) {
            return;
        }
        this.f2111r.onViewPositionChanged(this.f2112s, i14, i15, i14 - left, i15 - top);
    }

    public final void q(int i10) {
        float[] fArr = this.f2097d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f2098e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f2099f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f2100g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f2101h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f2102i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f2103j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f2097d = fArr2;
            this.f2098e = fArr3;
            this.f2099f = fArr4;
            this.f2100g = fArr5;
            this.f2101h = iArr;
            this.f2102i = iArr2;
            this.f2103j = iArr3;
        }
    }

    public View r(int i10, int i11) {
        for (int childCount = this.f2114u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f2114u.getChildAt(this.f2111r.getOrderedChildIndex(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean s(int i10, int i11, int i12, int i13) {
        int left = this.f2112s.getLeft();
        int top = this.f2112s.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f2110q.abortAnimation();
            F(0);
            return false;
        }
        this.f2110q.startScroll(left, top, i14, i15, j(this.f2112s, i14, i15, i12, i13));
        F(2);
        return true;
    }

    public final int t(int i10, int i11) {
        int i12 = i10 < this.f2114u.getLeft() + this.f2108o ? 1 : 0;
        if (i11 < this.f2114u.getTop() + this.f2108o) {
            i12 |= 4;
        }
        if (i10 > this.f2114u.getRight() - this.f2108o) {
            i12 |= 2;
        }
        return i11 > this.f2114u.getBottom() - this.f2108o ? i12 | 8 : i12;
    }

    public int u() {
        return this.f2095b;
    }

    public int v() {
        return this.f2094a;
    }

    public boolean w(int i10, int i11) {
        return z(this.f2112s, i10, i11);
    }

    public boolean x(int i10) {
        return ((1 << i10) & this.f2104k) != 0;
    }

    public final boolean y(int i10) {
        if (x(i10)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public boolean z(View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }
}
