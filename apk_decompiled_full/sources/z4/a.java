package z4;

/* loaded from: classes3.dex */
public class a extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public int f20220a;

    /* renamed from: b, reason: collision with root package name */
    public int f20221b;

    public a(int i10) {
        this.f20220a = i10;
    }

    public int a() {
        return this.f20220a;
    }

    public int b() {
        return this.f20221b;
    }

    public a(int i10, String str) {
        super(str);
        this.f20220a = i10;
    }

    public a(int i10, int i11, String str) {
        super(str);
        this.f20220a = i10;
        this.f20221b = i11;
    }

    public a(int i10, String str, Throwable th) {
        super(str, th);
        this.f20220a = i10;
    }

    public a(int i10, Throwable th) {
        super(th);
        this.f20220a = i10;
    }
}
