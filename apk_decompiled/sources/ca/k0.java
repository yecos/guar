package ca;

/* loaded from: classes3.dex */
public final class k0 extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final k9.f f5763a;

    public k0(k9.f fVar) {
        this.f5763a = fVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f5763a.toString();
    }
}
