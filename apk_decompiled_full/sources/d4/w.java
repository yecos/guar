package d4;

import b3.r;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public class w extends r3.s {

    /* renamed from: b, reason: collision with root package name */
    public final k3.b f12579b;

    /* renamed from: c, reason: collision with root package name */
    public final r3.i f12580c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.w f12581d;

    /* renamed from: e, reason: collision with root package name */
    public final k3.x f12582e;

    /* renamed from: f, reason: collision with root package name */
    public final r.b f12583f;

    public w(k3.b bVar, r3.i iVar, k3.x xVar, k3.w wVar, r.b bVar2) {
        this.f12579b = bVar;
        this.f12580c = iVar;
        this.f12582e = xVar;
        this.f12581d = wVar == null ? k3.w.f14995i : wVar;
        this.f12583f = bVar2;
    }

    public static w E(m3.m mVar, r3.i iVar, k3.x xVar) {
        return G(mVar, iVar, xVar, null, r3.s.f18483a);
    }

    public static w F(m3.m mVar, r3.i iVar, k3.x xVar, k3.w wVar, r.a aVar) {
        return new w(mVar.g(), iVar, xVar, wVar, (aVar == null || aVar == r.a.USE_DEFAULTS) ? r3.s.f18483a : r.b.a(aVar, null));
    }

    public static w G(m3.m mVar, r3.i iVar, k3.x xVar, k3.w wVar, r.b bVar) {
        return new w(mVar.g(), iVar, xVar, wVar, bVar);
    }

    @Override // r3.s
    public boolean A() {
        return v() != null;
    }

    @Override // r3.s
    public boolean B() {
        return false;
    }

    @Override // r3.s
    public boolean C() {
        return false;
    }

    @Override // r3.s
    public k3.x c() {
        return this.f12582e;
    }

    @Override // r3.s
    public r.b g() {
        return this.f12583f;
    }

    @Override // r3.s
    public k3.w getMetadata() {
        return this.f12581d;
    }

    @Override // r3.s, d4.r
    public String getName() {
        return this.f12582e.c();
    }

    @Override // r3.s
    public r3.m m() {
        r3.i iVar = this.f12580c;
        if (iVar instanceof r3.m) {
            return (r3.m) iVar;
        }
        return null;
    }

    @Override // r3.s
    public Iterator n() {
        r3.m m10 = m();
        return m10 == null ? h.n() : Collections.singleton(m10).iterator();
    }

    @Override // r3.s
    public r3.g o() {
        r3.i iVar = this.f12580c;
        if (iVar instanceof r3.g) {
            return (r3.g) iVar;
        }
        return null;
    }

    @Override // r3.s
    public r3.j p() {
        r3.i iVar = this.f12580c;
        if ((iVar instanceof r3.j) && ((r3.j) iVar).v() == 0) {
            return (r3.j) this.f12580c;
        }
        return null;
    }

    @Override // r3.s
    public r3.i s() {
        return this.f12580c;
    }

    @Override // r3.s
    public k3.j t() {
        r3.i iVar = this.f12580c;
        return iVar == null ? c4.o.O() : iVar.f();
    }

    @Override // r3.s
    public Class u() {
        r3.i iVar = this.f12580c;
        return iVar == null ? Object.class : iVar.e();
    }

    @Override // r3.s
    public r3.j v() {
        r3.i iVar = this.f12580c;
        if ((iVar instanceof r3.j) && ((r3.j) iVar).v() == 1) {
            return (r3.j) this.f12580c;
        }
        return null;
    }

    @Override // r3.s
    public k3.x w() {
        r3.i iVar;
        k3.b bVar = this.f12579b;
        if (bVar == null || (iVar = this.f12580c) == null) {
            return null;
        }
        return bVar.g0(iVar);
    }

    @Override // r3.s
    public boolean x() {
        return this.f12580c instanceof r3.m;
    }

    @Override // r3.s
    public boolean y() {
        return this.f12580c instanceof r3.g;
    }

    @Override // r3.s
    public boolean z(k3.x xVar) {
        return this.f12582e.equals(xVar);
    }
}
