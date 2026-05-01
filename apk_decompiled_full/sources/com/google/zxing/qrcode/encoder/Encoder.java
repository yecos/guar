package com.google.zxing.qrcode.encoder;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    /* renamed from: com.google.zxing.qrcode.encoder.Encoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private Encoder() {
    }

    public static void append8BitBytes(String str, BitArray bitArray, String str2) {
        try {
            for (byte b10 : str.getBytes(str2)) {
                bitArray.appendBits(b10, 8);
            }
        } catch (UnsupportedEncodingException e10) {
            throw new WriterException(e10);
        }
    }

    public static void appendAlphanumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i10));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            int i11 = i10 + 1;
            if (i11 < length) {
                int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i11));
                if (alphanumericCode2 == -1) {
                    throw new WriterException();
                }
                bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i10 += 2;
            } else {
                bitArray.appendBits(alphanumericCode, 6);
                i10 = i11;
            }
        }
    }

    public static void appendBytes(String str, Mode mode, BitArray bitArray, String str2) {
        int i10 = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode.ordinal()];
        if (i10 == 1) {
            appendNumericBytes(str, bitArray);
            return;
        }
        if (i10 == 2) {
            appendAlphanumericBytes(str, bitArray);
            return;
        }
        if (i10 == 3) {
            append8BitBytes(str, bitArray, str2);
        } else if (i10 == 4) {
            appendKanjiBytes(str, bitArray);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    private static void appendECI(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[LOOP:0: B:4:0x0008->B:11:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void appendKanjiBytes(String str, BitArray bitArray) {
        int i10;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i11 = 0; i11 < length; i11 += 2) {
                int i12 = ((bytes[i11] & UnsignedBytes.MAX_VALUE) << 8) | (bytes[i11 + 1] & UnsignedBytes.MAX_VALUE);
                int i13 = 33088;
                if (i12 < 33088 || i12 > 40956) {
                    if (i12 < 57408 || i12 > 60351) {
                        i10 = -1;
                        if (i10 != -1) {
                            throw new WriterException("Invalid byte sequence");
                        }
                        bitArray.appendBits(((i10 >> 8) * 192) + (i10 & 255), 13);
                    } else {
                        i13 = 49472;
                    }
                }
                i10 = i12 - i13;
                if (i10 != -1) {
                }
            }
        } catch (UnsupportedEncodingException e10) {
            throw new WriterException(e10);
        }
    }

    public static void appendLengthInfo(int i10, Version version, Mode mode, BitArray bitArray) {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i11 = 1 << characterCountBits;
        if (i10 < i11) {
            bitArray.appendBits(i10, characterCountBits);
            return;
        }
        throw new WriterException(i10 + " is bigger than " + (i11 - 1));
    }

    public static void appendModeInfo(Mode mode, BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    public static void appendNumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int charAt = charSequence.charAt(i10) - '0';
            int i11 = i10 + 2;
            if (i11 < length) {
                bitArray.appendBits((charAt * 100) + ((charSequence.charAt(i10 + 1) - '0') * 10) + (charSequence.charAt(i11) - '0'), 10);
                i10 += 3;
            } else {
                i10++;
                if (i10 < length) {
                    bitArray.appendBits((charAt * 10) + (charSequence.charAt(i10) - '0'), 7);
                    i10 = i11;
                } else {
                    bitArray.appendBits(charAt, 4);
                }
            }
        }
    }

    private static int calculateBitsNeeded(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        return bitArray.getSize() + mode.getCharacterCountBits(version) + bitArray2.getSize();
    }

    private static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    private static int chooseMaskPattern(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) {
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12++) {
            MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i12, byteMatrix);
            int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (calculateMaskPenalty < i10) {
                i11 = i12;
                i10 = calculateMaskPenalty;
            }
        }
        return i11;
    }

    public static Mode chooseMode(String str) {
        return chooseMode(str, null);
    }

    private static Version chooseVersion(int i10, ErrorCorrectionLevel errorCorrectionLevel) {
        for (int i11 = 1; i11 <= 40; i11++) {
            Version versionForNumber = Version.getVersionForNumber(i11);
            if (willFit(i10, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel) {
        return encode(str, errorCorrectionLevel, null);
    }

    public static byte[] generateECBytes(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length + i10];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & UnsignedBytes.MAX_VALUE;
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, i10);
        byte[] bArr2 = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = (byte) iArr[length + i12];
        }
        return bArr2;
    }

    public static int getAlphanumericCode(int i10) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    public static void getNumDataBytesAndNumECBytesForBlockID(int i10, int i11, int i12, int i13, int[] iArr, int[] iArr2) {
        if (i13 >= i12) {
            throw new WriterException("Block ID too large");
        }
        int i14 = i10 % i12;
        int i15 = i12 - i14;
        int i16 = i10 / i12;
        int i17 = i16 + 1;
        int i18 = i11 / i12;
        int i19 = i18 + 1;
        int i20 = i16 - i18;
        int i21 = i17 - i19;
        if (i20 != i21) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i12 != i15 + i14) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i10 != ((i18 + i20) * i15) + ((i19 + i21) * i14)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i13 < i15) {
            iArr[0] = i18;
            iArr2[0] = i20;
        } else {
            iArr[0] = i19;
            iArr2[0] = i21;
        }
    }

    public static BitArray interleaveWithECBytes(BitArray bitArray, int i10, int i11, int i12) {
        if (bitArray.getSizeInBytes() != i11) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i12);
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < i12; i16++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            getNumDataBytesAndNumECBytesForBlockID(i10, i11, i12, i16, iArr, iArr2);
            int i17 = iArr[0];
            byte[] bArr = new byte[i17];
            bitArray.toBytes(i13 << 3, bArr, 0, i17);
            byte[] generateECBytes = generateECBytes(bArr, iArr2[0]);
            arrayList.add(new BlockPair(bArr, generateECBytes));
            i14 = Math.max(i14, i17);
            i15 = Math.max(i15, generateECBytes.length);
            i13 += iArr[0];
        }
        if (i11 != i13) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray2 = new BitArray();
        for (int i18 = 0; i18 < i14; i18++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] dataBytes = ((BlockPair) it.next()).getDataBytes();
                if (i18 < dataBytes.length) {
                    bitArray2.appendBits(dataBytes[i18], 8);
                }
            }
        }
        for (int i19 = 0; i19 < i15; i19++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] errorCorrectionBytes = ((BlockPair) it2.next()).getErrorCorrectionBytes();
                if (i19 < errorCorrectionBytes.length) {
                    bitArray2.appendBits(errorCorrectionBytes[i19], 8);
                }
            }
        }
        if (i10 == bitArray2.getSizeInBytes()) {
            return bitArray2;
        }
        throw new WriterException("Interleaving error: " + i10 + " and " + bitArray2.getSizeInBytes() + " differ.");
    }

    private static boolean isOnlyDoubleByteKanji(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i10 = 0; i10 < length; i10 += 2) {
                int i11 = bytes[i10] & UnsignedBytes.MAX_VALUE;
                if ((i11 < 129 || i11 > 159) && (i11 < 224 || i11 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static Version recommendVersion(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, BitArray bitArray, BitArray bitArray2) {
        return chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void terminateBits(int i10, BitArray bitArray) {
        int i11 = i10 << 3;
        if (bitArray.getSize() > i11) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i11);
        }
        for (int i12 = 0; i12 < 4 && bitArray.getSize() < i11; i12++) {
            bitArray.appendBit(false);
        }
        int size = bitArray.getSize() & 7;
        if (size > 0) {
            while (size < 8) {
                bitArray.appendBit(false);
                size++;
            }
        }
        int sizeInBytes = i10 - bitArray.getSizeInBytes();
        for (int i13 = 0; i13 < sizeInBytes; i13++) {
            bitArray.appendBits((i13 & 1) == 0 ? 236 : 17, 8);
        }
        if (bitArray.getSize() != i11) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    private static boolean willFit(int i10, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i10 + 7) / 8;
    }

    private static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2) && isOnlyDoubleByteKanji(str)) {
            return Mode.KANJI;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt >= '0' && charAt <= '9') {
                z11 = true;
            } else {
                if (getAlphanumericCode(charAt) == -1) {
                    return Mode.BYTE;
                }
                z10 = true;
            }
        }
        return z10 ? Mode.ALPHANUMERIC : z11 ? Mode.NUMERIC : Mode.BYTE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) {
        String str2;
        Mode chooseMode;
        BitArray bitArray;
        Mode mode;
        Version recommendVersion;
        CharacterSetECI characterSetECIByName;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType)) {
                str2 = map.get(encodeHintType).toString();
                chooseMode = chooseMode(str, str2);
                bitArray = new BitArray();
                mode = Mode.BYTE;
                if (chooseMode == mode && !DEFAULT_BYTE_MODE_ENCODING.equals(str2) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(str2)) != null) {
                    appendECI(characterSetECIByName, bitArray);
                }
                appendModeInfo(chooseMode, bitArray);
                BitArray bitArray2 = new BitArray();
                appendBytes(str, chooseMode, bitArray2, str2);
                if (map != null) {
                    EncodeHintType encodeHintType2 = EncodeHintType.QR_VERSION;
                    if (map.containsKey(encodeHintType2)) {
                        recommendVersion = Version.getVersionForNumber(Integer.parseInt(map.get(encodeHintType2).toString()));
                        if (!willFit(calculateBitsNeeded(chooseMode, bitArray, bitArray2, recommendVersion), recommendVersion, errorCorrectionLevel)) {
                            throw new WriterException("Data too big for requested version");
                        }
                        BitArray bitArray3 = new BitArray();
                        bitArray3.appendBitArray(bitArray);
                        appendLengthInfo(chooseMode == mode ? bitArray2.getSizeInBytes() : str.length(), recommendVersion, chooseMode, bitArray3);
                        bitArray3.appendBitArray(bitArray2);
                        Version.ECBlocks eCBlocksForLevel = recommendVersion.getECBlocksForLevel(errorCorrectionLevel);
                        int totalCodewords = recommendVersion.getTotalCodewords() - eCBlocksForLevel.getTotalECCodewords();
                        terminateBits(totalCodewords, bitArray3);
                        BitArray interleaveWithECBytes = interleaveWithECBytes(bitArray3, recommendVersion.getTotalCodewords(), totalCodewords, eCBlocksForLevel.getNumBlocks());
                        QRCode qRCode = new QRCode();
                        qRCode.setECLevel(errorCorrectionLevel);
                        qRCode.setMode(chooseMode);
                        qRCode.setVersion(recommendVersion);
                        int dimensionForVersion = recommendVersion.getDimensionForVersion();
                        ByteMatrix byteMatrix = new ByteMatrix(dimensionForVersion, dimensionForVersion);
                        int chooseMaskPattern = chooseMaskPattern(interleaveWithECBytes, errorCorrectionLevel, recommendVersion, byteMatrix);
                        qRCode.setMaskPattern(chooseMaskPattern);
                        MatrixUtil.buildMatrix(interleaveWithECBytes, errorCorrectionLevel, recommendVersion, chooseMaskPattern, byteMatrix);
                        qRCode.setMatrix(byteMatrix);
                        return qRCode;
                    }
                }
                recommendVersion = recommendVersion(errorCorrectionLevel, chooseMode, bitArray, bitArray2);
                BitArray bitArray32 = new BitArray();
                bitArray32.appendBitArray(bitArray);
                appendLengthInfo(chooseMode == mode ? bitArray2.getSizeInBytes() : str.length(), recommendVersion, chooseMode, bitArray32);
                bitArray32.appendBitArray(bitArray2);
                Version.ECBlocks eCBlocksForLevel2 = recommendVersion.getECBlocksForLevel(errorCorrectionLevel);
                int totalCodewords2 = recommendVersion.getTotalCodewords() - eCBlocksForLevel2.getTotalECCodewords();
                terminateBits(totalCodewords2, bitArray32);
                BitArray interleaveWithECBytes2 = interleaveWithECBytes(bitArray32, recommendVersion.getTotalCodewords(), totalCodewords2, eCBlocksForLevel2.getNumBlocks());
                QRCode qRCode2 = new QRCode();
                qRCode2.setECLevel(errorCorrectionLevel);
                qRCode2.setMode(chooseMode);
                qRCode2.setVersion(recommendVersion);
                int dimensionForVersion2 = recommendVersion.getDimensionForVersion();
                ByteMatrix byteMatrix2 = new ByteMatrix(dimensionForVersion2, dimensionForVersion2);
                int chooseMaskPattern2 = chooseMaskPattern(interleaveWithECBytes2, errorCorrectionLevel, recommendVersion, byteMatrix2);
                qRCode2.setMaskPattern(chooseMaskPattern2);
                MatrixUtil.buildMatrix(interleaveWithECBytes2, errorCorrectionLevel, recommendVersion, chooseMaskPattern2, byteMatrix2);
                qRCode2.setMatrix(byteMatrix2);
                return qRCode2;
            }
        }
        str2 = DEFAULT_BYTE_MODE_ENCODING;
        chooseMode = chooseMode(str, str2);
        bitArray = new BitArray();
        mode = Mode.BYTE;
        if (chooseMode == mode) {
            appendECI(characterSetECIByName, bitArray);
        }
        appendModeInfo(chooseMode, bitArray);
        BitArray bitArray22 = new BitArray();
        appendBytes(str, chooseMode, bitArray22, str2);
        if (map != null) {
        }
        recommendVersion = recommendVersion(errorCorrectionLevel, chooseMode, bitArray, bitArray22);
        BitArray bitArray322 = new BitArray();
        bitArray322.appendBitArray(bitArray);
        appendLengthInfo(chooseMode == mode ? bitArray22.getSizeInBytes() : str.length(), recommendVersion, chooseMode, bitArray322);
        bitArray322.appendBitArray(bitArray22);
        Version.ECBlocks eCBlocksForLevel22 = recommendVersion.getECBlocksForLevel(errorCorrectionLevel);
        int totalCodewords22 = recommendVersion.getTotalCodewords() - eCBlocksForLevel22.getTotalECCodewords();
        terminateBits(totalCodewords22, bitArray322);
        BitArray interleaveWithECBytes22 = interleaveWithECBytes(bitArray322, recommendVersion.getTotalCodewords(), totalCodewords22, eCBlocksForLevel22.getNumBlocks());
        QRCode qRCode22 = new QRCode();
        qRCode22.setECLevel(errorCorrectionLevel);
        qRCode22.setMode(chooseMode);
        qRCode22.setVersion(recommendVersion);
        int dimensionForVersion22 = recommendVersion.getDimensionForVersion();
        ByteMatrix byteMatrix22 = new ByteMatrix(dimensionForVersion22, dimensionForVersion22);
        int chooseMaskPattern22 = chooseMaskPattern(interleaveWithECBytes22, errorCorrectionLevel, recommendVersion, byteMatrix22);
        qRCode22.setMaskPattern(chooseMaskPattern22);
        MatrixUtil.buildMatrix(interleaveWithECBytes22, errorCorrectionLevel, recommendVersion, chooseMaskPattern22, byteMatrix22);
        qRCode22.setMatrix(byteMatrix22);
        return qRCode22;
    }
}
