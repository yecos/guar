package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public abstract class AbstractDeserializer<T> implements Deserializer<T> {
    private static final byte[] EMPTY_BYTES = new byte[0];
    protected static final int EOF = -1;

    @Override // io.jsonwebtoken.io.Deserializer
    public final T deserialize(byte[] bArr) {
        if (bArr == null) {
            bArr = EMPTY_BYTES;
        }
        return deserialize(new InputStreamReader(new ByteArrayInputStream(bArr), StandardCharsets.UTF_8));
    }

    public abstract T doDeserialize(Reader reader);

    @Override // io.jsonwebtoken.io.Deserializer
    public final T deserialize(Reader reader) {
        Assert.notNull(reader, "Reader argument cannot be null.");
        try {
            return doDeserialize(reader);
        } catch (Throwable th) {
            if (th instanceof DeserializationException) {
                throw th;
            }
            throw new DeserializationException("Unable to deserialize: " + th.getMessage(), th);
        }
    }
}
