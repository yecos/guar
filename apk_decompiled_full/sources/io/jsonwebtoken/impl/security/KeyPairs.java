package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;

/* loaded from: classes3.dex */
public final class KeyPairs {
    private KeyPairs() {
    }

    public static <K> K assertKey(Key key, Class<K> cls, String str) {
        Assert.notNull(key, "Key argument cannot be null.");
        Assert.notNull(cls, "Class argument cannot be null.");
        String str2 = key instanceof PrivateKey ? "private" : "public";
        if (cls.isInstance(key)) {
            return cls.cast(key);
        }
        throw new IllegalArgumentException(str + str2 + " key must be an instance of " + cls.getName() + ". Type found: " + key.getClass().getName());
    }

    private static String familyPrefix(Class<?> cls) {
        return RSAKey.class.isAssignableFrom(cls) ? "RSA " : ECKey.class.isAssignableFrom(cls) ? "EC " : "";
    }

    public static <K> K getKey(KeyPair keyPair, Class<K> cls) {
        Assert.notNull(keyPair, "KeyPair cannot be null.");
        return (K) assertKey(PrivateKey.class.isAssignableFrom(cls) ? keyPair.getPrivate() : keyPair.getPublic(), cls, familyPrefix(cls) + "KeyPair ");
    }
}
