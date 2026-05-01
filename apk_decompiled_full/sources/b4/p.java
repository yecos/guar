package b4;

import com.fasterxml.jackson.databind.ser.std.i0;
import java.lang.reflect.Type;
import k3.b0;
import k3.c0;

/* loaded from: classes.dex */
public class p extends i0 {
    public p() {
        super(Object.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        fVar.c(jVar);
    }

    public void c(c0 c0Var, Object obj) {
        c0Var.p(handledType(), String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)", obj.getClass().getName()));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(c0 c0Var, Type type) {
        return null;
    }

    @Override // k3.o
    public boolean isEmpty(c0 c0Var, Object obj) {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void serialize(Object obj, c3.h hVar, c0 c0Var) {
        if (c0Var.m0(b0.FAIL_ON_EMPTY_BEANS)) {
            c(c0Var, obj);
        }
        hVar.x0(obj, 0);
        hVar.W();
    }

    @Override // k3.o
    public final void serializeWithType(Object obj, c3.h hVar, c0 c0Var, w3.h hVar2) {
        if (c0Var.m0(b0.FAIL_ON_EMPTY_BEANS)) {
            c(c0Var, obj);
        }
        hVar2.h(hVar, hVar2.g(hVar, hVar2.d(obj, c3.n.START_OBJECT)));
    }

    public p(Class cls) {
        super(cls, false);
    }
}
