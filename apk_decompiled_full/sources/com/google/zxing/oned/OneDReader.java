package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class OneDReader implements Reader {
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
    
        r3 = r22.getBlackRow(r11, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e1, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007d A[Catch: ReaderException -> 0x00c6, TryCatch #0 {ReaderException -> 0x00c6, blocks: (B:37:0x0077, B:39:0x007d, B:41:0x008e), top: B:36:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) {
        int i10;
        int i11;
        int i12;
        OneDReader oneDReader;
        Map<DecodeHintType, ?> map2;
        int i13;
        Map<DecodeHintType, ?> map3 = map;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray = new BitArray(width);
        int i14 = height >> 1;
        char c10 = 0;
        int i15 = 1;
        boolean z10 = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int max = Math.max(1, height >> (z10 ? 8 : 5));
        int i16 = z10 ? height : 15;
        int i17 = 0;
        while (i17 < i16) {
            i10 = i17 + 1;
            int i18 = i10 / 2;
            if (!((i17 & 1) == 0)) {
                i18 = -i18;
            }
            i11 = (i18 * max) + i14;
            if (i11 < 0 || i11 >= height) {
                break;
            }
            i17 = i10;
            width = width;
            c10 = 0;
            i15 = 1;
        }
        throw NotFoundException.getNotFoundInstance();
        while (i12 < 2) {
            try {
                if (i12 == i15) {
                    bitArray.reverse();
                    if (map3 != null) {
                        DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                        if (map3.containsKey(decodeHintType)) {
                            EnumMap enumMap = new EnumMap(DecodeHintType.class);
                            enumMap.putAll(map3);
                            enumMap.remove(decodeHintType);
                            oneDReader = this;
                            map3 = enumMap;
                            Result decodeRow = oneDReader.decodeRow(i11, bitArray, map3);
                            if (i12 != i15) {
                                decodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                                ResultPoint[] resultPoints = decodeRow.getResultPoints();
                                if (resultPoints != null) {
                                    map2 = map3;
                                    float f10 = width;
                                    try {
                                        i13 = width;
                                        try {
                                            resultPoints[0] = new ResultPoint((f10 - resultPoints[c10].getX()) - 1.0f, resultPoints[c10].getY());
                                            try {
                                                resultPoints[1] = new ResultPoint((f10 - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                            } catch (ReaderException unused) {
                                                continue;
                                                i12++;
                                                map3 = map2;
                                                width = i13;
                                                c10 = 0;
                                                i15 = 1;
                                            }
                                        } catch (ReaderException unused2) {
                                            i12++;
                                            map3 = map2;
                                            width = i13;
                                            c10 = 0;
                                            i15 = 1;
                                        }
                                    } catch (ReaderException unused3) {
                                        i13 = width;
                                        i12++;
                                        map3 = map2;
                                        width = i13;
                                        c10 = 0;
                                        i15 = 1;
                                    }
                                }
                            }
                            return decodeRow;
                        }
                    }
                }
                Result decodeRow2 = oneDReader.decodeRow(i11, bitArray, map3);
                if (i12 != i15) {
                }
                return decodeRow2;
            } catch (ReaderException unused4) {
                map2 = map3;
            }
            oneDReader = this;
        }
        continue;
        i17 = i10;
        width = width;
        c10 = 0;
        i15 = 1;
    }

    public static float patternMatchVariance(int[] iArr, int[] iArr2, float f10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f11 = i10;
        float f12 = f11 / i11;
        float f13 = f10 * f12;
        float f14 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f15 = iArr2[i13] * f12;
            float f16 = iArr[i13];
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }

    public static void recordPattern(BitArray bitArray, int i10, int[] iArr) {
        int length = iArr.length;
        int i11 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i10 >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z10 = !bitArray.get(i10);
        while (i10 < size) {
            if (!(bitArray.get(i10) ^ z10)) {
                i11++;
                if (i11 == length) {
                    break;
                }
                iArr[i11] = 1;
                z10 = !z10;
            } else {
                iArr[i11] = iArr[i11] + 1;
            }
            i10++;
        }
        if (i11 != length) {
            if (i11 != length - 1 || i10 != size) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public static void recordPatternInReverse(BitArray bitArray, int i10, int[] iArr) {
        int length = iArr.length;
        boolean z10 = bitArray.get(i10);
        while (i10 > 0 && length >= 0) {
            i10--;
            if (bitArray.get(i10) != z10) {
                length--;
                z10 = !z10;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, i10 + 1, iArr);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) {
        return decode(binaryBitmap, null);
    }

    public abstract Result decodeRow(int i10, BitArray bitArray, Map<DecodeHintType, ?> map);

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) {
        try {
            return doDecode(binaryBitmap, map);
        } catch (NotFoundException e10) {
            if (!(map != null && map.containsKey(DecodeHintType.TRY_HARDER)) || !binaryBitmap.isRotateSupported()) {
                throw e10;
            }
            BinaryBitmap rotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
            Result doDecode = doDecode(rotateCounterClockwise, map);
            Map<ResultMetadataType, Object> resultMetadata = doDecode.getResultMetadata();
            int i10 = 270;
            if (resultMetadata != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (resultMetadata.containsKey(resultMetadataType)) {
                    i10 = (((Integer) resultMetadata.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            doDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i10));
            ResultPoint[] resultPoints = doDecode.getResultPoints();
            if (resultPoints != null) {
                int height = rotateCounterClockwise.getHeight();
                for (int i11 = 0; i11 < resultPoints.length; i11++) {
                    resultPoints[i11] = new ResultPoint((height - resultPoints[i11].getY()) - 1.0f, resultPoints[i11].getX());
                }
            }
            return doDecode;
        }
    }
}
