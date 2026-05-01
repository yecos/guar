package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Bytes;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class FilteredOutputStream extends FilterOutputStream {
    public FilteredOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void afterWrite(int i10) {
    }

    public void beforeWrite(int i10) {
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (Throwable th) {
            onThrowable(th);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        try {
            ((FilterOutputStream) this).out.flush();
        } catch (Throwable th) {
            onThrowable(th);
        }
    }

    public void onThrowable(Throwable th) {
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        throw new IOException("IO Exception " + th.getMessage(), th);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) {
        try {
            int length = Bytes.length(bArr);
            beforeWrite(length);
            ((FilterOutputStream) this).out.write(bArr);
            afterWrite(length);
        } catch (Throwable th) {
            onThrowable(th);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        try {
            beforeWrite(i11);
            ((FilterOutputStream) this).out.write(bArr, i10, i11);
            afterWrite(i11);
        } catch (Throwable th) {
            onThrowable(th);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) {
        try {
            beforeWrite(1);
            ((FilterOutputStream) this).out.write(i10);
            afterWrite(1);
        } catch (Throwable th) {
            onThrowable(th);
        }
    }
}
