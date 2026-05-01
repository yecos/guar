package io.jsonwebtoken.security;

import java.security.Key;

/* loaded from: classes3.dex */
public interface DecryptionKeyRequest<K extends Key> extends SecureRequest<byte[], K>, KeyRequest<byte[]> {
}
