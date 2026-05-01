package x3;

/* loaded from: classes.dex */
public abstract class t extends w3.h {

    /* renamed from: a, reason: collision with root package name */
    public final w3.f f19454a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.d f19455b;

    public t(w3.f fVar, k3.d dVar) {
        this.f19454a = fVar;
        this.f19455b = dVar;
    }

    @Override // w3.h
    public String b() {
        return null;
    }

    @Override // w3.h
    public i3.b g(c3.h hVar, i3.b bVar) {
        i(bVar);
        return hVar.D0(bVar);
    }

    @Override // w3.h
    public i3.b h(c3.h hVar, i3.b bVar) {
        return hVar.E0(bVar);
    }

    public void i(i3.b bVar) {
        if (bVar.f14300c == null) {
            Object obj = bVar.f14298a;
            Class cls = bVar.f14299b;
            bVar.f14300c = cls == null ? k(obj) : l(obj, cls);
        }
    }

    public void j(Object obj) {
    }

    public String k(Object obj) {
        String a10 = this.f19454a.a(obj);
        if (a10 == null) {
            j(obj);
        }
        return a10;
    }

    public String l(Object obj, Class cls) {
        String d10 = this.f19454a.d(obj, cls);
        if (d10 == null) {
            j(obj);
        }
        return d10;
    }
}
