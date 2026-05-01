package t7;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.mdns.xbill.dns.Type;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import u7.c;

/* loaded from: classes3.dex */
public class a extends c {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f18914b = new byte[256];

    /* renamed from: a, reason: collision with root package name */
    public byte[] f18915a = new byte[4];

    static {
        for (int i10 = 0; i10 < 255; i10++) {
            f18914b[i10] = -1;
        }
    }

    @Override // u7.c
    public int a() {
        return 4;
    }

    @Override // u7.c
    public int b() {
        return 72;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7  */
    @Override // u7.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i10) {
        byte b10;
        byte b11;
        byte b12;
        char[] cArr = {'A', ASCIIPropertyListParser.DATA_GSBOOL_BEGIN_TOKEN, 'C', ASCIIPropertyListParser.DATA_GSDATE_BEGIN_TOKEN, 'E', 'F', 'G', 'H', ASCIIPropertyListParser.DATA_GSINT_BEGIN_TOKEN, 'J', 'K', 'L', 'M', ASCIIPropertyListParser.DATA_GSBOOL_FALSE_TOKEN, 'O', 'P', 'Q', ASCIIPropertyListParser.DATA_GSREAL_BEGIN_TOKEN, 'S', ASCIIPropertyListParser.DATE_APPLE_DATE_TIME_DELIMITER, 'U', 'V', 'W', 'X', ASCIIPropertyListParser.DATA_GSBOOL_TRUE_TOKEN, ASCIIPropertyListParser.DATE_APPLE_END_TOKEN, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        for (int i11 = 0; i11 < 64; i11++) {
            f18914b[cArr[i11]] = (byte) i11;
        }
        if (i10 < 2) {
            throw new u7.a("BASE64Decoder: Not enough bytes for an atom.");
        }
        while (true) {
            int read = pushbackInputStream.read();
            byte b13 = -1;
            if (read == -1) {
                throw new u7.b();
            }
            if (read != 10 && read != 13) {
                byte[] bArr = this.f18915a;
                bArr[0] = (byte) read;
                if (j(pushbackInputStream, bArr, 1, i10 - 1) == -1) {
                    throw new u7.b();
                }
                if (i10 > 3 && this.f18915a[3] == 61) {
                    i10 = 3;
                }
                if (i10 > 2 && this.f18915a[2] == 61) {
                    i10 = 2;
                }
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            b12 = -1;
                            b10 = -1;
                            b11 = -1;
                            if (i10 != 2) {
                                outputStream.write((byte) (((b11 >>> 4) & 3) | ((b13 << 2) & Type.AXFR)));
                                return;
                            }
                            if (i10 == 3) {
                                outputStream.write((byte) (((b13 << 2) & Type.AXFR) | (3 & (b11 >>> 4))));
                                outputStream.write((byte) (((b11 << 4) & 240) | ((b12 >>> 2) & 15)));
                                return;
                            } else {
                                if (i10 != 4) {
                                    return;
                                }
                                outputStream.write((byte) (((b13 << 2) & Type.AXFR) | ((b11 >>> 4) & 3)));
                                outputStream.write((byte) (((b11 << 4) & 240) | ((b12 >>> 2) & 15)));
                                outputStream.write((byte) (((b12 << 6) & 192) | (b10 & 63)));
                                return;
                            }
                        }
                        b13 = f18914b[this.f18915a[3] & UnsignedBytes.MAX_VALUE];
                    }
                    b10 = b13;
                    b13 = f18914b[this.f18915a[2] & UnsignedBytes.MAX_VALUE];
                } else {
                    b10 = -1;
                }
                byte[] bArr2 = f18914b;
                byte[] bArr3 = this.f18915a;
                b11 = bArr2[bArr3[1] & UnsignedBytes.MAX_VALUE];
                byte b14 = b13;
                b13 = bArr2[bArr3[0] & UnsignedBytes.MAX_VALUE];
                b12 = b14;
                if (i10 != 2) {
                }
            }
        }
    }
}
