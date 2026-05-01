package com.fasterxml.jackson.databind.deser.std;

import c3.k;

/* loaded from: classes.dex */
public abstract class f extends b0 {

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f6512a;

    public f(Class cls, Boolean bool) {
        super(cls);
        this.f6512a = bool;
    }

    public final k3.m a(c3.k kVar, k3.g gVar, z3.l lVar) {
        Object N = kVar.N();
        return N == null ? lVar.d() : N.getClass() == byte[].class ? lVar.b((byte[]) N) : N instanceof d4.u ? lVar.m((d4.u) N) : N instanceof k3.m ? (k3.m) N : lVar.l(N);
    }

    public final k3.m b(c3.k kVar, k3.g gVar, z3.l lVar) {
        k.b R = kVar.R();
        return R == k.b.BIG_DECIMAL ? lVar.i(kVar.L()) : gVar.n0(k3.h.USE_BIG_DECIMAL_FOR_FLOATS) ? kVar.p0() ? lVar.e(kVar.M()) : lVar.i(kVar.L()) : R == k.b.FLOAT ? lVar.f(kVar.O()) : lVar.e(kVar.M());
    }

    public final k3.m c(c3.k kVar, k3.g gVar, z3.l lVar) {
        int P = gVar.P();
        k.b R = (b0.F_MASK_INT_COERCIONS & P) != 0 ? k3.h.USE_BIG_INTEGER_FOR_INTS.c(P) ? k.b.BIG_INTEGER : k3.h.USE_LONG_FOR_INTS.c(P) ? k.b.LONG : kVar.R() : kVar.R();
        return R == k.b.INT ? lVar.g(kVar.P()) : R == k.b.LONG ? lVar.h(kVar.Q()) : lVar.j(kVar.s());
    }

