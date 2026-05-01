package q9;

import java.io.Closeable;

/* loaded from: classes3.dex */
public abstract class a {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                h9.a.a(th, th2);
            }
        }
    }
}
