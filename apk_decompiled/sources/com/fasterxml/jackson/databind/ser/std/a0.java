package com.fasterxml.jackson.databind.ser.std;

import k3.n;

/* loaded from: classes.dex */
public class a0 extends i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f6655a = new a0();

    public a0() {
        super(k3.n.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        fVar.c(jVar);
    }

    @Override // k3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isEmpty(k3.c0 c0Var, k3.n nVar) {
        if (nVar instanceof n.a) {
            return ((n.a) nVar).f(c0Var);
        }
        return false;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void serialize(k3.n nVar, c3.h hVar, k3.c0 c0Var) {
        nVar.d(hVar, c0Var);
    }

    @Override // k3.o
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final void serializeWithType(k3.n nVar, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        nVar.e(hVar, c0Var, hVar2);
    }
}
