package com.fasterxml.jackson.databind.ser.std;

import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class n extends b {
    public n(k3.j jVar) {
        super(EnumSet.class, jVar, true, (w3.h) null, (k3.o) null);
    }

    @Override // a4.h
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public n c(w3.h hVar) {
        return this;
    }

    @Override // k3.o
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean isEmpty(k3.c0 c0Var, EnumSet enumSet) {
        return enumSet.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final void serialize(EnumSet enumSet, c3.h hVar, k3.c0 c0Var) {
        int size = enumSet.size();
        if (size == 1 && ((this.f6659d == null && c0Var.m0(k3.b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this.f6659d == Boolean.TRUE)) {
            g(enumSet, hVar, c0Var);
            return;
        }
        hVar.u0(enumSet, size);
        g(enumSet, hVar, c0Var);
        hVar.V();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void g(EnumSet enumSet, c3.h hVar, k3.c0 c0Var) {
        k3.o oVar = this.f6661f;
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            Enum r12 = (Enum) it.next();
            if (oVar == null) {
                oVar = c0Var.G(r12.getDeclaringClass(), this.f6657b);
            }
            oVar.serialize(r12, hVar, c0Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.b
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public n h(k3.d dVar, w3.h hVar, k3.o oVar, Boolean bool) {
        return new n(this, dVar, hVar, oVar, bool);
    }

    public n(n nVar, k3.d dVar, w3.h hVar, k3.o oVar, Boolean bool) {
        super(nVar, dVar, hVar, oVar, bool);
    }
}
