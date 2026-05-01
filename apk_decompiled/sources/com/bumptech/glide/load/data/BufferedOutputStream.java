package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class BufferedOutputStream extends OutputStream {
    private ArrayPool arrayPool;
    private byte[] buffer;
    private int index;
    private final OutputStream out;

    public BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    private void flushBuffer() {
        int i10 = this.index;
        if (i10 > 0) {
            this.out.write(this.buffer, 0, i10);
            this.index = 0;
        }
    }

    private void maybeFlushBuffer() {
        if (this.index == this.buffer.length) {
            flushBuffer();
        }
    }

    private void release() {
        byte[] bArr = this.buffer;
        if (bArr != null) {
            this.arrayPool.put(bArr);
            this.buffer = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.out.close();
            release();
        } catch (Throwable th) {
            this.out.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        flushBuffer();
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i10) {
        byte[] bArr = this.buffer;
        int i11 = this.index;
        this.index = i11 + 1;
        bArr[i11] = (byte) i10;
        maybeFlushBuffer();
    }

    public BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool, int i10) {
        this.out = outputStream;
        this.arrayPool = arrayPool;
        this.buffer = (byte[]) arrayPool.get(i10, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.index;
            if (i15 == 0 && i13 >= this.buffer.length) {
                this.out.write(bArr, i14, i13);
                return;
            }
            int min = Math.min(i13, this.buffer.length - i15);
            System.arraycopy(bArr, i14, this.buffer, this.index, min);
            this.index += min;
            i12 += min;
            maybeFlushBuffer();
        } while (i12 < i11);
    }
}
