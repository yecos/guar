package z8;

import com.google.common.base.Preconditions;
import com.hpplay.component.protocol.mirror.AutoStrategy;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.DataFormatException;
import y8.l;
import z8.i2;

/* loaded from: classes3.dex */
public class k1 implements Closeable, y {

    /* renamed from: a, reason: collision with root package name */
    public b f20667a;

    /* renamed from: b, reason: collision with root package name */
    public int f20668b;

    /* renamed from: c, reason: collision with root package name */
    public final g2 f20669c;

    /* renamed from: d, reason: collision with root package name */
    public final m2 f20670d;

    /* renamed from: e, reason: collision with root package name */
    public y8.u f20671e;

    /* renamed from: f, reason: collision with root package name */
    public r0 f20672f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f20673g;

    /* renamed from: h, reason: collision with root package name */
    public int f20674h;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20677k;

    /* renamed from: l, reason: collision with root package name */
    public u f20678l;

    /* renamed from: n, reason: collision with root package name */
    public long f20680n;

    /* renamed from: q, reason: collision with root package name */
    public int f20683q;

    /* renamed from: i, reason: collision with root package name */
    public e f20675i = e.HEADER;

    /* renamed from: j, reason: collision with root package name */
    public int f20676j = 5;

    /* renamed from: m, reason: collision with root package name */
    public u f20679m = new u();

    /* renamed from: o, reason: collision with root package name */
    public boolean f20681o = false;

    /* renamed from: p, reason: collision with root package name */
    public int f20682p = -1;

    /* renamed from: r, reason: collision with root package name */
    public boolean f20684r = false;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f20685s = false;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20686a;

