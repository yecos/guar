package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;
import java.net.InetAddress;

/* loaded from: classes3.dex */
public final class ReverseMap {
    private static Name inaddr4 = Name.fromConstantString("in-addr.arpa.");
    private static Name inaddr6 = Name.fromConstantString("ip6.arpa.");

    private ReverseMap() {
    }

    public static Name fromAddress(byte[] bArr) {
        String stringBuffer;
        Name name;
        if (bArr.length != 4 && bArr.length != 16) {
            throw new IllegalArgumentException("array must contain 4 or 16 elements");
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        if (bArr.length == 4) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                stringBuffer2.append(bArr[length] & UnsignedBytes.MAX_VALUE);
                if (length > 0) {
                    stringBuffer2.append(".");
                }
            }
        } else {
            int[] iArr = new int[2];
            for (int length2 = bArr.length - 1; length2 >= 0; length2--) {
                byte b10 = bArr[length2];
                iArr[0] = (b10 & UnsignedBytes.MAX_VALUE) >> 4;
                iArr[1] = b10 & UnsignedBytes.MAX_VALUE & 15;
                for (int i10 = 1; i10 >= 0; i10--) {
                    stringBuffer2.append(Integer.toHexString(iArr[i10]));
                    if (length2 > 0 || i10 > 0) {
                        stringBuffer2.append(".");
                    }
                }
            }
        }
        try {
            if (bArr.length == 4) {
                stringBuffer = stringBuffer2.toString();
                name = inaddr4;
            } else {
                stringBuffer = stringBuffer2.toString();
                name = inaddr6;
            }
            return Name.fromString(stringBuffer, name);
        } catch (Exception unused) {
            throw new IllegalStateException("name cannot be invalid");
        }
    }

    public static Name fromAddress(InetAddress inetAddress) {
        return fromAddress(inetAddress.getAddress());
    }
}
