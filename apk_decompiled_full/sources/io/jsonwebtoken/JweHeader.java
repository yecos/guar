package io.jsonwebtoken;

import io.jsonwebtoken.security.PublicJwk;

/* loaded from: classes3.dex */
public interface JweHeader extends ProtectedHeader {
    byte[] getAgreementPartyUInfo();

    byte[] getAgreementPartyVInfo();

    byte[] getAuthenticationTag();

    String getEncryptionAlgorithm();

    PublicJwk<?> getEphemeralPublicKey();

    byte[] getInitializationVector();

    Integer getPbes2Count();

    byte[] getPbes2Salt();
}
