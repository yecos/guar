package ab;

import ab.b;

/* loaded from: classes.dex */
public class f extends b {

    /* renamed from: e, reason: collision with root package name */
    public static final eb.g f513e = new eb.g();

    /* renamed from: f, reason: collision with root package name */
    public static final eb.h f514f = new eb.h();

    /* renamed from: g, reason: collision with root package name */
    public static final eb.i f515g = new eb.i();

    /* renamed from: h, reason: collision with root package name */
    public static final eb.j f516h = new eb.j();

    /* renamed from: a, reason: collision with root package name */
    public eb.b[] f517a;

    /* renamed from: b, reason: collision with root package name */
    public int f518b;

    /* renamed from: c, reason: collision with root package name */
    public b.a f519c;

    /* renamed from: d, reason: collision with root package name */
    public String f520d;

    public f() {
        eb.b[] bVarArr = new eb.b[4];
        this.f517a = bVarArr;
        bVarArr[0] = new eb.b(f513e);
        this.f517a[1] = new eb.b(f514f);
        this.f517a[2] = new eb.b(f515g);
        this.f517a[3] = new eb.b(f516h);
        i();
    }

    @Override // ab.b
    public String c() {
        return this.f520d;
    }

    @Override // ab.b
    public float d() {
        return 0.99f;
    }

    @Override // ab.b
    public b.a e() {
        return this.f519c;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12 && this.f519c == b.a.DETECTING) {
            for (int i13 = this.f518b - 1; i13 >= 0; i13--) {
                int c10 = this.f517a[i13].c(bArr[i10]);
                if (c10 == 1) {
                    int i14 = this.f518b - 1;
                    this.f518b = i14;
                    if (i14 <= 0) {
                        b.a aVar = b.a.NOT_ME;
                        this.f519c = aVar;
                        return aVar;
                    }
                    if (i13 != i14) {
                        eb.b[] bVarArr = this.f517a;
                        eb.b bVar = bVarArr[i14];
                        bVarArr[i14] = bVarArr[i13];
                        bVarArr[i13] = bVar;
                    }
                } else if (c10 == 2) {
                    this.f519c = b.a.FOUND_IT;
                    this.f520d = this.f517a[i13].a();
                    return this.f519c;
                }
            }
            i10++;
        }
        return this.f519c;
    }

    @Override // ab.b
    public void i() {
        this.f519c = b.a.DETECTING;
        int i10 = 0;
        while (true) {
            eb.b[] bVarArr = this.f517a;
            if (i10 >= bVarArr.length) {
                this.f518b = bVarArr.length;
                this.f520d = null;
                return;
            } else {
                bVarArr[i10].d();
                i10++;
            }
        }
    }
}
