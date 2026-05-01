package io.jsonwebtoken.impl.io;

import com.google.common.base.Ascii;
import io.jsonwebtoken.impl.io.BaseNCodec;
import io.jsonwebtoken.lang.Strings;

/* loaded from: classes3.dex */
class Base64Codec extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    private static final int MASK_2BITS = 3;
    private static final int MASK_4BITS = 15;
    private static final int MASK_6BITS = 63;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, 63, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public Base64Codec() {
        this(0);
    }

    private void validateCharacter(int i10, BaseNCodec.Context context) {
        if (isStrictDecoding() && (i10 & context.ibitWorkArea) != 0) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
        }
    }

    private void validateTrailingCharacter() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Decoding requires at least two trailing 6-bit characters to create bytes.");
        }
    }

    @Override // io.jsonwebtoken.impl.io.BaseNCodec
    public void decode(byte[] bArr, int i10, int i11, BaseNCodec.Context context) {
        byte b10;
        if (context.eof) {
            return;
        }
        if (i11 < 0) {
            context.eof = true;
        }
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
            int i13 = i10 + 1;
            byte b11 = bArr[i10];
            if (b11 == this.pad) {
                context.eof = true;
                break;
            }
            if (b11 >= 0) {
                byte[] bArr2 = DECODE_TABLE;
                if (b11 < bArr2.length && (b10 = bArr2[b11]) >= 0) {
                    int i14 = (context.modulus + 1) % 4;
                    context.modulus = i14;
                    int i15 = (context.ibitWorkArea << 6) + b10;
                    context.ibitWorkArea = i15;
                    if (i14 == 0) {
                        int i16 = context.pos;
                        int i17 = i16 + 1;
                        ensureBufferSize[i16] = (byte) ((i15 >> 16) & 255);
                        int i18 = i17 + 1;
                        ensureBufferSize[i17] = (byte) ((i15 >> 8) & 255);
                        context.pos = i18 + 1;
                        ensureBufferSize[i18] = (byte) (i15 & 255);
                    }
                }
            }
            i12++;
            i10 = i13;
        }
        if (!context.eof || context.modulus == 0) {
            return;
        }
        byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
        int i19 = context.modulus;
        if (i19 == 1) {
            validateTrailingCharacter();
            return;
        }
        if (i19 == 2) {
            validateCharacter(15, context);
            int i20 = context.ibitWorkArea >> 4;
            context.ibitWorkArea = i20;
            int i21 = context.pos;
            context.pos = i21 + 1;
            ensureBufferSize2[i21] = (byte) (i20 & 255);
            return;
        }
        if (i19 != 3) {
            throw new IllegalStateException("Impossible modulus " + context.modulus);
        }
        validateCharacter(3, context);
        int i22 = context.ibitWorkArea >> 2;
        context.ibitWorkArea = i22;
        int i23 = context.pos;
        int i24 = i23 + 1;
        ensureBufferSize2[i23] = (byte) ((i22 >> 8) & 255);
        context.pos = i24 + 1;
        ensureBufferSize2[i24] = (byte) (i22 & 255);
    }

    @Override // io.jsonwebtoken.impl.io.BaseNCodec
    public void encode(byte[] bArr, int i10, int i11, BaseNCodec.Context context) {
        if (context.eof) {
            return;
        }
        if (i11 >= 0) {
            int i12 = 0;
            while (i12 < i11) {
                byte[] ensureBufferSize = ensureBufferSize(this.encodeSize, context);
                int i13 = (context.modulus + 1) % 3;
                context.modulus = i13;
                int i14 = i10 + 1;
                int i15 = bArr[i10];
                if (i15 < 0) {
                    i15 += 256;
                }
                int i16 = (context.ibitWorkArea << 8) + i15;
                context.ibitWorkArea = i16;
                if (i13 == 0) {
                    int i17 = context.pos;
                    int i18 = i17 + 1;
                    byte[] bArr2 = this.encodeTable;
                    ensureBufferSize[i17] = bArr2[(i16 >> 18) & 63];
                    int i19 = i18 + 1;
                    ensureBufferSize[i18] = bArr2[(i16 >> 12) & 63];
                    int i20 = i19 + 1;
                    ensureBufferSize[i19] = bArr2[(i16 >> 6) & 63];
                    int i21 = i20 + 1;
                    context.pos = i21;
                    ensureBufferSize[i20] = bArr2[i16 & 63];
                    int i22 = context.currentLinePos + 4;
                    context.currentLinePos = i22;
                    int i23 = this.lineLength;
                    if (i23 > 0 && i23 <= i22) {
                        byte[] bArr3 = this.lineSeparator;
                        System.arraycopy(bArr3, 0, ensureBufferSize, i21, bArr3.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                    }
                }
                i12++;
                i10 = i14;
            }
            return;
        }
        context.eof = true;
        if (context.modulus == 0 && this.lineLength == 0) {
            return;
        }
        byte[] ensureBufferSize2 = ensureBufferSize(this.encodeSize, context);
        int i24 = context.pos;
        int i25 = context.modulus;
        if (i25 != 0) {
            if (i25 == 1) {
                int i26 = i24 + 1;
                byte[] bArr4 = this.encodeTable;
                int i27 = context.ibitWorkArea;
                ensureBufferSize2[i24] = bArr4[(i27 >> 2) & 63];
                int i28 = i26 + 1;
                context.pos = i28;
                ensureBufferSize2[i26] = bArr4[(i27 << 4) & 63];
                if (bArr4 == STANDARD_ENCODE_TABLE) {
                    int i29 = i28 + 1;
                    byte b10 = this.pad;
                    ensureBufferSize2[i28] = b10;
                    context.pos = i29 + 1;
                    ensureBufferSize2[i29] = b10;
                }
            } else {
                if (i25 != 2) {
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
                int i30 = i24 + 1;
                byte[] bArr5 = this.encodeTable;
                int i31 = context.ibitWorkArea;
                ensureBufferSize2[i24] = bArr5[(i31 >> 10) & 63];
                int i32 = i30 + 1;
                ensureBufferSize2[i30] = bArr5[(i31 >> 4) & 63];
                int i33 = i32 + 1;
                context.pos = i33;
                ensureBufferSize2[i32] = bArr5[(i31 << 2) & 63];
                if (bArr5 == STANDARD_ENCODE_TABLE) {
                    context.pos = i33 + 1;
                    ensureBufferSize2[i33] = this.pad;
                }
            }
        }
        int i34 = context.currentLinePos;
        int i35 = context.pos;
        int i36 = i34 + (i35 - i24);
        context.currentLinePos = i36;
        if (this.lineLength <= 0 || i36 <= 0) {
            return;
        }
        byte[] bArr6 = this.lineSeparator;
        System.arraycopy(bArr6, 0, ensureBufferSize2, i35, bArr6.length);
        context.pos += this.lineSeparator.length;
    }

    @Override // io.jsonwebtoken.impl.io.BaseNCodec
    public boolean isInAlphabet(byte b10) {
        if (b10 >= 0) {
            byte[] bArr = this.decodeTable;
            if (b10 < bArr.length && bArr[b10] != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    public Base64Codec(boolean z10) {
        this(76, BaseNCodec.CHUNK_SEPARATOR, z10);
    }

    public Base64Codec(int i10) {
        this(i10, BaseNCodec.CHUNK_SEPARATOR);
    }

    public Base64Codec(int i10, byte[] bArr) {
        this(i10, bArr, false);
    }

    public Base64Codec(int i10, byte[] bArr, boolean z10) {
        this(i10, bArr, z10, BaseNCodec.DECODING_POLICY_DEFAULT);
    }

    public Base64Codec(int i10, byte[] bArr, boolean z10, CodecPolicy codecPolicy) {
        super(3, 4, i10, BaseNCodec.length(bArr), (byte) 61, codecPolicy);
        this.decodeTable = DECODE_TABLE;
        if (bArr != null) {
            if (containsAlphabetOrPad(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + Strings.utf8(bArr) + "]");
            }
            if (i10 > 0) {
                this.encodeSize = bArr.length + 4;
                this.lineSeparator = (byte[]) bArr.clone();
            } else {
                this.encodeSize = 4;
                this.lineSeparator = null;
            }
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z10 ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }
}
