package z8;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class c1 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f20407b = Logger.getLogger(c1.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f20408a;

    public c1(Runnable runnable) {
        this.f20408a = (Runnable) Preconditions.checkNotNull(runnable, "task");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f20408a.run();
        } catch (Throwable th) {
            f20407b.log(Level.SEVERE, "Exception while executing runnable " + this.f20408a, th);
            Throwables.throwIfUnchecked(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.f20408a + ")";
    }
}
