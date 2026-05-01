package n3;

import java.io.Closeable;
import java.io.Serializable;
import java.util.Map;
import o3.z;

/* loaded from: classes.dex */
public class s implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final k3.d f17239a;

    /* renamed from: b, reason: collision with root package name */
    public final r3.i f17240b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17241c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.j f17242d;

    /* renamed from: e, reason: collision with root package name */
    public k3.k f17243e;

    /* renamed from: f, reason: collision with root package name */
    public final w3.e f17244f;

    /* renamed from: g, reason: collision with root package name */
    public final k3.p f17245g;

    public static class a extends z.a {

        /* renamed from: c, reason: collision with root package name */
        public final s f17246c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f17247d;

        /* renamed from: e, reason: collision with root package name */
        public final String f17248e;

        public a(s sVar, u uVar, Class cls, Object obj, String str) {
            super(uVar, cls);
            this.f17246c = sVar;
            this.f17247d = obj;
            this.f17248e = str;
        }
    }

    public s(k3.d dVar, r3.i iVar, k3.j jVar, k3.p pVar, k3.k kVar, w3.e eVar) {
        this.f17239a = dVar;
        this.f17240b = iVar;
        this.f17242d = jVar;
        this.f17243e = kVar;
        this.f17244f = eVar;
        this.f17245g = pVar;
        this.f17241c = iVar instanceof r3.g;
    }

    public void a(Exception exc, Object obj, Object obj2) {
        if (!(exc instanceof IllegalArgumentException)) {
            d4.h.i0(exc);
            d4.h.j0(exc);
            Throwable F = d4.h.F(exc);
            throw new k3.l((Closeable) null, d4.h.o(F), F);
        }
        String h10 = d4.h.h(obj2);
        StringBuilder sb = new StringBuilder("Problem deserializing \"any\" property '");
        sb.append(obj);
        sb.append("' of class " + e() + " (expected type: ");
        sb.append(this.f17242d);
        sb.append("; actual type: ");
        sb.append(h10);
        sb.append(")");
        String o10 = d4.h.o(exc);
        if (o10 != null) {
            sb.append(", problem: ");
            sb.append(o10);
        } else {
            sb.append(" (no error message provided)");
        }
        throw new k3.l((Closeable) null, sb.toString(), exc);
    }

    public Object b(c3.k kVar, k3.g gVar) {
        if (kVar.j0(c3.n.VALUE_NULL)) {
            return this.f17243e.getNullValue(gVar);
        }
        w3.e eVar = this.f17244f;
        return eVar != null ? this.f17243e.deserializeWithType(kVar, gVar, eVar) : this.f17243e.deserialize(kVar, gVar);
    }

    public final void c(c3.k kVar, k3.g gVar, Object obj, String str) {
        try {
            k3.p pVar = this.f17245g;
            i(obj, pVar == null ? str : pVar.a(str, gVar), b(kVar, gVar));
        } catch (u e10) {
            if (this.f17243e.getObjectIdReader() == null) {
                throw k3.l.i(kVar, "Unresolved forward reference but no identity info.", e10);
            }
            e10.t().a(new a(this, e10, this.f17242d.q(), obj, str));
        }
    }

    public void d(k3.f fVar) {
        this.f17240b.i(fVar.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public final String e() {
        return this.f17240b.k().getName();
    }

    public k3.d f() {
        return this.f17239a;
    }

    public k3.j g() {
        return this.f17242d;
    }

    public boolean h() {
        return this.f17243e != null;
    }

    public void i(Object obj, Object obj2, Object obj3) {
        try {
            if (this.f17241c) {
                Map map = (Map) ((r3.g) this.f17240b).n(obj);
                if (map != null) {
                    map.put(obj2, obj3);
                }
            } else {
                ((r3.j) this.f17240b).z(obj, obj2, obj3);
            }
        } catch (Exception e10) {
            a(e10, obj2, obj3);
        }
    }

    public s j(k3.k kVar) {
        return new s(this.f17239a, this.f17240b, this.f17242d, this.f17245g, kVar, this.f17244f);
    }

    public String toString() {
        return "[any property on class " + e() + "]";
    }
}
