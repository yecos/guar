package com.fasterxml.jackson.databind.deser.std;

import b3.k;
import c3.k;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class b0 extends k3.k implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<?> _valueClass;
    protected final k3.j _valueType;
    protected static final int F_MASK_INT_COERCIONS = k3.h.USE_BIG_INTEGER_FOR_INTS.b() | k3.h.USE_LONG_FOR_INTS.b();

    @Deprecated
    protected static final int F_MASK_ACCEPT_ARRAYS = k3.h.UNWRAP_SINGLE_VALUE_ARRAYS.b() | k3.h.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT.b();

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6498a;

        static {
            int[] iArr = new int[m3.b.values().length];
            f6498a = iArr;
            try {
                iArr[m3.b.AsEmpty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6498a[m3.b.AsNull.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6498a[m3.b.TryConvert.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6498a[m3.b.Fail.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b0(Class cls) {
        this._valueClass = cls;
        this._valueType = null;
    }

    public static final boolean _isBlank(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (str.charAt(i10) > ' ') {
                return false;
            }
        }
        return true;
    }

    public static final boolean _neitherNull(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    public static final double _parseDouble(String str) {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_NORMAL;
        }
        return Double.parseDouble(str);
    }

    public final boolean _byteOverflow(int i10) {
        return i10 < -128 || i10 > 255;
    }

    public m3.b _checkCoercionFail(k3.g gVar, m3.b bVar, Class<?> cls, Object obj, String str) {
        if (bVar == m3.b.Fail) {
            gVar.t0(this, cls, obj, "Cannot coerce %s to %s (but could if coercion was enabled using `CoercionConfig`)", str, _coercedTypeDesc());
        }
        return bVar;
    }

    public Double _checkDoubleSpecialValue(String str) {
        if (str.isEmpty()) {
            return null;
        }
        char charAt = str.charAt(0);
        if (charAt == '-') {
            if (_isNegInf(str)) {
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
            return null;
        }
        if (charAt == 'I') {
            if (_isPosInf(str)) {
                return Double.valueOf(Double.POSITIVE_INFINITY);
            }
            return null;
        }
        if (charAt == 'N' && _isNaN(str)) {
            return Double.valueOf(Double.NaN);
        }
        return null;
    }

    public Float _checkFloatSpecialValue(String str) {
        if (str.isEmpty()) {
            return null;
        }
        char charAt = str.charAt(0);
        if (charAt == '-') {
            if (_isNegInf(str)) {
                return Float.valueOf(Float.NEGATIVE_INFINITY);
            }
            return null;
        }
        if (charAt == 'I') {
            if (_isPosInf(str)) {
                return Float.valueOf(Float.POSITIVE_INFINITY);
            }
            return null;
        }
        if (charAt == 'N' && _isNaN(str)) {
            return Float.valueOf(Float.NaN);
        }
        return null;
    }

    public m3.b _checkFloatToIntCoercion(c3.k kVar, k3.g gVar, Class<?> cls) {
        m3.b B = gVar.B(c4.f.Integer, cls, m3.e.Float);
        if (B != m3.b.Fail) {
            return B;
        }
        return _checkCoercionFail(gVar, B, cls, kVar.S(), "Floating-point value (" + kVar.Y() + ")");
    }

    public m3.b _checkFromStringCoercion(k3.g gVar, String str) {
        return _checkFromStringCoercion(gVar, str, logicalType(), handledType());
    }

    public boolean _checkTextualNull(k3.g gVar, String str) {
        if (!_hasTextualNull(str)) {
            return false;
        }
        k3.q qVar = k3.q.ALLOW_COERCION_OF_SCALARS;
        if (!gVar.o0(qVar)) {
            _reportFailedNullCoerce(gVar, true, qVar, "String \"null\"");
        }
        return true;
    }

    public Boolean _coerceBooleanFromInt(c3.k kVar, k3.g gVar, Class<?> cls) {
        m3.b B = gVar.B(c4.f.Boolean, cls, m3.e.Integer);
        int i10 = a.f6498a[B.ordinal()];
        if (i10 == 1) {
            return Boolean.FALSE;
        }
        if (i10 == 2) {
            return null;
        }
        if (i10 != 4) {
            if (kVar.R() == k.b.INT) {
                return Boolean.valueOf(kVar.P() != 0);
            }
            return Boolean.valueOf(!"0".equals(kVar.Y()));
        }
        _checkCoercionFail(gVar, B, cls, kVar.S(), "Integer value (" + kVar.Y() + ")");
        return Boolean.FALSE;
    }

    @Deprecated
    public Object _coerceEmptyString(k3.g gVar, boolean z10) {
        boolean z11;
        k3.q qVar;
        k3.q qVar2 = k3.q.ALLOW_COERCION_OF_SCALARS;
        if (gVar.o0(qVar2)) {
            if (z10) {
                k3.h hVar = k3.h.FAIL_ON_NULL_FOR_PRIMITIVES;
                if (gVar.n0(hVar)) {
                    z11 = false;
                    qVar = hVar;
                }
            }
            return getNullValue(gVar);
        }
        z11 = true;
        qVar = qVar2;
        _reportFailedNullCoerce(gVar, z11, qVar, "empty String (\"\")");
        return null;
    }

    public Object _coerceIntegral(c3.k kVar, k3.g gVar) {
        int P = gVar.P();
        return k3.h.USE_BIG_INTEGER_FOR_INTS.c(P) ? kVar.s() : k3.h.USE_LONG_FOR_INTS.c(P) ? Long.valueOf(kVar.Q()) : kVar.S();
    }

    @Deprecated
    public Object _coerceNullToken(k3.g gVar, boolean z10) {
        if (z10) {
            _verifyNullForPrimitive(gVar);
        }
        return getNullValue(gVar);
    }

    @Deprecated
    public Object _coerceTextualNull(k3.g gVar, boolean z10) {
        k3.q qVar = k3.q.ALLOW_COERCION_OF_SCALARS;
        if (!gVar.o0(qVar)) {
            _reportFailedNullCoerce(gVar, true, qVar, "String \"null\"");
        }
        return getNullValue(gVar);
    }

    public String _coercedTypeDesc() {
        boolean z10;
        String y10;
        k3.j valueType = getValueType();
        if (valueType == null || valueType.K()) {
            Class<?> handledType = handledType();
            z10 = handledType.isArray() || Collection.class.isAssignableFrom(handledType) || Map.class.isAssignableFrom(handledType);
            y10 = d4.h.y(handledType);
        } else {
            z10 = valueType.D() || valueType.b();
            y10 = d4.h.G(valueType);
        }
        if (z10) {
            return "element of " + y10;
        }
        return y10 + " value";
    }

    public Object _deserializeFromArray(c3.k kVar, k3.g gVar) {
        m3.b _findCoercionFromEmptyArray = _findCoercionFromEmptyArray(gVar);
        boolean n02 = gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (n02 || _findCoercionFromEmptyArray != m3.b.Fail) {
            c3.n s02 = kVar.s0();
            c3.n nVar = c3.n.END_ARRAY;
            if (s02 == nVar) {
                int i10 = a.f6498a[_findCoercionFromEmptyArray.ordinal()];
                if (i10 == 1) {
                    return getEmptyValue(gVar);
                }
                if (i10 == 2 || i10 == 3) {
                    return getNullValue(gVar);
                }
            } else if (n02) {
                Object _deserializeWrappedValue = _deserializeWrappedValue(kVar, gVar);
                if (kVar.s0() != nVar) {
                    handleMissingEndArrayForSingle(kVar, gVar);
                }
                return _deserializeWrappedValue;
            }
        }
        return gVar.d0(getValueType(gVar), c3.n.START_ARRAY, kVar, null, new Object[0]);
    }

    @Deprecated
    public Object _deserializeFromEmpty(c3.k kVar, k3.g gVar) {
        if (!kVar.j0(c3.n.START_ARRAY) || !gVar.n0(k3.h.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
            return gVar.c0(getValueType(gVar), kVar);
        }
        if (kVar.s0() == c3.n.END_ARRAY) {
            return null;
        }
        return gVar.c0(getValueType(gVar), kVar);
    }

    public Object _deserializeFromEmptyString(c3.k kVar, k3.g gVar, m3.b bVar, Class<?> cls, String str) {
        int i10 = a.f6498a[bVar.ordinal()];
        if (i10 == 1) {
            return getEmptyValue(gVar);
        }
        if (i10 != 4) {
            return null;
        }
        _checkCoercionFail(gVar, bVar, cls, "", "empty String (\"\")");
        return null;
    }

    public Object _deserializeFromString(c3.k kVar, k3.g gVar) {
        n3.w valueInstantiator = getValueInstantiator();
        Class<?> handledType = handledType();
        String g02 = kVar.g0();
        if (valueInstantiator != null && valueInstantiator.h()) {
            return valueInstantiator.v(gVar, g02);
        }
        if (g02.isEmpty()) {
            return _deserializeFromEmptyString(kVar, gVar, gVar.B(logicalType(), handledType, m3.e.EmptyString), handledType, "empty String (\"\")");
        }
        if (_isBlank(g02)) {
            return _deserializeFromEmptyString(kVar, gVar, gVar.C(logicalType(), handledType, m3.b.Fail), handledType, "blank String (all whitespace)");
        }
        if (valueInstantiator != null) {
            g02 = g02.trim();
            if (valueInstantiator.e() && gVar.B(c4.f.Integer, Integer.class, m3.e.String) == m3.b.TryConvert) {
                return valueInstantiator.r(gVar, _parseIntPrimitive(gVar, g02));
            }
            if (valueInstantiator.f() && gVar.B(c4.f.Integer, Long.class, m3.e.String) == m3.b.TryConvert) {
                return valueInstantiator.s(gVar, _parseLongPrimitive(gVar, g02));
            }
            if (valueInstantiator.c() && gVar.B(c4.f.Boolean, Boolean.class, m3.e.String) == m3.b.TryConvert) {
                String trim = g02.trim();
                if ("true".equals(trim)) {
                    return valueInstantiator.p(gVar, true);
                }
                if ("false".equals(trim)) {
                    return valueInstantiator.p(gVar, false);
                }
            }
        }
        return gVar.W(handledType, valueInstantiator, gVar.S(), "no String-argument constructor/factory method to deserialize from String value ('%s')", g02);
    }

    public Object _deserializeWrappedValue(c3.k kVar, k3.g gVar) {
        return kVar.j0(c3.n.START_ARRAY) ? handleNestedArrayForSingle(kVar, gVar) : deserialize(kVar, gVar);
    }

    @Deprecated
    public void _failDoubleToIntCoercion(c3.k kVar, k3.g gVar, String str) {
        gVar.w0(handledType(), "Cannot coerce a floating-point value ('%s') into %s (enable `DeserializationFeature.ACCEPT_FLOAT_AS_INT` to allow)", kVar.g0(), str);
    }

    public m3.b _findCoercionFromBlankString(k3.g gVar) {
        return gVar.C(logicalType(), handledType(), m3.b.Fail);
    }

    public m3.b _findCoercionFromEmptyArray(k3.g gVar) {
        return gVar.B(logicalType(), handledType(), m3.e.EmptyArray);
    }

    public m3.b _findCoercionFromEmptyString(k3.g gVar) {
        return gVar.B(logicalType(), handledType(), m3.e.EmptyString);
    }

    public final n3.q _findNullProvider(k3.g gVar, k3.d dVar, b3.j0 j0Var, k3.k kVar) {
        if (j0Var == b3.j0.FAIL) {
            return dVar == null ? o3.r.c(gVar.x(kVar.handledType())) : o3.r.a(dVar);
        }
        if (j0Var != b3.j0.AS_EMPTY) {
            if (j0Var == b3.j0.SKIP) {
                return o3.q.d();
            }
            return null;
        }
        if (kVar == null) {
            return null;
        }
        if ((kVar instanceof n3.d) && !((n3.d) kVar).getValueInstantiator().j()) {
            k3.j type = dVar.getType();
            gVar.q(type, String.format("Cannot create empty instance of %s, no default Creator", type));
        }
        d4.a emptyAccessPattern = kVar.getEmptyAccessPattern();
        return emptyAccessPattern == d4.a.ALWAYS_NULL ? o3.q.c() : emptyAccessPattern == d4.a.CONSTANT ? o3.q.a(kVar.getEmptyValue(gVar)) : new o3.p(kVar);
    }

    public boolean _hasTextualNull(String str) {
        return "null".equals(str);
    }

    public final boolean _intOverflow(long j10) {
        return j10 < -2147483648L || j10 > TTL.MAX_VALUE;
    }

    @Deprecated
    public boolean _isEmptyOrTextualNull(String str) {
        return str.isEmpty() || "null".equals(str);
    }

    public boolean _isFalse(String str) {
        char charAt = str.charAt(0);
        if (charAt == 'f') {
            return "false".equals(str);
        }
        if (charAt == 'F') {
            return "FALSE".equals(str) || "False".equals(str);
        }
        return false;
    }

    public final boolean _isIntNumber(String str) {
        int i10;
        int length = str.length();
        if (length <= 0) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt != '-' && charAt != '+') {
            i10 = 0;
        } else {
            if (length == 1) {
                return false;
            }
            i10 = 1;
        }
        while (i10 < length) {
            char charAt2 = str.charAt(i10);
            if (charAt2 > '9' || charAt2 < '0') {
                return false;
            }
            i10++;
        }
        return true;
    }

    public final boolean _isNaN(String str) {
        return "NaN".equals(str);
    }

    public final boolean _isNegInf(String str) {
        return "-Infinity".equals(str) || "-INF".equals(str);
    }

    public final boolean _isPosInf(String str) {
        return "Infinity".equals(str) || "INF".equals(str);
    }

    public boolean _isTrue(String str) {
        char charAt = str.charAt(0);
        if (charAt == 't') {
            return "true".equals(str);
        }
        if (charAt == 'T') {
            return "TRUE".equals(str) || "True".equals(str);
        }
        return false;
    }

    public Number _nonNullNumber(Number number) {
        if (number == null) {
            return 0;
        }
        return number;
    }

    public final Boolean _parseBoolean(c3.k kVar, k3.g gVar, Class<?> cls) {
        String z10;
        int q10 = kVar.q();
        if (q10 == 1) {
            z10 = gVar.z(kVar, this, cls);
        } else {
            if (q10 == 3) {
                return (Boolean) _deserializeFromArray(kVar, gVar);
            }
            if (q10 != 6) {
                if (q10 == 7) {
                    return _coerceBooleanFromInt(kVar, gVar, cls);
                }
                switch (q10) {
                    case 9:
                        return Boolean.TRUE;
                    case 10:
                        return Boolean.FALSE;
                    case 11:
                        return null;
                    default:
                        return (Boolean) gVar.a0(cls, kVar);
                }
            }
            z10 = kVar.Y();
        }
        m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10, c4.f.Boolean, cls);
        if (_checkFromStringCoercion == m3.b.AsNull) {
            return null;
        }
        if (_checkFromStringCoercion == m3.b.AsEmpty) {
            return Boolean.FALSE;
        }
        String trim = z10.trim();
        int length = trim.length();
        if (length == 4) {
            if (_isTrue(trim)) {
                return Boolean.TRUE;
            }
        } else if (length == 5 && _isFalse(trim)) {
            return Boolean.FALSE;
        }
        if (_checkTextualNull(gVar, trim)) {
            return null;
        }
        return (Boolean) gVar.j0(cls, trim, "only \"true\" or \"false\" recognized", new Object[0]);
    }

    @Deprecated
    public boolean _parseBooleanFromInt(c3.k kVar, k3.g gVar) {
        _verifyNumberForScalarCoercion(gVar, kVar);
        return !"0".equals(kVar.Y());
    }

    @Deprecated
    public final boolean _parseBooleanPrimitive(k3.g gVar, c3.k kVar, Class<?> cls) {
        return _parseBooleanPrimitive(kVar, gVar);
    }

    public final byte _parseBytePrimitive(c3.k kVar, k3.g gVar) {
        String z10;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 11) {
                    _verifyNullForPrimitive(gVar);
                    return (byte) 0;
                }
                if (q10 == 6) {
                    z10 = kVar.Y();
                } else {
                    if (q10 == 7) {
                        return kVar.x();
                    }
                    if (q10 == 8) {
                        m3.b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, Byte.TYPE);
                        if (_checkFloatToIntCoercion == m3.b.AsNull || _checkFloatToIntCoercion == m3.b.AsEmpty) {
                            return (byte) 0;
                        }
                        return kVar.x();
                    }
                }
            } else if (gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == c3.n.START_ARRAY) {
                    return ((Byte) handleNestedArrayForSingle(kVar, gVar)).byteValue();
                }
                byte _parseBytePrimitive = _parseBytePrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseBytePrimitive;
            }
            return ((Byte) gVar.c0(gVar.x(Byte.TYPE), kVar)).byteValue();
        }
        z10 = gVar.z(kVar, this, Byte.TYPE);
        m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10, c4.f.Integer, Byte.TYPE);
        if (_checkFromStringCoercion == m3.b.AsNull || _checkFromStringCoercion == m3.b.AsEmpty) {
            return (byte) 0;
        }
        String trim = z10.trim();
        if (_hasTextualNull(trim)) {
            _verifyNullForPrimitiveCoercion(gVar, trim);
            return (byte) 0;
        }
        try {
            int j10 = f3.f.j(trim);
            return _byteOverflow(j10) ? ((Byte) gVar.j0(this._valueClass, trim, "overflow, value cannot be represented as 8-bit value", new Object[0])).byteValue() : (byte) j10;
        } catch (IllegalArgumentException unused) {
            return ((Byte) gVar.j0(this._valueClass, trim, "not a valid `byte` value", new Object[0])).byteValue();
        }
    }

    public Date _parseDate(c3.k kVar, k3.g gVar) {
        String z10;
        long longValue;
        int q10 = kVar.q();
        if (q10 == 1) {
            z10 = gVar.z(kVar, this, this._valueClass);
        } else {
            if (q10 == 3) {
                return _parseDateFromArray(kVar, gVar);
            }
            if (q10 == 11) {
                return (Date) getNullValue(gVar);
            }
            if (q10 != 6) {
                if (q10 != 7) {
                    return (Date) gVar.a0(this._valueClass, kVar);
                }
                try {
                    longValue = kVar.Q();
                } catch (c3.j | e3.a unused) {
                    longValue = ((Number) gVar.i0(this._valueClass, kVar.S(), "not a valid 64-bit `long` for creating `java.util.Date`", new Object[0])).longValue();
                }
                return new Date(longValue);
            }
            z10 = kVar.Y();
        }
        return _parseDate(z10.trim(), gVar);
    }

    public Date _parseDateFromArray(c3.k kVar, k3.g gVar) {
        m3.b _findCoercionFromEmptyArray = _findCoercionFromEmptyArray(gVar);
        boolean n02 = gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (n02 || _findCoercionFromEmptyArray != m3.b.Fail) {
            c3.n s02 = kVar.s0();
            if (s02 == c3.n.END_ARRAY) {
                int i10 = a.f6498a[_findCoercionFromEmptyArray.ordinal()];
                if (i10 == 1) {
                    return (Date) getEmptyValue(gVar);
                }
                if (i10 == 2 || i10 == 3) {
                    return (Date) getNullValue(gVar);
                }
            } else if (n02) {
                if (s02 == c3.n.START_ARRAY) {
                    return (Date) handleNestedArrayForSingle(kVar, gVar);
                }
                Date _parseDate = _parseDate(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseDate;
            }
        }
        return (Date) gVar.b0(this._valueClass, c3.n.START_ARRAY, kVar, null, new Object[0]);
    }

    public final double _parseDoublePrimitive(c3.k kVar, k3.g gVar) {
        String z10;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 11) {
                    _verifyNullForPrimitive(gVar);
                    return 0.0d;
                }
                if (q10 == 6) {
                    z10 = kVar.Y();
                } else if (q10 == 7 || q10 == 8) {
                    return kVar.M();
                }
            } else if (gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == c3.n.START_ARRAY) {
                    return ((Double) handleNestedArrayForSingle(kVar, gVar)).doubleValue();
                }
                double _parseDoublePrimitive = _parseDoublePrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseDoublePrimitive;
            }
            return ((Number) gVar.a0(Double.TYPE, kVar)).doubleValue();
        }
        z10 = gVar.z(kVar, this, Double.TYPE);
        Double _checkDoubleSpecialValue = _checkDoubleSpecialValue(z10);
        if (_checkDoubleSpecialValue != null) {
            return _checkDoubleSpecialValue.doubleValue();
        }
        m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10, c4.f.Integer, Double.TYPE);
        if (_checkFromStringCoercion == m3.b.AsNull || _checkFromStringCoercion == m3.b.AsEmpty) {
            return 0.0d;
        }
        String trim = z10.trim();
        if (!_hasTextualNull(trim)) {
            return _parseDoublePrimitive(gVar, trim);
        }
        _verifyNullForPrimitiveCoercion(gVar, trim);
        return 0.0d;
    }

    public final float _parseFloatPrimitive(c3.k kVar, k3.g gVar) {
        String z10;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 11) {
                    _verifyNullForPrimitive(gVar);
                    return 0.0f;
                }
                if (q10 == 6) {
                    z10 = kVar.Y();
                } else if (q10 == 7 || q10 == 8) {
                    return kVar.O();
                }
            } else if (gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == c3.n.START_ARRAY) {
                    return ((Float) handleNestedArrayForSingle(kVar, gVar)).floatValue();
                }
                float _parseFloatPrimitive = _parseFloatPrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseFloatPrimitive;
            }
            return ((Number) gVar.a0(Float.TYPE, kVar)).floatValue();
        }
        z10 = gVar.z(kVar, this, Float.TYPE);
        Float _checkFloatSpecialValue = _checkFloatSpecialValue(z10);
        if (_checkFloatSpecialValue != null) {
            return _checkFloatSpecialValue.floatValue();
        }
        m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10, c4.f.Integer, Float.TYPE);
        if (_checkFromStringCoercion == m3.b.AsNull || _checkFromStringCoercion == m3.b.AsEmpty) {
            return 0.0f;
        }
        String trim = z10.trim();
        if (!_hasTextualNull(trim)) {
            return _parseFloatPrimitive(gVar, trim);
        }
        _verifyNullForPrimitiveCoercion(gVar, trim);
        return 0.0f;
    }

    public final int _parseIntPrimitive(c3.k kVar, k3.g gVar) {
        String z10;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 11) {
                    _verifyNullForPrimitive(gVar);
                    return 0;
                }
                if (q10 == 6) {
                    z10 = kVar.Y();
                } else {
                    if (q10 == 7) {
                        return kVar.P();
                    }
                    if (q10 == 8) {
                        m3.b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, Integer.TYPE);
                        if (_checkFloatToIntCoercion == m3.b.AsNull || _checkFloatToIntCoercion == m3.b.AsEmpty) {
                            return 0;
                        }
                        return kVar.e0();
                    }
                }
            } else if (gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == c3.n.START_ARRAY) {
                    return ((Integer) handleNestedArrayForSingle(kVar, gVar)).intValue();
                }
                int _parseIntPrimitive = _parseIntPrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseIntPrimitive;
            }
            return ((Number) gVar.a0(Integer.TYPE, kVar)).intValue();
        }
        z10 = gVar.z(kVar, this, Integer.TYPE);
        m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10, c4.f.Integer, Integer.TYPE);
        if (_checkFromStringCoercion == m3.b.AsNull || _checkFromStringCoercion == m3.b.AsEmpty) {
            return 0;
        }
        String trim = z10.trim();
        if (!_hasTextualNull(trim)) {
            return _parseIntPrimitive(gVar, trim);
        }
        _verifyNullForPrimitiveCoercion(gVar, trim);
        return 0;
    }

    public final Integer _parseInteger(c3.k kVar, k3.g gVar, Class<?> cls) {
        String z10;
        int q10 = kVar.q();
        if (q10 == 1) {
            z10 = gVar.z(kVar, this, cls);
        } else {
            if (q10 == 3) {
                return (Integer) _deserializeFromArray(kVar, gVar);
            }
            if (q10 == 11) {
                return (Integer) getNullValue(gVar);
            }
            if (q10 != 6) {
                if (q10 == 7) {
                    return Integer.valueOf(kVar.P());
                }
                if (q10 != 8) {
                    return (Integer) gVar.c0(getValueType(gVar), kVar);
                }
                m3.b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, cls);
                return _checkFloatToIntCoercion == m3.b.AsNull ? (Integer) getNullValue(gVar) : _checkFloatToIntCoercion == m3.b.AsEmpty ? (Integer) getEmptyValue(gVar) : Integer.valueOf(kVar.e0());
            }
            z10 = kVar.Y();
        }
        m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10);
        if (_checkFromStringCoercion == m3.b.AsNull) {
            return (Integer) getNullValue(gVar);
        }
        if (_checkFromStringCoercion == m3.b.AsEmpty) {
            return (Integer) getEmptyValue(gVar);
        }
        String trim = z10.trim();
        return _checkTextualNull(gVar, trim) ? (Integer) getNullValue(gVar) : Integer.valueOf(_parseIntPrimitive(gVar, trim));
    }

    public final Long _parseLong(c3.k kVar, k3.g gVar, Class<?> cls) {
        String z10;
        int q10 = kVar.q();
        if (q10 == 1) {
            z10 = gVar.z(kVar, this, cls);
        } else {
            if (q10 == 3) {
                return (Long) _deserializeFromArray(kVar, gVar);
            }
            if (q10 == 11) {
                return (Long) getNullValue(gVar);
            }
            if (q10 != 6) {
                if (q10 == 7) {
                    return Long.valueOf(kVar.Q());
                }
                if (q10 != 8) {
                    return (Long) gVar.c0(getValueType(gVar), kVar);
                }
                m3.b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, cls);
                return _checkFloatToIntCoercion == m3.b.AsNull ? (Long) getNullValue(gVar) : _checkFloatToIntCoercion == m3.b.AsEmpty ? (Long) getEmptyValue(gVar) : Long.valueOf(kVar.f0());
            }
            z10 = kVar.Y();
        }
        m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10);
        if (_checkFromStringCoercion == m3.b.AsNull) {
            return (Long) getNullValue(gVar);
        }
        if (_checkFromStringCoercion == m3.b.AsEmpty) {
            return (Long) getEmptyValue(gVar);
        }
        String trim = z10.trim();
        return _checkTextualNull(gVar, trim) ? (Long) getNullValue(gVar) : Long.valueOf(_parseLongPrimitive(gVar, trim));
    }

    public final long _parseLongPrimitive(c3.k kVar, k3.g gVar) {
        String z10;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 11) {
                    _verifyNullForPrimitive(gVar);
                    return 0L;
                }
                if (q10 == 6) {
                    z10 = kVar.Y();
                } else {
                    if (q10 == 7) {
                        return kVar.Q();
                    }
                    if (q10 == 8) {
                        m3.b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, Long.TYPE);
                        if (_checkFloatToIntCoercion == m3.b.AsNull || _checkFloatToIntCoercion == m3.b.AsEmpty) {
                            return 0L;
                        }
                        return kVar.f0();
                    }
                }
            } else if (gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == c3.n.START_ARRAY) {
                    return ((Long) handleNestedArrayForSingle(kVar, gVar)).longValue();
                }
                long _parseLongPrimitive = _parseLongPrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseLongPrimitive;
            }
            return ((Number) gVar.a0(Long.TYPE, kVar)).longValue();
        }
        z10 = gVar.z(kVar, this, Long.TYPE);
        m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10, c4.f.Integer, Long.TYPE);
        if (_checkFromStringCoercion == m3.b.AsNull || _checkFromStringCoercion == m3.b.AsEmpty) {
            return 0L;
        }
        String trim = z10.trim();
        if (!_hasTextualNull(trim)) {
            return _parseLongPrimitive(gVar, trim);
        }
        _verifyNullForPrimitiveCoercion(gVar, trim);
        return 0L;
    }

    public final short _parseShortPrimitive(c3.k kVar, k3.g gVar) {
        String z10;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 11) {
                    _verifyNullForPrimitive(gVar);
                    return (short) 0;
                }
                if (q10 == 6) {
                    z10 = kVar.Y();
                } else {
                    if (q10 == 7) {
                        return kVar.X();
                    }
                    if (q10 == 8) {
                        m3.b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, Short.TYPE);
                        if (_checkFloatToIntCoercion == m3.b.AsNull || _checkFloatToIntCoercion == m3.b.AsEmpty) {
                            return (short) 0;
                        }
                        return kVar.X();
                    }
                }
            } else if (gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == c3.n.START_ARRAY) {
                    return ((Short) handleNestedArrayForSingle(kVar, gVar)).shortValue();
                }
                short _parseShortPrimitive = _parseShortPrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseShortPrimitive;
            }
            return ((Short) gVar.c0(gVar.x(Short.TYPE), kVar)).shortValue();
        }
        z10 = gVar.z(kVar, this, Short.TYPE);
        m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10, c4.f.Integer, Short.TYPE);
        if (_checkFromStringCoercion == m3.b.AsNull || _checkFromStringCoercion == m3.b.AsEmpty) {
            return (short) 0;
        }
        String trim = z10.trim();
        if (_hasTextualNull(trim)) {
            _verifyNullForPrimitiveCoercion(gVar, trim);
            return (short) 0;
        }
        try {
            int j10 = f3.f.j(trim);
            return _shortOverflow(j10) ? ((Short) gVar.j0(Short.TYPE, trim, "overflow, value cannot be represented as 16-bit value", new Object[0])).shortValue() : (short) j10;
        } catch (IllegalArgumentException unused) {
            return ((Short) gVar.j0(Short.TYPE, trim, "not a valid `short` value", new Object[0])).shortValue();
        }
    }

    public final String _parseString(c3.k kVar, k3.g gVar) {
        if (kVar.j0(c3.n.VALUE_STRING)) {
            return kVar.Y();
        }
        if (!kVar.j0(c3.n.VALUE_EMBEDDED_OBJECT)) {
            if (kVar.j0(c3.n.START_OBJECT)) {
                return gVar.z(kVar, this, this._valueClass);
            }
            String g02 = kVar.g0();
            return g02 != null ? g02 : (String) gVar.a0(String.class, kVar);
        }
        Object N = kVar.N();
        if (N instanceof byte[]) {
            return gVar.M().i((byte[]) N, false);
        }
        if (N == null) {
            return null;
        }
        return N.toString();
    }

    public void _reportFailedNullCoerce(k3.g gVar, boolean z10, Enum<?> r52, String str) {
        gVar.z0(this, "Cannot coerce %s to Null value as %s (%s `%s.%s` to allow)", str, _coercedTypeDesc(), z10 ? "enable" : "disable", r52.getDeclaringClass().getSimpleName(), r52.name());
    }

    public final boolean _shortOverflow(int i10) {
        return i10 < -32768 || i10 > 32767;
    }

    public void _verifyEndArrayForSingle(c3.k kVar, k3.g gVar) {
        if (kVar.s0() != c3.n.END_ARRAY) {
            handleMissingEndArrayForSingle(kVar, gVar);
        }
    }

    public final void _verifyNullForPrimitive(k3.g gVar) {
        if (gVar.n0(k3.h.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            gVar.z0(this, "Cannot coerce `null` to %s (disable `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to allow)", _coercedTypeDesc());
        }
    }

    public final void _verifyNullForPrimitiveCoercion(k3.g gVar, String str) {
        boolean z10;
        k3.q qVar;
        k3.q qVar2 = k3.q.ALLOW_COERCION_OF_SCALARS;
        if (gVar.o0(qVar2)) {
            k3.h hVar = k3.h.FAIL_ON_NULL_FOR_PRIMITIVES;
            if (!gVar.n0(hVar)) {
                return;
            }
            z10 = false;
            qVar = hVar;
        } else {
            z10 = true;
            qVar = qVar2;
        }
        _reportFailedNullCoerce(gVar, z10, qVar, str.isEmpty() ? "empty String (\"\")" : String.format("String \"%s\"", str));
    }

    @Deprecated
    public final void _verifyNullForScalarCoercion(k3.g gVar, String str) {
        k3.q qVar = k3.q.ALLOW_COERCION_OF_SCALARS;
        if (gVar.o0(qVar)) {
            return;
        }
        _reportFailedNullCoerce(gVar, true, qVar, str.isEmpty() ? "empty String (\"\")" : String.format("String \"%s\"", str));
    }

    @Deprecated
    public void _verifyNumberForScalarCoercion(k3.g gVar, c3.k kVar) {
        k3.q qVar = k3.q.ALLOW_COERCION_OF_SCALARS;
        if (gVar.o0(qVar)) {
            return;
        }
        gVar.z0(this, "Cannot coerce Number (%s) to %s (enable `%s.%s` to allow)", kVar.Y(), _coercedTypeDesc(), qVar.getDeclaringClass().getSimpleName(), qVar.name());
    }

    @Deprecated
    public void _verifyStringForScalarCoercion(k3.g gVar, String str) {
        k3.q qVar = k3.q.ALLOW_COERCION_OF_SCALARS;
        if (gVar.o0(qVar)) {
            return;
        }
        gVar.z0(this, "Cannot coerce String \"%s\" to %s (enable `%s.%s` to allow)", str, _coercedTypeDesc(), qVar.getDeclaringClass().getSimpleName(), qVar.name());
    }

    @Override // k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return eVar.c(kVar, gVar);
    }

    public n3.q findContentNullProvider(k3.g gVar, k3.d dVar, k3.k kVar) {
        b3.j0 findContentNullStyle = findContentNullStyle(gVar, dVar);
        if (findContentNullStyle == b3.j0.SKIP) {
            return o3.q.d();
        }
        if (findContentNullStyle != b3.j0.FAIL) {
            n3.q _findNullProvider = _findNullProvider(gVar, dVar, findContentNullStyle, kVar);
            return _findNullProvider != null ? _findNullProvider : kVar;
        }
        if (dVar != null) {
            return o3.r.b(dVar, dVar.getType().k());
        }
        k3.j x10 = gVar.x(kVar.handledType());
        if (x10.D()) {
            x10 = x10.k();
        }
        return o3.r.c(x10);
    }

    public b3.j0 findContentNullStyle(k3.g gVar, k3.d dVar) {
        if (dVar != null) {
            return dVar.getMetadata().b();
        }
        return null;
    }

    public k3.k findConvertingContentDeserializer(k3.g gVar, k3.d dVar, k3.k kVar) {
        r3.i d10;
        Object k10;
        k3.b K = gVar.K();
        if (!_neitherNull(K, dVar) || (d10 = dVar.d()) == null || (k10 = K.k(d10)) == null) {
            return kVar;
        }
        d4.j j10 = gVar.j(dVar.d(), k10);
        k3.j b10 = j10.b(gVar.l());
        if (kVar == null) {
            kVar = gVar.D(b10, dVar);
        }
        return new a0(j10, b10, kVar);
    }

    public k3.k findDeserializer(k3.g gVar, k3.j jVar, k3.d dVar) {
        return gVar.D(jVar, dVar);
    }

    public Boolean findFormatFeature(k3.g gVar, k3.d dVar, Class<?> cls, k.a aVar) {
        k.d findFormatOverrides = findFormatOverrides(gVar, dVar, cls);
        if (findFormatOverrides != null) {
            return findFormatOverrides.e(aVar);
        }
        return null;
    }

    public k.d findFormatOverrides(k3.g gVar, k3.d dVar, Class<?> cls) {
        return dVar != null ? dVar.a(gVar.k(), cls) : gVar.O(cls);
    }

    public final n3.q findValueNullProvider(k3.g gVar, n3.t tVar, k3.w wVar) {
        if (tVar != null) {
            return _findNullProvider(gVar, tVar, wVar.e(), tVar.u());
        }
        return null;
    }

    @Deprecated
    public final Class<?> getValueClass() {
        return this._valueClass;
    }

    public n3.w getValueInstantiator() {
        return null;
    }

    public k3.j getValueType() {
        return this._valueType;
    }

    public void handleMissingEndArrayForSingle(c3.k kVar, k3.g gVar) {
        gVar.G0(this, c3.n.END_ARRAY, "Attempted to unwrap '%s' value from an array (with `DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS`) but it contains more than one value", handledType().getName());
    }

    public Object handleNestedArrayForSingle(c3.k kVar, k3.g gVar) {
        return gVar.d0(getValueType(gVar), kVar.n(), kVar, String.format("Cannot deserialize instance of %s out of %s token: nested Arrays not allowed with %s", d4.h.X(this._valueClass), c3.n.START_ARRAY, "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS"), new Object[0]);
    }

    public void handleUnknownProperty(c3.k kVar, k3.g gVar, Object obj, String str) {
        if (obj == null) {
            obj = handledType();
        }
        if (gVar.e0(kVar, this, obj, str)) {
            return;
        }
        kVar.D0();
    }

    @Override // k3.k
    public Class<?> handledType() {
        return this._valueClass;
    }

    public boolean isDefaultDeserializer(k3.k kVar) {
        return d4.h.O(kVar);
    }

    public boolean isDefaultKeyDeserializer(k3.p pVar) {
        return d4.h.O(pVar);
    }

    public m3.b _checkFromStringCoercion(k3.g gVar, String str, c4.f fVar, Class<?> cls) {
        if (str.isEmpty()) {
            return _checkCoercionFail(gVar, gVar.B(fVar, cls, m3.e.EmptyString), cls, str, "empty String (\"\")");
        }
        if (_isBlank(str)) {
            return _checkCoercionFail(gVar, gVar.C(fVar, cls, m3.b.Fail), cls, str, "blank String (all whitespace)");
        }
        if (gVar.m0(c3.r.UNTYPED_SCALARS)) {
            return m3.b.TryConvert;
        }
        m3.b B = gVar.B(fVar, cls, m3.e.String);
        if (B == m3.b.Fail) {
            gVar.z0(this, "Cannot coerce String value (\"%s\") to %s (but might if coercion using `CoercionConfig` was enabled)", str, _coercedTypeDesc());
        }
        return B;
    }

    public final boolean _parseBooleanPrimitive(c3.k kVar, k3.g gVar) {
        String z10;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 6) {
                    z10 = kVar.Y();
                } else {
                    if (q10 == 7) {
                        return Boolean.TRUE.equals(_coerceBooleanFromInt(kVar, gVar, Boolean.TYPE));
                    }
                    switch (q10) {
                        case 9:
                            return true;
                        case 11:
                            _verifyNullForPrimitive(gVar);
                        case 10:
                            return false;
                    }
                }
            } else if (gVar.n0(k3.h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == c3.n.START_ARRAY) {
                    return ((Boolean) handleNestedArrayForSingle(kVar, gVar)).booleanValue();
                }
                boolean _parseBooleanPrimitive = _parseBooleanPrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseBooleanPrimitive;
            }
            return ((Boolean) gVar.a0(Boolean.TYPE, kVar)).booleanValue();
        }
        z10 = gVar.z(kVar, this, Boolean.TYPE);
        c4.f fVar = c4.f.Boolean;
        Class cls = Boolean.TYPE;
        m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, z10, fVar, cls);
        if (_checkFromStringCoercion == m3.b.AsNull) {
            _verifyNullForPrimitive(gVar);
            return false;
        }
        if (_checkFromStringCoercion == m3.b.AsEmpty) {
            return false;
        }
        String trim = z10.trim();
        int length = trim.length();
        if (length == 4) {
            if (_isTrue(trim)) {
                return true;
            }
        } else if (length == 5 && _isFalse(trim)) {
            return false;
        }
        if (_hasTextualNull(trim)) {
            _verifyNullForPrimitiveCoercion(gVar, trim);
            return false;
        }
        return Boolean.TRUE.equals((Boolean) gVar.j0(cls, trim, "only \"true\"/\"True\"/\"TRUE\" or \"false\"/\"False\"/\"FALSE\" recognized", new Object[0]));
    }

    public k3.j getValueType(k3.g gVar) {
        k3.j jVar = this._valueType;
        return jVar != null ? jVar : gVar.x(this._valueClass);
    }

    public b0(k3.j jVar) {
        this._valueClass = jVar == null ? Object.class : jVar.q();
        this._valueType = jVar;
    }

    public b0(b0 b0Var) {
        this._valueClass = b0Var._valueClass;
        this._valueType = b0Var._valueType;
    }

    public Date _parseDate(String str, k3.g gVar) {
        try {
            if (str.isEmpty()) {
                if (a.f6498a[_checkFromStringCoercion(gVar, str).ordinal()] != 1) {
                    return null;
                }
                return new Date(0L);
            }
            if (_hasTextualNull(str)) {
                return null;
            }
            return gVar.s0(str);
        } catch (IllegalArgumentException e10) {
            return (Date) gVar.j0(this._valueClass, str, "not a valid representation (error: %s)", d4.h.o(e10));
        }
    }

    public final double _parseDoublePrimitive(k3.g gVar, String str) {
        try {
            return _parseDouble(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) gVar.j0(Double.TYPE, str, "not a valid `double` value (as String to convert)", new Object[0])).doubleValue();
        }
    }

    public final float _parseFloatPrimitive(k3.g gVar, String str) {
        try {
            return Float.parseFloat(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) gVar.j0(Float.TYPE, str, "not a valid `float` value", new Object[0])).floatValue();
        }
    }

    public final int _parseIntPrimitive(k3.g gVar, String str) {
        try {
            if (str.length() > 9) {
                long parseLong = Long.parseLong(str);
                return _intOverflow(parseLong) ? _nonNullNumber((Number) gVar.j0(Integer.TYPE, str, "Overflow: numeric value (%s) out of range of int (%d -%d)", str, Integer.MIN_VALUE, Integer.MAX_VALUE)).intValue() : (int) parseLong;
            }
            return f3.f.j(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) gVar.j0(Integer.TYPE, str, "not a valid `int` value", new Object[0])).intValue();
        }
    }

    public final long _parseLongPrimitive(k3.g gVar, String str) {
        try {
            return f3.f.l(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) gVar.j0(Long.TYPE, str, "not a valid `long` value", new Object[0])).longValue();
        }
    }
}
