package r3;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r3.t;

/* loaded from: classes.dex */
public class d {

    /* renamed from: i, reason: collision with root package name */
    public static final d4.b f18377i = o.d();

    /* renamed from: j, reason: collision with root package name */
    public static final Class f18378j = Object.class;

    /* renamed from: k, reason: collision with root package name */
    public static final Class f18379k = Enum.class;

    /* renamed from: l, reason: collision with root package name */
    public static final Class f18380l = List.class;

    /* renamed from: m, reason: collision with root package name */
    public static final Class f18381m = Map.class;

    /* renamed from: a, reason: collision with root package name */
    public final m3.m f18382a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.b f18383b;

    /* renamed from: c, reason: collision with root package name */
    public final t.a f18384c;

    /* renamed from: d, reason: collision with root package name */
    public final c4.n f18385d;

    /* renamed from: e, reason: collision with root package name */
    public final k3.j f18386e;

    /* renamed from: f, reason: collision with root package name */
    public final Class f18387f;

    /* renamed from: g, reason: collision with root package name */
    public final Class f18388g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f18389h;

    public d(m3.m mVar, k3.j jVar, t.a aVar) {
        this.f18382a = mVar;
        this.f18386e = jVar;
        Class q10 = jVar.q();
        this.f18387f = q10;
        this.f18384c = aVar;
        this.f18385d = jVar.j();
        k3.b g10 = mVar.C() ? mVar.g() : null;
        this.f18383b = g10;
        this.f18388g = aVar != null ? aVar.a(q10) : null;
        this.f18389h = (g10 == null || (d4.h.M(q10) && jVar.D())) ? false : true;
    }

    public static void d(k3.j jVar, List list, boolean z10) {
        Class q10 = jVar.q();
        if (z10) {
            if (f(list, q10)) {
                return;
            }
            list.add(jVar);
            if (q10 == f18380l || q10 == f18381m) {
                return;
            }
        }
        Iterator it = jVar.o().iterator();
        while (it.hasNext()) {
            d((k3.j) it.next(), list, true);
        }
    }

    public static void e(k3.j jVar, List list, boolean z10) {
        Class q10 = jVar.q();
        if (q10 == f18378j || q10 == f18379k) {
            return;
        }
        if (z10) {
            if (f(list, q10)) {
                return;
            } else {
                list.add(jVar);
            }
        }
        Iterator it = jVar.o().iterator();
        while (it.hasNext()) {
            d((k3.j) it.next(), list, true);
        }
        k3.j s10 = jVar.s();
        if (s10 != null) {
            e(s10, list, true);
        }
    }

    public static boolean f(List list, Class cls) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((k3.j) list.get(i10)).q() == cls) {
                return true;
            }
        }
        return false;
    }

    public static c g(m3.m mVar, Class cls) {
        return new c(cls);
    }

    public static c h(Class cls) {
        return new c(cls);
    }

    public static c i(m3.m mVar, k3.j jVar, t.a aVar) {
        return (jVar.A() && o(mVar, jVar.q())) ? g(mVar, jVar.q()) : new d(mVar, jVar, aVar).k();
    }

    public static c m(m3.m mVar, Class cls) {
        return n(mVar, cls, mVar);
    }

    public static c n(m3.m mVar, Class cls, t.a aVar) {
        return (cls.isArray() && o(mVar, cls)) ? g(mVar, cls) : new d(mVar, cls, aVar).l();
    }

    public static boolean o(m3.m mVar, Class cls) {
        return mVar == null || mVar.a(cls) == null;
    }

    public final o a(o oVar, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!oVar.f(annotation)) {
                    oVar = oVar.a(annotation);
                    if (this.f18383b.q0(annotation)) {
                        oVar = c(oVar, annotation);
                    }
                }
            }
        }
        return oVar;
    }

    public final o b(o oVar, Class cls, Class cls2) {
        if (cls2 != null) {
            oVar = a(oVar, d4.h.p(cls2));
            Iterator it = d4.h.x(cls2, cls, false).iterator();
            while (it.hasNext()) {
                oVar = a(oVar, d4.h.p((Class) it.next()));
            }
        }
        return oVar;
    }

    public final o c(o oVar, Annotation annotation) {
        for (Annotation annotation2 : d4.h.p(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !oVar.f(annotation2)) {
                oVar = oVar.a(annotation2);
                if (this.f18383b.q0(annotation2)) {
                    oVar = c(oVar, annotation2);
                }
            }
        }
        return oVar;
    }

    public final d4.b j(List list) {
        if (this.f18383b == null) {
            return f18377i;
        }
        t.a aVar = this.f18384c;
        boolean z10 = aVar != null && (!(aVar instanceof e0) || ((e0) aVar).c());
        if (!z10 && !this.f18389h) {
            return f18377i;
        }
        o e10 = o.e();
        Class cls = this.f18388g;
        if (cls != null) {
            e10 = b(e10, this.f18387f, cls);
        }
        if (this.f18389h) {
            e10 = a(e10, d4.h.p(this.f18387f));
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k3.j jVar = (k3.j) it.next();
            if (z10) {
                Class q10 = jVar.q();
                e10 = b(e10, q10, this.f18384c.a(q10));
            }
            if (this.f18389h) {
                e10 = a(e10, d4.h.p(jVar.q()));
            }
        }
        if (z10) {
            e10 = b(e10, Object.class, this.f18384c.a(Object.class));
        }
        return e10.c();
    }

    public c k() {
        ArrayList arrayList = new ArrayList(8);
        if (!this.f18386e.y(Object.class)) {
            if (this.f18386e.H()) {
                d(this.f18386e, arrayList, false);
            } else {
                e(this.f18386e, arrayList, false);
            }
        }
        return new c(this.f18386e, this.f18387f, arrayList, this.f18388g, j(arrayList), this.f18385d, this.f18383b, this.f18384c, this.f18382a.z(), this.f18389h);
    }

    public c l() {
        List emptyList = Collections.emptyList();
        return new c(null, this.f18387f, emptyList, this.f18388g, j(emptyList), this.f18385d, this.f18383b, this.f18384c, this.f18382a.z(), this.f18389h);
    }

    public d(m3.m mVar, Class cls, t.a aVar) {
        this.f18382a = mVar;
        this.f18386e = null;
        this.f18387f = cls;
        this.f18384c = aVar;
        this.f18385d = c4.n.i();
        if (mVar == null) {
            this.f18383b = null;
            this.f18388g = null;
        } else {
            this.f18383b = mVar.C() ? mVar.g() : null;
            this.f18388g = aVar != null ? aVar.a(cls) : null;
        }
        this.f18389h = this.f18383b != null;
    }
}
