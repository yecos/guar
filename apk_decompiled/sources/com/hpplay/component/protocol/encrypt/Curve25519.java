package com.hpplay.component.protocol.encrypt;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes2.dex */
public class Curve25519 {
    public static final int KEY_SIZE = 32;
    private static final int P25 = 33554431;
    private static final int P26 = 67108863;
    public static final byte[] ZERO = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final byte[] PRIME = {-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Ascii.DEL};
    public static final byte[] ORDER = {-19, -45, -11, 92, Ascii.SUB, 99, Ascii.DC2, 88, -42, -100, -9, -94, -34, -7, -34, Ascii.DC4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};
    private static final byte[] ORDER_TIMES_8 = {104, -97, -82, -25, -46, Ascii.CAN, -109, -64, -78, -26, -68, Ascii.ETB, -11, -50, -9, -90, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, UnsignedBytes.MAX_POWER_OF_TWO};
    private static final long10 BASE_2Y = new long10(39999547, 18689728, 59995525, 1648697, 57546132, 24010086, 19059592, 5425144, 63499247, 16420658);
    private static final long10 BASE_R2Y = new long10(5744, 8160848, 4790893, 13779497, 35730846, 12541209, 49101323, 30047407, 40071253, 6226132);

    public static final class long10 {
        public long _0;
        public long _1;
        public long _2;
        public long _3;
        public long _4;
        public long _5;
        public long _6;
        public long _7;
        public long _8;
        public long _9;

        public long10() {
        }

        public long10(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19) {
            this._0 = j10;
            this._1 = j11;
            this._2 = j12;
            this._3 = j13;
            this._4 = j14;
            this._5 = j15;
            this._6 = j16;
            this._7 = j17;
            this._8 = j18;
            this._9 = j19;
        }
    }

    private static final void add(long10 long10Var, long10 long10Var2, long10 long10Var3) {
        long10Var._0 = long10Var2._0 + long10Var3._0;
        long10Var._1 = long10Var2._1 + long10Var3._1;
        long10Var._2 = long10Var2._2 + long10Var3._2;
        long10Var._3 = long10Var2._3 + long10Var3._3;
        long10Var._4 = long10Var2._4 + long10Var3._4;
        long10Var._5 = long10Var2._5 + long10Var3._5;
        long10Var._6 = long10Var2._6 + long10Var3._6;
        long10Var._7 = long10Var2._7 + long10Var3._7;
        long10Var._8 = long10Var2._8 + long10Var3._8;
        long10Var._9 = long10Var2._9 + long10Var3._9;
    }

    public static final void clamp(byte[] bArr) {
        byte b10 = (byte) (bArr[31] & Ascii.DEL);
        bArr[31] = b10;
        bArr[31] = (byte) (b10 | SignedBytes.MAX_POWER_OF_TWO);
        bArr[0] = (byte) (bArr[0] & 248);
    }

