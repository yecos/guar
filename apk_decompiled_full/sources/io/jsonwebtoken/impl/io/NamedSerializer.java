package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.io.AbstractSerializer;
import io.jsonwebtoken.io.SerializationException;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Assert;
import java.io.OutputStream;
import java.util.Map;

/* loaded from: classes3.dex */
public class NamedSerializer extends AbstractSerializer<Map<String, ?>> {
    private final Serializer<Map<String, ?>> DELEGATE;
    private final String name;

    public NamedSerializer(String str, Serializer<Map<String, ?>> serializer) {
        this.DELEGATE = (Serializer) Assert.notNull(serializer, "JSON Serializer cannot be null.");
        this.name = (String) Assert.hasText(str, "Name cannot be null or empty.");
    }

    @Override // io.jsonwebtoken.io.AbstractSerializer
    public void doSerialize(Map<String, ?> map, OutputStream outputStream) {
        try {
            this.DELEGATE.serialize(map, outputStream);
        } catch (Throwable th) {
            throw new SerializationException(String.format("Cannot serialize %s to JSON. Cause: %s", this.name, th.getMessage()), th);
        }
    }
}
