package b4;

import java.util.Set;
import k3.b0;
import k3.c0;
import k3.l;

/* loaded from: classes.dex */
public class b extends com.fasterxml.jackson.databind.ser.std.d {

    /* renamed from: k, reason: collision with root package name */
    public final com.fasterxml.jackson.databind.ser.std.d f4585k;

    public b(com.fasterxml.jackson.databind.ser.std.d dVar) {
        super(dVar, (i) null);
        this.f4585k = dVar;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d
    public com.fasterxml.jackson.databind.ser.std.d g() {
        return this;
    }

    @Override // k3.o
    public boolean isUnwrappingSerializer() {
        return false;
    }

    @Override // k3.o
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.ser.std.d withFilterId(Object obj) {
        return new b(this, this.f6679g, obj);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d
    public com.fasterxml.jackson.databind.ser.std.d n(i iVar) {
        return this.f4585k.n(iVar);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d
    public com.fasterxml.jackson.databind.ser.std.d o(a4.c[] cVarArr, a4.c[] cVarArr2) {
        return this;
    }

    public final boolean p(c0 c0Var) {
        return ((this.f6675c == null || c0Var.V() == null) ? this.f6674b : this.f6675c).length == 1;
    }

    public final void q(Object obj, c3.h hVar, c0 c0Var) {
        a4.c[] cVarArr = (this.f6675c == null || c0Var.V() == null) ? this.f6674b : this.f6675c;
        int i10 = 0;
        try {
            int length = cVarArr.length;
            while (i10 < length) {
                a4.c cVar = cVarArr[i10];
                if (cVar == null) {
                    hVar.a0();
                } else {
                    cVar.x(obj, hVar, c0Var);
                }
                i10++;
            }
        } catch (Exception e10) {
            wrapAndThrow(c0Var, e10, obj, i10 != cVarArr.length ? cVarArr[i10].getName() : "[anySetter]");
        } catch (StackOverflowError e11) {
            k3.l h10 = k3.l.h(hVar, "Infinite recursion (StackOverflowError)", e11);
            h10.o(new l.a(obj, i10 != cVarArr.length ? cVarArr[i10].getName() : "[anySetter]"));
            throw h10;
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public b l(Set set, Set set2) {
        return new b(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public final void serialize(Object obj, c3.h hVar, c0 c0Var) {
        if (c0Var.m0(b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && p(c0Var)) {
            q(obj, hVar, c0Var);
            return;
        }
        hVar.t0(obj);
        q(obj, hVar, c0Var);
        hVar.V();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.d, k3.o
    public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, w3.h hVar2) {
        if (this.f6679g != null) {
            d(obj, hVar, c0Var, hVar2);
            return;
        }
        i3.b f10 = f(hVar2, obj, c3.n.START_ARRAY);
        hVar2.g(hVar, f10);
        hVar.z(obj);
        q(obj, hVar, c0Var);
        hVar2.h(hVar, f10);
    }

    public String toString() {
        return "BeanAsArraySerializer for " + handledType().getName();
    }

    @Override // k3.o
    public k3.o unwrappingSerializer(d4.q qVar) {
        return this.f4585k.unwrappingSerializer(qVar);
    }

    public b(com.fasterxml.jackson.databind.ser.std.d dVar, Set set, Set set2) {
        super(dVar, set, set2);
        this.f4585k = dVar;
    }

    public b(com.fasterxml.jackson.databind.ser.std.d dVar, i iVar, Object obj) {
        super(dVar, iVar, obj);
        this.f4585k = dVar;
    }
}
