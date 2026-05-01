package n9;

import i9.g;
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
            Method method;
            Method method2;
            boolean z10;
            Method[] methods = Throwable.class.getMethods();
            i.f(methods, "throwableMethods");
            int length = methods.length;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                method = null;
                if (i11 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i11];
                if (i.b(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    i.f(parameterTypes, "it.parameterTypes");
                    if (i.b(g.h(parameterTypes), Throwable.class)) {
                        z10 = true;
                        if (!z10) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                z10 = false;
                if (!z10) {
                }
            }
            f17330b = method2;
            int length2 = methods.length;
            while (true) {
                if (i10 >= length2) {
                    break;
                }
                Method method3 = methods[i10];
                if (i.b(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i10++;
            }
            f17331c = method;
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
