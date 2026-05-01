package z8;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import y8.l;

/* loaded from: classes3.dex */
public class l1 implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final d f20714a;

    /* renamed from: c, reason: collision with root package name */
    public n2 f20716c;

    /* renamed from: h, reason: collision with root package name */
    public final o2 f20721h;

    /* renamed from: i, reason: collision with root package name */
    public final g2 f20722i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20723j;

    /* renamed from: k, reason: collision with root package name */
    public int f20724k;

    /* renamed from: m, reason: collision with root package name */
    public long f20726m;

    /* renamed from: b, reason: collision with root package name */
    public int f20715b = -1;

    /* renamed from: d, reason: collision with root package name */
    public y8.n f20717d = l.b.f19933a;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20718e = true;

    /* renamed from: f, reason: collision with root package name */
    public final c f20719f = new c();

    /* renamed from: g, reason: collision with root package name */
    public final ByteBuffer f20720g = ByteBuffer.allocate(5);

    /* renamed from: l, reason: collision with root package name */
    public int f20725l = -1;

    public class c extends OutputStream {
        public c() {
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            write(new byte[]{(byte) i10}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            l1.this.n(bArr, i10, i11);
        }
    }

    public interface d {
        void f(n2 n2Var, boolean z10, boolean z11, int i10);
    }

    public l1(d dVar, o2 o2Var, g2 g2Var) {
        this.f20714a = (d) Preconditions.checkNotNull(dVar, "sink");
        this.f20721h = (o2) Preconditions.checkNotNull(o2Var, "bufferAllocator");
        this.f20722i = (g2) Preconditions.checkNotNull(g2Var, "statsTraceCtx");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int o(InputStream inputStream, OutputStream outputStream) {
        if (inputStream instanceof y8.w) {
            return ((y8.w) inputStream).a(outputStream);
        }
        long copy = ByteStreams.copy(inputStream, outputStream);
        Preconditions.checkArgument(copy <= TTL.MAX_VALUE, "Message size overflow: %s", copy);
        return (int) copy;
    }

    @Override // z8.o0
    public void b(InputStream inputStream) {
        j();
        this.f20724k++;
        int i10 = this.f20725l + 1;
        this.f20725l = i10;
        this.f20726m = 0L;
        this.f20722i.i(i10);
        boolean z10 = this.f20718e && this.f20717d != l.b.f19933a;
        try {
            int g10 = g(inputStream);
            int p10 = (g10 == 0 || !z10) ? p(inputStream, g10) : l(inputStream, g10);
            if (g10 != -1 && p10 != g10) {
                throw y8.k1.f19903t.r(String.format("Message length inaccurate %s != %s", Integer.valueOf(p10), Integer.valueOf(g10))).d();
            }
            long j10 = p10;
            this.f20722i.k(j10);
            this.f20722i.l(this.f20726m);
            this.f20722i.j(this.f20725l, this.f20726m, j10);
        } catch (IOException e10) {
            throw y8.k1.f19903t.r("Failed to frame message").q(e10).d();
        } catch (RuntimeException e11) {
            throw y8.k1.f19903t.r("Failed to frame message").q(e11).d();
        }
    }

    @Override // z8.o0
    public void close() {
        if (isClosed()) {
            return;
        }
        this.f20723j = true;
        n2 n2Var = this.f20716c;
        if (n2Var != null && n2Var.h() == 0) {
            h();
        }
        f(true, true);
    }

    @Override // z8.o0
    public void d(int i10) {
        Preconditions.checkState(this.f20715b == -1, "max size already set");
        this.f20715b = i10;
    }

    public final void f(boolean z10, boolean z11) {
        n2 n2Var = this.f20716c;
        this.f20716c = null;
        this.f20714a.f(n2Var, z10, z11, this.f20724k);
        this.f20724k = 0;
    }

    @Override // z8.o0
    public void flush() {
        n2 n2Var = this.f20716c;
        if (n2Var == null || n2Var.h() <= 0) {
            return;
        }
        f(false, true);
    }

    public final int g(InputStream inputStream) {
        if ((inputStream instanceof y8.n0) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    public final void h() {
        n2 n2Var = this.f20716c;
        if (n2Var != null) {
            n2Var.release();
            this.f20716c = null;
        }
    }

    @Override // z8.o0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public l1 a(y8.n nVar) {
        this.f20717d = (y8.n) Preconditions.checkNotNull(nVar, "Can't pass an empty compressor");
        return this;
    }

    @Override // z8.o0
    public boolean isClosed() {
        return this.f20723j;
    }

    public final void j() {
        if (isClosed()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    public final void k(b bVar, boolean z10) {
        int h10 = bVar.h();
        this.f20720g.clear();
        this.f20720g.put(z10 ? (byte) 1 : (byte) 0).putInt(h10);
        n2 a10 = this.f20721h.a(5);
        a10.write(this.f20720g.array(), 0, this.f20720g.position());
        if (h10 == 0) {
            this.f20716c = a10;
            return;
        }
        this.f20714a.f(a10, false, false, this.f20724k - 1);
        this.f20724k = 1;
        List list = bVar.f20727a;
        for (int i10 = 0; i10 < list.size() - 1; i10++) {
            this.f20714a.f((n2) list.get(i10), false, false, 0);
        }
        this.f20716c = (n2) list.get(list.size() - 1);
        this.f20726m = h10;
    }

    public final int l(InputStream inputStream, int i10) {
        b bVar = new b();
        OutputStream compress = this.f20717d.compress(bVar);
        try {
            int o10 = o(inputStream, compress);
            compress.close();
            int i11 = this.f20715b;
            if (i11 >= 0 && o10 > i11) {
                throw y8.k1.f19898o.r(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(o10), Integer.valueOf(this.f20715b))).d();
            }
            k(bVar, true);
            return o10;
        } catch (Throwable th) {
            compress.close();
            throw th;
        }
    }

    public final int m(InputStream inputStream, int i10) {
        int i11 = this.f20715b;
        if (i11 >= 0 && i10 > i11) {
            throw y8.k1.f19898o.r(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(i10), Integer.valueOf(this.f20715b))).d();
        }
        this.f20720g.clear();
        this.f20720g.put((byte) 0).putInt(i10);
        if (this.f20716c == null) {
            this.f20716c = this.f20721h.a(this.f20720g.position() + i10);
        }
        n(this.f20720g.array(), 0, this.f20720g.position());
        return o(inputStream, this.f20719f);
    }

    public final void n(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            n2 n2Var = this.f20716c;
            if (n2Var != null && n2Var.a() == 0) {
                f(false, false);
            }
            if (this.f20716c == null) {
                this.f20716c = this.f20721h.a(i11);
            }
            int min = Math.min(i11, this.f20716c.a());
            this.f20716c.write(bArr, i10, min);
            i10 += min;
            i11 -= min;
        }
    }

    public final int p(InputStream inputStream, int i10) {
        if (i10 != -1) {
            this.f20726m = i10;
            return m(inputStream, i10);
        }
        b bVar = new b();
        int o10 = o(inputStream, bVar);
        int i11 = this.f20715b;
        if (i11 >= 0 && o10 > i11) {
            throw y8.k1.f19898o.r(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(o10), Integer.valueOf(this.f20715b))).d();
        }
        k(bVar, false);
        return o10;
    }

    public final class b extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        public final List f20727a;

        /* renamed from: b, reason: collision with root package name */
        public n2 f20728b;

        public b() {
            this.f20727a = new ArrayList();
        }

        public final int h() {
            Iterator it = this.f20727a.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                i10 += ((n2) it.next()).h();
            }
            return i10;
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            n2 n2Var = this.f20728b;
            if (n2Var == null || n2Var.a() <= 0) {
                write(new byte[]{(byte) i10}, 0, 1);
            } else {
                this.f20728b.b((byte) i10);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            if (this.f20728b == null) {
                n2 a10 = l1.this.f20721h.a(i11);
                this.f20728b = a10;
                this.f20727a.add(a10);
            }
            while (i11 > 0) {
                int min = Math.min(i11, this.f20728b.a());
                if (min == 0) {
                    n2 a11 = l1.this.f20721h.a(Math.max(i11, this.f20728b.h() * 2));
                    this.f20728b = a11;
                    this.f20727a.add(a11);
                } else {
                    this.f20728b.write(bArr, i10, min);
                    i10 += min;
                    i11 -= min;
                }
            }
        }
    }
}
