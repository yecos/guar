package com.hpplay.glide.gifencoder;

import anet.channel.entity.EventType;
import com.google.common.primitives.UnsignedBytes;
import com.taobao.accs.data.Message;
import java.io.OutputStream;

/* loaded from: classes2.dex */
class LZWEncoder {
    static final int BITS = 12;
    private static final int EOF = -1;
    static final int HSIZE = 5003;
    int ClearCode;
    int EOFCode;
    int a_count;
    private int curPixel;
    int g_init_bits;
    private int imgH;
    private int imgW;
    private int initCodeSize;
    int maxcode;
    int n_bits;
    private byte[] pixAry;
    private int remaining;
    int maxbits = 12;
    int maxmaxcode = 4096;
    int[] htab = new int[HSIZE];
    int[] codetab = new int[HSIZE];
    int hsize = HSIZE;
    int free_ent = 0;
    boolean clear_flg = false;
    int cur_accum = 0;
    int cur_bits = 0;
    int[] masks = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, Message.EXT_HEADER_VALUE_MAX_LEN, 2047, EventType.ALL, 8191, 16383, 32767, com.hpplay.sdk.source.mdns.xbill.dns.Message.MAXLENGTH};
    byte[] accum = new byte[256];

    public LZWEncoder(int i10, int i11, byte[] bArr, int i12) {
        this.imgW = i10;
        this.imgH = i11;
        this.pixAry = bArr;
        this.initCodeSize = Math.max(2, i12);
    }

    private int nextPixel() {
        int i10 = this.remaining;
        if (i10 == 0) {
            return -1;
        }
        this.remaining = i10 - 1;
        byte[] bArr = this.pixAry;
        int i11 = this.curPixel;
        this.curPixel = i11 + 1;
        return bArr[i11] & UnsignedBytes.MAX_VALUE;
    }

    public final int MAXCODE(int i10) {
        return (1 << i10) - 1;
    }

    public void char_out(byte b10, OutputStream outputStream) {
        byte[] bArr = this.accum;
        int i10 = this.a_count;
        int i11 = i10 + 1;
        this.a_count = i11;
        bArr[i10] = b10;
        if (i11 >= 254) {
            flush_char(outputStream);
        }
    }

    public void cl_block(OutputStream outputStream) {
        cl_hash(this.hsize);
        int i10 = this.ClearCode;
        this.free_ent = i10 + 2;
        this.clear_flg = true;
        output(i10, outputStream);
    }

    public void cl_hash(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            this.htab[i11] = -1;
        }
    }

    public void compress(int i10, OutputStream outputStream) {
        int i11;
        this.g_init_bits = i10;
        int i12 = 0;
        this.clear_flg = false;
        this.n_bits = i10;
        this.maxcode = MAXCODE(i10);
        int i13 = 1 << (i10 - 1);
        this.ClearCode = i13;
        this.EOFCode = i13 + 1;
        this.free_ent = i13 + 2;
        this.a_count = 0;
        int nextPixel = nextPixel();
        for (int i14 = this.hsize; i14 < 65536; i14 *= 2) {
            i12++;
        }
        int i15 = 8 - i12;
        int i16 = this.hsize;
        cl_hash(i16);
        output(this.ClearCode, outputStream);
        while (true) {
            int nextPixel2 = nextPixel();
            if (nextPixel2 == -1) {
                output(nextPixel, outputStream);
                output(this.EOFCode, outputStream);
                return;
            }
            int i17 = (nextPixel2 << this.maxbits) + nextPixel;
            int i18 = (nextPixel2 << i15) ^ nextPixel;
            int i19 = this.htab[i18];
            if (i19 == i17) {
                nextPixel = this.codetab[i18];
            } else {
                if (i19 >= 0) {
                    int i20 = i16 - i18;
                    if (i18 == 0) {
                        i20 = 1;
                    }
                    do {
                        i18 -= i20;
                        if (i18 < 0) {
                            i18 += i16;
                        }
                        i11 = this.htab[i18];
                        if (i11 == i17) {
                            nextPixel = this.codetab[i18];
                            break;
                        }
                    } while (i11 >= 0);
                }
                output(nextPixel, outputStream);
                int i21 = this.free_ent;
                if (i21 < this.maxmaxcode) {
                    int[] iArr = this.codetab;
                    this.free_ent = i21 + 1;
                    iArr[i18] = i21;
                    this.htab[i18] = i17;
                } else {
                    cl_block(outputStream);
                }
                nextPixel = nextPixel2;
            }
        }
    }

    public void encode(OutputStream outputStream) {
        outputStream.write(this.initCodeSize);
        this.remaining = this.imgW * this.imgH;
        this.curPixel = 0;
        compress(this.initCodeSize + 1, outputStream);
        outputStream.write(0);
    }

    public void flush_char(OutputStream outputStream) {
        int i10 = this.a_count;
        if (i10 > 0) {
            outputStream.write(i10);
            outputStream.write(this.accum, 0, this.a_count);
            this.a_count = 0;
        }
    }

    public void output(int i10, OutputStream outputStream) {
        int i11 = this.cur_accum;
        int[] iArr = this.masks;
        int i12 = this.cur_bits;
        int i13 = i11 & iArr[i12];
        this.cur_accum = i13;
        if (i12 > 0) {
            this.cur_accum = i13 | (i10 << i12);
        } else {
            this.cur_accum = i10;
        }
        this.cur_bits = i12 + this.n_bits;
        while (this.cur_bits >= 8) {
            char_out((byte) (this.cur_accum & 255), outputStream);
            this.cur_accum >>= 8;
            this.cur_bits -= 8;
        }
        if (this.free_ent > this.maxcode || this.clear_flg) {
            if (this.clear_flg) {
                int i14 = this.g_init_bits;
                this.n_bits = i14;
                this.maxcode = MAXCODE(i14);
                this.clear_flg = false;
            } else {
                int i15 = this.n_bits + 1;
                this.n_bits = i15;
                if (i15 == this.maxbits) {
                    this.maxcode = this.maxmaxcode;
                } else {
                    this.maxcode = MAXCODE(i15);
                }
            }
        }
        if (i10 == this.EOFCode) {
            while (this.cur_bits > 0) {
                char_out((byte) (this.cur_accum & 255), outputStream);
                this.cur_accum >>= 8;
                this.cur_bits -= 8;
            }
            flush_char(outputStream);
        }
    }
}
