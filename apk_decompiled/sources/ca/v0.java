package ca;

import java.util.concurrent.CancellationException;

/* loaded from: classes3.dex */
public abstract class v0 {
    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
