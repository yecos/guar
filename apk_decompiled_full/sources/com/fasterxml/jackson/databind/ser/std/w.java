package com.fasterxml.jackson.databind.ser.std;

import b3.k;
import c3.k;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class w {

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6735a;

        static {
            int[] iArr = new int[k.c.values().length];
            f6735a = iArr;
            try {
                iArr[k.c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static abstract class b extends h0 implements a4.i {

        /* renamed from: a, reason: collision with root package name */
        public final k.b f6736a;

        /* renamed from: b, reason: collision with root package name */
        public final String f6737b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f6738c;

        public b(Class cls, k.b bVar, String str) {
            super(cls, false);
            this.f6736a = bVar;
            this.f6737b = str;
            this.f6738c = bVar == k.b.INT || bVar == k.b.LONG || bVar == k.b.BIG_INTEGER;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
            if (this.f6738c) {
                visitIntFormat(fVar, jVar, this.f6736a);
            } else {
                visitFloatFormat(fVar, jVar, this.f6736a);
            }
        }

        @Override // a4.i
        public k3.o b(k3.c0 c0Var, k3.d dVar) {
            k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, handledType());
            return (findFormatOverrides == null || a.f6735a[findFormatOverrides.i().ordinal()] != 1) ? this : handledType() == BigDecimal.class ? v.c() : l0.f6697a;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, v3.c
        public k3.m getSchema(k3.c0 c0Var, Type type) {
            return createSchemaNode(this.f6737b, true);
        }
    }

    public static class c extends b {
        public c(Class cls) {
            super(cls, k.b.DOUBLE, "number");
        }

        public static boolean c(double d10) {
            return Double.isNaN(d10) || Double.isInfinite(d10);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
            hVar.b0(((Double) obj).doubleValue());
        }

        @Override // com.fasterxml.jackson.databind.ser.std.h0, k3.o
        public void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
            Double d10 = (Double) obj;
            if (!c(d10.doubleValue())) {
                hVar.b0(d10.doubleValue());
                return;
            }
            i3.b g10 = hVar2.g(hVar, hVar2.d(obj, c3.n.VALUE_NUMBER_FLOAT));
            hVar.b0(d10.doubleValue());
            hVar2.h(hVar, g10);
        }
    }

    public static class d extends b {

        /* renamed from: d, reason: collision with root package name */
        public static final d f6739d = new d();

        public d() {
            super(Float.class, k.b.FLOAT, "number");
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
            hVar.c0(((Float) obj).floatValue());
        }
    }

    public static class e extends b {

        /* renamed from: d, reason: collision with root package name */
        public static final e f6740d = new e();

        public e() {
            super(Number.class, k.b.INT, "integer");
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
            hVar.d0(((Number) obj).intValue());
        }
    }

    public static class f extends b {
        public f(Class cls) {
            super(cls, k.b.INT, "integer");
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
            hVar.d0(((Integer) obj).intValue());
        }

        @Override // com.fasterxml.jackson.databind.ser.std.h0, k3.o
        public void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
            serialize(obj, hVar, c0Var);
        }
    }

    public static class g extends b {
        public g(Class cls) {
            super(cls, k.b.LONG, "number");
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
            hVar.e0(((Long) obj).longValue());
        }
    }

    public static class h extends b {

        /* renamed from: d, reason: collision with root package name */
        public static final h f6741d = new h();

        public h() {
            super(Short.class, k.b.INT, "number");
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
            hVar.i0(((Short) obj).shortValue());
        }
    }

    public static void a(Map map) {
        map.put(Integer.class.getName(), new f(Integer.class));
        Class cls = Integer.TYPE;
        map.put(cls.getName(), new f(cls));
        map.put(Long.class.getName(), new g(Long.class));
        Class cls2 = Long.TYPE;
        map.put(cls2.getName(), new g(cls2));
        String name = Byte.class.getName();
        e eVar = e.f6740d;
        map.put(name, eVar);
        map.put(Byte.TYPE.getName(), eVar);
        String name2 = Short.class.getName();
        h hVar = h.f6741d;
        map.put(name2, hVar);
        map.put(Short.TYPE.getName(), hVar);
        map.put(Double.class.getName(), new c(Double.class));
        map.put(Double.TYPE.getName(), new c(Double.TYPE));
        String name3 = Float.class.getName();
        d dVar = d.f6739d;
        map.put(name3, dVar);
        map.put(Float.TYPE.getName(), dVar);
    }
}
