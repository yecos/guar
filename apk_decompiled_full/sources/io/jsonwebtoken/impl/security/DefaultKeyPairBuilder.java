package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.KeyPairBuilder;
import java.security.KeyPair;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes3.dex */
public class DefaultKeyPairBuilder extends AbstractSecurityBuilder<KeyPair, KeyPairBuilder> implements KeyPairBuilder {
    private final int bitLength;
    private final String jcaName;
    private final AlgorithmParameterSpec params;

    public DefaultKeyPairBuilder(String str) {
        this.jcaName = (String) Assert.hasText(str, "jcaName cannot be null or empty.");
        this.bitLength = 0;
        this.params = null;
    }

    @Override // io.jsonwebtoken.lang.Builder
    public KeyPair build() {
        JcaTemplate jcaTemplate = new JcaTemplate(this.jcaName, this.provider, this.random);
        AlgorithmParameterSpec algorithmParameterSpec = this.params;
        if (algorithmParameterSpec != null) {
            return jcaTemplate.generateKeyPair(algorithmParameterSpec);
        }
        int i10 = this.bitLength;
        return i10 > 0 ? jcaTemplate.generateKeyPair(i10) : jcaTemplate.generateKeyPair();
    }

    public DefaultKeyPairBuilder(String str, int i10) {
        this.jcaName = (String) Assert.hasText(str, "jcaName cannot be null or empty.");
        this.bitLength = ((Integer) Assert.gt(Integer.valueOf(i10), 0, "bitLength must be a positive integer greater than 0")).intValue();
        this.params = null;
    }

    public DefaultKeyPairBuilder(String str, AlgorithmParameterSpec algorithmParameterSpec) {
        this.jcaName = (String) Assert.hasText(str, "jcaName cannot be null or empty.");
        this.params = (AlgorithmParameterSpec) Assert.notNull(algorithmParameterSpec, "AlgorithmParameterSpec params cannot be null.");
        this.bitLength = 0;
    }
}
