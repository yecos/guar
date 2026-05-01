package cb;

import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes.dex */
public class h extends g {
    @Override // cb.b
    public int b(byte[] bArr, int i10) {
        int i11;
        int i12 = bArr[i10] & UnsignedBytes.MAX_VALUE;
        if (i12 >= 129 && i12 <= 159) {
            i11 = i12 - 129;
        } else {
            if (i12 < 224 || i12 > 239) {
                return -1;
            }
            i11 = (i12 - 224) + 31;
        }
        int i13 = i11 * 188;
        int i14 = bArr[i10 + 1] & UnsignedBytes.MAX_VALUE;
        int i15 = i13 + (i14 - 64);
        return i14 >= 128 ? i15 - 1 : i15;
    }
}
