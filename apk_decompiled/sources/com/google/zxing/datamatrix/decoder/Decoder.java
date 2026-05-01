package com.google.zxing.datamatrix.decoder;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.ChecksumException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* loaded from: classes2.dex */
public final class Decoder {
    private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);

    private void correctErrors(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & UnsignedBytes.MAX_VALUE;
        }
        try {
            this.rsDecoder.decode(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public DecoderResult decode(boolean[][] zArr) {
        int length = zArr.length;
        BitMatrix bitMatrix = new BitMatrix(length);
        for (int i10 = 0; i10 < length; i10++) {
            for (int i11 = 0; i11 < length; i11++) {
                if (zArr[i10][i11]) {
                    bitMatrix.set(i11, i10);
                }
            }
        }
        return decode(bitMatrix);
    }

    public DecoderResult decode(BitMatrix bitMatrix) {
        BitMatrixParser bitMatrixParser = new BitMatrixParser(bitMatrix);
        DataBlock[] dataBlocks = DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), bitMatrixParser.getVersion());
        int i10 = 0;
        for (DataBlock dataBlock : dataBlocks) {
            i10 += dataBlock.getNumDataCodewords();
        }
        byte[] bArr = new byte[i10];
        int length = dataBlocks.length;
        for (int i11 = 0; i11 < length; i11++) {
            DataBlock dataBlock2 = dataBlocks[i11];
            byte[] codewords = dataBlock2.getCodewords();
            int numDataCodewords = dataBlock2.getNumDataCodewords();
            correctErrors(codewords, numDataCodewords);
            for (int i12 = 0; i12 < numDataCodewords; i12++) {
                bArr[(i12 * length) + i11] = codewords[i12];
            }
        }
        return DecodedBitStreamParser.decode(bArr);
    }
}
