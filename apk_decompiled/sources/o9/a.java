package o9;

import t9.i;

/* loaded from: classes3.dex */
public class a extends n9.a {

    /* renamed from: o9.a$a, reason: collision with other inner class name */
    public static final class C0303a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0303a f17667a = new C0303a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f17668b;

        /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
        static {
            /*
                o9.a$a r0 = new o9.a$a
                r0.<init>()
                o9.a.C0303a.f17667a = r0
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L1f
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L1f
                boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L1f
                if (r2 == 0) goto L20
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L1f
                goto L21
            L1f:
            L20:
                r1 = r0
            L21:
                if (r1 == 0) goto L2f
                int r2 = r1.intValue()
                if (r2 <= 0) goto L2b
                r2 = 1
                goto L2c
            L2b:
                r2 = 0
            L2c:
                if (r2 == 0) goto L2f
                r0 = r1
            L2f:
                o9.a.C0303a.f17668b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o9.a.C0303a.<clinit>():void");
        }
    }

    @Override // n9.a
    public void a(Throwable th, Throwable th2) {
        i.g(th, "cause");
        i.g(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }

    public final boolean c(int i10) {
        Integer num = C0303a.f17668b;
        return num == null || num.intValue() >= i10;
    }
}
