package m;

/* loaded from: classes.dex */
public class n extends o {

    /* renamed from: c, reason: collision with root package name */
    public float f16600c = 0.0f;

    @Override // m.o
    public void e() {
        super.e();
        this.f16600c = 0.0f;
    }

    public void g() {
        this.f16602b = 2;
    }

    public void h(int i10) {
        int i11 = this.f16602b;
        if (i11 == 0 || this.f16600c != i10) {
            this.f16600c = i10;
            if (i11 == 1) {
                c();
            }
            b();
        }
    }
}
