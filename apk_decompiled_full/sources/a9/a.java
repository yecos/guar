package a9;

import a9.b;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.net.Socket;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;
import z8.b2;

/* loaded from: classes3.dex */
public final class a implements Sink {

    /* renamed from: c, reason: collision with root package name */
    public final b2 f301c;

    /* renamed from: d, reason: collision with root package name */
    public final b.a f302d;

    /* renamed from: e, reason: collision with root package name */
    public final int f303e;

    /* renamed from: i, reason: collision with root package name */
    public Sink f307i;

    /* renamed from: j, reason: collision with root package name */
    public Socket f308j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f309k;

    /* renamed from: l, reason: collision with root package name */
    public int f310l;

    /* renamed from: m, reason: collision with root package name */
    public int f311m;

    /* renamed from: a, reason: collision with root package name */
    public final Object f299a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Buffer f300b = new Buffer();

    /* renamed from: f, reason: collision with root package name */
    public boolean f304f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f305g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f306h = false;

    /* renamed from: a9.a$a, reason: collision with other inner class name */
    public class C0006a extends e {

        /* renamed from: b, reason: collision with root package name */
        public final g9.b f312b;

        public C0006a() {
            super(a.this, null);
            this.f312b = g9.c.e();
        }

        @Override // a9.a.e
        public void a() {
            int i10;
            g9.c.f("WriteRunnable.runWrite");
            g9.c.d(this.f312b);
            Buffer buffer = new Buffer();
            try {
                synchronized (a.this.f299a) {
                    buffer.write(a.this.f300b, a.this.f300b.completeSegmentByteCount());
                    a.this.f304f = false;
                    i10 = a.this.f311m;
                }
                a.this.f307i.write(buffer, buffer.size());
                synchronized (a.this.f299a) {
                    a.f(a.this, i10);
                }
            } finally {
                g9.c.h("WriteRunnable.runWrite");
            }
        }
    }

    public class b extends e {

        /* renamed from: b, reason: collision with root package name */
        public final g9.b f314b;

        public b() {
            super(a.this, null);
            this.f314b = g9.c.e();
        }

        @Override // a9.a.e
        public void a() {
            g9.c.f("WriteRunnable.runFlush");
            g9.c.d(this.f314b);
            Buffer buffer = new Buffer();
            try {
                synchronized (a.this.f299a) {
                    buffer.write(a.this.f300b, a.this.f300b.size());
                    a.this.f305g = false;
                }
                a.this.f307i.write(buffer, buffer.size());
                a.this.f307i.flush();
            } finally {
                g9.c.h("WriteRunnable.runFlush");
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.f307i != null && a.this.f300b.size() > 0) {
                    a.this.f307i.write(a.this.f300b, a.this.f300b.size());
                }
            } catch (IOException e10) {
                a.this.f302d.h(e10);
            }
            a.this.f300b.close();
            try {
                if (a.this.f307i != null) {
                    a.this.f307i.close();
                }
            } catch (IOException e11) {
                a.this.f302d.h(e11);
            }
            try {
                if (a.this.f308j != null) {
                    a.this.f308j.close();
                }
            } catch (IOException e12) {
                a.this.f302d.h(e12);
            }
        }
    }

    public class d extends a9.c {
        public d(c9.c cVar) {
            super(cVar);
        }

        @Override // a9.c, c9.c
        public void d(int i10, c9.a aVar) {
            a.u(a.this);
            super.d(i10, aVar);
        }

        @Override // a9.c, c9.c
        public void g(c9.i iVar) {
            a.u(a.this);
            super.g(iVar);
        }

        @Override // a9.c, c9.c
        public void ping(boolean z10, int i10, int i11) {
            if (z10) {
                a.u(a.this);
            }
            super.ping(z10, i10, i11);
        }
    }

    public abstract class e implements Runnable {
        public e() {
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (a.this.f307i == null) {
                    throw new IOException("Unable to perform write due to unavailable sink.");
                }
                a();
            } catch (Exception e10) {
                a.this.f302d.h(e10);
            }
        }

        public /* synthetic */ e(a aVar, C0006a c0006a) {
            this();
        }
    }

    public a(b2 b2Var, b.a aVar, int i10) {
        this.f301c = (b2) Preconditions.checkNotNull(b2Var, "executor");
        this.f302d = (b.a) Preconditions.checkNotNull(aVar, "exceptionHandler");
        this.f303e = i10;
    }

    public static /* synthetic */ int f(a aVar, int i10) {
        int i11 = aVar.f311m - i10;
        aVar.f311m = i11;
        return i11;
    }

    public static /* synthetic */ int u(a aVar) {
        int i10 = aVar.f310l;
        aVar.f310l = i10 + 1;
        return i10;
    }

    public static a y(b2 b2Var, b.a aVar, int i10) {
        return new a(b2Var, aVar, i10);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f306h) {
            return;
        }
        this.f306h = true;
        this.f301c.execute(new c());
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        if (this.f306h) {
            throw new IOException("closed");
        }
        g9.c.f("AsyncSink.flush");
        try {
            synchronized (this.f299a) {
                if (this.f305g) {
                    return;
                }
                this.f305g = true;
                this.f301c.execute(new b());
            }
        } finally {
            g9.c.h("AsyncSink.flush");
        }
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void v(Sink sink, Socket socket) {
        Preconditions.checkState(this.f307i == null, "AsyncSink's becomeConnected should only be called once.");
        this.f307i = (Sink) Preconditions.checkNotNull(sink, "sink");
        this.f308j = (Socket) Preconditions.checkNotNull(socket, "socket");
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j10) {
        Preconditions.checkNotNull(buffer, "source");
        if (this.f306h) {
            throw new IOException("closed");
        }
        g9.c.f("AsyncSink.write");
        try {
            synchronized (this.f299a) {
                this.f300b.write(buffer, j10);
                int i10 = this.f311m + this.f310l;
                this.f311m = i10;
                boolean z10 = false;
                this.f310l = 0;
                if (this.f309k || i10 <= this.f303e) {
                    if (!this.f304f && !this.f305g && this.f300b.completeSegmentByteCount() > 0) {
                        this.f304f = true;
                    }
                }
                this.f309k = true;
                z10 = true;
                if (!z10) {
                    this.f301c.execute(new C0006a());
                    return;
                }
                try {
                    this.f308j.close();
                } catch (IOException e10) {
                    this.f302d.h(e10);
                }
            }
        } finally {
            g9.c.h("AsyncSink.write");
        }
    }

    public c9.c x(c9.c cVar) {
        return new d(cVar);
    }
}
