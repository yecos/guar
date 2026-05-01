package x3;

import b3.e0;

/* loaded from: classes.dex */
public class f extends t {

    /* renamed from: c, reason: collision with root package name */
    public final String f19420c;

    public f(w3.f fVar, k3.d dVar, String str) {
        super(fVar, dVar);
        this.f19420c = str;
    }

    @Override // x3.t, w3.h
    public String b() {
        return this.f19420c;
    }

    @Override // w3.h
    public e0.a c() {
        return e0.a.EXTERNAL_PROPERTY;
    }

    @Override // w3.h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public f a(k3.d dVar) {
        return this.f19455b == dVar ? this : new f(this.f19454a, dVar, this.f19420c);
    }
}
