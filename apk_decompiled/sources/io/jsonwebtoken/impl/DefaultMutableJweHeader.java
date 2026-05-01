package io.jsonwebtoken.impl;

import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.security.PublicJwk;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultMutableJweHeader extends DefaultJweHeaderMutator<DefaultMutableJweHeader> implements JweHeader {
    public DefaultMutableJweHeader(DefaultJweHeaderMutator<?> defaultJweHeaderMutator) {
        super(defaultJweHeaderMutator);
    }

    private <T> T get(Parameter<T> parameter) {
        return (T) ((ParameterMap) this.DELEGATE).get((Parameter) parameter);
    }

    @Override // io.jsonwebtoken.JweHeader
    public byte[] getAgreementPartyUInfo() {
        return (byte[]) get((Parameter) DefaultJweHeader.APU);
    }

    @Override // io.jsonwebtoken.JweHeader
    public byte[] getAgreementPartyVInfo() {
        return (byte[]) get((Parameter) DefaultJweHeader.APV);
    }

    @Override // io.jsonwebtoken.Header
    public String getAlgorithm() {
        return (String) get((Parameter) DefaultHeader.ALGORITHM);
    }

    @Override // io.jsonwebtoken.JweHeader
    public byte[] getAuthenticationTag() {
        return (byte[]) get((Parameter) DefaultJweHeader.TAG);
    }

    @Override // io.jsonwebtoken.Header
    public String getCompressionAlgorithm() {
        return (String) get((Parameter) DefaultHeader.COMPRESSION_ALGORITHM);
    }

    @Override // io.jsonwebtoken.Header
    public String getContentType() {
        return (String) get((Parameter) DefaultHeader.CONTENT_TYPE);
    }

    @Override // io.jsonwebtoken.ProtectedHeader
    public Set<String> getCritical() {
        return (Set) get((Parameter) DefaultProtectedHeader.CRIT);
    }

    @Override // io.jsonwebtoken.JweHeader
    public String getEncryptionAlgorithm() {
        return (String) get((Parameter) DefaultJweHeader.ENCRYPTION_ALGORITHM);
    }

    @Override // io.jsonwebtoken.JweHeader
    public PublicJwk<?> getEphemeralPublicKey() {
        return (PublicJwk) get((Parameter) DefaultJweHeader.EPK);
    }

    @Override // io.jsonwebtoken.JweHeader
    public byte[] getInitializationVector() {
        return (byte[]) get((Parameter) DefaultJweHeader.IV);
    }

    @Override // io.jsonwebtoken.ProtectedHeader
    public PublicJwk<?> getJwk() {
        return (PublicJwk) get((Parameter) DefaultProtectedHeader.JWK);
    }

    @Override // io.jsonwebtoken.ProtectedHeader
    public URI getJwkSetUrl() {
        return (URI) get((Parameter) DefaultProtectedHeader.JKU);
    }

    @Override // io.jsonwebtoken.ProtectedHeader
    public String getKeyId() {
        return (String) get((Parameter) DefaultProtectedHeader.KID);
    }

    @Override // io.jsonwebtoken.JweHeader
    public Integer getPbes2Count() {
        return (Integer) get((Parameter) DefaultJweHeader.P2C);
    }

    @Override // io.jsonwebtoken.JweHeader
    public byte[] getPbes2Salt() {
        return (byte[]) get((Parameter) DefaultJweHeader.P2S);
    }

    @Override // io.jsonwebtoken.Header
    public String getType() {
        return (String) get((Parameter) DefaultHeader.TYPE);
    }

    @Override // io.jsonwebtoken.security.X509Accessor
    public List<X509Certificate> getX509Chain() {
        return (List) get((Parameter) DefaultProtectedHeader.X5C);
    }

    @Override // io.jsonwebtoken.security.X509Accessor
    public byte[] getX509Sha1Thumbprint() {
        return (byte[]) get((Parameter) DefaultProtectedHeader.X5T);
    }

    @Override // io.jsonwebtoken.security.X509Accessor
    public byte[] getX509Sha256Thumbprint() {
        return (byte[]) get((Parameter) DefaultProtectedHeader.X5T_S256);
    }

    @Override // io.jsonwebtoken.security.X509Accessor
    public URI getX509Url() {
        return (URI) get((Parameter) DefaultProtectedHeader.X5U);
    }
}
