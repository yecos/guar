package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.lang.Assert;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class TeeOutputStream extends FilteredOutputStream {
    private final OutputStream other;

    public TeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        super(outputStream);
        this.other = (OutputStream) Assert.notNull(outputStream2, "Second OutputStream cannot be null.");
    }

    @Override // io.jsonwebtoken.impl.io.FilteredOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } finally {
            this.other.close();
        }
    }

    @Override // io.jsonwebtoken.impl.io.FilteredOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        super.flush();
        this.other.flush();
    }

    @Override // io.jsonwebtoken.impl.io.FilteredOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) {
        super.write(bArr);
        this.other.write(bArr);
    }

    @Override // io.jsonwebtoken.impl.io.FilteredOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        super.write(bArr, i10, i11);
        this.other.write(bArr, i10, i11);
    }

    @Override // io.jsonwebtoken.impl.io.FilteredOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) {
        super.write(i10);
        this.other.write(i10);
    }
}
