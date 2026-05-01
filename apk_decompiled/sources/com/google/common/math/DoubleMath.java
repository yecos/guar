package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class DoubleMath {

    @VisibleForTesting
    static final int MAX_FACTORIAL = 170;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9d;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18d;
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9d;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18d;
    private static final double LN_2 = Math.log(2.0d);

    @VisibleForTesting
    static final double[] everySixteenthFactorial = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* renamed from: com.google.common.math.DoubleMath$1, reason: invalid class name */
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
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private DoubleMath() {
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    private static double checkFinite(double d10) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d10));
        return d10;
    }

    public static double factorial(int i10) {
        MathPreconditions.checkNonNegative("n", i10);
        if (i10 > MAX_FACTORIAL) {
            return Double.POSITIVE_INFINITY;
        }
        double d10 = 1.0d;
        for (int i11 = (i10 & (-16)) + 1; i11 <= i10; i11++) {
            double d11 = i11;
            Double.isNaN(d11);
            d10 *= d11;
        }
        return d10 * everySixteenthFactorial[i10 >> 4];
    }

    public static int fuzzyCompare(double d10, double d11, double d12) {
        if (fuzzyEquals(d10, d11, d12)) {
            return 0;
        }
        if (d10 < d11) {
            return -1;
        }
        if (d10 > d11) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(d10), Double.isNaN(d11));
    }

    public static boolean fuzzyEquals(double d10, double d11, double d12) {
        MathPreconditions.checkNonNegative("tolerance", d12);
        return Math.copySign(d10 - d11, 1.0d) <= d12 || d10 == d11 || (Double.isNaN(d10) && Double.isNaN(d11));
    }

    @GwtIncompatible
    public static boolean isMathematicalInteger(double d10) {
        return DoubleUtils.isFinite(d10) && (d10 == LN_2 || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(d10)) <= Math.getExponent(d10));
    }

    @GwtIncompatible
    public static boolean isPowerOfTwo(double d10) {
        if (d10 <= LN_2 || !DoubleUtils.isFinite(d10)) {
            return false;
        }
        long significand = DoubleUtils.getSignificand(d10);
        return (significand & (significand - 1)) == 0;
    }

    public static double log2(double d10) {
        return Math.log(d10) / LN_2;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0, "Cannot take mean of 0 values");
        double checkFinite = checkFinite(dArr[0]);
        long j10 = 1;
        for (int i10 = 1; i10 < dArr.length; i10++) {
            checkFinite(dArr[i10]);
            j10++;
            double d10 = dArr[i10] - checkFinite;
            double d11 = j10;
            Double.isNaN(d11);
            checkFinite += d10 / d11;
        }
        return checkFinite;
    }

    @GwtIncompatible
    public static double roundIntermediate(double d10, RoundingMode roundingMode) {
        if (!DoubleUtils.isFinite(d10)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(d10));
                return d10;
            case 2:
                return (d10 >= LN_2 || isMathematicalInteger(d10)) ? d10 : ((long) d10) - 1;
            case 3:
                return (d10 <= LN_2 || isMathematicalInteger(d10)) ? d10 : ((long) d10) + 1;
            case 4:
                return d10;
            case 5:
                if (isMathematicalInteger(d10)) {
                    return d10;
                }
                return ((long) d10) + (d10 > LN_2 ? 1 : -1);
            case 6:
                return Math.rint(d10);
            case 7:
                double rint = Math.rint(d10);
                return Math.abs(d10 - rint) == 0.5d ? d10 + Math.copySign(0.5d, d10) : rint;
            case 8:
                double rint2 = Math.rint(d10);
                return Math.abs(d10 - rint2) == 0.5d ? d10 : rint2;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static BigInteger roundToBigInteger(double d10, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d10, roundingMode);
        if ((roundIntermediate < MAX_LONG_AS_DOUBLE_PLUS_ONE) && (MIN_LONG_AS_DOUBLE - roundIntermediate < 1.0d)) {
            return BigInteger.valueOf((long) roundIntermediate);
        }
        BigInteger shiftLeft = BigInteger.valueOf(DoubleUtils.getSignificand(roundIntermediate)).shiftLeft(Math.getExponent(roundIntermediate) - 52);
        return roundIntermediate < LN_2 ? shiftLeft.negate() : shiftLeft;
    }

    @GwtIncompatible
    public static int roundToInt(double d10, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d10, roundingMode);
        MathPreconditions.checkInRangeForRoundingInputs((roundIntermediate > -2.147483649E9d) & (roundIntermediate < 2.147483648E9d), d10, roundingMode);
        return (int) roundIntermediate;
    }

    @GwtIncompatible
    public static long roundToLong(double d10, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d10, roundingMode);
        MathPreconditions.checkInRangeForRoundingInputs((MIN_LONG_AS_DOUBLE - roundIntermediate < 1.0d) & (roundIntermediate < MAX_LONG_AS_DOUBLE_PLUS_ONE), d10, roundingMode);
        return (long) roundIntermediate;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @com.google.common.annotations.GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int log2(double r6, java.math.RoundingMode r8) {
        /*
            r0 = 0
            r2 = 0
            r3 = 1
            int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r4 <= 0) goto L10
            boolean r0 = com.google.common.math.DoubleUtils.isFinite(r6)
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            java.lang.String r1 = "x must be positive and finite"
            com.google.common.base.Preconditions.checkArgument(r0, r1)
            int r0 = java.lang.Math.getExponent(r6)
            boolean r1 = com.google.common.math.DoubleUtils.isNormal(r6)
            if (r1 != 0) goto L2b
            r0 = 4841369599423283200(0x4330000000000000, double:4.503599627370496E15)
            double r6 = r6 * r0
            int r6 = log2(r6, r8)
            int r6 = r6 + (-52)
            return r6
        L2b:
            int[] r1 = com.google.common.math.DoubleMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r8 = r8.ordinal()
            r8 = r1[r8]
            switch(r8) {
                case 1: goto L63;
                case 2: goto L6a;
                case 3: goto L5c;
                case 4: goto L52;
                case 5: goto L4a;
                case 6: goto L3c;
                case 7: goto L3c;
                case 8: goto L3c;
                default: goto L36;
            }
        L36:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            r6.<init>()
            throw r6
        L3c:
            double r6 = com.google.common.math.DoubleUtils.scaleNormalize(r6)
            double r6 = r6 * r6
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 <= 0) goto L6a
            r2 = 1
            goto L6a
        L4a:
            if (r0 < 0) goto L4d
            r2 = 1
        L4d:
            boolean r6 = isPowerOfTwo(r6)
            goto L59
        L52:
            if (r0 >= 0) goto L55
            r2 = 1
        L55:
            boolean r6 = isPowerOfTwo(r6)
        L59:
            r6 = r6 ^ r3
            r2 = r2 & r6
            goto L6a
        L5c:
            boolean r6 = isPowerOfTwo(r6)
            r2 = r6 ^ 1
            goto L6a
        L63:
            boolean r6 = isPowerOfTwo(r6)
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r6)
        L6a:
            if (r2 == 0) goto L6e
            int r0 = r0 + 1
        L6e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleMath.log2(double, java.math.RoundingMode):int");
    }

    @Deprecated
    public static double mean(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0, "Cannot take mean of 0 values");
        long j10 = 0;
        for (int i10 : iArr) {
            j10 += i10;
        }
        double d10 = j10;
        double length = iArr.length;
        Double.isNaN(d10);
        Double.isNaN(length);
        return d10 / length;
    }

    @Deprecated
    public static double mean(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0, "Cannot take mean of 0 values");
        double d10 = jArr[0];
        long j10 = 1;
        for (int i10 = 1; i10 < jArr.length; i10++) {
            j10++;
            double d11 = jArr[i10];
            Double.isNaN(d11);
            double d12 = j10;
            Double.isNaN(d12);
            d10 += (d11 - d10) / d12;
        }
        return d10;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterable<? extends Number> iterable) {
        return mean(iterable.iterator());
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterator<? extends Number> it) {
        Preconditions.checkArgument(it.hasNext(), "Cannot take mean of 0 values");
        double checkFinite = checkFinite(it.next().doubleValue());
        long j10 = 1;
        while (it.hasNext()) {
            j10++;
            double checkFinite2 = checkFinite(it.next().doubleValue()) - checkFinite;
            double d10 = j10;
            Double.isNaN(d10);
            checkFinite += checkFinite2 / d10;
        }
        return checkFinite;
    }
}
