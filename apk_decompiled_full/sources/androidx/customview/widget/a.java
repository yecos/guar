package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.h;
import androidx.customview.widget.b;
import b0.c1;
import b0.z1;
import c0.g0;
import c0.j0;
import c0.k0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a extends b0.a {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final b.a NODE_ADAPTER = new C0028a();
    private static final b.InterfaceC0029b SPARSE_VALUES_ADAPTER = new b();
    private final View mHost;
    private final AccessibilityManager mManager;
    private c mNodeProvider;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    /* renamed from: androidx.customview.widget.a$a, reason: collision with other inner class name */
    public static class C0028a implements b.a {
        @Override // androidx.customview.widget.b.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g0 g0Var, Rect rect) {
            g0Var.l(rect);
        }
    }

    public static class b implements b.InterfaceC0029b {
        @Override // androidx.customview.widget.b.InterfaceC0029b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public g0 a(h hVar, int i10) {
            return (g0) hVar.k(i10);
        }

        @Override // androidx.customview.widget.b.InterfaceC0029b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(h hVar) {
            return hVar.j();
        }
    }

    public class c extends j0 {
        public c() {
        }

        @Override // c0.j0
        public g0 b(int i10) {
            return g0.M(a.this.obtainAccessibilityNodeInfo(i10));
        }

        @Override // c0.j0
        public g0 d(int i10) {
            int i11 = i10 == 2 ? a.this.mAccessibilityFocusedVirtualViewId : a.this.mKeyboardFocusedVirtualViewId;
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i11);
        }

        @Override // c0.j0
        public boolean f(int i10, int i11, Bundle bundle) {
            return a.this.performAction(i10, i11, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.mHost = view;
        this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (c1.x(view) == 0) {
            c1.v0(view, 1);
        }
    }

    public static Rect l(View view, int i10, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i10 == 17) {
            rect.set(width, 0, width, height);
        } else if (i10 == 33) {
            rect.set(0, height, width, height);
        } else if (i10 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    public static int n(int i10) {
        if (i10 == 19) {
            return 33;
        }
        if (i10 != 21) {
            return i10 != 22 ? 130 : 66;
        }
        return 17;
    }

    public final boolean c(int i10) {
        if (this.mAccessibilityFocusedVirtualViewId != i10) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(i10, 65536);
        return true;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i10) {
        if (this.mKeyboardFocusedVirtualViewId != i10) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i10, false);
        sendEventForVirtualView(i10, 8);
        return true;
    }

    public final boolean d() {
        int i10 = this.mKeyboardFocusedVirtualViewId;
        return i10 != Integer.MIN_VALUE && onPerformActionForVirtualView(i10, 16, null);
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            s(virtualViewAt);
            return virtualViewAt != Integer.MIN_VALUE;
        }
        if (action != 10 || this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
            return false;
        }
        s(Integer.MIN_VALUE);
        return true;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i10 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return o(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return o(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int n10 = n(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z10 = false;
                    while (i10 < repeatCount && o(n10, null)) {
                        i10++;
                        z10 = true;
                    }
                    return z10;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        d();
        return true;
    }

    public final AccessibilityEvent e(int i10, int i11) {
        return i10 != -1 ? f(i10, i11) : g(i11);
    }

    public final AccessibilityEvent f(int i10, int i11) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i11);
        g0 obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i10);
        obtain.getText().add(obtainAccessibilityNodeInfo.v());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.q());
        obtain.setScrollable(obtainAccessibilityNodeInfo.H());
        obtain.setPassword(obtainAccessibilityNodeInfo.G());
        obtain.setEnabled(obtainAccessibilityNodeInfo.C());
        obtain.setChecked(obtainAccessibilityNodeInfo.A());
        onPopulateEventForVirtualView(i10, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(obtainAccessibilityNodeInfo.o());
        k0.g(obtain, this.mHost, i10);
        obtain.setPackageName(this.mHost.getContext().getPackageName());
        return obtain;
    }

    public final AccessibilityEvent g(int i10) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i10);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    @Override // b0.a
    public j0 getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new c();
        }
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    public abstract int getVirtualViewAt(float f10, float f11);

    public abstract void getVisibleVirtualViews(List list);

    public final g0 h(int i10) {
        g0 K = g0.K();
        K.d0(true);
        K.f0(true);
        K.W(DEFAULT_CLASS_NAME);
        Rect rect = INVALID_PARENT_BOUNDS;
        K.S(rect);
        K.T(rect);
        K.l0(this.mHost);
        onPopulateNodeForVirtualView(i10, K);
        if (K.v() == null && K.q() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        K.l(this.mTempParentRect);
        if (this.mTempParentRect.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int j10 = K.j();
        if ((j10 & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((j10 & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        K.j0(this.mHost.getContext().getPackageName());
        K.q0(this.mHost, i10);
        if (this.mAccessibilityFocusedVirtualViewId == i10) {
            K.Q(true);
            K.a(128);
        } else {
            K.Q(false);
            K.a(64);
        }
        boolean z10 = this.mKeyboardFocusedVirtualViewId == i10;
        if (z10) {
            K.a(2);
        } else if (K.D()) {
            K.a(1);
        }
        K.g0(z10);
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        K.m(this.mTempScreenRect);
        if (this.mTempScreenRect.equals(rect)) {
            K.l(this.mTempScreenRect);
            if (K.f5259b != -1) {
                g0 K2 = g0.K();
                for (int i11 = K.f5259b; i11 != -1; i11 = K2.f5259b) {
                    K2.m0(this.mHost, -1);
                    K2.S(INVALID_PARENT_BOUNDS);
                    onPopulateNodeForVirtualView(i11, K2);
                    K2.l(this.mTempParentRect);
                    Rect rect2 = this.mTempScreenRect;
                    Rect rect3 = this.mTempParentRect;
                    rect2.offset(rect3.left, rect3.top);
                }
                K2.O();
            }
            this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        }
        if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
            this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                K.T(this.mTempScreenRect);
                if (m(this.mTempScreenRect)) {
                    K.t0(true);
                }
            }
        }
        return K;
    }

    public final g0 i() {
        g0 L = g0.L(this.mHost);
        c1.Y(this.mHost, L);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (L.n() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            L.c(this.mHost, ((Integer) arrayList.get(i10)).intValue());
        }
        return L;
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i10) {
        invalidateVirtualView(i10, 0);
    }

    public final h j() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        h hVar = new h();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            hVar.i(i10, h(i10));
        }
        return hVar;
    }

    public final void k(int i10, Rect rect) {
        obtainAccessibilityNodeInfo(i10).l(rect);
    }

    public final boolean m(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    public final boolean o(int i10, Rect rect) {
        g0 g0Var;
        h j10 = j();
        int i11 = this.mKeyboardFocusedVirtualViewId;
        g0 g0Var2 = i11 == Integer.MIN_VALUE ? null : (g0) j10.e(i11);
        if (i10 == 1 || i10 == 2) {
            g0Var = (g0) androidx.customview.widget.b.d(j10, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, g0Var2, i10, c1.z(this.mHost) == 1, false);
        } else {
            if (i10 != 17 && i10 != 33 && i10 != 66 && i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i12 = this.mKeyboardFocusedVirtualViewId;
            if (i12 != Integer.MIN_VALUE) {
                k(i12, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                l(this.mHost, i10, rect2);
            }
            g0Var = (g0) androidx.customview.widget.b.c(j10, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, g0Var2, rect2, i10);
        }
        return requestKeyboardFocusForVirtualView(g0Var != null ? j10.h(j10.g(g0Var)) : Integer.MIN_VALUE);
    }

    public g0 obtainAccessibilityNodeInfo(int i10) {
        return i10 == -1 ? i() : h(i10);
    }

    public final void onFocusChanged(boolean z10, int i10, Rect rect) {
        int i11 = this.mKeyboardFocusedVirtualViewId;
        if (i11 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i11);
        }
        if (z10) {
            o(i10, rect);
        }
    }

    @Override // b0.a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    @Override // b0.a
    public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
        super.onInitializeAccessibilityNodeInfo(view, g0Var);
        onPopulateNodeForHost(g0Var);
    }

    public abstract boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle);

    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateEventForVirtualView(int i10, AccessibilityEvent accessibilityEvent) {
    }

    public abstract void onPopulateNodeForHost(g0 g0Var);

    public abstract void onPopulateNodeForVirtualView(int i10, g0 g0Var);

    public abstract void onVirtualViewKeyboardFocusChanged(int i10, boolean z10);

    public final boolean p(int i10, int i11, Bundle bundle) {
        return i11 != 1 ? i11 != 2 ? i11 != 64 ? i11 != 128 ? onPerformActionForVirtualView(i10, i11, bundle) : c(i10) : r(i10) : clearKeyboardFocusForVirtualView(i10) : requestKeyboardFocusForVirtualView(i10);
    }

    public boolean performAction(int i10, int i11, Bundle bundle) {
        return i10 != -1 ? p(i10, i11, bundle) : q(i11, bundle);
    }

    public final boolean q(int i10, Bundle bundle) {
        return c1.a0(this.mHost, i10, bundle);
    }

    public final boolean r(int i10) {
        int i11;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i11 = this.mAccessibilityFocusedVirtualViewId) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            c(i11);
        }
        this.mAccessibilityFocusedVirtualViewId = i10;
        this.mHost.invalidate();
        sendEventForVirtualView(i10, 32768);
        return true;
    }

    public final boolean requestKeyboardFocusForVirtualView(int i10) {
        int i11;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i11 = this.mKeyboardFocusedVirtualViewId) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i11);
        }
        this.mKeyboardFocusedVirtualViewId = i10;
        onVirtualViewKeyboardFocusChanged(i10, true);
        sendEventForVirtualView(i10, 8);
        return true;
    }

    public final void s(int i10) {
        int i11 = this.mHoveredVirtualViewId;
        if (i11 == i10) {
            return;
        }
        this.mHoveredVirtualViewId = i10;
        sendEventForVirtualView(i10, 128);
        sendEventForVirtualView(i11, 256);
    }

    public final boolean sendEventForVirtualView(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return z1.h(parent, this.mHost, e(i10, i11));
    }

    public final void invalidateVirtualView(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        AccessibilityEvent e10 = e(i10, 2048);
        c0.b.b(e10, i11);
        z1.h(parent, this.mHost, e10);
    }
}
