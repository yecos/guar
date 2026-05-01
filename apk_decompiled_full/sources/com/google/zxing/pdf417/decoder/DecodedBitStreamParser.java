package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i10 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i10 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i10] = bigIntegerArr2[i10 - 1].multiply(valueOf);
            i10++;
        }
    }

    private DecodedBitStreamParser() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r7 >= 6) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        r1.write((byte) (r18 >> ((5 - r7) * 8)));
        r7 = r7 + 1;
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.MACRO_PDF417_TERMINATOR;
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int byteCompaction(int i10, int[] iArr, Charset charset, int i11, StringBuilder sb) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i17 = MACRO_PDF417_TERMINATOR;
        int i18 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
        int i19 = 928;
        int i20 = 902;
        long j10 = 900;
        if (i10 == 901) {
            int[] iArr2 = new int[6];
            i12 = i11 + 1;
            int i21 = iArr[i11];
            boolean z10 = false;
            loop0: while (true) {
                i13 = 0;
                long j11 = 0;
                while (true) {
                    i14 = iArr[0];
                    if (i12 >= i14 || z10) {
                        break loop0;
                    }
                    int i22 = i13 + 1;
                    iArr2[i13] = i21;
                    j11 = (j11 * j10) + i21;
                    i16 = i12 + 1;
                    i21 = iArr[i12];
                    if (i21 == 900 || i21 == 901 || i21 == 902 || i21 == BYTE_COMPACTION_MODE_LATCH_6 || i21 == 928 || i21 == i18 || i21 == i17) {
                        i12 = i16 - 1;
                        i13 = i22;
                        i17 = MACRO_PDF417_TERMINATOR;
                        i18 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                        j10 = 900;
                        z10 = true;
                    } else {
                        if (i22 % 5 == 0 && i22 > 0) {
                            break;
                        }
                        i12 = i16;
                        i13 = i22;
                        i17 = MACRO_PDF417_TERMINATOR;
                        i18 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                        j10 = 900;
                    }
                }
                i12 = i16;
                j10 = 900;
            }
            if (i12 != i14 || i21 >= 900) {
                i15 = i13;
            } else {
                i15 = i13 + 1;
                iArr2[i13] = i21;
            }
            for (int i23 = 0; i23 < i15; i23++) {
                byteArrayOutputStream.write((byte) iArr2[i23]);
            }
        } else if (i10 == BYTE_COMPACTION_MODE_LATCH_6) {
            int i24 = i11;
            boolean z11 = false;
            int i25 = 0;
            long j12 = 0;
            while (i24 < iArr[0] && !z11) {
                int i26 = i24 + 1;
                int i27 = iArr[i24];
                if (i27 < 900) {
                    i25++;
                    j12 = (j12 * 900) + i27;
                    i24 = i26;
                } else {
                    if (i27 != 900 && i27 != 901 && i27 != i20 && i27 != BYTE_COMPACTION_MODE_LATCH_6 && i27 != i19) {
                        if (i27 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD && i27 != MACRO_PDF417_TERMINATOR) {
                            i24 = i26;
                        }
                    }
                    i24 = i26 - 1;
                    z11 = true;
                }
                if (i25 % 5 == 0 && i25 > 0) {
                    for (int i28 = 0; i28 < 6; i28++) {
                        byteArrayOutputStream.write((byte) (j12 >> ((5 - i28) * 8)));
                    }
                    i25 = 0;
                    j12 = 0;
                }
                i19 = 928;
                i20 = 902;
            }
            i12 = i24;
        } else {
            i12 = i11;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i12;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DecoderResult decode(int[] iArr, String str) {
        int i10;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charset = DEFAULT_ENCODING;
        int i11 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        int i12 = 2;
        while (i12 < iArr[0]) {
            if (i11 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                switch (i11) {
                    case 900:
                        i10 = textCompaction(iArr, i12, sb);
                        break;
                    case 901:
                        i10 = byteCompaction(i11, iArr, charset, i12, sb);
                        break;
                    case 902:
                        i10 = numericCompaction(iArr, i12, sb);
                        break;
                    default:
                        switch (i11) {
                            case MACRO_PDF417_TERMINATOR /* 922 */:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                                throw FormatException.getFormatInstance();
                            case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                break;
                            case ECI_USER_DEFINED /* 925 */:
                                i10 = i12 + 1;
                                break;
                            case ECI_GENERAL_PURPOSE /* 926 */:
                                i10 = i12 + 2;
                                break;
                            case ECI_CHARSET /* 927 */:
                                i10 = i12 + 1;
                                charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i12]).name());
                                break;
                            case 928:
                                i10 = decodeMacroBlock(iArr, i12, pDF417ResultMetadata);
                                break;
                            default:
                                i10 = textCompaction(iArr, i12 - 1, sb);
                                break;
                        }
                }
            } else {
                i10 = i12 + 1;
                sb.append((char) iArr[i12]);
            }
            if (i10 >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            i12 = i10 + 1;
            i11 = iArr[i10];
        }
        if (sb.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        DecoderResult decoderResult = new DecoderResult(null, sb.toString(), null, str);
        decoderResult.setOther(pDF417ResultMetadata);
        return decoderResult;
    }

    private static String decodeBase900toBase10(int[] iArr, int i10) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i11 = 0; i11 < i10; i11++) {
            bigInteger = bigInteger.add(EXP900[(i10 - i11) - 1].multiply(BigInteger.valueOf(iArr[i11])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] iArr, int i10, PDF417ResultMetadata pDF417ResultMetadata) {
        if (i10 + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i11 = 0;
        while (i11 < 2) {
            iArr2[i11] = iArr[i10];
            i11++;
            i10++;
        }
        pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int textCompaction = textCompaction(iArr, i10, sb);
        pDF417ResultMetadata.setFileId(sb.toString());
        int i12 = iArr[textCompaction];
        if (i12 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
            if (i12 != MACRO_PDF417_TERMINATOR) {
                return textCompaction;
            }
            pDF417ResultMetadata.setLastSegment(true);
            return textCompaction + 1;
        }
        int i13 = textCompaction + 1;
        int[] iArr3 = new int[iArr[0] - i13];
        boolean z10 = false;
        int i14 = 0;
        while (i13 < iArr[0] && !z10) {
            int i15 = i13 + 1;
            int i16 = iArr[i13];
            if (i16 < 900) {
                iArr3[i14] = i16;
                i13 = i15;
                i14++;
            } else {
                if (i16 != MACRO_PDF417_TERMINATOR) {
                    throw FormatException.getFormatInstance();
                }
                pDF417ResultMetadata.setLastSegment(true);
                i13 = i15 + 1;
                z10 = true;
            }
        }
        pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i14));
        return i13;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i10, StringBuilder sb) {
        Mode mode;
        int i11;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = iArr[i12];
            char c10 = ' ';
            switch (AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[mode2.ordinal()]) {
                case 1:
                    if (i13 < 26) {
                        i11 = i13 + 65;
                        c10 = (char) i11;
                        break;
                    } else if (i13 != 26) {
                        if (i13 == 27) {
                            mode2 = Mode.LOWER;
                        } else if (i13 == 28) {
                            mode2 = Mode.MIXED;
                        } else if (i13 == 29) {
                            mode = Mode.PUNCT_SHIFT;
                            c10 = 0;
                            Mode mode4 = mode;
                            mode3 = mode2;
                            mode2 = mode4;
                            break;
                        } else if (i13 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            sb.append((char) iArr2[i12]);
                        } else if (i13 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c10 = 0;
                        break;
                    }
                    break;
                case 2:
                    if (i13 < 26) {
                        i11 = i13 + 97;
                        c10 = (char) i11;
                        break;
                    } else if (i13 != 26) {
                        if (i13 != 27) {
                            if (i13 == 28) {
                                mode2 = Mode.MIXED;
                            } else if (i13 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                            } else if (i13 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                sb.append((char) iArr2[i12]);
                            } else if (i13 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            c10 = 0;
                            break;
                        } else {
                            mode = Mode.ALPHA_SHIFT;
                        }
                        c10 = 0;
                        Mode mode42 = mode;
                        mode3 = mode2;
                        mode2 = mode42;
                        break;
                    }
                    break;
                case 3:
                    if (i13 < 25) {
                        c10 = MIXED_CHARS[i13];
                        break;
                    } else {
                        if (i13 == 25) {
                            mode2 = Mode.PUNCT;
                        } else if (i13 != 26) {
                            if (i13 == 27) {
                                mode2 = Mode.LOWER;
                            } else if (i13 == 28) {
                                mode2 = Mode.ALPHA;
                            } else if (i13 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                                c10 = 0;
                                Mode mode422 = mode;
                                mode3 = mode2;
                                mode2 = mode422;
                                break;
                            } else if (i13 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                sb.append((char) iArr2[i12]);
                            } else if (i13 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                        }
                        c10 = 0;
                        break;
                    }
                    break;
                case 4:
                    if (i13 < 29) {
                        c10 = PUNCT_CHARS[i13];
                        break;
                    } else {
                        if (i13 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i13 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            sb.append((char) iArr2[i12]);
                        } else if (i13 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c10 = 0;
                        break;
                    }
                case 5:
                    if (i13 < 26) {
                        c10 = (char) (i13 + 65);
                    } else if (i13 != 26) {
                        if (i13 == 900) {
                            mode2 = Mode.ALPHA;
                            c10 = 0;
                            break;
                        }
                        mode2 = mode3;
                        c10 = 0;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i13 < 29) {
                        c10 = PUNCT_CHARS[i13];
                        mode2 = mode3;
                        break;
                    } else {
                        if (i13 == 29) {
                            mode2 = Mode.ALPHA;
                        } else {
                            if (i13 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                sb.append((char) iArr2[i12]);
                            } else if (i13 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            mode2 = mode3;
                        }
                        c10 = 0;
                        break;
                    }
                default:
                    c10 = 0;
                    break;
            }
            if (c10 != 0) {
                sb.append(c10);
            }
        }
    }

    private static int numericCompaction(int[] iArr, int i10, StringBuilder sb) {
        int[] iArr2 = new int[15];
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            int i12 = iArr[0];
            if (i10 >= i12 || z10) {
                break;
            }
            int i13 = i10 + 1;
            int i14 = iArr[i10];
            if (i13 == i12) {
                z10 = true;
            }
            if (i14 < 900) {
                iArr2[i11] = i14;
                i11++;
            } else if (i14 == 900 || i14 == 901 || i14 == BYTE_COMPACTION_MODE_LATCH_6 || i14 == 928 || i14 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i14 == MACRO_PDF417_TERMINATOR) {
                i13--;
                z10 = true;
            }
            if ((i11 % 15 == 0 || i14 == 902 || z10) && i11 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i11));
                i11 = 0;
            }
            i10 = i13;
        }
        return i10;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0036. Please report as an issue. */
    private static int textCompaction(int[] iArr, int i10, StringBuilder sb) {
        int i11 = iArr[0];
        int[] iArr2 = new int[(i11 - i10) << 1];
        int[] iArr3 = new int[(i11 - i10) << 1];
        boolean z10 = false;
        int i12 = 0;
        while (i10 < iArr[0] && !z10) {
            int i13 = i10 + 1;
            int i14 = iArr[i10];
            if (i14 < 900) {
                iArr2[i12] = i14 / 30;
                iArr2[i12 + 1] = i14 % 30;
                i12 += 2;
            } else if (i14 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i14 != 928) {
                    switch (i14) {
                        case 900:
                            iArr2[i12] = 900;
                            i12++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i14) {
                            }
                    }
                }
                i10 = i13 - 1;
                z10 = true;
            } else {
                iArr2[i12] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i10 = i13 + 1;
                iArr3[i12] = iArr[i13];
                i12++;
            }
            i10 = i13;
        }
        decodeTextCompaction(iArr2, iArr3, i12, sb);
        return i10;
    }
}
