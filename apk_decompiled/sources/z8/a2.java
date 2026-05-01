package z8;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public void execute(java.lang.Runnable r7) {
        /*
            r6 = this;
            java.lang.String r0 = "'task' must not be null."
            com.google.common.base.Preconditions.checkNotNull(r7, r0)
            boolean r0 = r6.f20293a
            if (r0 != 0) goto L43
            r0 = 1
            r6.f20293a = r0
            r0 = 0
            r7.run()     // Catch: java.lang.Throwable -> L1a
            java.util.ArrayDeque r7 = r6.f20294b
            if (r7 == 0) goto L17
        L14:
            r6.a()
        L17:
            r6.f20293a = r0
            goto L46
        L1a:
            r1 = move-exception
            java.util.logging.Logger r2 = z8.a2.f20292c     // Catch: java.lang.Throwable -> L38
            java.util.logging.Level r3 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r4.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r5 = "Exception while executing runnable "
            r4.append(r5)     // Catch: java.lang.Throwable -> L38
            r4.append(r7)     // Catch: java.lang.Throwable -> L38
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L38
            r2.log(r3, r7, r1)     // Catch: java.lang.Throwable -> L38
            java.util.ArrayDeque r7 = r6.f20294b
            if (r7 == 0) goto L17
            goto L14
        L38:
            r7 = move-exception
            java.util.ArrayDeque r1 = r6.f20294b
            if (r1 == 0) goto L40
            r6.a()
        L40:
            r6.f20293a = r0
            throw r7
        L43:
            r6.b(r7)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.a2.execute(java.lang.Runnable):void");
    }
}
