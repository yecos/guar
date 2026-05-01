package a1;

import android.os.Build;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: i, reason: collision with root package name */
    public static final b f82i = new a().a();

    /* renamed from: a, reason: collision with root package name */
    public l f83a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f84b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f85c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f86d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f87e;

    /* renamed from: f, reason: collision with root package name */
    public long f88f;

    /* renamed from: g, reason: collision with root package name */
    public long f89g;

    /* renamed from: h, reason: collision with root package name */
    public c f90h;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f91a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f92b = false;

        /* renamed from: c, reason: collision with root package name */
        public l f93c = l.NOT_REQUIRED;

        /* renamed from: d, reason: collision with root package name */
        public boolean f94d = false;

        /* renamed from: e, reason: collision with root package name */
        public boolean f95e = false;

        /* renamed from: f, reason: collision with root package name */
        public long f96f = -1;

        /* renamed from: g, reason: collision with root package name */
        public long f97g = -1;

        /* renamed from: h, reason: collision with root package name */
        public c f98h = new c();

        public b a() {
            return new b(this);
        }
    }

    public b() {
        this.f83a = l.NOT_REQUIRED;
        this.f88f = -1L;
        this.f89g = -1L;
        this.f90h = new c();
    }

    public c a() {
        return this.f90h;
    }

    public l b() {
        return this.f83a;
    }

    public long c() {
        return this.f88f;
    }

    public long d() {
        return this.f89g;
    }

    public boolean e() {
        return this.f90h.c() > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f84b == bVar.f84b && this.f85c == bVar.f85c && this.f86d == bVar.f86d && this.f87e == bVar.f87e && this.f88f == bVar.f88f && this.f89g == bVar.f89g && this.f83a == bVar.f83a) {
            return this.f90h.equals(bVar.f90h);
        }
        return false;
    }

    public boolean f() {
        return this.f86d;
    }

    public boolean g() {
        return this.f84b;
    }

    public boolean h() {
        return this.f85c;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f83a.hashCode() * 31) + (this.f84b ? 1 : 0)) * 31) + (this.f85c ? 1 : 0)) * 31) + (this.f86d ? 1 : 0)) * 31) + (this.f87e ? 1 : 0)) * 31;
        long j10 = this.f88f;
        int i10 = (hashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f89g;
        return ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f90h.hashCode();
    }

    public boolean i() {
        return this.f87e;
    }

    public void j(c cVar) {
        this.f90h = cVar;
    }

    public void k(l lVar) {
        this.f83a = lVar;
    }

    public void l(boolean z10) {
        this.f86d = z10;
    }

    public void m(boolean z10) {
        this.f84b = z10;
    }

    public void n(boolean z10) {
        this.f85c = z10;
    }

    public void o(boolean z10) {
        this.f87e = z10;
    }

    public void p(long j10) {
        this.f88f = j10;
    }

    public void q(long j10) {
        this.f89g = j10;
    }

    public b(a aVar) {
        this.f83a = l.NOT_REQUIRED;
        this.f88f = -1L;
        this.f89g = -1L;
        this.f90h = new c();
        this.f84b = aVar.f91a;
        int i10 = Build.VERSION.SDK_INT;
        this.f85c = i10 >= 23 && aVar.f92b;
        this.f83a = aVar.f93c;
        this.f86d = aVar.f94d;
        this.f87e = aVar.f95e;
        if (i10 >= 24) {
            this.f90h = aVar.f98h;
            this.f88f = aVar.f96f;
            this.f89g = aVar.f97g;
        }
    }

    public b(b bVar) {
        this.f83a = l.NOT_REQUIRED;
        this.f88f = -1L;
        this.f89g = -1L;
        this.f90h = new c();
        this.f84b = bVar.f84b;
        this.f85c = bVar.f85c;
        this.f83a = bVar.f83a;
        this.f86d = bVar.f86d;
        this.f87e = bVar.f87e;
        this.f90h = bVar.f90h;
    }
}
