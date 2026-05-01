package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.impl.DefaultJweHeader;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.RequiredParameterReader;
import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.Curve;
import io.jsonwebtoken.security.DecryptionKeyRequest;
import io.jsonwebtoken.security.DynamicJwkBuilder;
import io.jsonwebtoken.security.EcPublicJwk;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.KeyLengthSupplier;
import io.jsonwebtoken.security.KeyRequest;
import io.jsonwebtoken.security.KeyResult;
import io.jsonwebtoken.security.OctetPublicJwk;
import io.jsonwebtoken.security.PublicJwk;
import io.jsonwebtoken.security.Request;
import io.jsonwebtoken.security.SecureRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECKey;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
class EcdhKeyAlgorithm extends CryptoAlgorithm implements KeyAlgorithm<PublicKey, PrivateKey> {
    protected static final String DEFAULT_ID = "ECDH-ES";
    protected static final String JCA_NAME = "ECDH";
    protected static final String XDH_JCA_NAME = "XDH";
    private final KeyAlgorithm<SecretKey, SecretKey> WRAP_ALG;
    private static final String CONCAT_KDF_HASH_ALG_NAME = "SHA-256";
    private static final ConcatKDF CONCAT_KDF = new ConcatKDF(CONCAT_KDF_HASH_ALG_NAME);

    public EcdhKeyAlgorithm() {
        this(new DirectKeyAlgorithm());
    }

    private static AbstractCurve assertCurve(Key key) {
        Curve findByKey = StandardCurves.findByKey(key);
        if (findByKey == null) {
            throw new InvalidKeyException("Unable to determine JWA-standard Elliptic Curve for " + (key instanceof PublicKey ? "encryption " : "decryption ") + "key [" + KeysBridge.toString(key) + "]");
        }
        if (!(findByKey instanceof EdwardsCurve) || !((EdwardsCurve) findByKey).isSignatureCurve()) {
            return (AbstractCurve) Assert.isInstanceOf(AbstractCurve.class, findByKey, "AbstractCurve instance expected.");
        }
        throw new InvalidKeyException(findByKey.getId() + " keys may not be used with ECDH-ES key agreement algorithms per https://www.rfc-editor.org/rfc/rfc8037#section-3.1.");
    }

    private byte[] createOtherInfo(int i10, String str, byte[] bArr, byte[] bArr2) {
        Assert.hasText(str, "AlgorithmId cannot be null or empty.");
        byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
        if (Arrays.length(bArr) == 0) {
            bArr = Bytes.EMPTY;
        }
        if (Arrays.length(bArr2) == 0) {
            bArr2 = Bytes.EMPTY;
        }
        return Bytes.concat(Bytes.toBytes(bytes.length), bytes, Bytes.toBytes(bArr.length), bArr, Bytes.toBytes(bArr2.length), bArr2, Bytes.toBytes(i10), Bytes.EMPTY);
    }

    private SecretKey deriveKey(KeyRequest<?> keyRequest, PublicKey publicKey, PrivateKey privateKey) {
        AeadAlgorithm aeadAlgorithm = (AeadAlgorithm) Assert.notNull(keyRequest.getEncryptionAlgorithm(), "Request encryptionAlgorithm cannot be null.");
        int keyBitLength = getKeyBitLength(aeadAlgorithm);
        byte[] createOtherInfo = createOtherInfo(keyBitLength, getConcatKDFAlgorithmId(aeadAlgorithm), keyRequest.getHeader().getAgreementPartyUInfo(), keyRequest.getHeader().getAgreementPartyVInfo());
        byte[] generateZ = generateZ(keyRequest, publicKey, privateKey);
        try {
            return CONCAT_KDF.deriveKey(generateZ, keyBitLength, createOtherInfo);
        } finally {
            Bytes.clear(generateZ);
        }
    }

    private int getKeyBitLength(AeadAlgorithm aeadAlgorithm) {
        KeyAlgorithm<SecretKey, SecretKey> keyAlgorithm = this.WRAP_ALG;
        return ((Integer) Assert.gt(Integer.valueOf(keyAlgorithm instanceof KeyLengthSupplier ? ((KeyLengthSupplier) keyAlgorithm).getKeyBitLength() : aeadAlgorithm.getKeyBitLength()), 0, "Algorithm keyBitLength must be > 0")).intValue();
    }

    private static String idFor(KeyAlgorithm<SecretKey, SecretKey> keyAlgorithm) {
        if (keyAlgorithm instanceof DirectKeyAlgorithm) {
            return DEFAULT_ID;
        }
        return "ECDH-ES+" + keyAlgorithm.getId();
    }

    public KeyPair generateKeyPair(Curve curve, Provider provider, SecureRandom secureRandom) {
        return curve.keyPair().provider(provider).random(secureRandom).build();
    }

