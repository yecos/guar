package com.fasterxml.jackson.databind.deser.std;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class i extends b0 {

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f6549a;

    /* renamed from: b, reason: collision with root package name */
    public final n3.q f6550b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6551c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f6552d;

    public i(k3.j jVar, n3.q qVar, Boolean bool) {
        super(jVar);
        this.f6549a = jVar;
        this.f6552d = bool;
        this.f6550b = qVar;
        this.f6551c = o3.q.b(qVar);
    }

    public abstract k3.k a();

    public Object b(k3.g gVar, Throwable th, Object obj, String str) {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        d4.h.h0(th);
        if (gVar != null && !gVar.n0(k3.h.WRAP_EXCEPTIONS)) {
            d4.h.j0(th);
        }
        if (!(th instanceof IOException) || (th instanceof k3.l)) {
            throw k3.l.q(th, obj, (String) d4.h.Y(str, "N/A"));
        }
        throw ((IOException) th);
    }

    @Override // k3.k
    public n3.t findBackReference(String str) {
        k3.k a10 = a();
        if (a10 != null) {
            return a10.findBackReference(str);
        }
        throw new IllegalArgumentException(String.format("Cannot handle managed/back reference '%s': type: container deserializer of type %s returned null for 'getContentDeserializer()'", str, getClass().getName()));
    }

    @Override // k3.k
    public d4.a getEmptyAccessPattern() {
        return d4.a.DYNAMIC;
    }

    @Override // k3.k
    public Object getEmptyValue(k3.g gVar) {
        n3.w valueInstantiator = getValueInstantiator();
        if (valueInstantiator == null || !valueInstantiator.j()) {
            k3.j valueType = getValueType();
            gVar.q(valueType, String.format("Cannot create empty instance of %s, no default Creator", valueType));
        }
        try {
            return valueInstantiator.x(gVar);
        } catch (IOException e10) {
            return d4.h.g0(gVar, e10);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0
    public k3.j getValueType() {
        return this.f6549a;
    }

    @Override // k3.k
    public Boolean supportsUpdate(k3.f fVar) {
        return Boolean.TRUE;
    }

    public i(k3.j jVar) {
        this(jVar, (n3.q) null, (Boolean) null);
    }

    public i(i iVar) {
        this(iVar, iVar.f6550b, iVar.f6552d);
    }

    public i(i iVar, n3.q qVar, Boolean bool) {
        super(iVar.f6549a);
        this.f6549a = iVar.f6549a;
        this.f6550b = qVar;
        this.f6552d = bool;
        this.f6551c = o3.q.b(qVar);
    }
}
