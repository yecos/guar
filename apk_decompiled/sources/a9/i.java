package a9;

import a9.b;
import a9.f;
import a9.h;
import a9.j;
import a9.q;
import c9.b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.SettableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import d9.a;
import d9.b;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import okio.Timeout;
import y8.a0;
import y8.b0;
import y8.c0;
import y8.e1;
import y8.i0;
import y8.k1;
import y8.l1;
import y8.w0;
import z8.b1;
import z8.b2;
import z8.g2;
import z8.j1;
import z8.m2;
import z8.p0;
import z8.q0;
import z8.r;
import z8.s;
import z8.u0;
import z8.v;
import z8.v0;

/* loaded from: classes3.dex */
public class i implements v, b.a, q.d {
    public static final Map W = Q();
    public static final Logger X = Logger.getLogger(i.class.getName());
    public final SocketFactory A;
    public SSLSocketFactory B;
    public HostnameVerifier C;
    public Socket D;
    public int E;
    public final Deque F;
    public final b9.b G;
    public b1 H;
    public boolean I;
    public long J;
    public long K;
    public boolean L;
    public final Runnable M;
    public final int N;
    public final boolean O;
    public final m2 P;
    public final v0 Q;
    public c0.b R;
    public final b0 S;
    public int T;
    public Runnable U;
    public SettableFuture V;

    /* renamed from: a, reason: collision with root package name */
    public final InetSocketAddress f395a;

    /* renamed from: b, reason: collision with root package name */
    public final String f396b;

    /* renamed from: c, reason: collision with root package name */
    public final String f397c;

    /* renamed from: d, reason: collision with root package name */
    public final Random f398d;

    /* renamed from: e, reason: collision with root package name */
    public final Supplier f399e;

    /* renamed from: f, reason: collision with root package name */
    public final int f400f;

    /* renamed from: g, reason: collision with root package name */
    public final c9.j f401g;

    /* renamed from: h, reason: collision with root package name */
    public j1.a f402h;

    /* renamed from: i, reason: collision with root package name */
    public a9.b f403i;

    /* renamed from: j, reason: collision with root package name */
    public q f404j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f405k;

    /* renamed from: l, reason: collision with root package name */
    public final i0 f406l;

    /* renamed from: m, reason: collision with root package name */
    public int f407m;

    /* renamed from: n, reason: collision with root package name */
    public final Map f408n;

    /* renamed from: o, reason: collision with root package name */
    public final Executor f409o;

    /* renamed from: p, reason: collision with root package name */
    public final b2 f410p;

    /* renamed from: q, reason: collision with root package name */
    public final ScheduledExecutorService f411q;

    /* renamed from: r, reason: collision with root package name */
    public final int f412r;

    /* renamed from: s, reason: collision with root package name */
    public int f413s;

    /* renamed from: t, reason: collision with root package name */
    public e f414t;

    /* renamed from: u, reason: collision with root package name */
    public y8.a f415u;

    /* renamed from: v, reason: collision with root package name */
    public k1 f416v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f417w;

    /* renamed from: x, reason: collision with root package name */
    public u0 f418x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f419y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f420z;

    public class a extends v0 {
        public a() {
        }

        @Override // z8.v0
        public void b() {
            i.this.f402h.b(true);
        }

        @Override // z8.v0
        public void c() {
            i.this.f402h.b(false);
        }
    }

