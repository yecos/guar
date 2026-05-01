package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.DefaultNestedCollection;
import io.jsonwebtoken.impl.lang.DelegatingMap;
import io.jsonwebtoken.impl.lang.DelegatingMapMutator;
import io.jsonwebtoken.impl.lang.IdRegistry;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterBuilder;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.NestedCollection;
import io.jsonwebtoken.security.HashAlgorithm;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.JwkBuilder;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.KeyOperation;
import io.jsonwebtoken.security.KeyOperationPolicied;
import io.jsonwebtoken.security.KeyOperationPolicy;
import io.jsonwebtoken.security.MalformedKeyException;
import io.jsonwebtoken.security.SecretJwk;
import io.jsonwebtoken.security.SecretJwkBuilder;
import io.jsonwebtoken.security.SecurityBuilder;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Set;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
abstract class AbstractJwkBuilder<K extends Key, J extends Jwk<K>, T extends JwkBuilder<K, J, T>> extends DelegatingMapMutator<String, Object, JwkContext<K>, T> implements JwkBuilder<K, J, T> {
    static final KeyOperationPolicy DEFAULT_OPERATION_POLICY = Jwks.OP.policy().build();
    protected final JwkFactory<K, J> jwkFactory;
    protected KeyOperationPolicy opsPolicy;

    public static class DefaultSecretJwkBuilder extends AbstractJwkBuilder<SecretKey, SecretJwk, SecretJwkBuilder> implements SecretJwkBuilder {
        public DefaultSecretJwkBuilder(JwkContext<SecretKey> jwkContext) {
            super(jwkContext);
            DefaultMacAlgorithm findByKey = DefaultMacAlgorithm.findByKey((Key) Assert.notNull(jwkContext.getKey(), "SecretKey cannot be null."));
            if (findByKey != null) {
                algorithm(findByKey.getId());
            }
        }

        @Override // io.jsonwebtoken.impl.security.AbstractJwkBuilder, io.jsonwebtoken.lang.Builder
        public /* bridge */ /* synthetic */ Object build() {
            return super.build();
        }

        @Override // io.jsonwebtoken.impl.security.AbstractJwkBuilder, io.jsonwebtoken.security.KeyOperationPolicied
        /* renamed from: operationPolicy */
        public /* bridge */ /* synthetic */ KeyOperationPolicied mo91operationPolicy(KeyOperationPolicy keyOperationPolicy) {
            return super.mo91operationPolicy(keyOperationPolicy);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractJwkBuilder, io.jsonwebtoken.security.SecurityBuilder
        public /* bridge */ /* synthetic */ SecurityBuilder provider(Provider provider) {
            return super.provider(provider);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractJwkBuilder, io.jsonwebtoken.security.SecurityBuilder
        public /* bridge */ /* synthetic */ SecurityBuilder random(SecureRandom secureRandom) {
            return super.random(secureRandom);
        }
    }

    public AbstractJwkBuilder(JwkContext<K> jwkContext) {
        this(jwkContext, DispatchingJwkFactory.DEFAULT_INSTANCE);
    }

    @Override // io.jsonwebtoken.security.JwkBuilder
    public T algorithm(String str) {
        Assert.hasText(str, "Algorithm cannot be null or empty.");
        ((JwkContext) this.DELEGATE).setAlgorithm(str);
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.JwkBuilder
    public T id(String str) {
        Assert.hasText(str, "Id cannot be null or empty.");
        ((JwkContext) this.DELEGATE).setIdThumbprintAlgorithm(null);
        ((JwkContext) this.DELEGATE).setId(str);
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.JwkBuilder
    public T idFromThumbprint() {
        return idFromThumbprint(Jwks.HASH.SHA256);
    }

    public <A extends Key> JwkContext<A> newContext(A a10) {
        return this.jwkFactory.newContext((JwkContext) this.DELEGATE, a10);
    }

    @Override // io.jsonwebtoken.security.JwkBuilder
    public NestedCollection<KeyOperation, T> operations() {
        return new DefaultNestedCollection<KeyOperation, T>((JwkBuilder) self(), ((JwkContext) this.DELEGATE).getOperations()) { // from class: io.jsonwebtoken.impl.security.AbstractJwkBuilder.1
            @Override // io.jsonwebtoken.impl.lang.DefaultCollectionMutator
            public void changed() {
                Collection<KeyOperation> collection = getCollection();
                AbstractJwkBuilder.this.opsPolicy.validate(collection);
                ((JwkContext) ((DelegatingMap) AbstractJwkBuilder.this).DELEGATE).setOperations(collection);
            }
        };
    }

    public AbstractJwkBuilder(JwkContext<K> jwkContext, JwkFactory<K, J> jwkFactory) {
        super(jwkContext);
        this.opsPolicy = DEFAULT_OPERATION_POLICY;
        this.jwkFactory = (JwkFactory) Assert.notNull(jwkFactory, "JwkFactory cannot be null.");
    }

    @Override // io.jsonwebtoken.lang.Builder
    public J build() {
        Assert.stateNotNull(this.DELEGATE, "JwkContext should always be non-null");
        if (((JwkContext) this.DELEGATE).getKey() == null && isEmpty()) {
            throw new IllegalStateException("A " + Key.class.getName() + " or one or more name/value pairs must be provided to create a JWK.");
        }
        try {
            this.opsPolicy.validate((Collection) ((JwkContext) this.DELEGATE).get((Parameter) AbstractJwk.KEY_OPS));
            return this.jwkFactory.createJwk((JwkContext) this.DELEGATE);
        } catch (IllegalArgumentException e10) {
            throw new MalformedKeyException("Unable to create JWK: " + e10.getMessage(), e10);
        }
    }

    @Override // io.jsonwebtoken.security.JwkBuilder
    public T idFromThumbprint(HashAlgorithm hashAlgorithm) {
        Assert.notNull(hashAlgorithm, "Thumbprint HashAlgorithm cannot be null.");
        Assert.notNull(hashAlgorithm.getId(), "Thumbprint HashAlgorithm ID cannot be null.");
        ((JwkContext) this.DELEGATE).setId(null);
        ((JwkContext) this.DELEGATE).setIdThumbprintAlgorithm(hashAlgorithm);
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.KeyOperationPolicied
    /* renamed from: operationPolicy */
    public T mo91operationPolicy(KeyOperationPolicy keyOperationPolicy) {
        Assert.notNull(keyOperationPolicy, "Policy cannot be null.");
        Collection<KeyOperation> operations = keyOperationPolicy.getOperations();
        Assert.notEmpty(operations, "Policy operations cannot be null or empty.");
        this.opsPolicy = keyOperationPolicy;
        ParameterBuilder parameterBuilder = Parameters.builder(KeyOperation.class).setConverter(new KeyOperationConverter(new IdRegistry("JSON Web Key Operation", operations))).set();
        Parameter<Set<KeyOperation>> parameter = AbstractJwk.KEY_OPS;
        setDelegate(((JwkContext) this.DELEGATE).parameter(parameterBuilder.setId(parameter.getId()).setName(parameter.getName()).build()));
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.SecurityBuilder
    public T provider(Provider provider) {
        ((JwkContext) this.DELEGATE).setProvider(provider);
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.SecurityBuilder
    public T random(SecureRandom secureRandom) {
        ((JwkContext) this.DELEGATE).setRandom(secureRandom);
        return (T) self();
    }
}
