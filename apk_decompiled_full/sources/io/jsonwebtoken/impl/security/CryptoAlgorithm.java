package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.KeyRequest;
import io.jsonwebtoken.security.Request;
import io.jsonwebtoken.security.SecretKeyBuilder;
import java.security.SecureRandom;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
abstract class CryptoAlgorithm implements Identifiable {
    private final String ID;
    private final String jcaName;

    public CryptoAlgorithm(String str, String str2) {
        Assert.hasText(str, "id cannot be null or empty.");
        this.ID = str;
        Assert.hasText(str2, "jcaName cannot be null or empty.");
        this.jcaName = str2;
    }

    public static SecureRandom ensureSecureRandom(Request<?> request) {
        SecureRandom secureRandom = request != null ? request.getSecureRandom() : null;
        return secureRandom != null ? secureRandom : Randoms.secureRandom();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CryptoAlgorithm)) {
            return false;
        }
        CryptoAlgorithm cryptoAlgorithm = (CryptoAlgorithm) obj;
        return this.ID.equals(cryptoAlgorithm.getId()) && this.jcaName.equals(cryptoAlgorithm.getJcaName());
    }

    public SecretKey generateCek(KeyRequest<?> keyRequest) {
        return (SecretKey) Assert.notNull((SecretKey) ((SecretKeyBuilder) ((SecretKeyBuilder) Assert.notNull(((AeadAlgorithm) Assert.notNull(keyRequest.getEncryptionAlgorithm(), "Request encryptionAlgorithm cannot be null.")).key(), "Request encryptionAlgorithm KeyBuilder cannot be null.")).random(keyRequest.getSecureRandom())).build(), "Request encryptionAlgorithm SecretKeyBuilder cannot produce null keys.");
    }

    @Override // io.jsonwebtoken.Identifiable
    public String getId() {
        return this.ID;
    }

    String getJcaName() {
        return this.jcaName;
    }

    public int hashCode() {
        return ((217 + this.ID.hashCode()) * 31) + this.jcaName.hashCode();
    }

    public JcaTemplate jca() {
        return new JcaTemplate(getJcaName());
    }

    public String toString() {
        return this.ID;
    }

    public String getJcaName(Request<?> request) {
        return getJcaName();
    }

    public JcaTemplate jca(Request<?> request) {
        Assert.notNull(request, "request cannot be null.");
        return new JcaTemplate((String) Assert.hasText(getJcaName(request), "Request jcaName cannot be null or empty."), request.getProvider(), ensureSecureRandom(request));
    }
}
