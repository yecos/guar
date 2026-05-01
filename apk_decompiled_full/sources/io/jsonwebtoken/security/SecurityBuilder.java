package io.jsonwebtoken.security;

import io.jsonwebtoken.lang.Builder;
import io.jsonwebtoken.security.SecurityBuilder;
import java.security.Provider;
import java.security.SecureRandom;

/* loaded from: classes3.dex */
public interface SecurityBuilder<T, B extends SecurityBuilder<T, B>> extends Builder<T> {
    B provider(Provider provider);

    B random(SecureRandom secureRandom);
}
