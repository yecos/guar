package d7;

import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f12684a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f12685b;

    static {
        Object c10 = c();
        f12684a = c10;
        f12685b = d(c10);
    }

    public static void a() {
        h(false);
    }

    public static void b() {
        h(false);
    }

    public static Object c() {
        Method g10;
        Object e10;
        Class f10;
        Method g11;
        Class f11 = f("android.os.ServiceManager");
        if (f11 == null || (g10 = g(f11, "getService", String.class)) == null || (e10 = e(g10, null, "hardware")) == null || (f10 = f("android.os.IHardwareService$Stub")) == null || (g11 = g(f10, "asInterface", IBinder.class)) == null) {
            return null;
        }
        return e(g11, null, e10);
    }

    public static Method d(Object obj) {
        if (obj == null) {
            return null;
        }
        return g(obj.getClass(), "setFlashlightEnabled", Boolean.TYPE);
    }

    public static Object e(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected error while invoking ");
            sb.append(method);
            return null;
        } catch (RuntimeException unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected error while invoking ");
            sb2.append(method);
            return null;
        } catch (InvocationTargetException e10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unexpected error while invoking ");
            sb3.append(method);
            e10.getCause();
            return null;
        }
    }

    public static Class f(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException unused2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected error while finding class ");
            sb.append(str);
            return null;
        }
    }

    public static Method g(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (RuntimeException unused2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected error while finding method ");
            sb.append(str);
            return null;
        }
    }

    public static void h(boolean z10) {
        Object obj = f12684a;
        if (obj != null) {
            e(f12685b, obj, Boolean.valueOf(z10));
        }
    }
}
