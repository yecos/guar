package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class ByteMatrix {
    private final byte[][] bytes;
    private final int height;
    private final int width;

    public ByteMatrix(int i10, int i11) {
        this.bytes = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i11, i10);
        this.width = i10;
        this.height = i11;
    }

    public void clear(byte b10) {
        for (int i10 = 0; i10 < this.height; i10++) {
            for (int i11 = 0; i11 < this.width; i11++) {
                this.bytes[i10][i11] = b10;
            }
        }
    }

    public byte get(int i10, int i11) {
        return this.bytes[i11][i10];
    }

    public byte[][] getArray() {
        return this.bytes;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void set(int i10, int i11, byte b10) {
        this.bytes[i11][i10] = b10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
        for (int i10 = 0; i10 < this.height; i10++) {
            for (int i11 = 0; i11 < this.width; i11++) {
                byte b10 = this.bytes[i10][i11];
                if (b10 == 0) {
                    sb.append(" 0");
                } else if (b10 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void set(int i10, int i11, int i12) {
        this.bytes[i11][i10] = (byte) i12;
    }

    public void set(int i10, int i11, boolean z10) {
        this.bytes[i11][i10] = z10 ? (byte) 1 : (byte) 0;
    }
}
