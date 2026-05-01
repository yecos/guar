package com.fasterxml.jackson.databind.deser.std;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class b extends e0 {
    public b() {
        super(AtomicBoolean.class);
    }

    @Override // k3.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AtomicBoolean deserialize(c3.k kVar, k3.g gVar) {
        c3.n n10 = kVar.n();
        if (n10 == c3.n.VALUE_TRUE) {
            return new AtomicBoolean(true);
        }
        if (n10 == c3.n.VALUE_FALSE) {
            return new AtomicBoolean(false);
        }
        Boolean _parseBoolean = _parseBoolean(kVar, gVar, AtomicBoolean.class);
        if (_parseBoolean == null) {
            return null;
        }
        return new AtomicBoolean(_parseBoolean.booleanValue());
    }

    @Override // k3.k
    public Object getEmptyValue(k3.g gVar) {
        return new AtomicBoolean(false);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
    public c4.f logicalType() {
        return c4.f.Boolean;
    }
}