        static {
            int[] iArr = new int[e.values().length];
            f20686a = iArr;
            try {
                iArr[e.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20686a[e.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public interface b {
        void a(i2.a aVar);

        void c(int i10);

        void d(Throwable th);

        void e(boolean z10);
    }

    public static class c implements i2.a {

        /* renamed from: a, reason: collision with root package name */
        public InputStream f20687a;

        public /* synthetic */ c(InputStream inputStream, a aVar) {
            this(inputStream);
        }

        @Override // z8.i2.a
        public InputStream next() {
            InputStream inputStream = this.f20687a;
            this.f20687a = null;
            return inputStream;
        }

        public c(InputStream inputStream) {
            this.f20687a = inputStream;
        }
    }

    public enum e {
        HEADER,
        BODY
    }

    public k1(b bVar, y8.u uVar, int i10, g2 g2Var, m2 m2Var) {
        this.f20667a = (b) Preconditions.checkNotNull(bVar, "sink");
        this.f20671e = (y8.u) Preconditions.checkNotNull(uVar, "decompressor");
        this.f20668b = i10;
        this.f20669c = (g2) Preconditions.checkNotNull(g2Var, "statsTraceCtx");
        this.f20670d = (m2) Preconditions.checkNotNull(m2Var, "transportTracer");
    }

    public void E(b bVar) {
        this.f20667a = bVar;
    }

    public void I() {
        this.f20685s = true;
    }

    public final void a() {
        if (this.f20681o) {
            return;
        }
        this.f20681o = true;
        while (true) {
            try {
                if (this.f20685s || this.f20680n <= 0 || !y()) {
                    break;
                }
                int i10 = a.f20686a[this.f20675i.ordinal()];
                if (i10 == 1) {
                    x();
                } else {
                    if (i10 != 2) {
                        throw new AssertionError("Invalid state: " + this.f20675i);
                    }
                    v();
                    this.f20680n--;
                }
            } finally {
                this.f20681o = false;
            }
        }
        if (this.f20685s) {
            close();
            return;
        }
        if (this.f20684r && u()) {
            close();
        }
    }

    @Override // z8.y
    public void b(int i10) {
        Preconditions.checkArgument(i10 > 0, "numMessages must be > 0");
        if (isClosed()) {
            return;
        }
        this.f20680n += i10;
        a();
    }

    @Override // z8.y
    public void c(int i10) {
        this.f20668b = i10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, z8.y
    public void close() {
        if (isClosed()) {
            return;
        }
        u uVar = this.f20678l;
        boolean z10 = true;
        boolean z11 = uVar != null && uVar.h() > 0;
        try {
            r0 r0Var = this.f20672f;
            if (r0Var != null) {
                if (!z11 && !r0Var.x()) {
                    z10 = false;
                }
                this.f20672f.close();
                z11 = z10;
            }
            u uVar2 = this.f20679m;
            if (uVar2 != null) {
                uVar2.close();
            }
            u uVar3 = this.f20678l;
            if (uVar3 != null) {
                uVar3.close();
            }
            this.f20672f = null;
            this.f20679m = null;
            this.f20678l = null;
            this.f20667a.e(z11);
        } catch (Throwable th) {
            this.f20672f = null;
            this.f20679m = null;
            this.f20678l = null;
            throw th;
        }
    }

    @Override // z8.y
    public void e(y8.u uVar) {
        Preconditions.checkState(this.f20672f == null, "Already set full stream decompressor");
        this.f20671e = (y8.u) Preconditions.checkNotNull(uVar, "Can't pass an empty decompressor");
    }

    @Override // z8.y
    public void f(t1 t1Var) {
        Preconditions.checkNotNull(t1Var, "data");
        boolean z10 = true;
        try {
            if (!s()) {
                r0 r0Var = this.f20672f;
                if (r0Var != null) {
                    r0Var.q(t1Var);
                } else {
                    this.f20679m.b(t1Var);
                }
                z10 = false;
                a();
            }
        } finally {
            if (z10) {
                t1Var.close();
            }
        }
    }

    public boolean isClosed() {
        return this.f20679m == null && this.f20672f == null;
    }

    @Override // z8.y
    public void m() {
        if (isClosed()) {
            return;
        }
        if (u()) {
            close();
        } else {
            this.f20684r = true;
        }
    }

    public final InputStream n() {
        y8.u uVar = this.f20671e;
        if (uVar == l.b.f19933a) {
            throw y8.k1.f19903t.r("Can't decode compressed gRPC message as compression not configured").d();
        }
        try {
            return new d(uVar.decompress(u1.c(this.f20678l, true)), this.f20668b, this.f20669c);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final InputStream q() {
        this.f20669c.f(this.f20678l.h());
        return u1.c(this.f20678l, true);
    }

    public final boolean s() {
        return isClosed() || this.f20684r;
    }

    public final boolean u() {
        r0 r0Var = this.f20672f;
        return r0Var != null ? r0Var.I() : this.f20679m.h() == 0;
    }

    public final void v() {
        this.f20669c.e(this.f20682p, this.f20683q, -1L);
        this.f20683q = 0;
        InputStream n10 = this.f20677k ? n() : q();
        this.f20678l = null;
        this.f20667a.a(new c(n10, null));
        this.f20675i = e.HEADER;
        this.f20676j = 5;
    }

    public final void x() {
        int readUnsignedByte = this.f20678l.readUnsignedByte();
        if ((readUnsignedByte & 254) != 0) {
            throw y8.k1.f19903t.r("gRPC frame header malformed: reserved bits not zero").d();
        }
        this.f20677k = (readUnsignedByte & 1) != 0;
        int readInt = this.f20678l.readInt();
        this.f20676j = readInt;
        if (readInt < 0 || readInt > this.f20668b) {
            throw y8.k1.f19898o.r(String.format(Locale.US, "gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.f20668b), Integer.valueOf(this.f20676j))).d();
        }
        int i10 = this.f20682p + 1;
        this.f20682p = i10;
        this.f20669c.d(i10);
        this.f20670d.d();
        this.f20675i = e.BODY;
    }

    public final boolean y() {
        int i10;
        int i11 = 0;
        try {
            if (this.f20678l == null) {
                this.f20678l = new u();
            }
            int i12 = 0;
            i10 = 0;
            while (true) {
                try {
                    int h10 = this.f20676j - this.f20678l.h();
                    if (h10 <= 0) {
                        if (i12 <= 0) {
                            return true;
                        }
                        this.f20667a.c(i12);
                        if (this.f20675i != e.BODY) {
                            return true;
                        }
                        if (this.f20672f != null) {
                            this.f20669c.g(i10);
                            this.f20683q += i10;
                            return true;
                        }
                        this.f20669c.g(i12);
                        this.f20683q += i12;
                        return true;
                    }
                    if (this.f20672f != null) {
                        try {
                            byte[] bArr = this.f20673g;
                            if (bArr == null || this.f20674h == bArr.length) {
                                this.f20673g = new byte[Math.min(h10, AutoStrategy.BITRATE_LOW4)];
                                this.f20674h = 0;
                            }
                            int z10 = this.f20672f.z(this.f20673g, this.f20674h, Math.min(h10, this.f20673g.length - this.f20674h));
                            i12 += this.f20672f.u();
                            i10 += this.f20672f.v();
                            if (z10 == 0) {
                                if (i12 > 0) {
                                    this.f20667a.c(i12);
                                    if (this.f20675i == e.BODY) {
                                        if (this.f20672f != null) {
                                            this.f20669c.g(i10);
                                            this.f20683q += i10;
                                        } else {
                                            this.f20669c.g(i12);
                                            this.f20683q += i12;
                                        }
                                    }
                                }
                                return false;
                            }
                            this.f20678l.b(u1.f(this.f20673g, this.f20674h, z10));
                            this.f20674h += z10;
                        } catch (IOException e10) {
                            throw new RuntimeException(e10);
                        } catch (DataFormatException e11) {
                            throw new RuntimeException(e11);
                        }
                    } else {
                        if (this.f20679m.h() == 0) {
                            if (i12 > 0) {
                                this.f20667a.c(i12);
                                if (this.f20675i == e.BODY) {
                                    if (this.f20672f != null) {
                                        this.f20669c.g(i10);
                                        this.f20683q += i10;
                                    } else {
                                        this.f20669c.g(i12);
                                        this.f20683q += i12;
                                    }
                                }
                            }
                            return false;
                        }
                        int min = Math.min(h10, this.f20679m.h());
                        i12 += min;
                        this.f20678l.b(this.f20679m.j(min));
                    }
                } catch (Throwable th) {
                    int i13 = i12;
                    th = th;
                    i11 = i13;
                    if (i11 > 0) {
                        this.f20667a.c(i11);
                        if (this.f20675i == e.BODY) {
                            if (this.f20672f != null) {
                                this.f20669c.g(i10);
                                this.f20683q += i10;
                            } else {
                                this.f20669c.g(i11);
                                this.f20683q += i11;
                            }
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            i10 = 0;
        }
    }

    public void z(r0 r0Var) {
        Preconditions.checkState(this.f20671e == l.b.f19933a, "per-message decompressor already set");
        Preconditions.checkState(this.f20672f == null, "full stream decompressor already set");
        this.f20672f = (r0) Preconditions.checkNotNull(r0Var, "Can't pass a null full stream decompressor");
        this.f20679m = null;
    }

    public static final class d extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        public final int f20688a;

        /* renamed from: b, reason: collision with root package name */
        public final g2 f20689b;

        /* renamed from: c, reason: collision with root package name */
        public long f20690c;

        /* renamed from: d, reason: collision with root package name */
        public long f20691d;

        /* renamed from: e, reason: collision with root package name */
        public long f20692e;

        public d(InputStream inputStream, int i10, g2 g2Var) {
            super(inputStream);
            this.f20692e = -1L;
            this.f20688a = i10;
            this.f20689b = g2Var;
        }

        public final void a() {
            long j10 = this.f20691d;
            long j11 = this.f20690c;
            if (j10 > j11) {
                this.f20689b.f(j10 - j11);
                this.f20690c = this.f20691d;
            }
        }

        public final void b() {
            if (this.f20691d <= this.f20688a) {
                return;
            }
            throw y8.k1.f19898o.r("Decompressed gRPC message exceeds maximum size " + this.f20688a).d();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i10) {
            ((FilterInputStream) this).in.mark(i10);
            this.f20692e = this.f20691d;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.f20691d++;
            }
            b();
            a();
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f20692e == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f20691d = this.f20692e;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j10) {
            long skip = ((FilterInputStream) this).in.skip(j10);
            this.f20691d += skip;
            b();
            a();
            return skip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            int read = ((FilterInputStream) this).in.read(bArr, i10, i11);
            if (read != -1) {
                this.f20691d += read;
            }
            b();
            a();
            return read;
        }
    }
}
