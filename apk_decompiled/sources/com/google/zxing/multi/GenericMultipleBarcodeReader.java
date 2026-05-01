package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i10, int i11, int i12) {
        boolean z10;
        float f10;
        float f11;
        int i13;
        int i14;
        int i15;
        int i16;
        if (i12 > 4) {
            return;
        }
        try {
            Result decode = this.delegate.decode(binaryBitmap, map);
            Iterator<Result> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getText().equals(decode.getText())) {
                        z10 = true;
                        break;
                    }
                } else {
                    z10 = false;
                    break;
                }
            }
            if (!z10) {
                list.add(translateResultPoints(decode, i10, i11));
            }
            ResultPoint[] resultPoints = decode.getResultPoints();
            if (resultPoints == null || resultPoints.length == 0) {
                return;
            }
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            float f12 = width;
            float f13 = height;
            float f14 = 0.0f;
            float f15 = 0.0f;
            for (ResultPoint resultPoint : resultPoints) {
                if (resultPoint != null) {
                    float x10 = resultPoint.getX();
                    float y10 = resultPoint.getY();
                    if (x10 < f12) {
                        f12 = x10;
                    }
                    if (y10 < f13) {
                        f13 = y10;
                    }
                    if (x10 > f14) {
                        f14 = x10;
                    }
                    if (y10 > f15) {
                        f15 = y10;
                    }
                }
            }
            if (f12 > 100.0f) {
                f10 = f14;
                f11 = f13;
                i13 = height;
                i14 = width;
                doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f12, height), map, list, i10, i11, i12 + 1);
            } else {
                f10 = f14;
                f11 = f13;
                i13 = height;
                i14 = width;
            }
            if (f11 > 100.0f) {
                int i17 = (int) f11;
                i15 = i14;
                doDecodeMultiple(binaryBitmap.crop(0, 0, i15, i17), map, list, i10, i11, i12 + 1);
            } else {
                i15 = i14;
            }
            float f16 = f10;
            if (f16 < i15 - 100) {
                int i18 = (int) f16;
                i16 = i13;
                doDecodeMultiple(binaryBitmap.crop(i18, 0, i15 - i18, i16), map, list, i10 + i18, i11, i12 + 1);
            } else {
                i16 = i13;
            }
            if (f15 < i16 - 100) {
                int i19 = (int) f15;
                doDecodeMultiple(binaryBitmap.crop(0, i19, i15, i16 - i19), map, list, i10, i11 + i19, i12 + 1);
            }
        } catch (ReaderException unused) {
        }
    }

    private static Result translateResultPoints(Result result, int i10, int i11) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i12 = 0; i12 < resultPoints.length; i12++) {
            ResultPoint resultPoint = resultPoints[i12];
            if (resultPoint != null) {
                resultPointArr[i12] = new ResultPoint(resultPoint.getX() + i10, resultPoint.getY() + i11);
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
    }
}
