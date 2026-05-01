package com.hpplay.glide.util;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class MarkEnforcingInputStream extends FilterInputStream {
    private static final int END_OF_STREAM = -1;
    private static final int UNSET = Integer.MIN_VALUE;
    private int availableBytes;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
        this.availableBytes = Integer.MIN_VALUE;
    }

    private long getBytesToRead(long j10) {
        int i10 = this.availableBytes;
        if (i10 == 0) {
            return -1L;
        }
        return (i10 == Integer.MIN_VALUE || j10 <= ((long) i10)) ? j10 : i10;
    }

    private void updateAvailableBytesAfterRead(long j10) {
        int i10 = this.availableBytes;
        if (i10 == Integer.MIN_VALUE || j10 == -1) {
            return;
        }
        this.availableBytes = (int) (i10 - j10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i10 = this.availableBytes;
        return i10 == Integer.MIN_VALUE ? super.available() : Math.min(i10, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
        super.mark(i10);
        this.availableBytes = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (getBytesToRead(1L) == -1) {
            return -1;
        }
        int read = super.read();
        updateAvailableBytesAfterRead(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        super.reset();
        this.availableBytes = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) {
        long bytesToRead = getBytesToRead(j10);
        if (bytesToRead == -1) {
            return -1L;
        }
        long skip = super.skip(bytesToRead);
        updateAvailableBytesAfterRead(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        int bytesToRead = (int) getBytesToRead(i11);
        if (bytesToRead == -1) {
            return -1;
        }
        int read = super.read(bArr, i10, bytesToRead);
        updateAvailableBytesAfterRead(read);
        return read;
    }
}
