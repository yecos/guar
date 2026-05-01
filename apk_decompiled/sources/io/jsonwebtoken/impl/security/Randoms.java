package io.jsonwebtoken.impl.security;

import java.security.SecureRandom;

/* loaded from: classes3.dex */
public final class Randoms {
    private static final SecureRandom DEFAULT_SECURE_RANDOM;

    static {
        SecureRandom secureRandom = new SecureRandom();
        DEFAULT_SECURE_RANDOM = secureRandom;
        secureRandom.nextBytes(new byte[64]);
    }

    private Randoms() {
    }

    public static SecureRandom secureRandom() {
        return DEFAULT_SECURE_RANDOM;
    }
}
