package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.MacAlgorithm;
import io.jsonwebtoken.security.Password;
import io.jsonwebtoken.security.SecretKeyBuilder;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.VerifySecureDigestRequest;
import io.jsonwebtoken.security.WeakKeyException;
import java.io.InputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
final class DefaultMacAlgorithm extends AbstractSecureDigestAlgorithm<SecretKey, SecretKey> implements MacAlgorithm {
    static final DefaultMacAlgorithm HS256;
    private static final String HS256_OID = "1.2.840.113549.2.9";
    static final DefaultMacAlgorithm HS384;
    private static final String HS384_OID = "1.2.840.113549.2.10";
    static final DefaultMacAlgorithm HS512;
    private static final String HS512_OID = "1.2.840.113549.2.11";
    private static final Map<String, DefaultMacAlgorithm> JCA_NAME_MAP;
    private static final Set<String> JWA_STANDARD_IDS = new LinkedHashSet(Collections.of("HS256", "HS384", "HS512"));
    private final int minKeyBitLength;

    static {
        DefaultMacAlgorithm defaultMacAlgorithm = new DefaultMacAlgorithm(256);
        HS256 = defaultMacAlgorithm;
        DefaultMacAlgorithm defaultMacAlgorithm2 = new DefaultMacAlgorithm(384);
        HS384 = defaultMacAlgorithm2;
        DefaultMacAlgorithm defaultMacAlgorithm3 = new DefaultMacAlgorithm(512);
        HS512 = defaultMacAlgorithm3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(6);
        JCA_NAME_MAP = linkedHashMap;
        String jcaName = defaultMacAlgorithm.getJcaName();
        Locale locale = Locale.ENGLISH;
        linkedHashMap.put(jcaName.toUpperCase(locale), defaultMacAlgorithm);
        linkedHashMap.put(HS256_OID, defaultMacAlgorithm);
        linkedHashMap.put(defaultMacAlgorithm2.getJcaName().toUpperCase(locale), defaultMacAlgorithm2);
        linkedHashMap.put(HS384_OID, defaultMacAlgorithm2);
        linkedHashMap.put(defaultMacAlgorithm3.getJcaName().toUpperCase(locale), defaultMacAlgorithm3);
        linkedHashMap.put(HS512_OID, defaultMacAlgorithm3);
    }

    private DefaultMacAlgorithm(int i10) {
        this("HS" + i10, "HmacSHA" + i10, i10);
    }

    private void assertAlgorithmName(SecretKey secretKey, boolean z10) {
        String algorithm = secretKey.getAlgorithm();
        if (!Strings.hasText(algorithm)) {
            throw new InvalidKeyException("The " + AbstractSecureDigestAlgorithm.keyType(z10) + " key's algorithm cannot be null or empty.");
        }
        if (KeysBridge.isGenericSecret(secretKey) || !isJwaStandard() || isJwaStandardJcaName(algorithm)) {
            return;
        }
        throw new InvalidKeyException("The " + AbstractSecureDigestAlgorithm.keyType(z10) + " key's algorithm '" + algorithm + "' does not equal a valid HmacSHA* algorithm name or PKCS12 OID and cannot be used with " + getId() + ".");
    }

    public static DefaultMacAlgorithm findByKey(Key key) {
        String findAlgorithm = KeysBridge.findAlgorithm(key);
        if (!Strings.hasText(findAlgorithm)) {
            return null;
        }
        DefaultMacAlgorithm defaultMacAlgorithm = JCA_NAME_MAP.get(findAlgorithm.toUpperCase(Locale.ENGLISH));
        if (defaultMacAlgorithm != null && Bytes.bitLength(KeysBridge.findEncoded(key)) >= defaultMacAlgorithm.getKeyBitLength()) {
            return defaultMacAlgorithm;
        }
        return null;
    }

    private boolean isJwaStandard() {
        return JWA_STANDARD_IDS.contains(getId());
    }

    private static boolean isJwaStandardJcaName(String str) {
        return JCA_NAME_MAP.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    @Override // io.jsonwebtoken.impl.security.AbstractSecureDigestAlgorithm
    public byte[] doDigest(final SecureRequest<InputStream, SecretKey> secureRequest) {
        return (byte[]) jca(secureRequest).withMac(new CheckedFunction<Mac, byte[]>() { // from class: io.jsonwebtoken.impl.security.DefaultMacAlgorithm.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public byte[] apply(Mac mac) {
                mac.init(secureRequest.getKey());
                InputStream inputStream = (InputStream) secureRequest.getPayload();
                byte[] bArr = new byte[1024];
                int i10 = 0;
                while (i10 != -1) {
                    i10 = inputStream.read(bArr);
                    if (i10 > 0) {
                        mac.update(bArr, 0, i10);
                    }
                }
                return mac.doFinal();
            }
        });
    }

    @Override // io.jsonwebtoken.impl.security.AbstractSecureDigestAlgorithm
    public boolean doVerify(VerifySecureDigestRequest<SecretKey> verifySecureDigestRequest) {
        byte[] digest = verifySecureDigestRequest.getDigest();
        Assert.notEmpty(digest, "Request signature byte array cannot be null or empty.");
        return MessageDigest.isEqual(digest, digest((SecureRequest) verifySecureDigestRequest));
    }

    @Override // io.jsonwebtoken.security.KeyLengthSupplier
    public int getKeyBitLength() {
        return this.minKeyBitLength;
    }

    @Override // io.jsonwebtoken.impl.security.AbstractSecureDigestAlgorithm
    public void validateKey(Key key, boolean z10) {
        String str;
        String keyType = AbstractSecureDigestAlgorithm.keyType(z10);
        if (key == null) {
            throw new IllegalArgumentException("MAC " + keyType + " key cannot be null.");
        }
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("MAC " + keyType + " keys must be SecretKey instances.  Specified key is of type " + key.getClass().getName());
        }
        if (key instanceof Password) {
            throw new InvalidKeyException("Passwords are intended for use with key derivation algorithms only.");
        }
        SecretKey secretKey = (SecretKey) key;
        String id = getId();
        assertAlgorithmName(secretKey, z10);
        int findBitLength = KeysBridge.findBitLength(secretKey);
        if (findBitLength >= 0 && findBitLength < this.minKeyBitLength) {
            String str2 = "The " + keyType + " key's size is " + findBitLength + " bits which is not secure enough for the " + id + " algorithm.";
            if (isJwaStandard() && isJwaStandardJcaName(getJcaName())) {
                str = str2 + " The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used with " + id + " MUST have a size >= " + this.minKeyBitLength + " bits (the key size must be greater than or equal to the hash output size). Consider using the Jwts.SIG." + id + ".key() builder to create a key guaranteed to be secure enough for " + id + ".  See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.";
            } else {
                str = str2 + " The " + id + " algorithm requires keys to have a size >= " + this.minKeyBitLength + " bits.";
            }
            throw new WeakKeyException(str);
        }
    }

    public DefaultMacAlgorithm(String str, String str2, int i10) {
        super(str, str2);
        Assert.isTrue(i10 > 0, "minKeyLength must be greater than zero.");
        this.minKeyBitLength = i10;
    }

    @Override // io.jsonwebtoken.security.KeyBuilderSupplier
    public SecretKeyBuilder key() {
        return new DefaultSecretKeyBuilder(getJcaName(), getKeyBitLength());
    }
}
