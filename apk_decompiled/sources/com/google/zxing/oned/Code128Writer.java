package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes2.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int chooseCode(CharSequence charSequence, int i10, int i11) {
        CType cType;
        CType findCType;
        CType findCType2 = findCType(charSequence, i10);
        CType cType2 = CType.UNCODABLE;
        if (findCType2 != cType2 && findCType2 != (cType = CType.ONE_DIGIT)) {
            if (i11 == 99) {
                return i11;
            }
            if (i11 == 100) {
                CType cType3 = CType.FNC_1;
                if (findCType2 == cType3) {
                    return i11;
                }
                CType findCType3 = findCType(charSequence, i10 + 2);
                if (findCType3 == cType2 || findCType3 == cType) {
                    return i11;
                }
                if (findCType3 == cType3) {
                    return findCType(charSequence, i10 + 3) == CType.TWO_DIGITS ? 99 : 100;
                }
                int i12 = i10 + 4;
                while (true) {
                    findCType = findCType(charSequence, i12);
                    if (findCType != CType.TWO_DIGITS) {
                        break;
                    }
                    i12 += 2;
                }
                return findCType == CType.ONE_DIGIT ? 100 : 99;
            }
            if (findCType2 == CType.FNC_1) {
                findCType2 = findCType(charSequence, i10 + 1);
            }
            if (findCType2 == CType.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }

    private static CType findCType(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        if (i10 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i10);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i11 = i10 + 1;
        if (i11 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i11);
        return (charAt2 < '0' || charAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length > 0 && length <= 80) {
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                char charAt = str.charAt(i11);
                if (charAt < ' ' || charAt > '~') {
                    switch (charAt) {
                        case 241:
                        case 242:
                        case 243:
                        case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /* 244 */:
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character in input: " + charAt);
                    }
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 1;
            while (i12 < length) {
                int chooseCode = chooseCode(str, i12, i14);
                int i16 = 100;
                if (chooseCode == i14) {
                    switch (str.charAt(i12)) {
                        case 241:
                            i16 = 102;
                            break;
                        case 242:
                            i16 = 97;
                            break;
                        case 243:
                            i16 = 96;
                            break;
                        case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /* 244 */:
                            break;
                        default:
                            if (i14 != 100) {
                                i16 = Integer.parseInt(str.substring(i12, i12 + 2));
                                i12++;
                                break;
                            } else {
                                i16 = str.charAt(i12) - ' ';
                                break;
                            }
                    }
                    i12++;
                } else {
                    i16 = i14 == 0 ? chooseCode == 100 ? 104 : 105 : chooseCode;
                    i14 = chooseCode;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i16]);
                i13 += i16 * i15;
                if (i12 != 0) {
                    i15++;
                }
            }
            int[][] iArr = Code128Reader.CODE_PATTERNS;
            arrayList.add(iArr[i13 % 103]);
            arrayList.add(iArr[106]);
            int i17 = 0;
            for (int[] iArr2 : arrayList) {
                for (int i18 : iArr2) {
                    i17 += i18;
                }
            }
            boolean[] zArr = new boolean[i17];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                i10 += OneDimensionalCodeWriter.appendPattern(zArr, i10, (int[]) it.next(), true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }
}
