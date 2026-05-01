package com.fasterxml.jackson.databind.deser.std;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class c extends e0 {
    public c() {
        super(AtomicInteger.class);
    }

    @Override // k3.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AtomicInteger deserialize(c3.k kVar, k3.g gVar) {
        if (kVar.m0()) {
            return new AtomicInteger(kVar.P());
        }
        Integer _parseInteger = _parseInteger(kVar, gVar, AtomicInteger.class);
        if (_parseInteger == null) {
            return null;
        }
        return new AtomicInteger(_parseInteger.intValue());
    }

    @Override // k3.k
    public Object getEmptyValue(k3.g gVar) {
        return new AtomicInteger();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
    public c4.f logicalType() {
        return c4.f.Integer;
    }
}
