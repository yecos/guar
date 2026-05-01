package io.jsonwebtoken.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Classes;
import java.security.PrivateKey;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class Keys {
    private static final String BRIDGE_CLASSNAME = "io.jsonwebtoken.impl.security.KeysBridge";
    private static final Class<?> BRIDGE_CLASS = Classes.forName(BRIDGE_CLASSNAME);
    private static final Class<?>[] FOR_PASSWORD_ARG_TYPES = {char[].class};
    private static final Class<?>[] SECRET_BUILDER_ARG_TYPES = {SecretKey.class};
    private static final Class<?>[] PRIVATE_BUILDER_ARG_TYPES = {PrivateKey.class};

    private Keys() {
    }

    public static SecretKeyBuilder builder(SecretKey secretKey) {
        Assert.notNull(secretKey, "SecretKey cannot be null.");
        return (SecretKeyBuilder) invokeStatic("builder", SECRET_BUILDER_ARG_TYPES, secretKey);
    }

    public static SecretKey hmacShaKeyFor(byte[] bArr) {
        if (bArr == null) {
            throw new InvalidKeyException("SecretKey byte array cannot be null.");
        }
        int length = bArr.length * 8;
        if (length >= 512) {
            return new SecretKeySpec(bArr, "HmacSHA512");
        }
        if (length >= 384) {
            return new SecretKeySpec(bArr, "HmacSHA384");
        }
        if (length >= 256) {
            return new SecretKeySpec(bArr, "HmacSHA256");
        }
        throw new WeakKeyException("The specified key byte array is " + length + " bits which is not secure enough for any JWT HMAC-SHA algorithm.  The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used with HMAC-SHA algorithms MUST have a size >= 256 bits (the key size must be greater than or equal to the hash output size).  Consider using the Jwts.SIG.HS256.key() builder (or HS384.key() or HS512.key()) to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.  See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.");
    }

    private static <T> T invokeStatic(String str, Class<?>[] clsArr, Object... objArr) {
        return (T) Classes.invokeStatic(BRIDGE_CLASS, str, clsArr, objArr);
    }

    @Deprecated
    public static java.security.KeyPair keyPairFor(io.jsonwebtoken.SignatureAlgorithm signatureAlgorithm) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        SecureDigestAlgorithm<?, ?> secureDigestAlgorithm = Jwts.SIG.get().get(signatureAlgorithm.name());
        if (secureDigestAlgorithm instanceof SignatureAlgorithm) {
            return ((SignatureAlgorithm) secureDigestAlgorithm).keyPair().build();
        }
        throw new IllegalArgumentException("The " + signatureAlgorithm.name() + " algorithm does not support Key Pairs.");
    }

    public static Password password(char[] cArr) {
        return (Password) invokeStatic("password", FOR_PASSWORD_ARG_TYPES, cArr);
    }

    @Deprecated
    public static SecretKey secretKeyFor(io.jsonwebtoken.SignatureAlgorithm signatureAlgorithm) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        SecureDigestAlgorithm<?, ?> secureDigestAlgorithm = Jwts.SIG.get().get(signatureAlgorithm.name());
        if (secureDigestAlgorithm instanceof MacAlgorithm) {
            return (SecretKey) ((MacAlgorithm) secureDigestAlgorithm).key().build();
        }
        throw new IllegalArgumentException("The " + signatureAlgorithm.name() + " algorithm does not support shared secret keys.");
    }

    public static PrivateKeyBuilder builder(PrivateKey privateKey) {
        Assert.notNull(privateKey, "PrivateKey cannot be null.");
        return (PrivateKeyBuilder) invokeStatic("builder", PRIVATE_BUILDER_ARG_TYPES, privateKey);
    }
}
