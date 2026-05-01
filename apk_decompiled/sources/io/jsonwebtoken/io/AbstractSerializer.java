package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Objects;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public abstract class AbstractSerializer<T> implements Serializer<T> {
    public abstract void doSerialize(T t10, OutputStream outputStream);

    @Override // io.jsonwebtoken.io.Serializer
    public final byte[] serialize(T t10) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        serialize(t10, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // io.jsonwebtoken.io.Serializer
    public final void serialize(T t10, OutputStream outputStream) {
        try {
            doSerialize(t10, outputStream);
        } catch (Throwable th) {
            if (th instanceof SerializationException) {
                throw th;
            }
            throw new SerializationException("Unable to serialize object of type " + Objects.nullSafeClassName(t10) + ": " + th.getMessage(), th);
        }
    }
}