    public void d(c3.k kVar, k3.g gVar, z3.l lVar, String str, z3.r rVar, k3.m mVar, k3.m mVar2) {
        if (gVar.n0(k3.h.FAIL_ON_READING_DUP_TREE_KEY)) {
            gVar.w0(k3.m.class, "Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", str);
        }
        if (gVar.m0(c3.r.DUPLICATE_PROPERTIES)) {
            if (mVar.p()) {
                ((z3.a) mVar).C(mVar2);
                rVar.F(str, mVar);
            } else {
                z3.a a10 = lVar.a();
                a10.C(mVar);
                a10.C(mVar2);
                rVar.F(str, a10);
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return eVar.c(kVar, gVar);
    }

    public final k3.m e(c3.k kVar, k3.g gVar, z3.l lVar) {
        int q10 = kVar.q();
        if (q10 == 2) {
            return lVar.k();
        }
        switch (q10) {
            case 5:
                return h(kVar, gVar, lVar);
            case 6:
                return lVar.n(kVar.Y());
            case 7:
                return c(kVar, gVar, lVar);
            case 8:
                return b(kVar, gVar, lVar);
            case 9:
                return lVar.c(true);
            case 10:
                return lVar.c(false);
            case 11:
                return lVar.d();
            case 12:
                return a(kVar, gVar, lVar);
            default:
                return (k3.m) gVar.a0(handledType(), kVar);
        }
    }

    public final z3.a f(c3.k kVar, k3.g gVar, z3.l lVar) {
        z3.a a10 = lVar.a();
        while (true) {
            c3.n s02 = kVar.s0();
            if (s02 == null) {
                return a10;
            }
            switch (s02.c()) {
                case 1:
                    a10.C(g(kVar, gVar, lVar));
                    break;
                case 2:
                case 5:
                case 8:
                default:
                    a10.C(e(kVar, gVar, lVar));
                    break;
                case 3:
                    a10.C(f(kVar, gVar, lVar));
                    break;
                case 4:
                    return a10;
                case 6:
                    a10.C(lVar.n(kVar.Y()));
                    break;
                case 7:
                    a10.C(c(kVar, gVar, lVar));
                    break;
                case 9:
                    a10.C(lVar.c(true));
                    break;
                case 10:
                    a10.C(lVar.c(false));
                    break;
                case 11:
                    a10.C(lVar.d());
                    break;
                case 12:
                    a10.C(a(kVar, gVar, lVar));
                    break;
            }
        }
    }

    public final z3.r g(c3.k kVar, k3.g gVar, z3.l lVar) {
        k3.m g10;
        z3.r k10 = lVar.k();
        String q02 = kVar.q0();
        while (q02 != null) {
            c3.n s02 = kVar.s0();
            if (s02 == null) {
                s02 = c3.n.NOT_AVAILABLE;
            }
            int c10 = s02.c();
            if (c10 == 1) {
                g10 = g(kVar, gVar, lVar);
            } else if (c10 == 3) {
                g10 = f(kVar, gVar, lVar);
            } else if (c10 == 6) {
                g10 = lVar.n(kVar.Y());
            } else if (c10 != 7) {
                switch (c10) {
                    case 9:
                        g10 = lVar.c(true);
                        break;
                    case 10:
                        g10 = lVar.c(false);
                        break;
                    case 11:
                        g10 = lVar.d();
                        break;
                    case 12:
                        g10 = a(kVar, gVar, lVar);
                        break;
                    default:
                        g10 = e(kVar, gVar, lVar);
                        break;
                }
            } else {
                g10 = c(kVar, gVar, lVar);
            }
            k3.m mVar = g10;
            k3.m F = k10.F(q02, mVar);
            if (F != null) {
                d(kVar, gVar, lVar, q02, k10, F, mVar);
            }
            q02 = kVar.q0();
        }
        return k10;
    }

    public final z3.r h(c3.k kVar, k3.g gVar, z3.l lVar) {
        k3.m g10;
        z3.r k10 = lVar.k();
        String m10 = kVar.m();
        while (m10 != null) {
            c3.n s02 = kVar.s0();
            if (s02 == null) {
                s02 = c3.n.NOT_AVAILABLE;
            }
            int c10 = s02.c();
            if (c10 == 1) {
                g10 = g(kVar, gVar, lVar);
            } else if (c10 == 3) {
                g10 = f(kVar, gVar, lVar);
            } else if (c10 == 6) {
                g10 = lVar.n(kVar.Y());
            } else if (c10 != 7) {
                switch (c10) {
                    case 9:
                        g10 = lVar.c(true);
                        break;
                    case 10:
                        g10 = lVar.c(false);
                        break;
                    case 11:
                        g10 = lVar.d();
                        break;
                    case 12:
                        g10 = a(kVar, gVar, lVar);
                        break;
                    default:
                        g10 = e(kVar, gVar, lVar);
                        break;
                }
            } else {
                g10 = c(kVar, gVar, lVar);
            }
            k3.m mVar = g10;
            k3.m F = k10.F(m10, mVar);
            if (F != null) {
                d(kVar, gVar, lVar, m10, k10, F, mVar);
            }
            m10 = kVar.q0();
        }
        return k10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final k3.m i(c3.k kVar, k3.g gVar, z3.a aVar) {
        z3.l R = gVar.R();
        while (true) {
            switch (kVar.s0().c()) {
                case 1:
                    aVar.C(g(kVar, gVar, R));
                    break;
                case 2:
                case 5:
                case 8:
                default:
                    aVar.C(e(kVar, gVar, R));
                    break;
                case 3:
                    aVar.C(f(kVar, gVar, R));
                    break;
                case 4:
                    break;
                case 6:
                    aVar.C(R.n(kVar.Y()));
                    break;
                case 7:
                    aVar.C(c(kVar, gVar, R));
                    break;
                case 9:
                    aVar.C(R.c(true));
                    break;
                case 10:
                    aVar.C(R.c(false));
                    break;
                case 11:
                    aVar.C(R.d());
                    break;
                case 12:
                    aVar.C(a(kVar, gVar, R));
                    break;
            }
        }
    }

    @Override // k3.k
    public boolean isCachable() {
        return true;
    }

    public final k3.m j(c3.k kVar, k3.g gVar, z3.r rVar) {
        String m10;
        k3.m g10;
        if (kVar.o0()) {
            m10 = kVar.q0();
        } else {
            if (!kVar.j0(c3.n.FIELD_NAME)) {
                return (k3.m) deserialize(kVar, gVar);
            }
            m10 = kVar.m();
        }
        while (m10 != null) {
            c3.n s02 = kVar.s0();
            k3.m n10 = rVar.n(m10);
            if (n10 != null) {
                if (n10 instanceof z3.r) {
                    if (s02 == c3.n.START_OBJECT) {
                        k3.m j10 = j(kVar, gVar, (z3.r) n10);
                        if (j10 != n10) {
                            rVar.G(m10, j10);
                        }
                    }
                } else if ((n10 instanceof z3.a) && s02 == c3.n.START_ARRAY) {
                    k3.m i10 = i(kVar, gVar, (z3.a) n10);
                    if (i10 != n10) {
                        rVar.G(m10, i10);
                    }
                }
                m10 = kVar.q0();
            }
            if (s02 == null) {
                s02 = c3.n.NOT_AVAILABLE;
            }
            z3.l R = gVar.R();
            int c10 = s02.c();
            if (c10 == 1) {
                g10 = g(kVar, gVar, R);
            } else if (c10 == 3) {
                g10 = f(kVar, gVar, R);
            } else if (c10 == 6) {
                g10 = R.n(kVar.Y());
            } else if (c10 != 7) {
                switch (c10) {
                    case 9:
                        g10 = R.c(true);
                        break;
                    case 10:
                        g10 = R.c(false);
                        break;
                    case 11:
                        g10 = R.d();
                        break;
                    case 12:
                        g10 = a(kVar, gVar, R);
                        break;
                    default:
                        g10 = e(kVar, gVar, R);
                        break;
                }
            } else {
                g10 = c(kVar, gVar, R);
            }
            rVar.G(m10, g10);
            m10 = kVar.q0();
        }
        return rVar;
    }

    @Override // k3.k
    public c4.f logicalType() {
        return c4.f.Untyped;
    }

    @Override // k3.k
    public Boolean supportsUpdate(k3.f fVar) {
        return this.f6512a;
    }
}
