package com.fasterxml.jackson.databind.ser.std;

import java.util.Iterator;

/* loaded from: classes.dex */
public class r extends b {
    public r(k3.j jVar, boolean z10, w3.h hVar) {
        super(Iterable.class, jVar, z10, hVar, (k3.o) null);
    }

    @Override // a4.h
    public a4.h c(w3.h hVar) {
        return new r(this, this.f6657b, hVar, this.f6661f, this.f6659d);
    }

    public boolean i(Iterable iterable) {
        if (iterable == null) {
            return false;
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        return !it.hasNext();
    }

    @Override // k3.o
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean isEmpty(k3.c0 c0Var, Iterable iterable) {
        return !iterable.iterator().hasNext();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final void serialize(Iterable iterable, c3.h hVar, k3.c0 c0Var) {
        if (((this.f6659d == null && c0Var.m0(k3.b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this.f6659d == Boolean.TRUE) && i(iterable)) {
            g(iterable, hVar, c0Var);
            return;
        }
        hVar.t0(iterable);
        g(iterable, hVar, c0Var);
        hVar.V();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void g(Iterable iterable, c3.h hVar, k3.c0 c0Var) {
        k3.o oVar;
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            w3.h hVar2 = this.f6660e;
            Class<?> cls = null;
            k3.o oVar2 = null;
            do {
                Object next = it.next();
                if (next == null) {
                    c0Var.E(hVar);
                } else {
                    k3.o oVar3 = this.f6661f;
                    if (oVar3 == null) {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            oVar2 = c0Var.S(cls2, this.f6657b);
                            cls = cls2;
                        }
                        oVar = oVar2;
                    } else {
                        oVar = oVar2;
                        oVar2 = oVar3;
                    }
                    if (hVar2 == null) {
                        oVar2.serialize(next, hVar, c0Var);
                    } else {
                        oVar2.serializeWithType(next, hVar, c0Var, hVar2);
                    }
                    oVar2 = oVar;
                }
            } while (it.hasNext());
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.b
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public r h(k3.d dVar, w3.h hVar, k3.o oVar, Boolean bool) {
        return new r(this, dVar, hVar, oVar, bool);
    }

    public r(r rVar, k3.d dVar, w3.h hVar, k3.o oVar, Boolean bool) {
        super(rVar, dVar, hVar, oVar, bool);
    }
}
