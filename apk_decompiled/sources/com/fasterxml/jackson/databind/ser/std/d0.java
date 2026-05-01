package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class d0 extends i0 implements a4.i, a4.o {

    /* renamed from: a, reason: collision with root package name */
    public final d4.j f6682a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.j f6683b;

    /* renamed from: c, reason: collision with root package name */
    public final k3.o f6684c;

    public d0(d4.j jVar, k3.j jVar2, k3.o oVar) {
        super(jVar2);
        this.f6682a = jVar;
        this.f6683b = jVar2;
        this.f6684c = oVar;
    }

    @Override // a4.o
    public void a(k3.c0 c0Var) {
        Object obj = this.f6684c;
        if (obj == null || !(obj instanceof a4.o)) {
            return;
        }
        ((a4.o) obj).a(c0Var);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        k3.o oVar = this.f6684c;
        if (oVar != null) {
            oVar.acceptJsonFormatVisitor(fVar, jVar);
        }
    }

    @Override // a4.i
    public k3.o b(k3.c0 c0Var, k3.d dVar) {
        k3.o oVar = this.f6684c;
        k3.j jVar = this.f6683b;
        if (oVar == null) {
            if (jVar == null) {
                jVar = this.f6682a.a(c0Var.l());
            }
            if (!jVar.I()) {
                oVar = c0Var.T(jVar);
            }
        }
        if (oVar instanceof a4.i) {
            oVar = c0Var.i0(oVar, dVar);
        }
        return (oVar == this.f6684c && jVar == this.f6683b) ? this : e(this.f6682a, jVar, oVar);
    }

    public k3.o c(Object obj, k3.c0 c0Var) {
        return c0Var.R(obj.getClass());
    }

    public Object d(Object obj) {
        return this.f6682a.convert(obj);
    }

    public d0 e(d4.j jVar, k3.j jVar2, k3.o oVar) {
        d4.h.n0(d0.class, this, "withDelegate");
        return new d0(jVar, jVar2, oVar);
    }

    @Override // k3.o
    public k3.o getDelegatee() {
        return this.f6684c;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        Object obj = this.f6684c;
        return obj instanceof v3.c ? ((v3.c) obj).getSchema(c0Var, type) : super.getSchema(c0Var, type);
    }

    @Override // k3.o
    public boolean isEmpty(k3.c0 c0Var, Object obj) {
        Object d10 = d(obj);
        if (d10 == null) {
            return true;
        }
        k3.o oVar = this.f6684c;
        return oVar == null ? obj == null : oVar.isEmpty(c0Var, d10);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
        Object d10 = d(obj);
        if (d10 == null) {
            c0Var.E(hVar);
            return;
        }
        k3.o oVar = this.f6684c;
        if (oVar == null) {
            oVar = c(d10, c0Var);
        }
        oVar.serialize(d10, hVar, c0Var);
    }

    @Override // k3.o
    public void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        Object d10 = d(obj);
        k3.o oVar = this.f6684c;
        if (oVar == null) {
            oVar = c(obj, c0Var);
        }
        oVar.serializeWithType(d10, hVar, c0Var, hVar2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type, boolean z10) {
        Object obj = this.f6684c;
        if (obj instanceof v3.c) {
            return ((v3.c) obj).getSchema(c0Var, type, z10);
        }
        return super.getSchema(c0Var, type);
    }
}
