package o3;

import java.io.Serializable;
import java.util.Collection;

/* loaded from: classes.dex */
public final class b0 extends k3.k implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final w3.e f17484a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.k f17485b;

    public b0(w3.e eVar, k3.k kVar) {
        this.f17484a = eVar;
        this.f17485b = kVar;
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar) {
        return this.f17485b.deserializeWithType(kVar, gVar, this.f17484a);
    }

    @Override // k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }

    @Override // k3.k
    public k3.k getDelegatee() {
        return this.f17485b.getDelegatee();
    }

    @Override // k3.k
    public Object getEmptyValue(k3.g gVar) {
        return this.f17485b.getEmptyValue(gVar);
    }

    @Override // k3.k
    public Collection getKnownPropertyNames() {
        return this.f17485b.getKnownPropertyNames();
    }

    @Override // k3.k, n3.q
    public Object getNullValue(k3.g gVar) {
        return this.f17485b.getNullValue(gVar);
    }

    @Override // k3.k
    public Class handledType() {
        return this.f17485b.handledType();
    }

    @Override // k3.k
    public c4.f logicalType() {
        return this.f17485b.logicalType();
    }

    @Override // k3.k
    public Boolean supportsUpdate(k3.f fVar) {
        return this.f17485b.supportsUpdate(fVar);
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar, Object obj) {
        return this.f17485b.deserialize(kVar, gVar, obj);
    }
}
