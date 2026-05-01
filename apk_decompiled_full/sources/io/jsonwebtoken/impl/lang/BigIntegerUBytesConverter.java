package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import java.math.BigInteger;

/* loaded from: classes3.dex */
public class BigIntegerUBytesConverter implements Converter<BigInteger, byte[]> {
    private static final String NEGATIVE_MSG = "JWA Base64urlUInt values MUST be >= 0 (non-negative) per the 'Base64urlUInt' definition in [JWA RFC 7518, Section 2](https://www.rfc-editor.org/rfc/rfc7518.html#section-2)";

    @Override // io.jsonwebtoken.impl.lang.Converter
    public BigInteger applyFrom(byte[] bArr) {
        Assert.notEmpty(bArr, "Byte array cannot be null or empty.");
        return new BigInteger(1, bArr);
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public byte[] applyTo(BigInteger bigInteger) {
        Assert.notNull(bigInteger, "BigInteger argument cannot be null.");
        if (BigInteger.ZERO.compareTo(bigInteger) > 0) {
            throw new IllegalArgumentException(NEGATIVE_MSG);
        }
        int bitLength = bigInteger.bitLength();
        byte[] byteArray = bigInteger.toByteArray();
        int max = Math.max(1, Bytes.length(bitLength));
        if (byteArray.length == max) {
            return byteArray;
        }
        byte[] bArr = new byte[max];
        System.arraycopy(byteArray, 1, bArr, 0, max);
        return bArr;
    }
}
