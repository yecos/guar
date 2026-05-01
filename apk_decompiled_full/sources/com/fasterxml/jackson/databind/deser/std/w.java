package com.fasterxml.jackson.databind.deser.std;

import b3.k;
import java.lang.reflect.Array;
import java.util.Objects;

/* loaded from: classes.dex */
public class w extends i implements n3.i {

    /* renamed from: e, reason: collision with root package name */
    public final boolean f6639e;

    /* renamed from: f, reason: collision with root package name */
    public final Class f6640f;

    /* renamed from: g, reason: collision with root package name */
    public k3.k f6641g;

    /* renamed from: h, reason: collision with root package name */
    public final w3.e f6642h;

    /* renamed from: i, reason: collision with root package name */
    public final Object[] f6643i;

    public w(k3.j jVar, k3.k kVar, w3.e eVar) {
        super(jVar, (n3.q) null, (Boolean) null);
        c4.a aVar = (c4.a) jVar;
        Class q10 = aVar.k().q();
        this.f6640f = q10;
        this.f6639e = q10 == Object.class;
        this.f6641g = kVar;
        this.f6642h = eVar;
        this.f6643i = aVar.d0();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.i
    public k3.k a() {
        return this.f6641g;
    }

    @Override // k3.k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Object[] deserialize(c3.k kVar, k3.g gVar) {
        Object deserialize;
        int i10;
        if (!kVar.n0()) {
            return g(kVar, gVar);
        }
        d4.s q02 = gVar.q0();
        Object[] i11 = q02.i();
        w3.e eVar = this.f6642h;
        int i12 = 0;
        while (true) {
            try {
                c3.n s02 = kVar.s0();
                if (s02 == c3.n.END_ARRAY) {
                    break;
                }
                try {
                    if (s02 != c3.n.VALUE_NULL) {
                        deserialize = eVar == null ? this.f6641g.deserialize(kVar, gVar) : this.f6641g.deserializeWithType(kVar, gVar, eVar);
                    } else if (!this.f6551c) {
                        deserialize = this.f6550b.getNullValue(gVar);
                    }
                    i11[i12] = deserialize;
                    i12 = i10;
                } catch (Exception e10) {
                    e = e10;
                    i12 = i10;
                    throw k3.l.p(e, i11, q02.d() + i12);
                }
                if (i12 >= i11.length) {
                    i11 = q02.c(i11);
                    i12 = 0;
                }
                i10 = i12 + 1;
            } catch (Exception e11) {
                e = e11;
            }
        }
        Object[] f10 = this.f6639e ? q02.f(i11, i12) : q02.g(i11, i12, this.f6640f);
        gVar.H0(q02);
        return f10;
    }

