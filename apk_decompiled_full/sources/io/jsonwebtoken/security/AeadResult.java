package io.jsonwebtoken.security;

import java.io.OutputStream;

/* loaded from: classes3.dex */
public interface AeadResult {
    OutputStream getOutputStream();

    AeadResult setIv(byte[] bArr);

    AeadResult setTag(byte[] bArr);
}
