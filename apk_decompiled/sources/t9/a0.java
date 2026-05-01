package t9;

import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class a0 {
    public static Collection a(Object obj) {
        if (obj instanceof u9.a) {
            j(obj, "kotlin.collections.MutableCollection");
        }
        return d(obj);
    }

    public static List b(Object obj) {
        if (obj instanceof u9.a) {
            j(obj, "kotlin.collections.MutableList");
        }
        return e(obj);
    }

    public static Object c(Object obj, int i10) {
        if (obj != null && !g(obj, i10)) {
            j(obj, "kotlin.jvm.functions.Function" + i10);
        }
        return obj;
    }

    public static Collection d(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e10) {
            throw i(e10);
        }
    }

    public static List e(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e10) {
            throw i(e10);
        }
    }

    public static int f(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).getArity();
        }
        if (obj instanceof s9.a) {
            return 0;
        }
        if (obj instanceof s9.l) {
            return 1;
        }
        return obj instanceof s9.p ? 2 : -1;
    }

    public static boolean g(Object obj, int i10) {
        return (obj instanceof h9.b) && f(obj) == i10;
    }

    public static Throwable h(Throwable th) {
        return i.n(th, a0.class.getName());
    }

    public static ClassCastException i(ClassCastException classCastException) {
        throw ((ClassCastException) h(classCastException));
    }

    public static void j(Object obj, String str) {
        k((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void k(String str) {
        throw i(new ClassCastException(str));
    }
}
