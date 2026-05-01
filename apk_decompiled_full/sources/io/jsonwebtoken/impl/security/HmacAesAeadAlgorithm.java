package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.io.TeeOutputStream;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.AeadRequest;
import io.jsonwebtoken.security.AeadResult;
import io.jsonwebtoken.security.DecryptAeadRequest;
import io.jsonwebtoken.security.SecretKeyBuilder;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.SignatureException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Collections;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class HmacAesAeadAlgorithm extends AesAlgorithm implements AeadAlgorithm {
    private static final String TRANSFORMATION_STRING = "AES/CBC/PKCS5Padding";
    private final DefaultMacAlgorithm SIGALG;

    public HmacAesAeadAlgorithm(String str, DefaultMacAlgorithm defaultMacAlgorithm) {
        super(str, TRANSFORMATION_STRING, defaultMacAlgorithm.getKeyBitLength());
        this.SIGALG = defaultMacAlgorithm;
    }

    private static int digestLength(int i10) {
        return i10 * 2;
    }

    private static String id(int i10) {
        return "A" + i10 + "CBC-HS" + digestLength(i10);
    }

    private byte[] sign(byte[] bArr, byte[] bArr2, InputStream inputStream, byte[] bArr3) {
        byte[] bytes = Bytes.toBytes((Arrays.length(bArr) * 8) & 4294967295L);
        ArrayList arrayList = new ArrayList(4);
        if (!Bytes.isEmpty(bArr)) {
            arrayList.add(Streams.of(bArr));
        }
        arrayList.add(Streams.of(bArr2));
        arrayList.add(inputStream);
        arrayList.add(Streams.of(bytes));
        return assertTag(java.util.Arrays.copyOfRange(this.SIGALG.digest((SecureRequest) new DefaultSecureRequest(new SequenceInputStream(Collections.enumeration(arrayList)), null, null, new SecretKeySpec(bArr3, this.SIGALG.getJcaName()))), 0, bArr3.length));
    }

    public byte[] assertKeyBytes(SecureRequest<?, SecretKey> secureRequest) {
        return validateLength((SecretKey) Assert.notNull(secureRequest.getKey(), "Request key cannot be null."), this.keyBitLength * 2, true);
    }

    @Override // io.jsonwebtoken.security.AeadAlgorithm
    public void decrypt(DecryptAeadRequest decryptAeadRequest, final OutputStream outputStream) {
        Assert.notNull(decryptAeadRequest, "Request cannot be null.");
        Assert.notNull(outputStream, "Plaintext OutputStream cannot be null.");
        byte[] assertKeyBytes = assertKeyBytes(decryptAeadRequest);
        int length = assertKeyBytes.length / 2;
        byte[] copyOfRange = java.util.Arrays.copyOfRange(assertKeyBytes, 0, length);
        byte[] copyOfRange2 = java.util.Arrays.copyOfRange(assertKeyBytes, length, assertKeyBytes.length);
        try {
            final SecretKeySpec secretKeySpec = new SecretKeySpec(copyOfRange2, "AES");
            Bytes.clear(copyOfRange2);
            Bytes.clear(assertKeyBytes);
            final InputStream inputStream = (InputStream) Assert.notNull(decryptAeadRequest.getPayload(), "Decryption request content (ciphertext) InputStream cannot be null.");
            InputStream associatedData = decryptAeadRequest.getAssociatedData();
            byte[] assertTag = assertTag(decryptAeadRequest.getDigest());
            byte[] assertDecryptionIv = assertDecryptionIv(decryptAeadRequest);
            final AlgorithmParameterSpec ivSpec = getIvSpec(assertDecryptionIv);
            try {
                byte[] sign = sign(associatedData == null ? Bytes.EMPTY : Streams.bytes(associatedData, "Unable to read AAD bytes."), assertDecryptionIv, inputStream, copyOfRange);
                Bytes.clear(copyOfRange);
                if (!MessageDigest.isEqual(sign, assertTag)) {
                    throw new SignatureException("Ciphertext decryption failed: Authentication tag verification failed.");
                }
                Streams.reset(inputStream);
                jca(decryptAeadRequest).withCipher(new CheckedFunction<Cipher, byte[]>() { // from class: io.jsonwebtoken.impl.security.HmacAesAeadAlgorithm.2
                    @Override // io.jsonwebtoken.impl.lang.CheckedFunction
                    public byte[] apply(Cipher cipher) {
                        cipher.init(2, secretKeySpec, ivSpec);
                        HmacAesAeadAlgorithm.this.withCipher(cipher, inputStream, outputStream);
                        return Bytes.EMPTY;
                    }
                });
            } catch (Throwable th) {
                Bytes.clear(copyOfRange);
                throw th;
            }
        } catch (Throwable th2) {
            Bytes.clear(copyOfRange2);
            Bytes.clear(assertKeyBytes);
            throw th2;
        }
    }

    @Override // io.jsonwebtoken.security.AeadAlgorithm
    public void encrypt(AeadRequest aeadRequest, AeadResult aeadResult) {
        Assert.notNull(aeadRequest, "Request cannot be null.");
        Assert.notNull(aeadResult, "Result cannot be null.");
        byte[] assertKeyBytes = assertKeyBytes(aeadRequest);
        int length = assertKeyBytes.length / 2;
        byte[] copyOfRange = java.util.Arrays.copyOfRange(assertKeyBytes, 0, length);
        byte[] copyOfRange2 = java.util.Arrays.copyOfRange(assertKeyBytes, length, assertKeyBytes.length);
        try {
            final SecretKeySpec secretKeySpec = new SecretKeySpec(copyOfRange2, "AES");
            Bytes.clear(copyOfRange2);
            Bytes.clear(assertKeyBytes);
            final InputStream inputStream = (InputStream) Assert.notNull(aeadRequest.getPayload(), "Request content (plaintext) InputStream cannot be null.");
            OutputStream outputStream = (OutputStream) Assert.notNull(aeadResult.getOutputStream(), "Result ciphertext OutputStream cannot be null.");
            InputStream associatedData = aeadRequest.getAssociatedData();
            byte[] ensureInitializationVector = ensureInitializationVector(aeadRequest);
            final AlgorithmParameterSpec ivSpec = getIvSpec(ensureInitializationVector);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            final TeeOutputStream teeOutputStream = new TeeOutputStream(outputStream, byteArrayOutputStream);
            jca(aeadRequest).withCipher(new CheckedFunction<Cipher, Object>() { // from class: io.jsonwebtoken.impl.security.HmacAesAeadAlgorithm.1
                @Override // io.jsonwebtoken.impl.lang.CheckedFunction
                public Object apply(Cipher cipher) {
                    cipher.init(1, secretKeySpec, ivSpec);
                    HmacAesAeadAlgorithm.this.withCipher(cipher, inputStream, teeOutputStream);
                    return null;
                }
            });
            try {
                aeadResult.setTag(sign(associatedData == null ? Bytes.EMPTY : Streams.bytes(associatedData, "Unable to read AAD bytes."), ensureInitializationVector, Streams.of(byteArrayOutputStream.toByteArray()), copyOfRange)).setIv(ensureInitializationVector);
            } finally {
                Bytes.clear(copyOfRange);
            }
        } catch (Throwable th) {
            Bytes.clear(copyOfRange2);
            Bytes.clear(assertKeyBytes);
            throw th;
        }
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
    public int getKeyBitLength() {
        return super.getKeyBitLength() * 2;
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // io.jsonwebtoken.impl.security.AesAlgorithm, io.jsonwebtoken.security.KeyBuilderSupplier
    public SecretKeyBuilder key() {
        return new RandomSecretKeyBuilder("AES", getKeyBitLength());
    }

    public HmacAesAeadAlgorithm(int i10) {
        this(id(i10), new DefaultMacAlgorithm(id(i10), "HmacSHA" + digestLength(i10), i10));
    }
}
