package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Bytes;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public abstract class FilteredInputStream extends FilterInputStream {
    public FilteredInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public void afterRead(int i10) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        try {
            return super.available();
        } catch (Throwable th) {
            onThrowable(th);
            return 0;
        }
    }

    public void beforeRead(int i10) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (Throwable th) {
            onThrowable(th);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        ((FilterInputStream) this).in.mark(i10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((FilterInputStream) this).in.markSupported();
    }

    public void onThrowable(Throwable th) {
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        throw new IOException("IO Exception: " + th.getMessage(), th);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i10 = 1;
        try {
            beforeRead(1);
            int read = ((FilterInputStream) this).in.read();
            if (read == -1) {
                i10 = -1;
            }
            afterRead(i10);
            return read;
        } catch (Throwable th) {
            onThrowable(th);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        try {
            ((FilterInputStream) this).in.reset();
        } catch (Throwable th) {
            onThrowable(th);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) {
        try {
            return ((FilterInputStream) this).in.skip(j10);
        } catch (Throwable th) {
            onThrowable(th);
            return 0L;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        try {
            beforeRead(Bytes.length(bArr));
            int read = ((FilterInputStream) this).in.read(bArr);
            afterRead(read);
            return read;
        } catch (Throwable th) {
            onThrowable(th);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        try {
            beforeRead(i11);
            int read = ((FilterInputStream) this).in.read(bArr, i10, i11);
            afterRead(read);
            return read;
        } catch (Throwable th) {
            onThrowable(th);
            return -1;
        }
    }
}
