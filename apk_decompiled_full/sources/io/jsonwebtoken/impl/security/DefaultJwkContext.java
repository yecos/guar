package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.AbstractX509Context;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.HashAlgorithm;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.KeyOperation;
import java.math.BigInteger;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultJwkContext<K extends Key> extends AbstractX509Context<JwkContext<K>> implements JwkContext<K> {
    private static final Set<Parameter<?>> DEFAULT_PARAMS;
    private HashAlgorithm idThumbprintAlgorithm;
    private K key;
    private Provider provider;
    private PublicKey publicKey;
    private SecureRandom random;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(DefaultSecretJwk.PARAMS);
        linkedHashSet.addAll(DefaultEcPrivateJwk.PARAMS);
        linkedHashSet.addAll(DefaultRsaPrivateJwk.PARAMS);
        linkedHashSet.addAll(DefaultOctetPrivateJwk.PARAMS);
        Parameter<BigInteger> parameter = DefaultEcPublicJwk.X;
        linkedHashSet.remove(parameter);
        Parameter<BigInteger> parameter2 = DefaultEcPrivateJwk.D;
        linkedHashSet.remove(parameter2);
        linkedHashSet.add(Parameters.string(parameter.getId(), "Elliptic Curve public key X coordinate"));
        linkedHashSet.add(Parameters.builder(String.class).setSecret(true).setId(parameter2.getId()).setName("Elliptic Curve private key").build());
        DEFAULT_PARAMS = Collections.immutable((Set) linkedHashSet);
    }

    public DefaultJwkContext() {
        this(DEFAULT_PARAMS);
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public String getAlgorithm() {
        return (String) get(AbstractJwk.ALG);
    }

    @Override // io.jsonwebtoken.Identifiable
    public String getId() {
        return (String) get(AbstractJwk.KID);
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public HashAlgorithm getIdThumbprintAlgorithm() {
        return this.idThumbprintAlgorithm;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public K getKey() {
        return this.key;
    }

    @Override // io.jsonwebtoken.impl.ParameterMap, io.jsonwebtoken.impl.lang.Nameable
    public String getName() {
        String str = (String) get(AbstractJwk.KTY);
        if ("oct".equals(str)) {
            str = "Secret";
        } else if ("OKP".equals(str)) {
            str = "Octet";
        }
        StringBuilder sb = str != null ? new StringBuilder(str) : new StringBuilder();
        K key = getKey();
        if (key instanceof PublicKey) {
            Strings.nespace(sb).append("Public");
        } else if (key instanceof PrivateKey) {
            Strings.nespace(sb).append("Private");
        }
        Strings.nespace(sb).append("JWK");
        return sb.toString();
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public Set<KeyOperation> getOperations() {
        return (Set) get(AbstractJwk.KEY_OPS);
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public Provider getProvider() {
        return this.provider;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public String getPublicKeyUse() {
        return (String) get(AbstractAsymmetricJwk.USE);
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public SecureRandom getRandom() {
        return this.random;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public String getType() {
        return (String) get(AbstractJwk.KTY);
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public boolean isSigUse() {
        if ("sig".equals(getPublicKeyUse())) {
            return true;
        }
        Set<KeyOperation> operations = getOperations();
        if (Collections.isEmpty(operations)) {
            return false;
        }
        return operations.contains(Jwks.OP.SIGN) || operations.contains(Jwks.OP.VERIFY);
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public JwkContext<K> parameter(Parameter<?> parameter) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Parameters.replace(this.PARAMS, parameter).values());
        K k10 = this.key;
        return k10 != null ? new DefaultJwkContext(linkedHashSet, this, k10) : new DefaultJwkContext((Set<Parameter<?>>) linkedHashSet, (JwkContext<?>) this, false);
    }

    @Override // io.jsonwebtoken.impl.ParameterMap, java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        Assert.notEmpty(map, "JWK values cannot be null or empty.");
        super.putAll(map);
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public JwkContext<K> setAlgorithm(String str) {
        put(AbstractJwk.ALG, (Object) str);
        return this;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public JwkContext<K> setId(String str) {
        put(AbstractJwk.KID, (Object) str);
        return this;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public JwkContext<K> setIdThumbprintAlgorithm(HashAlgorithm hashAlgorithm) {
        this.idThumbprintAlgorithm = hashAlgorithm;
        return this;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public JwkContext<K> setKey(K k10) {
        this.key = k10;
        return this;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public JwkContext<K> setOperations(Collection<? extends KeyOperation> collection) {
        put(AbstractJwk.KEY_OPS, (Object) collection);
        return this;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public JwkContext<K> setProvider(Provider provider) {
        this.provider = provider;
        return this;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public JwkContext<K> setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public JwkContext<K> setPublicKeyUse(String str) {
        put(AbstractAsymmetricJwk.USE, (Object) str);
        return this;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public JwkContext<K> setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    @Override // io.jsonwebtoken.impl.security.JwkContext
    public JwkContext<K> setType(String str) {
        put(AbstractJwk.KTY, (Object) str);
        return this;
    }

    public DefaultJwkContext(Set<Parameter<?>> set) {
        super(set);
    }

    public DefaultJwkContext(Set<Parameter<?>> set, JwkContext<?> jwkContext) {
        this(set, jwkContext, true);
    }

    public DefaultJwkContext(Set<Parameter<?>> set, JwkContext<?> jwkContext, K k10) {
        this(set, jwkContext, k10 == null || (k10 instanceof PublicKey));
        this.key = (K) Assert.notNull(k10, "Key cannot be null.");
    }

    public DefaultJwkContext(Set<Parameter<?>> set, JwkContext<?> jwkContext, boolean z10) {
        super((Set) Assert.notEmpty(set, "Parameters cannot be null or empty."));
        Assert.notNull(jwkContext, "JwkContext cannot be null.");
        Assert.isInstanceOf(DefaultJwkContext.class, jwkContext, "JwkContext must be a DefaultJwkContext instance.");
        DefaultJwkContext defaultJwkContext = (DefaultJwkContext) jwkContext;
        this.provider = jwkContext.getProvider();
        this.random = jwkContext.getRandom();
        this.idThumbprintAlgorithm = jwkContext.getIdThumbprintAlgorithm();
        this.values.putAll(defaultJwkContext.values);
        for (Map.Entry<String, Object> entry : defaultJwkContext.idiomaticValues.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Parameter<T> parameter = (Parameter) this.PARAMS.get(key);
            if (parameter != 0 && !parameter.supports(value)) {
                put((Parameter) parameter, this.values.get(parameter.getId()));
            } else {
                this.idiomaticValues.put(key, value);
            }
        }
        if (z10) {
            for (Parameter<?> parameter2 : defaultJwkContext.PARAMS.values()) {
                if (parameter2.isSecret()) {
                    remove(parameter2.getId());
                }
            }
        }
    }
}
