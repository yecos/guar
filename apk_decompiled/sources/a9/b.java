package a9;

import a9.j;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.ByteString;

/* loaded from: classes3.dex */
public final class b implements c9.c {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f319d = Logger.getLogger(i.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final a f320a;

    /* renamed from: b, reason: collision with root package name */
    public final c9.c f321b;

    /* renamed from: c, reason: collision with root package name */
    public final j f322c = new j(Level.FINE, i.class);

    public interface a {
        void h(Throwable th);
    }

    public b(a aVar, c9.c cVar) {
        this.f320a = (a) Preconditions.checkNotNull(aVar, "transportExceptionHandler");
        this.f321b = (c9.c) Preconditions.checkNotNull(cVar, "frameWriter");
    }

    public static Level a(Throwable th) {
        return th.getClass().equals(IOException.class) ? Level.FINE : Level.INFO;
    }

    @Override // c9.c
    public void F(c9.i iVar) {
        this.f322c.i(j.a.OUTBOUND, iVar);
        try {
            this.f321b.F(iVar);
        } catch (IOException e10) {
            this.f320a.h(e10);
        }
    }

    @Override // c9.c
    public void K(boolean z10, boolean z11, int i10, int i11, List list) {
        try {
            this.f321b.K(z10, z11, i10, i11, list);
        } catch (IOException e10) {
            this.f320a.h(e10);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f321b.close();
        } catch (IOException e10) {
            f319d.log(a(e10), "Failed closing connection", (Throwable) e10);
        }
    }

    @Override // c9.c
    public void connectionPreface() {
        try {
            this.f321b.connectionPreface();
        } catch (IOException e10) {
            this.f320a.h(e10);
        }
    }

    @Override // c9.c
    public void d(int i10, c9.a aVar) {
        this.f322c.h(j.a.OUTBOUND, i10, aVar);
        try {
            this.f321b.d(i10, aVar);
        } catch (IOException e10) {
            this.f320a.h(e10);
        }
    }

    @Override // c9.c
    public void data(boolean z10, int i10, Buffer buffer, int i11) {
        this.f322c.b(j.a.OUTBOUND, i10, buffer.buffer(), i11, z10);
        try {
            this.f321b.data(z10, i10, buffer, i11);
        } catch (IOException e10) {
            this.f320a.h(e10);
        }
    }

    @Override // c9.c
    public void flush() {
        try {
            this.f321b.flush();
        } catch (IOException e10) {
            this.f320a.h(e10);
        }
    }

    @Override // c9.c
    public void g(c9.i iVar) {
        this.f322c.j(j.a.OUTBOUND);
        try {
            this.f321b.g(iVar);
        } catch (IOException e10) {
            this.f320a.h(e10);
        }
    }

    @Override // c9.c
    public int maxDataLength() {
        return this.f321b.maxDataLength();
    }

    @Override // c9.c
    public void o(int i10, c9.a aVar, byte[] bArr) {
        this.f322c.c(j.a.OUTBOUND, i10, aVar, ByteString.of(bArr));
        try {
            this.f321b.o(i10, aVar, bArr);
            this.f321b.flush();
        } catch (IOException e10) {
            this.f320a.h(e10);
        }
    }

    @Override // c9.c
    public void ping(boolean z10, int i10, int i11) {
        if (z10) {
            this.f322c.f(j.a.OUTBOUND, (4294967295L & i11) | (i10 << 32));
        } else {
            this.f322c.e(j.a.OUTBOUND, (4294967295L & i11) | (i10 << 32));
        }
        try {
            this.f321b.ping(z10, i10, i11);
        } catch (IOException e10) {
            this.f320a.h(e10);
        }
    }

    @Override // c9.c
    public void windowUpdate(int i10, long j10) {
        this.f322c.k(j.a.OUTBOUND, i10, j10);
        try {
            this.f321b.windowUpdate(i10, j10);
        } catch (IOException e10) {
            this.f320a.h(e10);
        }
    }
}
