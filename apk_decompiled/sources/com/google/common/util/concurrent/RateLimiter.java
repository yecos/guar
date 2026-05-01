package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class RateLimiter {

    @CheckForNull
    private volatile Object mutexDoNotUseDirectly;
    private final SleepingStopwatch stopwatch;

    public static abstract class SleepingStopwatch {
        public static SleepingStopwatch createFromSystemTimer() {
            return new SleepingStopwatch() { // from class: com.google.common.util.concurrent.RateLimiter.SleepingStopwatch.1
                final Stopwatch stopwatch = Stopwatch.createStarted();

                @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
                public long readMicros() {
                    return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
                }

                @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
                public void sleepMicrosUninterruptibly(long j10) {
                    if (j10 > 0) {
                        Uninterruptibles.sleepUninterruptibly(j10, TimeUnit.MICROSECONDS);
                    }
                }
            };
        }

        public abstract long readMicros();

        public abstract void sleepMicrosUninterruptibly(long j10);
    }

    public RateLimiter(SleepingStopwatch sleepingStopwatch) {
        this.stopwatch = (SleepingStopwatch) Preconditions.checkNotNull(sleepingStopwatch);
    }

    private boolean canAcquire(long j10, long j11) {
        return queryEarliestAvailable(j10) - j11 <= j10;
    }

    private static void checkPermits(int i10) {
        Preconditions.checkArgument(i10 > 0, "Requested permits (%s) must be positive", i10);
    }

    public static RateLimiter create(double d10) {
        return create(d10, SleepingStopwatch.createFromSystemTimer());
    }

    private Object mutex() {
        Object obj = this.mutexDoNotUseDirectly;
        if (obj == null) {
            synchronized (this) {
                obj = this.mutexDoNotUseDirectly;
                if (obj == null) {
                    obj = new Object();
                    this.mutexDoNotUseDirectly = obj;
                }
            }
        }
        return obj;
    }

    @CanIgnoreReturnValue
    public double acquire() {
        return acquire(1);
    }

    public abstract double doGetRate();

    public abstract void doSetRate(double d10, long j10);

    public final double getRate() {
        double doGetRate;
        synchronized (mutex()) {
            doGetRate = doGetRate();
        }
        return doGetRate;
    }

    public abstract long queryEarliestAvailable(long j10);

    public final long reserve(int i10) {
        long reserveAndGetWaitLength;
        checkPermits(i10);
        synchronized (mutex()) {
            reserveAndGetWaitLength = reserveAndGetWaitLength(i10, this.stopwatch.readMicros());
        }
        return reserveAndGetWaitLength;
    }

    public final long reserveAndGetWaitLength(int i10, long j10) {
        return Math.max(reserveEarliestAvailable(i10, j10) - j10, 0L);
    }

    public abstract long reserveEarliestAvailable(int i10, long j10);

    public final void setRate(double d10) {
        Preconditions.checkArgument(d10 > 0.0d && !Double.isNaN(d10), "rate must be positive");
        synchronized (mutex()) {
            doSetRate(d10, this.stopwatch.readMicros());
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(getRate()));
    }

    public boolean tryAcquire(long j10, TimeUnit timeUnit) {
        return tryAcquire(1, j10, timeUnit);
    }

    @VisibleForTesting
    public static RateLimiter create(double d10, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothBursty smoothBursty = new SmoothRateLimiter.SmoothBursty(sleepingStopwatch, 1.0d);
        smoothBursty.setRate(d10);
        return smoothBursty;
    }

    @CanIgnoreReturnValue
    public double acquire(int i10) {
        long reserve = reserve(i10);
        this.stopwatch.sleepMicrosUninterruptibly(reserve);
        double d10 = reserve;
        Double.isNaN(d10);
        double micros = TimeUnit.SECONDS.toMicros(1L);
        Double.isNaN(micros);
        return (d10 * 1.0d) / micros;
    }

    public boolean tryAcquire(int i10) {
        return tryAcquire(i10, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
    }

    public static RateLimiter create(double d10, long j10, TimeUnit timeUnit) {
        Preconditions.checkArgument(j10 >= 0, "warmupPeriod must not be negative: %s", j10);
        return create(d10, j10, timeUnit, 3.0d, SleepingStopwatch.createFromSystemTimer());
    }

    public boolean tryAcquire(int i10, long j10, TimeUnit timeUnit) {
        long max = Math.max(timeUnit.toMicros(j10), 0L);
        checkPermits(i10);
        synchronized (mutex()) {
            long readMicros = this.stopwatch.readMicros();
            if (!canAcquire(readMicros, max)) {
                return false;
            }
            this.stopwatch.sleepMicrosUninterruptibly(reserveAndGetWaitLength(i10, readMicros));
            return true;
        }
    }

    @VisibleForTesting
    public static RateLimiter create(double d10, long j10, TimeUnit timeUnit, double d11, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new SmoothRateLimiter.SmoothWarmingUp(sleepingStopwatch, j10, timeUnit, d11);
        smoothWarmingUp.setRate(d10);
        return smoothWarmingUp;
    }
}
