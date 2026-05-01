package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.DecryptionKeyRequest;
import io.jsonwebtoken.security.KeyRequest;
import io.jsonwebtoken.security.KeyResult;
import io.jsonwebtoken.security.SecretKeyAlgorithm;
import io.jsonwebtoken.security.SecretKeyBuilder;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public class AesWrapKeyAlgorithm extends AesAlgorithm implements SecretKeyAlgorithm {
    private static final String TRANSFORMATION = "AESWrap";

    public AesWrapKeyAlgorithm(int i10) {
        super("A" + i10 + "KW", TRANSFORMATION, i10);
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // io.jsonwebtoken.security.KeyAlgorithm
    public SecretKey getDecryptionKey(DecryptionKeyRequest<SecretKey> decryptionKeyRequest) {
        Assert.notNull(decryptionKeyRequest, "request cannot be null.");
        final SecretKey assertKey = assertKey(decryptionKeyRequest.getKey());
        final byte[] notEmpty = Assert.notEmpty(decryptionKeyRequest.getPayload(), "Request content (encrypted key) cannot be null or empty.");
        return (SecretKey) jca(decryptionKeyRequest).withCipher(new CheckedFunction<Cipher, SecretKey>() { // from class: io.jsonwebtoken.impl.security.AesWrapKeyAlgorithm.2
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public SecretKey apply(Cipher cipher) {
                cipher.init(4, assertKey);
                Key unwrap = cipher.unwrap(notEmpty, "AES", 3);
                Assert.state(unwrap instanceof SecretKey, "Cipher unwrap must return a SecretKey instance.");
                return (SecretKey) unwrap;
            }
        });
    }

    @Override // io.jsonwebtoken.security.KeyAlgorithm
    public KeyResult getEncryptionKey(KeyRequest<SecretKey> keyRequest) {
        Assert.notNull(keyRequest, "request cannot be null.");
        final SecretKey assertKey = assertKey(keyRequest.getPayload());
        final SecretKey generateCek = generateCek(keyRequest);
        return new DefaultKeyResult(generateCek, (byte[]) jca(keyRequest).withCipher(new CheckedFunction<Cipher, byte[]>() { // from class: io.jsonwebtoken.impl.security.AesWrapKeyAlgorithm.1
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public byte[] apply(Cipher cipher) {
                cipher.init(3, assertKey);
                return cipher.wrap(generateCek);
            }
        }));
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
