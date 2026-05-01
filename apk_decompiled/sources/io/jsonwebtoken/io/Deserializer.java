package io.jsonwebtoken.io;

import java.io.Reader;

/* loaded from: classes3.dex */
public interface Deserializer<T> {
    T deserialize(Reader reader);

    @Deprecated
    T deserialize(byte[] bArr);
}
