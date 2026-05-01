package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyPairBuilder;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.VerifySecureDigestRequest;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECKey;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
final class EcSignatureAlgorithm extends AbstractSignatureAlgorithm {
    private static final Map<String, SignatureAlgorithm> BY_OID;
    private static final String DER_ENCODING_SYS_PROPERTY_NAME = "io.jsonwebtoken.impl.crypto.EllipticCurveSignatureValidator.derEncodingSupported";
    static final EcSignatureAlgorithm ES256;
    static final EcSignatureAlgorithm ES384;
    static final EcSignatureAlgorithm ES512;
    private static final String REQD_ORDER_BIT_LENGTH_MSG = "orderBitLength must equal 256, 384, or 521.";
    private final ECGenParameterSpec KEY_PAIR_GEN_PARAMS;
    private final String OID;
    private final int orderBitLength;
    private final int sigFieldByteLength;
    private final int signatureByteLength;
    private static final String ES256_OID = "1.2.840.10045.4.3.2";
    private static final String ES384_OID = "1.2.840.10045.4.3.3";
    private static final String ES512_OID = "1.2.840.10045.4.3.4";
    private static final Set<String> KEY_ALG_NAMES = Collections.setOf("EC", "ECDSA", ES256_OID, ES384_OID, ES512_OID);

    static {
        EcSignatureAlgorithm ecSignatureAlgorithm = new EcSignatureAlgorithm(256, ES256_OID);
        ES256 = ecSignatureAlgorithm;
        EcSignatureAlgorithm ecSignatureAlgorithm2 = new EcSignatureAlgorithm(384, ES384_OID);
        ES384 = ecSignatureAlgorithm2;
        EcSignatureAlgorithm ecSignatureAlgorithm3 = new EcSignatureAlgorithm(521, ES512_OID);
        ES512 = ecSignatureAlgorithm3;
        BY_OID = new LinkedHashMap(3);
        for (EcSignatureAlgorithm ecSignatureAlgorithm4 : Collections.of(ecSignatureAlgorithm, ecSignatureAlgorithm2, ecSignatureAlgorithm3)) {
            BY_OID.put(ecSignatureAlgorithm4.OID, ecSignatureAlgorithm4);
        }
    }

    private EcSignatureAlgorithm(int i10, String str) {
        super("ES" + shaSize(i10), "SHA" + shaSize(i10) + "withECDSA");
        Assert.isTrue(isSupportedOrderBitLength(i10), REQD_ORDER_BIT_LENGTH_MSG);
        this.OID = (String) Assert.hasText(str, "Invalid OID.");
        this.KEY_PAIR_GEN_PARAMS = new ECGenParameterSpec("secp" + i10 + "r1");
        this.orderBitLength = i10;
        int length = Bytes.length(i10);
        this.sigFieldByteLength = length;
        this.signatureByteLength = length * 2;
    }

    private static byte[] concatToDER(byte[] bArr) {
        byte[] bArr2;
        int length = bArr.length / 2;
        int i10 = length;
        while (i10 > 0 && bArr[length - i10] == 0) {
            i10--;
        }
        int i11 = length - i10;
        int i12 = bArr[i11] < 0 ? i10 + 1 : i10;
        int i13 = length;
        while (i13 > 0 && bArr[(length * 2) - i13] == 0) {
            i13--;
        }
        int i14 = (length * 2) - i13;
        int i15 = bArr[i14] < 0 ? i13 + 1 : i13;
        int i16 = i12 + 2 + 2 + i15;
        if (i16 > 255) {
            throw new JwtException("Invalid ECDSA signature format");
        }
        int i17 = 1;
        if (i16 < 128) {
            bArr2 = new byte[i12 + 4 + 2 + i15];
        } else {
            bArr2 = new byte[i12 + 5 + 2 + i15];
            bArr2[1] = -127;
            i17 = 2;
        }
        bArr2[0] = 48;
        int i18 = i17 + 1;
        bArr2[i17] = (byte) i16;
        int i19 = i18 + 1;
        bArr2[i18] = 2;
        bArr2[i19] = (byte) i12;
        int i20 = i19 + 1 + i12;
        System.arraycopy(bArr, i11, bArr2, i20 - i10, i10);
        int i21 = i20 + 1;
        bArr2[i20] = 2;
        bArr2[i21] = (byte) i15;
        System.arraycopy(bArr, i14, bArr2, ((i21 + 1) + i15) - i13, i13);
        return bArr2;
    }