    private static final void core(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int i10;
        long10 long10Var = new long10();
        long10 long10Var2 = new long10();
        long10 long10Var3 = new long10();
        long10 long10Var4 = new long10();
        long10 long10Var5 = new long10();
        int i11 = 1;
        long10[] long10VarArr = {new long10(), new long10()};
        long10[] long10VarArr2 = {new long10(), new long10()};
        if (bArr4 != null) {
            unpack(long10Var, bArr4);
        } else {
            set(long10Var, 9);
        }
        set(long10VarArr[0], 1);
        set(long10VarArr2[0], 0);
        cpy(long10VarArr[1], long10Var);
        set(long10VarArr2[1], 1);
        int i12 = 32;
        while (true) {
            int i13 = i12 - 1;
            if (i12 == 0) {
                break;
            }
            int i14 = i13 == 0 ? 0 : i13;
            int i15 = 8;
            while (true) {
                int i16 = i15 - 1;
                if (i15 != 0) {
                    byte b10 = bArr3[i14];
                    int i17 = ((b10 & UnsignedBytes.MAX_VALUE) >> i16) & i11;
                    int i18 = (((b10 & UnsignedBytes.MAX_VALUE) ^ (-1)) >> i16) & i11;
                    long10 long10Var6 = long10VarArr[i18];
                    long10 long10Var7 = long10VarArr2[i18];
                    long10 long10Var8 = long10VarArr[i17];
                    long10 long10Var9 = long10VarArr2[i17];
                    mont_prep(long10Var2, long10Var3, long10Var6, long10Var7);
                    mont_prep(long10Var4, long10Var5, long10Var8, long10Var9);
                    mont_add(long10Var2, long10Var3, long10Var4, long10Var5, long10Var6, long10Var7, long10Var);
                    mont_dbl(long10Var2, long10Var3, long10Var4, long10Var5, long10Var8, long10Var9);
                    i15 = i16;
                    long10VarArr2 = long10VarArr2;
                    i11 = 1;
                }
            }
            i12 = i14;
        }
        long10[] long10VarArr3 = long10VarArr2;
        recip(long10Var2, long10VarArr3[0], 0);
        mul(long10Var, long10VarArr[0], long10Var2);
        pack(long10Var, bArr);
        if (bArr2 != null) {
            x_to_y2(long10Var3, long10Var2, long10Var);
            recip(long10Var4, long10VarArr3[1], 0);
            mul(long10Var3, long10VarArr[1], long10Var4);
            add(long10Var3, long10Var3, long10Var);
            long10Var3._0 += 486671;
            long10Var._0 -= 9;
            sqr(long10Var4, long10Var);
            mul(long10Var, long10Var3, long10Var4);
            sub(long10Var, long10Var, long10Var2);
            long10Var._0 -= 39420360;
            mul(long10Var2, long10Var, BASE_R2Y);
            if (is_negative(long10Var2) != 0) {
                cpy32(bArr2, bArr3);
                i10 = 32;
            } else {
                i10 = 32;
                mula_small(bArr2, ORDER_TIMES_8, 0, bArr3, 32, -1);
            }
            byte[] bArr5 = new byte[i10];
            byte[] bArr6 = ORDER;
            cpy32(bArr5, bArr6);
            cpy32(bArr2, egcd32(new byte[64], new byte[64], bArr2, bArr5));
            if ((bArr2[31] & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                mula_small(bArr2, bArr2, 0, bArr6, 32, 1);
            }
        }
    }

    private static final void cpy(long10 long10Var, long10 long10Var2) {
        long10Var._0 = long10Var2._0;
        long10Var._1 = long10Var2._1;
        long10Var._2 = long10Var2._2;
        long10Var._3 = long10Var2._3;
        long10Var._4 = long10Var2._4;
        long10Var._5 = long10Var2._5;
        long10Var._6 = long10Var2._6;
        long10Var._7 = long10Var2._7;
        long10Var._8 = long10Var2._8;
        long10Var._9 = long10Var2._9;
    }

    private static final void cpy32(byte[] bArr, byte[] bArr2) {
        for (int i10 = 0; i10 < 32; i10++) {
            bArr[i10] = bArr2[i10];
        }
    }

    public static final void curve(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        core(bArr, null, bArr2, bArr3);
    }

    private static final void divmod(byte[] bArr, byte[] bArr2, int i10, byte[] bArr3, int i11) {
        int i12 = i11 - 1;
        int i13 = (bArr3[i12] & UnsignedBytes.MAX_VALUE) << 8;
        if (i11 > 1) {
            i13 |= bArr3[i11 - 2] & UnsignedBytes.MAX_VALUE;
        }
        int i14 = i13;
        int i15 = 0;
        int i16 = i10;
        while (true) {
            int i17 = i16 - 1;
            if (i16 < i11) {
                bArr2[i12] = (byte) i15;
                return;
            }
            int i18 = (i15 << 16) | ((bArr2[i17] & UnsignedBytes.MAX_VALUE) << 8);
            if (i17 > 0) {
                i18 |= bArr2[i17 - 1] & UnsignedBytes.MAX_VALUE;
            }
            int i19 = i18 / i14;
            int i20 = (i17 - i11) + 1;
            int mula_small = i15 + mula_small(bArr2, bArr2, i20, bArr3, i11, -i19);
            bArr[i20] = (byte) ((i19 + mula_small) & 255);
            mula_small(bArr2, bArr2, i20, bArr3, i11, -mula_small);
            i15 = bArr2[i17] & UnsignedBytes.MAX_VALUE;
            bArr2[i17] = 0;
            i16 = i17;
        }
    }

    private static final byte[] egcd32(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int i10;
        int i11 = 0;
        while (true) {
            i10 = 32;
            if (i11 >= 32) {
                break;
            }
            bArr2[i11] = 0;
            bArr[i11] = 0;
            i11++;
        }
        bArr[0] = 1;
        int numsize = numsize(bArr3, 32);
        if (numsize == 0) {
            return bArr2;
        }
        byte[] bArr5 = new byte[32];
        while (true) {
            int i12 = (i10 - numsize) + 1;
            divmod(bArr5, bArr4, i10, bArr3, numsize);
            i10 = numsize(bArr4, i10);
            if (i10 == 0) {
                return bArr;
            }
            mula32(bArr2, bArr, bArr5, i12, -1);
            int i13 = (numsize - i10) + 1;
            divmod(bArr5, bArr3, numsize, bArr4, i10);
            numsize = numsize(bArr3, numsize);
            if (numsize == 0) {
                return bArr2;
            }
            mula32(bArr, bArr2, bArr5, i13, -1);
        }
    }

    private static final int is_negative(long10 long10Var) {
        return (int) (((is_overflow(long10Var) || long10Var._9 < 0) ? 1 : 0) ^ (long10Var._0 & 1));
    }

    private static final boolean is_overflow(long10 long10Var) {
        return (long10Var._0 > 67108844 && ((((long10Var._1 & long10Var._3) & long10Var._5) & long10Var._7) & long10Var._9) == 33554431 && (((long10Var._2 & long10Var._4) & long10Var._6) & long10Var._8) == 67108863) || long10Var._9 > 33554431;
    }

    public static final void keygen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        clamp(bArr3);
        core(bArr, bArr2, bArr3, null);
    }

