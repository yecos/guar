package com.google.zxing.aztec.decoder;

import anet.channel.strategy.dispatch.DispatchConstants;
import c8.b;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.bt;
import java.util.Arrays;
import m7.f;
import org.android.agoo.message.MessageService;

/* loaded from: classes2.dex */
public final class Decoder {
    private AztecDetectorResult ddata;
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", "a", b.f5629b, bt.aL, "d", "e", f.f16828a, "g", "h", bt.aI, "j", "k", "l", "m", "n", "o", bt.aD, "q", "r", "s", "t", "u", "v", BrowserInfo.KEY_WIDTH, "x", "y", bt.aJ, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", HTTP.TAB, "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", Operator.Operation.MOD, DispatchConstants.SIGN_SPLIT_SYMBOL, "'", "(", ")", Operator.Operation.MULTIPLY, Operator.Operation.PLUS, ",", Operator.Operation.MINUS, ".", Operator.Operation.DIVISION, SOAP.DELIM, ";", Operator.Operation.LESS_THAN, Operator.Operation.EQUALS, Operator.Operation.GREATER_THAN, Operator.Operation.EMPTY_PARAM, "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", "0", "1", "2", "3", "4", CdnType.DIGITAL_TYPE_PCDN, CdnType.DIGITAL_TYPE_PEERSTAR, "7", MessageService.MSG_ACCS_NOTIFY_CLICK, MessageService.MSG_ACCS_NOTIFY_DISMISS, ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;

