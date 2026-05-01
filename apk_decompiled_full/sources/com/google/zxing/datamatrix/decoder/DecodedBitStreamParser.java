package com.google.zxing.datamatrix.decoder;

import com.google.common.base.Ascii;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes2.dex */
final class DecodedBitStreamParser {
    private static final char[] C40_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', ASCIIPropertyListParser.DATA_GSBOOL_BEGIN_TOKEN, 'C', ASCIIPropertyListParser.DATA_GSDATE_BEGIN_TOKEN, 'E', 'F', 'G', 'H', ASCIIPropertyListParser.DATA_GSINT_BEGIN_TOKEN, 'J', 'K', 'L', 'M', ASCIIPropertyListParser.DATA_GSBOOL_FALSE_TOKEN, 'O', 'P', 'Q', ASCIIPropertyListParser.DATA_GSREAL_BEGIN_TOKEN, 'S', ASCIIPropertyListParser.DATE_APPLE_DATE_TIME_DELIMITER, 'U', 'V', 'W', 'X', ASCIIPropertyListParser.DATA_GSBOOL_TRUE_TOKEN, ASCIIPropertyListParser.DATE_APPLE_END_TOKEN};
    private static final char[] C40_SHIFT2_SET_CHARS;
    private static final char[] TEXT_BASIC_SET_CHARS;
    private static final char[] TEXT_SHIFT2_SET_CHARS;
    private static final char[] TEXT_SHIFT3_SET_CHARS;

