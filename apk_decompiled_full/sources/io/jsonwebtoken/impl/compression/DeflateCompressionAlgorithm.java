package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.lang.Objects;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import java.util.zip.InflaterOutputStream;

/* loaded from: classes3.dex */
public class DeflateCompressionAlgorithm extends AbstractCompressionAlgorithm {
    private static final String ID = "DEF";

    public DeflateCompressionAlgorithm() {
        super(ID);
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionAlgorithm
    public OutputStream doCompress(OutputStream outputStream) {
        return new DeflaterOutputStream(outputStream);
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionAlgorithm
    public InputStream doDecompress(InputStream inputStream) {
        return new InflaterInputStream(inputStream);
    }

    public byte[] doDecompressBackCompat(byte[] bArr) {
        InflaterOutputStream inflaterOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                inflaterOutputStream = new InflaterOutputStream(byteArrayOutputStream2);
                try {
                    inflaterOutputStream.write(bArr);
                    inflaterOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    Objects.nullSafeClose(byteArrayOutputStream2, inflaterOutputStream);
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    Objects.nullSafeClose(byteArrayOutputStream, inflaterOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inflaterOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inflaterOutputStream = null;
        }
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionAlgorithm
    public byte[] doDecompress(byte[] bArr) {
        try {
            return super.doDecompress(bArr);
        } catch (IOException e10) {
            try {
                return doDecompressBackCompat(bArr);
            } catch (IOException unused) {
                throw e10;
            }
        }
    }
}
