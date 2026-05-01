package o3;

/* loaded from: classes.dex */
public class c0 extends com.fasterxml.jackson.databind.deser.std.b0 {

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f17495a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17496b;

    public c0(k3.j jVar, String str) {
        super(jVar);
        this.f17495a = jVar;
        this.f17496b = str;
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar) {
        gVar.q(this.f17495a, this.f17496b);
        return null;
    }
}
