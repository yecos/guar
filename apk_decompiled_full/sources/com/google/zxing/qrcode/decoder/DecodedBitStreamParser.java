package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser() {
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ea A[LOOP:0: B:2:0x001d->B:46:0x00ea, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) {
        Mode mode;
        Mode mode2;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i10 = 1;
        ArrayList arrayList = new ArrayList(1);
        int i11 = -1;
        int i12 = -1;
        boolean z10 = false;
        CharacterSetECI characterSetECI = null;
        while (true) {
            try {
                Mode forBits = bitSource.available() < 4 ? Mode.TERMINATOR : Mode.forBits(bitSource.readBits(4));
                Mode mode3 = Mode.TERMINATOR;
                if (forBits != mode3) {
                    if (forBits != Mode.FNC1_FIRST_POSITION && forBits != Mode.FNC1_SECOND_POSITION) {
                        if (forBits == Mode.STRUCTURED_APPEND) {
                            if (bitSource.available() < 16) {
                                throw FormatException.getFormatInstance();
                            }
                            int readBits = bitSource.readBits(8);
                            i12 = bitSource.readBits(8);
                            i11 = readBits;
                        } else if (forBits == Mode.ECI) {
                            characterSetECI = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                            if (characterSetECI == null) {
                                throw FormatException.getFormatInstance();
                            }
                        } else if (forBits == Mode.HANZI) {
                            int readBits2 = bitSource.readBits(4);
                            int readBits3 = bitSource.readBits(forBits.getCharacterCountBits(version));
                            if (readBits2 == i10) {
                                decodeHanziSegment(bitSource, sb, readBits3);
                            }
                        } else {
                            int readBits4 = bitSource.readBits(forBits.getCharacterCountBits(version));
                            if (forBits == Mode.NUMERIC) {
                                decodeNumericSegment(bitSource, sb, readBits4);
                            } else if (forBits == Mode.ALPHANUMERIC) {
                                decodeAlphanumericSegment(bitSource, sb, readBits4, z10);
                            } else {
                                if (forBits == Mode.BYTE) {
                                    mode = mode3;
                                    mode2 = forBits;
                                    decodeByteSegment(bitSource, sb, readBits4, characterSetECI, arrayList, map);
                                } else {
                                    mode = mode3;
                                    mode2 = forBits;
                                    if (mode2 != Mode.KANJI) {
                                        throw FormatException.getFormatInstance();
                                    }
                                    decodeKanjiSegment(bitSource, sb, readBits4);
                                }
                                if (mode2 == mode) {
                                    return new DecoderResult(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel == null ? null : errorCorrectionLevel.toString(), i11, i12);
                                }
                                i10 = 1;
                            }
                        }
                    }
                    mode = mode3;
                    mode2 = forBits;
                    z10 = true;
                    if (mode2 == mode) {
                    }
                }
                mode = mode3;
                mode2 = forBits;
                if (mode2 == mode) {
                }
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    private static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder sb, int i10, boolean z10) {
        while (i10 > 1) {
            if (bitSource.available() < 11) {
                throw FormatException.getFormatInstance();
            }
            int readBits = bitSource.readBits(11);
            sb.append(toAlphaNumericChar(readBits / 45));
            sb.append(toAlphaNumericChar(readBits % 45));
            i10 -= 2;
        }
        if (i10 == 1) {
            if (bitSource.available() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bitSource.readBits(6)));
        }
        if (z10) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i11 = length + 1;
                        if (sb.charAt(i11) == '%') {
                            sb.deleteCharAt(i11);
                        }
                    }
                    sb.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuilder sb, int i10, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) {
        if ((i10 << 3) > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = (byte) bitSource.readBits(8);
        }
        try {
            sb.append(new String(bArr, characterSetECI == null ? StringUtils.guessEncoding(bArr, map) : characterSetECI.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeHanziSegment(BitSource bitSource, StringBuilder sb, int i10) {
        if (i10 * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i10 * 2];
        int i11 = 0;
        while (i10 > 0) {
            int readBits = bitSource.readBits(13);
            int i12 = (readBits % 96) | ((readBits / 96) << 8);
            int i13 = i12 + (i12 < 959 ? 41377 : 42657);
            bArr[i11] = (byte) (i13 >> 8);
            bArr[i11 + 1] = (byte) i13;
            i11 += 2;
            i10--;
        }
        try {
            sb.append(new String(bArr, StringUtils.GB2312));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuilder sb, int i10) {
        if (i10 * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i10 * 2];
        int i11 = 0;
        while (i10 > 0) {
            int readBits = bitSource.readBits(13);
            int i12 = (readBits % 192) | ((readBits / 192) << 8);
            int i13 = i12 + (i12 < 7936 ? 33088 : 49472);
            bArr[i11] = (byte) (i13 >> 8);
            bArr[i11 + 1] = (byte) i13;
            i11 += 2;
            i10--;
        }
        try {
            sb.append(new String(bArr, StringUtils.SHIFT_JIS));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuilder sb, int i10) {
        while (i10 >= 3) {
            if (bitSource.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            int readBits = bitSource.readBits(10);
            if (readBits >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(readBits / 100));
            sb.append(toAlphaNumericChar((readBits / 10) % 10));
            sb.append(toAlphaNumericChar(readBits % 10));
            i10 -= 3;
        }
        if (i10 == 2) {
            if (bitSource.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            int readBits2 = bitSource.readBits(7);
            if (readBits2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(readBits2 / 10));
            sb.append(toAlphaNumericChar(readBits2 % 10));
            return;
        }
        if (i10 == 1) {
            if (bitSource.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            int readBits3 = bitSource.readBits(4);
            if (readBits3 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(readBits3));
        }
    }

    private static int parseECIValue(BitSource bitSource) {
        int readBits = bitSource.readBits(8);
        if ((readBits & 128) == 0) {
            return readBits & 127;
        }
        if ((readBits & 192) == 128) {
            return bitSource.readBits(8) | ((readBits & 63) << 8);
        }
        if ((readBits & 224) == 192) {
            return bitSource.readBits(16) | ((readBits & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    private static char toAlphaNumericChar(int i10) {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (i10 < cArr.length) {
            return cArr[i10];
        }
        throw FormatException.getFormatInstance();
    }
}
