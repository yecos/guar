package k3;

import java.util.Collection;

/* loaded from: classes.dex */
public abstract class k implements n3.q {

    public static abstract class a extends k {
    }

    public abstract Object deserialize(c3.k kVar, g gVar);

    public Object deserialize(c3.k kVar, g gVar, Object obj) {
        gVar.U(this);
        return deserialize(kVar, gVar);
    }

    public Object deserializeWithType(c3.k kVar, g gVar, w3.e eVar) {
        return eVar.c(kVar, gVar);
    }

    public n3.t findBackReference(String str) {
        throw new IllegalArgumentException("Cannot handle managed/back reference '" + str + "': type: value deserializer of type " + getClass().getName() + " does not support them");
    }

    public k getDelegatee() {
        return null;
    }

    public d4.a getEmptyAccessPattern() {
        return d4.a.DYNAMIC;
    }

    public Object getEmptyValue(g gVar) {
        return getNullValue(gVar);
    }

    public Collection<Object> getKnownPropertyNames() {
        return null;
    }

    public d4.a getNullAccessPattern() {
        return d4.a.CONSTANT;
    }

    @Deprecated
    public Object getNullValue() {
        return null;
    }

    public o3.s getObjectIdReader() {
        return null;
    }

    public Class handledType() {
        return null;
    }

    public boolean isCachable() {
        return false;
    }

    public c4.f logicalType() {
        return null;
    }

    public k replaceDelegatee(k kVar) {
        throw new UnsupportedOperationException();
    }

    public Boolean supportsUpdate(f fVar) {
        return null;
    }

    public k unwrappingDeserializer(d4.q qVar) {
        return this;
    }

    public Object deserializeWithType(c3.k kVar, g gVar, w3.e eVar, Object obj) {
        gVar.U(this);
        return deserializeWithType(kVar, gVar, eVar);
    }

    @Deprecated
    public Object getEmptyValue() {
        return getNullValue();
    }

    @Override // n3.q
    public Object getNullValue(g gVar) {
        return getNullValue();
    }
}
