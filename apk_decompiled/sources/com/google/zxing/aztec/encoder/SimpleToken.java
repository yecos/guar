package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes2.dex */
final class SimpleToken extends Token {
    private final short bitCount;
    private final short value;

    public SimpleToken(Token token, int i10, int i11) {
        super(token);
        this.value = (short) i10;
        this.bitCount = (short) i11;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void appendTo(BitArray bitArray, byte[] bArr) {
        bitArray.appendBits(this.value, this.bitCount);
    }

    public String toString() {
        short s10 = this.value;
        short s11 = this.bitCount;
        return Operator.Operation.LESS_THAN + Integer.toBinaryString((s10 & ((1 << s11) - 1)) | (1 << s11) | (1 << this.bitCount)).substring(1) + ASCIIPropertyListParser.DATA_END_TOKEN;
    }
}
