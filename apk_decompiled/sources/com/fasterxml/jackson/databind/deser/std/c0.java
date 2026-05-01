package com.fasterxml.jackson.databind.deser.std;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class c0 extends k3.p implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final int f6499a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f6500b;

    /* renamed from: c, reason: collision with root package name */
    public final o f6501c;

    public static final class a extends k3.p implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Class f6502a;

        /* renamed from: b, reason: collision with root package name */
        public final k3.k f6503b;

        public a(Class cls, k3.k kVar) {
            this.f6502a = cls;
            this.f6503b = kVar;
        }

        @Override // k3.p
        public final Object a(String str, k3.g gVar) {
            if (str == null) {
                return null;
            }
            d4.y yVar = new d4.y(gVar.S(), gVar);
            yVar.z0(str);
            try {
                c3.k R0 = yVar.R0();
                R0.s0();
                Object deserialize = this.f6503b.deserialize(R0, gVar);
                return deserialize != null ? deserialize : gVar.g0(this.f6502a, str, "not a valid representation", new Object[0]);
            } catch (Exception e10) {
                return gVar.g0(this.f6502a, str, "not a valid representation: %s", e10.getMessage());
            }
        }
    }

    public static final class b extends c0 {

        /* renamed from: d, reason: collision with root package name */
        public final d4.k f6504d;

        /* renamed from: e, reason: collision with root package name */
        public final r3.j f6505e;

        /* renamed from: f, reason: collision with root package name */
        public d4.k f6506f;

        /* renamed from: g, reason: collision with root package name */
        public final Enum f6507g;

        public b(d4.k kVar, r3.j jVar) {
            super(-1, kVar.n());
            this.f6504d = kVar;
            this.f6505e = jVar;
            this.f6507g = kVar.m();
        }

        @Override // com.fasterxml.jackson.databind.deser.std.c0
        public Object b(String str, k3.g gVar) {
            r3.j jVar = this.f6505e;
            if (jVar != null) {
                try {
                    return jVar.s(str);
                } catch (Exception e10) {
                    d4.h.l0(e10);
                }
            }
            d4.k h10 = gVar.n0(k3.h.READ_ENUMS_USING_TO_STRING) ? h(gVar) : this.f6504d;
            Enum l10 = h10.l(str);
            return l10 == null ? (this.f6507g == null || !gVar.n0(k3.h.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)) ? !gVar.n0(k3.h.READ_UNKNOWN_ENUM_VALUES_AS_NULL) ? gVar.g0(this.f6500b, str, "not one of the values accepted for Enum class: %s", h10.o()) : l10 : this.f6507g : l10;
        }

        public final d4.k h(k3.g gVar) {
            d4.k kVar = this.f6506f;
            if (kVar == null) {
                synchronized (this) {
                    kVar = d4.k.k(gVar.k(), this.f6504d.n());
                    this.f6506f = kVar;
                }
            }
            return kVar;
        }
    }

    public static final class c extends c0 {

        /* renamed from: d, reason: collision with root package name */
        public final Constructor f6508d;

        public c(Constructor constructor) {
            super(-1, constructor.getDeclaringClass());
            this.f6508d = constructor;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.c0
        public Object b(String str, k3.g gVar) {
            return this.f6508d.newInstance(str);
        }
    }

    public static final class d extends c0 {

        /* renamed from: d, reason: collision with root package name */
        public final Method f6509d;

        public d(Method method) {
            super(-1, method.getDeclaringClass());
            this.f6509d = method;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.c0
        public Object b(String str, k3.g gVar) {
            return this.f6509d.invoke(null, str);
        }
    }

    public static final class e extends c0 {

        /* renamed from: d, reason: collision with root package name */
        public static final e f6510d = new e(String.class);

        /* renamed from: e, reason: collision with root package name */
        public static final e f6511e = new e(Object.class);

        public e(Class cls) {
            super(-1, cls);
        }

        public static e h(Class cls) {
            return cls == String.class ? f6510d : cls == Object.class ? f6511e : new e(cls);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.c0, k3.p
        public Object a(String str, k3.g gVar) {
            return str;
        }
    }

    public c0(int i10, Class cls) {
        this(i10, cls, null);
    }

    public static c0 g(Class cls) {
        int i10;
        if (cls == String.class || cls == Object.class || cls == CharSequence.class || cls == Serializable.class) {
            return e.h(cls);
        }
        if (cls == UUID.class) {
            i10 = 12;
        } else if (cls == Integer.class) {
            i10 = 5;
        } else if (cls == Long.class) {
            i10 = 6;
        } else if (cls == Date.class) {
            i10 = 10;
        } else if (cls == Calendar.class) {
            i10 = 11;
        } else if (cls == Boolean.class) {
            i10 = 1;
        } else if (cls == Byte.class) {
            i10 = 2;
        } else if (cls == Character.class) {
            i10 = 4;
        } else if (cls == Short.class) {
            i10 = 3;
        } else if (cls == Float.class) {
            i10 = 7;
        } else if (cls == Double.class) {
            i10 = 8;
        } else if (cls == URI.class) {
            i10 = 13;
        } else if (cls == URL.class) {
            i10 = 14;
        } else if (cls == Class.class) {
            i10 = 15;
        } else {
            if (cls == Locale.class) {
                return new c0(9, cls, o.f(Locale.class));
            }
            if (cls == Currency.class) {
                return new c0(16, cls, o.f(Currency.class));
            }
            if (cls != byte[].class) {
                return null;
            }
            i10 = 17;
        }
        return new c0(i10, cls);
    }

    @Override // k3.p
    public Object a(String str, k3.g gVar) {
        if (str == null) {
            return null;
        }
        try {
            Object b10 = b(str, gVar);
            if (b10 != null) {
                return b10;
            }
            if (d4.h.L(this.f6500b) && gVar.k().j0(k3.h.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            return gVar.g0(this.f6500b, str, "not a valid representation", new Object[0]);
        } catch (Exception e10) {
            return gVar.g0(this.f6500b, str, "not a valid representation, problem: (%s) %s", e10.getClass().getName(), d4.h.o(e10));
        }
    }

    public Object b(String str, k3.g gVar) {
        switch (this.f6499a) {
            case 1:
                return "true".equals(str) ? Boolean.TRUE : "false".equals(str) ? Boolean.FALSE : gVar.g0(this.f6500b, str, "value not 'true' or 'false'", new Object[0]);
            case 2:
                int d10 = d(str);
                return (d10 < -128 || d10 > 255) ? gVar.g0(this.f6500b, str, "overflow, value cannot be represented as 8-bit value", new Object[0]) : Byte.valueOf((byte) d10);
            case 3:
                int d11 = d(str);
                return (d11 < -32768 || d11 > 32767) ? gVar.g0(this.f6500b, str, "overflow, value cannot be represented as 16-bit value", new Object[0]) : Short.valueOf((short) d11);
            case 4:
                return str.length() == 1 ? Character.valueOf(str.charAt(0)) : gVar.g0(this.f6500b, str, "can only convert 1-character Strings", new Object[0]);
            case 5:
                return Integer.valueOf(d(str));
            case 6:
                return Long.valueOf(e(str));
            case 7:
                return Float.valueOf((float) c(str));
            case 8:
                return Double.valueOf(c(str));
            case 9:
                try {
                    return this.f6501c.a(str, gVar);
                } catch (IllegalArgumentException e10) {
                    return f(gVar, str, e10);
                }
            case 10:
                return gVar.s0(str);
            case 11:
                return gVar.v(gVar.s0(str));
            case 12:
                try {
                    return UUID.fromString(str);
                } catch (Exception e11) {
                    return f(gVar, str, e11);
                }
            case 13:
                try {
                    return URI.create(str);
                } catch (Exception e12) {
                    return f(gVar, str, e12);
                }
            case 14:
                try {
                    return new URL(str);
                } catch (MalformedURLException e13) {
                    return f(gVar, str, e13);
                }
            case 15:
                try {
                    return gVar.A(str);
                } catch (Exception unused) {
                    return gVar.g0(this.f6500b, str, "unable to parse key as Class", new Object[0]);
                }
            case 16:
                try {
                    return this.f6501c.a(str, gVar);
                } catch (IllegalArgumentException e14) {
                    return f(gVar, str, e14);
                }
            case 17:
                try {
                    return gVar.k().h().f(str);
                } catch (IllegalArgumentException e15) {
                    return f(gVar, str, e15);
                }
            default:
                throw new IllegalStateException("Internal error: unknown key type " + this.f6500b);
        }
    }

    public double c(String str) {
        return f3.f.i(str);
    }

    public int d(String str) {
        return Integer.parseInt(str);
    }

    public long e(String str) {
        return Long.parseLong(str);
    }

    public Object f(k3.g gVar, String str, Exception exc) {
        return gVar.g0(this.f6500b, str, "problem: %s", d4.h.o(exc));
    }

    public c0(int i10, Class cls, o oVar) {
        this.f6499a = i10;
        this.f6500b = cls;
        this.f6501c = oVar;
    }
}
