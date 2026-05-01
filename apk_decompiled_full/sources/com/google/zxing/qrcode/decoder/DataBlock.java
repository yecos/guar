package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version;

/* loaded from: classes2.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i10, byte[] bArr) {
        this.numDataCodewords = i10;
        this.codewords = bArr;
    }

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int i10 = 0;
        for (Version.ECB ecb : eCBlocks) {
            i10 += ecb.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i10];
        int i11 = 0;
        for (Version.ECB ecb2 : eCBlocks) {
            int i12 = 0;
            while (i12 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i11] = new DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                i12++;
                i11++;
            }
        }
        int length = dataBlockArr[0].codewords.length;
        int i13 = i10 - 1;
        while (i13 >= 0 && dataBlockArr[i13].codewords.length != length) {
            i13--;
        }
        int i14 = i13 + 1;
        int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
        int i15 = 0;
        for (int i16 = 0; i16 < eCCodewordsPerBlock; i16++) {
            int i17 = 0;
            while (i17 < i11) {
                dataBlockArr[i17].codewords[i16] = bArr[i15];
                i17++;
                i15++;
            }
        }
        int i18 = i14;
        while (i18 < i11) {
            dataBlockArr[i18].codewords[eCCodewordsPerBlock] = bArr[i15];
            i18++;
            i15++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (eCCodewordsPerBlock < length2) {
            int i19 = 0;
            while (i19 < i11) {
                dataBlockArr[i19].codewords[i19 < i14 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i15];
                i19++;
                i15++;
            }
            eCCodewordsPerBlock++;
        }
        return dataBlockArr;
    }

    public byte[] getCodewords() {
        return this.codewords;
    }

    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
