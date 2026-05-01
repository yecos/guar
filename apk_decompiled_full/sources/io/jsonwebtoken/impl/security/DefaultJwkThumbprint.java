package io.jsonwebtoken.impl.security;

import com.hpplay.cybergarage.soap.SOAP;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.HashAlgorithm;
import io.jsonwebtoken.security.JwkThumbprint;
import java.net.URI;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
class DefaultJwkThumbprint implements JwkThumbprint {
    private static final String URI_PREFIX = "urn:ietf:params:oauth:jwk-thumbprint:";
    private final HashAlgorithm alg;
    private final byte[] digest;
    private final int hashcode;
    private final String sval;
    private final URI uri;

    public DefaultJwkThumbprint(byte[] bArr, HashAlgorithm hashAlgorithm) {
        byte[] notEmpty = Assert.notEmpty(bArr, "Thumbprint digest byte array cannot be null or empty.");
        this.digest = notEmpty;
        HashAlgorithm hashAlgorithm2 = (HashAlgorithm) Assert.notNull(hashAlgorithm, "Thumbprint HashAlgorithm cannot be null.");
        this.alg = hashAlgorithm2;
        String str = (String) Assert.hasText(Strings.clean(hashAlgorithm.getId()), "Thumbprint HashAlgorithm id cannot be null or empty.");
        Encoder<byte[], String> encoder = Encoders.BASE64URL;
        this.uri = URI.create(URI_PREFIX + str + SOAP.DELIM + encoder.encode(bArr));
        this.hashcode = Objects.nullSafeHashCode(notEmpty, hashAlgorithm2);
        this.sval = encoder.encode(bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultJwkThumbprint)) {
            return false;
        }
        DefaultJwkThumbprint defaultJwkThumbprint = (DefaultJwkThumbprint) obj;
        return this.alg.equals(defaultJwkThumbprint.alg) && MessageDigest.isEqual(this.digest, defaultJwkThumbprint.digest);
    }

    @Override // io.jsonwebtoken.security.JwkThumbprint
    public HashAlgorithm getHashAlgorithm() {
        return this.alg;
    }

    public int hashCode() {
        return this.hashcode;
    }

    @Override // io.jsonwebtoken.security.JwkThumbprint
    public byte[] toByteArray() {
        return (byte[]) this.digest.clone();
    }

    @Override // io.jsonwebtoken.security.JwkThumbprint
    public String toString() {
        return this.sval;
    }

    @Override // io.jsonwebtoken.security.JwkThumbprint
    public URI toURI() {
        return this.uri;
    }
}
