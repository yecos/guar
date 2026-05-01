package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int decodeCode(BitArray bitArray, int[] iArr, int i10) {
        OneDReader.recordPattern(bitArray, i10, iArr);
        float f10 = MAX_AVG_VARIANCE;
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[][] iArr2 = CODE_PATTERNS;
            if (i12 >= iArr2.length) {
                break;
            }
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, iArr2[i12], 0.7f);
            if (patternMatchVariance < f10) {
                i11 = i12;
                f10 = patternMatchVariance;
            }
            i12++;
        }
        if (i11 >= 0) {
            return i11;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int[] findStartPattern(BitArray bitArray) {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        int i10 = nextSet;
        boolean z10 = false;
        int i11 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) ^ z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 == 5) {
                    int i12 = -1;
                    float f10 = MAX_AVG_VARIANCE;
                    for (int i13 = 103; i13 <= 105; i13++) {
                        float patternMatchVariance = OneDReader.patternMatchVariance(iArr, CODE_PATTERNS[i13], 0.7f);
                        if (patternMatchVariance < f10) {
                            i12 = i13;
                            f10 = patternMatchVariance;
                        }
                    }
                    if (i12 >= 0 && bitArray.isRange(Math.max(0, i10 - ((nextSet - i10) / 2)), i10, false)) {
                        return new int[]{i10, nextSet, i12};
                    }
                    i10 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, 4);
                    iArr[4] = 0;
                    iArr[5] = 0;
                    i11--;
                } else {
                    i11++;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e1, code lost:
    
        if (r9 != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0129, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0127, code lost:
    
        if (r9 != false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012e A[PHI: r17
      0x012e: PHI (r17v10 boolean) = (r17v6 boolean), (r17v17 boolean) binds: [B:78:0x0107, B:51:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013a A[PHI: r16 r17
      0x013a: PHI (r16v4 boolean) = 
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v3 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
     binds: [B:78:0x0107, B:79:0x010b, B:83:0x0117, B:82:0x0113, B:70:0x0138, B:51:0x00c1, B:52:0x00c6, B:56:0x00d3, B:55:0x00ce] A[DONT_GENERATE, DONT_INLINE]
      0x013a: PHI (r17v9 boolean) = 
      (r17v6 boolean)
      (r17v6 boolean)
      (r17v6 boolean)
      (r17v6 boolean)
      (r17v8 boolean)
      (r17v17 boolean)
      (r17v17 boolean)
      (r17v17 boolean)
      (r17v17 boolean)
     binds: [B:78:0x0107, B:79:0x010b, B:83:0x0117, B:82:0x0113, B:70:0x0138, B:51:0x00c1, B:52:0x00c6, B:56:0x00d3, B:55:0x00ce] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.zxing.oned.OneDReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result decodeRow(int i10, BitArray bitArray, Map<DecodeHintType, ?> map) {
        char c10;
        boolean z10;
        boolean z11 = false;
        boolean z12 = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
        int[] findStartPattern = findStartPattern(bitArray);
        int i11 = findStartPattern[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i11));
        switch (i11) {
            case 103:
                c10 = 'e';
                break;
            case 104:
                c10 = 'd';
                break;
            case 105:
                c10 = 'c';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        StringBuilder sb = new StringBuilder(20);
        int i12 = 6;
        int[] iArr = new int[6];
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = true;
        boolean z16 = false;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        char c11 = c10;
        int i16 = findStartPattern[0];
        int i17 = findStartPattern[1];
        char c12 = c11;
        while (!z14) {
            int decodeCode = decodeCode(bitArray, iArr, i17);
            arrayList.add(Byte.valueOf((byte) decodeCode));
            if (decodeCode != 106) {
                z15 = true;
            }
            if (decodeCode != 106) {
                i14++;
                i11 += i14 * decodeCode;
            }
            int i18 = i17;
            for (int i19 = 0; i19 < i12; i19++) {
                i18 += iArr[i19];
            }
            switch (decodeCode) {
                case 103:
                case 104:
                case 105:
                    throw FormatException.getFormatInstance();
                default:
                    switch (c12) {
                        case 'c':
                            if (decodeCode >= 100) {
                                if (decodeCode != 106) {
                                    z15 = false;
                                }
                                if (decodeCode != 106) {
                                    switch (decodeCode) {
                                        case 100:
                                            z10 = false;
                                            c12 = 'd';
                                            break;
                                        case 101:
                                            z10 = false;
                                            c12 = 'e';
                                            break;
                                        case 102:
                                            if (z12) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append((char) 29);
                                                }
                                            }
                                        default:
                                            z10 = false;
                                            break;
                                    }
                                } else {
                                    z10 = false;
                                    z14 = true;
                                    break;
                                }
                            } else {
                                if (decodeCode < 10) {
                                    sb.append('0');
                                }
                                sb.append(decodeCode);
                            }
                            z10 = false;
                        case 'd':
                            if (decodeCode < 96) {
                                if (z13 == z11) {
                                    sb.append((char) (decodeCode + 32));
                                } else {
                                    sb.append((char) (decodeCode + 32 + 128));
                                }
                                z10 = false;
                                z13 = false;
                                break;
                            } else {
                                if (decodeCode != 106) {
                                    z15 = false;
                                }
                                if (decodeCode != 106) {
                                    switch (decodeCode) {
                                        case 96:
                                        case 97:
                                        default:
                                            z10 = false;
                                            break;
                                        case 98:
                                            z10 = true;
                                            c12 = 'e';
                                            break;
                                        case 99:
                                            z10 = false;
                                            c12 = 'c';
                                            break;
                                        case 100:
                                            if (z11 || !z13) {
                                                if (z11) {
                                                }
                                                z10 = false;
                                                z13 = true;
                                                break;
                                            }
                                            z11 = true;
                                            z10 = false;
                                            z13 = false;
                                            break;
                                        case 101:
                                            z10 = false;
                                            c12 = 'e';
                                            break;
                                        case 102:
                                            if (z12) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append((char) 29);
                                                }
                                            }
                                            z10 = false;
                                            break;
                                    }
                                }
                                z14 = true;
                                z10 = false;
                            }
                            break;
                        case 'e':
                            if (decodeCode < 64) {
                                if (z13 == z11) {
                                    sb.append((char) (decodeCode + 32));
                                } else {
                                    sb.append((char) (decodeCode + 32 + 128));
                                }
                            } else if (decodeCode >= 96) {
                                if (decodeCode != 106) {
                                    z15 = false;
                                }
                                if (decodeCode != 106) {
                                    switch (decodeCode) {
                                        case 98:
                                            z10 = true;
                                            c12 = 'd';
                                            break;
                                        case 100:
                                            z10 = false;
                                            c12 = 'd';
                                            break;
                                        case 101:
                                            if (z11 || !z13) {
                                                if (z11) {
                                                }
                                                z10 = false;
                                                z13 = true;
                                                break;
                                            }
                                            z11 = true;
                                            break;
                                        case 102:
                                            if (z12) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append((char) 29);
                                                }
                                            }
                                            z10 = false;
                                            break;
                                    }
                                }
                                z14 = true;
                                z10 = false;
                            } else if (z13 == z11) {
                                sb.append((char) (decodeCode - 64));
                            } else {
                                sb.append((char) (decodeCode + 64));
                            }
                            z10 = false;
                            z13 = false;
                            break;
                        default:
                            z10 = false;
                            break;
                    }
                    if (z16) {
                        c12 = c12 == 'e' ? 'd' : 'e';
                    }
                    z16 = z10;
                    i12 = 6;
                    i16 = i17;
                    i17 = i18;
                    i15 = i13;
                    i13 = decodeCode;
                    break;
            }
            while (!z14) {
            }
        }
        int i20 = i17 - i16;
        int nextUnset = bitArray.getNextUnset(i17);
        if (!bitArray.isRange(nextUnset, Math.min(bitArray.getSize(), ((nextUnset - i16) / 2) + nextUnset), false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i21 = i15;
        if ((i11 - (i14 * i21)) % 103 != i21) {
            throw ChecksumException.getChecksumInstance();
        }
        int length = sb.length();
        if (length == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (length > 0 && z15) {
            if (c12 == 'c') {
                sb.delete(length - 2, length);
            } else {
                sb.delete(length - 1, length);
            }
        }
        float f10 = (findStartPattern[1] + findStartPattern[0]) / 2.0f;
        float f11 = i16 + (i20 / 2.0f);
        int size = arrayList.size();
        byte[] bArr = new byte[size];
        for (int i22 = 0; i22 < size; i22++) {
            bArr[i22] = ((Byte) arrayList.get(i22)).byteValue();
        }
        float f12 = i10;
        return new Result(sb.toString(), bArr, new ResultPoint[]{new ResultPoint(f10, f12), new ResultPoint(f11, f12)}, BarcodeFormat.CODE_128);
    }
}