    public static SignatureAlgorithm findByKey(Key key) {
        String findAlgorithm = KeysBridge.findAlgorithm(key);
        if (!Strings.hasText(findAlgorithm)) {
            return null;
        }
        String upperCase = findAlgorithm.toUpperCase(Locale.ENGLISH);
        SignatureAlgorithm signatureAlgorithm = BY_OID.get(upperCase);
        if (signatureAlgorithm != null) {
            return signatureAlgorithm;
        }
        if ("EC".equalsIgnoreCase(upperCase) || "ECDSA".equalsIgnoreCase(upperCase)) {
            int findBitLength = KeysBridge.findBitLength(key);
            EcSignatureAlgorithm ecSignatureAlgorithm = ES512;
            if (findBitLength == ecSignatureAlgorithm.orderBitLength) {
                return ecSignatureAlgorithm;
            }
            EcSignatureAlgorithm ecSignatureAlgorithm2 = ES384;
            if (findBitLength == ecSignatureAlgorithm2.orderBitLength) {
                return ecSignatureAlgorithm2;
            }
            EcSignatureAlgorithm ecSignatureAlgorithm3 = ES256;
            if (findBitLength == ecSignatureAlgorithm3.orderBitLength) {
                return ecSignatureAlgorithm3;
            }
        }
        return null;
    }

    private static boolean isSupportedOrderBitLength(int i10) {
        return i10 == 256 || i10 == 384 || i10 == 521;
    }

    private static int shaSize(int i10) {
        if (i10 == 521) {
            return 512;
        }
        return i10;
    }

    public static byte[] transcodeConcatToDER(byte[] bArr) {
        try {
            return concatToDER(bArr);
        } catch (Exception e10) {
            throw new SignatureException("Invalid ECDSA signature format.", e10);
        }
    }

    public static byte[] transcodeDERToConcat(byte[] bArr, int i10) {
        int i11;
        if (bArr.length < 8 || bArr[0] != 48) {
            throw new JwtException("Invalid ECDSA signature format");
        }
        byte b10 = bArr[1];
        if (b10 > 0) {
            i11 = 2;
        } else {
            if (b10 != -127) {
                throw new JwtException("Invalid ECDSA signature format");
            }
            i11 = 3;
        }
        int i12 = bArr[i11 + 1];
        int i13 = i12;
        while (i13 > 0 && bArr[((i11 + 2) + i12) - i13] == 0) {
            i13--;
        }
        int i14 = i11 + 2 + i12;
        int i15 = bArr[i14 + 1];
        int i16 = i15;
        while (i16 > 0 && bArr[((i14 + 2) + i15) - i16] == 0) {
            i16--;
        }
        int max = Math.max(Math.max(i13, i16), i10 / 2);
        int i17 = bArr[i11 - 1];
        if ((i17 & 255) != bArr.length - i11 || (i17 & 255) != i12 + 2 + 2 + i15 || bArr[i11] != 2 || bArr[i14] != 2) {
            throw new JwtException("Invalid ECDSA signature format");
        }
        int i18 = max * 2;
        byte[] bArr2 = new byte[i18];
        System.arraycopy(bArr, i14 - i13, bArr2, max - i13, i13);
        System.arraycopy(bArr, ((i14 + 2) + i15) - i16, bArr2, i18 - i16, i16);
        return bArr2;
    }

