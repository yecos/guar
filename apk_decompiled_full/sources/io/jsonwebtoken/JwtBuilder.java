package io.jsonwebtoken;

import io.jsonwebtoken.io.CompressionAlgorithm;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Conjunctor;
import io.jsonwebtoken.lang.MapMutator;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import io.jsonwebtoken.security.X509Builder;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public interface JwtBuilder extends ClaimsMutator<JwtBuilder> {

    public interface BuilderClaims extends MapMutator<String, Object, BuilderClaims>, ClaimsMutator<BuilderClaims>, Conjunctor<JwtBuilder> {
    }

    public interface BuilderHeader extends JweHeaderMutator<BuilderHeader>, X509Builder<BuilderHeader>, Conjunctor<JwtBuilder> {
    }

    @Deprecated
    JwtBuilder addClaims(Map<String, ?> map);

    JwtBuilder b64Url(Encoder<OutputStream, OutputStream> encoder);

    @Deprecated
    JwtBuilder base64UrlEncodeWith(Encoder<byte[], String> encoder);

    JwtBuilder claim(String str, Object obj);

    BuilderClaims claims();

    JwtBuilder claims(Map<String, ?> map);

    String compact();

    JwtBuilder compressWith(CompressionAlgorithm compressionAlgorithm);

    JwtBuilder content(InputStream inputStream);

    JwtBuilder content(InputStream inputStream, String str);

    JwtBuilder content(String str);

    JwtBuilder content(String str, String str2);

    JwtBuilder content(byte[] bArr);

    JwtBuilder content(byte[] bArr, String str);

    JwtBuilder encodePayload(boolean z10);

    <K extends Key> JwtBuilder encryptWith(K k10, KeyAlgorithm<? super K, ?> keyAlgorithm, AeadAlgorithm aeadAlgorithm);

    JwtBuilder encryptWith(SecretKey secretKey, AeadAlgorithm aeadAlgorithm);

    @Override // io.jsonwebtoken.ClaimsMutator
    JwtBuilder expiration(Date date);

    BuilderHeader header();

    @Override // io.jsonwebtoken.ClaimsMutator
    JwtBuilder id(String str);

    @Override // io.jsonwebtoken.ClaimsMutator
    JwtBuilder issuedAt(Date date);

    @Override // io.jsonwebtoken.ClaimsMutator
    JwtBuilder issuer(String str);

    JwtBuilder json(Serializer<Map<String, ?>> serializer);

    @Override // io.jsonwebtoken.ClaimsMutator
    JwtBuilder notBefore(Date date);

    JwtBuilder provider(Provider provider);

    JwtBuilder random(SecureRandom secureRandom);

    @Deprecated
    JwtBuilder serializeToJsonWith(Serializer<Map<String, ?>> serializer);

    @Deprecated
    JwtBuilder setClaims(Map<String, ?> map);

    @Deprecated
    JwtBuilder setHeader(Map<String, ?> map);

    @Deprecated
    JwtBuilder setHeaderParam(String str, Object obj);

    @Deprecated
    JwtBuilder setHeaderParams(Map<String, ?> map);

    @Deprecated
    JwtBuilder setPayload(String str);

    @Deprecated
    JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, String str);

    @Deprecated
    JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, Key key);

    @Deprecated
    JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, byte[] bArr);

    JwtBuilder signWith(Key key);

    @Deprecated
    JwtBuilder signWith(Key key, SignatureAlgorithm signatureAlgorithm);

    <K extends Key> JwtBuilder signWith(K k10, SecureDigestAlgorithm<? super K, ?> secureDigestAlgorithm);

    @Override // io.jsonwebtoken.ClaimsMutator
    JwtBuilder subject(String str);
}
