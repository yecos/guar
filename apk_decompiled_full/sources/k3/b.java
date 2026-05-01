package k3;

import b3.b;
import b3.b0;
import b3.h;
import b3.k;
import b3.p;
import b3.r;
import b3.s;
import b3.w;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import l3.e;
import l3.f;
import r3.h0;

/* loaded from: classes.dex */
public abstract class b implements Serializable {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final EnumC0244a f14816a;

        /* renamed from: b, reason: collision with root package name */
        public final String f14817b;

        /* renamed from: k3.b$a$a, reason: collision with other inner class name */
        public enum EnumC0244a {
            MANAGED_REFERENCE,
            BACK_REFERENCE
        }

        public a(EnumC0244a enumC0244a, String str) {
            this.f14816a = enumC0244a;
            this.f14817b = str;
        }

        public static a a(String str) {
            return new a(EnumC0244a.BACK_REFERENCE, str);
        }

        public static a e(String str) {
            return new a(EnumC0244a.MANAGED_REFERENCE, str);
        }

        public String b() {
            return this.f14817b;
        }

        public boolean c() {
            return this.f14816a == EnumC0244a.BACK_REFERENCE;
        }

        public boolean d() {
            return this.f14816a == EnumC0244a.MANAGED_REFERENCE;
        }
    }

    public static b t0() {
        return r3.a0.f18330a;
    }

    public Object A(r3.b bVar) {
        return null;
    }

    public r3.b0 B(r3.b bVar) {
        return null;
    }

    public r3.b0 C(r3.b bVar, r3.b0 b0Var) {
        return b0Var;
    }

    public Class D(r3.c cVar) {
        return null;
    }

    public e.a E(r3.c cVar) {
        return null;
    }

    public w.a F(r3.b bVar) {
        return null;
    }

    public List G(r3.b bVar) {
        return null;
    }

    public w3.g H(m3.m mVar, r3.i iVar, j jVar) {
        return null;
    }

    public String I(r3.b bVar) {
        return null;
    }

    public String J(r3.b bVar) {
        return null;
    }

    public p.a K(m3.m mVar, r3.b bVar) {
        return L(bVar);
    }

    public p.a L(r3.b bVar) {
        return p.a.f();
    }

    public r.b M(r3.b bVar) {
        return r.b.c();
    }

    public s.a N(m3.m mVar, r3.b bVar) {
        return s.a.c();
    }

    public Integer O(r3.b bVar) {
        return null;
    }

    public w3.g P(m3.m mVar, r3.i iVar, j jVar) {
        return null;
    }

    public a Q(r3.i iVar) {
        return null;
    }

    public x R(m3.m mVar, r3.g gVar, x xVar) {
        return null;
    }

    public x S(r3.c cVar) {
        return null;
    }

    public Object T(r3.i iVar) {
        return null;
    }

    public Object U(r3.b bVar) {
        return null;
    }

    public String[] V(r3.c cVar) {
        return null;
    }

    public Boolean W(r3.b bVar) {
        return null;
    }

    public f.b X(r3.b bVar) {
        return null;
    }

    public Object Y(r3.b bVar) {
        return null;
    }

    public b0.a Z(r3.b bVar) {
        return b0.a.c();
    }

    public Annotation a(r3.b bVar, Class cls) {
        return bVar.c(cls);
    }

    public List a0(r3.b bVar) {
        return null;
    }

    public boolean b(r3.b bVar, Class cls) {
        return bVar.g(cls);
    }

    public String b0(r3.c cVar) {
        return null;
    }

    public boolean c(r3.b bVar, Class[] clsArr) {
        return bVar.h(clsArr);
    }

    public w3.g c0(m3.m mVar, r3.c cVar, j jVar) {
        return null;
    }

    public void d(m3.m mVar, r3.c cVar, List list) {
    }

    public d4.q d0(r3.i iVar) {
        return null;
    }

    public h0 e(r3.c cVar, h0 h0Var) {
        return h0Var;
    }

    public Object e0(r3.c cVar) {
        return null;
    }

    public Object f(r3.b bVar) {
        return null;
    }

    public Class[] f0(r3.b bVar) {
        return null;
    }

    public Object g(r3.b bVar) {
        return null;
    }

    public x g0(r3.b bVar) {
        return null;
    }

    public h.a h(m3.m mVar, r3.b bVar) {
        if (!n0(bVar)) {
            return null;
        }
        h.a i10 = i(bVar);
        return i10 == null ? h.a.DEFAULT : i10;
    }

    public Boolean h0(r3.b bVar) {
        if ((bVar instanceof r3.j) && i0((r3.j) bVar)) {
            return Boolean.TRUE;
        }
        return null;
    }

    public h.a i(r3.b bVar) {
        return null;
    }

    public boolean i0(r3.j jVar) {
        return false;
    }

    public Enum j(Class cls) {
        return null;
    }

    public Boolean j0(r3.b bVar) {
        return null;
    }

    public Object k(r3.i iVar) {
        return null;
    }

    public Boolean k0(m3.m mVar, r3.b bVar) {
        return null;
    }

    public Object l(r3.b bVar) {
        return null;
    }

    public Boolean l0(r3.b bVar) {
        if ((bVar instanceof r3.j) && m0((r3.j) bVar)) {
            return Boolean.TRUE;
        }
        return null;
    }

    public Object m(r3.b bVar) {
        return null;
    }

    public boolean m0(r3.j jVar) {
        return false;
    }

    public void n(Class cls, Enum[] enumArr, String[][] strArr) {
    }

    public boolean n0(r3.b bVar) {
        return false;
    }

    public String[] o(Class cls, Enum[] enumArr, String[] strArr) {
        return strArr;
    }

    public boolean o0(r3.i iVar) {
        return false;
    }

    public Object p(r3.b bVar) {
        return null;
    }

    public Boolean p0(r3.i iVar) {
        return null;
    }

    public k.d q(r3.b bVar) {
        return k.d.b();
    }

    public boolean q0(Annotation annotation) {
        return false;
    }

    public String r(r3.i iVar) {
        return null;
    }

    public Boolean r0(r3.c cVar) {
        return null;
    }

    public b.a s(r3.i iVar) {
        Object t10 = t(iVar);
        if (t10 != null) {
            return b.a.c(t10);
        }
        return null;
    }

    public Boolean s0(r3.i iVar) {
        return null;
    }

    public Object t(r3.i iVar) {
        return null;
    }

    public Object u(r3.b bVar) {
        return null;
    }

    public j u0(m3.m mVar, r3.b bVar, j jVar) {
        return jVar;
    }

    public Object v(r3.b bVar) {
        return null;
    }

    public j v0(m3.m mVar, r3.b bVar, j jVar) {
        return jVar;
    }

    public Boolean w(r3.b bVar) {
        return null;
    }

    public r3.j w0(m3.m mVar, r3.j jVar, r3.j jVar2) {
        return null;
    }

    public x x(r3.b bVar) {
        return null;
    }

    public x y(r3.b bVar) {
        return null;
    }

    public Object z(r3.c cVar) {
        return null;
    }
}
