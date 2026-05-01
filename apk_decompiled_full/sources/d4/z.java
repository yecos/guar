package d4;

/* loaded from: classes.dex */
public class z extends c3.m {

    /* renamed from: c, reason: collision with root package name */
    public final c3.m f12631c;

    /* renamed from: d, reason: collision with root package name */
    public final c3.i f12632d;

    /* renamed from: e, reason: collision with root package name */
    public String f12633e;

    /* renamed from: f, reason: collision with root package name */
    public Object f12634f;

    public z(c3.m mVar, c3.i iVar) {
        super(mVar);
        this.f12631c = mVar.e();
        this.f12633e = mVar.b();
        this.f12634f = mVar.c();
        this.f12632d = iVar;
    }

    public static z m(c3.m mVar) {
        return mVar == null ? new z() : new z(mVar, null);
    }

    @Override // c3.m
    public String b() {
        return this.f12633e;
    }

    @Override // c3.m
    public Object c() {
        return this.f12634f;
    }

    @Override // c3.m
    public c3.m e() {
        return this.f12631c;
    }

    @Override // c3.m
    public void i(Object obj) {
        this.f12634f = obj;
    }

    public z k() {
        this.f5484b++;
        return new z(this, 1, -1);
    }

    public z l() {
        this.f5484b++;
        return new z(this, 2, -1);
    }

    public z n() {
        c3.m mVar = this.f12631c;
        return mVar instanceof z ? (z) mVar : mVar == null ? new z() : new z(mVar, this.f12632d);
    }

    public void o(String str) {
        this.f12633e = str;
    }

    public void p() {
        this.f5484b++;
    }

    public z() {
        super(0, -1);
        this.f12631c = null;
        this.f12632d = c3.i.f5449f;
    }

    public z(z zVar, int i10, int i11) {
        super(i10, i11);
        this.f12631c = zVar;
        this.f12632d = zVar.f12632d;
    }
}
