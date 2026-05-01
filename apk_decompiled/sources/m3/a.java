package m3;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import k3.y;
import r3.a;
import r3.t;

/* loaded from: classes.dex */
public final class a implements Serializable {

    /* renamed from: k, reason: collision with root package name */
    public static final TimeZone f16618k = TimeZone.getTimeZone("UTC");

    /* renamed from: a, reason: collision with root package name */
    public final c4.o f16619a;

    /* renamed from: b, reason: collision with root package name */
    public final t f16620b;

    /* renamed from: c, reason: collision with root package name */
    public final k3.b f16621c;

    /* renamed from: d, reason: collision with root package name */
    public final a.AbstractC0314a f16622d;

    /* renamed from: e, reason: collision with root package name */
    public final w3.g f16623e;

    /* renamed from: f, reason: collision with root package name */
    public final w3.c f16624f;

    /* renamed from: g, reason: collision with root package name */
    public final DateFormat f16625g;

    /* renamed from: h, reason: collision with root package name */
    public final Locale f16626h;

    /* renamed from: i, reason: collision with root package name */
    public final TimeZone f16627i;

    /* renamed from: j, reason: collision with root package name */
    public final c3.a f16628j;

    public a(t tVar, k3.b bVar, y yVar, c4.o oVar, w3.g gVar, DateFormat dateFormat, l lVar, Locale locale, TimeZone timeZone, c3.a aVar, w3.c cVar, a.AbstractC0314a abstractC0314a) {
        this.f16620b = tVar;
        this.f16621c = bVar;
        this.f16619a = oVar;
        this.f16623e = gVar;
        this.f16625g = dateFormat;
        this.f16626h = locale;
        this.f16627i = timeZone;
        this.f16628j = aVar;
        this.f16624f = cVar;
        this.f16622d = abstractC0314a;
    }

    public a.AbstractC0314a a() {
        return this.f16622d;
    }

    public k3.b b() {
        return this.f16621c;
    }

    public c3.a c() {
        return this.f16628j;
    }

    public t d() {
        return this.f16620b;
    }

    public DateFormat e() {
        return this.f16625g;
    }

    public l f() {
        return null;
    }

    public Locale g() {
        return this.f16626h;
    }

    public w3.c h() {
        return this.f16624f;
    }

    public y i() {
        return null;
    }

    public TimeZone j() {
        TimeZone timeZone = this.f16627i;
        return timeZone == null ? f16618k : timeZone;
    }

    public c4.o k() {
        return this.f16619a;
    }

    public w3.g l() {
        return this.f16623e;
    }

    public a m(t tVar) {
        return this.f16620b == tVar ? this : new a(tVar, this.f16621c, null, this.f16619a, this.f16623e, this.f16625g, null, this.f16626h, this.f16627i, this.f16628j, this.f16624f, this.f16622d);
    }
}
