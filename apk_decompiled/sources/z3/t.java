package z3;

import k3.c0;

/* loaded from: classes.dex */
public class t extends v {

    /* renamed from: b, reason: collision with root package name */
    public static final t f20214b = new t("");

    /* renamed from: a, reason: collision with root package name */
    public final String f20215a;

    public t(String str) {
        this.f20215a = str;
    }

    public static t w(String str) {
        if (str == null) {
            return null;
        }
        return str.isEmpty() ? f20214b : new t(str);
    }

    @Override // z3.v, c3.v
    public c3.n b() {
        return c3.n.VALUE_STRING;
    }

    @Override // z3.b, k3.n
    public final void d(c3.h hVar, c0 c0Var) {
        String str = this.f20215a;
        if (str == null) {
            hVar.a0();
        } else {
            hVar.z0(str);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof t)) {
            return ((t) obj).f20215a.equals(this.f20215a);
        }
        return false;
    }

    @Override // k3.m
    public String g() {
        return this.f20215a;
    }

    public int hashCode() {
        return this.f20215a.hashCode();
    }

    @Override // k3.m
    public byte[] i() {
        return v(c3.b.a());
    }

    @Override // k3.m
    public m o() {
        return m.STRING;
    }

    @Override // k3.m
    public String u() {
        return this.f20215a;
    }

    public byte[] v(c3.a aVar) {
        String trim = this.f20215a.trim();
        j3.c cVar = new j3.c(Math.max(16, Math.min(65536, ((trim.length() >> 2) * 3) + 4)));
        try {
            aVar.e(trim, cVar);
            return cVar.v();
        } catch (IllegalArgumentException e10) {
            throw p3.c.v(null, String.format("Cannot access contents of TextNode as binary due to broken Base64 encoding: %s", e10.getMessage()), trim, byte[].class);
        }
    }
}
