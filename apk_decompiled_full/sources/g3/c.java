package g3;

import c3.i;
import c3.j;
import c3.k;
import c3.m;

/* loaded from: classes.dex */
public final class c extends m {

    /* renamed from: c, reason: collision with root package name */
    public final c f13571c;

    /* renamed from: d, reason: collision with root package name */
    public a f13572d;

    /* renamed from: e, reason: collision with root package name */
    public c f13573e;

    /* renamed from: f, reason: collision with root package name */
    public String f13574f;

    /* renamed from: g, reason: collision with root package name */
    public Object f13575g;

    /* renamed from: h, reason: collision with root package name */
    public int f13576h;

    /* renamed from: i, reason: collision with root package name */
    public int f13577i;

    public c(c cVar, a aVar, int i10, int i11, int i12) {
        this.f13571c = cVar;
        this.f13572d = aVar;
        this.f5483a = i10;
        this.f13576h = i11;
        this.f13577i = i12;
        this.f5484b = -1;
    }

    public static c o(a aVar) {
        return new c(null, aVar, 0, 1, 0);
    }

    @Override // c3.m
    public String b() {
        return this.f13574f;
    }

    @Override // c3.m
    public Object c() {
        return this.f13575g;
    }

    @Override // c3.m
    public void i(Object obj) {
        this.f13575g = obj;
    }

    public final void k(a aVar, String str) {
        if (aVar.c(str)) {
            Object b10 = aVar.b();
            throw new j(b10 instanceof k ? (k) b10 : null, "Duplicate field '" + str + "'");
        }
    }

    public c l() {
        this.f13575g = null;
        return this.f13571c;
    }

    public c m(int i10, int i11) {
        c cVar = this.f13573e;
        if (cVar == null) {
            a aVar = this.f13572d;
            cVar = new c(this, aVar == null ? null : aVar.a(), 1, i10, i11);
            this.f13573e = cVar;
        } else {
            cVar.t(1, i10, i11);
        }
        return cVar;
    }

    public c n(int i10, int i11) {
        c cVar = this.f13573e;
        if (cVar != null) {
            cVar.t(2, i10, i11);
            return cVar;
        }
        a aVar = this.f13572d;
        c cVar2 = new c(this, aVar == null ? null : aVar.a(), 2, i10, i11);
        this.f13573e = cVar2;
        return cVar2;
    }

    public boolean p() {
        int i10 = this.f5484b + 1;
        this.f5484b = i10;
        return this.f5483a != 0 && i10 > 0;
    }

    public a q() {
        return this.f13572d;
    }

    @Override // c3.m
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public c e() {
        return this.f13571c;
    }

    public i s(Object obj) {
        return new i(obj, -1L, this.f13576h, this.f13577i);
    }

    public void t(int i10, int i11, int i12) {
        this.f5483a = i10;
        this.f5484b = -1;
        this.f13576h = i11;
        this.f13577i = i12;
        this.f13574f = null;
        this.f13575g = null;
        a aVar = this.f13572d;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void u(String str) {
        this.f13574f = str;
        a aVar = this.f13572d;
        if (aVar != null) {
            k(aVar, str);
        }
    }

    public c v(a aVar) {
        this.f13572d = aVar;
        return this;
    }
}
