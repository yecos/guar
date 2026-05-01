package com.fasterxml.jackson.databind.deser.std;

import b3.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import o3.z;

/* loaded from: classes.dex */
public class h extends i implements n3.i {

    /* renamed from: e, reason: collision with root package name */
    public final k3.k f6537e;

    /* renamed from: f, reason: collision with root package name */
    public final w3.e f6538f;

    /* renamed from: g, reason: collision with root package name */
    public final n3.w f6539g;

    /* renamed from: h, reason: collision with root package name */
    public final k3.k f6540h;

    public static final class a extends z.a {

        /* renamed from: c, reason: collision with root package name */
        public final b f6541c;

        /* renamed from: d, reason: collision with root package name */
        public final List f6542d;

        public a(b bVar, n3.u uVar, Class cls) {
            super(uVar, cls);
            this.f6542d = new ArrayList();
            this.f6541c = bVar;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Class f6543a;

        /* renamed from: b, reason: collision with root package name */
        public final Collection f6544b;

        /* renamed from: c, reason: collision with root package name */
        public List f6545c = new ArrayList();

        public b(Class cls, Collection collection) {
            this.f6543a = cls;
            this.f6544b = collection;
        }

        public void a(Object obj) {
            if (this.f6545c.isEmpty()) {
                this.f6544b.add(obj);
            } else {
                ((a) this.f6545c.get(r0.size() - 1)).f6542d.add(obj);
            }
        }

        public z.a b(n3.u uVar) {
            a aVar = new a(this, uVar, this.f6543a);
            this.f6545c.add(aVar);
            return aVar;
        }
    }

