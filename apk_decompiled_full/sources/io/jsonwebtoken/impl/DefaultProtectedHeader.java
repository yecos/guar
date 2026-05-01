package io.jsonwebtoken.impl;

import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.ProtectedHeader;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.impl.security.AbstractAsymmetricJwk;
import io.jsonwebtoken.impl.security.AbstractJwk;
import io.jsonwebtoken.impl.security.JwkConverter;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.PublicJwk;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultProtectedHeader extends DefaultHeader implements ProtectedHeader {
    static final Parameter<Set<String>> CRIT;
    static final Parameter<URI> JKU;
    static final Parameter<PublicJwk<?>> JWK;
    static final Parameter<String> KID;
    static final Registry<String, Parameter<?>> PARAMS;
    static final Parameter<List<X509Certificate>> X5C;
    static final Parameter<byte[]> X5T;
    static final Parameter<byte[]> X5T_S256;
    static final Parameter<URI> X5U;

    static {
        Parameter<URI> uri = Parameters.uri(JwsHeader.JWK_SET_URL, "JWK Set URL");
        JKU = uri;
        Parameter<PublicJwk<?>> parameter = (Parameter) Parameters.builder(JwkConverter.PUBLIC_JWK_CLASS).setId(JwsHeader.JSON_WEB_KEY).setName("JSON Web Key").setConverter(JwkConverter.PUBLIC_JWK).build();
        JWK = parameter;
        Parameter<Set<String>> stringSet = Parameters.stringSet(JwsHeader.CRITICAL, "Critical");
        CRIT = stringSet;
        Parameter<String> parameter2 = AbstractJwk.KID;
        KID = parameter2;
        Parameter<URI> parameter3 = AbstractAsymmetricJwk.X5U;
        X5U = parameter3;
        Parameter<List<X509Certificate>> parameter4 = AbstractAsymmetricJwk.X5C;
        X5C = parameter4;
        Parameter<byte[]> parameter5 = AbstractAsymmetricJwk.X5T;
        X5T = parameter5;
        Parameter<byte[]> parameter6 = AbstractAsymmetricJwk.X5T_S256;
        X5T_S256 = parameter6;
        PARAMS = Parameters.registry(DefaultHeader.PARAMS, stringSet, uri, parameter, parameter2, parameter3, parameter4, parameter5, parameter6);
    }

    public DefaultProtectedHeader(Registry<String, Parameter<?>> registry, Map<String, ?> map) {
        super(registry, map);
    }

    public static boolean isCandidate(ParameterMap parameterMap) {
        String str = (String) parameterMap.get((Parameter) DefaultHeader.ALGORITHM);
        return Strings.hasText(str) && !str.equalsIgnoreCase(Jwts.SIG.NONE.getId());
    }

    @Override // io.jsonwebtoken.ProtectedHeader
    public Set<String> getCritical() {
        return (Set) get((Parameter) CRIT);
    }

    @Override // io.jsonwebtoken.ProtectedHeader
    public PublicJwk<?> getJwk() {
        return (PublicJwk) get((Parameter) JWK);
    }

    @Override // io.jsonwebtoken.ProtectedHeader
    public URI getJwkSetUrl() {
        return (URI) get((Parameter) JKU);
    }

    @Override // io.jsonwebtoken.ProtectedHeader
    public String getKeyId() {
        return (String) get((Parameter) KID);
    }

    @Override // io.jsonwebtoken.security.X509Accessor
    public List<X509Certificate> getX509Chain() {
        return (List) get((Parameter) X5C);
    }

    @Override // io.jsonwebtoken.security.X509Accessor
    public byte[] getX509Sha1Thumbprint() {
        return (byte[]) get((Parameter) X5T);
    }

    @Override // io.jsonwebtoken.security.X509Accessor
    public byte[] getX509Sha256Thumbprint() {
        return (byte[]) get((Parameter) X5T_S256);
    }

    @Override // io.jsonwebtoken.security.X509Accessor
    public URI getX509Url() {
        return (URI) get((Parameter) AbstractAsymmetricJwk.X5U);
    }
}
