package k3;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class o {

    public static abstract class a extends o {
    }

    public void acceptJsonFormatVisitor(u3.f fVar, j jVar) {
        fVar.c(jVar);
    }

    public o getDelegatee() {
        return null;
    }

    public abstract Class handledType();

    public boolean isEmpty(c0 c0Var, Object obj) {
        return obj == null;
    }

    public boolean isUnwrappingSerializer() {
        return false;
    }

    public Iterator<a4.n> properties() {
        return d4.h.n();
    }

    public o replaceDelegatee(o oVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void serialize(Object obj, c3.h hVar, c0 c0Var);

    public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, w3.h hVar2) {
        Class<?> handledType = handledType();
        if (handledType == null) {
            handledType = obj.getClass();
        }
        c0Var.p(handledType, String.format("Type id handling not implemented for type %s (by serializer of type %s)", handledType.getName(), getClass().getName()));
    }

    public o unwrappingSerializer(d4.q qVar) {
        return this;
    }

    public boolean usesObjectId() {
        return false;
    }

    public o withFilterId(Object obj) {
        return this;
    }

    @Deprecated
    public boolean isEmpty(Object obj) {
        return isEmpty(null, obj);
    }
}
