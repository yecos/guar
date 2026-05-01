package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.io.Base64UrlStreamEncoder;
import io.jsonwebtoken.impl.io.ByteBase64UrlStreamEncoder;
import io.jsonwebtoken.impl.io.CountingInputStream;
import io.jsonwebtoken.impl.io.EncodingOutputStream;
import io.jsonwebtoken.impl.io.NamedSerializer;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.io.UncloseableInputStream;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.impl.lang.Functions;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Services;
import io.jsonwebtoken.impl.security.DefaultAeadRequest;
import io.jsonwebtoken.impl.security.DefaultAeadResult;
import io.jsonwebtoken.impl.security.DefaultKeyRequest;
import io.jsonwebtoken.impl.security.DefaultSecureRequest;
import io.jsonwebtoken.impl.security.Pbes2HsAkwAlgorithm;
import io.jsonwebtoken.impl.security.ProviderKey;
import io.jsonwebtoken.impl.security.StandardSecureDigestAlgorithms;
import io.jsonwebtoken.io.CompressionAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.CollectionMutator;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.NestedCollection;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.AeadRequest;
import io.jsonwebtoken.security.AeadResult;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.KeyRequest;
import io.jsonwebtoken.security.KeyResult;
import io.jsonwebtoken.security.Password;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.SecurityException;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.UnsupportedKeyException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class DefaultJwtBuilder implements JwtBuilder {
    private static final String PRIV_KEY_ENC_MSG = "PrivateKeys may not be used to encrypt data. PublicKeys are used to encrypt, and PrivateKeys are used to decrypt.";
    private static final String PUB_KEY_SIGN_MSG = "PublicKeys may not be used to create digital signatures. PrivateKeys are used to sign, and PublicKeys are used to verify.";
    private final DefaultBuilderClaims claimsBuilder;
    protected CompressionAlgorithm compressionAlgorithm;
    private AeadAlgorithm enc;
    private final DefaultBuilderHeader headerBuilder;
    private Key key;
    private KeyAlgorithm<Key, ?> keyAlg;
    private Function<KeyRequest<Key>, KeyResult> keyAlgFunction;
    protected Provider provider;
    protected SecureRandom secureRandom;
    private Serializer<Map<String, ?>> serializer;
    private Function<SecureRequest<InputStream, Key>, byte[]> signFunction;
    private Payload payload = Payload.EMPTY;
    private SecureDigestAlgorithm<Key, ?> sigAlg = Jwts.SIG.NONE;
    protected Encoder<OutputStream, OutputStream> encoder = Base64UrlStreamEncoder.INSTANCE;
    private boolean encodePayload = true;

    public static class DefaultBuilderClaims extends DelegatingClaimsMutator<JwtBuilder.BuilderClaims> implements JwtBuilder.BuilderClaims {
        private final JwtBuilder builder;

        /* JADX INFO: Access modifiers changed from: private */
        public Claims build() {
            return new DefaultClaims((ParameterMap) this.DELEGATE);
        }

        private DefaultBuilderClaims(JwtBuilder jwtBuilder) {
            this.builder = jwtBuilder;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.jsonwebtoken.lang.Conjunctor
        public JwtBuilder and() {
            return this.builder;
        }
    }

    public static class DefaultBuilderHeader extends DefaultJweHeaderBuilder<JwtBuilder.BuilderHeader> implements JwtBuilder.BuilderHeader {
        private final JwtBuilder builder;

        /* JADX INFO: Access modifiers changed from: private */
        public Header build() {
            return new DefaultJwtHeaderBuilder(this).build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T> T get(Parameter<T> parameter) {
            return (T) ((ParameterMap) this.DELEGATE).get((Parameter) parameter);
        }

        private DefaultBuilderHeader(JwtBuilder jwtBuilder) {
            this.builder = (JwtBuilder) Assert.notNull(jwtBuilder, "JwtBuilder cannot be null.");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.jsonwebtoken.lang.Conjunctor
        public JwtBuilder and() {
            return this.builder;
        }
    }

    public DefaultJwtBuilder() {
        this.headerBuilder = new DefaultBuilderHeader(this);
        this.claimsBuilder = new DefaultBuilderClaims(this);
    }

    private void assertPayloadEncoding(String str) {
        if (this.encodePayload) {
            return;
        }
        throw new IllegalArgumentException("Payload encoding may not be disabled for " + str + "s, only JWSs.");
    }

    private OutputStream encode(OutputStream outputStream, String str) {
        return new EncodingOutputStream(this.encoder.encode(outputStream), "base64url", str);
    }

    private void encodeAndWrite(String str, Map<String, ?> map, OutputStream outputStream) {
        writeAndClose(str, map, encode(outputStream, str));
    }

    private void encrypt(final AeadRequest aeadRequest, final AeadResult aeadResult) {
        Functions.wrap(new Function<Object, Object>() { // from class: io.jsonwebtoken.impl.DefaultJwtBuilder.3
            @Override // io.jsonwebtoken.impl.lang.Function
            public Object apply(Object obj) {
                DefaultJwtBuilder.this.enc.encrypt(aeadRequest, aeadResult);
                return null;
            }
        }, SecurityException.class, "%s encryption failed.", this.enc.getId()).apply(null);
    }

    public static <K extends Key> SecureDigestAlgorithm<K, ?> forSigningKey(K k10) {
        Assert.notNull(k10, "Key cannot be null.");
        SecureDigestAlgorithm<K, ?> findBySigningKey = StandardSecureDigestAlgorithms.findBySigningKey(k10);
        if (findBySigningKey != null) {
            return findBySigningKey;
        }
        throw new UnsupportedKeyException("Unable to determine a suitable MAC or Signature algorithm for the specified key using available heuristics: either the key size is too weak be used with available algorithms, or the key size is unavailable (e.g. if using a PKCS11 or HSM (Hardware Security Module) key store). If you are using a PKCS11 or HSM keystore, consider using the JwtBuilder.signWith(Key, SecureDigestAlgorithm) method instead.");
    }

    private String sign(Payload payload, Key key, Provider provider) {
        InputStream inputStream;
        InputStream sequenceInputStream;
        Assert.stateNotNull(key, "Key is required.");
        Assert.stateNotNull(this.sigAlg, "SignatureAlgorithm is required.");
        Assert.stateNotNull(this.signFunction, "Signature Algorithm function cannot be null.");
        Assert.stateNotNull(payload, "Payload argument cannot be null.");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        this.headerBuilder.add(DefaultHeader.ALGORITHM.getId(), this.sigAlg.getId());
        if (!this.encodePayload) {
            String id = DefaultJwsHeader.B64.getId();
            ((JwtBuilder.BuilderHeader) ((NestedCollection) this.headerBuilder.critical().add((CollectionMutator) id)).and()).add(id, Boolean.FALSE);
        }
        encodeAndWrite("JWS Protected Header", (JwsHeader) Assert.isInstanceOf(JwsHeader.class, this.headerBuilder.build()), byteArrayOutputStream);
        byteArrayOutputStream.write(46);
        if (this.encodePayload) {
            encodeAndWrite("JWS Payload", payload, byteArrayOutputStream);
            sequenceInputStream = Streams.of(byteArrayOutputStream.toByteArray());
            inputStream = null;
        } else {
            InputStream of = Streams.of(byteArrayOutputStream.toByteArray());
            inputStream = toInputStream("JWS Unencoded Payload", payload);
            if (!payload.isClaims()) {
                inputStream = new CountingInputStream(inputStream);
            }
            if (inputStream.markSupported()) {
                inputStream.mark(0);
            }
            sequenceInputStream = new SequenceInputStream(of, new UncloseableInputStream(inputStream));
        }
        try {
            byte[] apply = this.signFunction.apply(new DefaultSecureRequest(sequenceInputStream, provider, this.secureRandom, key));
            if (!this.encodePayload) {
                if (!payload.isCompressed() && (payload.isClaims() || payload.isString())) {
                    Streams.copy(inputStream, byteArrayOutputStream, new byte[8192], "Unable to copy attached Payload InputStream.");
                }
                if ((inputStream instanceof CountingInputStream) && ((CountingInputStream) inputStream).getCount() <= 0) {
                    throw new IllegalStateException("'b64' Unencoded payload option has been specified, but payload is empty.");
                }
            }
            Streams.reset(inputStream);
            byteArrayOutputStream.write(46);
            encodeAndWrite("JWS Signature", apply, byteArrayOutputStream);
            return Strings.utf8(byteArrayOutputStream.toByteArray());
        } catch (Throwable th) {
            Streams.reset(inputStream);
            throw th;
        }
    }

    private InputStream toInputStream(String str, Payload payload) {
        if (!payload.isClaims() && !payload.isCompressed()) {
            return (InputStream) Assert.stateNotNull(payload.toInputStream(), "Payload InputStream cannot be null.");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        writeAndClose(str, payload, byteArrayOutputStream);
        return Streams.of(byteArrayOutputStream.toByteArray());
    }

    private String unprotected(Payload payload) {
        Assert.stateNotNull(payload, "Content argument cannot be null.");
        assertPayloadEncoding("unprotected JWT");
        this.headerBuilder.add(DefaultHeader.ALGORITHM.getId(), Jwts.SIG.NONE.getId());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        encodeAndWrite("JWT Header", this.headerBuilder.build(), byteArrayOutputStream);
        byteArrayOutputStream.write(46);
        encodeAndWrite("JWT Payload", payload, byteArrayOutputStream);
        byteArrayOutputStream.write(46);
        return Strings.ascii(byteArrayOutputStream.toByteArray());
    }

    private void writeAndClose(String str, Map<String, ?> map, OutputStream outputStream) {
        try {
            new NamedSerializer(str, this.serializer).serialize(map, outputStream);
            Objects.nullSafeClose(outputStream);
        } catch (Throwable th) {
            Objects.nullSafeClose(outputStream);
            throw th;
        }
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder addClaims(Map<String, ?> map) {
        return claims(map);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public ClaimsMutator.AudienceCollection<JwtBuilder> audience() {
        return new DelegateAudienceCollection(this, claims().audience());
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder b64Url(Encoder<OutputStream, OutputStream> encoder) {
        Assert.notNull(encoder, "encoder cannot be null.");
        this.encoder = encoder;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder base64UrlEncodeWith(Encoder<byte[], String> encoder) {
        return b64Url(new ByteBase64UrlStreamEncoder(encoder));
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder claim(String str, Object obj) {
        return claims().add(str, obj).and();
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder.BuilderClaims claims() {
        return this.claimsBuilder;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public String compact() {
        boolean z10 = this.enc != null;
        if (z10 && this.signFunction != null) {
            throw new IllegalStateException("Both 'signWith' and 'encryptWith' cannot be specified. Choose either one.");
        }
        Payload payload = (Payload) Assert.stateNotNull(this.payload, "Payload instance null, internal error");
        Claims build = this.claimsBuilder.build();
        if (z10 && payload.isEmpty() && Collections.isEmpty(build)) {
            throw new IllegalStateException("Encrypted JWTs must have either 'claims' or non-empty 'content'.");
        }
        if (!payload.isEmpty() && !Collections.isEmpty(build)) {
            throw new IllegalStateException("Both 'content' and 'claims' cannot be specified. Choose either one.");
        }
        if (this.serializer == null) {
            json((Serializer) Services.get(Serializer.class));
        }
        if (!Collections.isEmpty(build)) {
            payload = new Payload(build);
        }
        if (this.compressionAlgorithm != null && !payload.isEmpty()) {
            payload.setZip(this.compressionAlgorithm);
            this.headerBuilder.put((DefaultBuilderHeader) DefaultHeader.COMPRESSION_ALGORITHM.getId(), this.compressionAlgorithm.getId());
        }
        if (Strings.hasText(payload.getContentType())) {
            this.headerBuilder.contentType(payload.getContentType());
        }
        Provider provider = ProviderKey.getProvider(this.key, this.provider);
        Key key = ProviderKey.getKey(this.key);
        return z10 ? encrypt(payload, key, provider) : key != null ? sign(payload, key, provider) : unprotected(payload);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder compressWith(CompressionAlgorithm compressionAlgorithm) {
        Assert.notNull(compressionAlgorithm, "CompressionAlgorithm cannot be null");
        Assert.hasText(compressionAlgorithm.getId(), "CompressionAlgorithm id cannot be null or empty.");
        this.compressionAlgorithm = compressionAlgorithm;
        return ((JwtBuilder.BuilderHeader) header().delete(DefaultHeader.COMPRESSION_ALGORITHM.getId())).and();
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder content(String str) {
        if (Strings.hasText(str)) {
            this.payload = new Payload(str, (String) null);
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder encodePayload(boolean z10) {
        this.encodePayload = z10;
        Parameter<Set<String>> parameter = DefaultProtectedHeader.CRIT;
        String id = parameter.getId();
        String id2 = DefaultJwsHeader.B64.getId();
        LinkedHashSet linkedHashSet = new LinkedHashSet(Collections.nullSafe((Set) this.headerBuilder.get((Parameter) parameter)));
        linkedHashSet.remove(id2);
        return ((JwtBuilder.BuilderHeader) ((JwtBuilder.BuilderHeader) header().delete(id2)).add(id, linkedHashSet)).and();
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder encryptWith(SecretKey secretKey, AeadAlgorithm aeadAlgorithm) {
        return secretKey instanceof Password ? encryptWith((Password) secretKey, new Pbes2HsAkwAlgorithm(aeadAlgorithm.getKeyBitLength()), aeadAlgorithm) : encryptWith(secretKey, Jwts.KEY.DIRECT, aeadAlgorithm);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder.BuilderHeader header() {
        return this.headerBuilder;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder json(Serializer<Map<String, ?>> serializer) {
        this.serializer = (Serializer) Assert.notNull(serializer, "JSON Serializer cannot be null.");
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder provider(Provider provider) {
        this.provider = provider;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder random(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder serializeToJsonWith(Serializer<Map<String, ?>> serializer) {
        return json(serializer);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setClaims(Map<String, ?> map) {
        Assert.notNull(map, "Claims map cannot be null.");
        return claims().empty().add(map).and();
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setHeader(Map<String, ?> map) {
        return ((JwtBuilder.BuilderHeader) ((JwtBuilder.BuilderHeader) header().empty()).add(map)).and();
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setHeaderParam(String str, Object obj) {
        return ((JwtBuilder.BuilderHeader) header().add(str, obj)).and();
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setHeaderParams(Map<String, ?> map) {
        return ((JwtBuilder.BuilderHeader) header().add(map)).and();
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setPayload(String str) {
        return content(str);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(Key key) {
        Assert.notNull(key, "Key argument cannot be null.");
        return signWith((DefaultJwtBuilder) key, (SecureDigestAlgorithm<? super DefaultJwtBuilder, ?>) forSigningKey(key));
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder claims(Map<String, ?> map) {
        return claims().add(map).and();
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder expiration(Date date) {
        return claims().expiration(date).and();
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder id(String str) {
        return claims().id(str).and();
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder issuedAt(Date date) {
        return claims().issuedAt(date).and();
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder issuer(String str) {
        return claims().issuer(str).and();
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder notBefore(Date date) {
        return claims().notBefore(date).and();
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder setAudience(String str) {
        return claims().setAudience(str).and();
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder setExpiration(Date date) {
        return expiration(date);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder setId(String str) {
        return id(str);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder setIssuedAt(Date date) {
        return issuedAt(date);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder setIssuer(String str) {
        return issuer(str);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder setNotBefore(Date date) {
        return notBefore(date);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder setSubject(String str) {
        return subject(str);
    }

    @Override // io.jsonwebtoken.ClaimsMutator
    public JwtBuilder subject(String str) {
        return claims().subject(str).and();
    }

    private void encodeAndWrite(String str, Payload payload, OutputStream outputStream) {
        writeAndClose(str, payload, encode(outputStream, str));
    }

    private String encrypt(Payload payload, Key key, Provider provider) {
        Assert.stateNotNull(payload, "Payload argument cannot be null.");
        Assert.stateNotNull(key, "Key is required.");
        Assert.stateNotNull(this.enc, "Encryption algorithm is required.");
        Assert.stateNotNull(this.keyAlg, "KeyAlgorithm is required.");
        Assert.stateNotNull(this.keyAlgFunction, "KeyAlgorithm function cannot be null.");
        assertPayloadEncoding("JWE");
        InputStream inputStream = toInputStream("JWE Payload", payload);
        KeyResult apply = this.keyAlgFunction.apply(new DefaultKeyRequest(key, provider, this.secureRandom, new DefaultMutableJweHeader(this.headerBuilder), this.enc));
        Assert.stateNotNull(apply, "KeyAlgorithm must return a KeyResult.");
        SecretKey secretKey = (SecretKey) Assert.notNull(apply.getKey(), "KeyResult must return a content encryption key.");
        byte[] bArr = (byte[]) Assert.notNull(apply.getPayload(), "KeyResult must return an encrypted key byte array, even if empty.");
        this.headerBuilder.add(DefaultHeader.ALGORITHM.getId(), this.keyAlg.getId());
        this.headerBuilder.put((DefaultBuilderHeader) DefaultJweHeader.ENCRYPTION_ALGORITHM.getId(), this.enc.getId());
        Map<String, ?> map = (JweHeader) Assert.isInstanceOf(JweHeader.class, this.headerBuilder.build(), "Invalid header created: ");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        encodeAndWrite("JWE Protected Header", map, byteArrayOutputStream);
        InputStream of = Streams.of(byteArrayOutputStream.toByteArray());
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(8192);
        AeadRequest defaultAeadRequest = new DefaultAeadRequest(inputStream, null, this.secureRandom, secretKey, of);
        DefaultAeadResult defaultAeadResult = new DefaultAeadResult(byteArrayOutputStream2);
        encrypt(defaultAeadRequest, defaultAeadResult);
        byte[] notEmpty = Assert.notEmpty(defaultAeadResult.getIv(), "Encryption result must have a non-empty initialization vector.");
        byte[] notEmpty2 = Assert.notEmpty(defaultAeadResult.getDigest(), "Encryption result must have a non-empty authentication tag.");
        byte[] notEmpty3 = Assert.notEmpty(byteArrayOutputStream2.toByteArray(), "Encryption result must have non-empty ciphertext.");
        byteArrayOutputStream.write(46);
        encodeAndWrite("JWE Encrypted CEK", bArr, byteArrayOutputStream);
        byteArrayOutputStream.write(46);
        encodeAndWrite("JWE Initialization Vector", notEmpty, byteArrayOutputStream);
        byteArrayOutputStream.write(46);
        encodeAndWrite("JWE Ciphertext", notEmpty3, byteArrayOutputStream);
        byteArrayOutputStream.write(46);
        encodeAndWrite("JWE AAD Tag", notEmpty2, byteArrayOutputStream);
        return Strings.utf8(byteArrayOutputStream.toByteArray());
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder content(byte[] bArr) {
        if (!Bytes.isEmpty(bArr)) {
            this.payload = new Payload(bArr, (String) null);
        }
        return this;
    }

    private void writeAndClose(String str, Payload payload, OutputStream outputStream) {
        OutputStream compress = payload.compress(outputStream);
        if (payload.isClaims()) {
            writeAndClose(str, payload.getRequiredClaims(), compress);
            return;
        }
        try {
            Streams.copy(payload.toInputStream(), compress, new byte[4096], "Unable to copy payload.");
            Objects.nullSafeClose(compress);
        } catch (Throwable th) {
            Objects.nullSafeClose(compress);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.jsonwebtoken.JwtBuilder
    public <K extends Key> JwtBuilder encryptWith(K k10, final KeyAlgorithm<? super K, ?> keyAlgorithm, AeadAlgorithm aeadAlgorithm) {
        this.enc = (AeadAlgorithm) Assert.notNull(aeadAlgorithm, "Encryption algorithm cannot be null.");
        Assert.hasText(aeadAlgorithm.getId(), "Encryption algorithm id cannot be null or empty.");
        Assert.notNull(k10, "Encryption key cannot be null.");
        if (!(k10 instanceof PrivateKey)) {
            Assert.notNull(keyAlgorithm, "KeyAlgorithm cannot be null.");
            String str = (String) Assert.hasText(keyAlgorithm.getId(), "KeyAlgorithm id cannot be null or empty.");
            this.key = k10;
            this.keyAlg = keyAlgorithm;
            this.keyAlgFunction = Functions.wrap(new Function<KeyRequest<Key>, KeyResult>() { // from class: io.jsonwebtoken.impl.DefaultJwtBuilder.2
                @Override // io.jsonwebtoken.impl.lang.Function
                public KeyResult apply(KeyRequest<Key> keyRequest) {
                    return keyAlgorithm.getEncryptionKey(keyRequest);
                }
            }, SecurityException.class, "Unable to obtain content encryption key from key management algorithm '%s'.", str);
            return this;
        }
        throw new IllegalArgumentException(PRIV_KEY_ENC_MSG);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.jsonwebtoken.JwtBuilder
    public <K extends Key> JwtBuilder signWith(K k10, SecureDigestAlgorithm<? super K, ?> secureDigestAlgorithm) {
        Assert.notNull(k10, "Key argument cannot be null.");
        if (!(k10 instanceof PublicKey)) {
            Assert.notNull(secureDigestAlgorithm, "SignatureAlgorithm cannot be null.");
            String str = (String) Assert.hasText(secureDigestAlgorithm.getId(), "SignatureAlgorithm id cannot be null or empty.");
            if (!Jwts.SIG.NONE.getId().equalsIgnoreCase(str)) {
                this.key = k10;
                this.sigAlg = secureDigestAlgorithm;
                this.signFunction = Functions.wrap(new Function<SecureRequest<InputStream, Key>, byte[]>() { // from class: io.jsonwebtoken.impl.DefaultJwtBuilder.1
                    @Override // io.jsonwebtoken.impl.lang.Function
                    public byte[] apply(SecureRequest<InputStream, Key> secureRequest) {
                        return DefaultJwtBuilder.this.sigAlg.digest(secureRequest);
                    }
                }, SignatureException.class, "Unable to compute %s signature.", str);
                return this;
            }
            throw new IllegalArgumentException("The 'none' JWS algorithm cannot be used to sign JWTs.");
        }
        throw new IllegalArgumentException(PUB_KEY_SIGN_MSG);
    }

    private void encodeAndWrite(String str, byte[] bArr, OutputStream outputStream) {
        Streams.writeAndClose(encode(outputStream, str), bArr, "Unable to write bytes");
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder content(InputStream inputStream) {
        if (inputStream != null) {
            this.payload = new Payload(inputStream, (String) null);
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder content(byte[] bArr, String str) {
        Assert.notEmpty(bArr, "content byte array cannot be null or empty.");
        Assert.hasText(str, "Content Type String cannot be null or empty.");
        this.payload = new Payload(bArr, str);
        return ((JwtBuilder.BuilderHeader) header().delete(DefaultHeader.CONTENT_TYPE.getId())).and();
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder content(String str, String str2) {
        Assert.hasText(str, "Content string cannot be null or empty.");
        Assert.hasText(str2, "ContentType string cannot be null or empty.");
        this.payload = new Payload(str, str2);
        return ((JwtBuilder.BuilderHeader) header().delete(DefaultHeader.CONTENT_TYPE.getId())).and();
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder content(InputStream inputStream, String str) {
        Assert.notNull(inputStream, "Payload InputStream cannot be null.");
        Assert.hasText(str, "ContentType string cannot be null or empty.");
        this.payload = new Payload(inputStream, str);
        return ((JwtBuilder.BuilderHeader) header().delete(DefaultHeader.CONTENT_TYPE.getId())).and();
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(Key key, SignatureAlgorithm signatureAlgorithm) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        signatureAlgorithm.assertValidSigningKey(key);
        return signWith((DefaultJwtBuilder) key, (SecureDigestAlgorithm<? super DefaultJwtBuilder, ?>) Jwts.SIG.get().forKey(signatureAlgorithm.getValue()));
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notEmpty(bArr, "secret key byte array cannot be null or empty.");
        Assert.isTrue(signatureAlgorithm.isHmac(), "Key bytes may only be specified for HMAC signatures.  If using RSA or Elliptic Curve, use the signWith(SignatureAlgorithm, Key) method instead.");
        return signWith(new SecretKeySpec(bArr, signatureAlgorithm.getJcaName()), signatureAlgorithm);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, String str) {
        Assert.hasText(str, "base64-encoded secret key cannot be null or empty.");
        Assert.isTrue(signatureAlgorithm.isHmac(), "Base64-encoded key bytes may only be specified for HMAC signatures.  If using RSA or Elliptic Curve, use the signWith(SignatureAlgorithm, Key) method instead.");
        return signWith(signatureAlgorithm, Decoders.BASE64.decode(str));
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, Key key) {
        return signWith(key, signatureAlgorithm);
    }
}
