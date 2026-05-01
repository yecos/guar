package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;

/* loaded from: classes3.dex */
public final class CompactMediaTypeIdConverter implements Converter<String, Object> {
    private static final String APP_MEDIA_TYPE_PREFIX = "application/";
    private static final char FORWARD_SLASH = '/';
    public static final Converter<String, Object> INSTANCE = new CompactMediaTypeIdConverter();

    public static String compactIfPossible(String str) {
        Assert.hasText(str, "Value cannot be null or empty.");
        if (!Strings.startsWithIgnoreCase(str, APP_MEDIA_TYPE_PREFIX)) {
            return str;
        }
        int length = str.length();
        do {
            length--;
            if (length < 12) {
                return str.substring(12);
            }
        } while (str.charAt(length) != '/');
        return str;
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public String applyFrom(Object obj) {
        Assert.notNull(obj, "Value cannot be null.");
        String str = (String) Assert.isInstanceOf(String.class, obj, "Value must be a string.");
        if (str.indexOf(47) >= 0) {
            return str;
        }
        return APP_MEDIA_TYPE_PREFIX + str;
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public Object applyTo(String str) {
        return compactIfPossible(str);
    }
}
