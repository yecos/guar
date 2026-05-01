package io.jsonwebtoken;

import io.jsonwebtoken.Jwts;

@Deprecated
/* loaded from: classes3.dex */
public final class CompressionCodecs {

    @Deprecated
    public static final CompressionCodec DEFLATE = (CompressionCodec) Jwts.ZIP.DEF;

    @Deprecated
    public static final CompressionCodec GZIP = (CompressionCodec) Jwts.ZIP.GZIP;

    private CompressionCodecs() {
    }
}
