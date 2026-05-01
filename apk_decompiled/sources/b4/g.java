package b4;

import java.util.Iterator;
import k3.c0;

/* loaded from: classes.dex */
public class g extends com.fasterxml.jackson.databind.ser.std.b {
    public g(k3.j jVar, boolean z10, w3.h hVar) {
        super(Iterator.class, jVar, z10, hVar, (k3.o) null);
    }

    @Override // a4.h
    public a4.h c(w3.h hVar) {
        return new g(this, this.f6657b, hVar, this.f6661f, this.f6659d);
    }

    public void i(Iterator it, c3.h hVar, c0 c0Var) {
        w3.h hVar2 = this.f6660e;
        k kVar = this.f6662g;
        do {
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
        } while (it.hasNext());
    }

    @Override // k3.o
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean isEmpty(c0 c0Var, Iterator it) {
        return !it.hasNext();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final void serialize(Iterator it, c3.h hVar, c0 c0Var) {
        hVar.t0(it);
        g(it, hVar, c0Var);
        hVar.V();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void g(Iterator it, c3.h hVar, c0 c0Var) {
        if (it.hasNext()) {
            k3.o oVar = this.f6661f;
            if (oVar == null) {
                i(it, hVar, c0Var);
                return;
            }
            w3.h hVar2 = this.f6660e;
            do {
                Object next = it.next();
                if (next == null) {
                    c0Var.E(hVar);
                } else if (hVar2 == null) {
                    oVar.serialize(next, hVar, c0Var);
                } else {
                    oVar.serializeWithType(next, hVar, c0Var, hVar2);
                }
            } while (it.hasNext());
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.b
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public g h(k3.d dVar, w3.h hVar, k3.o oVar, Boolean bool) {
        return new g(this, dVar, hVar, oVar, bool);
    }

    public g(g gVar, k3.d dVar, w3.h hVar, k3.o oVar, Boolean bool) {
        super(gVar, dVar, hVar, oVar, bool);
    }
}
