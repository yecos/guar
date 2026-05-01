package com.hpplay.sdk.source.mdns.xbill.dns;

/* loaded from: classes3.dex */
public class DNSOutput {
    private byte[] array;
    private int pos;
    private int saved_pos;

    public DNSOutput(int i10) {
        this.array = new byte[i10];
        this.pos = 0;
        this.saved_pos = -1;
    }

    private void check(long j10, int i10) {
        long j11 = 1 << i10;
        if (j10 < 0 || j10 > j11) {
            throw new IllegalArgumentException(j10 + " out of range for " + i10 + " bit value");
        }
    }

    private void need(int i10) {
        byte[] bArr = this.array;
        int length = bArr.length;
        int i11 = this.pos;
        if (length - i11 >= i10) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i11 + i10) {
            length2 = i11 + i10;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i11);
        this.array = bArr2;
    }

    public int current() {
        return this.pos;
    }

    public void jump(int i10) {
        if (i10 > this.pos) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.pos = i10;
    }

    public void restore() {
        int i10 = this.saved_pos;
        if (i10 < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.pos = i10;
        this.saved_pos = -1;
    }

    public void save() {
        this.saved_pos = this.pos;
    }

    public byte[] toByteArray() {
        int i10 = this.pos;
        byte[] bArr = new byte[i10];
        System.arraycopy(this.array, 0, bArr, 0, i10);
        return bArr;
    }

    public void writeByteArray(byte[] bArr, int i10, int i11) {
        need(i11);
        System.arraycopy(bArr, i10, this.array, this.pos, i11);
        this.pos += i11;
    }

    public void writeCountedString(byte[] bArr) {
        if (bArr.length > 255) {
            throw new IllegalArgumentException("Invalid counted string");
        }
        need(bArr.length + 1);
        byte[] bArr2 = this.array;
        int i10 = this.pos;
        this.pos = i10 + 1;
        bArr2[i10] = (byte) (255 & bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeU16(int i10) {
        check(i10, 16);
        need(2);
        byte[] bArr = this.array;
        int i11 = this.pos;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        this.pos = i12 + 1;
        bArr[i12] = (byte) (i10 & 255);
    }

    public void writeU16At(int i10, int i11) {
        check(i10, 16);
        if (i11 > this.pos - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.array;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 1] = (byte) (i10 & 255);
    }

    public void writeU32(long j10) {
        check(j10, 32);
        need(4);
        byte[] bArr = this.array;
        int i10 = this.pos;
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((j10 >>> 24) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((j10 >>> 16) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((j10 >>> 8) & 255);
        this.pos = i13 + 1;
        bArr[i13] = (byte) (j10 & 255);
    }

    public void writeU8(int i10) {
        check(i10, 8);
        need(1);
        byte[] bArr = this.array;
        int i11 = this.pos;
        this.pos = i11 + 1;
        bArr[i11] = (byte) (i10 & 255);
    }

    public void writeByteArray(byte[] bArr) {
        writeByteArray(bArr, 0, bArr.length);
    }

    public DNSOutput() {
        this(32);
    }
}
