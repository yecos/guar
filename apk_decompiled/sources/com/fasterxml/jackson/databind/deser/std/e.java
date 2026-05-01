package com.fasterxml.jackson.databind.deser.std;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class e extends y {
    public e(k3.j jVar, n3.w wVar, w3.e eVar, k3.k kVar) {
        super(jVar, wVar, eVar, kVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.y, k3.k, n3.q
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AtomicReference getNullValue(k3.g gVar) {
        return new AtomicReference(this.f6652d.getNullValue(gVar));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.y
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Object a(AtomicReference atomicReference) {
        return atomicReference.get();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.y
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public AtomicReference b(Object obj) {
        return new AtomicReference(obj);
    }

    @Override // k3.k
    public Object getEmptyValue(k3.g gVar) {
        return getNullValue(gVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.y
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public AtomicReference c(AtomicReference atomicReference, Object obj) {
        atomicReference.set(obj);
        return atomicReference;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.y
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public e d(w3.e eVar, k3.k kVar) {
        return new e(this.f6649a, this.f6650b, eVar, kVar);
    }

    @Override // k3.k
    public Boolean supportsUpdate(k3.f fVar) {
        return Boolean.TRUE;
    }
}
