package com.hpplay.sdk.source.mdns.xbill.dns.utils;

import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class base16 {
    private static final String Base16 = "0123456789ABCDEF";

    private base16() {
    }

    public static byte[] fromString(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = str.getBytes();
        for (int i10 = 0; i10 < bytes.length; i10++) {
            if (!Character.isWhitespace((char) bytes[i10])) {
                byteArrayOutputStream.write(bytes[i10]);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length % 2 != 0) {
            return null;
        }
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i11 = 0; i11 < byteArray.length; i11 += 2) {
            try {
                dataOutputStream.writeByte((((byte) Base16.indexOf(Character.toUpperCase((char) byteArray[i11]))) << 4) + ((byte) Base16.indexOf(Character.toUpperCase((char) byteArray[i11 + 1]))));
            } catch (IOException unused) {
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String toString(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b10 : bArr) {
            short s10 = (short) (b10 & UnsignedBytes.MAX_VALUE);
            byteArrayOutputStream.write(Base16.charAt((byte) (s10 >> 4)));
            byteArrayOutputStream.write(Base16.charAt((byte) (s10 & 15)));
        }
        return new String(byteArrayOutputStream.toByteArray());
    }
}
