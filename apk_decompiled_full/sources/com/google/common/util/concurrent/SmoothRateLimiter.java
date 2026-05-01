package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes2.dex */
abstract class SmoothRateLimiter extends RateLimiter {
    double maxPermits;
    private long nextFreeTicketMicros;
    double stableIntervalMicros;
    double storedPermits;

    public static final class SmoothBursty extends SmoothRateLimiter {
        final double maxBurstSeconds;

        public SmoothBursty(RateLimiter.SleepingStopwatch sleepingStopwatch, double d10) {
            super(sleepingStopwatch);
            this.maxBurstSeconds = d10;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double coolDownIntervalMicros() {
            return this.stableIntervalMicros;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void doSetRate(double d10, double d11) {
            double d12 = this.maxPermits;
            double d13 = this.maxBurstSeconds * d10;
            this.maxPermits = d13;
            if (d12 == Double.POSITIVE_INFINITY) {
                this.storedPermits = d13;
            } else {
                this.storedPermits = d12 != 0.0d ? (this.storedPermits * d13) / d12 : 0.0d;
            }
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long storedPermitsToWaitTime(double d10, double d11) {
            return 0L;
        }
    }

    public static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        public SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j10, TimeUnit timeUnit, double d10) {
            super(sleepingStopwatch);
            this.warmupPeriodMicros = timeUnit.toMicros(j10);
            this.coldFactor = d10;
        }

        private double permitsToTime(double d10) {
            return this.stableIntervalMicros + (d10 * this.slope);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double coolDownIntervalMicros() {
            double d10 = this.warmupPeriodMicros;
            double d11 = this.maxPermits;
            Double.isNaN(d10);
            return d10 / d11;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void doSetRate(double d10, double d11) {
            double d12 = this.maxPermits;
            double d13 = this.coldFactor * d11;
            long j10 = this.warmupPeriodMicros;
            double d14 = j10;
            Double.isNaN(d14);
            double d15 = (d14 * 0.5d) / d11;
            this.thresholdPermits = d15;
            double d16 = j10;
            Double.isNaN(d16);
            double d17 = ((d16 * 2.0d) / (d11 + d13)) + d15;
            this.maxPermits = d17;
            this.slope = (d13 - d11) / (d17 - d15);
            if (d12 == Double.POSITIVE_INFINITY) {
                this.storedPermits = 0.0d;
                return;
            }
            if (d12 != 0.0d) {
                d17 = (this.storedPermits * d17) / d12;
            }
            this.storedPermits = d17;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long storedPermitsToWaitTime(double d10, double d11) {
            long j10;
            double d12 = d10 - this.thresholdPermits;
            if (d12 > 0.0d) {
                double min = Math.min(d12, d11);
                j10 = (long) (((permitsToTime(d12) + permitsToTime(d12 - min)) * min) / 2.0d);
                d11 -= min;
            } else {
                j10 = 0;
            }
            return j10 + ((long) (this.stableIntervalMicros * d11));
        }
    }

    public abstract double coolDownIntervalMicros();

    @Override // com.google.common.util.concurrent.RateLimiter
    public final double doGetRate() {
        double micros = TimeUnit.SECONDS.toMicros(1L);
        double d10 = this.stableIntervalMicros;
        Double.isNaN(micros);
        return micros / d10;
    }

    public abstract void doSetRate(double d10, double d11);

    @Override // com.google.common.util.concurrent.RateLimiter
    public final void doSetRate(double d10, long j10) {
        resync(j10);
        double micros = TimeUnit.SECONDS.toMicros(1L);
        Double.isNaN(micros);
        double d11 = micros / d10;
        this.stableIntervalMicros = d11;
        doSetRate(d10, d11);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long queryEarliestAvailable(long j10) {
        return this.nextFreeTicketMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long reserveEarliestAvailable(int i10, long j10) {
        resync(j10);
        long j11 = this.nextFreeTicketMicros;
        double d10 = i10;
        double min = Math.min(d10, this.storedPermits);
        Double.isNaN(d10);
        this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, storedPermitsToWaitTime(this.storedPermits, min) + ((long) ((d10 - min) * this.stableIntervalMicros)));
        this.storedPermits -= min;
        return j11;
    }

    public void resync(long j10) {
        long j11 = this.nextFreeTicketMicros;
        if (j10 > j11) {
            double d10 = j10 - j11;
            double coolDownIntervalMicros = coolDownIntervalMicros();
            Double.isNaN(d10);
            this.storedPermits = Math.min(this.maxPermits, this.storedPermits + (d10 / coolDownIntervalMicros));
            this.nextFreeTicketMicros = j10;
        }
    }

    public abstract long storedPermitsToWaitTime(double d10, double d11);

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.nextFreeTicketMicros = 0L;
    }
}
