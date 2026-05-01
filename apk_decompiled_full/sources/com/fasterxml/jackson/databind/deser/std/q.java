package com.fasterxml.jackson.databind.deser.std;

import n3.w;

/* loaded from: classes.dex */
public class q extends w.a {
    public q() {
        super(c3.i.class);
    }

    public static final int G(Object obj) {
        if (obj == null) {
            return 0;
        }
        return ((Number) obj).intValue();
    }

    public static final long H(Object obj) {
        if (obj == null) {
            return 0L;
        }
        return ((Number) obj).longValue();
    }

    public static n3.j I(String str, k3.j jVar, int i10) {
        return n3.j.O(k3.x.a(str), jVar, null, null, null, null, i10, null, k3.w.f14994h);
    }

    @Override // n3.w
    public n3.t[] E(k3.f fVar) {
        k3.j e10 = fVar.e(Integer.TYPE);
        k3.j e11 = fVar.e(Long.TYPE);
        return new n3.t[]{I("sourceRef", fVar.e(Object.class), 0), I("byteOffset", e11, 1), I("charOffset", e11, 2), I("lineNr", e10, 3), I("columnNr", e10, 4)};
    }

    @Override // n3.w
    public boolean g() {
        return true;
    }

    @Override // n3.w
    public Object t(k3.g gVar, Object[] objArr) {
        return new c3.i(objArr[0], H(objArr[1]), H(objArr[2]), G(objArr[3]), G(objArr[4]));
    }
}