        static {
            int[] iArr = new int[Table.values().length];
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = readByte(zArr, i10 << 3);
        }
        return bArr;
    }

    private boolean[] correctBits(boolean[] zArr) {
        int i10;
        GenericGF genericGF;
        if (this.ddata.getNbLayers() <= 2) {
            genericGF = GenericGF.AZTEC_DATA_6;
            i10 = 6;
        } else {
            i10 = 8;
            if (this.ddata.getNbLayers() <= 8) {
                genericGF = GenericGF.AZTEC_DATA_8;
            } else if (this.ddata.getNbLayers() <= 22) {
                genericGF = GenericGF.AZTEC_DATA_10;
                i10 = 10;
            } else {
                genericGF = GenericGF.AZTEC_DATA_12;
                i10 = 12;
            }
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i10;
        if (length < nbDatablocks) {
            throw FormatException.getFormatInstance();
        }
        int length2 = zArr.length % i10;
        int[] iArr = new int[length];
        int i11 = 0;
        while (i11 < length) {
            iArr[i11] = readCode(zArr, length2, i10);
            i11++;
            length2 += i10;
        }
        try {
            new ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
            int i12 = (1 << i10) - 1;
            int i13 = 0;
            for (int i14 = 0; i14 < nbDatablocks; i14++) {
                int i15 = iArr[i14];
                if (i15 == 0 || i15 == i12) {
                    throw FormatException.getFormatInstance();
                }
                if (i15 == 1 || i15 == i12 - 1) {
                    i13++;
                }
            }
            boolean[] zArr2 = new boolean[(nbDatablocks * i10) - i13];
            int i16 = 0;
            for (int i17 = 0; i17 < nbDatablocks; i17++) {
                int i18 = iArr[i17];
                if (i18 == 1 || i18 == i12 - 1) {
                    Arrays.fill(zArr2, i16, (i16 + i10) - 1, i18 > 1);
                    i16 += i10 - 1;
                } else {
                    int i19 = i10 - 1;
                    while (i19 >= 0) {
                        int i20 = i16 + 1;
                        zArr2[i16] = ((1 << i19) & i18) != 0;
                        i19--;
                        i16 = i20;
                    }
                }
            }
            return zArr2;
        } catch (ReedSolomonException e10) {
            throw FormatException.getFormatInstance(e10);
        }
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        boolean isCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i10 = (isCompact ? 11 : 14) + (nbLayers << 2);
        int[] iArr = new int[i10];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
        int i11 = 2;
        if (isCompact) {
            for (int i12 = 0; i12 < i10; i12++) {
                iArr[i12] = i12;
            }
        } else {
            int i13 = i10 / 2;
            int i14 = ((i10 + 1) + (((i13 - 1) / 15) * 2)) / 2;
            for (int i15 = 0; i15 < i13; i15++) {
                iArr[(i13 - i15) - 1] = (i14 - r12) - 1;
                iArr[i13 + i15] = (i15 / 15) + i15 + i14 + 1;
            }
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < nbLayers) {
            int i18 = ((nbLayers - i16) << i11) + (isCompact ? 9 : 12);
            int i19 = i16 << 1;
            int i20 = (i10 - 1) - i19;
            int i21 = 0;
            while (i21 < i18) {
                int i22 = i21 << 1;
                int i23 = 0;
                while (i23 < i11) {
                    int i24 = i19 + i23;
                    int i25 = i19 + i21;
                    zArr[i17 + i22 + i23] = bitMatrix.get(iArr[i24], iArr[i25]);
                    int i26 = iArr[i25];
                    int i27 = i20 - i23;
                    zArr[(i18 * 2) + i17 + i22 + i23] = bitMatrix.get(i26, iArr[i27]);
                    int i28 = i20 - i21;
                    zArr[(i18 * 4) + i17 + i22 + i23] = bitMatrix.get(iArr[i27], iArr[i28]);
                    zArr[(i18 * 6) + i17 + i22 + i23] = bitMatrix.get(iArr[i28], iArr[i24]);
                    i23++;
                    nbLayers = nbLayers;
                    isCompact = isCompact;
                    i11 = 2;
                }
                i21++;
                i11 = 2;
            }
            i17 += i18 << 3;
            i16++;
            i11 = 2;
        }
        return zArr;
    }

    private static String getCharacter(Table table, int i10) {
        int i11 = AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[table.ordinal()];
        if (i11 == 1) {
            return UPPER_TABLE[i10];
        }
        if (i11 == 2) {
            return LOWER_TABLE[i10];
        }
        if (i11 == 3) {
            return MIXED_TABLE[i10];
        }
        if (i11 == 4) {
            return PUNCT_TABLE[i10];
        }
        if (i11 == 5) {
            return DIGIT_TABLE[i10];
        }
        throw new IllegalStateException("Bad table");
    }

    private static String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table2 = table;
        int i10 = 0;
        while (i10 < length) {
            if (table != Table.BINARY) {
                int i11 = table == Table.DIGIT ? 4 : 5;
                if (length - i10 < i11) {
                    break;
                }
                int readCode = readCode(zArr, i10, i11);
                i10 += i11;
                String character = getCharacter(table, readCode);
                if (character.startsWith("CTRL_")) {
                    table2 = getTable(character.charAt(5));
                    if (character.charAt(6) != 'L') {
                        table2 = table;
                        table = table2;
                    }
                } else {
                    sb.append(character);
                }
                table = table2;
            } else {
                if (length - i10 < 5) {
                    break;
                }
                int readCode2 = readCode(zArr, i10, 5);
                i10 += 5;
                if (readCode2 == 0) {
                    if (length - i10 < 11) {
                        break;
                    }
                    readCode2 = readCode(zArr, i10, 11) + 31;
                    i10 += 11;
                }
                int i12 = 0;
                while (true) {
                    if (i12 >= readCode2) {
                        break;
                    }
                    if (length - i10 < 8) {
                        i10 = length;
                        break;
                    }
                    sb.append((char) readCode(zArr, i10, 8));
                    i10 += 8;
                    i12++;
                }
                table = table2;
            }
        }
        return sb.toString();
    }

    private static Table getTable(char c10) {
        return c10 != 'B' ? c10 != 'D' ? c10 != 'P' ? c10 != 'L' ? c10 != 'M' ? Table.UPPER : Table.MIXED : Table.LOWER : Table.PUNCT : Table.DIGIT : Table.BINARY;
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static byte readByte(boolean[] zArr, int i10) {
        int length = zArr.length - i10;
        return (byte) (length >= 8 ? readCode(zArr, i10, 8) : readCode(zArr, i10, length) << (8 - length));
    }

    private static int readCode(boolean[] zArr, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i10; i13 < i10 + i11; i13++) {
            i12 <<= 1;
            if (zArr[i13]) {
                i12 |= 1;
            }
        }
        return i12;
    }

    private static int totalBitsInLayer(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 << 4)) * i10;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) {
        this.ddata = aztecDetectorResult;
        boolean[] correctBits = correctBits(extractBits(aztecDetectorResult.getBits()));
        DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(correctBits), getEncodedData(correctBits), null, null);
        decoderResult.setNumBits(correctBits.length);
        return decoderResult;
    }
}
