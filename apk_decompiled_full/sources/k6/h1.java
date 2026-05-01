package k6;

/* loaded from: classes3.dex */
public final class h1 implements i6.a0 {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15267a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.b0 f15268b;

    public h1(f5.c cVar, i6.b0 b0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(b0Var, "view");
        this.f15267a = cVar;
        this.f15268b = b0Var;
        b0Var.Y0(this);
    }

    @Override // l5.a
    public void e() {
        i();
    }

    @Override // l5.a
    public void g() {
    }

    public void h() {
        q5.i.f18197a.l(this.f15267a);
    }

    public void i() {
        if (q5.i.f18197a.j(this.f15267a)) {
            this.f15268b.y1();
        } else {
            this.f15268b.e2();
        }
    }
}
