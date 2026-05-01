package com.fasterxml.jackson.databind.ser.std;

import java.util.TimeZone;

/* loaded from: classes.dex */
public class k0 extends h0 {
    public k0() {
        super(TimeZone.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void serialize(TimeZone timeZone, c3.h hVar, k3.c0 c0Var) {
        hVar.z0(timeZone.getID());
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, k3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void serializeWithType(TimeZone timeZone, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        i3.b g10 = hVar2.g(hVar, hVar2.f(timeZone, TimeZone.class, c3.n.VALUE_STRING));
        serialize(timeZone, hVar, c0Var);
        hVar2.h(hVar, g10);
    }
}
