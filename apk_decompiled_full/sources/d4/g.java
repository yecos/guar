package d4;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class g extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f12529a;

    public g(ByteBuffer byteBuffer) {
        this.f12529a = byteBuffer;
    }

    @Override // java.io.OutputStream
    public void write(int i10) {
        this.f12529a.put((byte) i10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        this.f12529a.put(bArr, i10, i11);
    }
}
