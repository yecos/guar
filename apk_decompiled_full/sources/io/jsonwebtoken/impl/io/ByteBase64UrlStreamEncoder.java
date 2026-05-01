package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class ByteBase64UrlStreamEncoder implements Encoder<OutputStream, OutputStream> {
    private final Encoder<byte[], String> delegate;

    public static class TranslatingOutputStream extends FilteredOutputStream {
        private final Encoder<byte[], String> delegate;
        private final OutputStream dst;

        public TranslatingOutputStream(OutputStream outputStream, Encoder<byte[], String> encoder) {
            super(new ByteArrayOutputStream());
            this.dst = outputStream;
            this.delegate = encoder;
        }

        @Override // io.jsonwebtoken.impl.io.FilteredOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.dst.write(Strings.utf8(this.delegate.encode(((ByteArrayOutputStream) ((FilterOutputStream) this).out).toByteArray())));
            this.dst.flush();
            this.dst.close();
        }
    }

    public ByteBase64UrlStreamEncoder(Encoder<byte[], String> encoder) {
        this.delegate = (Encoder) Assert.notNull(encoder, "delegate cannot be null.");
    }

    @Override // io.jsonwebtoken.io.Encoder
    public OutputStream encode(OutputStream outputStream) {
        Assert.notNull(outputStream, "outputStream cannot be null.");
        return new TranslatingOutputStream(outputStream, this.delegate);
    }
}
