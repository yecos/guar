package w0;

import android.os.Trace;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static long f19126a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f19127b;

    public static void a(String str) {
        c.a(str);
    }

    public static void b() {
        c.b();
    }

    public static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to call ");
        sb.append(str);
        sb.append(" via reflection");
    }

    public static boolean d() {
        boolean isEnabled;
        try {
            if (f19127b == null) {
                isEnabled = Trace.isEnabled();
                return isEnabled;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    public static boolean e() {
        try {
            if (f19127b == null) {
                f19126a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f19127b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f19127b.invoke(null, Long.valueOf(f19126a))).booleanValue();
        } catch (Exception e10) {
            c("isTagEnabled", e10);
            return false;
        }
    }
}
