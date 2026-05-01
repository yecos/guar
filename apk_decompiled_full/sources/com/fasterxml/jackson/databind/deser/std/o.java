package com.fasterxml.jackson.databind.deser.std;

import java.io.File;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class o extends e0 {

    public static class a extends o {

        /* renamed from: a, reason: collision with root package name */
        public final int f6588a;

        public a(Class cls, int i10) {
            super(cls);
            this.f6588a = i10;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.o
        public Object a(String str, k3.g gVar) {
            switch (this.f6588a) {
                case 1:
                    return new File(str);
                case 2:
                    return new URL(str);
                case 3:
                    return URI.create(str);
                case 4:
                    try {
                        return gVar.A(str);
                    } catch (Exception e10) {
                        return gVar.V(this._valueClass, str, d4.h.F(e10));
                    }
                case 5:
                    return gVar.l().A(str);
                case 6:
                    return Currency.getInstance(str);
                case 7:
                    return Pattern.compile(str);
                case 8:
                    int h10 = h(str);
                    if (h10 < 0) {
                        return new Locale(str);
                    }
                    String substring = str.substring(0, h10);
                    String substring2 = str.substring(h10 + 1);
                    int h11 = h(substring2);
                    return h11 < 0 ? new Locale(substring, substring2) : new Locale(substring, substring2.substring(0, h11), substring2.substring(h11 + 1));
                case 9:
                    return Charset.forName(str);
                case 10:
                    return TimeZone.getTimeZone(str);
                case 11:
                    return InetAddress.getByName(str);
                case 12:
                    if (str.startsWith("[")) {
                        int lastIndexOf = str.lastIndexOf(93);
                        if (lastIndexOf == -1) {
                            throw new p3.c(gVar.S(), "Bracketed IPv6 address must contain closing bracket", str, InetSocketAddress.class);
                        }
                        int indexOf = str.indexOf(58, lastIndexOf);
                        return new InetSocketAddress(str.substring(0, lastIndexOf + 1), indexOf > -1 ? Integer.parseInt(str.substring(indexOf + 1)) : 0);
                    }
                    int indexOf2 = str.indexOf(58);
                    if (indexOf2 >= 0) {
                        int i10 = indexOf2 + 1;
                        if (str.indexOf(58, i10) < 0) {
                            return new InetSocketAddress(str.substring(0, indexOf2), Integer.parseInt(str.substring(i10)));
                        }
                    }
                    return new InetSocketAddress(str, 0);
                default:
                    j3.q.a();
                    return null;
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.o
        public Object d(k3.g gVar) {
            return getEmptyValue(gVar);
        }

        @Override // k3.k
        public Object getEmptyValue(k3.g gVar) {
            int i10 = this.f6588a;
            return i10 != 3 ? i10 != 8 ? super.getEmptyValue(gVar) : Locale.ROOT : URI.create("");
        }

        public int h(String str) {
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = str.charAt(i10);
                if (charAt == '_' || charAt == '-') {
                    return i10;
                }
            }
            return -1;
        }
    }

    public static class b extends o {
        public b() {
            super(StringBuilder.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.o
        public Object a(String str, k3.g gVar) {
            return new StringBuilder(str);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.o, k3.k
        public Object deserialize(c3.k kVar, k3.g gVar) {
            String g02 = kVar.g0();
            return g02 != null ? a(g02, gVar) : super.deserialize(kVar, gVar);
        }

        @Override // k3.k
        public Object getEmptyValue(k3.g gVar) {
            return new StringBuilder();
        }

        @Override // com.fasterxml.jackson.databind.deser.std.o, com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public c4.f logicalType() {
            return c4.f.Textual;
        }
    }

    public o(Class cls) {
        super(cls);
    }

    public static o f(Class cls) {
        int i10;
        if (cls == File.class) {
            i10 = 1;
        } else if (cls == URL.class) {
            i10 = 2;
        } else if (cls == URI.class) {
            i10 = 3;
        } else if (cls == Class.class) {
            i10 = 4;
        } else if (cls == k3.j.class) {
            i10 = 5;
        } else if (cls == Currency.class) {
            i10 = 6;
        } else if (cls == Pattern.class) {
            i10 = 7;
        } else if (cls == Locale.class) {
            i10 = 8;
        } else if (cls == Charset.class) {
            i10 = 9;
        } else if (cls == TimeZone.class) {
            i10 = 10;
        } else if (cls == InetAddress.class) {
            i10 = 11;
        } else {
            if (cls != InetSocketAddress.class) {
                if (cls == StringBuilder.class) {
                    return new b();
                }
                return null;
            }
            i10 = 12;
        }
        return new a(cls, i10);
    }

    public static Class[] g() {
        return new Class[]{File.class, URL.class, URI.class, Class.class, k3.j.class, Currency.class, Pattern.class, Locale.class, Charset.class, TimeZone.class, InetAddress.class, InetSocketAddress.class, StringBuilder.class};
    }

    public abstract Object a(String str, k3.g gVar);

    public Object b(Object obj, k3.g gVar) {
        gVar.z0(this, "Don't know how to convert embedded Object of type %s into %s", obj.getClass().getName(), this._valueClass.getName());
        return null;
    }

    public Object c(k3.g gVar) {
        m3.b B = gVar.B(logicalType(), this._valueClass, m3.e.EmptyString);
        if (B == m3.b.Fail) {
            gVar.z0(this, "Cannot coerce empty String (\"\") to %s (but could if enabling coercion using `CoercionConfig`)", _coercedTypeDesc());
        }
        return B == m3.b.AsNull ? getNullValue(gVar) : B == m3.b.AsEmpty ? getEmptyValue(gVar) : d(gVar);
    }

    public Object d(k3.g gVar) {
        return getNullValue(gVar);
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar) {
        String g02 = kVar.g0();
        if (g02 == null) {
            c3.n n10 = kVar.n();
            if (n10 != c3.n.START_OBJECT) {
                return e(kVar, gVar, n10);
            }
            g02 = gVar.z(kVar, this, this._valueClass);
        }
        if (!g02.isEmpty()) {
            String trim = g02.trim();
            if (!trim.isEmpty()) {
                try {
                    return a(trim, gVar);
                } catch (IllegalArgumentException | MalformedURLException e10) {
                    String message = e10.getMessage();
                    String str = "not a valid textual representation";
                    if (message != null) {
                        str = "not a valid textual representation, problem: " + message;
                    }
                    k3.l L0 = gVar.L0(trim, this._valueClass, str);
                    L0.initCause(e10);
                    throw L0;
                }
            }
        }
        return c(gVar);
    }

    public Object e(c3.k kVar, k3.g gVar, c3.n nVar) {
        if (nVar == c3.n.START_ARRAY) {
            return _deserializeFromArray(kVar, gVar);
        }
        if (nVar != c3.n.VALUE_EMBEDDED_OBJECT) {
            return gVar.a0(this._valueClass, kVar);
        }
        Object N = kVar.N();
        if (N == null) {
            return null;
        }
        return this._valueClass.isAssignableFrom(N.getClass()) ? N : b(N, gVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
    public c4.f logicalType() {
        return c4.f.OtherScalar;
    }
}
