package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class LinearTransformation {

    public static final class LinearTransformationBuilder {

        /* renamed from: x1, reason: collision with root package name */
        private final double f6910x1;

        /* renamed from: y1, reason: collision with root package name */
        private final double f6911y1;

        public LinearTransformation and(double d10, double d11) {
            Preconditions.checkArgument(DoubleUtils.isFinite(d10) && DoubleUtils.isFinite(d11));
            double d12 = this.f6910x1;
            if (d10 != d12) {
                return withSlope((d11 - this.f6911y1) / (d10 - d12));
            }
            Preconditions.checkArgument(d11 != this.f6911y1);
            return new VerticalLinearTransformation(this.f6910x1);
        }

        public LinearTransformation withSlope(double d10) {
            Preconditions.checkArgument(!Double.isNaN(d10));
            return DoubleUtils.isFinite(d10) ? new RegularLinearTransformation(d10, this.f6911y1 - (this.f6910x1 * d10)) : new VerticalLinearTransformation(this.f6910x1);
        }

        private LinearTransformationBuilder(double d10, double d11) {
            this.f6910x1 = d10;
            this.f6911y1 = d11;
        }
    }

    public static final class NaNLinearTransformation extends LinearTransformation {
        static final NaNLinearTransformation INSTANCE = new NaNLinearTransformation();

        private NaNLinearTransformation() {
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            return this;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d10) {
            return Double.NaN;
        }
    }

    public static LinearTransformation forNaN() {
        return NaNLinearTransformation.INSTANCE;
    }

    public static LinearTransformation horizontal(double d10) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d10));
        return new RegularLinearTransformation(0.0d, d10);
    }

    public static LinearTransformationBuilder mapping(double d10, double d11) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d10) && DoubleUtils.isFinite(d11));
        return new LinearTransformationBuilder(d10, d11);
    }

    public static LinearTransformation vertical(double d10) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d10));
        return new VerticalLinearTransformation(d10);
    }

    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d10);

    public static final class VerticalLinearTransformation extends LinearTransformation {

        @CheckForNull
        @LazyInit
        LinearTransformation inverse;

        /* renamed from: x, reason: collision with root package name */
        final double f6912x;

        public VerticalLinearTransformation(double d10) {
            this.f6912x = d10;
            this.inverse = null;
        }

        private LinearTransformation createInverse() {
            return new RegularLinearTransformation(0.0d, this.f6912x, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return true;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f6912x));
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d10) {
            throw new IllegalStateException();
        }

        public VerticalLinearTransformation(double d10, LinearTransformation linearTransformation) {
            this.f6912x = d10;
            this.inverse = linearTransformation;
        }
    }

    public static final class RegularLinearTransformation extends LinearTransformation {

        @CheckForNull
        @LazyInit
        LinearTransformation inverse;
        final double slope;
        final double yIntercept;

        public RegularLinearTransformation(double d10, double d11) {
            this.slope = d10;
            this.yIntercept = d11;
            this.inverse = null;
        }

        private LinearTransformation createInverse() {
            double d10 = this.slope;
            return d10 != 0.0d ? new RegularLinearTransformation(1.0d / d10, (this.yIntercept * (-1.0d)) / d10, this) : new VerticalLinearTransformation(this.yIntercept, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return this.slope == 0.0d;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return this.slope;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.slope), Double.valueOf(this.yIntercept));
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d10) {
            return (d10 * this.slope) + this.yIntercept;
        }

        public RegularLinearTransformation(double d10, double d11, LinearTransformation linearTransformation) {
            this.slope = d10;
            this.yIntercept = d11;
            this.inverse = linearTransformation;
        }
    }
}
