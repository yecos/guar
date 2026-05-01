package t7;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.OutputStream;
import u7.d;

/* loaded from: classes3.dex */
public class b extends d {
    @Override // u7.d
    public int a() {
        return 3;
    }

    @Override // u7.d
    public int b() {
        return 57;
    }

    @Override // u7.d
    public void e(OutputStream outputStream, byte[] bArr, int i10, int i11) {
        char[] cArr = {'A', ASCIIPropertyListParser.DATA_GSBOOL_BEGIN_TOKEN, 'C', ASCIIPropertyListParser.DATA_GSDATE_BEGIN_TOKEN, 'E', 'F', 'G', 'H', ASCIIPropertyListParser.DATA_GSINT_BEGIN_TOKEN, 'J', 'K', 'L', 'M', ASCIIPropertyListParser.DATA_GSBOOL_FALSE_TOKEN, 'O', 'P', 'Q', ASCIIPropertyListParser.DATA_GSREAL_BEGIN_TOKEN, 'S', ASCIIPropertyListParser.DATE_APPLE_DATE_TIME_DELIMITER, 'U', 'V', 'W', 'X', ASCIIPropertyListParser.DATA_GSBOOL_TRUE_TOKEN, ASCIIPropertyListParser.DATE_APPLE_END_TOKEN, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        if (i11 == 1) {
            byte b10 = bArr[i10];
            outputStream.write(cArr[(b10 >>> 2) & 63]);
            outputStream.write(cArr[((b10 << 4) & 48) + 0]);
            outputStream.write(61);
            outputStream.write(61);
            return;
        }
        if (i11 == 2) {
            byte b11 = bArr[i10];
            byte b12 = bArr[i10 + 1];
            outputStream.write(cArr[(b11 >>> 2) & 63]);
            outputStream.write(cArr[((b11 << 4) & 48) + ((b12 >>> 4) & 15)]);
            outputStream.write(cArr[((b12 << 2) & 60) + 0]);
            outputStream.write(61);
            return;
        }
        byte b13 = bArr[i10];
        byte b14 = bArr[i10 + 1];
        byte b15 = bArr[i10 + 2];
        outputStream.write(cArr[(b13 >>> 2) & 63]);
        outputStream.write(cArr[((b13 << 4) & 48) + ((b14 >>> 4) & 15)]);
        outputStream.write(cArr[((b14 << 2) & 60) + ((b15 >>> 6) & 3)]);
        outputStream.write(cArr[b15 & 63]);
    }
}
