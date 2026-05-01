package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* loaded from: classes2.dex */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    private static int[] bitsToWords(BitArray bitArray, int i10, int i11) {
        int[] iArr = new int[i11];
        int size = bitArray.getSize() / i10;
        for (int i12 = 0; i12 < size; i12++) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                i13 |= bitArray.get((i12 * i10) + i14) ? 1 << ((i10 - i14) - 1) : 0;
            }
            iArr[i12] = i13;
        }
        return iArr;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12 += 2) {
            int i13 = i10 - i12;
            int i14 = i13;
            while (true) {
                int i15 = i10 + i12;
                if (i14 <= i15) {
                    bitMatrix.set(i14, i13);
                    bitMatrix.set(i14, i15);
                    bitMatrix.set(i13, i14);
                    bitMatrix.set(i15, i14);
                    i14++;
                }
            }
        }
        int i16 = i10 - i11;
        bitMatrix.set(i16, i16);
        int i17 = i16 + 1;
        bitMatrix.set(i17, i16);
        bitMatrix.set(i16, i17);
        int i18 = i10 + i11;
        bitMatrix.set(i18, i16);
        bitMatrix.set(i18, i17);
        bitMatrix.set(i18, i18 - 1);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z10, int i10, BitArray bitArray) {
        int i11 = i10 / 2;
        int i12 = 0;
        if (z10) {
            while (i12 < 7) {
                int i13 = (i11 - 3) + i12;
                if (bitArray.get(i12)) {
                    bitMatrix.set(i13, i11 - 5);
                }
                if (bitArray.get(i12 + 7)) {
                    bitMatrix.set(i11 + 5, i13);
                }
                if (bitArray.get(20 - i12)) {
                    bitMatrix.set(i13, i11 + 5);
                }
                if (bitArray.get(27 - i12)) {
                    bitMatrix.set(i11 - 5, i13);
                }
                i12++;
            }
            return;
        }
        while (i12 < 10) {
            int i14 = (i11 - 5) + i12 + (i12 / 5);
            if (bitArray.get(i12)) {
                bitMatrix.set(i14, i11 - 7);
            }
            if (bitArray.get(i12 + 10)) {
                bitMatrix.set(i11 + 7, i14);
            }
            if (bitArray.get(29 - i12)) {
                bitMatrix.set(i14, i11 + 7);
            }
            if (bitArray.get(39 - i12)) {
                bitMatrix.set(i11 - 7, i14);
            }
            i12++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i10, int i11) {
        int size = bitArray.getSize() / i11;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i11));
        int i12 = i10 / i11;
        int[] bitsToWords = bitsToWords(bitArray, i11, i12);
        reedSolomonEncoder.encode(bitsToWords, i12 - size);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i10 % i11);
        for (int i13 : bitsToWords) {
            bitArray2.appendBits(i13, i11);
        }
        return bitArray2;
    }

    public static BitArray generateModeMessage(boolean z10, int i10, int i11) {
        BitArray bitArray = new BitArray();
        if (z10) {
            bitArray.appendBits(i10 - 1, 2);
            bitArray.appendBits(i11 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i10 - 1, 5);
        bitArray.appendBits(i11 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static GenericGF getGF(int i10) {
        if (i10 == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i10 == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i10 == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i10 == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i10 == 12) {
            return GenericGF.AZTEC_DATA_12;
        }
        throw new IllegalArgumentException("Unsupported word size " + i10);
    }

    public static BitArray stuffBits(BitArray bitArray, int i10) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i11 = (1 << i10) - 2;
        int i12 = 0;
        while (i12 < size) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = i12 + i14;
                if (i15 >= size || bitArray.get(i15)) {
                    i13 |= 1 << ((i10 - 1) - i14);
                }
            }
            int i16 = i13 & i11;
            if (i16 == i11) {
                bitArray2.appendBits(i16, i10);
            } else if (i16 == 0) {
                bitArray2.appendBits(i13 | 1, i10);
            } else {
                bitArray2.appendBits(i13, i10);
                i12 += i10;
            }
            i12--;
            i12 += i10;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 << 4)) * i10;
    }

    public static AztecCode encode(byte[] bArr, int i10, int i11) {
        BitArray bitArray;
        boolean z10;
        int i12;
        int i13;
        int i14;
        int i15;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int size = ((encode.getSize() * i10) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i16 = 0;
        int i17 = 1;
        if (i11 == 0) {
            BitArray bitArray2 = null;
            int i18 = 0;
            int i19 = 0;
            while (i18 <= 32) {
                boolean z11 = i18 <= 3;
                int i20 = z11 ? i18 + 1 : i18;
                int i21 = totalBitsInLayer(i20, z11);
                if (size2 <= i21) {
                    int i22 = WORD_SIZE[i20];
                    if (i19 != i22) {
                        bitArray2 = stuffBits(encode, i22);
                    } else {
                        i22 = i19;
                    }
                    int i23 = i21 - (i21 % i22);
                    if ((!z11 || bitArray2.getSize() <= (i22 << 6)) && bitArray2.getSize() + size <= i23) {
                        bitArray = bitArray2;
                        z10 = z11;
                        i12 = i20;
                        i13 = i21;
                        i14 = i22;
                    } else {
                        i19 = i22;
                    }
                }
                i18++;
                i16 = 0;
                i17 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z10 = i11 < 0;
        i12 = Math.abs(i11);
        if (i12 > (z10 ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i11)));
        }
        i13 = totalBitsInLayer(i12, z10);
        i14 = WORD_SIZE[i12];
        int i24 = i13 - (i13 % i14);
        bitArray = stuffBits(encode, i14);
        if (bitArray.getSize() + size > i24) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z10 && bitArray.getSize() > (i14 << 6)) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i13, i14);
        int size3 = bitArray.getSize() / i14;
        BitArray generateModeMessage = generateModeMessage(z10, i12, size3);
        int i25 = (z10 ? 11 : 14) + (i12 << 2);
        int[] iArr = new int[i25];
        int i26 = 2;
        if (z10) {
            for (int i27 = 0; i27 < i25; i27++) {
                iArr[i27] = i27;
            }
            i15 = i25;
        } else {
            int i28 = i25 / 2;
            i15 = i25 + 1 + (((i28 - 1) / 15) * 2);
            int i29 = i15 / 2;
            for (int i30 = 0; i30 < i28; i30++) {
                iArr[(i28 - i30) - i17] = (i29 - r14) - 1;
                iArr[i28 + i30] = (i30 / 15) + i30 + i29 + i17;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i15);
        int i31 = 0;
        int i32 = 0;
        while (i31 < i12) {
            int i33 = ((i12 - i31) << i26) + (z10 ? 9 : 12);
            int i34 = 0;
            while (i34 < i33) {
                int i35 = i34 << 1;
                while (i16 < i26) {
                    if (generateCheckWords.get(i32 + i35 + i16)) {
                        int i36 = i31 << 1;
                        bitMatrix.set(iArr[i36 + i16], iArr[i36 + i34]);
                    }
                    if (generateCheckWords.get((i33 << 1) + i32 + i35 + i16)) {
                        int i37 = i31 << 1;
                        bitMatrix.set(iArr[i37 + i34], iArr[((i25 - 1) - i37) - i16]);
                    }
                    if (generateCheckWords.get((i33 << 2) + i32 + i35 + i16)) {
                        int i38 = (i25 - 1) - (i31 << 1);
                        bitMatrix.set(iArr[i38 - i16], iArr[i38 - i34]);
                    }
                    if (generateCheckWords.get((i33 * 6) + i32 + i35 + i16)) {
                        int i39 = i31 << 1;
                        bitMatrix.set(iArr[((i25 - 1) - i39) - i34], iArr[i39 + i16]);
                    }
                    i16++;
                    i26 = 2;
                }
                i34++;
                i16 = 0;
                i26 = 2;
            }
            i32 += i33 << 3;
            i31++;
            i16 = 0;
            i26 = 2;
        }
        drawModeMessage(bitMatrix, z10, i15, generateModeMessage);
        if (z10) {
            drawBullsEye(bitMatrix, i15 / 2, 5);
        } else {
            int i40 = i15 / 2;
            drawBullsEye(bitMatrix, i40, 7);
            int i41 = 0;
            int i42 = 0;
            while (i42 < (i25 / 2) - 1) {
                for (int i43 = i40 & 1; i43 < i15; i43 += 2) {
                    int i44 = i40 - i41;
                    bitMatrix.set(i44, i43);
                    int i45 = i40 + i41;
                    bitMatrix.set(i45, i43);
                    bitMatrix.set(i43, i44);
                    bitMatrix.set(i43, i45);
                }
                i42 += 15;
                i41 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z10);
        aztecCode.setSize(i15);
        aztecCode.setLayers(i12);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }
}
