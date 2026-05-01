package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f6664a;

    public static class a extends com.fasterxml.jackson.databind.ser.std.a {

        /* renamed from: c, reason: collision with root package name */
        public static final k3.j f6665c = c4.o.I().N(Boolean.class);

        public a() {
            super(boolean[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.BOOLEAN);
        }

        @Override // a4.h
        public a4.h c(w3.h hVar) {
            return this;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.a
        public k3.o f(k3.d dVar, Boolean bool) {
            return new a(this, dVar, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
        public k3.m getSchema(k3.c0 c0Var, Type type) {
            z3.r createSchemaNode = createSchemaNode("array", true);
            createSchemaNode.G("items", createSchemaNode("boolean"));
            return createSchemaNode;
        }

        @Override // k3.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean isEmpty(k3.c0 c0Var, boolean[] zArr) {
            return zArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final void serialize(boolean[] zArr, c3.h hVar, k3.c0 c0Var) {
            int length = zArr.length;
            if (length == 1 && e(c0Var)) {
                g(zArr, hVar, c0Var);
                return;
            }
            hVar.u0(zArr, length);
            g(zArr, hVar, c0Var);
            hVar.V();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(boolean[] zArr, c3.h hVar, k3.c0 c0Var) {
            for (boolean z10 : zArr) {
                hVar.U(z10);
            }
        }

        public a(a aVar, k3.d dVar, Boolean bool) {
            super(aVar, dVar, bool);
        }
    }

    public static class b extends i0 {
        public b() {
            super(char[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.STRING);
        }

        public final void c(c3.h hVar, char[] cArr) {
            int length = cArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                hVar.A0(cArr, i10, 1);
            }
        }

        @Override // k3.o
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean isEmpty(k3.c0 c0Var, char[] cArr) {
            return cArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void serialize(char[] cArr, c3.h hVar, k3.c0 c0Var) {
            if (!c0Var.m0(k3.b0.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                hVar.A0(cArr, 0, cArr.length);
                return;
            }
            hVar.u0(cArr, cArr.length);
            c(hVar, cArr);
            hVar.V();
        }

        @Override // k3.o
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void serializeWithType(char[] cArr, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
            i3.b g10;
            if (c0Var.m0(k3.b0.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                g10 = hVar2.g(hVar, hVar2.d(cArr, c3.n.START_ARRAY));
                c(hVar, cArr);
            } else {
                g10 = hVar2.g(hVar, hVar2.d(cArr, c3.n.VALUE_STRING));
                hVar.A0(cArr, 0, cArr.length);
            }
            hVar2.h(hVar, g10);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
        public k3.m getSchema(k3.c0 c0Var, Type type) {
            z3.r createSchemaNode = createSchemaNode("array", true);
            z3.r createSchemaNode2 = createSchemaNode("string");
            createSchemaNode2.C("type", "string");
            return createSchemaNode.G("items", createSchemaNode2);
        }
    }

    public static class c extends com.fasterxml.jackson.databind.ser.std.a {

        /* renamed from: c, reason: collision with root package name */
        public static final k3.j f6666c = c4.o.I().N(Double.TYPE);

        public c() {
            super(double[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.NUMBER);
        }

        @Override // a4.h
        public a4.h c(w3.h hVar) {
            return this;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.a
        public k3.o f(k3.d dVar, Boolean bool) {
            return new c(this, dVar, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
        public k3.m getSchema(k3.c0 c0Var, Type type) {
            return createSchemaNode("array", true).G("items", createSchemaNode("number"));
        }

        @Override // k3.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean isEmpty(k3.c0 c0Var, double[] dArr) {
            return dArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final void serialize(double[] dArr, c3.h hVar, k3.c0 c0Var) {
            if (dArr.length == 1 && e(c0Var)) {
                g(dArr, hVar, c0Var);
            } else {
                hVar.M(dArr, 0, dArr.length);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.std.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(double[] dArr, c3.h hVar, k3.c0 c0Var) {
            for (double d10 : dArr) {
                hVar.b0(d10);
            }
        }

        public c(c cVar, k3.d dVar, Boolean bool) {
            super(cVar, dVar, bool);
        }
    }

    public static class d extends h {

        /* renamed from: c, reason: collision with root package name */
        public static final k3.j f6667c = c4.o.I().N(Float.TYPE);

        public d() {
            super(float[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.NUMBER);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.a
        public k3.o f(k3.d dVar, Boolean bool) {
            return new d(this, dVar, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
        public k3.m getSchema(k3.c0 c0Var, Type type) {
            return createSchemaNode("array", true).G("items", createSchemaNode("number"));
        }

        @Override // k3.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean isEmpty(k3.c0 c0Var, float[] fArr) {
            return fArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final void serialize(float[] fArr, c3.h hVar, k3.c0 c0Var) {
            int length = fArr.length;
            if (length == 1 && e(c0Var)) {
                g(fArr, hVar, c0Var);
                return;
            }
            hVar.u0(fArr, length);
            g(fArr, hVar, c0Var);
            hVar.V();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(float[] fArr, c3.h hVar, k3.c0 c0Var) {
            for (float f10 : fArr) {
                hVar.c0(f10);
            }
        }

        public d(d dVar, k3.d dVar2, Boolean bool) {
            super(dVar, dVar2, bool);
        }
    }

    public static class e extends com.fasterxml.jackson.databind.ser.std.a {

        /* renamed from: c, reason: collision with root package name */
        public static final k3.j f6668c = c4.o.I().N(Integer.TYPE);

        public e() {
            super(int[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.INTEGER);
        }

        @Override // a4.h
        public a4.h c(w3.h hVar) {
            return this;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.a
        public k3.o f(k3.d dVar, Boolean bool) {
            return new e(this, dVar, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
        public k3.m getSchema(k3.c0 c0Var, Type type) {
            return createSchemaNode("array", true).G("items", createSchemaNode("integer"));
        }

        @Override // k3.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean isEmpty(k3.c0 c0Var, int[] iArr) {
            return iArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final void serialize(int[] iArr, c3.h hVar, k3.c0 c0Var) {
            if (iArr.length == 1 && e(c0Var)) {
                g(iArr, hVar, c0Var);
            } else {
                hVar.N(iArr, 0, iArr.length);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.std.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(int[] iArr, c3.h hVar, k3.c0 c0Var) {
            for (int i10 : iArr) {
                hVar.d0(i10);
            }
        }

        public e(e eVar, k3.d dVar, Boolean bool) {
            super(eVar, dVar, bool);
        }
    }

    public static class f extends h {

        /* renamed from: c, reason: collision with root package name */
        public static final k3.j f6669c = c4.o.I().N(Long.TYPE);

        public f() {
            super(long[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.NUMBER);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.a
        public k3.o f(k3.d dVar, Boolean bool) {
            return new f(this, dVar, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
        public k3.m getSchema(k3.c0 c0Var, Type type) {
            return createSchemaNode("array", true).G("items", createSchemaNode("number", true));
        }

        @Override // k3.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean isEmpty(k3.c0 c0Var, long[] jArr) {
            return jArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final void serialize(long[] jArr, c3.h hVar, k3.c0 c0Var) {
            if (jArr.length == 1 && e(c0Var)) {
                g(jArr, hVar, c0Var);
            } else {
                hVar.O(jArr, 0, jArr.length);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.std.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(long[] jArr, c3.h hVar, k3.c0 c0Var) {
            for (long j10 : jArr) {
                hVar.e0(j10);
            }
        }

        public f(f fVar, k3.d dVar, Boolean bool) {
            super(fVar, dVar, bool);
        }
    }

    public static class g extends h {

        /* renamed from: c, reason: collision with root package name */
        public static final k3.j f6670c = c4.o.I().N(Short.TYPE);

        public g() {
            super(short[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.INTEGER);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.a
        public k3.o f(k3.d dVar, Boolean bool) {
            return new g(this, dVar, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
        public k3.m getSchema(k3.c0 c0Var, Type type) {
            return createSchemaNode("array", true).G("items", createSchemaNode("integer"));
        }

        @Override // k3.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean isEmpty(k3.c0 c0Var, short[] sArr) {
            return sArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final void serialize(short[] sArr, c3.h hVar, k3.c0 c0Var) {
            int length = sArr.length;
            if (length == 1 && e(c0Var)) {
                g(sArr, hVar, c0Var);
                return;
            }
            hVar.u0(sArr, length);
            g(sArr, hVar, c0Var);
            hVar.V();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(short[] sArr, c3.h hVar, k3.c0 c0Var) {
            for (short s10 : sArr) {
                hVar.d0(s10);
            }
        }

        public g(g gVar, k3.d dVar, Boolean bool) {
            super(gVar, dVar, bool);
        }
    }

    public static abstract class h extends com.fasterxml.jackson.databind.ser.std.a {
        public h(Class cls) {
            super(cls);
        }

        @Override // a4.h
        public final a4.h c(w3.h hVar) {
            return this;
        }

        public h(h hVar, k3.d dVar, Boolean bool) {
            super(hVar, dVar, bool);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f6664a = hashMap;
        hashMap.put(boolean[].class.getName(), new a());
        hashMap.put(byte[].class.getName(), new com.fasterxml.jackson.databind.ser.std.f());
        hashMap.put(char[].class.getName(), new b());
        hashMap.put(short[].class.getName(), new g());
        hashMap.put(int[].class.getName(), new e());
        hashMap.put(long[].class.getName(), new f());
        hashMap.put(float[].class.getName(), new d());
        hashMap.put(double[].class.getName(), new c());
    }

    public static k3.o a(Class cls) {
        return (k3.o) f6664a.get(cls.getName());
    }
}
