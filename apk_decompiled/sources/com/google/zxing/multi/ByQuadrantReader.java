package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ByQuadrantReader implements Reader {
    private final Reader delegate;

    public ByQuadrantReader(Reader reader) {
        this.delegate = reader;
    }

    private static void makeAbsolute(ResultPoint[] resultPointArr, int i10, int i11) {
        if (resultPointArr != null) {
            for (int i12 = 0; i12 < resultPointArr.length; i12++) {
                ResultPoint resultPoint = resultPointArr[i12];
                resultPointArr[i12] = new ResultPoint(resultPoint.getX() + i10, resultPoint.getY() + i11);
            }
        }
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        this.delegate.reset();
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) {
        int width = binaryBitmap.getWidth() / 2;
        int height = binaryBitmap.getHeight() / 2;
        try {
            try {
                try {
                    try {
                        return this.delegate.decode(binaryBitmap.crop(0, 0, width, height), map);
                    } catch (NotFoundException unused) {
                        int i10 = width / 2;
                        int i11 = height / 2;
                        Result decode = this.delegate.decode(binaryBitmap.crop(i10, i11, width, height), map);
                        makeAbsolute(decode.getResultPoints(), i10, i11);
                        return decode;
                    }
                } catch (NotFoundException unused2) {
                    Result decode2 = this.delegate.decode(binaryBitmap.crop(width, height, width, height), map);
                    makeAbsolute(decode2.getResultPoints(), width, height);
                    return decode2;
                }
            } catch (NotFoundException unused3) {
                Result decode3 = this.delegate.decode(binaryBitmap.crop(0, height, width, height), map);
                makeAbsolute(decode3.getResultPoints(), 0, height);
                return decode3;
            }
        } catch (NotFoundException unused4) {
            Result decode4 = this.delegate.decode(binaryBitmap.crop(width, 0, width, height), map);
            makeAbsolute(decode4.getResultPoints(), width, 0);
            return decode4;
        }
    }
}
