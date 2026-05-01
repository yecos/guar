package a9;

import com.google.common.base.Preconditions;
import java.util.List;
import okio.Buffer;

/* loaded from: classes3.dex */
public abstract class c implements c9.c {

    /* renamed from: a, reason: collision with root package name */
    public final c9.c f323a;

    public c(c9.c cVar) {
        this.f323a = (c9.c) Preconditions.checkNotNull(cVar, "delegate");
    }

    @Override // c9.c
    public void F(c9.i iVar) {
        this.f323a.F(iVar);
    }

    @Override // c9.c
    public void K(boolean z10, boolean z11, int i10, int i11, List list) {
        this.f323a.K(z10, z11, i10, i11, list);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f323a.close();
    }

    @Override // c9.c
    public void connectionPreface() {
        this.f323a.connectionPreface();
    }

    @Override // c9.c
    public void d(int i10, c9.a aVar) {
        this.f323a.d(i10, aVar);
    }

    @Override // c9.c
    public void data(boolean z10, int i10, Buffer buffer, int i11) {
        this.f323a.data(z10, i10, buffer, i11);
    }

    @Override // c9.c
    public void flush() {
        this.f323a.flush();
    }

    @Override // c9.c
    public void g(c9.i iVar) {
        this.f323a.g(iVar);
    }

    @Override // c9.c
    public int maxDataLength() {
        return this.f323a.maxDataLength();
    }

    @Override // c9.c
    public void o(int i10, c9.a aVar, byte[] bArr) {
        this.f323a.o(i10, aVar, bArr);
    }

    @Override // c9.c
    public void ping(boolean z10, int i10, int i11) {
        this.f323a.ping(z10, i10, i11);
    }

    @Override // c9.c
    public void windowUpdate(int i10, long j10) {
        this.f323a.windowUpdate(i10, j10);
    }
}
