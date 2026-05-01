package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.HashAlgorithm;
import io.jsonwebtoken.security.Request;
import io.jsonwebtoken.security.VerifyDigestRequest;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class DefaultHashAlgorithm extends CryptoAlgorithm implements HashAlgorithm {
    public static final HashAlgorithm SHA1 = new DefaultHashAlgorithm("sha-1");

    public DefaultHashAlgorithm(String str) {
        super(str, str.toUpperCase(Locale.ENGLISH));
    }

    @Override // io.jsonwebtoken.security.DigestAlgorithm
    public byte[] digest(Request<InputStream> request) {
        Assert.notNull(request, "Request cannot be null.");
        final InputStream inputStream = (InputStream) Assert.notNull(request.getPayload(), "Request payload cannot be null.");
        return (byte[]) jca(request).withMessageDigest(new CheckedFunction<MessageDigest, byte[]>() { // from class: io.jsonwebtoken.impl.security.DefaultHashAlgorithm.1
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public byte[] apply(MessageDigest messageDigest) {
                byte[] bArr = new byte[1024];
                int i10 = 0;
                while (i10 != -1) {
                    i10 = inputStream.read(bArr);
                    if (i10 > 0) {
                        messageDigest.update(bArr, 0, i10);
                    }
                }
                return messageDigest.digest();
            }
        });
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm, io.jsonwebtoken.Identifiable
    public /* bridge */ /* synthetic */ String getId() {
        return super.getId();
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // io.jsonwebtoken.impl.security.CryptoAlgorithm
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // io.jsonwebtoken.security.DigestAlgorithm
    public boolean verify(VerifyDigestRequest verifyDigestRequest) {
        Assert.notNull(verifyDigestRequest, "VerifyDigestRequest cannot be null.");
        return MessageDigest.isEqual(digest(verifyDigestRequest), (byte[]) Assert.notNull(verifyDigestRequest.getDigest(), "Digest cannot be null."));
    }
}
