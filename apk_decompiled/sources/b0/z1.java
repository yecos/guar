package b0;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public abstract class z1 {
    public static boolean a(ViewParent viewParent, View view, float f10, float f11, boolean z10) {
        boolean onNestedFling;
        if (Build.VERSION.SDK_INT < 21) {
            if (viewParent instanceof z) {
                return ((z) viewParent).onNestedFling(view, f10, f11, z10);
            }
            return false;
        }
        try {
            onNestedFling = viewParent.onNestedFling(view, f10, f11, z10);
            return onNestedFling;
        } catch (AbstractMethodError e10) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e10);
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f10, float f11) {
        boolean onNestedPreFling;
        if (Build.VERSION.SDK_INT < 21) {
            if (viewParent instanceof z) {
                return ((z) viewParent).onNestedPreFling(view, f10, f11);
            }
            return false;
        }
        try {
            onNestedPreFling = viewParent.onNestedPreFling(view, f10, f11);
            return onNestedPreFling;
        } catch (AbstractMethodError e10) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e10);
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i10, int i11, int[] iArr, int i12) {
        if (viewParent instanceof x) {
            ((x) viewParent).onNestedPreScroll(view, i10, i11, iArr, i12);
            return;
        }
        if (i12 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof z) {
                    ((z) viewParent).onNestedPreScroll(view, i10, i11, iArr);
                    return;
                }
                return;
            }
            try {
                viewParent.onNestedPreScroll(view, i10, i11, iArr);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e10);
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (viewParent instanceof y) {
            ((y) viewParent).onNestedScroll(view, i10, i11, i12, i13, i14, iArr);
            return;
        }
        iArr[0] = iArr[0] + i12;
        iArr[1] = iArr[1] + i13;
        if (viewParent instanceof x) {
            ((x) viewParent).onNestedScroll(view, i10, i11, i12, i13, i14);
            return;
        }
        if (i14 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof z) {
                    ((z) viewParent).onNestedScroll(view, i10, i11, i12, i13);
                    return;
                }
                return;
            }
            try {
                viewParent.onNestedScroll(view, i10, i11, i12, i13);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e10);
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i10, int i11) {
        if (viewParent instanceof x) {
            ((x) viewParent).onNestedScrollAccepted(view, view2, i10, i11);
            return;
        }
        if (i11 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof z) {
                    ((z) viewParent).onNestedScrollAccepted(view, view2, i10);
                    return;
                }
                return;
            }
            try {
                viewParent.onNestedScrollAccepted(view, view2, i10);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e10);
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i10, int i11) {
        boolean onStartNestedScroll;
        if (viewParent instanceof x) {
            return ((x) viewParent).onStartNestedScroll(view, view2, i10, i11);
        }
        if (i11 != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21) {
            if (viewParent instanceof z) {
                return ((z) viewParent).onStartNestedScroll(view, view2, i10);
            }
            return false;
        }
        try {
            onStartNestedScroll = viewParent.onStartNestedScroll(view, view2, i10);
            return onStartNestedScroll;
        } catch (AbstractMethodError e10) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e10);
            return false;
        }
    }

    public static void g(ViewParent viewParent, View view, int i10) {
        if (viewParent instanceof x) {
            ((x) viewParent).onStopNestedScroll(view, i10);
            return;
        }
        if (i10 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof z) {
                    ((z) viewParent).onStopNestedScroll(view);
                    return;
                }
                return;
            }
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e10);
            }
        }
    }

    public static boolean h(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
}
