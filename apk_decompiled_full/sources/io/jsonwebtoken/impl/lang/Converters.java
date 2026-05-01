package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.impl.io.Codec;
import io.jsonwebtoken.impl.security.JwtX509StringConverter;
import java.math.BigInteger;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Converters {
    public static final Converter<byte[], Object> BASE64URL_BYTES;
    public static final Converter<BigInteger, Object> BIGINT;
    public static final Converter<BigInteger, byte[]> BIGINT_UBYTES;
    public static final Converter<URI, Object> URI = forEncoded(URI.class, new UriStringConverter());
    public static final Converter<X509Certificate, Object> X509_CERTIFICATE;

    static {
        Codec codec = Codec.BASE64URL;
        BASE64URL_BYTES = forEncoded(byte[].class, codec);
        X509_CERTIFICATE = forEncoded(X509Certificate.class, JwtX509StringConverter.INSTANCE);
        BigIntegerUBytesConverter bigIntegerUBytesConverter = new BigIntegerUBytesConverter();
        BIGINT_UBYTES = bigIntegerUBytesConverter;
        BIGINT = forEncoded(BigInteger.class, compound(bigIntegerUBytesConverter, codec));
    }

    private Converters() {
    }

    public static <A, B, C> Converter<A, C> compound(Converter<A, B> converter, Converter<B, C> converter2) {
        return new CompoundConverter(converter, converter2);
    }

    public static <T> Converter<T, Object> forEncoded(Class<T> cls, Converter<T, CharSequence> converter) {
        return new EncodedObjectConverter(cls, converter);
    }

    public static <T> Converter<List<T>, Object> forList(Converter<T, Object> converter) {
        return CollectionConverter.forList(converter);
    }

    public static <T> Converter<Set<T>, Object> forSet(Converter<T, Object> converter) {
        return CollectionConverter.forSet(converter);
    }

    public static <T> Converter<T, Object> forType(Class<T> cls) {
        return new RequiredTypeConverter(cls);
    }
}
