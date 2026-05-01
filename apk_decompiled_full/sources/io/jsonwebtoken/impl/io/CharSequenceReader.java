package io.jsonwebtoken.impl.io;

import java.io.Reader;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes3.dex */
public class CharSequenceReader extends Reader implements Serializable {
    private static final long serialVersionUID = 3724187752191401220L;
    private final CharSequence charSequence;
    private final Integer end;
    private int idx;
    private int mark;
    private final int start;

    public CharSequenceReader(CharSequence charSequence) {
        this(charSequence, 0);
    }

    private int end() {
        int length = this.charSequence.length();
        Integer num = this.end;
        return Math.min(length, num == null ? Integer.MAX_VALUE : num.intValue());
    }

    private int start() {
        return Math.min(this.charSequence.length(), this.start);
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i10 = this.start;
        this.idx = i10;
        this.mark = i10;
    }

    @Override // java.io.Reader
    public void mark(int i10) {
        this.mark = this.idx;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public int read() {
        if (this.idx >= end()) {
            return -1;
        }
        CharSequence charSequence = this.charSequence;
        int i10 = this.idx;
        this.idx = i10 + 1;
        return charSequence.charAt(i10);
    }

    @Override // java.io.Reader
    public boolean ready() {
        return this.idx < end();
    }

    @Override // java.io.Reader
    public void reset() {
        this.idx = this.mark;
    }

    @Override // java.io.Reader
    public long skip(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("Number of characters to skip is less than zero: " + j10);
        }
        if (this.idx >= end()) {
            return 0L;
        }
        int min = (int) Math.min(end(), this.idx + j10);
        int i10 = min - this.idx;
        this.idx = min;
        return i10;
    }

    public String toString() {
        return this.charSequence.subSequence(start(), end()).toString();
    }

    public CharSequenceReader(CharSequence charSequence, int i10) {
        this(charSequence, i10, Integer.MAX_VALUE);
    }

    public CharSequenceReader(String str, int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Start index is less than zero: " + i10);
        }
        if (i11 >= i10) {
            this.charSequence = str == null ? "" : str;
            this.start = i10;
            this.end = Integer.valueOf(i11);
            this.idx = i10;
            this.mark = i10;
            return;
        }
        throw new IllegalArgumentException("End index is less than start " + i10 + ": " + i11);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i10, int i11) {
        if (this.idx >= end()) {
            return -1;
        }
        Objects.requireNonNull(cArr, "array");
        if (i11 >= 0 && i10 >= 0 && i10 + i11 <= cArr.length) {
            CharSequence charSequence = this.charSequence;
            if (charSequence instanceof String) {
                int min = Math.min(i11, end() - this.idx);
                String str = (String) this.charSequence;
                int i12 = this.idx;
                str.getChars(i12, i12 + min, cArr, i10);
                this.idx += min;
                return min;
            }
            if (charSequence instanceof StringBuilder) {
                int min2 = Math.min(i11, end() - this.idx);
                StringBuilder sb = (StringBuilder) this.charSequence;
                int i13 = this.idx;
                sb.getChars(i13, i13 + min2, cArr, i10);
                this.idx += min2;
                return min2;
            }
            if (charSequence instanceof StringBuffer) {
                int min3 = Math.min(i11, end() - this.idx);
                StringBuffer stringBuffer = (StringBuffer) this.charSequence;
                int i14 = this.idx;
                stringBuffer.getChars(i14, i14 + min3, cArr, i10);
                this.idx += min3;
                return min3;
            }
            int i15 = 0;
            for (int i16 = 0; i16 < i11; i16++) {
                int read = read();
                if (read == -1) {
                    return i15;
                }
                cArr[i10 + i16] = (char) read;
                i15++;
            }
            return i15;
        }
        throw new IndexOutOfBoundsException("Array Size=" + cArr.length + ", offset=" + i10 + ", length=" + i11);
    }
}
