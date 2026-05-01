package io.jsonwebtoken.impl.io;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class CountingInputStream extends FilterInputStream {
    private final AtomicLong count;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
        this.count = new AtomicLong(0L);
    }

    private void add(long j10) {
        if (j10 > 0) {
            this.count.addAndGet(j10);
        }
    }

    public long getCount() {
        return this.count.get();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = super.read();
        add(read == -1 ? -1L : 1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) {
        long skip = super.skip(j10);
        add(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        int read = super.read(bArr);
        add(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        int read = super.read(bArr, i10, i11);
        add(read);
        return read;
    }
}
