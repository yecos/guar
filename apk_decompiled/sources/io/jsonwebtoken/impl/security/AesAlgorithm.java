package io.jsonwebtoken.impl.security;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.IvSupplier;
import io.jsonwebtoken.security.KeyBuilderSupplier;
import io.jsonwebtoken.security.KeyLengthSupplier;
import io.jsonwebtoken.security.Request;
import io.jsonwebtoken.security.SecretKeyBuilder;
import io.jsonwebtoken.security.WeakKeyException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
abstract class AesAlgorithm extends CryptoAlgorithm implements KeyBuilderSupplier<SecretKey, SecretKeyBuilder>, KeyLengthSupplier {
    protected static final int BLOCK_BYTE_SIZE = 16;
    protected static final int BLOCK_SIZE = 128;
    protected static final String DECRYPT_NO_IV = "This algorithm implementation rejects decryption requests that do not include initialization vectors. AES ciphertext without an IV is weak and susceptible to attack.";
    protected static final int GCM_IV_SIZE = 96;
    protected static final String KEY_ALG_NAME = "AES";
    protected final boolean gcm;
    protected final int ivBitLength;
    protected final int keyBitLength;
    protected final int tagBitLength;

    public AesAlgorithm(String str, String str2, int i10) {
        super(str, str2);
        assertKeyBitLength(i10);
        this.keyBitLength = i10;
        boolean startsWith = str2.startsWith("AES/GCM");
        this.gcm = startsWith;
        this.ivBitLength = str2.equals("AESWrap") ? 0 : startsWith ? 96 : 128;
        this.tagBitLength = startsWith ? 128 : i10;
    }

    public static void assertKeyBitLength(int i10) {
        if (i10 == 128 || i10 == 192 || i10 == 256) {
            return;
        }
        throw new IllegalArgumentException("Invalid AES key length: " + Bytes.bitsMsg(i10) + ". AES only supports 128, 192, or 256 bit keys.");
    }

    public static SecretKey keyFor(byte[] bArr) {
        assertKeyBitLength((int) Bytes.bitLength(bArr));
        return new SecretKeySpec(bArr, KEY_ALG_NAME);
    }

    public static String lengthMsg(String str, String str2, int i10, long j10) {
        return "The '" + str + "' algorithm requires " + str2 + " with a length of " + Bytes.bitsMsg(i10) + ".  The provided key has a length of " + Bytes.bitsMsg(j10) + ".";
    }

    private void updateAAD(Cipher cipher, InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        byte[] bArr = new byte[2048];
        int i10 = 0;
        while (i10 != -1) {
            i10 = inputStream.read(bArr);
            if (i10 > 0) {
                cipher.updateAAD(bArr, 0, i10);
            }
        }
    }

    private void validateLengthIfPossible(SecretKey secretKey) {
        validateLength(secretKey, this.keyBitLength, false);
    }

    public byte[] assertBytes(byte[] bArr, String str, int i10) {
        long bitLength = Bytes.bitLength(bArr);
        if (i10 == bitLength) {
            return bArr;
        }
        throw new IllegalArgumentException(lengthMsg(getId(), str, i10, bitLength));
    }

    public byte[] assertDecryptionIv(IvSupplier ivSupplier) {
        byte[] iv = ivSupplier.getIv();
        Assert.notEmpty(iv, DECRYPT_NO_IV);
        return assertIvLength(iv);
    }

    public byte[] assertIvLength(byte[] bArr) {
        return assertBytes(bArr, "initialization vectors", this.ivBitLength);
    }

    public SecretKey assertKey(SecretKey secretKey) {
        Assert.notNull(secretKey, "Request key cannot be null.");
        validateLengthIfPossible(secretKey);
        return secretKey;
    }

    public byte[] assertTag(byte[] bArr) {
        return assertBytes(bArr, "authentication tags", this.tagBitLength);
    }

    public byte[] ensureInitializationVector(Request<?> request) {
        byte[] clean = request instanceof IvSupplier ? Arrays.clean(((IvSupplier) request).getIv()) : null;
        int i10 = this.ivBitLength / 8;
        if (clean != null && clean.length != 0) {
            assertIvLength(clean);
            return clean;
        }
        byte[] bArr = new byte[i10];
        CryptoAlgorithm.ensureSecureRandom(request).nextBytes(bArr);
        return bArr;
    }

    public AlgorithmParameterSpec getIvSpec(byte[] bArr) {
        Assert.notEmpty(bArr, "Initialization Vector byte array cannot be null or empty.");
        return this.gcm ? new GCMParameterSpec(128, bArr) : new IvParameterSpec(bArr);
    }

    @Override // io.jsonwebtoken.security.KeyLengthSupplier
    public int getKeyBitLength() {
        return this.keyBitLength;
    }

    public byte[] validateLength(SecretKey secretKey, int i10, boolean z10) {
        try {
            byte[] encoded = secretKey.getEncoded();
            long bitLength = Bytes.bitLength(encoded);
            if (bitLength >= i10) {
                return encoded;
            }
            throw new WeakKeyException(lengthMsg(getId(), UserMetadata.KEYDATA_FILENAME, i10, bitLength));
        } catch (RuntimeException e10) {
            if (z10) {
                throw e10;
            }
            return null;
        }
    }

    public void withCipher(Cipher cipher, InputStream inputStream, OutputStream outputStream) {
        outputStream.write(withCipher(cipher, inputStream, null, outputStream));
    }

    @Override // io.jsonwebtoken.security.KeyBuilderSupplier
    public SecretKeyBuilder key() {
        return new DefaultSecretKeyBuilder(KEY_ALG_NAME, getKeyBitLength());
    }

    public byte[] withCipher(Cipher cipher, InputStream inputStream, InputStream inputStream2, OutputStream outputStream) {
        updateAAD(cipher, inputStream2);
        byte[] bArr = new byte[2048];
        int i10 = 0;
        while (i10 != -1) {
            try {
                i10 = inputStream.read(bArr);
                if (i10 > 0) {
                    Streams.write(outputStream, cipher.update(bArr, 0, i10), "Unable to write Cipher output to OutputStream");
                }
            } finally {
                Bytes.clear(bArr);
            }
        }
        return cipher.doFinal();
    }
}
