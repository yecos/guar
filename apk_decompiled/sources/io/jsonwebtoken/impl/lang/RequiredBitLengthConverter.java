package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
public class RequiredBitLengthConverter implements Converter<byte[], Object> {
    private final int bitLength;
    private final Converter<byte[], Object> converter;
    private final boolean exact;

    public RequiredBitLengthConverter(Converter<byte[], Object> converter, int i10) {
        this(converter, i10, true);
    }

    private byte[] assertLength(byte[] bArr) {
        long bitLength = Bytes.bitLength(bArr);
        if (this.exact && bitLength != this.bitLength) {
            throw new IllegalArgumentException("Byte array must be exactly " + Bytes.bitsMsg(this.bitLength) + ". Found " + Bytes.bitsMsg(bitLength));
        }
        if (bitLength >= this.bitLength) {
            return bArr;
        }
        throw new IllegalArgumentException("Byte array must be at least " + Bytes.bitsMsg(this.bitLength) + ". Found " + Bytes.bitsMsg(bitLength));
    }

    public RequiredBitLengthConverter(Converter<byte[], Object> converter, int i10, boolean z10) {
        this.converter = (Converter) Assert.notNull(converter, "Converter cannot be null.");
        this.bitLength = ((Integer) Assert.gt(Integer.valueOf(i10), 0, "bitLength must be greater than 0")).intValue();
        this.exact = z10;
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public byte[] applyFrom(Object obj) {
        return assertLength(this.converter.applyFrom(obj));
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public Object applyTo(byte[] bArr) {
        assertLength(bArr);
        return this.converter.applyTo(bArr);
    }
}
