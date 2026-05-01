package io.jsonwebtoken.security;

import io.jsonwebtoken.JweHeader;

/* loaded from: classes3.dex */
public interface KeyRequest<T> extends Request<T> {
    AeadAlgorithm getEncryptionAlgorithm();

    JweHeader getHeader();
}
