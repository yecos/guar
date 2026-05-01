package r3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import r3.t;

/* loaded from: classes.dex */
public final class c extends b implements f0 {

    /* renamed from: o, reason: collision with root package name */
    public static final a f18337o = new a(null, Collections.emptyList(), Collections.emptyList());

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f18338a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f18339b;

    /* renamed from: c, reason: collision with root package name */
    public final c4.n f18340c;

    /* renamed from: d, reason: collision with root package name */
    public final List f18341d;

    /* renamed from: e, reason: collision with root package name */
    public final k3.b f18342e;

    /* renamed from: f, reason: collision with root package name */
    public final c4.o f18343f;

    /* renamed from: g, reason: collision with root package name */
    public final t.a f18344g;

    /* renamed from: h, reason: collision with root package name */
    public final Class f18345h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f18346i;

    /* renamed from: j, reason: collision with root package name */
    public final d4.b f18347j;

    /* renamed from: k, reason: collision with root package name */
    public a f18348k;

    /* renamed from: l, reason: collision with root package name */
    public l f18349l;

    /* renamed from: m, reason: collision with root package name */
    public List f18350m;

    /* renamed from: n, reason: collision with root package name */
    public transient Boolean f18351n;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final e f18352a;

        /* renamed from: b, reason: collision with root package name */
        public final List f18353b;

        /* renamed from: c, reason: collision with root package name */
        public final List f18354c;

        public a(e eVar, List list, List list2) {
            this.f18352a = eVar;
            this.f18353b = list;
            this.f18354c = list2;
        }
    }

    public c(k3.j jVar, Class cls, List list, Class cls2, d4.b bVar, c4.n nVar, k3.b bVar2, t.a aVar, c4.o oVar, boolean z10) {
        this.f18338a = jVar;
        this.f18339b = cls;
        this.f18341d = list;
        this.f18345h = cls2;
        this.f18347j = bVar;
        this.f18340c = nVar;
        this.f18342e = bVar2;
        this.f18344g = aVar;
        this.f18343f = oVar;
        this.f18346i = z10;
    }

    @Override // r3.f0
    public k3.j a(Type type) {
        return this.f18343f.M(type, this.f18340c);
    }

    @Override // r3.b
    public Annotation c(Class cls) {
        return this.f18347j.get(cls);
    }

    @Override // r3.b
    public String d() {
        return this.f18339b.getName();
    }

    @Override // r3.b
    public Class e() {
        return this.f18339b;
    }

    @Override // r3.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return d4.h.H(obj, c.class) && ((c) obj).f18339b == this.f18339b;
    }

    @Override // r3.b
    public k3.j f() {
        return this.f18338a;
    }

    @Override // r3.b
    public boolean g(Class cls) {
        return this.f18347j.a(cls);
    }

    @Override // r3.b
    public boolean h(Class[] clsArr) {
        return this.f18347j.b(clsArr);
    }

    @Override // r3.b
    public int hashCode() {
        return this.f18339b.getName().hashCode();
    }

    public final a i() {
        a aVar = this.f18348k;
        if (aVar == null) {
            k3.j jVar = this.f18338a;
            aVar = jVar == null ? f18337o : f.p(this.f18342e, this.f18343f, this, jVar, this.f18345h, this.f18346i);
            this.f18348k = aVar;
        }
        return aVar;
    }

    public final List j() {
        List list = this.f18350m;
        if (list == null) {
            k3.j jVar = this.f18338a;
            list = jVar == null ? Collections.emptyList() : h.m(this.f18342e, this, this.f18344g, this.f18343f, jVar, this.f18346i);
            this.f18350m = list;
        }
        return list;
    }

    public final l k() {
        l lVar = this.f18349l;
        if (lVar == null) {
            k3.j jVar = this.f18338a;
            lVar = jVar == null ? new l() : k.m(this.f18342e, this, this.f18344g, this.f18343f, jVar, this.f18341d, this.f18345h, this.f18346i);
            this.f18349l = lVar;
        }
        return lVar;
    }

    public Iterable l() {
        return j();
    }

    public j m(String str, Class[] clsArr) {
        return k().a(str, clsArr);
    }

    public Class n() {
        return this.f18339b;
    }

    public d4.b o() {
        return this.f18347j;
    }

    public List p() {
        return i().f18353b;
    }

    public e q() {
        return i().f18352a;
    }

    public List r() {
        return i().f18354c;
    }

    public boolean s() {
        return this.f18347j.size() > 0;
    }

    public boolean t() {
        Boolean bool = this.f18351n;
        if (bool == null) {
            bool = Boolean.valueOf(d4.h.Q(this.f18339b));
            this.f18351n = bool;
        }
        return bool.booleanValue();
    }

    @Override // r3.b
    public String toString() {
        return "[AnnotedClass " + this.f18339b.getName() + "]";
    }

    public Iterable u() {
        return k();
    }

    public c(Class cls) {
        this.f18338a = null;
        this.f18339b = cls;
        this.f18341d = Collections.emptyList();
        this.f18345h = null;
        this.f18347j = o.d();
        this.f18340c = c4.n.i();
        this.f18342e = null;
        this.f18344g = null;
        this.f18343f = null;
        this.f18346i = false;
    }
}
