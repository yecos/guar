package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.IdRegistry;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.Password;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import io.jsonwebtoken.security.SignatureAlgorithm;
import java.security.Key;
import java.security.PrivateKey;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public final class StandardSecureDigestAlgorithms extends IdRegistry<SecureDigestAlgorithm<?, ?>> {
    public static final String NAME = "JWS Digital Signature or MAC";

    public StandardSecureDigestAlgorithms() {
        super(NAME, Collections.of(NoneSignatureAlgorithm.INSTANCE, DefaultMacAlgorithm.HS256, DefaultMacAlgorithm.HS384, DefaultMacAlgorithm.HS512, RsaSignatureAlgorithm.RS256, RsaSignatureAlgorithm.RS384, RsaSignatureAlgorithm.RS512, RsaSignatureAlgorithm.PS256, RsaSignatureAlgorithm.PS384, RsaSignatureAlgorithm.PS512, EcSignatureAlgorithm.ES256, EcSignatureAlgorithm.ES384, EcSignatureAlgorithm.ES512, EdSignatureAlgorithm.INSTANCE));
    }

    public static <K extends Key> SecureDigestAlgorithm<K, ?> findBySigningKey(K k10) {
        if ((k10 instanceof SecretKey) && !(k10 instanceof Password)) {
            return DefaultMacAlgorithm.findByKey(k10);
        }
        if (!(k10 instanceof PrivateKey)) {
            return null;
        }
        PrivateKey privateKey = (PrivateKey) k10;
        SignatureAlgorithm findByKey = RsaSignatureAlgorithm.findByKey(privateKey);
        if (findByKey == null) {
            findByKey = EcSignatureAlgorithm.findByKey(privateKey);
        }
        return (findByKey == null && EdSignatureAlgorithm.isSigningKey(privateKey)) ? EdSignatureAlgorithm.INSTANCE : findByKey;
    }
}
