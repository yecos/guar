package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.ParameterMap;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.impl.lang.Functions;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.security.HashAlgorithm;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.X509Builder;
import io.jsonwebtoken.security.X509Mutator;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.List;

/* loaded from: classes3.dex */
public class X509BuilderSupport implements X509Builder<X509BuilderSupport> {
    private final Function<X509Certificate, byte[]> GET_X509_BYTES;
    protected boolean computeX509Sha1Thumbprint;
    protected Boolean computeX509Sha256Thumbprint = null;
    private final ParameterMap map;

    public X509BuilderSupport(ParameterMap parameterMap, Class<? extends RuntimeException> cls) {
        this.map = (ParameterMap) Assert.notNull(parameterMap, "ParameterMap cannot be null.");
        this.GET_X509_BYTES = createGetBytesFunction(cls);
    }

    private byte[] computeThumbprint(X509Certificate x509Certificate, HashAlgorithm hashAlgorithm) {
        return hashAlgorithm.digest(new DefaultRequest(Streams.of(this.GET_X509_BYTES.apply(x509Certificate)), null, null));
    }

    private static Function<X509Certificate, byte[]> createGetBytesFunction(Class<? extends RuntimeException> cls) {
        return Functions.wrapFmt(new CheckedFunction<X509Certificate, byte[]>() { // from class: io.jsonwebtoken.impl.security.X509BuilderSupport.1
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public byte[] apply(X509Certificate x509Certificate) {
                return x509Certificate.getEncoded();
            }
        }, cls, "Unable to access X509Certificate encoded bytes necessary to compute thumbprint. Certificate: %s");
    }

    public void apply() {
        List list = (List) this.map.get((Parameter) AbstractAsymmetricJwk.X5C);
        boolean z10 = false;
        X509Certificate x509Certificate = !Collections.isEmpty(list) ? (X509Certificate) list.get(0) : null;
        Boolean bool = this.computeX509Sha256Thumbprint;
        if (bool == null) {
            if (x509Certificate != null && !this.computeX509Sha1Thumbprint && Objects.isEmpty((byte[]) this.map.get((Parameter) AbstractAsymmetricJwk.X5T_S256))) {
                z10 = true;
            }
            bool = Boolean.valueOf(z10);
        }
        if (x509Certificate != null) {
            if (this.computeX509Sha1Thumbprint) {
                x509Sha1Thumbprint(computeThumbprint(x509Certificate, DefaultHashAlgorithm.SHA1));
            }
            if (bool.booleanValue()) {
                x509Sha256Thumbprint(computeThumbprint(x509Certificate, Jwks.HASH.SHA256));
            }
        }
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public /* bridge */ /* synthetic */ X509Mutator x509Chain(List list) {
        return x509Chain((List<X509Certificate>) list);
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public X509BuilderSupport x509Chain(List<X509Certificate> list) {
        this.map.put(AbstractAsymmetricJwk.X5C.getId(), (Object) list);
        return this;
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public X509BuilderSupport x509Url(URI uri) {
        this.map.put(AbstractAsymmetricJwk.X5U.getId(), (Object) uri);
        return this;
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public X509BuilderSupport x509Sha1Thumbprint(byte[] bArr) {
        this.map.put(AbstractAsymmetricJwk.X5T.getId(), (Object) bArr);
        return this;
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public X509BuilderSupport x509Sha256Thumbprint(byte[] bArr) {
        this.map.put(AbstractAsymmetricJwk.X5T_S256.getId(), (Object) bArr);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.security.X509Builder
    /* renamed from: x509Sha1Thumbprint */
    public X509BuilderSupport mo76x509Sha1Thumbprint(boolean z10) {
        this.computeX509Sha1Thumbprint = z10;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.security.X509Builder
    /* renamed from: x509Sha256Thumbprint */
    public X509BuilderSupport mo77x509Sha256Thumbprint(boolean z10) {
        this.computeX509Sha256Thumbprint = Boolean.valueOf(z10);
        return this;
    }
}
