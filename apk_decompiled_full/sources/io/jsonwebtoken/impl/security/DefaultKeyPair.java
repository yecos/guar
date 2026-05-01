package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/* loaded from: classes3.dex */
public class DefaultKeyPair<A extends PublicKey, B extends PrivateKey> implements KeyPair<A, B> {
    private final java.security.KeyPair jdkPair;
    private final B privateKey;
    private final A publicKey;

    public DefaultKeyPair(A a10, B b10) {
        A a11 = (A) Assert.notNull(a10, "PublicKey argument cannot be null.");
        this.publicKey = a11;
        B b11 = (B) Assert.notNull(b10, "PrivateKey argument cannot be null.");
        this.privateKey = b11;
        this.jdkPair = new java.security.KeyPair(a11, b11);
    }

    @Override // io.jsonwebtoken.security.KeyPair
    public B getPrivate() {
        return this.privateKey;
    }

    @Override // io.jsonwebtoken.security.KeyPair
    public A getPublic() {
        return this.publicKey;
    }

    @Override // io.jsonwebtoken.security.KeyPair
    public java.security.KeyPair toJavaKeyPair() {
        return this.jdkPair;
    }
}
