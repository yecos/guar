package bb;

import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes.dex */
public class a extends b {
    @Override // bb.b
    public int b(byte[] bArr, int i10) {
        int i11;
        if ((bArr[i10] & UnsignedBytes.MAX_VALUE) != 164 || (i11 = bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) < 161 || i11 > 243) {
            return -1;
        }
        return i11 - 161;
    }
}
