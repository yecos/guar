package io.jsonwebtoken.impl;

import io.jsonwebtoken.ClaimsBuilder;
import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.impl.io.DelegateStringDecoder;
import io.jsonwebtoken.impl.io.StandardCompressionAlgorithms;
import io.jsonwebtoken.impl.lang.DefaultNestedCollection;
import io.jsonwebtoken.impl.lang.IdRegistry;
import io.jsonwebtoken.impl.lang.Services;
import io.jsonwebtoken.impl.security.ConstantKeyLocator;
import io.jsonwebtoken.impl.security.StandardEncryptionAlgorithms;
import io.jsonwebtoken.impl.security.StandardKeyAlgorithms;
import io.jsonwebtoken.impl.security.StandardSecureDigestAlgorithms;
import io.jsonwebtoken.io.CompressionAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.NestedCollection;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import java.io.InputStream;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public class DefaultJwtParserBuilder implements JwtParserBuilder {
    static final String MAX_CLOCK_SKEW_ILLEGAL_MSG = "Illegal allowedClockSkewMillis value: multiplying this value by 1000 to obtain the number of milliseconds would cause a numeric overflow.";
    static final long MAX_CLOCK_SKEW_MILLIS = 9223372036854775L;
    private static final int MILLISECONDS_PER_SECOND = 1000;
    private CompressionCodecResolver compressionCodecResolver;
    private Key decryptionKey;
    private Deserializer<Map<String, ?>> deserializer;
    private Locator<? extends Key> keyLocator;
    private Provider provider;
    private Key signatureVerificationKey;
    private boolean unsecured = false;
    private boolean unsecuredDecompression = false;
    private SigningKeyResolver signingKeyResolver = null;
    private Registry<String, AeadAlgorithm> encAlgs = Jwts.ENC.get();
    private Registry<String, KeyAlgorithm<?, ?>> keyAlgs = Jwts.KEY.get();
    private Registry<String, SecureDigestAlgorithm<?, ?>> sigAlgs = Jwts.SIG.get();
    private Registry<String, CompressionAlgorithm> zipAlgs = Jwts.ZIP.get();
    private Decoder<InputStream, InputStream> decoder = new DelegateStringDecoder(Decoders.BASE64URL);
    private final ClaimsBuilder expectedClaims = Jwts.claims();
    private Clock clock = DefaultClock.INSTANCE;
    private Set<String> critical = Collections.emptySet();
    private long allowedClockSkewMillis = 0;

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder b64Url(Decoder<InputStream, InputStream> decoder) {
        Assert.notNull(decoder, "decoder cannot be null.");
        this.decoder = decoder;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder base64UrlDecodeWith(Decoder<CharSequence, byte[]> decoder) {
        Assert.notNull(decoder, "decoder cannot be null.");
        return b64Url(new DelegateStringDecoder(decoder));
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder clock(Clock clock) {
        Assert.notNull(clock, "Clock instance cannot be null.");
        this.clock = clock;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder clockSkewSeconds(long j10) {
        Assert.isTrue(j10 <= MAX_CLOCK_SKEW_MILLIS, MAX_CLOCK_SKEW_ILLEGAL_MSG);
        this.allowedClockSkewMillis = Math.max(0L, j10 * 1000);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public NestedCollection<String, JwtParserBuilder> critical() {
        return new DefaultNestedCollection<String, JwtParserBuilder>(this, this.critical) { // from class: io.jsonwebtoken.impl.DefaultJwtParserBuilder.1
            @Override // io.jsonwebtoken.impl.lang.DefaultCollectionMutator
            public void changed() {
                DefaultJwtParserBuilder.this.critical = Collections.asSet(getCollection());
            }
        };
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder decryptWith(SecretKey secretKey) {
        return decryptWith((Key) secretKey);
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder deserializeJsonWith(Deserializer<Map<String, ?>> deserializer) {
        return json(deserializer);
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public NestedCollection<AeadAlgorithm, JwtParserBuilder> enc() {
        return new DefaultNestedCollection<AeadAlgorithm, JwtParserBuilder>(this, this.encAlgs.values()) { // from class: io.jsonwebtoken.impl.DefaultJwtParserBuilder.3
            @Override // io.jsonwebtoken.impl.lang.DefaultCollectionMutator
            public void changed() {
                DefaultJwtParserBuilder.this.encAlgs = new IdRegistry(StandardEncryptionAlgorithms.NAME, getCollection());
            }
        };
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder json(Deserializer<Map<String, ?>> deserializer) {
        this.deserializer = (Deserializer) Assert.notNull(deserializer, "JSON Deserializer cannot be null.");
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public NestedCollection<KeyAlgorithm<?, ?>, JwtParserBuilder> key() {
        return new DefaultNestedCollection<KeyAlgorithm<?, ?>, JwtParserBuilder>(this, this.keyAlgs.values()) { // from class: io.jsonwebtoken.impl.DefaultJwtParserBuilder.5
            @Override // io.jsonwebtoken.impl.lang.DefaultCollectionMutator
            public void changed() {
                DefaultJwtParserBuilder.this.keyAlgs = new IdRegistry(StandardKeyAlgorithms.NAME, getCollection());
            }
        };
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder keyLocator(Locator<Key> locator) {
        this.keyLocator = (Locator) Assert.notNull(locator, "Key locator cannot be null.");
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder provider(Provider provider) {
        this.provider = provider;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder require(String str, Object obj) {
        Assert.hasText(str, "claim name cannot be null or empty.");
        Assert.notNull(obj, "The value cannot be null for claim name: " + str);
        this.expectedClaims.add(str, obj);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireAudience(String str) {
        this.expectedClaims.audience().add((ClaimsMutator.AudienceCollection<ClaimsBuilder>) str).and();
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireExpiration(Date date) {
        this.expectedClaims.setExpiration(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireId(String str) {
        this.expectedClaims.setId(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireIssuedAt(Date date) {
        this.expectedClaims.setIssuedAt(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireIssuer(String str) {
        this.expectedClaims.setIssuer(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireNotBefore(Date date) {
        this.expectedClaims.setNotBefore(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireSubject(String str) {
        this.expectedClaims.setSubject(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setAllowedClockSkewSeconds(long j10) {
        return clockSkewSeconds(j10);
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setClock(Clock clock) {
        return clock(clock);
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver) {
        this.compressionCodecResolver = (CompressionCodecResolver) Assert.notNull(compressionCodecResolver, "CompressionCodecResolver cannot be null.");
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setSigningKey(byte[] bArr) {
        Assert.notEmpty(bArr, "signature verification key cannot be null or empty.");
        return setSigningKey(Keys.hmacShaKeyFor(bArr));
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setSigningKeyResolver(SigningKeyResolver signingKeyResolver) {
        Assert.notNull(signingKeyResolver, "SigningKeyResolver cannot be null.");
        this.signingKeyResolver = signingKeyResolver;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public NestedCollection<SecureDigestAlgorithm<?, ?>, JwtParserBuilder> sig() {
        return new DefaultNestedCollection<SecureDigestAlgorithm<?, ?>, JwtParserBuilder>(this, this.sigAlgs.values()) { // from class: io.jsonwebtoken.impl.DefaultJwtParserBuilder.4
            @Override // io.jsonwebtoken.impl.lang.DefaultCollectionMutator
            public void changed() {
                DefaultJwtParserBuilder.this.sigAlgs = new IdRegistry(StandardSecureDigestAlgorithms.NAME, getCollection());
            }
        };
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder unsecured() {
        this.unsecured = true;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder unsecuredDecompression() {
        this.unsecuredDecompression = true;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder verifyWith(SecretKey secretKey) {
        return verifyWith((Key) secretKey);
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public NestedCollection<CompressionAlgorithm, JwtParserBuilder> zip() {
        return new DefaultNestedCollection<CompressionAlgorithm, JwtParserBuilder>(this, this.zipAlgs.values()) { // from class: io.jsonwebtoken.impl.DefaultJwtParserBuilder.2
            @Override // io.jsonwebtoken.impl.lang.DefaultCollectionMutator
            public void changed() {
                DefaultJwtParserBuilder.this.zipAlgs = new IdRegistry(StandardCompressionAlgorithms.NAME, getCollection());
            }
        };
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.lang.Builder
    public JwtParser build() {
        if (this.deserializer == null) {
            json((Deserializer) Services.get(Deserializer.class));
        }
        if (this.signingKeyResolver != null && this.signatureVerificationKey != null) {
            throw new IllegalStateException("Both a 'signingKeyResolver and a 'verifyWith' key cannot be configured. Choose either, or prefer `keyLocator` when possible.");
        }
        Locator locator = this.keyLocator;
        if (locator != null) {
            if (this.signatureVerificationKey != null) {
                throw new IllegalStateException("Both 'keyLocator' and a 'verifyWith' key cannot be configured. Prefer 'keyLocator' if possible.");
            }
            if (this.decryptionKey != null) {
                throw new IllegalStateException("Both 'keyLocator' and a 'decryptWith' key cannot be configured. Prefer 'keyLocator' if possible.");
            }
        }
        if (locator == null) {
            locator = new ConstantKeyLocator(this.signatureVerificationKey, this.decryptionKey);
        }
        Locator locator2 = locator;
        if (!this.unsecured && this.unsecuredDecompression) {
            throw new IllegalStateException("'unsecuredDecompression' is only relevant if 'unsecured' is also configured. Please read the JavaDoc of both features before enabling either due to their security implications.");
        }
        if (this.compressionCodecResolver != null && !Jwts.ZIP.get().equals(this.zipAlgs)) {
            throw new IllegalStateException("Both 'zip()' and 'compressionCodecResolver' cannot be configured. Choose either.");
        }
        Assert.stateNotNull(locator2, "Key locator should never be null.");
        return new DefaultJwtParser(this.provider, this.signingKeyResolver, this.unsecured, this.unsecuredDecompression, locator2, this.clock, this.critical, this.allowedClockSkewMillis, (DefaultClaims) this.expectedClaims.build(), this.decoder, this.deserializer, this.compressionCodecResolver, this.zipAlgs, this.sigAlgs, this.keyAlgs, this.encAlgs);
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder decryptWith(PrivateKey privateKey) {
        return decryptWith((Key) privateKey);
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder verifyWith(PublicKey publicKey) {
        return verifyWith((Key) publicKey);
    }

    private JwtParserBuilder decryptWith(Key key) {
        if (!(key instanceof PublicKey)) {
            this.decryptionKey = (Key) Assert.notNull(key, "decryption key cannot be null.");
            return this;
        }
        throw new IllegalArgumentException("PublicKeys may not be used to decrypt data. PublicKeys are used to encrypt, and PrivateKeys are used to decrypt.");
    }

    private JwtParserBuilder verifyWith(Key key) {
        if (!(key instanceof PrivateKey)) {
            this.signatureVerificationKey = (Key) Assert.notNull(key, "signature verification key cannot be null.");
            return this;
        }
        throw new IllegalArgumentException("PrivateKeys may not be used to verify digital signatures. PrivateKeys are used to sign, and PublicKeys are used to verify.");
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setSigningKey(String str) {
        Assert.hasText(str, "signature verification key cannot be null or empty.");
        return setSigningKey(Decoders.BASE64.decode(str));
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setSigningKey(Key key) {
        if (key instanceof SecretKey) {
            return verifyWith((SecretKey) key);
        }
        if (key instanceof PublicKey) {
            return verifyWith((PublicKey) key);
        }
        throw new InvalidKeyException("JWS verification key must be either a SecretKey (for MAC algorithms) or a PublicKey (for Signature algorithms).");
    }
}
