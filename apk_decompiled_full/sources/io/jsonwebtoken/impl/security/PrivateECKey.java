package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.KeySupplier;
import java.security.PrivateKey;
import java.security.interfaces.ECKey;
import java.security.spec.ECParameterSpec;

/* loaded from: classes3.dex */
public class PrivateECKey implements PrivateKey, ECKey, KeySupplier<PrivateKey> {
    private final ECParameterSpec params;
    private final PrivateKey privateKey;

    public PrivateECKey(PrivateKey privateKey, ECParameterSpec eCParameterSpec) {
        this.privateKey = (PrivateKey) Assert.notNull(privateKey, "PrivateKey cannot be null.");
        this.params = (ECParameterSpec) Assert.notNull(eCParameterSpec, "ECParameterSpec cannot be null.");
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.privateKey.getAlgorithm();
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.privateKey.getEncoded();
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.privateKey.getFormat();
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.params;
    }

    @Override // io.jsonwebtoken.security.KeySupplier
    public PrivateKey getKey() {
        return this.privateKey;
    }
}
