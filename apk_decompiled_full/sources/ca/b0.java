package ca;

/* loaded from: classes3.dex */
public abstract class b0 {
    public static final void a(k9.f fVar, Throwable th) {
        try {
            z zVar = (z) fVar.a(z.U);
            if (zVar != null) {
                zVar.y(fVar, th);
            } else {
                a0.a(fVar, th);
            }
        } catch (Throwable th2) {
            a0.a(fVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        h9.a.a(runtimeException, th);
        return runtimeException;
    }
}
