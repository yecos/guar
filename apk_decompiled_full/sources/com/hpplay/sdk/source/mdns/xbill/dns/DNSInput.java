package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes3.dex */
public class DNSInput {
    private byte[] array;
    private int end;
    private int pos = 0;
    private int saved_pos = -1;
    private int saved_end = -1;

    public DNSInput(byte[] bArr) {
        this.array = bArr;
        this.end = bArr.length;
    }

    private void require(int i10) {
        if (i10 > remaining()) {
            throw new Exception("end of input");
        }
    }

    public void clearActive() {
        this.end = this.array.length;
    }

    public int current() {
        return this.pos;
    }

    public void jump(int i10) {
        byte[] bArr = this.array;
        if (i10 >= bArr.length) {
            throw new IllegalArgumentException("cannot jump past end of input");
        }
        this.pos = i10;
        this.end = bArr.length;
    }

    public void readByteArray(byte[] bArr, int i10, int i11) {
        require(i11);
        System.arraycopy(this.array, this.pos, bArr, i10, i11);
        this.pos += i11;
    }

    public byte[] readCountedString() {
        require(1);
        byte[] bArr = this.array;
        int i10 = this.pos;
        this.pos = i10 + 1;
        return readByteArray(bArr[i10] & UnsignedBytes.MAX_VALUE);
    }

    public int readU16() {
        require(2);
        byte[] bArr = this.array;
        int i10 = this.pos;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & UnsignedBytes.MAX_VALUE;
        this.pos = i11 + 1;
        return (i12 << 8) + (bArr[i11] & UnsignedBytes.MAX_VALUE);
    }

    public long readU32() {
        require(4);
        byte[] bArr = this.array;
        int i10 = this.pos;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & UnsignedBytes.MAX_VALUE;
        int i13 = i11 + 1;
        int i14 = bArr[i11] & UnsignedBytes.MAX_VALUE;
        int i15 = i13 + 1;
        int i16 = bArr[i13] & UnsignedBytes.MAX_VALUE;
        this.pos = i15 + 1;
        return (i12 << 24) + (i14 << 16) + (i16 << 8) + (bArr[i15] & UnsignedBytes.MAX_VALUE);
    }

    public int readU8() {
        require(1);
        byte[] bArr = this.array;
        int i10 = this.pos;
        this.pos = i10 + 1;
        return bArr[i10] & UnsignedBytes.MAX_VALUE;
    }

    public int remaining() {
        return this.end - this.pos;
    }

    public void restore() {
        int i10 = this.saved_pos;
        if (i10 < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.pos = i10;
        this.end = this.saved_end;
        this.saved_pos = -1;
        this.saved_end = -1;
    }

    public void restoreActive(int i10) {
        if (i10 > this.array.length) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        this.end = i10;
    }

    public void save() {
        this.saved_pos = this.pos;
        this.saved_end = this.end;
    }

    public int saveActive() {
        return this.end;
    }

    public void setActive(int i10) {
        int length = this.array.length;
        int i11 = this.pos;
        if (i10 > length - i11) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        this.end = i11 + i10;
    }

    public byte[] readByteArray(int i10) {
        require(i10);
        byte[] bArr = new byte[i10];
        System.arraycopy(this.array, this.pos, bArr, 0, i10);
        this.pos += i10;
        return bArr;
    }

    public byte[] readByteArray() {
        int remaining = remaining();
        byte[] bArr = new byte[remaining];
        System.arraycopy(this.array, this.pos, bArr, 0, remaining);
        this.pos += remaining;
        return bArr;
    }
}
