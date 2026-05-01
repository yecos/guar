package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.Converters;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.UnsupportedKeyException;
import java.math.BigInteger;
import java.security.Key;
import java.security.interfaces.ECKey;
import java.security.spec.EllipticCurve;
import java.util.Set;

/* loaded from: classes3.dex */
abstract class AbstractEcJwkFactory<K extends Key & ECKey, J extends Jwk<K>> extends AbstractFamilyJwkFactory<K, J> {
    public AbstractEcJwkFactory(Class<K> cls, Set<Parameter<?>> set) {
        super("EC", cls, set);
    }

    public static ECCurve getCurveByJwaId(String str) {
        ECCurve findById = ECCurve.findById(str);
        if (findById != null) {
            return findById;
        }
        throw new UnsupportedKeyException("Unrecognized JWA EC curve id '" + str + "'");
    }

    public static String toOctetString(EllipticCurve ellipticCurve, BigInteger bigInteger) {
        return Encoders.BASE64URL.encode(Bytes.prepad(Converters.BIGINT_UBYTES.applyTo(bigInteger), Bytes.length(ellipticCurve.getField().getFieldSize())));
    }
}
