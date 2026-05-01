package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.impl.DefaultJweHeader;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.impl.lang.RequiredParameterReader;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.DecryptionKeyRequest;
import io.jsonwebtoken.security.KeyRequest;
import io.jsonwebtoken.security.KeyResult;
import io.jsonwebtoken.security.SecretKeyAlgorithm;
import io.jsonwebtoken.security.SecretKeyBuilder;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public class AesGcmKeyAlgorithm extends AesAlgorithm implements SecretKeyAlgorithm {
    public static final String TRANSFORMATION = "AES/GCM/NoPadding";

    public AesGcmKeyAlgorithm(int i10) {
        super("A" + i10 + "GCMKW", TRANSFORMATION, i10);
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // io.jsonwebtoken.security.KeyAlgorithm
    public SecretKey getDecryptionKey(DecryptionKeyRequest<SecretKey> decryptionKeyRequest) {
        Assert.notNull(decryptionKeyRequest, "request cannot be null.");
        final SecretKey assertKey = assertKey(decryptionKeyRequest.getKey());
        byte[] notEmpty = Assert.notEmpty(decryptionKeyRequest.getPayload(), "Decryption request content (ciphertext) cannot be null or empty.");
        RequiredParameterReader requiredParameterReader = new RequiredParameterReader((ParameterReadable) Assert.isInstanceOf(ParameterReadable.class, (JweHeader) Assert.notNull(decryptionKeyRequest.getHeader(), "Request JweHeader cannot be null."), "Header must implement ParameterReadable."));
        byte[] bArr = (byte[]) requiredParameterReader.get(DefaultJweHeader.TAG);
        final AlgorithmParameterSpec ivSpec = getIvSpec((byte[]) requiredParameterReader.get(DefaultJweHeader.IV));
        final byte[] concat = Bytes.concat(notEmpty, bArr);
        return (SecretKey) jca(decryptionKeyRequest).withCipher(new CheckedFunction<Cipher, SecretKey>() { // from class: io.jsonwebtoken.impl.security.AesGcmKeyAlgorithm.2
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public SecretKey apply(Cipher cipher) {
                cipher.init(4, assertKey, ivSpec);
                Key unwrap = cipher.unwrap(concat, "AES", 3);
                Assert.state(unwrap instanceof SecretKey, "cipher.unwrap must produce a SecretKey instance.");
                return (SecretKey) unwrap;
            }
        });
    }

    @Override // io.jsonwebtoken.security.KeyAlgorithm
    public KeyResult getEncryptionKey(KeyRequest<SecretKey> keyRequest) {
        Assert.notNull(keyRequest, "request cannot be null.");
        JweHeader jweHeader = (JweHeader) Assert.notNull(keyRequest.getHeader(), "Request JweHeader cannot be null.");
        final SecretKey assertKey = assertKey(keyRequest.getPayload());
        final SecretKey generateCek = generateCek(keyRequest);
        byte[] ensureInitializationVector = ensureInitializationVector(keyRequest);
        final AlgorithmParameterSpec ivSpec = getIvSpec(ensureInitializationVector);
        byte[] bArr = (byte[]) jca(keyRequest).withCipher(new CheckedFunction<Cipher, byte[]>() { // from class: io.jsonwebtoken.impl.security.AesGcmKeyAlgorithm.1
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public byte[] apply(Cipher cipher) {
                cipher.init(3, assertKey, ivSpec);
                return cipher.wrap(generateCek);
            }
        });
        int i10 = this.tagBitLength / 8;
        int length = bArr.length - i10;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        byte[] bArr3 = new byte[i10];
        System.arraycopy(bArr, length, bArr3, 0, i10);
        Encoder<byte[], String> encoder = Encoders.BASE64URL;
        String encode = encoder.encode(ensureInitializationVector);
        String encode2 = encoder.encode(bArr3);
        jweHeader.put(DefaultJweHeader.IV.getId(), encode);
        jweHeader.put(DefaultJweHeader.TAG.getId(), encode2);
        return new DefaultKeyResult(generateCek, bArr2);
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm, io.jsonwebtoken.Identifiable
    public /* bridge */ /* synthetic */ String getId() {
        return super.getId();
    }

    @Override // io.jsonwebtoken.impl.security.AesAlgorithm, io.jsonwebtoken.security.KeyLengthSupplier
    public /* bridge */ /* synthetic */ int getKeyBitLength() {
        return super.getKeyBitLength();
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // io.jsonwebtoken.impl.security.AesAlgorithm, io.jsonwebtoken.security.KeyBuilderSupplier
    public /* bridge */ /* synthetic */ SecretKeyBuilder key() {
        return super.key();
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
