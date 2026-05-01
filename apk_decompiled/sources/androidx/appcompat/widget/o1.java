package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class o1 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1559a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1560b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Rect f1561c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public static Class f1562d;

    static {
        try {
            f1562d = Class.forName("android.graphics.Insets");
        } catch (ClassNotFoundException unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(Drawable drawable) {
        if (!(drawable instanceof DrawableContainer)) {
            if (drawable instanceof s.x) {
                return a(((s.x) drawable).a());
            }
            if (drawable instanceof e.m) {
                return a(((e.m) drawable).getWrappedDrawable());
            }
            if (drawable instanceof ScaleDrawable) {
                return a(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
            return true;
        }
        for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
            if (!a(drawable2)) {
                return false;
            }
        }
        return true;
    }

    public static void b(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            c(drawable);
        }
    }

    public static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1559a);
        } else {
            drawable.setState(f1560b);
        }
        drawable.setState(state);
    }

    public static Rect d(Drawable drawable) {
        char c10;
        Insets opticalInsets;
        int i10;
        int i11;
        int i12;
        int i13;
        if (Build.VERSION.SDK_INT >= 29) {
            opticalInsets = drawable.getOpticalInsets();
            Rect rect = new Rect();
            i10 = opticalInsets.left;
            rect.left = i10;
            i11 = opticalInsets.right;
            rect.right = i11;
            i12 = opticalInsets.top;
            rect.top = i12;
            i13 = opticalInsets.bottom;
            rect.bottom = i13;
            return rect;
        }
        if (f1562d != null) {
            try {
                Drawable q10 = s.h.q(drawable);
                Object invoke = q10.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(q10, new Object[0]);
                if (invoke != null) {
                    Rect rect2 = new Rect();
                    for (Field field : f1562d.getFields()) {
                        String name = field.getName();
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c10 = 3;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c10 = 1;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    c10 = 0;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    c10 = 2;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            default:
                                c10 = 65535;
                                break;
                        }
                        if (c10 == 0) {
                            rect2.left = field.getInt(invoke);
                        } else if (c10 == 1) {
                            rect2.top = field.getInt(invoke);
                        } else if (c10 == 2) {
                            rect2.right = field.getInt(invoke);
                        } else if (c10 == 3) {
                            rect2.bottom = field.getInt(invoke);
                        }
                    }
                    return rect2;
                }
            } catch (Exception unused) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f1561c;
    }

    public static PorterDuff.Mode e(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
