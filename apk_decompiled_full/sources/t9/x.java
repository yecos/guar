package t9;

/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static final y f18962a;

    /* renamed from: b, reason: collision with root package name */
    public static final z9.b[] f18963b;

    static {
        y yVar = null;
        try {
            yVar = (y) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (yVar == null) {
            yVar = new y();
        }
        f18962a = yVar;
        f18963b = new z9.b[0];
    }

    public static z9.b a(Class cls) {
        return f18962a.a(cls);
    }

    public static z9.c b(Class cls) {
        return f18962a.b(cls, "");
    }

    public static z9.d c(k kVar) {
        return f18962a.c(kVar);
    }

    public static z9.e d(o oVar) {
        return f18962a.d(oVar);
    }

    public static z9.f e(q qVar) {
        return f18962a.e(qVar);
    }

    public static String f(h hVar) {
        return f18962a.f(hVar);
    }

    public static String g(j jVar) {
        return f18962a.g(jVar);
    }
}
