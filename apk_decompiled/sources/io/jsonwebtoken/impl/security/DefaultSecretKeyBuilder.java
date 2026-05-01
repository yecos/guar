package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.SecretKeyBuilder;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public class DefaultSecretKeyBuilder extends AbstractSecurityBuilder<SecretKey, SecretKeyBuilder> implements SecretKeyBuilder {
    protected final int BIT_LENGTH;
    protected final String JCA_NAME;

    public DefaultSecretKeyBuilder(String str, int i10) {
        this.JCA_NAME = (String) Assert.hasText(str, "jcaName cannot be null or empty.");
        if (i10 % 8 != 0) {
            throw new IllegalArgumentException("bitLength must be an even multiple of 8");
        }
        this.BIT_LENGTH = ((Integer) Assert.gt(Integer.valueOf(i10), 0, "bitLength must be > 0")).intValue();
        random(Randoms.secureRandom());
    }

    @Override // io.jsonwebtoken.lang.Builder
    public SecretKey build() {
        return new JcaTemplate(this.JCA_NAME, this.provider, this.random).generateSecretKey(this.BIT_LENGTH);
    }
}
