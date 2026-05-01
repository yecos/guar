package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.KeyPairBuilder;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.interfaces.ECKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class ECCurve extends AbstractCurve {
    private static final Map<String, ECCurve> BY_ID;
    private static final Map<EllipticCurve, ECCurve> BY_JCA_CURVE;
    static final String KEY_PAIR_GENERATOR_JCA_NAME = "EC";
    public static final ECCurve P256;
    public static final ECCurve P384;
    public static final ECCurve P521;
    public static final Collection<ECCurve> VALUES;
    private final ECParameterSpec spec;
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger THREE = BigInteger.valueOf(3);

    static {
        ECCurve eCCurve = new ECCurve("P-256", "secp256r1");
        P256 = eCCurve;
        ECCurve eCCurve2 = new ECCurve("P-384", "secp384r1");
        P384 = eCCurve2;
        ECCurve eCCurve3 = new ECCurve("P-521", "secp521r1");
        P521 = eCCurve3;
        Set<ECCurve> of = Collections.setOf(eCCurve, eCCurve2, eCCurve3);
        VALUES = of;
        BY_ID = new LinkedHashMap(3);
        BY_JCA_CURVE = new LinkedHashMap(3);
        for (ECCurve eCCurve4 : of) {
            BY_ID.put(eCCurve4.getId(), eCCurve4);
        }
        for (ECCurve eCCurve5 : VALUES) {
            BY_JCA_CURVE.put(eCCurve5.spec.getCurve(), eCCurve5);
        }
    }

    public ECCurve(String str, String str2) {
        super(str, str2);
        this.spec = (ECParameterSpec) new JcaTemplate(KEY_PAIR_GENERATOR_JCA_NAME).withAlgorithmParameters(new CheckedFunction<AlgorithmParameters, ECParameterSpec>() { // from class: io.jsonwebtoken.impl.security.ECCurve.1
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public ECParameterSpec apply(AlgorithmParameters algorithmParameters) {
                algorithmParameters.init(new ECGenParameterSpec(ECCurve.this.getJcaName()));
                return (ECParameterSpec) algorithmParameters.getParameterSpec(ECParameterSpec.class);
            }
        });
    }

    private ECPoint add(ECPoint eCPoint, ECPoint eCPoint2) {
        if (ECPoint.POINT_INFINITY.equals(eCPoint)) {
            return eCPoint2;
        }
        if (ECPoint.POINT_INFINITY.equals(eCPoint2)) {
            return eCPoint;
        }
        if (eCPoint.equals(eCPoint2)) {
            return doublePoint(eCPoint);
        }
        EllipticCurve curve = this.spec.getCurve();
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        BigInteger affineX2 = eCPoint2.getAffineX();
        BigInteger affineY2 = eCPoint2.getAffineY();
        BigInteger p10 = ((ECFieldFp) curve.getField()).getP();
        BigInteger mod = affineY2.subtract(affineY).multiply(affineX2.subtract(affineX).modInverse(p10)).mod(p10);
        BigInteger mod2 = mod.pow(2).subtract(affineX).subtract(affineX2).mod(p10);
        return new ECPoint(mod2, mod.multiply(affineX.subtract(mod2)).subtract(affineY).mod(p10));
    }

    public static EllipticCurve assertJcaCurve(ECKey eCKey) {
        Assert.notNull(eCKey, "ECKey cannot be null.");
        return (EllipticCurve) Assert.notNull(((ECParameterSpec) Assert.notNull(eCKey.getParams(), "ECKey params() cannot be null.")).getCurve(), "ECKey params().getCurve() cannot be null.");
    }

    private ECPoint doublePoint(ECPoint eCPoint) {
        if (ECPoint.POINT_INFINITY.equals(eCPoint)) {
            return eCPoint;
        }
        EllipticCurve curve = this.spec.getCurve();
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        BigInteger p10 = ((ECFieldFp) curve.getField()).getP();
        BigInteger mod = THREE.multiply(affineX.pow(2)).add(curve.getA()).mod(p10);
        BigInteger bigInteger = TWO;
        BigInteger mod2 = mod.multiply(bigInteger.multiply(affineY).modInverse(p10)).mod(p10);
        BigInteger mod3 = mod2.pow(2).subtract(bigInteger.multiply(affineX)).mod(p10);
        return new ECPoint(mod3, mod2.multiply(affineX.subtract(mod3)).subtract(affineY).mod(p10));
    }

    public static ECCurve findById(String str) {
        return BY_ID.get(str);
    }

    public static ECCurve findByJcaCurve(EllipticCurve ellipticCurve) {
        return BY_JCA_CURVE.get(ellipticCurve);
    }

    public static ECCurve findByKey(Key key) {
        ECParameterSpec params;
        ECPoint w10;
        if (!(key instanceof ECKey) || (params = ((ECKey) key).getParams()) == null) {
            return null;
        }
        ECCurve eCCurve = BY_JCA_CURVE.get(params.getCurve());
        if (eCCurve == null || !(key instanceof ECPublicKey) || ((w10 = ((ECPublicKey) key).getW()) != null && eCCurve.contains(w10))) {
            return eCCurve;
        }
        return null;
    }

    private ECPoint multiply(BigInteger bigInteger) {
        return multiply(this.spec.getGenerator(), bigInteger);
    }

    public static ECPublicKeySpec publicKeySpec(ECPrivateKey eCPrivateKey) {
        ECCurve eCCurve = BY_JCA_CURVE.get(assertJcaCurve(eCPrivateKey));
        Assert.notNull(eCCurve, "There is no JWA-standard Elliptic Curve for specified ECPrivateKey.");
        return new ECPublicKeySpec(eCCurve.multiply(eCPrivateKey.getS()), eCCurve.spec);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractCurve
    public boolean contains(Key key) {
        ECPublicKey eCPublicKey;
        ECParameterSpec params;
        return (key instanceof ECPublicKey) && (params = (eCPublicKey = (ECPublicKey) key).getParams()) != null && this.spec.getCurve().equals(params.getCurve()) && contains(eCPublicKey.getW());
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

    @Override // io.jsonwebtoken.impl.security.AbstractCurve
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // io.jsonwebtoken.impl.security.AbstractCurve, io.jsonwebtoken.security.KeyPairBuilderSupplier
    public KeyPairBuilder keyPair() {
        return new DefaultKeyPairBuilder(KEY_PAIR_GENERATOR_JCA_NAME, toParameterSpec());
    }

    public ECParameterSpec toParameterSpec() {
        return this.spec;
    }

    @Override // io.jsonwebtoken.impl.security.AbstractCurve
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger) {
        if (ECPoint.POINT_INFINITY.equals(eCPoint)) {
            return eCPoint;
        }
        BigInteger mod = bigInteger.mod(this.spec.getOrder());
        ECPoint eCPoint2 = ECPoint.POINT_INFINITY;
        for (int bitLength = mod.bitLength() - 1; bitLength >= 0; bitLength--) {
            if (mod.testBit(bitLength)) {
                eCPoint2 = add(eCPoint2, eCPoint);
                eCPoint = doublePoint(eCPoint);
            } else {
                eCPoint = add(eCPoint2, eCPoint);
                eCPoint2 = doublePoint(eCPoint2);
            }
        }
        return eCPoint2;
    }

    public boolean contains(ECPoint eCPoint) {
        return contains(this.spec.getCurve(), eCPoint);
    }

    public static boolean contains(EllipticCurve ellipticCurve, ECPoint eCPoint) {
        if (eCPoint != null && !ECPoint.POINT_INFINITY.equals(eCPoint)) {
            BigInteger a10 = ellipticCurve.getA();
            BigInteger b10 = ellipticCurve.getB();
            BigInteger affineX = eCPoint.getAffineX();
            BigInteger affineY = eCPoint.getAffineY();
            BigInteger p10 = ((ECFieldFp) ellipticCurve.getField()).getP();
            BigInteger bigInteger = BigInteger.ZERO;
            if (affineX.compareTo(bigInteger) >= 0 && affineX.compareTo(p10) < 0 && affineY.compareTo(bigInteger) >= 0 && affineY.compareTo(p10) < 0) {
                return affineY.modPow(TWO, p10).equals(affineX.modPow(THREE, p10).add(a10.multiply(affineX)).add(b10).mod(p10));
            }
        }
        return false;
    }
}
