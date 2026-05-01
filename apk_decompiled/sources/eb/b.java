package eb;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public m f12969a;

    /* renamed from: b, reason: collision with root package name */
    public int f12970b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f12971c;

    /* renamed from: d, reason: collision with root package name */
    public int f12972d;

    public b(m mVar) {
        this.f12969a = mVar;
    }

    public String a() {
        return this.f12969a.c();
    }

    public int b() {
        return this.f12971c;
    }

    public int c(byte b10) {
        int b11 = this.f12969a.b(b10);
        if (this.f12970b == 0) {
            this.f12972d = 0;
            this.f12971c = this.f12969a.a(b11);
        }
        int d10 = this.f12969a.d(b11, this.f12970b);
        this.f12970b = d10;
        this.f12972d++;
        return d10;
    }

    public void d() {
        this.f12970b = 0;
    }
}
