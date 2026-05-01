package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeySupplier;
import io.jsonwebtoken.security.Password;
import io.jsonwebtoken.security.PrivateKeyBuilder;
import io.jsonwebtoken.security.SecretKeyBuilder;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public final class KeysBridge {
    private static final String GENERIC_SECRET_ALG_PREFIX = "Generic";

    private KeysBridge() {
    }

    public static SecretKeyBuilder builder(SecretKey secretKey) {
        return new ProvidedSecretKeyBuilder(secretKey);
    }

    public static String findAlgorithm(Key key) {
        if (key != null) {
            return Strings.clean(key.getAlgorithm());
        }
        return null;
    }

    public static int findBitLength(Key key) {
        if (!(key instanceof SecretKey)) {
            if (key instanceof RSAKey) {
                return ((RSAKey) key).getModulus().bitLength();
            }
            if (key instanceof ECKey) {
                return ((ECKey) key).getParams().getOrder().bitLength();
            }
            EdwardsCurve findByKey = EdwardsCurve.findByKey(key);
            if (findByKey != null) {
                return findByKey.getKeyBitLength();
            }
            return -1;
        }
        SecretKey secretKey = (SecretKey) key;
        if (!"RAW".equals(secretKey.getFormat())) {
            return -1;
        }
        byte[] findEncoded = findEncoded(secretKey);
        if (Bytes.isEmpty(findEncoded)) {
            return -1;
        }
        int bitLength = (int) Bytes.bitLength(findEncoded);
        Bytes.clear(findEncoded);
        return bitLength;
    }

    public static byte[] findEncoded(Key key) {
        Assert.notNull(key, "Key cannot be null.");
        try {
            return key.getEncoded();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] getEncoded(Key key) {
        Assert.notNull(key, "Key cannot be null.");
        try {
            byte[] encoded = key.getEncoded();
            if (!Bytes.isEmpty(encoded)) {
                return encoded;
            }
            throw new InvalidKeyException("Missing required encoded bytes for key [" + toString(key) + "].");
        } catch (Throwable th) {
            throw new InvalidKeyException("Cannot obtain required encoded bytes from key [" + toString(key) + "]: " + th.getMessage(), th);
        }
    }

    public static boolean isGenericSecret(Key key) {
        if (key instanceof SecretKey) {
            return ((String) Assert.hasText(key.getAlgorithm(), "Key algorithm cannot be null or empty.")).startsWith(GENERIC_SECRET_ALG_PREFIX);
        }
        return false;
    }

    public static Password password(char[] cArr) {
        return new PasswordSpec(cArr);
    }

    public static <K extends Key> K root(K k10) {
        return k10 instanceof KeySupplier ? (K) root((KeySupplier) k10) : k10;
    }

    public static String toString(Key key) {
        if (key == null) {
            return "null";
        }
        if (key instanceof PublicKey) {
            return key.toString();
        }
        return "class: " + key.getClass().getName() + ", algorithm: " + key.getAlgorithm() + ", format: " + key.getFormat();
    }

    public static PrivateKeyBuilder builder(PrivateKey privateKey) {
        return new ProvidedPrivateKeyBuilder(privateKey);
    }

    public static <K extends Key> K root(KeySupplier<K> keySupplier) {
        Assert.notNull(keySupplier, "KeySupplier canot be null.");
        return (K) Assert.notNull(root(keySupplier.getKey()), "KeySupplier key cannot be null.");
    }
}
