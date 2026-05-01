package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ComparisonChain {
    private static final ComparisonChain ACTIVE = new ComparisonChain() { // from class: com.google.common.collect.ComparisonChain.1
        public ComparisonChain classify(int i10) {
            return i10 < 0 ? ComparisonChain.LESS : i10 > 0 ? ComparisonChain.GREATER : ComparisonChain.ACTIVE;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return classify(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean z10, boolean z11) {
            return classify(Booleans.compare(z10, z11));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean z10, boolean z11) {
            return classify(Booleans.compare(z11, z10));
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return 0;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@ParametricNullness T t10, @ParametricNullness T t11, Comparator<T> comparator) {
            return classify(comparator.compare(t10, t11));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int i10, int i11) {
            return classify(Ints.compare(i10, i11));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long j10, long j11) {
            return classify(Longs.compare(j10, j11));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float f10, float f11) {
            return classify(Float.compare(f10, f11));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double d10, double d11) {
            return classify(Double.compare(d10, d11));
        }
    };
    private static final ComparisonChain LESS = new InactiveComparisonChain(-1);
    private static final ComparisonChain GREATER = new InactiveComparisonChain(1);

    public static final class InactiveComparisonChain extends ComparisonChain {
        final int result;

        public InactiveComparisonChain(int i10) {
            super();
            this.result = i10;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double d10, double d11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean z10, boolean z11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean z10, boolean z11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return this.result;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float f10, float f11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int i10, int i11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long j10, long j11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@ParametricNullness T t10, @ParametricNullness T t11, Comparator<T> comparator) {
            return this;
        }
    }

    private ComparisonChain() {
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }

    public abstract ComparisonChain compare(double d10, double d11);

    public abstract ComparisonChain compare(float f10, float f11);

    public abstract ComparisonChain compare(int i10, int i11);

    public abstract ComparisonChain compare(long j10, long j11);

    @Deprecated
    public final ComparisonChain compare(Boolean bool, Boolean bool2) {
        return compareFalseFirst(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> ComparisonChain compare(@ParametricNullness T t10, @ParametricNullness T t11, Comparator<T> comparator);

    public abstract ComparisonChain compareFalseFirst(boolean z10, boolean z11);

    public abstract ComparisonChain compareTrueFirst(boolean z10, boolean z11);

    public abstract int result();
}
