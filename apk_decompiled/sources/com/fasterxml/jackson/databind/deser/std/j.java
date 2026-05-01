package com.fasterxml.jackson.databind.deser.std;

import b3.k;
import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.TimeZone;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f6554a;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6555a;

        static {
            int[] iArr = new int[m3.b.values().length];
            f6555a = iArr;
            try {
                iArr[m3.b.AsEmpty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6555a[m3.b.AsNull.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6555a[m3.b.TryConvert.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class d extends c {

        /* renamed from: c, reason: collision with root package name */
        public static final d f6559c = new d();

        public d() {
            super(Date.class);
        }

        @Override // k3.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Date deserialize(c3.k kVar, k3.g gVar) {
            return _parseDate(kVar, gVar);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.j.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d a(DateFormat dateFormat, String str) {
            return new d(this, dateFormat, str);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.j.c, n3.i
        public /* bridge */ /* synthetic */ k3.k createContextual(k3.g gVar, k3.d dVar) {
            return super.createContextual(gVar, dVar);
        }

        @Override // k3.k
        public Object getEmptyValue(k3.g gVar) {
            return new Date(0L);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.j.c, com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public /* bridge */ /* synthetic */ c4.f logicalType() {
            return super.logicalType();
        }

        public d(d dVar, DateFormat dateFormat, String str) {
            super(dVar, dateFormat, str);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f6554a = hashSet;
        hashSet.add("java.util.Calendar");
        hashSet.add("java.util.GregorianCalendar");
        hashSet.add("java.util.Date");
    }

    public static k3.k a(Class cls, String str) {
        if (!f6554a.contains(str)) {
            return null;
        }
        if (cls == Calendar.class) {
            return new b();
        }
        if (cls == Date.class) {
            return d.f6559c;
        }
        if (cls == GregorianCalendar.class) {
            return new b(GregorianCalendar.class);
        }
        return null;
    }

    public static class b extends c {

        /* renamed from: c, reason: collision with root package name */
        public final Constructor f6556c;

        public b() {
            super(Calendar.class);
            this.f6556c = null;
        }

        @Override // k3.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Calendar deserialize(c3.k kVar, k3.g gVar) {
            Date _parseDate = _parseDate(kVar, gVar);
            if (_parseDate == null) {
                return null;
            }
            Constructor constructor = this.f6556c;
            if (constructor == null) {
                return gVar.v(_parseDate);
            }
            try {
                Calendar calendar = (Calendar) constructor.newInstance(new Object[0]);
                calendar.setTimeInMillis(_parseDate.getTime());
                TimeZone T = gVar.T();
                if (T != null) {
                    calendar.setTimeZone(T);
                }
                return calendar;
            } catch (Exception e10) {
                return (Calendar) gVar.V(handledType(), _parseDate, e10);
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.j.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public b a(DateFormat dateFormat, String str) {
            return new b(this, dateFormat, str);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.j.c, n3.i
        public /* bridge */ /* synthetic */ k3.k createContextual(k3.g gVar, k3.d dVar) {
            return super.createContextual(gVar, dVar);
        }

        @Override // k3.k
        public Object getEmptyValue(k3.g gVar) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(0L);
            return gregorianCalendar;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.j.c, com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public /* bridge */ /* synthetic */ c4.f logicalType() {
            return super.logicalType();
        }

        public b(Class cls) {
            super(cls);
            this.f6556c = d4.h.q(cls, false);
        }

        public b(b bVar, DateFormat dateFormat, String str) {
            super(bVar, dateFormat, str);
            this.f6556c = bVar.f6556c;
        }
    }

    public static abstract class c extends e0 implements n3.i {

        /* renamed from: a, reason: collision with root package name */
        public final DateFormat f6557a;

        /* renamed from: b, reason: collision with root package name */
        public final String f6558b;

        public c(Class cls) {
            super(cls);
            this.f6557a = null;
            this.f6558b = null;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.b0
        public Date _parseDate(c3.k kVar, k3.g gVar) {
            Date parse;
            if (this.f6557a == null || !kVar.j0(c3.n.VALUE_STRING)) {
                return super._parseDate(kVar, gVar);
            }
            String trim = kVar.Y().trim();
            if (trim.isEmpty()) {
                if (a.f6555a[_checkFromStringCoercion(gVar, trim).ordinal()] != 1) {
                    return null;
                }
                return new Date(0L);
            }
            synchronized (this.f6557a) {
                try {
                    try {
                        parse = this.f6557a.parse(trim);
                    } catch (ParseException unused) {
                        return (Date) gVar.j0(handledType(), trim, "expected format \"%s\"", this.f6558b);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return parse;
        }

        public abstract c a(DateFormat dateFormat, String str);

        public k3.k createContextual(k3.g gVar, k3.d dVar) {
            DateFormat dateFormat;
            DateFormat dateFormat2;
            k.d findFormatOverrides = findFormatOverrides(gVar, dVar, handledType());
            if (findFormatOverrides != null) {
                TimeZone j10 = findFormatOverrides.j();
                Boolean f10 = findFormatOverrides.f();
                if (findFormatOverrides.m()) {
                    String h10 = findFormatOverrides.h();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(h10, findFormatOverrides.l() ? findFormatOverrides.g() : gVar.Q());
                    if (j10 == null) {
                        j10 = gVar.T();
                    }
                    simpleDateFormat.setTimeZone(j10);
                    if (f10 != null) {
                        simpleDateFormat.setLenient(f10.booleanValue());
                    }
                    return a(simpleDateFormat, h10);
                }
                if (j10 != null) {
                    DateFormat k10 = gVar.k().k();
                    if (k10.getClass() == d4.x.class) {
                        d4.x u10 = ((d4.x) k10).v(j10).u(findFormatOverrides.l() ? findFormatOverrides.g() : gVar.Q());
                        dateFormat2 = u10;
                        if (f10 != null) {
                            dateFormat2 = u10.t(f10);
                        }
                    } else {
                        DateFormat dateFormat3 = (DateFormat) k10.clone();
                        dateFormat3.setTimeZone(j10);
                        dateFormat2 = dateFormat3;
                        if (f10 != null) {
                            dateFormat3.setLenient(f10.booleanValue());
                            dateFormat2 = dateFormat3;
                        }
                    }
                    return a(dateFormat2, this.f6558b);
                }
                if (f10 != null) {
                    DateFormat k11 = gVar.k().k();
                    String str = this.f6558b;
                    if (k11.getClass() == d4.x.class) {
                        d4.x t10 = ((d4.x) k11).t(f10);
                        str = t10.s();
                        dateFormat = t10;
                    } else {
                        DateFormat dateFormat4 = (DateFormat) k11.clone();
                        dateFormat4.setLenient(f10.booleanValue());
                        boolean z10 = dateFormat4 instanceof SimpleDateFormat;
                        dateFormat = dateFormat4;
                        if (z10) {
                            ((SimpleDateFormat) dateFormat4).toPattern();
                            dateFormat = dateFormat4;
                        }
                    }
                    if (str == null) {
                        str = "[unknown]";
                    }
                    return a(dateFormat, str);
                }
            }
            return this;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
        public c4.f logicalType() {
            return c4.f.DateTime;
        }

        public c(c cVar, DateFormat dateFormat, String str) {
            super(cVar._valueClass);
            this.f6557a = dateFormat;
            this.f6558b = str;
        }
    }
}
