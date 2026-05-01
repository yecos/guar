package ca;

import java.util.concurrent.CancellationException;

/* loaded from: classes3.dex */
public final class g1 extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient f1 f5752a;

    public g1(String str, Throwable th, f1 f1Var) {
        super(str);
        this.f5752a = f1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof g1) {
                g1 g1Var = (g1) obj;
                if (!t9.i.b(g1Var.getMessage(), getMessage()) || !t9.i.b(g1Var.f5752a, this.f5752a) || !t9.i.b(g1Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        t9.i.d(message);
        int hashCode = ((message.hashCode() * 31) + this.f5752a.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f5752a;
    }
}
