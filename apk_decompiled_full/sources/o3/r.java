package o3;

import java.io.Serializable;

/* loaded from: classes.dex */
public class r implements n3.q, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final k3.x f17560a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.j f17561b;

    public r(k3.x xVar, k3.j jVar) {
        this.f17560a = xVar;
        this.f17561b = jVar;
    }

    public static r a(k3.d dVar) {
        return b(dVar, dVar.getType());
    }

    public static r b(k3.d dVar, k3.j jVar) {
        return new r(dVar.c(), jVar);
    }

    public static r c(k3.j jVar) {
        return new r(null, jVar);
    }

    @Override // n3.q
    public Object getNullValue(k3.g gVar) {
        throw p3.d.v(gVar, this.f17560a, this.f17561b);
    }
}
