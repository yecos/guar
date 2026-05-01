package com.hpplay.glide.gifencoder;

import com.google.common.primitives.UnsignedBytes;
import com.uc.crashsdk.export.LogType;

/* loaded from: classes2.dex */
class NeuQuant {
    protected static final int alphabiasshift = 10;
    protected static final int alpharadbias = 262144;
    protected static final int alpharadbshift = 18;
    protected static final int beta = 64;
    protected static final int betagamma = 65536;
    protected static final int betashift = 10;
    protected static final int gamma = 1024;
    protected static final int gammashift = 10;
    protected static final int initalpha = 1024;
    protected static final int initrad = 32;
    protected static final int initradius = 2048;
    protected static final int intbias = 65536;
    protected static final int intbiasshift = 16;
    protected static final int maxnetpos = 255;
    protected static final int minpicturebytes = 1509;
    protected static final int ncycles = 100;
    protected static final int netbiasshift = 4;
    protected static final int netsize = 256;
    protected static final int prime1 = 499;
    protected static final int prime2 = 491;
    protected static final int prime3 = 487;
    protected static final int prime4 = 503;
    protected static final int radbias = 256;
    protected static final int radbiasshift = 8;
    protected static final int radiusbias = 64;
    protected static final int radiusbiasshift = 6;
    protected static final int radiusdec = 30;
    protected int alphadec;
    protected int lengthcount;
    protected int samplefac;
    protected byte[] thepicture;
    protected int[] netindex = new int[256];
    protected int[] bias = new int[256];
    protected int[] freq = new int[256];
    protected int[] radpower = new int[32];
    protected int[][] network = new int[256][];

    public NeuQuant(byte[] bArr, int i10, int i11) {
        this.thepicture = bArr;
        this.lengthcount = i10;
        this.samplefac = i11;
        for (int i12 = 0; i12 < 256; i12++) {
            this.network[i12] = new int[]{r6, r6, r6, 0};
            int i13 = (i12 << 12) / 256;
            this.freq[i12] = 256;
            this.bias[i12] = 0;
        }
    }

    public void alterneigh(int i10, int i11, int i12, int i13, int i14) {
        int i15 = i11 - i10;
        if (i15 < -1) {
            i15 = -1;
        }
        int i16 = i11 + i10;
        if (i16 > 256) {
            i16 = 256;
        }
        int i17 = i11 + 1;
        int i18 = i11 - 1;
        int i19 = 1;
        while (true) {
            if (i17 >= i16 && i18 <= i15) {
                return;
            }
            int i20 = i19 + 1;
            int i21 = this.radpower[i19];
            if (i17 < i16) {
                int i22 = i17 + 1;
                int[] iArr = this.network[i17];
                try {
                    int i23 = iArr[0];
                    iArr[0] = i23 - (((i23 - i12) * i21) / alpharadbias);
                    int i24 = iArr[1];
                    iArr[1] = i24 - (((i24 - i13) * i21) / alpharadbias);
                    int i25 = iArr[2];
                    iArr[2] = i25 - (((i25 - i14) * i21) / alpharadbias);
                } catch (Exception unused) {
                }
                i17 = i22;
            }
            if (i18 > i15) {
                int i26 = i18 - 1;
                int[] iArr2 = this.network[i18];
                try {
                    int i27 = iArr2[0];
                    iArr2[0] = i27 - (((i27 - i12) * i21) / alpharadbias);
                    int i28 = iArr2[1];
                    iArr2[1] = i28 - (((i28 - i13) * i21) / alpharadbias);
                    int i29 = iArr2[2];
                    iArr2[2] = i29 - ((i21 * (i29 - i14)) / alpharadbias);
                } catch (Exception unused2) {
                }
                i19 = i20;
                i18 = i26;
            } else {
                i19 = i20;
            }
        }
    }

    public void altersingle(int i10, int i11, int i12, int i13, int i14) {
        int[] iArr = this.network[i11];
        int i15 = iArr[0];
        iArr[0] = i15 - (((i15 - i12) * i10) / 1024);
        int i16 = iArr[1];
        iArr[1] = i16 - (((i16 - i13) * i10) / 1024);
        int i17 = iArr[2];
        iArr[2] = i17 - ((i10 * (i17 - i14)) / 1024);
    }

