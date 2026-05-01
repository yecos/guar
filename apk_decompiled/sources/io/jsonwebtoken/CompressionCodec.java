package io.jsonwebtoken;

import io.jsonwebtoken.io.CompressionAlgorithm;

@Deprecated
/* loaded from: classes3.dex */
public interface CompressionCodec extends CompressionAlgorithm {
    @Deprecated
    byte[] compress(byte[] bArr);

    @Deprecated
    byte[] decompress(byte[] bArr);

    @Deprecated
    String getAlgorithmName();
}