    public byte[] generateZ(final KeyRequest<?> keyRequest, final PublicKey publicKey, final PrivateKey privateKey) {
        return (byte[]) jca(keyRequest).withKeyAgreement(new CheckedFunction<KeyAgreement, byte[]>() { // from class: io.jsonwebtoken.impl.security.EcdhKeyAlgorithm.1
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public byte[] apply(KeyAgreement keyAgreement) {
                keyAgreement.init(KeysBridge.root(privateKey), CryptoAlgorithm.ensureSecureRandom(keyRequest));
                keyAgreement.doPhase(publicKey, true);
                return keyAgreement.generateSecret();
            }
        });
    }

    public String getConcatKDFAlgorithmId(AeadAlgorithm aeadAlgorithm) {
        return this.WRAP_ALG instanceof DirectKeyAlgorithm ? (String) Assert.hasText(aeadAlgorithm.getId(), "AeadAlgorithm id cannot be null or empty.") : getId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.security.Key] */
    @Override // io.jsonwebtoken.security.KeyAlgorithm
    public SecretKey getDecryptionKey(DecryptionKeyRequest<PrivateKey> decryptionKeyRequest) {
        Assert.notNull(decryptionKeyRequest, "Request cannot be null.");
        JweHeader jweHeader = (JweHeader) Assert.notNull(decryptionKeyRequest.getHeader(), "Request JweHeader cannot be null.");
        PrivateKey privateKey = (PrivateKey) Assert.notNull(decryptionKeyRequest.getKey(), "Decryption PrivateKey cannot be null.");
        RequiredParameterReader requiredParameterReader = new RequiredParameterReader(jweHeader);
        Parameter<PublicJwk<?>> parameter = DefaultJweHeader.EPK;
        PublicJwk publicJwk = (PublicJwk) requiredParameterReader.get(parameter);
        AbstractCurve assertCurve = assertCurve(privateKey);
        Assert.stateNotNull(assertCurve, "Internal implementation state: Curve cannot be null.");
        if (!(assertCurve instanceof ECCurve ? EcPublicJwk.class : OctetPublicJwk.class).isInstance(publicJwk)) {
            throw new InvalidKeyException("JWE Header " + parameter + " value is not an Elliptic Curve Public JWK. Value: " + publicJwk);
        }
        if (assertCurve.contains(publicJwk.toKey())) {
            return this.WRAP_ALG.getDecryptionKey(new DefaultDecryptionKeyRequest(decryptionKeyRequest.getPayload(), null, decryptionKeyRequest.getSecureRandom(), jweHeader, decryptionKeyRequest.getEncryptionAlgorithm(), deriveKey(decryptionKeyRequest, (PublicKey) publicJwk.toKey(), privateKey)));
        }
        throw new InvalidKeyException("JWE Header " + parameter + " value does not represent a point on the expected curve. Value: " + publicJwk);
    }

    @Override // io.jsonwebtoken.security.KeyAlgorithm
    public KeyResult getEncryptionKey(KeyRequest<PublicKey> keyRequest) {
        Assert.notNull(keyRequest, "Request cannot be null.");
        JweHeader jweHeader = (JweHeader) Assert.notNull(keyRequest.getHeader(), "Request JweHeader cannot be null.");
        PublicKey publicKey = (PublicKey) Assert.notNull(keyRequest.getPayload(), "Encryption PublicKey cannot be null.");
        AbstractCurve assertCurve = assertCurve(publicKey);
        Assert.stateNotNull(assertCurve, "Internal implementation state: Curve cannot be null.");
        SecureRandom ensureSecureRandom = CryptoAlgorithm.ensureSecureRandom(keyRequest);
        DynamicJwkBuilder dynamicJwkBuilder = (DynamicJwkBuilder) Jwks.builder().random(ensureSecureRandom);
        KeyPair generateKeyPair = generateKeyPair(assertCurve, null, ensureSecureRandom);
        Assert.stateNotNull(generateKeyPair, "Internal implementation state: KeyPair cannot be null.");
        PublicJwk publicJwk = (PublicJwk) dynamicJwkBuilder.key((DynamicJwkBuilder) generateKeyPair.getPublic()).build();
        KeyResult encryptionKey = this.WRAP_ALG.getEncryptionKey(new DefaultKeyRequest(deriveKey(keyRequest, publicKey, generateKeyPair.getPrivate()), keyRequest.getProvider(), keyRequest.getSecureRandom(), keyRequest.getHeader(), keyRequest.getEncryptionAlgorithm()));
        jweHeader.put(DefaultJweHeader.EPK.getId(), publicJwk);
        return encryptionKey;
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm
    public String getJcaName(Request<?> request) {
        return request instanceof SecureRequest ? ((SecureRequest) request).getKey() instanceof ECKey ? super.getJcaName(request) : XDH_JCA_NAME : request.getPayload() instanceof ECKey ? super.getJcaName(request) : XDH_JCA_NAME;
    }

    public EcdhKeyAlgorithm(KeyAlgorithm<SecretKey, SecretKey> keyAlgorithm) {
        super(idFor(keyAlgorithm), JCA_NAME);
        this.WRAP_ALG = (KeyAlgorithm) Assert.notNull(keyAlgorithm, "Wrap algorithm cannot be null.");
    }
}
