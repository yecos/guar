package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.std.c0;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class d0 implements n3.p, Serializable {
    public static k3.p b(k3.f fVar, k3.j jVar, k3.k kVar) {
        return new c0.a(jVar.q(), kVar);
    }

    public static k3.p c(d4.k kVar) {
        return new c0.b(kVar, null);
    }

    public static k3.p d(d4.k kVar, r3.j jVar) {
        return new c0.b(kVar, jVar);
    }

    public static k3.p e(k3.f fVar, k3.j jVar) {
        k3.c g02 = fVar.g0(jVar);
        Constructor r10 = g02.r(String.class);
        if (r10 != null) {
            if (fVar.b()) {
                d4.h.g(r10, fVar.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            return new c0.c(r10);
        }
        Method h10 = g02.h(String.class);
        if (h10 == null) {
            return null;
        }
        if (fVar.b()) {
            d4.h.g(h10, fVar.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new c0.d(h10);
    }

    @Override // n3.p
    public k3.p a(k3.j jVar, k3.f fVar, k3.c cVar) {
        Class q10 = jVar.q();
        if (q10.isPrimitive()) {
            q10 = d4.h.o0(q10);
        }
        return c0.g(q10);
    }
}
