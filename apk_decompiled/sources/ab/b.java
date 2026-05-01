package ab;

import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class b {

    public enum a {
        DETECTING,
        FOUND_IT,
        NOT_ME
    }

    public ByteBuffer a(byte[] bArr, int i10, int i11) {
        ByteBuffer allocate = ByteBuffer.allocate(i11);
        int i12 = i11 + i10;
        int i13 = i10;
        boolean z10 = false;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            if (b10 == 62) {
                z10 = false;
            } else if (b10 == 60) {
                z10 = true;
            }
            if (g(b10) && h(b10)) {
                if (i10 > i13 && !z10) {
                    allocate.put(bArr, i13, i10 - i13);
                    allocate.put((byte) 32);
                }
                i13 = i10 + 1;
            }
            i10++;
        }
        if (!z10 && i10 > i13) {
            allocate.put(bArr, i13, i10 - i13);
        }
        return allocate;
    }

    public ByteBuffer b(byte[] bArr, int i10, int i11) {
        ByteBuffer allocate = ByteBuffer.allocate(i11);
        int i12 = i11 + i10;
        int i13 = i10;
        boolean z10 = false;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            if (!g(b10)) {
                z10 = true;
            } else if (h(b10)) {
                if (!z10 || i10 <= i13) {
                    i13 = i10 + 1;
                } else {
                    allocate.put(bArr, i13, i10 - i13);
                    allocate.put((byte) 32);
                    i13 = i10 + 1;
                    z10 = false;
                }
            }
            i10++;
        }
        if (z10 && i10 > i13) {
            allocate.put(bArr, i13, i10 - i13);
        }
        return allocate;
    }

    public abstract String c();

    public abstract float d();

    public abstract a e();

    public abstract a f(byte[] bArr, int i10, int i11);

    public final boolean g(byte b10) {
        return (b10 & UnsignedBytes.MAX_POWER_OF_TWO) == 0;
    }

    public final boolean h(byte b10) {
        int i10 = b10 & UnsignedBytes.MAX_VALUE;
        return i10 < 65 || (i10 > 90 && i10 < 97) || i10 > 122;
    }

    public abstract void i();
}
