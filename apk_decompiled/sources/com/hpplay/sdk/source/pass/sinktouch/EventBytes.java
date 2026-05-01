package com.hpplay.sdk.source.pass.sinktouch;

import java.util.Arrays;

/* loaded from: classes3.dex */
class EventBytes {
    private static final int MAX_LEN = 128;
    private byte[] mBuffer = new byte[128];
    private int mCurrentLen = 0;

    public int append(byte[] bArr, int i10, int i11) {
        int i12;
        int i13 = 0;
        while (true) {
            i12 = this.mCurrentLen;
            if (i12 >= 4 || i13 >= i11) {
                break;
            }
            this.mBuffer[i12] = bArr[i10 + i13];
            this.mCurrentLen = i12 + 1;
            i13++;
        }
        if (i12 < 4) {
            return 0;
        }
        byte[] bArr2 = this.mBuffer;
        int i14 = bArr2[3] - (i12 - 4);
        int i15 = i10 + i13;
        int i16 = i11 - i13;
        if (i16 < 0) {
            return 0;
        }
        if (i14 >= i16) {
            System.arraycopy(bArr, i15, bArr2, i12, i16);
            this.mCurrentLen += i16;
            return 0;
        }
        System.arraycopy(bArr, i15, bArr2, i12, i14);
        this.mCurrentLen += i14;
        return i16 - i14;
    }

    public byte[] getData() {
        return Arrays.copyOf(this.mBuffer, this.mCurrentLen);
    }

    public boolean isFillUp() {
        int i10 = this.mCurrentLen;
        return i10 >= 4 && this.mBuffer[3] == i10 - 4;
    }

    public void reset() {
        Arrays.fill(this.mBuffer, (byte) 0);
        this.mCurrentLen = 0;
    }
}