    private static final void mont_add(long10 long10Var, long10 long10Var2, long10 long10Var3, long10 long10Var4, long10 long10Var5, long10 long10Var6, long10 long10Var7) {
        mul(long10Var5, long10Var2, long10Var3);
        mul(long10Var6, long10Var, long10Var4);
        add(long10Var, long10Var5, long10Var6);
        sub(long10Var2, long10Var5, long10Var6);
        sqr(long10Var5, long10Var);
        sqr(long10Var, long10Var2);
        mul(long10Var6, long10Var, long10Var7);
    }

    private static final void mont_dbl(long10 long10Var, long10 long10Var2, long10 long10Var3, long10 long10Var4, long10 long10Var5, long10 long10Var6) {
        sqr(long10Var, long10Var3);
        sqr(long10Var2, long10Var4);
        mul(long10Var5, long10Var, long10Var2);
        sub(long10Var2, long10Var, long10Var2);
        mul_small(long10Var6, long10Var2, 121665L);
        add(long10Var, long10Var, long10Var6);
        mul(long10Var6, long10Var, long10Var2);
    }

    private static final void mont_prep(long10 long10Var, long10 long10Var2, long10 long10Var3, long10 long10Var4) {
        add(long10Var, long10Var3, long10Var4);
        sub(long10Var2, long10Var3, long10Var4);
    }

    private static final long10 mul(long10 long10Var, long10 long10Var2, long10 long10Var3) {
        long j10 = long10Var2._0;
        long j11 = long10Var2._1;
        long j12 = long10Var2._2;
        long j13 = long10Var2._3;
        long j14 = long10Var2._4;
        long j15 = long10Var2._5;
        long j16 = long10Var2._6;
        long j17 = long10Var2._7;
        long j18 = long10Var2._8;
        long j19 = long10Var2._9;
        long j20 = long10Var3._0;
        long j21 = long10Var3._1;
        long j22 = long10Var3._2;
        long j23 = long10Var3._3;
        long j24 = long10Var3._4;
        long j25 = long10Var3._5;
        long j26 = long10Var3._6;
        long j27 = long10Var3._7;
        long j28 = long10Var3._8;
        long j29 = long10Var3._9;
        long j30 = (j10 * j28) + (j12 * j26) + (j14 * j24) + (j16 * j22) + (j18 * j20) + (((j11 * j27) + (j13 * j25) + (j15 * j23) + (j17 * j21)) * 2) + (j19 * j29 * 38);
        long j31 = j30 & 67108863;
        long j32 = (j30 >> 26) + (j10 * j29) + (j11 * j28) + (j12 * j27) + (j13 * j26) + (j14 * j25) + (j15 * j24) + (j16 * j23) + (j17 * j22) + (j18 * j21) + (j19 * j20);
        long j33 = (j10 * j20) + (((j32 >> 25) + (j12 * j28) + (j14 * j26) + (j16 * j24) + (j18 * j22)) * 19) + (((j11 * j29) + (j13 * j27) + (j15 * j25) + (j17 * j23) + (j19 * j21)) * 38);
        long10Var._0 = j33 & 67108863;
        long j34 = (j33 >> 26) + (j10 * j21) + (j11 * j20) + (((j12 * j29) + (j13 * j28) + (j14 * j27) + (j15 * j26) + (j16 * j25) + (j17 * j24) + (j18 * j23) + (j19 * j22)) * 19);
        long10Var._1 = j34 & 33554431;
        long j35 = (j34 >> 25) + (j10 * j22) + (j12 * j20) + (((j14 * j28) + (j16 * j26) + (j18 * j24)) * 19) + (j11 * j21 * 2) + (((j13 * j29) + (j15 * j27) + (j17 * j25) + (j19 * j23)) * 38);
        long10Var._2 = j35 & 67108863;
        long j36 = (j35 >> 26) + (j10 * j23) + (j11 * j22) + (j12 * j21) + (j13 * j20) + (((j14 * j29) + (j15 * j28) + (j16 * j27) + (j17 * j26) + (j18 * j25) + (j19 * j24)) * 19);
        long10Var._3 = j36 & 33554431;
        long j37 = (j36 >> 25) + (j10 * j24) + (j12 * j22) + (j14 * j20) + (((j16 * j28) + (j18 * j26)) * 19) + (((j11 * j23) + (j13 * j21)) * 2) + (((j15 * j29) + (j17 * j27) + (j19 * j25)) * 38);
        long10Var._4 = j37 & 67108863;
        long j38 = (j37 >> 26) + (j10 * j25) + (j11 * j24) + (j12 * j23) + (j13 * j22) + (j14 * j21) + (j15 * j20) + (((j16 * j29) + (j17 * j28) + (j18 * j27) + (j19 * j26)) * 19);
        long10Var._5 = j38 & 33554431;
        long j39 = (j38 >> 25) + (j10 * j26) + (j12 * j24) + (j14 * j22) + (j16 * j20) + (j18 * j28 * 19) + (((j11 * j25) + (j13 * j23) + (j15 * j21)) * 2) + (((j17 * j29) + (j19 * j27)) * 38);
        long10Var._6 = j39 & 67108863;
        long j40 = (j39 >> 26) + (j10 * j27) + (j11 * j26) + (j12 * j25) + (j13 * j24) + (j14 * j23) + (j15 * j22) + (j16 * j21) + (j17 * j20) + (((j18 * j29) + (j19 * j28)) * 19);
        long10Var._7 = j40 & 33554431;
        long j41 = (j40 >> 25) + j31;
        long10Var._8 = j41 & 67108863;
        long10Var._9 = (j32 & 33554431) + (j41 >> 26);
        return long10Var;
    }

