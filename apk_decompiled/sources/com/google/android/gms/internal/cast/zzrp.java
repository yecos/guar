package com.google.android.gms.internal.cast;

import com.google.common.base.Ascii;

/* loaded from: classes.dex */
final class zzrp extends zzro {
    @Override // com.google.android.gms.internal.cast.zzro
    public final int zza(int i10, byte[] bArr, int i11, int i12) {
        int i13 = 0;
        while (i13 < i12 && bArr[i13] >= 0) {
            i13++;
        }
        if (i13 >= i12) {
            return 0;
        }
        while (i13 < i12) {
            int i14 = i13 + 1;
            byte b10 = bArr[i13];
            if (b10 < 0) {
                if (b10 < -32) {
                    if (i14 >= i12) {
                        return b10;
                    }
                    if (b10 >= -62) {
                        i13 = i14 + 1;
                        if (bArr[i14] > -65) {
                        }
                    }
                    return -1;
                }
                if (b10 < -16) {
                    if (i14 >= i12 - 1) {
                        return zzrr.zza(bArr, i14, i12);
                    }
                    int i15 = i14 + 1;
                    byte b11 = bArr[i14];
                    if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                        i13 = i15 + 1;
                        if (bArr[i15] > -65) {
                        }
                    }
                } else {
                    if (i14 >= i12 - 2) {
                        return zzrr.zza(bArr, i14, i12);
                    }
                    int i16 = i14 + 1;
                    byte b12 = bArr[i14];
                    if (b12 <= -65 && (((b10 << Ascii.FS) + (b12 + 112)) >> 30) == 0) {
                        int i17 = i16 + 1;
                        if (bArr[i16] <= -65) {
                            i14 = i17 + 1;
                            if (bArr[i17] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            i13 = i14;
        }
        return 0;
    }
}
