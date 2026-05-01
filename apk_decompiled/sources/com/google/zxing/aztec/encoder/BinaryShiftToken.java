package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes2.dex */
final class BinaryShiftToken extends Token {
    private final short binaryShiftByteCount;
    private final short binaryShiftStart;

    public BinaryShiftToken(Token token, int i10, int i11) {
        super(token);
        this.binaryShiftStart = (short) i10;
        this.binaryShiftByteCount = (short) i11;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void appendTo(BitArray bitArray, byte[] bArr) {
        int i10 = 0;
        while (true) {
            short s10 = this.binaryShiftByteCount;
            if (i10 >= s10) {
                return;
            }
            if (i10 == 0 || (i10 == 31 && s10 <= 62)) {
                bitArray.appendBits(31, 5);
                short s11 = this.binaryShiftByteCount;
                if (s11 > 62) {
                    bitArray.appendBits(s11 - 31, 16);
                } else if (i10 == 0) {
                    bitArray.appendBits(Math.min((int) s11, 31), 5);
                } else {
                    bitArray.appendBits(s11 - 31, 5);
                }
            }
            bitArray.appendBits(bArr[this.binaryShiftStart + i10], 8);
            i10++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Operator.Operation.LESS_THAN);
        sb.append((int) this.binaryShiftStart);
        sb.append("::");
        sb.append((this.binaryShiftStart + this.binaryShiftByteCount) - 1);
        sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        return sb.toString();
    }
}
