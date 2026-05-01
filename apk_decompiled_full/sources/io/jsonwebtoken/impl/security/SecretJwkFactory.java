package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.RequiredParameterReader;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;
import io.jsonwebtoken.security.MalformedKeyException;
import io.jsonwebtoken.security.SecretJwk;
import io.jsonwebtoken.security.SecretKeyAlgorithm;
import io.jsonwebtoken.security.WeakKeyException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
class SecretJwkFactory extends AbstractFamilyJwkFactory<SecretKey, SecretJwk> {
    public SecretJwkFactory() {
        super("oct", SecretKey.class, DefaultSecretJwk.PARAMS);
    }

    private static void assertKeyBitLength(byte[] bArr, MacAlgorithm macAlgorithm) {
        long bitLength = Bytes.bitLength(bArr);
        long keyBitLength = macAlgorithm.getKeyBitLength();
        if (bitLength >= keyBitLength) {
            return;
        }
        throw new WeakKeyException("Secret JWK " + AbstractJwk.ALG + " value is '" + macAlgorithm.getId() + "', but the " + DefaultSecretJwk.K + " length is smaller than the " + macAlgorithm.getId() + " minimum length of " + Bytes.bitsMsg(keyBitLength) + " required by [JWA RFC 7518, Section 3.2](https://www.rfc-editor.org/rfc/rfc7518.html#section-3.2), 2nd paragraph: 'A key of the same size as the hash output or larger MUST be used with this algorithm.'");
    }

    private static void assertSymmetric(Identifiable identifiable) {
        if ((identifiable instanceof MacAlgorithm) || (identifiable instanceof SecretKeyAlgorithm) || (identifiable instanceof AeadAlgorithm)) {
            return;
        }
        throw new MalformedKeyException("Invalid Secret JWK " + AbstractJwk.ALG + " value '" + identifiable.getId() + "'. Secret JWKs may only be used with symmetric (secret) key algorithms.");
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public SecretJwk createJwkFromKey(JwkContext<SecretKey> jwkContext) {
        byte[] bArr;
        SecretKey secretKey = (SecretKey) Assert.notNull(jwkContext.getKey(), "JwkContext key cannot be null.");
        try {
            bArr = KeysBridge.getEncoded(secretKey);
            try {
                String encode = Encoders.BASE64URL.encode(bArr);
                Assert.hasText(encode, "k value cannot be null or empty.");
                Bytes.clear(bArr);
                DefaultMacAlgorithm findByKey = DefaultMacAlgorithm.findByKey(secretKey);
                if (findByKey != null) {
                    jwkContext.put(AbstractJwk.ALG.getId(), findByKey.getId());
                }
                jwkContext.put(DefaultSecretJwk.K.getId(), encode);
                return createJwkFromValues(jwkContext);
            } catch (Throwable th) {
                th = th;
                try {
                    throw new InvalidKeyException("Unable to encode SecretKey to JWK: " + th.getMessage(), th);
                } catch (Throwable th2) {
                    Bytes.clear(bArr);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bArr = null;
        }
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public SecretJwk createJwkFromValues(JwkContext<SecretKey> jwkContext) {
        SecretKey keyFor;
        byte[] bArr = (byte[]) new RequiredParameterReader(jwkContext).get(DefaultSecretJwk.K);
        String algorithm = jwkContext.getAlgorithm();
        if (!Strings.hasText(algorithm)) {
            jwkContext.setKey((jwkContext.isSigUse() || ((int) Bytes.bitLength(bArr)) > Jwts.SIG.HS256.getKeyBitLength()) ? Keys.hmacShaKeyFor(bArr) : AesAlgorithm.keyFor(bArr));
            return new DefaultSecretJwk(jwkContext);
        }
        AeadAlgorithm aeadAlgorithm = Jwts.SIG.get().get(algorithm);
        if (aeadAlgorithm == null) {
            aeadAlgorithm = Jwts.KEY.get().get(algorithm);
        }
        if (aeadAlgorithm == null) {
            aeadAlgorithm = Jwts.ENC.get().get(algorithm);
        }
        if (aeadAlgorithm != null) {
            assertSymmetric(aeadAlgorithm);
        }
        if (aeadAlgorithm instanceof MacAlgorithm) {
            assertKeyBitLength(bArr, (MacAlgorithm) aeadAlgorithm);
            String jcaName = ((CryptoAlgorithm) aeadAlgorithm).getJcaName();
            Assert.hasText(jcaName, "Algorithm jcaName cannot be null or empty.");
            keyFor = new SecretKeySpec(bArr, jcaName);
        } else {
            keyFor = AesAlgorithm.keyFor(bArr);
        }
        jwkContext.setKey(keyFor);
        return new DefaultSecretJwk(jwkContext);
    }
}
