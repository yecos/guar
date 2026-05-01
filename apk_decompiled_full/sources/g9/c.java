package g9;

/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14073a;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    static {
        Object obj;
        Class<?> cls;
        a aVar;
        try {
            cls = Class.forName("io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl");
            obj = null;
        } catch (Throwable th) {
            obj = th;
            cls = null;
        }
        if (cls != null) {
            try {
                aVar = (a) cls.asSubclass(a.class).getConstructor(d.class).newInstance(a.f14070a);
            } catch (Throwable th2) {
                obj = th2;
            }
            if (aVar == null) {
                f14073a = aVar;
            } else {
                f14073a = new a(a.f14070a);
            }
            if (obj == null) {
                try {
                    if (Boolean.getBoolean("io.perfmark.PerfMark.debug")) {
                        Class<?> cls2 = Class.forName("java.util.logging.Logger");
                        Object invoke = cls2.getMethod("getLogger", String.class).invoke(null, c.class.getName());
                        Class<?> cls3 = Class.forName("java.util.logging.Level");
                        cls2.getMethod("log", cls3, String.class, Throwable.class).invoke(invoke, cls3.getField("FINE").get(null), "Error during PerfMark.<clinit>", obj);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            return;
        }
        aVar = null;
        if (aVar == null) {
        }
        if (obj == null) {
        }
    }

    public static d a(String str) {
        return f14073a.a(str, Long.MIN_VALUE);
    }

    public static d b(String str, long j10) {
        return f14073a.a(str, j10);
    }

    public static void c(String str, d dVar) {
        f14073a.b(str, dVar);
    }

    public static void d(b bVar) {
        f14073a.c(bVar);
    }

    public static b e() {
        return f14073a.d();
    }

    public static void f(String str) {
        f14073a.e(str);
    }

    public static void g(String str, d dVar) {
        f14073a.f(str, dVar);
    }

    public static void h(String str) {
        f14073a.g(str);
    }

    public static void i(String str, d dVar) {
        f14073a.h(str, dVar);
    }
}
