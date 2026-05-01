package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;

/* loaded from: classes.dex */
public abstract class n2 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f1549a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1550b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f1551c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f1552d = {R.attr.state_activated};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f1553e = {R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f1554f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f1555g = {R.attr.state_selected};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f1556h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f1557i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f1558j = new int[1];

    public static int a(Context context, int i10) {
        ColorStateList d10 = d(context, i10);
        if (d10 != null && d10.isStateful()) {
            return d10.getColorForState(f1550b, d10.getDefaultColor());
        }
        TypedValue e10 = e();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, e10, true);
        return c(context, i10, e10.getFloat());
    }

    public static int b(Context context, int i10) {
        int[] iArr = f1558j;
        iArr[0] = i10;
        r2 t10 = r2.t(context, null, iArr);
        try {
            return t10.b(0, 0);
        } finally {
            t10.v();
        }
    }

    public static int c(Context context, int i10, float f10) {
        return r.a.m(b(context, i10), Math.round(Color.alpha(r0) * f10));
    }

    public static ColorStateList d(Context context, int i10) {
        int[] iArr = f1558j;
        iArr[0] = i10;
        r2 t10 = r2.t(context, null, iArr);
        try {
            return t10.c(0);
        } finally {
            t10.v();
        }
    }

    public static TypedValue e() {
        ThreadLocal threadLocal = f1549a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
