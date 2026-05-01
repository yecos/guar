package x3;

import b3.e0;
import java.util.Collection;
import k3.a0;
import w3.c;

/* loaded from: classes.dex */
public class o implements w3.g {

    /* renamed from: a, reason: collision with root package name */
    public e0.b f19429a;

    /* renamed from: b, reason: collision with root package name */
    public e0.a f19430b;

    /* renamed from: c, reason: collision with root package name */
    public String f19431c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19432d = false;

    /* renamed from: e, reason: collision with root package name */
    public Class f19433e;

    /* renamed from: f, reason: collision with root package name */
    public w3.f f19434f;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19435a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f19436b;

        static {
            int[] iArr = new int[e0.b.values().length];
            f19436b = iArr;
            try {
                iArr[e0.b.DEDUCTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19436b[e0.b.CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19436b[e0.b.MINIMAL_CLASS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19436b[e0.b.NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19436b[e0.b.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19436b[e0.b.CUSTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[e0.a.values().length];
            f19435a = iArr2;
            try {
                iArr2[e0.a.WRAPPER_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19435a[e0.a.PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f19435a[e0.a.WRAPPER_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f19435a[e0.a.EXTERNAL_PROPERTY.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f19435a[e0.a.EXISTING_PROPERTY.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static o o() {
        return new o().h(e0.b.NONE, null);
    }

    @Override // w3.g
    public w3.h b(a0 a0Var, k3.j jVar, Collection collection) {
        if (this.f19429a == e0.b.NONE) {
            return null;
        }
        if (jVar.K() && !i(a0Var, jVar)) {
            return null;
        }
        w3.f l10 = l(a0Var, jVar, q(a0Var), collection, true, false);
        if (this.f19429a == e0.b.DEDUCTION) {
            return new d(l10, null, this.f19431c);
        }
        int i10 = a.f19435a[this.f19430b.ordinal()];
        if (i10 == 1) {
            return new b(l10, null);
        }
        if (i10 == 2) {
            return new h(l10, null, this.f19431c);
        }
        if (i10 == 3) {
            return new j(l10, null);
        }
        if (i10 == 4) {
            return new f(l10, null, this.f19431c);
        }
        if (i10 == 5) {
            return new d(l10, null, this.f19431c);
        }
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.f19430b);
    }

    @Override // w3.g
    public w3.e e(k3.f fVar, k3.j jVar, Collection collection) {
        if (this.f19429a == e0.b.NONE) {
            return null;
        }
        if (jVar.K() && !i(fVar, jVar)) {
            return null;
        }
        w3.f l10 = l(fVar, jVar, t(fVar, jVar), collection, false, true);
        k3.j k10 = k(fVar, jVar);
        if (this.f19429a == e0.b.DEDUCTION) {
            return new c(jVar, l10, k10, fVar, collection);
        }
        int i10 = a.f19435a[this.f19430b.ordinal()];
        if (i10 == 1) {
            return new x3.a(jVar, l10, this.f19431c, this.f19432d, k10);
        }
        if (i10 != 2) {
            if (i10 == 3) {
                return new i(jVar, l10, this.f19431c, this.f19432d, k10);
            }
            if (i10 == 4) {
                return new e(jVar, l10, this.f19431c, this.f19432d, k10);
            }
            if (i10 != 5) {
                throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.f19430b);
            }
        }
        return new g(jVar, l10, this.f19431c, this.f19432d, k10, this.f19430b);
    }

    @Override // w3.g
    public Class g() {
        return this.f19433e;
    }

    public boolean i(m3.m mVar, k3.j jVar) {
        return false;
    }

    @Override // w3.g
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public o d(Class cls) {
        this.f19433e = cls;
        return this;
    }

    public k3.j k(k3.f fVar, k3.j jVar) {
        Class cls = this.f19433e;
        if (cls == null) {
            if (fVar.D(k3.q.USE_BASE_TYPE_AS_DEFAULT_IMPL) && !jVar.z()) {
                return jVar;
            }
        } else {
            if (cls == Void.class || cls == l3.j.class) {
                return fVar.z().H(this.f19433e);
            }
            if (jVar.y(cls)) {
                return jVar;
            }
            if (jVar.O(this.f19433e)) {
                return fVar.z().F(jVar, this.f19433e);
            }
        }
        return null;
    }

    public w3.f l(m3.m mVar, k3.j jVar, w3.c cVar, Collection collection, boolean z10, boolean z11) {
        w3.f fVar = this.f19434f;
        if (fVar != null) {
            return fVar;
        }
        e0.b bVar = this.f19429a;
        if (bVar == null) {
            throw new IllegalStateException("Cannot build, 'init()' not yet called");
        }
        int i10 = a.f19436b[bVar.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return k.i(jVar, mVar, cVar);
        }
        if (i10 == 3) {
            return m.j(jVar, mVar, cVar);
        }
        if (i10 == 4) {
            return s.i(mVar, jVar, collection, z10, z11);
        }
        if (i10 == 5) {
            return null;
        }
        throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.f19429a);
    }

    @Override // w3.g
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public o f(e0.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("includeAs cannot be null");
        }
        this.f19430b = aVar;
        return this;
    }

    @Override // w3.g
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public o h(e0.b bVar, w3.f fVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("idType cannot be null");
        }
        this.f19429a = bVar;
        this.f19434f = fVar;
        this.f19431c = bVar.a();
        return this;
    }

    public w3.c p(m3.m mVar, k3.j jVar, w3.c cVar) {
        throw new IllegalArgumentException(String.format("Configured `PolymorphicTypeValidator` (of type %s) denied resolution of all subtypes of base type %s", d4.h.h(cVar), d4.h.h(jVar.q())));
    }

    public w3.c q(m3.m mVar) {
        return mVar.w();
    }

    @Override // w3.g
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public o a(boolean z10) {
        this.f19432d = z10;
        return this;
    }

    @Override // w3.g
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public o c(String str) {
        if (str == null || str.isEmpty()) {
            str = this.f19429a.a();
        }
        this.f19431c = str;
        return this;
    }

    public w3.c t(m3.m mVar, k3.j jVar) {
        w3.c q10 = q(mVar);
        e0.b bVar = this.f19429a;
        if (bVar == e0.b.CLASS || bVar == e0.b.MINIMAL_CLASS) {
            c.b a10 = q10.a(mVar, jVar);
            if (a10 == c.b.DENIED) {
                return p(mVar, jVar, q10);
            }
            if (a10 == c.b.ALLOWED) {
                return l.f19425a;
            }
        }
        return q10;
    }
}
