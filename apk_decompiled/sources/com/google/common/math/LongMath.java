package com.google.common.math;

import c8.b;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import com.taobao.accs.antibrush.AntiBrush;
import java.math.RoundingMode;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class LongMath {

    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;

    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;

    @VisibleForTesting
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;

    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {19, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    @VisibleForTesting
    @GwtIncompatible
    static final long[] powersOf10 = {1, 10, 100, 1000, NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    @VisibleForTesting
    @GwtIncompatible
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    @VisibleForTesting
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, AntiBrush.STATUS_BRUSH, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* renamed from: com.google.common.math.LongMath$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public enum MillerRabinTester {
        SMALL { // from class: com.google.common.math.LongMath.MillerRabinTester.1
            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j10, long j11, long j12) {
                return (j10 * j11) % j12;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j10, long j11) {
                return (j10 * j10) % j11;
            }
        },
        LARGE { // from class: com.google.common.math.LongMath.MillerRabinTester.2
            private long plusMod(long j10, long j11, long j12) {
                long j13 = j10 + j11;
                return j10 >= j12 - j11 ? j13 - j12 : j13;
            }

            private long times2ToThe32Mod(long j10, long j11) {
                int i10 = 32;
                do {
                    int min = Math.min(i10, Long.numberOfLeadingZeros(j10));
                    j10 = UnsignedLongs.remainder(j10 << min, j11);
                    i10 -= min;
                } while (i10 > 0);
                return j10;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j10, long j11, long j12) {
                long j13 = j10 >>> 32;
                long j14 = j11 >>> 32;
                long j15 = j10 & 4294967295L;
                long j16 = j11 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j13 * j14, j12) + (j13 * j16);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.remainder(times2ToThe32Mod, j12);
                }
                Long.signum(j15);
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j14 * j15), j12), UnsignedLongs.remainder(j15 * j16, j12), j12);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j10, long j11) {
                long j12 = j10 >>> 32;
                long j13 = j10 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j12 * j12, j11);
                long j14 = j12 * j13 * 2;
                if (j14 < 0) {
                    j14 = UnsignedLongs.remainder(j14, j11);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j14, j11), UnsignedLongs.remainder(j13 * j13, j11), j11);
            }
        };

        private long powMod(long j10, long j11, long j12) {
            long j13 = 1;
            while (j11 != 0) {
                if ((j11 & 1) != 0) {
                    j13 = mulMod(j13, j10, j12);
                }
                j10 = squareMod(j10, j12);
                j11 >>= 1;
            }
            return j13;
        }

        public static boolean test(long j10, long j11) {
            return (j11 <= LongMath.FLOOR_SQRT_MAX_LONG ? SMALL : LARGE).testWitness(j10, j11);
        }

        private boolean testWitness(long j10, long j11) {
            long j12 = j11 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j12);
            long j13 = j12 >> numberOfTrailingZeros;
            long j14 = j10 % j11;
            if (j14 == 0) {
                return true;
            }
            long powMod = powMod(j14, j13, j11);
            if (powMod == 1) {
                return true;
            }
            int i10 = 0;
            while (powMod != j12) {
                i10++;
                if (i10 == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j11);
            }
            return true;
        }

        public abstract long mulMod(long j10, long j11, long j12);

        public abstract long squareMod(long j10, long j11);

        /* synthetic */ MillerRabinTester(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private LongMath() {
    }

    public static long binomial(int i10, int i11) {
        MathPreconditions.checkNonNegative("n", i10);
        MathPreconditions.checkNonNegative("k", i11);
        Preconditions.checkArgument(i11 <= i10, "k (%s) > n (%s)", i11, i10);
        if (i11 > (i10 >> 1)) {
            i11 = i10 - i11;
        }
        long j10 = 1;
        if (i11 == 0) {
            return 1L;
        }
        if (i11 == 1) {
            return i10;
        }
        long[] jArr = factorials;
        if (i10 < jArr.length) {
            return jArr[i10] / (jArr[i11] * jArr[i10 - i11]);
        }
        int[] iArr = biggestBinomials;
        if (i11 >= iArr.length || i10 > iArr[i11]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = biggestSimpleBinomials;
        if (i11 < iArr2.length && i10 <= iArr2[i11]) {
            int i12 = i10 - 1;
            long j11 = i10;
            for (int i13 = 2; i13 <= i11; i13++) {
                j11 = (j11 * i12) / i13;
                i12--;
            }
            return j11;
        }
        long j12 = i10;
        int log2 = log2(j12, RoundingMode.CEILING);
        int i14 = i10 - 1;
        int i15 = log2;
        long j13 = j12;
        int i16 = 2;
        long j14 = 1;
        while (i16 <= i11) {
            i15 += log2;
            if (i15 < 63) {
                j13 *= i14;
                j14 *= i16;
            } else {
                j10 = multiplyFraction(j10, j13, j14);
                j13 = i14;
                j14 = i16;
                i15 = log2;
            }
            i16++;
            i14--;
        }
        return multiplyFraction(j10, j13, j14);
    }

    @Beta
    public static long ceilingPowerOfTwo(long j10) {
        MathPreconditions.checkPositive("x", j10);
        if (j10 <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j10 - 1));
        }
        StringBuilder sb = new StringBuilder(70);
        sb.append("ceilingPowerOfTwo(");
        sb.append(j10);
        sb.append(") is not representable as a long");
        throw new ArithmeticException(sb.toString());
    }

    @GwtIncompatible
    public static long checkedAdd(long j10, long j11) {
        long j12 = j10 + j11;
        MathPreconditions.checkNoOverflow(((j10 ^ j11) < 0) | ((j10 ^ j12) >= 0), "checkedAdd", j10, j11);
        return j12;
    }

    public static long checkedMultiply(long j10, long j11) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j10) + Long.numberOfLeadingZeros(j10 ^ (-1)) + Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros((-1) ^ j11);
        if (numberOfLeadingZeros > 65) {
            return j10 * j11;
        }
        MathPreconditions.checkNoOverflow(numberOfLeadingZeros >= 64, "checkedMultiply", j10, j11);
        MathPreconditions.checkNoOverflow((j10 >= 0) | (j11 != Long.MIN_VALUE), "checkedMultiply", j10, j11);
        long j12 = j10 * j11;
        MathPreconditions.checkNoOverflow(j10 == 0 || j12 / j10 == j11, "checkedMultiply", j10, j11);
        return j12;
    }

    @GwtIncompatible
    public static long checkedPow(long j10, int i10) {
        MathPreconditions.checkNonNegative("exponent", i10);
        long j11 = 1;
        if (!(j10 >= -2) || !(j10 <= 2)) {
            long j12 = j10;
            int i11 = i10;
            while (i11 != 0) {
                if (i11 == 1) {
                    return checkedMultiply(j11, j12);
                }
                long checkedMultiply = (i11 & 1) != 0 ? checkedMultiply(j11, j12) : j11;
                int i12 = i11 >> 1;
                if (i12 > 0) {
                    MathPreconditions.checkNoOverflow(-3037000499L <= j12 && j12 <= FLOOR_SQRT_MAX_LONG, "checkedPow", j12, i12);
                    j12 *= j12;
                }
                j11 = checkedMultiply;
                i11 = i12;
            }
            return j11;
        }
        int i13 = (int) j10;
        if (i13 == -2) {
            MathPreconditions.checkNoOverflow(i10 < 64, "checkedPow", j10, i10);
            return (i10 & 1) == 0 ? 1 << i10 : (-1) << i10;
        }
        if (i13 == -1) {
            return (i10 & 1) == 0 ? 1L : -1L;
        }
        if (i13 == 0) {
            return i10 == 0 ? 1L : 0L;
        }
        if (i13 == 1) {
            return 1L;
        }
        if (i13 != 2) {
            throw new AssertionError();
        }
        MathPreconditions.checkNoOverflow(i10 < 63, "checkedPow", j10, i10);
        return 1 << i10;
    }

    @GwtIncompatible
    public static long checkedSubtract(long j10, long j11) {
        long j12 = j10 - j11;
        MathPreconditions.checkNoOverflow(((j10 ^ j11) >= 0) | ((j10 ^ j12) >= 0), "checkedSubtract", j10, j11);
        return j12;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        if (r9 > 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r9 < 0) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @com.google.common.annotations.GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long divide(long r8, long r10, java.math.RoundingMode r12) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r12)
            long r0 = r8 / r10
            long r2 = r10 * r0
            long r2 = r8 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L10
            return r0
        L10:
            long r8 = r8 ^ r10
            r6 = 63
            long r8 = r8 >> r6
            int r9 = (int) r8
            r8 = 1
            r9 = r9 | r8
            int[] r6 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r7 = r12.ordinal()
            r6 = r6[r7]
            r7 = 0
            switch(r6) {
                case 1: goto L52;
                case 2: goto L5b;
                case 3: goto L4f;
                case 4: goto L5c;
                case 5: goto L4c;
                case 6: goto L29;
                case 7: goto L29;
                case 8: goto L29;
                default: goto L23;
            }
        L23:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L29:
            long r2 = java.lang.Math.abs(r2)
            long r10 = java.lang.Math.abs(r10)
            long r10 = r10 - r2
            long r2 = r2 - r10
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 != 0) goto L47
            java.math.RoundingMode r10 = java.math.RoundingMode.HALF_UP
            if (r12 == r10) goto L5c
            java.math.RoundingMode r10 = java.math.RoundingMode.HALF_EVEN
            if (r12 != r10) goto L5b
            r10 = 1
            long r10 = r10 & r0
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L5b
            goto L5c
        L47:
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 <= 0) goto L5b
            goto L5c
        L4c:
            if (r9 <= 0) goto L5b
            goto L5c
        L4f:
            if (r9 >= 0) goto L5b
            goto L5c
        L52:
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 != 0) goto L57
            goto L58
        L57:
            r8 = 0
        L58:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r8)
        L5b:
            r8 = 0
        L5c:
            if (r8 == 0) goto L60
            long r8 = (long) r9
            long r0 = r0 + r8
        L60:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.divide(long, long, java.math.RoundingMode):long");
    }

    @GwtIncompatible
    public static long factorial(int i10) {
        MathPreconditions.checkNonNegative("n", i10);
        long[] jArr = factorials;
        if (i10 < jArr.length) {
            return jArr[i10];
        }
        return Long.MAX_VALUE;
    }

    public static boolean fitsInInt(long j10) {
        return ((long) ((int) j10)) == j10;
    }

    @Beta
    public static long floorPowerOfTwo(long j10) {
        MathPreconditions.checkPositive("x", j10);
        return 1 << (63 - Long.numberOfLeadingZeros(j10));
    }

    public static long gcd(long j10, long j11) {
        MathPreconditions.checkNonNegative("a", j10);
        MathPreconditions.checkNonNegative(b.f5629b, j11);
        if (j10 == 0) {
            return j11;
        }
        if (j11 == 0) {
            return j10;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j10);
        long j12 = j10 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j11);
        long j13 = j11 >> numberOfTrailingZeros2;
        while (j12 != j13) {
            long j14 = j12 - j13;
            long j15 = (j14 >> 63) & j14;
            long j16 = (j14 - j15) - j15;
            j13 += j15;
            j12 = j16 >> Long.numberOfTrailingZeros(j16);
        }
        return j12 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j10) {
        return (j10 > 0) & ((j10 & (j10 - 1)) == 0);
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(long j10) {
        if (j10 < 2) {
            MathPreconditions.checkNonNegative("n", j10);
            return false;
        }
        if (j10 < 66) {
            return ((722865708377213483 >> (((int) j10) + (-2))) & 1) != 0;
        }
        if (((1 << ((int) (j10 % 30))) & SIEVE_30) != 0 || j10 % 7 == 0 || j10 % 11 == 0 || j10 % 13 == 0) {
            return false;
        }
        if (j10 < 289) {
            return true;
        }
        for (long[] jArr : millerRabinBaseSets) {
            if (j10 <= jArr[0]) {
                for (int i10 = 1; i10 < jArr.length; i10++) {
                    if (!MillerRabinTester.test(jArr[i10], j10)) {
                        return false;
                    }
                }
                return true;
            }
        }
        throw new AssertionError();
    }

    @VisibleForTesting
    public static int lessThanBranchFree(long j10, long j11) {
        return (int) ((((j10 - j11) ^ (-1)) ^ (-1)) >>> 63);
    }

    @GwtIncompatible
    public static int log10(long j10, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkPositive("x", j10);
        int log10Floor = log10Floor(j10);
        long j11 = powersOf10[log10Floor];
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j10 == j11);
            case 2:
            case 3:
                return log10Floor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(j11, j10);
                return log10Floor + lessThanBranchFree;
            case 6:
            case 7:
            case 8:
                lessThanBranchFree = lessThanBranchFree(halfPowersOf10[log10Floor], j10);
                return log10Floor + lessThanBranchFree;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static int log10Floor(long j10) {
        byte b10 = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j10)];
        return b10 - lessThanBranchFree(j10, powersOf10[b10]);
    }

    public static int log2(long j10, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", j10);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(j10));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j10 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j10);
                return (63 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, j10);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j10);
    }

    public static long mean(long j10, long j11) {
        return (j10 & j11) + ((j10 ^ j11) >> 1);
    }

    @GwtIncompatible
    public static int mod(long j10, int i10) {
        return (int) mod(j10, i10);
    }

    public static long multiplyFraction(long j10, long j11, long j12) {
        if (j10 == 1) {
            return j11 / j12;
        }
        long gcd = gcd(j10, j12);
        return (j10 / gcd) * (j11 / (j12 / gcd));
    }

    @GwtIncompatible
    public static long pow(long j10, int i10) {
        MathPreconditions.checkNonNegative("exponent", i10);
        if (-2 > j10 || j10 > 2) {
            long j11 = 1;
            while (i10 != 0) {
                if (i10 == 1) {
                    return j11 * j10;
                }
                j11 *= (i10 & 1) == 0 ? 1L : j10;
                j10 *= j10;
                i10 >>= 1;
            }
            return j11;
        }
        int i11 = (int) j10;
        if (i11 == -2) {
            if (i10 < 64) {
                return (i10 & 1) == 0 ? 1 << i10 : -(1 << i10);
            }
            return 0L;
        }
        if (i11 == -1) {
            return (i10 & 1) == 0 ? 1L : -1L;
        }
        if (i11 == 0) {
            return i10 == 0 ? 1L : 0L;
        }
        if (i11 == 1) {
            return 1L;
        }
        if (i11 != 2) {
            throw new AssertionError();
        }
        if (i10 < 64) {
            return 1 << i10;
        }
        return 0L;
    }

    @GwtIncompatible
    public static double roundToDouble(long j10, RoundingMode roundingMode) {
        double d10;
        long j11;
        double d11 = j10;
        long j12 = (long) d11;
        int compare = j12 == Long.MAX_VALUE ? -1 : Longs.compare(j10, j12);
        int[] iArr = AnonymousClass1.$SwitchMap$java$math$RoundingMode;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(compare == 0);
                return d11;
            case 2:
                return j10 >= 0 ? compare >= 0 ? d11 : DoubleUtils.nextDown(d11) : compare <= 0 ? d11 : Math.nextUp(d11);
            case 3:
                return compare >= 0 ? d11 : DoubleUtils.nextDown(d11);
            case 4:
                return j10 >= 0 ? compare <= 0 ? d11 : Math.nextUp(d11) : compare >= 0 ? d11 : DoubleUtils.nextDown(d11);
            case 5:
                return compare <= 0 ? d11 : Math.nextUp(d11);
            case 6:
            case 7:
            case 8:
                if (compare >= 0) {
                    d10 = Math.nextUp(d11);
                    j11 = (long) Math.ceil(d10);
                } else {
                    double nextDown = DoubleUtils.nextDown(d11);
                    j12 = (long) Math.floor(nextDown);
                    d10 = d11;
                    d11 = nextDown;
                    j11 = j12;
                }
                long j13 = j10 - j12;
                long j14 = j11 - j10;
                if (j11 == Long.MAX_VALUE) {
                    j14++;
                }
                int compare2 = Longs.compare(j13, j14);
                if (compare2 < 0) {
                    return d11;
                }
                if (compare2 > 0) {
                    return d10;
                }
                int i10 = iArr[roundingMode.ordinal()];
                if (i10 == 6) {
                    return j10 >= 0 ? d11 : d10;
                }
                if (i10 == 7) {
                    return j10 >= 0 ? d10 : d11;
                }
                if (i10 == 8) {
                    return (DoubleUtils.getSignificand(d11) & 1) == 0 ? d11 : d10;
                }
                throw new AssertionError("impossible");
            default:
                throw new AssertionError("impossible");
        }
    }

    @Beta
    public static long saturatedAdd(long j10, long j11) {
        long j12 = j10 + j11;
        return (((j11 ^ j10) > 0L ? 1 : ((j11 ^ j10) == 0L ? 0 : -1)) < 0) | ((j10 ^ j12) >= 0) ? j12 : ((j12 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @Beta
    public static long saturatedMultiply(long j10, long j11) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j10) + Long.numberOfLeadingZeros(j10 ^ (-1)) + Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros((-1) ^ j11);
        if (numberOfLeadingZeros > 65) {
            return j10 * j11;
        }
        long j12 = ((j10 ^ j11) >>> 63) + Long.MAX_VALUE;
        if ((numberOfLeadingZeros < 64) || ((j10 < 0) & (j11 == Long.MIN_VALUE))) {
            return j12;
        }
        long j13 = j10 * j11;
        return (j10 == 0 || j13 / j10 == j11) ? j13 : j12;
    }

    @Beta
    public static long saturatedPow(long j10, int i10) {
        MathPreconditions.checkNonNegative("exponent", i10);
        long j11 = 1;
        if (!(j10 >= -2) || !(j10 <= 2)) {
            long j12 = ((j10 >>> 63) & i10 & 1) + Long.MAX_VALUE;
            while (i10 != 0) {
                if (i10 == 1) {
                    return saturatedMultiply(j11, j10);
                }
                if ((i10 & 1) != 0) {
                    j11 = saturatedMultiply(j11, j10);
                }
                i10 >>= 1;
                if (i10 > 0) {
                    if ((-3037000499L > j10) || (j10 > FLOOR_SQRT_MAX_LONG)) {
                        return j12;
                    }
                    j10 *= j10;
                }
            }
            return j11;
        }
        int i11 = (int) j10;
        if (i11 == -2) {
            return i10 >= 64 ? (i10 & 1) + Long.MAX_VALUE : (i10 & 1) == 0 ? 1 << i10 : (-1) << i10;
        }
        if (i11 == -1) {
            return (i10 & 1) == 0 ? 1L : -1L;
        }
        if (i11 == 0) {
            return i10 == 0 ? 1L : 0L;
        }
        if (i11 == 1) {
            return 1L;
        }
        if (i11 != 2) {
            throw new AssertionError();
        }
        if (i10 >= 63) {
            return Long.MAX_VALUE;
        }
        return 1 << i10;
    }

    @Beta
    public static long saturatedSubtract(long j10, long j11) {
        long j12 = j10 - j11;
        return (((j11 ^ j10) > 0L ? 1 : ((j11 ^ j10) == 0L ? 0 : -1)) >= 0) | ((j10 ^ j12) >= 0) ? j12 : ((j12 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @GwtIncompatible
    public static long sqrt(long j10, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", j10);
        if (fitsInInt(j10)) {
            return IntMath.sqrt((int) j10, roundingMode);
        }
        long sqrt = (long) Math.sqrt(j10);
        long j11 = sqrt * sqrt;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j11 == j10);
                return sqrt;
            case 2:
            case 3:
                return j10 < j11 ? sqrt - 1 : sqrt;
            case 4:
            case 5:
                return j10 > j11 ? sqrt + 1 : sqrt;
            case 6:
            case 7:
            case 8:
                return (sqrt - (j10 >= j11 ? 0 : 1)) + lessThanBranchFree((r0 * r0) + r0, j10);
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static long mod(long j10, long j11) {
        if (j11 <= 0) {
            throw new ArithmeticException("Modulus must be positive");
        }
        long j12 = j10 % j11;
        return j12 >= 0 ? j12 : j12 + j11;
    }
}
