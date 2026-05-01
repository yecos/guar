package b4;

import k3.c0;

/* loaded from: classes.dex */
public final class o extends k3.o implements a4.i {

    /* renamed from: a, reason: collision with root package name */
    public final w3.h f4637a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.o f4638b;

    public o(w3.h hVar, k3.o oVar) {
        this.f4637a = hVar;
        this.f4638b = oVar;
    }

    @Override // a4.i
    public k3.o b(c0 c0Var, k3.d dVar) {
        k3.o oVar = this.f4638b;
        if (oVar instanceof a4.i) {
            oVar = c0Var.i0(oVar, dVar);
        }
        return oVar == this.f4638b ? this : new o(this.f4637a, oVar);
    }

    @Override // k3.o
    public Class handledType() {
        return Object.class;
    }

    @Override // k3.o
    public void serialize(Object obj, c3.h hVar, c0 c0Var) {
        this.f4638b.serializeWithType(obj, hVar, c0Var, this.f4637a);
    }

    @Override // k3.o
    public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, w3.h hVar2) {
        this.f4638b.serializeWithType(obj, hVar, c0Var, hVar2);
    }
}
