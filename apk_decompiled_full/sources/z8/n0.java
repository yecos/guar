package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class n0 implements t1 {

    /* renamed from: a, reason: collision with root package name */
    public final t1 f20765a;

    public n0(t1 t1Var) {
        this.f20765a = (t1) Preconditions.checkNotNull(t1Var, "buf");
    }

    @Override // z8.t1
    public void C(byte[] bArr, int i10, int i11) {
        this.f20765a.C(bArr, i10, i11);
    }

    @Override // z8.t1
    public void D() {
        this.f20765a.D();
    }

    @Override // z8.t1
    public void H(OutputStream outputStream, int i10) {
        this.f20765a.H(outputStream, i10);
    }

    @Override // z8.t1
    public int h() {
        return this.f20765a.h();
    }

    @Override // z8.t1
    public t1 j(int i10) {
        return this.f20765a.j(i10);
    }

    @Override // z8.t1
    public boolean markSupported() {
        return this.f20765a.markSupported();
    }

    @Override // z8.t1
    public void r(ByteBuffer byteBuffer) {
        this.f20765a.r(byteBuffer);
    }

    @Override // z8.t1
    public int readUnsignedByte() {
        return this.f20765a.readUnsignedByte();
    }

    @Override // z8.t1
    public void reset() {
        this.f20765a.reset();
    }

    @Override // z8.t1
    public void skipBytes(int i10) {
        this.f20765a.skipBytes(i10);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.f20765a).toString();
    }
}
