package t9;

/* loaded from: classes3.dex */
public class y {
    public z9.b a(Class cls) {
        return new e(cls);
    }

    public z9.c b(Class cls, String str) {
        return new n(cls, str);
    }

    public z9.d c(k kVar) {
        return kVar;
    }

    public z9.e d(o oVar) {
        return oVar;
    }

    public z9.f e(q qVar) {
        return qVar;
    }

    public String f(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String g(j jVar) {
        return f(jVar);
    }
}
