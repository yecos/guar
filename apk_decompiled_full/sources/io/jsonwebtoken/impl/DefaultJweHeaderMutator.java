package io.jsonwebtoken.impl;

import io.jsonwebtoken.JweHeaderMutator;
import io.jsonwebtoken.ProtectedHeaderMutator;
import io.jsonwebtoken.impl.lang.DefaultNestedCollection;
import io.jsonwebtoken.impl.lang.DelegatingMapMutator;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.security.X509BuilderSupport;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.NestedCollection;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.PublicJwk;
import io.jsonwebtoken.security.X509Mutator;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultJweHeaderMutator<T extends JweHeaderMutator<T>> extends DelegatingMapMutator<String, Object, ParameterMap, T> implements JweHeaderMutator<T> {
    protected X509BuilderSupport x509;

    public DefaultJweHeaderMutator() {
        super(new ParameterMap(DefaultJweHeader.PARAMS));
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <F> T put(Parameter<F> parameter, F f10) {
        ((ParameterMap) this.DELEGATE).put((Parameter) parameter, (Object) f10);
        return (T) self();
    }

    @Override // io.jsonwebtoken.JweHeaderMutator
    public T agreementPartyUInfo(byte[] bArr) {
        return put((Parameter<Parameter>) DefaultJweHeader.APU, (Parameter) bArr);
    }

    @Override // io.jsonwebtoken.JweHeaderMutator
    public T agreementPartyVInfo(byte[] bArr) {
        return put((Parameter<Parameter>) DefaultJweHeader.APV, (Parameter) bArr);
    }

    @Override // io.jsonwebtoken.impl.lang.DelegatingMap, java.util.Map
    public void clear() {
        super.clear();
        this.x509 = new X509BuilderSupport((ParameterMap) this.DELEGATE, IllegalStateException.class);
    }

    @Override // io.jsonwebtoken.ProtectedHeaderMutator
    public NestedCollection<String, T> critical() {
        return new DefaultNestedCollection<String, T>((JweHeaderMutator) self(), (Collection) ((ParameterMap) this.DELEGATE).get((Parameter) DefaultProtectedHeader.CRIT)) { // from class: io.jsonwebtoken.impl.DefaultJweHeaderMutator.1
            @Override // io.jsonwebtoken.impl.lang.DefaultCollectionMutator
            public void changed() {
                DefaultJweHeaderMutator.this.put((Parameter<Parameter<Set<String>>>) DefaultProtectedHeader.CRIT, (Parameter<Set<String>>) Collections.asSet(getCollection()));
            }
        };
    }

    @Override // io.jsonwebtoken.ProtectedHeaderMutator
    public /* bridge */ /* synthetic */ ProtectedHeaderMutator jwk(PublicJwk publicJwk) {
        return jwk((PublicJwk<?>) publicJwk);
    }

    @Override // io.jsonwebtoken.JweHeaderMutator
    public T pbes2Count(int i10) {
        return put((Parameter<Parameter>) DefaultJweHeader.P2C, (Parameter) Integer.valueOf(i10));
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public /* bridge */ /* synthetic */ X509Mutator x509Chain(List list) {
        return x509Chain((List<X509Certificate>) list);
    }

    @Override // io.jsonwebtoken.JweHeaderMutator
    public T agreementPartyUInfo(String str) {
        return agreementPartyUInfo(Strings.utf8(Strings.clean(str)));
    }

    @Override // io.jsonwebtoken.JweHeaderMutator
    public T agreementPartyVInfo(String str) {
        return agreementPartyVInfo(Strings.utf8(Strings.clean(str)));
    }

    @Override // io.jsonwebtoken.HeaderMutator
    public T contentType(String str) {
        return put((Parameter<Parameter>) DefaultHeader.CONTENT_TYPE, (Parameter) str);
    }

    @Override // io.jsonwebtoken.ProtectedHeaderMutator
    public T jwk(PublicJwk<?> publicJwk) {
        return put((Parameter<Parameter>) DefaultProtectedHeader.JWK, (Parameter) publicJwk);
    }

    @Override // io.jsonwebtoken.ProtectedHeaderMutator
    public T jwkSetUrl(URI uri) {
        return put((Parameter<Parameter>) DefaultProtectedHeader.JKU, (Parameter) uri);
    }

    @Override // io.jsonwebtoken.ProtectedHeaderMutator
    public T keyId(String str) {
        return put((Parameter<Parameter>) DefaultProtectedHeader.KID, (Parameter) str);
    }

    @Override // io.jsonwebtoken.ProtectedHeaderMutator
    public T setAlgorithm(String str) {
        return put((Parameter<Parameter>) DefaultHeader.ALGORITHM, (Parameter) str);
    }

    @Override // io.jsonwebtoken.HeaderMutator
    public T setCompressionAlgorithm(String str) {
        return put((Parameter<Parameter>) DefaultHeader.COMPRESSION_ALGORITHM, (Parameter) str);
    }

    @Override // io.jsonwebtoken.HeaderMutator
    public T setContentType(String str) {
        return contentType(str);
    }

    @Override // io.jsonwebtoken.ProtectedHeaderMutator
    public T setKeyId(String str) {
        return keyId(str);
    }

    @Override // io.jsonwebtoken.HeaderMutator
    public T setType(String str) {
        return type(str);
    }

    @Override // io.jsonwebtoken.HeaderMutator
    public T type(String str) {
        return put((Parameter<Parameter>) DefaultHeader.TYPE, (Parameter) str);
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public T x509Chain(List<X509Certificate> list) {
        this.x509.x509Chain(list);
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public T x509Sha1Thumbprint(byte[] bArr) {
        this.x509.x509Sha1Thumbprint(bArr);
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public T x509Sha256Thumbprint(byte[] bArr) {
        this.x509.x509Sha256Thumbprint(bArr);
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public T x509Url(URI uri) {
        this.x509.x509Url(uri);
        return (T) self();
    }

    public DefaultJweHeaderMutator(DefaultJweHeaderMutator<?> defaultJweHeaderMutator) {
        super(defaultJweHeaderMutator.DELEGATE);
        this.x509 = defaultJweHeaderMutator.x509;
    }
}
