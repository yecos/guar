package z8;

import com.google.common.base.Preconditions;

/* loaded from: classes3.dex */
public final class m2 {

    /* renamed from: l, reason: collision with root package name */
    public static final b f20749l = new b(j2.f20666a);

    /* renamed from: a, reason: collision with root package name */
    public final j2 f20750a;

    /* renamed from: b, reason: collision with root package name */
    public long f20751b;

    /* renamed from: c, reason: collision with root package name */
    public long f20752c;

    /* renamed from: d, reason: collision with root package name */
    public long f20753d;

    /* renamed from: e, reason: collision with root package name */
    public long f20754e;

    /* renamed from: f, reason: collision with root package name */
    public long f20755f;

    /* renamed from: g, reason: collision with root package name */
    public c f20756g;

    /* renamed from: h, reason: collision with root package name */
    public long f20757h;

    /* renamed from: i, reason: collision with root package name */
    public long f20758i;

    /* renamed from: j, reason: collision with root package name */
    public final d1 f20759j;

    /* renamed from: k, reason: collision with root package name */
    public volatile long f20760k;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final j2 f20761a;

        public b(j2 j2Var) {
            this.f20761a = j2Var;
        }

        public m2 a() {
            return new m2(this.f20761a);
        }
    }

    public interface c {
    }

    public static b a() {
        return f20749l;
    }

    public void b() {
        this.f20755f++;
    }

    public void c() {
        this.f20751b++;
        this.f20752c = this.f20750a.a();
    }

    public void d() {
        this.f20759j.add(1L);
        this.f20760k = this.f20750a.a();
    }

    public void e(int i10) {
        if (i10 == 0) {
            return;
        }
        this.f20757h += i10;
        this.f20758i = this.f20750a.a();
    }

    public void f(boolean z10) {
        if (z10) {
            this.f20753d++;
        } else {
            this.f20754e++;
        }
    }

    public void g(c cVar) {
        this.f20756g = (c) Preconditions.checkNotNull(cVar);
    }

    public m2(j2 j2Var) {
        this.f20759j = e1.a();
        this.f20750a = j2Var;
    }
}
