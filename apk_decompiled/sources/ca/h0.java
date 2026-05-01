package ca;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes3.dex */
public final class h0 extends r0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: h, reason: collision with root package name */
    public static final h0 f5753h;

    /* renamed from: i, reason: collision with root package name */
    public static final long f5754i;

    static {
        Long l10;
        h0 h0Var = new h0();
        f5753h = h0Var;
        q0.T(h0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f5754i = timeUnit.toNanos(l10.longValue());
    }

    @Override // ca.s0
    public Thread X() {
        Thread thread = _thread;
        return thread == null ? k0() : thread;
    }

    @Override // ca.r0
    public void b0(Runnable runnable) {
        if (l0()) {
            o0();
        }
        super.b0(runnable);
    }

    public final synchronized void j0() {
        if (m0()) {
            debugStatus = 3;
            h0();
            notifyAll();
        }
    }

    public final synchronized Thread k0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean l0() {
        return debugStatus == 4;
    }

    public final boolean m0() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }

    public final synchronized boolean n0() {
        if (m0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    public final void o0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean e02;
        w1.f5809a.c(this);
        c.a();
        try {
            if (!n0()) {
                if (e02) {
                    return;
                } else {
                    return;
                }
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long f02 = f0();
                if (f02 == Long.MAX_VALUE) {
                    c.a();
                    long nanoTime = System.nanoTime();
                    if (j10 == Long.MAX_VALUE) {
                        j10 = f5754i + nanoTime;
                    }
                    long j11 = j10 - nanoTime;
                    if (j11 <= 0) {
                        _thread = null;
                        j0();
                        c.a();
                        if (e0()) {
                            return;
                        }
                        X();
                        return;
                    }
                    f02 = y9.e.c(f02, j11);
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (f02 > 0) {
                    if (m0()) {
                        _thread = null;
                        j0();
                        c.a();
                        if (e0()) {
                            return;
                        }
                        X();
                        return;
                    }
                    c.a();
                    LockSupport.parkNanos(this, f02);
                }
            }
        } finally {
            _thread = null;
            j0();
            c.a();
            if (!e0()) {
                X();
            }
        }
    }

    @Override // ca.r0, ca.q0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
