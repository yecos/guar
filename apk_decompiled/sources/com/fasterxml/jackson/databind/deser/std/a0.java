package com.fasterxml.jackson.databind.deser.std;

/* loaded from: classes.dex */
public class a0 extends b0 implements n3.i, n3.r {

    /* renamed from: a, reason: collision with root package name */
    public final d4.j f6495a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.j f6496b;

    /* renamed from: c, reason: collision with root package name */
    public final k3.k f6497c;

    public a0(d4.j jVar) {
        super(Object.class);
        this.f6495a = jVar;
        this.f6496b = null;
        this.f6497c = null;
    }

    public Object a(c3.k kVar, k3.g gVar, Object obj) {
        throw new UnsupportedOperationException(String.format("Cannot update object of type %s (using deserializer for type %s)" + obj.getClass().getName(), this.f6496b));
    }

    public Object b(Object obj) {
        return this.f6495a.convert(obj);
    }

    public a0 c(d4.j jVar, k3.j jVar2, k3.k kVar) {
        d4.h.n0(a0.class, this, "withDelegate");
        return new a0(jVar, jVar2, kVar);
    }

    @Override // n3.i
    public k3.k createContextual(k3.g gVar, k3.d dVar) {
        k3.k kVar = this.f6497c;
        if (kVar != null) {
            k3.k Z = gVar.Z(kVar, dVar, this.f6496b);
            return Z != this.f6497c ? c(this.f6495a, this.f6496b, Z) : this;
        }
        k3.j b10 = this.f6495a.b(gVar.l());
        return c(this.f6495a, b10, gVar.D(b10, dVar));
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar) {
        Object deserialize = this.f6497c.deserialize(kVar, gVar);
        if (deserialize == null) {
            return null;
        }
        return b(deserialize);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        Object deserialize = this.f6497c.deserialize(kVar, gVar);
        if (deserialize == null) {
            return null;
        }
        return b(deserialize);
    }

    @Override // k3.k
    public k3.k getDelegatee() {
        return this.f6497c;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Class handledType() {
        return this.f6497c.handledType();
    }

    @Override // k3.k
    public c4.f logicalType() {
        return this.f6497c.logicalType();
    }

    @Override // n3.r
    public void resolve(k3.g gVar) {
        Object obj = this.f6497c;
        if (obj == null || !(obj instanceof n3.r)) {
            return;
        }
        ((n3.r) obj).resolve(gVar);
    }

    @Override // k3.k
    public Boolean supportsUpdate(k3.f fVar) {
        return this.f6497c.supportsUpdate(fVar);
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar, Object obj) {
        if (this.f6496b.q().isAssignableFrom(obj.getClass())) {
            return this.f6497c.deserialize(kVar, gVar, obj);
        }
        return a(kVar, gVar, obj);
    }

    public a0(d4.j jVar, k3.j jVar2, k3.k kVar) {
        super(jVar2);
        this.f6495a = jVar;
        this.f6496b = jVar2;
        this.f6497c = kVar;
    }
}
