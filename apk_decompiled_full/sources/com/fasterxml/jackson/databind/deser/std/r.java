package com.fasterxml.jackson.databind.deser.std;

/* loaded from: classes.dex */
public class r extends f {

    /* renamed from: b, reason: collision with root package name */
    public static final r f6590b = new r();

    public static final class a extends f {

        /* renamed from: b, reason: collision with root package name */
        public static final a f6591b = new a();

        public a() {
            super(z3.a.class, Boolean.TRUE);
        }

        public static a m() {
            return f6591b;
        }

        @Override // k3.k
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public z3.a deserialize(c3.k kVar, k3.g gVar) {
            return kVar.n0() ? f(kVar, gVar, gVar.R()) : (z3.a) gVar.a0(z3.a.class, kVar);
        }

        @Override // k3.k
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public z3.a deserialize(c3.k kVar, k3.g gVar, z3.a aVar) {
            return kVar.n0() ? (z3.a) i(kVar, gVar, aVar) : (z3.a) gVar.a0(z3.a.class, kVar);
        }
    }

    public static final class b extends f {

        /* renamed from: b, reason: collision with root package name */
        public static final b f6592b = new b();

        public b() {
            super(z3.r.class, Boolean.TRUE);
        }

        public static b m() {
            return f6592b;
        }

        @Override // k3.k
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public z3.r deserialize(c3.k kVar, k3.g gVar) {
            return kVar.o0() ? g(kVar, gVar, gVar.R()) : kVar.j0(c3.n.FIELD_NAME) ? h(kVar, gVar, gVar.R()) : kVar.j0(c3.n.END_OBJECT) ? gVar.R().k() : (z3.r) gVar.a0(z3.r.class, kVar);
        }

        @Override // k3.k
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public z3.r deserialize(c3.k kVar, k3.g gVar, z3.r rVar) {
            return (kVar.o0() || kVar.j0(c3.n.FIELD_NAME)) ? (z3.r) j(kVar, gVar, rVar) : (z3.r) gVar.a0(z3.r.class, kVar);
        }
    }

    public r() {
        super(k3.m.class, null);
    }

    public static k3.k l(Class cls) {
        return cls == z3.r.class ? b.m() : cls == z3.a.class ? a.m() : f6590b;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.f, com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public /* bridge */ /* synthetic */ Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return super.deserializeWithType(kVar, gVar, eVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.f, k3.k
    public /* bridge */ /* synthetic */ boolean isCachable() {
        return super.isCachable();
    }

    @Override // k3.k
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public k3.m deserialize(c3.k kVar, k3.g gVar) {
        int q10 = kVar.q();
        return q10 != 1 ? q10 != 3 ? e(kVar, gVar, gVar.R()) : f(kVar, gVar, gVar.R()) : g(kVar, gVar, gVar.R());
    }

    @Override // com.fasterxml.jackson.databind.deser.std.f, k3.k
    public /* bridge */ /* synthetic */ c4.f logicalType() {
        return super.logicalType();
    }

    @Override // k3.k, n3.q
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public k3.m getNullValue(k3.g gVar) {
        return gVar.R().d();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.f, k3.k
    public /* bridge */ /* synthetic */ Boolean supportsUpdate(k3.f fVar) {
        return super.supportsUpdate(fVar);
    }
}
