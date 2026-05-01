package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.Codec;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Converters;
import java.math.BigInteger;

/* loaded from: classes3.dex */
final class FieldElementConverter implements Converter<BigInteger, byte[]> {
    static final Converter<BigInteger, Object> B64URL_CONVERTER;
    static final FieldElementConverter INSTANCE;
    private static final int P256_BYTE_LEN;
    private static final int P384_BYTE_LEN;
    private static final int P521_BYTE_LEN;

    static {
        FieldElementConverter fieldElementConverter = new FieldElementConverter();
        INSTANCE = fieldElementConverter;
        B64URL_CONVERTER = Converters.forEncoded(BigInteger.class, Converters.compound(fieldElementConverter, Codec.BASE64URL));
        P256_BYTE_LEN = bytelen(ECCurve.P256);
        P384_BYTE_LEN = bytelen(ECCurve.P384);
        P521_BYTE_LEN = bytelen(ECCurve.P521);
    }

    private static int bytelen(ECCurve eCCurve) {
        return Bytes.length(eCCurve.toParameterSpec().getCurve().getField().getFieldSize());
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public BigInteger applyFrom(byte[] bArr) {
        return Converters.BIGINT_UBYTES.applyFrom(bArr);
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public byte[] applyTo(BigInteger bigInteger) {
        int i10;
        int i11;
        byte[] applyTo = Converters.BIGINT_UBYTES.applyTo(bigInteger);
        int length = applyTo.length;
        int i12 = P256_BYTE_LEN;
        return (length == i12 || length == (i10 = P384_BYTE_LEN) || length == (i11 = P521_BYTE_LEN)) ? applyTo : length < i12 ? Bytes.prepad(applyTo, i12) : length < i10 ? Bytes.prepad(applyTo, i10) : Bytes.prepad(applyTo, i11);
    }
}
