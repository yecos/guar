package io.jsonwebtoken.impl.security;

import com.google.android.gms.stats.CodePackage;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.AeadRequest;
import io.jsonwebtoken.security.AeadResult;
import io.jsonwebtoken.security.DecryptAeadRequest;
import io.jsonwebtoken.security.SecretKeyBuilder;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public class GcmAesAeadAlgorithm extends AesAlgorithm implements AeadAlgorithm {
    private static final String TRANSFORMATION_STRING = "AES/GCM/NoPadding";

    public GcmAesAeadAlgorithm(int i10) {
        super("A" + i10 + CodePackage.GCM, "AES/GCM/NoPadding", i10);
    }

    @Override // io.jsonwebtoken.security.AeadAlgorithm
    public void decrypt(DecryptAeadRequest decryptAeadRequest, final OutputStream outputStream) {
        Assert.notNull(decryptAeadRequest, "Request cannot be null.");
        Assert.notNull(outputStream, "Plaintext OutputStream cannot be null.");
        final SecretKey assertKey = assertKey((SecretKey) decryptAeadRequest.getKey());
        InputStream inputStream = (InputStream) Assert.notNull(decryptAeadRequest.getPayload(), "Decryption request content (ciphertext) InputStream cannot be null.");
        final InputStream associatedData = decryptAeadRequest.getAssociatedData();
        byte[] notEmpty = Assert.notEmpty(decryptAeadRequest.getDigest(), "Decryption request authentication tag cannot be null or empty.");
        final AlgorithmParameterSpec ivSpec = getIvSpec(assertDecryptionIv(decryptAeadRequest));
        final SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream, Streams.of(notEmpty));
        jca(decryptAeadRequest).withCipher(new CheckedFunction<Cipher, byte[]>() { // from class: io.jsonwebtoken.impl.security.GcmAesAeadAlgorithm.2
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public byte[] apply(Cipher cipher) {
                cipher.init(2, assertKey, ivSpec);
                Streams.write(outputStream, GcmAesAeadAlgorithm.this.withCipher(cipher, sequenceInputStream, associatedData, outputStream), "GcmAesAeadAlgorithm#decrypt plaintext write failure.");
                return Bytes.EMPTY;
            }
        });
        Streams.flush(outputStream);
    }

    @Override // io.jsonwebtoken.security.AeadAlgorithm
    public void encrypt(AeadRequest aeadRequest, AeadResult aeadResult) {
        Assert.notNull(aeadRequest, "Request cannot be null.");
        Assert.notNull(aeadResult, "Result cannot be null.");
        final SecretKey assertKey = assertKey((SecretKey) aeadRequest.getKey());
        final InputStream inputStream = (InputStream) Assert.notNull(aeadRequest.getPayload(), "Request content (plaintext) InputStream cannot be null.");
        final OutputStream outputStream = (OutputStream) Assert.notNull(aeadResult.getOutputStream(), "Result ciphertext OutputStream cannot be null.");
        final InputStream associatedData = aeadRequest.getAssociatedData();
        byte[] ensureInitializationVector = ensureInitializationVector(aeadRequest);
        final AlgorithmParameterSpec ivSpec = getIvSpec(ensureInitializationVector);
        byte[] bArr = (byte[]) jca(aeadRequest).withCipher(new CheckedFunction<Cipher, byte[]>() { // from class: io.jsonwebtoken.impl.security.GcmAesAeadAlgorithm.1
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public byte[] apply(Cipher cipher) {
                cipher.init(1, assertKey, ivSpec);
                byte[] withCipher = GcmAesAeadAlgorithm.this.withCipher(cipher, inputStream, associatedData, outputStream);
                int length = Bytes.length(withCipher) - 16;
                Streams.write(outputStream, withCipher, 0, length, "Ciphertext write failure.");
                byte[] bArr2 = new byte[16];
                System.arraycopy(withCipher, length, bArr2, 0, 16);
                return bArr2;
            }
        });
        Streams.flush(outputStream);
        Streams.reset(inputStream);
        aeadResult.setTag(bArr).setIv(ensureInitializationVector);
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
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
