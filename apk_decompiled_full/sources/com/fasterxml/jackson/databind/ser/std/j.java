package com.fasterxml.jackson.databind.ser.std;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class j extends b {
    public j(k3.j jVar, boolean z10, w3.h hVar, k3.o oVar) {
        super(Collection.class, jVar, z10, hVar, oVar);
    }

    @Override // a4.h
    public a4.h c(w3.h hVar) {
        return new j(this, this.f6657b, hVar, this.f6661f, this.f6659d);
    }

    @Override // k3.o
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean isEmpty(k3.c0 c0Var, Collection collection) {
        return collection.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void serialize(Collection collection, c3.h hVar, k3.c0 c0Var) {
        int size = collection.size();
        if (size == 1 && ((this.f6659d == null && c0Var.m0(k3.b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this.f6659d == Boolean.TRUE)) {
            g(collection, hVar, c0Var);
            return;
        }
        hVar.u0(collection, size);
        g(collection, hVar, c0Var);
        hVar.V();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void g(Collection collection, c3.h hVar, k3.c0 c0Var) {
        hVar.z(collection);
        k3.o oVar = this.f6661f;
        if (oVar != null) {
            l(collection, hVar, c0Var, oVar);
            return;
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            b4.k kVar = this.f6662g;
            w3.h hVar2 = this.f6660e;
            int i10 = 0;
            do {
                try {
                    Object next = it.next();
                    if (next == null) {
                        c0Var.E(hVar);
                    } else {
                        Class<?> cls = next.getClass();
                        k3.o j10 = kVar.j(cls);
                        if (j10 == null) {
                            j10 = this.f6656a.w() ? f(kVar, c0Var.A(this.f6656a, cls), c0Var) : e(kVar, cls, c0Var);
                            kVar = this.f6662g;
                        }
                        if (hVar2 == null) {
                            j10.serialize(next, hVar, c0Var);
                        } else {
                            j10.serializeWithType(next, hVar, c0Var, hVar2);
                        }
                    }
                    i10++;
                } catch (Exception e10) {
                    wrapAndThrow(c0Var, e10, collection, i10);
                    return;
                }
            } while (it.hasNext());
        }
    }

    public void l(Collection collection, c3.h hVar, k3.c0 c0Var, k3.o oVar) {
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            w3.h hVar2 = this.f6660e;
            int i10 = 0;
            do {
                Object next = it.next();
                if (next == null) {
                    try {
                        c0Var.E(hVar);
                    } catch (Exception e10) {
                        wrapAndThrow(c0Var, e10, collection, i10);
                    }
                } else if (hVar2 == null) {
                    oVar.serialize(next, hVar, c0Var);
                } else {
                    oVar.serializeWithType(next, hVar, c0Var, hVar2);
                }
                i10++;
            } while (it.hasNext());
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.b
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public j h(k3.d dVar, w3.h hVar, k3.o oVar, Boolean bool) {
        return new j(this, dVar, hVar, oVar, bool);
    }

    public j(j jVar, k3.d dVar, w3.h hVar, k3.o oVar, Boolean bool) {
        super(jVar, dVar, hVar, oVar, bool);
    }
}