    public h(k3.j jVar, k3.k kVar, w3.e eVar, n3.w wVar) {
        this(jVar, kVar, eVar, wVar, null, null, null);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.i
    public k3.k a() {
        return this.f6537e;
    }

    public Collection c(c3.k kVar, k3.g gVar, Collection collection) {
        Object deserialize;
        kVar.A0(collection);
        k3.k kVar2 = this.f6537e;
        if (kVar2.getObjectIdReader() != null) {
            return e(kVar, gVar, collection);
        }
        w3.e eVar = this.f6538f;
        while (true) {
            c3.n s02 = kVar.s0();
            if (s02 == c3.n.END_ARRAY) {
                return collection;
            }
            try {
                if (s02 != c3.n.VALUE_NULL) {
                    deserialize = eVar == null ? kVar2.deserialize(kVar, gVar) : kVar2.deserializeWithType(kVar, gVar, eVar);
                } else if (!this.f6551c) {
                    deserialize = this.f6550b.getNullValue(gVar);
                }
                collection.add(deserialize);
            } catch (Exception e10) {
                if (!(gVar == null || gVar.n0(k3.h.WRAP_EXCEPTIONS))) {
                    d4.h.j0(e10);
                }
                throw k3.l.p(e10, collection, collection.size());
            }
        }
    }

    public Collection d(c3.k kVar, k3.g gVar, String str) {
        Class<?> handledType = handledType();
        if (str.isEmpty()) {
            m3.b _checkCoercionFail = _checkCoercionFail(gVar, gVar.B(logicalType(), handledType, m3.e.EmptyString), handledType, str, "empty String (\"\")");
            if (_checkCoercionFail != null) {
                return (Collection) _deserializeFromEmptyString(kVar, gVar, _checkCoercionFail, handledType, "empty String (\"\")");
            }
        } else if (b0._isBlank(str)) {
            return (Collection) _deserializeFromEmptyString(kVar, gVar, gVar.C(logicalType(), handledType, m3.b.Fail), handledType, "blank String (all whitespace)");
        }
        return j(kVar, gVar, g(gVar));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return eVar.d(kVar, gVar);
    }

    public Collection e(c3.k kVar, k3.g gVar, Collection collection) {
        Object deserialize;
        if (!kVar.n0()) {
            return j(kVar, gVar, collection);
        }
        kVar.A0(collection);
        k3.k kVar2 = this.f6537e;
        w3.e eVar = this.f6538f;
        b bVar = new b(this.f6549a.k().q(), collection);
        while (true) {
            c3.n s02 = kVar.s0();
            if (s02 == c3.n.END_ARRAY) {
                return collection;
            }
            try {
            } catch (n3.u e10) {
                e10.t().a(bVar.b(e10));
            } catch (Exception e11) {
                if (!(gVar == null || gVar.n0(k3.h.WRAP_EXCEPTIONS))) {
                    d4.h.j0(e11);
                }
                throw k3.l.p(e11, collection, collection.size());
            }
            if (s02 != c3.n.VALUE_NULL) {
                deserialize = eVar == null ? kVar2.deserialize(kVar, gVar) : kVar2.deserializeWithType(kVar, gVar, eVar);
            } else if (!this.f6551c) {
                deserialize = this.f6550b.getNullValue(gVar);
            }
            bVar.a(deserialize);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    @Override // n3.i
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h createContextual(k3.g gVar, k3.d dVar) {
        k3.k kVar;
        w3.e eVar;
        n3.w wVar = this.f6539g;
        if (wVar != null) {
            if (wVar.k()) {
                k3.j D = this.f6539g.D(gVar.k());
                if (D == null) {
                    k3.j jVar = this.f6549a;
                    gVar.q(jVar, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", jVar, this.f6539g.getClass().getName()));
                }
                kVar = findDeserializer(gVar, D, dVar);
            } else if (this.f6539g.i()) {
                k3.j A = this.f6539g.A(gVar.k());
                if (A == null) {
                    k3.j jVar2 = this.f6549a;
                    gVar.q(jVar2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", jVar2, this.f6539g.getClass().getName()));
                }
                kVar = findDeserializer(gVar, A, dVar);
            }
            k3.k kVar2 = kVar;
            Boolean findFormatFeature = findFormatFeature(gVar, dVar, Collection.class, k.a.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            k3.k findConvertingContentDeserializer = findConvertingContentDeserializer(gVar, dVar, this.f6537e);
            k3.j k10 = this.f6549a.k();
            k3.k D2 = findConvertingContentDeserializer != null ? gVar.D(k10, dVar) : gVar.Z(findConvertingContentDeserializer, dVar, k10);
            eVar = this.f6538f;
            if (eVar != null) {
                eVar = eVar.g(dVar);
            }
            w3.e eVar2 = eVar;
            n3.q findContentNullProvider = findContentNullProvider(gVar, dVar, D2);
            return (!Objects.equals(findFormatFeature, this.f6552d) && findContentNullProvider == this.f6550b && kVar2 == this.f6540h && D2 == this.f6537e && eVar2 == this.f6538f) ? this : k(kVar2, D2, eVar2, findContentNullProvider, findFormatFeature);
        }
        kVar = null;
        k3.k kVar22 = kVar;
        Boolean findFormatFeature2 = findFormatFeature(gVar, dVar, Collection.class, k.a.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        k3.k findConvertingContentDeserializer2 = findConvertingContentDeserializer(gVar, dVar, this.f6537e);
        k3.j k102 = this.f6549a.k();
        k3.k D22 = findConvertingContentDeserializer2 != null ? gVar.D(k102, dVar) : gVar.Z(findConvertingContentDeserializer2, dVar, k102);
        eVar = this.f6538f;
        if (eVar != null) {
        }
        w3.e eVar22 = eVar;
        n3.q findContentNullProvider2 = findContentNullProvider(gVar, dVar, D22);
        if (!Objects.equals(findFormatFeature2, this.f6552d)) {
        }
    }

    public Collection g(k3.g gVar) {
        return (Collection) this.f6539g.x(gVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0
    public n3.w getValueInstantiator() {
        return this.f6539g;
    }

    @Override // k3.k
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Collection deserialize(c3.k kVar, k3.g gVar) {
        k3.k kVar2 = this.f6540h;
        return kVar2 != null ? (Collection) this.f6539g.y(gVar, kVar2.deserialize(kVar, gVar)) : kVar.n0() ? c(kVar, gVar, g(gVar)) : kVar.j0(c3.n.VALUE_STRING) ? d(kVar, gVar, kVar.Y()) : j(kVar, gVar, g(gVar));
    }

    @Override // k3.k
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Collection deserialize(c3.k kVar, k3.g gVar, Collection collection) {
        return kVar.n0() ? c(kVar, gVar, collection) : j(kVar, gVar, collection);
    }

    @Override // k3.k
    public boolean isCachable() {
        return this.f6537e == null && this.f6538f == null && this.f6540h == null;
    }

    public final Collection j(c3.k kVar, k3.g gVar, Collection collection) {
        Object deserialize;
        Boolean bool = this.f6552d;
        if (!(bool == Boolean.TRUE || (bool == null && gVar.n0(k3.h.ACCEPT_SINGLE_VALUE_AS_ARRAY)))) {
            return (Collection) gVar.c0(this.f6549a, kVar);
        }
        k3.k kVar2 = this.f6537e;
        w3.e eVar = this.f6538f;
        try {
            if (!kVar.j0(c3.n.VALUE_NULL)) {
                deserialize = eVar == null ? kVar2.deserialize(kVar, gVar) : kVar2.deserializeWithType(kVar, gVar, eVar);
            } else {
                if (this.f6551c) {
                    return collection;
                }
                deserialize = this.f6550b.getNullValue(gVar);
            }
            collection.add(deserialize);
            return collection;
        } catch (Exception e10) {
            if (!gVar.n0(k3.h.WRAP_EXCEPTIONS)) {
                d4.h.j0(e10);
            }
            throw k3.l.p(e10, Object.class, collection.size());
        }
    }

    public h k(k3.k kVar, k3.k kVar2, w3.e eVar, n3.q qVar, Boolean bool) {
        return new h(this.f6549a, kVar2, eVar, this.f6539g, kVar, qVar, bool);
    }

    @Override // k3.k
    public c4.f logicalType() {
        return c4.f.Collection;
    }

    public h(k3.j jVar, k3.k kVar, w3.e eVar, n3.w wVar, k3.k kVar2, n3.q qVar, Boolean bool) {
        super(jVar, qVar, bool);
        this.f6537e = kVar;
        this.f6538f = eVar;
        this.f6539g = wVar;
        this.f6540h = kVar2;
    }
}
