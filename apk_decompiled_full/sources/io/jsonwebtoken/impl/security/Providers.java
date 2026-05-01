package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Classes;
import java.security.Provider;
import java.security.Security;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
final class Providers {
    private static final String BC_PROVIDER_CLASS_NAME = "org.bouncycastle.jce.provider.BouncyCastleProvider";
    static final boolean BOUNCY_CASTLE_AVAILABLE = Classes.isAvailable(BC_PROVIDER_CLASS_NAME);
    private static final AtomicReference<Provider> BC_PROVIDER = new AtomicReference<>();

    private Providers() {
    }

    public static Provider findBouncyCastle() {
        if (!BOUNCY_CASTLE_AVAILABLE) {
            return null;
        }
        Provider provider = BC_PROVIDER.get();
        if (provider != null) {
            return provider;
        }
        Class forName = Classes.forName(BC_PROVIDER_CLASS_NAME);
        for (Provider provider2 : Security.getProviders()) {
            if (forName.isInstance(provider2)) {
                BC_PROVIDER.set(provider2);
                return provider2;
            }
        }
        Provider provider3 = (Provider) Classes.newInstance(forName);
        BC_PROVIDER.set(provider3);
        return provider3;
    }
}
