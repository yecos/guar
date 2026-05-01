package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import java.net.URI;

/* loaded from: classes3.dex */
public class UriStringConverter implements Converter<URI, CharSequence> {
    @Override // io.jsonwebtoken.impl.lang.Converter
    public URI applyFrom(CharSequence charSequence) {
        Assert.hasText(charSequence, "URI string cannot be null or empty.");
        try {
            return URI.create(charSequence.toString());
        } catch (Exception e10) {
            throw new IllegalArgumentException("Unable to convert String value '" + ((Object) charSequence) + "' to URI instance: " + e10.getMessage(), e10);
        }
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public String applyTo(URI uri) {
        Assert.notNull(uri, "URI cannot be null.");
        return uri.toString();
    }
}
