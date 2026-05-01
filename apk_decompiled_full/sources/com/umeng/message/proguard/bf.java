package com.umeng.message.proguard;

import com.google.common.base.Ascii;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;

/* loaded from: classes3.dex */
public final class bf extends bg {

    /* renamed from: g, reason: collision with root package name */
    private static final byte[] f11631g = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f11632h = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, 63, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* renamed from: l, reason: collision with root package name */
    private int f11636l;

    /* renamed from: k, reason: collision with root package name */
    private final int f11635k = 4;

    /* renamed from: j, reason: collision with root package name */
    private final int f11634j = 4 - 1;

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f11633i = f11631g;

    private static byte[] f(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        bf bfVar = new bf();
        long c10 = super.c(bArr);
        if (c10 <= TTL.MAX_VALUE) {
            return super.d(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + c10 + ") than the specified maximum size of 2147483647");
    }

    @Override // com.umeng.message.proguard.bg
    public final void a(byte[] bArr, int i10, int i11) {
        if (this.f11640d) {
            return;
        }
        if (i11 >= 0) {
            int i12 = 0;
            while (i12 < i11) {
                a(this.f11635k);
                int i13 = (this.f11642f + 1) % 3;
                this.f11642f = i13;
                int i14 = i10 + 1;
                int i15 = bArr[i10];
                if (i15 < 0) {
                    i15 += 256;
                }
                int i16 = (this.f11636l << 8) + i15;
                this.f11636l = i16;
                if (i13 == 0) {
                    byte[] bArr2 = this.f11638b;
                    int i17 = this.f11639c;
                    int i18 = i17 + 1;
                    byte[] bArr3 = this.f11633i;
                    bArr2[i17] = bArr3[(i16 >> 18) & 63];
                    int i19 = i18 + 1;
                    bArr2[i18] = bArr3[(i16 >> 12) & 63];
                    int i20 = i19 + 1;
                    bArr2[i19] = bArr3[(i16 >> 6) & 63];
                    this.f11639c = i20 + 1;
                    bArr2[i20] = bArr3[i16 & 63];
                    this.f11641e += 4;
                }
                i12++;
                i10 = i14;
            }
            return;
        }
        this.f11640d = true;
        if (this.f11642f == 0) {
            return;
        }
        a(this.f11635k);
        int i21 = this.f11639c;
        int i22 = this.f11642f;
        if (i22 == 1) {
            byte[] bArr4 = this.f11638b;
            int i23 = i21 + 1;
            byte[] bArr5 = this.f11633i;
            int i24 = this.f11636l;
            bArr4[i21] = bArr5[(i24 >> 2) & 63];
            int i25 = i23 + 1;
            this.f11639c = i25;
            bArr4[i23] = bArr5[(i24 << 4) & 63];
            if (bArr5 == f11631g) {
                int i26 = i25 + 1;
                bArr4[i25] = 61;
                this.f11639c = i26 + 1;
                bArr4[i26] = 61;
            }
        } else if (i22 == 2) {
            byte[] bArr6 = this.f11638b;
            int i27 = i21 + 1;
            byte[] bArr7 = this.f11633i;
            int i28 = this.f11636l;
            bArr6[i21] = bArr7[(i28 >> 10) & 63];
            int i29 = i27 + 1;
            bArr6[i27] = bArr7[(i28 >> 4) & 63];
            int i30 = i29 + 1;
            this.f11639c = i30;
            bArr6[i29] = bArr7[(i28 << 2) & 63];
            if (bArr7 == f11631g) {
                this.f11639c = i30 + 1;
                bArr6[i30] = 61;
            }
        }
        this.f11641e += this.f11639c - i21;
    }

    @Override // com.umeng.message.proguard.bg
    public final /* bridge */ /* synthetic */ byte[] b(String str) {
        return super.b(str);
    }

    @Override // com.umeng.message.proguard.bg
    public final /* bridge */ /* synthetic */ long c(byte[] bArr) {
        return super.c(bArr);
    }

    @Override // com.umeng.message.proguard.bg
    public final /* bridge */ /* synthetic */ byte[] d(byte[] bArr) {
        return super.d(bArr);
    }

    @Override // com.umeng.message.proguard.bg
    public final /* bridge */ /* synthetic */ byte[] e(byte[] bArr) {
        return super.e(bArr);
    }

    @Override // com.umeng.message.proguard.bg
    public final void b(byte[] bArr, int i10, int i11) {
        byte b10;
        if (this.f11640d) {
            return;
        }
        if (i11 < 0) {
            this.f11640d = true;
        }
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            a(this.f11634j);
            int i13 = i10 + 1;
            byte b11 = bArr[i10];
            if (b11 == 61) {
                this.f11640d = true;
                break;
            }
            if (b11 >= 0) {
                byte[] bArr2 = f11632h;
                if (b11 < bArr2.length && (b10 = bArr2[b11]) >= 0) {
                    int i14 = (this.f11642f + 1) % 4;
                    this.f11642f = i14;
                    int i15 = (this.f11636l << 6) + b10;
                    this.f11636l = i15;
                    if (i14 == 0) {
                        byte[] bArr3 = this.f11638b;
                        int i16 = this.f11639c;
                        int i17 = i16 + 1;
                        bArr3[i16] = (byte) ((i15 >> 16) & 255);
                        int i18 = i17 + 1;
                        bArr3[i17] = (byte) ((i15 >> 8) & 255);
                        this.f11639c = i18 + 1;
                        bArr3[i18] = (byte) (i15 & 255);
                    }
                }
            }
            i12++;
            i10 = i13;
        }
        if (!this.f11640d || this.f11642f == 0) {
            return;
        }
        a(this.f11634j);
        int i19 = this.f11642f;
        if (i19 == 2) {
            int i20 = this.f11636l >> 4;
            this.f11636l = i20;
            byte[] bArr4 = this.f11638b;
            int i21 = this.f11639c;
            this.f11639c = i21 + 1;
            bArr4[i21] = (byte) (i20 & 255);
            return;
        }
        if (i19 != 3) {
            return;
        }
        int i22 = this.f11636l >> 2;
        this.f11636l = i22;
        byte[] bArr5 = this.f11638b;
        int i23 = this.f11639c;
        int i24 = i23 + 1;
        bArr5[i23] = (byte) ((i22 >> 8) & 255);
        this.f11639c = i24 + 1;
        bArr5[i24] = (byte) (i22 & 255);
    }

    public static byte[] b(byte[] bArr) {
        return f(bArr);
    }

    public static String a(byte[] bArr) {
        return new String(f(bArr));
    }

    public static byte[] a(String str) {
        return super.b(str);
    }
}
