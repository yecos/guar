package z8;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface t1 extends Closeable {
    void C(byte[] bArr, int i10, int i11);

    void D();

    void H(OutputStream outputStream, int i10);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int h();

    t1 j(int i10);

    boolean markSupported();

    void r(ByteBuffer byteBuffer);

    int readUnsignedByte();

    void reset();

    void skipBytes(int i10);
}
