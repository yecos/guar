package io.jsonwebtoken;

import io.jsonwebtoken.ProtectedHeader;
import io.jsonwebtoken.security.DigestSupplier;

/* loaded from: classes3.dex */
public interface ProtectedJwt<H extends ProtectedHeader, P> extends Jwt<H, P>, DigestSupplier {
}
