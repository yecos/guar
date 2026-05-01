package b4;

import java.util.Set;
import k3.b0;
import k3.c0;

/* loaded from: classes.dex */
public class s extends com.fasterxml.jackson.databind.ser.std.d {

    /* renamed from: k, reason: collision with root package name */
    public final d4.q f4642k;

    public s(com.fasterxml.jackson.databind.ser.std.d dVar, d4.q qVar) {
        super(dVar, qVar);
        this.f4642k = qVar;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d
    public com.fasterxml.jackson.databind.ser.std.d g() {
        return this;
    }

    @Override // k3.o
    public boolean isUnwrappingSerializer() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d
    public com.fasterxml.jackson.databind.ser.std.d l(Set set, Set set2) {
        return new s(this, set, set2);
    }

    @Override // k3.o
    /* renamed from: m */
    public com.fasterxml.jackson.databind.ser.std.d withFilterId(Object obj) {
        return new s(this, this.f6679g, obj);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d
    public com.fasterxml.jackson.databind.ser.std.d n(i iVar) {
        return new s(this, iVar);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d
    public com.fasterxml.jackson.databind.ser.std.d o(a4.c[] cVarArr, a4.c[] cVarArr2) {
        return new s(this, cVarArr, cVarArr2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public final void serialize(Object obj, c3.h hVar, c0 c0Var) {
        hVar.z(obj);
        if (this.f6679g != null) {
            e(obj, hVar, c0Var, false);
        } else if (this.f6677e != null) {
            k(obj, hVar, c0Var);
        } else {
            j(obj, hVar, c0Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d, k3.o
    public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, w3.h hVar2) {
        if (c0Var.m0(b0.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)) {
            c0Var.p(handledType(), "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
        }
        hVar.z(obj);
        if (this.f6679g != null) {
            d(obj, hVar, c0Var, hVar2);
        } else if (this.f6677e != null) {
            k(obj, hVar, c0Var);
        } else {
            j(obj, hVar, c0Var);
        }
    }

    public String toString() {
        return "UnwrappingBeanSerializer for " + handledType().getName();
    }

    @Override // k3.o
    public k3.o unwrappingSerializer(d4.q qVar) {
        return new s(this, qVar);
    }

    public s(s sVar, i iVar) {
        super(sVar, iVar);
        this.f4642k = sVar.f4642k;
    }

    public s(s sVar, i iVar, Object obj) {
        super(sVar, iVar, obj);
        this.f4642k = sVar.f4642k;
    }

    public s(s sVar, Set set, Set set2) {
        super(sVar, set, set2);
        this.f4642k = sVar.f4642k;
    }

    public s(s sVar, a4.c[] cVarArr, a4.c[] cVarArr2) {
        super(sVar, cVarArr, cVarArr2);
        this.f4642k = sVar.f4642k;
    }
}
