package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public final class CodaBarReader extends OneDReader {
    private static final float MAX_ACCEPTABLE = 2.0f;
    private static final int MIN_CHARACTER_LENGTH = 3;
    private static final float PADDING = 1.5f;
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
    static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    static final int[] CHARACTER_ENCODINGS = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] STARTEND_ENCODING = {'A', ASCIIPropertyListParser.DATA_GSBOOL_BEGIN_TOKEN, 'C', ASCIIPropertyListParser.DATA_GSDATE_BEGIN_TOKEN};
    private final StringBuilder decodeRowResult = new StringBuilder(20);
    private int[] counters = new int[80];
    private int counterLength = 0;

    public static boolean arrayContains(char[] cArr, char c10) {
        if (cArr != null) {
            for (char c11 : cArr) {
                if (c11 == c10) {
                    return true;
                }
            }
        }
        return false;
    }

    private void counterAppend(int i10) {
        int[] iArr = this.counters;
        int i11 = this.counterLength;
        iArr[i11] = i10;
        int i12 = i11 + 1;
        this.counterLength = i12;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[i12 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.counters = iArr2;
        }
    }

    private int findStartPattern() {
        for (int i10 = 1; i10 < this.counterLength; i10 += 2) {
            int narrowWidePattern = toNarrowWidePattern(i10);
            if (narrowWidePattern != -1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                int i11 = 0;
                for (int i12 = i10; i12 < i10 + 7; i12++) {
                    i11 += this.counters[i12];
                }
                if (i10 == 1 || this.counters[i10 - 1] >= i11 / 2) {
                    return i10;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void setCounters(BitArray bitArray) {
        int i10 = 0;
        this.counterLength = 0;
        int nextUnset = bitArray.getNextUnset(0);
        int size = bitArray.getSize();
        if (nextUnset >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z10 = true;
        while (nextUnset < size) {
            if (bitArray.get(nextUnset) ^ z10) {
                i10++;
            } else {
                counterAppend(i10);
                z10 = !z10;
                i10 = 1;
            }
            nextUnset++;
        }
        counterAppend(i10);
    }

    private int toNarrowWidePattern(int i10) {
        int i11 = i10 + 7;
        if (i11 >= this.counterLength) {
            return -1;
        }
        int[] iArr = this.counters;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        int i14 = Integer.MAX_VALUE;
        int i15 = 0;
        for (int i16 = i10; i16 < i11; i16 += 2) {
            int i17 = iArr[i16];
            if (i17 < i14) {
                i14 = i17;
            }
            if (i17 > i15) {
                i15 = i17;
            }
        }
        int i18 = (i14 + i15) / 2;
        int i19 = 0;
        for (int i20 = i10 + 1; i20 < i11; i20 += 2) {
            int i21 = iArr[i20];
            if (i21 < i12) {
                i12 = i21;
            }
            if (i21 > i19) {
                i19 = i21;
            }
        }
        int i22 = (i12 + i19) / 2;
        int i23 = 128;
        int i24 = 0;
        for (int i25 = 0; i25 < 7; i25++) {
            i23 >>= 1;
            if (iArr[i10 + i25] > ((i25 & 1) == 0 ? i18 : i22)) {
                i24 |= i23;
            }
        }
        while (true) {
            int[] iArr2 = CHARACTER_ENCODINGS;
            if (i13 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i13] == i24) {
                return i13;
            }
            i13++;
        }
    }

    private void validatePattern(int i10) {
        int i11 = 0;
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.decodeRowResult.length() - 1;
        int i12 = i10;
        int i13 = 0;
        while (true) {
            int i14 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i13)];
            for (int i15 = 6; i15 >= 0; i15--) {
                int i16 = (i15 & 1) + ((i14 & 1) << 1);
                iArr[i16] = iArr[i16] + this.counters[i12 + i15];
                iArr2[i16] = iArr2[i16] + 1;
                i14 >>= 1;
            }
            if (i13 >= length) {
                break;
            }
            i12 += 8;
            i13++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i17 = 0; i17 < 2; i17++) {
            fArr2[i17] = 0.0f;
            int i18 = i17 + 2;
            int i19 = iArr[i18];
            int i20 = iArr2[i18];
            float f10 = ((iArr[i17] / iArr2[i17]) + (i19 / i20)) / 2.0f;
            fArr2[i18] = f10;
            fArr[i17] = f10;
            fArr[i18] = ((i19 * 2.0f) + 1.5f) / i20;
        }
        loop3: while (true) {
            int i21 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i11)];
            for (int i22 = 6; i22 >= 0; i22--) {
                int i23 = (i22 & 1) + ((i21 & 1) << 1);
                float f11 = this.counters[i10 + i22];
                if (f11 < fArr2[i23] || f11 > fArr[i23]) {
                    break loop3;
                }
                i21 >>= 1;
            }
            if (i11 >= length) {
                return;
            }
            i10 += 8;
            i11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i10, BitArray bitArray, Map<DecodeHintType, ?> map) {
        Arrays.fill(this.counters, 0);
        setCounters(bitArray);
        int findStartPattern = findStartPattern();
        this.decodeRowResult.setLength(0);
        int i11 = findStartPattern;
        do {
            int narrowWidePattern = toNarrowWidePattern(i11);
            if (narrowWidePattern == -1) {
                throw NotFoundException.getNotFoundInstance();
            }
            this.decodeRowResult.append((char) narrowWidePattern);
            i11 += 8;
            if (this.decodeRowResult.length() > 1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                break;
            }
        } while (i11 < this.counterLength);
        int i12 = i11 - 1;
        int i13 = this.counters[i12];
        int i14 = 0;
        for (int i15 = -8; i15 < -1; i15++) {
            i14 += this.counters[i11 + i15];
        }
        if (i11 < this.counterLength && i13 < i14 / 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        validatePattern(findStartPattern);
        for (int i16 = 0; i16 < this.decodeRowResult.length(); i16++) {
            StringBuilder sb = this.decodeRowResult;
            sb.setCharAt(i16, ALPHABET[sb.charAt(i16)]);
        }
        char charAt = this.decodeRowResult.charAt(0);
        char[] cArr = STARTEND_ENCODING;
        if (!arrayContains(cArr, charAt)) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = this.decodeRowResult;
        if (!arrayContains(cArr, sb2.charAt(sb2.length() - 1))) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (this.decodeRowResult.length() <= 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.decodeRowResult;
            sb3.deleteCharAt(sb3.length() - 1);
            this.decodeRowResult.deleteCharAt(0);
        }
        int i17 = 0;
        for (int i18 = 0; i18 < findStartPattern; i18++) {
            i17 += this.counters[i18];
        }
        float f10 = i17;
        while (findStartPattern < i12) {
            i17 += this.counters[findStartPattern];
            findStartPattern++;
        }
        float f11 = i10;
        return new Result(this.decodeRowResult.toString(), null, new ResultPoint[]{new ResultPoint(f10, f11), new ResultPoint(i17, f11)}, BarcodeFormat.CODABAR);
    }
}
