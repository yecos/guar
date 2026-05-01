package x3;

import b3.e0;

/* loaded from: classes.dex */
public class h extends b {

    /* renamed from: c, reason: collision with root package name */
    public final String f19423c;

    public h(w3.f fVar, k3.d dVar, String str) {
        super(fVar, dVar);
        this.f19423c = str;
    }

    @Override // x3.t, w3.h
    public String b() {
        return this.f19423c;
    }

    @Override // x3.b, w3.h
    public e0.a c() {
        return e0.a.PROPERTY;
    }

    @Override // x3.b
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public h a(k3.d dVar) {
        return this.f19455b == dVar ? this : new h(this.f19454a, dVar, this.f19423c);
    }
}
