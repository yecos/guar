package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.KeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.util.Set;

/* loaded from: classes3.dex */
abstract class AbstractFamilyJwkFactory<K extends Key, J extends Jwk<K>> implements FamilyJwkFactory<K, J> {
    private final Class<K> keyType;
    private final String ktyValue;
    private final Set<Parameter<?>> params;

    public AbstractFamilyJwkFactory(String str, Class<K> cls, Set<Parameter<?>> set) {
        this.ktyValue = (String) Assert.hasText(str, "keyType argument cannot be null or empty.");
        this.keyType = (Class) Assert.notNull(cls, "keyType class cannot be null.");
        this.params = (Set) Assert.notEmpty(set, "Parameters collection cannot be null or empty.");
    }

    public static <T> void put(JwkContext<?> jwkContext, Parameter<T> parameter, T t10) {
        jwkContext.put(parameter.getId(), parameter.applyTo(t10));
    }

    @Override // io.jsonwebtoken.impl.security.JwkFactory
    public final J createJwk(JwkContext<K> jwkContext) {
        Assert.notNull(jwkContext, "JwkContext argument cannot be null.");
        if (!supports((JwkContext<?>) jwkContext)) {
            throw new IllegalArgumentException("Unsupported JwkContext.");
        }
        if (jwkContext.getKey() == null) {
            return createJwkFromValues(jwkContext);
        }
        jwkContext.setType(this.ktyValue);
        return createJwkFromKey(jwkContext);
    }

    public abstract J createJwkFromKey(JwkContext<K> jwkContext);

    public abstract J createJwkFromValues(JwkContext<K> jwkContext);

    /* JADX WARN: Multi-variable type inference failed */
    public K generateKey(JwkContext<K> jwkContext, CheckedFunction<KeyFactory, K> checkedFunction) {
        return (K) generateKey(jwkContext, this.keyType, checkedFunction);
    }

    @Override // io.jsonwebtoken.Identifiable
    public String getId() {
        return this.ktyValue;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.security.Key] */
    public String getKeyFactoryJcaName(JwkContext<?> jwkContext) {
        String findAlgorithm = KeysBridge.findAlgorithm(jwkContext.getKey());
        return Strings.hasText(findAlgorithm) ? findAlgorithm : getId();
    }

    @Override // io.jsonwebtoken.impl.security.JwkFactory
    public JwkContext<K> newContext(JwkContext<?> jwkContext, K k10) {
        Assert.notNull(jwkContext, "Source JwkContext cannot be null.");
        return k10 != null ? new DefaultJwkContext(this.params, jwkContext, k10) : new DefaultJwkContext(this.params, jwkContext, false);
    }

    @Override // io.jsonwebtoken.impl.security.FamilyJwkFactory
    public boolean supports(Key key) {
        return this.keyType.isInstance(key);
    }

    public boolean supportsKeyValues(JwkContext<?> jwkContext) {
        return this.ktyValue.equals(jwkContext.getType());
    }

    public <T extends Key> T generateKey(final JwkContext<?> jwkContext, final Class<T> cls, final CheckedFunction<KeyFactory, T> checkedFunction) {
        return (T) new JcaTemplate(getKeyFactoryJcaName(jwkContext), jwkContext.getProvider(), jwkContext.getRandom()).withKeyFactory(new CheckedFunction<KeyFactory, T>() { // from class: io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory.1
            /* JADX WARN: Incorrect return type in method signature: (Ljava/security/KeyFactory;)TT; */
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public Key apply(KeyFactory keyFactory) {
                try {
                    return (Key) checkedFunction.apply(keyFactory);
                } catch (KeyException e10) {
                    throw e10;
                } catch (Exception e11) {
                    throw new InvalidKeyException("Unable to create " + cls.getSimpleName() + " from JWK " + jwkContext + ": " + e11.getMessage(), e11);
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.security.Key] */
    @Override // io.jsonwebtoken.impl.security.FamilyJwkFactory
    public boolean supports(JwkContext<?> jwkContext) {
        return supports((Key) jwkContext.getKey()) || supportsKeyValues(jwkContext);
    }
}
