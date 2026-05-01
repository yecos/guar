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
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r1 = 0
            java.lang.String r2 = "io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> Lb
            r3 = r1
            goto Le
        Lb:
            r2 = move-exception
            r3 = r2
            r2 = r1
        Le:
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L31
            java.lang.Class<g9.a> r6 = g9.a.class
            java.lang.Class r2 = r2.asSubclass(r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L2f
            java.lang.Class<g9.d> r7 = g9.d.class
            r6[r4] = r7     // Catch: java.lang.Throwable -> L2f
            java.lang.reflect.Constructor r2 = r2.getConstructor(r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L2f
            g9.d r7 = g9.a.f14070a     // Catch: java.lang.Throwable -> L2f
            r6[r4] = r7     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r2 = r2.newInstance(r6)     // Catch: java.lang.Throwable -> L2f
            g9.a r2 = (g9.a) r2     // Catch: java.lang.Throwable -> L2f
            goto L32
        L2f:
            r2 = move-exception
            r3 = r2
        L31:
            r2 = r1
        L32:
            if (r2 == 0) goto L37
            g9.c.f14073a = r2
            goto L40
        L37:
            g9.a r2 = new g9.a
            g9.d r6 = g9.a.f14070a
            r2.<init>(r6)
            g9.c.f14073a = r2
        L40:
            if (r3 == 0) goto L97
            java.lang.String r2 = "io.perfmark.PerfMark.debug"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch: java.lang.Throwable -> L97
            if (r2 == 0) goto L97
            java.lang.String r2 = "java.util.logging.Logger"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = "getLogger"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L97
            r7[r4] = r0     // Catch: java.lang.Throwable -> L97
            java.lang.reflect.Method r6 = r2.getMethod(r6, r7)     // Catch: java.lang.Throwable -> L97
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L97
            java.lang.Class<g9.c> r8 = g9.c.class
            java.lang.String r8 = r8.getName()     // Catch: java.lang.Throwable -> L97
            r7[r4] = r8     // Catch: java.lang.Throwable -> L97
            java.lang.Object r6 = r6.invoke(r1, r7)     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = "java.util.logging.Level"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch: java.lang.Throwable -> L97
            java.lang.String r8 = "FINE"
            java.lang.reflect.Field r8 = r7.getField(r8)     // Catch: java.lang.Throwable -> L97
            java.lang.Object r1 = r8.get(r1)     // Catch: java.lang.Throwable -> L97
            java.lang.String r8 = "log"
            r9 = 3
            java.lang.Class[] r10 = new java.lang.Class[r9]     // Catch: java.lang.Throwable -> L97
            r10[r4] = r7     // Catch: java.lang.Throwable -> L97
            r10[r5] = r0     // Catch: java.lang.Throwable -> L97
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            r7 = 2
            r10[r7] = r0     // Catch: java.lang.Throwable -> L97
            java.lang.reflect.Method r0 = r2.getMethod(r8, r10)     // Catch: java.lang.Throwable -> L97
            java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch: java.lang.Throwable -> L97
            r2[r4] = r1     // Catch: java.lang.Throwable -> L97
            java.lang.String r1 = "Error during PerfMark.<clinit>"
            r2[r5] = r1     // Catch: java.lang.Throwable -> L97
            r2[r7] = r3     // Catch: java.lang.Throwable -> L97
            r0.invoke(r6, r2)     // Catch: java.lang.Throwable -> L97
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.c.<clinit>():void");
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