    @Override // io.jsonwebtoken.impl.security.AbstractSignatureAlgorithm, io.jsonwebtoken.impl.security.AbstractSecureDigestAlgorithm
    public byte[] doDigest(final SecureRequest<InputStream, PrivateKey> secureRequest) {
        return (byte[]) jca(secureRequest).withSignature(new CheckedFunction<Signature, byte[]>() { // from class: io.jsonwebtoken.impl.security.EcSignatureAlgorithm.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public byte[] apply(Signature signature) {
                signature.initSign((PrivateKey) KeysBridge.root(secureRequest));
                return EcSignatureAlgorithm.transcodeDERToConcat(EcSignatureAlgorithm.this.sign(signature, (InputStream) secureRequest.getPayload()), EcSignatureAlgorithm.this.signatureByteLength);
            }
        });
    }

    @Override // io.jsonwebtoken.impl.security.AbstractSignatureAlgorithm, io.jsonwebtoken.impl.security.AbstractSecureDigestAlgorithm
    public boolean doVerify(final VerifySecureDigestRequest<PublicKey> verifySecureDigestRequest) {
        final PublicKey key = verifySecureDigestRequest.getKey();
        return ((Boolean) jca(verifySecureDigestRequest).withSignature(new CheckedFunction<Signature, Boolean>() { // from class: io.jsonwebtoken.impl.security.EcSignatureAlgorithm.2
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public Boolean apply(Signature signature) {
                byte[] digest = verifySecureDigestRequest.getDigest();
                try {
                    if (EcSignatureAlgorithm.this.signatureByteLength != digest.length) {
                        if (digest[0] != 48 || !"true".equalsIgnoreCase(System.getProperty(EcSignatureAlgorithm.DER_ENCODING_SYS_PROPERTY_NAME))) {
                            throw new SignatureException("Provided signature is " + Bytes.bytesMsg(digest.length) + " but " + EcSignatureAlgorithm.this.getId() + " signatures must be exactly " + Bytes.bytesMsg(EcSignatureAlgorithm.this.signatureByteLength) + " per [RFC 7518, Section 3.4 (validation)](https://www.rfc-editor.org/rfc/rfc7518.html#section-3.4).");
                        }
                    } else {
                        if (!EcSignatureAlgorithm.this.isValidRAndS(key, digest)) {
                            return Boolean.FALSE;
                        }
                        digest = EcSignatureAlgorithm.transcodeConcatToDER(digest);
                    }
                    signature.initVerify(key);
                    return Boolean.valueOf(EcSignatureAlgorithm.this.verify(signature, verifySecureDigestRequest.getPayload(), digest));
                } catch (Exception e10) {
                    throw new SignatureException("Unable to verify Elliptic Curve signature using provided ECPublicKey: " + e10.getMessage(), e10);
                }
            }
        })).booleanValue();
    }

    public boolean isValidRAndS(PublicKey publicKey, byte[] bArr) {
        if (!(publicKey instanceof ECKey)) {
            return true;
        }
        BigInteger order = ((ECKey) publicKey).getParams().getOrder();
        BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 0, this.sigFieldByteLength));
        BigInteger bigInteger2 = new BigInteger(1, Arrays.copyOfRange(bArr, this.sigFieldByteLength, bArr.length));
        return bigInteger.signum() >= 1 && bigInteger2.signum() >= 1 && bigInteger.compareTo(order) < 0 && bigInteger2.compareTo(order) < 0;
    }

    @Override // io.jsonwebtoken.security.KeyPairBuilderSupplier
    public KeyPairBuilder keyPair() {
        return new DefaultKeyPairBuilder("EC", this.KEY_PAIR_GEN_PARAMS).random(Randoms.secureRandom());
    }

    @Override // io.jsonwebtoken.impl.security.AbstractSignatureAlgorithm, io.jsonwebtoken.impl.security.AbstractSecureDigestAlgorithm
    public void validateKey(Key key, boolean z10) {
        super.validateKey(key, z10);
        if (!KEY_ALG_NAMES.contains(KeysBridge.findAlgorithm(key))) {
            throw new InvalidKeyException("Unrecognized EC key algorithm name.");
        }
        int findBitLength = KeysBridge.findBitLength(key);
        if (findBitLength >= 0 && Bytes.length(findBitLength) * 2 != this.signatureByteLength) {
            throw new InvalidKeyException("The provided Elliptic Curve " + AbstractSecureDigestAlgorithm.keyType(z10) + " key size (aka order bit length) is " + Bytes.bitsMsg(findBitLength) + ", but the '" + getId() + "' algorithm requires EC Keys with " + Bytes.bitsMsg(this.orderBitLength) + " per [RFC 7518, Section 3.4](https://www.rfc-editor.org/rfc/rfc7518.html#section-3.4).");
        }
    }
}
