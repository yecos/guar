package x;

import android.os.Build;
import android.os.Trace;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static long f19285a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f19286b;

    /* renamed from: c, reason: collision with root package name */
    public static Method f19287c;

    /* renamed from: d, reason: collision with root package name */
    public static Method f19288d;

    /* renamed from: e, reason: collision with root package name */
    public static Method f19289e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f19285a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f19286b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f19287c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f19288d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f19289e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
