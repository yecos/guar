package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigInteger;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes2.dex */
final class DoubleUtils {
    static final int EXPONENT_BIAS = 1023;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final long IMPLICIT_BIT = 4503599627370496L;

    @VisibleForTesting
    static final long ONE_BITS = 4607182418800017408L;
    static final int SIGNIFICAND_BITS = 52;
    static final long SIGNIFICAND_MASK = 4503599627370495L;
    static final long SIGN_MASK = Long.MIN_VALUE;

    private DoubleUtils() {
    }

    public static double bigToDouble(BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        boolean z10 = true;
        int bitLength = abs.bitLength() - 1;
        if (bitLength < 63) {
            return bigInteger.longValue();
        }
        if (bitLength > 1023) {
            double signum = bigInteger.signum();
            Double.isNaN(signum);
            return signum * Double.POSITIVE_INFINITY;
        }
        int i10 = (bitLength - 52) - 1;
        long longValue = abs.shiftRight(i10).longValue();
        long j10 = (longValue >> 1) & SIGNIFICAND_MASK;
        if ((longValue & 1) == 0 || ((j10 & 1) == 0 && abs.getLowestSetBit() >= i10)) {
            z10 = false;
        }
        if (z10) {
            j10++;
        }
        return Double.longBitsToDouble((((bitLength + 1023) << 52) + j10) | (bigInteger.signum() & SIGN_MASK));
    }

    public static double ensureNonNegative(double d10) {
        Preconditions.checkArgument(!Double.isNaN(d10));
        return Math.max(d10, 0.0d);
    }

    public static long getSignificand(double d10) {
        Preconditions.checkArgument(isFinite(d10), "not a normal value");
        int exponent = Math.getExponent(d10);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d10) & SIGNIFICAND_MASK;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | IMPLICIT_BIT;
    }

    public static boolean isFinite(double d10) {
        return Math.getExponent(d10) <= 1023;
    }

    public static boolean isNormal(double d10) {
        return Math.getExponent(d10) >= -1022;
    }

    public static double nextDown(double d10) {
        return -Math.nextUp(-d10);
    }

    public static double scaleNormalize(double d10) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d10) & SIGNIFICAND_MASK) | ONE_BITS);
    }
}
