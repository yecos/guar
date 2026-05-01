package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class StatsAccumulator {
    private long count = 0;
    private double mean = 0.0d;
    private double sumOfSquaresOfDeltas = 0.0d;
    private double min = Double.NaN;
    private double max = Double.NaN;

    public static double calculateNewMeanNonFinite(double d10, double d11) {
        if (Doubles.isFinite(d10)) {
            return d11;
        }
        if (Doubles.isFinite(d11) || d10 == d11) {
            return d10;
        }
        return Double.NaN;
    }

    private void merge(long j10, double d10, double d11, double d12, double d13) {
        long j11 = this.count;
        if (j11 == 0) {
            this.count = j10;
            this.mean = d10;
            this.sumOfSquaresOfDeltas = d11;
            this.min = d12;
            this.max = d13;
            return;
        }
        this.count = j11 + j10;
        if (Doubles.isFinite(this.mean) && Doubles.isFinite(d10)) {
            double d14 = this.mean;
            double d15 = d10 - d14;
            double d16 = j10;
            Double.isNaN(d16);
            double d17 = this.count;
            Double.isNaN(d17);
            double d18 = d14 + ((d15 * d16) / d17);
            this.mean = d18;
            double d19 = this.sumOfSquaresOfDeltas;
            Double.isNaN(d16);
            this.sumOfSquaresOfDeltas = d19 + d11 + (d15 * (d10 - d18) * d16);
        } else {
            this.mean = calculateNewMeanNonFinite(this.mean, d10);
            this.sumOfSquaresOfDeltas = Double.NaN;
        }
        this.min = Math.min(this.min, d12);
        this.max = Math.max(this.max, d13);
    }

    public void add(double d10) {
        long j10 = this.count;
        if (j10 == 0) {
            this.count = 1L;
            this.mean = d10;
            this.min = d10;
            this.max = d10;
            if (Doubles.isFinite(d10)) {
                return;
            }
            this.sumOfSquaresOfDeltas = Double.NaN;
            return;
        }
        this.count = j10 + 1;
        if (Doubles.isFinite(d10) && Doubles.isFinite(this.mean)) {
            double d11 = this.mean;
            double d12 = d10 - d11;
            double d13 = this.count;
            Double.isNaN(d13);
            double d14 = d11 + (d12 / d13);
            this.mean = d14;
            this.sumOfSquaresOfDeltas += d12 * (d10 - d14);
        } else {
            this.mean = calculateNewMeanNonFinite(this.mean, d10);
            this.sumOfSquaresOfDeltas = Double.NaN;
        }
        this.min = Math.min(this.min, d10);
        this.max = Math.max(this.max, d10);
    }

    public void addAll(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    public long count() {
        return this.count;
    }

    public double max() {
        Preconditions.checkState(this.count != 0);
        return this.max;
    }

    public double mean() {
        Preconditions.checkState(this.count != 0);
        return this.mean;
    }

    public double min() {
        Preconditions.checkState(this.count != 0);
        return this.min;
    }

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double populationVariance() {
        Preconditions.checkState(this.count != 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        double ensureNonNegative = DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas);
        double d10 = this.count;
        Double.isNaN(d10);
        return ensureNonNegative / d10;
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public final double sampleVariance() {
        Preconditions.checkState(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        double ensureNonNegative = DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas);
        double d10 = this.count - 1;
        Double.isNaN(d10);
        return ensureNonNegative / d10;
    }

    public Stats snapshot() {
        return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }

    public final double sum() {
        double d10 = this.mean;
        double d11 = this.count;
        Double.isNaN(d11);
        return d10 * d11;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public void addAll(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    public void addAll(double... dArr) {
        for (double d10 : dArr) {
            add(d10);
        }
    }

    public void addAll(int... iArr) {
        for (int i10 : iArr) {
            add(i10);
        }
    }

    public void addAll(long... jArr) {
        for (long j10 : jArr) {
            add(j10);
        }
    }

    public void addAll(Stats stats) {
        if (stats.count() == 0) {
            return;
        }
        merge(stats.count(), stats.mean(), stats.sumOfSquaresOfDeltas(), stats.min(), stats.max());
    }

    public void addAll(StatsAccumulator statsAccumulator) {
        if (statsAccumulator.count() == 0) {
            return;
        }
        merge(statsAccumulator.count(), statsAccumulator.mean(), statsAccumulator.sumOfSquaresOfDeltas(), statsAccumulator.min(), statsAccumulator.max());
    }
}
