package io.jsonwebtoken.security;

import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.security.Request;
import io.jsonwebtoken.security.VerifyDigestRequest;
import java.io.InputStream;

/* loaded from: classes3.dex */
public interface DigestAlgorithm<R extends Request<InputStream>, V extends VerifyDigestRequest> extends Identifiable {
    byte[] digest(R r10);

    boolean verify(V v10);
}
