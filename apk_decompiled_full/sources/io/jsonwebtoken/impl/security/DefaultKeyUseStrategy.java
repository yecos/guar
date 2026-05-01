package io.jsonwebtoken.impl.security;

/* loaded from: classes3.dex */
public class DefaultKeyUseStrategy implements KeyUseStrategy {
    private static final String ENCRYPTION = "enc";
    static final KeyUseStrategy INSTANCE = new DefaultKeyUseStrategy();
    private static final String SIGNATURE = "sig";

    @Override // io.jsonwebtoken.impl.security.KeyUseStrategy
    public String toJwkValue(KeyUsage keyUsage) {
        if (keyUsage.isKeyEncipherment() || keyUsage.isDataEncipherment() || keyUsage.isKeyAgreement()) {
            return ENCRYPTION;
        }
        if (keyUsage.isDigitalSignature() || keyUsage.isNonRepudiation() || keyUsage.isKeyCertSign() || keyUsage.isCRLSign()) {
            return SIGNATURE;
        }
        return null;
    }
}
