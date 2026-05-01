package io.jsonwebtoken.io;

import io.jsonwebtoken.Identifiable;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public interface CompressionAlgorithm extends Identifiable {
    OutputStream compress(OutputStream outputStream);

    InputStream decompress(InputStream inputStream);
}
