package c0;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R$id;
import c0.l0;
import com.hpplay.component.protocol.mirror.AutoStrategy;
import com.uc.crashsdk.export.LogType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class g0 {

    /* renamed from: d, reason: collision with root package name */
    public static int f5257d;

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f5258a;

    /* renamed from: b, reason: collision with root package name */
    public int f5259b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f5260c = -1;

    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;

        /* renamed from: e, reason: collision with root package name */
        public static final a f5261e = new a(1, null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f5262f = new a(2, null);

        /* renamed from: g, reason: collision with root package name */
        public static final a f5263g = new a(4, null);

        /* renamed from: h, reason: collision with root package name */
        public static final a f5264h = new a(8, null);

        /* renamed from: i, reason: collision with root package name */
        public static final a f5265i = new a(16, null);

        /* renamed from: j, reason: collision with root package name */
        public static final a f5266j = new a(32, null);

        /* renamed from: k, reason: collision with root package name */
        public static final a f5267k = new a(64, null);

        /* renamed from: l, reason: collision with root package name */
        public static final a f5268l = new a(128, null);

        /* renamed from: m, reason: collision with root package name */
        public static final a f5269m = new a(256, null, l0.b.class);

        /* renamed from: n, reason: collision with root package name */
        public static final a f5270n = new a(512, null, l0.b.class);

        /* renamed from: o, reason: collision with root package name */
        public static final a f5271o = new a(1024, null, l0.c.class);

        /* renamed from: p, reason: collision with root package name */
        public static final a f5272p = new a(2048, null, l0.c.class);

        /* renamed from: q, reason: collision with root package name */
        public static final a f5273q = new a(4096, null);

        /* renamed from: r, reason: collision with root package name */
        public static final a f5274r = new a(8192, null);

        /* renamed from: s, reason: collision with root package name */
        public static final a f5275s = new a(16384, null);

        /* renamed from: t, reason: collision with root package name */
        public static final a f5276t = new a(32768, null);

        /* renamed from: u, reason: collision with root package name */
        public static final a f5277u = new a(65536, null);

        /* renamed from: v, reason: collision with root package name */
        public static final a f5278v = new a(131072, null, l0.g.class);

        /* renamed from: w, reason: collision with root package name */
        public static final a f5279w = new a(262144, null);

        /* renamed from: x, reason: collision with root package name */
        public static final a f5280x = new a(524288, null);

        /* renamed from: y, reason: collision with root package name */
        public static final a f5281y = new a(LogType.ANR, null);

        /* renamed from: z, reason: collision with root package name */
        public static final a f5282z = new a(AutoStrategy.BITRATE_LOW4, null, l0.h.class);

        /* renamed from: a, reason: collision with root package name */
        public final Object f5283a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5284b;

        /* renamed from: c, reason: collision with root package name */
        public final Class f5285c;

        /* renamed from: d, reason: collision with root package name */
        public final l0 f5286d;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction21;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction22;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction23;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction24;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction25;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction26;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction27;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction28;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction29;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction30;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction31;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction32;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 23) {
                accessibilityAction32 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
                accessibilityAction = accessibilityAction32;
            } else {
                accessibilityAction = null;
            }
            A = new a(accessibilityAction, R.id.accessibilityActionShowOnScreen, null, null, null);
            if (i10 >= 23) {
                accessibilityAction31 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
                accessibilityAction2 = accessibilityAction31;
            } else {
                accessibilityAction2 = null;
            }
            B = new a(accessibilityAction2, R.id.accessibilityActionScrollToPosition, null, null, l0.e.class);
            if (i10 >= 23) {
                accessibilityAction30 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
                accessibilityAction3 = accessibilityAction30;
            } else {
                accessibilityAction3 = null;
            }
            C = new a(accessibilityAction3, R.id.accessibilityActionScrollUp, null, null, null);
            if (i10 >= 23) {
                accessibilityAction29 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
                accessibilityAction4 = accessibilityAction29;
            } else {
                accessibilityAction4 = null;
            }
            D = new a(accessibilityAction4, R.id.accessibilityActionScrollLeft, null, null, null);
            if (i10 >= 23) {
                accessibilityAction28 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
                accessibilityAction5 = accessibilityAction28;
            } else {
                accessibilityAction5 = null;
            }
            E = new a(accessibilityAction5, R.id.accessibilityActionScrollDown, null, null, null);
            if (i10 >= 23) {
                accessibilityAction27 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
                accessibilityAction6 = accessibilityAction27;
            } else {
                accessibilityAction6 = null;
            }
            F = new a(accessibilityAction6, R.id.accessibilityActionScrollRight, null, null, null);
            if (i10 >= 29) {
                accessibilityAction26 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
                accessibilityAction7 = accessibilityAction26;
            } else {
                accessibilityAction7 = null;
            }
            G = new a(accessibilityAction7, R.id.accessibilityActionPageUp, null, null, null);
            if (i10 >= 29) {
                accessibilityAction25 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
                accessibilityAction8 = accessibilityAction25;
            } else {
                accessibilityAction8 = null;
            }
            H = new a(accessibilityAction8, R.id.accessibilityActionPageDown, null, null, null);
            if (i10 >= 29) {
                accessibilityAction24 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
                accessibilityAction9 = accessibilityAction24;
            } else {
                accessibilityAction9 = null;
            }
            I = new a(accessibilityAction9, R.id.accessibilityActionPageLeft, null, null, null);
            if (i10 >= 29) {
                accessibilityAction23 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
                accessibilityAction10 = accessibilityAction23;
            } else {
                accessibilityAction10 = null;
            }
            J = new a(accessibilityAction10, R.id.accessibilityActionPageRight, null, null, null);
            if (i10 >= 23) {
                accessibilityAction22 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
                accessibilityAction11 = accessibilityAction22;
            } else {
                accessibilityAction11 = null;
            }
            K = new a(accessibilityAction11, R.id.accessibilityActionContextClick, null, null, null);
            if (i10 >= 24) {
                accessibilityAction21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
                accessibilityAction12 = accessibilityAction21;
            } else {
                accessibilityAction12 = null;
            }
            L = new a(accessibilityAction12, R.id.accessibilityActionSetProgress, null, null, l0.f.class);
            if (i10 >= 26) {
                accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
                accessibilityAction13 = accessibilityAction20;
            } else {
                accessibilityAction13 = null;
            }
            M = new a(accessibilityAction13, R.id.accessibilityActionMoveWindow, null, null, l0.d.class);
            if (i10 >= 28) {
                accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
                accessibilityAction14 = accessibilityAction19;
            } else {
                accessibilityAction14 = null;
            }
            N = new a(accessibilityAction14, R.id.accessibilityActionShowTooltip, null, null, null);
            if (i10 >= 28) {
                accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
                accessibilityAction15 = accessibilityAction18;
            } else {
                accessibilityAction15 = null;
            }
            O = new a(accessibilityAction15, R.id.accessibilityActionHideTooltip, null, null, null);
            if (i10 >= 30) {
                accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
                accessibilityAction16 = accessibilityAction17;
            } else {
                accessibilityAction16 = null;
            }
            P = new a(accessibilityAction16, R.id.accessibilityActionPressAndHold, null, null, null);
            Q = new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        }

        public a(int i10, CharSequence charSequence) {
            this(null, i10, charSequence, null, null);
        }

        public a a(CharSequence charSequence, l0 l0Var) {
            return new a(null, this.f5284b, charSequence, l0Var, this.f5285c);
        }

        public int b() {
            int id;
            if (Build.VERSION.SDK_INT < 21) {
                return 0;
            }
            id = i.a(this.f5283a).getId();
            return id;
        }

        public CharSequence c() {
            CharSequence label;
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            label = i.a(this.f5283a).getLabel();
            return label;
        }

        public boolean d(View view, Bundle bundle) {
            if (this.f5286d == null) {
                return false;
            }
            Class cls = this.f5285c;
            if (cls != null) {
                try {
                    androidx.appcompat.app.m.a(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    throw null;
                } catch (Exception e10) {
                    Class cls2 = this.f5285c;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e10);
                }
            }
            return this.f5286d.perform(view, null);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f5283a;
            return obj2 == null ? aVar.f5283a == null : obj2.equals(aVar.f5283a);
        }

        public int hashCode() {
            Object obj = this.f5283a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(int i10, CharSequence charSequence, Class cls) {
            this(null, i10, charSequence, null, cls);
        }

        public a(Object obj, int i10, CharSequence charSequence, l0 l0Var, Class cls) {
            this.f5284b = i10;
            this.f5286d = l0Var;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.f5283a = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
            } else {
                this.f5283a = obj;
            }
            this.f5285c = cls;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Object f5287a;

        public b(Object obj) {
            this.f5287a = obj;
        }

        public static b a(int i10, int i11, boolean z10) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10));
        }

        public static b b(int i10, int i11, boolean z10, int i12) {
            AccessibilityNodeInfo.CollectionInfo obtain;
            if (Build.VERSION.SDK_INT < 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10));
            }
            obtain = AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12);
            return new b(obtain);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Object f5288a;

        public c(Object obj) {
            this.f5288a = obj;
        }

        public static c a(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
            AccessibilityNodeInfo.CollectionItemInfo obtain;
            if (Build.VERSION.SDK_INT < 21) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10));
            }
            obtain = AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10, z11);
            return new c(obtain);
        }
    }

    public g0(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f5258a = accessibilityNodeInfo;
    }

    public static g0 K() {
        return v0(AccessibilityNodeInfo.obtain());
    }

    public static g0 L(View view) {
        return v0(AccessibilityNodeInfo.obtain(view));
    }

    public static g0 M(g0 g0Var) {
        return v0(AccessibilityNodeInfo.obtain(g0Var.f5258a));
    }

    public static String i(int i10) {
        if (i10 == 1) {
            return "ACTION_FOCUS";
        }
        if (i10 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i10) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case AutoStrategy.BITRATE_LOW4 /* 2097152 */:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionImeEnter:
                return "ACTION_IME_ENTER";
            default:
                switch (i10) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i10) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public static g0 v0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new g0(accessibilityNodeInfo);
    }

    public boolean A() {
        return this.f5258a.isChecked();
    }

    public boolean B() {
        return this.f5258a.isClickable();
    }

    public boolean C() {
        return this.f5258a.isEnabled();
    }

    public boolean D() {
        return this.f5258a.isFocusable();
    }

    public boolean E() {
        return this.f5258a.isFocused();
    }

    public boolean F() {
        return this.f5258a.isLongClickable();
    }

    public boolean G() {
        return this.f5258a.isPassword();
    }

    public boolean H() {
        return this.f5258a.isScrollable();
    }

    public boolean I() {
        return this.f5258a.isSelected();
    }

    public boolean J() {
        boolean isShowingHintText;
        if (Build.VERSION.SDK_INT < 26) {
            return k(4);
        }
        isShowingHintText = this.f5258a.isShowingHintText();
        return isShowingHintText;
    }

    public boolean N(int i10, Bundle bundle) {
        return this.f5258a.performAction(i10, bundle);
    }

    public void O() {
        this.f5258a.recycle();
    }

    public final void P(View view) {
        SparseArray u10 = u(view);
        if (u10 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < u10.size(); i10++) {
                if (((WeakReference) u10.valueAt(i10)).get() == null) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                u10.remove(((Integer) arrayList.get(i11)).intValue());
            }
        }
    }

    public void Q(boolean z10) {
        this.f5258a.setAccessibilityFocused(z10);
    }

    public final void R(int i10, boolean z10) {
        Bundle r10 = r();
        if (r10 != null) {
            int i11 = r10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i10 ^ (-1));
            if (!z10) {
                i10 = 0;
            }
            r10.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i10 | i11);
        }
    }

    public void S(Rect rect) {
        this.f5258a.setBoundsInParent(rect);
    }

    public void T(Rect rect) {
        this.f5258a.setBoundsInScreen(rect);
    }

    public void U(boolean z10) {
        this.f5258a.setCheckable(z10);
    }

    public void V(boolean z10) {
        this.f5258a.setChecked(z10);
    }

    public void W(CharSequence charSequence) {
        this.f5258a.setClassName(charSequence);
    }

    public void X(boolean z10) {
        this.f5258a.setClickable(z10);
    }

    public void Y(Object obj) {
        this.f5258a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f5287a);
    }

    public void Z(Object obj) {
        this.f5258a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f5288a);
    }

    public void a(int i10) {
        this.f5258a.addAction(i10);
    }

    public void a0(CharSequence charSequence) {
        this.f5258a.setContentDescription(charSequence);
    }

    public void b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f5258a.addAction(i.a(aVar.f5283a));
        }
    }

    public void b0(boolean z10) {
        this.f5258a.setContentInvalid(z10);
    }

    public void c(View view, int i10) {
        this.f5258a.addChild(view, i10);
    }

    public void c0(boolean z10) {
        this.f5258a.setDismissable(z10);
    }

    public final void d(ClickableSpan clickableSpan, Spanned spanned, int i10) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i10));
    }

    public void d0(boolean z10) {
        this.f5258a.setEnabled(z10);
    }

    public void e(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            f();
            P(view);
            ClickableSpan[] p10 = p(charSequence);
            if (p10 == null || p10.length <= 0) {
                return;
            }
            r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.accessibility_action_clickable_span);
            SparseArray s10 = s(view);
            for (int i10 = 0; i10 < p10.length; i10++) {
                int y10 = y(p10[i10], s10);
                s10.put(y10, new WeakReference(p10[i10]));
                d(p10[i10], (Spanned) charSequence, y10);
            }
        }
    }

    public void e0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f5258a.setError(charSequence);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5258a;
        if (accessibilityNodeInfo == null) {
            if (g0Var.f5258a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(g0Var.f5258a)) {
            return false;
        }
        return this.f5260c == g0Var.f5260c && this.f5259b == g0Var.f5259b;
    }

    public final void f() {
        this.f5258a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f5258a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f5258a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f5258a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    public void f0(boolean z10) {
        this.f5258a.setFocusable(z10);
    }

    public final List g(String str) {
        ArrayList<Integer> integerArrayList = this.f5258a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f5258a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void g0(boolean z10) {
        this.f5258a.setFocused(z10);
    }

    public List h() {
        List actionList = Build.VERSION.SDK_INT >= 21 ? this.f5258a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10)));
        }
        return arrayList;
    }

    public void h0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f5258a.setHeading(z10);
        } else {
            R(2, z10);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5258a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5258a.setHintText(charSequence);
        } else {
            this.f5258a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public int j() {
        return this.f5258a.getActions();
    }

    public void j0(CharSequence charSequence) {
        this.f5258a.setPackageName(charSequence);
    }

    public final boolean k(int i10) {
        Bundle r10 = r();
        return r10 != null && (r10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i10) == i10;
    }

    public void k0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f5258a.setPaneTitle(charSequence);
        } else {
            this.f5258a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void l(Rect rect) {
        this.f5258a.getBoundsInParent(rect);
    }

    public void l0(View view) {
        this.f5259b = -1;
        this.f5258a.setParent(view);
    }

    public void m(Rect rect) {
        this.f5258a.getBoundsInScreen(rect);
    }

    public void m0(View view, int i10) {
        this.f5259b = i10;
        this.f5258a.setParent(view, i10);
    }

    public int n() {
        return this.f5258a.getChildCount();
    }

    public void n0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f5258a.setScreenReaderFocusable(z10);
        } else {
            R(1, z10);
        }
    }

    public CharSequence o() {
        return this.f5258a.getClassName();
    }

    public void o0(boolean z10) {
        this.f5258a.setScrollable(z10);
    }

    public void p0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5258a.setShowingHintText(z10);
        } else {
            R(4, z10);
        }
    }

    public CharSequence q() {
        return this.f5258a.getContentDescription();
    }

    public void q0(View view, int i10) {
        this.f5260c = i10;
        this.f5258a.setSource(view, i10);
    }

    public Bundle r() {
        return this.f5258a.getExtras();
    }

    public void r0(CharSequence charSequence) {
        if (x.a.b()) {
            this.f5258a.setStateDescription(charSequence);
        } else {
            this.f5258a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public final SparseArray s(View view) {
        SparseArray u10 = u(view);
        if (u10 != null) {
            return u10;
        }
        SparseArray sparseArray = new SparseArray();
        view.setTag(R$id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    public void s0(CharSequence charSequence) {
        this.f5258a.setText(charSequence);
    }

    public CharSequence t() {
        return this.f5258a.getPackageName();
    }

    public void t0(boolean z10) {
        this.f5258a.setVisibleToUser(z10);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        sb.append("; boundsInParent: " + rect);
        m(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(t());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(v());
        sb.append("; contentDescription: ");
        sb.append(q());
        sb.append("; viewId: ");
        sb.append(w());
        sb.append("; checkable: ");
        sb.append(z());
        sb.append("; checked: ");
        sb.append(A());
        sb.append("; focusable: ");
        sb.append(D());
        sb.append("; focused: ");
        sb.append(E());
        sb.append("; selected: ");
        sb.append(I());
        sb.append("; clickable: ");
        sb.append(B());
        sb.append("; longClickable: ");
        sb.append(F());
        sb.append("; enabled: ");
        sb.append(C());
        sb.append("; password: ");
        sb.append(G());
        sb.append("; scrollable: " + H());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List h10 = h();
            for (int i10 = 0; i10 < h10.size(); i10++) {
                a aVar = (a) h10.get(i10);
                String i11 = i(aVar.b());
                if (i11.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                    i11 = aVar.c().toString();
                }
                sb.append(i11);
                if (i10 != h10.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int j10 = j();
            while (j10 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(j10);
                j10 &= numberOfTrailingZeros ^ (-1);
                sb.append(i(numberOfTrailingZeros));
                if (j10 != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final SparseArray u(View view) {
        return (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
    }

    public AccessibilityNodeInfo u0() {
        return this.f5258a;
    }

    public CharSequence v() {
        if (!x()) {
            return this.f5258a.getText();
        }
        List g10 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List g11 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List g12 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List g13 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f5258a.getText(), 0, this.f5258a.getText().length()));
        for (int i10 = 0; i10 < g10.size(); i10++) {
            spannableString.setSpan(new c0.a(((Integer) g13.get(i10)).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) g10.get(i10)).intValue(), ((Integer) g11.get(i10)).intValue(), ((Integer) g12.get(i10)).intValue());
        }
        return spannableString;
    }

    public String w() {
        return this.f5258a.getViewIdResourceName();
    }

    public final boolean x() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public final int y(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i10)).get())) {
                    return sparseArray.keyAt(i10);
                }
            }
        }
        int i11 = f5257d;
        f5257d = i11 + 1;
        return i11;
    }

    public boolean z() {
        return this.f5258a.isCheckable();
    }
}
