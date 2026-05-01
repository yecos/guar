package j3;

import java.lang.ref.SoftReference;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final p f14635a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f14636b;

    static {
        boolean z10;
        try {
            z10 = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        f14635a = z10 ? p.a() : null;
        f14636b = new ThreadLocal();
    }

    public static a a() {
        ThreadLocal threadLocal = f14636b;
        SoftReference softReference = (SoftReference) threadLocal.get();
        a aVar = softReference == null ? null : (a) softReference.get();
        if (aVar == null) {
            aVar = new a();
            p pVar = f14635a;
            threadLocal.set(pVar != null ? pVar.c(aVar) : new SoftReference(aVar));
        }
        return aVar;
    }
}
