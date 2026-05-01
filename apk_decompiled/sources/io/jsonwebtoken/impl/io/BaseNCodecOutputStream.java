package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.io.BaseNCodec;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Objects;

/* loaded from: classes3.dex */
class BaseNCodecOutputStream extends FilterOutputStream {
    private final BaseNCodec baseNCodec;
    private final BaseNCodec.Context context;
    private final boolean doEncode;
    private final byte[] singleByte;

    public BaseNCodecOutputStream(OutputStream outputStream, BaseNCodec baseNCodec, boolean z10) {
        super(outputStream);
        this.singleByte = new byte[1];
        this.context = new BaseNCodec.Context();
        this.baseNCodec = baseNCodec;
        this.doEncode = z10;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        eof();
        flush();
        ((FilterOutputStream) this).out.close();
    }

    public void eof() {
        if (this.doEncode) {
            this.baseNCodec.encode(this.singleByte, 0, -1, this.context);
        } else {
            this.baseNCodec.decode(this.singleByte, 0, -1, this.context);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        flush(true);
    }

    public boolean isStrictDecoding() {
        return this.baseNCodec.isStrictDecoding();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        Objects.requireNonNull(bArr, "array");
        if (i10 < 0 || i11 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i10 > bArr.length || i10 + i11 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 > 0) {
            if (this.doEncode) {
                this.baseNCodec.encode(bArr, i10, i11, this.context);
            } else {
                this.baseNCodec.decode(bArr, i10, i11, this.context);
            }
            flush(false);
        }
    }

    private void flush(boolean z10) {
        byte[] bArr;
        int readResults;
        int available = this.baseNCodec.available(this.context);
        if (available > 0 && (readResults = this.baseNCodec.readResults((bArr = new byte[available]), 0, available, this.context)) > 0) {
            ((FilterOutputStream) this).out.write(bArr, 0, readResults);
        }
        if (z10) {
            ((FilterOutputStream) this).out.flush();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) {
        byte[] bArr = this.singleByte;
        bArr[0] = (byte) i10;
        write(bArr, 0, 1);
    }
}
