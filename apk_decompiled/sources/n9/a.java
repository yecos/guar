package n9;

import java.lang.reflect.Method;
import t9.i;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: n9.a$a, reason: collision with other inner class name */
    public static final class C0297a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0297a f17329a = new C0297a();

        /* renamed from: b, reason: collision with root package name */
        public static final Method f17330b;

        /* renamed from: c, reason: collision with root package name */
        public static final Method f17331c;

        /* JADX WARN: Removed duplicated region for block: B:10:0x003f A[LOOP:0: B:2:0x0015->B:10:0x003f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0043 A[EDGE_INSN: B:11:0x0043->B:12:0x0043 BREAK  A[LOOP:0: B:2:0x0015->B:10:0x003f], SYNTHETIC] */
        static {
            /*
                n9.a$a r0 = new n9.a$a
                r0.<init>()
                n9.a.C0297a.f17329a = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                t9.i.f(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                r5 = 0
                if (r4 >= r2) goto L42
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = t9.i.b(r7, r8)
                if (r7 == 0) goto L3b
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                t9.i.f(r7, r8)
                java.lang.Object r7 = i9.g.h(r7)
                boolean r7 = t9.i.b(r7, r0)
                if (r7 == 0) goto L3b
                r7 = 1
                goto L3c
            L3b:
                r7 = 0
            L3c:
                if (r7 == 0) goto L3f
                goto L43
            L3f:
                int r4 = r4 + 1
                goto L15
            L42:
                r6 = r5
            L43:
                n9.a.C0297a.f17330b = r6
                int r0 = r1.length
            L46:
                if (r3 >= r0) goto L5b
                r2 = r1[r3]
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = t9.i.b(r4, r6)
                if (r4 == 0) goto L58
                r5 = r2
                goto L5b
            L58:
                int r3 = r3 + 1
                goto L46
            L5b:
                n9.a.C0297a.f17331c = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: n9.a.C0297a.<clinit>():void");
        }
    }

    public void a(Throwable th, Throwable th2) {
        i.g(th, "cause");
        i.g(th2, "exception");
        Method method = C0297a.f17330b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public w9.c b() {
        return new w9.b();
    }
}
