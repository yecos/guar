package b4;

import b3.r;
import b4.k;
import java.util.Map;
import k3.c0;

/* loaded from: classes.dex */
public class h extends a4.h implements a4.i {

    /* renamed from: l, reason: collision with root package name */
    public static final Object f4592l = r.a.NON_EMPTY;

    /* renamed from: a, reason: collision with root package name */
    public final k3.d f4593a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4594b;

    /* renamed from: c, reason: collision with root package name */
    public final k3.j f4595c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.j f4596d;

    /* renamed from: e, reason: collision with root package name */
    public final k3.j f4597e;

    /* renamed from: f, reason: collision with root package name */
    public k3.o f4598f;

    /* renamed from: g, reason: collision with root package name */
    public k3.o f4599g;

    /* renamed from: h, reason: collision with root package name */
    public final w3.h f4600h;

    /* renamed from: i, reason: collision with root package name */
    public k f4601i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f4602j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f4603k;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4604a;

        static {
            int[] iArr = new int[r.a.values().length];
            f4604a = iArr;
            try {
                iArr[r.a.NON_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4604a[r.a.NON_ABSENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4604a[r.a.NON_EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4604a[r.a.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4604a[r.a.NON_NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4604a[r.a.ALWAYS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public h(k3.j jVar, k3.j jVar2, k3.j jVar3, boolean z10, w3.h hVar, k3.d dVar) {
        super(jVar);
        this.f4595c = jVar;
        this.f4596d = jVar2;
        this.f4597e = jVar3;
        this.f4594b = z10;
        this.f4600h = hVar;
        this.f4593a = dVar;
        this.f4601i = k.c();
        this.f4602j = null;
        this.f4603k = false;
    }

    @Override // a4.i
    public k3.o b(c0 c0Var, k3.d dVar) {
        k3.o oVar;
        k3.o oVar2;
        Object obj;
        boolean z10;
        r.b b10;
        r.a f10;
        k3.b W = c0Var.W();
        Object obj2 = null;
        r3.i d10 = dVar == null ? null : dVar.d();
        if (d10 == null || W == null) {
            oVar = null;
            oVar2 = null;
        } else {
            Object v10 = W.v(d10);
            oVar2 = v10 != null ? c0Var.t0(d10, v10) : null;
            Object g10 = W.g(d10);
            oVar = g10 != null ? c0Var.t0(d10, g10) : null;
        }
        if (oVar == null) {
            oVar = this.f4599g;
        }
        k3.o findContextualConvertingSerializer = findContextualConvertingSerializer(c0Var, dVar, oVar);
        if (findContextualConvertingSerializer == null && this.f4594b && !this.f4597e.I()) {
            findContextualConvertingSerializer = c0Var.H(this.f4597e, dVar);
        }
        k3.o oVar3 = findContextualConvertingSerializer;
        if (oVar2 == null) {
            oVar2 = this.f4598f;
        }
        k3.o J = oVar2 == null ? c0Var.J(this.f4596d, dVar) : c0Var.i0(oVar2, dVar);
        Object obj3 = this.f4602j;
        boolean z11 = this.f4603k;
        if (dVar == null || (b10 = dVar.b(c0Var.k(), null)) == null || (f10 = b10.f()) == r.a.USE_DEFAULTS) {
            obj = obj3;
            z10 = z11;
        } else {
            int i10 = a.f4604a[f10.ordinal()];
            if (i10 == 1) {
                obj2 = d4.e.b(this.f4597e);
                if (obj2 != null && obj2.getClass().isArray()) {
                    obj2 = d4.c.a(obj2);
                }
            } else if (i10 != 2) {
                if (i10 == 3) {
                    obj2 = f4592l;
                } else if (i10 == 4) {
                    obj2 = c0Var.j0(null, b10.e());
                    if (obj2 != null) {
                        z10 = c0Var.k0(obj2);
                        obj = obj2;
                    }
                } else if (i10 != 5) {
                    obj = null;
                    z10 = false;
                }
            } else if (this.f4597e.b()) {
                obj2 = f4592l;
            }
            obj = obj2;
            z10 = true;
        }
        return m(dVar, J, oVar3, obj, z10);
    }

    @Override // a4.h
    public a4.h c(w3.h hVar) {
        return new h(this, this.f4593a, hVar, this.f4598f, this.f4599g, this.f4602j, this.f4603k);
    }

    public final k3.o e(k kVar, Class cls, c0 c0Var) {
        k.d g10 = kVar.g(cls, c0Var, this.f4593a);
        k kVar2 = g10.f4620b;
        if (kVar != kVar2) {
            this.f4601i = kVar2;
        }
        return g10.f4619a;
    }

    public final k3.o f(k kVar, k3.j jVar, c0 c0Var) {
        k.d h10 = kVar.h(jVar, c0Var, this.f4593a);
        k kVar2 = h10.f4620b;
        if (kVar != kVar2) {
            this.f4601i = kVar2;
        }
        return h10.f4619a;
    }

    public k3.j g() {
        return this.f4597e;
    }

    @Override // k3.o
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean isEmpty(c0 c0Var, Map.Entry entry) {
        Object value = entry.getValue();
        if (value == null) {
            return this.f4603k;
        }
        if (this.f4602j == null) {
            return false;
        }
        k3.o oVar = this.f4599g;
        if (oVar == null) {
            Class<?> cls = value.getClass();
            k3.o j10 = this.f4601i.j(cls);
            if (j10 == null) {
                try {
                    oVar = e(this.f4601i, cls, c0Var);
                } catch (k3.l unused) {
                    return false;
                }
            } else {
                oVar = j10;
            }
        }
        Object obj = this.f4602j;
        return obj == f4592l ? oVar.isEmpty(c0Var, value) : obj.equals(value);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void serialize(Map.Entry entry, c3.h hVar, c0 c0Var) {
        hVar.w0(entry);
        j(entry, hVar, c0Var);
        hVar.W();
    }

    public void j(Map.Entry entry, c3.h hVar, c0 c0Var) {
        k3.o oVar;
        w3.h hVar2 = this.f4600h;
        Object key = entry.getKey();
        k3.o K = key == null ? c0Var.K(this.f4596d, this.f4593a) : this.f4598f;
        Object value = entry.getValue();
        if (value != null) {
            oVar = this.f4599g;
            if (oVar == null) {
                Class<?> cls = value.getClass();
                k3.o j10 = this.f4601i.j(cls);
                oVar = j10 == null ? this.f4597e.w() ? f(this.f4601i, c0Var.A(this.f4597e, cls), c0Var) : e(this.f4601i, cls, c0Var) : j10;
            }
            Object obj = this.f4602j;
            if (obj != null && ((obj == f4592l && oVar.isEmpty(c0Var, value)) || this.f4602j.equals(value))) {
                return;
            }
        } else if (this.f4603k) {
            return;
        } else {
            oVar = c0Var.Z();
        }
        K.serialize(key, hVar, c0Var);
        try {
            if (hVar2 == null) {
                oVar.serialize(value, hVar, c0Var);
            } else {
                oVar.serializeWithType(value, hVar, c0Var, hVar2);
            }
        } catch (Exception e10) {
            wrapAndThrow(c0Var, e10, entry, "" + key);
        }
    }

    @Override // k3.o
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void serializeWithType(Map.Entry entry, c3.h hVar, c0 c0Var, w3.h hVar2) {
        hVar.z(entry);
        i3.b g10 = hVar2.g(hVar, hVar2.d(entry, c3.n.START_OBJECT));
        j(entry, hVar, c0Var);
        hVar2.h(hVar, g10);
    }

    public h l(Object obj, boolean z10) {
        return (this.f4602j == obj && this.f4603k == z10) ? this : new h(this, this.f4593a, this.f4600h, this.f4598f, this.f4599g, obj, z10);
    }

    public h m(k3.d dVar, k3.o oVar, k3.o oVar2, Object obj, boolean z10) {
        return new h(this, dVar, this.f4600h, oVar, oVar2, obj, z10);
    }

    public h(h hVar, k3.d dVar, w3.h hVar2, k3.o oVar, k3.o oVar2, Object obj, boolean z10) {
        super(Map.class, false);
        this.f4595c = hVar.f4595c;
        this.f4596d = hVar.f4596d;
        this.f4597e = hVar.f4597e;
        this.f4594b = hVar.f4594b;
        this.f4600h = hVar.f4600h;
        this.f4598f = oVar;
        this.f4599g = oVar2;
        this.f4601i = k.c();
        this.f4593a = hVar.f4593a;
        this.f4602j = obj;
        this.f4603k = z10;
    }
}
