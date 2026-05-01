package io.jsonwebtoken;

import java.util.Map;

/* loaded from: classes3.dex */
public interface Header extends Map<String, Object> {

    @Deprecated
    public static final String ALGORITHM = "alg";

    @Deprecated
    public static final String COMPRESSION_ALGORITHM = "zip";

    @Deprecated
    public static final String CONTENT_TYPE = "cty";

    @Deprecated
    public static final String DEPRECATED_COMPRESSION_ALGORITHM = "calg";

    @Deprecated
    public static final String JWT_TYPE = "JWT";

    @Deprecated
    public static final String TYPE = "typ";

    String getAlgorithm();

    String getCompressionAlgorithm();

    String getContentType();

    String getType();
}
