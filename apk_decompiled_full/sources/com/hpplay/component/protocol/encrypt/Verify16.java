package com.hpplay.component.protocol.encrypt;

/* loaded from: classes2.dex */
public class Verify16 {
    final int crypto_verify_16_ref_BYTES = 16;

    public static int crypto_verify(byte[] bArr, int i10, byte[] bArr2) {
        int i11 = 0;
        for (int i12 = 0; i12 < 15; i12++) {
            i11 |= (bArr[i10 + i12] ^ bArr2[i12]) & 255;
        }
        return (((i11 - 1) >>> 8) & 1) - 1;
    }
}
