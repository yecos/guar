package a4;

import java.util.Set;
import k3.c0;

/* loaded from: classes.dex */
public class d extends com.fasterxml.jackson.databind.ser.std.d {
    public d(k3.j jVar, e eVar, c[] cVarArr, c[] cVarArr2) {
        super(jVar, eVar, cVarArr, cVarArr2);
    }

    public static d p(k3.j jVar, e eVar) {
        return new d(jVar, eVar, com.fasterxml.jackson.databind.ser.std.d.f6672j, null);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d
    public com.fasterxml.jackson.databind.ser.std.d g() {
        return (this.f6679g == null && this.f6676d == null && this.f6677e == null) ? new b4.b(this) : this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d
    public com.fasterxml.jackson.databind.ser.std.d l(Set set, Set set2) {
        return new d(this, set, set2);
    }

    @Override // k3.o
    /* renamed from: m */
    public com.fasterxml.jackson.databind.ser.std.d withFilterId(Object obj) {
        return new d(this, this.f6679g, obj);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d
    public com.fasterxml.jackson.databind.ser.std.d n(b4.i iVar) {
        return new d(this, iVar, this.f6677e);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d
    public com.fasterxml.jackson.databind.ser.std.d o(c[] cVarArr, c[] cVarArr2) {
        return new d(this, cVarArr, cVarArr2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public final void serialize(Object obj, c3.h hVar, c0 c0Var) {
        if (this.f6679g != null) {
            hVar.z(obj);
            e(obj, hVar, c0Var, true);
            return;
        }
        hVar.w0(obj);
        if (this.f6677e != null) {
            k(obj, hVar, c0Var);
        } else {
            j(obj, hVar, c0Var);
        }
        hVar.W();
    }

    public String toString() {
        return "BeanSerializer for " + handledType().getName();
    }

    @Override // k3.o
    public k3.o unwrappingSerializer(d4.q qVar) {
        return new b4.s(this, qVar);
    }

    public d(com.fasterxml.jackson.databind.ser.std.d dVar, b4.i iVar, Object obj) {
        super(dVar, iVar, obj);
    }

    public d(com.fasterxml.jackson.databind.ser.std.d dVar, Set set, Set set2) {
        super(dVar, set, set2);
    }

    public d(com.fasterxml.jackson.databind.ser.std.d dVar, c[] cVarArr, c[] cVarArr2) {
        super(dVar, cVarArr, cVarArr2);
    }
}
