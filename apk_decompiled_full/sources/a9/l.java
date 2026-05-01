package a9;

import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import okio.Buffer;
import z8.t1;

/* loaded from: classes3.dex */
public class l extends z8.c {

    /* renamed from: a, reason: collision with root package name */
    public final Buffer f462a;

    public l(Buffer buffer) {
        this.f462a = buffer;
    }

    @Override // z8.t1
    public void C(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            int read = this.f462a.read(bArr, i10, i11);
            if (read == -1) {
                throw new IndexOutOfBoundsException("EOF trying to read " + i11 + " bytes");
            }
            i11 -= read;
            i10 += read;
        }
    }

    @Override // z8.t1
    public void H(OutputStream outputStream, int i10) {
        this.f462a.writeTo(outputStream, i10);
    }

    public final void b() {
    }

    @Override // z8.c, z8.t1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f462a.clear();
    }

    @Override // z8.t1
    public int h() {
        return (int) this.f462a.size();
    }

    @Override // z8.t1
    public t1 j(int i10) {
        Buffer buffer = new Buffer();
        buffer.write(this.f462a, i10);
        return new l(buffer);
    }

    @Override // z8.t1
    public void r(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // z8.t1
    public int readUnsignedByte() {
        try {
            b();
            return this.f462a.readByte() & UnsignedBytes.MAX_VALUE;
        } catch (EOFException e10) {
            throw new IndexOutOfBoundsException(e10.getMessage());
        }
    }

    @Override // z8.t1
    public void skipBytes(int i10) {
        try {
            this.f462a.skip(i10);
        } catch (EOFException e10) {
            throw new IndexOutOfBoundsException(e10.getMessage());
        }
    }
}
