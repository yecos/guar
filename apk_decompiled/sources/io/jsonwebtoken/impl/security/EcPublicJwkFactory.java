package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.RequiredParameterReader;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.EcPublicJwk;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Jwk;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Map;

/* loaded from: classes3.dex */
class EcPublicJwkFactory extends AbstractEcJwkFactory<ECPublicKey, EcPublicJwk> {
    static final EcPublicJwkFactory INSTANCE = new EcPublicJwkFactory();
    private static final String UNSUPPORTED_CURVE_MSG = "The specified ECKey curve does not match a JWA standard curve id.";

    public EcPublicJwkFactory() {
        super(ECPublicKey.class, DefaultEcPublicJwk.PARAMS);
    }

    public static String getJwaIdByCurve(EllipticCurve ellipticCurve) {
        ECCurve findByJcaCurve = ECCurve.findByJcaCurve(ellipticCurve);
        if (findByJcaCurve != null) {
            return findByJcaCurve.getId();
        }
        throw new InvalidKeyException(UNSUPPORTED_CURVE_MSG);
    }

    public static String jwkContainsErrorMessage(String str, Map<String, ?> map) {
        Assert.hasText(str, "curveId cannot be null or empty.");
        return String.format("EC JWK x,y coordinates do not exist on elliptic curve '%s'. This could be due simply to an incorrectly-created JWK or possibly an attempted Invalid Curve Attack (see https://safecurves.cr.yp.to/twist.html for more information).", str, map);
    }

    public static String keyContainsErrorMessage(String str) {
        Assert.hasText(str, "curveId cannot be null or empty.");
        return String.format("ECPublicKey's ECPoint does not exist on elliptic curve '%s' and may not be used to create '%s' JWKs.", str, str);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public /* bridge */ /* synthetic */ Jwk createJwkFromKey(JwkContext jwkContext) {
        return createJwkFromKey((JwkContext<ECPublicKey>) jwkContext);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public /* bridge */ /* synthetic */ Jwk createJwkFromValues(JwkContext jwkContext) {
        return createJwkFromValues((JwkContext<ECPublicKey>) jwkContext);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public EcPublicJwk createJwkFromKey(JwkContext<ECPublicKey> jwkContext) {
        ECPublicKey key = jwkContext.getKey();
        EllipticCurve curve = key.getParams().getCurve();
        ECPoint w10 = key.getW();
        String jwaIdByCurve = getJwaIdByCurve(curve);
        if (!ECCurve.contains(curve, w10)) {
            throw new InvalidKeyException(keyContainsErrorMessage(jwaIdByCurve));
        }
        jwkContext.put(DefaultEcPublicJwk.CRV.getId(), jwaIdByCurve);
        jwkContext.put(DefaultEcPublicJwk.X.getId(), AbstractEcJwkFactory.toOctetString(curve, w10.getAffineX()));
        jwkContext.put(DefaultEcPublicJwk.Y.getId(), AbstractEcJwkFactory.toOctetString(curve, w10.getAffineY()));
        return new DefaultEcPublicJwk(jwkContext);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public EcPublicJwk createJwkFromValues(JwkContext<ECPublicKey> jwkContext) {
        RequiredParameterReader requiredParameterReader = new RequiredParameterReader(jwkContext);
        String str = (String) requiredParameterReader.get(DefaultEcPublicJwk.CRV);
        BigInteger bigInteger = (BigInteger) requiredParameterReader.get(DefaultEcPublicJwk.X);
        BigInteger bigInteger2 = (BigInteger) requiredParameterReader.get(DefaultEcPublicJwk.Y);
        ECCurve curveByJwaId = AbstractEcJwkFactory.getCurveByJwaId(str);
        ECPoint eCPoint = new ECPoint(bigInteger, bigInteger2);
        if (!curveByJwaId.contains(eCPoint)) {
            throw new InvalidKeyException(jwkContainsErrorMessage(str, jwkContext));
        }
        final ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(eCPoint, curveByJwaId.toParameterSpec());
        jwkContext.setKey((ECPublicKey) generateKey(jwkContext, new CheckedFunction<KeyFactory, ECPublicKey>() { // from class: io.jsonwebtoken.impl.security.EcPublicJwkFactory.1
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public ECPublicKey apply(KeyFactory keyFactory) {
                return (ECPublicKey) keyFactory.generatePublic(eCPublicKeySpec);
            }
        }));
        return new DefaultEcPublicJwk(jwkContext);
    }
}
