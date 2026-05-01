package a9;

import b9.b;
import com.google.common.base.Preconditions;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.UPushNotificationChannel;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import y8.q1;
import y8.s0;
import z8.d2;
import z8.e2;
import z8.g1;
import z8.h;
import z8.m2;
import z8.o1;
import z8.q0;
import z8.t;
import z8.v;

/* loaded from: classes3.dex */
public final class f extends z8.b {

    /* renamed from: r, reason: collision with root package name */
    public static final Logger f333r = Logger.getLogger(f.class.getName());

    /* renamed from: s, reason: collision with root package name */
    public static final b9.b f334s = new b.C0075b(b9.b.f5145f).f(b9.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, b9.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, b9.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, b9.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, b9.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, b9.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256).i(b9.k.TLS_1_2).h(true).e();

    /* renamed from: t, reason: collision with root package name */
    public static final long f335t = TimeUnit.DAYS.toNanos(1000);

    /* renamed from: u, reason: collision with root package name */
    public static final d2.d f336u;

    /* renamed from: v, reason: collision with root package name */
    public static final o1 f337v;

    /* renamed from: w, reason: collision with root package name */
    public static final EnumSet f338w;

    /* renamed from: b, reason: collision with root package name */
    public final g1 f339b;

    /* renamed from: f, reason: collision with root package name */
    public SocketFactory f343f;

    /* renamed from: g, reason: collision with root package name */
    public SSLSocketFactory f344g;

    /* renamed from: i, reason: collision with root package name */
    public HostnameVerifier f346i;

    /* renamed from: o, reason: collision with root package name */
    public boolean f352o;

    /* renamed from: c, reason: collision with root package name */
    public m2.b f340c = m2.a();

    /* renamed from: d, reason: collision with root package name */
    public o1 f341d = f337v;

    /* renamed from: e, reason: collision with root package name */
    public o1 f342e = e2.c(q0.f20854v);

    /* renamed from: j, reason: collision with root package name */
    public b9.b f347j = f334s;

    /* renamed from: k, reason: collision with root package name */
    public c f348k = c.TLS;

    /* renamed from: l, reason: collision with root package name */
    public long f349l = Long.MAX_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public long f350m = q0.f20846n;

    /* renamed from: n, reason: collision with root package name */
    public int f351n = Message.MAXLENGTH;

    /* renamed from: p, reason: collision with root package name */
    public int f353p = Integer.MAX_VALUE;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f354q = false;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f345h = false;

    public class a implements d2.d {
        @Override // z8.d2.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void close(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // z8.d2.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Executor create() {
            return Executors.newCachedThreadPool(q0.i("grpc-okhttp-%d", true));
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f356b;