    public byte[] colorMap() {
        byte[] bArr = new byte[LogType.UNEXP_OTHER];
        int[] iArr = new int[256];
        for (int i10 = 0; i10 < 256; i10++) {
            iArr[this.network[i10][3]] = i10;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < 256) {
            int i13 = i12 + 1;
            int[] iArr2 = this.network[iArr[i11]];
            bArr[i12] = (byte) iArr2[0];
            int i14 = i13 + 1;
            bArr[i13] = (byte) iArr2[1];
            bArr[i14] = (byte) iArr2[2];
            i11++;
            i12 = i14 + 1;
        }
        return bArr;
    }

    public int contest(int i10, int i11, int i12) {
        int i13 = Integer.MAX_VALUE;
        int i14 = Integer.MAX_VALUE;
        int i15 = -1;
        int i16 = -1;
        for (int i17 = 0; i17 < 256; i17++) {
            int[] iArr = this.network[i17];
            int i18 = iArr[0] - i10;
            if (i18 < 0) {
                i18 = -i18;
            }
            int i19 = iArr[1] - i11;
            if (i19 < 0) {
                i19 = -i19;
            }
            int i20 = i18 + i19;
            int i21 = iArr[2] - i12;
            if (i21 < 0) {
                i21 = -i21;
            }
            int i22 = i20 + i21;
            if (i22 < i13) {
                i15 = i17;
                i13 = i22;
            }
            int[] iArr2 = this.bias;
            int i23 = i22 - (iArr2[i17] >> 12);
            if (i23 < i14) {
                i16 = i17;
                i14 = i23;
            }
            int[] iArr3 = this.freq;
            int i24 = iArr3[i17];
            int i25 = i24 >> 10;
            iArr3[i17] = i24 - i25;
            iArr2[i17] = iArr2[i17] + (i25 << 10);
        }
        int[] iArr4 = this.freq;
        iArr4[i15] = iArr4[i15] + 64;
        int[] iArr5 = this.bias;
        iArr5[i15] = iArr5[i15] - 65536;
        return i16;
    }