    public class b implements m2.c {
        public b() {
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f423a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a9.a f424b;

        public class a implements Source {
            public a() {
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // okio.Source
            public long read(Buffer buffer, long j10) {
                return -1L;
            }

            @Override // okio.Source
            public Timeout timeout() {
                return Timeout.NONE;
            }
        }

        public c(CountDownLatch countDownLatch, a9.a aVar) {
            this.f423a = countDownLatch;
            this.f424b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar;
            e eVar;
            Socket S;
            SSLSession sSLSession;
            Socket socket;
            try {
                this.f423a.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            BufferedSource buffer = Okio.buffer(new a());
            try {
                try {
                    i iVar2 = i.this;
                    b0 b0Var = iVar2.S;
                    if (b0Var == null) {
                        S = iVar2.A.createSocket(i.this.f395a.getAddress(), i.this.f395a.getPort());
                    } else {
                        if (!(b0Var.b() instanceof InetSocketAddress)) {
                            throw k1.f19903t.r("Unsupported SocketAddress implementation " + i.this.S.b().getClass()).c();
                        }
                        i iVar3 = i.this;
                        S = iVar3.S(iVar3.S.c(), (InetSocketAddress) i.this.S.b(), i.this.S.d(), i.this.S.a());
                    }
                    Socket socket2 = S;
                    if (i.this.B != null) {
                        SSLSocket b10 = n.b(i.this.B, i.this.C, socket2, i.this.W(), i.this.X(), i.this.G);
                        sSLSession = b10.getSession();
                        socket = b10;
                    } else {
                        sSLSession = null;
                        socket = socket2;
                    }
                    socket.setTcpNoDelay(true);
                    BufferedSource buffer2 = Okio.buffer(Okio.source(socket));
                    this.f424b.v(Okio.sink(socket), socket);
                    i iVar4 = i.this;
                    iVar4.f415u = iVar4.f415u.d().d(a0.f19776a, socket.getRemoteSocketAddress()).d(a0.f19777b, socket.getLocalSocketAddress()).d(a0.f19778c, sSLSession).d(p0.f20821a, sSLSession == null ? e1.NONE : e1.PRIVACY_AND_INTEGRITY).a();
                    i iVar5 = i.this;
                    iVar5.f414t = iVar5.new e(iVar5.f401g.a(buffer2, true));
                    synchronized (i.this.f405k) {
                        i.this.D = (Socket) Preconditions.checkNotNull(socket, "socket");
                        if (sSLSession != null) {
                            i.this.R = new c0.b(new c0.c(sSLSession));
                        }
                    }
                } catch (l1 e10) {
                    i.this.k0(0, c9.a.INTERNAL_ERROR, e10.a());
                    iVar = i.this;
                    eVar = iVar.new e(iVar.f401g.a(buffer, true));
                    iVar.f414t = eVar;
                } catch (Exception e11) {
                    i.this.h(e11);
                    iVar = i.this;
                    eVar = iVar.new e(iVar.f401g.a(buffer, true));
                    iVar.f414t = eVar;
                }
            } catch (Throwable th) {
                i iVar6 = i.this;
                iVar6.f414t = iVar6.new e(iVar6.f401g.a(buffer, true));
                throw th;
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = i.this.U;
            if (runnable != null) {
                runnable.run();
            }
            i.this.f409o.execute(i.this.f414t);
            synchronized (i.this.f405k) {
                i.this.E = Integer.MAX_VALUE;
                i.this.l0();
            }
            SettableFuture settableFuture = i.this.V;
            if (settableFuture != null) {
                settableFuture.set(null);
            }
        }
    }

    public class e implements b.a, Runnable {

        /* renamed from: b, reason: collision with root package name */
        public c9.b f429b;

        /* renamed from: a, reason: collision with root package name */
        public final j f428a = new j(Level.FINE, i.class);

        /* renamed from: c, reason: collision with root package name */
        public boolean f430c = true;

        public e(c9.b bVar) {
            this.f429b = bVar;
        }

        public final int a(List list) {
            long j10 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                c9.d dVar = (c9.d) list.get(i10);
                j10 += dVar.f5673a.size() + 32 + dVar.f5674b.size();
            }
            return (int) Math.min(j10, TTL.MAX_VALUE);
        }

        @Override // c9.b.a
        public void ackSettings() {
        }

        @Override // c9.b.a
        public void d(int i10, c9.a aVar) {
            this.f428a.h(j.a.INBOUND, i10, aVar);
            k1 f10 = i.p0(aVar).f("Rst Stream");
            boolean z10 = f10.n() == k1.b.CANCELLED || f10.n() == k1.b.DEADLINE_EXCEEDED;
            synchronized (i.this.f405k) {
                h hVar = (h) i.this.f408n.get(Integer.valueOf(i10));
                if (hVar != null) {
                    g9.c.c("OkHttpClientTransport$ClientFrameHandler.rstStream", hVar.t().h0());
                    i.this.U(i10, f10, aVar == c9.a.REFUSED_STREAM ? r.a.REFUSED : r.a.PROCESSED, z10, null, null);
                }
            }
        }

        @Override // c9.b.a
        public void data(boolean z10, int i10, BufferedSource bufferedSource, int i11) {
            this.f428a.b(j.a.INBOUND, i10, bufferedSource.getBuffer(), i11, z10);
            h Z = i.this.Z(i10);
            if (Z != null) {
                long j10 = i11;
                bufferedSource.require(j10);
                Buffer buffer = new Buffer();
                buffer.write(bufferedSource.getBuffer(), j10);
                g9.c.c("OkHttpClientTransport$ClientFrameHandler.data", Z.t().h0());
                synchronized (i.this.f405k) {
                    Z.t().i0(buffer, z10);
                }
            } else {
                if (!i.this.c0(i10)) {
                    i.this.f0(c9.a.PROTOCOL_ERROR, "Received data for unknown stream: " + i10);
                    return;
                }
                synchronized (i.this.f405k) {
                    i.this.f403i.d(i10, c9.a.STREAM_CLOSED);
                }
                bufferedSource.skip(i11);
            }
            i.D(i.this, i11);
            if (i.this.f413s >= i.this.f400f * 0.5f) {
                synchronized (i.this.f405k) {
                    i.this.f403i.windowUpdate(0, i.this.f413s);
                }
                i.this.f413s = 0;
            }
        }

        @Override // c9.b.a
        public void e(boolean z10, boolean z11, int i10, int i11, List list, c9.e eVar) {
            k1 k1Var;
            int a10;
            this.f428a.d(j.a.INBOUND, i10, list, z11);
            boolean z12 = true;
            if (i.this.N == Integer.MAX_VALUE || (a10 = a(list)) <= i.this.N) {
                k1Var = null;
            } else {
                k1 k1Var2 = k1.f19898o;
                Locale locale = Locale.US;
                Object[] objArr = new Object[3];
                objArr[0] = z11 ? "trailer" : "header";
                objArr[1] = Integer.valueOf(i.this.N);
                objArr[2] = Integer.valueOf(a10);
                k1Var = k1Var2.r(String.format(locale, "Response %s metadata larger than %d: %d", objArr));
            }
            synchronized (i.this.f405k) {
                h hVar = (h) i.this.f408n.get(Integer.valueOf(i10));
                if (hVar == null) {
                    if (i.this.c0(i10)) {
                        i.this.f403i.d(i10, c9.a.STREAM_CLOSED);
                    }
                } else if (k1Var == null) {
                    g9.c.c("OkHttpClientTransport$ClientFrameHandler.headers", hVar.t().h0());
                    hVar.t().j0(list, z11);
                } else {
                    if (!z11) {
                        i.this.f403i.d(i10, c9.a.CANCEL);
                    }
                    hVar.t().N(k1Var, false, new y8.v0());
                }
                z12 = false;
            }
            if (z12) {
                i.this.f0(c9.a.PROTOCOL_ERROR, "Received header for unknown stream: " + i10);
            }
        }

        @Override // c9.b.a
        public void f(int i10, c9.a aVar, ByteString byteString) {
            this.f428a.c(j.a.INBOUND, i10, aVar, byteString);
            if (aVar == c9.a.ENHANCE_YOUR_CALM) {
                String utf8 = byteString.utf8();
                i.X.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, utf8));
                if ("too_many_pings".equals(utf8)) {
                    i.this.M.run();
                }
            }
            k1 f10 = q0.h.e(aVar.f5663a).f("Received Goaway");
            if (byteString.size() > 0) {
                f10 = f10.f(byteString.utf8());
            }
            i.this.k0(i10, null, f10);
        }

        @Override // c9.b.a
        public void g(boolean z10, c9.i iVar) {
            boolean z11;
            this.f428a.i(j.a.INBOUND, iVar);
            synchronized (i.this.f405k) {
                if (m.b(iVar, 4)) {
                    i.this.E = m.a(iVar, 4);
                }
                if (m.b(iVar, 7)) {
                    z11 = i.this.f404j.f(m.a(iVar, 7));
                } else {
                    z11 = false;
                }
                if (this.f430c) {
                    i.this.f402h.a();
                    this.f430c = false;
                }
                i.this.f403i.g(iVar);
                if (z11) {
                    i.this.f404j.h();
                }
                i.this.l0();
            }
        }

        @Override // c9.b.a
        public void ping(boolean z10, int i10, int i11) {
            u0 u0Var;
            long j10 = (i10 << 32) | (i11 & 4294967295L);
            this.f428a.e(j.a.INBOUND, j10);
            if (!z10) {
                synchronized (i.this.f405k) {
                    i.this.f403i.ping(true, i10, i11);
                }
                return;
            }
            synchronized (i.this.f405k) {
                u0Var = null;
                if (i.this.f418x == null) {
                    i.X.warning("Received unexpected ping ack. No ping outstanding");
                } else if (i.this.f418x.h() == j10) {
                    u0 u0Var2 = i.this.f418x;
                    i.this.f418x = null;
                    u0Var = u0Var2;
                } else {
                    i.X.log(Level.WARNING, String.format(Locale.US, "Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(i.this.f418x.h()), Long.valueOf(j10)));
                }
            }
            if (u0Var != null) {
                u0Var.d();
            }
        }

        @Override // c9.b.a
        public void priority(int i10, int i11, int i12, boolean z10) {
        }

        @Override // c9.b.a
        public void pushPromise(int i10, int i11, List list) {
            this.f428a.g(j.a.INBOUND, i10, i11, list);
            synchronized (i.this.f405k) {
                i.this.f403i.d(i10, c9.a.PROTOCOL_ERROR);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            k1 k1Var;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.f429b.t(this)) {
                try {
                    if (i.this.H != null) {
                        i.this.H.l();
                    }
                } catch (Throwable th) {
                    try {
                        i.this.k0(0, c9.a.PROTOCOL_ERROR, k1.f19903t.r("error in frame handler").q(th));
                        try {
                            this.f429b.close();
                        } catch (IOException e10) {
                            e = e10;
                            i.X.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                            i.this.f402h.d();
                            Thread.currentThread().setName(name);
                        }
                    } catch (Throwable th2) {
                        try {
                            this.f429b.close();
                        } catch (IOException e11) {
                            i.X.log(Level.INFO, "Exception closing frame reader", (Throwable) e11);
                        }
                        i.this.f402h.d();
                        Thread.currentThread().setName(name);
                        throw th2;
                    }
                }
            }
            synchronized (i.this.f405k) {
                k1Var = i.this.f416v;
            }
            if (k1Var == null) {
                k1Var = k1.f19904u.r("End of stream or IOException");
            }
            i.this.k0(0, c9.a.INTERNAL_ERROR, k1Var);
            try {
                this.f429b.close();
            } catch (IOException e12) {
                e = e12;
                i.X.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                i.this.f402h.d();
                Thread.currentThread().setName(name);
            }
            i.this.f402h.d();
            Thread.currentThread().setName(name);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        @Override // c9.b.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void windowUpdate(int r8, long r9) {
            /*
                r7 = this;
                a9.j r0 = r7.f428a
                a9.j$a r1 = a9.j.a.INBOUND
                r0.k(r1, r8, r9)
                r0 = 0
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 != 0) goto L2c
                java.lang.String r9 = "Received 0 flow control window increment."
                if (r8 != 0) goto L19
                a9.i r8 = a9.i.this
                c9.a r10 = c9.a.PROTOCOL_ERROR
                a9.i.A(r8, r10, r9)
                goto L2b
            L19:
                a9.i r0 = a9.i.this
                y8.k1 r10 = y8.k1.f19903t
                y8.k1 r2 = r10.r(r9)
                z8.r$a r3 = z8.r.a.PROCESSED
                r4 = 0
                c9.a r5 = c9.a.PROTOCOL_ERROR
                r6 = 0
                r1 = r8
                r0.U(r1, r2, r3, r4, r5, r6)
            L2b:
                return
            L2c:
                a9.i r0 = a9.i.this
                java.lang.Object r0 = a9.i.j(r0)
                monitor-enter(r0)
                if (r8 != 0) goto L42
                a9.i r8 = a9.i.this     // Catch: java.lang.Throwable -> L8e
                a9.q r8 = a9.i.w(r8)     // Catch: java.lang.Throwable -> L8e
                r1 = 0
                int r10 = (int) r9     // Catch: java.lang.Throwable -> L8e
                r8.g(r1, r10)     // Catch: java.lang.Throwable -> L8e
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L8e
                return
            L42:
                a9.i r1 = a9.i.this     // Catch: java.lang.Throwable -> L8e
                java.util.Map r1 = a9.i.F(r1)     // Catch: java.lang.Throwable -> L8e
                java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L8e
                java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L8e
                a9.h r1 = (a9.h) r1     // Catch: java.lang.Throwable -> L8e
                if (r1 == 0) goto L67
                a9.i r2 = a9.i.this     // Catch: java.lang.Throwable -> L8e
                a9.q r2 = a9.i.w(r2)     // Catch: java.lang.Throwable -> L8e
                a9.h$b r1 = r1.t()     // Catch: java.lang.Throwable -> L8e
                a9.q$c r1 = r1.b0()     // Catch: java.lang.Throwable -> L8e
                int r10 = (int) r9     // Catch: java.lang.Throwable -> L8e
                r2.g(r1, r10)     // Catch: java.lang.Throwable -> L8e
                goto L71
            L67:
                a9.i r9 = a9.i.this     // Catch: java.lang.Throwable -> L8e
                boolean r9 = r9.c0(r8)     // Catch: java.lang.Throwable -> L8e
                if (r9 != 0) goto L71
                r9 = 1
                goto L72
            L71:
                r9 = 0
            L72:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L8e
                if (r9 == 0) goto L8d
                a9.i r9 = a9.i.this
                c9.a r10 = c9.a.PROTOCOL_ERROR
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Received window_update for unknown stream: "
                r0.append(r1)
                r0.append(r8)
                java.lang.String r8 = r0.toString()
                a9.i.A(r9, r10, r8)
            L8d:
                return
            L8e:
                r8 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L8e
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: a9.i.e.windowUpdate(int, long):void");
        }
    }

    public i(f.C0007f c0007f, InetSocketAddress inetSocketAddress, String str, String str2, y8.a aVar, b0 b0Var, Runnable runnable) {
        this(c0007f, inetSocketAddress, str, str2, aVar, q0.f20855w, new c9.g(), b0Var, runnable);
    }

    public static /* synthetic */ int D(i iVar, int i10) {
        int i11 = iVar.f413s + i10;
        iVar.f413s = i11;
        return i11;
    }

    public static Map Q() {
        EnumMap enumMap = new EnumMap(c9.a.class);
        c9.a aVar = c9.a.NO_ERROR;
        k1 k1Var = k1.f19903t;
        enumMap.put((EnumMap) aVar, (c9.a) k1Var.r("No error: A GRPC status of OK should have been sent"));
        enumMap.put((EnumMap) c9.a.PROTOCOL_ERROR, (c9.a) k1Var.r("Protocol error"));
        enumMap.put((EnumMap) c9.a.INTERNAL_ERROR, (c9.a) k1Var.r("Internal error"));
        enumMap.put((EnumMap) c9.a.FLOW_CONTROL_ERROR, (c9.a) k1Var.r("Flow control error"));
        enumMap.put((EnumMap) c9.a.STREAM_CLOSED, (c9.a) k1Var.r("Stream closed"));
        enumMap.put((EnumMap) c9.a.FRAME_TOO_LARGE, (c9.a) k1Var.r("Frame too large"));
        enumMap.put((EnumMap) c9.a.REFUSED_STREAM, (c9.a) k1.f19904u.r("Refused stream"));
        enumMap.put((EnumMap) c9.a.CANCEL, (c9.a) k1.f19890g.r("Cancelled"));
        enumMap.put((EnumMap) c9.a.COMPRESSION_ERROR, (c9.a) k1Var.r("Compression error"));
        enumMap.put((EnumMap) c9.a.CONNECT_ERROR, (c9.a) k1Var.r("Connect error"));
        enumMap.put((EnumMap) c9.a.ENHANCE_YOUR_CALM, (c9.a) k1.f19898o.r("Enhance your calm"));
        enumMap.put((EnumMap) c9.a.INADEQUATE_SECURITY, (c9.a) k1.f19896m.r("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    public static String g0(Source source) {
        Buffer buffer = new Buffer();
        while (source.read(buffer, 1L) != -1) {
            if (buffer.getByte(buffer.size() - 1) == 10) {
                return buffer.readUtf8LineStrict();
            }
        }
        throw new EOFException("\\n not found: " + buffer.readByteString().hex());
    }

    public static k1 p0(c9.a aVar) {
        k1 k1Var = (k1) W.get(aVar);
        if (k1Var != null) {
            return k1Var;
        }
        return k1.f19891h.r("Unknown http2 error code: " + aVar.f5663a);
    }

    public final d9.b R(InetSocketAddress inetSocketAddress, String str, String str2) {
        d9.a a10 = new a.b().k("https").h(inetSocketAddress.getHostName()).j(inetSocketAddress.getPort()).a();
        b.C0210b d10 = new b.C0210b().e(a10).d("Host", a10.c() + SOAP.DELIM + a10.f()).d("User-Agent", this.f397c);
        if (str != null && str2 != null) {
            d10.d(HttpHeaders.PROXY_AUTHORIZATION, b9.c.a(str, str2));
        }
        return d10.c();
    }

    public final Socket S(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) {
        Socket socket = null;
        try {
            socket = inetSocketAddress2.getAddress() != null ? this.A.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : this.A.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            socket.setTcpNoDelay(true);
            socket.setSoTimeout(this.T);
            Source source = Okio.source(socket);
            BufferedSink buffer = Okio.buffer(Okio.sink(socket));
            d9.b R = R(inetSocketAddress, str, str2);
            d9.a b10 = R.b();
            buffer.writeUtf8(String.format(Locale.US, "CONNECT %s:%d HTTP/1.1", b10.c(), Integer.valueOf(b10.f()))).writeUtf8("\r\n");
            int b11 = R.a().b();
            for (int i10 = 0; i10 < b11; i10++) {
                buffer.writeUtf8(R.a().a(i10)).writeUtf8(": ").writeUtf8(R.a().c(i10)).writeUtf8("\r\n");
            }
            buffer.writeUtf8("\r\n");
            buffer.flush();
            b9.j a10 = b9.j.a(g0(source));
            while (!g0(source).equals("")) {
            }
            int i11 = a10.f5202b;
            if (i11 >= 200 && i11 < 300) {
                socket.setSoTimeout(0);
                return socket;
            }
            Buffer buffer2 = new Buffer();
            try {
                socket.shutdownOutput();
                source.read(buffer2, 1024L);
            } catch (IOException e10) {
                buffer2.writeUtf8("Unable to read body: " + e10.toString());
            }
            try {
                socket.close();
            } catch (IOException unused) {
            }
            throw k1.f19904u.r(String.format(Locale.US, "Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(a10.f5202b), a10.f5203c, buffer2.readUtf8())).c();
        } catch (IOException e11) {
            if (socket != null) {
                q0.d(socket);
            }
            throw k1.f19904u.r("Failed trying to connect with proxy").q(e11).c();
        }
    }

    public void T(boolean z10, long j10, long j11, boolean z11) {
        this.I = z10;
        this.J = j10;
        this.K = j11;
        this.L = z11;
    }

    public void U(int i10, k1 k1Var, r.a aVar, boolean z10, c9.a aVar2, y8.v0 v0Var) {
        synchronized (this.f405k) {
            h hVar = (h) this.f408n.remove(Integer.valueOf(i10));
            if (hVar != null) {
                if (aVar2 != null) {
                    this.f403i.d(i10, c9.a.CANCEL);
                }
                if (k1Var != null) {
                    h.b t10 = hVar.t();
                    if (v0Var == null) {
                        v0Var = new y8.v0();
                    }
                    t10.M(k1Var, aVar, z10, v0Var);
                }
                if (!l0()) {
                    n0();
                    d0(hVar);
                }
            }
        }
    }

    public y8.a V() {
        return this.f415u;
    }

    public String W() {
        URI b10 = q0.b(this.f396b);
        return b10.getHost() != null ? b10.getHost() : this.f396b;
    }

    public int X() {
        URI b10 = q0.b(this.f396b);
        return b10.getPort() != -1 ? b10.getPort() : this.f395a.getPort();
    }

    public final Throwable Y() {
        synchronized (this.f405k) {
            k1 k1Var = this.f416v;
            if (k1Var != null) {
                return k1Var.c();
            }
            return k1.f19904u.r("Connection closed").c();
        }
    }

    public h Z(int i10) {
        h hVar;
        synchronized (this.f405k) {
            hVar = (h) this.f408n.get(Integer.valueOf(i10));
        }
        return hVar;
    }

    @Override // a9.q.d
    public q.c[] a() {
        q.c[] cVarArr;
        synchronized (this.f405k) {
            cVarArr = new q.c[this.f408n.size()];
            Iterator it = this.f408n.values().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                cVarArr[i10] = ((h) it.next()).t().b0();
                i10++;
            }
        }
        return cVarArr;
    }

    public final void a0() {
        synchronized (this.f405k) {
            this.P.g(new b());
        }
    }

    public boolean b0() {
        return this.B == null;
    }

    @Override // z8.j1
    public void c(k1 k1Var) {
        synchronized (this.f405k) {
            if (this.f416v != null) {
                return;
            }
            this.f416v = k1Var;
            this.f402h.c(k1Var);
            n0();
        }
    }

    public boolean c0(int i10) {
        boolean z10;
        synchronized (this.f405k) {
            if (i10 < this.f407m) {
                z10 = true;
                if ((i10 & 1) == 1) {
                }
            }
            z10 = false;
        }
        return z10;
    }

    @Override // y8.m0
    public i0 d() {
        return this.f406l;
    }

    public final void d0(h hVar) {
        if (this.f420z && this.F.isEmpty() && this.f408n.isEmpty()) {
            this.f420z = false;
            b1 b1Var = this.H;
            if (b1Var != null) {
                b1Var.n();
            }
        }
        if (hVar.x()) {
            this.Q.e(hVar, false);
        }
    }

    @Override // z8.j1
    public Runnable e(j1.a aVar) {
        this.f402h = (j1.a) Preconditions.checkNotNull(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.I) {
            b1 b1Var = new b1(new b1.c(this), this.f411q, this.J, this.K, this.L);
            this.H = b1Var;
            b1Var.o();
        }
        a9.a y10 = a9.a.y(this.f410p, this, 10000);
        c9.c x10 = y10.x(this.f401g.b(Okio.buffer(y10), true));
        synchronized (this.f405k) {
            a9.b bVar = new a9.b(this, x10);
            this.f403i = bVar;
            this.f404j = new q(this, bVar);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f410p.execute(new c(countDownLatch, y10));
        try {
            i0();
            countDownLatch.countDown();
            this.f410p.execute(new d());
            return null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    @Override // z8.s
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public h b(w0 w0Var, y8.v0 v0Var, y8.c cVar, y8.k[] kVarArr) {
        Preconditions.checkNotNull(w0Var, FirebaseAnalytics.Param.METHOD);
        Preconditions.checkNotNull(v0Var, "headers");
        g2 h10 = g2.h(kVarArr, V(), v0Var);
        synchronized (this.f405k) {
            try {
                try {
                    return new h(w0Var, v0Var, this.f403i, this, this.f404j, this.f405k, this.f412r, this.f400f, this.f396b, this.f397c, h10, this.P, cVar, this.O);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // z8.s
    public void f(s.a aVar, Executor executor) {
        long nextLong;
        synchronized (this.f405k) {
            boolean z10 = true;
            Preconditions.checkState(this.f403i != null);
            if (this.f419y) {
                u0.g(aVar, executor, Y());
                return;
            }
            u0 u0Var = this.f418x;
            if (u0Var != null) {
                nextLong = 0;
                z10 = false;
            } else {
                nextLong = this.f398d.nextLong();
                Stopwatch stopwatch = (Stopwatch) this.f399e.get();
                stopwatch.start();
                u0 u0Var2 = new u0(nextLong, stopwatch);
                this.f418x = u0Var2;
                this.P.b();
                u0Var = u0Var2;
            }
            if (z10) {
                this.f403i.ping(false, (int) (nextLong >>> 32), (int) nextLong);
            }
            u0Var.a(aVar, executor);
        }
    }

    public final void f0(c9.a aVar, String str) {
        k0(0, aVar, p0(aVar).f(str));
    }

    @Override // z8.j1
    public void g(k1 k1Var) {
        c(k1Var);
        synchronized (this.f405k) {
            Iterator it = this.f408n.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                it.remove();
                ((h) entry.getValue()).t().N(k1Var, false, new y8.v0());
                d0((h) entry.getValue());
            }
            for (h hVar : this.F) {
                hVar.t().M(k1Var, r.a.MISCARRIED, true, new y8.v0());
                d0(hVar);
            }
            this.F.clear();
            n0();
        }
    }

    @Override // a9.b.a
    public void h(Throwable th) {
        Preconditions.checkNotNull(th, "failureCause");
        k0(0, c9.a.INTERNAL_ERROR, k1.f19904u.q(th));
    }

    public void h0(h hVar) {
        this.F.remove(hVar);
        d0(hVar);
    }

    public final void i0() {
        synchronized (this.f405k) {
            this.f403i.connectionPreface();
            c9.i iVar = new c9.i();
            m.c(iVar, 7, this.f400f);
            this.f403i.F(iVar);
            if (this.f400f > 65535) {
                this.f403i.windowUpdate(0, r1 - Message.MAXLENGTH);
            }
        }
    }

    public final void j0(h hVar) {
        if (!this.f420z) {
            this.f420z = true;
            b1 b1Var = this.H;
            if (b1Var != null) {
                b1Var.m();
            }
        }
        if (hVar.x()) {
            this.Q.e(hVar, true);
        }
    }

    public final void k0(int i10, c9.a aVar, k1 k1Var) {
        synchronized (this.f405k) {
            if (this.f416v == null) {
                this.f416v = k1Var;
                this.f402h.c(k1Var);
            }
            if (aVar != null && !this.f417w) {
                this.f417w = true;
                this.f403i.o(0, aVar, new byte[0]);
            }
            Iterator it = this.f408n.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((Integer) entry.getKey()).intValue() > i10) {
                    it.remove();
                    ((h) entry.getValue()).t().M(k1Var, r.a.REFUSED, false, new y8.v0());
                    d0((h) entry.getValue());
                }
            }
            for (h hVar : this.F) {
                hVar.t().M(k1Var, r.a.MISCARRIED, true, new y8.v0());
                d0(hVar);
            }
            this.F.clear();
            n0();
        }
    }

    public final boolean l0() {
        boolean z10 = false;
        while (!this.F.isEmpty() && this.f408n.size() < this.E) {
            m0((h) this.F.poll());
            z10 = true;
        }
        return z10;
    }

    public final void m0(h hVar) {
        Preconditions.checkState(hVar.t().c0() == -1, "StreamId already assigned");
        this.f408n.put(Integer.valueOf(this.f407m), hVar);
        j0(hVar);
        hVar.t().f0(this.f407m);
        if ((hVar.L() != w0.d.UNARY && hVar.L() != w0.d.SERVER_STREAMING) || hVar.N()) {
            this.f403i.flush();
        }
        int i10 = this.f407m;
        if (i10 < 2147483645) {
            this.f407m = i10 + 2;
        } else {
            this.f407m = Integer.MAX_VALUE;
            k0(Integer.MAX_VALUE, c9.a.NO_ERROR, k1.f19904u.r("Stream ids exhausted"));
        }
    }

    public final void n0() {
        if (this.f416v == null || !this.f408n.isEmpty() || !this.F.isEmpty() || this.f419y) {
            return;
        }
        this.f419y = true;
        b1 b1Var = this.H;
        if (b1Var != null) {
            b1Var.p();
        }
        u0 u0Var = this.f418x;
        if (u0Var != null) {
            u0Var.f(Y());
            this.f418x = null;
        }
        if (!this.f417w) {
            this.f417w = true;
            this.f403i.o(0, c9.a.NO_ERROR, new byte[0]);
        }
        this.f403i.close();
    }

    public void o0(h hVar) {
        if (this.f416v != null) {
            hVar.t().M(this.f416v, r.a.MISCARRIED, true, new y8.v0());
        } else if (this.f408n.size() < this.E) {
            m0(hVar);
        } else {
            this.F.add(hVar);
            j0(hVar);
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.f406l.d()).add("address", this.f395a).toString();
    }

    public i(f.C0007f c0007f, InetSocketAddress inetSocketAddress, String str, String str2, y8.a aVar, Supplier supplier, c9.j jVar, b0 b0Var, Runnable runnable) {
        this.f398d = new Random();
        this.f405k = new Object();
        this.f408n = new HashMap();
        this.E = 0;
        this.F = new LinkedList();
        this.Q = new a();
        this.T = 30000;
        this.f395a = (InetSocketAddress) Preconditions.checkNotNull(inetSocketAddress, "address");
        this.f396b = str;
        this.f412r = c0007f.f371j;
        this.f400f = c0007f.f376o;
        this.f409o = (Executor) Preconditions.checkNotNull(c0007f.f363b, "executor");
        this.f410p = new b2(c0007f.f363b);
        this.f411q = (ScheduledExecutorService) Preconditions.checkNotNull(c0007f.f365d, "scheduledExecutorService");
        this.f407m = 3;
        SocketFactory socketFactory = c0007f.f367f;
        this.A = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        this.B = c0007f.f368g;
        this.C = c0007f.f369h;
        this.G = (b9.b) Preconditions.checkNotNull(c0007f.f370i, "connectionSpec");
        this.f399e = (Supplier) Preconditions.checkNotNull(supplier, "stopwatchFactory");
        this.f401g = (c9.j) Preconditions.checkNotNull(jVar, "variant");
        this.f397c = q0.g("okhttp", str2);
        this.S = b0Var;
        this.M = (Runnable) Preconditions.checkNotNull(runnable, "tooManyPingsRunnable");
        this.N = c0007f.f378q;
        this.P = c0007f.f366e.a();
        this.f406l = i0.a(getClass(), inetSocketAddress.toString());
        this.f415u = y8.a.c().d(p0.f20822b, aVar).a();
        this.O = c0007f.f379r;
        a0();
    }
}
