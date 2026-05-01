package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.PrivateKeyBuilder;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.ECKey;

/* loaded from: classes3.dex */
public class ProvidedPrivateKeyBuilder extends ProvidedKeyBuilder<PrivateKey, PrivateKeyBuilder> implements PrivateKeyBuilder {
    private PublicKey publicKey;

    public ProvidedPrivateKeyBuilder(PrivateKey privateKey) {
        super(privateKey);
    }

    @Override // io.jsonwebtoken.security.PrivateKeyBuilder
    public PrivateKeyBuilder publicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    @Override // io.jsonwebtoken.impl.security.ProvidedKeyBuilder
    public PrivateKey doBuild() {
        K k10 = this.key;
        PrivateKey privateKey = (PrivateKey) k10;
        String clean = Strings.clean(((PrivateKey) k10).getAlgorithm());
        if (!(privateKey instanceof ECKey) && ("EC".equalsIgnoreCase(clean) || "ECDSA".equalsIgnoreCase(clean))) {
            PublicKey publicKey = this.publicKey;
            if (publicKey instanceof ECKey) {
                privateKey = new PrivateECKey(privateKey, ((ECKey) publicKey).getParams());
            }
        }
        Provider provider = this.provider;
        return provider != null ? new ProviderPrivateKey(provider, privateKey) : privateKey;
    }
}
