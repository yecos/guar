package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionException;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.impl.lang.PropagatingExceptionFunction;
import io.jsonwebtoken.io.CompressionAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public abstract class AbstractCompressionAlgorithm implements CompressionAlgorithm, CompressionCodec {
    private final String id;
    private final Function<OutputStream, OutputStream> OS_WRAP_FN = forCompression(new CheckedFunction<OutputStream, OutputStream>() { // from class: io.jsonwebtoken.impl.compression.AbstractCompressionAlgorithm.1
        @Override // io.jsonwebtoken.impl.lang.CheckedFunction
        public OutputStream apply(OutputStream outputStream) {
            return AbstractCompressionAlgorithm.this.doCompress(outputStream);
        }
    });
    private final Function<byte[], byte[]> COMPRESS_FN = forCompression(new CheckedFunction<byte[], byte[]>() { // from class: io.jsonwebtoken.impl.compression.AbstractCompressionAlgorithm.2
        @Override // io.jsonwebtoken.impl.lang.CheckedFunction
        public byte[] apply(byte[] bArr) {
            return AbstractCompressionAlgorithm.this.doCompress(bArr);
        }
    });
    private final Function<InputStream, InputStream> IS_WRAP_FN = forDecompression(new CheckedFunction<InputStream, InputStream>() { // from class: io.jsonwebtoken.impl.compression.AbstractCompressionAlgorithm.3
        @Override // io.jsonwebtoken.impl.lang.CheckedFunction
        public InputStream apply(InputStream inputStream) {
            return AbstractCompressionAlgorithm.this.doDecompress(inputStream);
        }
    });
    private final Function<byte[], byte[]> DECOMPRESS_FN = forDecompression(new CheckedFunction<byte[], byte[]>() { // from class: io.jsonwebtoken.impl.compression.AbstractCompressionAlgorithm.4
        @Override // io.jsonwebtoken.impl.lang.CheckedFunction
        public byte[] apply(byte[] bArr) {
            return AbstractCompressionAlgorithm.this.doDecompress(bArr);
        }
    });

    public AbstractCompressionAlgorithm(String str) {
        this.id = (String) Assert.hasText(Strings.clean(str), "id argument cannot be null or empty.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] doCompress(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        OutputStream compress = compress(byteArrayOutputStream);
        try {
            compress.write(bArr);
            compress.flush();
            Objects.nullSafeClose(compress);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            Objects.nullSafeClose(compress);
            throw th;
        }
    }

    private static <T, R> Function<T, R> forCompression(CheckedFunction<T, R> checkedFunction) {
        return propagate(checkedFunction, "Compression failed.");
    }

    private static <T, R> Function<T, R> forDecompression(CheckedFunction<T, R> checkedFunction) {
        return propagate(checkedFunction, "Decompression failed.");
    }

    private static <T, R> Function<T, R> propagate(CheckedFunction<T, R> checkedFunction, String str) {
        return new PropagatingExceptionFunction(checkedFunction, CompressionException.class, str);
    }

    @Override // io.jsonwebtoken.io.CompressionAlgorithm
    public final OutputStream compress(OutputStream outputStream) {
        return this.OS_WRAP_FN.apply(outputStream);
    }

    @Override // io.jsonwebtoken.io.CompressionAlgorithm
    public final InputStream decompress(InputStream inputStream) {
        return this.IS_WRAP_FN.apply(inputStream);
    }

    public abstract OutputStream doCompress(OutputStream outputStream);

    public abstract InputStream doDecompress(InputStream inputStream);

    public byte[] doDecompress(byte[] bArr) {
        InputStream decompress = decompress(Streams.of(bArr));
        byte[] bArr2 = new byte[512];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        int i10 = 0;
        while (i10 != -1) {
            try {
                i10 = decompress.read(bArr2);
                if (i10 > 0) {
                    byteArrayOutputStream.write(bArr2, 0, i10);
                }
            } catch (Throwable th) {
                Objects.nullSafeClose(decompress);
                throw th;
            }
        }
        Objects.nullSafeClose(decompress);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // io.jsonwebtoken.CompressionCodec
    public String getAlgorithmName() {
        return getId();
    }

    @Override // io.jsonwebtoken.Identifiable
    public String getId() {
        return this.id;
    }

    @Override // io.jsonwebtoken.CompressionCodec
    public final byte[] compress(byte[] bArr) {
        return Bytes.isEmpty(bArr) ? Bytes.EMPTY : this.COMPRESS_FN.apply(bArr);
    }

    @Override // io.jsonwebtoken.CompressionCodec
    public final byte[] decompress(byte[] bArr) {
        return Bytes.isEmpty(bArr) ? Bytes.EMPTY : this.DECOMPRESS_FN.apply(bArr);
    }
}