    private static final long10 mul_small(long10 long10Var, long10 long10Var2, long j10) {
        long j11 = long10Var2._8 * j10;
        long j12 = j11 & 67108863;
        long j13 = (j11 >> 26) + (long10Var2._9 * j10);
        long j14 = j13 & 33554431;
        long j15 = ((j13 >> 25) * 19) + (long10Var2._0 * j10);
        long10Var._0 = j15 & 67108863;
        long j16 = (j15 >> 26) + (long10Var2._1 * j10);
        long10Var._1 = j16 & 33554431;
        long j17 = (j16 >> 25) + (long10Var2._2 * j10);
        long10Var._2 = j17 & 67108863;
        long j18 = (j17 >> 26) + (long10Var2._3 * j10);
        long10Var._3 = j18 & 33554431;
        long j19 = (j18 >> 25) + (long10Var2._4 * j10);
        long10Var._4 = j19 & 67108863;
        long j20 = (j19 >> 26) + (long10Var2._5 * j10);
        long10Var._5 = j20 & 33554431;
        long j21 = (j20 >> 25) + (long10Var2._6 * j10);
        long10Var._6 = j21 & 67108863;
        long j22 = (j21 >> 26) + (long10Var2._7 * j10);
        long10Var._7 = 33554431 & j22;
        long j23 = (j22 >> 25) + j12;
        long10Var._8 = 67108863 & j23;
        long10Var._9 = j14 + (j23 >> 26);
        return long10Var;
    }

