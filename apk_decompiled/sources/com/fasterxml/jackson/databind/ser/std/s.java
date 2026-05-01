package com.fasterxml.jackson.databind.ser.std;

import b3.e0;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class s extends i0 implements a4.i {

    /* renamed from: a, reason: collision with root package name */
    public final r3.i f6703a;

    /* renamed from: b, reason: collision with root package name */
    public final w3.h f6704b;

    /* renamed from: c, reason: collision with root package name */
    public final k3.o f6705c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.d f6706d;

    /* renamed from: e, reason: collision with root package name */
    public final k3.j f6707e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f6708f;

    /* renamed from: g, reason: collision with root package name */
    public transient b4.k f6709g;

    public static class a extends w3.h {

        /* renamed from: a, reason: collision with root package name */
        public final w3.h f6710a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f6711b;

        public a(w3.h hVar, Object obj) {
            this.f6710a = hVar;
            this.f6711b = obj;
        }

        @Override // w3.h
        public w3.h a(k3.d dVar) {
            throw new UnsupportedOperationException();
        }

        @Override // w3.h
        public String b() {
            return this.f6710a.b();
        }

        @Override // w3.h
        public e0.a c() {
            return this.f6710a.c();
        }

        @Override // w3.h
        public i3.b g(c3.h hVar, i3.b bVar) {
            bVar.f14298a = this.f6711b;
            return this.f6710a.g(hVar, bVar);
        }

        @Override // w3.h
        public i3.b h(c3.h hVar, i3.b bVar) {
            return this.f6710a.h(hVar, bVar);
        }
    }

    public s(r3.i iVar, w3.h hVar, k3.o oVar) {
        super(iVar.f());
        this.f6703a = iVar;
        this.f6707e = iVar.f();
        this.f6704b = hVar;
        this.f6705c = oVar;
        this.f6706d = null;
        this.f6708f = true;
        this.f6709g = b4.k.c();
    }

    public static final Class e(Class cls) {
        return cls == null ? Object.class : cls;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        Class k10 = this.f6703a.k();
        if (k10 != null && d4.h.L(k10) && c(fVar, jVar, k10)) {
            return;
        }
        k3.o oVar = this.f6705c;
        if (oVar == null && (oVar = fVar.getProvider().Q(this.f6707e, false, this.f6706d)) == null) {
            fVar.c(jVar);
        } else {
            oVar.acceptJsonFormatVisitor(fVar, this.f6707e);
        }
    }

    @Override // a4.i
    public k3.o b(k3.c0 c0Var, k3.d dVar) {
        w3.h hVar = this.f6704b;
        if (hVar != null) {
            hVar = hVar.a(dVar);
        }
        k3.o oVar = this.f6705c;
        if (oVar != null) {
            return g(dVar, hVar, c0Var.h0(oVar, dVar), this.f6708f);
        }
        if (!c0Var.l0(k3.q.USE_STATIC_TYPING) && !this.f6707e.G()) {
            return dVar != this.f6706d ? g(dVar, hVar, oVar, this.f6708f) : this;
        }
        k3.o O = c0Var.O(this.f6707e, dVar);
        return g(dVar, hVar, O, f(this.f6707e.q(), O));
    }

    public boolean c(u3.f fVar, k3.j jVar, Class cls) {
        fVar.a(jVar);
        return true;
    }

    public k3.o d(k3.c0 c0Var, Class cls) {
        k3.o j10 = this.f6709g.j(cls);
        if (j10 != null) {
            return j10;
        }
        if (!this.f6707e.w()) {
            k3.o N = c0Var.N(cls, this.f6706d);
            this.f6709g = this.f6709g.a(cls, N).f4620b;
            return N;
        }
        k3.j A = c0Var.A(this.f6707e, cls);
        k3.o O = c0Var.O(A, this.f6706d);
        this.f6709g = this.f6709g.b(A, O).f4620b;
        return O;
    }

    public boolean f(Class cls, k3.o oVar) {
        if (cls.isPrimitive()) {
            if (cls != Integer.TYPE && cls != Boolean.TYPE && cls != Double.TYPE) {
                return false;
            }
        } else if (cls != String.class && cls != Integer.class && cls != Boolean.class && cls != Double.class) {
            return false;
        }
        return isDefaultSerializer(oVar);
    }

    public s g(k3.d dVar, w3.h hVar, k3.o oVar, boolean z10) {
        return (this.f6706d == dVar && this.f6704b == hVar && this.f6705c == oVar && z10 == this.f6708f) ? this : new s(this, dVar, hVar, oVar, z10);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        Object obj = this.f6705c;
        return obj instanceof v3.c ? ((v3.c) obj).getSchema(c0Var, null) : v3.a.a();
    }

    @Override // k3.o
    public boolean isEmpty(k3.c0 c0Var, Object obj) {
        Object n10 = this.f6703a.n(obj);
        if (n10 == null) {
            return true;
        }
        k3.o oVar = this.f6705c;
        if (oVar == null) {
            try {
                oVar = d(c0Var, n10.getClass());
            } catch (k3.l e10) {
                throw new k3.z(e10);
            }
        }
        return oVar.isEmpty(c0Var, n10);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
        Object obj2;
        try {
            obj2 = this.f6703a.n(obj);
        } catch (Exception e10) {
            wrapAndThrow(c0Var, e10, obj, this.f6703a.d() + "()");
            obj2 = null;
        }
        if (obj2 == null) {
            c0Var.E(hVar);
            return;
        }
        k3.o oVar = this.f6705c;
        if (oVar == null) {
            oVar = d(c0Var, obj2.getClass());
        }
        w3.h hVar2 = this.f6704b;
        if (hVar2 != null) {
            oVar.serializeWithType(obj2, hVar, c0Var, hVar2);
        } else {
            oVar.serialize(obj2, hVar, c0Var);
        }
    }

    @Override // k3.o
    public void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        Object obj2;
        try {
            obj2 = this.f6703a.n(obj);
        } catch (Exception e10) {
            wrapAndThrow(c0Var, e10, obj, this.f6703a.d() + "()");
            obj2 = null;
        }
        if (obj2 == null) {
            c0Var.E(hVar);
            return;
        }
        k3.o oVar = this.f6705c;
        if (oVar == null) {
            oVar = d(c0Var, obj2.getClass());
        } else if (this.f6708f) {
            i3.b g10 = hVar2.g(hVar, hVar2.d(obj, c3.n.VALUE_STRING));
            oVar.serialize(obj2, hVar, c0Var);
            hVar2.h(hVar, g10);
            return;
        }
        oVar.serializeWithType(obj2, hVar, c0Var, new a(hVar2, obj));
    }

    public String toString() {
        return "(@JsonValue serializer for method " + this.f6703a.k() + "#" + this.f6703a.d() + ")";
    }

    public s(s sVar, k3.d dVar, w3.h hVar, k3.o oVar, boolean z10) {
        super(e(sVar.handledType()));
        this.f6703a = sVar.f6703a;
        this.f6707e = sVar.f6707e;
        this.f6704b = hVar;
        this.f6705c = oVar;
        this.f6706d = dVar;
        this.f6708f = z10;
        this.f6709g = b4.k.c();
    }
}
