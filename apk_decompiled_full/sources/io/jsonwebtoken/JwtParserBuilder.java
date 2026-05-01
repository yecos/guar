package io.jsonwebtoken;

import io.jsonwebtoken.io.CompressionAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Builder;
import io.jsonwebtoken.lang.NestedCollection;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import java.io.InputStream;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public interface JwtParserBuilder extends Builder<JwtParser> {
    JwtParserBuilder b64Url(Decoder<InputStream, InputStream> decoder);

    @Deprecated
    JwtParserBuilder base64UrlDecodeWith(Decoder<CharSequence, byte[]> decoder);

    @Override // io.jsonwebtoken.lang.Builder
    JwtParser build();

    JwtParserBuilder clock(Clock clock);

    JwtParserBuilder clockSkewSeconds(long j10);

    NestedCollection<String, JwtParserBuilder> critical();

    JwtParserBuilder decryptWith(PrivateKey privateKey);

    JwtParserBuilder decryptWith(SecretKey secretKey);

    @Deprecated
    JwtParserBuilder deserializeJsonWith(Deserializer<Map<String, ?>> deserializer);

    NestedCollection<AeadAlgorithm, JwtParserBuilder> enc();

    JwtParserBuilder json(Deserializer<Map<String, ?>> deserializer);

    NestedCollection<KeyAlgorithm<?, ?>, JwtParserBuilder> key();

    JwtParserBuilder keyLocator(Locator<Key> locator);

    JwtParserBuilder provider(Provider provider);

    JwtParserBuilder require(String str, Object obj);

    JwtParserBuilder requireAudience(String str);

    JwtParserBuilder requireExpiration(Date date);

    JwtParserBuilder requireId(String str);

    JwtParserBuilder requireIssuedAt(Date date);

    JwtParserBuilder requireIssuer(String str);

    JwtParserBuilder requireNotBefore(Date date);

    JwtParserBuilder requireSubject(String str);

    @Deprecated
    JwtParserBuilder setAllowedClockSkewSeconds(long j10);

    @Deprecated
    JwtParserBuilder setClock(Clock clock);

    @Deprecated
    JwtParserBuilder setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver);

    @Deprecated
    JwtParserBuilder setSigningKey(String str);

    @Deprecated
    JwtParserBuilder setSigningKey(Key key);

    @Deprecated
    JwtParserBuilder setSigningKey(byte[] bArr);

    @Deprecated
    JwtParserBuilder setSigningKeyResolver(SigningKeyResolver signingKeyResolver);

    NestedCollection<SecureDigestAlgorithm<?, ?>, JwtParserBuilder> sig();

    JwtParserBuilder unsecured();

    JwtParserBuilder unsecuredDecompression();

    JwtParserBuilder verifyWith(PublicKey publicKey);

    JwtParserBuilder verifyWith(SecretKey secretKey);

    NestedCollection<CompressionAlgorithm, JwtParserBuilder> zip();
}
