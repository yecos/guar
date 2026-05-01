package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.io.DeserializationException;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import java.io.Reader;
import java.util.Map;

/* loaded from: classes3.dex */
public class JsonObjectDeserializer implements Function<Reader, Map<String, ?>> {
    private static final String MALFORMED_COMPLEX_ERROR = "Malformed or excessively complex %s JSON. If experienced in a production environment, this could reflect a potential malicious %s, please investigate the source further. Cause: %s";
    private static final String MALFORMED_ERROR = "Malformed %s JSON: %s";
    private final Deserializer<?> deserializer;
    private final String name;

    public JsonObjectDeserializer(Deserializer<?> deserializer, String str) {
        this.deserializer = (Deserializer) Assert.notNull(deserializer, "JSON Deserializer cannot be null.");
        this.name = (String) Assert.hasText(str, "name cannot be null or empty.");
    }

    public RuntimeException malformed(Throwable th) {
        throw new MalformedJwtException(String.format(MALFORMED_ERROR, this.name, th.getMessage()), th);
    }

    @Override // io.jsonwebtoken.impl.lang.Function
    public Map<String, ?> apply(Reader reader) {
        Assert.notNull(reader, "InputStream argument cannot be null.");
        try {
            Object deserialize = this.deserializer.deserialize(reader);
            if (deserialize == null) {
                throw new DeserializationException("Deserialized data resulted in a null value; cannot create Map<String,?>");
            }
            if (deserialize instanceof Map) {
                return (Map) deserialize;
            }
            throw new DeserializationException("Deserialized data is not a JSON Object; cannot create Map<String,?>");
        } catch (StackOverflowError e10) {
            String str = this.name;
            throw new DeserializationException(String.format(MALFORMED_COMPLEX_ERROR, str, str, e10.getMessage()), e10);
        } catch (Throwable th) {
            throw malformed(th);
        }
    }
}
