package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.lang.Assert;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/* loaded from: classes3.dex */
public class JwtX509StringConverter implements Converter<X509Certificate, CharSequence> {
    public static final JwtX509StringConverter INSTANCE = new JwtX509StringConverter();

    public X509Certificate toCert(byte[] bArr) {
        return new JcaTemplate("X.509").generateX509Certificate(bArr);
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public X509Certificate applyFrom(CharSequence charSequence) {
        Assert.hasText(charSequence, "X.509 Certificate encoded string cannot be null or empty.");
        try {
            return toCert(Decoders.BASE64.decode(charSequence));
        } catch (Exception e10) {
            throw new IllegalArgumentException("Unable to convert Base64 String '" + ((Object) charSequence) + "' to X509Certificate instance. Cause: " + e10.getMessage(), e10);
        }
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public String applyTo(X509Certificate x509Certificate) {
        Assert.notNull(x509Certificate, "X509Certificate cannot be null.");
        try {
            byte[] encoded = x509Certificate.getEncoded();
            if (!Bytes.isEmpty(encoded)) {
                return Encoders.BASE64.encode(encoded);
            }
            throw new IllegalArgumentException("X509Certificate encoded bytes cannot be null or empty.  Certificate: {" + x509Certificate + "}.");
        } catch (CertificateEncodingException e10) {
            throw new IllegalArgumentException("Unable to access X509Certificate encoded bytes necessary to perform DER Base64-encoding. Certificate: {" + x509Certificate + "}. Cause: " + e10.getMessage(), e10);
        }
    }
}
