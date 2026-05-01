package m3;

import b3.b0;
import b3.k;
import b3.r;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import k3.q;
import k3.y;
import r3.a;
import r3.a0;
import r3.h0;
import r3.t;

/* loaded from: classes.dex */
public abstract class m implements t.a, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final r.b f16694c = r.b.c();

    /* renamed from: d, reason: collision with root package name */
    public static final k.d f16695d = k.d.b();

    /* renamed from: a, reason: collision with root package name */
    public final int f16696a;

    /* renamed from: b, reason: collision with root package name */
    public final a f16697b;

    public m(a aVar, int i10) {
        this.f16697b = aVar;
        this.f16696a = i10;
    }

    public static int c(Class cls) {
        int i10 = 0;
        for (Object obj : (Enum[]) cls.getEnumConstants()) {
            f fVar = (f) obj;
            if (fVar.a()) {
                i10 |= fVar.b();
            }
        }
        return i10;
    }

    public k3.c A(Class cls) {
        return B(e(cls));
    }

    public k3.c B(k3.j jVar) {
        return i().a(this, jVar, this);
    }

    public final boolean C() {
        return D(q.USE_ANNOTATIONS);
    }

    public final boolean D(q qVar) {
        return qVar.c(this.f16696a);
    }

    public final boolean E() {
        return D(q.SORT_PROPERTIES_ALPHABETICALLY);
    }

    public w3.f F(r3.b bVar, Class cls) {
        u();
        return (w3.f) d4.h.l(cls, b());
    }

    public w3.g G(r3.b bVar, Class cls) {
        u();
        return (w3.g) d4.h.l(cls, b());
    }

    public final boolean b() {
        return D(q.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    public c3.q d(String str) {
        return new f3.i(str);
    }

    public final k3.j e(Class cls) {
        return z().H(cls);
    }

    public final a.AbstractC0314a f() {
        return this.f16697b.a();
    }

    public k3.b g() {
        return D(q.USE_ANNOTATIONS) ? this.f16697b.b() : a0.f18330a;
    }

    public c3.a h() {
        return this.f16697b.c();
    }

    public t i() {
        return this.f16697b.d();
    }

    public abstract g j(Class cls);

    public final DateFormat k() {
        return this.f16697b.e();
    }

    public abstract r.b l(Class cls, Class cls2);

    public r.b m(Class cls, Class cls2, r.b bVar) {
        return r.b.j(bVar, j(cls).d(), j(cls2).e());
    }

    public abstract Boolean n();

    public abstract k.d o(Class cls);

    public abstract r.b p(Class cls);

    public r.b q(Class cls, r.b bVar) {
        r.b d10 = j(cls).d();
        return d10 != null ? d10 : bVar;
    }

    public abstract b0.a r();

    public final w3.g s(k3.j jVar) {
        return this.f16697b.l();
    }

    public abstract h0 t(Class cls, r3.c cVar);

    public final l u() {
        this.f16697b.f();
        return null;
    }

    public final Locale v() {
        return this.f16697b.g();
    }

    public w3.c w() {
        w3.c h10 = this.f16697b.h();
        return (h10 == x3.l.f19425a && D(q.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES)) ? new w3.a() : h10;
    }

    public final y x() {
        this.f16697b.i();
        return null;
    }

    public final TimeZone y() {
        return this.f16697b.j();
    }

    public final c4.o z() {
        return this.f16697b.k();
    }

    public m(m mVar, int i10) {
        this.f16697b = mVar.f16697b;
        this.f16696a = i10;
    }
}
