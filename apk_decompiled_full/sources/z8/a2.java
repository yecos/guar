package z8;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class a2 implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f20292c = Logger.getLogger(a2.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public boolean f20293a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayDeque f20294b;

    public final void a() {
        while (true) {
            Runnable runnable = (Runnable) this.f20294b.poll();
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th) {
                f20292c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
            }
        }
    }

    public final void b(Runnable runnable) {
        if (this.f20294b == null) {
            this.f20294b = new ArrayDeque(4);
        }
        this.f20294b.add(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        if (r6.f20294b == null) goto L9;
     */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(Runnable runnable) {
        Preconditions.checkNotNull(runnable, "'task' must not be null.");
        if (this.f20293a) {
            b(runnable);
            return;
        }
        this.f20293a = true;
        try {
            runnable.run();
        } catch (Throwable th) {
            try {
                f20292c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
            } finally {
                if (this.f20294b != null) {
                    a();
                }
                this.f20293a = false;
            }
        }
    }
}