        static {
            int[] iArr = new int[c.values().length];
            f356b = iArr;
            try {
                iArr[c.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f356b[c.TLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[a9.e.values().length];
            f355a = iArr2;
            try {
                iArr2[a9.e.TLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f355a[a9.e.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum c {
        TLS,
        PLAINTEXT
    }

    public final class d implements g1.b {
        public d() {
        }

        @Override // z8.g1.b
        public int a() {
            return f.this.g();
        }

        public /* synthetic */ d(f fVar, a aVar) {
            this();
        }
    }

    public final class e implements g1.c {
        public e() {
        }

        @Override // z8.g1.c
        public t a() {
            return f.this.d();
        }

        public /* synthetic */ e(f fVar, a aVar) {
            this();
        }
    }

    /* renamed from: a9.f$f, reason: collision with other inner class name */
    public static final class C0007f implements t {

        /* renamed from: a, reason: collision with root package name */
        public final o1 f362a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f363b;

        /* renamed from: c, reason: collision with root package name */
        public final o1 f364c;

        /* renamed from: d, reason: collision with root package name */
        public final ScheduledExecutorService f365d;

        /* renamed from: e, reason: collision with root package name */
        public final m2.b f366e;

        /* renamed from: f, reason: collision with root package name */
        public final SocketFactory f367f;

        /* renamed from: g, reason: collision with root package name */
        public final SSLSocketFactory f368g;

        /* renamed from: h, reason: collision with root package name */
        public final HostnameVerifier f369h;

        /* renamed from: i, reason: collision with root package name */
        public final b9.b f370i;

        /* renamed from: j, reason: collision with root package name */
        public final int f371j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f372k;

        /* renamed from: l, reason: collision with root package name */
        public final long f373l;

        /* renamed from: m, reason: collision with root package name */
        public final z8.h f374m;

        /* renamed from: n, reason: collision with root package name */
        public final long f375n;

        /* renamed from: o, reason: collision with root package name */
        public final int f376o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f377p;

        /* renamed from: q, reason: collision with root package name */
        public final int f378q;

        /* renamed from: r, reason: collision with root package name */
        public final boolean f379r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f380s;

        /* renamed from: a9.f$f$a */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h.b f381a;

            public a(h.b bVar) {
                this.f381a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f381a.a();
            }
        }

        public /* synthetic */ C0007f(o1 o1Var, o1 o1Var2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, b9.b bVar, int i10, boolean z10, long j10, long j11, int i11, boolean z11, int i12, m2.b bVar2, boolean z12, a aVar) {
            this(o1Var, o1Var2, socketFactory, sSLSocketFactory, hostnameVerifier, bVar, i10, z10, j10, j11, i11, z11, i12, bVar2, z12);
        }

        @Override // z8.t
        public v J(SocketAddress socketAddress, t.a aVar, y8.f fVar) {
            if (this.f380s) {
                throw new IllegalStateException("The transport factory is closed.");
            }
            h.b d10 = this.f374m.d();
            i iVar = new i(this, (InetSocketAddress) socketAddress, aVar.a(), aVar.d(), aVar.b(), aVar.c(), new a(d10));
            if (this.f372k) {
                iVar.T(true, d10.b(), this.f375n, this.f377p);
            }
            return iVar;
        }

        @Override // z8.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f380s) {
                return;
            }
            this.f380s = true;
            this.f362a.b(this.f363b);
            this.f364c.b(this.f365d);
        }

        @Override // z8.t
        public ScheduledExecutorService p() {
            return this.f365d;
        }

        public C0007f(o1 o1Var, o1 o1Var2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, b9.b bVar, int i10, boolean z10, long j10, long j11, int i11, boolean z11, int i12, m2.b bVar2, boolean z12) {
            this.f362a = o1Var;
            this.f363b = (Executor) o1Var.a();
            this.f364c = o1Var2;
            this.f365d = (ScheduledExecutorService) o1Var2.a();
            this.f367f = socketFactory;
            this.f368g = sSLSocketFactory;
            this.f369h = hostnameVerifier;
            this.f370i = bVar;
            this.f371j = i10;
            this.f372k = z10;
            this.f373l = j10;
            this.f374m = new z8.h("keepalive time nanos", j10);
            this.f375n = j11;
            this.f376o = i11;
            this.f377p = z11;
            this.f378q = i12;
            this.f379r = z12;
            this.f366e = (m2.b) Preconditions.checkNotNull(bVar2, "transportTracerFactory");
        }
    }

    static {
        a aVar = new a();
        f336u = aVar;
        f337v = e2.c(aVar);
        f338w = EnumSet.of(q1.MTLS, q1.CUSTOM_MANAGERS);
    }

    public f(String str) {
        a aVar = null;
        this.f339b = new g1(str, new e(this, aVar), new d(this, aVar));
    }

    public static f f(String str) {
        return new f(str);
    }

    @Override // z8.b
    public s0 c() {
        return this.f339b;
    }

    public C0007f d() {
        return new C0007f(this.f341d, this.f342e, this.f343f, e(), this.f346i, this.f347j, this.f20295a, this.f349l != Long.MAX_VALUE, this.f349l, this.f350m, this.f351n, this.f352o, this.f353p, this.f340c, false, null);
    }

    public SSLSocketFactory e() {
        int i10 = b.f356b[this.f348k.ordinal()];
        if (i10 == 1) {
            return null;
        }
        if (i10 != 2) {
            throw new RuntimeException("Unknown negotiation type: " + this.f348k);
        }
        try {
            if (this.f344g == null) {
                this.f344g = SSLContext.getInstance(UPushNotificationChannel.DEFAULT_NOTIFICATION_CHANNEL_NAME, b9.h.e().g()).getSocketFactory();
            }
            return this.f344g;
        } catch (GeneralSecurityException e10) {
            throw new RuntimeException("TLS Provider failure", e10);
        }
    }

    public int g() {
        int i10 = b.f356b[this.f348k.ordinal()];
        if (i10 == 1) {
            return 80;
        }
        if (i10 == 2) {
            return Constants.PORT;
        }
        throw new AssertionError(this.f348k + " not handled");
    }
}
