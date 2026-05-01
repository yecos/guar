package d4;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class f extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f12528a;

    public f(ByteBuffer byteBuffer) {
        this.f12528a = byteBuffer;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f12528a.remaining();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f12528a.hasRemaining()) {
            return this.f12528a.get() & UnsignedBytes.MAX_VALUE;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        if (!this.f12528a.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i11, this.f12528a.remaining());
        this.f12528a.get(bArr, i10, min);
        return min;
    }
}
