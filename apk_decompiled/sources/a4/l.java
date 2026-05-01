package a4;

import b3.r;
import k3.a0;
import k3.b0;
import k3.c0;
import l3.f;

/* loaded from: classes.dex */
public class l {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f214g = Boolean.FALSE;

    /* renamed from: a, reason: collision with root package name */
    public final a0 f215a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.c f216b;

    /* renamed from: c, reason: collision with root package name */
    public final k3.b f217c;

    /* renamed from: d, reason: collision with root package name */
    public Object f218d;

    /* renamed from: e, reason: collision with root package name */
    public final r.b f219e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f220f;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f221a;

        static {
            int[] iArr = new int[r.a.values().length];
            f221a = iArr;
            try {
                iArr[r.a.NON_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f221a[r.a.NON_ABSENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f221a[r.a.NON_EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f221a[r.a.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f221a[r.a.NON_NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f221a[r.a.ALWAYS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public l(a0 a0Var, k3.c cVar) {
        this.f215a = a0Var;
        this.f216b = cVar;
        r.b i10 = r.b.i(cVar.p(r.b.c()), a0Var.q(cVar.s(), r.b.c()));
        this.f219e = r.b.i(a0Var.P(), i10);
        this.f220f = i10.h() == r.a.NON_DEFAULT;
        this.f217c = a0Var.g();
    }

    public c a(r3.s sVar, r3.i iVar, d4.b bVar, k3.j jVar, k3.o oVar, w3.h hVar, k3.j jVar2, boolean z10, Object obj, Class[] clsArr) {
        return new c(sVar, iVar, bVar, jVar, oVar, hVar, jVar2, z10, obj, clsArr);
    }

    public Object b(Exception exc, String str, Object obj) {
        Exception exc2 = exc;
        while (exc2.getCause() != null) {
            exc2 = exc2.getCause();
        }
        d4.h.h0(exc2);
        d4.h.j0(exc2);
        throw new IllegalArgumentException("Failed to get property '" + str + "' of default " + obj.getClass().getName() + " instance");
    }

    public c c(c0 c0Var, r3.s sVar, k3.j jVar, k3.o oVar, w3.h hVar, w3.h hVar2, r3.i iVar, boolean z10) {
        k3.j jVar2;
        Object a10;
        Object e10;
        Object obj;
        boolean z11;
        try {
            k3.j d10 = d(iVar, z10, jVar);
            if (hVar2 != null) {
                if (d10 == null) {
                    d10 = jVar;
                }
                if (d10.k() == null) {
                    c0Var.p0(this.f216b, sVar, "serialization type " + d10 + " has no content", new Object[0]);
                }
                k3.j S = d10.S(hVar2);
                S.k();
                jVar2 = S;
            } else {
                jVar2 = d10;
            }
            k3.j jVar3 = jVar2 == null ? jVar : jVar2;
            r3.i l10 = sVar.l();
            if (l10 == null) {
                return (c) c0Var.p0(this.f216b, sVar, "could not determine property type", new Object[0]);
            }
            r.b m10 = this.f215a.m(jVar3.q(), l10.e(), this.f219e).m(sVar.g());
            r.a h10 = m10.h();
            if (h10 == r.a.USE_DEFAULTS) {
                h10 = r.a.ALWAYS;
            }
            int i10 = a.f221a[h10.ordinal()];
            Object obj2 = null;
            if (i10 != 1) {
                if (i10 == 2) {
                    if (jVar3.b()) {
                        a10 = c.f183t;
                    }
                    obj = obj2;
                    z11 = true;
                } else if (i10 != 3) {
                    if (i10 != 4) {
                        r1 = i10 == 5;
                        b0 b0Var = b0.WRITE_EMPTY_JSON_ARRAYS;
                        if (jVar3.D() && !this.f215a.c0(b0Var)) {
                            a10 = c.f183t;
                        }
                        z11 = r1;
                        obj = obj2;
                    } else {
                        a10 = c0Var.j0(sVar, m10.g());
                        if (a10 != null) {
                            r1 = c0Var.k0(a10);
                        }
                    }
                    obj = a10;
                    z11 = r1;
                } else {
                    a10 = c.f183t;
                }
                obj = a10;
                z11 = true;
            } else {
                if (!this.f220f || (e10 = e()) == null) {
                    obj2 = d4.e.b(jVar3);
                    r1 = true;
                } else {
                    if (c0Var.l0(k3.q.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                        iVar.i(this.f215a.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    try {
                        obj2 = iVar.n(e10);
                    } catch (Exception e11) {
                        b(e11, sVar.getName(), e10);
                    }
                }
                if (obj2 != null) {
                    if (obj2.getClass().isArray()) {
                        a10 = d4.c.a(obj2);
                        obj = a10;
                        z11 = r1;
                    }
                    z11 = r1;
                    obj = obj2;
                }
                obj = obj2;
                z11 = true;
            }
            Class[] k10 = sVar.k();
            if (k10 == null) {
                k10 = this.f216b.e();
            }
            c a11 = a(sVar, iVar, this.f216b.t(), jVar, oVar, hVar, jVar2, z11, obj, k10);
            Object A = this.f217c.A(iVar);
            if (A != null) {
                a11.k(c0Var.t0(iVar, A));
            }
            d4.q d02 = this.f217c.d0(iVar);
            return d02 != null ? a11.C(d02) : a11;
        } catch (k3.l e12) {
            return sVar == null ? (c) c0Var.q(jVar, d4.h.o(e12)) : (c) c0Var.p0(this.f216b, sVar, d4.h.o(e12), new Object[0]);
        }
    }

    public k3.j d(r3.b bVar, boolean z10, k3.j jVar) {
        k3.j v02 = this.f217c.v0(this.f215a, bVar, jVar);
        if (v02 != jVar) {
            Class<?> q10 = v02.q();
            Class<?> q11 = jVar.q();
            if (!q10.isAssignableFrom(q11) && !q11.isAssignableFrom(q10)) {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + bVar.d() + "': class " + q10.getName() + " not a super-type of (declared) class " + q11.getName());
            }
            jVar = v02;
            z10 = true;
        }
        f.b X = this.f217c.X(bVar);
        if (X != null && X != f.b.DEFAULT_TYPING) {
            z10 = X == f.b.STATIC;
        }
        if (z10) {
            return jVar.d0();
        }
        return null;
    }

    public Object e() {
        Object obj = this.f218d;
        if (obj == null) {
            obj = this.f216b.B(this.f215a.b());
            if (obj == null) {
                obj = f214g;
            }
            this.f218d = obj;
        }
        if (obj == f214g) {
            return null;
        }
        return this.f218d;
    }
}