    @Override // n3.i
    public k3.k createContextual(k3.g gVar, k3.d dVar) {
        k3.k kVar = this.f6641g;
        Boolean findFormatFeature = findFormatFeature(gVar, dVar, this.f6549a.q(), k.a.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        k3.k findConvertingContentDeserializer = findConvertingContentDeserializer(gVar, dVar, kVar);
        k3.j k10 = this.f6549a.k();
        k3.k D = findConvertingContentDeserializer == null ? gVar.D(k10, dVar) : gVar.Z(findConvertingContentDeserializer, dVar, k10);
        w3.e eVar = this.f6642h;
        if (eVar != null) {
            eVar = eVar.g(dVar);
        }
        return h(eVar, D, findContentNullProvider(gVar, dVar, D), findFormatFeature);
    }

    @Override // k3.k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Object[] deserialize(c3.k kVar, k3.g gVar, Object[] objArr) {
        Object deserialize;
        int i10;
        if (!kVar.n0()) {
            Object[] g10 = g(kVar, gVar);
            if (g10 == null) {
                return objArr;
            }
            int length = objArr.length;
            Object[] objArr2 = new Object[g10.length + length];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            System.arraycopy(g10, 0, objArr2, length, g10.length);
            return objArr2;
        }
        d4.s q02 = gVar.q0();
        int length2 = objArr.length;
        Object[] j10 = q02.j(objArr, length2);
        w3.e eVar = this.f6642h;
        while (true) {
            try {
                c3.n s02 = kVar.s0();
                if (s02 == c3.n.END_ARRAY) {
                    break;
                }
                try {
                    if (s02 != c3.n.VALUE_NULL) {
                        deserialize = eVar == null ? this.f6641g.deserialize(kVar, gVar) : this.f6641g.deserializeWithType(kVar, gVar, eVar);
                    } else if (!this.f6551c) {
                        deserialize = this.f6550b.getNullValue(gVar);
                    }
                    j10[length2] = deserialize;
                    length2 = i10;
                } catch (Exception e10) {
                    e = e10;
                    length2 = i10;
                    throw k3.l.p(e, j10, q02.d() + length2);
                }
                if (length2 >= j10.length) {
                    j10 = q02.c(j10);
                    length2 = 0;
                }
                i10 = length2 + 1;
            } catch (Exception e11) {
                e = e11;
            }
        }
        Object[] f10 = this.f6639e ? q02.f(j10, length2) : q02.g(j10, length2, this.f6640f);
        gVar.H0(q02);
        return f10;
    }

    public Byte[] e(c3.k kVar, k3.g gVar) {
        byte[] v10 = kVar.v(gVar.M());
        Byte[] bArr = new Byte[v10.length];
        int length = v10.length;
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = Byte.valueOf(v10[i10]);
        }
        return bArr;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Object[] deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return (Object[]) eVar.d(kVar, gVar);
    }

    public Object[] g(c3.k kVar, k3.g gVar) {
        Object deserialize;
        Boolean bool = this.f6552d;
        if (!(bool == Boolean.TRUE || (bool == null && gVar.n0(k3.h.ACCEPT_SINGLE_VALUE_AS_ARRAY)))) {
            return kVar.j0(c3.n.VALUE_STRING) ? this.f6640f == Byte.class ? e(kVar, gVar) : (Object[]) _deserializeFromString(kVar, gVar) : (Object[]) gVar.c0(this.f6549a, kVar);
        }
        if (!kVar.j0(c3.n.VALUE_NULL)) {
            w3.e eVar = this.f6642h;
            deserialize = eVar == null ? this.f6641g.deserialize(kVar, gVar) : this.f6641g.deserializeWithType(kVar, gVar, eVar);
        } else {
            if (this.f6551c) {
                return this.f6643i;
            }
            deserialize = this.f6550b.getNullValue(gVar);
        }
        Object[] objArr = this.f6639e ? new Object[1] : (Object[]) Array.newInstance((Class<?>) this.f6640f, 1);
        objArr[0] = deserialize;
        return objArr;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.i, k3.k
    public d4.a getEmptyAccessPattern() {
        return d4.a.CONSTANT;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.i, k3.k
    public Object getEmptyValue(k3.g gVar) {
        return this.f6643i;
    }

    public w h(w3.e eVar, k3.k kVar, n3.q qVar, Boolean bool) {
        return (Objects.equals(bool, this.f6552d) && qVar == this.f6550b && kVar == this.f6641g && eVar == this.f6642h) ? this : new w(this, kVar, eVar, qVar, bool);
    }

    @Override // k3.k
    public boolean isCachable() {
        return this.f6641g == null && this.f6642h == null;
    }

    @Override // k3.k
    public c4.f logicalType() {
        return c4.f.Array;
    }

    public w(w wVar, k3.k kVar, w3.e eVar, n3.q qVar, Boolean bool) {
        super(wVar, qVar, bool);
        this.f6640f = wVar.f6640f;
        this.f6639e = wVar.f6639e;
        this.f6643i = wVar.f6643i;
        this.f6641g = kVar;
        this.f6642h = eVar;
    }
}
