package cb;

import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes.dex */
public class c extends g {
    @Override // cb.b
    public int b(byte[] bArr, int i10) {
        int i11 = bArr[i10] & UnsignedBytes.MAX_VALUE;
        if (i11 < 161) {
            return -1;
        }
        return (((i11 - 161) * 94) + (bArr[i10 + 1] & UnsignedBytes.MAX_VALUE)) - 161;
    }
}