    private static final int mula32(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, int i11) {
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = i11 * (bArr3[i12] & 255);
            int i15 = i12 + 31;
            int mula_small = i13 + mula_small(bArr, bArr, i12, bArr2, 31, i14) + (bArr[i15] & 255) + (i14 * (bArr2[31] & 255));
            bArr[i15] = (byte) mula_small;
            i13 = mula_small >> 8;
            i12++;
        }
        int i16 = i12 + 31;
        bArr[i16] = (byte) ((bArr[i16] & 255) + i13);
        return i13 >> 8;
    }

    private static final int mula_small(byte[] bArr, byte[] bArr2, int i10, byte[] bArr3, int i11, int i12) {
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i14 + i10;
            int i16 = i13 + (bArr2[i15] & 255) + ((bArr3[i14] & 255) * i12);
            bArr[i15] = (byte) i16;
            i13 = i16 >> 8;
        }
        return i13;
    }

    private static final int numsize(byte[] bArr, int i10) {
        int i11;
        while (true) {
            i11 = i10 - 1;
            if (i10 == 0 || bArr[i11] != 0) {
                break;
            }
            i10 = i11;
        }
        return i11 + 1;
    }

    private static final void pack(long10 long10Var, byte[] bArr) {
        boolean is_overflow = is_overflow(long10Var);
        long j10 = long10Var._9;
        int i10 = (is_overflow ? 1 : 0) - (j10 < 0 ? 1 : 0);
        long j11 = (i10 * 19) + long10Var._0 + (long10Var._1 << 26);
        bArr[0] = (byte) j11;
        bArr[1] = (byte) (j11 >> 8);
        bArr[2] = (byte) (j11 >> 16);
        bArr[3] = (byte) (j11 >> 24);
        long j12 = (j11 >> 32) + (long10Var._2 << 19);
        bArr[4] = (byte) j12;
        bArr[5] = (byte) (j12 >> 8);
        bArr[6] = (byte) (j12 >> 16);
        bArr[7] = (byte) (j12 >> 24);
        long j13 = (j12 >> 32) + (long10Var._3 << 13);
        bArr[8] = (byte) j13;
        bArr[9] = (byte) (j13 >> 8);
        bArr[10] = (byte) (j13 >> 16);
        bArr[11] = (byte) (j13 >> 24);
        long j14 = (j13 >> 32) + (long10Var._4 << 6);
        bArr[12] = (byte) j14;
        bArr[13] = (byte) (j14 >> 8);
        bArr[14] = (byte) (j14 >> 16);
        bArr[15] = (byte) (j14 >> 24);
        long j15 = (j14 >> 32) + long10Var._5 + (long10Var._6 << 25);
        bArr[16] = (byte) j15;
        bArr[17] = (byte) (j15 >> 8);
        bArr[18] = (byte) (j15 >> 16);
        bArr[19] = (byte) (j15 >> 24);
        long j16 = (j15 >> 32) + (long10Var._7 << 19);
        bArr[20] = (byte) j16;
        bArr[21] = (byte) (j16 >> 8);
        bArr[22] = (byte) (j16 >> 16);
        bArr[23] = (byte) (j16 >> 24);
        long j17 = (j16 >> 32) + (long10Var._8 << 12);
        bArr[24] = (byte) j17;
        bArr[25] = (byte) (j17 >> 8);
        bArr[26] = (byte) (j17 >> 16);
        bArr[27] = (byte) (j17 >> 24);
        bArr[28] = (byte) ((j17 >> 32) + ((j10 + ((-33554432) * i10)) << 6));
        bArr[29] = (byte) (r0 >> 8);
        bArr[30] = (byte) (r0 >> 16);
        bArr[31] = (byte) (r0 >> 24);
    }

    private static final void recip(long10 long10Var, long10 long10Var2, int i10) {
        long10 long10Var3 = new long10();
        long10 long10Var4 = new long10();
        long10 long10Var5 = new long10();
        long10 long10Var6 = new long10();
        long10 long10Var7 = new long10();
        sqr(long10Var4, long10Var2);
        sqr(long10Var5, long10Var4);
        sqr(long10Var3, long10Var5);
        mul(long10Var5, long10Var3, long10Var2);
        mul(long10Var3, long10Var5, long10Var4);
        sqr(long10Var4, long10Var3);
        mul(long10Var6, long10Var4, long10Var5);
        sqr(long10Var4, long10Var6);
        sqr(long10Var5, long10Var4);
        sqr(long10Var4, long10Var5);
        sqr(long10Var5, long10Var4);
        sqr(long10Var4, long10Var5);
        mul(long10Var5, long10Var4, long10Var6);
        sqr(long10Var4, long10Var5);
        sqr(long10Var6, long10Var4);
        for (int i11 = 1; i11 < 5; i11++) {
            sqr(long10Var4, long10Var6);
            sqr(long10Var6, long10Var4);
        }
        mul(long10Var4, long10Var6, long10Var5);
        sqr(long10Var6, long10Var4);
        sqr(long10Var7, long10Var6);
        for (int i12 = 1; i12 < 10; i12++) {
            sqr(long10Var6, long10Var7);
            sqr(long10Var7, long10Var6);
        }
        mul(long10Var6, long10Var7, long10Var4);
        for (int i13 = 0; i13 < 5; i13++) {
            sqr(long10Var4, long10Var6);
            sqr(long10Var6, long10Var4);
        }
        mul(long10Var4, long10Var6, long10Var5);
        sqr(long10Var5, long10Var4);
        sqr(long10Var6, long10Var5);
        for (int i14 = 1; i14 < 25; i14++) {
            sqr(long10Var5, long10Var6);
            sqr(long10Var6, long10Var5);
        }
        mul(long10Var5, long10Var6, long10Var4);
        sqr(long10Var6, long10Var5);
        sqr(long10Var7, long10Var6);
        for (int i15 = 1; i15 < 50; i15++) {
            sqr(long10Var6, long10Var7);
            sqr(long10Var7, long10Var6);
        }
        mul(long10Var6, long10Var7, long10Var5);
        for (int i16 = 0; i16 < 25; i16++) {
            sqr(long10Var7, long10Var6);
            sqr(long10Var6, long10Var7);
        }
        mul(long10Var5, long10Var6, long10Var4);
        sqr(long10Var4, long10Var5);
        sqr(long10Var5, long10Var4);
        if (i10 != 0) {
            mul(long10Var, long10Var2, long10Var5);
            return;
        }
        sqr(long10Var4, long10Var5);
        sqr(long10Var5, long10Var4);
        sqr(long10Var4, long10Var5);
        mul(long10Var, long10Var4, long10Var3);
    }

    private static final void set(long10 long10Var, int i10) {
        long10Var._0 = i10;
        long10Var._1 = 0L;
        long10Var._2 = 0L;
        long10Var._3 = 0L;
        long10Var._4 = 0L;
        long10Var._5 = 0L;
        long10Var._6 = 0L;
        long10Var._7 = 0L;
        long10Var._8 = 0L;
        long10Var._9 = 0L;
    }

    public static final boolean sign(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = new byte[32];
        byte[] bArr6 = new byte[32];
        byte[] bArr7 = new byte[64];
        cpy32(bArr5, bArr2);
        cpy32(bArr6, bArr3);
        byte[] bArr8 = new byte[32];
        byte[] bArr9 = ORDER;
        divmod(bArr8, bArr5, 32, bArr9, 32);
        divmod(bArr8, bArr6, 32, bArr9, 32);
        mula_small(bArr, bArr6, 0, bArr5, 32, -1);
        mula_small(bArr, bArr, 0, bArr9, 32, 1);
        mula32(bArr7, bArr, bArr4, 32, 1);
        divmod(new byte[64], bArr7, 64, bArr9, 32);
        int i10 = 0;
        for (int i11 = 0; i11 < 32; i11++) {
            byte b10 = bArr7[i11];
            bArr[i11] = b10;
            i10 |= b10;
        }
        return i10 != 0;
    }

    private static final long10 sqr(long10 long10Var, long10 long10Var2) {
        long j10 = long10Var2._0;
        long j11 = long10Var2._1;
        long j12 = long10Var2._2;
        long j13 = long10Var2._3;
        long j14 = long10Var2._4;
        long j15 = long10Var2._5;
        long j16 = long10Var2._6;
        long j17 = long10Var2._7;
        long j18 = long10Var2._8;
        long j19 = long10Var2._9;
        long j20 = (j14 * j14) + (((j10 * j18) + (j12 * j16)) * 2) + (j19 * j19 * 38) + (((j11 * j17) + (j13 * j15)) * 4);
        long j21 = j20 & 67108863;
        long j22 = (j20 >> 26) + (((j10 * j19) + (j11 * j18) + (j12 * j17) + (j13 * j16) + (j14 * j15)) * 2);
        long j23 = j22 & 33554431;
        long j24 = ((j22 >> 25) * 19) + (j10 * j10) + (((j12 * j18) + (j14 * j16) + (j15 * j15)) * 38) + (((j11 * j19) + (j13 * j17)) * 76);
        long10Var._0 = j24 & 67108863;
        long j25 = (j24 >> 26) + (j10 * j11 * 2) + (((j12 * j19) + (j13 * j18) + (j14 * j17) + (j15 * j16)) * 38);
        long10Var._1 = j25 & 33554431;
        long j26 = (j25 >> 25) + (j16 * j16 * 19) + (((j10 * j12) + (j11 * j11)) * 2) + (j14 * j18 * 38) + (((j13 * j19) + (j15 * j17)) * 76);
        long10Var._2 = j26 & 67108863;
        long j27 = (j26 >> 26) + (((j10 * j13) + (j11 * j12)) * 2) + (((j14 * j19) + (j15 * j18) + (j16 * j17)) * 38);
        long10Var._3 = j27 & 33554431;
        long j28 = (j27 >> 25) + (j12 * j12) + (j10 * j14 * 2) + (((j16 * j18) + (j17 * j17)) * 38) + (j11 * j13 * 4) + (j15 * j19 * 76);
        long10Var._4 = j28 & 67108863;
        long j29 = (j28 >> 26) + (((j10 * j15) + (j11 * j14) + (j12 * j13)) * 2) + (((j16 * j19) + (j17 * j18)) * 38);
        long10Var._5 = j29 & 33554431;
        long j30 = (j29 >> 25) + (j18 * j18 * 19) + (((j10 * j16) + (j12 * j14) + (j13 * j13)) * 2) + (j11 * j15 * 4) + (j17 * j19 * 76);
        long10Var._6 = j30 & 67108863;
        long j31 = (j30 >> 26) + (((j10 * j17) + (j11 * j16) + (j12 * j15) + (j13 * j14)) * 2) + (j18 * j19 * 38);
        long10Var._7 = j31 & 33554431;
        long j32 = (j31 >> 25) + j21;
        long10Var._8 = j32 & 67108863;
        long10Var._9 = j23 + (j32 >> 26);
        return long10Var;
    }

    private static final void sqrt(long10 long10Var, long10 long10Var2) {
        long10 long10Var3 = new long10();
        long10 long10Var4 = new long10();
        long10 long10Var5 = new long10();
        add(long10Var4, long10Var2, long10Var2);
        recip(long10Var3, long10Var4, 1);
        sqr(long10Var, long10Var3);
        mul(long10Var5, long10Var4, long10Var);
        long10Var5._0--;
        mul(long10Var4, long10Var3, long10Var5);
        mul(long10Var, long10Var2, long10Var4);
    }

    private static final void sub(long10 long10Var, long10 long10Var2, long10 long10Var3) {
        long10Var._0 = long10Var2._0 - long10Var3._0;
        long10Var._1 = long10Var2._1 - long10Var3._1;
        long10Var._2 = long10Var2._2 - long10Var3._2;
        long10Var._3 = long10Var2._3 - long10Var3._3;
        long10Var._4 = long10Var2._4 - long10Var3._4;
        long10Var._5 = long10Var2._5 - long10Var3._5;
        long10Var._6 = long10Var2._6 - long10Var3._6;
        long10Var._7 = long10Var2._7 - long10Var3._7;
        long10Var._8 = long10Var2._8 - long10Var3._8;
        long10Var._9 = long10Var2._9 - long10Var3._9;
    }

    private static final void unpack(long10 long10Var, byte[] bArr) {
        int i10 = (bArr[0] & UnsignedBytes.MAX_VALUE) | ((bArr[1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[2] & UnsignedBytes.MAX_VALUE) << 16);
        byte b10 = bArr[3];
        long10Var._0 = i10 | (((b10 & UnsignedBytes.MAX_VALUE) & 3) << 24);
        int i11 = (((b10 & UnsignedBytes.MAX_VALUE) & (-4)) >> 2) | ((bArr[4] & UnsignedBytes.MAX_VALUE) << 6) | ((bArr[5] & UnsignedBytes.MAX_VALUE) << 14);
        byte b11 = bArr[6];
        long10Var._1 = i11 | (((b11 & UnsignedBytes.MAX_VALUE) & 7) << 22);
        int i12 = (((b11 & UnsignedBytes.MAX_VALUE) & (-8)) >> 3) | ((bArr[7] & UnsignedBytes.MAX_VALUE) << 5) | ((bArr[8] & UnsignedBytes.MAX_VALUE) << 13);
        byte b12 = bArr[9];
        long10Var._2 = i12 | (((b12 & UnsignedBytes.MAX_VALUE) & 31) << 21);
        int i13 = (((b12 & UnsignedBytes.MAX_VALUE) & (-32)) >> 5) | ((bArr[10] & UnsignedBytes.MAX_VALUE) << 3) | ((bArr[11] & UnsignedBytes.MAX_VALUE) << 11);
        byte b13 = bArr[12];
        long10Var._3 = i13 | (((b13 & UnsignedBytes.MAX_VALUE) & 63) << 19);
        long10Var._4 = (((b13 & UnsignedBytes.MAX_VALUE) & (-64)) >> 6) | ((bArr[13] & UnsignedBytes.MAX_VALUE) << 2) | ((bArr[14] & UnsignedBytes.MAX_VALUE) << 10) | ((bArr[15] & UnsignedBytes.MAX_VALUE) << 18);
        int i14 = ((bArr[18] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[17] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[16] & UnsignedBytes.MAX_VALUE);
        byte b14 = bArr[19];
        long10Var._5 = i14 | (((b14 & UnsignedBytes.MAX_VALUE) & 1) << 24);
        int i15 = (((b14 & UnsignedBytes.MAX_VALUE) & (-2)) >> 1) | ((bArr[20] & UnsignedBytes.MAX_VALUE) << 7) | ((bArr[21] & UnsignedBytes.MAX_VALUE) << 15);
        byte b15 = bArr[22];
        long10Var._6 = i15 | ((7 & (b15 & UnsignedBytes.MAX_VALUE)) << 23);
        int i16 = (((b15 & UnsignedBytes.MAX_VALUE) & (-8)) >> 3) | ((bArr[23] & UnsignedBytes.MAX_VALUE) << 5) | ((bArr[24] & UnsignedBytes.MAX_VALUE) << 13);
        byte b16 = bArr[25];
        long10Var._7 = i16 | (((b16 & UnsignedBytes.MAX_VALUE) & 15) << 21);
        int i17 = (((b16 & UnsignedBytes.MAX_VALUE) & (-16)) >> 4) | ((bArr[26] & UnsignedBytes.MAX_VALUE) << 4) | ((bArr[27] & UnsignedBytes.MAX_VALUE) << 12);
        byte b17 = bArr[28];
        long10Var._8 = i17 | (((b17 & UnsignedBytes.MAX_VALUE) & 63) << 20);
        long10Var._9 = (((b17 & UnsignedBytes.MAX_VALUE) & (-64)) >> 6) | ((bArr[29] & UnsignedBytes.MAX_VALUE) << 2) | ((bArr[30] & UnsignedBytes.MAX_VALUE) << 10) | ((bArr[31] & UnsignedBytes.MAX_VALUE) << 18);
    }

    public static final void verify(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = new byte[32];
        char c10 = 0;
        long10[] long10VarArr = {new long10(), new long10()};
        long10[] long10VarArr2 = {new long10(), new long10()};
        long10[] long10VarArr3 = {new long10(), new long10(), new long10()};
        long10[] long10VarArr4 = {new long10(), new long10(), new long10()};
        long10[] long10VarArr5 = {new long10(), new long10(), new long10()};
        long10[] long10VarArr6 = {new long10(), new long10(), new long10()};
        set(long10VarArr[0], 9);
        unpack(long10VarArr[1], bArr4);
        x_to_y2(long10VarArr5[0], long10VarArr6[0], long10VarArr[1]);
        sqrt(long10VarArr5[0], long10VarArr6[0]);
        int is_negative = is_negative(long10VarArr5[0]);
        long10VarArr6[0]._0 += 39420360;
        mul(long10VarArr6[1], BASE_2Y, long10VarArr5[0]);
        sub(long10VarArr5[is_negative], long10VarArr6[0], long10VarArr6[1]);
        add(long10VarArr5[1 - is_negative], long10VarArr6[0], long10VarArr6[1]);
        cpy(long10VarArr6[0], long10VarArr[1]);
        long10 long10Var = long10VarArr6[0];
        long10Var._0 -= 9;
        sqr(long10VarArr6[1], long10Var);
        recip(long10VarArr6[0], long10VarArr6[1], 0);
        mul(long10VarArr2[0], long10VarArr5[0], long10VarArr6[0]);
        long10 long10Var2 = long10VarArr2[0];
        sub(long10Var2, long10Var2, long10VarArr[1]);
        long10VarArr2[0]._0 -= 486671;
        mul(long10VarArr2[1], long10VarArr5[1], long10VarArr6[0]);
        long10 long10Var3 = long10VarArr2[1];
        sub(long10Var3, long10Var3, long10VarArr[1]);
        long10VarArr2[1]._0 -= 486671;
        long10 long10Var4 = long10VarArr2[0];
        mul_small(long10Var4, long10Var4, 1L);
        long10 long10Var5 = long10VarArr2[1];
        mul_small(long10Var5, long10Var5, 1L);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 32; i10 < i15; i15 = 32) {
            int i16 = i13 >> 8;
            byte b10 = bArr2[i10];
            i13 = ((b10 & UnsignedBytes.MAX_VALUE) ^ i16) ^ ((b10 & UnsignedBytes.MAX_VALUE) << 1);
            byte b11 = bArr3[i10];
            i14 = ((i14 >> 8) ^ (b11 & UnsignedBytes.MAX_VALUE)) ^ ((b11 & UnsignedBytes.MAX_VALUE) << 1);
            i11 = (i13 ^ i14) ^ (-1);
            int i17 = (((i12 & 128) >> 7) & i11) ^ i13;
            int i18 = i17 ^ (((i17 & 1) << 1) & i11);
            int i19 = i18 ^ (((i18 & 2) << 1) & i11);
            int i20 = i19 ^ (((i19 & 4) << 1) & i11);
            int i21 = i20 ^ (((i20 & 8) << 1) & i11);
            int i22 = i21 ^ (((i21 & 16) << 1) & i11);
            int i23 = i22 ^ (((i22 & 32) << 1) & i11);
            i12 = (((i23 & 64) << 1) & i11) ^ i23;
            bArr5[i10] = (byte) i12;
            i10++;
        }
        int i24 = ((((i12 & 128) << 1) & i11) ^ i13) >> 8;
        set(long10VarArr3[0], 1);
        cpy(long10VarArr3[1], long10VarArr[i24]);
        cpy(long10VarArr3[2], long10VarArr2[0]);
        set(long10VarArr4[0], 0);
        set(long10VarArr4[1], 1);
        set(long10VarArr4[2], 1);
        int i25 = i24;
        int i26 = 32;
        int i27 = 0;
        int i28 = 0;
        while (true) {
            int i29 = i26 - 1;
            if (i26 == 0) {
                int i30 = (i27 & 1) + (i28 & 1);
                recip(long10VarArr5[0], long10VarArr4[i30], 0);
                mul(long10VarArr5[1], long10VarArr3[i30], long10VarArr5[0]);
                pack(long10VarArr5[1], bArr);
                return;
            }
            i27 = (bArr2[i29] & UnsignedBytes.MAX_VALUE) | (i27 << 8);
            i28 = (bArr3[i29] & UnsignedBytes.MAX_VALUE) | (i28 << 8);
            i25 = (bArr5[i29] & UnsignedBytes.MAX_VALUE) | (i25 << 8);
            int i31 = 8;
            while (true) {
                int i32 = i31 - 1;
                if (i31 != 0) {
                    byte[] bArr6 = bArr5;
                    mont_prep(long10VarArr5[c10], long10VarArr6[c10], long10VarArr3[c10], long10VarArr4[c10]);
                    mont_prep(long10VarArr5[1], long10VarArr6[1], long10VarArr3[1], long10VarArr4[1]);
                    mont_prep(long10VarArr5[2], long10VarArr6[2], long10VarArr3[2], long10VarArr4[2]);
                    int i33 = ((((i27 >> 1) ^ i27) >> i32) & 1) + ((((i28 >> 1) ^ i28) >> i32) & 1);
                    mont_dbl(long10VarArr3[2], long10VarArr4[2], long10VarArr5[i33], long10VarArr6[i33], long10VarArr3[0], long10VarArr4[0]);
                    int i34 = i25 >> i32;
                    int i35 = i34 & 2;
                    int i36 = i34 & 1;
                    int i37 = i35 ^ (i36 << 1);
                    mont_add(long10VarArr5[1], long10VarArr6[1], long10VarArr5[i37], long10VarArr6[i37], long10VarArr3[1], long10VarArr4[1], long10VarArr[i36]);
                    mont_add(long10VarArr5[2], long10VarArr6[2], long10VarArr5[0], long10VarArr6[0], long10VarArr3[2], long10VarArr4[2], long10VarArr2[(((i27 ^ i28) >> i32) & 2) >> 1]);
                    i31 = i32;
                    bArr5 = bArr6;
                    c10 = 0;
                }
            }
            i26 = i29;
        }
    }

    private static final void x_to_y2(long10 long10Var, long10 long10Var2, long10 long10Var3) {
        sqr(long10Var, long10Var3);
        mul_small(long10Var2, long10Var3, 486662L);
        add(long10Var, long10Var, long10Var2);
        long10Var._0++;
        mul(long10Var2, long10Var, long10Var3);
    }
}
