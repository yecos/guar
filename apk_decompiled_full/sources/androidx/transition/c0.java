package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import b0.c1;

/* loaded from: classes.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final o0 f3452a;

    /* renamed from: b, reason: collision with root package name */
    public static final Property f3453b;

    /* renamed from: c, reason: collision with root package name */
    public static final Property f3454c;

    public static class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(c0.c(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            c0.g(view, f10.floatValue());
        }
    }

    public static class b extends Property {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return c1.s(view);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            c1.r0(view, rect);
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f3452a = new n0();
        } else if (i10 >= 23) {
            f3452a = new m0();
        } else if (i10 >= 22) {
            f3452a = new k0();
        } else if (i10 >= 21) {
            f3452a = new i0();
        } else {
            f3452a = new f0();
        }
        f3453b = new a(Float.class, "translationAlpha");
        f3454c = new b(Rect.class, "clipBounds");
    }

    public static void a(View view) {
        f3452a.a(view);
    }

    public static b0 b(View view) {
        return new a0(view);
    }

    public static float c(View view) {
        return f3452a.c(view);
    }

    public static r0 d(View view) {
        return new q0(view);
    }

    public static void e(View view) {
        f3452a.d(view);
    }

    public static void f(View view, int i10, int i11, int i12, int i13) {
        f3452a.e(view, i10, i11, i12, i13);
    }

    public static void g(View view, float f10) {
        f3452a.f(view, f10);
    }

    public static void h(View view, int i10) {
        f3452a.g(view, i10);
    }

    public static void i(View view, Matrix matrix) {
        f3452a.h(view, matrix);
    }

    public static void j(View view, Matrix matrix) {
        f3452a.i(view, matrix);
    }
}
