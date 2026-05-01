package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyPairBuilder;
import io.jsonwebtoken.security.Request;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.VerifyDigestRequest;
import java.security.Key;
import java.security.PrivateKey;

/* loaded from: classes3.dex */
final class EdSignatureAlgorithm extends AbstractSignatureAlgorithm {
    private static final String ID = "EdDSA";
    static final EdSignatureAlgorithm INSTANCE = new EdSignatureAlgorithm();
    private final EdwardsCurve preferredCurve;

    private EdSignatureAlgorithm() {
        super(ID, ID);
        EdwardsCurve edwardsCurve = EdwardsCurve.Ed448;
        this.preferredCurve = edwardsCurve;
        Assert.isTrue(edwardsCurve.isSignatureCurve(), "Must be signature curve, not key agreement curve.");
    }

    public static boolean isSigningKey(PrivateKey privateKey) {
        EdwardsCurve findByKey = EdwardsCurve.findByKey(privateKey);
        return findByKey != null && findByKey.isSignatureCurve();
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm
    public String getJcaName(Request<?> request) {
        return !(request instanceof VerifyDigestRequest) ? EdwardsCurve.forKey((Key) Assert.notNull(((SecureRequest) Assert.isInstanceOf(SecureRequest.class, request, "SecureRequests are required.")).getKey(), "Request key cannot be null.")).getJcaName() : getJcaName();
    }

    @Override // io.jsonwebtoken.security.KeyPairBuilderSupplier
    public KeyPairBuilder keyPair() {
        return this.preferredCurve.keyPair();
    }

    @Override // io.jsonwebtoken.impl.security.AbstractSignatureAlgorithm, io.jsonwebtoken.impl.security.AbstractSecureDigestAlgorithm
    public void validateKey(Key key, boolean z10) {
        super.validateKey(key, z10);
        EdwardsCurve forKey = EdwardsCurve.forKey(key);
        if (forKey.isSignatureCurve()) {
            return;
        }
        throw new InvalidKeyException(forKey.getId() + " keys may not be used with " + getId() + " digital signatures per https://www.rfc-editor.org/rfc/rfc8037.html#section-3.2");
    }
}
