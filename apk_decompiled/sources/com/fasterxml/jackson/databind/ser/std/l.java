package com.fasterxml.jackson.databind.ser.std;

import b3.k;
import c3.k;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class l extends h0 implements a4.i {

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f6694a;

    /* renamed from: b, reason: collision with root package name */
    public final DateFormat f6695b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f6696c;

    public l(Class cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        this.f6694a = bool;
        this.f6695b = dateFormat;
        this.f6696c = dateFormat == null ? null : new AtomicReference();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        c(fVar, jVar, d(fVar.getProvider()));
    }

    @Override // a4.i
    public k3.o b(k3.c0 c0Var, k3.d dVar) {
        k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, handledType());
        if (findFormatOverrides == null) {
            return this;
        }
        k.c i10 = findFormatOverrides.i();
        if (i10.a()) {
            return f(Boolean.TRUE, null);
        }
        if (findFormatOverrides.m()) {
            DateFormat simpleDateFormat = new SimpleDateFormat(findFormatOverrides.h(), findFormatOverrides.l() ? findFormatOverrides.g() : c0Var.e0());
            simpleDateFormat.setTimeZone(findFormatOverrides.o() ? findFormatOverrides.j() : c0Var.f0());
            return f(Boolean.FALSE, simpleDateFormat);
        }
        boolean l10 = findFormatOverrides.l();
        boolean o10 = findFormatOverrides.o();
        boolean z10 = i10 == k.c.STRING;
        if (!l10 && !o10 && !z10) {
            return this;
        }
        DateFormat k10 = c0Var.k().k();
        if (k10 instanceof d4.x) {
            d4.x xVar = (d4.x) k10;
            if (findFormatOverrides.l()) {
                xVar = xVar.u(findFormatOverrides.g());
            }
            if (findFormatOverrides.o()) {
                xVar = xVar.v(findFormatOverrides.j());
            }
            return f(Boolean.FALSE, xVar);
        }
        if (!(k10 instanceof SimpleDateFormat)) {
            c0Var.p(handledType(), String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", k10.getClass().getName()));
        }
        SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat) k10;
        DateFormat simpleDateFormat3 = l10 ? new SimpleDateFormat(simpleDateFormat2.toPattern(), findFormatOverrides.g()) : (SimpleDateFormat) simpleDateFormat2.clone();
        TimeZone j10 = findFormatOverrides.j();
        if ((j10 == null || j10.equals(simpleDateFormat3.getTimeZone())) ? false : true) {
            simpleDateFormat3.setTimeZone(j10);
        }
        return f(Boolean.FALSE, simpleDateFormat3);
    }

    public void c(u3.f fVar, k3.j jVar, boolean z10) {
        if (z10) {
            visitIntFormat(fVar, jVar, k.b.LONG, u3.m.UTC_MILLISEC);
        } else {
            visitStringFormat(fVar, jVar, u3.m.DATE_TIME);
        }
    }

    public boolean d(k3.c0 c0Var) {
        Boolean bool = this.f6694a;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this.f6695b != null) {
            return false;
        }
        if (c0Var != null) {
            return c0Var.m0(k3.b0.WRITE_DATES_AS_TIMESTAMPS);
        }
        throw new IllegalArgumentException("Null SerializerProvider passed for " + handledType().getName());
    }

    public void e(Date date, c3.h hVar, k3.c0 c0Var) {
        if (this.f6695b == null) {
            c0Var.D(date, hVar);
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f6696c.getAndSet(null);
        if (dateFormat == null) {
            dateFormat = (DateFormat) this.f6695b.clone();
        }
        hVar.z0(dateFormat.format(date));
        h3.b.a(this.f6696c, null, dateFormat);
    }

    public abstract l f(Boolean bool, DateFormat dateFormat);

    @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        return createSchemaNode(d(c0Var) ? "number" : "string", true);
    }

    @Override // k3.o
    public boolean isEmpty(k3.c0 c0Var, Object obj) {
        return false;
    }
}
