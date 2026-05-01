package com.fasterxml.jackson.databind.deser.std;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes.dex */
public class a extends h {
    public a(k3.j jVar, k3.k kVar, w3.e eVar, n3.w wVar) {
        super(jVar, kVar, eVar, wVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.h
    public Collection c(c3.k kVar, k3.g gVar, Collection collection) {
        if (collection == null) {
            collection = new ArrayList();
        }
        Collection c10 = super.c(kVar, gVar, collection);
        return c10.isEmpty() ? new ArrayBlockingQueue(1, false) : new ArrayBlockingQueue(c10.size(), false, c10);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.h, com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return eVar.d(kVar, gVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.h
    public Collection g(k3.g gVar) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.h
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public a k(k3.k kVar, k3.k kVar2, w3.e eVar, n3.q qVar, Boolean bool) {
        return new a(this.f6549a, kVar2, eVar, this.f6539g, kVar, qVar, bool);
    }

    public a(k3.j jVar, k3.k kVar, w3.e eVar, n3.w wVar, k3.k kVar2, n3.q qVar, Boolean bool) {
        super(jVar, kVar, eVar, wVar, kVar2, qVar, bool);
    }
}
