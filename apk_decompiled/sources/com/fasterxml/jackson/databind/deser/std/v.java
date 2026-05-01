package com.fasterxml.jackson.databind.deser.std;

import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f6614a = new HashSet();

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6615a;

        static {
            int[] iArr = new int[m3.b.values().length];
            f6615a = iArr;
            try {
                iArr[m3.b.Fail.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6615a[m3.b.AsNull.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6615a[m3.b.AsEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class b extends e0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f6616a = new b();

        public b() {
            super(BigDecimal.class);
        }

        @Override // k3.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal deserialize(c3.k kVar, k3.g gVar) {
            String z10;
            int q10 = kVar.q();
            if (q10 == 1) {
                z10 = gVar.z(kVar, this, this._valueClass);
            } else {
                if (q10 == 3) {
                    return (BigDecimal) _deserializeFromArray(kVar, gVar);
                }
                if (q10 != 6) {
                    return (q10 == 7 || q10 == 8) ? kVar.L() : (BigDecimal) gVar.c0(getValueType(gVar), kVar);
                }
                z10 = kVar.Y();
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (BigDecimal) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (BigDecimal) getEmptyValue(gVar);
            }
            String trim = z10.trim();
            if (_hasTextualNull(trim)) {
                return (BigDecimal) getNullValue(gVar);
            }
            try {
                return new BigDecimal(trim);
            } catch (IllegalArgumentException unused) {
                return (BigDecimal) gVar.j0(this._valueClass, trim, "not a valid representation", new Object[0]);
            }
        }

        @Override // k3.k
        public Object getEmptyValue(k3.g gVar) {
            return BigDecimal.ZERO;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public final c4.f logicalType() {
            return c4.f.Float;
        }
    }

    public static class c extends e0 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f6617a = new c();

        public c() {
            super(BigInteger.class);
        }

        @Override // k3.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger deserialize(c3.k kVar, k3.g gVar) {
            String z10;
            if (kVar.m0()) {
                return kVar.s();
            }
            int q10 = kVar.q();
            if (q10 == 1) {
                z10 = gVar.z(kVar, this, this._valueClass);
            } else {
                if (q10 == 3) {
                    return (BigInteger) _deserializeFromArray(kVar, gVar);
                }
                if (q10 != 6) {
                    if (q10 != 8) {
                        return (BigInteger) gVar.c0(getValueType(gVar), kVar);
                    }
                    m3.b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, this._valueClass);
                    return _checkFloatToIntCoercion == m3.b.AsNull ? (BigInteger) getNullValue(gVar) : _checkFloatToIntCoercion == m3.b.AsEmpty ? (BigInteger) getEmptyValue(gVar) : kVar.L().toBigInteger();
                }
                z10 = kVar.Y();
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (BigInteger) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (BigInteger) getEmptyValue(gVar);
            }
            String trim = z10.trim();
            if (_hasTextualNull(trim)) {
                return (BigInteger) getNullValue(gVar);
            }
            try {
                return new BigInteger(trim);
            } catch (IllegalArgumentException unused) {
                return (BigInteger) gVar.j0(this._valueClass, trim, "not a valid representation", new Object[0]);
            }
        }

        @Override // k3.k
        public Object getEmptyValue(k3.g gVar) {
            return BigInteger.ZERO;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public final c4.f logicalType() {
            return c4.f.Integer;
        }
    }

    public static final class d extends l {

        /* renamed from: e, reason: collision with root package name */
        public static final d f6618e = new d(Boolean.TYPE, Boolean.FALSE);

        /* renamed from: f, reason: collision with root package name */
        public static final d f6619f = new d(Boolean.class, null);

        public d(Class cls, Boolean bool) {
            super(cls, c4.f.Boolean, bool, Boolean.FALSE);
        }

        @Override // k3.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean deserialize(c3.k kVar, k3.g gVar) {
            c3.n n10 = kVar.n();
            return n10 == c3.n.VALUE_TRUE ? Boolean.TRUE : n10 == c3.n.VALUE_FALSE ? Boolean.FALSE : this.f6636d ? Boolean.valueOf(_parseBooleanPrimitive(kVar, gVar)) : _parseBoolean(kVar, gVar, this._valueClass);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.e0, com.fasterxml.jackson.databind.deser.std.b0, k3.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
            c3.n n10 = kVar.n();
            return n10 == c3.n.VALUE_TRUE ? Boolean.TRUE : n10 == c3.n.VALUE_FALSE ? Boolean.FALSE : this.f6636d ? Boolean.valueOf(_parseBooleanPrimitive(kVar, gVar)) : _parseBoolean(kVar, gVar, this._valueClass);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, k3.k
        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    public static class e extends l {

        /* renamed from: e, reason: collision with root package name */
        public static final e f6620e = new e(Byte.TYPE, (byte) 0);

        /* renamed from: f, reason: collision with root package name */
        public static final e f6621f = new e(Byte.class, null);

        public e(Class cls, Byte b10) {
            super(cls, c4.f.Integer, b10, (byte) 0);
        }

        public Byte a(c3.k kVar, k3.g gVar) {
            String z10;
            int q10 = kVar.q();
            if (q10 == 1) {
                z10 = gVar.z(kVar, this, this._valueClass);
            } else {
                if (q10 == 3) {
                    return (Byte) _deserializeFromArray(kVar, gVar);
                }
                if (q10 == 11) {
                    return (Byte) getNullValue(gVar);
                }
                if (q10 != 6) {
                    if (q10 == 7) {
                        return Byte.valueOf(kVar.x());
                    }
                    if (q10 != 8) {
                        return (Byte) gVar.c0(getValueType(gVar), kVar);
                    }
                    m3.b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, this._valueClass);
                    return _checkFloatToIntCoercion == m3.b.AsNull ? (Byte) getNullValue(gVar) : _checkFloatToIntCoercion == m3.b.AsEmpty ? (Byte) getEmptyValue(gVar) : Byte.valueOf(kVar.x());
                }
                z10 = kVar.Y();
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (Byte) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (Byte) getEmptyValue(gVar);
            }
            String trim = z10.trim();
            if (_checkTextualNull(gVar, trim)) {
                return (Byte) getNullValue(gVar);
            }
            try {
                int j10 = f3.f.j(trim);
                return _byteOverflow(j10) ? (Byte) gVar.j0(this._valueClass, trim, "overflow, value cannot be represented as 8-bit value", new Object[0]) : Byte.valueOf((byte) j10);
            } catch (IllegalArgumentException unused) {
                return (Byte) gVar.j0(this._valueClass, trim, "not a valid Byte value", new Object[0]);
            }
        }

        @Override // k3.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte deserialize(c3.k kVar, k3.g gVar) {
            return kVar.m0() ? Byte.valueOf(kVar.x()) : this.f6636d ? Byte.valueOf(_parseBytePrimitive(kVar, gVar)) : a(kVar, gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, k3.k
        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    public static class f extends l {

        /* renamed from: e, reason: collision with root package name */
        public static final f f6622e = new f(Character.TYPE, 0);

        /* renamed from: f, reason: collision with root package name */
        public static final f f6623f = new f(Character.class, null);

        public f(Class cls, Character ch) {
            super(cls, c4.f.Integer, ch, (char) 0);
        }

        @Override // k3.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character deserialize(c3.k kVar, k3.g gVar) {
            String z10;
            int q10 = kVar.q();
            if (q10 == 1) {
                z10 = gVar.z(kVar, this, this._valueClass);
            } else {
                if (q10 == 3) {
                    return (Character) _deserializeFromArray(kVar, gVar);
                }
                if (q10 == 11) {
                    if (this.f6636d) {
                        _verifyNullForPrimitive(gVar);
                    }
                    return (Character) getNullValue(gVar);
                }
                if (q10 != 6) {
                    if (q10 != 7) {
                        return (Character) gVar.c0(getValueType(gVar), kVar);
                    }
                    m3.b B = gVar.B(logicalType(), this._valueClass, m3.e.Integer);
                    int i10 = a.f6615a[B.ordinal()];
                    if (i10 == 1) {
                        _checkCoercionFail(gVar, B, this._valueClass, kVar.S(), "Integer value (" + kVar.Y() + ")");
                    } else if (i10 != 2) {
                        if (i10 == 3) {
                            return (Character) getEmptyValue(gVar);
                        }
                        int P = kVar.P();
                        return (P < 0 || P > 65535) ? (Character) gVar.i0(handledType(), Integer.valueOf(P), "value outside valid Character range (0x0000 - 0xFFFF)", new Object[0]) : Character.valueOf((char) P);
                    }
                    return (Character) getNullValue(gVar);
                }
                z10 = kVar.Y();
            }
            if (z10.length() == 1) {
                return Character.valueOf(z10.charAt(0));
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (Character) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (Character) getEmptyValue(gVar);
            }
            String trim = z10.trim();
            return _checkTextualNull(gVar, trim) ? (Character) getNullValue(gVar) : (Character) gVar.j0(handledType(), trim, "Expected either Integer value code or 1-character String", new Object[0]);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, k3.k
        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    public static class g extends l {

        /* renamed from: e, reason: collision with root package name */
        public static final g f6624e = new g(Double.TYPE, Double.valueOf(0.0d));

        /* renamed from: f, reason: collision with root package name */
        public static final g f6625f = new g(Double.class, null);

        public g(Class cls, Double d10) {
            super(cls, c4.f.Float, d10, Double.valueOf(0.0d));
        }

        public final Double a(c3.k kVar, k3.g gVar) {
            String z10;
            int q10 = kVar.q();
            if (q10 == 1) {
                z10 = gVar.z(kVar, this, this._valueClass);
            } else {
                if (q10 == 3) {
                    return (Double) _deserializeFromArray(kVar, gVar);
                }
                if (q10 == 11) {
                    return (Double) getNullValue(gVar);
                }
                if (q10 != 6) {
                    return (q10 == 7 || q10 == 8) ? Double.valueOf(kVar.M()) : (Double) gVar.c0(getValueType(gVar), kVar);
                }
                z10 = kVar.Y();
            }
            Double _checkDoubleSpecialValue = _checkDoubleSpecialValue(z10);
            if (_checkDoubleSpecialValue != null) {
                return _checkDoubleSpecialValue;
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (Double) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (Double) getEmptyValue(gVar);
            }
            String trim = z10.trim();
            if (_checkTextualNull(gVar, trim)) {
                return (Double) getNullValue(gVar);
            }
            try {
                return Double.valueOf(b0._parseDouble(trim));
            } catch (IllegalArgumentException unused) {
                return (Double) gVar.j0(this._valueClass, trim, "not a valid `Double` value", new Object[0]);
            }
        }

        @Override // k3.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double deserialize(c3.k kVar, k3.g gVar) {
            return kVar.j0(c3.n.VALUE_NUMBER_FLOAT) ? Double.valueOf(kVar.M()) : this.f6636d ? Double.valueOf(_parseDoublePrimitive(kVar, gVar)) : a(kVar, gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.e0, com.fasterxml.jackson.databind.deser.std.b0, k3.k
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Double deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
            return kVar.j0(c3.n.VALUE_NUMBER_FLOAT) ? Double.valueOf(kVar.M()) : this.f6636d ? Double.valueOf(_parseDoublePrimitive(kVar, gVar)) : a(kVar, gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, k3.k
        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    public static class h extends l {

        /* renamed from: e, reason: collision with root package name */
        public static final h f6626e = new h(Float.TYPE, Float.valueOf(0.0f));

        /* renamed from: f, reason: collision with root package name */
        public static final h f6627f = new h(Float.class, null);

        public h(Class cls, Float f10) {
            super(cls, c4.f.Float, f10, Float.valueOf(0.0f));
        }

        public final Float a(c3.k kVar, k3.g gVar) {
            String z10;
            int q10 = kVar.q();
            if (q10 == 1) {
                z10 = gVar.z(kVar, this, this._valueClass);
            } else {
                if (q10 == 3) {
                    return (Float) _deserializeFromArray(kVar, gVar);
                }
                if (q10 == 11) {
                    return (Float) getNullValue(gVar);
                }
                if (q10 != 6) {
                    return (q10 == 7 || q10 == 8) ? Float.valueOf(kVar.O()) : (Float) gVar.c0(getValueType(gVar), kVar);
                }
                z10 = kVar.Y();
            }
            Float _checkFloatSpecialValue = _checkFloatSpecialValue(z10);
            if (_checkFloatSpecialValue != null) {
                return _checkFloatSpecialValue;
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (Float) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (Float) getEmptyValue(gVar);
            }
            String trim = z10.trim();
            if (_checkTextualNull(gVar, trim)) {
                return (Float) getNullValue(gVar);
            }
            try {
                return Float.valueOf(Float.parseFloat(trim));
            } catch (IllegalArgumentException unused) {
                return (Float) gVar.j0(this._valueClass, trim, "not a valid `Float` value", new Object[0]);
            }
        }

        @Override // k3.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float deserialize(c3.k kVar, k3.g gVar) {
            return kVar.j0(c3.n.VALUE_NUMBER_FLOAT) ? Float.valueOf(kVar.O()) : this.f6636d ? Float.valueOf(_parseFloatPrimitive(kVar, gVar)) : a(kVar, gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, k3.k
        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    public static final class i extends l {

        /* renamed from: e, reason: collision with root package name */
        public static final i f6628e = new i(Integer.TYPE, 0);

        /* renamed from: f, reason: collision with root package name */
        public static final i f6629f = new i(Integer.class, null);

        public i(Class cls, Integer num) {
            super(cls, c4.f.Integer, num, 0);
        }

        @Override // k3.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer deserialize(c3.k kVar, k3.g gVar) {
            return kVar.m0() ? Integer.valueOf(kVar.P()) : this.f6636d ? Integer.valueOf(_parseIntPrimitive(kVar, gVar)) : _parseInteger(kVar, gVar, Integer.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.e0, com.fasterxml.jackson.databind.deser.std.b0, k3.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
            return kVar.m0() ? Integer.valueOf(kVar.P()) : this.f6636d ? Integer.valueOf(_parseIntPrimitive(kVar, gVar)) : _parseInteger(kVar, gVar, Integer.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, k3.k
        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        @Override // k3.k
        public boolean isCachable() {
            return true;
        }
    }

    public static final class j extends l {

        /* renamed from: e, reason: collision with root package name */
        public static final j f6630e = new j(Long.TYPE, 0L);

        /* renamed from: f, reason: collision with root package name */
        public static final j f6631f = new j(Long.class, null);

        public j(Class cls, Long l10) {
            super(cls, c4.f.Integer, l10, 0L);
        }

        @Override // k3.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long deserialize(c3.k kVar, k3.g gVar) {
            return kVar.m0() ? Long.valueOf(kVar.Q()) : this.f6636d ? Long.valueOf(_parseLongPrimitive(kVar, gVar)) : _parseLong(kVar, gVar, Long.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, k3.k
        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        @Override // k3.k
        public boolean isCachable() {
            return true;
        }
    }

    public static class k extends e0 {

        /* renamed from: a, reason: collision with root package name */
        public static final k f6632a = new k();

        public k() {
            super(Number.class);
        }

        @Override // k3.k
        public Object deserialize(c3.k kVar, k3.g gVar) {
            String z10;
            int q10 = kVar.q();
            if (q10 == 1) {
                z10 = gVar.z(kVar, this, this._valueClass);
            } else {
                if (q10 == 3) {
                    return _deserializeFromArray(kVar, gVar);
                }
                if (q10 != 6) {
                    return q10 != 7 ? q10 != 8 ? gVar.c0(getValueType(gVar), kVar) : (!gVar.n0(k3.h.USE_BIG_DECIMAL_FOR_FLOATS) || kVar.p0()) ? kVar.S() : kVar.L() : gVar.k0(b0.F_MASK_INT_COERCIONS) ? _coerceIntegral(kVar, gVar) : kVar.S();
                }
                z10 = kVar.Y();
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return getEmptyValue(gVar);
            }
            String trim = z10.trim();
            if (_hasTextualNull(trim)) {
                return getNullValue(gVar);
            }
            if (_isPosInf(trim)) {
                return Double.valueOf(Double.POSITIVE_INFINITY);
            }
            if (_isNegInf(trim)) {
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
            if (_isNaN(trim)) {
                return Double.valueOf(Double.NaN);
            }
            try {
                if (!_isIntNumber(trim)) {
                    return gVar.n0(k3.h.USE_BIG_DECIMAL_FOR_FLOATS) ? new BigDecimal(trim) : Double.valueOf(trim);
                }
                if (gVar.n0(k3.h.USE_BIG_INTEGER_FOR_INTS)) {
                    return new BigInteger(trim);
                }
                long parseLong = Long.parseLong(trim);
                return (gVar.n0(k3.h.USE_LONG_FOR_INTS) || parseLong > TTL.MAX_VALUE || parseLong < -2147483648L) ? Long.valueOf(parseLong) : Integer.valueOf((int) parseLong);
            } catch (IllegalArgumentException unused) {
                return gVar.j0(this._valueClass, trim, "not a valid number", new Object[0]);
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.e0, com.fasterxml.jackson.databind.deser.std.b0, k3.k
        public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
            int q10 = kVar.q();
            return (q10 == 6 || q10 == 7 || q10 == 8) ? deserialize(kVar, gVar) : eVar.f(kVar, gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public final c4.f logicalType() {
            return c4.f.Integer;
        }
    }

    public static abstract class l extends e0 {

        /* renamed from: a, reason: collision with root package name */
        public final c4.f f6633a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f6634b;

        /* renamed from: c, reason: collision with root package name */
        public final Object f6635c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f6636d;

        public l(Class cls, c4.f fVar, Object obj, Object obj2) {
            super(cls);
            this.f6633a = fVar;
            this.f6634b = obj;
            this.f6635c = obj2;
            this.f6636d = cls.isPrimitive();
        }

        @Override // k3.k
        public Object getEmptyValue(k3.g gVar) {
            return this.f6635c;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public d4.a getNullAccessPattern() {
            return this.f6636d ? d4.a.DYNAMIC : this.f6634b == null ? d4.a.ALWAYS_NULL : d4.a.CONSTANT;
        }

        @Override // k3.k, n3.q
        public final Object getNullValue(k3.g gVar) {
            if (this.f6636d && gVar.n0(k3.h.FAIL_ON_NULL_FOR_PRIMITIVES)) {
                gVar.z0(this, "Cannot map `null` into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", d4.h.h(handledType()));
            }
            return this.f6634b;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public final c4.f logicalType() {
            return this.f6633a;
        }
    }

    public static class m extends l {

        /* renamed from: e, reason: collision with root package name */
        public static final m f6637e = new m(Short.TYPE, 0);

        /* renamed from: f, reason: collision with root package name */
        public static final m f6638f = new m(Short.class, null);

        public m(Class cls, Short sh) {
            super(cls, c4.f.Integer, sh, (short) 0);
        }

        public Short a(c3.k kVar, k3.g gVar) {
            String z10;
            int q10 = kVar.q();
            if (q10 == 1) {
                z10 = gVar.z(kVar, this, this._valueClass);
            } else {
                if (q10 == 3) {
                    return (Short) _deserializeFromArray(kVar, gVar);
                }
                if (q10 == 11) {
                    return (Short) getNullValue(gVar);
                }
                if (q10 != 6) {
                    if (q10 == 7) {
                        return Short.valueOf(kVar.X());
                    }
                    if (q10 != 8) {
                        return (Short) gVar.c0(getValueType(gVar), kVar);
                    }
                    m3.b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, this._valueClass);
                    return _checkFloatToIntCoercion == m3.b.AsNull ? (Short) getNullValue(gVar) : _checkFloatToIntCoercion == m3.b.AsEmpty ? (Short) getEmptyValue(gVar) : Short.valueOf(kVar.X());
                }
                z10 = kVar.Y();
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (Short) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (Short) getEmptyValue(gVar);
            }
            String trim = z10.trim();
            if (_checkTextualNull(gVar, trim)) {
                return (Short) getNullValue(gVar);
            }
            try {
                int j10 = f3.f.j(trim);
                return _shortOverflow(j10) ? (Short) gVar.j0(this._valueClass, trim, "overflow, value cannot be represented as 16-bit value", new Object[0]) : Short.valueOf((short) j10);
            } catch (IllegalArgumentException unused) {
                return (Short) gVar.j0(this._valueClass, trim, "not a valid Short value", new Object[0]);
            }
        }

        @Override // k3.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short deserialize(c3.k kVar, k3.g gVar) {
            return kVar.m0() ? Short.valueOf(kVar.X()) : this.f6636d ? Short.valueOf(_parseShortPrimitive(kVar, gVar)) : a(kVar, gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, k3.k
        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.v.l, com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    static {
        Class[] clsArr = {Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, Number.class, BigDecimal.class, BigInteger.class};
        for (int i10 = 0; i10 < 11; i10++) {
            f6614a.add(clsArr[i10].getName());
        }
    }

    public static k3.k a(Class cls, String str) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return i.f6628e;
            }
            if (cls == Boolean.TYPE) {
                return d.f6618e;
            }
            if (cls == Long.TYPE) {
                return j.f6630e;
            }
            if (cls == Double.TYPE) {
                return g.f6624e;
            }
            if (cls == Character.TYPE) {
                return f.f6622e;
            }
            if (cls == Byte.TYPE) {
                return e.f6620e;
            }
            if (cls == Short.TYPE) {
                return m.f6637e;
            }
            if (cls == Float.TYPE) {
                return h.f6626e;
            }
            if (cls == Void.TYPE) {
                return u.f6613a;
            }
        } else {
            if (!f6614a.contains(str)) {
                return null;
            }
            if (cls == Integer.class) {
                return i.f6629f;
            }
            if (cls == Boolean.class) {
                return d.f6619f;
            }
            if (cls == Long.class) {
                return j.f6631f;
            }
            if (cls == Double.class) {
                return g.f6625f;
            }
            if (cls == Character.class) {
                return f.f6623f;
            }
            if (cls == Byte.class) {
                return e.f6621f;
            }
            if (cls == Short.class) {
                return m.f6638f;
            }
            if (cls == Float.class) {
                return h.f6627f;
            }
            if (cls == Number.class) {
                return k.f6632a;
            }
            if (cls == BigDecimal.class) {
                return b.f6616a;
            }
            if (cls == BigInteger.class) {
                return c.f6617a;
            }
        }
        throw new IllegalArgumentException("Internal error: can't find deserializer for " + cls.getName());
    }
}
