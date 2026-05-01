package y4;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public transient s4.b f19740a;

    /* renamed from: b, reason: collision with root package name */
    public z4.a f19741b;

    /* renamed from: c, reason: collision with root package name */
    public String f19742c;

    /* renamed from: d, reason: collision with root package name */
    public long f19743d;

    /* renamed from: e, reason: collision with root package name */
    public String f19744e;

    /* renamed from: f, reason: collision with root package name */
    public String f19745f;

    /* renamed from: g, reason: collision with root package name */
    public String f19746g;

    /* renamed from: h, reason: collision with root package name */
    public long f19747h;

    /* renamed from: i, reason: collision with root package name */
    public long f19748i;

    /* renamed from: j, reason: collision with root package name */
    public int f19749j;

    /* renamed from: k, reason: collision with root package name */
    public String f19750k;

    /* renamed from: l, reason: collision with root package name */
    public int f19751l = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f19752m;

    /* renamed from: n, reason: collision with root package name */
    public List f19753n;

    /* renamed from: y4.a$a, reason: collision with other inner class name */
    public static final class C0342a {

        /* renamed from: a, reason: collision with root package name */
        public String f19754a;

        /* renamed from: b, reason: collision with root package name */
        public long f19755b = -1;

        /* renamed from: c, reason: collision with root package name */
        public String f19756c;

        /* renamed from: d, reason: collision with root package name */
        public String f19757d;

        /* renamed from: e, reason: collision with root package name */
        public String f19758e;

        public a a() {
            a aVar = new a();
            if (TextUtils.isEmpty(this.f19756c)) {
                throw new z4.a(0, "uri cannot be null.");
            }
            aVar.F(this.f19756c);
            if (TextUtils.isEmpty(this.f19758e)) {
                throw new z4.a(1, "path cannot be null.");
            }
            aVar.z(this.f19758e);
            if (this.f19755b == -1) {
                aVar.t(System.currentTimeMillis());
            }
            aVar.r(this.f19757d);
            if (TextUtils.isEmpty(this.f19754a)) {
                aVar.y(this.f19756c);
            } else {
                aVar.y(this.f19754a);
            }
            return aVar;
        }

        public C0342a b(String str) {
            this.f19757d = str;
            return this;
        }

        public C0342a c(String str) {
            this.f19754a = str;
            return this;
        }

        public C0342a d(String str) {
            this.f19758e = str;
            return this;
        }

        public C0342a e(String str) {
            this.f19756c = str;
            return this;
        }
    }

    public void A(long j10) {
        this.f19748i = j10;
    }

    public void B(long j10) {
        this.f19747h = j10;
    }

    public void C(int i10) {
        this.f19749j = i10;
    }

    public void D(int i10) {
        this.f19752m = i10;
    }

    public void E(boolean z10) {
        this.f19752m = !z10 ? 1 : 0;
    }

    public void F(String str) {
        this.f19744e = str;
    }

    public String a() {
        return this.f19745f;
    }

    public int b() {
        return this.f19751l;
    }

    public long c() {
        return this.f19743d;
    }

    public s4.b d() {
        return this.f19740a;
    }

    public List e() {
        return this.f19753n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f19742c == ((a) obj).f19742c;
    }

    public z4.a f() {
        return this.f19741b;
    }

    public String g() {
        return this.f19742c;
    }

    public String h() {
        return this.f19746g;
    }

    public int hashCode() {
        return this.f19742c.hashCode();
    }

    public long i() {
        return this.f19748i;
    }

    public long j() {
        return this.f19747h;
    }

    public int k() {
        return this.f19749j;
    }

    public int l() {
        return this.f19752m;
    }

    public String m() {
        return this.f19744e;
    }

    public boolean n() {
        return this.f19749j == 5;
    }

    public boolean o() {
        int i10 = this.f19749j;
        return i10 == 2 || i10 == 1 || i10 == 3;
    }

    public boolean p() {
        int i10 = this.f19749j;
        return i10 == 4 || i10 == 6 || i10 == 7;
    }

    public boolean q() {
        return this.f19752m == 0;
    }

    public void r(String str) {
        this.f19745f = str;
    }

    public void s(int i10) {
        this.f19751l = i10;
    }

    public void t(long j10) {
        this.f19743d = j10;
    }

    public void u(s4.b bVar) {
        this.f19740a = bVar;
    }

    public void v(List list) {
        this.f19753n = list;
    }

    public void w(String str) {
        this.f19750k = str;
    }

    public void x(z4.a aVar) {
        this.f19741b = aVar;
    }

    public void y(String str) {
        this.f19742c = str;
    }

    public void z(String str) {
        this.f19746g = str;
    }
}
