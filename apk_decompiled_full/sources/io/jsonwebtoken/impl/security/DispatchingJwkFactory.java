package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.UnsupportedKeyException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
class DispatchingJwkFactory implements JwkFactory<Key, Jwk<Key>> {
    private static final Collection<FamilyJwkFactory<Key, ?>> DEFAULT_FACTORIES = createDefaultFactories();
    static final JwkFactory<Key, Jwk<Key>> DEFAULT_INSTANCE = new DispatchingJwkFactory();
    private final Collection<FamilyJwkFactory<Key, ?>> factories;

    public DispatchingJwkFactory() {
        this(DEFAULT_FACTORIES);
    }

    private static void assertKeyOrKeyType(Key key, String str) {
        if (key != null || Strings.hasText(str)) {
            return;
        }
        throw new InvalidKeyException("Either a Key instance or a " + AbstractJwk.KTY + " value is required to create a JWK.");
    }

    private static Collection<FamilyJwkFactory<Key, ?>> createDefaultFactories() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new SecretJwkFactory());
        arrayList.add(new AsymmetricJwkFactory(EcPublicJwkFactory.INSTANCE, new EcPrivateJwkFactory()));
        arrayList.add(new AsymmetricJwkFactory(RsaPublicJwkFactory.INSTANCE, new RsaPrivateJwkFactory()));
        arrayList.add(new AsymmetricJwkFactory(OctetPublicJwkFactory.INSTANCE, new OctetPrivateJwkFactory()));
        return arrayList;
    }

    private static UnsupportedKeyException noFamily(Key key, String str) {
        String str2;
        if (key != null) {
            str2 = "key of type " + key.getClass().getName();
        } else {
            str2 = "kty value '" + str + "'";
        }
        return new UnsupportedKeyException("Unable to create JWK for unrecognized " + str2 + ": there is no known JWK Factory capable of creating JWKs for this key type.");
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [io.jsonwebtoken.security.Jwk, io.jsonwebtoken.security.Jwk<java.security.Key>] */
    @Override // io.jsonwebtoken.impl.security.JwkFactory
    public Jwk<Key> createJwk(JwkContext<Key> jwkContext) {
        Assert.notNull(jwkContext, "JwkContext cannot be null.");
        Key key = jwkContext.getKey();
        String clean = Strings.clean(jwkContext.getType());
        assertKeyOrKeyType(key, clean);
        for (FamilyJwkFactory<Key, ?> familyJwkFactory : this.factories) {
            if (familyJwkFactory.supports(jwkContext)) {
                String str = (String) Assert.hasText(familyJwkFactory.getId(), "factory id cannot be null or empty.");
                if (clean == null) {
                    jwkContext.setType(str);
                }
                return familyJwkFactory.createJwk(jwkContext);
            }
        }
        throw noFamily(key, clean);
    }

    @Override // io.jsonwebtoken.impl.security.JwkFactory
    public JwkContext<Key> newContext(JwkContext<?> jwkContext, Key key) {
        Assert.notNull(jwkContext, "JwkContext cannot be null.");
        String type = jwkContext.getType();
        assertKeyOrKeyType(key, type);
        for (FamilyJwkFactory<Key, ?> familyJwkFactory : this.factories) {
            if (familyJwkFactory.supports(key) || familyJwkFactory.supports(jwkContext)) {
                return (JwkContext) Assert.notNull(familyJwkFactory.newContext(jwkContext, key), "FamilyJwkFactory implementation cannot return null JwkContexts.");
            }
        }
        throw noFamily(key, type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchingJwkFactory(Collection<? extends FamilyJwkFactory<?, ?>> collection) {
        Assert.notEmpty(collection, "FamilyJwkFactory collection cannot be null or empty.");
        this.factories = new ArrayList(collection.size());
        for (FamilyJwkFactory<?, ?> familyJwkFactory : collection) {
            Assert.hasText(familyJwkFactory.getId(), "FamilyJwkFactory.getFactoryId() cannot return null or empty.");
            this.factories.add(familyJwkFactory);
        }
    }
}
