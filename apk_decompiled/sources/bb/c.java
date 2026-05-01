package bb;

import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes.dex */
public class c extends b {
    @Override // bb.b
    public int b(byte[] bArr, int i10) {
        int i11;
        if ((bArr[i10] & UnsignedBytes.MAX_VALUE) != 130 || (i11 = bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) < 159 || i11 > 241) {
            return -1;
        }
        return i11 - 159;
    }
}
