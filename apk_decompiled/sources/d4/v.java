package d4;

import java.io.Serializable;

/* loaded from: classes.dex */
public class v implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient n f12578a = new n(20, 200);

    public k3.x a(Class cls, m3.m mVar) {
        c4.b bVar = new c4.b(cls);
        k3.x xVar = (k3.x) this.f12578a.get(bVar);
        if (xVar != null) {
            return xVar;
        }
        k3.x S = mVar.g().S(mVar.A(cls).u());
        if (S == null || !S.e()) {
            S = k3.x.a(cls.getSimpleName());
        }
        this.f12578a.a(bVar, S);
        return S;
    }

    public k3.x b(k3.j jVar, m3.m mVar) {
        return a(jVar.q(), mVar);
    }
}
