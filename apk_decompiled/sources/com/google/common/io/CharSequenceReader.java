package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes2.dex */
final class CharSequenceReader extends Reader {
    private int mark;
    private int pos;

    @CheckForNull
    private CharSequence seq;

    public CharSequenceReader(CharSequence charSequence) {
        this.seq = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    private void checkOpen() {
        if (this.seq == null) {
            throw new IOException("reader closed");
        }
    }

    private boolean hasRemaining() {
        return remaining() > 0;
    }

    private int remaining() {
        Objects.requireNonNull(this.seq);
        return this.seq.length() - this.pos;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.seq = null;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i10) {
        Preconditions.checkArgument(i10 >= 0, "readAheadLimit (%s) may not be negative", i10);
        checkOpen();
        this.mark = this.pos;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer charBuffer) {
        Preconditions.checkNotNull(charBuffer);
        checkOpen();
        Objects.requireNonNull(this.seq);
        if (!hasRemaining()) {
            return -1;
        }
        int min = Math.min(charBuffer.remaining(), remaining());
        for (int i10 = 0; i10 < min; i10++) {
            CharSequence charSequence = this.seq;
            int i11 = this.pos;
            this.pos = i11 + 1;
            charBuffer.put(charSequence.charAt(i11));
        }
        return min;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() {
        checkOpen();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() {
        checkOpen();
        this.pos = this.mark;
    }

    @Override // java.io.Reader
    public synchronized long skip(long j10) {
        int min;
        Preconditions.checkArgument(j10 >= 0, "n (%s) may not be negative", j10);
        checkOpen();
        min = (int) Math.min(remaining(), j10);
        this.pos += min;
        return min;
    }

    @Override // java.io.Reader
    public synchronized int read() {
        char c10;
        checkOpen();
        Objects.requireNonNull(this.seq);
        if (hasRemaining()) {
            CharSequence charSequence = this.seq;
            int i10 = this.pos;
            this.pos = i10 + 1;
            c10 = charSequence.charAt(i10);
        } else {
            c10 = 65535;
        }
        return c10;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cArr, int i10, int i11) {
        Preconditions.checkPositionIndexes(i10, i10 + i11, cArr.length);
        checkOpen();
        Objects.requireNonNull(this.seq);
        if (!hasRemaining()) {
            return -1;
        }
        int min = Math.min(i11, remaining());
        for (int i12 = 0; i12 < min; i12++) {
            CharSequence charSequence = this.seq;
            int i13 = this.pos;
            this.pos = i13 + 1;
            cArr[i10 + i12] = charSequence.charAt(i13);
        }
        return min;
    }
}
