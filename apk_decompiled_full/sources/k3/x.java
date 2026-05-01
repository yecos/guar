package k3;

import java.io.Serializable;

/* loaded from: classes.dex */
public class x implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final x f15006d = new x("", null);

    /* renamed from: e, reason: collision with root package name */
    public static final x f15007e = new x(new String(""), null);

    /* renamed from: a, reason: collision with root package name */
    public final String f15008a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15009b;

    /* renamed from: c, reason: collision with root package name */
    public c3.q f15010c;

    public x(String str) {
        this(str, null);
    }

    public static x a(String str) {
        return (str == null || str.isEmpty()) ? f15006d : new x(j3.g.f14658b.a(str), null);
    }

    public static x b(String str, String str2) {
        if (str == null) {
            str = "";
        }
        return (str2 == null && str.isEmpty()) ? f15006d : new x(j3.g.f14658b.a(str), str2);
    }

    public String c() {
        return this.f15008a;
    }

    public boolean d() {
        return this.f15009b != null;
    }

    public boolean e() {
        return !this.f15008a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        x xVar = (x) obj;
        String str = this.f15008a;
        if (str == null) {
            if (xVar.f15008a != null) {
                return false;
            }
        } else if (!str.equals(xVar.f15008a)) {
            return false;
        }
        String str2 = this.f15009b;
        return str2 == null ? xVar.f15009b == null : str2.equals(xVar.f15009b);
    }

    public boolean f(String str) {
        return this.f15008a.equals(str);
    }

    public x g() {
        if (this.f15008a.isEmpty()) {
            return this;
        }
        String a10 = j3.g.f14658b.a(this.f15008a);
        return a10 == this.f15008a ? this : new x(a10, this.f15009b);
    }

    public boolean h() {
        return this.f15009b == null && this.f15008a.isEmpty();
    }

    public int hashCode() {
        String str = this.f15009b;
        return str == null ? this.f15008a.hashCode() : str.hashCode() ^ this.f15008a.hashCode();
    }

    public c3.q i(m3.m mVar) {
        c3.q qVar = this.f15010c;
        if (qVar != null) {
            return qVar;
        }
        c3.q iVar = mVar == null ? new f3.i(this.f15008a) : mVar.d(this.f15008a);
        this.f15010c = iVar;
        return iVar;
    }

    public x j(String str) {
        if (str == null) {
            str = "";
        }
        return str.equals(this.f15008a) ? this : new x(str, this.f15009b);
    }

    public String toString() {
        if (this.f15009b == null) {
            return this.f15008a;
        }
        return "{" + this.f15009b + "}" + this.f15008a;
    }

    public x(String str, String str2) {
        this.f15008a = d4.h.Z(str);
        this.f15009b = str2;
    }
}
