package io.jsonwebtoken.security;

import io.jsonwebtoken.Identifiable;
import java.security.Key;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public interface KeyAlgorithm<E extends Key, D extends Key> extends Identifiable {
    SecretKey getDecryptionKey(DecryptionKeyRequest<D> decryptionKeyRequest);

    KeyResult getEncryptionKey(KeyRequest<E> keyRequest);
}
