package io.jsonwebtoken.impl.compression;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public class GzipCompressionAlgorithm extends AbstractCompressionAlgorithm {
    private static final String ID = "GZIP";

    public GzipCompressionAlgorithm() {
        super(ID);
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionAlgorithm
    public OutputStream doCompress(OutputStream outputStream) {
        return new GZIPOutputStream(outputStream);
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionAlgorithm
    public InputStream doDecompress(InputStream inputStream) {
        return new GZIPInputStream(inputStream);
    }
}
