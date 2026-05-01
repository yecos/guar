package r3;

import b3.k;
import b3.r;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class v implements k3.d, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final k3.w f18487a;

    /* renamed from: b, reason: collision with root package name */
    public transient List f18488b;

    public v(k3.w wVar) {
        this.f18487a = wVar == null ? k3.w.f14996j : wVar;
    }

    @Override // k3.d
    public k.d a(m3.m mVar, Class cls) {
        i d10;
        k.d o10 = mVar.o(cls);
        k3.b g10 = mVar.g();
        k.d q10 = (g10 == null || (d10 = d()) == null) ? null : g10.q(d10);
        return o10 == null ? q10 == null ? k3.d.f14862c0 : q10 : q10 == null ? o10 : o10.r(q10);
    }

    @Override // k3.d
    public r.b b(m3.m mVar, Class cls) {
        k3.b g10 = mVar.g();
        i d10 = d();
        if (d10 == null) {
            return mVar.p(cls);
        }
        r.b l10 = mVar.l(cls, d10.e());
        if (g10 == null) {
            return l10;
        }
        r.b M = g10.M(d10);
        return l10 == null ? M : l10.m(M);
    }

    public List e(m3.m mVar) {
        i d10;
        List list = this.f18488b;
        if (list == null) {
            k3.b g10 = mVar.g();
            if (g10 != null && (d10 = d()) != null) {
                list = g10.G(d10);
            }
            if (list == null) {
                list = Collections.emptyList();
            }
            this.f18488b = list;
        }
        return list;
    }

    public boolean f() {
        return this.f18487a.g();
    }

    @Override // k3.d
    public k3.w getMetadata() {
        return this.f18487a;
    }

    public v(v vVar) {
        this.f18487a = vVar.f18487a;
    }
}
