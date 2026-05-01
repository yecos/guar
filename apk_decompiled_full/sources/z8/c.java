package z8;

/* loaded from: classes3.dex */
public abstract class c implements t1 {
    @Override // z8.t1
    public void D() {
    }

    public final void a(int i10) {
        if (h() < i10) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // z8.t1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // z8.t1
    public boolean markSupported() {
        return false;
    }

    public final int readInt() {
        a(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    @Override // z8.t1
    public void reset() {
        throw new UnsupportedOperationException();
    }
}
