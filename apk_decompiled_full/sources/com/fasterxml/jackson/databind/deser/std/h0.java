package com.fasterxml.jackson.databind.deser.std;

import b3.k;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes.dex */
public final class h0 extends i implements n3.i {

    /* renamed from: e, reason: collision with root package name */
    public final k3.k f6546e;

    /* renamed from: f, reason: collision with root package name */
    public final n3.w f6547f;

    /* renamed from: g, reason: collision with root package name */
    public final k3.k f6548g;

    public h0(k3.j jVar, k3.k kVar, n3.w wVar) {
        this(jVar, wVar, null, kVar, kVar, null);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.i
    public k3.k a() {
        return this.f6546e;
    }

    @Override // k3.k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Collection deserialize(c3.k kVar, k3.g gVar) {
        k3.k kVar2 = this.f6548g;
        return kVar2 != null ? (Collection) this.f6547f.y(gVar, kVar2.deserialize(kVar, gVar)) : deserialize(kVar, gVar, (Collection) this.f6547f.x(gVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003c  */
    @Override // n3.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k3.k createContextual(k3.g gVar, k3.d dVar) {
        k3.k kVar;
        k3.k kVar2;
        k3.k Z;
        n3.w wVar = this.f6547f;
        if (wVar != null) {
            if (wVar.z() != null) {
                kVar = findDeserializer(gVar, this.f6547f.A(gVar.k()), dVar);
            } else if (this.f6547f.C() != null) {
                kVar = findDeserializer(gVar, this.f6547f.D(gVar.k()), dVar);
            }
            kVar2 = this.f6546e;
            k3.j k10 = this.f6549a.k();
            if (kVar2 != null) {
                Z = findConvertingContentDeserializer(gVar, dVar, kVar2);
                if (Z == null) {
                    Z = gVar.D(k10, dVar);
                }
            } else {
                Z = gVar.Z(kVar2, dVar, k10);
            }
            return g(kVar, isDefaultDeserializer(Z) ? null : Z, findContentNullProvider(gVar, dVar, Z), findFormatFeature(gVar, dVar, Collection.class, k.a.ACCEPT_SINGLE_VALUE_AS_ARRAY));
        }
        kVar = null;
        kVar2 = this.f6546e;
        k3.j k102 = this.f6549a.k();
        if (kVar2 != null) {
        }
        return g(kVar, isDefaultDeserializer(Z) ? null : Z, findContentNullProvider(gVar, dVar, Z), findFormatFeature(gVar, dVar, Collection.class, k.a.ACCEPT_SINGLE_VALUE_AS_ARRAY));
    }

    @Override // k3.k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Collection deserialize(c3.k kVar, k3.g gVar, Collection collection) {
        String _parseString;
        if (!kVar.n0()) {
            return f(kVar, gVar, collection);
        }
        k3.k kVar2 = this.f6546e;
        if (kVar2 != null) {
            return e(kVar, gVar, collection, kVar2);
        }
        while (true) {
            try {
                String r02 = kVar.r0();
                if (r02 != null) {
                    collection.add(r02);
                } else {
                    c3.n n10 = kVar.n();
                    if (n10 == c3.n.END_ARRAY) {
                        return collection;
                    }
                    if (n10 != c3.n.VALUE_NULL) {
                        _parseString = _parseString(kVar, gVar);
                    } else if (!this.f6551c) {
                        _parseString = (String) this.f6550b.getNullValue(gVar);
                    }
                    collection.add(_parseString);
                }
            } catch (Exception e10) {
                throw k3.l.p(e10, collection, collection.size());
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return eVar.d(kVar, gVar);
    }

    public final Collection e(c3.k kVar, k3.g gVar, Collection collection, k3.k kVar2) {
        String str;
        while (true) {
            try {
                if (kVar.r0() == null) {
                    c3.n n10 = kVar.n();
                    if (n10 == c3.n.END_ARRAY) {
                        return collection;
                    }
                    if (n10 != c3.n.VALUE_NULL) {
                        str = (String) kVar2.deserialize(kVar, gVar);
                    } else if (!this.f6551c) {
                        str = (String) this.f6550b.getNullValue(gVar);
                    }
                } else {
                    str = (String) kVar2.deserialize(kVar, gVar);
                }
                collection.add(str);
            } catch (Exception e10) {
                throw k3.l.p(e10, collection, collection.size());
            }
        }
    }

    public final Collection f(c3.k kVar, k3.g gVar, Collection collection) {
        String _parseString;
        Boolean bool = this.f6552d;
        if (!(bool == Boolean.TRUE || (bool == null && gVar.n0(k3.h.ACCEPT_SINGLE_VALUE_AS_ARRAY)))) {
            return kVar.j0(c3.n.VALUE_STRING) ? (Collection) _deserializeFromString(kVar, gVar) : (Collection) gVar.c0(this.f6549a, kVar);
        }
        k3.k kVar2 = this.f6546e;
        if (kVar.n() != c3.n.VALUE_NULL) {
            try {
                _parseString = kVar2 == null ? _parseString(kVar, gVar) : (String) kVar2.deserialize(kVar, gVar);
            } catch (Exception e10) {
                throw k3.l.p(e10, collection, collection.size());
            }
        } else {
            if (this.f6551c) {
                return collection;
            }
            _parseString = (String) this.f6550b.getNullValue(gVar);
        }
        collection.add(_parseString);
        return collection;
    }

    public h0 g(k3.k kVar, k3.k kVar2, n3.q qVar, Boolean bool) {
        return (Objects.equals(this.f6552d, bool) && this.f6550b == qVar && this.f6546e == kVar2 && this.f6548g == kVar) ? this : new h0(this.f6549a, this.f6547f, kVar, kVar2, qVar, bool);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0
    public n3.w getValueInstantiator() {
        return this.f6547f;
    }

    @Override // k3.k
    public boolean isCachable() {
        return this.f6546e == null && this.f6548g == null;
    }

    @Override // k3.k
    public c4.f logicalType() {
        return c4.f.Collection;
    }

    public h0(k3.j jVar, n3.w wVar, k3.k kVar, k3.k kVar2, n3.q qVar, Boolean bool) {
        super(jVar, qVar, bool);
        this.f6546e = kVar2;
        this.f6547f = wVar;
        this.f6548g = kVar;
    }
}
