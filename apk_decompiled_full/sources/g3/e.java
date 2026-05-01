package g3;

import c3.m;

/* loaded from: classes.dex */
public class e extends m {

    /* renamed from: c, reason: collision with root package name */
    public final e f13593c;

    /* renamed from: d, reason: collision with root package name */
    public a f13594d;

    /* renamed from: e, reason: collision with root package name */
    public e f13595e;

    /* renamed from: f, reason: collision with root package name */
    public String f13596f;

    /* renamed from: g, reason: collision with root package name */
    public Object f13597g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13598h;

    public e(int i10, e eVar, a aVar) {
        this.f5483a = i10;
        this.f13593c = eVar;
        this.f13594d = aVar;
        this.f5484b = -1;
    }

    public static e q(a aVar) {
        return new e(0, null, aVar);
    }

    @Override // c3.m
    public final String b() {
        return this.f13596f;
    }

    @Override // c3.m
    public Object c() {
        return this.f13597g;
    }

    @Override // c3.m
    public void i(Object obj) {
        this.f13597g = obj;
    }

    public final void k(a aVar, String str) {
        if (aVar.c(str)) {
            Object b10 = aVar.b();
            throw new c3.g("Duplicate field '" + str + "'", b10 instanceof c3.h ? (c3.h) b10 : null);
        }
    }

    public e l() {
        this.f13597g = null;
        return this.f13593c;
    }

    public e m() {
        e eVar = this.f13595e;
        if (eVar != null) {
            return eVar.t(1);
        }
        a aVar = this.f13594d;
        e eVar2 = new e(1, this, aVar == null ? null : aVar.a());
        this.f13595e = eVar2;
        return eVar2;
    }

    public e n(Object obj) {
        e eVar = this.f13595e;
        if (eVar != null) {
            return eVar.u(1, obj);
        }
        a aVar = this.f13594d;
        e eVar2 = new e(1, this, aVar == null ? null : aVar.a(), obj);
        this.f13595e = eVar2;
        return eVar2;
    }

    public e o() {
        e eVar = this.f13595e;
        if (eVar != null) {
            return eVar.t(2);
        }
        a aVar = this.f13594d;
        e eVar2 = new e(2, this, aVar == null ? null : aVar.a());
        this.f13595e = eVar2;
        return eVar2;
    }

    public e p(Object obj) {
        e eVar = this.f13595e;
        if (eVar != null) {
            return eVar.u(2, obj);
        }
        a aVar = this.f13594d;
        e eVar2 = new e(2, this, aVar == null ? null : aVar.a(), obj);
        this.f13595e = eVar2;
        return eVar2;
    }

    public a r() {
        return this.f13594d;
    }

    @Override // c3.m
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final e e() {
        return this.f13593c;
    }

    public e t(int i10) {
        this.f5483a = i10;
        this.f5484b = -1;
        this.f13596f = null;
        this.f13598h = false;
        this.f13597g = null;
        a aVar = this.f13594d;
        if (aVar != null) {
            aVar.d();
        }
        return this;
    }

    public e u(int i10, Object obj) {
        this.f5483a = i10;
        this.f5484b = -1;
        this.f13596f = null;
        this.f13598h = false;
        this.f13597g = obj;
        a aVar = this.f13594d;
        if (aVar != null) {
            aVar.d();
        }
        return this;
    }

    public e v(a aVar) {
        this.f13594d = aVar;
        return this;
    }

    public int w(String str) {
        if (this.f5483a != 2 || this.f13598h) {
            return 4;
        }
        this.f13598h = true;
        this.f13596f = str;
        a aVar = this.f13594d;
        if (aVar != null) {
            k(aVar, str);
        }
        return this.f5484b < 0 ? 0 : 1;
    }

    public int x() {
        int i10 = this.f5483a;
        if (i10 == 2) {
            if (!this.f13598h) {
                return 5;
            }
            this.f13598h = false;
            this.f5484b++;
            return 2;
        }
        if (i10 == 1) {
            int i11 = this.f5484b;
            this.f5484b = i11 + 1;
            return i11 < 0 ? 0 : 1;
        }
        int i12 = this.f5484b + 1;
        this.f5484b = i12;
        return i12 == 0 ? 0 : 3;
    }

    public e(int i10, e eVar, a aVar, Object obj) {
        this.f5483a = i10;
        this.f13593c = eVar;
        this.f13594d = aVar;
        this.f5484b = -1;
        this.f13597g = obj;
    }
}
