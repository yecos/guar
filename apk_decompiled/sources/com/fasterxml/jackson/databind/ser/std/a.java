package com.fasterxml.jackson.databind.ser.std;

import b3.k;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class a extends a4.h implements a4.i {

    /* renamed from: a, reason: collision with root package name */
    public final k3.d f6653a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f6654b;

    public a(Class cls) {
        super(cls);
        this.f6653a = null;
        this.f6654b = null;
    }

    public k3.o b(k3.c0 c0Var, k3.d dVar) {
        k.d findFormatOverrides;
        if (dVar != null && (findFormatOverrides = findFormatOverrides(c0Var, dVar, handledType())) != null) {
            Boolean e10 = findFormatOverrides.e(k.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
            if (!Objects.equals(e10, this.f6654b)) {
                return f(dVar, e10);
            }
        }
        return this;
    }

    public final boolean e(k3.c0 c0Var) {
        Boolean bool = this.f6654b;
        return bool == null ? c0Var.m0(k3.b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : bool.booleanValue();
    }

    public abstract k3.o f(k3.d dVar, Boolean bool);

    public abstract void g(Object obj, c3.h hVar, k3.c0 c0Var);

    @Override // k3.o
    public final void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        i3.b g10 = hVar2.g(hVar, hVar2.d(obj, c3.n.START_ARRAY));
        hVar.z(obj);
        g(obj, hVar, c0Var);
        hVar2.h(hVar, g10);
    }

    public a(a aVar, k3.d dVar, Boolean bool) {
        super(aVar._handledType, false);
        this.f6653a = dVar;
        this.f6654b = bool;
    }
}
