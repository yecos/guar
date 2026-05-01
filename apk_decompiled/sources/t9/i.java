package t9;

import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class i {
    public static boolean a(Float f10, float f11) {
        return f10 != null && f10.floatValue() == f11;
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) m(new IllegalStateException(str + " must not be null")));
    }

    public static void d(Object obj) {
        if (obj == null) {
            o();
        }
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            p(str);
        }
    }

    public static void f(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) m(new NullPointerException(str + " must not be null")));
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            s(str);
        }
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            r(str);
        }
    }

    public static int i(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    public static String j(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void k() {
        t();
    }

    public static void l(int i10, String str) {
        t();
    }

    public static Throwable m(Throwable th) {
        return n(th, i.class.getName());
    }

    public static Throwable n(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(stackTrace[i11].getClassName())) {
                i10 = i11;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i10 + 1, length));
        return th;
    }

    public static void o() {
        throw ((NullPointerException) m(new NullPointerException()));
    }

    public static void p(String str) {
        throw ((NullPointerException) m(new NullPointerException(str)));
    }

    public static void q() {
        throw ((h9.d) m(new h9.d()));
    }

    public static void r(String str) {
        throw ((IllegalArgumentException) m(new IllegalArgumentException(j(str))));
    }

    public static void s(String str) {
        throw ((NullPointerException) m(new NullPointerException(j(str))));
    }

    public static void t() {
        u("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void u(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void v(String str) {
        throw ((h9.s) m(new h9.s(str)));
    }

    public static void w(String str) {
        v("lateinit property " + str + " has not been initialized");
    }
}
