package y8;

/* loaded from: classes3.dex */
public class m1 extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final k1 f19946a;

    /* renamed from: b, reason: collision with root package name */
    public final v0 f19947b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19948c;

    public m1(k1 k1Var) {
        this(k1Var, null);
    }

    public final k1 a() {
        return this.f19946a;
    }

    public final v0 b() {
        return this.f19947b;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.f19948c ? super.fillInStackTrace() : this;
    }

    public m1(k1 k1Var, v0 v0Var) {
        this(k1Var, v0Var, true);
    }

    public m1(k1 k1Var, v0 v0Var, boolean z10) {
        super(k1.h(k1Var), k1Var.m());
        this.f19946a = k1Var;
        this.f19947b = v0Var;
        this.f19948c = z10;
        fillInStackTrace();
    }
}
