package com.fasterxml.jackson.databind.ser.std;

import b4.k;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final k3.o f6687a = new f0();

    /* renamed from: b, reason: collision with root package name */
    public static final k3.o f6688b = new d();

    public static class a extends i0 {

        /* renamed from: a, reason: collision with root package name */
        public final int f6689a;

        public a(int i10, Class cls) {
            super(cls, false);
            this.f6689a = i10;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
            String valueOf;
            switch (this.f6689a) {
                case 1:
                    c0Var.C((Date) obj, hVar);
                    break;
                case 2:
                    c0Var.B(((Calendar) obj).getTimeInMillis(), hVar);
                    break;
                case 3:
                    hVar.Z(((Class) obj).getName());
                    break;
                case 4:
                    if (c0Var.m0(k3.b0.WRITE_ENUMS_USING_TO_STRING)) {
                        valueOf = obj.toString();
                    } else {
                        Enum r32 = (Enum) obj;
                        valueOf = c0Var.m0(k3.b0.WRITE_ENUM_KEYS_USING_INDEX) ? String.valueOf(r32.ordinal()) : r32.name();
                    }
                    hVar.Z(valueOf);
                    break;
                case 5:
                case 6:
                    hVar.X(((Number) obj).longValue());
                    break;
                case 7:
                    hVar.Z(c0Var.k().h().h((byte[]) obj));
                    break;
                default:
                    hVar.Z(obj.toString());
                    break;
            }
        }
    }

    public static class b extends i0 {

        /* renamed from: a, reason: collision with root package name */
        public transient b4.k f6690a;

        public b() {
            super(String.class, false);
            this.f6690a = b4.k.c();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
            visitStringFormat(fVar, jVar);
        }

        public k3.o c(b4.k kVar, Class cls, k3.c0 c0Var) {
            if (cls == Object.class) {
                a aVar = new a(8, cls);
                this.f6690a = kVar.i(cls, aVar);
                return aVar;
            }
            k.d d10 = kVar.d(cls, c0Var, null);
            b4.k kVar2 = d10.f4620b;
            if (kVar != kVar2) {
                this.f6690a = kVar2;
            }
            return d10.f4619a;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
            Class<?> cls = obj.getClass();
            b4.k kVar = this.f6690a;
            k3.o j10 = kVar.j(cls);
            if (j10 == null) {
                j10 = c(kVar, cls, c0Var);
            }
            j10.serialize(obj, hVar, c0Var);
        }
    }

    public static class c extends i0 {

        /* renamed from: a, reason: collision with root package name */
        public final d4.l f6691a;

        public c(Class cls, d4.l lVar) {
            super(cls, false);
            this.f6691a = lVar;
        }

        public static c c(Class cls, d4.l lVar) {
            return new c(cls, lVar);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
            if (c0Var.m0(k3.b0.WRITE_ENUMS_USING_TO_STRING)) {
                hVar.Z(obj.toString());
                return;
            }
            Enum r22 = (Enum) obj;
            if (c0Var.m0(k3.b0.WRITE_ENUM_KEYS_USING_INDEX)) {
                hVar.Z(String.valueOf(r22.ordinal()));
            } else {
                hVar.Y(this.f6691a.d(r22));
            }
        }
    }

    public static class d extends i0 {
        public d() {
            super(String.class, false);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
            hVar.Z((String) obj);
        }
    }

    public static k3.o a(k3.a0 a0Var, Class cls) {
        if (cls != null) {
            if (cls == Enum.class) {
                return new b();
            }
            if (d4.h.L(cls)) {
                return c.c(cls, d4.l.b(a0Var, cls));
            }
        }
        return new a(8, cls);
    }

    public static k3.o b(k3.a0 a0Var, Class cls, boolean z10) {
        if (cls == null || cls == Object.class) {
            return new b();
        }
        if (cls == String.class) {
            return f6688b;
        }
        if (cls.isPrimitive()) {
            cls = d4.h.o0(cls);
        }
        if (cls == Integer.class) {
            return new a(5, cls);
        }
        if (cls == Long.class) {
            return new a(6, cls);
        }
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) {
            return new a(8, cls);
        }
        if (cls == Class.class) {
            return new a(3, cls);
        }
        if (Date.class.isAssignableFrom(cls)) {
            return new a(1, cls);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            return new a(2, cls);
        }
        if (cls == UUID.class) {
            return new a(8, cls);
        }
        if (cls == byte[].class) {
            return new a(7, cls);
        }
        if (z10) {
            return new a(8, cls);
        }
        return null;
    }
}