    public void inxbuild() {
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < 256) {
            int[] iArr = this.network[i10];
            int i13 = iArr[1];
            int i14 = i10 + 1;
            int i15 = i10;
            for (int i16 = i14; i16 < 256; i16++) {
                int i17 = this.network[i16][1];
                if (i17 < i13) {
                    i15 = i16;
                    i13 = i17;
                }
            }
            int[] iArr2 = this.network[i15];
            if (i10 != i15) {
                int i18 = iArr2[0];
                iArr2[0] = iArr[0];
                iArr[0] = i18;
                int i19 = iArr2[1];
                iArr2[1] = iArr[1];
                iArr[1] = i19;
                int i20 = iArr2[2];
                iArr2[2] = iArr[2];
                iArr[2] = i20;
                int i21 = iArr2[3];
                iArr2[3] = iArr[3];
                iArr[3] = i21;
            }
            if (i13 != i11) {
                this.netindex[i11] = (i12 + i10) >> 1;
                while (true) {
                    i11++;
                    if (i11 >= i13) {
                        break;
                    } else {
                        this.netindex[i11] = i10;
                    }
                }
                i12 = i10;
                i11 = i13;
            }
            i10 = i14;
        }
        this.netindex[i11] = (i12 + 255) >> 1;
        for (int i22 = i11 + 1; i22 < 256; i22++) {
            this.netindex[i22] = 255;
        }
    }

    public void learn() {
        int i10 = this.lengthcount;
        if (i10 < minpicturebytes) {
            this.samplefac = 1;
        }
        int i11 = this.samplefac;
        this.alphadec = ((i11 - 1) / 3) + 30;
        byte[] bArr = this.thepicture;
        int i12 = i10 / (i11 * 3);
        int i13 = i12 / 100;
        for (int i14 = 0; i14 < 32; i14++) {
            this.radpower[i14] = 1024 * (((1024 - (i14 * i14)) * 256) / 1024);
        }
        int i15 = this.lengthcount;
        int i16 = i15 < minpicturebytes ? 3 : i15 % prime1 != 0 ? 1497 : i15 % prime2 != 0 ? 1473 : i15 % prime3 != 0 ? 1461 : minpicturebytes;
        int i17 = i13;
        int i18 = 0;
        int i19 = 2048;
        int i20 = 1024;
        int i21 = 32;
        int i22 = 0;
        while (i18 < i12) {
            int i23 = (bArr[i22 + 0] & UnsignedBytes.MAX_VALUE) << 4;
            int i24 = (bArr[i22 + 1] & UnsignedBytes.MAX_VALUE) << 4;
            int i25 = (bArr[i22 + 2] & UnsignedBytes.MAX_VALUE) << 4;
            int contest = contest(i23, i24, i25);
            int i26 = i18;
            altersingle(i20, contest, i23, i24, i25);
            if (i21 != 0) {
                alterneigh(i21, contest, i23, i24, i25);
            }
            int i27 = i22 + i16;
            if (i27 >= i10) {
                i27 -= this.lengthcount;
            }
            i22 = i27;
            i18 = i26 + 1;
            if (i17 == 0) {
                i17 = 1;
            }
            if (i18 % i17 == 0) {
                i20 -= i20 / this.alphadec;
                i19 -= i19 / 30;
                int i28 = i19 >> 6;
                if (i28 <= 1) {
                    i28 = 0;
                }
                for (int i29 = 0; i29 < i28; i29++) {
                    int i30 = i28 * i28;
                    this.radpower[i29] = (((i30 - (i29 * i29)) * 256) / i30) * i20;
                }
                i21 = i28;
            }
        }
    }

    public int map(int i10, int i11, int i12) {
        int i13 = this.netindex[i11];
        int i14 = i13 - 1;
        int i15 = 1000;
        int i16 = -1;
        while (true) {
            if (i13 >= 256 && i14 < 0) {
                return i16;
            }
            if (i13 < 256) {
                int[] iArr = this.network[i13];
                int i17 = iArr[1] - i11;
                if (i17 >= i15) {
                    i13 = 256;
                } else {
                    i13++;
                    if (i17 < 0) {
                        i17 = -i17;
                    }
                    int i18 = iArr[0] - i10;
                    if (i18 < 0) {
                        i18 = -i18;
                    }
                    int i19 = i17 + i18;
                    if (i19 < i15) {
                        int i20 = iArr[2] - i12;
                        if (i20 < 0) {
                            i20 = -i20;
                        }
                        int i21 = i19 + i20;
                        if (i21 < i15) {
                            i16 = iArr[3];
                            i15 = i21;
                        }
                    }
                }
            }
            if (i14 >= 0) {
                int[] iArr2 = this.network[i14];
                int i22 = i11 - iArr2[1];
                if (i22 >= i15) {
                    i14 = -1;
                } else {
                    i14--;
                    if (i22 < 0) {
                        i22 = -i22;
                    }
                    int i23 = iArr2[0] - i10;
                    if (i23 < 0) {
                        i23 = -i23;
                    }
                    int i24 = i22 + i23;
                    if (i24 < i15) {
                        int i25 = iArr2[2] - i12;
                        if (i25 < 0) {
                            i25 = -i25;
                        }
                        int i26 = i25 + i24;
                        if (i26 < i15) {
                            i16 = iArr2[3];
                            i15 = i26;
                        }
                    }
                }
            }
        }
    }

    public byte[] process() {
        learn();
        unbiasnet();
        inxbuild();
        return colorMap();
    }

    public void unbiasnet() {
        for (int i10 = 0; i10 < 256; i10++) {
            int[] iArr = this.network[i10];
            iArr[0] = iArr[0] >> 4;
            iArr[1] = iArr[1] >> 4;
            iArr[2] = iArr[2] >> 4;
            iArr[3] = i10;
        }
    }
}
