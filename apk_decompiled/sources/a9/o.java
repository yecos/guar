package a9;

import okio.Buffer;
import z8.n2;

/* loaded from: classes3.dex */
public class o implements n2 {

    /* renamed from: a, reason: collision with root package name */
    public final Buffer f464a;

    /* renamed from: b, reason: collision with root package name */
    public int f465b;

    /* renamed from: c, reason: collision with root package name */
    public int f466c;

    public o(Buffer buffer, int i10) {
        this.f464a = buffer;
        this.f465b = i10;
    }

    @Override // z8.n2
    public int a() {
        return this.f465b;
    }

    @Override // z8.n2
    public void b(byte b10) {
        this.f464a.writeByte((int) b10);
        this.f465b--;
        this.f466c++;
    }

    public Buffer c() {
        return this.f464a;
    }

    @Override // z8.n2
    public int h() {
        return this.f466c;
    }

    @Override // z8.n2
    public void release() {
    }

    @Override // z8.n2
    public void write(byte[] bArr, int i10, int i11) {
        this.f464a.write(bArr, i10, i11);
        this.f465b -= i11;
        this.f466c += i11;
    }
}
