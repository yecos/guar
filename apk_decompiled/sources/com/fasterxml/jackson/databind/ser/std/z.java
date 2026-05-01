package com.fasterxml.jackson.databind.ser.std;

import b3.r;
import l3.f;

/* loaded from: classes.dex */
public abstract class z extends i0 implements a4.i {

    /* renamed from: i, reason: collision with root package name */
    public static final Object f6747i = r.a.NON_EMPTY;

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f6748a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.d f6749b;

    /* renamed from: c, reason: collision with root package name */
    public final w3.h f6750c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.o f6751d;

    /* renamed from: e, reason: collision with root package name */
    public final d4.q f6752e;

    /* renamed from: f, reason: collision with root package name */
    public transient b4.k f6753f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f6754g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f6755h;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6756a;

        static {
            int[] iArr = new int[r.a.values().length];
            f6756a = iArr;
            try {
                iArr[r.a.NON_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6756a[r.a.NON_ABSENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6756a[r.a.NON_EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6756a[r.a.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6756a[r.a.NON_NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6756a[r.a.ALWAYS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public z(c4.j jVar, boolean z10, w3.h hVar, k3.o oVar) {
        super(jVar);
        this.f6748a = jVar.a();
        this.f6749b = null;
        this.f6750c = hVar;
        this.f6751d = oVar;
        this.f6752e = null;
        this.f6754g = null;
        this.f6755h = false;
        this.f6753f = b4.k.c();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        k3.o oVar = this.f6751d;
        if (oVar == null) {
            oVar = d(fVar.getProvider(), this.f6748a, this.f6749b);
            d4.q qVar = this.f6752e;
            if (qVar != null) {
                oVar = oVar.unwrappingSerializer(qVar);
            }
        }
        oVar.acceptJsonFormatVisitor(fVar, this.f6748a);
    }

    @Override // a4.i
    public k3.o b(k3.c0 c0Var, k3.d dVar) {
        r.b b10;
        r.a f10;
        Object b11;
        w3.h hVar = this.f6750c;
        if (hVar != null) {
            hVar = hVar.a(dVar);
        }
        k3.o findAnnotatedContentSerializer = findAnnotatedContentSerializer(c0Var, dVar);
        if (findAnnotatedContentSerializer == null) {
            findAnnotatedContentSerializer = this.f6751d;
            if (findAnnotatedContentSerializer != null) {
                findAnnotatedContentSerializer = c0Var.h0(findAnnotatedContentSerializer, dVar);
            } else if (h(c0Var, dVar, this.f6748a)) {
                findAnnotatedContentSerializer = d(c0Var, this.f6748a, dVar);
            }
        }
        z j10 = (this.f6749b == dVar && this.f6750c == hVar && this.f6751d == findAnnotatedContentSerializer) ? this : j(dVar, hVar, findAnnotatedContentSerializer, this.f6752e);
        if (dVar == null || (b10 = dVar.b(c0Var.k(), handledType())) == null || (f10 = b10.f()) == r.a.USE_DEFAULTS) {
            return j10;
        }
        int i10 = a.f6756a[f10.ordinal()];
        boolean z10 = true;
        if (i10 != 1) {
            b11 = null;
            if (i10 != 2) {
                if (i10 == 3) {
                    b11 = f6747i;
                } else if (i10 == 4) {
                    b11 = c0Var.j0(null, b10.e());
                    if (b11 != null) {
                        z10 = c0Var.k0(b11);
                    }
                } else if (i10 != 5) {
                    z10 = false;
                }
            } else if (this.f6748a.b()) {
                b11 = f6747i;
            }
        } else {
            b11 = d4.e.b(this.f6748a);
            if (b11 != null && b11.getClass().isArray()) {
                b11 = d4.c.a(b11);
            }
        }
        return (this.f6754g == b11 && this.f6755h == z10) ? j10 : j10.i(b11, z10);
    }

    public final k3.o c(k3.c0 c0Var, Class cls) {
        k3.o j10 = this.f6753f.j(cls);
        if (j10 != null) {
            return j10;
        }
        k3.o O = this.f6748a.w() ? c0Var.O(c0Var.A(this.f6748a, cls), this.f6749b) : c0Var.N(cls, this.f6749b);
        d4.q qVar = this.f6752e;
        if (qVar != null) {
            O = O.unwrappingSerializer(qVar);
        }
        k3.o oVar = O;
        this.f6753f = this.f6753f.i(cls, oVar);
        return oVar;
    }

    public final k3.o d(k3.c0 c0Var, k3.j jVar, k3.d dVar) {
        return c0Var.O(jVar, dVar);
    }

    public abstract Object e(Object obj);

    public abstract Object f(Object obj);

    public abstract boolean g(Object obj);

    public boolean h(k3.c0 c0Var, k3.d dVar, k3.j jVar) {
        if (jVar.I()) {
            return false;
        }
        if (jVar.G() || jVar.Q()) {
            return true;
        }
        k3.b W = c0Var.W();
        if (W != null && dVar != null && dVar.d() != null) {
            f.b X = W.X(dVar.d());
            if (X == f.b.STATIC) {
                return true;
            }
            if (X == f.b.DYNAMIC) {
                return false;
            }
        }
        return c0Var.l0(k3.q.USE_STATIC_TYPING);
    }

    public abstract z i(Object obj, boolean z10);

    @Override // k3.o
    public boolean isEmpty(k3.c0 c0Var, Object obj) {
        if (!g(obj)) {
            return true;
        }
        Object e10 = e(obj);
        if (e10 == null) {
            return this.f6755h;
        }
        if (this.f6754g == null) {
            return false;
        }
        k3.o oVar = this.f6751d;
        if (oVar == null) {
            try {
                oVar = c(c0Var, e10.getClass());
            } catch (k3.l e11) {
                throw new k3.z(e11);
            }
        }
        Object obj2 = this.f6754g;
        return obj2 == f6747i ? oVar.isEmpty(c0Var, e10) : obj2.equals(e10);
    }

    @Override // k3.o
    public boolean isUnwrappingSerializer() {
        return this.f6752e != null;
    }

    public abstract z j(k3.d dVar, w3.h hVar, k3.o oVar, d4.q qVar);

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
        Object f10 = f(obj);
        if (f10 == null) {
            if (this.f6752e == null) {
                c0Var.E(hVar);
                return;
            }
            return;
        }
        k3.o oVar = this.f6751d;
        if (oVar == null) {
            oVar = c(c0Var, f10.getClass());
        }
        w3.h hVar2 = this.f6750c;
        if (hVar2 != null) {
            oVar.serializeWithType(f10, hVar, c0Var, hVar2);
        } else {
            oVar.serialize(f10, hVar, c0Var);
        }
    }

    @Override // k3.o
    public void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        Object f10 = f(obj);
        if (f10 == null) {
            if (this.f6752e == null) {
                c0Var.E(hVar);
            }
        } else {
            k3.o oVar = this.f6751d;
            if (oVar == null) {
                oVar = c(c0Var, f10.getClass());
            }
            oVar.serializeWithType(f10, hVar, c0Var, hVar2);
        }
    }

    @Override // k3.o
    public k3.o unwrappingSerializer(d4.q qVar) {
        k3.o oVar = this.f6751d;
        if (oVar != null && (oVar = oVar.unwrappingSerializer(qVar)) == this.f6751d) {
            return this;
        }
        d4.q qVar2 = this.f6752e;
        if (qVar2 != null) {
            qVar = d4.q.a(qVar, qVar2);
        }
        return (this.f6751d == oVar && this.f6752e == qVar) ? this : j(this.f6749b, this.f6750c, oVar, qVar);
    }

    public z(z zVar, k3.d dVar, w3.h hVar, k3.o oVar, d4.q qVar, Object obj, boolean z10) {
        super(zVar);
        this.f6748a = zVar.f6748a;
        this.f6753f = b4.k.c();
        this.f6749b = dVar;
        this.f6750c = hVar;
        this.f6751d = oVar;
        this.f6752e = qVar;
        this.f6754g = obj;
        this.f6755h = z10;
    }
}
