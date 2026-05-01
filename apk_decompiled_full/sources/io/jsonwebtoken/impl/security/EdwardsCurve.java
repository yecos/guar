package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyException;
import io.jsonwebtoken.security.KeyLengthSupplier;
import io.jsonwebtoken.security.KeyPairBuilder;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class EdwardsCurve extends AbstractCurve implements KeyLengthSupplier {
    private static final Map<Integer, EdwardsCurve> BY_OID_TERMINAL_NODE;
    public static final EdwardsCurve Ed25519;
    public static final EdwardsCurve Ed448;
    private static final String OID_PREFIX = "1.3.101.";
    private static final Map<String, EdwardsCurve> REGISTRY;
    public static final Collection<EdwardsCurve> VALUES;
    public static final EdwardsCurve X25519;
    public static final EdwardsCurve X448;
    final byte[] ASN1_OID;
    private final String OID;
    private final byte[] PRIVATE_KEY_ASN1_PREFIX;
    private final byte[] PRIVATE_KEY_JDK11_PREFIX;
    private final byte[] PUBLIC_KEY_ASN1_PREFIX;
    private final int encodedKeyByteLength;
    private final int keyBitLength;
    private final boolean signatureCurve;
    private static final byte[] ASN1_OID_PREFIX = {6, 3, 43, 101};
    private static final Function<Key, String> CURVE_NAME_FINDER = new NamedParameterSpecValueFinder();

    static {
        EdwardsCurve edwardsCurve = new EdwardsCurve("X25519", 110);
        X25519 = edwardsCurve;
        EdwardsCurve edwardsCurve2 = new EdwardsCurve("X448", 111);
        X448 = edwardsCurve2;
        EdwardsCurve edwardsCurve3 = new EdwardsCurve("Ed25519", 112);
        Ed25519 = edwardsCurve3;
        EdwardsCurve edwardsCurve4 = new EdwardsCurve("Ed448", 113);
        Ed448 = edwardsCurve4;
        List<EdwardsCurve> of = Collections.of(edwardsCurve, edwardsCurve2, edwardsCurve3, edwardsCurve4);
        VALUES = of;
        REGISTRY = new LinkedHashMap(8);
        BY_OID_TERMINAL_NODE = new LinkedHashMap(4);
        for (EdwardsCurve edwardsCurve5 : of) {
            byte[] bArr = edwardsCurve5.ASN1_OID;
            BY_OID_TERMINAL_NODE.put(Integer.valueOf(bArr[bArr.length - 1]), edwardsCurve5);
            Map<String, EdwardsCurve> map = REGISTRY;
            map.put(edwardsCurve5.getId(), edwardsCurve5);
            map.put(edwardsCurve5.OID, edwardsCurve5);
        }
    }

    public EdwardsCurve(String str, int i10) {
        super(str, str);
        if (i10 < 110 || i10 > 113) {
            throw new IllegalArgumentException("Invalid Edwards Curve ASN.1 OID terminal node value");
        }
        int i11 = i10 % 2 == 0 ? 255 : 448;
        this.keyBitLength = i11;
        int length = Bytes.length(i10 == 113 ? i11 + 8 : i11);
        this.encodedKeyByteLength = length;
        this.OID = OID_PREFIX + i10;
        this.signatureCurve = i10 == 112 || i10 == 113;
        byte[] concat = Bytes.concat(ASN1_OID_PREFIX, new byte[]{(byte) i10});
        this.ASN1_OID = concat;
        this.PUBLIC_KEY_ASN1_PREFIX = publicKeyAsn1Prefix(length, concat);
        this.PRIVATE_KEY_ASN1_PREFIX = privateKeyPkcs8Prefix(length, concat, true);
        this.PRIVATE_KEY_JDK11_PREFIX = privateKeyPkcs8Prefix(length, concat, false);
    }

    public static <K extends Key> K assertEdwards(K k10) {
        forKey(k10);
        return k10;
    }

    private void assertLength(byte[] bArr, boolean z10) {
        int length = Bytes.length(bArr);
        if (length != this.encodedKeyByteLength) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid ");
            sb.append(getId());
            sb.append(" encoded ");
            sb.append(z10 ? "PublicKey" : "PrivateKey");
            sb.append(" length. Should be ");
            sb.append(Bytes.bytesMsg(this.encodedKeyByteLength));
            sb.append(", found ");
            sb.append(Bytes.bytesMsg(length));
            sb.append(".");
            throw new InvalidKeyException(sb.toString());
        }
    }

    public static PublicKey derivePublic(PrivateKey privateKey) {
        return EdwardsPublicKeyDeriver.INSTANCE.apply(privateKey);
    }

    public static EdwardsCurve findById(String str) {
        return REGISTRY.get(str);
    }

    public static EdwardsCurve findByKey(Key key) {
        if (key == null) {
            return null;
        }
        EdwardsCurve findById = findById(key.getAlgorithm());
        if (findById == null) {
            findById = findById(CURVE_NAME_FINDER.apply(key));
        }
        byte[] findEncoded = KeysBridge.findEncoded(key);
        if (findById == null && !Bytes.isEmpty(findEncoded)) {
            findById = BY_OID_TERMINAL_NODE.get(Integer.valueOf(findOidTerminalNode(findEncoded)));
        }
        if (findById != null && !Bytes.isEmpty(findEncoded)) {
            try {
                findById.getKeyMaterial(key);
            } catch (Throwable unused) {
                return null;
            }
        }
        return findById;
    }

    private static int findOidTerminalNode(byte[] bArr) {
        int length;
        byte[] bArr2 = ASN1_OID_PREFIX;
        int indexOf = Bytes.indexOf(bArr, bArr2);
        if (indexOf <= -1 || (length = indexOf + bArr2.length) >= bArr.length) {
            return -1;
        }
        return bArr[length];
    }

    public static EdwardsCurve forKey(Key key) {
        Assert.notNull(key, "Key cannot be null.");
        EdwardsCurve findByKey = findByKey(key);
        if (findByKey != null) {
            return findByKey;
        }
        throw new InvalidKeyException("Unrecognized Edwards Curve key: [" + KeysBridge.toString(key) + "]");
    }

    public static boolean isEdwards(Key key) {
        if (key == null) {
            return false;
        }
        String clean = Strings.clean(key.getAlgorithm());
        return "EdDSA".equals(clean) || "XDH".equals(clean) || findByKey(key) != null;
    }

    private static byte[] privateKeyPkcs8Prefix(int i10, byte[] bArr, boolean z10) {
        byte[] bArr2 = z10 ? new byte[]{4, (byte) (i10 + 2), 4, (byte) i10} : new byte[]{4, (byte) i10};
        return Bytes.concat(new byte[]{48, (byte) (bArr.length + 5 + bArr2.length + i10), 2, 1, 0, 48, 5}, bArr, bArr2);
    }

    private static byte[] publicKeyAsn1Prefix(int i10, byte[] bArr) {
        return Bytes.concat(new byte[]{48, (byte) (i10 + 10), 48, 5}, bArr, new byte[]{3, (byte) (i10 + 1), 0});
    }

    @Override // io.jsonwebtoken.impl.security.AbstractCurve
    public boolean contains(Key key) {
        return findByKey(key).equals(this);
    }

    public byte[] doGetKeyMaterial(Key key) {
        byte[] encoded = KeysBridge.getEncoded(key);
        int indexOf = Bytes.indexOf(encoded, this.ASN1_OID);
        Assert.gt(Integer.valueOf(indexOf), -1, "Missing or incorrect algorithm OID.");
        int length = indexOf + this.ASN1_OID.length;
        int i10 = 0;
        if (encoded[length] == 5) {
            int i11 = length + 1;
            Assert.eq(Integer.valueOf(encoded[i11]), 0, "OID NULL terminator should indicate zero unused bytes.");
            length = i11 + 1;
        }
        char c10 = encoded[length];
        if (c10 == 3) {
            int i12 = length + 1;
            int i13 = i12 + 1;
            int i14 = encoded[i12];
            Assert.eq(Integer.valueOf(encoded[i13]), 0, "BIT STREAM should not indicate unused bytes.");
            i10 = i14 - 1;
            length = i13 + 1;
        } else if (c10 == 4) {
            int i15 = length + 1;
            int i16 = i15 + 1;
            i10 = encoded[i15];
            if (encoded[i16] == 4) {
                int i17 = i16 + 1;
                length = i17 + 1;
                i10 = encoded[i17];
            } else {
                length = i16;
            }
        }
        Assert.eq(Integer.valueOf(i10), Integer.valueOf(this.encodedKeyByteLength), "Invalid key length.");
        byte[] copyOfRange = Arrays.copyOfRange(encoded, length, i10 + length);
        Assert.eq(Integer.valueOf(Bytes.length(copyOfRange)), Integer.valueOf(this.encodedKeyByteLength), "Invalid key length.");
        return copyOfRange;
    }

    @Override // io.jsonwebtoken.impl.security.AbstractCurve
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractCurve, io.jsonwebtoken.Identifiable
    public /* bridge */ /* synthetic */ String getId() {
        return super.getId();
    }

    @Override // io.jsonwebtoken.impl.security.AbstractCurve
    public /* bridge */ /* synthetic */ String getJcaName() {
        return super.getJcaName();
    }

    @Override // io.jsonwebtoken.security.KeyLengthSupplier
    public int getKeyBitLength() {
        return this.keyBitLength;
    }

    public byte[] getKeyMaterial(Key key) {
        try {
            return doGetKeyMaterial(key);
        } catch (Throwable th) {
            if (th instanceof KeyException) {
                throw th;
            }
            throw new InvalidKeyException("Invalid " + getId() + " ASN.1 encoding: " + th.getMessage(), th);
        }
    }

    @Override // io.jsonwebtoken.impl.security.AbstractCurve
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public boolean isSignatureCurve() {
        return this.signatureCurve;
    }

    @Override // io.jsonwebtoken.impl.security.AbstractCurve, io.jsonwebtoken.security.KeyPairBuilderSupplier
    public KeyPairBuilder keyPair() {
        return new DefaultKeyPairBuilder(getJcaName(), this.keyBitLength);
    }

    public KeySpec privateKeySpec(byte[] bArr, boolean z10) {
        return new PKCS8EncodedKeySpec(Bytes.concat(z10 ? this.PRIVATE_KEY_ASN1_PREFIX : this.PRIVATE_KEY_JDK11_PREFIX, bArr));
    }

    public PrivateKey toPrivateKey(byte[] bArr, Provider provider) {
        assertLength(bArr, false);
        return new JcaTemplate(getJcaName(), provider).generatePrivate(privateKeySpec(bArr, true));
    }

    public PublicKey toPublicKey(byte[] bArr, Provider provider) {
        assertLength(bArr, true);
        return new JcaTemplate(getJcaName(), provider).generatePublic(new X509EncodedKeySpec(Bytes.concat(this.PUBLIC_KEY_ASN1_PREFIX, bArr)));
    }

    @Override // io.jsonwebtoken.impl.security.AbstractCurve
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
