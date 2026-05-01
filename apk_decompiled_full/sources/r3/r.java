package r3;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import r3.t;

/* loaded from: classes.dex */
public class r extends t implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f18475a = Object.class;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f18476b = String.class;

    /* renamed from: c, reason: collision with root package name */
    public static final Class f18477c = k3.m.class;

    /* renamed from: d, reason: collision with root package name */
    public static final q f18478d = q.I(null, c4.l.b0(String.class), d.h(String.class));

    /* renamed from: e, reason: collision with root package name */
    public static final q f18479e;

    /* renamed from: f, reason: collision with root package name */
    public static final q f18480f;

    /* renamed from: g, reason: collision with root package name */
    public static final q f18481g;

    /* renamed from: h, reason: collision with root package name */
    public static final q f18482h;

    static {
        Class cls = Boolean.TYPE;
        f18479e = q.I(null, c4.l.b0(cls), d.h(cls));
        Class cls2 = Integer.TYPE;
        f18480f = q.I(null, c4.l.b0(cls2), d.h(cls2));
        Class cls3 = Long.TYPE;
        f18481g = q.I(null, c4.l.b0(cls3), d.h(cls3));
        f18482h = q.I(null, c4.l.b0(Object.class), d.h(Object.class));
    }

    public q f(m3.m mVar, k3.j jVar) {
        if (h(jVar)) {
            return q.I(mVar, jVar, i(mVar, jVar, mVar));
        }
        return null;
    }

    public q g(m3.m mVar, k3.j jVar) {
        Class<?> q10 = jVar.q();
        if (q10.isPrimitive()) {
            if (q10 == Integer.TYPE) {
                return f18480f;
            }
            if (q10 == Long.TYPE) {
                return f18481g;
            }
            if (q10 == Boolean.TYPE) {
                return f18479e;
            }
            return null;
        }
        if (!d4.h.M(q10)) {
            if (f18477c.isAssignableFrom(q10)) {
                return q.I(mVar, jVar, d.h(q10));
            }
            return null;
        }
        if (q10 == f18475a) {
            return f18482h;
        }
        if (q10 == f18476b) {
            return f18478d;
        }
        if (q10 == Integer.class) {
            return f18480f;
        }
        if (q10 == Long.class) {
            return f18481g;
        }
        if (q10 == Boolean.class) {
            return f18479e;
        }
        return null;
    }

    public boolean h(k3.j jVar) {
        if (jVar.D() && !jVar.A()) {
            Class q10 = jVar.q();
            if (d4.h.M(q10) && (Collection.class.isAssignableFrom(q10) || Map.class.isAssignableFrom(q10))) {
                return true;
            }
        }
        return false;
    }

    public c i(m3.m mVar, k3.j jVar, t.a aVar) {
        return d.i(mVar, jVar, aVar);
    }

    public c0 j(m3.m mVar, k3.j jVar, t.a aVar, boolean z10) {
        c i10 = i(mVar, jVar, aVar);
        return l(mVar, i10, jVar, z10, jVar.L() ? mVar.f().c(mVar, i10) : mVar.f().b(mVar, i10));
    }

    public c0 k(m3.m mVar, k3.j jVar, t.a aVar, k3.c cVar, boolean z10) {
        c i10 = i(mVar, jVar, aVar);
        return l(mVar, i10, jVar, z10, mVar.f().a(mVar, i10, cVar));
    }

    public c0 l(m3.m mVar, c cVar, k3.j jVar, boolean z10, a aVar) {
        return new c0(mVar, z10, jVar, cVar, aVar);
    }

    @Override // r3.t
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public q a(m3.m mVar, k3.j jVar, t.a aVar) {
        q g10 = g(mVar, jVar);
        return g10 == null ? q.I(mVar, jVar, i(mVar, jVar, aVar)) : g10;
    }

    @Override // r3.t
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public q b(k3.f fVar, k3.j jVar, t.a aVar) {
        q g10 = g(fVar, jVar);
        if (g10 != null) {
            return g10;
        }
        q f10 = f(fVar, jVar);
        return f10 == null ? q.H(j(fVar, jVar, aVar, false)) : f10;
    }

    @Override // r3.t
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public q c(k3.f fVar, k3.j jVar, t.a aVar) {
        q g10 = g(fVar, jVar);
        if (g10 != null) {
            return g10;
        }
        q f10 = f(fVar, jVar);
        return f10 == null ? q.H(j(fVar, jVar, aVar, false)) : f10;
    }

    @Override // r3.t
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public q d(k3.f fVar, k3.j jVar, t.a aVar, k3.c cVar) {
        return q.H(k(fVar, jVar, aVar, cVar, false));
    }

    @Override // r3.t
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public q e(k3.a0 a0Var, k3.j jVar, t.a aVar) {
        q g10 = g(a0Var, jVar);
        if (g10 != null) {
            return g10;
        }
        q f10 = f(a0Var, jVar);
        return f10 == null ? q.J(j(a0Var, jVar, aVar, true)) : f10;
    }
}
