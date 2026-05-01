package k3;

import b3.k;
import b3.r;
import java.io.Serializable;

/* loaded from: classes.dex */
public interface d extends d4.r {

    /* renamed from: c0, reason: collision with root package name */
    public static final k.d f14862c0 = new k.d();

    /* renamed from: d0, reason: collision with root package name */
    public static final r.b f14863d0 = r.b.c();

    public static class a implements d, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final x f14864a;

        /* renamed from: b, reason: collision with root package name */
        public final j f14865b;

        /* renamed from: c, reason: collision with root package name */
        public final x f14866c;

        /* renamed from: d, reason: collision with root package name */
        public final w f14867d;

        /* renamed from: e, reason: collision with root package name */
        public final r3.i f14868e;

        public a(x xVar, j jVar, x xVar2, r3.i iVar, w wVar) {
            this.f14864a = xVar;
            this.f14865b = jVar;
            this.f14866c = xVar2;
            this.f14867d = wVar;
            this.f14868e = iVar;
        }

        @Override // k3.d
        public k.d a(m3.m mVar, Class cls) {
            r3.i iVar;
            k.d o10 = mVar.o(cls);
            b g10 = mVar.g();
            if (g10 == null || (iVar = this.f14868e) == null) {
                return o10;
            }
            k.d q10 = g10.q(iVar);
            return q10 == null ? o10 : o10.r(q10);
        }

        @Override // k3.d
        public r.b b(m3.m mVar, Class cls) {
            r3.i iVar;
            r.b l10 = mVar.l(cls, this.f14865b.q());
            b g10 = mVar.g();
            if (g10 == null || (iVar = this.f14868e) == null) {
                return l10;
            }
            r.b M = g10.M(iVar);
            return M == null ? l10 : l10.m(M);
        }

        @Override // k3.d
        public x c() {
            return this.f14864a;
        }

        @Override // k3.d
        public r3.i d() {
            return this.f14868e;
        }

        public x e() {
            return this.f14866c;
        }

        @Override // k3.d
        public w getMetadata() {
            return this.f14867d;
        }

        @Override // k3.d, d4.r
        public String getName() {
            return this.f14864a.c();
        }

        @Override // k3.d
        public j getType() {
            return this.f14865b;
        }
    }

    k.d a(m3.m mVar, Class cls);

    r.b b(m3.m mVar, Class cls);

    x c();

    r3.i d();

    w getMetadata();

    @Override // d4.r
    String getName();

    j getType();
}