    /* renamed from: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN, ASCIIPropertyListParser.ARRAY_END_TOKEN, '*', '+', ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN, ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER, '.', '/', ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER, ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN, ASCIIPropertyListParser.DATA_BEGIN_TOKEN, ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN, ASCIIPropertyListParser.DATA_END_TOKEN, '?', '@', '[', ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN, ']', '^', '_'};
        C40_SHIFT2_SET_CHARS = cArr;
        TEXT_BASIC_SET_CHARS = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        TEXT_SHIFT2_SET_CHARS = cArr;
        TEXT_SHIFT3_SET_CHARS = new char[]{'`', 'A', ASCIIPropertyListParser.DATA_GSBOOL_BEGIN_TOKEN, 'C', ASCIIPropertyListParser.DATA_GSDATE_BEGIN_TOKEN, 'E', 'F', 'G', 'H', ASCIIPropertyListParser.DATA_GSINT_BEGIN_TOKEN, 'J', 'K', 'L', 'M', ASCIIPropertyListParser.DATA_GSBOOL_FALSE_TOKEN, 'O', 'P', 'Q', ASCIIPropertyListParser.DATA_GSREAL_BEGIN_TOKEN, 'S', ASCIIPropertyListParser.DATE_APPLE_DATE_TIME_DELIMITER, 'U', 'V', 'W', 'X', ASCIIPropertyListParser.DATA_GSBOOL_TRUE_TOKEN, ASCIIPropertyListParser.DATE_APPLE_END_TOKEN, ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN, '|', ASCIIPropertyListParser.DICTIONARY_END_TOKEN, '~', Ascii.MAX};
    }

    private DecodedBitStreamParser() {
    }

    public static DecoderResult decode(byte[] bArr) {
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        Mode mode = Mode.ASCII_ENCODE;
        do {
            Mode mode2 = Mode.ASCII_ENCODE;
            if (mode == mode2) {
                mode = decodeAsciiSegment(bitSource, sb, sb2);
            } else {
                int i10 = AnonymousClass1.$SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[mode.ordinal()];
                if (i10 == 1) {
                    decodeC40Segment(bitSource, sb);
                } else if (i10 == 2) {
                    decodeTextSegment(bitSource, sb);
                } else if (i10 == 3) {
                    decodeAnsiX12Segment(bitSource, sb);
                } else if (i10 == 4) {
                    decodeEdifactSegment(bitSource, sb);
                } else {
                    if (i10 != 5) {
                        throw FormatException.getFormatInstance();
                    }
                    decodeBase256Segment(bitSource, sb, arrayList);
                }
                mode = mode2;
            }
            if (mode == Mode.PAD_ENCODE) {
                break;
            }
        } while (bitSource.available() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String sb3 = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new DecoderResult(bArr, sb3, arrayList, null);
    }

    private static void decodeAnsiX12Segment(BitSource bitSource, StringBuilder sb) {
        int readBits;
        int[] iArr = new int[3];
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i10 = 0; i10 < 3; i10++) {
                int i11 = iArr[i10];
                if (i11 == 0) {
                    sb.append(ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN);
                } else if (i11 == 1) {
                    sb.append('*');
                } else if (i11 == 2) {
                    sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
                } else if (i11 == 3) {
                    sb.append(' ');
                } else if (i11 < 14) {
                    sb.append((char) (i11 + 44));
                } else {
                    if (i11 >= 40) {
                        throw FormatException.getFormatInstance();
                    }
                    sb.append((char) (i11 + 51));
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static Mode decodeAsciiSegment(BitSource bitSource, StringBuilder sb, StringBuilder sb2) {
        boolean z10 = false;
        do {
            int readBits = bitSource.readBits(8);
            if (readBits == 0) {
                throw FormatException.getFormatInstance();
            }
            if (readBits <= 128) {
                if (z10) {
                    readBits += 128;
                }
                sb.append((char) (readBits - 1));
                return Mode.ASCII_ENCODE;
            }
            if (readBits == 129) {
                return Mode.PAD_ENCODE;
            }
            if (readBits <= 229) {
                int i10 = readBits - 130;
                if (i10 < 10) {
                    sb.append('0');
                }
                sb.append(i10);
            } else {
                if (readBits == 230) {
                    return Mode.C40_ENCODE;
                }
                if (readBits == 231) {
                    return Mode.BASE256_ENCODE;
                }
                if (readBits == 232) {
                    sb.append((char) 29);
                } else if (readBits != 233 && readBits != 234) {
                    if (readBits == 235) {
                        z10 = true;
                    } else if (readBits == 236) {
                        sb.append("[)>\u001e05\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else if (readBits == 237) {
                        sb.append("[)>\u001e06\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else {
                        if (readBits == 238) {
                            return Mode.ANSIX12_ENCODE;
                        }
                        if (readBits == 239) {
                            return Mode.TEXT_ENCODE;
                        }
                        if (readBits == 240) {
                            return Mode.EDIFACT_ENCODE;
                        }
                        if (readBits != 241 && readBits >= 242 && (readBits != 254 || bitSource.available() != 0)) {
                            throw FormatException.getFormatInstance();
                        }
                    }
                }
            }
        } while (bitSource.available() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void decodeBase256Segment(BitSource bitSource, StringBuilder sb, Collection<byte[]> collection) {
        int byteOffset = bitSource.getByteOffset() + 1;
        int i10 = byteOffset + 1;
        int unrandomize255State = unrandomize255State(bitSource.readBits(8), byteOffset);
        if (unrandomize255State == 0) {
            unrandomize255State = bitSource.available() / 8;
        } else if (unrandomize255State >= 250) {
            unrandomize255State = ((unrandomize255State - 249) * 250) + unrandomize255State(bitSource.readBits(8), i10);
            i10++;
        }
        if (unrandomize255State < 0) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[unrandomize255State];
        int i11 = 0;
        while (i11 < unrandomize255State) {
            if (bitSource.available() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i11] = (byte) unrandomize255State(bitSource.readBits(8), i10);
            i11++;
            i10++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e10) {
            throw new IllegalStateException("Platform does not support required encoding: " + e10);
        }
    }

    private static void decodeC40Segment(BitSource bitSource, StringBuilder sb) {
        int readBits;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            char[] cArr = C40_SHIFT2_SET_CHARS;
                            if (i12 < cArr.length) {
                                char c10 = cArr[i12];
                                if (z10) {
                                    sb.append((char) (c10 + 128));
                                    z10 = false;
                                } else {
                                    sb.append(c10);
                                }
                            } else if (i12 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i12 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z10 = true;
                            }
                            i10 = 0;
                        } else {
                            if (i10 != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            if (z10) {
                                sb.append((char) (i12 + 224));
                                z10 = false;
                                i10 = 0;
                            } else {
                                sb.append((char) (i12 + 96));
                                i10 = 0;
                            }
                        }
                    } else if (z10) {
                        sb.append((char) (i12 + 128));
                        z10 = false;
                        i10 = 0;
                    } else {
                        sb.append((char) i12);
                        i10 = 0;
                    }
                } else if (i12 < 3) {
                    i10 = i12 + 1;
                } else {
                    char[] cArr2 = C40_BASIC_SET_CHARS;
                    if (i12 >= cArr2.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c11 = cArr2[i12];
                    if (z10) {
                        sb.append((char) (c11 + 128));
                        z10 = false;
                    } else {
                        sb.append(c11);
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeEdifactSegment(BitSource bitSource, StringBuilder sb) {
        while (bitSource.available() > 16) {
            for (int i10 = 0; i10 < 4; i10++) {
                int readBits = bitSource.readBits(6);
                if (readBits == 31) {
                    int bitOffset = 8 - bitSource.getBitOffset();
                    if (bitOffset != 8) {
                        bitSource.readBits(bitOffset);
                        return;
                    }
                    return;
                }
                if ((readBits & 32) == 0) {
                    readBits |= 64;
                }
                sb.append((char) readBits);
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeTextSegment(BitSource bitSource, StringBuilder sb) {
        int readBits;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            char[] cArr = TEXT_SHIFT2_SET_CHARS;
                            if (i12 < cArr.length) {
                                char c10 = cArr[i12];
                                if (z10) {
                                    sb.append((char) (c10 + 128));
                                    z10 = false;
                                } else {
                                    sb.append(c10);
                                }
                            } else if (i12 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i12 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z10 = true;
                            }
                            i10 = 0;
                        } else {
                            if (i10 != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            char[] cArr2 = TEXT_SHIFT3_SET_CHARS;
                            if (i12 >= cArr2.length) {
                                throw FormatException.getFormatInstance();
                            }
                            char c11 = cArr2[i12];
                            if (z10) {
                                sb.append((char) (c11 + 128));
                                z10 = false;
                                i10 = 0;
                            } else {
                                sb.append(c11);
                                i10 = 0;
                            }
                        }
                    } else if (z10) {
                        sb.append((char) (i12 + 128));
                        z10 = false;
                        i10 = 0;
                    } else {
                        sb.append((char) i12);
                        i10 = 0;
                    }
                } else if (i12 < 3) {
                    i10 = i12 + 1;
                } else {
                    char[] cArr3 = TEXT_BASIC_SET_CHARS;
                    if (i12 >= cArr3.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c12 = cArr3[i12];
                    if (z10) {
                        sb.append((char) (c12 + 128));
                        z10 = false;
                    } else {
                        sb.append(c12);
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void parseTwoBytes(int i10, int i11, int[] iArr) {
        int i12 = ((i10 << 8) + i11) - 1;
        int i13 = i12 / 1600;
        iArr[0] = i13;
        int i14 = i12 - (i13 * 1600);
        int i15 = i14 / 40;
        iArr[1] = i15;
        iArr[2] = i14 - (i15 * 40);
    }

    private static int unrandomize255State(int i10, int i11) {
        int i12 = i10 - (((i11 * 149) % 255) + 1);
        return i12 >= 0 ? i12 : i12 + 256;
    }
}
