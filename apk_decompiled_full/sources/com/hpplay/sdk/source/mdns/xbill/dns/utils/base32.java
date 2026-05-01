package com.hpplay.sdk.source.mdns.xbill.dns.utils;

import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class base32 {
    private String alphabet;
    private boolean lowercase;
    private boolean padding;

    public static class Alphabet {
        public static final String BASE32 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=";
        public static final String BASE32HEX = "0123456789ABCDEFGHIJKLMNOPQRSTUV=";

        private Alphabet() {
        }
    }

    public base32(String str, boolean z10, boolean z11) {
        this.alphabet = str;
        this.padding = z10;
        this.lowercase = z11;
    }

    private static int blockLenToPadding(int i10) {
        if (i10 == 1) {
            return 6;
        }
        if (i10 == 2) {
            return 4;
        }
        if (i10 == 3) {
            return 3;
        }
        if (i10 != 4) {
            return i10 != 5 ? -1 : 0;
        }
        return 1;
    }

    private static int paddingToBlockLen(int i10) {
        if (i10 == 0) {
            return 5;
        }
        if (i10 == 1) {
            return 4;
        }
        if (i10 == 3) {
            return 3;
        }
        if (i10 != 4) {
            return i10 != 6 ? -1 : 1;
        }
        return 2;
    }

    public byte[] fromString(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b10 : str.getBytes()) {
            char c10 = (char) b10;
            if (!Character.isWhitespace(c10)) {
                byteArrayOutputStream.write((byte) Character.toUpperCase(c10));
            }
        }
        if (!this.padding) {
            while (byteArrayOutputStream.size() % 8 != 0) {
                byteArrayOutputStream.write(61);
            }
        } else if (byteArrayOutputStream.size() % 8 != 0) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i10 = 0; i10 < byteArray.length / 8; i10++) {
            short[] sArr = new short[8];
            int[] iArr = new int[5];
            int i11 = 8;
            for (int i12 = 0; i12 < 8; i12++) {
                byte b11 = byteArray[(i10 * 8) + i12];
                if (((char) b11) == '=') {
                    break;
                }
                short indexOf = (short) this.alphabet.indexOf(b11);
                sArr[i12] = indexOf;
                if (indexOf < 0) {
                    return null;
                }
                i11--;
            }
            int paddingToBlockLen = paddingToBlockLen(i11);
            if (paddingToBlockLen < 0) {
                return null;
            }
            int i13 = sArr[0] << 3;
            short s10 = sArr[1];
            iArr[0] = i13 | (s10 >> 2);
            int i14 = ((s10 & 3) << 6) | (sArr[2] << 1);
            short s11 = sArr[3];
            iArr[1] = i14 | (s11 >> 4);
            int i15 = (s11 & 15) << 4;
            short s12 = sArr[4];
            iArr[2] = i15 | ((s12 >> 1) & 15);
            int i16 = (s12 << 7) | (sArr[5] << 2);
            short s13 = sArr[6];
            iArr[3] = i16 | (s13 >> 3);
            iArr[4] = sArr[7] | ((s13 & 7) << 5);
            for (int i17 = 0; i17 < paddingToBlockLen; i17++) {
                try {
                    dataOutputStream.writeByte((byte) (iArr[i17] & 255));
                } catch (IOException unused) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString(byte[] bArr) {
        int i10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i11 = 0; i11 < (bArr.length + 4) / 5; i11++) {
            short[] sArr = new short[5];
            int[] iArr = new int[8];
            int i12 = 5;
            for (int i13 = 0; i13 < 5; i13++) {
                int i14 = (i11 * 5) + i13;
                if (i14 < bArr.length) {
                    sArr[i13] = (short) (bArr[i14] & UnsignedBytes.MAX_VALUE);
                } else {
                    sArr[i13] = 0;
                    i12--;
                }
            }
            int blockLenToPadding = blockLenToPadding(i12);
            short s10 = sArr[0];
            iArr[0] = (byte) ((s10 >> 3) & 31);
            short s11 = sArr[1];
            iArr[1] = (byte) (((s10 & 7) << 2) | ((s11 >> 6) & 3));
            iArr[2] = (byte) ((s11 >> 1) & 31);
            short s12 = sArr[2];
            iArr[3] = (byte) (((s11 & 1) << 4) | ((s12 >> 4) & 15));
            int i15 = (s12 & 15) << 1;
            short s13 = sArr[3];
            iArr[4] = (byte) (i15 | (1 & (s13 >> 7)));
            iArr[5] = (byte) ((s13 >> 2) & 31);
            short s14 = sArr[4];
            iArr[6] = (byte) (((s14 >> 5) & 7) | ((s13 & 3) << 3));
            iArr[7] = (byte) (s14 & 31);
            int i16 = 0;
            while (true) {
                i10 = 8 - blockLenToPadding;
                if (i16 >= i10) {
                    break;
                }
                char charAt = this.alphabet.charAt(iArr[i16]);
                if (this.lowercase) {
                    charAt = Character.toLowerCase(charAt);
                }
                byteArrayOutputStream.write(charAt);
                i16++;
            }
            if (this.padding) {
                while (i10 < 8) {
                    byteArrayOutputStream.write(61);
                    i10++;
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }
}
