package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.NamedSerializer;
import io.jsonwebtoken.impl.lang.Services;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.Jwk;
import java.io.ByteArrayOutputStream;

/* loaded from: classes3.dex */
public final class JwksBridge {
    private JwksBridge() {
    }

    public static String UNSAFE_JSON(Jwk<?> jwk) {
        Serializer serializer = (Serializer) Services.get(Serializer.class);
        Assert.stateNotNull(serializer, "Serializer lookup failed. Ensure JSON impl .jar is in the runtime classpath.");
        NamedSerializer namedSerializer = new NamedSerializer("JWK", serializer);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        namedSerializer.serialize(jwk, byteArrayOutputStream);
        return Strings.utf8(byteArrayOutputStream.toByteArray());
    }
}
